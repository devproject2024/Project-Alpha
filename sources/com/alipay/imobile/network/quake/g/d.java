package com.alipay.imobile.network.quake.g;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alipay.imobile.network.quake.c;
import com.alipay.imobile.network.quake.e;
import com.alipay.mobile.framework.b.a.b;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class d implements InvocationHandler {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<Object> f14794a = new ThreadLocal<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Map<String, Object>> f14795b = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    private static e.a f14796f = new e.a() {
        public final void a(e eVar) throws com.alipay.mobile.b.b.a {
            if (eVar instanceof e) {
                d.a((e) eVar);
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Class f14797c;

    /* renamed from: d  reason: collision with root package name */
    private a f14798d;

    /* renamed from: e  reason: collision with root package name */
    private com.alipay.imobile.network.quake.a f14799e = this.f14798d.a();

    /* renamed from: g  reason: collision with root package name */
    private com.alipay.imobile.network.quake.d f14800g = this.f14799e.a();

    /* renamed from: h  reason: collision with root package name */
    private com.alipay.imobile.network.quake.d f14801h;

    interface a {
        boolean a(c cVar) throws com.alipay.mobile.b.b.a;
    }

    public d(a aVar, Class cls) {
        this.f14797c = cls;
        this.f14798d = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r1 = r7.a(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.annotation.Annotation[] r6, com.alipay.imobile.network.quake.g.d.a r7) throws com.alipay.mobile.b.b.a {
        /*
            r5 = this;
            int r0 = r6.length
            r1 = 1
            r2 = 0
        L_0x0003:
            if (r2 >= r0) goto L_0x001e
            r3 = r6[r2]
            java.lang.Class r3 = r3.annotationType()
            if (r3 == 0) goto L_0x001b
            com.alipay.imobile.network.quake.g.a r4 = r5.f14798d
            com.alipay.imobile.network.quake.g.c r3 = r4.a(r3)
            if (r3 == 0) goto L_0x001b
            boolean r1 = r7.a(r3)
            if (r1 == 0) goto L_0x001e
        L_0x001b:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x001e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.g.d.a(java.lang.annotation.Annotation[], com.alipay.imobile.network.quake.g.d$a):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ef A[Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f3 A[Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0236 A[Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0279 A[Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0285 A[Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b9 A[Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02c7 A[SYNTHETIC, Splitter:B:122:0x02c7] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0107 A[Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0112 A[Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012c A[Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0133 A[Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142 A[Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0147 A[Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0190 A[Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01c0 A[Catch:{ InterruptedException -> 0x01d1, ExecutionException -> 0x01cd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object invoke(java.lang.Object r23, java.lang.reflect.Method r24, java.lang.Object[] r25) throws com.alipay.mobile.b.b.a {
        /*
            r22 = this;
            r8 = r22
            r9 = r24
            r10 = r25
            monitor-enter(r22)
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x02d0 }
            long r11 = r0.getId()     // Catch:{ all -> 0x02d0 }
            java.lang.String r13 = r24.getName()     // Catch:{ all -> 0x02d0 }
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x02d0 }
            java.lang.String r0 = "ThreadId=[%d]  invoke.object=[%s]  methodName=[%s]"
            r14 = 3
            java.lang.Object[] r1 = new java.lang.Object[r14]     // Catch:{ all -> 0x02d0 }
            java.lang.Long r2 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x02d0 }
            r15 = 0
            r1[r15] = r2     // Catch:{ all -> 0x02d0 }
            java.lang.Class r2 = r24.getDeclaringClass()     // Catch:{ all -> 0x02d0 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x02d0 }
            r7 = 1
            r1[r7] = r2     // Catch:{ all -> 0x02d0 }
            r16 = 2
            r1[r16] = r13     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.c.a(r0, r1)     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x02d0 }
            boolean r0 = com.alipay.imobile.network.quake.i.g.a()     // Catch:{ all -> 0x02d0 }
            if (r0 != 0) goto L_0x02c8
            java.lang.String r0 = "toString"
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x02d0 }
            r17 = 9
            if (r0 == 0) goto L_0x008b
            java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ all -> 0x02d0 }
            r0.<init>()     // Catch:{ all -> 0x02d0 }
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()     // Catch:{ all -> 0x02d0 }
            int r1 = r0.length     // Catch:{ all -> 0x02d0 }
            if (r1 <= r7) goto L_0x0087
        L_0x0053:
            if (r7 >= r1) goto L_0x0087
            r2 = r0[r7]     // Catch:{ all -> 0x02d0 }
            java.lang.String r3 = r2.getClassName()     // Catch:{ all -> 0x02d0 }
            java.lang.Class<com.alipay.imobile.network.quake.g.d> r4 = com.alipay.imobile.network.quake.g.d.class
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x02d0 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x02d0 }
            if (r3 != 0) goto L_0x0076
            java.lang.String r3 = "invoke"
            java.lang.String r2 = r2.getMethodName()     // Catch:{ all -> 0x02d0 }
            boolean r2 = r3.equals(r2)     // Catch:{ all -> 0x02d0 }
            if (r2 != 0) goto L_0x0076
            int r7 = r7 + 1
            goto L_0x0053
        L_0x0076:
            java.lang.String r0 = "Do not call proxy.toString() in the RpcInterceptor"
            java.lang.String r1 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ all -> 0x02d0 }
            com.alipay.mobile.b.b.a r1 = new com.alipay.mobile.b.b.a     // Catch:{ all -> 0x02d0 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x02d0 }
            r1.<init>((java.lang.Integer) r2, (java.lang.String) r0)     // Catch:{ all -> 0x02d0 }
            throw r1     // Catch:{ all -> 0x02d0 }
        L_0x0087:
            java.lang.String r0 = ""
            monitor-exit(r22)
            return r0
        L_0x008b:
            java.lang.String r0 = "getRpcConfig"
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x02d0 }
            if (r0 == 0) goto L_0x00a4
            com.alipay.imobile.network.quake.d r0 = r8.f14801h     // Catch:{ all -> 0x02d0 }
            if (r0 != 0) goto L_0x00a0
            com.alipay.imobile.network.quake.d r0 = new com.alipay.imobile.network.quake.d     // Catch:{ all -> 0x02d0 }
            com.alipay.imobile.network.quake.d r1 = r8.f14800g     // Catch:{ all -> 0x02d0 }
            r0.<init>(r1)     // Catch:{ all -> 0x02d0 }
            r8.f14801h = r0     // Catch:{ all -> 0x02d0 }
        L_0x00a0:
            com.alipay.imobile.network.quake.d r0 = r8.f14801h     // Catch:{ all -> 0x02d0 }
            monitor-exit(r22)
            return r0
        L_0x00a4:
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02d0 }
            java.lang.ThreadLocal<java.lang.Object> r0 = f14794a     // Catch:{ all -> 0x02d0 }
            r6 = 0
            r0.set(r6)     // Catch:{ all -> 0x02d0 }
            java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> r0 = f14795b     // Catch:{ all -> 0x02d0 }
            r0.set(r6)     // Catch:{ all -> 0x02d0 }
            java.lang.Class r4 = r8.f14797c     // Catch:{ all -> 0x02d0 }
            java.lang.annotation.Annotation[] r0 = r24.getAnnotations()     // Catch:{ all -> 0x02d0 }
            com.alipay.imobile.network.quake.g.d$2 r5 = new com.alipay.imobile.network.quake.g.d$2     // Catch:{ all -> 0x02d0 }
            r1 = r5
            r2 = r22
            r3 = r23
            r14 = r5
            r5 = r24
            r20 = r6
            r6 = r25
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x02d0 }
            r8.a(r0, r14)     // Catch:{ all -> 0x02d0 }
            com.alipay.imobile.network.quake.f r0 = new com.alipay.imobile.network.quake.f     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            r0.<init>()     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            com.alipay.imobile.network.quake.g.e r6 = new com.alipay.imobile.network.quake.g.e     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            if (r1 == 0) goto L_0x00e3
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            java.lang.String r1 = r1.f14747d     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            if (r2 != 0) goto L_0x00e3
            goto L_0x00e7
        L_0x00e3:
            com.alipay.imobile.network.quake.d r1 = r8.f14800g     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            java.lang.String r1 = r1.f14747d     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
        L_0x00e7:
            r6.<init>(r1, r0, r0)     // Catch:{ InterruptedException -> 0x01fd, ExecutionException -> 0x01e1 }
            com.alipay.imobile.network.quake.a r1 = r8.f14799e     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            java.lang.String r1 = r1.d()     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            r6.c(r1)     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            com.alipay.imobile.network.quake.a r1 = r8.f14799e     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            java.lang.String r1 = r1.b()     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            r6.d(r1)     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            com.alipay.imobile.network.quake.a r1 = r8.f14799e     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            java.lang.String r1 = r1.c()     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            r6.e(r1)     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            if (r9 == 0) goto L_0x0109
            r6.w = r9     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
        L_0x0109:
            r6.p = r10     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            if (r1 != 0) goto L_0x0112
        L_0x010f:
            r2 = r20
            goto L_0x0126
        L_0x0112:
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            java.lang.String r1 = r1.f14745b     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            if (r2 == 0) goto L_0x011d
            goto L_0x010f
        L_0x011d:
            com.alipay.imobile.network.quake.i.b$a r2 = new com.alipay.imobile.network.quake.i.b$a     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            com.alipay.imobile.network.quake.d r3 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            java.lang.String r3 = r3.f14746c     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            r2.<init>(r1, r3)     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
        L_0x0126:
            r6.v = r2     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            if (r1 == 0) goto L_0x0133
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
        L_0x012e:
            com.alipay.imobile.network.quake.h.c.b r1 = r1.a()     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            goto L_0x0136
        L_0x0133:
            com.alipay.imobile.network.quake.d r1 = r8.f14800g     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            goto L_0x012e
        L_0x0136:
            r6.m = r1     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            if (r1 == 0) goto L_0x0147
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            java.util.Map<java.lang.String, java.lang.String> r1 = r1.k     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            if (r1 == 0) goto L_0x0147
            com.alipay.imobile.network.quake.d r1 = r8.f14801h     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            java.util.Map<java.lang.String, java.lang.String> r1 = r1.k     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            goto L_0x0149
        L_0x0147:
            r1 = r20
        L_0x0149:
            if (r1 == 0) goto L_0x0152
            if (r1 == 0) goto L_0x0152
            java.util.Map<java.lang.String, java.lang.String> r2 = r6.t     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            r2.putAll(r1)     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
        L_0x0152:
            java.lang.String r1 = com.alipay.imobile.network.quake.g.f.a(r24)     // Catch:{ InterruptedException -> 0x01dd, ExecutionException -> 0x01d9 }
            if (r1 == 0) goto L_0x0190
            java.lang.String r2 = "alipay.client.executerpc"
            boolean r2 = android.text.TextUtils.equals(r1, r2)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            if (r2 == 0) goto L_0x0174
            r2 = r10[r15]     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            int r2 = r10.length     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            if (r2 <= r7) goto L_0x0174
            r2 = r10[r7]     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r6.p = r2     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.String r2 = "alipay.client.executerpc"
            r6.c(r2)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r6.y = r7     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
        L_0x0174:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.Class r3 = r8.f14797c     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r2.append(r3)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r2.append(r1)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r6.o = r2     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            if (r1 == 0) goto L_0x01ab
            r6.x = r1     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            goto L_0x01ab
        L_0x0190:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.Class r3 = r8.f14797c     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r2.append(r3)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.String r3 = r24.getName()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r2.append(r3)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r6.o = r2     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
        L_0x01ab:
            com.alipay.imobile.network.quake.e$a r2 = f14796f     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r6.f14774f = r2     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            com.alipay.imobile.network.quake.a r2 = r8.f14799e     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            r2.a((com.alipay.imobile.network.quake.e) r6)     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.Object r2 = r0.get()     // Catch:{ InterruptedException -> 0x01d7, ExecutionException -> 0x01d5 }
            java.lang.reflect.Type r0 = r24.getGenericReturnType()     // Catch:{ InterruptedException -> 0x01d1, ExecutionException -> 0x01cd }
            java.lang.Class r3 = java.lang.Void.TYPE     // Catch:{ InterruptedException -> 0x01d1, ExecutionException -> 0x01cd }
            if (r0 == r3) goto L_0x01c5
            java.lang.ThreadLocal<java.lang.Object> r0 = f14794a     // Catch:{ InterruptedException -> 0x01d1, ExecutionException -> 0x01cd }
            r0.set(r2)     // Catch:{ InterruptedException -> 0x01d1, ExecutionException -> 0x01cd }
        L_0x01c5:
            r14 = r1
            r20 = r2
            r0 = r6
            r21 = 1
            goto L_0x0238
        L_0x01cd:
            r0 = move-exception
            r20 = r2
            goto L_0x01e5
        L_0x01d1:
            r0 = move-exception
            r20 = r2
            goto L_0x0201
        L_0x01d5:
            r0 = move-exception
            goto L_0x01e5
        L_0x01d7:
            r0 = move-exception
            goto L_0x0201
        L_0x01d9:
            r0 = move-exception
            r1 = r20
            goto L_0x01e5
        L_0x01dd:
            r0 = move-exception
            r1 = r20
            goto L_0x0201
        L_0x01e1:
            r0 = move-exception
            r1 = r20
            r6 = r1
        L_0x01e5:
            java.lang.Throwable r0 = r0.getCause()     // Catch:{ all -> 0x02d0 }
            if (r0 == 0) goto L_0x01f3
            boolean r2 = r0 instanceof com.alipay.mobile.b.b.a     // Catch:{ all -> 0x02d0 }
            if (r2 == 0) goto L_0x01f3
            com.alipay.mobile.b.b.a r0 = (com.alipay.mobile.b.b.a) r0     // Catch:{ all -> 0x02d0 }
            r14 = r1
            goto L_0x020e
        L_0x01f3:
            com.alipay.imobile.network.quake.c.a r2 = new com.alipay.imobile.network.quake.c.a     // Catch:{ all -> 0x02d0 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x02d0 }
            r2.<init>((java.lang.Integer) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02d0 }
            goto L_0x020c
        L_0x01fd:
            r0 = move-exception
            r1 = r20
            r6 = r1
        L_0x0201:
            com.alipay.imobile.network.quake.c.a r2 = new com.alipay.imobile.network.quake.c.a     // Catch:{ all -> 0x02d0 }
            r3 = 13
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x02d0 }
            r2.<init>((java.lang.Integer) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02d0 }
        L_0x020c:
            r14 = r1
            r0 = r2
        L_0x020e:
            r17 = r6
            java.lang.String r1 = com.alipay.imobile.network.quake.g.f.a(r24)     // Catch:{ all -> 0x02d0 }
            r0.setOperationType(r1)     // Catch:{ all -> 0x02d0 }
            java.lang.Class r4 = r8.f14797c     // Catch:{ all -> 0x02d0 }
            java.lang.annotation.Annotation[] r6 = r24.getAnnotations()     // Catch:{ all -> 0x02d0 }
            com.alipay.imobile.network.quake.g.d$4 r5 = new com.alipay.imobile.network.quake.g.d$4     // Catch:{ all -> 0x02d0 }
            r1 = r5
            r2 = r22
            r3 = r23
            r15 = r5
            r5 = r24
            r9 = r6
            r6 = r25
            r21 = 1
            r7 = r0
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x02d0 }
            boolean r1 = r8.a(r9, r15)     // Catch:{ all -> 0x02d0 }
            if (r1 != 0) goto L_0x02c7
            r0 = r17
        L_0x0238:
            java.lang.Class r4 = r8.f14797c     // Catch:{ all -> 0x02d0 }
            java.lang.annotation.Annotation[] r7 = r24.getAnnotations()     // Catch:{ all -> 0x02d0 }
            com.alipay.imobile.network.quake.g.d$3 r9 = new com.alipay.imobile.network.quake.g.d$3     // Catch:{ all -> 0x02d0 }
            r1 = r9
            r2 = r22
            r3 = r23
            r5 = r24
            r6 = r25
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x02d0 }
            r8.a(r7, r9)     // Catch:{ all -> 0x02d0 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02d0 }
            long r1 = r1 - r18
            java.lang.String r3 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x02d0 }
            java.lang.String r3 = "ThreadId=[%d] methodName=[%s] invokeTiming=[%d]"
            r4 = 3
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x02d0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x02d0 }
            r6 = 0
            r5[r6] = r4     // Catch:{ all -> 0x02d0 }
            r5[r21] = r13     // Catch:{ all -> 0x02d0 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x02d0 }
            r5[r16] = r1     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.c.a(r3, r5)     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.c.e()     // Catch:{ all -> 0x02d0 }
            java.lang.ThreadLocal<java.lang.Object> r1 = f14794a     // Catch:{ all -> 0x02d0 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x02d0 }
            if (r1 == 0) goto L_0x027f
            java.lang.ThreadLocal<java.lang.Object> r1 = f14794a     // Catch:{ all -> 0x02d0 }
            java.lang.Object r20 = r1.get()     // Catch:{ all -> 0x02d0 }
        L_0x027f:
            boolean r1 = com.alipay.iap.android.common.b.c.a()     // Catch:{ all -> 0x02d0 }
            if (r1 == 0) goto L_0x029d
            java.lang.String r1 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x02d0 }
            java.lang.String r1 = "ThreadId=[%d] methodName=[%s] returnObj=[%s]"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x02d0 }
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x02d0 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x02d0 }
            r2[r21] = r13     // Catch:{ all -> 0x02d0 }
            r2[r16] = r20     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.c.a(r1, r2)     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.c.c()     // Catch:{ all -> 0x02d0 }
        L_0x029d:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x02d0 }
            r2 = 4
            r1.<init>(r2)     // Catch:{ all -> 0x02d0 }
            java.lang.String r2 = "duration"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02d0 }
            long r3 = r3 - r18
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x02d0 }
            r1.put(r2, r3)     // Catch:{ all -> 0x02d0 }
            java.lang.String r2 = "operation_type"
            r1.put(r2, r14)     // Catch:{ all -> 0x02d0 }
            if (r0 == 0) goto L_0x02bf
            r0.b((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ all -> 0x02d0 }
            r0.a((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ all -> 0x02d0 }
        L_0x02bf:
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02d0 }
            com.alipay.iap.android.common.b.d.a()     // Catch:{ all -> 0x02d0 }
            monitor-exit(r22)
            return r20
        L_0x02c7:
            throw r0     // Catch:{ all -> 0x02d0 }
        L_0x02c8:
            java.lang.IllegalThreadStateException r0 = new java.lang.IllegalThreadStateException     // Catch:{ all -> 0x02d0 }
            java.lang.String r1 = "can't call rpc in main thread."
            r0.<init>(r1)     // Catch:{ all -> 0x02d0 }
            throw r0     // Catch:{ all -> 0x02d0 }
        L_0x02d0:
            r0 = move-exception
            monitor-exit(r22)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.g.d.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    static /* synthetic */ void a(e eVar) throws com.alipay.mobile.b.b.a {
        Method method;
        String str = c.f14737a;
        com.alipay.iap.android.common.b.c.e();
        if (eVar != null && (method = eVar.w) != null) {
            try {
                b bVar = (b) method.getAnnotation(b.class);
                if (bVar != null) {
                    String d2 = eVar.d();
                    if (com.alipay.imobile.network.quake.h.c.c.a(d2) && ((com.alipay.mobile.framework.b.a.a) method.getAnnotation(com.alipay.mobile.framework.b.a.a.class)) != null) {
                        String cookie = CookieManager.getInstance().getCookie(d2);
                        if (TextUtils.isEmpty(cookie)) {
                            String str2 = c.f14737a;
                            StringBuilder sb = new StringBuilder("CheckLogin_prejudge: cookie is empty  API=[");
                            sb.append(bVar.a());
                            sb.append("]");
                            com.alipay.iap.android.common.b.c.g();
                            throw new com.alipay.imobile.network.quake.c.c(Integer.valueOf(H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY), "Session is timeout, please login again");
                        } else if (!cookie.contains("ALIPAYJSESSIONID")) {
                            String str3 = c.f14737a;
                            StringBuilder sb2 = new StringBuilder("CheckLogin_prejudge: cookie not contains ALIPAYJSESSIONID!  API=[");
                            sb2.append(bVar.a());
                            sb2.append("]");
                            com.alipay.iap.android.common.b.c.g();
                            throw new com.alipay.imobile.network.quake.c.c(Integer.valueOf(H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY), "Session is timeout, please login again");
                        }
                    }
                }
            } catch (Exception unused) {
                String str4 = c.f14737a;
                com.alipay.iap.android.common.b.c.j();
            }
        }
    }
}
