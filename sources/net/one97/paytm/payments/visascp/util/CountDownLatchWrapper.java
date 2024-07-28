package net.one97.paytm.payments.visascp.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchWrapper extends CountDownLatch {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static int f649 = 1;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static int f650;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f651;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f652;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f653;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f654;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f655;

    public CountDownLatchWrapper(Context context, String str, String str2, String str3, String str4, int i2) {
        super(i2);
        this.f653 = str;
        this.f654 = str2;
        this.f651 = str3;
        this.f652 = str4;
        this.f655 = Utils.getCardAlias(context, str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if ((r4.f655.equalsIgnoreCase(r5) ? (char) 21 : 3) != 3) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void countDown(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = f650     // Catch:{ all -> 0x007f }
            r1 = r0 & 95
            int r2 = ~r1     // Catch:{ all -> 0x007f }
            r0 = r0 | 95
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r1 = -r1
            int r1 = -r1
            r3 = r0 | r1
            int r3 = r3 << r2
            r0 = r0 ^ r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f649 = r0     // Catch:{ all -> 0x007f }
            int r3 = r3 % 2
            r0 = 88
            if (r3 == 0) goto L_0x001f
            r1 = 60
            goto L_0x0021
        L_0x001f:
            r1 = 88
        L_0x0021:
            r3 = 0
            if (r1 == r0) goto L_0x0032
            java.lang.String r0 = r4.f655     // Catch:{ all -> 0x007f }
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ all -> 0x007f }
            if (r5 == 0) goto L_0x002e
            r5 = 0
            goto L_0x002f
        L_0x002e:
            r5 = 1
        L_0x002f:
            if (r5 == r2) goto L_0x0060
            goto L_0x0041
        L_0x0032:
            java.lang.String r0 = r4.f655     // Catch:{ all -> 0x007f }
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ all -> 0x007f }
            r0 = 3
            if (r5 == 0) goto L_0x003e
            r5 = 21
            goto L_0x003f
        L_0x003e:
            r5 = 3
        L_0x003f:
            if (r5 == r0) goto L_0x0060
        L_0x0041:
            super.countDown()     // Catch:{ all -> 0x007f }
            int r5 = f649     // Catch:{ all -> 0x007f }
            r0 = r5 ^ 85
            r5 = r5 & 85
            int r5 = r5 << r2
            r1 = r0 ^ r5
            r5 = r5 & r0
            int r5 = r5 << r2
            int r1 = r1 + r5
            int r5 = r1 % 128
            f650 = r5     // Catch:{ all -> 0x007f }
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r3 = 1
        L_0x005a:
            if (r3 == r2) goto L_0x005e
            monitor-exit(r4)
            return
        L_0x005e:
            monitor-exit(r4)
            return
        L_0x0060:
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x007f }
            int r5 = f650     // Catch:{ all -> 0x007f }
            r0 = r5 ^ 123(0x7b, float:1.72E-43)
            r5 = r5 & 123(0x7b, float:1.72E-43)
            int r5 = r5 << r2
            int r0 = r0 + r5
            int r5 = r0 % 128
            f649 = r5     // Catch:{ all -> 0x007f }
            int r0 = r0 % 2
            r5 = 75
            if (r0 == 0) goto L_0x0077
            r0 = 18
            goto L_0x0079
        L_0x0077:
            r0 = 75
        L_0x0079:
            if (r0 == r5) goto L_0x007d
            monitor-exit(r4)
            return
        L_0x007d:
            monitor-exit(r4)
            return
        L_0x007f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.CountDownLatchWrapper.countDown(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        if ((!r5 ? '7' : 'b') != 'b') goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ad, code lost:
        if ((!r4.f652.equalsIgnoreCase(r8) ? 29 : '5') != 29) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c4, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isSameCard(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = f649     // Catch:{ all -> 0x00df }
            r1 = r0 & 109(0x6d, float:1.53E-43)
            r0 = r0 | 109(0x6d, float:1.53E-43)
            int r0 = -r0
            int r0 = -r0
            r2 = r1 | r0
            r3 = 1
            int r2 = r2 << r3
            r0 = r0 ^ r1
            int r2 = r2 - r0
            int r0 = r2 % 128
            f650 = r0     // Catch:{ all -> 0x00df }
            int r2 = r2 % 2
            java.lang.String r0 = r4.f653     // Catch:{ all -> 0x00df }
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ all -> 0x00df }
            r0 = 36
            if (r5 != 0) goto L_0x0021
            r5 = 4
            goto L_0x0023
        L_0x0021:
            r5 = 36
        L_0x0023:
            r1 = 0
            if (r5 == r0) goto L_0x0028
            goto L_0x00c5
        L_0x0028:
            int r5 = f650     // Catch:{ all -> 0x00df }
            r0 = r5 | 76
            int r0 = r0 << r3
            r5 = r5 ^ 76
            int r0 = r0 - r5
            int r0 = r0 - r3
            int r5 = r0 % 128
            f649 = r5     // Catch:{ all -> 0x00df }
            int r0 = r0 % 2
            java.lang.String r5 = r4.f654     // Catch:{ all -> 0x00df }
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ all -> 0x00df }
            r6 = 38
            if (r5 != 0) goto L_0x0043
            r5 = 7
            goto L_0x0045
        L_0x0043:
            r5 = 38
        L_0x0045:
            if (r5 == r6) goto L_0x0049
            goto L_0x00c5
        L_0x0049:
            int r5 = f650     // Catch:{ all -> 0x00df }
            r6 = r5 ^ 27
            r0 = r5 & 27
            r6 = r6 | r0
            int r6 = r6 << r3
            int r0 = ~r0     // Catch:{ all -> 0x00df }
            r5 = r5 | 27
            r5 = r5 & r0
            int r5 = -r5
            int r5 = ~r5     // Catch:{ all -> 0x00df }
            int r6 = r6 - r5
            int r6 = r6 - r3
            int r5 = r6 % 128
            f649 = r5     // Catch:{ all -> 0x00df }
            int r6 = r6 % 2
            boolean r5 = r4.m720(r7)     // Catch:{ all -> 0x00df }
            if (r5 != 0) goto L_0x0067
            r5 = 0
            goto L_0x0068
        L_0x0067:
            r5 = 1
        L_0x0068:
            if (r5 == 0) goto L_0x00c5
            int r5 = f650     // Catch:{ all -> 0x00df }
            r6 = r5 ^ 115(0x73, float:1.61E-43)
            r7 = r5 & 115(0x73, float:1.61E-43)
            r6 = r6 | r7
            int r6 = r6 << r3
            r7 = r5 & -116(0xffffffffffffff8c, float:NaN)
            int r5 = ~r5     // Catch:{ all -> 0x00df }
            r5 = r5 & 115(0x73, float:1.61E-43)
            r5 = r5 | r7
            int r6 = r6 - r5
            int r5 = r6 % 128
            f649 = r5     // Catch:{ all -> 0x00df }
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x0083
            r5 = 1
            goto L_0x0084
        L_0x0083:
            r5 = 0
        L_0x0084:
            if (r5 == r3) goto L_0x009e
            java.lang.String r5 = r4.f652     // Catch:{ all -> 0x00df }
            boolean r5 = r5.equalsIgnoreCase(r8)     // Catch:{ all -> 0x00df }
            r6 = 0
            super.hashCode()     // Catch:{ all -> 0x009c }
            r6 = 98
            if (r5 != 0) goto L_0x0097
            r5 = 55
            goto L_0x0099
        L_0x0097:
            r5 = 98
        L_0x0099:
            if (r5 == r6) goto L_0x00af
            goto L_0x00c5
        L_0x009c:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x00df }
        L_0x009e:
            java.lang.String r5 = r4.f652     // Catch:{ all -> 0x00df }
            boolean r5 = r5.equalsIgnoreCase(r8)     // Catch:{ all -> 0x00df }
            r6 = 29
            if (r5 != 0) goto L_0x00ab
            r5 = 29
            goto L_0x00ad
        L_0x00ab:
            r5 = 53
        L_0x00ad:
            if (r5 == r6) goto L_0x00c5
        L_0x00af:
            int r5 = f650     // Catch:{ all -> 0x00df }
            int r5 = r5 + 20
            int r5 = r5 - r3
            int r6 = r5 % 128
            f649 = r6     // Catch:{ all -> 0x00df }
            int r5 = r5 % 2
            r6 = 19
            if (r5 == 0) goto L_0x00c1
            r5 = 10
            goto L_0x00c3
        L_0x00c1:
            r5 = 19
        L_0x00c3:
            monitor-exit(r4)
            return r3
        L_0x00c5:
            int r5 = f649     // Catch:{ all -> 0x00df }
            r6 = r5 ^ 17
            r7 = r5 & 17
            r6 = r6 | r7
            int r6 = r6 << r3
            int r7 = ~r7     // Catch:{ all -> 0x00df }
            r5 = r5 | 17
            r5 = r5 & r7
            int r5 = -r5
            r7 = r6 | r5
            int r7 = r7 << r3
            r5 = r5 ^ r6
            int r7 = r7 - r5
            int r5 = r7 % 128
            f650 = r5     // Catch:{ all -> 0x00df }
            int r7 = r7 % 2
            monitor-exit(r4)
            return r1
        L_0x00df:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.CountDownLatchWrapper.isSameCard(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m720(String str) {
        int i2 = f650;
        int i3 = (i2 ^ 15) + ((i2 & 15) << 1);
        f649 = i3 % 128;
        int i4 = i3 % 2;
        if ((TextUtils.isEmpty(this.f651) ? 6 : 'Z') != 'Z') {
            if ((TextUtils.isEmpty(str) ? '*' : 'E') != 'E') {
                int i5 = f650;
                int i6 = (i5 ^ 93) + ((i5 & 93) << 1);
                f649 = i6 % 128;
                if ((i6 % 2 != 0 ? 'I' : '_') != '_') {
                }
                return true;
            }
            int i7 = (f649 + 83) - 1;
            int i8 = (i7 & -1) + (i7 | -1);
            f650 = i8 % 128;
            int i9 = i8 % 2;
            boolean equalsIgnoreCase = str.equalsIgnoreCase(this.f651);
            int i10 = f650;
            int i11 = i10 & 69;
            int i12 = (i10 ^ 69) | i11;
            int i13 = (i11 & i12) + (i12 | i11);
            f649 = i13 % 128;
            if ((i13 % 2 != 0 ? '`' : 'Q') != 'Q') {
                return equalsIgnoreCase;
            }
            Object obj = null;
            super.hashCode();
            return equalsIgnoreCase;
        }
        int i14 = f650;
        int i15 = i14 & 65;
        int i16 = -(-((i14 ^ 65) | i15));
        int i17 = ((i15 | i16) << 1) - (i16 ^ i15);
        f649 = i17 % 128;
        boolean z = false;
        if (i17 % 2 != 0) {
        }
        boolean equalsIgnoreCase2 = this.f651.equalsIgnoreCase(str);
        int i18 = f649;
        int i19 = i18 & 103;
        int i20 = (i18 ^ 103) | i19;
        int i21 = (i19 ^ i20) + ((i20 & i19) << 1);
        f650 = i21 % 128;
        if (i21 % 2 != 0) {
            z = true;
        }
        if (!z) {
        }
        return equalsIgnoreCase2;
    }
}
