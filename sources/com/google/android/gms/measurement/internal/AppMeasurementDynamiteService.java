package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.ju;
import com.google.android.gms.internal.measurement.lw;
import com.google.android.gms.internal.measurement.mg;
import com.google.android.gms.internal.measurement.mh;
import com.google.android.gms.internal.measurement.zzv;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class AppMeasurementDynamiteService extends ju {

    /* renamed from: a  reason: collision with root package name */
    fc f11680a = null;

    /* renamed from: b  reason: collision with root package name */
    private Map<Integer, gb> f11681b = new androidx.a.a();

    class a implements gd {

        /* renamed from: a  reason: collision with root package name */
        private mg f11682a;

        a(mg mgVar) {
            this.f11682a = mgVar;
        }

        public final void a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f11682a.a(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f11680a.J_().f11831f.a("Event interceptor threw exception", e2);
            }
        }
    }

    class b implements gb {

        /* renamed from: a  reason: collision with root package name */
        private mg f11684a;

        b(mg mgVar) {
            this.f11684a = mgVar;
        }

        public final void a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f11684a.a(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f11680a.J_().f11831f.a("Event listener threw exception", e2);
            }
        }
    }

    private final void a() {
        if (this.f11680a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void initialize(com.google.android.gms.b.b bVar, zzv zzv, long j) throws RemoteException {
        Context context = (Context) d.a(bVar);
        fc fcVar = this.f11680a;
        if (fcVar == null) {
            this.f11680a = fc.a(context, zzv);
        } else {
            fcVar.J_().f11831f.a("Attempting to initialize multiple times");
        }
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        a();
        this.f11680a.d().a(str, str2, bundle, z, z2, j);
    }

    public void setUserProperty(String str, String str2, com.google.android.gms.b.b bVar, boolean z, long j) throws RemoteException {
        a();
        this.f11680a.d().a(str, str2, d.a(bVar), z, j);
    }

    public void setUserId(String str, long j) throws RemoteException {
        a();
        this.f11680a.d().a((String) null, "_id", str, true, j);
    }

    public void setCurrentScreen(com.google.android.gms.b.b bVar, String str, String str2, long j) throws RemoteException {
        a();
        this.f11680a.h().a((Activity) d.a(bVar), str, str2);
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        a();
        this.f11680a.d().a(z);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        a();
        ge d2 = this.f11680a.d();
        d2.a((String) null);
        d2.K_().a((Runnable) new gm(d2, j));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        a();
        ge d2 = this.f11680a.d();
        d2.K_().a((Runnable) new gy(d2, j));
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        a();
        ge d2 = this.f11680a.d();
        d2.K_().a((Runnable) new gx(d2, j));
    }

    public void getMaxUserProperties(String str, lw lwVar) throws RemoteException {
        a();
        this.f11680a.d();
        s.a(str);
        this.f11680a.e().a(lwVar, 25);
    }

    public void getCurrentScreenName(lw lwVar) throws RemoteException {
        a();
        a(lwVar, this.f11680a.d().D());
    }

    public void getCurrentScreenClass(lw lwVar) throws RemoteException {
        a();
        a(lwVar, this.f11680a.d().E());
    }

    public void getCachedAppInstanceId(lw lwVar) throws RemoteException {
        a();
        a(lwVar, this.f11680a.d().B());
    }

    public void getAppInstanceId(lw lwVar) throws RemoteException {
        a();
        this.f11680a.K_().a((Runnable) new hc(this, lwVar));
    }

    public void getGmpAppId(lw lwVar) throws RemoteException {
        a();
        a(lwVar, this.f11680a.d().F());
    }

    public void generateEventId(lw lwVar) throws RemoteException {
        a();
        this.f11680a.e().a(lwVar, this.f11680a.e().c());
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        a();
        this.f11680a.p().a(str, j);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        a();
        this.f11680a.p().b(str, j);
    }

    public void initForTests(Map map) throws RemoteException {
        a();
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, lw lwVar, long j) throws RemoteException {
        Bundle bundle2;
        a();
        s.a(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f11680a.K_().a((Runnable) new gc(this, lwVar, new zzan(str2, new zzam(bundle), AppManagerUtil.EXTEND_PREFIX_DEFAULT, j), str));
    }

    public void onActivityStarted(com.google.android.gms.b.b bVar, long j) throws RemoteException {
        a();
        ha haVar = this.f11680a.d().f12016a;
        if (haVar != null) {
            this.f11680a.d().z();
            haVar.onActivityStarted((Activity) d.a(bVar));
        }
    }

    public void onActivityStopped(com.google.android.gms.b.b bVar, long j) throws RemoteException {
        a();
        ha haVar = this.f11680a.d().f12016a;
        if (haVar != null) {
            this.f11680a.d().z();
            haVar.onActivityStopped((Activity) d.a(bVar));
        }
    }

    public void onActivityCreated(com.google.android.gms.b.b bVar, Bundle bundle, long j) throws RemoteException {
        a();
        ha haVar = this.f11680a.d().f12016a;
        if (haVar != null) {
            this.f11680a.d().z();
            haVar.onActivityCreated((Activity) d.a(bVar), bundle);
        }
    }

    public void onActivityDestroyed(com.google.android.gms.b.b bVar, long j) throws RemoteException {
        a();
        ha haVar = this.f11680a.d().f12016a;
        if (haVar != null) {
            this.f11680a.d().z();
            haVar.onActivityDestroyed((Activity) d.a(bVar));
        }
    }

    public void onActivityPaused(com.google.android.gms.b.b bVar, long j) throws RemoteException {
        a();
        ha haVar = this.f11680a.d().f12016a;
        if (haVar != null) {
            this.f11680a.d().z();
            haVar.onActivityPaused((Activity) d.a(bVar));
        }
    }

    public void onActivityResumed(com.google.android.gms.b.b bVar, long j) throws RemoteException {
        a();
        ha haVar = this.f11680a.d().f12016a;
        if (haVar != null) {
            this.f11680a.d().z();
            haVar.onActivityResumed((Activity) d.a(bVar));
        }
    }

    public void onActivitySaveInstanceState(com.google.android.gms.b.b bVar, lw lwVar, long j) throws RemoteException {
        a();
        ha haVar = this.f11680a.d().f12016a;
        Bundle bundle = new Bundle();
        if (haVar != null) {
            this.f11680a.d().z();
            haVar.onActivitySaveInstanceState((Activity) d.a(bVar), bundle);
        }
        try {
            lwVar.a(bundle);
        } catch (RemoteException e2) {
            this.f11680a.J_().f11831f.a("Error returning bundle value to wrapper", e2);
        }
    }

    public void performAction(Bundle bundle, lw lwVar, long j) throws RemoteException {
        a();
        lwVar.a((Bundle) null);
    }

    public void getUserProperties(String str, String str2, boolean z, lw lwVar) throws RemoteException {
        a();
        this.f11680a.K_().a((Runnable) new je(this, lwVar, str, str2, z));
    }

    public void logHealthData(int i2, String str, com.google.android.gms.b.b bVar, com.google.android.gms.b.b bVar2, com.google.android.gms.b.b bVar3) throws RemoteException {
        Object obj;
        Object obj2;
        a();
        Object obj3 = null;
        if (bVar == null) {
            obj = null;
        } else {
            obj = d.a(bVar);
        }
        if (bVar2 == null) {
            obj2 = null;
        } else {
            obj2 = d.a(bVar2);
        }
        if (bVar3 != null) {
            obj3 = d.a(bVar3);
        }
        this.f11680a.J_().a(i2, true, false, str, obj, obj2, obj3);
    }

    public void setEventInterceptor(mg mgVar) throws RemoteException {
        a();
        ge d2 = this.f11680a.d();
        a aVar = new a(mgVar);
        d2.u();
        d2.K_().a((Runnable) new gl(d2, aVar));
    }

    public void registerOnMeasurementEventListener(mg mgVar) throws RemoteException {
        a();
        gb gbVar = this.f11681b.get(Integer.valueOf(mgVar.s_()));
        if (gbVar == null) {
            gbVar = new b(mgVar);
            this.f11681b.put(Integer.valueOf(mgVar.s_()), gbVar);
        }
        this.f11680a.d().a(gbVar);
    }

    public void unregisterOnMeasurementEventListener(mg mgVar) throws RemoteException {
        a();
        gb remove = this.f11681b.remove(Integer.valueOf(mgVar.s_()));
        if (remove == null) {
            remove = new b(mgVar);
        }
        this.f11680a.d().b(remove);
    }

    public void setInstanceIdProvider(mh mhVar) throws RemoteException {
        a();
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        a();
        if (bundle == null) {
            this.f11680a.J_().f11828c.a("Conditional user property must not be null");
        } else {
            this.f11680a.d().a(bundle, j);
        }
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        a();
        this.f11680a.d().c(str, str2, bundle);
    }

    public void getConditionalUserProperties(String str, String str2, lw lwVar) throws RemoteException {
        a();
        this.f11680a.K_().a((Runnable) new id(this, lwVar, str, str2));
    }

    public void getTestFlag(lw lwVar, int i2) throws RemoteException {
        a();
        if (i2 == 0) {
            jq e2 = this.f11680a.e();
            ge d2 = this.f11680a.d();
            AtomicReference atomicReference = new AtomicReference();
            e2.a(lwVar, (String) d2.K_().a(atomicReference, 15000, "String test flag value", new gp(d2, atomicReference)));
        } else if (i2 == 1) {
            jq e3 = this.f11680a.e();
            ge d3 = this.f11680a.d();
            AtomicReference atomicReference2 = new AtomicReference();
            e3.a(lwVar, ((Long) d3.K_().a(atomicReference2, 15000, "long test flag value", new gr(d3, atomicReference2))).longValue());
        } else if (i2 == 2) {
            jq e4 = this.f11680a.e();
            ge d4 = this.f11680a.d();
            AtomicReference atomicReference3 = new AtomicReference();
            double doubleValue = ((Double) d4.K_().a(atomicReference3, 15000, "double test flag value", new gt(d4, atomicReference3))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                lwVar.a(bundle);
            } catch (RemoteException e5) {
                e4.y.J_().f11831f.a("Error returning double value to wrapper", e5);
            }
        } else if (i2 == 3) {
            jq e6 = this.f11680a.e();
            ge d5 = this.f11680a.d();
            AtomicReference atomicReference4 = new AtomicReference();
            e6.a(lwVar, ((Integer) d5.K_().a(atomicReference4, 15000, "int test flag value", new gu(d5, atomicReference4))).intValue());
        } else if (i2 == 4) {
            jq e7 = this.f11680a.e();
            ge d6 = this.f11680a.d();
            AtomicReference atomicReference5 = new AtomicReference();
            e7.a(lwVar, ((Boolean) d6.K_().a(atomicReference5, 15000, "boolean test flag value", new gg(d6, atomicReference5))).booleanValue());
        }
    }

    private final void a(lw lwVar, String str) {
        this.f11680a.e().a(lwVar, str);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        a();
        this.f11680a.d().b(z);
    }

    public void isDataCollectionEnabled(lw lwVar) throws RemoteException {
        a();
        this.f11680a.K_().a((Runnable) new ju(this, lwVar));
    }
}
