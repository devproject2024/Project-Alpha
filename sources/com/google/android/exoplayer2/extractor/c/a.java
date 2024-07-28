package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayDeque;

final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f31714a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<C0539a> f31715b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f31716c = new f();

    /* renamed from: d  reason: collision with root package name */
    private b f31717d;

    /* renamed from: e  reason: collision with root package name */
    private int f31718e;

    /* renamed from: f  reason: collision with root package name */
    private int f31719f;

    /* renamed from: g  reason: collision with root package name */
    private long f31720g;

    public final void a(b bVar) {
        this.f31717d = bVar;
    }

    public final void a() {
        this.f31718e = 0;
        this.f31715b.clear();
        this.f31716c.a();
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        double d2;
        int a2;
        int a3;
        com.google.android.exoplayer2.g.a.a(this.f31717d);
        while (true) {
            if (this.f31715b.isEmpty() || hVar.c() < this.f31715b.peek().f31722b) {
                if (this.f31718e == 0) {
                    long a4 = this.f31716c.a(hVar, true, false, 4);
                    if (a4 == -2) {
                        hVar.a();
                        while (true) {
                            hVar.c(this.f31714a, 0, 4);
                            a2 = f.a(this.f31714a[0]);
                            if (a2 != -1 && a2 <= 4) {
                                a3 = (int) f.a(this.f31714a, a2, false);
                                if (this.f31717d.b(a3)) {
                                    break;
                                }
                            }
                            hVar.b(1);
                        }
                        hVar.b(a2);
                        a4 = (long) a3;
                    }
                    if (a4 == -1) {
                        return false;
                    }
                    this.f31719f = (int) a4;
                    this.f31718e = 1;
                }
                if (this.f31718e == 1) {
                    this.f31720g = this.f31716c.a(hVar, false, true, 8);
                    this.f31718e = 2;
                }
                int a5 = this.f31717d.a(this.f31719f);
                if (a5 == 0) {
                    hVar.b((int) this.f31720g);
                    this.f31718e = 0;
                } else if (a5 == 1) {
                    long c2 = hVar.c();
                    this.f31715b.push(new C0539a(this.f31719f, this.f31720g + c2, (byte) 0));
                    this.f31717d.a(this.f31719f, c2, this.f31720g);
                    this.f31718e = 0;
                    return true;
                } else if (a5 == 2) {
                    long j = this.f31720g;
                    if (j <= 8) {
                        this.f31717d.a(this.f31719f, a(hVar, (int) j));
                        this.f31718e = 0;
                        return true;
                    }
                    throw new v("Invalid integer size: " + this.f31720g);
                } else if (a5 == 3) {
                    long j2 = this.f31720g;
                    if (j2 <= 2147483647L) {
                        this.f31717d.a(this.f31719f, b(hVar, (int) j2));
                        this.f31718e = 0;
                        return true;
                    }
                    throw new v("String element size: " + this.f31720g);
                } else if (a5 == 4) {
                    this.f31717d.a(this.f31719f, (int) this.f31720g, hVar);
                    this.f31718e = 0;
                    return true;
                } else if (a5 == 5) {
                    long j3 = this.f31720g;
                    if (j3 == 4 || j3 == 8) {
                        b bVar = this.f31717d;
                        int i2 = this.f31719f;
                        int i3 = (int) this.f31720g;
                        long a6 = a(hVar, i3);
                        if (i3 == 4) {
                            d2 = (double) Float.intBitsToFloat((int) a6);
                        } else {
                            d2 = Double.longBitsToDouble(a6);
                        }
                        bVar.a(i2, d2);
                        this.f31718e = 0;
                        return true;
                    }
                    throw new v("Invalid float size: " + this.f31720g);
                } else {
                    throw new v("Invalid element type ".concat(String.valueOf(a5)));
                }
            } else {
                this.f31717d.c(this.f31715b.pop().f31721a);
                return true;
            }
        }
    }

    private long a(h hVar, int i2) throws IOException, InterruptedException {
        hVar.b(this.f31714a, 0, i2);
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j = (j << 8) | ((long) (this.f31714a[i3] & 255));
        }
        return j;
    }

    private static String b(h hVar, int i2) throws IOException, InterruptedException {
        if (i2 == 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        hVar.b(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    /* renamed from: com.google.android.exoplayer2.extractor.c.a$a  reason: collision with other inner class name */
    static final class C0539a {

        /* renamed from: a  reason: collision with root package name */
        final int f31721a;

        /* renamed from: b  reason: collision with root package name */
        final long f31722b;

        /* synthetic */ C0539a(int i2, long j, byte b2) {
            this(i2, j);
        }

        private C0539a(int i2, long j) {
            this.f31721a = i2;
            this.f31722b = j;
        }
    }
}
