package net.one97.paytm.hotel4.utils.location;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.q;
import com.paytm.utility.s;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.u;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f28651a;

    /* renamed from: b  reason: collision with root package name */
    public int f28652b = 100;

    /* renamed from: c  reason: collision with root package name */
    public long f28653c = 1000;

    /* renamed from: d  reason: collision with root package name */
    public long f28654d = 250;

    /* renamed from: e  reason: collision with root package name */
    public LocationRequest f28655e;

    /* renamed from: f  reason: collision with root package name */
    public LocationSettingsRequest f28656f;

    /* renamed from: g  reason: collision with root package name */
    public com.google.android.gms.location.b f28657g;

    /* renamed from: h  reason: collision with root package name */
    public b f28658h;

    /* renamed from: i  reason: collision with root package name */
    public C0500a f28659i;
    final g j = new g(this);
    public final Context k;
    public final Activity l;

    /* renamed from: net.one97.paytm.hotel4.utils.location.a$a  reason: collision with other inner class name */
    public interface C0500a {
        void a(List<Address> list);
    }

    public interface b {
        void a(Location location);
    }

    public static final class c<TResult> implements OnSuccessListener<com.google.android.gms.location.g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28660a;

        public c(a aVar) {
            this.f28660a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (((com.google.android.gms.location.g) obj) != null) {
                this.f28660a.a();
            }
        }
    }

    static final class f<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28665a;

        f(a aVar) {
            this.f28665a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Location location = (Location) obj;
            if (location != null) {
                b bVar = this.f28665a.f28658h;
                if (bVar != null) {
                    bVar.a(location);
                    return;
                }
                return;
            }
            this.f28665a.b();
        }
    }

    public a(Context context, Activity activity) {
        k.c(context, "mContext");
        k.c(activity, "mActivity");
        this.k = context;
        this.l = activity;
    }

    public static final class d implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28661a;

        public d(a aVar) {
            this.f28661a = aVar;
        }

        public final void onFailure(Exception exc) {
            k.c(exc, "exception");
            if (((ApiException) exc).getStatusCode() == 6) {
                try {
                    ((j) exc).startResolutionForResult(this.f28661a.l, 115);
                } catch (IntentSender.SendIntentException | ClassCastException unused) {
                }
            }
        }
    }

    public final void a() {
        boolean z;
        Task<Location> a2;
        Context context = this.k;
        k.c(context, "context");
        Object systemService = context.getSystemService("location");
        if (systemService != null) {
            LocationManager locationManager = (LocationManager) systemService;
            boolean z2 = false;
            if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled(ContactsConstant.NETWORK)) {
                Activity activity = this.l;
                k.c(activity, "activity");
                if (!s.a() || s.e((Context) activity)) {
                    z = true;
                } else {
                    s.d(activity);
                    z = false;
                }
                if (z) {
                    Context context2 = this.k;
                    k.c(context2, "context");
                    if (androidx.core.app.a.a(context2, "android.permission.ACCESS_FINE_LOCATION") == 0 && androidx.core.app.a.a(context2, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        return;
                    }
                    if (this.f28651a) {
                        b();
                        return;
                    }
                    com.google.android.gms.location.b bVar = this.f28657g;
                    if (bVar != null && (a2 = bVar.a()) != null) {
                        a2.a((OnSuccessListener<? super Location>) new f(this));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.location.LocationManager");
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Location f28663b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f28664c = 1;

        public e(a aVar, Location location) {
            this.f28662a = aVar;
            this.f28663b = location;
        }

        public final void run() {
            C0500a aVar;
            try {
                List<Address> fromLocation = new Geocoder(this.f28662a.k, Locale.ENGLISH).getFromLocation(this.f28663b.getLatitude(), this.f28663b.getLongitude(), this.f28664c);
                if (fromLocation != null && (aVar = this.f28662a.f28659i) != null) {
                    aVar.a(fromLocation);
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    public static final class g extends com.google.android.gms.location.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28666a;

        g(a aVar) {
            this.f28666a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
            r0 = r2.f28666a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onLocationResult(com.google.android.gms.location.LocationResult r3) {
            /*
                r2 = this;
                if (r3 != 0) goto L_0x0003
                return
            L_0x0003:
                android.location.Location r3 = r3.a()
                if (r3 == 0) goto L_0x0025
                net.one97.paytm.hotel4.utils.location.a r0 = r2.f28666a
                boolean r0 = r0.f28651a
                if (r0 != 0) goto L_0x001c
                net.one97.paytm.hotel4.utils.location.a r0 = r2.f28666a
                com.google.android.gms.location.b r1 = r0.f28657g
                if (r1 == 0) goto L_0x001c
                net.one97.paytm.hotel4.utils.location.a$g r0 = r0.j
                com.google.android.gms.location.d r0 = (com.google.android.gms.location.d) r0
                r1.a(r0)
            L_0x001c:
                net.one97.paytm.hotel4.utils.location.a r0 = r2.f28666a
                net.one97.paytm.hotel4.utils.location.a$b r0 = r0.f28658h
                if (r0 == 0) goto L_0x0025
                r0.a(r3)
            L_0x0025:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.utils.location.a.g.onLocationResult(com.google.android.gms.location.LocationResult):void");
        }
    }

    public final void b() {
        com.google.android.gms.location.b bVar = this.f28657g;
        if (bVar != null) {
            bVar.a(this.f28655e, this.j, Looper.myLooper());
        }
    }
}
