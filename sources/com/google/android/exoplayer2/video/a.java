package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f33662a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33663b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33664c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33665d;

    /* renamed from: e  reason: collision with root package name */
    public final float f33666e;

    public static a a(r rVar) throws v {
        float f2;
        int i2;
        int i3;
        try {
            rVar.d(4);
            int c2 = (rVar.c() & 3) + 1;
            if (c2 != 3) {
                ArrayList arrayList = new ArrayList();
                int c3 = rVar.c() & 31;
                for (int i4 = 0; i4 < c3; i4++) {
                    arrayList.add(b(rVar));
                }
                int c4 = rVar.c();
                for (int i5 = 0; i5 < c4; i5++) {
                    arrayList.add(b(rVar));
                }
                if (c3 > 0) {
                    p.b a2 = p.a((byte[]) arrayList.get(0), c2, ((byte[]) arrayList.get(0)).length);
                    int i6 = a2.f32557e;
                    int i7 = a2.f32558f;
                    f2 = a2.f32559g;
                    i3 = i6;
                    i2 = i7;
                } else {
                    i3 = -1;
                    i2 = -1;
                    f2 = 1.0f;
                }
                return new a(arrayList, c2, i3, i2, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new v("Error parsing AVC config", e2);
        }
    }

    private a(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.f33662a = list;
        this.f33663b = i2;
        this.f33664c = i3;
        this.f33665d = i4;
        this.f33666e = f2;
    }

    private static byte[] b(r rVar) {
        int d2 = rVar.d();
        int i2 = rVar.f32567b;
        rVar.d(d2);
        return c.a(rVar.f32566a, i2, d2);
    }
}
