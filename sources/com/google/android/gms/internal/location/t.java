package com.google.android.gms.internal.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.location.al;

public final class t extends af {

    /* renamed from: a  reason: collision with root package name */
    public final m f10396a;

    public t(Context context, Looper looper, e.b bVar, e.c cVar, String str, d dVar) {
        super(context, looper, bVar, cVar, str, dVar);
        this.f10396a = new m(context, this.j);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void f() {
        /*
            r9 = this;
            com.google.android.gms.internal.location.m r0 = r9.f10396a
            monitor-enter(r0)
            boolean r1 = r9.g()     // Catch:{ all -> 0x00cd }
            if (r1 == 0) goto L_0x00c8
            com.google.android.gms.internal.location.m r1 = r9.f10396a     // Catch:{ Exception -> 0x00c8 }
            java.util.Map<com.google.android.gms.common.api.internal.k$a<com.google.android.gms.location.e>, com.google.android.gms.internal.location.r> r2 = r1.f10387d     // Catch:{ Exception -> 0x00c8 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x00c8 }
            java.util.Map<com.google.android.gms.common.api.internal.k$a<com.google.android.gms.location.e>, com.google.android.gms.internal.location.r> r3 = r1.f10387d     // Catch:{ all -> 0x00c5 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x00c5 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c5 }
        L_0x0018:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00c5 }
            r5 = 0
            if (r4 == 0) goto L_0x0037
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.location.r r4 = (com.google.android.gms.internal.location.r) r4     // Catch:{ all -> 0x00c5 }
            if (r4 == 0) goto L_0x0018
            com.google.android.gms.internal.location.z<com.google.android.gms.internal.location.i> r6 = r1.f10384a     // Catch:{ all -> 0x00c5 }
            android.os.IInterface r6 = r6.a()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.location.i r6 = (com.google.android.gms.internal.location.i) r6     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.location.zzbf r4 = com.google.android.gms.internal.location.zzbf.a((com.google.android.gms.location.ao) r4, (com.google.android.gms.internal.location.f) r5)     // Catch:{ all -> 0x00c5 }
            r6.a((com.google.android.gms.internal.location.zzbf) r4)     // Catch:{ all -> 0x00c5 }
            goto L_0x0018
        L_0x0037:
            java.util.Map<com.google.android.gms.common.api.internal.k$a<com.google.android.gms.location.e>, com.google.android.gms.internal.location.r> r3 = r1.f10387d     // Catch:{ all -> 0x00c5 }
            r3.clear()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00c5 }
            java.util.Map<com.google.android.gms.common.api.internal.k$a<com.google.android.gms.location.d>, com.google.android.gms.internal.location.n> r2 = r1.f10389f     // Catch:{ Exception -> 0x00c8 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x00c8 }
            java.util.Map<com.google.android.gms.common.api.internal.k$a<com.google.android.gms.location.d>, com.google.android.gms.internal.location.n> r3 = r1.f10389f     // Catch:{ all -> 0x00c2 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x00c2 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c2 }
        L_0x004a:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00c2 }
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.location.n r4 = (com.google.android.gms.internal.location.n) r4     // Catch:{ all -> 0x00c2 }
            if (r4 == 0) goto L_0x004a
            com.google.android.gms.internal.location.z<com.google.android.gms.internal.location.i> r6 = r1.f10384a     // Catch:{ all -> 0x00c2 }
            android.os.IInterface r6 = r6.a()     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.location.i r6 = (com.google.android.gms.internal.location.i) r6     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.location.zzbf r4 = com.google.android.gms.internal.location.zzbf.a((com.google.android.gms.location.al) r4, (com.google.android.gms.internal.location.f) r5)     // Catch:{ all -> 0x00c2 }
            r6.a((com.google.android.gms.internal.location.zzbf) r4)     // Catch:{ all -> 0x00c2 }
            goto L_0x004a
        L_0x0068:
            java.util.Map<com.google.android.gms.common.api.internal.k$a<com.google.android.gms.location.d>, com.google.android.gms.internal.location.n> r3 = r1.f10389f     // Catch:{ all -> 0x00c2 }
            r3.clear()     // Catch:{ all -> 0x00c2 }
            monitor-exit(r2)     // Catch:{ all -> 0x00c2 }
            java.util.Map<com.google.android.gms.common.api.internal.k$a<java.lang.Object>, com.google.android.gms.internal.location.q> r2 = r1.f10388e     // Catch:{ Exception -> 0x00c8 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x00c8 }
            java.util.Map<com.google.android.gms.common.api.internal.k$a<java.lang.Object>, com.google.android.gms.internal.location.q> r3 = r1.f10388e     // Catch:{ all -> 0x00bf }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x00bf }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00bf }
        L_0x007b:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x009f
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00bf }
            com.google.android.gms.internal.location.q r4 = (com.google.android.gms.internal.location.q) r4     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x007b
            com.google.android.gms.internal.location.z<com.google.android.gms.internal.location.i> r6 = r1.f10384a     // Catch:{ all -> 0x00bf }
            android.os.IInterface r6 = r6.a()     // Catch:{ all -> 0x00bf }
            com.google.android.gms.internal.location.i r6 = (com.google.android.gms.internal.location.i) r6     // Catch:{ all -> 0x00bf }
            com.google.android.gms.internal.location.zzo r7 = new com.google.android.gms.internal.location.zzo     // Catch:{ all -> 0x00bf }
            r8 = 2
            android.os.IBinder r4 = r4.asBinder()     // Catch:{ all -> 0x00bf }
            r7.<init>(r8, r5, r4, r5)     // Catch:{ all -> 0x00bf }
            r6.a((com.google.android.gms.internal.location.zzo) r7)     // Catch:{ all -> 0x00bf }
            goto L_0x007b
        L_0x009f:
            java.util.Map<com.google.android.gms.common.api.internal.k$a<java.lang.Object>, com.google.android.gms.internal.location.q> r1 = r1.f10388e     // Catch:{ all -> 0x00bf }
            r1.clear()     // Catch:{ all -> 0x00bf }
            monitor-exit(r2)     // Catch:{ all -> 0x00bf }
            com.google.android.gms.internal.location.m r1 = r9.f10396a     // Catch:{ Exception -> 0x00c8 }
            boolean r2 = r1.f10386c     // Catch:{ Exception -> 0x00c8 }
            if (r2 == 0) goto L_0x00c8
            com.google.android.gms.internal.location.z<com.google.android.gms.internal.location.i> r2 = r1.f10384a     // Catch:{ Exception -> 0x00c8 }
            r2.b()     // Catch:{ Exception -> 0x00c8 }
            com.google.android.gms.internal.location.z<com.google.android.gms.internal.location.i> r2 = r1.f10384a     // Catch:{ Exception -> 0x00c8 }
            android.os.IInterface r2 = r2.a()     // Catch:{ Exception -> 0x00c8 }
            com.google.android.gms.internal.location.i r2 = (com.google.android.gms.internal.location.i) r2     // Catch:{ Exception -> 0x00c8 }
            r2.m_()     // Catch:{ Exception -> 0x00c8 }
            r2 = 0
            r1.f10386c = r2     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00c8
        L_0x00bf:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00bf }
            throw r1     // Catch:{ Exception -> 0x00c8 }
        L_0x00c2:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00c2 }
            throw r1     // Catch:{ Exception -> 0x00c8 }
        L_0x00c5:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00c5 }
            throw r1     // Catch:{ Exception -> 0x00c8 }
        L_0x00c8:
            super.f()     // Catch:{ all -> 0x00cd }
            monitor-exit(r0)     // Catch:{ all -> 0x00cd }
            return
        L_0x00cd:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cd }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.t.f():void");
    }

    public final Location t() throws RemoteException {
        m mVar = this.f10396a;
        mVar.f10384a.b();
        return mVar.f10384a.a().a(mVar.f10385b.getPackageName());
    }

    public final void a(k.a<com.google.android.gms.location.d> aVar, f fVar) throws RemoteException {
        m mVar = this.f10396a;
        mVar.f10384a.b();
        s.a(aVar, (Object) "Invalid null listener key");
        synchronized (mVar.f10389f) {
            n remove = mVar.f10389f.remove(aVar);
            if (remove != null) {
                remove.a();
                mVar.f10384a.a().a(zzbf.a((al) remove, fVar));
            }
        }
    }
}
