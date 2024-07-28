package net.one97.paytm.oauth.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.d;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.location.i;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.oauth.fragment.ay;

public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56769c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public com.google.android.gms.location.b f56770a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.oauth.e.c f56771b;

    /* renamed from: d  reason: collision with root package name */
    private final long f56772d = TimeUnit.MINUTES.toMillis(10);

    /* renamed from: e  reason: collision with root package name */
    private LocationRequest f56773e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f56774f;

    /* renamed from: g  reason: collision with root package name */
    private final d f56775g;

    static final class c<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f56777a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f56778b;

        c(j jVar, Activity activity) {
            this.f56777a = jVar;
            this.f56778b = activity;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Location location = (Location) obj;
            if (location != null) {
                net.one97.paytm.oauth.e.c a2 = this.f56777a.f56771b;
                if (a2 != null) {
                    a2.a(location.getLatitude(), location.getLongitude(), System.currentTimeMillis() - this.f56777a.f56774f);
                    return;
                }
                return;
            }
            LocationSettingsRequest.a a3 = new LocationSettingsRequest.a().a(this.f56777a.a()).a();
            i a4 = f.a(this.f56778b);
            k.a((Object) a4, "LocationServices.getSettingsClient(activity)");
            Task<g> a5 = a4.a(a3.b());
            a5.a((OnSuccessListener<? super g>) new OnSuccessListener<g>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f56779a;

                {
                    this.f56779a = r1;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    j.d(this.f56779a.f56777a);
                }
            });
            a5.a((OnFailureListener) new OnFailureListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f56780a;

                {
                    this.f56780a = r1;
                }

                public final void onFailure(Exception exc) {
                    k.c(exc, "exception");
                    if (exc instanceof com.google.android.gms.common.api.j) {
                        try {
                            ((com.google.android.gms.common.api.j) exc).startResolutionForResult(this.f56780a.f56778b, 101);
                            net.one97.paytm.oauth.e.c a2 = this.f56780a.f56777a.f56771b;
                            if (a2 != null) {
                                a2.c();
                            }
                        } catch (IntentSender.SendIntentException unused) {
                        }
                    }
                }
            });
        }
    }

    public j(net.one97.paytm.oauth.e.c cVar) {
        k.c(cVar, "listener");
        this.f56771b = cVar;
        this.f56775g = new b(this);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final LocationRequest a() {
        if (this.f56773e == null) {
            LocationRequest a2 = LocationRequest.a();
            a2.a(this.f56772d);
            a2.b(this.f56772d);
            a2.a(100);
            k.a((Object) a2, "LocationRequest.create()…GH_ACCURACY\n            }");
            this.f56773e = a2;
        }
        LocationRequest locationRequest = this.f56773e;
        if (locationRequest == null) {
            k.a("locationRequest");
        }
        return locationRequest;
    }

    public final void a(Activity activity) {
        k.c(activity, "activity");
        ay ayVar = ay.f56391a;
        if (ay.a((Context) activity)) {
            this.f56774f = System.currentTimeMillis();
            new StringBuilder("Start time:-").append(this.f56774f);
            com.google.android.gms.location.b bVar = this.f56770a;
            if (bVar == null) {
                k.a("fusedLocationClient");
            }
            bVar.a().a(new c(this, activity));
        }
    }

    public final void b() {
        if (this.f56770a != null) {
            com.google.android.gms.location.b bVar = this.f56770a;
            if (bVar == null) {
                k.a("fusedLocationClient");
            }
            bVar.a(this.f56775g);
        }
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f56776a;

        b(j jVar) {
            this.f56776a = jVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001d, code lost:
            r2 = r12.a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onLocationResult(com.google.android.gms.location.LocationResult r12) {
            /*
                r11 = this;
                net.one97.paytm.oauth.utils.j r0 = r11.f56776a
                r0.b()
                long r0 = java.lang.System.currentTimeMillis()
                net.one97.paytm.oauth.utils.j r2 = r11.f56776a
                long r2 = r2.f56774f
                long r9 = r0 - r2
                net.one97.paytm.oauth.utils.j r0 = r11.f56776a
                net.one97.paytm.oauth.e.c r4 = r0.f56771b
                if (r4 == 0) goto L_0x003a
                r0 = 0
                if (r12 == 0) goto L_0x0029
                android.location.Location r2 = r12.a()
                if (r2 == 0) goto L_0x0029
                double r2 = r2.getLatitude()
                r5 = r2
                goto L_0x002a
            L_0x0029:
                r5 = r0
            L_0x002a:
                if (r12 == 0) goto L_0x0036
                android.location.Location r12 = r12.a()
                if (r12 == 0) goto L_0x0036
                double r0 = r12.getLongitude()
            L_0x0036:
                r7 = r0
                r4.a(r5, r7, r9)
            L_0x003a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.utils.j.b.onLocationResult(com.google.android.gms.location.LocationResult):void");
        }
    }

    public static final /* synthetic */ void d(j jVar) {
        if (jVar.f56770a != null) {
            com.google.android.gms.location.b bVar = jVar.f56770a;
            if (bVar == null) {
                k.a("fusedLocationClient");
            }
            bVar.a(jVar.a(), jVar.f56775g, Looper.getMainLooper());
        }
    }
}
