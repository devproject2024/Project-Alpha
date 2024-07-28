package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class di<T> implements dr<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f10157a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f10158b = eo.c();

    /* renamed from: c  reason: collision with root package name */
    private final int[] f10159c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f10160d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10161e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10162f;

    /* renamed from: g  reason: collision with root package name */
    private final dd f10163g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f10164h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f10165i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final dj o;
    private final cn p;
    private final ei<?, ?> q;
    private final bl<?> r;
    private final cw s;

    private di(int[] iArr, Object[] objArr, int i2, int i3, dd ddVar, boolean z, int[] iArr2, int i4, int i5, dj djVar, cn cnVar, ei<?, ?> eiVar, bl<?> blVar, cw cwVar) {
        this.f10159c = iArr;
        this.f10160d = objArr;
        this.f10161e = i2;
        this.f10162f = i3;
        this.f10165i = ddVar instanceof bv;
        this.j = z;
        this.f10164h = blVar != null && blVar.a(ddVar);
        this.k = false;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = djVar;
        this.p = cnVar;
        this.q = eiVar;
        this.r = blVar;
        this.f10163g = ddVar;
        this.s = cwVar;
    }

    static <T> di<T> a(db dbVar, dj djVar, cn cnVar, ei<?, ?> eiVar, bl<?> blVar, cw cwVar) {
        int i2;
        int i3;
        int i4;
        char c2;
        char c3;
        char c4;
        int[] iArr;
        int i5;
        char c5;
        char c6;
        int i6;
        int i7;
        int[] iArr2;
        ds dsVar;
        String str;
        int i8;
        int i9;
        int i10;
        char c7;
        int i11;
        Field field;
        char charAt;
        int i12;
        int i13;
        Field field2;
        Field field3;
        char charAt2;
        int i14;
        char charAt3;
        int i15;
        char charAt4;
        int i16;
        char c8;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        char charAt5;
        int i22;
        char charAt6;
        int i23;
        char charAt7;
        int i24;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        char charAt12;
        char charAt13;
        char charAt14;
        db dbVar2 = dbVar;
        if (dbVar2 instanceof ds) {
            ds dsVar2 = (ds) dbVar2;
            char c9 = 0;
            boolean z = dsVar2.a() == bv.c.f10117i;
            String str2 = dsVar2.f10174b;
            int length = str2.length();
            char charAt15 = str2.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i25 = 1;
                int i26 = 13;
                while (true) {
                    i2 = i25 + 1;
                    charAt14 = str2.charAt(i25);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c10 |= (charAt14 & 8191) << i26;
                    i26 += 13;
                    i25 = i2;
                }
                charAt15 = (charAt14 << i26) | c10;
            } else {
                i2 = 1;
            }
            int i27 = i2 + 1;
            char charAt16 = str2.charAt(i2);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i28 = 13;
                while (true) {
                    i3 = i27 + 1;
                    charAt13 = str2.charAt(i27);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c11 |= (charAt13 & 8191) << i28;
                    i28 += 13;
                    i27 = i3;
                }
                charAt16 = c11 | (charAt13 << i28);
            } else {
                i3 = i27;
            }
            if (charAt16 == 0) {
                i4 = i3;
                c5 = 0;
                i5 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
                iArr = f10157a;
                c6 = 0;
            } else {
                int i29 = i3 + 1;
                char charAt17 = str2.charAt(i3);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i30 = 13;
                    while (true) {
                        i16 = i29 + 1;
                        charAt12 = str2.charAt(i29);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c12 |= (charAt12 & 8191) << i30;
                        i30 += 13;
                        i29 = i16;
                    }
                    c8 = (charAt12 << i30) | c12;
                } else {
                    i16 = i29;
                    c8 = charAt17;
                }
                int i31 = i16 + 1;
                char charAt18 = str2.charAt(i16);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i32 = 13;
                    while (true) {
                        i17 = i31 + 1;
                        charAt11 = str2.charAt(i31);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c13 |= (charAt11 & 8191) << i32;
                        i32 += 13;
                        i31 = i17;
                    }
                    charAt18 = c13 | (charAt11 << i32);
                } else {
                    i17 = i31;
                }
                int i33 = i17 + 1;
                char charAt19 = str2.charAt(i17);
                if (charAt19 >= 55296) {
                    char c14 = charAt19 & 8191;
                    int i34 = 13;
                    while (true) {
                        i18 = i33 + 1;
                        charAt10 = str2.charAt(i33);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c14 |= (charAt10 & 8191) << i34;
                        i34 += 13;
                        i33 = i18;
                    }
                    charAt19 = (charAt10 << i34) | c14;
                } else {
                    i18 = i33;
                }
                int i35 = i18 + 1;
                char charAt20 = str2.charAt(i18);
                if (charAt20 >= 55296) {
                    char c15 = charAt20 & 8191;
                    int i36 = 13;
                    while (true) {
                        i19 = i35 + 1;
                        charAt9 = str2.charAt(i35);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c15 |= (charAt9 & 8191) << i36;
                        i36 += 13;
                        i35 = i19;
                    }
                    charAt20 = (charAt9 << i36) | c15;
                } else {
                    i19 = i35;
                }
                int i37 = i19 + 1;
                c3 = str2.charAt(i19);
                if (c3 >= 55296) {
                    char c16 = c3 & 8191;
                    int i38 = 13;
                    while (true) {
                        i24 = i37 + 1;
                        charAt8 = str2.charAt(i37);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c16 |= (charAt8 & 8191) << i38;
                        i38 += 13;
                        i37 = i24;
                    }
                    c3 = (charAt8 << i38) | c16;
                    i37 = i24;
                }
                int i39 = i37 + 1;
                char charAt21 = str2.charAt(i37);
                if (charAt21 >= 55296) {
                    char c17 = charAt21 & 8191;
                    int i40 = 13;
                    while (true) {
                        i23 = i39 + 1;
                        charAt7 = str2.charAt(i39);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c17 |= (charAt7 & 8191) << i40;
                        i40 += 13;
                        i39 = i23;
                    }
                    charAt21 = c17 | (charAt7 << i40);
                    i39 = i23;
                }
                int i41 = i39 + 1;
                char charAt22 = str2.charAt(i39);
                if (charAt22 >= 55296) {
                    int i42 = 13;
                    int i43 = i41;
                    char c18 = charAt22 & 8191;
                    int i44 = i43;
                    while (true) {
                        i22 = i44 + 1;
                        charAt6 = str2.charAt(i44);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c18 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i44 = i22;
                    }
                    charAt22 = c18 | (charAt6 << i42);
                    i20 = i22;
                } else {
                    i20 = i41;
                }
                i4 = i20 + 1;
                char charAt23 = str2.charAt(i20);
                if (charAt23 >= 55296) {
                    int i45 = 13;
                    int i46 = i4;
                    char c19 = charAt23 & 8191;
                    int i47 = i46;
                    while (true) {
                        i21 = i47 + 1;
                        charAt5 = str2.charAt(i47);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c19 |= (charAt5 & 8191) << i45;
                        i45 += 13;
                        i47 = i21;
                    }
                    charAt23 = c19 | (charAt5 << i45);
                    i4 = i21;
                }
                i5 = (c8 << 1) + charAt18;
                char c20 = charAt20;
                c4 = charAt23;
                c9 = charAt21;
                c5 = c20;
                int[] iArr3 = new int[(charAt23 + charAt21 + charAt22)];
                c2 = c8;
                c6 = charAt19;
                iArr = iArr3;
            }
            Unsafe unsafe = f10158b;
            Object[] objArr = dsVar2.f10175c;
            Class<?> cls = dsVar2.f10173a.getClass();
            int i48 = i5;
            int[] iArr4 = new int[(c3 * 3)];
            Object[] objArr2 = new Object[(c3 << 1)];
            int i49 = c9 + c4;
            int i50 = i49;
            char c21 = c4;
            int i51 = i4;
            int i52 = i48;
            int i53 = 0;
            int i54 = 0;
            while (i51 < length) {
                int i55 = i51 + 1;
                int charAt24 = str2.charAt(i51);
                int i56 = length;
                char c22 = 55296;
                if (charAt24 >= 55296) {
                    int i57 = 13;
                    int i58 = i55;
                    int i59 = charAt24 & 8191;
                    int i60 = i58;
                    while (true) {
                        i15 = i60 + 1;
                        charAt4 = str2.charAt(i60);
                        if (charAt4 < c22) {
                            break;
                        }
                        i59 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i60 = i15;
                        c22 = 55296;
                    }
                    charAt24 = i59 | (charAt4 << i57);
                    i6 = i15;
                } else {
                    i6 = i55;
                }
                int i61 = i6 + 1;
                char charAt25 = str2.charAt(i6);
                char c23 = c4;
                char c24 = 55296;
                if (charAt25 >= 55296) {
                    int i62 = 13;
                    int i63 = i61;
                    char c25 = charAt25 & 8191;
                    int i64 = i63;
                    while (true) {
                        i14 = i64 + 1;
                        charAt3 = str2.charAt(i64);
                        if (charAt3 < c24) {
                            break;
                        }
                        c25 |= (charAt3 & 8191) << i62;
                        i62 += 13;
                        i64 = i14;
                        c24 = 55296;
                    }
                    charAt25 = c25 | (charAt3 << i62);
                    i7 = i14;
                } else {
                    i7 = i61;
                }
                boolean z2 = z;
                char c26 = charAt25 & 255;
                char c27 = c5;
                if ((charAt25 & 1024) != 0) {
                    iArr[i53] = i54;
                    i53++;
                }
                char c28 = c6;
                if (c26 >= '3') {
                    int i65 = i7 + 1;
                    char charAt26 = str2.charAt(i7);
                    char c29 = 55296;
                    if (charAt26 >= 55296) {
                        char c30 = charAt26 & 8191;
                        int i66 = 13;
                        while (true) {
                            i13 = i65 + 1;
                            charAt2 = str2.charAt(i65);
                            if (charAt2 < c29) {
                                break;
                            }
                            c30 |= (charAt2 & 8191) << i66;
                            i66 += 13;
                            i65 = i13;
                            c29 = 55296;
                        }
                        charAt26 = c30 | (charAt2 << i66);
                    } else {
                        i13 = i65;
                    }
                    int i67 = c26 - '3';
                    if (i67 == 9 || i67 == 17) {
                        objArr2[((i54 / 3) << 1) + 1] = objArr[i52];
                        i52++;
                    } else if (i67 == 12 && (charAt15 & 1) == 1) {
                        objArr2[((i54 / 3) << 1) + 1] = objArr[i52];
                        i52++;
                    }
                    int i68 = charAt26 << 1;
                    Object obj = objArr[i68];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = a(cls, (String) obj);
                        objArr[i68] = field2;
                    }
                    iArr2 = iArr4;
                    i8 = (int) unsafe.objectFieldOffset(field2);
                    int i69 = i68 + 1;
                    Object obj2 = objArr[i69];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = a(cls, (String) obj2);
                        objArr[i69] = field3;
                    }
                    i9 = (int) unsafe.objectFieldOffset(field3);
                    dsVar = dsVar2;
                    str = str2;
                    i7 = i13;
                    i10 = 0;
                } else {
                    iArr2 = iArr4;
                    int i70 = i52 + 1;
                    Field a2 = a(cls, (String) objArr[i52]);
                    if (c26 == 9 || c26 == 17) {
                        dsVar = dsVar2;
                        c7 = 1;
                        objArr2[((i54 / 3) << 1) + 1] = a2.getType();
                    } else {
                        if (c26 == 27 || c26 == '1') {
                            dsVar = dsVar2;
                            c7 = 1;
                            i12 = i70 + 1;
                            objArr2[((i54 / 3) << 1) + 1] = objArr[i70];
                        } else if (c26 == 12 || c26 == 30 || c26 == ',') {
                            dsVar = dsVar2;
                            c7 = 1;
                            if ((charAt15 & 1) == 1) {
                                i12 = i70 + 1;
                                objArr2[((i54 / 3) << 1) + 1] = objArr[i70];
                            }
                        } else {
                            if (c26 == '2') {
                                int i71 = c21 + 1;
                                iArr[c21] = i54;
                                int i72 = (i54 / 3) << 1;
                                int i73 = i70 + 1;
                                objArr2[i72] = objArr[i70];
                                if ((charAt25 & 2048) != 0) {
                                    i70 = i73 + 1;
                                    objArr2[i72 + 1] = objArr[i73];
                                    dsVar = dsVar2;
                                    c21 = i71;
                                    c7 = 1;
                                } else {
                                    c21 = i71;
                                    i70 = i73;
                                }
                            }
                            dsVar = dsVar2;
                            c7 = 1;
                        }
                        i70 = i12;
                    }
                    i8 = (int) unsafe.objectFieldOffset(a2);
                    if ((charAt15 & 1) != c7 || c26 > 17) {
                        str = str2;
                        i10 = 0;
                        i9 = 0;
                    } else {
                        int i74 = i7 + 1;
                        char charAt27 = str2.charAt(i7);
                        if (charAt27 >= 55296) {
                            char c31 = charAt27 & 8191;
                            int i75 = 13;
                            while (true) {
                                i11 = i74 + 1;
                                charAt = str2.charAt(i74);
                                if (charAt < 55296) {
                                    break;
                                }
                                c31 |= (charAt & 8191) << i75;
                                i75 += 13;
                                i74 = i11;
                            }
                            charAt27 = c31 | (charAt << i75);
                        } else {
                            i11 = i74;
                        }
                        int i76 = (c2 << 1) + (charAt27 / ' ');
                        Object obj3 = objArr[i76];
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = a(cls, (String) obj3);
                            objArr[i76] = field;
                        }
                        str = str2;
                        int objectFieldOffset = (int) unsafe.objectFieldOffset(field);
                        int i77 = charAt27 % ' ';
                        i9 = objectFieldOffset;
                        i7 = i11;
                        i10 = i77;
                    }
                    if (c26 >= 18 && c26 <= '1') {
                        iArr[i50] = i8;
                        i50++;
                    }
                    i52 = i70;
                }
                int i78 = i54 + 1;
                iArr2[i54] = charAt24;
                int i79 = i78 + 1;
                iArr2[i78] = ((charAt25 & 256) != 0 ? 268435456 : 0) | ((charAt25 & 512) != 0 ? 536870912 : 0) | (c26 << 20) | i8;
                i54 = i79 + 1;
                iArr2[i79] = (i10 << 20) | i9;
                i51 = i7;
                str2 = str;
                z = z2;
                length = i56;
                c4 = c23;
                c5 = c27;
                dsVar2 = dsVar;
                c6 = c28;
                iArr4 = iArr2;
            }
            char c32 = c6;
            char c33 = c5;
            boolean z3 = z;
            char c34 = c4;
            return new di(iArr4, objArr2, c6, c5, dsVar2.f10173a, z, iArr, c4, i49, djVar, cnVar, eiVar, blVar, cwVar);
        }
        throw new NoSuchMethodError();
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
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.icing.dt.a(com.google.android.gms.internal.icing.eo.f(r10, r6), com.google.android.gms.internal.icing.eo.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.icing.eo.b(r10, r6) == com.google.android.gms.internal.icing.eo.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.icing.eo.b(r10, r6) == com.google.android.gms.internal.icing.eo.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.icing.dt.a(com.google.android.gms.internal.icing.eo.f(r10, r6), com.google.android.gms.internal.icing.eo.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.icing.dt.a(com.google.android.gms.internal.icing.eo.f(r10, r6), com.google.android.gms.internal.icing.eo.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.icing.dt.a(com.google.android.gms.internal.icing.eo.f(r10, r6), com.google.android.gms.internal.icing.eo.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.icing.eo.c(r10, r6) == com.google.android.gms.internal.icing.eo.c(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.icing.eo.b(r10, r6) == com.google.android.gms.internal.icing.eo.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.icing.eo.b(r10, r6) == com.google.android.gms.internal.icing.eo.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.icing.eo.b(r10, r6) == com.google.android.gms.internal.icing.eo.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.icing.eo.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.icing.eo.d(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.icing.eo.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.icing.eo.e(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.icing.dt.a(com.google.android.gms.internal.icing.eo.f(r10, r6), com.google.android.gms.internal.icing.eo.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.f10159c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.b((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.c((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.icing.eo.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.icing.eo.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.icing.dt.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.icing.eo.f(r11, r6)
            boolean r3 = com.google.android.gms.internal.icing.dt.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.icing.eo.f(r11, r6)
            boolean r3 = com.google.android.gms.internal.icing.dt.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.icing.eo.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.icing.eo.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.icing.dt.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.icing.eo.b(r10, r6)
            long r6 = com.google.android.gms.internal.icing.eo.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.icing.eo.b(r10, r6)
            long r6 = com.google.android.gms.internal.icing.eo.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.icing.eo.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.icing.eo.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.icing.dt.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.icing.eo.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.icing.eo.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.icing.dt.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.icing.eo.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.icing.eo.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.icing.dt.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.icing.eo.c(r10, r6)
            boolean r5 = com.google.android.gms.internal.icing.eo.c(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.icing.eo.b(r10, r6)
            long r6 = com.google.android.gms.internal.icing.eo.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.icing.eo.b(r10, r6)
            long r6 = com.google.android.gms.internal.icing.eo.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.icing.eo.b(r10, r6)
            long r6 = com.google.android.gms.internal.icing.eo.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.icing.eo.d(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.icing.eo.d(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.icing.eo.e(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.icing.eo.e(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.icing.ei<?, ?> r0 = r9.q
            java.lang.Object r0 = r0.a(r10)
            com.google.android.gms.internal.icing.ei<?, ?> r2 = r9.q
            java.lang.Object r2 = r2.a(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.f10164h
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.icing.bl<?> r0 = r9.r
            com.google.android.gms.internal.icing.bq r10 = r0.a((java.lang.Object) r10)
            com.google.android.gms.internal.icing.bl<?> r0 = r9.r
            com.google.android.gms.internal.icing.bq r11 = r0.a((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.di.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f10159c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.b((int) r1)
            int[] r4 = r8.f10159c
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = f(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = c(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = b(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.icing.eo.b(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.icing.eo.b(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.icing.eo.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.icing.eo.c(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.icing.eo.b(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.icing.eo.b(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.icing.eo.b(r9, r5)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.icing.eo.d(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.icing.eo.e(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.icing.bx.a((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.icing.ei<?, ?> r0 = r8.q
            java.lang.Object r0 = r0.a(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f10164h
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.icing.bl<?> r0 = r8.r
            com.google.android.gms.internal.icing.bq r9 = r0.a((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.di.a(java.lang.Object):int");
    }

    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i2 = 0; i2 < this.f10159c.length; i2 += 3) {
                int b2 = b(i2);
                long j2 = (long) (1048575 & b2);
                int i3 = this.f10159c[i2];
                switch ((b2 & 267386880) >>> 20) {
                    case 0:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.e(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 1:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.d(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 2:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 3:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 4:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 5:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 6:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 7:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.c(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 8:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.f(t2, j2));
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
                            eo.a((Object) t, j2, eo.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 11:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 12:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 13:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 14:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 15:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 16:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            eo.a((Object) t, j2, eo.b(t2, j2));
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
                        dt.a(this.s, t, t2, j2);
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
                            eo.a((Object) t, j2, eo.f(t2, j2));
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
                            eo.a((Object) t, j2, eo.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 68:
                        b(t, t2, i2);
                        break;
                }
            }
            if (!this.j) {
                dt.a(this.q, t, t2);
                if (this.f10164h) {
                    dt.a(this.r, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void a(T t, T t2, int i2) {
        long b2 = (long) (b(i2) & 1048575);
        if (a(t2, i2)) {
            Object f2 = eo.f(t, b2);
            Object f3 = eo.f(t2, b2);
            if (f2 != null && f3 != null) {
                eo.a((Object) t, b2, bx.a(f2, f3));
                b(t, i2);
            } else if (f3 != null) {
                eo.a((Object) t, b2, f3);
                b(t, i2);
            }
        }
    }

    private final void b(T t, T t2, int i2) {
        int b2 = b(i2);
        int i3 = this.f10159c[i2];
        long j2 = (long) (b2 & 1048575);
        if (a(t2, i3, i2)) {
            Object f2 = eo.f(t, j2);
            Object f3 = eo.f(t2, j2);
            if (f2 != null && f3 != null) {
                eo.a((Object) t, j2, bx.a(f2, f3));
                b(t, i3, i2);
            } else if (f3 != null) {
                eo.a((Object) t, j2, f3);
                b(t, i3, i2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0815, code lost:
        r7 = r7 + ((r4 + r10) + r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.j
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            if (r2 == 0) goto L_0x04e4
            sun.misc.Unsafe r2 = f10158b
            r6 = 0
            r7 = 0
        L_0x0012:
            int[] r8 = r0.f10159c
            int r8 = r8.length
            if (r6 >= r8) goto L_0x04dc
            int r8 = r0.b((int) r6)
            r9 = r8 & r3
            int r9 = r9 >>> 20
            int[] r10 = r0.f10159c
            r10 = r10[r6]
            r8 = r8 & r4
            long r11 = (long) r8
            com.google.android.gms.internal.icing.br r8 = com.google.android.gms.internal.icing.br.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r9 < r8) goto L_0x003d
            com.google.android.gms.internal.icing.br r8 = com.google.android.gms.internal.icing.br.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r9 > r8) goto L_0x003d
            int[] r8 = r0.f10159c
            int r13 = r6 + 2
            r8 = r8[r13]
            r8 = r8 & r4
            goto L_0x003e
        L_0x003d:
            r8 = 0
        L_0x003e:
            switch(r9) {
                case 0: goto L_0x04cc;
                case 1: goto L_0x04c0;
                case 2: goto L_0x04b0;
                case 3: goto L_0x04a0;
                case 4: goto L_0x0490;
                case 5: goto L_0x0484;
                case 6: goto L_0x0478;
                case 7: goto L_0x046c;
                case 8: goto L_0x044e;
                case 9: goto L_0x043a;
                case 10: goto L_0x0429;
                case 11: goto L_0x041a;
                case 12: goto L_0x040b;
                case 13: goto L_0x0400;
                case 14: goto L_0x03f5;
                case 15: goto L_0x03e6;
                case 16: goto L_0x03d7;
                case 17: goto L_0x03c2;
                case 18: goto L_0x03b7;
                case 19: goto L_0x03ae;
                case 20: goto L_0x03a5;
                case 21: goto L_0x039c;
                case 22: goto L_0x0393;
                case 23: goto L_0x038a;
                case 24: goto L_0x0381;
                case 25: goto L_0x0378;
                case 26: goto L_0x036f;
                case 27: goto L_0x0362;
                case 28: goto L_0x0359;
                case 29: goto L_0x0350;
                case 30: goto L_0x0346;
                case 31: goto L_0x033c;
                case 32: goto L_0x0332;
                case 33: goto L_0x0328;
                case 34: goto L_0x031e;
                case 35: goto L_0x02fe;
                case 36: goto L_0x02e1;
                case 37: goto L_0x02c4;
                case 38: goto L_0x02a7;
                case 39: goto L_0x0289;
                case 40: goto L_0x026b;
                case 41: goto L_0x024d;
                case 42: goto L_0x022f;
                case 43: goto L_0x0211;
                case 44: goto L_0x01f3;
                case 45: goto L_0x01d5;
                case 46: goto L_0x01b7;
                case 47: goto L_0x0199;
                case 48: goto L_0x017b;
                case 49: goto L_0x016d;
                case 50: goto L_0x0161;
                case 51: goto L_0x0155;
                case 52: goto L_0x0149;
                case 53: goto L_0x0139;
                case 54: goto L_0x0129;
                case 55: goto L_0x0119;
                case 56: goto L_0x010d;
                case 57: goto L_0x0101;
                case 58: goto L_0x00f5;
                case 59: goto L_0x00d7;
                case 60: goto L_0x00c3;
                case 61: goto L_0x00b1;
                case 62: goto L_0x00a1;
                case 63: goto L_0x0091;
                case 64: goto L_0x0085;
                case 65: goto L_0x0079;
                case 66: goto L_0x0069;
                case 67: goto L_0x0059;
                case 68: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x04d8
        L_0x0043:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            com.google.android.gms.internal.icing.dd r8 = (com.google.android.gms.internal.icing.dd) r8
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.icing.bf.c(r10, r8, r9)
            goto L_0x03bf
        L_0x0059:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.f((int) r10, (long) r8)
            goto L_0x03bf
        L_0x0069:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.h(r10, r8)
            goto L_0x03bf
        L_0x0079:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.h(r10)
            goto L_0x03bf
        L_0x0085:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.f((int) r10)
            goto L_0x03bf
        L_0x0091:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.i(r10, r8)
            goto L_0x03bf
        L_0x00a1:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.g(r10, r8)
            goto L_0x03bf
        L_0x00b1:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            com.google.android.gms.internal.icing.at r8 = (com.google.android.gms.internal.icing.at) r8
            int r8 = com.google.android.gms.internal.icing.bf.c((int) r10, (com.google.android.gms.internal.icing.at) r8)
            goto L_0x03bf
        L_0x00c3:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.icing.dt.a((int) r10, (java.lang.Object) r8, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x03bf
        L_0x00d7:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.icing.at
            if (r9 == 0) goto L_0x00ed
            com.google.android.gms.internal.icing.at r8 = (com.google.android.gms.internal.icing.at) r8
            int r8 = com.google.android.gms.internal.icing.bf.c((int) r10, (com.google.android.gms.internal.icing.at) r8)
            goto L_0x03bf
        L_0x00ed:
            java.lang.String r8 = (java.lang.String) r8
            int r8 = com.google.android.gms.internal.icing.bf.b((int) r10, (java.lang.String) r8)
            goto L_0x03bf
        L_0x00f5:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.k(r10)
            goto L_0x03bf
        L_0x0101:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.e((int) r10)
            goto L_0x03bf
        L_0x010d:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.g((int) r10)
            goto L_0x03bf
        L_0x0119:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.f((int) r10, (int) r8)
            goto L_0x03bf
        L_0x0129:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.e((int) r10, (long) r8)
            goto L_0x03bf
        L_0x0139:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.d((int) r10, (long) r8)
            goto L_0x03bf
        L_0x0149:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.i(r10)
            goto L_0x03bf
        L_0x0155:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.j(r10)
            goto L_0x03bf
        L_0x0161:
            com.google.android.gms.internal.icing.cw r8 = r0.s
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            int r8 = r8.c(r9)
            goto L_0x03bf
        L_0x016d:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.icing.dt.b((int) r10, (java.util.List<com.google.android.gms.internal.icing.dd>) r8, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x03bf
        L_0x017b:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.c(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x018f
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x018f:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x0199:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.g(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01ad
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01ad:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x01b7:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.i(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01cb
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01cb:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x01d5:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.h(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01e9
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01e9:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x01f3:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.d(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0207
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0207:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x0211:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.f(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0225
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0225:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x022f:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.j(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0243
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0243:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x024d:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.h(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0261
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0261:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x026b:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.i(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x027f
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x027f:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x0289:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.e(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x029d
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x029d:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x02a7:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.b(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02bb
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02bb:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x02c4:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.a((java.util.List<java.lang.Long>) r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02d8
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02d8:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x02e1:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.h(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02f5
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02f5:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
            goto L_0x031a
        L_0x02fe:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.icing.dt.i(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0312
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0312:
            int r8 = com.google.android.gms.internal.icing.bf.l(r10)
            int r10 = com.google.android.gms.internal.icing.bf.n(r9)
        L_0x031a:
            int r8 = r8 + r10
            int r8 = r8 + r9
            goto L_0x03bf
        L_0x031e:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.c(r10, r8)
            goto L_0x03bf
        L_0x0328:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.g(r10, r8)
            goto L_0x03bf
        L_0x0332:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.i(r10, r8)
            goto L_0x03bf
        L_0x033c:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.h(r10, r8)
            goto L_0x03bf
        L_0x0346:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.d(r10, r8)
            goto L_0x03bf
        L_0x0350:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.f(r10, r8)
            goto L_0x03bf
        L_0x0359:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.l(r10, r8)
            goto L_0x03bf
        L_0x0362:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.icing.dt.a((int) r10, (java.util.List<?>) r8, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x03bf
        L_0x036f:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.k(r10, r8)
            goto L_0x03bf
        L_0x0378:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.j(r10, r8)
            goto L_0x03bf
        L_0x0381:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.h(r10, r8)
            goto L_0x03bf
        L_0x038a:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.i(r10, r8)
            goto L_0x03bf
        L_0x0393:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.e(r10, r8)
            goto L_0x03bf
        L_0x039c:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.b(r10, r8)
            goto L_0x03bf
        L_0x03a5:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.a((int) r10, (java.util.List<java.lang.Long>) r8)
            goto L_0x03bf
        L_0x03ae:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.h(r10, r8)
            goto L_0x03bf
        L_0x03b7:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.dt.i(r10, r8)
        L_0x03bf:
            int r7 = r7 + r8
            goto L_0x04d8
        L_0x03c2:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            com.google.android.gms.internal.icing.dd r8 = (com.google.android.gms.internal.icing.dd) r8
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.icing.bf.c(r10, r8, r9)
            goto L_0x03bf
        L_0x03d7:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = com.google.android.gms.internal.icing.eo.b(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.f((int) r10, (long) r8)
            goto L_0x03bf
        L_0x03e6:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.bf.h(r10, r8)
            goto L_0x03bf
        L_0x03f5:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.h(r10)
            goto L_0x03bf
        L_0x0400:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.f((int) r10)
            goto L_0x03bf
        L_0x040b:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.bf.i(r10, r8)
            goto L_0x03bf
        L_0x041a:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.bf.g(r10, r8)
            goto L_0x03bf
        L_0x0429:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            com.google.android.gms.internal.icing.at r8 = (com.google.android.gms.internal.icing.at) r8
            int r8 = com.google.android.gms.internal.icing.bf.c((int) r10, (com.google.android.gms.internal.icing.at) r8)
            goto L_0x03bf
        L_0x043a:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.icing.dt.a((int) r10, (java.lang.Object) r8, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x03bf
        L_0x044e:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.icing.at
            if (r9 == 0) goto L_0x0464
            com.google.android.gms.internal.icing.at r8 = (com.google.android.gms.internal.icing.at) r8
            int r8 = com.google.android.gms.internal.icing.bf.c((int) r10, (com.google.android.gms.internal.icing.at) r8)
            goto L_0x03bf
        L_0x0464:
            java.lang.String r8 = (java.lang.String) r8
            int r8 = com.google.android.gms.internal.icing.bf.b((int) r10, (java.lang.String) r8)
            goto L_0x03bf
        L_0x046c:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.k(r10)
            goto L_0x03bf
        L_0x0478:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.e((int) r10)
            goto L_0x03bf
        L_0x0484:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.g((int) r10)
            goto L_0x03bf
        L_0x0490:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.icing.bf.f((int) r10, (int) r8)
            goto L_0x03bf
        L_0x04a0:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = com.google.android.gms.internal.icing.eo.b(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.e((int) r10, (long) r8)
            goto L_0x03bf
        L_0x04b0:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = com.google.android.gms.internal.icing.eo.b(r1, r11)
            int r8 = com.google.android.gms.internal.icing.bf.d((int) r10, (long) r8)
            goto L_0x03bf
        L_0x04c0:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.i(r10)
            goto L_0x03bf
        L_0x04cc:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.icing.bf.j(r10)
            goto L_0x03bf
        L_0x04d8:
            int r6 = r6 + 3
            goto L_0x0012
        L_0x04dc:
            com.google.android.gms.internal.icing.ei<?, ?> r2 = r0.q
            int r1 = a(r2, r1)
            int r7 = r7 + r1
            return r7
        L_0x04e4:
            sun.misc.Unsafe r2 = f10158b
            r6 = -1
            r6 = 0
            r7 = 0
            r8 = -1
            r9 = 0
        L_0x04eb:
            int[] r10 = r0.f10159c
            int r10 = r10.length
            if (r6 >= r10) goto L_0x09dc
            int r10 = r0.b((int) r6)
            int[] r11 = r0.f10159c
            r12 = r11[r6]
            r13 = r10 & r3
            int r13 = r13 >>> 20
            r14 = 17
            if (r13 > r14) goto L_0x0517
            int r14 = r6 + 2
            r11 = r11[r14]
            r14 = r11 & r4
            int r15 = r11 >>> 20
            r16 = 1
            int r15 = r16 << r15
            if (r14 == r8) goto L_0x0514
            long r8 = (long) r14
            int r9 = r2.getInt(r1, r8)
            goto L_0x0515
        L_0x0514:
            r14 = r8
        L_0x0515:
            r8 = r14
            goto L_0x0535
        L_0x0517:
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0533
            com.google.android.gms.internal.icing.br r11 = com.google.android.gms.internal.icing.br.DOUBLE_LIST_PACKED
            int r11 = r11.id()
            if (r13 < r11) goto L_0x0533
            com.google.android.gms.internal.icing.br r11 = com.google.android.gms.internal.icing.br.SINT64_LIST_PACKED
            int r11 = r11.id()
            if (r13 > r11) goto L_0x0533
            int[] r11 = r0.f10159c
            int r14 = r6 + 2
            r11 = r11[r14]
            r11 = r11 & r4
            goto L_0x0534
        L_0x0533:
            r11 = 0
        L_0x0534:
            r15 = 0
        L_0x0535:
            r10 = r10 & r4
            long r3 = (long) r10
            switch(r13) {
                case 0: goto L_0x09c9;
                case 1: goto L_0x09bf;
                case 2: goto L_0x09b1;
                case 3: goto L_0x09a3;
                case 4: goto L_0x0995;
                case 5: goto L_0x098b;
                case 6: goto L_0x0981;
                case 7: goto L_0x0977;
                case 8: goto L_0x095b;
                case 9: goto L_0x094a;
                case 10: goto L_0x093b;
                case 11: goto L_0x092e;
                case 12: goto L_0x0921;
                case 13: goto L_0x0918;
                case 14: goto L_0x090f;
                case 15: goto L_0x0902;
                case 16: goto L_0x08f5;
                case 17: goto L_0x08e2;
                case 18: goto L_0x08d5;
                case 19: goto L_0x08ca;
                case 20: goto L_0x08bf;
                case 21: goto L_0x08b4;
                case 22: goto L_0x08a9;
                case 23: goto L_0x089e;
                case 24: goto L_0x0893;
                case 25: goto L_0x0888;
                case 26: goto L_0x087d;
                case 27: goto L_0x086e;
                case 28: goto L_0x0862;
                case 29: goto L_0x0856;
                case 30: goto L_0x084a;
                case 31: goto L_0x083e;
                case 32: goto L_0x0832;
                case 33: goto L_0x0826;
                case 34: goto L_0x081a;
                case 35: goto L_0x07f9;
                case 36: goto L_0x07dc;
                case 37: goto L_0x07bf;
                case 38: goto L_0x07a2;
                case 39: goto L_0x0784;
                case 40: goto L_0x0766;
                case 41: goto L_0x0748;
                case 42: goto L_0x072a;
                case 43: goto L_0x070c;
                case 44: goto L_0x06ee;
                case 45: goto L_0x06d0;
                case 46: goto L_0x06b2;
                case 47: goto L_0x0694;
                case 48: goto L_0x0676;
                case 49: goto L_0x0666;
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
            goto L_0x09d3
        L_0x053c:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.icing.dd r3 = (com.google.android.gms.internal.icing.dd) r3
            com.google.android.gms.internal.icing.dr r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.icing.bf.c(r12, r3, r4)
            goto L_0x08df
        L_0x0552:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.f((int) r12, (long) r3)
            goto L_0x08df
        L_0x0562:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.h(r12, r3)
            goto L_0x08df
        L_0x0572:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.h(r12)
            goto L_0x08df
        L_0x057e:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.f((int) r12)
            goto L_0x08df
        L_0x058a:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.i(r12, r3)
            goto L_0x08df
        L_0x059a:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.g(r12, r3)
            goto L_0x08df
        L_0x05aa:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.icing.at r3 = (com.google.android.gms.internal.icing.at) r3
            int r3 = com.google.android.gms.internal.icing.bf.c((int) r12, (com.google.android.gms.internal.icing.at) r3)
            goto L_0x08df
        L_0x05bc:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.icing.dr r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.icing.dt.a((int) r12, (java.lang.Object) r3, (com.google.android.gms.internal.icing.dr) r4)
            goto L_0x08df
        L_0x05d0:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.icing.at
            if (r4 == 0) goto L_0x05e6
            com.google.android.gms.internal.icing.at r3 = (com.google.android.gms.internal.icing.at) r3
            int r3 = com.google.android.gms.internal.icing.bf.c((int) r12, (com.google.android.gms.internal.icing.at) r3)
            goto L_0x08df
        L_0x05e6:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.icing.bf.b((int) r12, (java.lang.String) r3)
            goto L_0x08df
        L_0x05ee:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.k(r12)
            goto L_0x08df
        L_0x05fa:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.e((int) r12)
            goto L_0x08df
        L_0x0606:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.g((int) r12)
            goto L_0x08df
        L_0x0612:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.f((int) r12, (int) r3)
            goto L_0x08df
        L_0x0622:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.e((int) r12, (long) r3)
            goto L_0x08df
        L_0x0632:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d3
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.d((int) r12, (long) r3)
            goto L_0x08df
        L_0x0642:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.i(r12)
            goto L_0x08df
        L_0x064e:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.j(r12)
            goto L_0x08df
        L_0x065a:
            com.google.android.gms.internal.icing.cw r10 = r0.s
            java.lang.Object r3 = r2.getObject(r1, r3)
            int r3 = r10.c(r3)
            goto L_0x08df
        L_0x0666:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.icing.dr r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.icing.dt.b((int) r12, (java.util.List<com.google.android.gms.internal.icing.dd>) r3, (com.google.android.gms.internal.icing.dr) r4)
            goto L_0x08df
        L_0x0676:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.c(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x068a
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x068a:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x0694:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.g(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06a8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06a8:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x06b2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.i(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06c6
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06c6:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x06d0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.h(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06e4
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06e4:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x06ee:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.d(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0702
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0702:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x070c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.f(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0720
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0720:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x072a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.j(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x073e
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x073e:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x0748:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.h(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x075c
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x075c:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x0766:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.i(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x077a
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x077a:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x0784:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.e(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0798
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0798:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x07a2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.b(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07b6
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07b6:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x07bf:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.a((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07d3
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07d3:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x07dc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.h(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07f0
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07f0:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
            goto L_0x0815
        L_0x07f9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.i(r3)
            if (r3 <= 0) goto L_0x09d3
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x080d
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x080d:
            int r4 = com.google.android.gms.internal.icing.bf.l(r12)
            int r10 = com.google.android.gms.internal.icing.bf.n(r3)
        L_0x0815:
            int r4 = r4 + r10
            int r4 = r4 + r3
            int r7 = r7 + r4
            goto L_0x09d3
        L_0x081a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.c(r12, r3)
            goto L_0x08df
        L_0x0826:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.g(r12, r3)
            goto L_0x08df
        L_0x0832:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.i(r12, r3)
            goto L_0x08df
        L_0x083e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.h(r12, r3)
            goto L_0x08df
        L_0x084a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.d(r12, r3)
            goto L_0x08df
        L_0x0856:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.f(r12, r3)
            goto L_0x08df
        L_0x0862:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.l(r12, r3)
            goto L_0x08df
        L_0x086e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.icing.dr r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.icing.dt.a((int) r12, (java.util.List<?>) r3, (com.google.android.gms.internal.icing.dr) r4)
            goto L_0x08df
        L_0x087d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.k(r12, r3)
            goto L_0x08df
        L_0x0888:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.j(r12, r3)
            goto L_0x08df
        L_0x0893:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.h(r12, r3)
            goto L_0x08df
        L_0x089e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.i(r12, r3)
            goto L_0x08df
        L_0x08a9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.e(r12, r3)
            goto L_0x08df
        L_0x08b4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.b(r12, r3)
            goto L_0x08df
        L_0x08bf:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.a((int) r12, (java.util.List<java.lang.Long>) r3)
            goto L_0x08df
        L_0x08ca:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.h(r12, r3)
            goto L_0x08df
        L_0x08d5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.icing.dt.i(r12, r3)
        L_0x08df:
            int r7 = r7 + r3
            goto L_0x09d3
        L_0x08e2:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.icing.dd r3 = (com.google.android.gms.internal.icing.dd) r3
            com.google.android.gms.internal.icing.dr r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.icing.bf.c(r12, r3, r4)
            goto L_0x08df
        L_0x08f5:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.f((int) r12, (long) r3)
            goto L_0x08df
        L_0x0902:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.h(r12, r3)
            goto L_0x08df
        L_0x090f:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.h(r12)
            goto L_0x08df
        L_0x0918:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.f((int) r12)
            goto L_0x08df
        L_0x0921:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.i(r12, r3)
            goto L_0x08df
        L_0x092e:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.g(r12, r3)
            goto L_0x08df
        L_0x093b:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.icing.at r3 = (com.google.android.gms.internal.icing.at) r3
            int r3 = com.google.android.gms.internal.icing.bf.c((int) r12, (com.google.android.gms.internal.icing.at) r3)
            goto L_0x08df
        L_0x094a:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.icing.dr r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.icing.dt.a((int) r12, (java.lang.Object) r3, (com.google.android.gms.internal.icing.dr) r4)
            goto L_0x08df
        L_0x095b:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.icing.at
            if (r4 == 0) goto L_0x096f
            com.google.android.gms.internal.icing.at r3 = (com.google.android.gms.internal.icing.at) r3
            int r3 = com.google.android.gms.internal.icing.bf.c((int) r12, (com.google.android.gms.internal.icing.at) r3)
            goto L_0x08df
        L_0x096f:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.icing.bf.b((int) r12, (java.lang.String) r3)
            goto L_0x08df
        L_0x0977:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.k(r12)
            goto L_0x08df
        L_0x0981:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.e((int) r12)
            goto L_0x08df
        L_0x098b:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.g((int) r12)
            goto L_0x08df
        L_0x0995:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.f((int) r12, (int) r3)
            goto L_0x08df
        L_0x09a3:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.e((int) r12, (long) r3)
            goto L_0x08df
        L_0x09b1:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d3
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.icing.bf.d((int) r12, (long) r3)
            goto L_0x08df
        L_0x09bf:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.i(r12)
            goto L_0x08df
        L_0x09c9:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d3
            int r3 = com.google.android.gms.internal.icing.bf.j(r12)
            goto L_0x08df
        L_0x09d3:
            int r6 = r6 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x04eb
        L_0x09dc:
            com.google.android.gms.internal.icing.ei<?, ?> r2 = r0.q
            int r2 = a(r2, r1)
            int r7 = r7 + r2
            boolean r2 = r0.f10164h
            if (r2 == 0) goto L_0x0a35
            com.google.android.gms.internal.icing.bl<?> r2 = r0.r
            com.google.android.gms.internal.icing.bq r1 = r2.a((java.lang.Object) r1)
            r2 = 0
        L_0x09ee:
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r3 = r1.f10100a
            int r3 = r3.b()
            if (r5 >= r3) goto L_0x0a0e
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r3 = r1.f10100a
            java.util.Map$Entry r3 = r3.b((int) r5)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.icing.bs r4 = (com.google.android.gms.internal.icing.bs) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.icing.bq.a((com.google.android.gms.internal.icing.bs<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r5 = r5 + 1
            goto L_0x09ee
        L_0x0a0e:
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r1 = r1.f10100a
            java.lang.Iterable r1 = r1.c()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a18:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a34
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.icing.bs r4 = (com.google.android.gms.internal.icing.bs) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.icing.bq.a((com.google.android.gms.internal.icing.bs<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a18
        L_0x0a34:
            int r7 = r7 + r2
        L_0x0a35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.di.d(java.lang.Object):int");
    }

    private static <UT, UB> int a(ei<UT, UB> eiVar, T t) {
        return eiVar.d(eiVar.a(t));
    }

    private static List<?> a(Object obj, long j2) {
        return (List) eo.f(obj, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a46  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r14, com.google.android.gms.internal.icing.fc r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.a()
            int r1 = com.google.android.gms.internal.icing.bv.c.k
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0544
            com.google.android.gms.internal.icing.ei<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.icing.fc) r15)
            boolean r0 = r13.f10164h
            if (r0 == 0) goto L_0x004d
            com.google.android.gms.internal.icing.bl<?> r0 = r13.r
            com.google.android.gms.internal.icing.bq r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r1 = r0.f10100a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x004d
            boolean r1 = r0.f10102c
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.icing.cj r1 = new com.google.android.gms.internal.icing.cj
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r0 = r0.f10100a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            r1.<init>(r0)
            r0 = r1
            goto L_0x0046
        L_0x003c:
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r0 = r0.f10100a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x004f
        L_0x004d:
            r0 = r3
            r1 = r0
        L_0x004f:
            int[] r7 = r13.f10159c
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0054:
            if (r7 < 0) goto L_0x052c
            int r8 = r13.b((int) r7)
            int[] r9 = r13.f10159c
            r9 = r9[r7]
        L_0x005e:
            if (r1 == 0) goto L_0x007c
            com.google.android.gms.internal.icing.bl<?> r10 = r13.r
            int r10 = r10.a((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x007c
            com.google.android.gms.internal.icing.bl<?> r10 = r13.r
            r10.b((java.util.Map.Entry<?, ?>) r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x005e
        L_0x007a:
            r1 = r3
            goto L_0x005e
        L_0x007c:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0519;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f9;
                case 3: goto L_0x04e9;
                case 4: goto L_0x04d9;
                case 5: goto L_0x04c9;
                case 6: goto L_0x04b9;
                case 7: goto L_0x04a8;
                case 8: goto L_0x0497;
                case 9: goto L_0x0482;
                case 10: goto L_0x046f;
                case 11: goto L_0x045e;
                case 12: goto L_0x044d;
                case 13: goto L_0x043c;
                case 14: goto L_0x042b;
                case 15: goto L_0x041a;
                case 16: goto L_0x0409;
                case 17: goto L_0x03f4;
                case 18: goto L_0x03e3;
                case 19: goto L_0x03d2;
                case 20: goto L_0x03c1;
                case 21: goto L_0x03b0;
                case 22: goto L_0x039f;
                case 23: goto L_0x038e;
                case 24: goto L_0x037d;
                case 25: goto L_0x036c;
                case 26: goto L_0x035b;
                case 27: goto L_0x0346;
                case 28: goto L_0x0335;
                case 29: goto L_0x0324;
                case 30: goto L_0x0313;
                case 31: goto L_0x0302;
                case 32: goto L_0x02f1;
                case 33: goto L_0x02e0;
                case 34: goto L_0x02cf;
                case 35: goto L_0x02be;
                case 36: goto L_0x02ad;
                case 37: goto L_0x029c;
                case 38: goto L_0x028b;
                case 39: goto L_0x027a;
                case 40: goto L_0x0269;
                case 41: goto L_0x0258;
                case 42: goto L_0x0247;
                case 43: goto L_0x0236;
                case 44: goto L_0x0225;
                case 45: goto L_0x0214;
                case 46: goto L_0x0203;
                case 47: goto L_0x01f2;
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
                case 62: goto L_0x00ef;
                case 63: goto L_0x00de;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bc;
                case 66: goto L_0x00ab;
                case 67: goto L_0x009a;
                case 68: goto L_0x0085;
                default: goto L_0x0083;
            }
        L_0x0083:
            goto L_0x0528
        L_0x0085:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            com.google.android.gms.internal.icing.dr r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.icing.dr) r10)
            goto L_0x0528
        L_0x009a:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.e((int) r9, (long) r10)
            goto L_0x0528
        L_0x00ab:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.f(r9, r8)
            goto L_0x0528
        L_0x00bc:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.b((int) r9, (long) r10)
            goto L_0x0528
        L_0x00cd:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.a((int) r9, (int) r8)
            goto L_0x0528
        L_0x00de:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.b((int) r9, (int) r8)
            goto L_0x0528
        L_0x00ef:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.e((int) r9, (int) r8)
            goto L_0x0528
        L_0x0100:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            com.google.android.gms.internal.icing.at r8 = (com.google.android.gms.internal.icing.at) r8
            r15.a((int) r9, (com.google.android.gms.internal.icing.at) r8)
            goto L_0x0528
        L_0x0113:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            com.google.android.gms.internal.icing.dr r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.icing.dr) r10)
            goto L_0x0528
        L_0x0128:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0528
        L_0x0139:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = f(r14, r10)
            r15.a((int) r9, (boolean) r8)
            goto L_0x0528
        L_0x014a:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.d((int) r9, (int) r8)
            goto L_0x0528
        L_0x015b:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.d((int) r9, (long) r10)
            goto L_0x0528
        L_0x016c:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.c((int) r9, (int) r8)
            goto L_0x0528
        L_0x017d:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.c((int) r9, (long) r10)
            goto L_0x0528
        L_0x018e:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.a((int) r9, (long) r10)
            goto L_0x0528
        L_0x019f:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = c(r14, r10)
            r15.a((int) r9, (float) r8)
            goto L_0x0528
        L_0x01b0:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = b(r14, (long) r10)
            r15.a((int) r9, (double) r10)
            goto L_0x0528
        L_0x01c1:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            r13.a((com.google.android.gms.internal.icing.fc) r15, (int) r9, (java.lang.Object) r8)
            goto L_0x0528
        L_0x01cc:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dr r10 = r13.a((int) r7)
            com.google.android.gms.internal.icing.dt.b((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.icing.fc) r15, (com.google.android.gms.internal.icing.dr) r10)
            goto L_0x0528
        L_0x01e1:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.e(r9, r8, r15, r4)
            goto L_0x0528
        L_0x01f2:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.j(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0203:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.g(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0214:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.l(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0225:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.m(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0236:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.i(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0247:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.n(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0258:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.k(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0269:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.f(r9, r8, r15, r4)
            goto L_0x0528
        L_0x027a:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.h(r9, r8, r15, r4)
            goto L_0x0528
        L_0x028b:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.d(r9, r8, r15, r4)
            goto L_0x0528
        L_0x029c:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.c(r9, r8, r15, r4)
            goto L_0x0528
        L_0x02ad:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.icing.fc) r15, (boolean) r4)
            goto L_0x0528
        L_0x02be:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.icing.fc) r15, (boolean) r4)
            goto L_0x0528
        L_0x02cf:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.e(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02e0:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.j(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02f1:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.g(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0302:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.l(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0313:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.m(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0324:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.i(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0335:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.b((int) r9, (java.util.List<com.google.android.gms.internal.icing.at>) r8, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0528
        L_0x0346:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dr r10 = r13.a((int) r7)
            com.google.android.gms.internal.icing.dt.a((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.icing.fc) r15, (com.google.android.gms.internal.icing.dr) r10)
            goto L_0x0528
        L_0x035b:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.a((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0528
        L_0x036c:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.n(r9, r8, r15, r5)
            goto L_0x0528
        L_0x037d:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.k(r9, r8, r15, r5)
            goto L_0x0528
        L_0x038e:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.f(r9, r8, r15, r5)
            goto L_0x0528
        L_0x039f:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.h(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03b0:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.d(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03c1:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.c(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03d2:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.icing.fc) r15, (boolean) r5)
            goto L_0x0528
        L_0x03e3:
            int[] r9 = r13.f10159c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.icing.dt.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.icing.fc) r15, (boolean) r5)
            goto L_0x0528
        L_0x03f4:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            com.google.android.gms.internal.icing.dr r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.icing.dr) r10)
            goto L_0x0528
        L_0x0409:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.icing.eo.b(r14, r10)
            r15.e((int) r9, (long) r10)
            goto L_0x0528
        L_0x041a:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r10)
            r15.f(r9, r8)
            goto L_0x0528
        L_0x042b:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.icing.eo.b(r14, r10)
            r15.b((int) r9, (long) r10)
            goto L_0x0528
        L_0x043c:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r10)
            r15.a((int) r9, (int) r8)
            goto L_0x0528
        L_0x044d:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r10)
            r15.b((int) r9, (int) r8)
            goto L_0x0528
        L_0x045e:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r10)
            r15.e((int) r9, (int) r8)
            goto L_0x0528
        L_0x046f:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            com.google.android.gms.internal.icing.at r8 = (com.google.android.gms.internal.icing.at) r8
            r15.a((int) r9, (com.google.android.gms.internal.icing.at) r8)
            goto L_0x0528
        L_0x0482:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            com.google.android.gms.internal.icing.dr r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.icing.dr) r10)
            goto L_0x0528
        L_0x0497:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.icing.eo.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0528
        L_0x04a8:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.icing.eo.c(r14, r10)
            r15.a((int) r9, (boolean) r8)
            goto L_0x0528
        L_0x04b9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r10)
            r15.d((int) r9, (int) r8)
            goto L_0x0528
        L_0x04c9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.icing.eo.b(r14, r10)
            r15.d((int) r9, (long) r10)
            goto L_0x0528
        L_0x04d9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r10)
            r15.c((int) r9, (int) r8)
            goto L_0x0528
        L_0x04e9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.icing.eo.b(r14, r10)
            r15.c((int) r9, (long) r10)
            goto L_0x0528
        L_0x04f9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.icing.eo.b(r14, r10)
            r15.a((int) r9, (long) r10)
            goto L_0x0528
        L_0x0509:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.icing.eo.d(r14, r10)
            r15.a((int) r9, (float) r8)
            goto L_0x0528
        L_0x0519:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.icing.eo.e(r14, r10)
            r15.a((int) r9, (double) r10)
        L_0x0528:
            int r7 = r7 + -3
            goto L_0x0054
        L_0x052c:
            if (r1 == 0) goto L_0x0543
            com.google.android.gms.internal.icing.bl<?> r14 = r13.r
            r14.b((java.util.Map.Entry<?, ?>) r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0541
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x052c
        L_0x0541:
            r1 = r3
            goto L_0x052c
        L_0x0543:
            return
        L_0x0544:
            boolean r0 = r13.j
            if (r0 == 0) goto L_0x0a61
            boolean r0 = r13.f10164h
            if (r0 == 0) goto L_0x0565
            com.google.android.gms.internal.icing.bl<?> r0 = r13.r
            com.google.android.gms.internal.icing.bq r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r1 = r0.f10100a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0565
            java.util.Iterator r0 = r0.c()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0567
        L_0x0565:
            r0 = r3
            r1 = r0
        L_0x0567:
            int[] r7 = r13.f10159c
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x056c:
            if (r1 >= r7) goto L_0x0a44
            int r9 = r13.b((int) r1)
            int[] r10 = r13.f10159c
            r10 = r10[r1]
        L_0x0576:
            if (r8 == 0) goto L_0x0594
            com.google.android.gms.internal.icing.bl<?> r11 = r13.r
            int r11 = r11.a((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0594
            com.google.android.gms.internal.icing.bl<?> r11 = r13.r
            r11.b((java.util.Map.Entry<?, ?>) r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0592
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x0576
        L_0x0592:
            r8 = r3
            goto L_0x0576
        L_0x0594:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a31;
                case 1: goto L_0x0a21;
                case 2: goto L_0x0a11;
                case 3: goto L_0x0a01;
                case 4: goto L_0x09f1;
                case 5: goto L_0x09e1;
                case 6: goto L_0x09d1;
                case 7: goto L_0x09c0;
                case 8: goto L_0x09af;
                case 9: goto L_0x099a;
                case 10: goto L_0x0987;
                case 11: goto L_0x0976;
                case 12: goto L_0x0965;
                case 13: goto L_0x0954;
                case 14: goto L_0x0943;
                case 15: goto L_0x0932;
                case 16: goto L_0x0921;
                case 17: goto L_0x090c;
                case 18: goto L_0x08fb;
                case 19: goto L_0x08ea;
                case 20: goto L_0x08d9;
                case 21: goto L_0x08c8;
                case 22: goto L_0x08b7;
                case 23: goto L_0x08a6;
                case 24: goto L_0x0895;
                case 25: goto L_0x0884;
                case 26: goto L_0x0873;
                case 27: goto L_0x085e;
                case 28: goto L_0x084d;
                case 29: goto L_0x083c;
                case 30: goto L_0x082b;
                case 31: goto L_0x081a;
                case 32: goto L_0x0809;
                case 33: goto L_0x07f8;
                case 34: goto L_0x07e7;
                case 35: goto L_0x07d6;
                case 36: goto L_0x07c5;
                case 37: goto L_0x07b4;
                case 38: goto L_0x07a3;
                case 39: goto L_0x0792;
                case 40: goto L_0x0781;
                case 41: goto L_0x0770;
                case 42: goto L_0x075f;
                case 43: goto L_0x074e;
                case 44: goto L_0x073d;
                case 45: goto L_0x072c;
                case 46: goto L_0x071b;
                case 47: goto L_0x070a;
                case 48: goto L_0x06f9;
                case 49: goto L_0x06e4;
                case 50: goto L_0x06d9;
                case 51: goto L_0x06c8;
                case 52: goto L_0x06b7;
                case 53: goto L_0x06a6;
                case 54: goto L_0x0695;
                case 55: goto L_0x0684;
                case 56: goto L_0x0673;
                case 57: goto L_0x0662;
                case 58: goto L_0x0651;
                case 59: goto L_0x0640;
                case 60: goto L_0x062b;
                case 61: goto L_0x0618;
                case 62: goto L_0x0607;
                case 63: goto L_0x05f6;
                case 64: goto L_0x05e5;
                case 65: goto L_0x05d4;
                case 66: goto L_0x05c3;
                case 67: goto L_0x05b2;
                case 68: goto L_0x059d;
                default: goto L_0x059b;
            }
        L_0x059b:
            goto L_0x0a40
        L_0x059d:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            com.google.android.gms.internal.icing.dr r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.icing.dr) r11)
            goto L_0x0a40
        L_0x05b2:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.e((int) r10, (long) r11)
            goto L_0x0a40
        L_0x05c3:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.f(r10, r9)
            goto L_0x0a40
        L_0x05d4:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.b((int) r10, (long) r11)
            goto L_0x0a40
        L_0x05e5:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.a((int) r10, (int) r9)
            goto L_0x0a40
        L_0x05f6:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.b((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0607:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.e((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0618:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            com.google.android.gms.internal.icing.at r9 = (com.google.android.gms.internal.icing.at) r9
            r15.a((int) r10, (com.google.android.gms.internal.icing.at) r9)
            goto L_0x0a40
        L_0x062b:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            com.google.android.gms.internal.icing.dr r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.icing.dr) r11)
            goto L_0x0a40
        L_0x0640:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0a40
        L_0x0651:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = f(r14, r11)
            r15.a((int) r10, (boolean) r9)
            goto L_0x0a40
        L_0x0662:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.d((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0673:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.d((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0684:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.c((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0695:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.c((int) r10, (long) r11)
            goto L_0x0a40
        L_0x06a6:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.a((int) r10, (long) r11)
            goto L_0x0a40
        L_0x06b7:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = c(r14, r11)
            r15.a((int) r10, (float) r9)
            goto L_0x0a40
        L_0x06c8:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = b(r14, (long) r11)
            r15.a((int) r10, (double) r11)
            goto L_0x0a40
        L_0x06d9:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            r13.a((com.google.android.gms.internal.icing.fc) r15, (int) r10, (java.lang.Object) r9)
            goto L_0x0a40
        L_0x06e4:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dr r11 = r13.a((int) r1)
            com.google.android.gms.internal.icing.dt.b((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.icing.fc) r15, (com.google.android.gms.internal.icing.dr) r11)
            goto L_0x0a40
        L_0x06f9:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.e(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x070a:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.j(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x071b:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.g(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x072c:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.l(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x073d:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.m(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x074e:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.i(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x075f:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.n(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0770:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.k(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0781:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.f(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0792:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.h(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07a3:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.d(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07b4:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.c(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07c5:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.icing.fc) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07d6:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.icing.fc) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07e7:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.e(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x07f8:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.j(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0809:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.g(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x081a:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.l(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x082b:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.m(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x083c:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.i(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x084d:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.b((int) r10, (java.util.List<com.google.android.gms.internal.icing.at>) r9, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0a40
        L_0x085e:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dr r11 = r13.a((int) r1)
            com.google.android.gms.internal.icing.dt.a((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.icing.fc) r15, (com.google.android.gms.internal.icing.dr) r11)
            goto L_0x0a40
        L_0x0873:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.a((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0a40
        L_0x0884:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.n(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0895:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.k(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08a6:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.f(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08b7:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.h(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08c8:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.d(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08d9:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.c(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08ea:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.icing.fc) r15, (boolean) r5)
            goto L_0x0a40
        L_0x08fb:
            int[] r10 = r13.f10159c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.icing.fc) r15, (boolean) r5)
            goto L_0x0a40
        L_0x090c:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            com.google.android.gms.internal.icing.dr r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.icing.dr) r11)
            goto L_0x0a40
        L_0x0921:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.icing.eo.b(r14, r11)
            r15.e((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0932:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r11)
            r15.f(r10, r9)
            goto L_0x0a40
        L_0x0943:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.icing.eo.b(r14, r11)
            r15.b((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0954:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r11)
            r15.a((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0965:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r11)
            r15.b((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0976:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r11)
            r15.e((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0987:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            com.google.android.gms.internal.icing.at r9 = (com.google.android.gms.internal.icing.at) r9
            r15.a((int) r10, (com.google.android.gms.internal.icing.at) r9)
            goto L_0x0a40
        L_0x099a:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            com.google.android.gms.internal.icing.dr r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.icing.dr) r11)
            goto L_0x0a40
        L_0x09af:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.icing.eo.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.icing.fc) r15)
            goto L_0x0a40
        L_0x09c0:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.icing.eo.c(r14, r11)
            r15.a((int) r10, (boolean) r9)
            goto L_0x0a40
        L_0x09d1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r11)
            r15.d((int) r10, (int) r9)
            goto L_0x0a40
        L_0x09e1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.icing.eo.b(r14, r11)
            r15.d((int) r10, (long) r11)
            goto L_0x0a40
        L_0x09f1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.icing.eo.a((java.lang.Object) r14, (long) r11)
            r15.c((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0a01:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.icing.eo.b(r14, r11)
            r15.c((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a11:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.icing.eo.b(r14, r11)
            r15.a((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a21:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.icing.eo.d(r14, r11)
            r15.a((int) r10, (float) r9)
            goto L_0x0a40
        L_0x0a31:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.icing.eo.e(r14, r11)
            r15.a((int) r10, (double) r11)
        L_0x0a40:
            int r1 = r1 + 3
            goto L_0x056c
        L_0x0a44:
            if (r8 == 0) goto L_0x0a5b
            com.google.android.gms.internal.icing.bl<?> r1 = r13.r
            r1.b((java.util.Map.Entry<?, ?>) r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a59
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a44
        L_0x0a59:
            r8 = r3
            goto L_0x0a44
        L_0x0a5b:
            com.google.android.gms.internal.icing.ei<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.icing.fc) r15)
            return
        L_0x0a61:
            r13.b(r14, (com.google.android.gms.internal.icing.fc) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.di.a(java.lang.Object, com.google.android.gms.internal.icing.fc):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(T r19, com.google.android.gms.internal.icing.fc r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.f10164h
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.icing.bl<?> r3 = r0.r
            com.google.android.gms.internal.icing.bq r3 = r3.a((java.lang.Object) r1)
            com.google.android.gms.internal.icing.dw<FieldDescriptorType, java.lang.Object> r5 = r3.f10100a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.c()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.f10159c
            int r7 = r7.length
            sun.misc.Unsafe r8 = f10158b
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x04ad
            int r12 = r0.b((int) r5)
            int[] r13 = r0.f10159c
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.j
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0062
            r4 = 17
            if (r15 > r4) goto L_0x0062
            int r4 = r5 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0058
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            goto L_0x0059
        L_0x0058:
            r13 = r6
        L_0x0059:
            int r4 = r4 >>> 20
            r6 = 1
            int r9 = r6 << r4
            r6 = r13
            r10 = r17
            goto L_0x0067
        L_0x0062:
            r17 = r10
            r10 = r17
            r9 = 0
        L_0x0067:
            if (r10 == 0) goto L_0x0086
            com.google.android.gms.internal.icing.bl<?> r4 = r0.r
            int r4 = r4.a((java.util.Map.Entry<?, ?>) r10)
            if (r4 > r14) goto L_0x0086
            com.google.android.gms.internal.icing.bl<?> r4 = r0.r
            r4.b((java.util.Map.Entry<?, ?>) r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0067
        L_0x0084:
            r10 = 0
            goto L_0x0067
        L_0x0086:
            r4 = r12 & r16
            long r12 = (long) r4
            switch(r15) {
                case 0: goto L_0x049d;
                case 1: goto L_0x0490;
                case 2: goto L_0x0483;
                case 3: goto L_0x0476;
                case 4: goto L_0x0469;
                case 5: goto L_0x045c;
                case 6: goto L_0x044f;
                case 7: goto L_0x0442;
                case 8: goto L_0x0434;
                case 9: goto L_0x0422;
                case 10: goto L_0x0412;
                case 11: goto L_0x0404;
                case 12: goto L_0x03f6;
                case 13: goto L_0x03e8;
                case 14: goto L_0x03da;
                case 15: goto L_0x03cc;
                case 16: goto L_0x03be;
                case 17: goto L_0x03ac;
                case 18: goto L_0x039c;
                case 19: goto L_0x038c;
                case 20: goto L_0x037c;
                case 21: goto L_0x036c;
                case 22: goto L_0x035c;
                case 23: goto L_0x034c;
                case 24: goto L_0x033c;
                case 25: goto L_0x032c;
                case 26: goto L_0x031d;
                case 27: goto L_0x030a;
                case 28: goto L_0x02fb;
                case 29: goto L_0x02eb;
                case 30: goto L_0x02db;
                case 31: goto L_0x02cb;
                case 32: goto L_0x02bb;
                case 33: goto L_0x02ab;
                case 34: goto L_0x029b;
                case 35: goto L_0x028b;
                case 36: goto L_0x027b;
                case 37: goto L_0x026b;
                case 38: goto L_0x025b;
                case 39: goto L_0x024b;
                case 40: goto L_0x023b;
                case 41: goto L_0x022b;
                case 42: goto L_0x021b;
                case 43: goto L_0x020b;
                case 44: goto L_0x01fb;
                case 45: goto L_0x01eb;
                case 46: goto L_0x01db;
                case 47: goto L_0x01cb;
                case 48: goto L_0x01bb;
                case 49: goto L_0x01a8;
                case 50: goto L_0x019f;
                case 51: goto L_0x0190;
                case 52: goto L_0x0181;
                case 53: goto L_0x0172;
                case 54: goto L_0x0163;
                case 55: goto L_0x0154;
                case 56: goto L_0x0145;
                case 57: goto L_0x0136;
                case 58: goto L_0x0127;
                case 59: goto L_0x0118;
                case 60: goto L_0x0105;
                case 61: goto L_0x00f5;
                case 62: goto L_0x00e7;
                case 63: goto L_0x00d9;
                case 64: goto L_0x00cb;
                case 65: goto L_0x00bd;
                case 66: goto L_0x00af;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x008c;
            }
        L_0x008c:
            r15 = 0
            goto L_0x04a9
        L_0x008f:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r5)
            r2.b((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x008c
        L_0x00a1:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.e((int) r14, (long) r12)
            goto L_0x008c
        L_0x00af:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.f(r14, r4)
            goto L_0x008c
        L_0x00bd:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.b((int) r14, (long) r12)
            goto L_0x008c
        L_0x00cb:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.a((int) r14, (int) r4)
            goto L_0x008c
        L_0x00d9:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.b((int) r14, (int) r4)
            goto L_0x008c
        L_0x00e7:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.e((int) r14, (int) r4)
            goto L_0x008c
        L_0x00f5:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.icing.at r4 = (com.google.android.gms.internal.icing.at) r4
            r2.a((int) r14, (com.google.android.gms.internal.icing.at) r4)
            goto L_0x008c
        L_0x0105:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r5)
            r2.a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x008c
        L_0x0118:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.getObject(r1, r12)
            a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.icing.fc) r2)
            goto L_0x008c
        L_0x0127:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            boolean r4 = f(r1, r12)
            r2.a((int) r14, (boolean) r4)
            goto L_0x008c
        L_0x0136:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.d((int) r14, (int) r4)
            goto L_0x008c
        L_0x0145:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.d((int) r14, (long) r12)
            goto L_0x008c
        L_0x0154:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            int r4 = d(r1, r12)
            r2.c((int) r14, (int) r4)
            goto L_0x008c
        L_0x0163:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.c((int) r14, (long) r12)
            goto L_0x008c
        L_0x0172:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            long r12 = e(r1, r12)
            r2.a((int) r14, (long) r12)
            goto L_0x008c
        L_0x0181:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            float r4 = c(r1, r12)
            r2.a((int) r14, (float) r4)
            goto L_0x008c
        L_0x0190:
            boolean r4 = r0.a(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008c
            double r12 = b(r1, (long) r12)
            r2.a((int) r14, (double) r12)
            goto L_0x008c
        L_0x019f:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.a((com.google.android.gms.internal.icing.fc) r2, (int) r14, (java.lang.Object) r4)
            goto L_0x008c
        L_0x01a8:
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dr r12 = r0.a((int) r5)
            com.google.android.gms.internal.icing.dt.b((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.icing.fc) r2, (com.google.android.gms.internal.icing.dr) r12)
            goto L_0x008c
        L_0x01bb:
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            com.google.android.gms.internal.icing.dt.e(r4, r9, r2, r14)
            goto L_0x008c
        L_0x01cb:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.j(r4, r9, r2, r14)
            goto L_0x008c
        L_0x01db:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.g(r4, r9, r2, r14)
            goto L_0x008c
        L_0x01eb:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.l(r4, r9, r2, r14)
            goto L_0x008c
        L_0x01fb:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.m(r4, r9, r2, r14)
            goto L_0x008c
        L_0x020b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.i(r4, r9, r2, r14)
            goto L_0x008c
        L_0x021b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.n(r4, r9, r2, r14)
            goto L_0x008c
        L_0x022b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.k(r4, r9, r2, r14)
            goto L_0x008c
        L_0x023b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.f(r4, r9, r2, r14)
            goto L_0x008c
        L_0x024b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.h(r4, r9, r2, r14)
            goto L_0x008c
        L_0x025b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.d(r4, r9, r2, r14)
            goto L_0x008c
        L_0x026b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.c(r4, r9, r2, r14)
            goto L_0x008c
        L_0x027b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.icing.fc) r2, (boolean) r14)
            goto L_0x008c
        L_0x028b:
            r14 = 1
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.icing.fc) r2, (boolean) r14)
            goto L_0x008c
        L_0x029b:
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
            com.google.android.gms.internal.icing.dt.e(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02ab:
            r14 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.j(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02bb:
            r14 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.g(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02cb:
            r14 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.l(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02db:
            r14 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.m(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02eb:
            r14 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.i(r4, r9, r2, r14)
            goto L_0x008c
        L_0x02fb:
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.b((int) r4, (java.util.List<com.google.android.gms.internal.icing.at>) r9, (com.google.android.gms.internal.icing.fc) r2)
            goto L_0x008c
        L_0x030a:
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dr r12 = r0.a((int) r5)
            com.google.android.gms.internal.icing.dt.a((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.icing.fc) r2, (com.google.android.gms.internal.icing.dr) r12)
            goto L_0x008c
        L_0x031d:
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.a((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.icing.fc) r2)
            goto L_0x008c
        L_0x032c:
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.icing.dt.n(r4, r9, r2, r15)
            goto L_0x04a9
        L_0x033c:
            r15 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.k(r4, r9, r2, r15)
            goto L_0x04a9
        L_0x034c:
            r15 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.f(r4, r9, r2, r15)
            goto L_0x04a9
        L_0x035c:
            r15 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.h(r4, r9, r2, r15)
            goto L_0x04a9
        L_0x036c:
            r15 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.d(r4, r9, r2, r15)
            goto L_0x04a9
        L_0x037c:
            r15 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.c(r4, r9, r2, r15)
            goto L_0x04a9
        L_0x038c:
            r15 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.icing.fc) r2, (boolean) r15)
            goto L_0x04a9
        L_0x039c:
            r15 = 0
            int[] r4 = r0.f10159c
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.icing.dt.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.icing.fc) r2, (boolean) r15)
            goto L_0x04a9
        L_0x03ac:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r5)
            r2.b((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x04a9
        L_0x03be:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            long r12 = r8.getLong(r1, r12)
            r2.e((int) r14, (long) r12)
            goto L_0x04a9
        L_0x03cc:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            int r4 = r8.getInt(r1, r12)
            r2.f(r14, r4)
            goto L_0x04a9
        L_0x03da:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            long r12 = r8.getLong(r1, r12)
            r2.b((int) r14, (long) r12)
            goto L_0x04a9
        L_0x03e8:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            int r4 = r8.getInt(r1, r12)
            r2.a((int) r14, (int) r4)
            goto L_0x04a9
        L_0x03f6:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            int r4 = r8.getInt(r1, r12)
            r2.b((int) r14, (int) r4)
            goto L_0x04a9
        L_0x0404:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            int r4 = r8.getInt(r1, r12)
            r2.e((int) r14, (int) r4)
            goto L_0x04a9
        L_0x0412:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.icing.at r4 = (com.google.android.gms.internal.icing.at) r4
            r2.a((int) r14, (com.google.android.gms.internal.icing.at) r4)
            goto L_0x04a9
        L_0x0422:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.icing.dr r9 = r0.a((int) r5)
            r2.a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.icing.dr) r9)
            goto L_0x04a9
        L_0x0434:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r8.getObject(r1, r12)
            a((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.icing.fc) r2)
            goto L_0x04a9
        L_0x0442:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            boolean r4 = com.google.android.gms.internal.icing.eo.c(r1, r12)
            r2.a((int) r14, (boolean) r4)
            goto L_0x04a9
        L_0x044f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            int r4 = r8.getInt(r1, r12)
            r2.d((int) r14, (int) r4)
            goto L_0x04a9
        L_0x045c:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            long r12 = r8.getLong(r1, r12)
            r2.d((int) r14, (long) r12)
            goto L_0x04a9
        L_0x0469:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            int r4 = r8.getInt(r1, r12)
            r2.c((int) r14, (int) r4)
            goto L_0x04a9
        L_0x0476:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            long r12 = r8.getLong(r1, r12)
            r2.c((int) r14, (long) r12)
            goto L_0x04a9
        L_0x0483:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            long r12 = r8.getLong(r1, r12)
            r2.a((int) r14, (long) r12)
            goto L_0x04a9
        L_0x0490:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            float r4 = com.google.android.gms.internal.icing.eo.d(r1, r12)
            r2.a((int) r14, (float) r4)
            goto L_0x04a9
        L_0x049d:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04a9
            double r12 = com.google.android.gms.internal.icing.eo.e(r1, r12)
            r2.a((int) r14, (double) r12)
        L_0x04a9:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x04ad:
            r17 = r10
            r4 = r17
        L_0x04b1:
            if (r4 == 0) goto L_0x04c7
            com.google.android.gms.internal.icing.bl<?> r5 = r0.r
            r5.b((java.util.Map.Entry<?, ?>) r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04c5
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x04b1
        L_0x04c5:
            r4 = 0
            goto L_0x04b1
        L_0x04c7:
            com.google.android.gms.internal.icing.ei<?, ?> r3 = r0.q
            a(r3, r1, (com.google.android.gms.internal.icing.fc) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.di.b(java.lang.Object, com.google.android.gms.internal.icing.fc):void");
    }

    private final <K, V> void a(fc fcVar, int i2, Object obj) throws IOException {
        if (obj != null) {
            fcVar.a(i2, this.s.a(), this.s.a(obj));
        }
    }

    private static <UT, UB> void a(ei<UT, UB> eiVar, T t, fc fcVar) throws IOException {
        eiVar.a(eiVar.a(t), fcVar);
    }

    private final dr a(int i2) {
        int i3 = (i2 / 3) << 1;
        dr drVar = (dr) this.f10160d[i3];
        if (drVar != null) {
            return drVar;
        }
        dr a2 = dq.a().a((Class) this.f10160d[i3 + 1]);
        this.f10160d[i3] = a2;
        return a2;
    }

    public final void b(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long b2 = (long) (b(this.l[i3]) & 1048575);
            Object f2 = eo.f(t, b2);
            if (f2 != null) {
                eo.a((Object) t, b2, this.s.b(f2));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.a(t, (long) this.l[i2]);
            i2++;
        }
        this.q.b(t);
        if (this.f10164h) {
            this.r.c(t);
        }
    }

    public final boolean c(T t) {
        int i2;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.m) {
                return !this.f10164h || this.r.a((Object) t).d();
            }
            int i6 = this.l[i3];
            int i7 = this.f10159c[i6];
            int b2 = b(i6);
            if (!this.j) {
                int i8 = this.f10159c[i6 + 2];
                int i9 = i8 & 1048575;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i4) {
                    i5 = f10158b.getInt(t, (long) i9);
                    i4 = i9;
                }
            } else {
                i2 = 0;
            }
            if (((268435456 & b2) != 0) && !a(t, i6, i5, i2)) {
                return false;
            }
            int i10 = (267386880 & b2) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (a(t, i7, i6) && !a((Object) t, b2, a(i6))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 != 50) {
                            continue;
                        } else {
                            Map<?, ?> a2 = this.s.a(eo.f(t, (long) (b2 & 1048575)));
                            if (!a2.isEmpty() && this.s.a().f10145b.zzdu() == fd.MESSAGE) {
                                dr<?> drVar = null;
                                Iterator<?> it2 = a2.values().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    Object next = it2.next();
                                    if (drVar == null) {
                                        drVar = dq.a().a(next.getClass());
                                    }
                                    if (!drVar.c(next)) {
                                        z = false;
                                        break;
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) eo.f(t, (long) (b2 & 1048575));
                if (!list.isEmpty()) {
                    dr a3 = a(i6);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list.size()) {
                            break;
                        } else if (!a3.c(list.get(i11))) {
                            z = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a(t, i6, i5, i2) && !a((Object) t, b2, a(i6))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean a(Object obj, int i2, dr drVar) {
        return drVar.c(eo.f(obj, (long) (i2 & 1048575)));
    }

    private static void a(int i2, Object obj, fc fcVar) throws IOException {
        if (obj instanceof String) {
            fcVar.a(i2, (String) obj);
        } else {
            fcVar.a(i2, (at) obj);
        }
    }

    private final int b(int i2) {
        return this.f10159c[i2 + 1];
    }

    private final int c(int i2) {
        return this.f10159c[i2 + 2];
    }

    private static <T> double b(T t, long j2) {
        return ((Double) eo.f(t, j2)).doubleValue();
    }

    private static <T> float c(T t, long j2) {
        return ((Float) eo.f(t, j2)).floatValue();
    }

    private static <T> int d(T t, long j2) {
        return ((Integer) eo.f(t, j2)).intValue();
    }

    private static <T> long e(T t, long j2) {
        return ((Long) eo.f(t, j2)).longValue();
    }

    private static <T> boolean f(T t, long j2) {
        return ((Boolean) eo.f(t, j2)).booleanValue();
    }

    private final boolean c(T t, T t2, int i2) {
        return a(t, i2) == a(t2, i2);
    }

    private final boolean a(T t, int i2, int i3, int i4) {
        if (this.j) {
            return a(t, i2);
        }
        return (i3 & i4) != 0;
    }

    private final boolean a(T t, int i2) {
        if (this.j) {
            int b2 = b(i2);
            long j2 = (long) (b2 & 1048575);
            switch ((b2 & 267386880) >>> 20) {
                case 0:
                    return eo.e(t, j2) != 0.0d;
                case 1:
                    return eo.d(t, j2) != 0.0f;
                case 2:
                    return eo.b(t, j2) != 0;
                case 3:
                    return eo.b(t, j2) != 0;
                case 4:
                    return eo.a((Object) t, j2) != 0;
                case 5:
                    return eo.b(t, j2) != 0;
                case 6:
                    return eo.a((Object) t, j2) != 0;
                case 7:
                    return eo.c(t, j2);
                case 8:
                    Object f2 = eo.f(t, j2);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof at) {
                        return !at.zzfy.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return eo.f(t, j2) != null;
                case 10:
                    return !at.zzfy.equals(eo.f(t, j2));
                case 11:
                    return eo.a((Object) t, j2) != 0;
                case 12:
                    return eo.a((Object) t, j2) != 0;
                case 13:
                    return eo.a((Object) t, j2) != 0;
                case 14:
                    return eo.b(t, j2) != 0;
                case 15:
                    return eo.a((Object) t, j2) != 0;
                case 16:
                    return eo.b(t, j2) != 0;
                case 17:
                    return eo.f(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int c2 = c(i2);
            return (eo.a((Object) t, (long) (c2 & 1048575)) & (1 << (c2 >>> 20))) != 0;
        }
    }

    private final void b(T t, int i2) {
        if (!this.j) {
            int c2 = c(i2);
            long j2 = (long) (c2 & 1048575);
            eo.a((Object) t, j2, eo.a((Object) t, j2) | (1 << (c2 >>> 20)));
        }
    }

    private final boolean a(T t, int i2, int i3) {
        return eo.a((Object) t, (long) (c(i3) & 1048575)) == i2;
    }

    private final void b(T t, int i2, int i3) {
        eo.a((Object) t, (long) (c(i3) & 1048575), i2);
    }
}
