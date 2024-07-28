package com.google.zxing.c.a;

import com.google.zxing.h;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.upi.util.UpiConstants;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f39946a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f39947b = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f39948c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f39949d = f39947b;

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f39950e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    enum a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.zxing.b.e a(byte[] r7) throws com.google.zxing.h {
        /*
            com.google.zxing.b.c r0 = new com.google.zxing.b.c
            r0.<init>(r7)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 0
            r2.<init>(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 1
            r3.<init>(r4)
            com.google.zxing.c.a.c$a r5 = com.google.zxing.c.a.c.a.ASCII_ENCODE
        L_0x001a:
            com.google.zxing.c.a.c$a r6 = com.google.zxing.c.a.c.a.ASCII_ENCODE
            if (r5 != r6) goto L_0x0023
            com.google.zxing.c.a.c$a r5 = a((com.google.zxing.b.c) r0, (java.lang.StringBuilder) r1, (java.lang.StringBuilder) r2)
            goto L_0x0053
        L_0x0023:
            int[] r6 = com.google.zxing.c.a.c.AnonymousClass1.f39951a
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 == r4) goto L_0x004e
            r6 = 2
            if (r5 == r6) goto L_0x004a
            r6 = 3
            if (r5 == r6) goto L_0x0046
            r6 = 4
            if (r5 == r6) goto L_0x0042
            r6 = 5
            if (r5 != r6) goto L_0x003d
            a((com.google.zxing.b.c) r0, (java.lang.StringBuilder) r1, (java.util.Collection<byte[]>) r3)
            goto L_0x0051
        L_0x003d:
            com.google.zxing.h r7 = com.google.zxing.h.getFormatInstance()
            throw r7
        L_0x0042:
            d(r0, r1)
            goto L_0x0051
        L_0x0046:
            c(r0, r1)
            goto L_0x0051
        L_0x004a:
            b(r0, r1)
            goto L_0x0051
        L_0x004e:
            a((com.google.zxing.b.c) r0, (java.lang.StringBuilder) r1)
        L_0x0051:
            com.google.zxing.c.a.c$a r5 = com.google.zxing.c.a.c.a.ASCII_ENCODE
        L_0x0053:
            com.google.zxing.c.a.c$a r6 = com.google.zxing.c.a.c.a.PAD_ENCODE
            if (r5 == r6) goto L_0x005d
            int r6 = r0.a()
            if (r6 > 0) goto L_0x001a
        L_0x005d:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x0066
            r1.append(r2)
        L_0x0066:
            com.google.zxing.b.e r0 = new com.google.zxing.b.e
            java.lang.String r1 = r1.toString()
            boolean r2 = r3.isEmpty()
            r4 = 0
            if (r2 == 0) goto L_0x0074
            r3 = r4
        L_0x0074:
            r0.<init>(r7, r1, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.c.a.c.a(byte[]):com.google.zxing.b.e");
    }

    /* renamed from: com.google.zxing.c.a.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f39951a = new int[a.values().length];

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
                com.google.zxing.c.a.c$a[] r0 = com.google.zxing.c.a.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f39951a = r0
                int[] r0 = f39951a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.zxing.c.a.c$a r1 = com.google.zxing.c.a.c.a.C40_ENCODE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f39951a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.zxing.c.a.c$a r1 = com.google.zxing.c.a.c.a.TEXT_ENCODE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f39951a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.zxing.c.a.c$a r1 = com.google.zxing.c.a.c.a.ANSIX12_ENCODE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f39951a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.zxing.c.a.c$a r1 = com.google.zxing.c.a.c.a.EDIFACT_ENCODE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f39951a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.zxing.c.a.c$a r1 = com.google.zxing.c.a.c.a.BASE256_ENCODE     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.c.a.c.AnonymousClass1.<clinit>():void");
        }
    }

    private static a a(com.google.zxing.b.c cVar, StringBuilder sb, StringBuilder sb2) throws h {
        boolean z = false;
        do {
            int a2 = cVar.a(8);
            if (a2 == 0) {
                throw h.getFormatInstance();
            } else if (a2 <= 128) {
                if (z) {
                    a2 += 128;
                }
                sb.append((char) (a2 - 1));
                return a.ASCII_ENCODE;
            } else if (a2 == 129) {
                return a.PAD_ENCODE;
            } else {
                if (a2 <= 229) {
                    int i2 = a2 - 130;
                    if (i2 < 10) {
                        sb.append('0');
                    }
                    sb.append(i2);
                } else {
                    switch (a2) {
                        case 230:
                            return a.C40_ENCODE;
                        case 231:
                            return a.BASE256_ENCODE;
                        case 232:
                            sb.append(29);
                            break;
                        case UpiPushView.REQUEST_CODE_UPI_CHECK_BALANCE /*233*/:
                        case 234:
                        case 241:
                            break;
                        case 235:
                            z = true;
                            break;
                        case 236:
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, "\u001e\u0004");
                            break;
                        case 237:
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, "\u001e\u0004");
                            break;
                        case 238:
                            return a.ANSIX12_ENCODE;
                        case 239:
                            return a.TEXT_ENCODE;
                        case 240:
                            return a.EDIFACT_ENCODE;
                        default:
                            if (!(a2 == 254 && cVar.a() == 0)) {
                                throw h.getFormatInstance();
                            }
                    }
                }
            }
        } while (cVar.a() > 0);
        return a.ASCII_ENCODE;
    }

    private static void a(com.google.zxing.b.c cVar, StringBuilder sb) throws h {
        int a2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (a2 = cVar.a(8)) != 254) {
            a(a2, cVar.a(8), iArr);
            boolean z2 = z;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f39947b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append(29);
                            } else if (i4 == 30) {
                                z2 = true;
                            } else {
                                throw h.getFormatInstance();
                            }
                            i2 = 0;
                        } else if (i2 != 3) {
                            throw h.getFormatInstance();
                        } else if (z2) {
                            sb.append((char) (i4 + Constants.EASY_PAY_INVISIBLE_ASSIST));
                        } else {
                            sb.append((char) (i4 + 96));
                            i2 = 0;
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                    z2 = false;
                    i2 = 0;
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = f39946a;
                    if (i4 < cArr2.length) {
                        char c3 = cArr2[i4];
                        if (z2) {
                            sb.append((char) (c3 + 128));
                            z2 = false;
                        } else {
                            sb.append(c3);
                        }
                    } else {
                        throw h.getFormatInstance();
                    }
                }
            }
            if (cVar.a() > 0) {
                z = z2;
            } else {
                return;
            }
        }
    }

    private static void b(com.google.zxing.b.c cVar, StringBuilder sb) throws h {
        int a2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (a2 = cVar.a(8)) != 254) {
            a(a2, cVar.a(8), iArr);
            boolean z2 = z;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f39949d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append(29);
                            } else if (i4 == 30) {
                                z2 = true;
                            } else {
                                throw h.getFormatInstance();
                            }
                            i2 = 0;
                        } else if (i2 == 3) {
                            char[] cArr2 = f39950e;
                            if (i4 < cArr2.length) {
                                char c3 = cArr2[i4];
                                if (z2) {
                                    sb.append((char) (c3 + 128));
                                } else {
                                    sb.append(c3);
                                    i2 = 0;
                                }
                            } else {
                                throw h.getFormatInstance();
                            }
                        } else {
                            throw h.getFormatInstance();
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                    z2 = false;
                    i2 = 0;
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f39948c;
                    if (i4 < cArr3.length) {
                        char c4 = cArr3[i4];
                        if (z2) {
                            sb.append((char) (c4 + 128));
                            z2 = false;
                        } else {
                            sb.append(c4);
                        }
                    } else {
                        throw h.getFormatInstance();
                    }
                }
            }
            if (cVar.a() > 0) {
                z = z2;
            } else {
                return;
            }
        }
    }

    private static void c(com.google.zxing.b.c cVar, StringBuilder sb) throws h {
        int a2;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (a2 = cVar.a(8)) != 254) {
            a(a2, cVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append(13);
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append('>');
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else if (i3 < 40) {
                    sb.append((char) (i3 + 51));
                } else {
                    throw h.getFormatInstance();
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static void d(com.google.zxing.b.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int a2 = cVar.a(6);
                if (a2 == 31) {
                    int i3 = 8 - cVar.f39908b;
                    if (i3 != 8) {
                        cVar.a(i3);
                        return;
                    }
                    return;
                }
                if ((a2 & 32) == 0) {
                    a2 |= 64;
                }
                sb.append((char) a2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static int a(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % PriceRangeSeekBar.INVALID_POINTER_ID) + 1);
        return i4 >= 0 ? i4 : i4 + UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
    }

    private static void a(com.google.zxing.b.c cVar, StringBuilder sb, Collection<byte[]> collection) throws h {
        int i2 = cVar.f39907a + 1;
        int i3 = i2 + 1;
        int a2 = a(cVar.a(8), i2);
        if (a2 == 0) {
            a2 = cVar.a() / 8;
        } else if (a2 >= 250) {
            a2 = ((a2 - 249) * 250) + a(cVar.a(8), i3);
            i3++;
        }
        if (a2 >= 0) {
            byte[] bArr = new byte[a2];
            int i4 = 0;
            while (i4 < a2) {
                if (cVar.a() >= 8) {
                    bArr[i4] = (byte) a(cVar.a(8), i3);
                    i4++;
                    i3++;
                } else {
                    throw h.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
            }
        } else {
            throw h.getFormatInstance();
        }
    }
}
