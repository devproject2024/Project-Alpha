package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.n;

/* renamed from: com.google.android.gms.internal.firebase_ml.do  reason: invalid class name */
public class Cdo {

    /* renamed from: b  reason: collision with root package name */
    public static final b<?> f9807b = b.a(Cdo.class).a(n.b(ec.class)).a(dp.f9810a).a();

    /* renamed from: c  reason: collision with root package name */
    private static final j f9808c = new j("MLTaskManager", "");

    /* renamed from: a  reason: collision with root package name */
    final ec f9809a;

    private Cdo(ec ecVar) {
        this.f9809a = ecVar;
    }

    public static synchronized Cdo a(ds dsVar) {
        Cdo doVar;
        Class cls = Cdo.class;
        synchronized (cls) {
            doVar = (Cdo) dsVar.a(cls);
        }
        return doVar;
    }

    public final synchronized <T, S extends dm> Task<T> a(di<T, S> diVar, S s) {
        ea a2;
        s.a(diVar, (Object) "Operation can not be null");
        s.a(s, (Object) "Input can not be null");
        f9808c.a("Execute task");
        a2 = diVar.a();
        this.f9809a.b(a2);
        return dl.b().a(new dq(this, a2, diVar, s));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(ea eaVar, di diVar, dm dmVar) throws Exception {
        if (eaVar != null) {
            this.f9809a.d(eaVar);
        }
        return diVar.a(dmVar);
    }

    static final /* synthetic */ Cdo a(e eVar) {
        return new Cdo((ec) eVar.a(ec.class));
    }
}
