package com.google.zxing.c.c;

import net.one97.paytm.upi.util.UpiConstants;

class c implements g {
    public int a() {
        return 1;
    }

    c() {
    }

    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.b()) {
                break;
            }
            char a2 = hVar.a();
            hVar.f39979f++;
            int a3 = a(a2, sb);
            int length = hVar.f39978e.length() + ((sb.length() / 3) << 1);
            hVar.a(length);
            int i2 = hVar.f39981h.f39989b - length;
            if (hVar.b()) {
                if (sb.length() % 3 == 0 && j.a(hVar.f39974a, hVar.f39979f, a()) != a()) {
                    hVar.f39980g = 0;
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (i2 < 2 || i2 > 2)) {
                    a3 = a(hVar, sb, sb2, a3);
                }
                while (sb.length() % 3 == 1 && ((a3 <= 3 && i2 != 1) || a3 > 3)) {
                    a3 = a(hVar, sb, sb2, a3);
                }
            }
        }
        b(hVar, sb);
    }

    private int a(h hVar, StringBuilder sb, StringBuilder sb2, int i2) {
        int length = sb.length();
        sb.delete(length - i2, length);
        hVar.f39979f--;
        int a2 = a(hVar.a(), sb2);
        hVar.f39981h = null;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void b(h hVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int length2 = hVar.f39978e.length() + ((sb.length() / 3) << 1);
        hVar.a(length2);
        int i2 = hVar.f39981h.f39989b - length2;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (hVar.b()) {
                hVar.a(254);
            }
        } else if (i2 == 1 && length == 1) {
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (hVar.b()) {
                hVar.a(254);
            }
            hVar.f39979f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (i2 > 0 || hVar.b()) {
                hVar.a(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.f39980g = 0;
    }

    /* access modifiers changed from: package-private */
    public int a(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append(3);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            return 1;
        } else if (c2 < ' ') {
            sb.append(0);
            sb.append(c2);
            return 2;
        } else if (c2 >= '!' && c2 <= '/') {
            sb.append(1);
            sb.append((char) (c2 - '!'));
            return 2;
        } else if (c2 >= ':' && c2 <= '@') {
            sb.append(1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        } else if (c2 >= '[' && c2 <= '_') {
            sb.append(1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        } else if (c2 < '`' || c2 > 127) {
            sb.append("\u0001\u001e");
            return a((char) (c2 - 128), sb) + 2;
        } else {
            sb.append(2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
    }

    static void a(h hVar, StringBuilder sb) {
        int charAt = (sb.charAt(0) * 1600) + (sb.charAt(1) * '(') + sb.charAt(2) + 1;
        hVar.a(new String(new char[]{(char) (charAt / UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS), (char) (charAt % UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS)}));
        sb.delete(0, 3);
    }
}
