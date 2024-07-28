package com.paytm.location.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import androidx.work.c;
import androidx.work.p;
import androidx.work.v;
import androidx.work.w;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.d;
import com.google.android.gms.tasks.OnSuccessListener;
import com.paytm.analytics.b;
import com.paytm.analytics.models.LocationEvent;
import com.paytm.analytics.models.LocationStateEvent;
import com.paytm.analytics.models.PaytmLocation;
import com.paytm.analytics.models.SignalEvent;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.location.schedulers.LocationJob;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    com.google.android.gms.location.b f42842a;

    /* renamed from: b  reason: collision with root package name */
    WeakReference<Context> f42843b;

    /* renamed from: c  reason: collision with root package name */
    d f42844c = new b(this);

    /* renamed from: d  reason: collision with root package name */
    final com.paytm.analytics.b.a f42845d;

    /* renamed from: e  reason: collision with root package name */
    private PaytmLocation f42846e;

    /* renamed from: f  reason: collision with root package name */
    private com.paytm.analytics.d f42847f;

    /* renamed from: g  reason: collision with root package name */
    private final com.paytm.analytics.schedulers.a f42848g;

    /* renamed from: h  reason: collision with root package name */
    private final com.paytm.analytics.b.b f42849h;

    /* renamed from: i  reason: collision with root package name */
    private final com.paytm.analytics.data.c f42850i;

    static final class a<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f42851a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f42852b;

        a(c cVar, Context context) {
            this.f42851a = cVar;
            this.f42852b = context;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            final Location location = (Location) obj;
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super x>, Object>(this, (kotlin.d.d) null) {
                int label;
                private CoroutineScope p$;
                final /* synthetic */ a this$0;

                {
                    this.this$0 = r1;
                }

                public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                    k.c(dVar, "completion");
                    AnonymousClass1 r0 = 

                    public c(com.paytm.analytics.b.a aVar, com.paytm.analytics.schedulers.a aVar2, com.paytm.analytics.b.b bVar, com.paytm.analytics.data.c cVar) {
                        k.c(aVar, "configProvider");
                        k.c(aVar2, "jobScheduler");
                        k.c(bVar, "pushEventProvider");
                        k.c(cVar, "configPreferenceStore");
                        this.f42845d = aVar;
                        this.f42848g = aVar2;
                        this.f42849h = bVar;
                        this.f42850i = cVar;
                    }

                    public final synchronized PaytmLocation a() {
                        return this.f42846e;
                    }

                    public final synchronized void b() {
                        if (this.f42846e == null) {
                            SharedPreferences a2 = this.f42850i.a();
                            PaytmLocation paytmLocation = new PaytmLocation((Float) null, (Float) null, (Long) null, (Float) null, (Boolean) null, 31, (g) null);
                            paytmLocation.setLatitude(Float.valueOf(a2.getFloat("last_latitude", 0.0f)));
                            paytmLocation.setLongitude(Float.valueOf(a2.getFloat("last_longitude", 0.0f)));
                            paytmLocation.setTime(Long.valueOf(a2.getLong("location_time", 0)));
                            paytmLocation.setLastDistanceDelta(Float.valueOf(a2.getFloat("last_distance_delta", 0.0f)));
                            paytmLocation.setGpslastState(Boolean.valueOf(a2.getBoolean("gps_last_state", false)));
                            this.f42846e = paytmLocation;
                        }
                    }

                    public final void a(com.paytm.analytics.d dVar) {
                        k.c(dVar, "signalLocationCallback");
                        this.f42847f = dVar;
                    }

                    public final synchronized void a(Context context) {
                        synchronized (this) {
                            k.c(context, "context");
                            try {
                                boolean c2 = c(context);
                                PaytmLocation paytmLocation = this.f42846e;
                                if (!k.a((Object) paytmLocation != null ? paytmLocation.getGpslastState() : null, (Object) Boolean.valueOf(c2))) {
                                    this.f42849h.a(new SignalEvent(LocationStateEvent.EVENT_TYPE_LOCATION_STATE_EVENT, new LocationStateEvent(Boolean.valueOf(c2), Boolean.valueOf(d(context)), Boolean.FALSE), (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16777212, (g) null), this.f42846e);
                                    PaytmLocation paytmLocation2 = this.f42846e;
                                    if (paytmLocation2 != null) {
                                        paytmLocation2.setGpslastState(Boolean.valueOf(c2));
                                    }
                                    this.f42850i.a(this.f42846e);
                                    if (!(this.f42847f == null || this.f42846e == null)) {
                                        com.paytm.analytics.d dVar = this.f42847f;
                                        if (dVar == null) {
                                            k.a();
                                        }
                                        PaytmLocation paytmLocation3 = this.f42846e;
                                        if (paytmLocation3 == null) {
                                            k.a();
                                        }
                                        dVar.a(paytmLocation3);
                                        this.f42847f = null;
                                        return;
                                    }
                                }
                            } catch (Exception e2) {
                                com.paytm.a.a.b.f40832a.b(e2);
                                e2.printStackTrace();
                            }
                        }
                        return;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
                        return;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final synchronized void b(android.content.Context r3) {
                        /*
                            r2 = this;
                            monitor-enter(r2)
                            java.lang.String r0 = "context"
                            kotlin.g.b.k.c(r3, r0)     // Catch:{ all -> 0x003c }
                            com.paytm.location.a r0 = com.paytm.location.a.f42839a     // Catch:{ Exception -> 0x0032 }
                            boolean r0 = com.paytm.location.a.a(r3)     // Catch:{ Exception -> 0x0032 }
                            if (r0 != 0) goto L_0x0010
                            monitor-exit(r2)
                            return
                        L_0x0010:
                            com.google.android.gms.location.b r0 = r2.f42842a     // Catch:{ Exception -> 0x0032 }
                            if (r0 != 0) goto L_0x001a
                            com.google.android.gms.location.b r0 = com.google.android.gms.location.f.b((android.content.Context) r3)     // Catch:{ Exception -> 0x0032 }
                            r2.f42842a = r0     // Catch:{ Exception -> 0x0032 }
                        L_0x001a:
                            com.google.android.gms.location.b r0 = r2.f42842a     // Catch:{ Exception -> 0x0032 }
                            if (r0 == 0) goto L_0x0030
                            com.google.android.gms.tasks.Task r0 = r0.a()     // Catch:{ Exception -> 0x0032 }
                            if (r0 == 0) goto L_0x0030
                            com.paytm.location.a.c$a r1 = new com.paytm.location.a.c$a     // Catch:{ Exception -> 0x0032 }
                            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0032 }
                            com.google.android.gms.tasks.OnSuccessListener r1 = (com.google.android.gms.tasks.OnSuccessListener) r1     // Catch:{ Exception -> 0x0032 }
                            r0.a(r1)     // Catch:{ Exception -> 0x0032 }
                            monitor-exit(r2)
                            return
                        L_0x0030:
                            monitor-exit(r2)
                            return
                        L_0x0032:
                            r3 = move-exception
                            com.paytm.a.a.b$b r0 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x003c }
                            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x003c }
                            r0.b(r3)     // Catch:{ all -> 0x003c }
                            monitor-exit(r2)
                            return
                        L_0x003c:
                            r3 = move-exception
                            monitor-exit(r2)
                            throw r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.paytm.location.a.c.b(android.content.Context):void");
                    }

                    public final synchronized void a(Location location, Context context) throws Exception {
                        Context context2 = context;
                        synchronized (this) {
                            k.c(location, "location");
                            k.c(context2, "context");
                            if (k.a((Object) location.getProvider(), (Object) "fused")) {
                                com.paytm.a.a.b.f40832a.a("New location found", new Object[0]);
                                LocationEvent locationEvent = new LocationEvent((Double) null, (Double) null, (Float) null, 7, (g) null);
                                locationEvent.setLongitude(Double.valueOf(location.getLongitude()));
                                locationEvent.setLatitude(Double.valueOf(location.getLatitude()));
                                locationEvent.setSpeed(Float.valueOf(location.getSpeed()));
                                this.f42846e = new PaytmLocation(Float.valueOf((float) location.getLongitude()), Float.valueOf((float) location.getLatitude()), Long.valueOf(new Date().getTime()), (Float) null, (Boolean) null, 24, (g) null);
                                PaytmLocation paytmLocation = this.f42846e;
                                if (paytmLocation != null) {
                                    paytmLocation.setGpslastState(Boolean.valueOf(c(context2)));
                                }
                                this.f42850i.a(this.f42846e);
                                this.f42849h.a(new SignalEvent(LocationEvent.EVENT_TYPE_LOCATION_EVENT, locationEvent, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16777212, (g) null), this.f42846e);
                                if (this.f42847f != null) {
                                    com.paytm.analytics.d dVar = this.f42847f;
                                    if (dVar == null) {
                                        k.a();
                                    }
                                    PaytmLocation paytmLocation2 = this.f42846e;
                                    if (paytmLocation2 == null) {
                                        k.a();
                                    }
                                    dVar.a(paytmLocation2);
                                    this.f42847f = null;
                                }
                                com.paytm.a.a.b.f40832a.a("location event pushed to event handler", new Object[0]);
                            }
                        }
                    }

                    public static final class b extends d {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ c f42853a;

                        b(c cVar) {
                            this.f42853a = cVar;
                        }

                        public final void onLocationResult(LocationResult locationResult) {
                            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new a(this, locationResult, (kotlin.d.d) null), 2, (Object) null);
                        }

                        @f(b = "LocationProviderImpl.kt", c = {}, d = "invokeSuspend", e = "com.paytm.location.provider.LocationProviderImpl$locationCallback$1$onLocationResult$1")
                        static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                            final /* synthetic */ LocationResult $locationResult;
                            int label;
                            private CoroutineScope p$;
                            final /* synthetic */ b this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            a(b bVar, LocationResult locationResult, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.this$0 = bVar;
                                this.$locationResult = locationResult;
                            }

                            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                                k.c(dVar, "completion");
                                a aVar = new a(this.this$0, this.$locationResult, dVar);
                                aVar.p$ = (CoroutineScope) obj;
                                return aVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label == 0) {
                                    ResultKt.a(obj);
                                    try {
                                        if (this.$locationResult != null && !k.a((Object) this.this$0.f42853a.f42845d.f40920a.isLocationEnable(), (Object) Boolean.FALSE)) {
                                            b.C0683b bVar = com.paytm.analytics.b.f40911e;
                                            if (b.C0683b.a()) {
                                                WeakReference<Context> weakReference = this.this$0.f42853a.f42843b;
                                                Context context = weakReference != null ? (Context) weakReference.get() : null;
                                                if (context != null) {
                                                    for (Location next : this.$locationResult.b()) {
                                                        c cVar = this.this$0.f42853a;
                                                        if (next == null) {
                                                            k.a();
                                                        }
                                                        cVar.a(next, context);
                                                    }
                                                }
                                                c.a(this.this$0.f42853a);
                                                return x.f47997a;
                                            }
                                        }
                                        com.paytm.a.a.b.f40832a.b("location results null", new Object[0]);
                                        x xVar = x.f47997a;
                                        c.a(this.this$0.f42853a);
                                        return xVar;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        com.paytm.a.a.b.f40832a.b(e2);
                                    } catch (Throwable th) {
                                        c.a(this.this$0.f42853a);
                                        throw th;
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                    }

                    public final synchronized boolean c(Context context) {
                        k.c(context, "context");
                        LocationManager locationManager = (LocationManager) context.getSystemService("location");
                        if (locationManager == null) {
                            return false;
                        }
                        boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                        boolean isProviderEnabled2 = locationManager.isProviderEnabled(ContactsConstant.NETWORK);
                        if (isProviderEnabled || isProviderEnabled2) {
                            return true;
                        }
                        return false;
                    }

                    public final synchronized boolean d(Context context) {
                        k.c(context, "context");
                        return androidx.core.app.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
                    }

                    public final synchronized void d() {
                        this.f42848g.a("get_location_tag");
                    }

                    @f(b = "LocationProviderImpl.kt", c = {}, d = "invokeSuspend", e = "com.paytm.location.provider.LocationProviderImpl$startLocationUpdates$1")
                    /* renamed from: com.paytm.location.a.c$c  reason: collision with other inner class name */
                    static final class C0714c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                        final /* synthetic */ LocationRequest $mLocationRequest;
                        int label;
                        private CoroutineScope p$;
                        final /* synthetic */ c this$0;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        C0714c(c cVar, LocationRequest locationRequest, kotlin.d.d dVar) {
                            super(2, dVar);
                            this.this$0 = cVar;
                            this.$mLocationRequest = locationRequest;
                        }

                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                            k.c(dVar, "completion");
                            C0714c cVar = new C0714c(this.this$0, this.$mLocationRequest, dVar);
                            cVar.p$ = (CoroutineScope) obj;
                            return cVar;
                        }

                        public final Object invoke(Object obj, Object obj2) {
                            return ((C0714c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                        }

                        public final Object invokeSuspend(Object obj) {
                            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                            if (this.label == 0) {
                                ResultKt.a(obj);
                                com.google.android.gms.location.b bVar = this.this$0.f42842a;
                                if (bVar == null) {
                                    k.a();
                                }
                                bVar.a(this.$mLocationRequest, this.this$0.f42844c, (Looper) null);
                                return x.f47997a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }

                    public final synchronized void c() {
                        long j;
                        Integer locationSchedulingTime = this.f42845d.f40920a.getLocationSchedulingTime();
                        int i2 = 0;
                        if ((locationSchedulingTime != null ? locationSchedulingTime.intValue() : 0) <= 0) {
                            j = 900000;
                        } else {
                            Integer locationSchedulingTime2 = this.f42845d.f40920a.getLocationSchedulingTime();
                            if (locationSchedulingTime2 != null) {
                                i2 = locationSchedulingTime2.intValue();
                            }
                            j = (long) i2;
                        }
                        long j2 = j;
                        com.paytm.analytics.schedulers.a aVar = this.f42848g;
                        try {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            w.a a2 = ((p.a) ((p.a) new p.a(LocationJob.class, j2, timeUnit, timeUnit).a(androidx.work.a.EXPONENTIAL, 30000, TimeUnit.MILLISECONDS)).a(new c.a().b())).a("get_location_tag");
                            k.a((Object) a2, "PeriodicWorkRequest.Buil…dTag(LocationJob.JOB_TAG)");
                            p.a aVar2 = (p.a) a2;
                            v a3 = aVar.a();
                            if (a3 != null) {
                                a3.a("get_location_tag", androidx.work.f.REPLACE, (p) aVar2.c());
                            }
                        } catch (Exception e2) {
                            com.paytm.a.a.b.f40832a.b(e2);
                        }
                    }

                    public static final /* synthetic */ void a(c cVar) {
                        com.paytm.a.a.b.f40832a.b("location update stopped", new Object[0]);
                        com.google.android.gms.location.b bVar = cVar.f42842a;
                        if (bVar != null) {
                            bVar.a(cVar.f42844c);
                        }
                    }
                }
