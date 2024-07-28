package com.google.android.exoplayer2.e.a;

import android.text.Layout;

final class b extends com.google.android.exoplayer2.e.b implements Comparable<b> {
    public final int p;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i2 = ((b) obj).p;
        int i3 = this.p;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, float f3, int i3, boolean z, int i4, int i5) {
        super(charSequence, alignment, f2, 0, i2, f3, i3, Float.MIN_VALUE, z, i4);
        this.p = i5;
    }
}
