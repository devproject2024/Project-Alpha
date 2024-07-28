package net.one97.paytm.payments.visascp.util;

import android.util.TimingLogger;

public class TimeLogger {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static TimeLogger f658 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f659 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f660 = 1;

    /* renamed from: ˋ  reason: contains not printable characters */
    private TimingLogger f661;

    static {
        int i2 = f660;
        int i3 = (i2 & 19) + (i2 | 19);
        f659 = i3 % 128;
        if (i3 % 2 != 0) {
        }
    }

    private TimeLogger(String str) {
        this.f661 = new TimingLogger(VisaSCPConstants.LOG_TAG, str);
    }

    public static TimeLogger getInstance(String str) {
        int i2 = f660;
        int i3 = (i2 ^ 119) + ((i2 & 119) << 1);
        f659 = i3 % 128;
        if ((i3 % 2 == 0 ? '0' : 'I') == '0' ? f658 == null : f658 == null) {
            f658 = new TimeLogger(str);
            int i4 = f659;
            int i5 = i4 & 113;
            int i6 = i4 | 113;
            int i7 = ((i5 | i6) << 1) - (i6 ^ i5);
            f660 = i7 % 128;
            if (i7 % 2 != 0) {
            }
        }
        TimeLogger timeLogger = f658;
        int i8 = f659;
        int i9 = ((i8 | 93) << 1) - (i8 ^ 93);
        f660 = i9 % 128;
        if (i9 % 2 == 0) {
        }
        return timeLogger;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if ((r4.f661 == null) != true) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if ((r4.f661 == null ? '`' : '3') != '3') goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addSplit(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = f660
            r1 = r0 | 73
            r2 = 1
            int r1 = r1 << r2
            r3 = r0 & -74
            int r0 = ~r0
            r0 = r0 & 73
            r0 = r0 | r3
            int r1 = r1 - r0
            int r0 = r1 % 128
            f659 = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 != 0) goto L_0x0018
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            if (r1 == 0) goto L_0x0029
            android.util.TimingLogger r1 = r4.f661
            r3 = 51
            if (r1 != 0) goto L_0x0024
            r1 = 96
            goto L_0x0026
        L_0x0024:
            r1 = 51
        L_0x0026:
            if (r1 == r3) goto L_0x0032
            goto L_0x005d
        L_0x0029:
            android.util.TimingLogger r1 = r4.f661
            if (r1 != 0) goto L_0x002f
            r1 = 1
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            if (r1 == r2) goto L_0x005d
        L_0x0032:
            int r1 = f660
            r3 = r1 ^ 100
            r1 = r1 & 100
            int r1 = r1 << r2
            int r3 = r3 + r1
            int r3 = r3 - r2
            int r1 = r3 % 128
            f659 = r1
            int r3 = r3 % 2
            android.util.TimingLogger r1 = r4.f661
            r1.addSplit(r5)
            int r5 = f660
            r1 = r5 & 59
            r5 = r5 ^ 59
            r5 = r5 | r1
            int r1 = r1 + r5
            int r5 = r1 % 128
            f659 = r5
            int r1 = r1 % 2
            r5 = 9
            if (r1 != 0) goto L_0x005b
            r1 = 9
            goto L_0x005d
        L_0x005b:
            r1 = 26
        L_0x005d:
            int r5 = f659
            r1 = r5 & 65
            int r3 = ~r1
            r5 = r5 | 65
            r5 = r5 & r3
            int r1 = r1 << r2
            r3 = r5 & r1
            r5 = r5 | r1
            int r3 = r3 + r5
            int r5 = r3 % 128
            f660 = r5
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r0 = 1
        L_0x0074:
            if (r0 == 0) goto L_0x007d
            r5 = 0
            super.hashCode()     // Catch:{ all -> 0x007b }
            return
        L_0x007b:
            r5 = move-exception
            throw r5
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.TimeLogger.addSplit(java.lang.String):void");
    }

