package com.google.android.exoplayer2.e.a;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.j;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    private final r f31414b = new r();

    /* renamed from: c  reason: collision with root package name */
    private final q f31415c = new q();

    /* renamed from: d  reason: collision with root package name */
    private final int f31416d;

    /* renamed from: e  reason: collision with root package name */
    private final a[] f31417e;

    /* renamed from: f  reason: collision with root package name */
    private a f31418f;

    /* renamed from: g  reason: collision with root package name */
    private List<com.google.android.exoplayer2.e.b> f31419g;

    /* renamed from: h  reason: collision with root package name */
    private List<com.google.android.exoplayer2.e.b> f31420h;

    /* renamed from: i  reason: collision with root package name */
    private b f31421i;
    private int j;

    public final /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    public final /* bridge */ /* synthetic */ void b(i iVar) throws g {
        super.a(iVar);
    }

    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public final /* bridge */ /* synthetic */ j g() throws g {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ i h() throws g {
        return super.a();
    }

    public c(int i2) {
        this.f31416d = i2 == -1 ? 1 : i2;
        this.f31417e = new a[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f31417e[i3] = new a();
        }
        this.f31418f = this.f31417e[0];
        l();
    }

    public final void c() {
        super.c();
        this.f31419g = null;
        this.f31420h = null;
        this.j = 0;
        this.f31418f = this.f31417e[this.j];
        l();
        this.f31421i = null;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        return this.f31419g != this.f31420h;
    }

    /* access modifiers changed from: protected */
    public final e f() {
        List<com.google.android.exoplayer2.e.b> list = this.f31419g;
        this.f31420h = list;
        return new e(list);
    }

    /* access modifiers changed from: protected */
    public final void a(i iVar) {
        this.f31414b.a(iVar.f31311c.array(), iVar.f31311c.limit());
        while (this.f31414b.b() >= 3) {
            int c2 = this.f31414b.c() & 7;
            int i2 = c2 & 3;
            boolean z = false;
            boolean z2 = (c2 & 4) == 4;
            byte c3 = (byte) this.f31414b.c();
            byte c4 = (byte) this.f31414b.c();
            if ((i2 == 2 || i2 == 3) && z2) {
                if (i2 == 3) {
                    i();
                    int i3 = (c3 & 192) >> 6;
                    byte b2 = c3 & 63;
                    if (b2 == 0) {
                        b2 = 64;
                    }
                    this.f31421i = new b(i3, b2);
                    byte[] bArr = this.f31421i.f31433c;
                    b bVar = this.f31421i;
                    int i4 = bVar.f31434d;
                    bVar.f31434d = i4 + 1;
                    bArr[i4] = c4;
                } else {
                    if (i2 == 2) {
                        z = true;
                    }
                    com.google.android.exoplayer2.g.a.a(z);
                    b bVar2 = this.f31421i;
                    if (bVar2 == null) {
                        l.d();
                    } else {
                        byte[] bArr2 = bVar2.f31433c;
                        b bVar3 = this.f31421i;
                        int i5 = bVar3.f31434d;
                        bVar3.f31434d = i5 + 1;
                        bArr2[i5] = c3;
                        byte[] bArr3 = this.f31421i.f31433c;
                        b bVar4 = this.f31421i;
                        int i6 = bVar4.f31434d;
                        bVar4.f31434d = i6 + 1;
                        bArr3[i6] = c4;
                    }
                }
                if (this.f31421i.f31434d == (this.f31421i.f31432b * 2) - 1) {
                    i();
                }
            }
        }
    }

    private void i() {
        if (this.f31421i != null) {
            j();
            this.f31421i = null;
        }
    }

    private void j() {
        if (this.f31421i.f31434d != (this.f31421i.f31432b * 2) - 1) {
            StringBuilder sb = new StringBuilder("DtvCcPacket ended prematurely; size is ");
            sb.append((this.f31421i.f31432b * 2) - 1);
            sb.append(", but current index is ");
            sb.append(this.f31421i.f31434d);
            sb.append(" (sequence number ");
            sb.append(this.f31421i.f31431a);
            sb.append("); ignoring packet");
            l.c();
            return;
        }
        this.f31415c.a(this.f31421i.f31433c, this.f31421i.f31434d);
        int c2 = this.f31415c.c(3);
        int c3 = this.f31415c.c(5);
        if (c2 == 7) {
            this.f31415c.b(2);
            c2 = this.f31415c.c(6);
            if (c2 < 7) {
                "Invalid extended service number: ".concat(String.valueOf(c2));
                l.c();
            }
        }
        if (c3 == 0) {
            if (c2 != 0) {
                StringBuilder sb2 = new StringBuilder("serviceNumber is non-zero (");
                sb2.append(c2);
                sb2.append(") when blockSize is 0");
                l.c();
            }
        } else if (c2 == this.f31416d) {
            boolean z = false;
            while (this.f31415c.a() > 0) {
                int c4 = this.f31415c.c(8);
                if (c4 == 16) {
                    int c5 = this.f31415c.c(8);
                    if (c5 <= 31) {
                        c(c5);
                    } else if (c5 <= 127) {
                        g(c5);
                    } else if (c5 <= 159) {
                        d(c5);
                    } else if (c5 <= 255) {
                        h(c5);
                    } else {
                        "Invalid extended command: ".concat(String.valueOf(c5));
                        l.c();
                    }
                } else if (c4 <= 31) {
                    a(c4);
                } else if (c4 <= 127) {
                    e(c4);
                } else if (c4 <= 159) {
                    b(c4);
                } else if (c4 <= 255) {
                    f(c4);
                } else {
                    "Invalid base command: ".concat(String.valueOf(c4));
                    l.c();
                }
                z = true;
            }
            if (z) {
                this.f31419g = k();
            }
        }
    }

    private void a(int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 == 3) {
            this.f31419g = k();
        } else if (i2 != 8) {
            switch (i2) {
                case 12:
                    l();
                    return;
                case 13:
                    this.f31418f.a(10);
                    return;
                case 14:
                    return;
                default:
                    if (i2 >= 17 && i2 <= 23) {
                        "Currently unsupported COMMAND_EXT1 Command: ".concat(String.valueOf(i2));
                        l.c();
                        this.f31415c.b(8);
                        return;
                    } else if (i2 < 24 || i2 > 31) {
                        "Invalid C0 command: ".concat(String.valueOf(i2));
                        l.c();
                        return;
                    } else {
                        "Currently unsupported COMMAND_P16 Command: ".concat(String.valueOf(i2));
                        l.c();
                        this.f31415c.b(16);
                        return;
                    }
            }
        } else {
            this.f31418f.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0224, code lost:
        if (r8 > 8) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x022c, code lost:
        if (r0.f31415c.e() == false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x022e, code lost:
        r0.f31417e[8 - r8].b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0237, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x023a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0255, code lost:
        if (r8 > 8) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x025d, code lost:
        if (r0.f31415c.e() == false) goto L_0x0269;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x025f, code lost:
        r0.f31417e[8 - r8].f31430i = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x026a, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x026d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0285, code lost:
        if (r8 > 8) goto L_0x029b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x028d, code lost:
        if (r0.f31415c.e() == false) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x028f, code lost:
        r0.f31417e[8 - r8].c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0298, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x029b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 16
            r3 = 6
            r5 = 4
            r6 = 3
            r7 = 8
            r8 = 1
            r9 = 2
            switch(r1) {
                case 128: goto L_0x029c;
                case 129: goto L_0x029c;
                case 130: goto L_0x029c;
                case 131: goto L_0x029c;
                case 132: goto L_0x029c;
                case 133: goto L_0x029c;
                case 134: goto L_0x029c;
                case 135: goto L_0x029c;
                case 136: goto L_0x0285;
                case 137: goto L_0x026e;
                case 138: goto L_0x0255;
                case 139: goto L_0x023b;
                case 140: goto L_0x0224;
                case 141: goto L_0x021e;
                case 142: goto L_0x021d;
                case 143: goto L_0x021a;
                case 144: goto L_0x01e3;
                case 145: goto L_0x017d;
                case 146: goto L_0x014e;
                case 147: goto L_0x0010;
                case 148: goto L_0x0010;
                case 149: goto L_0x0010;
                case 150: goto L_0x0010;
                case 151: goto L_0x00e5;
                case 152: goto L_0x001e;
                case 153: goto L_0x001e;
                case 154: goto L_0x001e;
                case 155: goto L_0x001e;
                case 156: goto L_0x001e;
                case 157: goto L_0x001e;
                case 158: goto L_0x001e;
                case 159: goto L_0x001e;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.String r1 = java.lang.String.valueOf(r17)
            java.lang.String r2 = "Invalid C1 command: "
            r2.concat(r1)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x02aa
        L_0x001e:
            int r1 = r1 + -152
            com.google.android.exoplayer2.e.a.c$a[] r2 = r0.f31417e
            r2 = r2[r1]
            com.google.android.exoplayer2.g.q r10 = r0.f31415c
            r10.b(r9)
            com.google.android.exoplayer2.g.q r10 = r0.f31415c
            boolean r10 = r10.e()
            com.google.android.exoplayer2.g.q r11 = r0.f31415c
            boolean r11 = r11.e()
            com.google.android.exoplayer2.g.q r12 = r0.f31415c
            r12.e()
            com.google.android.exoplayer2.g.q r12 = r0.f31415c
            int r12 = r12.c(r6)
            com.google.android.exoplayer2.g.q r13 = r0.f31415c
            boolean r13 = r13.e()
            com.google.android.exoplayer2.g.q r14 = r0.f31415c
            r15 = 7
            int r14 = r14.c(r15)
            com.google.android.exoplayer2.g.q r15 = r0.f31415c
            int r7 = r15.c(r7)
            com.google.android.exoplayer2.g.q r15 = r0.f31415c
            int r15 = r15.c(r5)
            com.google.android.exoplayer2.g.q r4 = r0.f31415c
            int r4 = r4.c(r5)
            com.google.android.exoplayer2.g.q r5 = r0.f31415c
            r5.b(r9)
            com.google.android.exoplayer2.g.q r5 = r0.f31415c
            r5.c(r3)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            r3.b(r9)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            int r3 = r3.c(r6)
            com.google.android.exoplayer2.g.q r5 = r0.f31415c
            int r5 = r5.c(r6)
            r2.f31429h = r8
            r2.f31430i = r10
            r2.p = r11
            r2.j = r12
            r2.k = r13
            r2.l = r14
            r2.m = r7
            r2.n = r15
            int r6 = r2.o
            int r4 = r4 + r8
            if (r6 == r4) goto L_0x00ae
            r2.o = r4
        L_0x0091:
            if (r11 == 0) goto L_0x009d
            java.util.List<android.text.SpannableString> r4 = r2.f31428g
            int r4 = r4.size()
            int r6 = r2.o
            if (r4 >= r6) goto L_0x00a7
        L_0x009d:
            java.util.List<android.text.SpannableString> r4 = r2.f31428g
            int r4 = r4.size()
            r6 = 15
            if (r4 < r6) goto L_0x00ae
        L_0x00a7:
            java.util.List<android.text.SpannableString> r4 = r2.f31428g
            r6 = 0
            r4.remove(r6)
            goto L_0x0091
        L_0x00ae:
            if (r3 == 0) goto L_0x00c2
            int r4 = r2.q
            if (r4 == r3) goto L_0x00c2
            r2.q = r3
            int r3 = r3 - r8
            int[] r4 = com.google.android.exoplayer2.e.a.c.a.f31426e
            r4 = r4[r3]
            int[] r6 = com.google.android.exoplayer2.e.a.c.a.f31425d
            r3 = r6[r3]
            r2.a((int) r4, (int) r3)
        L_0x00c2:
            if (r5 == 0) goto L_0x00d8
            int r3 = r2.r
            if (r3 == r5) goto L_0x00d8
            r2.r = r5
            int r5 = r5 - r8
            r3 = 0
            r2.a((boolean) r3, (boolean) r3)
            int r3 = com.google.android.exoplayer2.e.a.c.a.f31422a
            int[] r4 = com.google.android.exoplayer2.e.a.c.a.f31427f
            r4 = r4[r5]
            r2.b(r3, r4)
        L_0x00d8:
            int r2 = r0.j
            if (r2 == r1) goto L_0x02aa
            r0.j = r1
            com.google.android.exoplayer2.e.a.c$a[] r2 = r0.f31417e
            r1 = r2[r1]
            r0.f31418f = r1
            return
        L_0x00e5:
            com.google.android.exoplayer2.e.a.c$a r1 = r0.f31418f
            boolean r1 = r1.f31429h
            if (r1 != 0) goto L_0x00f3
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r2 = 32
            r1.b(r2)
            return
        L_0x00f3:
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            int r1 = r1.c(r9)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            int r2 = r2.c(r9)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            int r3 = r3.c(r9)
            com.google.android.exoplayer2.g.q r4 = r0.f31415c
            int r4 = r4.c(r9)
            int r1 = com.google.android.exoplayer2.e.a.c.a.a(r2, r3, r4, r1)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            r2.c(r9)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            int r2 = r2.c(r9)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            int r3 = r3.c(r9)
            com.google.android.exoplayer2.g.q r4 = r0.f31415c
            int r4 = r4.c(r9)
            com.google.android.exoplayer2.e.a.c.a.a(r2, r3, r4)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            r2.e()
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            r2.e()
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            r2.c(r9)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            r2.c(r9)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            int r2 = r2.c(r9)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            r3.b(r7)
            com.google.android.exoplayer2.e.a.c$a r3 = r0.f31418f
            r3.a((int) r1, (int) r2)
            return
        L_0x014e:
            com.google.android.exoplayer2.e.a.c$a r1 = r0.f31418f
            boolean r1 = r1.f31429h
            if (r1 != 0) goto L_0x015a
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r1.b(r2)
            return
        L_0x015a:
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r1.b(r5)
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            int r1 = r1.c(r5)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            r2.b(r9)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            r2.c(r3)
            com.google.android.exoplayer2.e.a.c$a r2 = r0.f31418f
            int r3 = r2.s
            if (r3 == r1) goto L_0x017a
            r3 = 10
            r2.a(r3)
        L_0x017a:
            r2.s = r1
            return
        L_0x017d:
            com.google.android.exoplayer2.e.a.c$a r1 = r0.f31418f
            boolean r1 = r1.f31429h
            if (r1 != 0) goto L_0x018b
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r2 = 24
            r1.b(r2)
            return
        L_0x018b:
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            int r1 = r1.c(r9)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            int r2 = r2.c(r9)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            int r3 = r3.c(r9)
            com.google.android.exoplayer2.g.q r4 = r0.f31415c
            int r4 = r4.c(r9)
            int r1 = com.google.android.exoplayer2.e.a.c.a.a(r2, r3, r4, r1)
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            int r2 = r2.c(r9)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            int r3 = r3.c(r9)
            com.google.android.exoplayer2.g.q r4 = r0.f31415c
            int r4 = r4.c(r9)
            com.google.android.exoplayer2.g.q r5 = r0.f31415c
            int r5 = r5.c(r9)
            int r2 = com.google.android.exoplayer2.e.a.c.a.a(r3, r4, r5, r2)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            r3.b(r9)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            int r3 = r3.c(r9)
            com.google.android.exoplayer2.g.q r4 = r0.f31415c
            int r4 = r4.c(r9)
            com.google.android.exoplayer2.g.q r5 = r0.f31415c
            int r5 = r5.c(r9)
            com.google.android.exoplayer2.e.a.c.a.a(r3, r4, r5)
            com.google.android.exoplayer2.e.a.c$a r3 = r0.f31418f
            r3.b(r1, r2)
            return
        L_0x01e3:
            com.google.android.exoplayer2.e.a.c$a r1 = r0.f31418f
            boolean r1 = r1.f31429h
            if (r1 != 0) goto L_0x01ef
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r1.b(r2)
            return
        L_0x01ef:
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r1.c(r5)
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r1.c(r9)
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r1.c(r9)
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            boolean r1 = r1.e()
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            boolean r2 = r2.e()
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            r3.c(r6)
            com.google.android.exoplayer2.g.q r3 = r0.f31415c
            r3.c(r6)
            com.google.android.exoplayer2.e.a.c$a r3 = r0.f31418f
            r3.a((boolean) r1, (boolean) r2)
            return
        L_0x021a:
            r16.l()
        L_0x021d:
            return
        L_0x021e:
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            r1.b(r7)
            return
        L_0x0224:
            if (r8 > r7) goto L_0x023a
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0237
            com.google.android.exoplayer2.e.a.c$a[] r1 = r0.f31417e
            int r2 = 8 - r8
            r1 = r1[r2]
            r1.b()
        L_0x0237:
            int r8 = r8 + 1
            goto L_0x0224
        L_0x023a:
            return
        L_0x023b:
            r1 = 1
        L_0x023c:
            if (r1 > r7) goto L_0x0254
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            boolean r2 = r2.e()
            if (r2 == 0) goto L_0x0251
            com.google.android.exoplayer2.e.a.c$a[] r2 = r0.f31417e
            int r3 = 8 - r1
            r2 = r2[r3]
            boolean r3 = r2.f31430i
            r3 = r3 ^ r8
            r2.f31430i = r3
        L_0x0251:
            int r1 = r1 + 1
            goto L_0x023c
        L_0x0254:
            return
        L_0x0255:
            if (r8 > r7) goto L_0x026d
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0269
            com.google.android.exoplayer2.e.a.c$a[] r1 = r0.f31417e
            int r2 = 8 - r8
            r1 = r1[r2]
            r2 = 0
            r1.f31430i = r2
            goto L_0x026a
        L_0x0269:
            r2 = 0
        L_0x026a:
            int r8 = r8 + 1
            goto L_0x0255
        L_0x026d:
            return
        L_0x026e:
            r1 = 1
        L_0x026f:
            if (r1 > r7) goto L_0x0284
            com.google.android.exoplayer2.g.q r2 = r0.f31415c
            boolean r2 = r2.e()
            if (r2 == 0) goto L_0x0281
            com.google.android.exoplayer2.e.a.c$a[] r2 = r0.f31417e
            int r3 = 8 - r1
            r2 = r2[r3]
            r2.f31430i = r8
        L_0x0281:
            int r1 = r1 + 1
            goto L_0x026f
        L_0x0284:
            return
        L_0x0285:
            if (r8 > r7) goto L_0x029b
            com.google.android.exoplayer2.g.q r1 = r0.f31415c
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0298
            com.google.android.exoplayer2.e.a.c$a[] r1 = r0.f31417e
            int r2 = 8 - r8
            r1 = r1[r2]
            r1.c()
        L_0x0298:
            int r8 = r8 + 1
            goto L_0x0285
        L_0x029b:
            return
        L_0x029c:
            int r1 = r1 + -128
            int r2 = r0.j
            if (r2 == r1) goto L_0x02aa
            r0.j = r1
            com.google.android.exoplayer2.e.a.c$a[] r2 = r0.f31417e
            r1 = r2[r1]
            r0.f31418f = r1
        L_0x02aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.a.c.b(int):void");
    }

    private void c(int i2) {
        if (i2 <= 7) {
            return;
        }
        if (i2 <= 15) {
            this.f31415c.b(8);
        } else if (i2 <= 23) {
            this.f31415c.b(16);
        } else if (i2 <= 31) {
            this.f31415c.b(24);
        }
    }

    private void d(int i2) {
        if (i2 <= 135) {
            this.f31415c.b(32);
        } else if (i2 <= 143) {
            this.f31415c.b(40);
        } else if (i2 <= 159) {
            this.f31415c.b(2);
            this.f31415c.b(this.f31415c.c(6) * 8);
        }
    }

    private void e(int i2) {
        if (i2 == 127) {
            this.f31418f.a(9835);
        } else {
            this.f31418f.a((char) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID));
        }
    }

    private void f(int i2) {
        this.f31418f.a((char) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID));
    }

    private void g(int i2) {
        if (i2 == 32) {
            this.f31418f.a(' ');
        } else if (i2 == 33) {
            this.f31418f.a(160);
        } else if (i2 == 37) {
            this.f31418f.a(8230);
        } else if (i2 == 42) {
            this.f31418f.a(352);
        } else if (i2 == 44) {
            this.f31418f.a(338);
        } else if (i2 == 63) {
            this.f31418f.a(376);
        } else if (i2 == 57) {
            this.f31418f.a(8482);
        } else if (i2 == 58) {
            this.f31418f.a(353);
        } else if (i2 == 60) {
            this.f31418f.a(339);
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    this.f31418f.a(9608);
                    return;
                case 49:
                    this.f31418f.a(8216);
                    return;
                case 50:
                    this.f31418f.a(8217);
                    return;
                case 51:
                    this.f31418f.a(8220);
                    return;
                case 52:
                    this.f31418f.a(8221);
                    return;
                case 53:
                    this.f31418f.a(8226);
                    return;
                default:
                    switch (i2) {
                        case 118:
                            this.f31418f.a(8539);
                            return;
                        case 119:
                            this.f31418f.a(8540);
                            return;
                        case 120:
                            this.f31418f.a(8541);
                            return;
                        case 121:
                            this.f31418f.a(8542);
                            return;
                        case 122:
                            this.f31418f.a(9474);
                            return;
                        case 123:
                            this.f31418f.a(9488);
                            return;
                        case 124:
                            this.f31418f.a(9492);
                            return;
                        case 125:
                            this.f31418f.a(9472);
                            return;
                        case 126:
                            this.f31418f.a(9496);
                            return;
                        case 127:
                            this.f31418f.a(9484);
                            return;
                        default:
                            "Invalid G2 character: ".concat(String.valueOf(i2));
                            l.c();
                            return;
                    }
            }
        } else {
            this.f31418f.a(8480);
        }
    }

    private void h(int i2) {
        if (i2 == 160) {
            this.f31418f.a(13252);
            return;
        }
        "Invalid G3 character: ".concat(String.valueOf(i2));
        l.c();
        this.f31418f.a('_');
    }

    private List<com.google.android.exoplayer2.e.b> k() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f31417e[i2].a() && this.f31417e[i2].f31430i) {
                arrayList.add(this.f31417e[i2].e());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void l() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f31417e[i2].b();
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f31431a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31432b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f31433c;

        /* renamed from: d  reason: collision with root package name */
        int f31434d = 0;

        public b(int i2, int i3) {
            this.f31431a = i2;
            this.f31432b = i3;
            this.f31433c = new byte[((i3 * 2) - 1)];
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f31422a = a(2, 2, 2, 0);

        /* renamed from: b  reason: collision with root package name */
        public static final int f31423b = a(0, 0, 0, 0);

        /* renamed from: c  reason: collision with root package name */
        public static final int f31424c = a(0, 0, 0, 3);

        /* renamed from: d  reason: collision with root package name */
        static final int[] f31425d = {0, 0, 0, 0, 0, 2, 0};

        /* renamed from: e  reason: collision with root package name */
        static final int[] f31426e;

        /* renamed from: f  reason: collision with root package name */
        static final int[] f31427f;
        private static final int[] t = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] u = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] v = {false, false, false, true, true, true, false};
        private static final int[] w = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] x = {0, 0, 0, 0, 0, 3, 3};
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;

        /* renamed from: g  reason: collision with root package name */
        final List<SpannableString> f31428g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        boolean f31429h;

        /* renamed from: i  reason: collision with root package name */
        boolean f31430i;
        int j;
        boolean k;
        int l;
        int m;
        int n;
        int o;
        boolean p;
        int q;
        int r;
        int s;
        private final SpannableStringBuilder y = new SpannableStringBuilder();
        private int z;

        static {
            int i2 = f31423b;
            int i3 = f31424c;
            f31426e = new int[]{i2, i3, i2, i2, i3, i2, i2};
            f31427f = new int[]{i2, i2, i2, i2, i2, i3, i3};
        }

        public a() {
            b();
        }

        public final void b() {
            c();
            this.f31429h = false;
            this.f31430i = false;
            this.j = 4;
            this.k = false;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 15;
            this.p = true;
            this.z = 0;
            this.q = 0;
            this.r = 0;
            int i2 = f31423b;
            this.A = i2;
            this.E = f31422a;
            this.G = i2;
        }

        public final void c() {
            this.f31428g.clear();
            this.y.clear();
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.F = -1;
            this.s = 0;
        }

        public final void a(int i2, int i3) {
            this.A = i2;
            this.z = i3;
        }

        public final void a(boolean z2, boolean z3) {
            if (this.B != -1) {
                if (!z2) {
                    this.y.setSpan(new StyleSpan(2), this.B, this.y.length(), 33);
                    this.B = -1;
                }
            } else if (z2) {
                this.B = this.y.length();
            }
            if (this.C != -1) {
                if (!z3) {
                    this.y.setSpan(new UnderlineSpan(), this.C, this.y.length(), 33);
                    this.C = -1;
                }
            } else if (z3) {
                this.C = this.y.length();
            }
        }

        public final void b(int i2, int i3) {
            int i4;
            int i5;
            if (!(this.D == -1 || (i5 = this.E) == i2)) {
                this.y.setSpan(new ForegroundColorSpan(i5), this.D, this.y.length(), 33);
            }
            if (i2 != f31422a) {
                this.D = this.y.length();
                this.E = i2;
            }
            if (!(this.F == -1 || (i4 = this.G) == i3)) {
                this.y.setSpan(new BackgroundColorSpan(i4), this.F, this.y.length(), 33);
            }
            if (i3 != f31423b) {
                this.F = this.y.length();
                this.G = i3;
            }
        }

        public final void d() {
            int length = this.y.length();
            if (length > 0) {
                this.y.delete(length - 1, length);
            }
        }

        public final void a(char c2) {
            if (c2 == 10) {
                this.f31428g.add(f());
                this.y.clear();
                if (this.B != -1) {
                    this.B = 0;
                }
                if (this.C != -1) {
                    this.C = 0;
                }
                if (this.D != -1) {
                    this.D = 0;
                }
                if (this.F != -1) {
                    this.F = 0;
                }
                while (true) {
                    if ((this.p && this.f31428g.size() >= this.o) || this.f31428g.size() >= 15) {
                        this.f31428g.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.y.append(c2);
            }
        }

        private SpannableString f() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.y);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.C, length, 33);
                }
                if (this.D != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.E), this.D, length, 33);
                }
                if (this.F != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.G), this.F, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.exoplayer2.e.a.b e() {
            /*
                r14 = this;
                boolean r0 = r14.a()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = 0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r14.f31428g
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r14.f31428g
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r14.f()
                r2.append(r1)
                int r1 = r14.z
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x005b
                if (r1 == r5) goto L_0x0058
                if (r1 == r3) goto L_0x0055
                if (r1 != r4) goto L_0x003f
                goto L_0x005b
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Unexpected justification value: "
                r1.<init>(r2)
                int r2 = r14.z
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0055:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x005d
            L_0x0058:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x005d
            L_0x005b:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x005d:
                r6 = r1
                boolean r1 = r14.k
                if (r1 == 0) goto L_0x006d
                int r1 = r14.m
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r14.l
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007a
            L_0x006d:
                int r1 = r14.m
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r14.l
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007a:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r14.n
                int r8 = r1 % 3
                if (r8 != 0) goto L_0x0090
                r8 = 0
                goto L_0x0096
            L_0x0090:
                int r1 = r1 % r4
                if (r1 != r5) goto L_0x0095
                r8 = 1
                goto L_0x0096
            L_0x0095:
                r8 = 2
            L_0x0096:
                int r1 = r14.n
                int r9 = r1 / 3
                if (r9 != 0) goto L_0x009e
                r9 = 0
                goto L_0x00a4
            L_0x009e:
                int r1 = r1 / r4
                if (r1 != r5) goto L_0x00a3
                r9 = 1
                goto L_0x00a4
            L_0x00a3:
                r9 = 2
            L_0x00a4:
                int r1 = r14.A
                int r3 = f31423b
                if (r1 == r3) goto L_0x00ab
                r0 = 1
            L_0x00ab:
                com.google.android.exoplayer2.e.a.b r11 = new com.google.android.exoplayer2.e.a.b
                int r12 = r14.A
                int r13 = r14.j
                r1 = r11
                r3 = r6
                r4 = r7
                r5 = r8
                r6 = r10
                r7 = r9
                r8 = r0
                r9 = r12
                r10 = r13
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.a.c.a.e():com.google.android.exoplayer2.e.a.b");
        }

        public static int a(int i2, int i3, int i4) {
            return a(i2, i3, i4, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int a(int r4, int r5, int r6, int r7) {
            /*
                r0 = 4
                com.google.android.exoplayer2.g.a.a((int) r4, (int) r0)
                com.google.android.exoplayer2.g.a.a((int) r5, (int) r0)
                com.google.android.exoplayer2.g.a.a((int) r6, (int) r0)
                com.google.android.exoplayer2.g.a.a((int) r7, (int) r0)
                r0 = 0
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x001b
                if (r7 == r1) goto L_0x001b
                r3 = 2
                if (r7 == r3) goto L_0x0020
                r3 = 3
                if (r7 == r3) goto L_0x001e
            L_0x001b:
                r7 = 255(0xff, float:3.57E-43)
                goto L_0x0022
            L_0x001e:
                r7 = 0
                goto L_0x0022
            L_0x0020:
                r7 = 127(0x7f, float:1.78E-43)
            L_0x0022:
                if (r4 <= r1) goto L_0x0027
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0028
            L_0x0027:
                r4 = 0
            L_0x0028:
                if (r5 <= r1) goto L_0x002d
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002e
            L_0x002d:
                r5 = 0
            L_0x002e:
                if (r6 <= r1) goto L_0x0032
                r0 = 255(0xff, float:3.57E-43)
            L_0x0032:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.a.c.a.a(int, int, int, int):int");
        }

        public final boolean a() {
            if (this.f31429h) {
                return this.f31428g.isEmpty() && this.y.length() == 0;
            }
            return true;
        }
    }
}
