package net.one97.paytm.payments.visascp.safetynet;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.CountDownLatch;

public class GoogleSafetyNet {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static GoogleSafetyNet f614 = null;

    /* renamed from: ͺ  reason: contains not printable characters */
    private static int f615 = 1;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static int f616;

    /* renamed from: ʻ  reason: contains not printable characters */
    private Handler f617 = null;

    /* renamed from: ʼ  reason: contains not printable characters */
    private SafetyNetResponseListener f618;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Runnable f619 = null;

    /* renamed from: ˊ  reason: contains not printable characters */
    private CountDownLatch f620;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f621;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f622 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f623 = false;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f624;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f625;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static /* synthetic */ boolean m694(GoogleSafetyNet googleSafetyNet) {
        int i2 = (f615 + 114) - 1;
        f616 = i2 % 128;
        if (i2 % 2 == 0) {
        }
        return googleSafetyNet.f623;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static /* synthetic */ Handler m695(GoogleSafetyNet googleSafetyNet) {
        int i2 = f616;
        int i3 = i2 & 45;
        int i4 = (i2 | 45) & (~i3);
        int i5 = i3 << 1;
        int i6 = ((i4 | i5) << 1) - (i4 ^ i5);
        f615 = i6 % 128;
        int i7 = i6 % 2;
        Handler handler = googleSafetyNet.f617;
        int i8 = f615;
        int i9 = (i8 & -52) | ((~i8) & 51);
        int i10 = (i8 & 51) << 1;
        int i11 = (i9 ^ i10) + ((i10 & i9) << 1);
        f616 = i11 % 128;
        if (i11 % 2 == 0) {
        }
        return handler;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static /* synthetic */ int m696(GoogleSafetyNet googleSafetyNet) {
        int i2;
        int i3;
        int i4 = f615;
        int i5 = i4 & 55;
        int i6 = i5 + ((i4 ^ 55) | i5);
        f616 = i6 % 128;
        if ((i6 % 2 == 0 ? 0 : '3') != '3') {
            i2 = googleSafetyNet.f622;
            int i7 = i2 + 2;
            i3 = (i7 & -1) + (i7 | -1);
        } else {
            i2 = googleSafetyNet.f622;
            int i8 = (i2 + 2) - 1;
            i3 = ((i8 | -1) << 1) - (~i8);
        }
        googleSafetyNet.f622 = i3;
        return i2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static /* synthetic */ Context m697(GoogleSafetyNet googleSafetyNet) {
        int i2 = (f616 + 20) - 1;
        f615 = i2 % 128;
        int i3 = i2 % 2;
        Context context = googleSafetyNet.f621;
        int i4 = f616;
        int i5 = ((i4 & 20) + (i4 | 20)) - 1;
        f615 = i5 % 128;
        int i6 = i5 % 2;
        return context;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ CountDownLatch m699(GoogleSafetyNet googleSafetyNet) {
        int i2 = f615;
        int i3 = i2 & 7;
        int i4 = (i2 ^ 7) | i3;
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        f616 = i5 % 128;
        if (i5 % 2 == 0) {
        }
        CountDownLatch countDownLatch = googleSafetyNet.f620;
        int i6 = f616;
        int i7 = ((i6 | 83) << 1) - (i6 ^ 83);
        f615 = i7 % 128;
        if (i7 % 2 != 0) {
        }
        return countDownLatch;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ int m700(GoogleSafetyNet googleSafetyNet) {
        int i2 = (f616 + 32) - 1;
        f615 = i2 % 128;
        if (i2 % 2 != 0) {
        }
        return googleSafetyNet.f622;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ boolean m701(GoogleSafetyNet googleSafetyNet, boolean z) {
        int i2 = f615 + 7;
        f616 = i2 % 128;
        int i3 = i2 % 2;
        googleSafetyNet.f623 = z;
        int i4 = f615;
        int i5 = (i4 & -70) | ((~i4) & 69);
        int i6 = (i4 & 69) << 1;
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f616 = i7 % 128;
        int i8 = i7 % 2;
        return z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ SafetyNetResponseListener m702(GoogleSafetyNet googleSafetyNet) {
        int i2 = (f616 + 36) - 1;
        f615 = i2 % 128;
        boolean z = i2 % 2 == 0;
        SafetyNetResponseListener safetyNetResponseListener = googleSafetyNet.f618;
        if (!z) {
            return safetyNetResponseListener;
        }
        Object obj = null;
        super.hashCode();
        return safetyNetResponseListener;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ SafetyNetResponseListener m703(GoogleSafetyNet googleSafetyNet, SafetyNetResponseListener safetyNetResponseListener) {
        int i2 = f615;
        int i3 = ((i2 ^ 35) - (~((i2 & 35) << 1))) - 1;
        f616 = i3 % 128;
        char c2 = i3 % 2 == 0 ? 'a' : 'c';
        googleSafetyNet.f618 = safetyNetResponseListener;
        if (c2 != 'c') {
            return safetyNetResponseListener;
        }
        Object obj = null;
        super.hashCode();
        return safetyNetResponseListener;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ int m704(GoogleSafetyNet googleSafetyNet) {
        int i2;
        int i3;
        int i4 = f615;
        int i5 = (((i4 & 36) + (i4 | 36)) - 0) - 1;
        f616 = i5 % 128;
        if (i5 % 2 == 0) {
            i2 = googleSafetyNet.f625;
            i3 = (i2 ^ 1) + ((i2 & 1) << 1);
        } else {
            i2 = googleSafetyNet.f625;
            i3 = i2 % 1;
        }
        googleSafetyNet.f625 = i3;
        int i6 = f616;
        int i7 = ((i6 | 33) << 1) - (i6 ^ 33);
        f615 = i7 % 128;
        if (i7 % 2 != 0) {
        }
        return i2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ int m705(GoogleSafetyNet googleSafetyNet, int i2) {
        int i3 = f616;
        int i4 = (i3 ^ 14) + ((i3 & 14) << 1);
        int i5 = (i4 & -1) + (i4 | -1);
        f615 = i5 % 128;
        int i6 = i5 % 2;
        googleSafetyNet.f625 = i2;
        int i7 = f615;
        int i8 = i7 & 75;
        int i9 = (i7 ^ 75) | i8;
        int i10 = ((i8 | i9) << 1) - (i9 ^ i8);
        f616 = i10 % 128;
        int i11 = i10 % 2;
        return i2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ long m706(GoogleSafetyNet googleSafetyNet, long j) {
        int i2 = f615 + 66;
        int i3 = (i2 & -1) + (i2 | -1);
        f616 = i3 % 128;
        if (i3 % 2 == 0) {
        }
        googleSafetyNet.f624 = j;
        return j;
    }

    public static GoogleSafetyNet getInstance(Context context) {
        int i2 = f616;
        int i3 = ((i2 | 104) << 1) - (i2 ^ 104);
        int i4 = (i3 & -1) + (i3 | -1);
        f615 = i4 % 128;
        int i5 = i4 % 2;
        if (f614 == null) {
            f614 = new GoogleSafetyNet(context);
            int i6 = (f616 + 31) - 1;
            int i7 = (i6 & -1) + (i6 | -1);
            f615 = i7 % 128;
            int i8 = i7 % 2;
        }
        GoogleSafetyNet googleSafetyNet = f614;
        int i9 = f615;
        int i10 = i9 & 47;
        int i11 = i10 + ((i9 ^ 47) | i10);
        f616 = i11 % 128;
        int i12 = i11 % 2;
        return googleSafetyNet;
    }

    private GoogleSafetyNet(Context context) {
        this.f621 = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        if ((r0 == 0) != true) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        if ((com.google.android.gms.common.c.a().a(r5.f621, 13000000) != 0 ? 10 : 'H') != 10) goto L_0x0078;
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m698() {
        /*
            r5 = this;
            int r0 = f615
            int r0 = r0 + 120
            r1 = 1
            int r0 = r0 - r1
            int r2 = r0 % 128
            f616 = r2
            int r0 = r0 % 2
            com.google.android.gms.common.c r0 = com.google.android.gms.common.c.a()
            android.content.Context r2 = r5.f621
            int r0 = r0.a((android.content.Context) r2)
            r2 = 0
            if (r0 != 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == r1) goto L_0x0078
            int r0 = f616
            int r0 = r0 + 6
            int r0 = r0 - r2
            int r0 = r0 - r1
            int r3 = r0 % 128
            f615 = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x002e
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            r3 = 13000000(0xc65d40, float:1.821688E-38)
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.common.c r0 = com.google.android.gms.common.c.a()
            android.content.Context r4 = r5.f621
            int r0 = r0.a((android.content.Context) r4, (int) r3)
            r3 = 0
            super.hashCode()     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0046
            r0 = 0
            goto L_0x0047
        L_0x0046:
            r0 = 1
        L_0x0047:
            if (r0 == r1) goto L_0x0078
            goto L_0x0062
        L_0x004a:
            r0 = move-exception
            throw r0
        L_0x004c:
            com.google.android.gms.common.c r0 = com.google.android.gms.common.c.a()
            android.content.Context r4 = r5.f621
            int r0 = r0.a((android.content.Context) r4, (int) r3)
            r3 = 10
            if (r0 == 0) goto L_0x005d
            r0 = 10
            goto L_0x005f
        L_0x005d:
            r0 = 72
        L_0x005f:
            if (r0 == r3) goto L_0x0062
            goto L_0x0078
        L_0x0062:
            int r0 = f615
            int r0 = r0 + 44
            int r0 = r0 - r1
            int r1 = r0 % 128
            f616 = r1
            int r0 = r0 % 2
            r1 = 40
            if (r0 != 0) goto L_0x0073
            r0 = 6
            goto L_0x0075
        L_0x0073:
            r0 = 40
        L_0x0075:
            if (r0 == r1) goto L_0x0077
        L_0x0077:
            return r2
        L_0x0078:
            int r0 = f616
            r2 = r0 ^ 19
            r3 = r0 & 19
            r2 = r2 | r3
            int r2 = r2 << r1
            r3 = r0 & -20
            int r0 = ~r0
            r0 = r0 & 19
            r0 = r0 | r3
            int r2 = r2 - r0
            int r0 = r2 % 128
            f615 = r0
            int r2 = r2 % 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet.m698():boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x017d, code lost:
        if ((r1.f625 < 4 ? 'I' : 22) != 'I') goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01f6, code lost:
        if (r1.f623 == false) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x037f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        r2 = r0.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0384, code lost:
        if (r2 != null) goto L_0x0386;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0386, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0387, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0388, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0389, code lost:
        r2 = r0.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x038d, code lost:
        if (r2 != null) goto L_0x038f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x038f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0390, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0391, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0392, code lost:
        r2 = r0.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0396, code lost:
        if (r2 != null) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0398, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0399, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if ((!android.text.TextUtils.isEmpty(net.one97.paytm.payments.visascp.VisaSDK.SAFETY_NET_API_KEY)) != true) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0433, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x04aa, code lost:
        if (r12 != false) goto L_0x04ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2 == null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        if (r2 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00be, code lost:
        if (r1.f620.getCount() == 0) goto L_0x00c0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x0064, B:137:0x0211, B:158:0x02f6, B:162:0x032e, B:210:0x042e] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x037b A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x037d A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void attest(java.lang.String r22, byte[] r23, net.one97.paytm.payments.visascp.safetynet.SafetyNetResponseListener r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r23
            r2 = r24
            monitor-enter(r21)
            int r3 = f616     // Catch:{ all -> 0x04ee }
            r4 = r3 & 81
            r3 = r3 ^ 81
            r3 = r3 | r4
            int r3 = -r3
            int r3 = -r3
            r5 = r4 & r3
            r3 = r3 | r4
            int r5 = r5 + r3
            int r3 = r5 % 128
            f615 = r3     // Catch:{ all -> 0x04ee }
            r14 = 2
            int r5 = r5 % r14
            r15 = 89
            if (r5 == 0) goto L_0x0021
            r3 = 21
            goto L_0x0023
        L_0x0021:
            r3 = 89
        L_0x0023:
            r13 = 31
            r12 = 0
            r11 = 1
            if (r3 == r15) goto L_0x0037
            java.lang.String r3 = net.one97.paytm.payments.visascp.VisaSDK.SAFETY_NET_API_KEY     // Catch:{ all -> 0x04ee }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04ee }
            if (r3 != 0) goto L_0x0033
            r3 = 1
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            if (r3 == 0) goto L_0x0044
            goto L_0x0099
        L_0x0037:
            java.lang.String r3 = net.one97.paytm.payments.visascp.VisaSDK.SAFETY_NET_API_KEY     // Catch:{ all -> 0x04ee }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04ee }
            if (r3 != 0) goto L_0x0041
            r3 = 1
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            if (r3 == r11) goto L_0x0099
        L_0x0044:
            int r0 = f616     // Catch:{ all -> 0x04ee }
            r3 = r0 | 31
            int r4 = r3 << 1
            r0 = r0 & r13
            int r0 = ~r0     // Catch:{ all -> 0x04ee }
            r0 = r0 & r3
            int r0 = -r0
            r3 = r4 | r0
            int r3 = r3 << r11
            r0 = r0 ^ r4
            int r3 = r3 - r0
            int r0 = r3 % 128
            f615 = r0     // Catch:{ all -> 0x04ee }
            int r3 = r3 % r14
            if (r3 == 0) goto L_0x005d
            r0 = 70
            goto L_0x005f
        L_0x005d:
            r0 = 79
        L_0x005f:
            r3 = 70
            if (r0 == r3) goto L_0x006d
            r0 = 0
            super.hashCode()     // Catch:{ all -> 0x006a }
            if (r2 != 0) goto L_0x006f
            goto L_0x0086
        L_0x006a:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x04ee }
        L_0x006d:
            if (r2 == 0) goto L_0x0086
        L_0x006f:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x04ee }
            java.lang.String r3 = "SafetyNet API key cannot be null or empty"
            r0.<init>(r3)     // Catch:{ all -> 0x04ee }
            r2.onSafetyNetResponseFailure(r0)     // Catch:{ all -> 0x04ee }
            int r0 = f615     // Catch:{ all -> 0x04ee }
            int r0 = r0 + 74
            int r0 = r0 - r11
            int r2 = r0 % 128
            f616 = r2     // Catch:{ all -> 0x04ee }
            int r0 = r0 % r14
            if (r0 != 0) goto L_0x0086
            r12 = 1
        L_0x0086:
            int r0 = f616     // Catch:{ all -> 0x04ee }
            r2 = r0 ^ 87
            r0 = r0 & 87
            int r0 = r0 << r11
            r3 = r2 | r0
            int r3 = r3 << r11
            r0 = r0 ^ r2
            int r3 = r3 - r0
            int r0 = r3 % 128
            f615 = r0     // Catch:{ all -> 0x04ee }
            int r3 = r3 % r14
            monitor-exit(r21)
            return
        L_0x0099:
            java.util.concurrent.CountDownLatch r3 = r1.f620     // Catch:{ all -> 0x04ee }
            r10 = 51
            if (r3 != 0) goto L_0x00a2
            r3 = 39
            goto L_0x00a4
        L_0x00a2:
            r3 = 51
        L_0x00a4:
            if (r3 == r10) goto L_0x00a7
            goto L_0x00c0
        L_0x00a7:
            int r3 = f616     // Catch:{ all -> 0x04ee }
            r4 = r3 | 81
            int r4 = r4 << r11
            r3 = r3 ^ 81
            int r4 = r4 - r3
            int r3 = r4 % 128
            f615 = r3     // Catch:{ all -> 0x04ee }
            int r4 = r4 % r14
            java.util.concurrent.CountDownLatch r3 = r1.f620     // Catch:{ all -> 0x04ee }
            long r3 = r3.getCount()     // Catch:{ all -> 0x04ee }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x00d2
        L_0x00c0:
            java.lang.String r3 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x04ee }
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x04ee }
            r3.<init>(r11)     // Catch:{ all -> 0x04ee }
            r1.f620 = r3     // Catch:{ all -> 0x04ee }
            int r3 = f615     // Catch:{ all -> 0x04ee }
            int r3 = r3 + 33
            int r4 = r3 % 128
            f616 = r4     // Catch:{ all -> 0x04ee }
            int r3 = r3 % r14
        L_0x00d2:
            r3 = 32
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ InterruptedException -> 0x011a }
            boolean r4 = r1.f623     // Catch:{ InterruptedException -> 0x011a }
            if (r4 != 0) goto L_0x00dc
            r4 = 1
            goto L_0x00dd
        L_0x00dc:
            r4 = 0
        L_0x00dd:
            if (r4 == r11) goto L_0x010b
            int r4 = f616     // Catch:{ all -> 0x04ee }
            r5 = r4 ^ 25
            r4 = r4 & 25
            r4 = r4 | r5
            int r4 = r4 << r11
            int r5 = -r5
            r6 = r4 | r5
            int r6 = r6 << r11
            r4 = r4 ^ r5
            int r6 = r6 - r4
            int r4 = r6 % 128
            f615 = r4     // Catch:{ all -> 0x04ee }
            int r6 = r6 % r14
            if (r6 == 0) goto L_0x00f6
            r4 = 1
            goto L_0x00f7
        L_0x00f6:
            r4 = 0
        L_0x00f7:
            if (r4 == 0) goto L_0x0103
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ InterruptedException -> 0x011a }
            java.util.concurrent.CountDownLatch r4 = r1.f620     // Catch:{ InterruptedException -> 0x011a }
            r4.await()     // Catch:{ InterruptedException -> 0x011a }
        L_0x0100:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ InterruptedException -> 0x011a }
            goto L_0x010b
        L_0x0103:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ InterruptedException -> 0x011a }
            java.util.concurrent.CountDownLatch r4 = r1.f620     // Catch:{ InterruptedException -> 0x011a }
            r4.await()     // Catch:{ InterruptedException -> 0x011a }
            goto L_0x0100
        L_0x010b:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ InterruptedException -> 0x011a }
            int r4 = f616     // Catch:{ all -> 0x04ee }
            r5 = r4 & 32
            r4 = r4 | r3
            int r5 = r5 + r4
            int r5 = r5 - r11
            int r4 = r5 % 128
            f615 = r4     // Catch:{ all -> 0x04ee }
            int r5 = r5 % r14
            goto L_0x011e
        L_0x011a:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x04ee }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE     // Catch:{ all -> 0x04ee }
        L_0x011e:
            android.content.Context r4 = r1.f621     // Catch:{ all -> 0x04ee }
            boolean r4 = net.one97.paytm.payments.visascp.util.Utils.isSafetyNetResponseValid(r4)     // Catch:{ all -> 0x04ee }
            if (r4 != 0) goto L_0x0129
            r4 = 55
            goto L_0x012b
        L_0x0129:
            r4 = 63
        L_0x012b:
            r5 = 63
            r6 = 10
            r7 = 57
            if (r4 == r5) goto L_0x0483
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x04ee }
            long r8 = r1.f624     // Catch:{ all -> 0x04ee }
            long r4 = r4 - r8
            int r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_NET_REFRESH_THRESHOLD     // Catch:{ all -> 0x04ee }
            long r8 = (long) r8     // Catch:{ all -> 0x04ee }
            r10 = 28
            int r17 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r17 < 0) goto L_0x0146
            r4 = 28
            goto L_0x0148
        L_0x0146:
            r4 = 95
        L_0x0148:
            r5 = 95
            r9 = 4
            r17 = 3
            if (r4 == r5) goto L_0x0151
            goto L_0x01cb
        L_0x0151:
            int r4 = f616     // Catch:{ all -> 0x04ee }
            r5 = r4 & 17
            r4 = r4 | 17
            int r5 = r5 + r4
            int r4 = r5 % 128
            f615 = r4     // Catch:{ all -> 0x04ee }
            int r5 = r5 % r14
            if (r5 == 0) goto L_0x0161
            r4 = 2
            goto L_0x0163
        L_0x0161:
            r4 = 10
        L_0x0163:
            if (r4 == r6) goto L_0x0172
            int r4 = r1.f625     // Catch:{ all -> 0x04ee }
            if (r4 >= r14) goto L_0x016c
            r4 = 54
            goto L_0x016d
        L_0x016c:
            r4 = 3
        L_0x016d:
            r5 = 54
            if (r4 == r5) goto L_0x01cb
            goto L_0x017f
        L_0x0172:
            int r4 = r1.f625     // Catch:{ all -> 0x04ee }
            if (r4 >= r9) goto L_0x0179
            r4 = 73
            goto L_0x017b
        L_0x0179:
            r4 = 22
        L_0x017b:
            r5 = 73
            if (r4 == r5) goto L_0x01cb
        L_0x017f:
            int r0 = f615     // Catch:{ all -> 0x04ee }
            r3 = r0 & 82
            r0 = r0 | 82
            int r3 = r3 + r0
            int r0 = ~r3     // Catch:{ all -> 0x04ee }
            r3 = r3 & -1
            int r3 = r3 << r11
            int r0 = r0 + r3
            int r3 = r0 % 128
            f616 = r3     // Catch:{ all -> 0x04ee }
            int r0 = r0 % r14
            if (r2 == 0) goto L_0x01af
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x04ee }
            java.lang.String r3 = "Too many SafetyNet API calls"
            r0.<init>(r3)     // Catch:{ all -> 0x04ee }
            r2.onSafetyNetResponseFailure(r0)     // Catch:{ all -> 0x04ee }
            int r0 = f615     // Catch:{ all -> 0x04ee }
            int r0 = r0 + 114
            int r0 = r0 - r11
            int r2 = r0 % 128
            f616 = r2     // Catch:{ all -> 0x04ee }
            int r0 = r0 % r14
            if (r0 != 0) goto L_0x01ab
            r0 = 12
            goto L_0x01ad
        L_0x01ab:
            r0 = 66
        L_0x01ad:
            r2 = 12
        L_0x01af:
            int r0 = f616     // Catch:{ all -> 0x04ee }
            r2 = r0 & 47
            r0 = r0 ^ 47
            r0 = r0 | r2
            int r0 = -r0
            int r0 = -r0
            r3 = r2 ^ r0
            r0 = r0 & r2
            int r0 = r0 << r11
            int r3 = r3 + r0
            int r0 = r3 % 128
            f615 = r0     // Catch:{ all -> 0x04ee }
            int r3 = r3 % r14
            if (r3 == 0) goto L_0x01c5
            r12 = 1
        L_0x01c5:
            if (r12 == r11) goto L_0x01c9
            monitor-exit(r21)
            return
        L_0x01c9:
            monitor-exit(r21)
            return
        L_0x01cb:
            boolean r4 = r21.m698()     // Catch:{ all -> 0x04ee }
            if (r4 != 0) goto L_0x01d3
            r4 = 1
            goto L_0x01d4
        L_0x01d3:
            r4 = 0
        L_0x01d4:
            r18 = 77
            if (r4 == r11) goto L_0x039a
            int r4 = f616     // Catch:{ all -> 0x04ee }
            r5 = r4 | 77
            int r5 = r5 << r11
            r4 = r4 ^ 77
            int r5 = r5 - r4
            int r4 = r5 % 128
            f615 = r4     // Catch:{ all -> 0x04ee }
            int r5 = r5 % r14
            if (r5 == 0) goto L_0x01ea
            r4 = 28
            goto L_0x01ec
        L_0x01ea:
            r4 = 88
        L_0x01ec:
            if (r4 == r10) goto L_0x01f4
            boolean r4 = r1.f623     // Catch:{ all -> 0x04ee }
            if (r4 == 0) goto L_0x01f8
            goto L_0x040f
        L_0x01f4:
            boolean r4 = r1.f623     // Catch:{ all -> 0x04ee }
            if (r4 != 0) goto L_0x040f
        L_0x01f8:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x04ee }
            r1.f623 = r11     // Catch:{ all -> 0x04ee }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x04ee }
            r1.f618 = r2     // Catch:{ all -> 0x04ee }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x04ee }
            r1.f622 = r11     // Catch:{ all -> 0x04ee }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x04ee }
            android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x04ee }
            r2.<init>(r4)     // Catch:{ all -> 0x04ee }
            r1.f617 = r2     // Catch:{ all -> 0x04ee }
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ all -> 0x0391 }
            r2[r12] = r1     // Catch:{ all -> 0x0391 }
            r4 = 60
            java.lang.Object r4 = net.one97.paytm.payments.visascp.safetynet.C1143.m709(r4, r12, r12)     // Catch:{ all -> 0x0391 }
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ all -> 0x0391 }
            java.lang.Class[] r5 = new java.lang.Class[r11]     // Catch:{ all -> 0x0391 }
            java.lang.Class<net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet> r6 = net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet.class
            r5[r12] = r6     // Catch:{ all -> 0x0391 }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r5)     // Catch:{ all -> 0x0391 }
            java.lang.Object r2 = r4.newInstance(r2)     // Catch:{ all -> 0x0391 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x0391 }
            r1.f619 = r2     // Catch:{ all -> 0x04ee }
            android.os.Handler r2 = r1.f617     // Catch:{ all -> 0x04ee }
            java.lang.Runnable r4 = r1.f619     // Catch:{ all -> 0x04ee }
            r5 = 1000(0x3e8, double:4.94E-321)
            r2.postDelayed(r4, r5)     // Catch:{ all -> 0x04ee }
            if (r0 != 0) goto L_0x023d
            r2 = 42
            goto L_0x023f
        L_0x023d:
            r2 = 32
        L_0x023f:
            if (r2 == r3) goto L_0x0242
            goto L_0x024e
        L_0x0242:
            int r2 = f615     // Catch:{ all -> 0x04ee }
            int r2 = r2 + 37
            int r3 = r2 % 128
            f616 = r3     // Catch:{ all -> 0x04ee }
            int r2 = r2 % r14
            int r2 = r0.length     // Catch:{ all -> 0x04ee }
            if (r2 != 0) goto L_0x0291
        L_0x024e:
            android.content.Context r2 = r1.f621     // Catch:{ all -> 0x04ee }
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r2 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r2)     // Catch:{ all -> 0x04ee }
            r3 = 0
            java.lang.String r4 = "safetynet-request"
            java.sql.Timestamp r5 = new java.sql.Timestamp     // Catch:{ all -> 0x04ee }
            r5.<init>(r7)     // Catch:{ all -> 0x04ee }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x04ee }
            java.lang.String r10 = ""
            r13 = 200(0xc8, float:2.8E-43)
            java.lang.String r15 = "Nonce=null"
            r16 = 0
            r18 = 0
            r5 = r22
            r19 = r7
            r7 = r10
            r8 = r13
            r13 = 4
            r9 = r15
            r10 = r16
            r15 = 1
            r11 = r18
            r2.logLocalEvent(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x04ee }
            int r2 = f616     // Catch:{ all -> 0x04ee }
            r3 = r2 ^ 73
            r2 = r2 & 73
            int r2 = r2 << r15
            int r3 = r3 + r2
            int r2 = r3 % 128
            f615 = r2     // Catch:{ all -> 0x04ee }
            int r3 = r3 % r14
            if (r3 == 0) goto L_0x028c
            r2 = 20
            goto L_0x028e
        L_0x028c:
            r2 = 35
        L_0x028e:
            r3 = 20
            goto L_0x02ea
        L_0x0291:
            r19 = r7
            r13 = 4
            r15 = 1
            android.content.Context r2 = r1.f621     // Catch:{ all -> 0x04ee }
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r2 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r2)     // Catch:{ all -> 0x04ee }
            r3 = 0
            java.lang.String r4 = "safetynet-request"
            java.sql.Timestamp r5 = new java.sql.Timestamp     // Catch:{ all -> 0x04ee }
            r10 = r19
            r5.<init>(r10)     // Catch:{ all -> 0x04ee }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x04ee }
            java.lang.String r7 = ""
            r8 = 200(0xc8, float:2.8E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ee }
            java.lang.String r9 = "Nonce="
            r5.<init>(r9)     // Catch:{ all -> 0x04ee }
            java.lang.String r9 = android.util.Base64.encodeToString(r0, r14)     // Catch:{ all -> 0x04ee }
            r5.append(r9)     // Catch:{ all -> 0x04ee }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x04ee }
            r16 = 0
            r18 = 0
            r5 = r22
            r19 = r10
            r10 = r16
            r11 = r18
            r2.logLocalEvent(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x04ee }
            int r2 = f616     // Catch:{ all -> 0x04ee }
            r3 = r2 ^ 19
            r4 = r2 & 19
            r3 = r3 | r4
            int r3 = r3 << r15
            r4 = r2 & -20
            int r2 = ~r2     // Catch:{ all -> 0x04ee }
            r2 = r2 & 19
            r2 = r2 | r4
            int r2 = -r2
            int r2 = ~r2     // Catch:{ all -> 0x04ee }
            int r3 = r3 - r2
            int r3 = r3 - r15
            int r2 = r3 % 128
            f615 = r2     // Catch:{ all -> 0x04ee }
            int r3 = r3 % r14
            if (r3 == 0) goto L_0x02e9
            r2 = 0
            goto L_0x02ea
        L_0x02e9:
            r2 = 1
        L_0x02ea:
            android.content.Context r2 = r1.f621     // Catch:{ all -> 0x04ee }
            com.google.android.gms.safetynet.SafetyNetClient r2 = com.google.android.gms.safetynet.SafetyNet.getClient((android.content.Context) r2)     // Catch:{ all -> 0x04ee }
            java.lang.String r3 = net.one97.paytm.payments.visascp.VisaSDK.SAFETY_NET_API_KEY     // Catch:{ all -> 0x04ee }
            com.google.android.gms.tasks.Task r2 = r2.attest(r0, r3)     // Catch:{ all -> 0x04ee }
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ all -> 0x0388 }
            r3[r17] = r0     // Catch:{ all -> 0x0388 }
            java.lang.Long r4 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0388 }
            r3[r14] = r4     // Catch:{ all -> 0x0388 }
            r3[r15] = r22     // Catch:{ all -> 0x0388 }
            r3[r12] = r1     // Catch:{ all -> 0x0388 }
            r4 = 60
            r5 = 511(0x1ff, float:7.16E-43)
            java.lang.Object r4 = net.one97.paytm.payments.visascp.network.If.m692(r12, r4, r5)     // Catch:{ all -> 0x0388 }
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ all -> 0x0388 }
            java.lang.Class[] r5 = new java.lang.Class[r13]     // Catch:{ all -> 0x0388 }
            java.lang.Class<net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet> r6 = net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet.class
            r5[r12] = r6     // Catch:{ all -> 0x0388 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r15] = r6     // Catch:{ all -> 0x0388 }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x0388 }
            r5[r14] = r6     // Catch:{ all -> 0x0388 }
            java.lang.Class<byte[]> r6 = byte[].class
            r5[r17] = r6     // Catch:{ all -> 0x0388 }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r5)     // Catch:{ all -> 0x0388 }
            java.lang.Object r3 = r4.newInstance(r3)     // Catch:{ all -> 0x0388 }
            com.google.android.gms.tasks.OnSuccessListener r3 = (com.google.android.gms.tasks.OnSuccessListener) r3     // Catch:{ all -> 0x0388 }
            com.google.android.gms.tasks.Task r2 = r2.a(r3)     // Catch:{ all -> 0x04ee }
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ all -> 0x037f }
            r3[r17] = r22     // Catch:{ all -> 0x037f }
            r3[r14] = r0     // Catch:{ all -> 0x037f }
            java.lang.Long r0 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x037f }
            r3[r15] = r0     // Catch:{ all -> 0x037f }
            r3[r12] = r1     // Catch:{ all -> 0x037f }
            r0 = 60
            r4 = 451(0x1c3, float:6.32E-43)
            java.lang.Object r0 = net.one97.paytm.payments.visascp.network.If.m692(r12, r0, r4)     // Catch:{ all -> 0x037f }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x037f }
            java.lang.Class[] r4 = new java.lang.Class[r13]     // Catch:{ all -> 0x037f }
            java.lang.Class<net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet> r5 = net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet.class
            r4[r12] = r5     // Catch:{ all -> 0x037f }
            java.lang.Class r5 = java.lang.Long.TYPE     // Catch:{ all -> 0x037f }
            r4[r15] = r5     // Catch:{ all -> 0x037f }
            java.lang.Class<byte[]> r5 = byte[].class
            r4[r14] = r5     // Catch:{ all -> 0x037f }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r17] = r5     // Catch:{ all -> 0x037f }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r4)     // Catch:{ all -> 0x037f }
            java.lang.Object r0 = r0.newInstance(r3)     // Catch:{ all -> 0x037f }
            com.google.android.gms.tasks.OnFailureListener r0 = (com.google.android.gms.tasks.OnFailureListener) r0     // Catch:{ all -> 0x037f }
            r2.a((com.google.android.gms.tasks.OnFailureListener) r0)     // Catch:{ all -> 0x04ee }
            int r0 = f615     // Catch:{ all -> 0x04ee }
            r2 = r0 & 125(0x7d, float:1.75E-43)
            r0 = r0 ^ 125(0x7d, float:1.75E-43)
            r0 = r0 | r2
            r3 = r2 & r0
            r0 = r0 | r2
            int r3 = r3 + r0
            int r0 = r3 % 128
            f616 = r0     // Catch:{ all -> 0x04ee }
            int r3 = r3 % r14
            if (r3 != 0) goto L_0x0378
            goto L_0x0379
        L_0x0378:
            r12 = 1
        L_0x0379:
            if (r12 == 0) goto L_0x037d
            monitor-exit(r21)
            return
        L_0x037d:
            monitor-exit(r21)
            return
        L_0x037f:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ all -> 0x04ee }
            if (r2 == 0) goto L_0x0387
            throw r2     // Catch:{ all -> 0x04ee }
        L_0x0387:
            throw r0     // Catch:{ all -> 0x04ee }
        L_0x0388:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ all -> 0x04ee }
            if (r2 == 0) goto L_0x0390
            throw r2     // Catch:{ all -> 0x04ee }
        L_0x0390:
            throw r0     // Catch:{ all -> 0x04ee }
        L_0x0391:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ all -> 0x04ee }
            if (r2 == 0) goto L_0x0399
            throw r2     // Catch:{ all -> 0x04ee }
        L_0x0399:
            throw r0     // Catch:{ all -> 0x04ee }
        L_0x039a:
            r12 = 1
            java.lang.String r9 = "Safetynet not supported. Please update Play Services"
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x04ee }
            r3.<init>(r9)     // Catch:{ all -> 0x04ee }
            r2.onSafetyNetResponseFailure(r3)     // Catch:{ all -> 0x04ee }
            if (r0 != 0) goto L_0x03aa
            r2 = 57
            goto L_0x03ac
        L_0x03aa:
            r2 = 27
        L_0x03ac:
            if (r2 == r7) goto L_0x0436
            int r2 = f615     // Catch:{ all -> 0x04ee }
            r3 = r2 & 5
            int r4 = ~r3     // Catch:{ all -> 0x04ee }
            r2 = r2 | 5
            r2 = r2 & r4
            int r3 = r3 << r12
            r4 = r2 & r3
            r2 = r2 | r3
            int r4 = r4 + r2
            int r2 = r4 % 128
            f616 = r2     // Catch:{ all -> 0x04ee }
            int r4 = r4 % r14
            int r2 = r0.length     // Catch:{ all -> 0x04ee }
            if (r2 != 0) goto L_0x03c5
            goto L_0x0436
        L_0x03c5:
            android.content.Context r2 = r1.f621     // Catch:{ all -> 0x04ee }
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r2 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r2)     // Catch:{ all -> 0x04ee }
            r3 = 1
            java.lang.String r4 = "safetynet"
            java.sql.Timestamp r5 = new java.sql.Timestamp     // Catch:{ all -> 0x04ee }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x04ee }
            r5.<init>(r6)     // Catch:{ all -> 0x04ee }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x04ee }
            java.lang.String r7 = "0"
            r8 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x04ee }
            java.lang.String r10 = "Nonce="
            r5.<init>(r10)     // Catch:{ all -> 0x04ee }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r14)     // Catch:{ all -> 0x04ee }
            r5.append(r0)     // Catch:{ all -> 0x04ee }
            java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x04ee }
            r11 = 0
            r0 = 0
            r13 = 0
            r5 = r22
            r15 = 51
            r12 = r0
            r2.logApiEvent(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x04ee }
            int r0 = f616     // Catch:{ all -> 0x04ee }
            r2 = r0 & 33
            r0 = r0 ^ 33
            r0 = r0 | r2
            int r2 = r2 + r0
            int r0 = r2 % 128
            f615 = r0     // Catch:{ all -> 0x04ee }
            int r2 = r2 % r14
            if (r2 == 0) goto L_0x040d
            r10 = 51
            goto L_0x040f
        L_0x040d:
            r10 = 78
        L_0x040f:
            int r0 = f616     // Catch:{ all -> 0x04ee }
            r2 = r0 | 102(0x66, float:1.43E-43)
            r12 = 1
            int r2 = r2 << r12
            r0 = r0 ^ 102(0x66, float:1.43E-43)
            int r2 = r2 - r0
            int r2 = r2 - r12
            int r0 = r2 % 128
            f615 = r0     // Catch:{ all -> 0x04ee }
            int r2 = r2 % r14
            if (r2 == 0) goto L_0x0423
            r0 = 77
            goto L_0x0427
        L_0x0423:
            r18 = 8
            r0 = 8
        L_0x0427:
            r2 = 8
            if (r0 == r2) goto L_0x042d
            monitor-exit(r21)
            return
        L_0x042d:
            r0 = 0
            super.hashCode()     // Catch:{ all -> 0x0433 }
            monitor-exit(r21)
            return
        L_0x0433:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x04ee }
        L_0x0436:
            android.content.Context r0 = r1.f621     // Catch:{ all -> 0x04ee }
            net.one97.paytm.payments.visascp.network.HawkEyeEvent r2 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r0)     // Catch:{ all -> 0x04ee }
            r3 = 1
            java.lang.String r4 = "safetynet"
            java.sql.Timestamp r0 = new java.sql.Timestamp     // Catch:{ all -> 0x04ee }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x04ee }
            r0.<init>(r5)     // Catch:{ all -> 0x04ee }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x04ee }
            java.lang.String r7 = "0"
            r8 = 0
            java.lang.String r10 = "Nonce=null"
            r11 = 0
            r0 = 0
            r16 = 0
            r5 = r22
            r14 = 1
            r12 = r0
            r0 = 31
            r13 = r16
            r2.logApiEvent(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x04ee }
            int r2 = f616     // Catch:{ all -> 0x04ee }
            r3 = r2 ^ 89
            r4 = r2 & 89
            r3 = r3 | r4
            int r3 = r3 << r14
            int r4 = ~r4     // Catch:{ all -> 0x04ee }
            r2 = r2 | r15
            r2 = r2 & r4
            int r2 = -r2
            r4 = r3 ^ r2
            r2 = r2 & r3
            int r2 = r2 << r14
            int r4 = r4 + r2
            int r2 = r4 % 128
            f615 = r2     // Catch:{ all -> 0x04ee }
            r2 = 2
            int r4 = r4 % r2
            if (r4 == 0) goto L_0x047c
            r2 = 31
            goto L_0x047d
        L_0x047c:
            r2 = 3
        L_0x047d:
            if (r2 == r0) goto L_0x0481
            monitor-exit(r21)
            return
        L_0x0481:
            monitor-exit(r21)
            return
        L_0x0483:
            r14 = 1
            int r0 = f616     // Catch:{ all -> 0x04ee }
            r3 = r0 & 57
            r0 = r0 ^ r7
            r0 = r0 | r3
            int r3 = r3 + r0
            int r0 = r3 % 128
            f615 = r0     // Catch:{ all -> 0x04ee }
            r0 = 2
            int r3 = r3 % r0
            if (r3 == 0) goto L_0x0495
            r0 = 0
            goto L_0x0496
        L_0x0495:
            r0 = 1
        L_0x0496:
            if (r0 == r14) goto L_0x04a4
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x04ee }
            if (r2 != 0) goto L_0x049f
            r0 = 10
            goto L_0x04a1
        L_0x049f:
            r0 = 50
        L_0x04a1:
            if (r0 == r6) goto L_0x04df
            goto L_0x04ac
        L_0x04a4:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x04ee }
            if (r2 != 0) goto L_0x04a9
            goto L_0x04aa
        L_0x04a9:
            r12 = 1
        L_0x04aa:
            if (r12 == 0) goto L_0x04df
        L_0x04ac:
            int r0 = f615     // Catch:{ all -> 0x04ee }
            r3 = r0 & 29
            r0 = r0 | 29
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0     // Catch:{ all -> 0x04ee }
            int r3 = r3 - r0
            int r3 = r3 - r14
            int r0 = r3 % 128
            f616 = r0     // Catch:{ all -> 0x04ee }
            r0 = 2
            int r3 = r3 % r0
            android.content.Context r0 = r1.f621     // Catch:{ all -> 0x04ee }
            net.one97.paytm.payments.visascp.storage.SecureSharedPref r0 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r0)     // Catch:{ all -> 0x04ee }
            android.content.Context r3 = r1.f621     // Catch:{ all -> 0x04ee }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_PREF_KEY     // Catch:{ all -> 0x04ee }
            java.lang.String r0 = r0.getData(r3, r4)     // Catch:{ all -> 0x04ee }
            r2.onSafetyNetResponseSuccess(r0)     // Catch:{ all -> 0x04ee }
            int r0 = f615     // Catch:{ all -> 0x04ee }
            r2 = r0 & 5
            r0 = r0 | 5
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0     // Catch:{ all -> 0x04ee }
            int r2 = r2 - r0
            int r2 = r2 - r14
            int r0 = r2 % 128
            f616 = r0     // Catch:{ all -> 0x04ee }
            r0 = 2
            int r2 = r2 % r0
        L_0x04df:
            int r0 = f615     // Catch:{ all -> 0x04ee }
            r2 = r0 & 15
            r0 = r0 | 15
            int r2 = r2 + r0
            int r0 = r2 % 128
            f616 = r0     // Catch:{ all -> 0x04ee }
            r0 = 2
            int r2 = r2 % r0
            monitor-exit(r21)
            return
        L_0x04ee:
            r0 = move-exception
            monitor-exit(r21)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet.attest(java.lang.String, byte[], net.one97.paytm.payments.visascp.safetynet.SafetyNetResponseListener):void");
    }
}
