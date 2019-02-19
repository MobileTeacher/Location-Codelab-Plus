package com.example.android.walkmyandroid

import android.app.Application
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.IOException
import java.lang.IllegalArgumentException
import java.util.*
import android.text.TextUtils



fun Address.joinToString(): String{
    val addressParts = mutableListOf<String>()
    // Fetch the address lines using getAddressLine,
    // join them, and send them to the thread
    for (i in 0..maxAddressLineIndex) {
        addressParts.add(getAddressLine(i))
    }
    return addressParts.joinToString()
}


class LocationViewModel(application: Application): AndroidViewModel(application) {

    private val TAG = "LocationViewModel"

    var locationClient: FusedLocationProviderClient = LocationServices
                                    .getFusedLocationProviderClient(application.applicationContext)

    var lastLocation: MutableLiveData<Location?> = MutableLiveData()
    var address: MutableLiveData<String> = MutableLiveData()
    private val geocoder = Geocoder(application.applicationContext, Locale.getDefault())

    init {
        lastLocation.observeForever{ location->
            location?.let {
                DoAsync{
                    try {
                        val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)?.get(0)

                        addresses?.let { address.postValue(it.joinToString()) } ?: run {
                            address.postValue(application.getString(R.string.no_address_found))
                        }
                    } catch (exception: IOException){
                        address.postValue(application.getString(R.string.service_not_available))
                        Log.e(TAG, address.value, exception)
                    } catch (exception: IllegalArgumentException){
                        address.postValue(application.getString(R.string.invalid_location))
                        Log.e(TAG, address.value, exception)
                    }
                }
            }

        }
    }

    fun getLocation(){
        locationClient.lastLocation.addOnSuccessListener {location: Location?->
                lastLocation.value = location

        }
    }

    internal class DoAsync(val action: ()-> Unit): AsyncTask<Unit, Unit, Unit>(){
        init {
            execute()
        }

        override fun doInBackground(vararg p0: Unit?) {
            action()
        }
    }

}