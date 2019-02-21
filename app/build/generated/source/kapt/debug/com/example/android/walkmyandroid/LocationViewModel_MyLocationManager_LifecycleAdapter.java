package com.example.android.walkmyandroid;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
import java.lang.Override;

public class LocationViewModel_MyLocationManager_LifecycleAdapter implements GeneratedAdapter {
  final LocationViewModel.MyLocationManager mReceiver;

  LocationViewModel_MyLocationManager_LifecycleAdapter(LocationViewModel.MyLocationManager receiver) {
    this.mReceiver = receiver;
  }

  @Override
  public void callMethods(LifecycleOwner owner, Lifecycle.Event event, boolean onAny,
      MethodCallsLogger logger) {
    boolean hasLogger = logger != null;
    if (onAny) {
      return;
    }
    if (event == Lifecycle.Event.ON_RESUME) {
      if (!hasLogger || logger.approveCall("requestLocationUpdates", 1)) {
        mReceiver.requestLocationUpdates();
      }
      return;
    }
    if (event == Lifecycle.Event.ON_PAUSE) {
      if (!hasLogger || logger.approveCall("removeLocationUpdates", 1)) {
        mReceiver.removeLocationUpdates();
      }
      return;
    }
  }
}
