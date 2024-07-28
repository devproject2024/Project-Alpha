package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.s;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class cj extends cl {

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<a> f8517b = new SparseArray<>();

    public static cj b(i iVar) {
        j a2 = a(iVar);
        cj cjVar = (cj) a2.a("AutoManageHelper", cj.class);
        if (cjVar != null) {
            return cjVar;
        }
        return new cj(a2);
    }

    class a implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final int f8518a;

        /* renamed from: b  reason: collision with root package name */
        public final e f8519b;

        /* renamed from: c  reason: collision with root package name */
        public final e.c f8520c;

        public a(int i2, e eVar, e.c cVar) {
            this.f8518a = i2;
            this.f8519b = eVar;
            this.f8520c = cVar;
            eVar.a((e.c) this);
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            cj.this.b(connectionResult, this.f8518a);
        }
    }

    private cj(j jVar) {
        super(jVar);
        this.f8394a.a("AutoManageHelper", (LifecycleCallback) this);
    }

    public final void a(int i2, e eVar, e.c cVar) {
        s.a(eVar, (Object) "GoogleApiClient instance cannot be null");
        boolean z = this.f8517b.indexOfKey(i2) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i2);
        s.a(z, (Object) sb.toString());
        cn cnVar = (cn) this.f8529d.get();
        boolean z2 = this.f8528c;
        String valueOf = String.valueOf(cnVar);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i2);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        this.f8517b.put(i2, new a(i2, eVar, cVar));
        if (this.f8528c && cnVar == null) {
            String valueOf2 = String.valueOf(eVar);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            eVar.d();
        }
    }

    public final void b() {
        super.b();
        boolean z = this.f8528c;
        String valueOf = String.valueOf(this.f8517b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        if (this.f8529d.get() == null) {
            for (int i2 = 0; i2 < this.f8517b.size(); i2++) {
                a a2 = a(i2);
                if (a2 != null) {
                    a2.f8519b.d();
                }
            }
        }
    }

    public final void d() {
        super.d();
        for (int i2 = 0; i2 < this.f8517b.size(); i2++) {
            a a2 = a(i2);
            if (a2 != null) {
                a2.f8519b.e();
            }
        }
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.f8517b.size(); i2++) {
            a a2 = a(i2);
            if (a2 != null) {
                printWriter.append(str).append("GoogleApiClient #").print(a2.f8518a);
                printWriter.println(AppConstants.COLON);
                a2.f8519b.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ConnectionResult connectionResult, int i2) {
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = this.f8517b.get(i2);
        if (aVar != null) {
            a aVar2 = this.f8517b.get(i2);
            this.f8517b.remove(i2);
            if (aVar2 != null) {
                aVar2.f8519b.b((e.c) aVar2);
                aVar2.f8519b.e();
            }
            e.c cVar = aVar.f8520c;
            if (cVar != null) {
                cVar.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        for (int i2 = 0; i2 < this.f8517b.size(); i2++) {
            a a2 = a(i2);
            if (a2 != null) {
                a2.f8519b.d();
            }
        }
    }

    private final a a(int i2) {
        if (this.f8517b.size() <= i2) {
            return null;
        }
        SparseArray<a> sparseArray = this.f8517b;
        return sparseArray.get(sparseArray.keyAt(i2));
    }
}
