package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.p;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.c;
import androidx.work.impl.f;
import androidx.work.impl.g;
import androidx.work.impl.j;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.l;
import androidx.work.o;
import java.util.HashSet;
import java.util.List;

public final class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private static final String f5433b = l.a("EnqueueRunnable");

    /* renamed from: a  reason: collision with root package name */
    public final c f5434a = new c();

    /* renamed from: c  reason: collision with root package name */
    private final g f5435c;

    public b(g gVar) {
        this.f5435c = gVar;
    }

    public final void run() {
        try {
            if (!g.a(this.f5435c, new HashSet())) {
                if (a()) {
                    e.a(this.f5435c.f5341a.f5359a, RescheduleReceiver.class, true);
                    j jVar = this.f5435c.f5341a;
                    f.a(jVar.f5360b, jVar.f5361c, jVar.f5363e);
                }
                this.f5434a.a(o.f5507a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.f5435c}));
        } catch (Throwable th) {
            this.f5434a.a(new o.a.C0079a(th));
        }
    }

    private boolean a() {
        WorkDatabase workDatabase = this.f5435c.f5341a.f5361c;
        workDatabase.beginTransaction();
        try {
            boolean a2 = a(this.f5435c);
            workDatabase.setTransactionSuccessful();
            return a2;
        } finally {
            workDatabase.endTransaction();
        }
    }

    private static boolean b(g gVar) {
        boolean a2 = a(gVar.f5341a, gVar.f5344d, (String[]) g.a(gVar).toArray(new String[0]), gVar.f5342b, gVar.f5343c);
        gVar.f5347g = true;
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01db A[LOOP:7: B:119:0x01d5->B:121:0x01db, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0208 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(androidx.work.impl.j r18, java.util.List<? extends androidx.work.w> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.g r22) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r22
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r0.f5361c
            r7 = 1
            if (r1 == 0) goto L_0x0016
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0016
            r9 = 1
            goto L_0x0017
        L_0x0016:
            r9 = 0
        L_0x0017:
            if (r9 == 0) goto L_0x0052
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x001e:
            if (r11 >= r10) goto L_0x0055
            r15 = r1[r11]
            androidx.work.impl.b.q r8 = r6.b()
            androidx.work.impl.b.p r8 = r8.b(r15)
            if (r8 != 0) goto L_0x003a
            androidx.work.l.a()
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r1 = 0
            r0[r1] = r15
            java.lang.String r2 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String.format(r2, r0)
            return r1
        L_0x003a:
            androidx.work.u$a r8 = r8.f5181b
            androidx.work.u$a r15 = androidx.work.u.a.SUCCEEDED
            if (r8 != r15) goto L_0x0042
            r15 = 1
            goto L_0x0043
        L_0x0042:
            r15 = 0
        L_0x0043:
            r12 = r12 & r15
            androidx.work.u$a r15 = androidx.work.u.a.FAILED
            if (r8 != r15) goto L_0x004a
            r14 = 1
            goto L_0x004f
        L_0x004a:
            androidx.work.u$a r15 = androidx.work.u.a.CANCELLED
            if (r8 != r15) goto L_0x004f
            r13 = 1
        L_0x004f:
            int r11 = r11 + 1
            goto L_0x001e
        L_0x0052:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0055:
            boolean r8 = android.text.TextUtils.isEmpty(r21)
            r8 = r8 ^ r7
            if (r8 == 0) goto L_0x0060
            if (r9 != 0) goto L_0x0060
            r10 = 1
            goto L_0x0061
        L_0x0060:
            r10 = 0
        L_0x0061:
            if (r10 == 0) goto L_0x0146
            androidx.work.impl.b.q r10 = r6.b()
            java.util.List r10 = r10.c(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x0146
            androidx.work.g r11 = androidx.work.g.APPEND
            if (r3 == r11) goto L_0x00c4
            androidx.work.g r11 = androidx.work.g.APPEND_OR_REPLACE
            if (r3 != r11) goto L_0x007a
            goto L_0x00c4
        L_0x007a:
            androidx.work.g r11 = androidx.work.g.KEEP
            if (r3 != r11) goto L_0x009f
            java.util.Iterator r3 = r10.iterator()
        L_0x0082:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x009f
            java.lang.Object r11 = r3.next()
            androidx.work.impl.b.p$a r11 = (androidx.work.impl.b.p.a) r11
            androidx.work.u$a r15 = r11.f5190b
            androidx.work.u$a r7 = androidx.work.u.a.ENQUEUED
            if (r15 == r7) goto L_0x009d
            androidx.work.u$a r7 = r11.f5190b
            androidx.work.u$a r11 = androidx.work.u.a.RUNNING
            if (r7 != r11) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r7 = 1
            goto L_0x0082
        L_0x009d:
            r7 = 0
            return r7
        L_0x009f:
            r7 = 0
            androidx.work.impl.utils.a r3 = androidx.work.impl.utils.a.a(r2, r0, r7)
            r3.run()
            androidx.work.impl.b.q r3 = r6.b()
            java.util.Iterator r10 = r10.iterator()
        L_0x00af:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00c1
            java.lang.Object r11 = r10.next()
            androidx.work.impl.b.p$a r11 = (androidx.work.impl.b.p.a) r11
            java.lang.String r11 = r11.f5189a
            r3.a((java.lang.String) r11)
            goto L_0x00af
        L_0x00c1:
            r3 = 1
            goto L_0x0147
        L_0x00c4:
            r7 = 0
            androidx.work.impl.b.b r9 = r6.c()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00d2:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x010e
            java.lang.Object r15 = r10.next()
            androidx.work.impl.b.p$a r15 = (androidx.work.impl.b.p.a) r15
            java.lang.String r7 = r15.f5189a
            boolean r7 = r9.c(r7)
            if (r7 != 0) goto L_0x0108
            androidx.work.u$a r7 = r15.f5190b
            r16 = r9
            androidx.work.u$a r9 = androidx.work.u.a.SUCCEEDED
            if (r7 != r9) goto L_0x00f0
            r7 = 1
            goto L_0x00f1
        L_0x00f0:
            r7 = 0
        L_0x00f1:
            r7 = r7 & r12
            androidx.work.u$a r9 = r15.f5190b
            androidx.work.u$a r12 = androidx.work.u.a.FAILED
            if (r9 != r12) goto L_0x00fa
            r14 = 1
            goto L_0x0101
        L_0x00fa:
            androidx.work.u$a r9 = r15.f5190b
            androidx.work.u$a r12 = androidx.work.u.a.CANCELLED
            if (r9 != r12) goto L_0x0101
            r13 = 1
        L_0x0101:
            java.lang.String r9 = r15.f5189a
            r11.add(r9)
            r12 = r7
            goto L_0x010a
        L_0x0108:
            r16 = r9
        L_0x010a:
            r9 = r16
            r7 = 0
            goto L_0x00d2
        L_0x010e:
            androidx.work.g r7 = androidx.work.g.APPEND_OR_REPLACE
            if (r3 != r7) goto L_0x013a
            if (r13 != 0) goto L_0x0116
            if (r14 == 0) goto L_0x013a
        L_0x0116:
            androidx.work.impl.b.q r3 = r6.b()
            java.util.List r7 = r3.c(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x0122:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0134
            java.lang.Object r9 = r7.next()
            androidx.work.impl.b.p$a r9 = (androidx.work.impl.b.p.a) r9
            java.lang.String r9 = r9.f5189a
            r3.a((java.lang.String) r9)
            goto L_0x0122
        L_0x0134:
            java.util.List r11 = java.util.Collections.emptyList()
            r13 = 0
            r14 = 0
        L_0x013a:
            java.lang.Object[] r1 = r11.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r3 = r1.length
            if (r3 <= 0) goto L_0x0145
            r9 = 1
            goto L_0x0146
        L_0x0145:
            r9 = 0
        L_0x0146:
            r3 = 0
        L_0x0147:
            java.util.Iterator r7 = r19.iterator()
        L_0x014b:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x020e
            java.lang.Object r10 = r7.next()
            androidx.work.w r10 = (androidx.work.w) r10
            androidx.work.impl.b.p r11 = r10.f5517b
            if (r9 == 0) goto L_0x0170
            if (r12 != 0) goto L_0x0170
            if (r14 == 0) goto L_0x0164
            androidx.work.u$a r15 = androidx.work.u.a.FAILED
            r11.f5181b = r15
            goto L_0x0178
        L_0x0164:
            if (r13 == 0) goto L_0x016b
            androidx.work.u$a r15 = androidx.work.u.a.CANCELLED
            r11.f5181b = r15
            goto L_0x0178
        L_0x016b:
            androidx.work.u$a r15 = androidx.work.u.a.BLOCKED
            r11.f5181b = r15
            goto L_0x0178
        L_0x0170:
            boolean r15 = r11.a()
            if (r15 != 0) goto L_0x017b
            r11.n = r4
        L_0x0178:
            r16 = r4
            goto L_0x0181
        L_0x017b:
            r16 = r4
            r4 = 0
            r11.n = r4
        L_0x0181:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x0191
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 25
            if (r4 > r5) goto L_0x0191
            a((androidx.work.impl.b.p) r11)
            goto L_0x01a2
        L_0x0191:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 22
            if (r4 > r5) goto L_0x01a2
            java.lang.String r4 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r4 = a(r0, r4)
            if (r4 == 0) goto L_0x01a2
            a((androidx.work.impl.b.p) r11)
        L_0x01a2:
            androidx.work.u$a r4 = r11.f5181b
            androidx.work.u$a r5 = androidx.work.u.a.ENQUEUED
            if (r4 != r5) goto L_0x01a9
            r3 = 1
        L_0x01a9:
            androidx.work.impl.b.q r4 = r6.b()
            r4.a((androidx.work.impl.b.p) r11)
            if (r9 == 0) goto L_0x01cf
            int r4 = r1.length
            r5 = 0
        L_0x01b4:
            if (r5 >= r4) goto L_0x01cf
            r11 = r1[r5]
            androidx.work.impl.b.a r15 = new androidx.work.impl.b.a
            java.util.UUID r0 = r10.f5516a
            java.lang.String r0 = r0.toString()
            r15.<init>(r0, r11)
            androidx.work.impl.b.b r0 = r6.c()
            r0.a((androidx.work.impl.b.a) r15)
            int r5 = r5 + 1
            r0 = r18
            goto L_0x01b4
        L_0x01cf:
            java.util.Set<java.lang.String> r0 = r10.f5518c
            java.util.Iterator r0 = r0.iterator()
        L_0x01d5:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01f4
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            androidx.work.impl.b.t r5 = r6.d()
            androidx.work.impl.b.s r11 = new androidx.work.impl.b.s
            java.util.UUID r15 = r10.f5516a
            java.lang.String r15 = r15.toString()
            r11.<init>(r4, r15)
            r5.a((androidx.work.impl.b.s) r11)
            goto L_0x01d5
        L_0x01f4:
            if (r8 == 0) goto L_0x0208
            androidx.work.impl.b.k r0 = r6.f()
            androidx.work.impl.b.j r4 = new androidx.work.impl.b.j
            java.util.UUID r5 = r10.f5516a
            java.lang.String r5 = r5.toString()
            r4.<init>(r2, r5)
            r0.a((androidx.work.impl.b.j) r4)
        L_0x0208:
            r0 = r18
            r4 = r16
            goto L_0x014b
        L_0x020e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.b.a(androidx.work.impl.j, java.util.List, java.lang.String[], java.lang.String, androidx.work.g):boolean");
    }

    private static void a(p pVar) {
        androidx.work.c cVar = pVar.j;
        if (cVar.f5076e || cVar.f5077f) {
            String str = pVar.f5182c;
            e.a aVar = new e.a();
            aVar.a(pVar.f5184e).a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f5182c = ConstraintTrackingWorker.class.getName();
            pVar.f5184e = aVar.a();
        }
    }

    private static boolean a(j jVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (androidx.work.impl.e eVar : jVar.f5363e) {
                if (cls.isAssignableFrom(eVar.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    private static boolean a(g gVar) {
        List<g> list = gVar.f5346f;
        boolean z = false;
        if (list != null) {
            boolean z2 = false;
            for (g next : list) {
                if (!next.f5347g) {
                    z2 |= a(next);
                } else {
                    l.a();
                    String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", next.f5345e)});
                }
            }
            z = z2;
        }
        return b(gVar) | z;
    }
}
