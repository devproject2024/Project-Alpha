package com.paytm.notification.schedulers;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.u;
import androidx.work.v;
import com.paytm.notification.b.e;
import com.paytm.notification.schedulers.c;
import com.paytm.notification.schedulers.d;
import com.paytm.notification.schedulers.jobs.FetchConfig;
import com.paytm.notification.schedulers.jobs.FetchFlashMsgJob;
import com.paytm.notification.schedulers.jobs.FetchInboxMsgJob;
import com.paytm.notification.schedulers.jobs.GetFCMTokenJob;
import com.paytm.notification.schedulers.jobs.InboxMessageCountJob;
import com.paytm.notification.schedulers.jobs.LoginJob;
import com.paytm.notification.schedulers.jobs.LogoutJob;
import com.paytm.notification.schedulers.jobs.SyncFlashStatusJob;
import com.paytm.notification.schedulers.jobs.SyncInboxMsgStatusJob;
import kotlin.g.b.k;

public final class b extends a implements c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f43250b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static b f43251c;

    private b(Context context) {
        super(context);
    }

    public /* synthetic */ b(Context context, byte b2) {
        this(context);
    }

    public final LiveData<u> b() {
        b bVar = f43251c;
        if (bVar == null) {
            return null;
        }
        FetchConfig.a aVar = FetchConfig.f43309a;
        String a2 = FetchConfig.f43310b;
        d.a aVar2 = new d.a();
        c.a.C0730a aVar3 = c.a.f43288a;
        aVar2.f43305b = c.a.C0730a.c();
        c.b.a aVar4 = c.b.f43295a;
        aVar2.f43304a = c.b.a.a();
        return bVar.b(FetchConfig.class, a2, aVar2.b());
    }

    public final LiveData<u> c() {
        b bVar = f43251c;
        if (bVar == null) {
            return null;
        }
        d.a aVar = new d.a();
        c.a.C0730a aVar2 = c.a.f43288a;
        aVar.f43305b = c.a.C0730a.c();
        c.b.a aVar3 = c.b.f43295a;
        aVar.f43304a = c.b.a.b();
        return bVar.b(SyncFlashStatusJob.class, "flash_msg_status", aVar.b());
    }

    public final LiveData<u> d() {
        b bVar = f43251c;
        if (bVar == null) {
            return null;
        }
        FetchFlashMsgJob.a aVar = FetchFlashMsgJob.f43311a;
        String a2 = FetchFlashMsgJob.f43312b;
        d.a aVar2 = new d.a();
        c.a.C0730a aVar3 = c.a.f43288a;
        aVar2.f43305b = c.a.C0730a.c();
        c.b.a aVar4 = c.b.f43295a;
        aVar2.f43304a = c.b.a.a();
        return bVar.b(FetchFlashMsgJob.class, a2, aVar2.b());
    }

    public final LiveData<u> e() {
        b bVar = f43251c;
        if (bVar != null) {
            d.a aVar = new d.a();
            c.a.C0730a aVar2 = c.a.f43288a;
            aVar.f43305b = c.a.C0730a.c();
            c.b.a aVar3 = c.b.f43295a;
            aVar.f43304a = c.b.a.a();
            LiveData<u> b2 = bVar.b(FetchInboxMsgJob.class, "fetch_inbox_msg", aVar.b());
            if (b2 == null) {
                return null;
            }
            return b2;
        }
        return null;
    }

    public final LiveData<u> a(d dVar) {
        k.c(dVar, "strategy");
        b bVar = f43251c;
        if (bVar != null) {
            InboxMessageCountJob.a aVar = InboxMessageCountJob.f43319c;
            String a2 = InboxMessageCountJob.f43320e;
            d.a aVar2 = new d.a();
            aVar2.f43306c = dVar.f43301c;
            aVar2.f43305b = dVar.f43300b;
            aVar2.f43304a = dVar.f43299a;
            LiveData<u> b2 = bVar.b(InboxMessageCountJob.class, a2, aVar2.b());
            if (b2 == null) {
                return null;
            }
            return b2;
        }
        return null;
    }

    public final void f() {
        a("fetch_inbox_msg");
    }

    public final void g() {
        FetchFlashMsgJob.a aVar = FetchFlashMsgJob.f43311a;
        a(FetchFlashMsgJob.f43312b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f3, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized androidx.lifecycle.LiveData<androidx.work.u> b(java.lang.Class<? extends androidx.work.ListenableWorker> r6, java.lang.String r7, com.paytm.notification.schedulers.d r8) throws java.lang.Exception {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "jobClass"
            kotlin.g.b.k.c(r6, r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = "jobName"
            kotlin.g.b.k.c(r7, r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = "strategy"
            kotlin.g.b.k.c(r8, r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = "jobClass"
            kotlin.g.b.k.c(r6, r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r7, r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = "strategy"
            kotlin.g.b.k.c(r8, r0)     // Catch:{ all -> 0x00f4 }
            int r0 = r8.f43300b     // Catch:{ all -> 0x00f4 }
            com.paytm.notification.schedulers.c$a$a r1 = com.paytm.notification.schedulers.c.a.f43288a     // Catch:{ all -> 0x00f4 }
            int r1 = com.paytm.notification.schedulers.c.a.C0730a.a()     // Catch:{ all -> 0x00f4 }
            r2 = 0
            if (r0 != r1) goto L_0x0032
            super.a((java.lang.Class<? extends androidx.work.ListenableWorker>) r6, (java.lang.String) r7, (com.paytm.notification.schedulers.d) r8)     // Catch:{ all -> 0x00f4 }
            goto L_0x00f2
        L_0x0032:
            com.paytm.notification.schedulers.c$a$a r1 = com.paytm.notification.schedulers.c.a.f43288a     // Catch:{ all -> 0x00f4 }
            int r1 = com.paytm.notification.schedulers.c.a.C0730a.b()     // Catch:{ all -> 0x00f4 }
            if (r0 != r1) goto L_0x009f
            androidx.work.p$a r0 = new androidx.work.p$a     // Catch:{ all -> 0x00f4 }
            long r3 = r8.f43301c     // Catch:{ all -> 0x00f4 }
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ all -> 0x00f4 }
            r0.<init>(r6, r3, r8)     // Catch:{ all -> 0x00f4 }
            androidx.work.a r6 = androidx.work.a.LINEAR     // Catch:{ all -> 0x00f4 }
            r3 = 60000(0xea60, double:2.9644E-319)
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00f4 }
            androidx.work.w$a r6 = r0.a(r6, r3, r8)     // Catch:{ all -> 0x00f4 }
            androidx.work.p$a r6 = (androidx.work.p.a) r6     // Catch:{ all -> 0x00f4 }
            androidx.work.c$a r8 = new androidx.work.c$a     // Catch:{ all -> 0x00f4 }
            r8.<init>()     // Catch:{ all -> 0x00f4 }
            androidx.work.m r0 = androidx.work.m.CONNECTED     // Catch:{ all -> 0x00f4 }
            androidx.work.c$a r8 = r8.a(r0)     // Catch:{ all -> 0x00f4 }
            androidx.work.c$a r8 = r8.a()     // Catch:{ all -> 0x00f4 }
            androidx.work.c r8 = r8.b()     // Catch:{ all -> 0x00f4 }
            androidx.work.w$a r6 = r6.a((androidx.work.c) r8)     // Catch:{ all -> 0x00f4 }
            androidx.work.p$a r6 = (androidx.work.p.a) r6     // Catch:{ all -> 0x00f4 }
            androidx.work.w$a r6 = r6.a((java.lang.String) r7)     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = "PeriodicWorkRequest.Buil…          .addTag(jobTag)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)     // Catch:{ all -> 0x00f4 }
            androidx.work.p$a r6 = (androidx.work.p.a) r6     // Catch:{ all -> 0x00f4 }
            androidx.work.v r8 = super.a()     // Catch:{ all -> 0x00f4 }
            if (r8 == 0) goto L_0x007f
            com.google.b.a.a.a r7 = r8.c(r7)     // Catch:{ all -> 0x00f4 }
            goto L_0x0080
        L_0x007f:
            r7 = r2
        L_0x0080:
            if (r7 == 0) goto L_0x00f2
            java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x00f4 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x00f4 }
            if (r7 == 0) goto L_0x00f2
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x00f4 }
            r8 = 1
            if (r7 != r8) goto L_0x00f2
            androidx.work.v r7 = super.a()     // Catch:{ all -> 0x00f4 }
            if (r7 == 0) goto L_0x00f2
            androidx.work.w r6 = r6.c()     // Catch:{ all -> 0x00f4 }
            r7.a((androidx.work.w) r6)     // Catch:{ all -> 0x00f4 }
            goto L_0x00f2
        L_0x009f:
            com.paytm.notification.schedulers.c$a$a r1 = com.paytm.notification.schedulers.c.a.f43288a     // Catch:{ all -> 0x00f4 }
            int r1 = com.paytm.notification.schedulers.c.a.C0730a.d()     // Catch:{ all -> 0x00f4 }
            if (r0 != r1) goto L_0x00ab
            super.a((java.lang.Class<? extends androidx.work.ListenableWorker>) r6, (java.lang.String) r7, (com.paytm.notification.schedulers.d) r8)     // Catch:{ all -> 0x00f4 }
            goto L_0x00f2
        L_0x00ab:
            com.paytm.notification.schedulers.c$a$a r1 = com.paytm.notification.schedulers.c.a.f43288a     // Catch:{ all -> 0x00f4 }
            int r1 = com.paytm.notification.schedulers.c.a.C0730a.c()     // Catch:{ all -> 0x00f4 }
            if (r0 != r1) goto L_0x00f2
            long r0 = r8.f43303e     // Catch:{ all -> 0x00f4 }
            r2 = 10000(0x2710, double:4.9407E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x00bd
            long r2 = r8.f43303e     // Catch:{ all -> 0x00f4 }
        L_0x00bd:
            androidx.work.n$a r0 = new androidx.work.n$a     // Catch:{ all -> 0x00f4 }
            r0.<init>(r6)     // Catch:{ all -> 0x00f4 }
            androidx.work.a r6 = androidx.work.a.EXPONENTIAL     // Catch:{ all -> 0x00f4 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00f4 }
            androidx.work.w$a r6 = r0.a(r6, r2, r1)     // Catch:{ all -> 0x00f4 }
            androidx.work.n$a r6 = (androidx.work.n.a) r6     // Catch:{ all -> 0x00f4 }
            androidx.work.c$a r0 = new androidx.work.c$a     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            androidx.work.m r1 = androidx.work.m.CONNECTED     // Catch:{ all -> 0x00f4 }
            androidx.work.c$a r0 = r0.a(r1)     // Catch:{ all -> 0x00f4 }
            androidx.work.c r0 = r0.b()     // Catch:{ all -> 0x00f4 }
            androidx.work.w$a r6 = r6.a((androidx.work.c) r0)     // Catch:{ all -> 0x00f4 }
            androidx.work.n$a r6 = (androidx.work.n.a) r6     // Catch:{ all -> 0x00f4 }
            androidx.work.w$a r6 = r6.a((java.lang.String) r7)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = "OneTimeWorkRequest.Build…          .addTag(jobTag)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ all -> 0x00f4 }
            androidx.work.n$a r6 = (androidx.work.n.a) r6     // Catch:{ all -> 0x00f4 }
            androidx.lifecycle.LiveData r6 = super.a((java.lang.String) r7, (com.paytm.notification.schedulers.d) r8, (androidx.work.n.a) r6)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r5)
            return r6
        L_0x00f2:
            monitor-exit(r5)
            return r2
        L_0x00f4:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.schedulers.b.b(java.lang.Class, java.lang.String, com.paytm.notification.schedulers.d):androidx.lifecycle.LiveData");
    }

    public final void b(String str) {
        k.c(str, "jobName");
        try {
            a(str);
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
    }

    public final LiveData<u> i() throws Exception {
        b bVar = f43251c;
        if (bVar == null) {
            k.a();
        }
        SyncInboxMsgStatusJob.a aVar = SyncInboxMsgStatusJob.f43332a;
        String a2 = SyncInboxMsgStatusJob.f43333b;
        d.a aVar2 = new d.a();
        c.a.C0730a aVar3 = c.a.f43288a;
        aVar2.f43305b = c.a.C0730a.c();
        c.b.a aVar4 = c.b.f43295a;
        aVar2.f43304a = c.b.a.a();
        return bVar.b(SyncInboxMsgStatusJob.class, a2, aVar2.b());
    }

    public final LiveData<u> j() {
        b bVar = f43251c;
        if (bVar == null) {
            k.a();
        }
        LogoutJob.a aVar = LogoutJob.f43326c;
        String b2 = LogoutJob.f43327e;
        d.a aVar2 = new d.a();
        c.a.C0730a aVar3 = c.a.f43288a;
        aVar2.f43305b = c.a.C0730a.c();
        c.b.a aVar4 = c.b.f43295a;
        aVar2.f43304a = c.b.a.a();
        return bVar.b(LoginJob.class, b2, aVar2.a().b());
    }

    public final LiveData<u> k() {
        b bVar = f43251c;
        if (bVar == null) {
            k.a();
        }
        LogoutJob.a aVar = LogoutJob.f43326c;
        String b2 = LogoutJob.f43327e;
        d.a aVar2 = new d.a();
        c.a.C0730a aVar3 = c.a.f43288a;
        aVar2.f43305b = c.a.C0730a.c();
        c.b.a aVar4 = c.b.f43295a;
        aVar2.f43304a = c.b.a.a();
        return bVar.b(LogoutJob.class, b2, aVar2.a().b());
    }

    public final LiveData<u> l() throws Exception {
        b bVar = f43251c;
        if (bVar == null) {
            k.a();
        }
        d.a aVar = new d.a();
        c.a.C0730a aVar2 = c.a.f43288a;
        aVar.f43305b = c.a.C0730a.c();
        d.a a2 = aVar.a();
        c.b.a aVar3 = c.b.f43295a;
        a2.f43304a = c.b.a.b();
        return bVar.b(GetFCMTokenJob.class, "get_fcm_token", a2.b());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a() throws com.paytm.notification.a.a.a {
            if (b.f43251c != null) {
                return b.f43251c;
            }
            throw new com.paytm.notification.a.a.a("You need to call initScheduler() at least once to create the singleton");
        }
    }

    public final void h() {
        v a2 = super.a();
        if (a2 != null) {
            a2.b();
        }
    }
}
