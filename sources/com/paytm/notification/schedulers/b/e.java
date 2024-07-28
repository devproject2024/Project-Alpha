package com.paytm.notification.schedulers.b;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import com.google.firebase.iid.w;
import com.paytm.notification.b.e;
import com.paytm.notification.data.c.h;
import com.paytm.notification.models.JOB_RESULT;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f43267a = new e();

    private e() {
    }

    public static final class b<TResult> implements c<w> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.notification.schedulers.c f43272a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f43273b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f43274c;

        public b(com.paytm.notification.schedulers.c cVar, Context context, h hVar) {
            this.f43272a = cVar;
            this.f43273b = context;
            this.f43274c = hVar;
        }

        public final void a(final Task<w> task) {
            k.c(task, "task");
            new Thread(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f43275a;

                {
                    this.f43275a = r1;
                }

                public final void run() {
                    Task task = task;
                    k.a((Object) task, "task");
                    if (task.c()) {
                        e.b bVar = com.paytm.notification.b.e.f43014a;
                        Task task2 = task;
                        k.a((Object) task2, "task");
                        bVar.a(task2.e(), "executeWithoutResult() - Firebase getInstanceId cancelled", new Object[0]);
                        return;
                    }
                    Task task3 = task;
                    k.a((Object) task3, "task");
                    String str = null;
                    if (!task3.b()) {
                        Task task4 = task;
                        k.a((Object) task4, "task");
                        Exception e2 = task4.e();
                        if (k.a((Object) e2 != null ? e2.getMessage() : null, (Object) "SERVICE_NOT_AVAILABLE")) {
                            e.b bVar2 = com.paytm.notification.b.e.f43014a;
                            Task task5 = task;
                            k.a((Object) task5, "task");
                            bVar2.a(task5.e(), "executeWithoutResult() - Firebase getInstanceId failed", new Object[0]);
                        } else {
                            com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
                            StringBuilder sb = new StringBuilder("GetToken Fail1: ");
                            Task task6 = task;
                            k.a((Object) task6, "task");
                            Exception e3 = task6.e();
                            if (e3 != null) {
                                str = e3.getMessage();
                            }
                            sb.append(str);
                            com.paytm.notification.b.a.c(sb.toString());
                            e.b bVar3 = com.paytm.notification.b.e.f43014a;
                            Task task7 = task;
                            k.a((Object) task7, "task");
                            bVar3.b(task7.e(), "executeWithoutResult() - Firebase getInstanceId failed", new Object[0]);
                        }
                        this.f43275a.f43272a.l();
                        return;
                    }
                    Task task8 = task;
                    k.a((Object) task8, "task");
                    w wVar = (w) task8.d();
                    if (wVar != null) {
                        str = wVar.b();
                    }
                    com.paytm.notification.b.e.f43014a.a("FCM Token: ".concat(String.valueOf(str)), new Object[0]);
                    com.paytm.notification.b.a aVar2 = com.paytm.notification.b.a.f42999a;
                    com.paytm.notification.b.a.b(str);
                    CharSequence charSequence = str;
                    if (charSequence == null || charSequence.length() == 0) {
                        com.paytm.notification.b.e.f43014a.d("executeWithoutResult() - Firebase has returned null token: ".concat(String.valueOf(str)), new Object[0]);
                        this.f43275a.f43272a.l();
                        return;
                    }
                    e eVar = e.f43267a;
                    if (e.a(this.f43275a.f43273b, str, this.f43275a.f43274c) == JOB_RESULT.RETRY) {
                        this.f43275a.f43272a.l();
                    }
                }
            }).start();
        }
    }

    public static final class a<TResult> implements c<w> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f43268a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.c f43269b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f43270c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f43271d;

        public a(d dVar, com.google.firebase.c cVar, Context context, h hVar) {
            this.f43268a = dVar;
            this.f43269b = cVar;
            this.f43270c = context;
            this.f43271d = hVar;
        }

        public final void a(final Task<w> task) {
            k.c(task, "task");
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new m<CoroutineScope, d<? super x>, Object>(this, (d) null) {
                int label;
                private CoroutineScope p$;
                final /* synthetic */ a this$0;

                {
                    this.this$0 = r1;
                }

                public final d<x> create(Object obj, d<?> dVar) {
                    k.c(dVar, "completion");
                    AnonymousClass1 r0 = 

                    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                        com.google.firebase.c.a(r10, new com.google.firebase.g(r1.f38762b, r1.f38761a, r1.f38763c, r1.f38764d, r1.f38765e, r1.f38766f, r1.f38767g, (byte) 0), "paytm_firebase");
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
                        r10 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
                        com.paytm.notification.b.e.f43014a.b(r10, "getFireBaseApp() - FirebaseApp.getInstance() fail", new java.lang.Object[0]);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
                        return null;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
                        return com.google.firebase.c.a("paytm_firebase");
                     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x004a */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public static com.google.firebase.c a(android.content.Context r10, com.paytm.notification.data.c.h r11) {
                        /*
                            java.lang.String r0 = "paytm_firebase"
                            com.paytm.notification.models.NotificationProjectConfig r11 = r11.g()
                            if (r11 == 0) goto L_0x0076
                            com.google.firebase.g$a r1 = new com.google.firebase.g$a
                            r1.<init>()
                            java.lang.String r2 = r11.getAppKey$paytmnotification_paytmRelease()
                            if (r2 != 0) goto L_0x0016
                            kotlin.g.b.k.a()
                        L_0x0016:
                            java.lang.String r3 = "ApplicationId must be set."
                            java.lang.String r2 = com.google.android.gms.common.internal.s.a((java.lang.String) r2, (java.lang.Object) r3)
                            r1.f38762b = r2
                            java.lang.String r2 = r11.getAppId$paytmnotification_paytmRelease()
                            if (r2 != 0) goto L_0x0027
                            kotlin.g.b.k.a()
                        L_0x0027:
                            r1.f38767g = r2
                            java.lang.String r2 = r11.getApiKey$paytmnotification_paytmRelease()
                            if (r2 != 0) goto L_0x0032
                            kotlin.g.b.k.a()
                        L_0x0032:
                            java.lang.String r3 = "ApiKey must be set."
                            java.lang.String r2 = com.google.android.gms.common.internal.s.a((java.lang.String) r2, (java.lang.Object) r3)
                            r1.f38761a = r2
                            java.lang.String r11 = r11.getSenderId$paytmnotification_paytmRelease()
                            r1.f38765e = r11
                            java.lang.String r11 = "FirebaseOptions.Builder(…enderId(options.senderId)"
                            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
                            com.google.firebase.c r10 = com.google.firebase.c.a((java.lang.String) r0)     // Catch:{ IllegalStateException -> 0x004a }
                            goto L_0x0075
                        L_0x004a:
                            com.google.firebase.g r11 = new com.google.firebase.g     // Catch:{ Exception -> 0x0067 }
                            java.lang.String r2 = r1.f38762b     // Catch:{ Exception -> 0x0067 }
                            java.lang.String r3 = r1.f38761a     // Catch:{ Exception -> 0x0067 }
                            java.lang.String r4 = r1.f38763c     // Catch:{ Exception -> 0x0067 }
                            java.lang.String r5 = r1.f38764d     // Catch:{ Exception -> 0x0067 }
                            java.lang.String r6 = r1.f38765e     // Catch:{ Exception -> 0x0067 }
                            java.lang.String r7 = r1.f38766f     // Catch:{ Exception -> 0x0067 }
                            java.lang.String r8 = r1.f38767g     // Catch:{ Exception -> 0x0067 }
                            r9 = 0
                            r1 = r11
                            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0067 }
                            com.google.firebase.c.a(r10, r11, r0)     // Catch:{ Exception -> 0x0067 }
                            com.google.firebase.c r10 = com.google.firebase.c.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0067 }
                            goto L_0x0075
                        L_0x0067:
                            r10 = move-exception
                            com.paytm.notification.b.e$b r11 = com.paytm.notification.b.e.f43014a
                            java.lang.Throwable r10 = (java.lang.Throwable) r10
                            r0 = 0
                            java.lang.Object[] r0 = new java.lang.Object[r0]
                            java.lang.String r1 = "getFireBaseApp() - FirebaseApp.getInstance() fail"
                            r11.b(r10, r1, r0)
                            r10 = 0
                        L_0x0075:
                            return r10
                        L_0x0076:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r11 = "Config options are not initialized"
                            r10.<init>(r11)
                            java.lang.Throwable r10 = (java.lang.Throwable) r10
                            throw r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.schedulers.b.e.a(android.content.Context, com.paytm.notification.data.c.h):com.google.firebase.c");
                    }

                    public static JOB_RESULT a(Context context, String str, h hVar) throws Exception {
                        k.c(context, "context");
                        k.c(str, "updateToken");
                        k.c(hVar, "pushConfigRepo");
                        String b2 = hVar.b();
                        boolean z = false;
                        if (b2 == null || (!k.a((Object) b2, (Object) str))) {
                            if (b2 != null) {
                                long c2 = hVar.c();
                                if (c2 <= 0) {
                                    com.paytm.notification.b.e.f43014a.d("(Not an Error) New Updated FCM token generated. Time diff: (unknown)", new Object[0]);
                                } else {
                                    long currentTimeMillis = System.currentTimeMillis() - c2;
                                    e.b bVar = com.paytm.notification.b.e.f43014a;
                                    StringBuilder sb = new StringBuilder("(Not an Error) New Updated FCM token generated. Time diff: ");
                                    com.paytm.notification.c.a aVar = com.paytm.notification.c.a.f43021a;
                                    sb.append(com.paytm.notification.c.a.a(currentTimeMillis));
                                    bVar.d(sb.toString(), new Object[0]);
                                }
                            }
                            hVar.b(str);
                            com.paytm.notification.b.e.f43014a.a("New token generated".concat(String.valueOf(str)), new Object[0]);
                            return g.f43280a.a(context, str, hVar);
                        }
                        if (hVar.a().handleLogin()) {
                            if (hVar.b() != null && (!hVar.d() || (!hVar.e() && hVar.a().getCustomerId$paytmnotification_paytmRelease() != null))) {
                                z = true;
                            }
                            if (z) {
                                return g.f43280a.a(context, str, hVar);
                            }
                        }
                        if (hVar.a().handleLogin() || hVar.d()) {
                            return JOB_RESULT.SUCCESS;
                        }
                        return g.f43280a.a(context, str, hVar);
                    }
                }
