package net.one97.paytm.feed.utility;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.location.i;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.g.b.k;

public final class q {

    /* renamed from: b  reason: collision with root package name */
    public static final a f35420b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final o f35421a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f35422c = "LocationUtil";

    /* renamed from: d  reason: collision with root package name */
    private LocationSettingsRequest f35423d;

    /* renamed from: e  reason: collision with root package name */
    private i f35424e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.gms.location.b f35425f;

    /* renamed from: g  reason: collision with root package name */
    private LocationRequest f35426g;

    /* renamed from: h  reason: collision with root package name */
    private com.google.android.gms.location.d f35427h;

    /* renamed from: i  reason: collision with root package name */
    private final FragmentActivity f35428i;
    private final Fragment j;

    static final class d implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f35431a = new d();

        d() {
        }

        public final /* synthetic */ void onFailure(Exception exc) {
            k.c(exc, "exception");
        }
    }

    public q(FragmentActivity fragmentActivity, Fragment fragment, o oVar) {
        k.c(fragmentActivity, "mContext");
        k.c(fragment, "fragment");
        k.c(oVar, "mListener");
        this.f35428i = fragmentActivity;
        this.j = fragment;
        this.f35421a = oVar;
        com.google.android.gms.location.b b2 = f.b((Activity) this.f35428i);
        k.a((Object) b2, "LocationServices.getFuse…nProviderClient(mContext)");
        this.f35425f = b2;
        this.f35427h = new b(this);
        this.f35426g = new LocationRequest();
        LocationRequest locationRequest = this.f35426g;
        if (locationRequest == null) {
            k.a("mLocationRequest");
        }
        locationRequest.a(10000);
        LocationRequest locationRequest2 = this.f35426g;
        if (locationRequest2 == null) {
            k.a("mLocationRequest");
        }
        locationRequest2.b(5000);
        LocationRequest locationRequest3 = this.f35426g;
        if (locationRequest3 == null) {
            k.a("mLocationRequest");
        }
        locationRequest3.a(100);
        i a2 = f.a((Activity) this.f35428i);
        k.a((Object) a2, "LocationServices.getSettingsClient(mContext)");
        this.f35424e = a2;
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        LocationRequest locationRequest4 = this.f35426g;
        if (locationRequest4 == null) {
            k.a("mLocationRequest");
        }
        aVar.a(locationRequest4);
        LocationSettingsRequest b3 = aVar.b();
        k.a((Object) b3, "builder.build()");
        this.f35423d = b3;
        if (a.a(this.f35428i)) {
            a();
        } else {
            this.j.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 15724);
        }
    }

    public static final /* synthetic */ com.google.android.gms.location.b a(q qVar) {
        com.google.android.gms.location.b bVar = qVar.f35425f;
        if (bVar == null) {
            k.a("mFusedLocationClient");
        }
        return bVar;
    }

    public static final /* synthetic */ com.google.android.gms.location.d b(q qVar) {
        com.google.android.gms.location.d dVar = qVar.f35427h;
        if (dVar == null) {
            k.a("mLocationCallback");
        }
        return dVar;
    }

    public static final /* synthetic */ LocationRequest d(q qVar) {
        LocationRequest locationRequest = qVar.f35426g;
        if (locationRequest == null) {
            k.a("mLocationRequest");
        }
        return locationRequest;
    }

    public static final class b extends com.google.android.gms.location.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f35429a;

        b(q qVar) {
            this.f35429a = qVar;
        }

        public final void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            if (locationResult != null) {
                this.f35429a.f35421a.a(locationResult);
                q.a(this.f35429a).a(q.b(this.f35429a));
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean a(Context context) {
            k.c(context, "context");
            return androidx.core.app.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
        }
    }

    public final void a() {
        i iVar = this.f35424e;
        if (iVar == null) {
            k.a("mSettingsClient");
        }
        LocationSettingsRequest locationSettingsRequest = this.f35423d;
        if (locationSettingsRequest == null) {
            k.a("mLocationSettingsRequest");
        }
        iVar.a(locationSettingsRequest).a((Activity) this.f35428i, new c(this)).a((Activity) this.f35428i, (OnFailureListener) d.f35431a);
    }

    static final class c<TResult> implements OnSuccessListener<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f35430a;

        c(q qVar) {
            this.f35430a = qVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            String unused = this.f35430a.f35422c;
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            q.a(this.f35430a).a(q.d(this.f35430a), q.b(this.f35430a), Looper.myLooper());
        }
    }
}
