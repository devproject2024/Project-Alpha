package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.ae;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final int f31280a = ae.h("RIFF");

    /* renamed from: b  reason: collision with root package name */
    public static final int f31281b = ae.h("WAVE");

    /* renamed from: c  reason: collision with root package name */
    public static final int f31282c = ae.h("fmt ");

    /* renamed from: d  reason: collision with root package name */
    public static final int f31283d = ae.h("data");

    public static int a(int i2, int i3) {
        if (i2 != 1) {
            if (i2 == 3) {
                return i3 == 32 ? 4 : 0;
            }
            if (i2 != 65534) {
                if (i2 != 6) {
                    return i2 != 7 ? 0 : 268435456;
                }
                return 536870912;
            }
        }
        return ae.b(i3);
    }
}
