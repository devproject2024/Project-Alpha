package com.ta.utdid2.a.a;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import java.io.UnsupportedEncodingException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f16105a = (!b.class.desiredAssertionStatus());

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f16106a;

        /* renamed from: b  reason: collision with root package name */
        public int f16107b;

        a() {
        }
    }

    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        C0218b bVar = new C0218b(new byte[((length * 3) / 4)]);
        boolean z = false;
        int i2 = 1;
        if (bVar.f16110c != 6) {
            int i3 = length + 0;
            int i4 = bVar.f16110c;
            int i5 = bVar.f16111d;
            byte[] bArr = bVar.f16106a;
            int[] iArr = bVar.f16112e;
            int i6 = i5;
            int i7 = 0;
            int i8 = i4;
            int i9 = 0;
            while (true) {
                if (i9 >= i3) {
                    break;
                }
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i3) {
                            break;
                        }
                        i6 = iArr[bytes[i9 + 3] & 255] | (iArr[bytes[i9 + 1] & 255] << 12) | (iArr[bytes[i9] & 255] << 18) | (iArr[bytes[i9 + 2] & 255] << 6);
                        if (i6 < 0) {
                            break;
                        }
                        bArr[i7 + 2] = (byte) i6;
                        bArr[i7 + 1] = (byte) (i6 >> 8);
                        bArr[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i3) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bytes[i9] & 255];
                if (i8 == 0) {
                    if (i12 < 0) {
                        if (i12 != -1) {
                            bVar.f16110c = 6;
                            break;
                        }
                    } else {
                        i8++;
                        i6 = i12;
                        i9 = i11;
                        i2 = 1;
                    }
                } else {
                    if (i8 == i2) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                bVar.f16110c = 6;
                                break;
                            }
                        }
                    } else if (i8 == 2) {
                        if (i12 < 0) {
                            if (i12 != -2) {
                                if (i12 != -1) {
                                    bVar.f16110c = 6;
                                    break;
                                }
                            } else {
                                bArr[i7] = (byte) (i6 >> 4);
                                i7++;
                                i9 = i11;
                                i2 = 1;
                                i8 = 4;
                            }
                        }
                    } else if (i8 == 3) {
                        if (i12 < 0) {
                            if (i12 != -2) {
                                if (i12 != -1) {
                                    bVar.f16110c = 6;
                                    break;
                                }
                            } else {
                                bArr[i7 + 1] = (byte) (i6 >> 2);
                                bArr[i7] = (byte) (i6 >> 10);
                                i7 += 2;
                                i9 = i11;
                                i2 = 1;
                                i8 = 5;
                            }
                        } else {
                            i6 = (i6 << 6) | i12;
                            bArr[i7 + 2] = (byte) i6;
                            bArr[i7 + 1] = (byte) (i6 >> 8);
                            bArr[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i11;
                            i2 = 1;
                            i8 = 0;
                        }
                    } else if (i8 != 4) {
                        if (i8 == 5 && i12 != -1) {
                            bVar.f16110c = 6;
                            break;
                        }
                    } else {
                        if (i12 != -2) {
                            if (i12 != -1) {
                                bVar.f16110c = 6;
                                break;
                            }
                        }
                        i8++;
                        i9 = i11;
                        i2 = 1;
                    }
                    i6 = (i6 << 6) | i12;
                    i8++;
                    i9 = i11;
                    i2 = 1;
                }
                i9 = i11;
                i2 = 1;
            }
            if (i8 != 0) {
                if (i8 == i2) {
                    bVar.f16110c = 6;
                } else if (i8 == 2) {
                    bArr[i7] = (byte) (i6 >> 4);
                    i7++;
                } else if (i8 == 3) {
                    int i13 = i7 + 1;
                    bArr[i7] = (byte) (i6 >> 10);
                    i7 = i13 + 1;
                    bArr[i13] = (byte) (i6 >> 2);
                } else if (i8 == 4) {
                    bVar.f16110c = 6;
                }
                z = false;
            }
            bVar.f16110c = i8;
            bVar.f16107b = i7;
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.f16107b == bVar.f16106a.length) {
            return bVar.f16106a;
        } else {
            byte[] bArr2 = new byte[bVar.f16107b];
            System.arraycopy(bVar.f16106a, 0, bArr2, 0, bVar.f16107b);
            return bArr2;
        }
    }

    /* renamed from: com.ta.utdid2.a.a.b$b  reason: collision with other inner class name */
    static class C0218b extends a {

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f16108f;

        /* renamed from: g  reason: collision with root package name */
        private static final int[] f16109g;

        /* renamed from: c  reason: collision with root package name */
        int f16110c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f16111d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int[] f16112e = f16108f;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: int[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: int[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                r0 = 256(0x100, float:3.59E-43)
                int[] r0 = new int[r0]
                r1 = -1
                r2 = 0
                r0[r2] = r1
                r2 = 1
                r0[r2] = r1
                r3 = 2
                r0[r3] = r1
                r4 = 3
                r0[r4] = r1
                r5 = 4
                r0[r5] = r1
                r6 = 5
                r0[r6] = r1
                r7 = 6
                r0[r7] = r1
                r8 = 7
                r0[r8] = r1
                r9 = 8
                r0[r9] = r1
                r10 = 9
                r0[r10] = r1
                r11 = 10
                r0[r11] = r1
                r12 = 11
                r0[r12] = r1
                r13 = 12
                r0[r13] = r1
                r14 = 13
                r0[r14] = r1
                r15 = 14
                r0[r15] = r1
                r16 = 15
                r0[r16] = r1
                r16 = 16
                r0[r16] = r1
                r16 = 17
                r0[r16] = r1
                r16 = 18
                r0[r16] = r1
                r16 = 19
                r0[r16] = r1
                r16 = 20
                r0[r16] = r1
                r16 = 21
                r0[r16] = r1
                r16 = 22
                r0[r16] = r1
                r16 = 23
                r0[r16] = r1
                r16 = 24
                r0[r16] = r1
                r16 = 25
                r0[r16] = r1
                r16 = 26
                r0[r16] = r1
                r16 = 27
                r0[r16] = r1
                r16 = 28
                r0[r16] = r1
                r16 = 29
                r0[r16] = r1
                r16 = 30
                r0[r16] = r1
                r16 = 31
                r0[r16] = r1
                r16 = 32
                r0[r16] = r1
                r16 = 33
                r0[r16] = r1
                r16 = 34
                r0[r16] = r1
                r16 = 35
                r0[r16] = r1
                r16 = 36
                r0[r16] = r1
                r16 = 37
                r0[r16] = r1
                r16 = 38
                r0[r16] = r1
                r16 = 39
                r0[r16] = r1
                r16 = 40
                r0[r16] = r1
                r16 = 41
                r0[r16] = r1
                r16 = 42
                r0[r16] = r1
                r16 = 43
                r17 = 62
                r0[r16] = r17
                r16 = 44
                r0[r16] = r1
                r16 = 45
                r0[r16] = r1
                r16 = 46
                r0[r16] = r1
                r16 = 47
                r17 = 63
                r0[r16] = r17
                r16 = 48
                r17 = 52
                r0[r16] = r17
                r16 = 49
                r17 = 53
                r0[r16] = r17
                r16 = 50
                r17 = 54
                r0[r16] = r17
                r16 = 51
                r17 = 55
                r0[r16] = r17
                r16 = 52
                r17 = 56
                r0[r16] = r17
                r16 = 53
                r17 = 57
                r0[r16] = r17
                r16 = 54
                r17 = 58
                r0[r16] = r17
                r16 = 55
                r17 = 59
                r0[r16] = r17
                r16 = 56
                r17 = 60
                r0[r16] = r17
                r16 = 57
                r17 = 61
                r0[r16] = r17
                r16 = 58
                r0[r16] = r1
                r16 = 59
                r0[r16] = r1
                r16 = 60
                r0[r16] = r1
                r16 = 61
                r17 = -2
                r0[r16] = r17
                r16 = 62
                r0[r16] = r1
                r16 = 63
                r0[r16] = r1
                r16 = 64
                r0[r16] = r1
                r16 = 66
                r0[r16] = r2
                r16 = 67
                r0[r16] = r3
                r16 = 68
                r0[r16] = r4
                r16 = 69
                r0[r16] = r5
                r16 = 70
                r0[r16] = r6
                r16 = 71
                r0[r16] = r7
                r16 = 72
                r0[r16] = r8
                r16 = 73
                r0[r16] = r9
                r16 = 74
                r0[r16] = r10
                r16 = 75
                r0[r16] = r11
                r16 = 76
                r0[r16] = r12
                r16 = 77
                r0[r16] = r13
                r16 = 78
                r0[r16] = r14
                r16 = 79
                r0[r16] = r15
                r16 = 80
                r17 = 15
                r0[r16] = r17
                r16 = 81
                r17 = 16
                r0[r16] = r17
                r16 = 82
                r17 = 17
                r0[r16] = r17
                r16 = 83
                r17 = 18
                r0[r16] = r17
                r16 = 84
                r17 = 19
                r0[r16] = r17
                r16 = 85
                r17 = 20
                r0[r16] = r17
                r16 = 86
                r17 = 21
                r0[r16] = r17
                r16 = 87
                r17 = 22
                r0[r16] = r17
                r16 = 88
                r17 = 23
                r0[r16] = r17
                r16 = 89
                r17 = 24
                r0[r16] = r17
                r16 = 90
                r17 = 25
                r0[r16] = r17
                r16 = 91
                r0[r16] = r1
                r16 = 92
                r0[r16] = r1
                r16 = 93
                r0[r16] = r1
                r16 = 94
                r0[r16] = r1
                r16 = 95
                r0[r16] = r1
                r16 = 96
                r0[r16] = r1
                r16 = 97
                r17 = 26
                r0[r16] = r17
                r16 = 98
                r17 = 27
                r0[r16] = r17
                r16 = 99
                r17 = 28
                r0[r16] = r17
                r16 = 100
                r17 = 29
                r0[r16] = r17
                r16 = 101(0x65, float:1.42E-43)
                r17 = 30
                r0[r16] = r17
                r16 = 102(0x66, float:1.43E-43)
                r17 = 31
                r0[r16] = r17
                r16 = 103(0x67, float:1.44E-43)
                r17 = 32
                r0[r16] = r17
                r16 = 104(0x68, float:1.46E-43)
                r17 = 33
                r0[r16] = r17
                r16 = 105(0x69, float:1.47E-43)
                r17 = 34
                r0[r16] = r17
                r16 = 106(0x6a, float:1.49E-43)
                r17 = 35
                r0[r16] = r17
                r16 = 107(0x6b, float:1.5E-43)
                r17 = 36
                r0[r16] = r17
                r16 = 108(0x6c, float:1.51E-43)
                r17 = 37
                r0[r16] = r17
                r16 = 109(0x6d, float:1.53E-43)
                r17 = 38
                r0[r16] = r17
                r16 = 110(0x6e, float:1.54E-43)
                r17 = 39
                r0[r16] = r17
                r16 = 111(0x6f, float:1.56E-43)
                r17 = 40
                r0[r16] = r17
                r16 = 112(0x70, float:1.57E-43)
                r17 = 41
                r0[r16] = r17
                r16 = 113(0x71, float:1.58E-43)
                r17 = 42
                r0[r16] = r17
                r16 = 114(0x72, float:1.6E-43)
                r17 = 43
                r0[r16] = r17
                r16 = 115(0x73, float:1.61E-43)
                r17 = 44
                r0[r16] = r17
                r16 = 116(0x74, float:1.63E-43)
                r17 = 45
                r0[r16] = r17
                r16 = 117(0x75, float:1.64E-43)
                r17 = 46
                r0[r16] = r17
                r16 = 118(0x76, float:1.65E-43)
                r17 = 47
                r0[r16] = r17
                r16 = 119(0x77, float:1.67E-43)
                r17 = 48
                r0[r16] = r17
                r16 = 120(0x78, float:1.68E-43)
                r17 = 49
                r0[r16] = r17
                r16 = 121(0x79, float:1.7E-43)
                r17 = 50
                r0[r16] = r17
                r16 = 122(0x7a, float:1.71E-43)
                r17 = 51
                r0[r16] = r17
                r16 = 123(0x7b, float:1.72E-43)
                r0[r16] = r1
                r16 = 124(0x7c, float:1.74E-43)
                r0[r16] = r1
                r16 = 125(0x7d, float:1.75E-43)
                r0[r16] = r1
                r16 = 126(0x7e, float:1.77E-43)
                r0[r16] = r1
                r16 = 127(0x7f, float:1.78E-43)
                r0[r16] = r1
                r16 = 128(0x80, float:1.794E-43)
                r0[r16] = r1
                r16 = 129(0x81, float:1.81E-43)
                r0[r16] = r1
                r16 = 130(0x82, float:1.82E-43)
                r0[r16] = r1
                r16 = 131(0x83, float:1.84E-43)
                r0[r16] = r1
                r16 = 132(0x84, float:1.85E-43)
                r0[r16] = r1
                r16 = 133(0x85, float:1.86E-43)
                r0[r16] = r1
                r16 = 134(0x86, float:1.88E-43)
                r0[r16] = r1
                r16 = 135(0x87, float:1.89E-43)
                r0[r16] = r1
                r16 = 136(0x88, float:1.9E-43)
                r0[r16] = r1
                r16 = 137(0x89, float:1.92E-43)
                r0[r16] = r1
                r16 = 138(0x8a, float:1.93E-43)
                r0[r16] = r1
                r16 = 139(0x8b, float:1.95E-43)
                r0[r16] = r1
                r16 = 140(0x8c, float:1.96E-43)
                r0[r16] = r1
                r16 = 141(0x8d, float:1.98E-43)
                r0[r16] = r1
                r16 = 142(0x8e, float:1.99E-43)
                r0[r16] = r1
                r16 = 143(0x8f, float:2.0E-43)
                r0[r16] = r1
                r16 = 144(0x90, float:2.02E-43)
                r0[r16] = r1
                r16 = 145(0x91, float:2.03E-43)
                r0[r16] = r1
                r16 = 146(0x92, float:2.05E-43)
                r0[r16] = r1
                r16 = 147(0x93, float:2.06E-43)
                r0[r16] = r1
                r16 = 148(0x94, float:2.07E-43)
                r0[r16] = r1
                r16 = 149(0x95, float:2.09E-43)
                r0[r16] = r1
                r16 = 150(0x96, float:2.1E-43)
                r0[r16] = r1
                r16 = 151(0x97, float:2.12E-43)
                r0[r16] = r1
                r16 = 152(0x98, float:2.13E-43)
                r0[r16] = r1
                r16 = 153(0x99, float:2.14E-43)
                r0[r16] = r1
                r16 = 154(0x9a, float:2.16E-43)
                r0[r16] = r1
                r16 = 155(0x9b, float:2.17E-43)
                r0[r16] = r1
                r16 = 156(0x9c, float:2.19E-43)
                r0[r16] = r1
                r16 = 157(0x9d, float:2.2E-43)
                r0[r16] = r1
                r16 = 158(0x9e, float:2.21E-43)
                r0[r16] = r1
                r16 = 159(0x9f, float:2.23E-43)
                r0[r16] = r1
                r16 = 160(0xa0, float:2.24E-43)
                r0[r16] = r1
                r16 = 161(0xa1, float:2.26E-43)
                r0[r16] = r1
                r16 = 162(0xa2, float:2.27E-43)
                r0[r16] = r1
                r16 = 163(0xa3, float:2.28E-43)
                r0[r16] = r1
                r16 = 164(0xa4, float:2.3E-43)
                r0[r16] = r1
                r16 = 165(0xa5, float:2.31E-43)
                r0[r16] = r1
                r16 = 166(0xa6, float:2.33E-43)
                r0[r16] = r1
                r16 = 167(0xa7, float:2.34E-43)
                r0[r16] = r1
                r16 = 168(0xa8, float:2.35E-43)
                r0[r16] = r1
                r16 = 169(0xa9, float:2.37E-43)
                r0[r16] = r1
                r16 = 170(0xaa, float:2.38E-43)
                r0[r16] = r1
                r16 = 171(0xab, float:2.4E-43)
                r0[r16] = r1
                r16 = 172(0xac, float:2.41E-43)
                r0[r16] = r1
                r16 = 173(0xad, float:2.42E-43)
                r0[r16] = r1
                r16 = 174(0xae, float:2.44E-43)
                r0[r16] = r1
                r16 = 175(0xaf, float:2.45E-43)
                r0[r16] = r1
                r16 = 176(0xb0, float:2.47E-43)
                r0[r16] = r1
                r16 = 177(0xb1, float:2.48E-43)
                r0[r16] = r1
                r16 = 178(0xb2, float:2.5E-43)
                r0[r16] = r1
                r16 = 179(0xb3, float:2.51E-43)
                r0[r16] = r1
                r16 = 180(0xb4, float:2.52E-43)
                r0[r16] = r1
                r16 = 181(0xb5, float:2.54E-43)
                r0[r16] = r1
                r16 = 182(0xb6, float:2.55E-43)
                r0[r16] = r1
                r16 = 183(0xb7, float:2.56E-43)
                r0[r16] = r1
                r16 = 184(0xb8, float:2.58E-43)
                r0[r16] = r1
                r16 = 185(0xb9, float:2.59E-43)
                r0[r16] = r1
                r16 = 186(0xba, float:2.6E-43)
                r0[r16] = r1
                r16 = 187(0xbb, float:2.62E-43)
                r0[r16] = r1
                r16 = 188(0xbc, float:2.63E-43)
                r0[r16] = r1
                r16 = 189(0xbd, float:2.65E-43)
                r0[r16] = r1
                r16 = 190(0xbe, float:2.66E-43)
                r0[r16] = r1
                r16 = 191(0xbf, float:2.68E-43)
                r0[r16] = r1
                r16 = 192(0xc0, float:2.69E-43)
                r0[r16] = r1
                r16 = 193(0xc1, float:2.7E-43)
                r0[r16] = r1
                r16 = 194(0xc2, float:2.72E-43)
                r0[r16] = r1
                r16 = 195(0xc3, float:2.73E-43)
                r0[r16] = r1
                r16 = 196(0xc4, float:2.75E-43)
                r0[r16] = r1
                r16 = 197(0xc5, float:2.76E-43)
                r0[r16] = r1
                r16 = 198(0xc6, float:2.77E-43)
                r0[r16] = r1
                r16 = 199(0xc7, float:2.79E-43)
                r0[r16] = r1
                r16 = 200(0xc8, float:2.8E-43)
                r0[r16] = r1
                r16 = 201(0xc9, float:2.82E-43)
                r0[r16] = r1
                r16 = 202(0xca, float:2.83E-43)
                r0[r16] = r1
                r16 = 203(0xcb, float:2.84E-43)
                r0[r16] = r1
                r16 = 204(0xcc, float:2.86E-43)
                r0[r16] = r1
                r16 = 205(0xcd, float:2.87E-43)
                r0[r16] = r1
                r16 = 206(0xce, float:2.89E-43)
                r0[r16] = r1
                r16 = 207(0xcf, float:2.9E-43)
                r0[r16] = r1
                r16 = 208(0xd0, float:2.91E-43)
                r0[r16] = r1
                r16 = 209(0xd1, float:2.93E-43)
                r0[r16] = r1
                r16 = 210(0xd2, float:2.94E-43)
                r0[r16] = r1
                r16 = 211(0xd3, float:2.96E-43)
                r0[r16] = r1
                r16 = 212(0xd4, float:2.97E-43)
                r0[r16] = r1
                r16 = 213(0xd5, float:2.98E-43)
                r0[r16] = r1
                r16 = 214(0xd6, float:3.0E-43)
                r0[r16] = r1
                r16 = 215(0xd7, float:3.01E-43)
                r0[r16] = r1
                r16 = 216(0xd8, float:3.03E-43)
                r0[r16] = r1
                r16 = 217(0xd9, float:3.04E-43)
                r0[r16] = r1
                r16 = 218(0xda, float:3.05E-43)
                r0[r16] = r1
                r16 = 219(0xdb, float:3.07E-43)
                r0[r16] = r1
                r16 = 220(0xdc, float:3.08E-43)
                r0[r16] = r1
                r16 = 221(0xdd, float:3.1E-43)
                r0[r16] = r1
                r16 = 222(0xde, float:3.11E-43)
                r0[r16] = r1
                r16 = 223(0xdf, float:3.12E-43)
                r0[r16] = r1
                r16 = 224(0xe0, float:3.14E-43)
                r0[r16] = r1
                r16 = 225(0xe1, float:3.15E-43)
                r0[r16] = r1
                r16 = 226(0xe2, float:3.17E-43)
                r0[r16] = r1
                r16 = 227(0xe3, float:3.18E-43)
                r0[r16] = r1
                r16 = 228(0xe4, float:3.2E-43)
                r0[r16] = r1
                r16 = 229(0xe5, float:3.21E-43)
                r0[r16] = r1
                r16 = 230(0xe6, float:3.22E-43)
                r0[r16] = r1
                r16 = 231(0xe7, float:3.24E-43)
                r0[r16] = r1
                r16 = 232(0xe8, float:3.25E-43)
                r0[r16] = r1
                r16 = 233(0xe9, float:3.27E-43)
                r0[r16] = r1
                r16 = 234(0xea, float:3.28E-43)
                r0[r16] = r1
                r16 = 235(0xeb, float:3.3E-43)
                r0[r16] = r1
                r16 = 236(0xec, float:3.31E-43)
                r0[r16] = r1
                r16 = 237(0xed, float:3.32E-43)
                r0[r16] = r1
                r16 = 238(0xee, float:3.34E-43)
                r0[r16] = r1
                r16 = 239(0xef, float:3.35E-43)
                r0[r16] = r1
                r16 = 240(0xf0, float:3.36E-43)
                r0[r16] = r1
                r16 = 241(0xf1, float:3.38E-43)
                r0[r16] = r1
                r16 = 242(0xf2, float:3.39E-43)
                r0[r16] = r1
                r16 = 243(0xf3, float:3.4E-43)
                r0[r16] = r1
                r16 = 244(0xf4, float:3.42E-43)
                r0[r16] = r1
                r16 = 245(0xf5, float:3.43E-43)
                r0[r16] = r1
                r16 = 246(0xf6, float:3.45E-43)
                r0[r16] = r1
                r16 = 247(0xf7, float:3.46E-43)
                r0[r16] = r1
                r16 = 248(0xf8, float:3.48E-43)
                r0[r16] = r1
                r16 = 249(0xf9, float:3.49E-43)
                r0[r16] = r1
                r16 = 250(0xfa, float:3.5E-43)
                r0[r16] = r1
                r16 = 251(0xfb, float:3.52E-43)
                r0[r16] = r1
                r16 = 252(0xfc, float:3.53E-43)
                r0[r16] = r1
                r16 = 253(0xfd, float:3.55E-43)
                r0[r16] = r1
                r16 = 254(0xfe, float:3.56E-43)
                r0[r16] = r1
                r16 = 255(0xff, float:3.57E-43)
                r0[r16] = r1
                f16108f = r0
                r0 = 256(0x100, float:3.59E-43)
                int[] r0 = new int[r0]
                r16 = 0
                r0[r16] = r1
                r0[r2] = r1
                r0[r3] = r1
                r0[r4] = r1
                r0[r5] = r1
                r0[r6] = r1
                r0[r7] = r1
                r0[r8] = r1
                r0[r9] = r1
                r0[r10] = r1
                r0[r11] = r1
                r0[r12] = r1
                r0[r13] = r1
                r0[r14] = r1
                r0[r15] = r1
                r16 = 15
                r0[r16] = r1
                r16 = 16
                r0[r16] = r1
                r16 = 17
                r0[r16] = r1
                r16 = 18
                r0[r16] = r1
                r16 = 19
                r0[r16] = r1
                r16 = 20
                r0[r16] = r1
                r16 = 21
                r0[r16] = r1
                r16 = 22
                r0[r16] = r1
                r16 = 23
                r0[r16] = r1
                r16 = 24
                r0[r16] = r1
                r16 = 25
                r0[r16] = r1
                r16 = 26
                r0[r16] = r1
                r16 = 27
                r0[r16] = r1
                r16 = 28
                r0[r16] = r1
                r16 = 29
                r0[r16] = r1
                r16 = 30
                r0[r16] = r1
                r16 = 31
                r0[r16] = r1
                r16 = 32
                r0[r16] = r1
                r16 = 33
                r0[r16] = r1
                r16 = 34
                r0[r16] = r1
                r16 = 35
                r0[r16] = r1
                r16 = 36
                r0[r16] = r1
                r16 = 37
                r0[r16] = r1
                r16 = 38
                r0[r16] = r1
                r16 = 39
                r0[r16] = r1
                r16 = 40
                r0[r16] = r1
                r16 = 41
                r0[r16] = r1
                r16 = 42
                r0[r16] = r1
                r16 = 43
                r0[r16] = r1
                r16 = 44
                r0[r16] = r1
                r16 = 45
                r17 = 62
                r0[r16] = r17
                r16 = 46
                r0[r16] = r1
                r16 = 47
                r0[r16] = r1
                r16 = 48
                r17 = 52
                r0[r16] = r17
                r16 = 49
                r17 = 53
                r0[r16] = r17
                r16 = 50
                r17 = 54
                r0[r16] = r17
                r16 = 51
                r17 = 55
                r0[r16] = r17
                r16 = 52
                r17 = 56
                r0[r16] = r17
                r16 = 53
                r17 = 57
                r0[r16] = r17
                r16 = 54
                r17 = 58
                r0[r16] = r17
                r16 = 55
                r17 = 59
                r0[r16] = r17
                r16 = 56
                r17 = 60
                r0[r16] = r17
                r16 = 57
                r17 = 61
                r0[r16] = r17
                r16 = 58
                r0[r16] = r1
                r16 = 59
                r0[r16] = r1
                r16 = 60
                r0[r16] = r1
                r16 = 61
                r17 = -2
                r0[r16] = r17
                r16 = 62
                r0[r16] = r1
                r16 = 63
                r0[r16] = r1
                r16 = 64
                r0[r16] = r1
                r16 = 66
                r0[r16] = r2
                r2 = 67
                r0[r2] = r3
                r2 = 68
                r0[r2] = r4
                r2 = 69
                r0[r2] = r5
                r2 = 70
                r0[r2] = r6
                r2 = 71
                r0[r2] = r7
                r2 = 72
                r0[r2] = r8
                r2 = 73
                r0[r2] = r9
                r2 = 74
                r0[r2] = r10
                r2 = 75
                r0[r2] = r11
                r2 = 76
                r0[r2] = r12
                r2 = 77
                r0[r2] = r13
                r2 = 78
                r0[r2] = r14
                r2 = 79
                r0[r2] = r15
                r2 = 80
                r3 = 15
                r0[r2] = r3
                r2 = 81
                r3 = 16
                r0[r2] = r3
                r2 = 82
                r3 = 17
                r0[r2] = r3
                r2 = 83
                r3 = 18
                r0[r2] = r3
                r2 = 84
                r3 = 19
                r0[r2] = r3
                r2 = 85
                r3 = 20
                r0[r2] = r3
                r2 = 86
                r3 = 21
                r0[r2] = r3
                r2 = 87
                r3 = 22
                r0[r2] = r3
                r2 = 88
                r3 = 23
                r0[r2] = r3
                r2 = 89
                r3 = 24
                r0[r2] = r3
                r2 = 90
                r3 = 25
                r0[r2] = r3
                r2 = 91
                r0[r2] = r1
                r2 = 92
                r0[r2] = r1
                r2 = 93
                r0[r2] = r1
                r2 = 94
                r0[r2] = r1
                r2 = 95
                r3 = 63
                r0[r2] = r3
                r2 = 96
                r0[r2] = r1
                r2 = 97
                r3 = 26
                r0[r2] = r3
                r2 = 98
                r3 = 27
                r0[r2] = r3
                r2 = 99
                r3 = 28
                r0[r2] = r3
                r2 = 100
                r3 = 29
                r0[r2] = r3
                r2 = 101(0x65, float:1.42E-43)
                r3 = 30
                r0[r2] = r3
                r2 = 102(0x66, float:1.43E-43)
                r3 = 31
                r0[r2] = r3
                r2 = 103(0x67, float:1.44E-43)
                r3 = 32
                r0[r2] = r3
                r2 = 104(0x68, float:1.46E-43)
                r3 = 33
                r0[r2] = r3
                r2 = 105(0x69, float:1.47E-43)
                r3 = 34
                r0[r2] = r3
                r2 = 106(0x6a, float:1.49E-43)
                r3 = 35
                r0[r2] = r3
                r2 = 107(0x6b, float:1.5E-43)
                r3 = 36
                r0[r2] = r3
                r2 = 108(0x6c, float:1.51E-43)
                r3 = 37
                r0[r2] = r3
                r2 = 109(0x6d, float:1.53E-43)
                r3 = 38
                r0[r2] = r3
                r2 = 110(0x6e, float:1.54E-43)
                r3 = 39
                r0[r2] = r3
                r2 = 111(0x6f, float:1.56E-43)
                r3 = 40
                r0[r2] = r3
                r2 = 112(0x70, float:1.57E-43)
                r3 = 41
                r0[r2] = r3
                r2 = 113(0x71, float:1.58E-43)
                r3 = 42
                r0[r2] = r3
                r2 = 114(0x72, float:1.6E-43)
                r3 = 43
                r0[r2] = r3
                r2 = 115(0x73, float:1.61E-43)
                r3 = 44
                r0[r2] = r3
                r2 = 116(0x74, float:1.63E-43)
                r3 = 45
                r0[r2] = r3
                r2 = 117(0x75, float:1.64E-43)
                r3 = 46
                r0[r2] = r3
                r2 = 118(0x76, float:1.65E-43)
                r3 = 47
                r0[r2] = r3
                r2 = 119(0x77, float:1.67E-43)
                r3 = 48
                r0[r2] = r3
                r2 = 120(0x78, float:1.68E-43)
                r3 = 49
                r0[r2] = r3
                r2 = 121(0x79, float:1.7E-43)
                r3 = 50
                r0[r2] = r3
                r2 = 122(0x7a, float:1.71E-43)
                r3 = 51
                r0[r2] = r3
                r2 = 123(0x7b, float:1.72E-43)
                r0[r2] = r1
                r2 = 124(0x7c, float:1.74E-43)
                r0[r2] = r1
                r2 = 125(0x7d, float:1.75E-43)
                r0[r2] = r1
                r2 = 126(0x7e, float:1.77E-43)
                r0[r2] = r1
                r2 = 127(0x7f, float:1.78E-43)
                r0[r2] = r1
                r2 = 128(0x80, float:1.794E-43)
                r0[r2] = r1
                r2 = 129(0x81, float:1.81E-43)
                r0[r2] = r1
                r2 = 130(0x82, float:1.82E-43)
                r0[r2] = r1
                r2 = 131(0x83, float:1.84E-43)
                r0[r2] = r1
                r2 = 132(0x84, float:1.85E-43)
                r0[r2] = r1
                r2 = 133(0x85, float:1.86E-43)
                r0[r2] = r1
                r2 = 134(0x86, float:1.88E-43)
                r0[r2] = r1
                r2 = 135(0x87, float:1.89E-43)
                r0[r2] = r1
                r2 = 136(0x88, float:1.9E-43)
                r0[r2] = r1
                r2 = 137(0x89, float:1.92E-43)
                r0[r2] = r1
                r2 = 138(0x8a, float:1.93E-43)
                r0[r2] = r1
                r2 = 139(0x8b, float:1.95E-43)
                r0[r2] = r1
                r2 = 140(0x8c, float:1.96E-43)
                r0[r2] = r1
                r2 = 141(0x8d, float:1.98E-43)
                r0[r2] = r1
                r2 = 142(0x8e, float:1.99E-43)
                r0[r2] = r1
                r2 = 143(0x8f, float:2.0E-43)
                r0[r2] = r1
                r2 = 144(0x90, float:2.02E-43)
                r0[r2] = r1
                r2 = 145(0x91, float:2.03E-43)
                r0[r2] = r1
                r2 = 146(0x92, float:2.05E-43)
                r0[r2] = r1
                r2 = 147(0x93, float:2.06E-43)
                r0[r2] = r1
                r2 = 148(0x94, float:2.07E-43)
                r0[r2] = r1
                r2 = 149(0x95, float:2.09E-43)
                r0[r2] = r1
                r2 = 150(0x96, float:2.1E-43)
                r0[r2] = r1
                r2 = 151(0x97, float:2.12E-43)
                r0[r2] = r1
                r2 = 152(0x98, float:2.13E-43)
                r0[r2] = r1
                r2 = 153(0x99, float:2.14E-43)
                r0[r2] = r1
                r2 = 154(0x9a, float:2.16E-43)
                r0[r2] = r1
                r2 = 155(0x9b, float:2.17E-43)
                r0[r2] = r1
                r2 = 156(0x9c, float:2.19E-43)
                r0[r2] = r1
                r2 = 157(0x9d, float:2.2E-43)
                r0[r2] = r1
                r2 = 158(0x9e, float:2.21E-43)
                r0[r2] = r1
                r2 = 159(0x9f, float:2.23E-43)
                r0[r2] = r1
                r2 = 160(0xa0, float:2.24E-43)
                r0[r2] = r1
                r2 = 161(0xa1, float:2.26E-43)
                r0[r2] = r1
                r2 = 162(0xa2, float:2.27E-43)
                r0[r2] = r1
                r2 = 163(0xa3, float:2.28E-43)
                r0[r2] = r1
                r2 = 164(0xa4, float:2.3E-43)
                r0[r2] = r1
                r2 = 165(0xa5, float:2.31E-43)
                r0[r2] = r1
                r2 = 166(0xa6, float:2.33E-43)
                r0[r2] = r1
                r2 = 167(0xa7, float:2.34E-43)
                r0[r2] = r1
                r2 = 168(0xa8, float:2.35E-43)
                r0[r2] = r1
                r2 = 169(0xa9, float:2.37E-43)
                r0[r2] = r1
                r2 = 170(0xaa, float:2.38E-43)
                r0[r2] = r1
                r2 = 171(0xab, float:2.4E-43)
                r0[r2] = r1
                r2 = 172(0xac, float:2.41E-43)
                r0[r2] = r1
                r2 = 173(0xad, float:2.42E-43)
                r0[r2] = r1
                r2 = 174(0xae, float:2.44E-43)
                r0[r2] = r1
                r2 = 175(0xaf, float:2.45E-43)
                r0[r2] = r1
                r2 = 176(0xb0, float:2.47E-43)
                r0[r2] = r1
                r2 = 177(0xb1, float:2.48E-43)
                r0[r2] = r1
                r2 = 178(0xb2, float:2.5E-43)
                r0[r2] = r1
                r2 = 179(0xb3, float:2.51E-43)
                r0[r2] = r1
                r2 = 180(0xb4, float:2.52E-43)
                r0[r2] = r1
                r2 = 181(0xb5, float:2.54E-43)
                r0[r2] = r1
                r2 = 182(0xb6, float:2.55E-43)
                r0[r2] = r1
                r2 = 183(0xb7, float:2.56E-43)
                r0[r2] = r1
                r2 = 184(0xb8, float:2.58E-43)
                r0[r2] = r1
                r2 = 185(0xb9, float:2.59E-43)
                r0[r2] = r1
                r2 = 186(0xba, float:2.6E-43)
                r0[r2] = r1
                r2 = 187(0xbb, float:2.62E-43)
                r0[r2] = r1
                r2 = 188(0xbc, float:2.63E-43)
                r0[r2] = r1
                r2 = 189(0xbd, float:2.65E-43)
                r0[r2] = r1
                r2 = 190(0xbe, float:2.66E-43)
                r0[r2] = r1
                r2 = 191(0xbf, float:2.68E-43)
                r0[r2] = r1
                r2 = 192(0xc0, float:2.69E-43)
                r0[r2] = r1
                r2 = 193(0xc1, float:2.7E-43)
                r0[r2] = r1
                r2 = 194(0xc2, float:2.72E-43)
                r0[r2] = r1
                r2 = 195(0xc3, float:2.73E-43)
                r0[r2] = r1
                r2 = 196(0xc4, float:2.75E-43)
                r0[r2] = r1
                r2 = 197(0xc5, float:2.76E-43)
                r0[r2] = r1
                r2 = 198(0xc6, float:2.77E-43)
                r0[r2] = r1
                r2 = 199(0xc7, float:2.79E-43)
                r0[r2] = r1
                r2 = 200(0xc8, float:2.8E-43)
                r0[r2] = r1
                r2 = 201(0xc9, float:2.82E-43)
                r0[r2] = r1
                r2 = 202(0xca, float:2.83E-43)
                r0[r2] = r1
                r2 = 203(0xcb, float:2.84E-43)
                r0[r2] = r1
                r2 = 204(0xcc, float:2.86E-43)
                r0[r2] = r1
                r2 = 205(0xcd, float:2.87E-43)
                r0[r2] = r1
                r2 = 206(0xce, float:2.89E-43)
                r0[r2] = r1
                r2 = 207(0xcf, float:2.9E-43)
                r0[r2] = r1
                r2 = 208(0xd0, float:2.91E-43)
                r0[r2] = r1
                r2 = 209(0xd1, float:2.93E-43)
                r0[r2] = r1
                r2 = 210(0xd2, float:2.94E-43)
                r0[r2] = r1
                r2 = 211(0xd3, float:2.96E-43)
                r0[r2] = r1
                r2 = 212(0xd4, float:2.97E-43)
                r0[r2] = r1
                r2 = 213(0xd5, float:2.98E-43)
                r0[r2] = r1
                r2 = 214(0xd6, float:3.0E-43)
                r0[r2] = r1
                r2 = 215(0xd7, float:3.01E-43)
                r0[r2] = r1
                r2 = 216(0xd8, float:3.03E-43)
                r0[r2] = r1
                r2 = 217(0xd9, float:3.04E-43)
                r0[r2] = r1
                r2 = 218(0xda, float:3.05E-43)
                r0[r2] = r1
                r2 = 219(0xdb, float:3.07E-43)
                r0[r2] = r1
                r2 = 220(0xdc, float:3.08E-43)
                r0[r2] = r1
                r2 = 221(0xdd, float:3.1E-43)
                r0[r2] = r1
                r2 = 222(0xde, float:3.11E-43)
                r0[r2] = r1
                r2 = 223(0xdf, float:3.12E-43)
                r0[r2] = r1
                r2 = 224(0xe0, float:3.14E-43)
                r0[r2] = r1
                r2 = 225(0xe1, float:3.15E-43)
                r0[r2] = r1
                r2 = 226(0xe2, float:3.17E-43)
                r0[r2] = r1
                r2 = 227(0xe3, float:3.18E-43)
                r0[r2] = r1
                r2 = 228(0xe4, float:3.2E-43)
                r0[r2] = r1
                r2 = 229(0xe5, float:3.21E-43)
                r0[r2] = r1
                r2 = 230(0xe6, float:3.22E-43)
                r0[r2] = r1
                r2 = 231(0xe7, float:3.24E-43)
                r0[r2] = r1
                r2 = 232(0xe8, float:3.25E-43)
                r0[r2] = r1
                r2 = 233(0xe9, float:3.27E-43)
                r0[r2] = r1
                r2 = 234(0xea, float:3.28E-43)
                r0[r2] = r1
                r2 = 235(0xeb, float:3.3E-43)
                r0[r2] = r1
                r2 = 236(0xec, float:3.31E-43)
                r0[r2] = r1
                r2 = 237(0xed, float:3.32E-43)
                r0[r2] = r1
                r2 = 238(0xee, float:3.34E-43)
                r0[r2] = r1
                r2 = 239(0xef, float:3.35E-43)
                r0[r2] = r1
                r2 = 240(0xf0, float:3.36E-43)
                r0[r2] = r1
                r2 = 241(0xf1, float:3.38E-43)
                r0[r2] = r1
                r2 = 242(0xf2, float:3.39E-43)
                r0[r2] = r1
                r2 = 243(0xf3, float:3.4E-43)
                r0[r2] = r1
                r2 = 244(0xf4, float:3.42E-43)
                r0[r2] = r1
                r2 = 245(0xf5, float:3.43E-43)
                r0[r2] = r1
                r2 = 246(0xf6, float:3.45E-43)
                r0[r2] = r1
                r2 = 247(0xf7, float:3.46E-43)
                r0[r2] = r1
                r2 = 248(0xf8, float:3.48E-43)
                r0[r2] = r1
                r2 = 249(0xf9, float:3.49E-43)
                r0[r2] = r1
                r2 = 250(0xfa, float:3.5E-43)
                r0[r2] = r1
                r2 = 251(0xfb, float:3.52E-43)
                r0[r2] = r1
                r2 = 252(0xfc, float:3.53E-43)
                r0[r2] = r1
                r2 = 253(0xfd, float:3.55E-43)
                r0[r2] = r1
                r2 = 254(0xfe, float:3.56E-43)
                r0[r2] = r1
                r2 = 255(0xff, float:3.57E-43)
                r0[r2] = r1
                f16109g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.b.C0218b.<clinit>():void");
        }

        public C0218b(byte[] bArr) {
            this.f16106a = bArr;
        }
    }

    public static String a(byte[] bArr, int i2) {
        try {
            int length = bArr.length;
            c cVar = new c(i2);
            int i3 = (length / 3) * 4;
            int i4 = 2;
            if (!cVar.f16117d) {
                int i5 = length % 3;
                if (i5 != 0) {
                    if (i5 == 1) {
                        i3 += 2;
                    } else if (i5 == 2) {
                        i3 += 3;
                    }
                }
            } else if (length % 3 > 0) {
                i3 += 4;
            }
            if (cVar.f16118e && length > 0) {
                int i6 = ((length - 1) / 57) + 1;
                if (!cVar.f16119f) {
                    i4 = 1;
                }
                i3 += i6 * i4;
            }
            cVar.f16106a = new byte[i3];
            cVar.a(bArr, length);
            if (!f16105a) {
                if (cVar.f16107b != i3) {
                    throw new AssertionError();
                }
            }
            return new String(cVar.f16106a, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    static class c extends a {

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ boolean f16113g = (!b.class.desiredAssertionStatus());

        /* renamed from: h  reason: collision with root package name */
        private static final byte[] f16114h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 43, 47};

        /* renamed from: i  reason: collision with root package name */
        private static final byte[] f16115i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 45, 95};

        /* renamed from: c  reason: collision with root package name */
        int f16116c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16117d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f16118e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f16119f;
        private final byte[] j;
        private int k;
        private final byte[] l;

        public c(int i2) {
            this.f16106a = null;
            boolean z = true;
            this.f16117d = (i2 & 1) == 0;
            this.f16118e = (i2 & 2) == 0;
            this.f16119f = (i2 & 4) == 0 ? false : z;
            this.l = (i2 & 8) == 0 ? f16114h : f16115i;
            this.j = new byte[2];
            this.f16116c = 0;
            this.k = this.f16118e ? 19 : -1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0175  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x017b  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x018d  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x008e A[EDGE_INSN: B:90:0x008e->B:22:0x008e ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(byte[] r18, int r19) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.l
                byte[] r2 = r0.f16106a
                int r3 = r0.k
                r4 = 0
                int r5 = r19 + 0
                int r6 = r0.f16116c
                r7 = -1
                r8 = 2
                r9 = 1
                if (r6 == 0) goto L_0x004b
                if (r6 == r9) goto L_0x0031
                if (r6 == r8) goto L_0x0017
                goto L_0x004b
            L_0x0017:
                if (r5 <= 0) goto L_0x004b
                byte[] r6 = r0.j
                byte r10 = r6[r4]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 16
                byte r6 = r6[r9]
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << 8
                r6 = r6 | r10
                byte r10 = r18[r4]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r6 = r6 | r10
                r0.f16116c = r4
                r10 = 1
                goto L_0x004d
            L_0x0031:
                if (r8 > r5) goto L_0x004b
                byte[] r6 = r0.j
                byte r6 = r6[r4]
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << 16
                byte r10 = r18[r4]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r6 = r6 | r10
                byte r10 = r18[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r6 = r6 | r10
                r0.f16116c = r4
                r10 = 2
                goto L_0x004d
            L_0x004b:
                r6 = -1
                r10 = 0
            L_0x004d:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r6 == r7) goto L_0x0089
                int r7 = r6 >> 18
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r4] = r7
                int r7 = r6 >> 12
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r9] = r7
                int r7 = r6 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r8] = r7
                r6 = r6 & 63
                byte r6 = r1[r6]
                r7 = 3
                r2[r7] = r6
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x0087
                boolean r3 = r0.f16119f
                if (r3 == 0) goto L_0x007f
                r3 = 5
                r2[r12] = r13
                goto L_0x0080
            L_0x007f:
                r3 = 4
            L_0x0080:
                int r6 = r3 + 1
                r2[r3] = r14
                r3 = 19
                goto L_0x008a
            L_0x0087:
                r6 = 4
                goto L_0x008a
            L_0x0089:
                r6 = 0
            L_0x008a:
                int r7 = r10 + 3
                if (r7 <= r5) goto L_0x018d
                int r7 = r0.f16116c
                int r15 = r10 - r7
                int r11 = r5 + -1
                if (r15 != r11) goto L_0x00e4
                if (r7 <= 0) goto L_0x009e
                byte[] r7 = r0.j
                byte r4 = r7[r4]
                r7 = 1
                goto L_0x00a5
            L_0x009e:
                int r7 = r10 + 1
                byte r8 = r18[r10]
                r10 = r7
                r4 = r8
                r7 = 0
            L_0x00a5:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r12
                int r8 = r0.f16116c
                int r8 = r8 - r7
                r0.f16116c = r8
                int r7 = r6 + 1
                int r8 = r4 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r7 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r7] = r1
                boolean r1 = r0.f16117d
                if (r1 == 0) goto L_0x00d0
                int r1 = r6 + 1
                r4 = 61
                r2[r6] = r4
                int r4 = r1 + 1
                r6 = 61
                r2[r1] = r6
                r6 = r4
            L_0x00d0:
                boolean r1 = r0.f16118e
                if (r1 == 0) goto L_0x016c
                boolean r1 = r0.f16119f
                if (r1 == 0) goto L_0x00dd
                int r1 = r6 + 1
                r2[r6] = r13
                goto L_0x00de
            L_0x00dd:
                r1 = r6
            L_0x00de:
                int r6 = r1 + 1
                r2[r1] = r14
                goto L_0x016c
            L_0x00e4:
                int r11 = r10 - r7
                int r12 = r5 + -2
                if (r11 != r12) goto L_0x0154
                if (r7 <= r9) goto L_0x00f3
                byte[] r7 = r0.j
                byte r4 = r7[r4]
                r7 = r10
                r10 = 1
                goto L_0x00f9
            L_0x00f3:
                int r7 = r10 + 1
                byte r10 = r18[r10]
                r4 = r10
                r10 = 0
            L_0x00f9:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r14
                int r11 = r0.f16116c
                if (r11 <= 0) goto L_0x010a
                byte[] r11 = r0.j
                int r12 = r10 + 1
                byte r10 = r11[r10]
                r11 = r7
                r7 = r10
                r10 = r12
                goto L_0x010e
            L_0x010a:
                int r11 = r7 + 1
                byte r7 = r18[r7]
            L_0x010e:
                r7 = r7 & 255(0xff, float:3.57E-43)
                int r7 = r7 << r8
                r4 = r4 | r7
                int r7 = r0.f16116c
                int r7 = r7 - r10
                r0.f16116c = r7
                int r7 = r6 + 1
                int r8 = r4 >> 12
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r7 + 1
                int r8 = r4 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r7] = r8
                int r7 = r6 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r6] = r1
                boolean r1 = r0.f16117d
                if (r1 == 0) goto L_0x013f
                int r1 = r7 + 1
                r4 = 61
                r2[r7] = r4
                r6 = r1
                goto L_0x0140
            L_0x013f:
                r6 = r7
            L_0x0140:
                boolean r1 = r0.f16118e
                if (r1 == 0) goto L_0x0152
                boolean r1 = r0.f16119f
                if (r1 == 0) goto L_0x014d
                int r1 = r6 + 1
                r2[r6] = r13
                goto L_0x014e
            L_0x014d:
                r1 = r6
            L_0x014e:
                int r6 = r1 + 1
                r2[r1] = r14
            L_0x0152:
                r10 = r11
                goto L_0x016c
            L_0x0154:
                boolean r1 = r0.f16118e
                if (r1 == 0) goto L_0x016c
                if (r6 <= 0) goto L_0x016c
                r11 = 19
                if (r3 == r11) goto L_0x016c
                boolean r1 = r0.f16119f
                if (r1 == 0) goto L_0x0167
                int r1 = r6 + 1
                r2[r6] = r13
                goto L_0x0168
            L_0x0167:
                r1 = r6
            L_0x0168:
                int r6 = r1 + 1
                r2[r1] = r14
            L_0x016c:
                boolean r1 = f16113g
                if (r1 != 0) goto L_0x017b
                int r1 = r0.f16116c
                if (r1 != 0) goto L_0x0175
                goto L_0x017b
            L_0x0175:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x017b:
                boolean r1 = f16113g
                if (r1 != 0) goto L_0x0188
                if (r10 != r5) goto L_0x0182
                goto L_0x0188
            L_0x0182:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x0188:
                r0.f16107b = r6
                r0.k = r3
                return r9
            L_0x018d:
                r11 = 19
                byte r15 = r18[r10]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r10 + 1
                byte r4 = r18[r16]
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << 8
                r4 = r4 | r15
                int r10 = r10 + 2
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r4 = r4 | r10
                int r10 = r4 >> 18
                r10 = r10 & 63
                byte r10 = r1[r10]
                r2[r6] = r10
                int r10 = r6 + 1
                int r15 = r4 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r10] = r15
                int r10 = r6 + 2
                int r15 = r4 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r10] = r15
                int r10 = r6 + 3
                r4 = r4 & 63
                byte r4 = r1[r4]
                r2[r10] = r4
                int r6 = r6 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x01e1
                boolean r3 = r0.f16119f
                if (r3 == 0) goto L_0x01d8
                int r3 = r6 + 1
                r2[r6] = r13
                goto L_0x01d9
            L_0x01d8:
                r3 = r6
            L_0x01d9:
                int r6 = r3 + 1
                r2[r3] = r14
                r10 = r7
                r3 = 19
                goto L_0x01e2
            L_0x01e1:
                r10 = r7
            L_0x01e2:
                r4 = 0
                goto L_0x008a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.b.c.a(byte[], int):boolean");
        }
    }

    private b() {
    }
}
