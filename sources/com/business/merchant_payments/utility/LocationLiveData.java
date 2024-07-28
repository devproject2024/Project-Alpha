package com.business.merchant_payments.utility;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.d;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;
import retrofit2.Response;

public class LocationLiveData extends y<b<Location>> {
    public static final long INTERVAL = TimeUnit.MINUTES.toMillis(10);
    public d locationCallback;
    public LocationRequest locationRequest;
    public Context mContext;
    public com.google.android.gms.location.b mFusedLocationClient;

    public LocationLiveData(Context context) {
        this.mContext = context;
        init();
    }

    public void init() {
        if (AppUtility.isGooglePlayServicesAvailable(this.mContext) == 0 && AppUtility.hasGPSDevice(this.mContext)) {
            this.mFusedLocationClient = f.b(this.mContext);
        }
        initLocationRequest();
        initLocationSettings();
        setValue(b.a());
    }

    private void initLocationRequest() {
        LocationRequest a2 = LocationRequest.a();
        this.locationRequest = a2;
        a2.a(100);
        this.locationRequest.a(INTERVAL);
        this.locationRequest.b(INTERVAL);
    }

    private void initLocationCallback() {
        this.locationCallback = new d() {
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult != null && !locationResult.f11350b.isEmpty()) {
                    LocationLiveData.this.onLocationChanged(locationResult.f11350b.get(0));
                    LocationLiveData.this.mFusedLocationClient.a(LocationLiveData.this.locationCallback);
                    LocationRequest unused = LocationLiveData.this.locationRequest = null;
                }
            }
        };
    }

    private void initLocationSettings() {
        if (this.locationRequest != null) {
            LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
            aVar.a(this.locationRequest);
            Task<g> a2 = f.a(this.mContext).a(aVar.b());
            if (!(Build.VERSION.SDK_INT >= 23) || androidx.core.content.b.a(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                initLocationCallback();
                a2.a((OnFailureListener) new OnFailureListener() {
                    public final void onFailure(Exception exc) {
                        LocationLiveData.this.lambda$initLocationSettings$0$LocationLiveData(exc);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$initLocationSettings$0$LocationLiveData(Exception exc) {
        setValue(b.a((Response<?>) null));
        if (exc instanceof j) {
            try {
                ((j) exc).startResolutionForResult((Activity) this.mContext, AppConstants.REQUEST_CODE_FOR_SYSTEM.LOCATION_SETTINGS_DIALOG);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public void onActive() {
        d dVar;
        LocationRequest locationRequest2;
        com.google.android.gms.location.b bVar = this.mFusedLocationClient;
        if (bVar != null && (dVar = this.locationCallback) != null && (locationRequest2 = this.locationRequest) != null) {
            bVar.a(locationRequest2, dVar, Looper.myLooper());
        }
    }

    public void onInactive() {
        try {
            if (this.mFusedLocationClient != null) {
                this.mFusedLocationClient.a(this.locationCallback);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            setValue(b.a(location));
        }
    }
}
