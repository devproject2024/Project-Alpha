package com.google.c;

import com.google.c.ac;
import com.google.c.am;
import com.google.c.bz;
import com.google.c.j;
import com.google.c.v;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class aw<T> implements bm<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f37729a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f37730b = bx.c();

    /* renamed from: c  reason: collision with root package name */
    private final int[] f37731c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f37732d;

    /* renamed from: e  reason: collision with root package name */
    private final int f37733e;

    /* renamed from: f  reason: collision with root package name */
    private final int f37734f;

    /* renamed from: g  reason: collision with root package name */
    private final at f37735g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f37736h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f37737i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final ay o;
    private final aj p;
    private final bt<?, ?> q;
    private final s<?> r;
    private final ao s;

    private static int f(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    private static boolean g(int i2) {
        return (i2 & 536870912) != 0;
    }

    private aw(int[] iArr, Object[] objArr, int i2, int i3, at atVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, ay ayVar, aj ajVar, bt<?, ?> btVar, s<?> sVar, ao aoVar) {
        this.f37731c = iArr;
        this.f37732d = objArr;
        this.f37733e = i2;
        this.f37734f = i3;
        this.f37737i = atVar instanceof aa;
        this.j = z;
        this.f37736h = sVar != null && sVar.a(atVar);
        this.k = z2;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = ayVar;
        this.p = ajVar;
        this.q = btVar;
        this.r = sVar;
        this.f37735g = atVar;
        this.s = aoVar;
    }

    static <T> aw<T> a(ar arVar, ay ayVar, aj ajVar, bt<?, ?> btVar, s<?> sVar, ao aoVar) {
        int i2;
        int i3;
        int[] iArr;
        int i4;
        bq bqVar;
        v[] vVarArr;
        int[] iArr2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Class<?> cls;
        int i11;
        char c2;
        char c3;
        char c4;
        int i12;
        char c5;
        int[] iArr3;
        char c6;
        int i13;
        int i14;
        char c7;
        int i15;
        String str;
        bj bjVar;
        char c8;
        int i16;
        int i17;
        int i18;
        int i19;
        char c9;
        char c10;
        Field field;
        int i20;
        char charAt;
        int i21;
        Field field2;
        Field field3;
        int i22;
        char charAt2;
        int i23;
        char charAt3;
        int i24;
        char charAt4;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        char charAt5;
        int i31;
        char charAt6;
        int i32;
        char charAt7;
        int i33;
        char charAt8;
        int i34;
        char charAt9;
        int i35;
        char charAt10;
        int i36;
        char charAt11;
        int i37;
        char charAt12;
        int i38;
        char charAt13;
        char charAt14;
        ar arVar2 = arVar;
        char c11 = 0;
        if (arVar2 instanceof bj) {
            bj bjVar2 = (bj) arVar2;
            boolean z = bjVar2.a() == bf.PROTO3;
            String str2 = bjVar2.f37757b;
            int length = str2.length();
            char charAt15 = str2.charAt(0);
            if (charAt15 >= 55296) {
                char c12 = charAt15 & 8191;
                int i39 = 1;
                int i40 = 13;
                while (true) {
                    i11 = i39 + 1;
                    charAt14 = str2.charAt(i39);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c12 |= (charAt14 & 8191) << i40;
                    i40 += 13;
                    i39 = i11;
                }
                charAt15 = (charAt14 << i40) | c12;
            } else {
                i11 = 1;
            }
            int i41 = i11 + 1;
            char charAt16 = str2.charAt(i11);
            if (charAt16 >= 55296) {
                char c13 = charAt16 & 8191;
                int i42 = 13;
                while (true) {
                    i38 = i41 + 1;
                    charAt13 = str2.charAt(i41);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c13 |= (charAt13 & 8191) << i42;
                    i42 += 13;
                    i41 = i38;
                }
                charAt16 = c13 | (charAt13 << i42);
                i41 = i38;
            }
            if (charAt16 == 0) {
                iArr3 = f37729a;
                c6 = 0;
                c5 = 0;
                i12 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
            } else {
                int i43 = i41 + 1;
                char charAt17 = str2.charAt(i41);
                if (charAt17 >= 55296) {
                    char c14 = charAt17 & 8191;
                    int i44 = 13;
                    while (true) {
                        i37 = i43 + 1;
                        charAt12 = str2.charAt(i43);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c14 |= (charAt12 & 8191) << i44;
                        i44 += 13;
                        i43 = i37;
                    }
                    charAt17 = c14 | (charAt12 << i44);
                    i43 = i37;
                }
                int i45 = i43 + 1;
                char charAt18 = str2.charAt(i43);
                if (charAt18 >= 55296) {
                    char c15 = charAt18 & 8191;
                    int i46 = 13;
                    while (true) {
                        i36 = i45 + 1;
                        charAt11 = str2.charAt(i45);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c15 |= (charAt11 & 8191) << i46;
                        i46 += 13;
                        i45 = i36;
                    }
                    charAt18 = c15 | (charAt11 << i46);
                    i45 = i36;
                }
                int i47 = i45 + 1;
                c3 = str2.charAt(i45);
                if (c3 >= 55296) {
                    int i48 = 13;
                    int i49 = i47;
                    char c16 = c3 & 8191;
                    int i50 = i49;
                    while (true) {
                        i35 = i50 + 1;
                        charAt10 = str2.charAt(i50);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c16 |= (charAt10 & 8191) << i48;
                        i48 += 13;
                        i50 = i35;
                    }
                    c3 = c16 | (charAt10 << i48);
                    i25 = i35;
                } else {
                    i25 = i47;
                }
                int i51 = i25 + 1;
                char charAt19 = str2.charAt(i25);
                if (charAt19 >= 55296) {
                    int i52 = 13;
                    int i53 = i51;
                    char c17 = charAt19 & 8191;
                    int i54 = i53;
                    while (true) {
                        i34 = i54 + 1;
                        charAt9 = str2.charAt(i54);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c17 |= (charAt9 & 8191) << i52;
                        i52 += 13;
                        i54 = i34;
                    }
                    charAt19 = c17 | (charAt9 << i52);
                    i26 = i34;
                } else {
                    i26 = i51;
                }
                int i55 = i26 + 1;
                c11 = str2.charAt(i26);
                if (c11 >= 55296) {
                    int i56 = 13;
                    int i57 = i55;
                    char c18 = c11 & 8191;
                    int i58 = i57;
                    while (true) {
                        i33 = i58 + 1;
                        charAt8 = str2.charAt(i58);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c18 |= (charAt8 & 8191) << i56;
                        i56 += 13;
                        i58 = i33;
                    }
                    c11 = c18 | (charAt8 << i56);
                    i27 = i33;
                } else {
                    i27 = i55;
                }
                int i59 = i27 + 1;
                c6 = str2.charAt(i27);
                if (c6 >= 55296) {
                    int i60 = 13;
                    int i61 = i59;
                    char c19 = c6 & 8191;
                    int i62 = i61;
                    while (true) {
                        i32 = i62 + 1;
                        charAt7 = str2.charAt(i62);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c19 |= (charAt7 & 8191) << i60;
                        i60 += 13;
                        i62 = i32;
                    }
                    c6 = c19 | (charAt7 << i60);
                    i28 = i32;
                } else {
                    i28 = i59;
                }
                int i63 = i28 + 1;
                char charAt20 = str2.charAt(i28);
                if (charAt20 >= 55296) {
                    int i64 = 13;
                    int i65 = i63;
                    char c20 = charAt20 & 8191;
                    int i66 = i65;
                    while (true) {
                        i31 = i66 + 1;
                        charAt6 = str2.charAt(i66);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c20 |= (charAt6 & 8191) << i64;
                        i64 += 13;
                        i66 = i31;
                    }
                    charAt20 = c20 | (charAt6 << i64);
                    i29 = i31;
                } else {
                    i29 = i63;
                }
                int i67 = i29 + 1;
                c5 = str2.charAt(i29);
                if (c5 >= 55296) {
                    int i68 = 13;
                    int i69 = i67;
                    char c21 = c5 & 8191;
                    int i70 = i69;
                    while (true) {
                        i30 = i70 + 1;
                        charAt5 = str2.charAt(i70);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c21 |= (charAt5 & 8191) << i68;
                        i68 += 13;
                        i70 = i30;
                    }
                    c5 = c21 | (charAt5 << i68);
                    i67 = i30;
                }
                iArr3 = new int[(c5 + c6 + charAt20)];
                int i71 = (charAt17 * 2) + charAt18;
                c4 = charAt19;
                i12 = i71;
                int i72 = i67;
                c2 = charAt17;
                i41 = i72;
            }
            Unsafe unsafe = f37730b;
            Object[] objArr = bjVar2.f37758c;
            Class<?> cls2 = bjVar2.f37756a.getClass();
            int i73 = i12;
            int[] iArr4 = new int[(c11 * 3)];
            Object[] objArr2 = new Object[(c11 * 2)];
            int i74 = c6 + c5;
            int i75 = i74;
            char c22 = c5;
            int i76 = i73;
            int i77 = 0;
            int i78 = 0;
            while (i41 < length) {
                int i79 = i41 + 1;
                int charAt21 = str2.charAt(i41);
                int i80 = length;
                char c23 = 55296;
                if (charAt21 >= 55296) {
                    int i81 = 13;
                    int i82 = i79;
                    int i83 = charAt21 & 8191;
                    int i84 = i82;
                    while (true) {
                        i24 = i84 + 1;
                        charAt4 = str2.charAt(i84);
                        if (charAt4 < c23) {
                            break;
                        }
                        i83 |= (charAt4 & 8191) << i81;
                        i81 += 13;
                        i84 = i24;
                        c23 = 55296;
                    }
                    charAt21 = i83 | (charAt4 << i81);
                    i13 = i24;
                } else {
                    i13 = i79;
                }
                int i85 = i13 + 1;
                char charAt22 = str2.charAt(i13);
                int i86 = i74;
                char c24 = 55296;
                if (charAt22 >= 55296) {
                    int i87 = 13;
                    int i88 = i85;
                    char c25 = charAt22 & 8191;
                    int i89 = i88;
                    while (true) {
                        i23 = i89 + 1;
                        charAt3 = str2.charAt(i89);
                        if (charAt3 < c24) {
                            break;
                        }
                        c25 |= (charAt3 & 8191) << i87;
                        i87 += 13;
                        i89 = i23;
                        c24 = 55296;
                    }
                    charAt22 = c25 | (charAt3 << i87);
                    i14 = i23;
                } else {
                    i14 = i85;
                }
                char c26 = c5;
                char c27 = charAt22 & 255;
                boolean z2 = z;
                if ((charAt22 & 1024) != 0) {
                    iArr3[i78] = i77;
                    i78++;
                }
                if (c27 >= '3') {
                    int i90 = i14 + 1;
                    char charAt23 = str2.charAt(i14);
                    int i91 = i90;
                    char c28 = 55296;
                    if (charAt23 >= 55296) {
                        int i92 = 13;
                        int i93 = i91;
                        char c29 = charAt23 & 8191;
                        int i94 = i93;
                        while (true) {
                            i22 = i94 + 1;
                            charAt2 = str2.charAt(i94);
                            if (charAt2 < c28) {
                                break;
                            }
                            c29 |= (charAt2 & 8191) << i92;
                            i92 += 13;
                            i94 = i22;
                            c28 = 55296;
                        }
                        charAt23 = c29 | (charAt2 << i92);
                        i91 = i22;
                    }
                    int i95 = c27 - '3';
                    c7 = c4;
                    if (i95 == 9 || i95 == 17) {
                        objArr2[((i77 / 3) * 2) + 1] = objArr[i76];
                        i76++;
                    } else if (i95 == 12 && (charAt15 & 1) == 1) {
                        objArr2[((i77 / 3) * 2) + 1] = objArr[i76];
                        i76++;
                    }
                    int i96 = charAt23 * 2;
                    Object obj = objArr[i96];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = a(cls2, (String) obj);
                        objArr[i96] = field2;
                    }
                    char c30 = c3;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i97 = i96 + 1;
                    Object obj2 = objArr[i97];
                    int i98 = objectFieldOffset;
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = a(cls2, (String) obj2);
                        objArr[i97] = field3;
                    }
                    i18 = (int) unsafe.objectFieldOffset(field3);
                    str = str2;
                    i17 = i76;
                    i16 = i98;
                    i15 = i91;
                    bjVar = bjVar2;
                    c8 = c30;
                    i19 = 0;
                } else {
                    c7 = c4;
                    char c31 = c3;
                    i17 = i76 + 1;
                    Field a2 = a(cls2, (String) objArr[i76]);
                    c8 = c31;
                    if (c27 == 9 || c27 == 17) {
                        bjVar = bjVar2;
                        c9 = 1;
                        objArr2[((i77 / 3) * 2) + 1] = a2.getType();
                    } else {
                        if (c27 == 27 || c27 == '1') {
                            bjVar = bjVar2;
                            c9 = 1;
                            i21 = i17 + 1;
                            objArr2[((i77 / 3) * 2) + 1] = objArr[i17];
                        } else if (c27 == 12 || c27 == 30 || c27 == ',') {
                            bjVar = bjVar2;
                            c9 = 1;
                            if ((charAt15 & 1) == 1) {
                                i21 = i17 + 1;
                                objArr2[((i77 / 3) * 2) + 1] = objArr[i17];
                            }
                        } else {
                            if (c27 == '2') {
                                int i99 = c22 + 1;
                                iArr3[c22] = i77;
                                int i100 = (i77 / 3) * 2;
                                int i101 = i17 + 1;
                                objArr2[i100] = objArr[i17];
                                if ((charAt22 & 2048) != 0) {
                                    i17 = i101 + 1;
                                    objArr2[i100 + 1] = objArr[i101];
                                    bjVar = bjVar2;
                                    c22 = i99;
                                    c9 = 1;
                                } else {
                                    c22 = i99;
                                    i17 = i101;
                                }
                            }
                            bjVar = bjVar2;
                            c9 = 1;
                        }
                        i17 = i21;
                    }
                    i16 = (int) unsafe.objectFieldOffset(a2);
                    if ((charAt15 & 1) != c9 || c27 > 17) {
                        str = str2;
                        i15 = i14;
                        i19 = 0;
                        c10 = 18;
                        i18 = 0;
                    } else {
                        int i102 = i14 + 1;
                        char charAt24 = str2.charAt(i14);
                        if (charAt24 >= 55296) {
                            char c32 = charAt24 & 8191;
                            int i103 = 13;
                            while (true) {
                                i20 = i102 + 1;
                                charAt = str2.charAt(i102);
                                if (charAt < 55296) {
                                    break;
                                }
                                c32 |= (charAt & 8191) << i103;
                                i103 += 13;
                                i102 = i20;
                            }
                            charAt24 = c32 | (charAt << i103);
                            i102 = i20;
                        }
                        int i104 = (c2 * 2) + (charAt24 / ' ');
                        Object obj3 = objArr[i104];
                        i15 = i102;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = a(cls2, (String) obj3);
                            objArr[i104] = field;
                        }
                        str = str2;
                        i19 = charAt24 % ' ';
                        i18 = (int) unsafe.objectFieldOffset(field);
                        c10 = 18;
                    }
                    if (c27 >= c10 && c27 <= '1') {
                        iArr3[i75] = i16;
                        i75++;
                    }
                }
                int i105 = i77 + 1;
                iArr4[i77] = charAt21;
                int i106 = i105 + 1;
                iArr4[i105] = (c27 << 20) | ((charAt22 & 256) != 0 ? 268435456 : 0) | ((charAt22 & 512) != 0 ? 536870912 : 0) | i16;
                i77 = i106 + 1;
                iArr4[i106] = (i19 << 20) | i18;
                c3 = c8;
                c5 = c26;
                length = i80;
                i74 = i86;
                z = z2;
                bjVar2 = bjVar;
                str2 = str;
                i41 = i15;
                i76 = i17;
                c4 = c7;
            }
            char c33 = c4;
            boolean z3 = z;
            return new aw(iArr4, objArr2, c3, c4, bjVar2.f37756a, z, false, iArr3, c5, i74, ayVar, ajVar, btVar, sVar, aoVar);
        }
        bq bqVar2 = (bq) arVar2;
        boolean z4 = bqVar2.f37798a == bf.PROTO3;
        v[] vVarArr2 = bqVar2.f37800c;
        if (vVarArr2.length == 0) {
            i3 = 0;
            i2 = 0;
        } else {
            int i107 = vVarArr2[0].f37917d;
            i2 = vVarArr2[vVarArr2.length - 1].f37917d;
            i3 = i107;
        }
        int length2 = vVarArr2.length;
        int[] iArr5 = new int[(length2 * 3)];
        Object[] objArr3 = new Object[(length2 * 2)];
        int i108 = 0;
        int i109 = 0;
        for (v vVar : vVarArr2) {
            if (vVar.f37915b == x.MAP) {
                i108++;
            } else if (vVar.f37915b.id() >= 18 && vVar.f37915b.id() <= 49) {
                i109++;
            }
        }
        int[] iArr6 = i108 > 0 ? new int[i108] : null;
        if (i109 > 0) {
            iArr = new int[i109];
        } else {
            iArr = null;
        }
        int[] iArr7 = bqVar2.f37799b;
        if (iArr7 == null) {
            iArr7 = f37729a;
        }
        int i110 = 0;
        int i111 = 0;
        int i112 = 0;
        int i113 = 0;
        int i114 = 0;
        while (i110 < vVarArr2.length) {
            v vVar2 = vVarArr2[i110];
            int i115 = vVar2.f37917d;
            bc bcVar = vVar2.f37922i;
            if (bcVar != null) {
                i6 = vVar2.f37915b.id() + 51;
                vVarArr = vVarArr2;
                bqVar = bqVar2;
                int a3 = (int) bx.a(bcVar.f37749b);
                Field field4 = bcVar.f37748a;
                int i116 = a3;
                i7 = (int) bx.a(field4);
                i4 = i110;
                i8 = 0;
                int i117 = i116;
                iArr2 = iArr6;
                i5 = i117;
            } else {
                bqVar = bqVar2;
                vVarArr = vVarArr2;
                x xVar = vVar2.f37915b;
                iArr2 = iArr6;
                int a4 = (int) bx.a(vVar2.f37914a);
                i6 = xVar.id();
                if (z4 || xVar.isList() || xVar.isMap()) {
                    i5 = a4;
                    if (vVar2.j == null) {
                        i4 = i110;
                        i8 = 0;
                        i7 = 0;
                    } else {
                        i7 = (int) bx.a(vVar2.j);
                        i4 = i110;
                        i8 = 0;
                    }
                } else {
                    i5 = a4;
                    i7 = (int) bx.a(vVar2.f37918e);
                    i8 = Integer.numberOfTrailingZeros(vVar2.f37919f);
                    i4 = i110;
                }
            }
            iArr5[i111] = vVar2.f37917d;
            int i118 = i111 + 1;
            int[] iArr8 = iArr;
            if (vVar2.f37921h) {
                i10 = 536870912;
                i9 = i114;
            } else {
                i9 = i114;
                i10 = 0;
            }
            iArr5[i118] = (i6 << 20) | i10 | (vVar2.f37920g ? 268435456 : 0) | i5;
            iArr5[i111 + 2] = (i8 << 20) | i7;
            int i119 = v.AnonymousClass1.f37923a[vVar2.f37915b.ordinal()];
            if (i119 == 1 || i119 == 2) {
                cls = vVar2.f37914a != null ? vVar2.f37914a.getType() : vVar2.k;
            } else if (i119 == 3 || i119 == 4) {
                cls = vVar2.f37916c;
            } else {
                cls = null;
            }
            if (vVar2.l != null) {
                int i120 = (i111 / 3) * 2;
                objArr3[i120] = vVar2.l;
                if (cls != null) {
                    objArr3[i120 + 1] = cls;
                } else if (vVar2.m != null) {
                    objArr3[i120 + 1] = vVar2.m;
                }
            } else if (cls != null) {
                objArr3[((i111 / 3) * 2) + 1] = cls;
            } else if (vVar2.m != null) {
                objArr3[((i111 / 3) * 2) + 1] = vVar2.m;
            }
            if (i112 < iArr7.length && iArr7[i112] == i115) {
                iArr7[i112] = i111;
                i112++;
            }
            if (vVar2.f37915b == x.MAP) {
                iArr2[i113] = i111;
                i113++;
                i114 = i9;
            } else {
                if (vVar2.f37915b.id() >= 18) {
                    if (vVar2.f37915b.id() <= 49) {
                        i114 = i9 + 1;
                        iArr8[i9] = (int) bx.a(vVar2.f37914a);
                    }
                }
                i114 = i9;
            }
            i110 = i4 + 1;
            i111 += 3;
            iArr6 = iArr2;
            vVarArr2 = vVarArr;
            bqVar2 = bqVar;
            iArr = iArr8;
        }
        bq bqVar3 = bqVar2;
        int[] iArr9 = iArr6;
        int[] iArr10 = iArr;
        if (iArr9 == null) {
            iArr9 = f37729a;
        }
        int[] iArr11 = iArr10 == null ? f37729a : iArr10;
        int[] iArr12 = new int[(iArr7.length + iArr9.length + iArr11.length)];
        System.arraycopy(iArr7, 0, iArr12, 0, iArr7.length);
        System.arraycopy(iArr9, 0, iArr12, iArr7.length, iArr9.length);
        System.arraycopy(iArr11, 0, iArr12, iArr7.length + iArr9.length, iArr11.length);
        return new aw(iArr5, objArr3, i3, i2, bqVar3.f37801d, z4, true, iArr12, iArr7.length, iArr7.length + iArr9.length, ayVar, ajVar, btVar, sVar, aoVar);
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public final T a() {
        return this.o.a(this.f37735g);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (com.google.c.bo.a(com.google.c.bx.f(r10, r6), com.google.c.bx.f(r11, r6)) != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006e, code lost:
        if (com.google.c.bo.a(com.google.c.bx.f(r10, r6), com.google.c.bx.f(r11, r6)) != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.c.bx.b(r10, r6) == com.google.c.bx.b(r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        if (com.google.c.bx.a((java.lang.Object) r10, r6) == com.google.c.bx.a((java.lang.Object) r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.c.bx.b(r10, r6) == com.google.c.bx.b(r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.c.bx.a((java.lang.Object) r10, r6) == com.google.c.bx.a((java.lang.Object) r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.c.bx.a((java.lang.Object) r10, r6) == com.google.c.bx.a((java.lang.Object) r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00de, code lost:
        if (com.google.c.bx.a((java.lang.Object) r10, r6) == com.google.c.bx.a((java.lang.Object) r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f4, code lost:
        if (com.google.c.bo.a(com.google.c.bx.f(r10, r6), com.google.c.bx.f(r11, r6)) != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010a, code lost:
        if (com.google.c.bo.a(com.google.c.bx.f(r10, r6), com.google.c.bx.f(r11, r6)) != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.c.bo.a(com.google.c.bx.f(r10, r6), com.google.c.bx.f(r11, r6)) != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.c.bx.c(r10, r6) == com.google.c.bx.c(r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0144, code lost:
        if (com.google.c.bx.a((java.lang.Object) r10, r6) == com.google.c.bx.a((java.lang.Object) r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0158, code lost:
        if (com.google.c.bx.b(r10, r6) == com.google.c.bx.b(r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.c.bx.a((java.lang.Object) r10, r6) == com.google.c.bx.a((java.lang.Object) r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.c.bx.b(r10, r6) == com.google.c.bx.b(r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018f, code lost:
        if (com.google.c.bx.b(r10, r6) == com.google.c.bx.b(r11, r6)) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a8, code lost:
        if (java.lang.Float.floatToIntBits(com.google.c.bx.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.c.bx.d(r11, r6))) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c3, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.c.bx.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.c.bx.e(r11, r6))) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c5, code lost:
        r3 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.f37731c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01cd
            int r4 = r9.d((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            int r4 = f(r4)
            switch(r4) {
                case 0: goto L_0x01ab;
                case 1: goto L_0x0192;
                case 2: goto L_0x017f;
                case 3: goto L_0x016c;
                case 4: goto L_0x015b;
                case 5: goto L_0x0148;
                case 6: goto L_0x0136;
                case 7: goto L_0x0124;
                case 8: goto L_0x010e;
                case 9: goto L_0x00f8;
                case 10: goto L_0x00e2;
                case 11: goto L_0x00d0;
                case 12: goto L_0x00be;
                case 13: goto L_0x00ac;
                case 14: goto L_0x0098;
                case 15: goto L_0x0086;
                case 16: goto L_0x0072;
                case 17: goto L_0x005c;
                case 18: goto L_0x004e;
                case 19: goto L_0x004e;
                case 20: goto L_0x004e;
                case 21: goto L_0x004e;
                case 22: goto L_0x004e;
                case 23: goto L_0x004e;
                case 24: goto L_0x004e;
                case 25: goto L_0x004e;
                case 26: goto L_0x004e;
                case 27: goto L_0x004e;
                case 28: goto L_0x004e;
                case 29: goto L_0x004e;
                case 30: goto L_0x004e;
                case 31: goto L_0x004e;
                case 32: goto L_0x004e;
                case 33: goto L_0x004e;
                case 34: goto L_0x004e;
                case 35: goto L_0x004e;
                case 36: goto L_0x004e;
                case 37: goto L_0x004e;
                case 38: goto L_0x004e;
                case 39: goto L_0x004e;
                case 40: goto L_0x004e;
                case 41: goto L_0x004e;
                case 42: goto L_0x004e;
                case 43: goto L_0x004e;
                case 44: goto L_0x004e;
                case 45: goto L_0x004e;
                case 46: goto L_0x004e;
                case 47: goto L_0x004e;
                case 48: goto L_0x004e;
                case 49: goto L_0x004e;
                case 50: goto L_0x0040;
                case 51: goto L_0x001b;
                case 52: goto L_0x001b;
                case 53: goto L_0x001b;
                case 54: goto L_0x001b;
                case 55: goto L_0x001b;
                case 56: goto L_0x001b;
                case 57: goto L_0x001b;
                case 58: goto L_0x001b;
                case 59: goto L_0x001b;
                case 60: goto L_0x001b;
                case 61: goto L_0x001b;
                case 62: goto L_0x001b;
                case 63: goto L_0x001b;
                case 64: goto L_0x001b;
                case 65: goto L_0x001b;
                case 66: goto L_0x001b;
                case 67: goto L_0x001b;
                case 68: goto L_0x001b;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x01c6
        L_0x001b:
            int r4 = r9.e((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.c.bx.a((java.lang.Object) r10, (long) r4)
            int r4 = com.google.c.bx.a((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x002d
            r4 = 1
            goto L_0x002e
        L_0x002d:
            r4 = 0
        L_0x002e:
            if (r4 == 0) goto L_0x01c5
            java.lang.Object r4 = com.google.c.bx.f(r10, r6)
            java.lang.Object r5 = com.google.c.bx.f(r11, r6)
            boolean r4 = com.google.c.bo.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c6
            goto L_0x01c5
        L_0x0040:
            java.lang.Object r3 = com.google.c.bx.f(r10, r6)
            java.lang.Object r4 = com.google.c.bx.f(r11, r6)
            boolean r3 = com.google.c.bo.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c6
        L_0x004e:
            java.lang.Object r3 = com.google.c.bx.f(r10, r6)
            java.lang.Object r4 = com.google.c.bx.f(r11, r6)
            boolean r3 = com.google.c.bo.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c6
        L_0x005c:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            java.lang.Object r4 = com.google.c.bx.f(r10, r6)
            java.lang.Object r5 = com.google.c.bx.f(r11, r6)
            boolean r4 = com.google.c.bo.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c6
            goto L_0x01c5
        L_0x0072:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            long r4 = com.google.c.bx.b(r10, r6)
            long r6 = com.google.c.bx.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c6
            goto L_0x01c5
        L_0x0086:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            int r4 = com.google.c.bx.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.c.bx.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x0098:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            long r4 = com.google.c.bx.b(r10, r6)
            long r6 = com.google.c.bx.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c6
            goto L_0x01c5
        L_0x00ac:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            int r4 = com.google.c.bx.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.c.bx.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x00be:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            int r4 = com.google.c.bx.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.c.bx.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x00d0:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            int r4 = com.google.c.bx.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.c.bx.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x00e2:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            java.lang.Object r4 = com.google.c.bx.f(r10, r6)
            java.lang.Object r5 = com.google.c.bx.f(r11, r6)
            boolean r4 = com.google.c.bo.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c6
            goto L_0x01c5
        L_0x00f8:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            java.lang.Object r4 = com.google.c.bx.f(r10, r6)
            java.lang.Object r5 = com.google.c.bx.f(r11, r6)
            boolean r4 = com.google.c.bo.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c6
            goto L_0x01c5
        L_0x010e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            java.lang.Object r4 = com.google.c.bx.f(r10, r6)
            java.lang.Object r5 = com.google.c.bx.f(r11, r6)
            boolean r4 = com.google.c.bo.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c6
            goto L_0x01c5
        L_0x0124:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            boolean r4 = com.google.c.bx.c(r10, r6)
            boolean r5 = com.google.c.bx.c(r11, r6)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x0136:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            int r4 = com.google.c.bx.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.c.bx.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x0148:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            long r4 = com.google.c.bx.b(r10, r6)
            long r6 = com.google.c.bx.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c6
            goto L_0x01c5
        L_0x015b:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            int r4 = com.google.c.bx.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.c.bx.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x016c:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            long r4 = com.google.c.bx.b(r10, r6)
            long r6 = com.google.c.bx.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c6
            goto L_0x01c5
        L_0x017f:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            long r4 = com.google.c.bx.b(r10, r6)
            long r6 = com.google.c.bx.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c6
            goto L_0x01c5
        L_0x0192:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            float r4 = com.google.c.bx.d(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.c.bx.d(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c6
            goto L_0x01c5
        L_0x01ab:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c5
            double r4 = com.google.c.bx.e(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.c.bx.e(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c6
        L_0x01c5:
            r3 = 0
        L_0x01c6:
            if (r3 != 0) goto L_0x01c9
            return r1
        L_0x01c9:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01cd:
            com.google.c.bt<?, ?> r0 = r9.q
            java.lang.Object r0 = r0.b(r10)
            com.google.c.bt<?, ?> r2 = r9.q
            java.lang.Object r2 = r2.b(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01e0
            return r1
        L_0x01e0:
            boolean r0 = r9.f37736h
            if (r0 == 0) goto L_0x01f5
            com.google.c.s<?> r0 = r9.r
            com.google.c.w r10 = r0.a((java.lang.Object) r10)
            com.google.c.s<?> r0 = r9.r
            com.google.c.w r11 = r0.a((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f37731c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.d((int) r1)
            int[] r4 = r8.f37731c
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = f(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = f(r9, r5)
            int r3 = com.google.c.ac.a((boolean) r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = c(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = b(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.c.bx.b(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.c.bx.a((java.lang.Object) r9, (long) r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.c.bx.b(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.c.bx.a((java.lang.Object) r9, (long) r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.c.bx.a((java.lang.Object) r9, (long) r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.c.bx.a((java.lang.Object) r9, (long) r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.c.bx.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.c.bx.c(r9, r5)
            int r3 = com.google.c.ac.a((boolean) r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.c.bx.a((java.lang.Object) r9, (long) r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.c.bx.b(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.c.bx.a((java.lang.Object) r9, (long) r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.c.bx.b(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.c.bx.b(r9, r5)
            int r3 = com.google.c.ac.a((long) r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.c.bx.d(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.c.bx.e(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.c.ac.a((long) r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.c.bt<?, ?> r0 = r8.q
            java.lang.Object r0 = r0.b(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f37736h
            if (r0 == 0) goto L_0x0249
            int r2 = r2 * 53
            com.google.c.s<?> r0 = r8.r
            com.google.c.w r9 = r0.a((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0249:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object):int");
    }

    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i2 = 0; i2 < this.f37731c.length; i2 += 3) {
                int d2 = d(i2);
                long j2 = (long) (1048575 & d2);
                int i3 = this.f37731c[i2];
                switch (f(d2)) {
                    case 0:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.e(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 1:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.d(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 2:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 3:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 4:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 5:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 6:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 7:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.c(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 8:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 9:
                        a(t, t2, i2);
                        break;
                    case 10:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 11:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 12:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 13:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 14:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 15:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 16:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 17:
                        a(t, t2, i2);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.p.a(t, t2, j2);
                        break;
                    case 50:
                        bo.a(this.s, t, t2, j2);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!a(t2, i3, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 60:
                        b(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!a(t2, i3, i2)) {
                            break;
                        } else {
                            bx.a((Object) t, j2, bx.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 68:
                        b(t, t2, i2);
                        break;
                }
            }
            bo.a(this.q, t, t2);
            if (this.f37736h) {
                bo.a(this.r, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private void a(T t, T t2, int i2) {
        long d2 = (long) (d(i2) & 1048575);
        if (a(t2, i2)) {
            Object f2 = bx.f(t, d2);
            Object f3 = bx.f(t2, d2);
            if (f2 != null && f3 != null) {
                bx.a((Object) t, d2, ac.a(f2, f3));
                b(t, i2);
            } else if (f3 != null) {
                bx.a((Object) t, d2, f3);
                b(t, i2);
            }
        }
    }

    private void b(T t, T t2, int i2) {
        int d2 = d(i2);
        int i3 = this.f37731c[i2];
        long j2 = (long) (d2 & 1048575);
        if (a(t2, i3, i2)) {
            Object f2 = bx.f(t, j2);
            Object f3 = bx.f(t2, j2);
            if (f2 != null && f3 != null) {
                bx.a((Object) t, j2, ac.a(f2, f3));
                b(t, i3, i2);
            } else if (f3 != null) {
                bx.a((Object) t, j2, f3);
                b(t, i3, i2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0819, code lost:
        r6 = r6 + ((r4 + r9) + r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r0.j
            r3 = 1048575(0xfffff, float:1.469367E-39)
            if (r2 == 0) goto L_0x04e5
            sun.misc.Unsafe r2 = f37730b
            r5 = 0
            r6 = 0
        L_0x000f:
            int[] r7 = r0.f37731c
            int r7 = r7.length
            if (r5 >= r7) goto L_0x04dd
            int r7 = r0.d((int) r5)
            int r8 = f(r7)
            int[] r9 = r0.f37731c
            r9 = r9[r5]
            r7 = r7 & r3
            long r10 = (long) r7
            com.google.c.x r7 = com.google.c.x.DOUBLE_LIST_PACKED
            int r7 = r7.id()
            if (r8 < r7) goto L_0x003a
            com.google.c.x r7 = com.google.c.x.SINT64_LIST_PACKED
            int r7 = r7.id()
            if (r8 > r7) goto L_0x003a
            int[] r7 = r0.f37731c
            int r12 = r5 + 2
            r7 = r7[r12]
            r7 = r7 & r3
            goto L_0x003b
        L_0x003a:
            r7 = 0
        L_0x003b:
            switch(r8) {
                case 0: goto L_0x04cd;
                case 1: goto L_0x04c1;
                case 2: goto L_0x04b1;
                case 3: goto L_0x04a1;
                case 4: goto L_0x0491;
                case 5: goto L_0x0485;
                case 6: goto L_0x0479;
                case 7: goto L_0x046d;
                case 8: goto L_0x044f;
                case 9: goto L_0x043b;
                case 10: goto L_0x042a;
                case 11: goto L_0x041b;
                case 12: goto L_0x040c;
                case 13: goto L_0x0401;
                case 14: goto L_0x03f6;
                case 15: goto L_0x03e7;
                case 16: goto L_0x03d8;
                case 17: goto L_0x03c3;
                case 18: goto L_0x03b8;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a6;
                case 21: goto L_0x039d;
                case 22: goto L_0x0394;
                case 23: goto L_0x038b;
                case 24: goto L_0x0382;
                case 25: goto L_0x0379;
                case 26: goto L_0x0370;
                case 27: goto L_0x0363;
                case 28: goto L_0x035a;
                case 29: goto L_0x0351;
                case 30: goto L_0x0347;
                case 31: goto L_0x033d;
                case 32: goto L_0x0333;
                case 33: goto L_0x0329;
                case 34: goto L_0x031f;
                case 35: goto L_0x02ff;
                case 36: goto L_0x02e2;
                case 37: goto L_0x02c5;
                case 38: goto L_0x02a8;
                case 39: goto L_0x028a;
                case 40: goto L_0x026c;
                case 41: goto L_0x024e;
                case 42: goto L_0x0230;
                case 43: goto L_0x0212;
                case 44: goto L_0x01f4;
                case 45: goto L_0x01d6;
                case 46: goto L_0x01b8;
                case 47: goto L_0x019a;
                case 48: goto L_0x017c;
                case 49: goto L_0x016e;
                case 50: goto L_0x015e;
                case 51: goto L_0x0152;
                case 52: goto L_0x0146;
                case 53: goto L_0x0136;
                case 54: goto L_0x0126;
                case 55: goto L_0x0116;
                case 56: goto L_0x010a;
                case 57: goto L_0x00fe;
                case 58: goto L_0x00f2;
                case 59: goto L_0x00d4;
                case 60: goto L_0x00c0;
                case 61: goto L_0x00ae;
                case 62: goto L_0x009e;
                case 63: goto L_0x008e;
                case 64: goto L_0x0082;
                case 65: goto L_0x0076;
                case 66: goto L_0x0066;
                case 67: goto L_0x0056;
                case 68: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x04d9
        L_0x0040:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            com.google.c.at r7 = (com.google.c.at) r7
            com.google.c.bm r8 = r0.a((int) r5)
            int r7 = com.google.c.m.c(r9, r7, r8)
            goto L_0x03c0
        L_0x0056:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            long r7 = e(r1, r10)
            int r7 = com.google.c.m.f((int) r9, (long) r7)
            goto L_0x03c0
        L_0x0066:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = d(r1, r10)
            int r7 = com.google.c.m.h(r9, r7)
            goto L_0x03c0
        L_0x0076:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.h(r9)
            goto L_0x03c0
        L_0x0082:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.f((int) r9)
            goto L_0x03c0
        L_0x008e:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = d(r1, r10)
            int r7 = com.google.c.m.i(r9, r7)
            goto L_0x03c0
        L_0x009e:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = d(r1, r10)
            int r7 = com.google.c.m.g(r9, r7)
            goto L_0x03c0
        L_0x00ae:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            com.google.c.j r7 = (com.google.c.j) r7
            int r7 = com.google.c.m.c((int) r9, (com.google.c.j) r7)
            goto L_0x03c0
        L_0x00c0:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            com.google.c.bm r8 = r0.a((int) r5)
            int r7 = com.google.c.bo.a((int) r9, (java.lang.Object) r7, (com.google.c.bm) r8)
            goto L_0x03c0
        L_0x00d4:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            boolean r8 = r7 instanceof com.google.c.j
            if (r8 == 0) goto L_0x00ea
            com.google.c.j r7 = (com.google.c.j) r7
            int r7 = com.google.c.m.c((int) r9, (com.google.c.j) r7)
            goto L_0x03c0
        L_0x00ea:
            java.lang.String r7 = (java.lang.String) r7
            int r7 = com.google.c.m.b((int) r9, (java.lang.String) r7)
            goto L_0x03c0
        L_0x00f2:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.k(r9)
            goto L_0x03c0
        L_0x00fe:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.e((int) r9)
            goto L_0x03c0
        L_0x010a:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.g((int) r9)
            goto L_0x03c0
        L_0x0116:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = d(r1, r10)
            int r7 = com.google.c.m.f((int) r9, (int) r7)
            goto L_0x03c0
        L_0x0126:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            long r7 = e(r1, r10)
            int r7 = com.google.c.m.e((int) r9, (long) r7)
            goto L_0x03c0
        L_0x0136:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            long r7 = e(r1, r10)
            int r7 = com.google.c.m.d((int) r9, (long) r7)
            goto L_0x03c0
        L_0x0146:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.i(r9)
            goto L_0x03c0
        L_0x0152:
            boolean r7 = r0.a(r1, (int) r9, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.j(r9)
            goto L_0x03c0
        L_0x015e:
            com.google.c.ao r7 = r0.s
            java.lang.Object r8 = com.google.c.bx.f(r1, r10)
            java.lang.Object r10 = r0.b((int) r5)
            int r7 = r7.a(r9, r8, r10)
            goto L_0x03c0
        L_0x016e:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            com.google.c.bm r8 = r0.a((int) r5)
            int r7 = com.google.c.bo.b((int) r9, (java.util.List<com.google.c.at>) r7, (com.google.c.bm) r8)
            goto L_0x03c0
        L_0x017c:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.c(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x0190
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x0190:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x019a:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.g(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x01ae
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x01ae:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x01b8:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.i(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x01cc
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x01cc:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x01d6:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.h(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x01ea
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x01ea:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x01f4:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.d(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x0208
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x0208:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x0212:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.f(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x0226
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x0226:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x0230:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.j(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x0244
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x0244:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x024e:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.h(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x0262
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x0262:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x026c:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.i(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x0280
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x0280:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x028a:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.e(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x029e
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x029e:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x02a8:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.b(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x02bc
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x02bc:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x02c5:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.a((java.util.List<java.lang.Long>) r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x02d9
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x02d9:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x02e2:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.h(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x02f6
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x02f6:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
            goto L_0x031b
        L_0x02ff:
            java.lang.Object r8 = r2.getObject(r1, r10)
            java.util.List r8 = (java.util.List) r8
            int r8 = com.google.c.bo.i(r8)
            if (r8 <= 0) goto L_0x04d9
            boolean r10 = r0.k
            if (r10 == 0) goto L_0x0313
            long r10 = (long) r7
            r2.putInt(r1, r10, r8)
        L_0x0313:
            int r7 = com.google.c.m.l(r9)
            int r9 = com.google.c.m.n(r8)
        L_0x031b:
            int r7 = r7 + r9
            int r7 = r7 + r8
            goto L_0x03c0
        L_0x031f:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.c(r9, r7)
            goto L_0x03c0
        L_0x0329:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.g(r9, r7)
            goto L_0x03c0
        L_0x0333:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.i(r9, r7)
            goto L_0x03c0
        L_0x033d:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.h(r9, r7)
            goto L_0x03c0
        L_0x0347:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.d(r9, r7)
            goto L_0x03c0
        L_0x0351:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.f(r9, r7)
            goto L_0x03c0
        L_0x035a:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.l(r9, r7)
            goto L_0x03c0
        L_0x0363:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            com.google.c.bm r8 = r0.a((int) r5)
            int r7 = com.google.c.bo.a((int) r9, (java.util.List<?>) r7, (com.google.c.bm) r8)
            goto L_0x03c0
        L_0x0370:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.k(r9, r7)
            goto L_0x03c0
        L_0x0379:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.j(r9, r7)
            goto L_0x03c0
        L_0x0382:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.h(r9, r7)
            goto L_0x03c0
        L_0x038b:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.i(r9, r7)
            goto L_0x03c0
        L_0x0394:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.e(r9, r7)
            goto L_0x03c0
        L_0x039d:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.b(r9, r7)
            goto L_0x03c0
        L_0x03a6:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.a((int) r9, (java.util.List<java.lang.Long>) r7)
            goto L_0x03c0
        L_0x03af:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.h(r9, r7)
            goto L_0x03c0
        L_0x03b8:
            java.util.List r7 = a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.bo.i(r9, r7)
        L_0x03c0:
            int r6 = r6 + r7
            goto L_0x04d9
        L_0x03c3:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            com.google.c.at r7 = (com.google.c.at) r7
            com.google.c.bm r8 = r0.a((int) r5)
            int r7 = com.google.c.m.c(r9, r7, r8)
            goto L_0x03c0
        L_0x03d8:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            long r7 = com.google.c.bx.b(r1, r10)
            int r7 = com.google.c.m.f((int) r9, (long) r7)
            goto L_0x03c0
        L_0x03e7:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.bx.a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.m.h(r9, r7)
            goto L_0x03c0
        L_0x03f6:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.h(r9)
            goto L_0x03c0
        L_0x0401:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.f((int) r9)
            goto L_0x03c0
        L_0x040c:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.bx.a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.m.i(r9, r7)
            goto L_0x03c0
        L_0x041b:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.bx.a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.m.g(r9, r7)
            goto L_0x03c0
        L_0x042a:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            com.google.c.j r7 = (com.google.c.j) r7
            int r7 = com.google.c.m.c((int) r9, (com.google.c.j) r7)
            goto L_0x03c0
        L_0x043b:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            com.google.c.bm r8 = r0.a((int) r5)
            int r7 = com.google.c.bo.a((int) r9, (java.lang.Object) r7, (com.google.c.bm) r8)
            goto L_0x03c0
        L_0x044f:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            java.lang.Object r7 = com.google.c.bx.f(r1, r10)
            boolean r8 = r7 instanceof com.google.c.j
            if (r8 == 0) goto L_0x0465
            com.google.c.j r7 = (com.google.c.j) r7
            int r7 = com.google.c.m.c((int) r9, (com.google.c.j) r7)
            goto L_0x03c0
        L_0x0465:
            java.lang.String r7 = (java.lang.String) r7
            int r7 = com.google.c.m.b((int) r9, (java.lang.String) r7)
            goto L_0x03c0
        L_0x046d:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.k(r9)
            goto L_0x03c0
        L_0x0479:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.e((int) r9)
            goto L_0x03c0
        L_0x0485:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.g((int) r9)
            goto L_0x03c0
        L_0x0491:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.bx.a((java.lang.Object) r1, (long) r10)
            int r7 = com.google.c.m.f((int) r9, (int) r7)
            goto L_0x03c0
        L_0x04a1:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            long r7 = com.google.c.bx.b(r1, r10)
            int r7 = com.google.c.m.e((int) r9, (long) r7)
            goto L_0x03c0
        L_0x04b1:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            long r7 = com.google.c.bx.b(r1, r10)
            int r7 = com.google.c.m.d((int) r9, (long) r7)
            goto L_0x03c0
        L_0x04c1:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.i(r9)
            goto L_0x03c0
        L_0x04cd:
            boolean r7 = r0.a(r1, (int) r5)
            if (r7 == 0) goto L_0x04d9
            int r7 = com.google.c.m.j(r9)
            goto L_0x03c0
        L_0x04d9:
            int r5 = r5 + 3
            goto L_0x000f
        L_0x04dd:
            com.google.c.bt<?, ?> r2 = r0.q
            int r1 = a(r2, r1)
            int r6 = r6 + r1
            return r6
        L_0x04e5:
            sun.misc.Unsafe r2 = f37730b
            r5 = -1
            r5 = 0
            r6 = 0
            r7 = -1
            r8 = 0
        L_0x04ec:
            int[] r9 = r0.f37731c
            int r9 = r9.length
            if (r5 >= r9) goto L_0x09de
            int r9 = r0.d((int) r5)
            int[] r10 = r0.f37731c
            r10 = r10[r5]
            int r11 = f(r9)
            r12 = 17
            if (r11 > r12) goto L_0x0517
            int[] r12 = r0.f37731c
            int r13 = r5 + 2
            r12 = r12[r13]
            r13 = r12 & r3
            int r14 = r12 >>> 20
            r15 = 1
            int r14 = r15 << r14
            if (r13 == r7) goto L_0x0535
            long r7 = (long) r13
            int r8 = r2.getInt(r1, r7)
            r7 = r13
            goto L_0x0535
        L_0x0517:
            boolean r12 = r0.k
            if (r12 == 0) goto L_0x0533
            com.google.c.x r12 = com.google.c.x.DOUBLE_LIST_PACKED
            int r12 = r12.id()
            if (r11 < r12) goto L_0x0533
            com.google.c.x r12 = com.google.c.x.SINT64_LIST_PACKED
            int r12 = r12.id()
            if (r11 > r12) goto L_0x0533
            int[] r12 = r0.f37731c
            int r13 = r5 + 2
            r12 = r12[r13]
            r12 = r12 & r3
            goto L_0x0534
        L_0x0533:
            r12 = 0
        L_0x0534:
            r14 = 0
        L_0x0535:
            r9 = r9 & r3
            long r3 = (long) r9
            switch(r11) {
                case 0: goto L_0x09cd;
                case 1: goto L_0x09c3;
                case 2: goto L_0x09b5;
                case 3: goto L_0x09a7;
                case 4: goto L_0x0999;
                case 5: goto L_0x098f;
                case 6: goto L_0x0985;
                case 7: goto L_0x097b;
                case 8: goto L_0x095f;
                case 9: goto L_0x094e;
                case 10: goto L_0x093f;
                case 11: goto L_0x0932;
                case 12: goto L_0x0925;
                case 13: goto L_0x091c;
                case 14: goto L_0x0913;
                case 15: goto L_0x0906;
                case 16: goto L_0x08f9;
                case 17: goto L_0x08e6;
                case 18: goto L_0x08d9;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08c3;
                case 21: goto L_0x08b8;
                case 22: goto L_0x08ad;
                case 23: goto L_0x08a2;
                case 24: goto L_0x0897;
                case 25: goto L_0x088c;
                case 26: goto L_0x0881;
                case 27: goto L_0x0872;
                case 28: goto L_0x0866;
                case 29: goto L_0x085a;
                case 30: goto L_0x084e;
                case 31: goto L_0x0842;
                case 32: goto L_0x0836;
                case 33: goto L_0x082a;
                case 34: goto L_0x081e;
                case 35: goto L_0x07fd;
                case 36: goto L_0x07e0;
                case 37: goto L_0x07c3;
                case 38: goto L_0x07a6;
                case 39: goto L_0x0788;
                case 40: goto L_0x076a;
                case 41: goto L_0x074c;
                case 42: goto L_0x072e;
                case 43: goto L_0x0710;
                case 44: goto L_0x06f2;
                case 45: goto L_0x06d4;
                case 46: goto L_0x06b6;
                case 47: goto L_0x0698;
                case 48: goto L_0x067a;
                case 49: goto L_0x066a;
                case 50: goto L_0x065a;
                case 51: goto L_0x064e;
                case 52: goto L_0x0642;
                case 53: goto L_0x0632;
                case 54: goto L_0x0622;
                case 55: goto L_0x0612;
                case 56: goto L_0x0606;
                case 57: goto L_0x05fa;
                case 58: goto L_0x05ee;
                case 59: goto L_0x05d0;
                case 60: goto L_0x05bc;
                case 61: goto L_0x05aa;
                case 62: goto L_0x059a;
                case 63: goto L_0x058a;
                case 64: goto L_0x057e;
                case 65: goto L_0x0572;
                case 66: goto L_0x0562;
                case 67: goto L_0x0552;
                case 68: goto L_0x053c;
                default: goto L_0x053a;
            }
        L_0x053a:
            goto L_0x09d7
        L_0x053c:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.c.at r3 = (com.google.c.at) r3
            com.google.c.bm r4 = r0.a((int) r5)
            int r3 = com.google.c.m.c(r10, r3, r4)
            goto L_0x08e3
        L_0x0552:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            long r3 = e(r1, r3)
            int r3 = com.google.c.m.f((int) r10, (long) r3)
            goto L_0x08e3
        L_0x0562:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            int r3 = d(r1, r3)
            int r3 = com.google.c.m.h(r10, r3)
            goto L_0x08e3
        L_0x0572:
            boolean r3 = r0.a(r1, (int) r10, (int) r5)
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.h(r10)
            goto L_0x08e3
        L_0x057e:
            boolean r3 = r0.a(r1, (int) r10, (int) r5)
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.f((int) r10)
            goto L_0x08e3
        L_0x058a:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            int r3 = d(r1, r3)
            int r3 = com.google.c.m.i(r10, r3)
            goto L_0x08e3
        L_0x059a:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            int r3 = d(r1, r3)
            int r3 = com.google.c.m.g(r10, r3)
            goto L_0x08e3
        L_0x05aa:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.c.j r3 = (com.google.c.j) r3
            int r3 = com.google.c.m.c((int) r10, (com.google.c.j) r3)
            goto L_0x08e3
        L_0x05bc:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.c.bm r4 = r0.a((int) r5)
            int r3 = com.google.c.bo.a((int) r10, (java.lang.Object) r3, (com.google.c.bm) r4)
            goto L_0x08e3
        L_0x05d0:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.c.j
            if (r4 == 0) goto L_0x05e6
            com.google.c.j r3 = (com.google.c.j) r3
            int r3 = com.google.c.m.c((int) r10, (com.google.c.j) r3)
            goto L_0x08e3
        L_0x05e6:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.c.m.b((int) r10, (java.lang.String) r3)
            goto L_0x08e3
        L_0x05ee:
            boolean r3 = r0.a(r1, (int) r10, (int) r5)
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.k(r10)
            goto L_0x08e3
        L_0x05fa:
            boolean r3 = r0.a(r1, (int) r10, (int) r5)
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.e((int) r10)
            goto L_0x08e3
        L_0x0606:
            boolean r3 = r0.a(r1, (int) r10, (int) r5)
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.g((int) r10)
            goto L_0x08e3
        L_0x0612:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            int r3 = d(r1, r3)
            int r3 = com.google.c.m.f((int) r10, (int) r3)
            goto L_0x08e3
        L_0x0622:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            long r3 = e(r1, r3)
            int r3 = com.google.c.m.e((int) r10, (long) r3)
            goto L_0x08e3
        L_0x0632:
            boolean r9 = r0.a(r1, (int) r10, (int) r5)
            if (r9 == 0) goto L_0x09d7
            long r3 = e(r1, r3)
            int r3 = com.google.c.m.d((int) r10, (long) r3)
            goto L_0x08e3
        L_0x0642:
            boolean r3 = r0.a(r1, (int) r10, (int) r5)
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.i(r10)
            goto L_0x08e3
        L_0x064e:
            boolean r3 = r0.a(r1, (int) r10, (int) r5)
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.j(r10)
            goto L_0x08e3
        L_0x065a:
            com.google.c.ao r9 = r0.s
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.b((int) r5)
            int r3 = r9.a(r10, r3, r4)
            goto L_0x08e3
        L_0x066a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.c.bm r4 = r0.a((int) r5)
            int r3 = com.google.c.bo.b((int) r10, (java.util.List<com.google.c.at>) r3, (com.google.c.bm) r4)
            goto L_0x08e3
        L_0x067a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.c(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x068e
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x068e:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x0698:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.g(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06ac
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x06ac:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x06b6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.i(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06ca
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x06ca:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x06d4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.h(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06e8
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x06e8:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x06f2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.d(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0706
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0706:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x0710:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.f(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0724
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0724:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x072e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.j(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0742
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0742:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x074c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.h(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0760
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0760:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x076a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.i(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x077e
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x077e:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x0788:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.e(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x079c
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x079c:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x07a6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.b(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07ba
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x07ba:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x07c3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.a((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07d7
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x07d7:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x07e0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.h(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07f4
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x07f4:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
            goto L_0x0819
        L_0x07fd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.i(r3)
            if (r3 <= 0) goto L_0x09d7
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0811
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0811:
            int r4 = com.google.c.m.l(r10)
            int r9 = com.google.c.m.n(r3)
        L_0x0819:
            int r4 = r4 + r9
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x09d7
        L_0x081e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.c(r10, r3)
            goto L_0x08e3
        L_0x082a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.g(r10, r3)
            goto L_0x08e3
        L_0x0836:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.i(r10, r3)
            goto L_0x08e3
        L_0x0842:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.h(r10, r3)
            goto L_0x08e3
        L_0x084e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.d(r10, r3)
            goto L_0x08e3
        L_0x085a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.f(r10, r3)
            goto L_0x08e3
        L_0x0866:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.l(r10, r3)
            goto L_0x08e3
        L_0x0872:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.c.bm r4 = r0.a((int) r5)
            int r3 = com.google.c.bo.a((int) r10, (java.util.List<?>) r3, (com.google.c.bm) r4)
            goto L_0x08e3
        L_0x0881:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.k(r10, r3)
            goto L_0x08e3
        L_0x088c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.j(r10, r3)
            goto L_0x08e3
        L_0x0897:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.h(r10, r3)
            goto L_0x08e3
        L_0x08a2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.i(r10, r3)
            goto L_0x08e3
        L_0x08ad:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.e(r10, r3)
            goto L_0x08e3
        L_0x08b8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.b(r10, r3)
            goto L_0x08e3
        L_0x08c3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.a((int) r10, (java.util.List<java.lang.Long>) r3)
            goto L_0x08e3
        L_0x08ce:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.h(r10, r3)
            goto L_0x08e3
        L_0x08d9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.c.bo.i(r10, r3)
        L_0x08e3:
            int r6 = r6 + r3
            goto L_0x09d7
        L_0x08e6:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.c.at r3 = (com.google.c.at) r3
            com.google.c.bm r4 = r0.a((int) r5)
            int r3 = com.google.c.m.c(r10, r3, r4)
            goto L_0x08e3
        L_0x08f9:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.c.m.f((int) r10, (long) r3)
            goto L_0x08e3
        L_0x0906:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.c.m.h(r10, r3)
            goto L_0x08e3
        L_0x0913:
            r3 = r8 & r14
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.h(r10)
            goto L_0x08e3
        L_0x091c:
            r3 = r8 & r14
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.f((int) r10)
            goto L_0x08e3
        L_0x0925:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.c.m.i(r10, r3)
            goto L_0x08e3
        L_0x0932:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.c.m.g(r10, r3)
            goto L_0x08e3
        L_0x093f:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.c.j r3 = (com.google.c.j) r3
            int r3 = com.google.c.m.c((int) r10, (com.google.c.j) r3)
            goto L_0x08e3
        L_0x094e:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.c.bm r4 = r0.a((int) r5)
            int r3 = com.google.c.bo.a((int) r10, (java.lang.Object) r3, (com.google.c.bm) r4)
            goto L_0x08e3
        L_0x095f:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.c.j
            if (r4 == 0) goto L_0x0973
            com.google.c.j r3 = (com.google.c.j) r3
            int r3 = com.google.c.m.c((int) r10, (com.google.c.j) r3)
            goto L_0x08e3
        L_0x0973:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.c.m.b((int) r10, (java.lang.String) r3)
            goto L_0x08e3
        L_0x097b:
            r3 = r8 & r14
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.k(r10)
            goto L_0x08e3
        L_0x0985:
            r3 = r8 & r14
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.e((int) r10)
            goto L_0x08e3
        L_0x098f:
            r3 = r8 & r14
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.g((int) r10)
            goto L_0x08e3
        L_0x0999:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.c.m.f((int) r10, (int) r3)
            goto L_0x08e3
        L_0x09a7:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.c.m.e((int) r10, (long) r3)
            goto L_0x08e3
        L_0x09b5:
            r9 = r8 & r14
            if (r9 == 0) goto L_0x09d7
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.c.m.d((int) r10, (long) r3)
            goto L_0x08e3
        L_0x09c3:
            r3 = r8 & r14
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.i(r10)
            goto L_0x08e3
        L_0x09cd:
            r3 = r8 & r14
            if (r3 == 0) goto L_0x09d7
            int r3 = com.google.c.m.j(r10)
            goto L_0x08e3
        L_0x09d7:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x04ec
        L_0x09de:
            com.google.c.bt<?, ?> r2 = r0.q
            int r2 = a(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.f37736h
            if (r2 == 0) goto L_0x0a38
            com.google.c.s<?> r2 = r0.r
            com.google.c.w r1 = r2.a((java.lang.Object) r1)
            r2 = 0
            r15 = 0
        L_0x09f1:
            com.google.c.bp<T, java.lang.Object> r3 = r1.f37925a
            int r3 = r3.b()
            if (r15 >= r3) goto L_0x0a11
            com.google.c.bp<T, java.lang.Object> r3 = r1.f37925a
            java.util.Map$Entry r3 = r3.b((int) r15)
            java.lang.Object r4 = r3.getKey()
            com.google.c.w$a r4 = (com.google.c.w.a) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.c.w.c((com.google.c.w.a<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r15 = r15 + 1
            goto L_0x09f1
        L_0x0a11:
            com.google.c.bp<T, java.lang.Object> r1 = r1.f37925a
            java.lang.Iterable r1 = r1.c()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a1b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a37
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.c.w$a r4 = (com.google.c.w.a) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.c.w.c((com.google.c.w.a<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a1b
        L_0x0a37:
            int r6 = r6 + r2
        L_0x0a38:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.b(java.lang.Object):int");
    }

    private static <UT, UB> int a(bt<UT, UB> btVar, T t) {
        return btVar.f(btVar.b(t));
    }

    private static List<?> a(Object obj, long j2) {
        return (List) bx.f(obj, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x056c  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a44  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r13, com.google.c.ca r14) throws java.io.IOException {
        /*
            r12 = this;
            com.google.c.ca$a r0 = r14.a()
            com.google.c.ca$a r1 = com.google.c.ca.a.DESCENDING
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0542
            com.google.c.bt<?, ?> r0 = r12.q
            a(r0, r13, (com.google.c.ca) r14)
            boolean r0 = r12.f37736h
            if (r0 == 0) goto L_0x004b
            com.google.c.s<?> r0 = r12.r
            com.google.c.w r0 = r0.a((java.lang.Object) r13)
            com.google.c.bp<T, java.lang.Object> r1 = r0.f37925a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x004b
            boolean r1 = r0.f37927c
            if (r1 == 0) goto L_0x003a
            com.google.c.af$b r1 = new com.google.c.af$b
            com.google.c.bp<T, java.lang.Object> r0 = r0.f37925a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            r1.<init>(r0)
            r0 = r1
            goto L_0x0044
        L_0x003a:
            com.google.c.bp<T, java.lang.Object> r0 = r0.f37925a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
        L_0x0044:
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x004d
        L_0x004b:
            r0 = r2
            r1 = r0
        L_0x004d:
            int[] r6 = r12.f37731c
            int r6 = r6.length
            int r6 = r6 + -3
        L_0x0052:
            if (r6 < 0) goto L_0x052a
            int r7 = r12.d((int) r6)
            int[] r8 = r12.f37731c
            r8 = r8[r6]
        L_0x005c:
            if (r1 == 0) goto L_0x007a
            com.google.c.s<?> r9 = r12.r
            int r9 = r9.a((java.util.Map.Entry<?, ?>) r1)
            if (r9 <= r8) goto L_0x007a
            com.google.c.s<?> r9 = r12.r
            r9.a(r14, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0078
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x005c
        L_0x0078:
            r1 = r2
            goto L_0x005c
        L_0x007a:
            int r9 = f(r7)
            switch(r9) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0507;
                case 2: goto L_0x04f7;
                case 3: goto L_0x04e7;
                case 4: goto L_0x04d7;
                case 5: goto L_0x04c7;
                case 6: goto L_0x04b7;
                case 7: goto L_0x04a6;
                case 8: goto L_0x0495;
                case 9: goto L_0x0480;
                case 10: goto L_0x046d;
                case 11: goto L_0x045c;
                case 12: goto L_0x044b;
                case 13: goto L_0x043a;
                case 14: goto L_0x0429;
                case 15: goto L_0x0418;
                case 16: goto L_0x0407;
                case 17: goto L_0x03f2;
                case 18: goto L_0x03e1;
                case 19: goto L_0x03d0;
                case 20: goto L_0x03bf;
                case 21: goto L_0x03ae;
                case 22: goto L_0x039d;
                case 23: goto L_0x038c;
                case 24: goto L_0x037b;
                case 25: goto L_0x036a;
                case 26: goto L_0x0359;
                case 27: goto L_0x0344;
                case 28: goto L_0x0333;
                case 29: goto L_0x0322;
                case 30: goto L_0x0311;
                case 31: goto L_0x0300;
                case 32: goto L_0x02ef;
                case 33: goto L_0x02de;
                case 34: goto L_0x02cd;
                case 35: goto L_0x02bc;
                case 36: goto L_0x02ab;
                case 37: goto L_0x029a;
                case 38: goto L_0x0289;
                case 39: goto L_0x0278;
                case 40: goto L_0x0267;
                case 41: goto L_0x0256;
                case 42: goto L_0x0245;
                case 43: goto L_0x0234;
                case 44: goto L_0x0223;
                case 45: goto L_0x0212;
                case 46: goto L_0x0201;
                case 47: goto L_0x01f0;
                case 48: goto L_0x01df;
                case 49: goto L_0x01ca;
                case 50: goto L_0x01bf;
                case 51: goto L_0x01ae;
                case 52: goto L_0x019d;
                case 53: goto L_0x018c;
                case 54: goto L_0x017b;
                case 55: goto L_0x016a;
                case 56: goto L_0x0159;
                case 57: goto L_0x0148;
                case 58: goto L_0x0137;
                case 59: goto L_0x0126;
                case 60: goto L_0x0111;
                case 61: goto L_0x00fe;
                case 62: goto L_0x00ed;
                case 63: goto L_0x00dc;
                case 64: goto L_0x00cb;
                case 65: goto L_0x00ba;
                case 66: goto L_0x00a9;
                case 67: goto L_0x0098;
                case 68: goto L_0x0083;
                default: goto L_0x0081;
            }
        L_0x0081:
            goto L_0x0526
        L_0x0083:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            com.google.c.bm r9 = r12.a((int) r6)
            r14.b((int) r8, (java.lang.Object) r7, (com.google.c.bm) r9)
            goto L_0x0526
        L_0x0098:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = e(r13, r9)
            r14.e((int) r8, (long) r9)
            goto L_0x0526
        L_0x00a9:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = d(r13, r9)
            r14.f(r8, r7)
            goto L_0x0526
        L_0x00ba:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = e(r13, r9)
            r14.b((int) r8, (long) r9)
            goto L_0x0526
        L_0x00cb:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = d(r13, r9)
            r14.a((int) r8, (int) r7)
            goto L_0x0526
        L_0x00dc:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = d(r13, r9)
            r14.b((int) r8, (int) r7)
            goto L_0x0526
        L_0x00ed:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = d(r13, r9)
            r14.e((int) r8, (int) r7)
            goto L_0x0526
        L_0x00fe:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            com.google.c.j r7 = (com.google.c.j) r7
            r14.a((int) r8, (com.google.c.j) r7)
            goto L_0x0526
        L_0x0111:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            com.google.c.bm r9 = r12.a((int) r6)
            r14.a((int) r8, (java.lang.Object) r7, (com.google.c.bm) r9)
            goto L_0x0526
        L_0x0126:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            a((int) r8, (java.lang.Object) r7, (com.google.c.ca) r14)
            goto L_0x0526
        L_0x0137:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            boolean r7 = f(r13, r9)
            r14.a((int) r8, (boolean) r7)
            goto L_0x0526
        L_0x0148:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = d(r13, r9)
            r14.d((int) r8, (int) r7)
            goto L_0x0526
        L_0x0159:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = e(r13, r9)
            r14.d((int) r8, (long) r9)
            goto L_0x0526
        L_0x016a:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = d(r13, r9)
            r14.c((int) r8, (int) r7)
            goto L_0x0526
        L_0x017b:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = e(r13, r9)
            r14.c((int) r8, (long) r9)
            goto L_0x0526
        L_0x018c:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = e(r13, r9)
            r14.a((int) r8, (long) r9)
            goto L_0x0526
        L_0x019d:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            float r7 = c(r13, r9)
            r14.a((int) r8, (float) r7)
            goto L_0x0526
        L_0x01ae:
            boolean r9 = r12.a(r13, (int) r8, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            double r9 = b(r13, (long) r9)
            r14.a((int) r8, (double) r9)
            goto L_0x0526
        L_0x01bf:
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            r12.a((com.google.c.ca) r14, (int) r8, (java.lang.Object) r7, (int) r6)
            goto L_0x0526
        L_0x01ca:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bm r9 = r12.a((int) r6)
            com.google.c.bo.b((int) r8, (java.util.List<?>) r7, (com.google.c.ca) r14, (com.google.c.bm) r9)
            goto L_0x0526
        L_0x01df:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.e(r8, r7, r14, r3)
            goto L_0x0526
        L_0x01f0:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.j(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0201:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.g(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0212:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.l(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0223:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.m(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0234:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.i(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0245:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.n(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0256:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.k(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0267:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.f(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0278:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.h(r8, r7, r14, r3)
            goto L_0x0526
        L_0x0289:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.d(r8, r7, r14, r3)
            goto L_0x0526
        L_0x029a:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.c(r8, r7, r14, r3)
            goto L_0x0526
        L_0x02ab:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.b((int) r8, (java.util.List<java.lang.Float>) r7, (com.google.c.ca) r14, (boolean) r3)
            goto L_0x0526
        L_0x02bc:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.a((int) r8, (java.util.List<java.lang.Double>) r7, (com.google.c.ca) r14, (boolean) r3)
            goto L_0x0526
        L_0x02cd:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.e(r8, r7, r14, r4)
            goto L_0x0526
        L_0x02de:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.j(r8, r7, r14, r4)
            goto L_0x0526
        L_0x02ef:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.g(r8, r7, r14, r4)
            goto L_0x0526
        L_0x0300:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.l(r8, r7, r14, r4)
            goto L_0x0526
        L_0x0311:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.m(r8, r7, r14, r4)
            goto L_0x0526
        L_0x0322:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.i(r8, r7, r14, r4)
            goto L_0x0526
        L_0x0333:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.b((int) r8, (java.util.List<com.google.c.j>) r7, (com.google.c.ca) r14)
            goto L_0x0526
        L_0x0344:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bm r9 = r12.a((int) r6)
            com.google.c.bo.a((int) r8, (java.util.List<?>) r7, (com.google.c.ca) r14, (com.google.c.bm) r9)
            goto L_0x0526
        L_0x0359:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.a((int) r8, (java.util.List<java.lang.String>) r7, (com.google.c.ca) r14)
            goto L_0x0526
        L_0x036a:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.n(r8, r7, r14, r4)
            goto L_0x0526
        L_0x037b:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.k(r8, r7, r14, r4)
            goto L_0x0526
        L_0x038c:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.f(r8, r7, r14, r4)
            goto L_0x0526
        L_0x039d:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.h(r8, r7, r14, r4)
            goto L_0x0526
        L_0x03ae:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.d(r8, r7, r14, r4)
            goto L_0x0526
        L_0x03bf:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.c(r8, r7, r14, r4)
            goto L_0x0526
        L_0x03d0:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.b((int) r8, (java.util.List<java.lang.Float>) r7, (com.google.c.ca) r14, (boolean) r4)
            goto L_0x0526
        L_0x03e1:
            int[] r8 = r12.f37731c
            r8 = r8[r6]
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.c.bo.a((int) r8, (java.util.List<java.lang.Double>) r7, (com.google.c.ca) r14, (boolean) r4)
            goto L_0x0526
        L_0x03f2:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            com.google.c.bm r9 = r12.a((int) r6)
            r14.b((int) r8, (java.lang.Object) r7, (com.google.c.bm) r9)
            goto L_0x0526
        L_0x0407:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = com.google.c.bx.b(r13, r9)
            r14.e((int) r8, (long) r9)
            goto L_0x0526
        L_0x0418:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = com.google.c.bx.a((java.lang.Object) r13, (long) r9)
            r14.f(r8, r7)
            goto L_0x0526
        L_0x0429:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = com.google.c.bx.b(r13, r9)
            r14.b((int) r8, (long) r9)
            goto L_0x0526
        L_0x043a:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = com.google.c.bx.a((java.lang.Object) r13, (long) r9)
            r14.a((int) r8, (int) r7)
            goto L_0x0526
        L_0x044b:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = com.google.c.bx.a((java.lang.Object) r13, (long) r9)
            r14.b((int) r8, (int) r7)
            goto L_0x0526
        L_0x045c:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = com.google.c.bx.a((java.lang.Object) r13, (long) r9)
            r14.e((int) r8, (int) r7)
            goto L_0x0526
        L_0x046d:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            com.google.c.j r7 = (com.google.c.j) r7
            r14.a((int) r8, (com.google.c.j) r7)
            goto L_0x0526
        L_0x0480:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            com.google.c.bm r9 = r12.a((int) r6)
            r14.a((int) r8, (java.lang.Object) r7, (com.google.c.bm) r9)
            goto L_0x0526
        L_0x0495:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            java.lang.Object r7 = com.google.c.bx.f(r13, r9)
            a((int) r8, (java.lang.Object) r7, (com.google.c.ca) r14)
            goto L_0x0526
        L_0x04a6:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            boolean r7 = com.google.c.bx.c(r13, r9)
            r14.a((int) r8, (boolean) r7)
            goto L_0x0526
        L_0x04b7:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = com.google.c.bx.a((java.lang.Object) r13, (long) r9)
            r14.d((int) r8, (int) r7)
            goto L_0x0526
        L_0x04c7:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = com.google.c.bx.b(r13, r9)
            r14.d((int) r8, (long) r9)
            goto L_0x0526
        L_0x04d7:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            int r7 = com.google.c.bx.a((java.lang.Object) r13, (long) r9)
            r14.c((int) r8, (int) r7)
            goto L_0x0526
        L_0x04e7:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = com.google.c.bx.b(r13, r9)
            r14.c((int) r8, (long) r9)
            goto L_0x0526
        L_0x04f7:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            long r9 = com.google.c.bx.b(r13, r9)
            r14.a((int) r8, (long) r9)
            goto L_0x0526
        L_0x0507:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            float r7 = com.google.c.bx.d(r13, r9)
            r14.a((int) r8, (float) r7)
            goto L_0x0526
        L_0x0517:
            boolean r9 = r12.a(r13, (int) r6)
            if (r9 == 0) goto L_0x0526
            r7 = r7 & r5
            long r9 = (long) r7
            double r9 = com.google.c.bx.e(r13, r9)
            r14.a((int) r8, (double) r9)
        L_0x0526:
            int r6 = r6 + -3
            goto L_0x0052
        L_0x052a:
            if (r1 == 0) goto L_0x0541
            com.google.c.s<?> r13 = r12.r
            r13.a(r14, r1)
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x053f
            java.lang.Object r13 = r0.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            r1 = r13
            goto L_0x052a
        L_0x053f:
            r1 = r2
            goto L_0x052a
        L_0x0541:
            return
        L_0x0542:
            boolean r0 = r12.j
            if (r0 == 0) goto L_0x0a5f
            boolean r0 = r12.f37736h
            if (r0 == 0) goto L_0x0563
            com.google.c.s<?> r0 = r12.r
            com.google.c.w r0 = r0.a((java.lang.Object) r13)
            com.google.c.bp<T, java.lang.Object> r1 = r0.f37925a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0563
            java.util.Iterator r0 = r0.d()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0565
        L_0x0563:
            r0 = r2
            r1 = r0
        L_0x0565:
            int[] r6 = r12.f37731c
            int r6 = r6.length
            r7 = r1
            r1 = 0
        L_0x056a:
            if (r1 >= r6) goto L_0x0a42
            int r8 = r12.d((int) r1)
            int[] r9 = r12.f37731c
            r9 = r9[r1]
        L_0x0574:
            if (r7 == 0) goto L_0x0592
            com.google.c.s<?> r10 = r12.r
            int r10 = r10.a((java.util.Map.Entry<?, ?>) r7)
            if (r10 > r9) goto L_0x0592
            com.google.c.s<?> r10 = r12.r
            r10.a(r14, r7)
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x0590
            java.lang.Object r7 = r0.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            goto L_0x0574
        L_0x0590:
            r7 = r2
            goto L_0x0574
        L_0x0592:
            int r10 = f(r8)
            switch(r10) {
                case 0: goto L_0x0a2f;
                case 1: goto L_0x0a1f;
                case 2: goto L_0x0a0f;
                case 3: goto L_0x09ff;
                case 4: goto L_0x09ef;
                case 5: goto L_0x09df;
                case 6: goto L_0x09cf;
                case 7: goto L_0x09be;
                case 8: goto L_0x09ad;
                case 9: goto L_0x0998;
                case 10: goto L_0x0985;
                case 11: goto L_0x0974;
                case 12: goto L_0x0963;
                case 13: goto L_0x0952;
                case 14: goto L_0x0941;
                case 15: goto L_0x0930;
                case 16: goto L_0x091f;
                case 17: goto L_0x090a;
                case 18: goto L_0x08f9;
                case 19: goto L_0x08e8;
                case 20: goto L_0x08d7;
                case 21: goto L_0x08c6;
                case 22: goto L_0x08b5;
                case 23: goto L_0x08a4;
                case 24: goto L_0x0893;
                case 25: goto L_0x0882;
                case 26: goto L_0x0871;
                case 27: goto L_0x085c;
                case 28: goto L_0x084b;
                case 29: goto L_0x083a;
                case 30: goto L_0x0829;
                case 31: goto L_0x0818;
                case 32: goto L_0x0807;
                case 33: goto L_0x07f6;
                case 34: goto L_0x07e5;
                case 35: goto L_0x07d4;
                case 36: goto L_0x07c3;
                case 37: goto L_0x07b2;
                case 38: goto L_0x07a1;
                case 39: goto L_0x0790;
                case 40: goto L_0x077f;
                case 41: goto L_0x076e;
                case 42: goto L_0x075d;
                case 43: goto L_0x074c;
                case 44: goto L_0x073b;
                case 45: goto L_0x072a;
                case 46: goto L_0x0719;
                case 47: goto L_0x0708;
                case 48: goto L_0x06f7;
                case 49: goto L_0x06e2;
                case 50: goto L_0x06d7;
                case 51: goto L_0x06c6;
                case 52: goto L_0x06b5;
                case 53: goto L_0x06a4;
                case 54: goto L_0x0693;
                case 55: goto L_0x0682;
                case 56: goto L_0x0671;
                case 57: goto L_0x0660;
                case 58: goto L_0x064f;
                case 59: goto L_0x063e;
                case 60: goto L_0x0629;
                case 61: goto L_0x0616;
                case 62: goto L_0x0605;
                case 63: goto L_0x05f4;
                case 64: goto L_0x05e3;
                case 65: goto L_0x05d2;
                case 66: goto L_0x05c1;
                case 67: goto L_0x05b0;
                case 68: goto L_0x059b;
                default: goto L_0x0599;
            }
        L_0x0599:
            goto L_0x0a3e
        L_0x059b:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            com.google.c.bm r10 = r12.a((int) r1)
            r14.b((int) r9, (java.lang.Object) r8, (com.google.c.bm) r10)
            goto L_0x0a3e
        L_0x05b0:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = e(r13, r10)
            r14.e((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x05c1:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = d(r13, r10)
            r14.f(r9, r8)
            goto L_0x0a3e
        L_0x05d2:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = e(r13, r10)
            r14.b((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x05e3:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = d(r13, r10)
            r14.a((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x05f4:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = d(r13, r10)
            r14.b((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x0605:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = d(r13, r10)
            r14.e((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x0616:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            com.google.c.j r8 = (com.google.c.j) r8
            r14.a((int) r9, (com.google.c.j) r8)
            goto L_0x0a3e
        L_0x0629:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            com.google.c.bm r10 = r12.a((int) r1)
            r14.a((int) r9, (java.lang.Object) r8, (com.google.c.bm) r10)
            goto L_0x0a3e
        L_0x063e:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.c.ca) r14)
            goto L_0x0a3e
        L_0x064f:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            boolean r8 = f(r13, r10)
            r14.a((int) r9, (boolean) r8)
            goto L_0x0a3e
        L_0x0660:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = d(r13, r10)
            r14.d((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x0671:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = e(r13, r10)
            r14.d((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x0682:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = d(r13, r10)
            r14.c((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x0693:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = e(r13, r10)
            r14.c((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x06a4:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = e(r13, r10)
            r14.a((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x06b5:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            float r8 = c(r13, r10)
            r14.a((int) r9, (float) r8)
            goto L_0x0a3e
        L_0x06c6:
            boolean r10 = r12.a(r13, (int) r9, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            double r10 = b(r13, (long) r10)
            r14.a((int) r9, (double) r10)
            goto L_0x0a3e
        L_0x06d7:
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            r12.a((com.google.c.ca) r14, (int) r9, (java.lang.Object) r8, (int) r1)
            goto L_0x0a3e
        L_0x06e2:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bm r10 = r12.a((int) r1)
            com.google.c.bo.b((int) r9, (java.util.List<?>) r8, (com.google.c.ca) r14, (com.google.c.bm) r10)
            goto L_0x0a3e
        L_0x06f7:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.e(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x0708:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.j(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x0719:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.g(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x072a:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.l(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x073b:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.m(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x074c:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.i(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x075d:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.n(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x076e:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.k(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x077f:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.f(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x0790:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.h(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x07a1:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.d(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x07b2:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.c(r9, r8, r14, r3)
            goto L_0x0a3e
        L_0x07c3:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.c.ca) r14, (boolean) r3)
            goto L_0x0a3e
        L_0x07d4:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.c.ca) r14, (boolean) r3)
            goto L_0x0a3e
        L_0x07e5:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.e(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x07f6:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.j(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x0807:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.g(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x0818:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.l(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x0829:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.m(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x083a:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.i(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x084b:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.b((int) r9, (java.util.List<com.google.c.j>) r8, (com.google.c.ca) r14)
            goto L_0x0a3e
        L_0x085c:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bm r10 = r12.a((int) r1)
            com.google.c.bo.a((int) r9, (java.util.List<?>) r8, (com.google.c.ca) r14, (com.google.c.bm) r10)
            goto L_0x0a3e
        L_0x0871:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.a((int) r9, (java.util.List<java.lang.String>) r8, (com.google.c.ca) r14)
            goto L_0x0a3e
        L_0x0882:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.n(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x0893:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.k(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x08a4:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.f(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x08b5:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.h(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x08c6:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.d(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x08d7:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.c(r9, r8, r14, r4)
            goto L_0x0a3e
        L_0x08e8:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.c.ca) r14, (boolean) r4)
            goto L_0x0a3e
        L_0x08f9:
            int[] r9 = r12.f37731c
            r9 = r9[r1]
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.c.bo.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.c.ca) r14, (boolean) r4)
            goto L_0x0a3e
        L_0x090a:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            com.google.c.bm r10 = r12.a((int) r1)
            r14.b((int) r9, (java.lang.Object) r8, (com.google.c.bm) r10)
            goto L_0x0a3e
        L_0x091f:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = com.google.c.bx.b(r13, r10)
            r14.e((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x0930:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = com.google.c.bx.a((java.lang.Object) r13, (long) r10)
            r14.f(r9, r8)
            goto L_0x0a3e
        L_0x0941:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = com.google.c.bx.b(r13, r10)
            r14.b((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x0952:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = com.google.c.bx.a((java.lang.Object) r13, (long) r10)
            r14.a((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x0963:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = com.google.c.bx.a((java.lang.Object) r13, (long) r10)
            r14.b((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x0974:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = com.google.c.bx.a((java.lang.Object) r13, (long) r10)
            r14.e((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x0985:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            com.google.c.j r8 = (com.google.c.j) r8
            r14.a((int) r9, (com.google.c.j) r8)
            goto L_0x0a3e
        L_0x0998:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            com.google.c.bm r10 = r12.a((int) r1)
            r14.a((int) r9, (java.lang.Object) r8, (com.google.c.bm) r10)
            goto L_0x0a3e
        L_0x09ad:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            java.lang.Object r8 = com.google.c.bx.f(r13, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.c.ca) r14)
            goto L_0x0a3e
        L_0x09be:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            boolean r8 = com.google.c.bx.c(r13, r10)
            r14.a((int) r9, (boolean) r8)
            goto L_0x0a3e
        L_0x09cf:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = com.google.c.bx.a((java.lang.Object) r13, (long) r10)
            r14.d((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x09df:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = com.google.c.bx.b(r13, r10)
            r14.d((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x09ef:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            int r8 = com.google.c.bx.a((java.lang.Object) r13, (long) r10)
            r14.c((int) r9, (int) r8)
            goto L_0x0a3e
        L_0x09ff:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = com.google.c.bx.b(r13, r10)
            r14.c((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x0a0f:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            long r10 = com.google.c.bx.b(r13, r10)
            r14.a((int) r9, (long) r10)
            goto L_0x0a3e
        L_0x0a1f:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            float r8 = com.google.c.bx.d(r13, r10)
            r14.a((int) r9, (float) r8)
            goto L_0x0a3e
        L_0x0a2f:
            boolean r10 = r12.a(r13, (int) r1)
            if (r10 == 0) goto L_0x0a3e
            r8 = r8 & r5
            long r10 = (long) r8
            double r10 = com.google.c.bx.e(r13, r10)
            r14.a((int) r9, (double) r10)
        L_0x0a3e:
            int r1 = r1 + 3
            goto L_0x056a
        L_0x0a42:
            if (r7 == 0) goto L_0x0a59
            com.google.c.s<?> r1 = r12.r
            r1.a(r14, r7)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a57
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r7 = r1
            goto L_0x0a42
        L_0x0a57:
            r7 = r2
            goto L_0x0a42
        L_0x0a59:
            com.google.c.bt<?, ?> r0 = r12.q
            a(r0, r13, (com.google.c.ca) r14)
            return
        L_0x0a5f:
            r12.b(r13, (com.google.c.ca) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object, com.google.c.ca):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0525  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(T r20, com.google.c.ca r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            boolean r3 = r0.f37736h
            if (r3 == 0) goto L_0x0023
            com.google.c.s<?> r3 = r0.r
            com.google.c.w r3 = r3.a((java.lang.Object) r1)
            com.google.c.bp<T, java.lang.Object> r5 = r3.f37925a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.d()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.f37731c
            int r7 = r7.length
            sun.misc.Unsafe r8 = f37730b
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x0523
            int r12 = r0.d((int) r5)
            int[] r13 = r0.f37731c
            r13 = r13[r5]
            int r14 = f(r12)
            boolean r15 = r0.j
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r15 != 0) goto L_0x005f
            r15 = 17
            if (r14 > r15) goto L_0x005f
            int[] r15 = r0.f37731c
            int r17 = r5 + 2
            r15 = r15[r17]
            r9 = r15 & r16
            r18 = r5
            if (r9 == r6) goto L_0x0059
            long r4 = (long) r9
            int r11 = r8.getInt(r1, r4)
            r6 = r9
        L_0x0059:
            int r4 = r15 >>> 20
            r5 = 1
            int r9 = r5 << r4
            goto L_0x0062
        L_0x005f:
            r18 = r5
            r9 = 0
        L_0x0062:
            if (r10 == 0) goto L_0x0081
            com.google.c.s<?> r4 = r0.r
            int r4 = r4.a((java.util.Map.Entry<?, ?>) r10)
            if (r4 > r13) goto L_0x0081
            com.google.c.s<?> r4 = r0.r
            r4.a(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0062
        L_0x007f:
            r10 = 0
            goto L_0x0062
        L_0x0081:
            r4 = r12 & r16
            long r4 = (long) r4
            switch(r14) {
                case 0: goto L_0x0512;
                case 1: goto L_0x0504;
                case 2: goto L_0x04f6;
                case 3: goto L_0x04e8;
                case 4: goto L_0x04da;
                case 5: goto L_0x04cc;
                case 6: goto L_0x04be;
                case 7: goto L_0x04b0;
                case 8: goto L_0x04a1;
                case 9: goto L_0x048e;
                case 10: goto L_0x047d;
                case 11: goto L_0x046e;
                case 12: goto L_0x045f;
                case 13: goto L_0x0450;
                case 14: goto L_0x0441;
                case 15: goto L_0x0432;
                case 16: goto L_0x0423;
                case 17: goto L_0x0410;
                case 18: goto L_0x03fe;
                case 19: goto L_0x03ec;
                case 20: goto L_0x03da;
                case 21: goto L_0x03c8;
                case 22: goto L_0x03b6;
                case 23: goto L_0x03a4;
                case 24: goto L_0x0392;
                case 25: goto L_0x0380;
                case 26: goto L_0x036f;
                case 27: goto L_0x035a;
                case 28: goto L_0x0349;
                case 29: goto L_0x0337;
                case 30: goto L_0x0325;
                case 31: goto L_0x0313;
                case 32: goto L_0x0301;
                case 33: goto L_0x02ef;
                case 34: goto L_0x02dd;
                case 35: goto L_0x02cb;
                case 36: goto L_0x02b9;
                case 37: goto L_0x02a7;
                case 38: goto L_0x0295;
                case 39: goto L_0x0283;
                case 40: goto L_0x0271;
                case 41: goto L_0x025f;
                case 42: goto L_0x024d;
                case 43: goto L_0x023b;
                case 44: goto L_0x0229;
                case 45: goto L_0x0217;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f3;
                case 48: goto L_0x01e1;
                case 49: goto L_0x01cc;
                case 50: goto L_0x01c1;
                case 51: goto L_0x01b0;
                case 52: goto L_0x019f;
                case 53: goto L_0x018e;
                case 54: goto L_0x017d;
                case 55: goto L_0x016c;
                case 56: goto L_0x015b;
                case 57: goto L_0x014a;
                case 58: goto L_0x0139;
                case 59: goto L_0x0128;
                case 60: goto L_0x0113;
                case 61: goto L_0x0100;
                case 62: goto L_0x00f0;
                case 63: goto L_0x00e0;
                case 64: goto L_0x00d0;
                case 65: goto L_0x00c0;
                case 66: goto L_0x00b0;
                case 67: goto L_0x00a0;
                case 68: goto L_0x008c;
                default: goto L_0x0087;
            }
        L_0x0087:
            r12 = r18
        L_0x0089:
            r14 = 0
            goto L_0x051f
        L_0x008c:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.c.bm r5 = r0.a((int) r12)
            r2.b((int) r13, (java.lang.Object) r4, (com.google.c.bm) r5)
            goto L_0x0089
        L_0x00a0:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            long r4 = e(r1, r4)
            r2.e((int) r13, (long) r4)
            goto L_0x0089
        L_0x00b0:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            int r4 = d(r1, r4)
            r2.f(r13, r4)
            goto L_0x0089
        L_0x00c0:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            long r4 = e(r1, r4)
            r2.b((int) r13, (long) r4)
            goto L_0x0089
        L_0x00d0:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            int r4 = d(r1, r4)
            r2.a((int) r13, (int) r4)
            goto L_0x0089
        L_0x00e0:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            int r4 = d(r1, r4)
            r2.b((int) r13, (int) r4)
            goto L_0x0089
        L_0x00f0:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            int r4 = d(r1, r4)
            r2.e((int) r13, (int) r4)
            goto L_0x0089
        L_0x0100:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.c.j r4 = (com.google.c.j) r4
            r2.a((int) r13, (com.google.c.j) r4)
            goto L_0x0089
        L_0x0113:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.c.bm r5 = r0.a((int) r12)
            r2.a((int) r13, (java.lang.Object) r4, (com.google.c.bm) r5)
            goto L_0x0089
        L_0x0128:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            java.lang.Object r4 = r8.getObject(r1, r4)
            a((int) r13, (java.lang.Object) r4, (com.google.c.ca) r2)
            goto L_0x0089
        L_0x0139:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            boolean r4 = f(r1, r4)
            r2.a((int) r13, (boolean) r4)
            goto L_0x0089
        L_0x014a:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            int r4 = d(r1, r4)
            r2.d((int) r13, (int) r4)
            goto L_0x0089
        L_0x015b:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            long r4 = e(r1, r4)
            r2.d((int) r13, (long) r4)
            goto L_0x0089
        L_0x016c:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            int r4 = d(r1, r4)
            r2.c((int) r13, (int) r4)
            goto L_0x0089
        L_0x017d:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            long r4 = e(r1, r4)
            r2.c((int) r13, (long) r4)
            goto L_0x0089
        L_0x018e:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            long r4 = e(r1, r4)
            r2.a((int) r13, (long) r4)
            goto L_0x0089
        L_0x019f:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            float r4 = c(r1, r4)
            r2.a((int) r13, (float) r4)
            goto L_0x0089
        L_0x01b0:
            r12 = r18
            boolean r9 = r0.a(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0089
            double r4 = b(r1, (long) r4)
            r2.a((int) r13, (double) r4)
            goto L_0x0089
        L_0x01c1:
            r12 = r18
            java.lang.Object r4 = r8.getObject(r1, r4)
            r0.a((com.google.c.ca) r2, (int) r13, (java.lang.Object) r4, (int) r12)
            goto L_0x0089
        L_0x01cc:
            r12 = r18
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bm r5 = r0.a((int) r12)
            com.google.c.bo.b((int) r9, (java.util.List<?>) r4, (com.google.c.ca) r2, (com.google.c.bm) r5)
            goto L_0x0089
        L_0x01e1:
            r12 = r18
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r13 = 1
            com.google.c.bo.e(r9, r4, r2, r13)
            goto L_0x0089
        L_0x01f3:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.j(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0205:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.g(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0217:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.l(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0229:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.m(r9, r4, r2, r13)
            goto L_0x0089
        L_0x023b:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.i(r9, r4, r2, r13)
            goto L_0x0089
        L_0x024d:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.n(r9, r4, r2, r13)
            goto L_0x0089
        L_0x025f:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.k(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0271:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.f(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0283:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.h(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0295:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.d(r9, r4, r2, r13)
            goto L_0x0089
        L_0x02a7:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.c(r9, r4, r2, r13)
            goto L_0x0089
        L_0x02b9:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.b((int) r9, (java.util.List<java.lang.Float>) r4, (com.google.c.ca) r2, (boolean) r13)
            goto L_0x0089
        L_0x02cb:
            r12 = r18
            r13 = 1
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.a((int) r9, (java.util.List<java.lang.Double>) r4, (com.google.c.ca) r2, (boolean) r13)
            goto L_0x0089
        L_0x02dd:
            r12 = r18
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r13 = 0
            com.google.c.bo.e(r9, r4, r2, r13)
            goto L_0x0089
        L_0x02ef:
            r12 = r18
            r13 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.j(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0301:
            r12 = r18
            r13 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.g(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0313:
            r12 = r18
            r13 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.l(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0325:
            r12 = r18
            r13 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.m(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0337:
            r12 = r18
            r13 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.i(r9, r4, r2, r13)
            goto L_0x0089
        L_0x0349:
            r12 = r18
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.b((int) r9, (java.util.List<com.google.c.j>) r4, (com.google.c.ca) r2)
            goto L_0x0089
        L_0x035a:
            r12 = r18
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bm r5 = r0.a((int) r12)
            com.google.c.bo.a((int) r9, (java.util.List<?>) r4, (com.google.c.ca) r2, (com.google.c.bm) r5)
            goto L_0x0089
        L_0x036f:
            r12 = r18
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.a((int) r9, (java.util.List<java.lang.String>) r4, (com.google.c.ca) r2)
            goto L_0x0089
        L_0x0380:
            r12 = r18
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r14 = 0
            com.google.c.bo.n(r9, r4, r2, r14)
            goto L_0x051f
        L_0x0392:
            r12 = r18
            r14 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.k(r9, r4, r2, r14)
            goto L_0x051f
        L_0x03a4:
            r12 = r18
            r14 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.f(r9, r4, r2, r14)
            goto L_0x051f
        L_0x03b6:
            r12 = r18
            r14 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.h(r9, r4, r2, r14)
            goto L_0x051f
        L_0x03c8:
            r12 = r18
            r14 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.d(r9, r4, r2, r14)
            goto L_0x051f
        L_0x03da:
            r12 = r18
            r14 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.c(r9, r4, r2, r14)
            goto L_0x051f
        L_0x03ec:
            r12 = r18
            r14 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.b((int) r9, (java.util.List<java.lang.Float>) r4, (com.google.c.ca) r2, (boolean) r14)
            goto L_0x051f
        L_0x03fe:
            r12 = r18
            r14 = 0
            int[] r9 = r0.f37731c
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.c.bo.a((int) r9, (java.util.List<java.lang.Double>) r4, (com.google.c.ca) r2, (boolean) r14)
            goto L_0x051f
        L_0x0410:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.c.bm r5 = r0.a((int) r12)
            r2.b((int) r13, (java.lang.Object) r4, (com.google.c.bm) r5)
            goto L_0x051f
        L_0x0423:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            long r4 = r8.getLong(r1, r4)
            r2.e((int) r13, (long) r4)
            goto L_0x051f
        L_0x0432:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            int r4 = r8.getInt(r1, r4)
            r2.f(r13, r4)
            goto L_0x051f
        L_0x0441:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            long r4 = r8.getLong(r1, r4)
            r2.b((int) r13, (long) r4)
            goto L_0x051f
        L_0x0450:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            int r4 = r8.getInt(r1, r4)
            r2.a((int) r13, (int) r4)
            goto L_0x051f
        L_0x045f:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            int r4 = r8.getInt(r1, r4)
            r2.b((int) r13, (int) r4)
            goto L_0x051f
        L_0x046e:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            int r4 = r8.getInt(r1, r4)
            r2.e((int) r13, (int) r4)
            goto L_0x051f
        L_0x047d:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.c.j r4 = (com.google.c.j) r4
            r2.a((int) r13, (com.google.c.j) r4)
            goto L_0x051f
        L_0x048e:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.c.bm r5 = r0.a((int) r12)
            r2.a((int) r13, (java.lang.Object) r4, (com.google.c.bm) r5)
            goto L_0x051f
        L_0x04a1:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            java.lang.Object r4 = r8.getObject(r1, r4)
            a((int) r13, (java.lang.Object) r4, (com.google.c.ca) r2)
            goto L_0x051f
        L_0x04b0:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            boolean r4 = com.google.c.bx.c(r1, r4)
            r2.a((int) r13, (boolean) r4)
            goto L_0x051f
        L_0x04be:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            int r4 = r8.getInt(r1, r4)
            r2.d((int) r13, (int) r4)
            goto L_0x051f
        L_0x04cc:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            long r4 = r8.getLong(r1, r4)
            r2.d((int) r13, (long) r4)
            goto L_0x051f
        L_0x04da:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            int r4 = r8.getInt(r1, r4)
            r2.c((int) r13, (int) r4)
            goto L_0x051f
        L_0x04e8:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            long r4 = r8.getLong(r1, r4)
            r2.c((int) r13, (long) r4)
            goto L_0x051f
        L_0x04f6:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            long r4 = r8.getLong(r1, r4)
            r2.a((int) r13, (long) r4)
            goto L_0x051f
        L_0x0504:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            float r4 = com.google.c.bx.d(r1, r4)
            r2.a((int) r13, (float) r4)
            goto L_0x051f
        L_0x0512:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x051f
            double r4 = com.google.c.bx.e(r1, r4)
            r2.a((int) r13, (double) r4)
        L_0x051f:
            int r5 = r12 + 3
            goto L_0x002e
        L_0x0523:
            if (r10 == 0) goto L_0x053a
            com.google.c.s<?> r4 = r0.r
            r4.a(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0538
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0523
        L_0x0538:
            r10 = 0
            goto L_0x0523
        L_0x053a:
            com.google.c.bt<?, ?> r3 = r0.q
            a(r3, r1, (com.google.c.ca) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.b(java.lang.Object, com.google.c.ca):void");
    }

    private <K, V> void a(ca caVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            caVar.a(i2, this.s.e(b(i3)), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(bt<UT, UB> btVar, T t, ca caVar) throws IOException {
        btVar.a(btVar.b(t), caVar);
    }

    public final void a(T t, bk bkVar, r rVar) throws IOException {
        if (rVar != null) {
            a(this.q, this.r, t, bkVar, rVar);
            return;
        }
        throw new NullPointerException();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <UT, UB, ET extends com.google.c.w.a<ET>> void a(com.google.c.bt<UT, UB> r11, com.google.c.s<ET> r12, T r13, com.google.c.bk r14, com.google.c.r r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
            r8 = r1
        L_0x0003:
            int r2 = r14.a()     // Catch:{ all -> 0x05b9 }
            int r3 = r10.h(r2)     // Catch:{ all -> 0x05b9 }
            if (r3 >= 0) goto L_0x006f
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x0029
            int r12 = r10.m
        L_0x0014:
            int r14 = r10.n
            if (r12 >= r14) goto L_0x0023
            int[] r14 = r10.l
            r14 = r14[r12]
            java.lang.Object r8 = r10.a((java.lang.Object) r13, (int) r14, r8, r11)
            int r12 = r12 + 1
            goto L_0x0014
        L_0x0023:
            if (r8 == 0) goto L_0x0028
            r11.b((java.lang.Object) r13, r8)
        L_0x0028:
            return
        L_0x0029:
            boolean r3 = r10.f37736h     // Catch:{ all -> 0x05b9 }
            if (r3 != 0) goto L_0x002f
            r3 = r0
            goto L_0x0036
        L_0x002f:
            com.google.c.at r3 = r10.f37735g     // Catch:{ all -> 0x05b9 }
            java.lang.Object r2 = r12.a(r15, r3, r2)     // Catch:{ all -> 0x05b9 }
            r3 = r2
        L_0x0036:
            if (r3 == 0) goto L_0x004b
            if (r1 != 0) goto L_0x003e
            com.google.c.w r1 = r12.b(r13)     // Catch:{ all -> 0x05b9 }
        L_0x003e:
            r9 = r1
            r1 = r12
            r2 = r14
            r4 = r15
            r5 = r9
            r6 = r8
            r7 = r11
            java.lang.Object r8 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x05b9 }
            r1 = r9
            goto L_0x0003
        L_0x004b:
            if (r8 != 0) goto L_0x0052
            java.lang.Object r2 = r11.c(r13)     // Catch:{ all -> 0x05b9 }
            r8 = r2
        L_0x0052:
            boolean r2 = r11.a(r8, (com.google.c.bk) r14)     // Catch:{ all -> 0x05b9 }
            if (r2 != 0) goto L_0x0003
            int r12 = r10.m
        L_0x005a:
            int r14 = r10.n
            if (r12 >= r14) goto L_0x0069
            int[] r14 = r10.l
            r14 = r14[r12]
            java.lang.Object r8 = r10.a((java.lang.Object) r13, (int) r14, r8, r11)
            int r12 = r12 + 1
            goto L_0x005a
        L_0x0069:
            if (r8 == 0) goto L_0x006e
            r11.b((java.lang.Object) r13, r8)
        L_0x006e:
            return
        L_0x006f:
            int r4 = r10.d((int) r3)     // Catch:{ all -> 0x05b9 }
            int r5 = f(r4)     // Catch:{ a -> 0x0595 }
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x0568;
                case 1: goto L_0x0559;
                case 2: goto L_0x054a;
                case 3: goto L_0x053b;
                case 4: goto L_0x052c;
                case 5: goto L_0x051d;
                case 6: goto L_0x050e;
                case 7: goto L_0x04ff;
                case 8: goto L_0x04f7;
                case 9: goto L_0x04c6;
                case 10: goto L_0x04b7;
                case 11: goto L_0x04a8;
                case 12: goto L_0x0486;
                case 13: goto L_0x0477;
                case 14: goto L_0x0468;
                case 15: goto L_0x0459;
                case 16: goto L_0x044a;
                case 17: goto L_0x0419;
                case 18: goto L_0x040b;
                case 19: goto L_0x03fd;
                case 20: goto L_0x03ef;
                case 21: goto L_0x03e1;
                case 22: goto L_0x03d3;
                case 23: goto L_0x03c5;
                case 24: goto L_0x03b7;
                case 25: goto L_0x03a9;
                case 26: goto L_0x0387;
                case 27: goto L_0x0375;
                case 28: goto L_0x0367;
                case 29: goto L_0x0359;
                case 30: goto L_0x0344;
                case 31: goto L_0x0336;
                case 32: goto L_0x0328;
                case 33: goto L_0x031a;
                case 34: goto L_0x030c;
                case 35: goto L_0x02fe;
                case 36: goto L_0x02f0;
                case 37: goto L_0x02e2;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02c6;
                case 40: goto L_0x02b8;
                case 41: goto L_0x02aa;
                case 42: goto L_0x029c;
                case 43: goto L_0x028e;
                case 44: goto L_0x0279;
                case 45: goto L_0x026b;
                case 46: goto L_0x025d;
                case 47: goto L_0x024f;
                case 48: goto L_0x0241;
                case 49: goto L_0x022f;
                case 50: goto L_0x01ed;
                case 51: goto L_0x01db;
                case 52: goto L_0x01c9;
                case 53: goto L_0x01b7;
                case 54: goto L_0x01a5;
                case 55: goto L_0x0193;
                case 56: goto L_0x0181;
                case 57: goto L_0x016f;
                case 58: goto L_0x015d;
                case 59: goto L_0x0155;
                case 60: goto L_0x0124;
                case 61: goto L_0x0116;
                case 62: goto L_0x0104;
                case 63: goto L_0x00df;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bb;
                case 66: goto L_0x00a9;
                case 67: goto L_0x0097;
                case 68: goto L_0x0085;
                default: goto L_0x007d;
            }     // Catch:{ a -> 0x0595 }
        L_0x007d:
            if (r8 != 0) goto L_0x0578
            java.lang.Object r2 = r11.a()     // Catch:{ a -> 0x0595 }
            goto L_0x0577
        L_0x0085:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            com.google.c.bm r6 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r6 = r14.b(r6, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0097:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            long r6 = r14.t()     // Catch:{ a -> 0x0595 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x00a9:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            int r6 = r14.s()     // Catch:{ a -> 0x0595 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x00bb:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            long r6 = r14.r()     // Catch:{ a -> 0x0595 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x00cd:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            int r6 = r14.q()     // Catch:{ a -> 0x0595 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x00df:
            int r5 = r14.p()     // Catch:{ a -> 0x0595 }
            com.google.c.ac$e r7 = r10.c((int) r3)     // Catch:{ a -> 0x0595 }
            if (r7 == 0) goto L_0x00f6
            boolean r7 = r7.a()     // Catch:{ a -> 0x0595 }
            if (r7 == 0) goto L_0x00f0
            goto L_0x00f6
        L_0x00f0:
            java.lang.Object r8 = com.google.c.bo.a((int) r2, (int) r5, r8, r11)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x00f6:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ a -> 0x0595 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r6, (java.lang.Object) r4)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0104:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            int r6 = r14.o()     // Catch:{ a -> 0x0595 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0116:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            com.google.c.j r6 = r14.n()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0124:
            boolean r5 = r10.a(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            if (r5 == 0) goto L_0x0140
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            java.lang.Object r6 = com.google.c.bx.f(r13, r4)     // Catch:{ a -> 0x0595 }
            com.google.c.bm r7 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r7 = r14.a(r7, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            java.lang.Object r6 = com.google.c.ac.a((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            goto L_0x0150
        L_0x0140:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            com.google.c.bm r6 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r6 = r14.a(r6, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
        L_0x0150:
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0155:
            r10.a((java.lang.Object) r13, (int) r4, (com.google.c.bk) r14)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x015d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            boolean r6 = r14.k()     // Catch:{ a -> 0x0595 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x016f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            int r6 = r14.j()     // Catch:{ a -> 0x0595 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0181:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            long r6 = r14.i()     // Catch:{ a -> 0x0595 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0193:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            int r6 = r14.h()     // Catch:{ a -> 0x0595 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x01a5:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            long r6 = r14.f()     // Catch:{ a -> 0x0595 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x01b7:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            long r6 = r14.g()     // Catch:{ a -> 0x0595 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x01c9:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            float r6 = r14.e()     // Catch:{ a -> 0x0595 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x01db:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ a -> 0x0595 }
            double r6 = r14.d()     // Catch:{ a -> 0x0595 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r2, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x01ed:
            java.lang.Object r2 = r10.b((int) r3)     // Catch:{ a -> 0x0595 }
            int r3 = r10.d((int) r3)     // Catch:{ a -> 0x0595 }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.lang.Object r5 = com.google.c.bx.f(r13, r3)     // Catch:{ a -> 0x0595 }
            if (r5 != 0) goto L_0x0207
            com.google.c.ao r5 = r10.s     // Catch:{ a -> 0x0595 }
            java.lang.Object r5 = r5.a()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ a -> 0x0595 }
            goto L_0x021e
        L_0x0207:
            com.google.c.ao r6 = r10.s     // Catch:{ a -> 0x0595 }
            boolean r6 = r6.c(r5)     // Catch:{ a -> 0x0595 }
            if (r6 == 0) goto L_0x021e
            com.google.c.ao r6 = r10.s     // Catch:{ a -> 0x0595 }
            java.lang.Object r6 = r6.a()     // Catch:{ a -> 0x0595 }
            com.google.c.ao r7 = r10.s     // Catch:{ a -> 0x0595 }
            r7.a(r6, r5)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r6)     // Catch:{ a -> 0x0595 }
            r5 = r6
        L_0x021e:
            com.google.c.ao r3 = r10.s     // Catch:{ a -> 0x0595 }
            java.util.Map r3 = r3.a(r5)     // Catch:{ a -> 0x0595 }
            com.google.c.ao r4 = r10.s     // Catch:{ a -> 0x0595 }
            com.google.c.am$a r2 = r4.e(r2)     // Catch:{ a -> 0x0595 }
            r14.a(r3, r2, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x022f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            com.google.c.bm r2 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            com.google.c.aj r3 = r10.p     // Catch:{ a -> 0x0595 }
            java.util.List r3 = r3.a(r13, r4)     // Catch:{ a -> 0x0595 }
            r14.b(r3, r2, r15)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0241:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.q(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x024f:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.p(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x025d:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.o(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x026b:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.n(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0279:
            com.google.c.aj r5 = r10.p     // Catch:{ a -> 0x0595 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ a -> 0x0595 }
            java.util.List r4 = r5.a(r13, r6)     // Catch:{ a -> 0x0595 }
            r14.m(r4)     // Catch:{ a -> 0x0595 }
            com.google.c.ac$e r3 = r10.c((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r8 = com.google.c.bo.a((int) r2, (java.util.List<java.lang.Integer>) r4, (com.google.c.ac.e) r3, r8, r11)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x028e:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.l(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x029c:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.h(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x02aa:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.g(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x02b8:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.f(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x02c6:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.e(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x02d4:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.c(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x02e2:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.d(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x02f0:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.b(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x02fe:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.a(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x030c:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.q(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x031a:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.p(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0328:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.o(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0336:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.n(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0344:
            com.google.c.aj r5 = r10.p     // Catch:{ a -> 0x0595 }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ a -> 0x0595 }
            java.util.List r4 = r5.a(r13, r6)     // Catch:{ a -> 0x0595 }
            r14.m(r4)     // Catch:{ a -> 0x0595 }
            com.google.c.ac$e r3 = r10.c((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r8 = com.google.c.bo.a((int) r2, (java.util.List<java.lang.Integer>) r4, (com.google.c.ac.e) r3, r8, r11)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0359:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.l(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0367:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.k(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0375:
            com.google.c.bm r2 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            com.google.c.aj r5 = r10.p     // Catch:{ a -> 0x0595 }
            java.util.List r3 = r5.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.a(r3, r2, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0387:
            boolean r2 = g(r4)     // Catch:{ a -> 0x0595 }
            if (r2 == 0) goto L_0x039b
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.j(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x039b:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.i(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x03a9:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.h(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x03b7:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.g(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x03c5:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.f(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x03d3:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.e(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x03e1:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.c(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x03ef:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.d(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x03fd:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.b(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x040b:
            com.google.c.aj r2 = r10.p     // Catch:{ a -> 0x0595 }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ a -> 0x0595 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ a -> 0x0595 }
            r14.a(r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0419:
            boolean r2 = r10.a(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            if (r2 == 0) goto L_0x0437
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            java.lang.Object r2 = com.google.c.bx.f(r13, r4)     // Catch:{ a -> 0x0595 }
            com.google.c.bm r3 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r3 = r14.b(r3, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            java.lang.Object r2 = com.google.c.ac.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0437:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            com.google.c.bm r2 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r2 = r14.b(r2, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x044a:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            long r6 = r14.t()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0459:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            int r2 = r14.s()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0468:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            long r6 = r14.r()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0477:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            int r2 = r14.q()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0486:
            int r5 = r14.p()     // Catch:{ a -> 0x0595 }
            com.google.c.ac$e r7 = r10.c((int) r3)     // Catch:{ a -> 0x0595 }
            if (r7 == 0) goto L_0x049d
            boolean r7 = r7.a()     // Catch:{ a -> 0x0595 }
            if (r7 == 0) goto L_0x0497
            goto L_0x049d
        L_0x0497:
            java.lang.Object r8 = com.google.c.bo.a((int) r2, (int) r5, r8, r11)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x049d:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r6, (int) r5)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x04a8:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            int r2 = r14.o()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x04b7:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            com.google.c.j r2 = r14.n()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x04c6:
            boolean r2 = r10.a(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            if (r2 == 0) goto L_0x04e4
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            java.lang.Object r2 = com.google.c.bx.f(r13, r4)     // Catch:{ a -> 0x0595 }
            com.google.c.bm r3 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r3 = r14.a(r3, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            java.lang.Object r2 = com.google.c.ac.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x04e4:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            com.google.c.bm r2 = r10.a((int) r3)     // Catch:{ a -> 0x0595 }
            java.lang.Object r2 = r14.a(r2, (com.google.c.r) r15)     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x04f7:
            r10.a((java.lang.Object) r13, (int) r4, (com.google.c.bk) r14)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x04ff:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            boolean r2 = r14.k()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (boolean) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x050e:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            int r2 = r14.j()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x051d:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            long r6 = r14.i()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x052c:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            int r2 = r14.h()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x053b:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            long r6 = r14.f()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x054a:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            long r6 = r14.g()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0559:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            float r2 = r14.e()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (float) r2)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0568:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ a -> 0x0595 }
            double r6 = r14.d()     // Catch:{ a -> 0x0595 }
            com.google.c.bx.a((java.lang.Object) r13, (long) r4, (double) r6)     // Catch:{ a -> 0x0595 }
            r10.b(r13, (int) r3)     // Catch:{ a -> 0x0595 }
            goto L_0x0003
        L_0x0577:
            r8 = r2
        L_0x0578:
            boolean r2 = r11.a(r8, (com.google.c.bk) r14)     // Catch:{ a -> 0x0595 }
            if (r2 != 0) goto L_0x0003
            int r12 = r10.m
        L_0x0580:
            int r14 = r10.n
            if (r12 >= r14) goto L_0x058f
            int[] r14 = r10.l
            r14 = r14[r12]
            java.lang.Object r8 = r10.a((java.lang.Object) r13, (int) r14, r8, r11)
            int r12 = r12 + 1
            goto L_0x0580
        L_0x058f:
            if (r8 == 0) goto L_0x0594
            r11.b((java.lang.Object) r13, r8)
        L_0x0594:
            return
        L_0x0595:
            if (r8 != 0) goto L_0x059c
            java.lang.Object r2 = r11.c(r13)     // Catch:{ all -> 0x05b9 }
            r8 = r2
        L_0x059c:
            boolean r2 = r11.a(r8, (com.google.c.bk) r14)     // Catch:{ all -> 0x05b9 }
            if (r2 != 0) goto L_0x0003
            int r12 = r10.m
        L_0x05a4:
            int r14 = r10.n
            if (r12 >= r14) goto L_0x05b3
            int[] r14 = r10.l
            r14 = r14[r12]
            java.lang.Object r8 = r10.a((java.lang.Object) r13, (int) r14, r8, r11)
            int r12 = r12 + 1
            goto L_0x05a4
        L_0x05b3:
            if (r8 == 0) goto L_0x05b8
            r11.b((java.lang.Object) r13, r8)
        L_0x05b8:
            return
        L_0x05b9:
            r12 = move-exception
            int r14 = r10.m
        L_0x05bc:
            int r15 = r10.n
            if (r14 >= r15) goto L_0x05cb
            int[] r15 = r10.l
            r15 = r15[r14]
            java.lang.Object r8 = r10.a((java.lang.Object) r13, (int) r15, r8, r11)
            int r14 = r14 + 1
            goto L_0x05bc
        L_0x05cb:
            if (r8 == 0) goto L_0x05d0
            r11.b((java.lang.Object) r13, r8)
        L_0x05d0:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(com.google.c.bt, com.google.c.s, java.lang.Object, com.google.c.bk, com.google.c.r):void");
    }

    static bu c(Object obj) {
        aa aaVar = (aa) obj;
        bu buVar = aaVar.f37680e;
        if (buVar != bu.a()) {
            return buVar;
        }
        bu b2 = bu.b();
        aaVar.f37680e = b2;
        return b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(byte[] r1, int r2, int r3, com.google.c.bz.a r4, java.lang.Class<?> r5, com.google.c.e.a r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.c.aw.AnonymousClass1.f37738a
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x009a;
                case 2: goto L_0x0095;
                case 3: goto L_0x0088;
                case 4: goto L_0x007b;
                case 5: goto L_0x007b;
                case 6: goto L_0x0070;
                case 7: goto L_0x0070;
                case 8: goto L_0x0065;
                case 9: goto L_0x0058;
                case 10: goto L_0x0058;
                case 11: goto L_0x0058;
                case 12: goto L_0x004b;
                case 13: goto L_0x004b;
                case 14: goto L_0x003e;
                case 15: goto L_0x002c;
                case 16: goto L_0x001a;
                case 17: goto L_0x0014;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0014:
            int r1 = com.google.c.e.d(r1, r2, r6)
            goto L_0x00af
        L_0x001a:
            int r1 = com.google.c.e.b(r1, r2, r6)
            long r2 = r6.f37837b
            long r2 = com.google.c.k.a((long) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.f37838c = r2
            goto L_0x00af
        L_0x002c:
            int r1 = com.google.c.e.a(r1, r2, r6)
            int r2 = r6.f37836a
            int r2 = com.google.c.k.e(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.f37838c = r2
            goto L_0x00af
        L_0x003e:
            com.google.c.bg r4 = com.google.c.bg.a()
            com.google.c.bm r4 = r4.a(r5)
            int r1 = com.google.c.e.a((com.google.c.bm) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.c.e.a) r6)
            goto L_0x00af
        L_0x004b:
            int r1 = com.google.c.e.b(r1, r2, r6)
            long r2 = r6.f37837b
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.f37838c = r2
            goto L_0x00af
        L_0x0058:
            int r1 = com.google.c.e.a(r1, r2, r6)
            int r2 = r6.f37836a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.f37838c = r2
            goto L_0x00af
        L_0x0065:
            float r1 = com.google.c.e.d(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.f37838c = r1
            goto L_0x0085
        L_0x0070:
            long r3 = com.google.c.e.b(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.f37838c = r1
            goto L_0x0092
        L_0x007b:
            int r1 = com.google.c.e.a(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.f37838c = r1
        L_0x0085:
            int r1 = r2 + 4
            goto L_0x00af
        L_0x0088:
            double r3 = com.google.c.e.c(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.f37838c = r1
        L_0x0092:
            int r1 = r2 + 8
            goto L_0x00af
        L_0x0095:
            int r1 = com.google.c.e.e(r1, r2, r6)
            goto L_0x00af
        L_0x009a:
            int r1 = com.google.c.e.b(r1, r2, r6)
            long r2 = r6.f37837b
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a8
            r2 = 1
            goto L_0x00a9
        L_0x00a8:
            r2 = 0
        L_0x00a9:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.f37838c = r2
        L_0x00af:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(byte[], int, int, com.google.c.bz$a, java.lang.Class, com.google.c.e$a):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011b  */
    private int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.c.e.a r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = f37730b
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.c.ac$i r11 = (com.google.c.ac.i) r11
            boolean r12 = r11.a()
            r13 = 2
            if (r12 != 0) goto L_0x0037
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002e
        L_0x002c:
            int r12 = r12 * 2
        L_0x002e:
            com.google.c.ac$i r11 = r11.a(r12)
            sun.misc.Unsafe r12 = f37730b
            r12.putObject(r1, r9, r11)
        L_0x0037:
            r9 = 5
            r14 = 0
            r10 = 1
            switch(r27) {
                case 18: goto L_0x0245;
                case 19: goto L_0x021f;
                case 20: goto L_0x01f6;
                case 21: goto L_0x01f6;
                case 22: goto L_0x01dc;
                case 23: goto L_0x01b5;
                case 24: goto L_0x018e;
                case 25: goto L_0x0156;
                case 26: goto L_0x00f3;
                case 27: goto L_0x00d9;
                case 28: goto L_0x00c7;
                case 29: goto L_0x01dc;
                case 30: goto L_0x008f;
                case 31: goto L_0x018e;
                case 32: goto L_0x01b5;
                case 33: goto L_0x0075;
                case 34: goto L_0x005b;
                case 35: goto L_0x0245;
                case 36: goto L_0x021f;
                case 37: goto L_0x01f6;
                case 38: goto L_0x01f6;
                case 39: goto L_0x01dc;
                case 40: goto L_0x01b5;
                case 41: goto L_0x018e;
                case 42: goto L_0x0156;
                case 43: goto L_0x01dc;
                case 44: goto L_0x008f;
                case 45: goto L_0x018e;
                case 46: goto L_0x01b5;
                case 47: goto L_0x0075;
                case 48: goto L_0x005b;
                case 49: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x026b
        L_0x0040:
            r1 = 3
            if (r6 != r1) goto L_0x026b
            com.google.c.bm r1 = r0.a((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.c.e.b(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x026c
        L_0x005b:
            if (r6 != r13) goto L_0x0063
            int r1 = com.google.c.e.i(r3, r4, r11, r7)
            goto L_0x026c
        L_0x0063:
            if (r6 != 0) goto L_0x026b
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.c.e.c(r21, r22, r23, r24, r25, r26)
            goto L_0x026c
        L_0x0075:
            if (r6 != r13) goto L_0x007d
            int r1 = com.google.c.e.h(r3, r4, r11, r7)
            goto L_0x026c
        L_0x007d:
            if (r6 != 0) goto L_0x026b
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.c.e.b(r21, r22, r23, r24, r25, r26)
            goto L_0x026c
        L_0x008f:
            if (r6 != r13) goto L_0x0096
            int r2 = com.google.c.e.a((byte[]) r3, (int) r4, (com.google.c.ac.i<?>) r11, (com.google.c.e.a) r7)
            goto L_0x00a7
        L_0x0096:
            if (r6 != 0) goto L_0x026b
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.c.e.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.c.ac.i<?>) r6, (com.google.c.e.a) r7)
        L_0x00a7:
            com.google.c.aa r1 = (com.google.c.aa) r1
            com.google.c.bu r3 = r1.f37680e
            com.google.c.bu r4 = com.google.c.bu.a()
            if (r3 != r4) goto L_0x00b2
            r3 = 0
        L_0x00b2:
            com.google.c.ac$e r4 = r0.c((int) r8)
            com.google.c.bt<?, ?> r5 = r0.q
            r6 = r22
            java.lang.Object r3 = com.google.c.bo.a((int) r6, (java.util.List<java.lang.Integer>) r11, (com.google.c.ac.e) r4, r3, r5)
            com.google.c.bu r3 = (com.google.c.bu) r3
            if (r3 == 0) goto L_0x00c4
            r1.f37680e = r3
        L_0x00c4:
            r1 = r2
            goto L_0x026c
        L_0x00c7:
            if (r6 != r13) goto L_0x026b
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.c.e.e(r21, r22, r23, r24, r25, r26)
            goto L_0x026c
        L_0x00d9:
            if (r6 != r13) goto L_0x026b
            com.google.c.bm r1 = r0.a((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.c.e.a(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x026c
        L_0x00f3:
            if (r6 != r13) goto L_0x026b
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x0146
            int r1 = com.google.c.e.a(r3, r4, r7)
            int r4 = r7.f37836a
            if (r4 < 0) goto L_0x0141
            java.lang.String r6 = ""
            if (r4 != 0) goto L_0x010e
            r11.add(r6)
            goto L_0x0119
        L_0x010e:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.c.ac.f37697a
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
        L_0x0118:
            int r1 = r1 + r4
        L_0x0119:
            if (r1 >= r5) goto L_0x026c
            int r4 = com.google.c.e.a(r3, r1, r7)
            int r8 = r7.f37836a
            if (r2 != r8) goto L_0x026c
            int r1 = com.google.c.e.a(r3, r4, r7)
            int r4 = r7.f37836a
            if (r4 < 0) goto L_0x013c
            if (r4 != 0) goto L_0x0131
            r11.add(r6)
            goto L_0x0119
        L_0x0131:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.c.ac.f37697a
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
            goto L_0x0118
        L_0x013c:
            com.google.c.ad r1 = com.google.c.ad.negativeSize()
            throw r1
        L_0x0141:
            com.google.c.ad r1 = com.google.c.ad.negativeSize()
            throw r1
        L_0x0146:
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.c.e.d(r21, r22, r23, r24, r25, r26)
            goto L_0x026c
        L_0x0156:
            if (r6 != r13) goto L_0x015e
            int r1 = com.google.c.e.g(r3, r4, r11, r7)
            goto L_0x026c
        L_0x015e:
            if (r6 != 0) goto L_0x026b
            com.google.c.g r11 = (com.google.c.g) r11
            int r1 = com.google.c.e.b(r3, r4, r7)
            long r8 = r7.f37837b
            r4 = 0
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x016f
            r6 = 1
            goto L_0x0170
        L_0x016f:
            r6 = 0
        L_0x0170:
            r11.a((boolean) r6)
        L_0x0173:
            if (r1 >= r5) goto L_0x026c
            int r6 = com.google.c.e.a(r3, r1, r7)
            int r8 = r7.f37836a
            if (r2 != r8) goto L_0x026c
            int r1 = com.google.c.e.b(r3, r6, r7)
            long r8 = r7.f37837b
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0189
            r6 = 1
            goto L_0x018a
        L_0x0189:
            r6 = 0
        L_0x018a:
            r11.a((boolean) r6)
            goto L_0x0173
        L_0x018e:
            if (r6 != r13) goto L_0x0196
            int r1 = com.google.c.e.c(r3, r4, r11, r7)
            goto L_0x026c
        L_0x0196:
            if (r6 != r9) goto L_0x026b
            com.google.c.ab r11 = (com.google.c.ab) r11
            int r1 = com.google.c.e.a(r18, r19)
            r11.c(r1)
        L_0x01a1:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x026c
            int r4 = com.google.c.e.a(r3, r1, r7)
            int r6 = r7.f37836a
            if (r2 != r6) goto L_0x026c
            int r1 = com.google.c.e.a(r3, r4)
            r11.c(r1)
            goto L_0x01a1
        L_0x01b5:
            if (r6 != r13) goto L_0x01bd
            int r1 = com.google.c.e.d(r3, r4, r11, r7)
            goto L_0x026c
        L_0x01bd:
            if (r6 != r10) goto L_0x026b
            com.google.c.ak r11 = (com.google.c.ak) r11
            long r8 = com.google.c.e.b(r18, r19)
            r11.a((long) r8)
        L_0x01c8:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x026c
            int r4 = com.google.c.e.a(r3, r1, r7)
            int r6 = r7.f37836a
            if (r2 != r6) goto L_0x026c
            long r8 = com.google.c.e.b(r3, r4)
            r11.a((long) r8)
            goto L_0x01c8
        L_0x01dc:
            if (r6 != r13) goto L_0x01e4
            int r1 = com.google.c.e.a((byte[]) r3, (int) r4, (com.google.c.ac.i<?>) r11, (com.google.c.e.a) r7)
            goto L_0x026c
        L_0x01e4:
            if (r6 != 0) goto L_0x026b
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.c.e.a((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.c.ac.i<?>) r25, (com.google.c.e.a) r26)
            goto L_0x026c
        L_0x01f6:
            if (r6 != r13) goto L_0x01fe
            int r1 = com.google.c.e.b(r3, r4, r11, r7)
            goto L_0x026c
        L_0x01fe:
            if (r6 != 0) goto L_0x026b
            com.google.c.ak r11 = (com.google.c.ak) r11
            int r1 = com.google.c.e.b(r3, r4, r7)
            long r8 = r7.f37837b
            r11.a((long) r8)
        L_0x020b:
            if (r1 >= r5) goto L_0x026c
            int r4 = com.google.c.e.a(r3, r1, r7)
            int r6 = r7.f37836a
            if (r2 != r6) goto L_0x026c
            int r1 = com.google.c.e.b(r3, r4, r7)
            long r8 = r7.f37837b
            r11.a((long) r8)
            goto L_0x020b
        L_0x021f:
            if (r6 != r13) goto L_0x0226
            int r1 = com.google.c.e.e(r3, r4, r11, r7)
            goto L_0x026c
        L_0x0226:
            if (r6 != r9) goto L_0x026b
            com.google.c.y r11 = (com.google.c.y) r11
            float r1 = com.google.c.e.d(r18, r19)
            r11.a((float) r1)
        L_0x0231:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x026c
            int r4 = com.google.c.e.a(r3, r1, r7)
            int r6 = r7.f37836a
            if (r2 != r6) goto L_0x026c
            float r1 = com.google.c.e.d(r3, r4)
            r11.a((float) r1)
            goto L_0x0231
        L_0x0245:
            if (r6 != r13) goto L_0x024c
            int r1 = com.google.c.e.f(r3, r4, r11, r7)
            goto L_0x026c
        L_0x024c:
            if (r6 != r10) goto L_0x026b
            com.google.c.o r11 = (com.google.c.o) r11
            double r8 = com.google.c.e.c(r18, r19)
            r11.a((double) r8)
        L_0x0257:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x026c
            int r4 = com.google.c.e.a(r3, r1, r7)
            int r6 = r7.f37836a
            if (r2 != r6) goto L_0x026c
            double r8 = com.google.c.e.c(r3, r4)
            r11.a((double) r8)
            goto L_0x0257
        L_0x026b:
            r1 = r4
        L_0x026c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.c.e$a):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int a(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.c.e.a r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = f37730b
            java.lang.Object r12 = r7.b((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.c.ao r2 = r7.s
            boolean r2 = r2.c(r1)
            if (r2 == 0) goto L_0x0021
            com.google.c.ao r2 = r7.s
            java.lang.Object r2 = r2.a()
            com.google.c.ao r3 = r7.s
            r3.a(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.c.ao r8 = r7.s
            com.google.c.am$a r8 = r8.e(r12)
            com.google.c.ao r12 = r7.s
            java.util.Map r12 = r12.a(r1)
            int r10 = com.google.c.e.a(r9, r10, r15)
            int r13 = r15.f37836a
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.f37724b
            V r0 = r8.f37726d
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.c.e.a((int) r10, (byte[]) r9, (int) r1, (com.google.c.e.a) r15)
            int r10 = r15.f37836a
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.c.bz$a r1 = r8.f37725c
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x0087
            com.google.c.bz$a r4 = r8.f37725c
            V r10 = r8.f37726d
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = a((byte[]) r1, (int) r2, (int) r3, (com.google.c.bz.a) r4, (java.lang.Class<?>) r5, (com.google.c.e.a) r6)
            java.lang.Object r0 = r15.f37838c
            goto L_0x003e
        L_0x0072:
            com.google.c.bz$a r1 = r8.f37723a
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x0087
            com.google.c.bz$a r4 = r8.f37723a
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = a((byte[]) r1, (int) r2, (int) r3, (com.google.c.bz.a) r4, (java.lang.Class<?>) r5, (com.google.c.e.a) r6)
            java.lang.Object r14 = r15.f37838c
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.c.e.a((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.c.e.a) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.c.ad r8 = com.google.c.ad.parseFailure()
            throw r8
        L_0x0097:
            com.google.c.ad r8 = com.google.c.ad.truncatedMessage()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object, byte[], int, int, int, long, com.google.c.e$a):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.c.e.a r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = f37730b
            int[] r7 = r0.f37731c
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.c.bm r2 = r0.a((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.c.e.a((com.google.c.bm) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.c.e.a) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.f37838c
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.f37838c
            java.lang.Object r3 = com.google.c.ac.a((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.c.e.b(r3, r4, r11)
            long r3 = r11.f37837b
            long r3 = com.google.c.k.a((long) r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.c.e.a(r3, r4, r11)
            int r3 = r11.f37836a
            int r3 = com.google.c.k.e(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.c.e.a(r3, r4, r11)
            int r4 = r11.f37836a
            com.google.c.ac$e r5 = r0.c((int) r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.c.bu r1 = c((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.a((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.c.e.e(r3, r4, r11)
            java.lang.Object r3 = r11.f37838c
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.c.bm r2 = r0.a((int) r6)
            r5 = r20
            int r2 = com.google.c.e.a((com.google.c.bm) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.c.e.a) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.f37838c
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.f37838c
            java.lang.Object r3 = com.google.c.ac.a((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.c.e.a(r3, r4, r11)
            int r4 = r11.f37836a
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.c.by.a((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.c.ad r1 = com.google.c.ad.invalidUtf8()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.c.ac.f37697a
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.c.e.b(r3, r4, r11)
            long r3 = r11.f37837b
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.c.e.a(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.c.e.b(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.c.e.a(r3, r4, r11)
            int r3 = r11.f37836a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.c.e.b(r3, r4, r11)
            long r3 = r11.f37837b
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.c.e.d(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.c.e.c(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.c.e$a):int");
    }

    private bm a(int i2) {
        int i3 = (i2 / 3) * 2;
        bm bmVar = (bm) this.f37732d[i3];
        if (bmVar != null) {
            return bmVar;
        }
        bm a2 = bg.a().a((Class) this.f37732d[i3 + 1]);
        this.f37732d[i3] = a2;
        return a2;
    }

    private Object b(int i2) {
        return this.f37732d[(i2 / 3) * 2];
    }

    private ac.e c(int i2) {
        return (ac.e) this.f37732d[((i2 / 3) * 2) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v75, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0345, code lost:
        if (r0 == r15) goto L_0x03b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0390, code lost:
        if (r0 == r15) goto L_0x03b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f9, code lost:
        r12 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015f, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fb, code lost:
        r6 = r6 | r21;
        r2 = r8;
        r3 = r13;
        r1 = r17;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0223, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0259, code lost:
        r6 = r6 | r21;
        r2 = r8;
        r0 = r11;
        r3 = r13;
        r1 = r17;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0262, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0294, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0296, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0298, code lost:
        r11 = r34;
        r2 = r8;
        r3 = r13;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02a0, code lost:
        r0 = r34;
        r21 = r6;
        r20 = r7;
        r18 = r8;
        r28 = r10;
        r2 = r11;
        r8 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03db  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(T r30, byte[] r31, int r32, int r33, int r34, com.google.c.e.a r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = f37730b
            r16 = 0
            r0 = r32
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            if (r0 >= r13) goto L_0x0425
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.c.e.a((int) r0, (byte[]) r12, (int) r3, (com.google.c.e.a) r9)
            int r3 = r9.f37836a
            r4 = r0
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r0
            r4 = r3
        L_0x002a:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0037
            int r2 = r2 / r8
            int r1 = r15.a((int) r3, (int) r2)
            goto L_0x003b
        L_0x0037:
            int r1 = r15.h(r3)
        L_0x003b:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004e
            r17 = r3
            r2 = r4
            r8 = r5
            r21 = r6
            r20 = r7
            r28 = r10
            r0 = r11
            r18 = 0
            goto L_0x03ba
        L_0x004e:
            int[] r1 = r15.f37731c
            int r18 = r2 + 1
            r1 = r1[r18]
            int r8 = f(r1)
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r5
            r5 = r1 & r18
            long r11 = (long) r5
            r5 = 17
            r20 = r1
            if (r8 > r5) goto L_0x02ae
            int[] r5 = r15.f37731c
            int r21 = r2 + 2
            r5 = r5[r21]
            int r21 = r5 >>> 20
            r1 = 1
            int r21 = r1 << r21
            r5 = r5 & r18
            if (r5 == r7) goto L_0x0086
            r13 = -1
            r17 = r2
            if (r7 == r13) goto L_0x007e
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x007e:
            long r1 = (long) r5
            int r1 = r10.getInt(r14, r1)
            r6 = r1
            r7 = r5
            goto L_0x0089
        L_0x0086:
            r17 = r2
            r13 = -1
        L_0x0089:
            r1 = 5
            switch(r8) {
                case 0: goto L_0x027e;
                case 1: goto L_0x0266;
                case 2: goto L_0x023f;
                case 3: goto L_0x023f;
                case 4: goto L_0x0226;
                case 5: goto L_0x0204;
                case 6: goto L_0x01e3;
                case 7: goto L_0x01c1;
                case 8: goto L_0x019c;
                case 9: goto L_0x0164;
                case 10: goto L_0x0148;
                case 11: goto L_0x0226;
                case 12: goto L_0x0117;
                case 13: goto L_0x01e3;
                case 14: goto L_0x0204;
                case 15: goto L_0x00fd;
                case 16: goto L_0x00dc;
                case 17: goto L_0x009a;
                default: goto L_0x008d;
            }
        L_0x008d:
            r12 = r31
            r11 = r4
            r8 = r17
            r13 = r19
            r19 = -1
            r17 = r3
            goto L_0x02a0
        L_0x009a:
            r2 = 3
            if (r0 != r2) goto L_0x00d5
            int r0 = r3 << 3
            r5 = r0 | 4
            r2 = r17
            com.google.c.bm r0 = r15.a((int) r2)
            r1 = r31
            r8 = r2
            r2 = r4
            r17 = r3
            r3 = r33
            r4 = r5
            r13 = r19
            r5 = r35
            int r0 = com.google.c.e.a((com.google.c.bm) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.c.e.a) r5)
            r1 = r6 & r21
            if (r1 != 0) goto L_0x00c2
            java.lang.Object r1 = r9.f37838c
            r10.putObject(r14, r11, r1)
            goto L_0x00cf
        L_0x00c2:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.f37838c
            java.lang.Object r1 = com.google.c.ac.a((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r11, r1)
        L_0x00cf:
            r6 = r6 | r21
            r12 = r31
            goto L_0x0298
        L_0x00d5:
            r8 = r17
            r13 = r19
            r17 = r3
            goto L_0x00f9
        L_0x00dc:
            r8 = r17
            r13 = r19
            r17 = r3
            if (r0 != 0) goto L_0x00f9
            r2 = r11
            r12 = r31
            int r11 = com.google.c.e.b(r12, r4, r9)
            long r0 = r9.f37837b
            long r4 = com.google.c.k.a((long) r0)
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            goto L_0x0259
        L_0x00f9:
            r12 = r31
            goto L_0x015f
        L_0x00fd:
            r8 = r17
            r13 = r19
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != 0) goto L_0x015f
            int r0 = com.google.c.e.a(r12, r4, r9)
            int r1 = r9.f37836a
            int r1 = com.google.c.k.e(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0296
        L_0x0117:
            r8 = r17
            r13 = r19
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != 0) goto L_0x015f
            int r0 = com.google.c.e.a(r12, r4, r9)
            int r1 = r9.f37836a
            com.google.c.ac$e r4 = r15.c((int) r8)
            if (r4 == 0) goto L_0x0143
            boolean r4 = r4.a()
            if (r4 == 0) goto L_0x0135
            goto L_0x0143
        L_0x0135:
            com.google.c.bu r2 = c((java.lang.Object) r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.a((int) r13, (java.lang.Object) r1)
            goto L_0x0298
        L_0x0143:
            r10.putInt(r14, r2, r1)
            goto L_0x0296
        L_0x0148:
            r8 = r17
            r13 = r19
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != r1) goto L_0x015f
            int r0 = com.google.c.e.e(r12, r4, r9)
            java.lang.Object r1 = r9.f37838c
            r10.putObject(r14, r2, r1)
            goto L_0x0296
        L_0x015f:
            r11 = r4
            r19 = -1
            goto L_0x02a0
        L_0x0164:
            r8 = r17
            r13 = r19
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r31
            if (r0 != r1) goto L_0x0196
            com.google.c.bm r0 = r15.a((int) r8)
            r11 = r33
            r19 = -1
            int r0 = com.google.c.e.a((com.google.c.bm) r0, (byte[]) r12, (int) r4, (int) r11, (com.google.c.e.a) r9)
            r1 = r6 & r21
            if (r1 != 0) goto L_0x0187
            java.lang.Object r1 = r9.f37838c
            r10.putObject(r14, r2, r1)
            goto L_0x01fb
        L_0x0187:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.f37838c
            java.lang.Object r1 = com.google.c.ac.a((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
            goto L_0x01fb
        L_0x0196:
            r11 = r33
            r19 = -1
            goto L_0x0223
        L_0x019c:
            r8 = r17
            r13 = r19
            r1 = 2
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != r1) goto L_0x0223
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01b7
            int r0 = com.google.c.e.c(r12, r4, r9)
            goto L_0x01bb
        L_0x01b7:
            int r0 = com.google.c.e.d(r12, r4, r9)
        L_0x01bb:
            java.lang.Object r1 = r9.f37838c
            r10.putObject(r14, r2, r1)
            goto L_0x01fb
        L_0x01c1:
            r8 = r17
            r13 = r19
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != 0) goto L_0x0223
            int r0 = com.google.c.e.b(r12, r4, r9)
            long r4 = r9.f37837b
            r22 = 0
            int r1 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x01de
            r1 = 1
            goto L_0x01df
        L_0x01de:
            r1 = 0
        L_0x01df:
            com.google.c.bx.a((java.lang.Object) r14, (long) r2, (boolean) r1)
            goto L_0x01fb
        L_0x01e3:
            r8 = r17
            r13 = r19
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != r1) goto L_0x0223
            int r0 = com.google.c.e.a(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x01fb:
            r6 = r6 | r21
            r2 = r8
            r3 = r13
            r1 = r17
            r13 = r11
            goto L_0x0262
        L_0x0204:
            r8 = r17
            r13 = r19
            r1 = 1
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r33
            if (r0 != r1) goto L_0x0223
            long r22 = com.google.c.e.b(r12, r4)
            r0 = r10
            r1 = r30
            r11 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            goto L_0x0294
        L_0x0223:
            r11 = r4
            goto L_0x02a0
        L_0x0226:
            r8 = r17
            r13 = r19
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != 0) goto L_0x02a0
            int r0 = com.google.c.e.a(r12, r11, r9)
            int r1 = r9.f37836a
            r10.putInt(r14, r2, r1)
            goto L_0x0296
        L_0x023f:
            r8 = r17
            r13 = r19
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != 0) goto L_0x02a0
            int r11 = com.google.c.e.b(r12, r11, r9)
            long r4 = r9.f37837b
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
        L_0x0259:
            r6 = r6 | r21
            r2 = r8
            r0 = r11
            r3 = r13
            r1 = r17
            r13 = r33
        L_0x0262:
            r11 = r34
            goto L_0x0017
        L_0x0266:
            r8 = r17
            r13 = r19
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != r1) goto L_0x02a0
            float r0 = com.google.c.e.d(r12, r11)
            com.google.c.bx.a((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r11 + 4
            goto L_0x0296
        L_0x027e:
            r8 = r17
            r13 = r19
            r1 = 1
            r19 = -1
            r17 = r3
            r2 = r11
            r12 = r31
            r11 = r4
            if (r0 != r1) goto L_0x02a0
            double r0 = com.google.c.e.c(r12, r11)
            com.google.c.bx.a((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0294:
            int r0 = r11 + 8
        L_0x0296:
            r6 = r6 | r21
        L_0x0298:
            r11 = r34
            r2 = r8
            r3 = r13
            r1 = r17
            goto L_0x02fd
        L_0x02a0:
            r0 = r34
            r21 = r6
            r20 = r7
            r18 = r8
            r28 = r10
            r2 = r11
            r8 = r13
            goto L_0x03ba
        L_0x02ae:
            r5 = r2
            r17 = r3
            r2 = r11
            r13 = r19
            r19 = -1
            r12 = r31
            r11 = r4
            r1 = 27
            if (r8 != r1) goto L_0x030e
            r1 = 2
            if (r0 != r1) goto L_0x0301
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.c.ac$i r0 = (com.google.c.ac.i) r0
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x02de
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d5
            r1 = 10
            goto L_0x02d7
        L_0x02d5:
            int r1 = r1 * 2
        L_0x02d7:
            com.google.c.ac$i r0 = r0.a(r1)
            r10.putObject(r14, r2, r0)
        L_0x02de:
            r8 = r0
            com.google.c.bm r0 = r15.a((int) r5)
            r1 = r13
            r2 = r31
            r3 = r11
            r4 = r33
            r18 = r5
            r5 = r8
            r21 = r6
            r6 = r35
            int r0 = com.google.c.e.a(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r3 = r13
            r1 = r17
            r2 = r18
            r6 = r21
        L_0x02fd:
            r13 = r33
            goto L_0x0017
        L_0x0301:
            r18 = r5
            r21 = r6
            r20 = r7
            r28 = r10
            r15 = r11
            r19 = r13
            goto L_0x0393
        L_0x030e:
            r18 = r5
            r21 = r6
            r1 = 49
            if (r8 > r1) goto L_0x0363
            r1 = r20
            long r5 = (long) r1
            r4 = r0
            r0 = r29
            r1 = r30
            r23 = r2
            r2 = r31
            r3 = r11
            r32 = r4
            r4 = r33
            r25 = r5
            r5 = r13
            r6 = r17
            r20 = r7
            r7 = r32
            r27 = r8
            r8 = r18
            r28 = r10
            r9 = r25
            r15 = r11
            r11 = r27
            r19 = r13
            r12 = r23
            r14 = r35
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.c.e.a) r14)
            if (r0 != r15) goto L_0x0349
            goto L_0x03b5
        L_0x0349:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r17
            r2 = r18
            r3 = r19
        L_0x035b:
            r7 = r20
            r6 = r21
        L_0x035f:
            r10 = r28
            goto L_0x0017
        L_0x0363:
            r32 = r0
            r23 = r2
            r27 = r8
            r28 = r10
            r15 = r11
            r19 = r13
            r1 = r20
            r20 = r7
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x0399
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x0393
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r23
            r8 = r35
            int r0 = r0.a(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x0349
            goto L_0x03b5
        L_0x0393:
            r0 = r34
            r2 = r15
            r8 = r19
            goto L_0x03ba
        L_0x0399:
            r7 = r32
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r17
            r10 = r23
            r12 = r18
            r13 = r35
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.c.e.a) r13)
            if (r0 != r15) goto L_0x0410
        L_0x03b5:
            r2 = r0
            r8 = r19
            r0 = r34
        L_0x03ba:
            if (r8 != r0) goto L_0x03ca
            if (r0 != 0) goto L_0x03bf
            goto L_0x03ca
        L_0x03bf:
            r4 = -1
            r9 = r29
            r10 = r0
            r3 = r8
            r0 = r20
            r1 = r21
            goto L_0x0433
        L_0x03ca:
            r9 = r29
            r10 = r0
            boolean r0 = r9.f37736h
            r11 = r35
            if (r0 == 0) goto L_0x03ed
            com.google.c.r r0 = r11.f37839d
            com.google.c.r r1 = com.google.c.r.a()
            if (r0 == r1) goto L_0x03ed
            com.google.c.at r5 = r9.f37735g
            com.google.c.bt<?, ?> r6 = r9.q
            r0 = r8
            r1 = r31
            r3 = r33
            r4 = r30
            r7 = r35
            int r0 = com.google.c.e.a(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x03fc
        L_0x03ed:
            com.google.c.bu r4 = c((java.lang.Object) r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.c.e.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.c.bu) r4, (com.google.c.e.a) r5)
        L_0x03fc:
            r14 = r30
            r12 = r31
            r13 = r33
            r3 = r8
            r15 = r9
            r9 = r11
            r1 = r17
            r2 = r18
            r7 = r20
            r6 = r21
            r11 = r10
            goto L_0x035f
        L_0x0410:
            r8 = r19
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r3 = r8
            r1 = r17
            r2 = r18
            goto L_0x035b
        L_0x0425:
            r21 = r6
            r20 = r7
            r28 = r10
            r10 = r11
            r9 = r15
            r2 = r0
            r0 = r20
            r1 = r21
            r4 = -1
        L_0x0433:
            if (r0 == r4) goto L_0x043e
            long r4 = (long) r0
            r0 = r30
            r6 = r28
            r6.putInt(r0, r4, r1)
            goto L_0x0440
        L_0x043e:
            r0 = r30
        L_0x0440:
            r1 = 0
            int r4 = r9.m
        L_0x0443:
            int r5 = r9.n
            if (r4 >= r5) goto L_0x0456
            int[] r5 = r9.l
            r5 = r5[r4]
            com.google.c.bt<?, ?> r6 = r9.q
            java.lang.Object r1 = r9.a((java.lang.Object) r0, (int) r5, r1, r6)
            com.google.c.bu r1 = (com.google.c.bu) r1
            int r4 = r4 + 1
            goto L_0x0443
        L_0x0456:
            if (r1 == 0) goto L_0x045d
            com.google.c.bt<?, ?> r4 = r9.q
            r4.b((java.lang.Object) r0, r1)
        L_0x045d:
            if (r10 != 0) goto L_0x0469
            r0 = r33
            if (r2 != r0) goto L_0x0464
            goto L_0x046f
        L_0x0464:
            com.google.c.ad r0 = com.google.c.ad.parseFailure()
            throw r0
        L_0x0469:
            r0 = r33
            if (r2 > r0) goto L_0x0470
            if (r3 != r10) goto L_0x0470
        L_0x046f:
            return r2
        L_0x0470:
            com.google.c.ad r0 = com.google.c.ad.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object, byte[], int, int, int, com.google.c.e$a):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010a, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013c, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0158, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015a, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015e, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e1, code lost:
        if (r0 == r15) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020e, code lost:
        if (r0 == r15) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x022d, code lost:
        if (r0 == r15) goto L_0x022f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r28, byte[] r29, int r30, int r31, com.google.c.e.a r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.j
            if (r0 == 0) goto L_0x025c
            sun.misc.Unsafe r9 = f37730b
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0253
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.c.e.a((int) r0, (byte[]) r12, (int) r3, (com.google.c.e.a) r11)
            int r3 = r11.f37836a
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0039
            int r2 = r2 / 3
            int r0 = r15.a((int) r7, (int) r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.h(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0230
        L_0x004b:
            int[] r0 = r15.f37731c
            int r1 = r4 + 1
            r5 = r0[r1]
            int r3 = f(r5)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0166
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014d;
                case 1: goto L_0x013e;
                case 2: goto L_0x012c;
                case 3: goto L_0x012c;
                case 4: goto L_0x011e;
                case 5: goto L_0x010e;
                case 6: goto L_0x00fd;
                case 7: goto L_0x00e7;
                case 8: goto L_0x00d0;
                case 9: goto L_0x00af;
                case 10: goto L_0x00a2;
                case 11: goto L_0x011e;
                case 12: goto L_0x0093;
                case 13: goto L_0x00fd;
                case 14: goto L_0x010e;
                case 15: goto L_0x0080;
                case 16: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x01a3
        L_0x0065:
            if (r6 != 0) goto L_0x01a3
            int r6 = com.google.c.e.b(r12, r8, r11)
            r19 = r1
            long r0 = r11.f37837b
            long r21 = com.google.c.k.a((long) r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013c
        L_0x0080:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015e
            int r0 = com.google.c.e.a(r12, r8, r11)
            int r1 = r11.f37836a
            int r1 = com.google.c.k.e(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015a
        L_0x0093:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015e
            int r0 = com.google.c.e.a(r12, r8, r11)
            int r1 = r11.f37836a
            r9.putInt(r14, r2, r1)
            goto L_0x015a
        L_0x00a2:
            r2 = r1
            if (r6 != r10) goto L_0x01a3
            int r0 = com.google.c.e.e(r12, r8, r11)
            java.lang.Object r1 = r11.f37838c
            r9.putObject(r14, r2, r1)
            goto L_0x010a
        L_0x00af:
            r2 = r1
            if (r6 != r10) goto L_0x01a3
            com.google.c.bm r0 = r15.a((int) r4)
            int r0 = com.google.c.e.a((com.google.c.bm) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.c.e.a) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c6
            java.lang.Object r1 = r11.f37838c
            r9.putObject(r14, r2, r1)
            goto L_0x010a
        L_0x00c6:
            java.lang.Object r5 = r11.f37838c
            java.lang.Object r1 = com.google.c.ac.a((java.lang.Object) r1, (java.lang.Object) r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010a
        L_0x00d0:
            r2 = r1
            if (r6 != r10) goto L_0x01a3
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00dd
            int r0 = com.google.c.e.c(r12, r8, r11)
            goto L_0x00e1
        L_0x00dd:
            int r0 = com.google.c.e.d(r12, r8, r11)
        L_0x00e1:
            java.lang.Object r1 = r11.f37838c
            r9.putObject(r14, r2, r1)
            goto L_0x010a
        L_0x00e7:
            r2 = r1
            if (r6 != 0) goto L_0x01a3
            int r1 = com.google.c.e.b(r12, r8, r11)
            long r5 = r11.f37837b
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            com.google.c.bx.a((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x010a
        L_0x00fd:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a3
            int r0 = com.google.c.e.a(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010a:
            r2 = r4
            r1 = r7
            goto L_0x0250
        L_0x010e:
            r2 = r1
            if (r6 != r0) goto L_0x01a3
            long r5 = com.google.c.e.b(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0158
        L_0x011e:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015e
            int r0 = com.google.c.e.a(r12, r8, r11)
            int r1 = r11.f37836a
            r9.putInt(r14, r2, r1)
            goto L_0x015a
        L_0x012c:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015e
            int r6 = com.google.c.e.b(r12, r8, r11)
            long r4 = r11.f37837b
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013c:
            r0 = r6
            goto L_0x015a
        L_0x013e:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015e
            float r0 = com.google.c.e.d(r12, r8)
            com.google.c.bx.a((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x015a
        L_0x014d:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015e
            double r0 = com.google.c.e.c(r12, r8)
            com.google.c.bx.a((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0158:
            int r0 = r8 + 8
        L_0x015a:
            r1 = r7
            r2 = r10
            goto L_0x0250
        L_0x015e:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01aa
        L_0x0166:
            r0 = 27
            if (r3 != r0) goto L_0x01ae
            if (r6 != r10) goto L_0x01a3
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.c.ac$i r0 = (com.google.c.ac.i) r0
            boolean r3 = r0.a()
            if (r3 != 0) goto L_0x018a
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0181
            r3 = 10
            goto L_0x0183
        L_0x0181:
            int r3 = r3 * 2
        L_0x0183:
            com.google.c.ac$i r0 = r0.a(r3)
            r9.putObject(r14, r1, r0)
        L_0x018a:
            r5 = r0
            com.google.c.bm r0 = r15.a((int) r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.c.e.a(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0250
        L_0x01a3:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01aa:
            r26 = -1
            goto L_0x0211
        L_0x01ae:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e4
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.c.e.a) r14)
            if (r0 != r15) goto L_0x0240
            goto L_0x022f
        L_0x01e4:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0213
            r7 = r30
            if (r7 != r10) goto L_0x0211
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.a(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x0240
            goto L_0x022f
        L_0x0211:
            r2 = r15
            goto L_0x0230
        L_0x0213:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.c.e.a) r13)
            if (r0 != r15) goto L_0x0240
        L_0x022f:
            r2 = r0
        L_0x0230:
            com.google.c.bu r4 = c((java.lang.Object) r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.c.e.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.c.bu) r4, (com.google.c.e.a) r5)
        L_0x0240:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0250:
            r10 = -1
            goto L_0x0017
        L_0x0253:
            r4 = r13
            if (r0 != r4) goto L_0x0257
            return
        L_0x0257:
            com.google.c.ad r0 = com.google.c.ad.parseFailure()
            throw r0
        L_0x025c:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.c.e.a) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.aw.a(java.lang.Object, byte[], int, int, com.google.c.e$a):void");
    }

    public final void d(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long d2 = (long) (d(this.l[i3]) & 1048575);
            Object f2 = bx.f(t, d2);
            if (f2 != null) {
                bx.a((Object) t, d2, this.s.d(f2));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.b(t, (long) this.l[i2]);
            i2++;
        }
        this.q.d(t);
        if (this.f37736h) {
            this.r.c(t);
        }
    }

    private final <K, V, UT, UB> UB a(int i2, int i3, Map<K, V> map, ac.e eVar, UB ub, bt<UT, UB> btVar) {
        am.a<?, ?> e2 = this.s.e(b(i2));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            ((Integer) next.getValue()).intValue();
            if (!eVar.a()) {
                if (ub == null) {
                    ub = btVar.a();
                }
                j.f newCodedBuilder = j.newCodedBuilder(am.a(e2, next.getKey(), next.getValue()));
                try {
                    am.a(newCodedBuilder.f37857a, e2, next.getKey(), next.getValue());
                    btVar.a(ub, i3, newCodedBuilder.a());
                    it2.remove();
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return ub;
    }

    public final boolean e(T t) {
        int i2;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.m) {
                return !this.f37736h || this.r.a((Object) t).e();
            }
            int i6 = this.l[i3];
            int i7 = this.f37731c[i6];
            int d2 = d(i6);
            if (!this.j) {
                int i8 = this.f37731c[i6 + 2];
                int i9 = i8 & 1048575;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i4) {
                    i5 = f37730b.getInt(t, (long) i9);
                    i4 = i9;
                }
            } else {
                i2 = 0;
            }
            if (((268435456 & d2) != 0) && !a(t, i6, i5, i2)) {
                return false;
            }
            int f2 = f(d2);
            if (f2 != 9 && f2 != 17) {
                if (f2 != 27) {
                    if (f2 == 60 || f2 == 68) {
                        if (a(t, i7, i6) && !a((Object) t, d2, a(i6))) {
                            return false;
                        }
                    } else if (f2 != 49) {
                        if (f2 != 50) {
                            continue;
                        } else {
                            Map<?, ?> b2 = this.s.b(bx.f(t, (long) (d2 & 1048575)));
                            if (!b2.isEmpty()) {
                                if (this.s.e(b(i6)).f37725c.getJavaType() == bz.b.MESSAGE) {
                                    bm<?> bmVar = null;
                                    Iterator<?> it2 = b2.values().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        Object next = it2.next();
                                        if (bmVar == null) {
                                            bmVar = bg.a().a(next.getClass());
                                        }
                                        if (!bmVar.e(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) bx.f(t, (long) (d2 & 1048575));
                if (!list.isEmpty()) {
                    bm a2 = a(i6);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!a2.e(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a(t, i6, i5, i2) && !a((Object) t, d2, a(i6))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean a(Object obj, int i2, bm bmVar) {
        return bmVar.e(bx.f(obj, (long) (i2 & 1048575)));
    }

    private static void a(int i2, Object obj, ca caVar) throws IOException {
        if (obj instanceof String) {
            caVar.a(i2, (String) obj);
        } else {
            caVar.a(i2, (j) obj);
        }
    }

    private void a(Object obj, int i2, bk bkVar) throws IOException {
        if (g(i2)) {
            bx.a(obj, (long) (i2 & 1048575), (Object) bkVar.m());
        } else if (this.f37737i) {
            bx.a(obj, (long) (i2 & 1048575), (Object) bkVar.l());
        } else {
            bx.a(obj, (long) (i2 & 1048575), (Object) bkVar.n());
        }
    }

    private int d(int i2) {
        return this.f37731c[i2 + 1];
    }

    private int e(int i2) {
        return this.f37731c[i2 + 2];
    }

    private static <T> double b(T t, long j2) {
        return ((Double) bx.f(t, j2)).doubleValue();
    }

    private static <T> float c(T t, long j2) {
        return ((Float) bx.f(t, j2)).floatValue();
    }

    private static <T> int d(T t, long j2) {
        return ((Integer) bx.f(t, j2)).intValue();
    }

    private static <T> long e(T t, long j2) {
        return ((Long) bx.f(t, j2)).longValue();
    }

    private static <T> boolean f(T t, long j2) {
        return ((Boolean) bx.f(t, j2)).booleanValue();
    }

    private boolean c(T t, T t2, int i2) {
        return a(t, i2) == a(t2, i2);
    }

    private boolean a(T t, int i2, int i3, int i4) {
        if (this.j) {
            return a(t, i2);
        }
        return (i3 & i4) != 0;
    }

    private boolean a(T t, int i2) {
        if (this.j) {
            int d2 = d(i2);
            long j2 = (long) (d2 & 1048575);
            switch (f(d2)) {
                case 0:
                    return bx.e(t, j2) != 0.0d;
                case 1:
                    return bx.d(t, j2) != 0.0f;
                case 2:
                    return bx.b(t, j2) != 0;
                case 3:
                    return bx.b(t, j2) != 0;
                case 4:
                    return bx.a((Object) t, j2) != 0;
                case 5:
                    return bx.b(t, j2) != 0;
                case 6:
                    return bx.a((Object) t, j2) != 0;
                case 7:
                    return bx.c(t, j2);
                case 8:
                    Object f2 = bx.f(t, j2);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof j) {
                        return !j.EMPTY.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return bx.f(t, j2) != null;
                case 10:
                    return !j.EMPTY.equals(bx.f(t, j2));
                case 11:
                    return bx.a((Object) t, j2) != 0;
                case 12:
                    return bx.a((Object) t, j2) != 0;
                case 13:
                    return bx.a((Object) t, j2) != 0;
                case 14:
                    return bx.b(t, j2) != 0;
                case 15:
                    return bx.a((Object) t, j2) != 0;
                case 16:
                    return bx.b(t, j2) != 0;
                case 17:
                    return bx.f(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int e2 = e(i2);
            return (bx.a((Object) t, (long) (e2 & 1048575)) & (1 << (e2 >>> 20))) != 0;
        }
    }

    private void b(T t, int i2) {
        if (!this.j) {
            int e2 = e(i2);
            long j2 = (long) (e2 & 1048575);
            bx.a((Object) t, j2, bx.a((Object) t, j2) | (1 << (e2 >>> 20)));
        }
    }

    private boolean a(T t, int i2, int i3) {
        return bx.a((Object) t, (long) (e(i3) & 1048575)) == i2;
    }

    private void b(T t, int i2, int i3) {
        bx.a((Object) t, (long) (e(i3) & 1048575), i2);
    }

    private int h(int i2) {
        if (i2 < this.f37733e || i2 > this.f37734f) {
            return -1;
        }
        return b(i2, 0);
    }

    private int a(int i2, int i3) {
        if (i2 < this.f37733e || i2 > this.f37734f) {
            return -1;
        }
        return b(i2, i3);
    }

    private int b(int i2, int i3) {
        int length = (this.f37731c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f37731c[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private final <UT, UB> UB a(Object obj, int i2, UB ub, bt<UT, UB> btVar) {
        ac.e c2;
        int i3 = this.f37731c[i2];
        Object f2 = bx.f(obj, (long) (d(i2) & 1048575));
        if (f2 == null || (c2 = c(i2)) == null) {
            return ub;
        }
        return a(i2, i3, this.s.a(f2), c2, ub, btVar);
    }
}
