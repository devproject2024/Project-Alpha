package com.google.android.exoplayer2.b;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import easypay.manager.Constants;
import java.nio.ByteBuffer;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f31147a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f31148b = {48000, 44100, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f31149c = {24000, 22050, 16000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f31150d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f31151e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, Constants.EASY_PAY_INVISIBLE_ASSIST, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS, UpiConstants.REQUEST_CODE_BANK_DETAIL, 384, 448, 512, 576, 640};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f31152f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a() {
        return 1536;
    }

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    public static final class C0530a {

        /* renamed from: a  reason: collision with root package name */
        public final String f31153a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31154b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31155c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31156d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31157e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31158f;

        /* synthetic */ C0530a(String str, int i2, int i3, int i4, int i5, int i6, byte b2) {
            this(str, i2, i3, i4, i5, i6);
        }

        private C0530a(String str, int i2, int i3, int i4, int i5, int i6) {
            this.f31153a = str;
            this.f31154b = i2;
            this.f31156d = i3;
            this.f31155c = i4;
            this.f31157e = i5;
            this.f31158f = i6;
        }
    }

    public static Format a(r rVar, String str, String str2, DrmInitData drmInitData) {
        int i2 = f31148b[(rVar.c() & 192) >> 6];
        int c2 = rVar.c();
        int i3 = f31150d[(c2 & 56) >> 3];
        if ((c2 & 4) != 0) {
            i3++;
        }
        return Format.a(str, "audio/ac3", -1, -1, i3, i2, (List<byte[]>) null, drmInitData, str2);
    }

    public static Format b(r rVar, String str, String str2, DrmInitData drmInitData) {
        rVar.d(2);
        int i2 = f31148b[(rVar.c() & 192) >> 6];
        int c2 = rVar.c();
        int i3 = f31150d[(c2 & 14) >> 1];
        if ((c2 & 1) != 0) {
            i3++;
        }
        if (((rVar.c() & 30) >> 1) > 0 && (2 & rVar.c()) != 0) {
            i3 += 2;
        }
        return Format.a(str, (rVar.b() <= 0 || (rVar.c() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc", -1, -1, i3, i2, (List<byte[]>) null, drmInitData, str2);
    }

    public static C0530a a(q qVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        int i7;
        int i8;
        int i9;
        int i10;
        q qVar2 = qVar;
        int b2 = qVar.b();
        qVar2.b(40);
        boolean z = qVar2.c(5) == 16;
        qVar2.a(b2);
        int i11 = -1;
        if (z) {
            qVar2.b(16);
            int c2 = qVar2.c(2);
            if (c2 == 0) {
                i11 = 0;
            } else if (c2 == 1) {
                i11 = 1;
            } else if (c2 == 2) {
                i11 = 2;
            }
            qVar2.b(3);
            int c3 = (qVar2.c(11) + 1) * 2;
            int c4 = qVar2.c(2);
            if (c4 == 3) {
                i7 = f31149c[qVar2.c(2)];
                i9 = 3;
                i8 = 6;
            } else {
                i9 = qVar2.c(2);
                i8 = f31147a[i9];
                i7 = f31148b[c4];
            }
            int i12 = i8 * UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
            int c5 = qVar2.c(3);
            boolean e2 = qVar.e();
            int i13 = f31150d[c5] + (e2 ? 1 : 0);
            qVar2.b(10);
            if (qVar.e()) {
                qVar2.b(8);
            }
            if (c5 == 0) {
                qVar2.b(5);
                if (qVar.e()) {
                    qVar2.b(8);
                }
            }
            if (i11 == 1 && qVar.e()) {
                qVar2.b(16);
            }
            if (qVar.e()) {
                if (c5 > 2) {
                    qVar2.b(2);
                }
                if ((c5 & 1) != 0 && c5 > 2) {
                    qVar2.b(6);
                }
                if ((c5 & 4) != 0) {
                    qVar2.b(6);
                }
                if (e2 && qVar.e()) {
                    qVar2.b(5);
                }
                if (i11 == 0) {
                    if (qVar.e()) {
                        qVar2.b(6);
                    }
                    if (c5 == 0 && qVar.e()) {
                        qVar2.b(6);
                    }
                    if (qVar.e()) {
                        qVar2.b(6);
                    }
                    int c6 = qVar2.c(2);
                    if (c6 == 1) {
                        qVar2.b(5);
                    } else if (c6 == 2) {
                        qVar2.b(12);
                    } else if (c6 == 3) {
                        int c7 = qVar2.c(5);
                        if (qVar.e()) {
                            qVar2.b(5);
                            if (qVar.e()) {
                                qVar2.b(4);
                            }
                            if (qVar.e()) {
                                qVar2.b(4);
                            }
                            if (qVar.e()) {
                                qVar2.b(4);
                            }
                            if (qVar.e()) {
                                qVar2.b(4);
                            }
                            if (qVar.e()) {
                                qVar2.b(4);
                            }
                            if (qVar.e()) {
                                qVar2.b(4);
                            }
                            if (qVar.e()) {
                                qVar2.b(4);
                            }
                            if (qVar.e()) {
                                if (qVar.e()) {
                                    qVar2.b(4);
                                }
                                if (qVar.e()) {
                                    qVar2.b(4);
                                }
                            }
                        }
                        if (qVar.e()) {
                            qVar2.b(5);
                            if (qVar.e()) {
                                qVar2.b(7);
                                if (qVar.e()) {
                                    qVar2.b(8);
                                }
                            }
                        }
                        qVar2.b((c7 + 2) * 8);
                        qVar.f();
                    }
                    if (c5 < 2) {
                        if (qVar.e()) {
                            qVar2.b(14);
                        }
                        if (c5 == 0 && qVar.e()) {
                            qVar2.b(14);
                        }
                    }
                    if (qVar.e()) {
                        if (i9 == 0) {
                            qVar2.b(5);
                        } else {
                            for (int i14 = 0; i14 < i8; i14++) {
                                if (qVar.e()) {
                                    qVar2.b(5);
                                }
                            }
                        }
                    }
                }
            }
            if (qVar.e()) {
                qVar2.b(5);
                if (c5 == 2) {
                    qVar2.b(4);
                }
                if (c5 >= 6) {
                    qVar2.b(2);
                }
                if (qVar.e()) {
                    qVar2.b(8);
                }
                if (c5 == 0 && qVar.e()) {
                    qVar2.b(8);
                }
                i10 = 3;
                if (c4 < 3) {
                    qVar.d();
                }
            } else {
                i10 = 3;
            }
            if (i11 == 0 && i9 != i10) {
                qVar.d();
            }
            if (i11 == 2 && (i9 == i10 || qVar.e())) {
                qVar2.b(6);
            }
            str = (qVar.e() && qVar2.c(6) == 1 && qVar2.c(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i6 = i11;
            i3 = c3;
            i4 = i7;
            i2 = i12;
            i5 = i13;
        } else {
            qVar2.b(32);
            int c8 = qVar2.c(2);
            String str2 = c8 == 3 ? null : "audio/ac3";
            int a2 = a(c8, qVar2.c(6));
            qVar2.b(8);
            int c9 = qVar2.c(3);
            if (!((c9 & 1) == 0 || c9 == 1)) {
                qVar2.b(2);
            }
            if ((c9 & 4) != 0) {
                qVar2.b(2);
            }
            if (c9 == 2) {
                qVar2.b(2);
            }
            int[] iArr = f31148b;
            str = str2;
            i3 = a2;
            i4 = c8 < iArr.length ? iArr[c8] : -1;
            i5 = f31150d[c9] + (qVar.e() ? 1 : 0);
            i6 = -1;
            i2 = 1536;
        }
        return new C0530a(str, i6, i5, i4, i3, i2, (byte) 0);
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (!(((bArr[5] & 255) >> 3) == 16)) {
            return a((bArr[4] & 192) >> 6, (int) bArr[4] & 63);
        }
        return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2 = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i2 = f31147a[(byteBuffer.get(byteBuffer.position() + 4) & TarHeader.LF_NORMAL) >> 4];
        }
        return i2 * UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i2 = position; i2 <= limit; i2++) {
            if ((byteBuffer.getInt(i2 + 4) & -16777217) == -1167101192) {
                return i2 - position;
            }
        }
        return -1;
    }

    public static int b(byte[] bArr) {
        boolean z = false;
        if (bArr[4] != -8 || bArr[5] != 114 || bArr[6] != 111 || (bArr[7] & 254) != 186) {
            return 0;
        }
        if ((bArr[7] & 255) == 187) {
            z = true;
        }
        return 40 << ((bArr[z ? (char) 9 : 8] >> 4) & 7);
    }

    public static int a(ByteBuffer byteBuffer, int i2) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i2) + ((byteBuffer.get((byteBuffer.position() + i2) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    private static int a(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0) {
            return -1;
        }
        int[] iArr = f31148b;
        if (i2 >= iArr.length || i3 < 0) {
            return -1;
        }
        int[] iArr2 = f31152f;
        if (i4 >= iArr2.length) {
            return -1;
        }
        int i5 = iArr[i2];
        if (i5 == 44100) {
            return (iArr2[i4] + (i3 % 2)) * 2;
        }
        int i6 = f31151e[i4];
        return i5 == 32000 ? i6 * 6 : i6 * 4;
    }
}
