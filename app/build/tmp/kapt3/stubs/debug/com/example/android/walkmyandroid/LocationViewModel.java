package com.example.android.walkmyandroid;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020\u0017J\u001a\u0010&\u001a\u00020#2\b\b\u0002\u0010\'\u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0011\u0010\fR\"\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/example/android/walkmyandroid/LocationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TAG", "", "address", "Landroidx/lifecycle/MutableLiveData;", "getAddress", "()Landroidx/lifecycle/MutableLiveData;", "setAddress", "(Landroidx/lifecycle/MutableLiveData;)V", "geocoder", "Landroid/location/Geocoder;", "isTrackingLocation", "", "setTrackingLocation", "lastLocation", "Landroid/location/Location;", "getLastLocation", "setLastLocation", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "locationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setLocationClient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "getLocationRequest", "()Lcom/google/android/gms/location/LocationRequest;", "getLocation", "", "removeLocationUpdates", "callback", "requestLocationUpdates", "request", "toggleTracking", "DoAsync", "app_debug"})
public final class LocationViewModel extends androidx.lifecycle.AndroidViewModel {
    private final java.lang.String TAG = "LocationViewModel";
    @org.jetbrains.annotations.NotNull()
    private com.google.android.gms.location.FusedLocationProviderClient locationClient;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<android.location.Location> lastLocation;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> address;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isTrackingLocation;
    private final android.location.Geocoder geocoder = null;
    private final com.google.android.gms.location.LocationCallback locationCallback = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.FusedLocationProviderClient getLocationClient() {
        return null;
    }
    
    public final void setLocationClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
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
    
    private final com.google.android.gms.location.LocationRequest getLocationRequest() {
        return null;
    }
    
    public final void requestLocationUpdates(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.LocationRequest request, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.LocationCallback callback) {
    }
    
    public final void removeLocationUpdates(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.LocationCallback callback) {
    }
    
    public final void toggleTracking() {
    }
    
    public final void getLocation() {
    }
    
    public LocationViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J%\u0010\b\u001a\u00020\u00022\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\n\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/android/walkmyandroid/LocationViewModel$DoAsync;", "Landroid/os/AsyncTask;", "", "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "doInBackground", "p0", "", "([Lkotlin/Unit;)V", "app_debug"})
    public static final class DoAsync extends android.os.AsyncTask<kotlin.Unit, kotlin.Unit, kotlin.Unit> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function0<kotlin.Unit> action = null;
        
        @java.lang.Override()
        protected void doInBackground(@org.jetbrains.annotations.NotNull()
        kotlin.Unit... p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function0<kotlin.Unit> getAction() {
            return null;
        }
        
        public DoAsync(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> action) {
            super();
        }
    }
}