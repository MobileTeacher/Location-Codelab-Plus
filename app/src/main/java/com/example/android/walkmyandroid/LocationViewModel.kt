package com.example.android.walkmyandroid

import android.app.Application
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.IOException
import java.lang.IllegalArgumentException
import java.util.*
import android.text.TextUtils
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*


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
    var isTrackingLocation: MutableLiveData<Boolean> = MutableLiveData()


    init {
        isTrackingLocation.value = false
    }


    private val geocoder = Geocoder(application.applicationContext, Locale.getDefault())


    private val locationRequest: LocationRequest
    get() {
        val value = LocationRequest()
        value.interval = 10000
        value.fastestInterval = 5000
        value.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        return value
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            isTrackingLocation.value?.let {
                if (it){
                    lastLocation.value = locationResult?.locations?.get(0)
                }
            }
        }
    }

    init {
        lastLocation.observeForever{ location->
            location?.let {
                DoAsync{
                    try {
                        val results = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                        if (results.isNotEmpty()){
                            val addresses = results[0]
                            addresses?.let { address.postValue(it.joinToString()) } ?: run {
                                address.postValue(application.getString(R.string.no_address_found))
                            }
                        } else {
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

    fun requestLocationUpdates(request:LocationRequest = locationRequest,
                               callback: LocationCallback = locationCallback){
        if (ContextCompat.checkSelfPermission(getApplication(), MainActivity.LOCATION_PERMISSION)
                == PackageManager.PERMISSION_GRANTED){
            locationClient.requestLocationUpdates(request, callback, null)
            Log.d(TAG, "Attached location updates")
        }

    }

    fun removeLocationUpdates(callback:LocationCallback = locationCallback){
        locationClient.removeLocationUpdates(callback)
        Log.d(TAG, "Dettach location updates")
    }

    fun toggleTracking(){
        isTrackingLocation.value = isTrackingLocation.value?.not()
    }

    fun getLocation(){
        if (ContextCompat.checkSelfPermission(getApplication(), MainActivity.LOCATION_PERMISSION)
                == PackageManager.PERMISSION_GRANTED){
            locationClient.lastLocation.addOnSuccessListener { location: Location? ->
                lastLocation.value = location
            }
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