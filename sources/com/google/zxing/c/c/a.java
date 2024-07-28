package com.google.zxing.c.c;

final class a implements g {
    a() {
    }

    public final void a(h hVar) {
        int i2;
        String str = hVar.f39974a;
        int i3 = hVar.f39979f;
        int length = str.length();
        if (i3 < length) {
            char charAt = str.charAt(i3);
            i2 = 0;
            while (j.a(charAt) && i3 < length) {
                i2++;
                i3++;
                if (i3 < length) {
                    charAt = str.charAt(i3);
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 >= 2) {
            char charAt2 = hVar.f39974a.charAt(hVar.f39979f);
            char charAt3 = hVar.f39974a.charAt(hVar.f39979f + 1);
            if (!j.a(charAt2) || !j.a(charAt3)) {
                throw new IllegalArgumentException("not digits: " + charAt2 + charAt3);
            }
            hVar.a((char) (((charAt2 - '0') * 10) + (charAt3 - '0') + 130));
            hVar.f39979f += 2;
            return;
        }
        char a2 = hVar.a();
        int a3 = j.a(hVar.f39974a, hVar.f39979f, 0);
        if (a3 != 0) {
            if (a3 == 1) {
                hVar.a(230);
                hVar.f39980g = 1;
            } else if (a3 == 2) {
                hVar.a(239);
                hVar.f39980g = 2;
            } else if (a3 == 3) {
                hVar.a(238);
                hVar.f39980g = 3;
            } else if (a3 == 4) {
                hVar.a(240);
                hVar.f39980g = 4;
            } else if (a3 == 5) {
                hVar.a(231);
                hVar.f39980g = 5;
            } else {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(a3)));
            }
        } else if (j.b(a2)) {
            hVar.a(235);
            hVar.a((char) ((a2 - 128) + 1));
            hVar.f39979f++;
        } else {
            hVar.a((char) (a2 + 1));
            hVar.f39979f++;
        }
    }
}
