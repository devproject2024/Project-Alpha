package net.one97.paytm.wallet.newdesign.nearby.helper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.location.Location;
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
import com.google.android.gms.location.g;
import com.google.android.gms.location.i;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.text.DateFormat;
import java.util.Date;
import kotlin.u;
import net.one97.paytm.common.utility.k;

public final class b {

    /* renamed from: g  reason: collision with root package name */
    public static final a f71116g = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public boolean f71117a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71118b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71119c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71120d;

    /* renamed from: e  reason: collision with root package name */
    public AppCompatActivity f71121e;

    /* renamed from: f  reason: collision with root package name */
    public k f71122f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f71123h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final String f71124i = "Location Utility";
    private final long j = 10000;
    private final long k = (this.j / 2);
    private final String l = "requesting-location-updates";
    private final String m = "location";
    private final String n = "last-updated-time-string";
    /* access modifiers changed from: private */
    public com.google.android.gms.location.b o;
    private i p;
    private LocationRequest q;
    private LocationSettingsRequest r;
    /* access modifiers changed from: private */
    public com.google.android.gms.location.d s;
    /* access modifiers changed from: private */
    public Location t;
    /* access modifiers changed from: private */
    public String u;
    private Object v;

    public b(AppCompatActivity appCompatActivity, k kVar, Bundle bundle) {
        kotlin.g.b.k.c(appCompatActivity, "activity");
        kotlin.g.b.k.c(kVar, "callbacks");
        this.f71121e = appCompatActivity;
        this.f71122f = kVar;
        com.google.android.gms.location.b b2 = f.b((Activity) this.f71121e);
        kotlin.g.b.k.a((Object) b2, "LocationServices.getFuse…nProviderClient(activity)");
        this.o = b2;
        i a2 = f.a((Activity) this.f71121e);
        kotlin.g.b.k.a((Object) a2, "LocationServices.getSettingsClient(activity)");
        this.p = a2;
        this.f71117a = true;
        if (bundle != null) {
            if (bundle.keySet().contains(this.l)) {
                this.f71117a = bundle.getBoolean(this.l);
            }
            if (bundle.keySet().contains(this.m)) {
                this.t = (Location) bundle.getParcelable(this.m);
            }
            if (bundle.keySet().contains(this.n)) {
                this.u = bundle.getString(this.n);
            }
        }
        this.s = new C1442b(this);
        this.q = new LocationRequest();
        LocationRequest locationRequest = this.q;
        if (locationRequest == null) {
            kotlin.g.b.k.a("mLocationRequest");
        }
        locationRequest.a(this.j);
        LocationRequest locationRequest2 = this.q;
        if (locationRequest2 == null) {
            kotlin.g.b.k.a("mLocationRequest");
        }
        locationRequest2.b(this.k);
        LocationRequest locationRequest3 = this.q;
        if (locationRequest3 == null) {
            kotlin.g.b.k.a("mLocationRequest");
        }
        locationRequest3.a(100);
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        LocationRequest locationRequest4 = this.q;
        if (locationRequest4 == null) {
            kotlin.g.b.k.a("mLocationRequest");
        }
        aVar.a(locationRequest4);
        this.r = aVar.b();
    }

    public static final /* synthetic */ LocationRequest d(b bVar) {
        LocationRequest locationRequest = bVar.q;
        if (locationRequest == null) {
            kotlin.g.b.k.a("mLocationRequest");
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

    /* renamed from: net.one97.paytm.wallet.newdesign.nearby.helper.b$b  reason: collision with other inner class name */
    public static final class C1442b extends com.google.android.gms.location.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71125a;

        C1442b(b bVar) {
            this.f71125a = bVar;
        }

        public final void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            this.f71125a.f71122f.a(locationResult);
            b bVar = this.f71125a;
            if (locationResult == null) {
                kotlin.g.b.k.a();
            }
            bVar.t = locationResult.a();
            this.f71125a.u = DateFormat.getTimeInstance().format(new Date());
        }
    }

    public final boolean a() {
        return Settings.Secure.getInt(this.f71121e.getContentResolver(), "location_mode") != 0;
    }

    public final boolean b() {
        this.f71120d = androidx.core.app.a.a((Context) this.f71121e, "android.permission.ACCESS_FINE_LOCATION") == 0;
        return this.f71120d;
    }

    public final void c() {
        androidx.core.app.a.a(this.f71121e, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 34);
    }

    public final void d() {
        if (this.f71117a) {
            this.o.a(this.s);
            try {
                Object obj = this.v;
                if (obj != null) {
                    AppCompatActivity appCompatActivity = this.f71121e;
                    if (obj != null) {
                        appCompatActivity.unregisterReceiver((BroadcastReceiver) obj);
                    } else {
                        throw new u("null cannot be cast to non-null type android.content.BroadcastReceiver");
                    }
                }
                this.f71123h = false;
            } catch (Exception unused) {
            }
        }
    }

    public final void e() {
        this.p.a(this.r).a((Activity) this.f71121e, new c(this)).a((Activity) this.f71121e, (OnFailureListener) new d(this));
    }

    static final class d implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71127a;

        d(b bVar) {
            this.f71127a = bVar;
        }

        public final void onFailure(Exception exc) {
            kotlin.g.b.k.c(exc, "it");
            int statusCode = ((ApiException) exc).getStatusCode();
            if (statusCode == 6) {
                String unused = this.f71127a.f71124i;
                try {
                    ((j) exc).startResolutionForResult(this.f71127a.f71121e, 1);
                } catch (IntentSender.SendIntentException unused2) {
                    String unused3 = this.f71127a.f71124i;
                }
            } else if (statusCode == 8502) {
                String unused4 = this.f71127a.f71124i;
                this.f71127a.f71122f.b();
                this.f71127a.f71117a = false;
            }
        }
    }

    public final void f() {
        if (!this.f71123h) {
            this.f71121e.registerReceiver(g(), new IntentFilter("android.location.PROVIDERS_CHANGED"));
            this.f71123h = true;
        }
    }

    private final BroadcastReceiver g() {
        if (this.v == null) {
            this.v = new NearByLocationUtility$getGpsReceiver$1(this);
        }
        Object obj = this.v;
        if (obj != null) {
            return (BroadcastReceiver) obj;
        }
        throw new u("null cannot be cast to non-null type android.content.BroadcastReceiver");
    }

    static final class c<TResult> implements OnSuccessListener<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71126a;

        c(b bVar) {
            this.f71126a = bVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String unused = this.f71126a.f71124i;
            this.f71126a.o.a(b.d(this.f71126a), this.f71126a.s, Looper.myLooper());
            this.f71126a.f71122f.e();
        }
    }
}
