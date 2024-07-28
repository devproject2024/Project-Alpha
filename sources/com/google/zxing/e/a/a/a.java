package com.google.zxing.e.a.a;

import java.util.List;

final class a {
    static com.google.zxing.b.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).f40340b == null) {
            size--;
        }
        com.google.zxing.b.a aVar = new com.google.zxing.b.a(size * 12);
        int i2 = list.get(0).f40340b.f40349a;
        int i3 = 0;
        for (int i4 = 11; i4 >= 0; i4--) {
            if (((1 << i4) & i2) != 0) {
                aVar.b(i3);
            }
            i3++;
        }
        for (int i5 = 1; i5 < list.size(); i5++) {
            b bVar = list.get(i5);
            int i6 = bVar.f40339a.f40349a;
            int i7 = i3;
            for (int i8 = 11; i8 >= 0; i8--) {
                if (((1 << i8) & i6) != 0) {
                    aVar.b(i7);
                }
                i7++;
            }
            if (bVar.f40340b != null) {
                int i9 = bVar.f40340b.f40349a;
                for (int i10 = 11; i10 >= 0; i10--) {
                    if (((1 << i10) & i9) != 0) {
                        aVar.b(i7);
                    }
                    i7++;
                }
            }
            i3 = i7;
        }
        return aVar;
    }
}
