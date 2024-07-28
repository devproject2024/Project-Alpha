package net.one97.paytm.common.utility;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.f;
import com.google.android.gms.location.i;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.text.DateFormat;
import java.util.Date;
import kotlin.g.b.k;
import kotlin.u;

public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final a f49606c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    AppCompatActivity f49607a;

    /* renamed from: b  reason: collision with root package name */
    h f49608b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49609d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f49610e = "Location Utility";

    /* renamed from: f  reason: collision with root package name */
    private final long f49611f = 5000;

    /* renamed from: g  reason: collision with root package name */
    private final long f49612g = (this.f49611f / 2);

    /* renamed from: h  reason: collision with root package name */
    private final String f49613h = "requesting-location-updates";

    /* renamed from: i  reason: collision with root package name */
    private final String f49614i = "location";
    private final String j = "last-updated-time-string";
    /* access modifiers changed from: private */
    public com.google.android.gms.location.b k;
    private i l;
    private LocationRequest m;
    private LocationSettingsRequest n;
    /* access modifiers changed from: private */
    public com.google.android.gms.location.d o;
    /* access modifiers changed from: private */
    public Location p;
    /* access modifiers changed from: private */
    public boolean q;
    private boolean r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public boolean u;
    private Object v;

    public g(AppCompatActivity appCompatActivity, h hVar, Bundle bundle) {
        k.c(appCompatActivity, "activity");
        k.c(hVar, "callbacksKyc");
        this.f49607a = appCompatActivity;
        this.f49608b = hVar;
        com.google.android.gms.location.b b2 = f.b((Activity) this.f49607a);
        k.a((Object) b2, "LocationServices.getFuse…nProviderClient(activity)");
        this.k = b2;
        i a2 = f.a((Activity) this.f49607a);
        k.a((Object) a2, "LocationServices.getSettingsClient(activity)");
        this.l = a2;
        this.q = true;
        if (bundle != null) {
            if (bundle.keySet().contains(this.f49613h)) {
                this.q = bundle.getBoolean(this.f49613h);
            }
            if (bundle.keySet().contains(this.f49614i)) {
                this.p = (Location) bundle.getParcelable(this.f49614i);
            }
            if (bundle.keySet().contains(this.j)) {
                this.t = bundle.getString(this.j);
            }
        }
        this.o = new b(this);
        this.m = new LocationRequest();
        LocationRequest locationRequest = this.m;
        if (locationRequest == null) {
            k.a("mLocationRequest");
        }
        locationRequest.a(this.f49611f);
        LocationRequest locationRequest2 = this.m;
        if (locationRequest2 == null) {
            k.a("mLocationRequest");
        }
        locationRequest2.b(this.f49612g);
        LocationRequest locationRequest3 = this.m;
        if (locationRequest3 == null) {
            k.a("mLocationRequest");
        }
        locationRequest3.a(100);
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        LocationRequest locationRequest4 = this.m;
        if (locationRequest4 == null) {
            k.a("mLocationRequest");
        }
        aVar.a(locationRequest4);
        this.n = aVar.b();
    }

    public static final /* synthetic */ LocationRequest d(g gVar) {
        LocationRequest locationRequest = gVar.m;
        if (locationRequest == null) {
            k.a("mLocationRequest");
        }
        return locationRequest;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b extends com.google.android.gms.location.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49615a;

        b(g gVar) {
            this.f49615a = gVar;
        }

        public final void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            this.f49615a.f49608b.a(locationResult);
            g gVar = this.f49615a;
            if (locationResult == null) {
                k.a();
            }
            gVar.p = locationResult.a();
            this.f49615a.t = DateFormat.getTimeInstance().format(new Date());
        }
    }

    public final void a() {
        if (this.q) {
            d();
            this.q = false;
        }
    }

    /* access modifiers changed from: private */
    public final boolean g() {
        return Settings.Secure.getInt(this.f49607a.getContentResolver(), "location_mode") != 0;
    }

    public final void b() {
        if (!this.q) {
            return;
        }
        if (!this.s || g()) {
            if (h()) {
                i();
            } else if (!h()) {
                if (androidx.core.app.a.a((Activity) this.f49607a, "android.permission.ACCESS_FINE_LOCATION")) {
                    this.f49608b.aE_();
                } else if (this.r) {
                    this.f49608b.aF_();
                } else {
                    c();
                }
            }
            this.s = false;
            return;
        }
        j();
        this.f49608b.aG_();
    }

    private final boolean h() {
        this.u = androidx.core.app.a.a((Context) this.f49607a, "android.permission.ACCESS_FINE_LOCATION") == 0;
        return this.u;
    }

    public final void c() {
        androidx.core.app.a.a(this.f49607a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 34);
    }

    public final void d() {
        if (this.q) {
            this.k.a(this.o);
            try {
                Object obj = this.v;
                if (obj != null) {
                    AppCompatActivity appCompatActivity = this.f49607a;
                    if (obj != null) {
                        appCompatActivity.unregisterReceiver((BroadcastReceiver) obj);
                    } else {
                        throw new u("null cannot be cast to non-null type android.content.BroadcastReceiver");
                    }
                }
                this.f49609d = false;
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void i() {
        this.l.a(this.n).a((Activity) this.f49607a, new c(this)).a((Activity) this.f49607a, (OnFailureListener) new d(this));
    }

    static final class d implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49617a;

        d(g gVar) {
            this.f49617a = gVar;
        }

        public final void onFailure(Exception exc) {
            k.c(exc, "it");
            int statusCode = ((ApiException) exc).getStatusCode();
            if (statusCode == 6) {
                String unused = this.f49617a.f49610e;
                try {
                    ((j) exc).startResolutionForResult(this.f49617a.f49607a, 1);
                } catch (IntentSender.SendIntentException unused2) {
                    String unused3 = this.f49617a.f49610e;
                }
            } else if (statusCode == 8502) {
                String unused4 = this.f49617a.f49610e;
                this.f49617a.f49608b.a("Location settings are inadequate, and cannot be fixed here. Fix in Settings.");
                this.f49617a.q = false;
            }
        }
    }

    public final void a(int i2, int i3) {
        if (i2 == 1) {
            if (i3 == -1) {
                i();
            } else if (i3 == 0) {
                j();
                this.s = true;
            }
        }
    }

    private final void j() {
        if (!this.f49609d) {
            this.f49607a.registerReceiver(k(), new IntentFilter("android.location.PROVIDERS_CHANGED"));
            this.f49609d = true;
        }
    }

    private final BroadcastReceiver k() {
        if (this.v == null) {
            this.v = new KycLocationUtility$getGpsReceiver$1(this);
        }
        Object obj = this.v;
        if (obj != null) {
            return (BroadcastReceiver) obj;
        }
        throw new u("null cannot be cast to non-null type android.content.BroadcastReceiver");
    }

    public final void a(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        if (i2 == 34) {
            if (iArr.length == 0) {
                return;
            }
            if (iArr[0] == 0) {
                this.r = false;
                this.q = true;
                this.u = true;
                i();
            } else if (androidx.core.app.a.a((Activity) this.f49607a, "android.permission.ACCESS_FINE_LOCATION")) {
                this.f49608b.aE_();
            } else {
                this.r = true;
            }
        }
    }

    public final void a(Bundle bundle) {
        k.c(bundle, "savedInstanceState");
        bundle.putBoolean(this.f49613h, this.q);
        bundle.putParcelable(this.f49614i, this.p);
        bundle.putString(this.j, this.t);
    }

    public final void e() {
        this.s = true;
        this.f49607a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    public final void f() {
        AppCompatActivity appCompatActivity = this.f49607a;
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f49607a.getPackageName(), (String) null));
        appCompatActivity.startActivity(intent);
    }

    static final class c<TResult> implements OnSuccessListener<com.google.android.gms.location.g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49616a;

        c(g gVar) {
            this.f49616a = gVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String unused = this.f49616a.f49610e;
            this.f49616a.k.a(g.d(this.f49616a), this.f49616a.o, Looper.myLooper());
            this.f49616a.f49608b.d();
        }
    }
}
