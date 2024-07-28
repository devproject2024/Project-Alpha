package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.e.h;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.i;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    i f31802a;

    /* renamed from: d  reason: collision with root package name */
    private a f31803d;

    b() {
    }

    public static boolean a(r rVar) {
        return rVar.b() >= 5 && rVar.c() == 127 && rVar.g() == 1179402563;
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.f31802a = null;
            this.f31803d = null;
        }
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public final long b(r rVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!a(rVar.f32566a)) {
            return -1;
        }
        int i6 = (rVar.f32566a[2] & 255) >> 4;
        switch (i6) {
            case 1:
                i2 = 192;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                i3 = 576;
                i4 = i6 - 2;
                break;
            case 6:
            case 7:
                rVar.d(4);
                long j = (long) rVar.f32566a[rVar.f32567b];
                int i7 = 7;
                while (true) {
                    if (i7 >= 0) {
                        int i8 = 1 << i7;
                        if ((((long) i8) & j) != 0) {
                            i7--;
                        } else if (i7 < 6) {
                            j &= (long) (i8 - 1);
                            i5 = 7 - i7;
                        } else if (i7 == 7) {
                            i5 = 1;
                        }
                    }
                }
                i5 = 0;
                if (i5 != 0) {
                    long j2 = j;
                    int i9 = 1;
                    while (i9 < i5) {
                        byte b2 = rVar.f32566a[rVar.f32567b + i9];
                        if ((b2 & 192) == 128) {
                            j2 = (j2 << 6) | ((long) (b2 & 63));
                            i9++;
                        } else {
                            throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(String.valueOf(j2)));
                        }
                    }
                    rVar.f32567b += i5;
                    int c2 = i6 == 6 ? rVar.c() : rVar.d();
                    rVar.c(0);
                    i2 = c2 + 1;
                    break;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(String.valueOf(j)));
                }
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i3 = UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
                i4 = i6 - 8;
                break;
            default:
                i2 = -1;
                break;
        }
        i2 = i3 << i4;
        return (long) i2;
    }

    /* access modifiers changed from: protected */
    public final boolean a(r rVar, long j, h.a aVar) throws IOException, InterruptedException {
        r rVar2 = rVar;
        h.a aVar2 = aVar;
        byte[] bArr = rVar2.f32566a;
        if (this.f31802a == null) {
            this.f31802a = new i(bArr);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, rVar2.f32568c);
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            i iVar = this.f31802a;
            aVar2.f31839a = Format.a((String) null, "audio/flac", -1, iVar.f32535g * iVar.f32533e, this.f31802a.f32534f, this.f31802a.f32533e, (List<byte[]>) singletonList, (DrmInitData) null, (String) null);
        } else {
            if ((bArr[0] & Byte.MAX_VALUE) == 3) {
                this.f31803d = new a();
                a aVar3 = this.f31803d;
                rVar2.d(1);
                int f2 = rVar.f() / 18;
                aVar3.f31804a = new long[f2];
                aVar3.f31805b = new long[f2];
                for (int i2 = 0; i2 < f2; i2++) {
                    aVar3.f31804a[i2] = rVar.k();
                    aVar3.f31805b[i2] = rVar.k();
                    rVar2.d(2);
                }
            } else if (a(bArr)) {
                a aVar4 = this.f31803d;
                if (aVar4 != null) {
                    aVar4.f31806c = j;
                    aVar2.f31840b = aVar4;
                }
                return false;
            }
        }
        return true;
    }

    class a implements f, o {

        /* renamed from: a  reason: collision with root package name */
        long[] f31804a;

        /* renamed from: b  reason: collision with root package name */
        long[] f31805b;

        /* renamed from: c  reason: collision with root package name */
        long f31806c = -1;

        /* renamed from: e  reason: collision with root package name */
        private long f31808e = -1;

        public final o a() {
            return this;
        }

        public final boolean h_() {
            return true;
        }

        public a() {
        }

        public final long a(com.google.android.exoplayer2.extractor.h hVar) throws IOException, InterruptedException {
            long j = this.f31808e;
            if (j < 0) {
                return -1;
            }
            long j2 = -(j + 2);
            this.f31808e = -1;
            return j2;
        }

        public final void a_(long j) {
            this.f31808e = this.f31804a[ae.a(this.f31804a, j, true)];
        }

        public final o.a a(long j) {
            int a2 = ae.a(this.f31804a, b.this.b(j), true);
            long a3 = b.this.a(this.f31804a[a2]);
            p pVar = new p(a3, this.f31806c + this.f31805b[a2]);
            if (a3 < j) {
                long[] jArr = this.f31804a;
                if (a2 != jArr.length - 1) {
                    int i2 = a2 + 1;
                    return new o.a(pVar, new p(b.this.a(jArr[i2]), this.f31806c + this.f31805b[i2]));
                }
            }
            return new o.a(pVar);
        }

        public final long b() {
            i iVar = b.this.f31802a;
            return (iVar.f32536h * 1000000) / ((long) iVar.f32533e);
        }
    }
}
