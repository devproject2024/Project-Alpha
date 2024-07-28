package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.util.Arrays;

final class dc {
    private int A = Integer.MIN_VALUE;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f9271a;

    /* renamed from: b  reason: collision with root package name */
    Class<?> f9272b;

    /* renamed from: c  reason: collision with root package name */
    final int f9273c;

    /* renamed from: d  reason: collision with root package name */
    final int f9274d;

    /* renamed from: e  reason: collision with root package name */
    final int f9275e;

    /* renamed from: f  reason: collision with root package name */
    final int f9276f;

    /* renamed from: g  reason: collision with root package name */
    final int f9277g;

    /* renamed from: h  reason: collision with root package name */
    final int f9278h;

    /* renamed from: i  reason: collision with root package name */
    final int f9279i;
    final int j;
    final int k;
    final int[] l;
    int m;
    int n;
    int o;
    int p;
    int q;
    Field r;
    Object s;
    Object t;
    Object u;
    private final dd v;
    private final int w;
    private int x;
    private int y;
    private int z = Integer.MAX_VALUE;

    dc(Class<?> cls, String str, Object[] objArr) {
        this.f9272b = cls;
        this.v = new dd(str);
        this.f9271a = objArr;
        this.f9273c = this.v.b();
        this.f9274d = this.v.b();
        int[] iArr = null;
        if (this.f9274d == 0) {
            this.f9275e = 0;
            this.w = 0;
            this.f9276f = 0;
            this.f9277g = 0;
            this.f9278h = 0;
            this.j = 0;
            this.f9279i = 0;
            this.k = 0;
            this.l = null;
            return;
        }
        this.f9275e = this.v.b();
        this.w = this.v.b();
        this.f9276f = this.v.b();
        this.f9277g = this.v.b();
        this.j = this.v.b();
        this.f9279i = this.v.b();
        this.f9278h = this.v.b();
        this.k = this.v.b();
        int b2 = this.v.b();
        this.l = b2 != 0 ? new int[b2] : iArr;
        this.x = (this.f9275e << 1) + this.w;
    }

