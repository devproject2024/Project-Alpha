package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.util.Collections;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f33692a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33693b;

    public static c a(r rVar) throws v {
        List list;
        try {
            rVar.d(21);
            int c2 = rVar.c() & 3;
            int c3 = rVar.c();
            int i2 = rVar.f32567b;
            int i3 = 0;
            int i4 = 0;
            while (i3 < c3) {
                rVar.d(1);
                int d2 = rVar.d();
                int i5 = i4;
                for (int i6 = 0; i6 < d2; i6++) {
                    int d3 = rVar.d();
                    i5 += d3 + 4;
                    rVar.d(d3);
                }
                i3++;
                i4 = i5;
            }
            rVar.c(i2);
            byte[] bArr = new byte[i4];
            int i7 = 0;
            int i8 = 0;
            while (i7 < c3) {
                rVar.d(1);
                int d4 = rVar.d();
                int i9 = i8;
                for (int i10 = 0; i10 < d4; i10++) {
                    int d5 = rVar.d();
                    System.arraycopy(p.f32546a, 0, bArr, i9, p.f32546a.length);
                    int length = i9 + p.f32546a.length;
                    System.arraycopy(rVar.f32566a, rVar.f32567b, bArr, length, d5);
                    i9 = length + d5;
                    rVar.d(d5);
                }
                i7++;
                i8 = i9;
            }
            if (i4 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new c(list, c2 + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new v("Error parsing HEVC config", e2);
        }
    }

    private c(List<byte[]> list, int i2) {
        this.f33692a = list;
        this.f33693b = i2;
    }
}
