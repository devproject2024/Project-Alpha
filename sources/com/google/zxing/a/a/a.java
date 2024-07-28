package com.google.zxing.a.a;

import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.google.zxing.b.b;
import com.google.zxing.b.b.c;
import com.google.zxing.b.e;
import com.google.zxing.h;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f39840a = {"CTRL_PS", " ", "A", "B", AppConstants.FEED_COMMUNITY, UpiConstants.DEFAULT_ACCOUNT_CONSTANT, "E", AppConstants.FEED_SUB_TYPE, "G", "H", AppConstants.IMAGE_SUBTYPE, "J", AppConstants.THOUSANDS, "L", "M", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, "O", AppConstants.FEED_COMMUNITY_POST, "Q", "R", "S", "T", AppConstants.USER_SUB_TYPE, "V", AppConstants.CAROUSEL_SUB_TYPE, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f39841b = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f39842c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", StringUtility.NEW_LINE, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f39843d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", AppConstants.AND_SIGN, "'", "(", ")", "*", "+", AppConstants.COMMA, "-", AppUtility.CENTER_DOT, "/", AppConstants.COLON, ";", SimpleComparison.LESS_THAN_OPERATION, "=", SimpleComparison.GREATER_THAN_OPERATION, "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f39844e = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", AppConstants.COMMA, AppUtility.CENTER_DOT, "CTRL_UL", "CTRL_US"};

    /* renamed from: f  reason: collision with root package name */
    private com.google.zxing.a.a f39845f;

    /* renamed from: com.google.zxing.a.a.a$a  reason: collision with other inner class name */
    enum C0670a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    public final e a(com.google.zxing.a.a aVar) throws h {
        this.f39845f = aVar;
        boolean[] b2 = b(a(aVar.f39919d));
        e eVar = new e(c(b2), a(b2), (List<byte[]>) null, (String) null);
        eVar.f39911b = b2.length;
        return eVar;
    }

    private static String a(boolean[] zArr) {
        int length = zArr.length;
        C0670a aVar = C0670a.UPPER;
        C0670a aVar2 = C0670a.UPPER;
        StringBuilder sb = new StringBuilder(20);
        C0670a aVar3 = aVar;
        int i2 = 0;
        while (i2 < length) {
            if (aVar2 == C0670a.BINARY) {
                if (length - i2 < 5) {
                    break;
                }
                int a2 = a(zArr, i2, 5);
                int i3 = i2 + 5;
                if (a2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    a2 = a(zArr, i3, 11) + 31;
                    i3 += 11;
                }
                int i4 = i3;
                int i5 = 0;
                while (true) {
                    if (i5 >= a2) {
                        i2 = i4;
                        break;
                    } else if (length - i4 < 8) {
                        i2 = length;
                        break;
                    } else {
                        sb.append((char) a(zArr, i4, 8));
                        i4 += 8;
                        i5++;
                    }
                }
            } else {
                int i6 = aVar2 == C0670a.DIGIT ? 4 : 5;
                if (length - i2 < i6) {
                    break;
                }
                int a3 = a(zArr, i2, i6);
                i2 += i6;
                String a4 = a(aVar2, a3);
                if (a4.startsWith("CTRL_")) {
                    aVar3 = a(a4.charAt(5));
                    if (a4.charAt(6) != 'L') {
                        C0670a aVar4 = aVar3;
                        aVar3 = aVar2;
                        aVar2 = aVar4;
                    }
                } else {
                    sb.append(a4);
                }
            }
            aVar2 = aVar3;
        }
        return sb.toString();
    }

    private static C0670a a(char c2) {
        if (c2 == 'B') {
            return C0670a.BINARY;
        }
        if (c2 == 'D') {
            return C0670a.DIGIT;
        }
        if (c2 == 'P') {
            return C0670a.PUNCT;
        }
        if (c2 == 'L') {
            return C0670a.LOWER;
        }
        if (c2 != 'M') {
            return C0670a.UPPER;
        }
        return C0670a.MIXED;
    }

    /* renamed from: com.google.zxing.a.a.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f39846a = new int[C0670a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.zxing.a.a.a$a[] r0 = com.google.zxing.a.a.a.C0670a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f39846a = r0
                int[] r0 = f39846a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.zxing.a.a.a$a r1 = com.google.zxing.a.a.a.C0670a.UPPER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f39846a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.zxing.a.a.a$a r1 = com.google.zxing.a.a.a.C0670a.LOWER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f39846a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.zxing.a.a.a$a r1 = com.google.zxing.a.a.a.C0670a.MIXED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f39846a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.zxing.a.a.a$a r1 = com.google.zxing.a.a.a.C0670a.PUNCT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f39846a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.zxing.a.a.a$a r1 = com.google.zxing.a.a.a.C0670a.DIGIT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.a.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    private static String a(C0670a aVar, int i2) {
        int i3 = AnonymousClass1.f39846a[aVar.ordinal()];
        if (i3 == 1) {
            return f39840a[i2];
        }
        if (i3 == 2) {
            return f39841b[i2];
        }
        if (i3 == 3) {
            return f39842c[i2];
        }
        if (i3 == 4) {
            return f39843d[i2];
        }
        if (i3 == 5) {
            return f39844e[i2];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] b(boolean[] zArr) throws h {
        com.google.zxing.b.b.a aVar;
        int i2 = 8;
        if (this.f39845f.f39839c <= 2) {
            i2 = 6;
            aVar = com.google.zxing.b.b.a.f39895c;
        } else if (this.f39845f.f39839c <= 8) {
            aVar = com.google.zxing.b.b.a.f39899g;
        } else if (this.f39845f.f39839c <= 22) {
            i2 = 10;
            aVar = com.google.zxing.b.b.a.f39894b;
        } else {
            i2 = 12;
            aVar = com.google.zxing.b.b.a.f39893a;
        }
        int i3 = this.f39845f.f39838b;
        int length = zArr.length / i2;
        if (length >= i3) {
            int[] iArr = new int[length];
            int length2 = zArr.length % i2;
            int i4 = 0;
            while (i4 < length) {
                iArr[i4] = a(zArr, length2, i2);
                i4++;
                length2 += i2;
            }
            try {
                new c(aVar).a(iArr, length - i3);
                int i5 = (1 << i2) - 1;
                int i6 = 0;
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = iArr[i7];
                    if (i8 == 0 || i8 == i5) {
                        throw h.getFormatInstance();
                    }
                    if (i8 == 1 || i8 == i5 - 1) {
                        i6++;
                    }
                }
                boolean[] zArr2 = new boolean[((i3 * i2) - i6)];
                int i9 = 0;
                for (int i10 = 0; i10 < i3; i10++) {
                    int i11 = iArr[i10];
                    if (i11 == 1 || i11 == i5 - 1) {
                        Arrays.fill(zArr2, i9, (i9 + i2) - 1, i11 > 1);
                        i9 += i2 - 1;
                    } else {
                        int i12 = i2 - 1;
                        while (i12 >= 0) {
                            int i13 = i9 + 1;
                            zArr2[i9] = ((1 << i12) & i11) != 0;
                            i12--;
                            i9 = i13;
                        }
                    }
                }
                return zArr2;
            } catch (com.google.zxing.b.b.e e2) {
                throw h.getFormatInstance(e2);
            }
        } else {
            throw h.getFormatInstance();
        }
    }

    private boolean[] a(b bVar) {
        b bVar2 = bVar;
        boolean z = this.f39845f.f39837a;
        int i2 = this.f39845f.f39839c;
        int i3 = (z ? 11 : 14) + (i2 << 2);
        int[] iArr = new int[i3];
        boolean[] zArr = new boolean[a(i2, z)];
        int i4 = 2;
        if (z) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                iArr[i5] = i5;
            }
        } else {
            int i6 = i3 / 2;
            int i7 = ((i3 + 1) + (((i6 - 1) / 15) * 2)) / 2;
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = (i8 / 15) + i8;
                iArr[(i6 - i8) - 1] = (i7 - i9) - 1;
                iArr[i6 + i8] = i9 + i7 + 1;
            }
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < i2) {
            int i12 = ((i2 - i10) << i4) + (z ? 9 : 12);
            int i13 = i10 << 1;
            int i14 = (i3 - 1) - i13;
            int i15 = 0;
            while (i15 < i12) {
                int i16 = i15 << 1;
                int i17 = 0;
                while (i17 < i4) {
                    int i18 = i13 + i17;
                    int i19 = i13 + i15;
                    zArr[i11 + i16 + i17] = bVar2.a(iArr[i18], iArr[i19]);
                    int i20 = iArr[i19];
                    int i21 = i14 - i17;
                    zArr[(i12 * 2) + i11 + i16 + i17] = bVar2.a(i20, iArr[i21]);
                    int i22 = i14 - i15;
                    zArr[(i12 * 4) + i11 + i16 + i17] = bVar2.a(iArr[i21], iArr[i22]);
                    zArr[(i12 * 6) + i11 + i16 + i17] = bVar2.a(iArr[i22], iArr[i18]);
                    i17++;
                    i2 = i2;
                    z = z;
                    i4 = 2;
                }
                boolean z2 = z;
                int i23 = i2;
                i15++;
                i4 = 2;
            }
            boolean z3 = z;
            int i24 = i2;
            i11 += i12 << 3;
            i10++;
            i4 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    private static byte a(boolean[] zArr, int i2) {
        int a2;
        int length = zArr.length - i2;
        if (length >= 8) {
            a2 = a(zArr, i2, 8);
        } else {
            a2 = a(zArr, i2, length) << (8 - length);
        }
        return (byte) a2;
    }

    private static byte[] c(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = a(zArr, i2 << 3);
        }
        return bArr;
    }
}
