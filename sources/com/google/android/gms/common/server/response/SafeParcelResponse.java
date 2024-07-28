package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.m;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8913a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f8914b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8915c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final zaj f8916d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8917e;

    /* renamed from: f  reason: collision with root package name */
    private int f8918f;

    /* renamed from: g  reason: collision with root package name */
    private int f8919g;

    SafeParcelResponse(int i2, Parcel parcel, zaj zaj) {
        this.f8913a = i2;
        this.f8914b = (Parcel) s.a(parcel);
        this.f8916d = zaj;
        zaj zaj2 = this.f8916d;
        if (zaj2 == null) {
            this.f8917e = null;
        } else {
            this.f8917e = zaj2.f8920a;
        }
        this.f8918f = 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        if (r0 != 1) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Parcel d() {
        /*
            r2 = this;
            int r0 = r2.f8918f
            if (r0 == 0) goto L_0x0008
            r1 = 1
            if (r0 == r1) goto L_0x0012
            goto L_0x001c
        L_0x0008:
            android.os.Parcel r0 = r2.f8914b
            r1 = 20293(0x4f45, float:2.8437E-41)
            int r0 = com.google.android.gms.common.internal.safeparcel.b.a(r0, r1)
            r2.f8919g = r0
        L_0x0012:
            android.os.Parcel r0 = r2.f8914b
            int r1 = r2.f8919g
            com.google.android.gms.common.internal.safeparcel.b.b(r0, r1)
            r0 = 2
            r2.f8918f = r0
        L_0x001c:
            android.os.Parcel r0 = r2.f8914b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.d():android.os.Parcel");
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> a() {
        zaj zaj = this.f8916d;
        if (zaj == null) {
            return null;
        }
        return zaj.a(this.f8917e);
    }

    public final Object b() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final boolean c() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public String toString() {
        s.a(this.f8916d, (Object) "Cannot convert to JSON on client side.");
        Parcel d2 = d();
        d2.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, this.f8916d.a(this.f8917e), d2);
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: long[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: boolean[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: boolean[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.StringBuilder r11, java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>> r12, android.os.Parcel r13) {
        /*
            r10 = this;
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x000d:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r12.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r2 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r2
            int r2 = r2.a()
            r0.put(r2, r1)
            goto L_0x000d
        L_0x0027:
            r12 = 123(0x7b, float:1.72E-43)
            r11.append(r12)
            int r12 = com.google.android.gms.common.internal.safeparcel.a.a(r13)
            r1 = 1
            r2 = 0
            r3 = 0
        L_0x0033:
            int r4 = r13.dataPosition()
            if (r4 >= r12) goto L_0x02ee
            int r4 = r13.readInt()
            r5 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r4
            java.lang.Object r5 = r0.get(r5)
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            if (r5 == 0) goto L_0x0033
            java.lang.String r6 = ","
            if (r3 == 0) goto L_0x0050
            r11.append(r6)
        L_0x0050:
            java.lang.Object r3 = r5.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r5.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r5 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r5
            java.lang.String r7 = "\""
            r11.append(r7)
            r11.append(r3)
            java.lang.String r3 = "\":"
            r11.append(r3)
            com.google.android.gms.common.server.response.FastJsonResponse$a<I, O> r3 = r5.f8912i
            if (r3 == 0) goto L_0x006f
            r3 = 1
            goto L_0x0070
        L_0x006f:
            r3 = 0
        L_0x0070:
            if (r3 == 0) goto L_0x0151
            int r3 = r5.f8906c
            switch(r3) {
                case 0: goto L_0x0140;
                case 1: goto L_0x0133;
                case 2: goto L_0x0122;
                case 3: goto L_0x0111;
                case 4: goto L_0x0100;
                case 5: goto L_0x00f3;
                case 6: goto L_0x00e2;
                case 7: goto L_0x00d5;
                case 8: goto L_0x00c8;
                case 9: goto L_0x00c8;
                case 10: goto L_0x009a;
                case 11: goto L_0x0092;
                default: goto L_0x0077;
            }
        L_0x0077:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            int r12 = r5.f8906c
            r13 = 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r13)
            java.lang.String r13 = "Unknown field out type = "
            r0.append(r13)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r11.<init>(r12)
            throw r11
        L_0x0092:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Method does not accept concrete type."
            r11.<init>(r12)
            throw r11
        L_0x009a:
            android.os.Bundle r3 = com.google.android.gms.common.internal.safeparcel.a.p(r13, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Set r6 = r3.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x00ab:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = r3.getString(r7)
            r4.put(r7, r8)
            goto L_0x00ab
        L_0x00bf:
            java.lang.Object r3 = a(r5, r4)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x00c8:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.a.q(r13, r4)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x00d5:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.a.n(r13, r4)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x00e2:
            boolean r3 = com.google.android.gms.common.internal.safeparcel.a.c(r13, r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x00f3:
            java.math.BigDecimal r3 = com.google.android.gms.common.internal.safeparcel.a.m(r13, r4)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x0100:
            double r3 = com.google.android.gms.common.internal.safeparcel.a.l(r13, r4)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x0111:
            float r3 = com.google.android.gms.common.internal.safeparcel.a.j(r13, r4)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x0122:
            long r3 = com.google.android.gms.common.internal.safeparcel.a.g(r13, r4)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x0133:
            java.math.BigInteger r3 = com.google.android.gms.common.internal.safeparcel.a.i(r13, r4)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x0140:
            int r3 = com.google.android.gms.common.internal.safeparcel.a.e(r13, r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = a(r5, r3)
            a((java.lang.StringBuilder) r11, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r5, (java.lang.Object) r3)
            goto L_0x02eb
        L_0x0151:
            boolean r3 = r5.f8907d
            if (r3 == 0) goto L_0x0211
            java.lang.String r3 = "["
            r11.append(r3)
            int r3 = r5.f8906c
            r7 = 0
            switch(r3) {
                case 0: goto L_0x0203;
                case 1: goto L_0x01fb;
                case 2: goto L_0x01e4;
                case 3: goto L_0x01cd;
                case 4: goto L_0x01b6;
                case 5: goto L_0x01ae;
                case 6: goto L_0x0197;
                case 7: goto L_0x018e;
                case 8: goto L_0x0186;
                case 9: goto L_0x0186;
                case 10: goto L_0x0186;
                case 11: goto L_0x0168;
                default: goto L_0x0160;
            }
        L_0x0160:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Unknown field type out."
            r11.<init>(r12)
            throw r11
        L_0x0168:
            android.os.Parcel[] r3 = com.google.android.gms.common.internal.safeparcel.a.z(r13, r4)
            int r4 = r3.length
            r7 = 0
        L_0x016e:
            if (r7 >= r4) goto L_0x020a
            if (r7 <= 0) goto L_0x0175
            r11.append(r6)
        L_0x0175:
            r8 = r3[r7]
            r8.setDataPosition(r2)
            java.util.Map r8 = r5.b()
            r9 = r3[r7]
            r10.a((java.lang.StringBuilder) r11, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r8, (android.os.Parcel) r9)
            int r7 = r7 + 1
            goto L_0x016e
        L_0x0186:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            java.lang.String r12 = "List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported"
            r11.<init>(r12)
            throw r11
        L_0x018e:
            java.lang.String[] r3 = com.google.android.gms.common.internal.safeparcel.a.v(r13, r4)
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (java.lang.String[]) r3)
            goto L_0x020a
        L_0x0197:
            int r3 = com.google.android.gms.common.internal.safeparcel.a.a(r13, r4)
            int r4 = r13.dataPosition()
            if (r3 != 0) goto L_0x01a2
            goto L_0x01aa
        L_0x01a2:
            boolean[] r7 = r13.createBooleanArray()
            int r4 = r4 + r3
            r13.setDataPosition(r4)
        L_0x01aa:
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (boolean[]) r7)
            goto L_0x020a
        L_0x01ae:
            java.math.BigDecimal[] r3 = com.google.android.gms.common.internal.safeparcel.a.u(r13, r4)
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (T[]) r3)
            goto L_0x020a
        L_0x01b6:
            int r3 = com.google.android.gms.common.internal.safeparcel.a.a(r13, r4)
            int r4 = r13.dataPosition()
            if (r3 != 0) goto L_0x01c1
            goto L_0x01c9
        L_0x01c1:
            double[] r7 = r13.createDoubleArray()
            int r4 = r4 + r3
            r13.setDataPosition(r4)
        L_0x01c9:
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (double[]) r7)
            goto L_0x020a
        L_0x01cd:
            int r3 = com.google.android.gms.common.internal.safeparcel.a.a(r13, r4)
            int r4 = r13.dataPosition()
            if (r3 != 0) goto L_0x01d8
            goto L_0x01e0
        L_0x01d8:
            float[] r7 = r13.createFloatArray()
            int r4 = r4 + r3
            r13.setDataPosition(r4)
        L_0x01e0:
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (float[]) r7)
            goto L_0x020a
        L_0x01e4:
            int r3 = com.google.android.gms.common.internal.safeparcel.a.a(r13, r4)
            int r4 = r13.dataPosition()
            if (r3 != 0) goto L_0x01ef
            goto L_0x01f7
        L_0x01ef:
            long[] r7 = r13.createLongArray()
            int r4 = r4 + r3
            r13.setDataPosition(r4)
        L_0x01f7:
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (long[]) r7)
            goto L_0x020a
        L_0x01fb:
            java.math.BigInteger[] r3 = com.google.android.gms.common.internal.safeparcel.a.t(r13, r4)
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (T[]) r3)
            goto L_0x020a
        L_0x0203:
            int[] r3 = com.google.android.gms.common.internal.safeparcel.a.s(r13, r4)
            com.google.android.gms.common.util.b.a((java.lang.StringBuilder) r11, (int[]) r3)
        L_0x020a:
            java.lang.String r3 = "]"
            r11.append(r3)
            goto L_0x02eb
        L_0x0211:
            int r3 = r5.f8906c
            switch(r3) {
                case 0: goto L_0x02e4;
                case 1: goto L_0x02dc;
                case 2: goto L_0x02d4;
                case 3: goto L_0x02cc;
                case 4: goto L_0x02c4;
                case 5: goto L_0x02bc;
                case 6: goto L_0x02b4;
                case 7: goto L_0x02a2;
                case 8: goto L_0x0290;
                case 9: goto L_0x027e;
                case 10: goto L_0x022e;
                case 11: goto L_0x021e;
                default: goto L_0x0216;
            }
        L_0x0216:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Unknown field type out"
            r11.<init>(r12)
            throw r11
        L_0x021e:
            android.os.Parcel r3 = com.google.android.gms.common.internal.safeparcel.a.y(r13, r4)
            r3.setDataPosition(r2)
            java.util.Map r4 = r5.b()
            r10.a((java.lang.StringBuilder) r11, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r4, (android.os.Parcel) r3)
            goto L_0x02eb
        L_0x022e:
            android.os.Bundle r3 = com.google.android.gms.common.internal.safeparcel.a.p(r13, r4)
            java.util.Set r4 = r3.keySet()
            r4.size()
            java.lang.String r5 = "{"
            r11.append(r5)
            java.util.Iterator r4 = r4.iterator()
            r5 = 1
        L_0x0244:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0276
            java.lang.Object r8 = r4.next()
            java.lang.String r8 = (java.lang.String) r8
            if (r5 != 0) goto L_0x0255
            r11.append(r6)
        L_0x0255:
            r11.append(r7)
            r11.append(r8)
            r11.append(r7)
            java.lang.String r5 = ":"
            r11.append(r5)
            r11.append(r7)
            java.lang.String r5 = r3.getString(r8)
            java.lang.String r5 = com.google.android.gms.common.util.l.a(r5)
            r11.append(r5)
            r11.append(r7)
            r5 = 0
            goto L_0x0244
        L_0x0276:
            java.lang.String r3 = "}"
            r11.append(r3)
            goto L_0x02eb
        L_0x027e:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.a.q(r13, r4)
            r11.append(r7)
            java.lang.String r3 = com.google.android.gms.common.util.c.b(r3)
            r11.append(r3)
            r11.append(r7)
            goto L_0x02eb
        L_0x0290:
            byte[] r3 = com.google.android.gms.common.internal.safeparcel.a.q(r13, r4)
            r11.append(r7)
            java.lang.String r3 = com.google.android.gms.common.util.c.a(r3)
            r11.append(r3)
            r11.append(r7)
            goto L_0x02eb
        L_0x02a2:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.a.n(r13, r4)
            r11.append(r7)
            java.lang.String r3 = com.google.android.gms.common.util.l.a(r3)
            r11.append(r3)
            r11.append(r7)
            goto L_0x02eb
        L_0x02b4:
            boolean r3 = com.google.android.gms.common.internal.safeparcel.a.c(r13, r4)
            r11.append(r3)
            goto L_0x02eb
        L_0x02bc:
            java.math.BigDecimal r3 = com.google.android.gms.common.internal.safeparcel.a.m(r13, r4)
            r11.append(r3)
            goto L_0x02eb
        L_0x02c4:
            double r3 = com.google.android.gms.common.internal.safeparcel.a.l(r13, r4)
            r11.append(r3)
            goto L_0x02eb
        L_0x02cc:
            float r3 = com.google.android.gms.common.internal.safeparcel.a.j(r13, r4)
            r11.append(r3)
            goto L_0x02eb
        L_0x02d4:
            long r3 = com.google.android.gms.common.internal.safeparcel.a.g(r13, r4)
            r11.append(r3)
            goto L_0x02eb
        L_0x02dc:
            java.math.BigInteger r3 = com.google.android.gms.common.internal.safeparcel.a.i(r13, r4)
            r11.append(r3)
            goto L_0x02eb
        L_0x02e4:
            int r3 = com.google.android.gms.common.internal.safeparcel.a.e(r13, r4)
            r11.append(r3)
        L_0x02eb:
            r3 = 1
            goto L_0x0033
        L_0x02ee:
            int r0 = r13.dataPosition()
            if (r0 != r12) goto L_0x02fa
            r12 = 125(0x7d, float:1.75E-43)
            r11.append(r12)
            return
        L_0x02fa:
            com.google.android.gms.common.internal.safeparcel.a$a r11 = new com.google.android.gms.common.internal.safeparcel.a$a
            r0 = 37
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Overread allowed size end="
            r1.append(r0)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r11.<init>(r12, r13)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.a(java.lang.StringBuilder, java.util.Map, android.os.Parcel):void");
    }

    private static void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f8905b) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(AppConstants.COMMA);
                }
                a(sb, field.f8904a, arrayList.get(i2));
            }
            sb.append("]");
            return;
        }
        a(sb, field.f8904a, obj);
    }

    private static void a(StringBuilder sb, int i2, Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(l.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(c.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(c.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                m.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        zaj zaj;
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8913a);
        Parcel d2 = d();
        if (d2 != null) {
            int a3 = b.a(parcel, 2);
            parcel.appendFrom(d2, 0, d2.dataSize());
            b.b(parcel, a3);
        }
        int i3 = this.f8915c;
        if (i3 == 0) {
            zaj = null;
        } else if (i3 == 1) {
            zaj = this.f8916d;
        } else if (i3 == 2) {
            zaj = this.f8916d;
        } else {
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i3);
            throw new IllegalStateException(sb.toString());
        }
        b.a(parcel, 3, zaj, i2, false);
        b.b(parcel, a2);
    }
}
