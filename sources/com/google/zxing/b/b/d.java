package com.google.zxing.b.b;

import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f39905a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f39906b = new ArrayList();

    public d(a aVar) {
        this.f39905a = aVar;
        this.f39906b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i2) {
        if (i2 >= this.f39906b.size()) {
            List<b> list = this.f39906b;
            b bVar = list.get(list.size() - 1);
            for (int size = this.f39906b.size(); size <= i2; size++) {
                a aVar = this.f39905a;
                bVar = bVar.b(new b(aVar, new int[]{1, aVar.f39901i[(size - 1) + aVar.m]}));
                this.f39906b.add(bVar);
            }
        }
        return this.f39906b.get(i2);
    }

    public final void a(int[] iArr, int i2) {
        if (i2 != 0) {
            int length = iArr.length - i2;
            if (length > 0) {
                b a2 = a(i2);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] iArr3 = new b(this.f39905a, iArr2).a(i2, 1).c(a2)[1].f39902a;
                int length2 = i2 - iArr3.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr[length + i3] = 0;
                }
                System.arraycopy(iArr3, 0, iArr, length + length2, iArr3.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
