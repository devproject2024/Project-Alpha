package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.syncsdk.e.h;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15114a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private volatile b f15115b = b.INIT;

    public final synchronized void a() {
        this.f15115b = b.INIT;
        String str = f15114a;
        h.b(str, "toInitState [ currState=" + this.f15115b + " ]");
    }

    public final synchronized b b() {
        String str = f15114a;
        h.b(str, "getCurrState [ currState=" + this.f15115b + " ]");
        return this.f15115b;
    }

    public final synchronized void c() {
        int i2 = e.f15140a[this.f15115b.ordinal()];
        if (i2 == 2) {
            this.f15115b = b.DEVICE_BINDED;
        } else if (i2 == 3) {
            this.f15115b = b.USER_BINDED;
        } else if (i2 == 4) {
            this.f15115b = b.REGISTERED;
        } else if (i2 == 5) {
            this.f15115b = b.DEVICE_BINDED;
        } else {
            String str = f15114a;
            h.d(str, "onRecvRegisterReply: [state error] [ currState=" + this.f15115b + " ]");
            throw new Exception("");
        }
        String str2 = f15114a;
        h.b(str2, "onRecvRegisterReply [ currState=" + this.f15115b + " ]");
    }

    public final synchronized void d() {
        this.f15115b = b.CONNECTED;
        String str = f15114a;
        h.b(str, "onConnectSucceeded [ currState=" + this.f15115b + " ]");
    }

    public final synchronized void e() {
        this.f15115b = b.WAIT_REGISTERED;
        String str = f15114a;
        h.b(str, "onRegisterSended [ currState=" + this.f15115b + " ]");
    }

    public final synchronized void f() {
        this.f15115b = b.WAIT_DEVICE_BINDED;
        String str = f15114a;
        h.b(str, "onDeviceBindSended [ currState=" + this.f15115b + " ]");
    }

    public final synchronized void g() {
        this.f15115b = b.WAIT_USER_BINDED;
        String str = f15114a;
        h.b(str, "onUserBindSended [ currState=" + this.f15115b + " ]");
    }

    public final synchronized void h() {
        this.f15115b = b.WAIT_USER_UNBINDED;
        String str = f15114a;
        h.b(str, "onUserUnBindSended [ currState=" + this.f15115b + " ]");
    }

    public final synchronized boolean i() {
        return this.f15115b != b.INIT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean j() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.alipay.mobile.rome.syncsdk.service.b r0 = r5.f15115b     // Catch:{ all -> 0x0028 }
            com.alipay.mobile.rome.syncsdk.service.b r1 = com.alipay.mobile.rome.syncsdk.service.b.DEVICE_BINDED     // Catch:{ all -> 0x0028 }
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            com.alipay.mobile.rome.syncsdk.service.b r1 = r5.f15115b     // Catch:{ all -> 0x0028 }
            com.alipay.mobile.rome.syncsdk.service.b r4 = com.alipay.mobile.rome.syncsdk.service.b.WAIT_USER_BINDED     // Catch:{ all -> 0x0028 }
            if (r1 == r4) goto L_0x001b
            com.alipay.mobile.rome.syncsdk.service.b r1 = r5.f15115b     // Catch:{ all -> 0x0028 }
            com.alipay.mobile.rome.syncsdk.service.b r4 = com.alipay.mobile.rome.syncsdk.service.b.USER_BINDED     // Catch:{ all -> 0x0028 }
            if (r1 != r4) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r1 = 0
            goto L_0x001c
        L_0x001b:
            r1 = 1
        L_0x001c:
            r0 = r0 | r1
            com.alipay.mobile.rome.syncsdk.service.b r1 = r5.f15115b     // Catch:{ all -> 0x0028 }
            com.alipay.mobile.rome.syncsdk.service.b r4 = com.alipay.mobile.rome.syncsdk.service.b.REGISTERED     // Catch:{ all -> 0x0028 }
            if (r1 != r4) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r0 = r0 | r2
            monitor-exit(r5)
            return r0
        L_0x0028:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.service.a.j():boolean");
    }

    public final synchronized boolean k() {
        return this.f15115b == b.USER_BINDED || this.f15115b == b.REGISTERED;
    }
}
