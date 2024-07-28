package com.squareup.b;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import i.c;
import i.e;
import i.f;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f16094a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    final e f16095b;

    /* renamed from: c  reason: collision with root package name */
    int f16096c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f16097d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f16098e;

    /* renamed from: f  reason: collision with root package name */
    private int f16099f;

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int c(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static o a(byte[] bArr) {
        return new o(new c().c(bArr));
    }

    public final int a() throws IOException {
        if (g()) {
            this.f16099f = 0;
            return 0;
        }
        this.f16099f = b();
        int i2 = this.f16099f;
        if (i2 != 0) {
            return i2;
        }
        throw new IOException("Protocol message contained an invalid tag (zero).");
    }

    public final void a(int i2) throws IOException {
        if (this.f16099f != i2) {
            throw new IOException("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final f b(int i2) throws IOException {
        this.f16096c += i2;
        long j = (long) i2;
        this.f16095b.a(j);
        return this.f16095b.d(j);
    }

    public final int b() throws IOException {
        int i2;
        this.f16096c++;
        byte g2 = this.f16095b.g();
        if (g2 >= 0) {
            return g2;
        }
        byte b2 = g2 & Byte.MAX_VALUE;
        this.f16096c++;
        byte g3 = this.f16095b.g();
        if (g3 >= 0) {
            i2 = g3 << 7;
        } else {
            b2 |= (g3 & Byte.MAX_VALUE) << 7;
            this.f16096c++;
            byte g4 = this.f16095b.g();
            if (g4 >= 0) {
                i2 = g4 << 14;
            } else {
                b2 |= (g4 & Byte.MAX_VALUE) << 14;
                this.f16096c++;
                byte g5 = this.f16095b.g();
                if (g5 >= 0) {
                    i2 = g5 << 21;
                } else {
                    byte b3 = b2 | ((g5 & Byte.MAX_VALUE) << 21);
                    this.f16096c++;
                    byte g6 = this.f16095b.g();
                    byte b4 = b3 | (g6 << 28);
                    if (g6 >= 0) {
                        return b4;
                    }
                    for (int i3 = 0; i3 < 5; i3++) {
                        this.f16096c++;
                        if (this.f16095b.g() >= 0) {
                            return b4;
                        }
                    }
                    throw new IOException("WireInput encountered a malformed varint.");
                }
            }
        }
        return b2 | i2;
    }

    public final long c() throws IOException {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.f16096c++;
            byte g2 = this.f16095b.g();
            j |= ((long) (g2 & Byte.MAX_VALUE)) << i2;
            if ((g2 & 128) == 0) {
                return j;
            }
        }
        throw new IOException("WireInput encountered a malformed varint.");
    }

    public final int d() throws IOException {
        this.f16096c += 4;
        return this.f16095b.l();
    }

    public final long e() throws IOException {
        this.f16096c += 8;
        return this.f16095b.m();
    }

    private o(e eVar) {
        this.f16095b = eVar;
    }

    public final int d(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = i2 + this.f16096c;
            int i4 = this.f16097d;
            if (i3 <= i4) {
                this.f16097d = i3;
                return i4;
            }
            throw new EOFException("The input ended unexpectedly in the middle of a field");
        }
        throw new IOException("Encountered a negative size");
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void f() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.a()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.e(r0)
            if (r0 == 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.b.o.f():void");
    }

    private boolean e(int i2) throws IOException {
        switch (q.valueOf(i2)) {
            case VARINT:
                c();
                return false;
            case FIXED32:
                d();
                return false;
            case FIXED64:
                e();
                return false;
            case LENGTH_DELIMITED:
                b((long) b());
                return false;
            case START_GROUP:
                f();
                a((i2 & -8) | q.END_GROUP.value());
                return false;
            case END_GROUP:
                return true;
            default:
                throw new AssertionError();
        }
    }

    private void b(long j) throws IOException {
        this.f16096c = (int) (((long) this.f16096c) + j);
        this.f16095b.i(j);
    }

    private boolean g() throws IOException {
        if (((long) this.f16096c) == ((long) this.f16097d)) {
            return true;
        }
        return this.f16095b.d();
    }
}
