package net.one97.paytm.bankCommon.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.d.c;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f16313b = new a((byte) 0);
    /* access modifiers changed from: private */
    public static String j = "location_fragment";

    /* renamed from: a  reason: collision with root package name */
    public Context f16314a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f16315c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.gms.location.b f16316d;

    /* renamed from: e  reason: collision with root package name */
    private LocationRequest f16317e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.google.android.gms.location.d f16318f;

    /* renamed from: g  reason: collision with root package name */
    private final long f16319g;

    /* renamed from: h  reason: collision with root package name */
    private final long f16320h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f16321i;

    static final class e<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16326a;

        e(b bVar) {
            this.f16326a = bVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Location location = (Location) obj;
            if (location != null) {
                b.a(this.f16326a, String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
                return;
            }
            b.a(this.f16326a);
        }
    }

    public /* synthetic */ b(Context context) {
        this(context, Boolean.FALSE);
    }

    private b(Context context, Boolean bool) {
        this.f16314a = context;
        this.f16321i = bool;
        this.f16315c = "Location Utility";
        this.f16319g = 5000;
        this.f16320h = this.f16319g / 2;
        Context context2 = this.f16314a;
        if (context2 != null) {
            com.google.android.gms.location.b b2 = f.b(context2);
            k.a((Object) b2, "LocationServices.getFuse…nProviderClient(mContext)");
            this.f16316d = b2;
            this.f16317e = new LocationRequest();
            LocationRequest locationRequest = this.f16317e;
            if (locationRequest == null) {
                k.a("mLocationRequest");
            }
            locationRequest.a(this.f16319g);
            LocationRequest locationRequest2 = this.f16317e;
            if (locationRequest2 == null) {
                k.a("mLocationRequest");
            }
            locationRequest2.b(this.f16320h);
            LocationRequest locationRequest3 = this.f16317e;
            if (locationRequest3 == null) {
                k.a("mLocationRequest");
            }
            locationRequest3.a(100);
            this.f16318f = new d(this);
        }
    }

    public static final /* synthetic */ com.google.android.gms.location.b b(b bVar) {
        com.google.android.gms.location.b bVar2 = bVar.f16316d;
        if (bVar2 == null) {
            k.a("mFusedLocationClient");
        }
        return bVar2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a() {
        Task<Location> a2;
        Context context = this.f16314a;
        if (context == null) {
            return;
        }
        if (androidx.core.content.b.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.content.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            com.google.android.gms.location.b bVar = this.f16316d;
            if (bVar == null) {
                k.a("mFusedLocationClient");
            }
            if (bVar != null && (a2 = bVar.a()) != null) {
                a2.a((OnSuccessListener<? super Location>) new e(this));
                return;
            }
            return;
        }
        Boolean bool = this.f16321i;
        if (bool == null) {
            k.a();
        }
        if (bool.booleanValue()) {
            if (context != null) {
                androidx.core.app.a.a((Activity) context, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        } else if (context != null) {
            Fragment c2 = ((AppCompatActivity) context).getSupportFragmentManager().c(j);
            if (c2 == null) {
                k.a();
            }
            c2.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1);
        } else {
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    public static final class d extends com.google.android.gms.location.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16325a;

        d(b bVar) {
            this.f16325a = bVar;
        }

        public final void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            if (locationResult != null) {
                Collection b2 = locationResult.b();
                if (!(b2 == null || b2.isEmpty())) {
                    Location location = locationResult.b().get(locationResult.b().size() - 1);
                    k.a((Object) location, "locationResult.locations…esult.locations.size - 1]");
                    String valueOf = String.valueOf(location.getLatitude());
                    Location location2 = locationResult.b().get(locationResult.b().size() - 1);
                    k.a((Object) location2, "locationResult.locations…esult.locations.size - 1]");
                    String valueOf2 = String.valueOf(location2.getLongitude());
                    b.b(this.f16325a).a(this.f16325a.f16318f);
                    b.a(this.f16325a, valueOf, valueOf2);
                    return;
                }
            }
            Context context = this.f16325a.f16314a;
            this.f16325a.a(context != null ? context.getString(R.string.loc_retrieve_error) : null);
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        Context context = this.f16314a;
        if (context != null) {
            j jVar = null;
            if (androidx.core.content.b.a(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                Boolean bool = this.f16321i;
                if (bool == null) {
                    k.a();
                }
                if (bool.booleanValue()) {
                    if (context != null) {
                        androidx.core.app.a.a((Activity) context, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                } else if (context != null) {
                    AppCompatActivity appCompatActivity = (AppCompatActivity) context;
                    if (appCompatActivity != null) {
                        jVar = appCompatActivity.getSupportFragmentManager();
                    }
                    Fragment c2 = jVar.c(j);
                    if (c2 == null) {
                        k.a();
                    }
                    c2.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
                } else {
                    throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                }
            } else {
                com.google.android.gms.location.b bVar = this.f16316d;
                if (bVar == null) {
                    k.a("mFusedLocationClient");
                }
                LocationRequest locationRequest = this.f16317e;
                if (locationRequest == null) {
                    k.a("mLocationRequest");
                }
                bVar.a(locationRequest, this.f16318f, (Looper) null);
            }
        }
    }

    static final class c implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f16323a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f16324b;

        c(Context context, b bVar) {
            this.f16323a = context;
            this.f16324b = bVar;
        }

        public final void onFailure(Exception exc) {
            k.c(exc, "it");
            int statusCode = ((ApiException) exc).getStatusCode();
            if (statusCode == 6) {
                String unused = this.f16324b.f16315c;
                try {
                    com.google.android.gms.common.api.j jVar = (com.google.android.gms.common.api.j) exc;
                    Context context = this.f16323a;
                    if (context != null) {
                        jVar.startResolutionForResult((Activity) context, 1);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                } catch (IntentSender.SendIntentException unused2) {
                    String unused3 = this.f16324b.f16315c;
                    String string = this.f16323a.getString(R.string.loc_settings_inadequate);
                    String unused4 = this.f16324b.f16315c;
                    this.f16324b.a(string);
                }
            } else if (statusCode == 8502) {
                String string2 = this.f16323a.getString(R.string.loc_settings_inadequate);
                String unused5 = this.f16324b.f16315c;
                this.f16324b.a(string2);
            }
        }
    }

    public final void a(int i2) {
        if (i2 == -1) {
            c();
            return;
        }
        Context context = this.f16314a;
        a(context != null ? context.getString(R.string.loc_enable_settings) : null);
    }

    public final void a(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            Toast.makeText(this.f16314a, charSequence, 0).show();
        }
        Context context = this.f16314a;
        if (context != null) {
            j supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c(j) : null;
            if (c2 == null) {
                k.a();
            }
            if (c2 != null && (c2 instanceof net.one97.paytm.bankCommon.location.a)) {
                ((net.one97.paytm.bankCommon.location.a) c2).a(true);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    /* renamed from: net.one97.paytm.bankCommon.utils.b$b  reason: collision with other inner class name */
    static final class C0227b<TResult> implements OnSuccessListener<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16322a;

        C0227b(b bVar) {
            this.f16322a = bVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            this.f16322a.c();
        }
    }

    public static final /* synthetic */ void a(b bVar, String str, String str2) {
        com.paytm.b.a.a aVar;
        Context applicationContext;
        Context context = bVar.f16314a;
        if (context != null) {
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                c.a aVar2 = net.one97.paytm.bankOpen.d.c.f16425a;
                aVar = c.a.a(applicationContext);
            }
            if (aVar != null) {
                if (!TextUtils.isEmpty(str) && str != null) {
                    aVar.a("pref_key_latitude", str, true);
                }
                if (!TextUtils.isEmpty(str2) && str2 != null) {
                    aVar.a("pref_key_longitude", str2, true);
                }
                Context context2 = bVar.f16314a;
                if (context2 instanceof net.one97.paytm.bankCommon.location.b) {
                    if (!(context2 instanceof net.one97.paytm.bankCommon.location.b)) {
                        context2 = null;
                    }
                    net.one97.paytm.bankCommon.location.b bVar2 = (net.one97.paytm.bankCommon.location.b) context2;
                    if (bVar2 != null) {
                        bVar2.V_();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        Context context = bVar.f16314a;
        if (context != null) {
            LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
            LocationRequest locationRequest = bVar.f16317e;
            if (locationRequest == null) {
                k.a("mLocationRequest");
            }
            Task<g> a2 = f.a(context).a(aVar.a(locationRequest).b());
            k.a((Object) a2, "client.checkLocationSettings(builder.build())");
            a2.a((OnSuccessListener<? super g>) new C0227b(bVar));
            a2.a((OnFailureListener) new c(context, bVar));
        }
    }
}
