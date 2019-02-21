package com.example.android.walkmyandroid;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0011\u0010\fR\"\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u0018\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/android/walkmyandroid/LocationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TAG", "", "address", "Landroidx/lifecycle/MutableLiveData;", "getAddress", "()Landroidx/lifecycle/MutableLiveData;", "setAddress", "(Landroidx/lifecycle/MutableLiveData;)V", "geocoder", "Landroid/location/Geocoder;", "isTrackingLocation", "", "setTrackingLocation", "lastLocation", "Landroid/location/Location;", "getLastLocation", "setLastLocation", "locationManager", "Ljava/lang/ref/WeakReference;", "Lcom/example/android/walkmyandroid/LocationViewModel$MyLocationManager;", "initLocationManager", "", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "toggleTracking", "MyLocationManager", "app_debug"})
public final class LocationViewModel extends androidx.lifecycle.AndroidViewModel {
    private final java.lang.String TAG = "LocationViewModel";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<android.location.Location> lastLocation;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> address;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTrackingLocation;
    private java.lang.ref.WeakReference<com.example.android.walkmyandroid.LocationViewModel.MyLocationManager> locationManager;
    private final android.location.Geocoder geocoder = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<android.location.Location> getLastLocation() {
        return null;
    }
    
    public final void setLastLocation(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<android.location.Location> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTrackingLocation() {
        return null;
    }
    
    public final void setTrackingLocation(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final void initLocationManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Lifecycle lifecycle) {
    }
    
    public final void toggleTracking() {
    }
    
    public LocationViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/example/android/walkmyandroid/LocationViewModel$MyLocationManager;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lcom/example/android/walkmyandroid/LocationViewModel;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "locationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setLocationClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "getLocationRequest", "()Lcom/google/android/gms/location/LocationRequest;", "removeLocationUpdates", "", "requestLocationUpdates", "app_debug"})
    public final class MyLocationManager implements androidx.lifecycle.LifecycleObserver {
        @org.jetbrains.annotations.NotNull()
        private com.google.android.gms.location.FusedLocationProviderClient locationClient;
        private final com.google.android.gms.location.LocationCallback locationCallback = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.lifecycle.Lifecycle lifecycle = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.android.gms.location.FusedLocationProviderClient getLocationClient() {
            return null;
        }
        
        public final void setLocationClient(@org.jetbrains.annotations.NotNull()
        com.google.android.gms.location.FusedLocationProviderClient p0) {
        }
        
        private final com.google.android.gms.location.LocationRequest getLocationRequest() {
            return null;
        }
        
        @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_RESUME)
        public final void requestLocationUpdates() {
        }
        
        @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_PAUSE)
        public final void removeLocationUpdates() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.Lifecycle getLifecycle() {
            return null;
        }
        
        public MyLocationManager(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        androidx.lifecycle.Lifecycle lifecycle) {
            super();
        }
    }
}