    static Field a(Class<?> cls, String str) {
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

    private final Object d() {
        Object[] objArr = this.f9271a;
        int i2 = this.x;
        this.x = i2 + 1;
        return objArr[i2];
    }

    private final boolean e() {
        return (this.f9273c & 1) == 1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
        if (e() != false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015e, code lost:
        if (r1 != false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0165, code lost:
        if (e() != false) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r5 = this;
            com.google.android.gms.internal.clearcut.dd r0 = r5.v
            boolean r0 = r0.a()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.google.android.gms.internal.clearcut.dd r0 = r5.v
            int r0 = r0.b()
            r5.m = r0
            com.google.android.gms.internal.clearcut.dd r0 = r5.v
            int r0 = r0.b()
            r5.n = r0
            int r0 = r5.n
            r0 = r0 & 255(0xff, float:3.57E-43)
            r5.o = r0
            int r0 = r5.m
            int r2 = r5.z
            if (r0 >= r2) goto L_0x0028
            r5.z = r0
        L_0x0028:
            int r0 = r5.m
            int r2 = r5.A
            if (r0 <= r2) goto L_0x0030
            r5.A = r0
        L_0x0030:
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.MAP
            int r2 = r2.id()
            r3 = 1
            if (r0 != r2) goto L_0x0041
            int r0 = r5.B
            int r0 = r0 + r3
            r5.B = r0
            goto L_0x005a
        L_0x0041:
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.DOUBLE_LIST
            int r2 = r2.id()
            if (r0 < r2) goto L_0x005a
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.GROUP_LIST
            int r2 = r2.id()
            if (r0 > r2) goto L_0x005a
            int r0 = r5.C
            int r0 = r0 + r3
            r5.C = r0
        L_0x005a:
            int r0 = r5.F
            int r0 = r0 + r3
            r5.F = r0
            int r0 = r5.z
            int r2 = r5.m
            int r4 = r5.F
            boolean r0 = com.google.android.gms.internal.clearcut.dg.a((int) r0, (int) r2, (int) r4)
            if (r0 == 0) goto L_0x0076
            int r0 = r5.m
            int r0 = r0 + r3
            r5.E = r0
            int r0 = r5.E
            int r2 = r5.z
            int r0 = r0 - r2
            goto L_0x0079
        L_0x0076:
            int r0 = r5.D
            int r0 = r0 + r3
        L_0x0079:
            r5.D = r0
            int r0 = r5.n
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0083
            r0 = 1
            goto L_0x0084
        L_0x0083:
            r0 = 0
        L_0x0084:
            if (r0 == 0) goto L_0x0092
            int[] r0 = r5.l
            int r2 = r5.y
            int r4 = r2 + 1
            r5.y = r4
            int r4 = r5.m
            r0[r2] = r4
        L_0x0092:
            r0 = 0
            r5.s = r0
            r5.t = r0
            r5.u = r0
            boolean r0 = r5.b()
            if (r0 == 0) goto L_0x00e2
            com.google.android.gms.internal.clearcut.dd r0 = r5.v
            int r0 = r0.b()
            r5.p = r0
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r1 = com.google.android.gms.internal.clearcut.ba.MESSAGE
            int r1 = r1.id()
            int r1 = r1 + 51
            if (r0 == r1) goto L_0x00da
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r1 = com.google.android.gms.internal.clearcut.ba.GROUP
            int r1 = r1.id()
            int r1 = r1 + 51
            if (r0 != r1) goto L_0x00c0
            goto L_0x00da
        L_0x00c0:
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r1 = com.google.android.gms.internal.clearcut.ba.ENUM
            int r1 = r1.id()
            int r1 = r1 + 51
            if (r0 != r1) goto L_0x0171
            boolean r0 = r5.e()
            if (r0 == 0) goto L_0x0171
        L_0x00d2:
            java.lang.Object r0 = r5.d()
            r5.t = r0
            goto L_0x0171
        L_0x00da:
            java.lang.Object r0 = r5.d()
        L_0x00de:
            r5.s = r0
            goto L_0x0171
        L_0x00e2:
            java.lang.Class<?> r0 = r5.f9272b
            java.lang.Object r2 = r5.d()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r0 = a(r0, r2)
            r5.r = r0
            boolean r0 = r5.c()
            if (r0 == 0) goto L_0x00fe
            com.google.android.gms.internal.clearcut.dd r0 = r5.v
            int r0 = r0.b()
            r5.q = r0
        L_0x00fe:
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.MESSAGE
            int r2 = r2.id()
            if (r0 == r2) goto L_0x0169
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.GROUP
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0113
            goto L_0x0169
        L_0x0113:
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.MESSAGE_LIST
            int r2 = r2.id()
            if (r0 == r2) goto L_0x00da
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.GROUP_LIST
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0128
            goto L_0x00da
        L_0x0128:
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.ENUM
            int r2 = r2.id()
            if (r0 == r2) goto L_0x0161
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.ENUM_LIST
            int r2 = r2.id()
            if (r0 == r2) goto L_0x0161
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.ENUM_LIST_PACKED
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0147
            goto L_0x0161
        L_0x0147:
            int r0 = r5.o
            com.google.android.gms.internal.clearcut.ba r2 = com.google.android.gms.internal.clearcut.ba.MAP
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0171
            java.lang.Object r0 = r5.d()
            r5.u = r0
            int r0 = r5.n
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x015e
            r1 = 1
        L_0x015e:
            if (r1 == 0) goto L_0x0171
            goto L_0x0167
        L_0x0161:
            boolean r0 = r5.e()
            if (r0 == 0) goto L_0x0171
        L_0x0167:
            goto L_0x00d2
        L_0x0169:
            java.lang.reflect.Field r0 = r5.r
            java.lang.Class r0 = r0.getType()
            goto L_0x00de
        L_0x0171:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.dc.a():boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.o > ba.MAP.id();
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return e() && this.o <= ba.GROUP.id();
    }
}
