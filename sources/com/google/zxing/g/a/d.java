package com.google.zxing.g.a;

import com.google.zxing.b.c;
import com.google.zxing.b.e;
import com.google.zxing.b.l;
import com.google.zxing.h;
import easypay.manager.Constants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f40506a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    static e a(byte[] bArr, j jVar, f fVar, Map<com.google.zxing.e, ?> map) throws h {
        h forBits;
        h hVar;
        String str;
        int i2;
        int a2;
        int i3;
        j jVar2 = jVar;
        c cVar = new c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i4 = 1;
        ArrayList arrayList = new ArrayList(1);
        com.google.zxing.b.d dVar = null;
        boolean z = false;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            try {
                if (cVar.a() < 4) {
                    forBits = h.TERMINATOR;
                } else {
                    forBits = h.forBits(cVar.a(4));
                }
                h hVar2 = forBits;
                switch (hVar2) {
                    case TERMINATOR:
                        break;
                    case FNC1_FIRST_POSITION:
                    case FNC1_SECOND_POSITION:
                        hVar = hVar2;
                        z = true;
                        break;
                    case STRUCTURED_APPEND:
                        if (cVar.a() >= 16) {
                            i5 = cVar.a(8);
                            i6 = cVar.a(8);
                            break;
                        } else {
                            throw h.getFormatInstance();
                        }
                    case ECI:
                        int a3 = cVar.a(8);
                        if ((a3 & 128) == 0) {
                            i2 = a3 & 127;
                        } else {
                            if ((a3 & 192) == 128) {
                                a2 = cVar.a(8);
                                i3 = (a3 & 63) << 8;
                            } else if ((a3 & Constants.EASY_PAY_INVISIBLE_ASSIST) == 192) {
                                a2 = cVar.a(16);
                                i3 = (a3 & 31) << 16;
                            } else {
                                throw h.getFormatInstance();
                            }
                            i2 = i3 | a2;
                        }
                        dVar = com.google.zxing.b.d.getCharacterSetECIByValue(i2);
                        if (dVar != null) {
                            break;
                        } else {
                            throw h.getFormatInstance();
                        }
                    case HANZI:
                        int a4 = cVar.a(4);
                        int a5 = cVar.a(hVar2.getCharacterCountBits(jVar2));
                        if (a4 == i4) {
                            a(cVar, sb, a5);
                            break;
                        }
                        break;
                    default:
                        int a6 = cVar.a(hVar2.getCharacterCountBits(jVar2));
                        int i7 = AnonymousClass1.f40507a[hVar2.ordinal()];
                        if (i7 != i4) {
                            if (i7 != 2) {
                                if (i7 == 3) {
                                    hVar = hVar2;
                                    a(cVar, sb, a6, dVar, arrayList, map);
                                    break;
                                } else if (i7 == 4) {
                                    b(cVar, sb, a6);
                                    break;
                                } else {
                                    throw h.getFormatInstance();
                                }
                            } else {
                                hVar = hVar2;
                                a(cVar, sb, a6, z);
                                break;
                            }
                        } else {
                            hVar = hVar2;
                            c(cVar, sb, a6);
                            break;
                        }
                }
                hVar = hVar2;
                if (hVar == h.TERMINATOR) {
                    String sb2 = sb.toString();
                    ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
                    if (fVar == null) {
                        str = null;
                    } else {
                        str = fVar.toString();
                    }
                    return new e(bArr, sb2, arrayList2, str, i5, i6);
                }
                i4 = 1;
            } catch (IllegalArgumentException unused) {
                throw h.getFormatInstance();
            }
        }
    }

    private static void a(c cVar, StringBuilder sb, int i2) throws h {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[(i2 * 2)];
            int i3 = 0;
            while (i2 > 0) {
                int a2 = cVar.a(13);
                int i4 = (a2 % 96) | ((a2 / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw h.getFormatInstance();
            }
        } else {
            throw h.getFormatInstance();
        }
    }

    private static void b(c cVar, StringBuilder sb, int i2) throws h {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[(i2 * 2)];
            int i3 = 0;
            while (i2 > 0) {
                int a2 = cVar.a(13);
                int i4 = (a2 % 192) | ((a2 / 192) << 8);
                int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw h.getFormatInstance();
            }
        } else {
            throw h.getFormatInstance();
        }
    }

    private static void a(c cVar, StringBuilder sb, int i2, com.google.zxing.b.d dVar, Collection<byte[]> collection, Map<com.google.zxing.e, ?> map) throws h {
        String str;
        if ((i2 << 3) <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.a(8);
            }
            if (dVar == null) {
                str = l.a(bArr, map);
            } else {
                str = dVar.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw h.getFormatInstance();
            }
        } else {
            throw h.getFormatInstance();
        }
    }

    private static char a(int i2) throws h {
        char[] cArr = f40506a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw h.getFormatInstance();
    }

    private static void a(c cVar, StringBuilder sb, int i2, boolean z) throws h {
        while (i2 > 1) {
            if (cVar.a() >= 11) {
                int a2 = cVar.a(11);
                sb.append(a(a2 / 45));
                sb.append(a(a2 % 45));
                i2 -= 2;
            } else {
                throw h.getFormatInstance();
            }
        }
        if (i2 == 1) {
            if (cVar.a() >= 6) {
                sb.append(a(cVar.a(6)));
            } else {
                throw h.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void c(c cVar, StringBuilder sb, int i2) throws h {
        while (i2 >= 3) {
            if (cVar.a() >= 10) {
                int a2 = cVar.a(10);
                if (a2 < 1000) {
                    sb.append(a(a2 / 100));
                    sb.append(a((a2 / 10) % 10));
                    sb.append(a(a2 % 10));
                    i2 -= 3;
                } else {
                    throw h.getFormatInstance();
                }
            } else {
                throw h.getFormatInstance();
            }
        }
        if (i2 == 2) {
            if (cVar.a() >= 7) {
                int a3 = cVar.a(7);
                if (a3 < 100) {
                    sb.append(a(a3 / 10));
                    sb.append(a(a3 % 10));
                    return;
                }
                throw h.getFormatInstance();
            }
            throw h.getFormatInstance();
        } else if (i2 != 1) {
        } else {
            if (cVar.a() >= 4) {
                int a4 = cVar.a(4);
                if (a4 < 10) {
                    sb.append(a(a4));
                    return;
                }
                throw h.getFormatInstance();
            }
            throw h.getFormatInstance();
        }
    }
}
