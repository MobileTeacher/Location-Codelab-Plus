package com.example.android.walkmyandroid

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.util.Log
import java.io.IOException
import java.lang.IllegalArgumentException
import java.util.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import com.google.android.gms.location.*
import java.lang.ref.WeakReference


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


    var lastLocation: MutableLiveData<Location?> = MutableLiveData()
    var address: MutableLiveData<String> = MutableLiveData()
    var isTrackingLocation = MutableLiveData<Boolean>().apply { value = false }
    private lateinit var locationManager: WeakReference<MyLocationManager>


    private val geocoder = Geocoder(application.applicationContext, Locale.getDefault())

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

    fun initLocationManager(context: Context, lifecycle: Lifecycle){
        locationManager = WeakReference(MyLocationManager(context, lifecycle))
    }


    fun toggleTracking(){
        isTrackingLocation.value = isTrackingLocation.value?.not()
    }


    inner class MyLocationManager(context: Context, val lifecycle: Lifecycle): LifecycleObserver {
        var locationClient: FusedLocationProviderClient = LocationServices
                .getFusedLocationProviderClient(context)

        init {
            lifecycle.addObserver(this)
        }

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

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun requestLocationUpdates(){
            if (ContextCompat.checkSelfPermission(getApplication(), MainActivity.LOCATION_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED){
                locationClient.requestLocationUpdates(locationRequest, locationCallback, null)
                Log.d(TAG, "Attached location updates")
            }

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun removeLocationUpdates(){
            locationClient.removeLocationUpdates(locationCallback)
            Log.d(TAG, "Dettach location updates")
        }
    }

}