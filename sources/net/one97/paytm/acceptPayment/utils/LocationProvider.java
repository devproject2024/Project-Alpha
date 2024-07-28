package net.one97.paytm.acceptPayment.utils;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.location.i;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final class LocationProvider implements p {

    /* renamed from: a  reason: collision with root package name */
    public com.google.android.gms.location.b f52150a;

    /* renamed from: b  reason: collision with root package name */
    public com.google.android.gms.location.d f52151b;

    /* renamed from: c  reason: collision with root package name */
    public final a f52152c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.acceptPayment.c.a f52153d;

    /* renamed from: e  reason: collision with root package name */
    private Location f52154e;

    /* renamed from: f  reason: collision with root package name */
    private LocationSettingsRequest.a f52155f;

    /* renamed from: g  reason: collision with root package name */
    private LocationRequest f52156g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f52157h = true;

    /* renamed from: i  reason: collision with root package name */
    private LocationManager f52158i;
    private final Activity j;
    private final k k;

    public interface a {
        void a(Location location);

        void a(j jVar);

        boolean a();

        void b();
    }

    @aa(a = k.a.ON_START)
    public final void start() {
    }

    public LocationProvider(Activity activity, a aVar, k kVar) {
        kotlin.g.b.k.d(activity, "activity");
        kotlin.g.b.k.d(aVar, "mListener");
        kotlin.g.b.k.d(kVar, "lifecycle");
        this.j = activity;
        this.f52152c = aVar;
        this.k = kVar;
        kVar.a(this);
        Object systemService = this.j.getSystemService("location");
        if (systemService != null) {
            this.f52158i = (LocationManager) systemService;
            LocationRequest a2 = LocationRequest.a();
            a2.a(10000);
            a2.b(5000);
            a2.a(100);
            this.f52156g = a2;
            this.f52155f = new LocationSettingsRequest.a().a(a2);
            this.f52150a = f.b(this.j);
            this.f52151b = new d(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    public final void a() {
        i a2 = f.a(this.j);
        LocationSettingsRequest.a aVar = this.f52155f;
        Task<g> a3 = a2.a(aVar != null ? aVar.b() : null);
        kotlin.g.b.k.b(a3, "client.checkLocationSettings(builder?.build())");
        a3.a(this.j, (OnSuccessListener<? super g>) new b(this));
        a3.a(this.j, (OnFailureListener) new c(this));
    }

    static final class c implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LocationProvider f52160a;

        c(LocationProvider locationProvider) {
            this.f52160a = locationProvider;
        }

        public final void onFailure(Exception exc) {
            kotlin.g.b.k.d(exc, "e");
            if (exc instanceof j) {
                this.f52160a.f52152c.a((j) exc);
            }
        }
    }

    public static final class d extends com.google.android.gms.location.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LocationProvider f52161a;

        d(LocationProvider locationProvider) {
            this.f52161a = locationProvider;
        }

        public final void onLocationResult(LocationResult locationResult) {
            LocationProvider.a(this.f52161a, locationResult);
        }
    }

    @aa(a = k.a.ON_STOP)
    public final void stop() {
        com.google.android.gms.location.b bVar;
        if (this.f52157h && (bVar = this.f52150a) != null) {
            bVar.a(this.f52151b);
        }
    }

    @aa(a = k.a.ON_DESTROY)
    public final void destroy() {
        this.k.b(this);
    }

    public final void b() {
        com.google.android.gms.location.b bVar;
        this.f52157h = true;
        if (this.k.a().isAtLeast(k.b.STARTED) && this.f52152c.a() && (bVar = this.f52150a) != null) {
            bVar.a(this.f52156g, this.f52151b, (Looper) null);
        }
    }

    static final class b<TResult> implements OnSuccessListener<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LocationProvider f52159a;

        b(LocationProvider locationProvider) {
            this.f52159a = locationProvider;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            this.f52159a.b();
        }
    }

    public static final /* synthetic */ void a(LocationProvider locationProvider, LocationResult locationResult) {
        if (locationResult != null) {
            List<Location> b2 = locationResult.b();
            kotlin.g.b.k.b(b2, "it.locations");
            if (!b2.isEmpty()) {
                locationProvider.f52154e = locationResult.b().get(0);
                a aVar = locationProvider.f52152c;
                Location location = locationResult.b().get(0);
                kotlin.g.b.k.b(location, "it.locations[0]");
                aVar.a(location);
                if (locationProvider.f52153d != null) {
                    kotlin.g.b.k.b(locationResult.b().get(0), "it.locations[0]");
                }
            }
        }
    }
}
