package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.m;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;

public final class an extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    com.google.android.gms.location.d f59503a;

    /* renamed from: b  reason: collision with root package name */
    com.google.android.gms.location.b f59504b;

    /* renamed from: c  reason: collision with root package name */
    boolean f59505c;

    static final class a<R extends l> implements m<LocationSettingsResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f59506a;

        a(Activity activity) {
            this.f59506a = activity;
        }

        public final /* synthetic */ void onResult(l lVar) {
            LocationSettingsResult locationSettingsResult = (LocationSettingsResult) lVar;
            k.c(locationSettingsResult, "result");
            Status status = locationSettingsResult.f11359a;
            k.a((Object) status, "result.status");
            int i2 = status.f8360g;
            if (i2 == 0) {
                j jVar = j.f59646a;
                j.a("PaytmH5Locationplugin", "All location settings are satisfied.");
            } else if (i2 == 6) {
                j jVar2 = j.f59646a;
                j.a("PaytmH5Locationplugin", "Location settings are not satisfied. Show the user a dialog to upgrade location settings ");
                try {
                    status.a(this.f59506a, 1);
                } catch (IntentSender.SendIntentException unused) {
                    j jVar3 = j.f59646a;
                    j.a("PaytmH5Locationplugin", "PendingIntent unable to execute request.");
                }
            } else if (i2 == 8502) {
                j jVar4 = j.f59646a;
                j.a("PaytmH5Locationplugin", "Location settings are inadequate, and cannot be fixed here. Dialog not created.");
            }
        }
    }

    static final class b<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ an f59507a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59508b;

        b(an anVar, H5Event h5Event) {
            this.f59507a = anVar;
            this.f59508b = h5Event;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Location location = (Location) obj;
            if (location != null) {
                an anVar = this.f59507a;
                anVar.f59504b = null;
                anVar.f59503a = null;
                anVar.a("lat", (Object) Double.valueOf(location.getLatitude()));
                this.f59507a.a("long", (Object) Double.valueOf(location.getLongitude()));
                net.one97.paytm.phoenix.core.a.a(this.f59507a, this.f59508b, (Object) null, false, 6);
                return;
            }
            this.f59507a.f59503a = new com.google.android.gms.location.d(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f59509a;

                {
                    this.f59509a = r1;
                }

                public final void onLocationResult(LocationResult locationResult) {
                    com.google.android.gms.location.b bVar;
                    if (locationResult != null) {
                        if (!(this.f59509a.f59507a.f59504b == null || this.f59509a.f59507a.f59503a == null || (bVar = this.f59509a.f59507a.f59504b) == null)) {
                            bVar.a(this.f59509a.f59507a.f59503a);
                        }
                        this.f59509a.f59507a.f59504b = null;
                        this.f59509a.f59507a.f59503a = null;
                        an anVar = this.f59509a.f59507a;
                        Location a2 = locationResult.a();
                        k.a((Object) a2, "lr.lastLocation");
                        anVar.a("lat", (Object) Double.valueOf(a2.getLatitude()));
                        an anVar2 = this.f59509a.f59507a;
                        Location a3 = locationResult.a();
                        k.a((Object) a3, "lr.lastLocation");
                        anVar2.a("long", (Object) Double.valueOf(a3.getLongitude()));
                        net.one97.paytm.phoenix.core.a.a(this.f59509a.f59507a, this.f59509a.f59508b, (Object) null, false, 6);
                        return;
                    }
                    this.f59509a.f59507a.a(this.f59509a.f59508b, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "Error");
                }
            };
            LocationRequest a2 = LocationRequest.a();
            a2.b(1000);
            a2.a(1000);
            a2.a(100);
            a2.f11342b = 0.0f;
            com.google.android.gms.location.b bVar = this.f59507a.f59504b;
            if (bVar != null) {
                bVar.a(a2, this.f59507a.f59503a, (Looper) null);
            }
        }
    }

    public an() {
        super("paytmGetLocation");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r8, net.one97.paytm.phoenix.api.b r9) {
        /*
            r7 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r9, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.b) r9)
            boolean r9 = r7.a((net.one97.paytm.phoenix.api.H5Event) r8)
            r0 = 1
            if (r9 == 0) goto L_0x00ed
            android.app.Activity r9 = r8.getActivity()
            if (r9 == 0) goto L_0x0038
            android.app.Activity r9 = r8.getActivity()
            if (r9 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            boolean r9 = r9 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r9 == 0) goto L_0x0038
            android.app.Activity r9 = r8.getActivity()
            if (r9 == 0) goto L_0x0030
            net.one97.paytm.phoenix.ui.PhoenixActivity r9 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r9
            goto L_0x0039
        L_0x0030:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            r9 = 0
        L_0x0039:
            if (r9 != 0) goto L_0x003d
            r8 = 0
            return r8
        L_0x003d:
            java.lang.String r1 = r8.getAction$phoenix_debug()
            java.lang.String r2 = "location"
            java.lang.Object r2 = r9.getSystemService(r2)
            if (r2 == 0) goto L_0x00e5
            android.location.LocationManager r2 = (android.location.LocationManager) r2
            java.lang.String r3 = "gps"
            boolean r2 = r2.isProviderEnabled(r3)
            if (r2 != 0) goto L_0x00a3
            r2 = r9
            android.app.Activity r2 = (android.app.Activity) r2
            com.google.android.gms.common.api.e$a r3 = new com.google.android.gms.common.api.e$a
            r4 = r2
            android.content.Context r4 = (android.content.Context) r4
            r3.<init>(r4)
            com.google.android.gms.common.api.a<java.lang.Object> r4 = com.google.android.gms.location.f.f11372a
            com.google.android.gms.common.api.e$a r3 = r3.a((com.google.android.gms.common.api.a<? extends com.google.android.gms.common.api.a.d.C0127d>) r4)
            com.google.android.gms.common.api.e r3 = r3.a()
            r3.d()
            com.google.android.gms.location.LocationRequest r4 = com.google.android.gms.location.LocationRequest.a()
            java.lang.String r5 = "locationRequest"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = 100
            r4.a((int) r5)
            r5 = 10000(0x2710, double:4.9407E-320)
            r4.a((long) r5)
            r5 = 5000(0x1388, double:2.4703E-320)
            r4.b(r5)
            com.google.android.gms.location.LocationSettingsRequest$a r5 = new com.google.android.gms.location.LocationSettingsRequest$a
            r5.<init>()
            com.google.android.gms.location.LocationSettingsRequest$a r4 = r5.a(r4)
            r4.f11355a = r0
            com.google.android.gms.location.h r5 = com.google.android.gms.location.f.f11375d
            com.google.android.gms.location.LocationSettingsRequest r4 = r4.b()
            com.google.android.gms.common.api.g r3 = r5.a(r3, r4)
            net.one97.paytm.phoenix.d.an$a r4 = new net.one97.paytm.phoenix.d.an$a
            r4.<init>(r2)
            com.google.android.gms.common.api.m r4 = (com.google.android.gms.common.api.m) r4
            r3.a(r4)
            goto L_0x00a6
        L_0x00a3:
            r7.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.ui.PhoenixActivity) r9)
        L_0x00a6:
            if (r1 == 0) goto L_0x00cf
            int r2 = r1.hashCode()
            r3 = 677282122(0x285e814a, float:1.2351511E-14)
            if (r2 == r3) goto L_0x00b2
            goto L_0x00cf
        L_0x00b2:
            java.lang.String r2 = "paytmGetLocation"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x00cf
            net.one97.paytm.phoenix.ui.PhoenixActivity$i r2 = r9.s
            java.util.Observable r2 = (java.util.Observable) r2
            r2.deleteObservers()
            net.one97.paytm.phoenix.ui.PhoenixActivity$i r2 = r9.s
            java.util.Observable r2 = (java.util.Observable) r2
            net.one97.paytm.phoenix.d.an$c r3 = new net.one97.paytm.phoenix.d.an$c
            r3.<init>(r9, r7, r1, r8)
            java.util.Observer r3 = (java.util.Observer) r3
            r2.addObserver(r3)
        L_0x00cf:
            net.one97.paytm.phoenix.ui.PhoenixActivity$k r2 = r9.r
            java.util.Observable r2 = (java.util.Observable) r2
            r2.deleteObservers()
            net.one97.paytm.phoenix.ui.PhoenixActivity$k r9 = r9.r
            java.util.Observable r9 = (java.util.Observable) r9
            net.one97.paytm.phoenix.d.an$d r2 = new net.one97.paytm.phoenix.d.an$d
            r2.<init>(r7, r1, r8)
            java.util.Observer r2 = (java.util.Observer) r2
            r9.addObserver(r2)
            goto L_0x00ed
        L_0x00e5:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type android.location.LocationManager"
            r8.<init>(r9)
            throw r8
        L_0x00ed:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.an.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class c implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59510a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ an f59511b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f59512c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ H5Event f59513d;

        c(PhoenixActivity phoenixActivity, an anVar, String str, H5Event h5Event) {
            this.f59510a = phoenixActivity;
            this.f59511b = anVar;
            this.f59512c = str;
            this.f59513d = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            if (k.a(obj, (Object) Boolean.FALSE)) {
                this.f59511b.a(this.f59513d, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "Error");
            } else {
                this.f59511b.a(this.f59513d, this.f59510a);
            }
        }
    }

    static final class d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ an f59514a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f59515b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ H5Event f59516c;

        d(an anVar, String str, H5Event h5Event) {
            this.f59514a = anVar;
            this.f59515b = str;
            this.f59516c = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            com.google.android.gms.location.b bVar;
            if (this.f59514a.f59504b != null && this.f59514a.f59503a != null && (bVar = this.f59514a.f59504b) != null) {
                bVar.a(this.f59514a.f59503a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(H5Event h5Event, PhoenixActivity phoenixActivity) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        for (String a2 : arrayList) {
            if (androidx.core.content.b.a((Context) phoenixActivity, a2) == 0) {
                this.f59505c = true;
            }
        }
        if (this.f59505c) {
            a(h5Event, (Activity) phoenixActivity);
            return;
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            a(h5Event, phoenixActivity, (String[]) array);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* access modifiers changed from: package-private */
    public final void a(H5Event h5Event, Activity activity) {
        Task<Location> a2;
        this.f59504b = f.b(activity);
        com.google.android.gms.location.b bVar = this.f59504b;
        if (bVar != null && (a2 = bVar.a()) != null) {
            a2.a((OnSuccessListener<? super Location>) new b(this, h5Event));
        }
    }

    private final void a(H5Event h5Event, PhoenixActivity phoenixActivity, String[] strArr) {
        this.f59505c = false;
        phoenixActivity.k.addObserver(new e(this, h5Event, phoenixActivity));
        phoenixActivity.a(strArr);
    }

    static final class e implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ an f59517a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59518b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59519c;

        e(an anVar, H5Event h5Event, PhoenixActivity phoenixActivity) {
            this.f59517a = anVar;
            this.f59518b = h5Event;
            this.f59519c = phoenixActivity;
        }

        public final void update(Observable observable, Object obj) {
            an anVar = this.f59517a;
            if (obj instanceof o) {
                o oVar = (o) obj;
                if (oVar.getFirst() != null) {
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                            anVar.a(this.f59518b, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "Error");
                        } else if (!anVar.f59505c) {
                            anVar.f59505c = true;
                            anVar.a(this.f59518b, (Activity) this.f59519c);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<*>");
                }
            } else {
                anVar.a(this.f59518b, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "Error");
            }
            this.f59519c.k.deleteObservers();
        }
    }
}
