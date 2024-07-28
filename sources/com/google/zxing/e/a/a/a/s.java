package com.google.zxing.e.a.a.a;

import com.google.zxing.b.a;
import com.google.zxing.e.a.a.a.m;
import com.google.zxing.h;
import com.google.zxing.m;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;

final class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f40336a;

    /* renamed from: b  reason: collision with root package name */
    private final m f40337b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f40338c = new StringBuilder();

    s(a aVar) {
        this.f40336a = aVar;
    }

    /* access modifiers changed from: package-private */
    public final String a(StringBuilder sb, int i2) throws m, h {
        String str;
        String str2 = null;
        while (true) {
            o a2 = a(i2, str2);
            String a3 = r.a(a2.f40325a);
            if (a3 != null) {
                sb.append(a3);
            }
            if (a2.f40327c) {
                str = String.valueOf(a2.f40326b);
            } else {
                str = null;
            }
            if (i2 == a2.f40330d) {
                return sb.toString();
            }
            i2 = a2.f40330d;
            str2 = str;
        }
    }

    private boolean a(int i2) {
        if (i2 + 7 <= this.f40336a.f39881b) {
            int i3 = i2;
            while (true) {
                int i4 = i2 + 3;
                if (i3 >= i4) {
                    return this.f40336a.a(i4);
                }
                if (this.f40336a.a(i3)) {
                    return true;
                }
                i3++;
            }
        } else if (i2 + 4 <= this.f40336a.f39881b) {
            return true;
        } else {
            return false;
        }
    }

    private p b(int i2) throws h {
        int i3 = i2 + 7;
        if (i3 > this.f40336a.f39881b) {
            int a2 = a(i2, 4);
            if (a2 == 0) {
                return new p(this.f40336a.f39881b, 10, 10);
            }
            return new p(this.f40336a.f39881b, a2 - 1, 10);
        }
        int a3 = a(i2, 7) - 8;
        return new p(i3, a3 / 11, a3 % 11);
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2, int i3) {
        return a(this.f40336a, i2, i3);
    }

    static int a(a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.a(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final o a(int i2, String str) throws h {
        this.f40338c.setLength(0);
        if (str != null) {
            this.f40338c.append(str);
        }
        this.f40337b.f40322a = i2;
        o a2 = a();
        if (a2 == null || !a2.f40327c) {
            return new o(this.f40337b.f40322a, this.f40338c.toString());
        }
        return new o(this.f40337b.f40322a, this.f40338c.toString(), a2.f40326b);
    }

    private o a() throws h {
        boolean z;
        l lVar;
        do {
            int i2 = this.f40337b.f40322a;
            if (this.f40337b.a()) {
                lVar = d();
                z = lVar.f40321b;
            } else if (this.f40337b.b()) {
                lVar = c();
                z = lVar.f40321b;
            } else {
                lVar = b();
                z = lVar.f40321b;
            }
            if (!(i2 != this.f40337b.f40322a) && !z) {
                break;
            }
        } while (!z);
        return lVar.f40320a;
    }

    private l b() throws h {
        o oVar;
        while (a(this.f40337b.f40322a)) {
            p b2 = b(this.f40337b.f40322a);
            this.f40337b.f40322a = b2.f40330d;
            if (b2.a()) {
                if (b2.b()) {
                    oVar = new o(this.f40337b.f40322a, this.f40338c.toString());
                } else {
                    oVar = new o(this.f40337b.f40322a, this.f40338c.toString(), b2.f40329b);
                }
                return new l(oVar, true);
            }
            this.f40338c.append(b2.f40328a);
            if (b2.b()) {
                return new l(new o(this.f40337b.f40322a, this.f40338c.toString()), true);
            }
            this.f40338c.append(b2.f40329b);
        }
        if (i(this.f40337b.f40322a)) {
            this.f40337b.f40323b = m.a.ALPHA;
            this.f40337b.a(4);
        }
        return new l();
    }

    private l c() throws h {
        while (c(this.f40337b.f40322a)) {
            n d2 = d(this.f40337b.f40322a);
            this.f40337b.f40322a = d2.f40330d;
            if (d2.a()) {
                return new l(new o(this.f40337b.f40322a, this.f40338c.toString()), true);
            }
            this.f40338c.append(d2.f40324a);
        }
        if (h(this.f40337b.f40322a)) {
            this.f40337b.a(3);
            this.f40337b.f40323b = m.a.NUMERIC;
        } else if (g(this.f40337b.f40322a)) {
            if (this.f40337b.f40322a + 5 < this.f40336a.f39881b) {
                this.f40337b.a(5);
            } else {
                this.f40337b.f40322a = this.f40336a.f39881b;
            }
            this.f40337b.f40323b = m.a.ALPHA;
        }
        return new l();
    }

    private l d() {
        while (e(this.f40337b.f40322a)) {
            n f2 = f(this.f40337b.f40322a);
            this.f40337b.f40322a = f2.f40330d;
            if (f2.a()) {
                return new l(new o(this.f40337b.f40322a, this.f40338c.toString()), true);
            }
            this.f40338c.append(f2.f40324a);
        }
        if (h(this.f40337b.f40322a)) {
            this.f40337b.a(3);
            this.f40337b.f40323b = m.a.NUMERIC;
        } else if (g(this.f40337b.f40322a)) {
            if (this.f40337b.f40322a + 5 < this.f40336a.f39881b) {
                this.f40337b.a(5);
            } else {
                this.f40337b.f40322a = this.f40336a.f39881b;
            }
            this.f40337b.f40323b = m.a.ISO_IEC_646;
        }
        return new l();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r5 = a(r5, 8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(int r5) {
        /*
            r4 = this;
            int r0 = r5 + 5
            com.google.zxing.b.a r1 = r4.f40336a
            int r1 = r1.f39881b
            r2 = 0
            if (r0 <= r1) goto L_0x000a
            return r2
        L_0x000a:
            r0 = 5
            int r1 = r4.a((int) r5, (int) r0)
            r3 = 1
            if (r1 < r0) goto L_0x0017
            r0 = 16
            if (r1 >= r0) goto L_0x0017
            return r3
        L_0x0017:
            int r0 = r5 + 7
            com.google.zxing.b.a r1 = r4.f40336a
            int r1 = r1.f39881b
            if (r0 <= r1) goto L_0x0020
            return r2
        L_0x0020:
            r0 = 7
            int r0 = r4.a((int) r5, (int) r0)
            r1 = 64
            if (r0 < r1) goto L_0x002e
            r1 = 116(0x74, float:1.63E-43)
            if (r0 >= r1) goto L_0x002e
            return r3
        L_0x002e:
            int r0 = r5 + 8
            com.google.zxing.b.a r1 = r4.f40336a
            int r1 = r1.f39881b
            if (r0 <= r1) goto L_0x0037
            return r2
        L_0x0037:
            r0 = 8
            int r5 = r4.a((int) r5, (int) r0)
            r0 = 232(0xe8, float:3.25E-43)
            if (r5 < r0) goto L_0x0046
            r0 = 253(0xfd, float:3.55E-43)
            if (r5 >= r0) goto L_0x0046
            return r3
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.a.a.a.s.c(int):boolean");
    }

    private n d(int i2) throws h {
        char c2;
        int a2 = a(i2, 5);
        if (a2 == 15) {
            return new n(i2 + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i2 + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i2, 7);
        if (a3 >= 64 && a3 < 90) {
            return new n(i2 + 7, (char) (a3 + 1));
        }
        if (a3 >= 90 && a3 < 116) {
            return new n(i2 + 7, (char) (a3 + 7));
        }
        switch (a(i2, 8)) {
            case 232:
                c2 = '!';
                break;
            case UpiPushView.REQUEST_CODE_UPI_CHECK_BALANCE /*233*/:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case 250:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw h.getFormatInstance();
        }
        return new n(i2 + 8, c2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r6 = a(r6, 6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r6) {
        /*
            r5 = this;
            int r0 = r6 + 5
            com.google.zxing.b.a r1 = r5.f40336a
            int r1 = r1.f39881b
            r2 = 0
            if (r0 <= r1) goto L_0x000a
            return r2
        L_0x000a:
            r0 = 5
            int r1 = r5.a((int) r6, (int) r0)
            r3 = 1
            r4 = 16
            if (r1 < r0) goto L_0x0017
            if (r1 >= r4) goto L_0x0017
            return r3
        L_0x0017:
            int r0 = r6 + 6
            com.google.zxing.b.a r1 = r5.f40336a
            int r1 = r1.f39881b
            if (r0 <= r1) goto L_0x0020
            return r2
        L_0x0020:
            r0 = 6
            int r6 = r5.a((int) r6, (int) r0)
            if (r6 < r4) goto L_0x002c
            r0 = 63
            if (r6 >= r0) goto L_0x002c
            return r3
        L_0x002c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.a.a.a.s.e(int):boolean");
    }

    private n f(int i2) {
        char c2;
        int a2 = a(i2, 5);
        if (a2 == 15) {
            return new n(i2 + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i2 + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i2, 6);
        if (a3 >= 32 && a3 < 58) {
            return new n(i2 + 6, (char) (a3 + 33));
        }
        switch (a3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(a3)));
        }
        return new n(i2 + 6, c2);
    }

    private boolean g(int i2) {
        int i3;
        if (i2 + 1 > this.f40336a.f39881b) {
            return false;
        }
        int i4 = 0;
        while (i4 < 5 && (i3 = i4 + i2) < this.f40336a.f39881b) {
            if (i4 == 2) {
                if (!this.f40336a.a(i2 + 2)) {
                    return false;
                }
            } else if (this.f40336a.a(i3)) {
                return false;
            }
            i4++;
        }
        return true;
    }

    private boolean h(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.f40336a.f39881b) {
            return false;
        }
        while (i2 < i3) {
            if (this.f40336a.a(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean i(int i2) {
        int i3;
        if (i2 + 1 > this.f40336a.f39881b) {
            return false;
        }
        int i4 = 0;
        while (i4 < 4 && (i3 = i4 + i2) < this.f40336a.f39881b) {
            if (this.f40336a.a(i3)) {
                return false;
            }
            i4++;
        }
        return true;
    }
}
