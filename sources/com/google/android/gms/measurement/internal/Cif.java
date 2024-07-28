package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.s;

/* renamed from: com.google.android.gms.measurement.internal.if  reason: invalid class name */
public final class Cif implements ServiceConnection, c.a, c.b {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f12197a;

    /* renamed from: b  reason: collision with root package name */
    volatile dv f12198b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ hm f12199c;

    protected Cif(hm hmVar) {
        this.f12199c = hmVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.f12199c.J_().f11828c.a("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.s.b((java.lang.String) r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001d
            r3.f12197a = r4     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.hm r4 = r3.f12199c     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "Service connected with null binder"
            r4.a(r5)     // Catch:{ all -> 0x001a }
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            return
        L_0x001a:
            r4 = move-exception
            goto L_0x008e
        L_0x001d:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x005c }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x005c }
            if (r2 == 0) goto L_0x004e
            if (r5 != 0) goto L_0x002d
            goto L_0x0040
        L_0x002d:
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x005c }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.dq     // Catch:{ RemoteException -> 0x005c }
            if (r2 == 0) goto L_0x003a
            com.google.android.gms.measurement.internal.dq r1 = (com.google.android.gms.measurement.internal.dq) r1     // Catch:{ RemoteException -> 0x005c }
            goto L_0x003f
        L_0x003a:
            com.google.android.gms.measurement.internal.ds r1 = new com.google.android.gms.measurement.internal.ds     // Catch:{ RemoteException -> 0x005c }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x005c }
        L_0x003f:
            r0 = r1
        L_0x0040:
            com.google.android.gms.measurement.internal.hm r5 = r3.f12199c     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.measurement.internal.ea r5 = r5.k     // Catch:{ RemoteException -> 0x005c }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.a(r1)     // Catch:{ RemoteException -> 0x005c }
            goto L_0x0069
        L_0x004e:
            com.google.android.gms.measurement.internal.hm r5 = r3.f12199c     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.measurement.internal.ea r5 = r5.f11828c     // Catch:{ RemoteException -> 0x005c }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.a(r2, r1)     // Catch:{ RemoteException -> 0x005c }
            goto L_0x0069
        L_0x005c:
            com.google.android.gms.measurement.internal.hm r5 = r3.f12199c     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.ea r5 = r5.f11828c     // Catch:{ all -> 0x001a }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.a(r1)     // Catch:{ all -> 0x001a }
        L_0x0069:
            if (r0 != 0) goto L_0x007e
            r3.f12197a = r4     // Catch:{ all -> 0x001a }
            com.google.android.gms.common.stats.a.a()     // Catch:{ IllegalArgumentException -> 0x008c }
            com.google.android.gms.measurement.internal.hm r4 = r3.f12199c     // Catch:{ IllegalArgumentException -> 0x008c }
            android.content.Context r4 = r4.k()     // Catch:{ IllegalArgumentException -> 0x008c }
            com.google.android.gms.measurement.internal.hm r5 = r3.f12199c     // Catch:{ IllegalArgumentException -> 0x008c }
            com.google.android.gms.measurement.internal.if r5 = r5.f12119a     // Catch:{ IllegalArgumentException -> 0x008c }
            com.google.android.gms.common.stats.a.a(r4, r5)     // Catch:{ IllegalArgumentException -> 0x008c }
            goto L_0x008c
        L_0x007e:
            com.google.android.gms.measurement.internal.hm r4 = r3.f12199c     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.eu r4 = r4.K_()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.ii r5 = new com.google.android.gms.measurement.internal.ii     // Catch:{ all -> 0x001a }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001a }
            r4.a((java.lang.Runnable) r5)     // Catch:{ all -> 0x001a }
        L_0x008c:
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            return
        L_0x008e:
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Cif.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        s.b("MeasurementServiceConnection.onServiceDisconnected");
        this.f12199c.J_().j.a("Service disconnected");
        this.f12199c.K_().a((Runnable) new ih(this, componentName));
    }

    public final void a() {
        s.b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f12199c.K_().a((Runnable) new ik(this, (dq) this.f12198b.r()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f12198b = null;
                this.f12197a = false;
            }
        }
    }

    public final void a(int i2) {
        s.b("MeasurementServiceConnection.onConnectionSuspended");
        this.f12199c.J_().j.a("Service connection suspended");
        this.f12199c.K_().a((Runnable) new ij(this));
    }

    public final void a(ConnectionResult connectionResult) {
        s.b("MeasurementServiceConnection.onConnectionFailed");
        fc fcVar = this.f12199c.y;
        dy dyVar = (fcVar.f11946f == null || !fcVar.f11946f.v()) ? null : fcVar.f11946f;
        if (dyVar != null) {
            dyVar.f11831f.a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f12197a = false;
            this.f12198b = null;
        }
        this.f12199c.K_().a((Runnable) new im(this));
    }
}
