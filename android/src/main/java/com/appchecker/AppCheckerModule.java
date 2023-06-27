package com.appchecker;
import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import androidx.core.content.pm.PackageInfoCompat;

import android.content.Context;
import android.content.pm.PackageManager;

@ReactModule(name = AppCheckerModule.NAME)
public class AppCheckerModule extends ReactContextBaseJavaModule {
  public static final String NAME = "AppChecker";
  Context ctx;
  public AppCheckerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.ctx = reactContext.getApplicationContext();
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void isPackageInstalled(String packageName, Promise promise) {
    PackageManager pm = this.ctx.getPackageManager();
    try {
      pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
      promise.resolve(true);
    } catch (Exception e) {
      promise.resolve(false);
    }
  }
}
