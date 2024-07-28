package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.m;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class u extends ad {

    /* renamed from: a  reason: collision with root package name */
    boolean f17040a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.google.android.gms.location.d f17041d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.google.android.gms.location.b f17042e;

    static final class b<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f17044a;

        b(u uVar) {
            this.f17044a = uVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Location location = (Location) obj;
            if (location != null) {
                this.f17044a.f17042e = null;
                this.f17044a.f17041d = null;
                this.f17044a.a("lat", (Object) Double.valueOf(location.getLatitude()));
                this.f17044a.a("long", (Object) Double.valueOf(location.getLongitude()));
                this.f17044a.a((Object) null);
                return;
            }
            this.f17044a.f17041d = new com.google.android.gms.location.d(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f17045a;

                {
                    this.f17045a = r1;
                }

                public final void onLocationResult(LocationResult locationResult) {
                    com.google.android.gms.location.b a2;
                    if (locationResult != null) {
                        if (!(this.f17045a.f17044a.f17042e == null || this.f17045a.f17044a.f17041d == null || (a2 = this.f17045a.f17044a.f17042e) == null)) {
                            a2.a(this.f17045a.f17044a.f17041d);
                        }
                        this.f17045a.f17044a.f17042e = null;
                        this.f17045a.f17044a.f17041d = null;
                        u uVar = this.f17045a.f17044a;
                        Location a3 = locationResult.a();
                        k.a((Object) a3, "lr.lastLocation");
                        uVar.a("lat", (Object) Double.valueOf(a3.getLatitude()));
                        u uVar2 = this.f17045a.f17044a;
                        Location a4 = locationResult.a();
                        k.a((Object) a4, "lr.lastLocation");
                        uVar2.a("long", (Object) Double.valueOf(a4.getLongitude()));
                        this.f17045a.f17044a.a((Object) null);
                        return;
                    }
                    this.f17045a.f17044a.a(H5Event.Error.UNKNOWN_ERROR, "Error");
                }
            };
            LocationRequest a2 = LocationRequest.a();
            a2.b(1000);
            a2.a(1000);
            a2.a(100);
            a2.c();
            com.google.android.gms.location.b a3 = this.f17044a.f17042e;
            if (a3 != null) {
                a3.a(a2, this.f17044a.f17041d, (Looper) null);
            }
        }
    }

    public u() {
        super("paytmGetLocation");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action;
        super.handleEvent(h5Event, h5BridgeContext);
        if (!a(h5Event)) {
            return true;
        }
        if (h5Event == null) {
            k.a();
        }
        Object systemService = h5Event.getActivity().getSystemService("location");
        if (systemService != null) {
            if (!((LocationManager) systemService).isProviderEnabled("gps")) {
                Activity activity = h5Event.getActivity();
                k.a((Object) activity, "event.activity");
                com.google.android.gms.common.api.e a2 = new e.a(activity).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) f.f11372a).a();
                a2.d();
                LocationRequest a3 = LocationRequest.a();
                k.a((Object) a3, "locationRequest");
                a3.a(100);
                a3.a(10000);
                a3.b(5000);
                LocationSettingsRequest.a a4 = new LocationSettingsRequest.a().a(a3);
                a4.a();
                f.f11375d.a(a2, a4.b()).a(new a(activity));
            } else {
                c(h5Event);
            }
            Activity activity2 = h5Event.getActivity();
            if (activity2 == null || !(activity2 instanceof PaytmH5Activity)) {
                return true;
            }
            if (h5Event != null && (action = h5Event.getAction()) != null && action.hashCode() == 677282122 && action.equals("paytmGetLocation")) {
                PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity2;
                paytmH5Activity.j.deleteObservers();
                paytmH5Activity.j.addObserver(new c(activity2, this, h5Event, h5BridgeContext));
            }
            PaytmH5Activity paytmH5Activity2 = (PaytmH5Activity) activity2;
            paytmH5Activity2.l.deleteObservers();
            paytmH5Activity2.l.addObserver(new d(this, h5Event, h5BridgeContext));
            return true;
        }
        throw new kotlin.u("null cannot be cast to non-null type android.location.LocationManager");
    }

    static final class c implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17046a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f17047b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f17048c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f17049d;

        c(Activity activity, u uVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f17046a = activity;
            this.f17047b = uVar;
            this.f17048c = h5Event;
            this.f17049d = h5BridgeContext;
        }

        public final void update(Observable observable, Object obj) {
            if (k.a(obj, (Object) Boolean.FALSE)) {
                this.f17047b.a(H5Event.Error.UNKNOWN_ERROR, "Error");
            } else {
                this.f17047b.c(this.f17048c);
            }
        }
    }

    static final class d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f17050a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f17051b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5BridgeContext f17052c;

        d(u uVar, H5Event h5Event, H5BridgeContext h5BridgeContext) {
            this.f17050a = uVar;
            this.f17051b = h5Event;
            this.f17052c = h5BridgeContext;
        }

        public final void update(Observable observable, Object obj) {
            com.google.android.gms.location.b a2;
            if (this.f17050a.f17042e != null && this.f17050a.f17041d != null && (a2 = this.f17050a.f17042e) != null) {
                a2.a(this.f17050a.f17041d);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c(H5Event h5Event) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        for (String a2 : arrayList) {
            if (androidx.core.content.b.a(h5Event.getActivity(), a2) == 0) {
                this.f17040a = true;
            }
        }
        if (this.f17040a) {
            Activity activity = h5Event.getActivity();
            k.a((Object) activity, "event.activity");
            a(activity);
            return;
        }
        Activity activity2 = h5Event.getActivity();
        if (activity2 != null) {
            PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity2;
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                a(paytmH5Activity, (String[]) array);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
    }

    /* access modifiers changed from: private */
    public final void a(Activity activity) {
        Task<Location> a2;
        this.f17042e = f.b(activity);
        com.google.android.gms.location.b bVar = this.f17042e;
        if (bVar != null && (a2 = bVar.a()) != null) {
            a2.a((OnSuccessListener<? super Location>) new b(this));
        }
    }

    public static final class a implements m<LocationSettingsResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17043a;

        a(Activity activity) {
            this.f17043a = activity;
        }

        public final /* synthetic */ void onResult(l lVar) {
            LocationSettingsResult locationSettingsResult = (LocationSettingsResult) lVar;
            k.c(locationSettingsResult, "result");
            Status a2 = locationSettingsResult.a();
            k.a((Object) a2, "result.status");
            int d2 = a2.d();
            if (d2 == 0) {
                com.alipay.iap.android.common.b.c.c();
            } else if (d2 == 6) {
                com.alipay.iap.android.common.b.c.c();
                try {
                    a2.a(this.f17043a, 1);
                } catch (IntentSender.SendIntentException unused) {
                    com.alipay.iap.android.common.b.c.c();
                }
            } else if (d2 == 8502) {
                com.alipay.iap.android.common.b.c.c();
            }
        }
    }

    private final void a(PaytmH5Activity paytmH5Activity, String[] strArr) {
        this.f17040a = false;
        paytmH5Activity.f17103a.addObserver(new e(this, paytmH5Activity));
        paytmH5Activity.a(strArr);
    }

    static final class e implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f17053a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmH5Activity f17054b;

        e(u uVar, PaytmH5Activity paytmH5Activity) {
            this.f17053a = uVar;
            this.f17054b = paytmH5Activity;
        }

        public final void update(Observable observable, Object obj) {
            u uVar = this.f17053a;
            if (obj instanceof o) {
                o oVar = (o) obj;
                Object first = oVar.getFirst();
                if (first != null) {
                    Object[] objArr = (Object[]) first;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        int length = objArr.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            int i4 = i3 + 1;
                            if (iArr[i3] != 0) {
                                uVar.a(H5Event.Error.UNKNOWN_ERROR, "Error");
                            } else if (!uVar.f17040a) {
                                uVar.f17040a = true;
                                uVar.a((Activity) this.f17054b);
                            }
                            i2++;
                            i3 = i4;
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type kotlin.Array<*>");
                }
            } else {
                uVar.a(H5Event.Error.UNKNOWN_ERROR, "Error");
            }
            this.f17054b.f17103a.deleteObservers();
        }
    }
}