    public void dumpToLog() {
        int i2 = f659;
        int i3 = (i2 & 114) + (i2 | 114);
        int i4 = (i3 & -1) + (i3 | -1);
        f660 = i4 % 128;
        int i5 = i4 % 2;
        if ((this.f661 == null ? '&' : 4) == 4) {
            int i6 = f660;
            int i7 = i6 ^ 59;
            int i8 = ((i6 & 59) | i7) << 1;
            int i9 = -i7;
            int i10 = (i8 ^ i9) + ((i8 & i9) << 1);
            f659 = i10 % 128;
            if (i10 % 2 == 0) {
            }
            this.f661.dumpToLog();
        }
        int i11 = f660;
        int i12 = i11 & 65;
        int i13 = i12 + ((i11 ^ 65) | i12);
        f659 = i13 % 128;
        int i14 = i13 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r1 != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r1 != true) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reset() {
        /*
            r4 = this;
            int r0 = f660
            int r0 = r0 + 23
            int r1 = r0 % 128
            f659 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 == 0) goto L_0x001b
            android.util.TimingLogger r0 = r4.f661
            if (r0 != 0) goto L_0x0018
            r1 = 1
        L_0x0018:
            if (r1 == r2) goto L_0x004b
            goto L_0x0023
        L_0x001b:
            android.util.TimingLogger r0 = r4.f661
            if (r0 != 0) goto L_0x0020
            r1 = 1
        L_0x0020:
            if (r1 == 0) goto L_0x0023
            goto L_0x004b
        L_0x0023:
            android.util.TimingLogger r0 = r4.f661
            r0.reset()
            int r0 = f659
            r1 = r0 ^ 119(0x77, float:1.67E-43)
            r3 = r0 & 119(0x77, float:1.67E-43)
            r1 = r1 | r3
            int r1 = r1 << r2
            r3 = r0 & -120(0xffffffffffffff88, float:NaN)
            int r0 = ~r0
            r0 = r0 & 119(0x77, float:1.67E-43)
            r0 = r0 | r3
            int r0 = -r0
            r3 = r1 | r0
            int r3 = r3 << r2
            r0 = r0 ^ r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f660 = r0
            int r3 = r3 % 2
            r0 = 73
            if (r3 == 0) goto L_0x0049
            r1 = 90
            goto L_0x004b
        L_0x0049:
            r1 = 73
        L_0x004b:
            int r0 = f659
            r1 = r0 | 113(0x71, float:1.58E-43)
            int r1 = r1 << r2
            r0 = r0 ^ 113(0x71, float:1.58E-43)
            int r1 = r1 - r0
            int r0 = r1 % 128
            f660 = r0
            int r1 = r1 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.TimeLogger.reset():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if ((r0 == null ? 'X' : '\"') != 'X') goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if ((r3.f661 != null) != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reset(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = f660
            r1 = r0 & 109(0x6d, float:1.53E-43)
            int r2 = ~r1
            r0 = r0 | 109(0x6d, float:1.53E-43)
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r1 = ~r1
            int r0 = r0 - r1
            int r0 = r0 - r2
            int r1 = r0 % 128
            f659 = r1
            int r0 = r0 % 2
            r1 = 39
            if (r0 != 0) goto L_0x001a
            r0 = 39
            goto L_0x001c
        L_0x001a:
            r0 = 65
        L_0x001c:
            if (r0 == r1) goto L_0x0032
            android.util.TimingLogger r0 = r3.f661
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x0030 }
            r1 = 88
            if (r0 != 0) goto L_0x002b
            r0 = 88
            goto L_0x002d
        L_0x002b:
            r0 = 34
        L_0x002d:
            if (r0 == r1) goto L_0x005a
            goto L_0x003b
        L_0x0030:
            r4 = move-exception
            throw r4
        L_0x0032:
            android.util.TimingLogger r0 = r3.f661
            if (r0 != 0) goto L_0x0038
            r0 = 0
            goto L_0x0039
        L_0x0038:
            r0 = 1
        L_0x0039:
            if (r0 == 0) goto L_0x005a
        L_0x003b:
            int r0 = f659
            int r0 = r0 + 91
            int r1 = r0 % 128
            f660 = r1
            int r0 = r0 % 2
            android.util.TimingLogger r0 = r3.f661
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            r0.reset(r1, r4)
            int r4 = f659
            r0 = r4 | 99
            int r0 = r0 << r2
            r4 = r4 ^ 99
            int r0 = r0 - r4
            int r4 = r0 % 128
            f660 = r4
            int r0 = r0 % 2
        L_0x005a:
            int r4 = f660
            r0 = r4 | 51
            int r0 = r0 << r2
            r4 = r4 ^ 51
            int r0 = r0 - r4
            int r4 = r0 % 128
            f659 = r4
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.util.TimeLogger.reset(java.lang.String):void");
    }
}
