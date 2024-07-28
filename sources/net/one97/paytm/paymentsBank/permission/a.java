package net.one97.paytm.paymentsBank.permission;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.f;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.payments.d.b;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.BankTabActivity;
import net.one97.paytm.paymentsBank.fragment.g;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0321a f18753b = new C0321a((byte) 0);
    /* access modifiers changed from: private */
    public static String j = "location_fragment";

    /* renamed from: a  reason: collision with root package name */
    public Context f18754a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f18755c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.gms.location.b f18756d;

    /* renamed from: e  reason: collision with root package name */
    private LocationRequest f18757e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.google.android.gms.location.d f18758f;

    /* renamed from: g  reason: collision with root package name */
    private final long f18759g;

    /* renamed from: h  reason: collision with root package name */
    private final long f18760h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f18761i;

    static final class e<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18766a;

        e(a aVar) {
            this.f18766a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Location location = (Location) obj;
            if (location != null) {
                a.a(this.f18766a, String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
                return;
            }
            a.a(this.f18766a);
        }
    }

    public /* synthetic */ a(Context context) {
        this(context, Boolean.FALSE);
    }

    private a(Context context, Boolean bool) {
        this.f18754a = context;
        this.f18761i = bool;
        this.f18755c = "Location Utility";
        this.f18759g = 5000;
        this.f18760h = this.f18759g / 2;
        Context context2 = this.f18754a;
        if (context2 != null) {
            com.google.android.gms.location.b b2 = f.b(context2);
            k.a((Object) b2, "LocationServices.getFuse…nProviderClient(mContext)");
            this.f18756d = b2;
            this.f18757e = new LocationRequest();
            LocationRequest locationRequest = this.f18757e;
            if (locationRequest == null) {
                k.a("mLocationRequest");
            }
            locationRequest.a(this.f18759g);
            LocationRequest locationRequest2 = this.f18757e;
            if (locationRequest2 == null) {
                k.a("mLocationRequest");
            }
            locationRequest2.b(this.f18760h);
            LocationRequest locationRequest3 = this.f18757e;
            if (locationRequest3 == null) {
                k.a("mLocationRequest");
            }
            locationRequest3.a(100);
            this.f18758f = new d(this);
        }
    }

    public static final /* synthetic */ com.google.android.gms.location.b b(a aVar) {
        com.google.android.gms.location.b bVar = aVar.f18756d;
        if (bVar == null) {
            k.a("mFusedLocationClient");
        }
        return bVar;
    }

    /* renamed from: net.one97.paytm.paymentsBank.permission.a$a  reason: collision with other inner class name */
    public static final class C0321a {
        private C0321a() {
        }

        public /* synthetic */ C0321a(byte b2) {
            this();
        }
    }

    public final void a() {
        Task<Location> a2;
        Context context = this.f18754a;
        if (context == null) {
            return;
        }
        if (androidx.core.content.b.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.content.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            com.google.android.gms.location.b bVar = this.f18756d;
            if (bVar == null) {
                k.a("mFusedLocationClient");
            }
            if (bVar != null && (a2 = bVar.a()) != null) {
                a2.a((OnSuccessListener<? super Location>) new e(this));
                return;
            }
            return;
        }
        Boolean bool = this.f18761i;
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
        final /* synthetic */ a f18765a;

        d(a aVar) {
            this.f18765a = aVar;
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
                    a.b(this.f18765a).a(this.f18765a.f18758f);
                    a.a(this.f18765a, valueOf, valueOf2);
                    return;
                }
            }
            Context context = this.f18765a.f18754a;
            this.f18765a.a(context != null ? context.getString(R.string.loc_retrieve_error) : null);
        }
    }

    static final class c implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f18763a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f18764b;

        c(Context context, a aVar) {
            this.f18763a = context;
            this.f18764b = aVar;
        }

        public final void onFailure(Exception exc) {
            k.c(exc, "it");
            int statusCode = ((ApiException) exc).getStatusCode();
            if (statusCode == 6) {
                String unused = this.f18764b.f18755c;
                try {
                    j jVar = (j) exc;
                    Context context = this.f18763a;
                    if (context != null) {
                        jVar.startResolutionForResult((Activity) context, 1);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                } catch (IntentSender.SendIntentException unused2) {
                    String unused3 = this.f18764b.f18755c;
                    String string = this.f18763a.getString(R.string.loc_settings_inadequate);
                    String unused4 = this.f18764b.f18755c;
                    this.f18764b.a(string);
                }
            } else if (statusCode == 8502) {
                String string2 = this.f18763a.getString(R.string.loc_settings_inadequate);
                String unused5 = this.f18764b.f18755c;
                this.f18764b.a(string2);
            }
        }
    }

    public final void a(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            Toast.makeText(this.f18754a, charSequence, 0).show();
        }
        Context context = this.f18754a;
        if (context != null) {
            androidx.fragment.app.j supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            Fragment c2 = supportFragmentManager != null ? supportFragmentManager.c(j) : null;
            if (c2 == null) {
                k.a();
            }
            if (c2 != null && (c2 instanceof g)) {
                ((g) c2).a(true);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    static final class b<TResult> implements OnSuccessListener<com.google.android.gms.location.g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18762a;

        b(a aVar) {
            this.f18762a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            a.d(this.f18762a);
        }
    }

    public static final /* synthetic */ void a(a aVar, String str, String str2) {
        b.a aVar2 = net.one97.paytm.payments.d.b.f17268a;
        Context context = aVar.f18754a;
        if (context == null) {
            k.a();
        }
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context!!.applicationContext");
        com.paytm.b.a.a a2 = b.a.a(applicationContext);
        if (a2 != null) {
            if (!TextUtils.isEmpty(str) && str != null) {
                a2.a("pref_key_latitude", str, true);
            }
            if (!TextUtils.isEmpty(str2) && str2 != null) {
                a2.a("pref_key_longitude", str2, true);
            }
            Context context2 = aVar.f18754a;
            if (!(context2 instanceof BankTabActivity)) {
                context2 = null;
            }
            BankTabActivity bankTabActivity = (BankTabActivity) context2;
            if (bankTabActivity != null) {
                bankTabActivity.V_();
            }
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        Context context = aVar.f18754a;
        if (context != null) {
            LocationSettingsRequest.a aVar2 = new LocationSettingsRequest.a();
            LocationRequest locationRequest = aVar.f18757e;
            if (locationRequest == null) {
                k.a("mLocationRequest");
            }
            Task<com.google.android.gms.location.g> a2 = f.a(context).a(aVar2.a(locationRequest).b());
            k.a((Object) a2, "client.checkLocationSettings(builder.build())");
            a2.a((OnSuccessListener<? super com.google.android.gms.location.g>) new b(aVar));
            a2.a((OnFailureListener) new c(context, aVar));
        }
    }

    public static final /* synthetic */ void d(a aVar) {
        Context context = aVar.f18754a;
        if (context != null) {
            androidx.fragment.app.j jVar = null;
            if (androidx.core.content.b.a(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                Boolean bool = aVar.f18761i;
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
                com.google.android.gms.location.b bVar = aVar.f18756d;
                if (bVar == null) {
                    k.a("mFusedLocationClient");
                }
                LocationRequest locationRequest = aVar.f18757e;
                if (locationRequest == null) {
                    k.a("mLocationRequest");
                }
                bVar.a(locationRequest, aVar.f18758f, (Looper) null);
            }
        }
    }
}
