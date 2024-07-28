package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.c;
import com.google.android.gms.internal.base.k;
import java.util.concurrent.atomic.AtomicReference;

public abstract class cl extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f8527b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile boolean f8528c;

    /* renamed from: d  reason: collision with root package name */
    protected final AtomicReference<cn> f8529d;

    /* renamed from: e  reason: collision with root package name */
    protected final c f8530e;

    protected cl(j jVar) {
        this(jVar, c.a());
    }

    /* access modifiers changed from: protected */
    public abstract void a(ConnectionResult connectionResult, int i2);

    /* access modifiers changed from: protected */
    public abstract void e();

    private cl(j jVar, c cVar) {
        super(jVar);
        this.f8529d = new AtomicReference<>((Object) null);
        this.f8527b = new k(Looper.getMainLooper());
        this.f8530e = cVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, (PendingIntent) null), a(this.f8529d.get()));
        f();
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            this.f8529d.set(bundle.getBoolean("resolving_error", false) ? new cn(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void b(Bundle bundle) {
        super.b(bundle);
        cn cnVar = this.f8529d.get();
        if (cnVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", cnVar.f8533a);
            bundle.putInt("failed_status", cnVar.f8534b.f8334b);
            bundle.putParcelable("failed_resolution", cnVar.f8534b.f8335c);
        }
    }

    public void b() {
        super.b();
        this.f8528c = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.cn> r0 = r4.f8529d
            java.lang.Object r0 = r0.get()
            com.google.android.gms.common.api.internal.cn r0 = (com.google.android.gms.common.api.internal.cn) r0
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L_0x002c
            r6 = 2
            if (r5 == r6) goto L_0x0010
            goto L_0x0057
        L_0x0010:
            com.google.android.gms.common.c r5 = r4.f8530e
            android.app.Activity r6 = r4.a()
            int r5 = r5.a((android.content.Context) r6)
            if (r5 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            if (r0 != 0) goto L_0x0021
            return
        L_0x0021:
            com.google.android.gms.common.ConnectionResult r6 = r0.f8534b
            int r6 = r6.f8334b
            r7 = 18
            if (r6 != r7) goto L_0x0058
            if (r5 != r7) goto L_0x0058
            return
        L_0x002c:
            r5 = -1
            if (r6 != r5) goto L_0x0030
            goto L_0x0058
        L_0x0030:
            if (r6 != 0) goto L_0x0057
            r5 = 13
            if (r7 == 0) goto L_0x003c
            java.lang.String r6 = "<<ResolutionFailureErrorDetail>>"
            int r5 = r7.getIntExtra(r6, r5)
        L_0x003c:
            com.google.android.gms.common.api.internal.cn r6 = new com.google.android.gms.common.api.internal.cn
            com.google.android.gms.common.ConnectionResult r7 = new com.google.android.gms.common.ConnectionResult
            r1 = 0
            com.google.android.gms.common.ConnectionResult r3 = r0.f8534b
            java.lang.String r3 = r3.toString()
            r7.<init>(r5, r1, r3)
            int r5 = a((com.google.android.gms.common.api.internal.cn) r0)
            r6.<init>(r7, r5)
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.cn> r5 = r4.f8529d
            r5.set(r6)
            r0 = r6
        L_0x0057:
            r1 = 0
        L_0x0058:
            if (r1 == 0) goto L_0x005e
            r4.f()
            return
        L_0x005e:
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.common.ConnectionResult r5 = r0.f8534b
            int r6 = r0.f8533a
            r4.a(r5, r6)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.cl.a(int, int, android.content.Intent):void");
    }

    public void d() {
        super.d();
        this.f8528c = false;
    }

    /* access modifiers changed from: protected */
    public final void f() {
        this.f8529d.set((Object) null);
        e();
    }

    public final void b(ConnectionResult connectionResult, int i2) {
        cn cnVar = new cn(connectionResult, i2);
        if (this.f8529d.compareAndSet((Object) null, cnVar)) {
            this.f8527b.post(new cm(this, cnVar));
        }
    }

    private static int a(cn cnVar) {
        if (cnVar == null) {
            return -1;
        }
        return cnVar.f8533a;
    }
}
