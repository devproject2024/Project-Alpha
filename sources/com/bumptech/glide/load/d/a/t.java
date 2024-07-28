package com.bumptech.glide.load.d.a;

import android.os.Build;
import android.util.Log;
import java.io.File;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final File f7172a = new File("/proc/self/fd");

    /* renamed from: b  reason: collision with root package name */
    private static volatile t f7173b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7174c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7175d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7176e;

    /* renamed from: f  reason: collision with root package name */
    private int f7177f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7178g = true;

    public static t a() {
        if (f7173b == null) {
            synchronized (t.class) {
                if (f7173b == null) {
                    f7173b = new t();
                }
            }
        }
        return f7173b;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    t() {
        /*
            r5 = this;
            r5.<init>()
            r0 = 1
            r5.f7178g = r0
            java.lang.String r1 = android.os.Build.MODEL
            r2 = 0
            if (r1 == 0) goto L_0x0076
            java.lang.String r1 = android.os.Build.MODEL
            int r1 = r1.length()
            r3 = 7
            if (r1 >= r3) goto L_0x0015
            goto L_0x0076
        L_0x0015:
            java.lang.String r1 = android.os.Build.MODEL
            java.lang.String r1 = r1.substring(r2, r3)
            r3 = -1
            int r4 = r1.hashCode()
            switch(r4) {
                case -1398613787: goto L_0x0060;
                case -1398431166: goto L_0x0056;
                case -1398431161: goto L_0x004c;
                case -1398431073: goto L_0x0042;
                case -1398431068: goto L_0x0038;
                case -1398343746: goto L_0x002e;
                case -1398222624: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x006a
        L_0x0024:
            java.lang.String r4 = "SM-N935"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x006a
            r1 = 0
            goto L_0x006b
        L_0x002e:
            java.lang.String r4 = "SM-J720"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x0038:
            java.lang.String r4 = "SM-G965"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x006a
            r1 = 3
            goto L_0x006b
        L_0x0042:
            java.lang.String r4 = "SM-G960"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x006a
            r1 = 2
            goto L_0x006b
        L_0x004c:
            java.lang.String r4 = "SM-G935"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x006a
            r1 = 4
            goto L_0x006b
        L_0x0056:
            java.lang.String r4 = "SM-G930"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x006a
            r1 = 5
            goto L_0x006b
        L_0x0060:
            java.lang.String r4 = "SM-A520"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x006a
            r1 = 6
            goto L_0x006b
        L_0x006a:
            r1 = -1
        L_0x006b:
            switch(r1) {
                case 0: goto L_0x006f;
                case 1: goto L_0x006f;
                case 2: goto L_0x006f;
                case 3: goto L_0x006f;
                case 4: goto L_0x006f;
                case 5: goto L_0x006f;
                case 6: goto L_0x006f;
                default: goto L_0x006e;
            }
        L_0x006e:
            goto L_0x0076
        L_0x006f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r1 != r3) goto L_0x0076
            r0 = 0
        L_0x0076:
            r5.f7174c = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x0085
            r0 = 20000(0x4e20, float:2.8026E-41)
            r5.f7175d = r0
            r5.f7176e = r2
            return
        L_0x0085:
            r0 = 700(0x2bc, float:9.81E-43)
            r5.f7175d = r0
            r0 = 128(0x80, float:1.794E-43)
            r5.f7176e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.t.<init>():void");
    }

    public final boolean a(int i2, int i3, boolean z, boolean z2) {
        int i4;
        if (!z || !this.f7174c || Build.VERSION.SDK_INT < 26 || z2 || i2 < (i4 = this.f7176e) || i3 < i4 || !b()) {
            return false;
        }
        return true;
    }

    private synchronized boolean b() {
        int i2 = this.f7177f + 1;
        this.f7177f = i2;
        if (i2 >= 50) {
            boolean z = false;
            this.f7177f = 0;
            int length = f7172a.list().length;
            if (length < this.f7175d) {
                z = true;
            }
            this.f7178g = z;
            if (!this.f7178g && Log.isLoggable("Downsampler", 5)) {
                StringBuilder sb = new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb.append(length);
                sb.append(", limit ");
                sb.append(this.f7175d);
            }
        }
        return this.f7178g;
    }
}
