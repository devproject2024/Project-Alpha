package com.google.zxing.c.c;

final class n extends c {
    public final int a() {
        return 3;
    }

    n() {
    }

    public final void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.b()) {
                break;
            }
            char a2 = hVar.a();
            hVar.f39979f++;
            a(a2, sb);
            if (sb.length() % 3 == 0) {
                a(hVar, sb);
                if (j.a(hVar.f39974a, hVar.f39979f, 3) != 3) {
                    hVar.f39980g = 0;
                    break;
                }
            }
        }
        b(hVar, sb);
    }

    /* access modifiers changed from: package-private */
    public final int a(char c2, StringBuilder sb) {
        if (c2 == 13) {
            sb.append(0);
        } else if (c2 == ' ') {
            sb.append(3);
        } else if (c2 == '*') {
            sb.append(1);
        } else if (c2 == '>') {
            sb.append(2);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 < 'A' || c2 > 'Z') {
            j.c(c2);
        } else {
            sb.append((char) ((c2 - 'A') + 14));
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public final void b(h hVar, StringBuilder sb) {
        hVar.d();
        int length = hVar.f39981h.f39989b - hVar.f39978e.length();
        hVar.f39979f -= sb.length();
        if (hVar.c() > 1 || length > 1 || hVar.c() != length) {
            hVar.a(254);
        }
        if (hVar.f39980g < 0) {
            hVar.f39980g = 0;
        }
    }
}
