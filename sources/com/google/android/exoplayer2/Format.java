package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new Format[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }
    };
    public final String A;
    public final int B;
    private int C;

    /* renamed from: a  reason: collision with root package name */
    public final String f31061a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31062b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31063c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31064d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31065e;

    /* renamed from: f  reason: collision with root package name */
    public final String f31066f;

    /* renamed from: g  reason: collision with root package name */
    public final Metadata f31067g;

    /* renamed from: h  reason: collision with root package name */
    public final String f31068h;

    /* renamed from: i  reason: collision with root package name */
    public final String f31069i;
    public final int j;
    public final List<byte[]> k;
    public final DrmInitData l;
    public final long m;
    public final int n;
    public final int o;
    public final float p;
    public final int q;
    public final float r;
    public final int s;
    public final byte[] t;
    public final ColorInfo u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    public final int describeContents() {
        return 0;
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, Metadata metadata, int i2, int i3, int i4, float f2, List<byte[]> list, int i5, int i6) {
        return new Format(str, str2, i5, i6, i2, str5, metadata, str3, str4, -1, list, (DrmInitData) null, Long.MAX_VALUE, i3, i4, f2, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, (String) null, -1);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, List<byte[]> list, float f2) {
        return a(str, str2, str3, -1, i2, i3, list, -1, f2, (byte[]) null, -1, (ColorInfo) null, (DrmInitData) null);
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, (String) null, 0, 0, -1, str3, (Metadata) null, (String) null, str2, i2, list, drmInitData, Long.MAX_VALUE, i3, i4, -1.0f, i5, f2, bArr, i6, colorInfo, -1, -1, -1, -1, -1, (String) null, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, Metadata metadata, int i2, int i3, int i4, List<byte[]> list, int i5, int i6, String str6) {
        return new Format(str, str2, i5, i6, i2, str5, metadata, str3, str4, -1, list, (DrmInitData) null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i3, i4, -1, -1, -1, str6, -1);
    }

    public static Format a(String str, String str2, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, String str3) {
        return a(str, str2, i2, i3, i4, i5, -1, list, drmInitData, 0, str3);
    }

    public static Format a(String str, String str2, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, DrmInitData drmInitData, int i7, String str3) {
        return a(str, str2, i2, i3, i4, i5, i6, -1, -1, list, drmInitData, i7, str3, (Metadata) null);
    }

    public static Format a(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, DrmInitData drmInitData, int i9, String str3, Metadata metadata) {
        return new Format(str, (String) null, i9, 0, i2, (String) null, metadata, (String) null, str2, i3, list, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, i4, i5, i6, i7, i8, str3, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, int i2, int i3, int i4, String str5) {
        return a(str, str2, str3, str4, (String) null, i2, i3, i4, str5, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6, int i5) {
        return new Format(str, str2, i3, i4, i2, str5, (Metadata) null, str3, str4, -1, (List<byte[]>) null, (DrmInitData) null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str6, i5);
    }

    public static Format a(String str) {
        return a((String) null, str, 0, (String) null, (DrmInitData) null);
    }

    public static Format a(String str, String str2, int i2, String str3, DrmInitData drmInitData) {
        return a(str, str2, i2, str3, -1, drmInitData, Long.MAX_VALUE, (List<byte[]>) Collections.emptyList());
    }

    public static Format a(String str, String str2, long j2) {
        return a((String) null, str, 0, str2, -1, (DrmInitData) null, j2, (List<byte[]>) Collections.emptyList());
    }

    public static Format a(String str, String str2, int i2, String str3, int i3, DrmInitData drmInitData, long j2, List<byte[]> list) {
        return new Format(str, (String) null, i2, 0, -1, (String) null, (Metadata) null, (String) null, str2, -1, list, drmInitData, j2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str3, i3);
    }

    public static Format a(String str, String str2, int i2, List<byte[]> list, String str3, DrmInitData drmInitData) {
        return new Format(str, (String) null, i2, 0, -1, (String) null, (Metadata) null, (String) null, str2, -1, list, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str3, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6) {
        return new Format(str, str2, i3, i4, i2, str5, (Metadata) null, str3, str4, -1, (List<byte[]>) null, (DrmInitData) null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, str6, -1);
    }

    public static Format b(String str, String str2, long j2) {
        return new Format(str, (String) null, 0, 0, -1, (String) null, (Metadata) null, (String) null, str2, -1, (List<byte[]>) null, (DrmInitData) null, j2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, (String) null, -1);
    }

    public static Format a(String str, String str2) {
        return new Format(str, (String) null, 0, 0, -1, (String) null, (Metadata) null, (String) null, str2, -1, (List<byte[]>) null, (DrmInitData) null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (ColorInfo) null, -1, -1, -1, -1, -1, (String) null, -1);
    }

    public Format(String str, String str2, int i2, int i3, int i4, String str3, Metadata metadata, String str4, String str5, int i5, List<byte[]> list, DrmInitData drmInitData, long j2, int i6, int i7, float f2, int i8, float f3, byte[] bArr, int i9, ColorInfo colorInfo, int i10, int i11, int i12, int i13, int i14, String str6, int i15) {
        this.f31061a = str;
        this.f31062b = str2;
        this.f31063c = i2;
        this.f31064d = i3;
        this.f31065e = i4;
        this.f31066f = str3;
        this.f31067g = metadata;
        this.f31068h = str4;
        this.f31069i = str5;
        this.j = i5;
        this.k = list == null ? Collections.emptyList() : list;
        this.l = drmInitData;
        this.m = j2;
        this.n = i6;
        this.o = i7;
        this.p = f2;
        int i16 = i8;
        this.q = i16 == -1 ? 0 : i16;
        this.r = f3 == -1.0f ? 1.0f : f3;
        this.t = bArr;
        this.s = i9;
        this.u = colorInfo;
        this.v = i10;
        this.w = i11;
        this.x = i12;
        int i17 = i13;
        this.y = i17 == -1 ? 0 : i17;
        int i18 = i14;
        this.z = i18 == -1 ? 0 : i18;
        this.A = ae.b(str6);
        this.B = i15;
    }

    Format(Parcel parcel) {
        this.f31061a = parcel.readString();
        this.f31062b = parcel.readString();
        this.f31063c = parcel.readInt();
        this.f31064d = parcel.readInt();
        this.f31065e = parcel.readInt();
        this.f31066f = parcel.readString();
        this.f31067g = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.f31068h = parcel.readString();
        this.f31069i = parcel.readString();
        this.j = parcel.readInt();
        int readInt = parcel.readInt();
        this.k = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.k.add(parcel.createByteArray());
        }
        this.l = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.m = parcel.readLong();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readFloat();
        this.q = parcel.readInt();
        this.r = parcel.readFloat();
        this.t = ae.a(parcel) ? parcel.createByteArray() : null;
        this.s = parcel.readInt();
        this.u = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readInt();
    }

    public final Format a(int i2) {
        return new Format(this.f31061a, this.f31062b, this.f31063c, this.f31064d, this.f31065e, this.f31066f, this.f31067g, this.f31068h, this.f31069i, i2, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.t, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B);
    }

    public final Format a(long j2) {
        return new Format(this.f31061a, this.f31062b, this.f31063c, this.f31064d, this.f31065e, this.f31066f, this.f31067g, this.f31068h, this.f31069i, this.j, this.k, this.l, j2, this.n, this.o, this.p, this.q, this.r, this.t, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B);
    }

    public final Format a(String str, String str2, String str3, String str4, Metadata metadata, int i2, int i3, int i4, int i5, int i6, String str5) {
        Metadata metadata2 = this.f31067g;
        Metadata metadata3 = metadata;
        return new Format(str, str2, i6, this.f31064d, i2, str4, metadata2 != null ? metadata2.a(metadata3) : metadata3, this.f31068h, str3, this.j, this.k, this.l, this.m, i3, i4, this.p, this.q, this.r, this.t, this.s, this.u, i5, this.w, this.x, this.y, this.z, str5, this.B);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r6 = r1.A;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.exoplayer2.Format a(com.google.android.exoplayer2.Format r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            if (r0 != r1) goto L_0x0007
            return r0
        L_0x0007:
            java.lang.String r2 = r0.f31069i
            int r2 = com.google.android.exoplayer2.g.o.g(r2)
            java.lang.String r4 = r1.f31061a
            java.lang.String r3 = r1.f31062b
            if (r3 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            java.lang.String r3 = r0.f31062b
        L_0x0016:
            r5 = r3
            java.lang.String r3 = r0.A
            r6 = 3
            r7 = 1
            if (r2 == r6) goto L_0x001f
            if (r2 != r7) goto L_0x0026
        L_0x001f:
            java.lang.String r6 = r1.A
            if (r6 == 0) goto L_0x0026
            r31 = r6
            goto L_0x0028
        L_0x0026:
            r31 = r3
        L_0x0028:
            int r3 = r0.f31065e
            r6 = -1
            if (r3 != r6) goto L_0x002f
            int r3 = r1.f31065e
        L_0x002f:
            r8 = r3
            java.lang.String r3 = r0.f31066f
            if (r3 != 0) goto L_0x0043
            java.lang.String r6 = r1.f31066f
            java.lang.String r6 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r6, (int) r2)
            java.lang.String[] r9 = com.google.android.exoplayer2.g.ae.j(r6)
            int r9 = r9.length
            if (r9 != r7) goto L_0x0043
            r9 = r6
            goto L_0x0044
        L_0x0043:
            r9 = r3
        L_0x0044:
            com.google.android.exoplayer2.metadata.Metadata r3 = r0.f31067g
            if (r3 != 0) goto L_0x004b
            com.google.android.exoplayer2.metadata.Metadata r3 = r1.f31067g
            goto L_0x0051
        L_0x004b:
            com.google.android.exoplayer2.metadata.Metadata r6 = r1.f31067g
            com.google.android.exoplayer2.metadata.Metadata r3 = r3.a((com.google.android.exoplayer2.metadata.Metadata) r6)
        L_0x0051:
            r10 = r3
            float r3 = r0.p
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0062
            r6 = 2
            if (r2 != r6) goto L_0x0062
            float r2 = r1.p
            r20 = r2
            goto L_0x0064
        L_0x0062:
            r20 = r3
        L_0x0064:
            int r2 = r0.f31063c
            int r3 = r1.f31063c
            r6 = r2 | r3
            int r2 = r0.f31064d
            int r3 = r1.f31064d
            r7 = r2 | r3
            com.google.android.exoplayer2.drm.DrmInitData r1 = r1.l
            com.google.android.exoplayer2.drm.DrmInitData r2 = r0.l
            com.google.android.exoplayer2.drm.DrmInitData r15 = com.google.android.exoplayer2.drm.DrmInitData.a(r1, r2)
            com.google.android.exoplayer2.Format r1 = new com.google.android.exoplayer2.Format
            r3 = r1
            java.lang.String r11 = r0.f31068h
            java.lang.String r12 = r0.f31069i
            int r13 = r0.j
            java.util.List<byte[]> r14 = r0.k
            r34 = r1
            long r1 = r0.m
            r16 = r1
            int r1 = r0.n
            r18 = r1
            int r1 = r0.o
            r19 = r1
            int r1 = r0.q
            r21 = r1
            float r1 = r0.r
            r22 = r1
            byte[] r1 = r0.t
            r23 = r1
            int r1 = r0.s
            r24 = r1
            com.google.android.exoplayer2.video.ColorInfo r1 = r0.u
            r25 = r1
            int r1 = r0.v
            r26 = r1
            int r1 = r0.w
            r27 = r1
            int r1 = r0.x
            r28 = r1
            int r1 = r0.y
            r29 = r1
            int r1 = r0.z
            r30 = r1
            int r1 = r0.B
            r32 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return r34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.Format.a(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.Format");
    }

    public final Format a(int i2, int i3) {
        return new Format(this.f31061a, this.f31062b, this.f31063c, this.f31064d, this.f31065e, this.f31066f, this.f31067g, this.f31068h, this.f31069i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.t, this.s, this.u, this.v, this.w, this.x, i2, i3, this.A, this.B);
    }

    public final Format a(float f2) {
        return new Format(this.f31061a, this.f31062b, this.f31063c, this.f31064d, this.f31065e, this.f31066f, this.f31067g, this.f31068h, this.f31069i, this.j, this.k, this.l, this.m, this.n, this.o, f2, this.q, this.r, this.t, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B);
    }

    public final Format a(DrmInitData drmInitData) {
        return new Format(this.f31061a, this.f31062b, this.f31063c, this.f31064d, this.f31065e, this.f31066f, this.f31067g, this.f31068h, this.f31069i, this.j, this.k, drmInitData, this.m, this.n, this.o, this.p, this.q, this.r, this.t, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B);
    }

    public final Format a(Metadata metadata) {
        return new Format(this.f31061a, this.f31062b, this.f31063c, this.f31064d, this.f31065e, this.f31066f, metadata, this.f31068h, this.f31069i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.t, this.s, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B);
    }

    public final int a() {
        int i2;
        int i3 = this.n;
        if (i3 == -1 || (i2 = this.o) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    public final String toString() {
        return "Format(" + this.f31061a + ", " + this.f31062b + ", " + this.f31068h + ", " + this.f31069i + ", " + this.f31066f + ", " + this.f31065e + ", " + this.A + ", [" + this.n + ", " + this.o + ", " + this.p + "], [" + this.v + ", " + this.w + "])";
    }

    public final int hashCode() {
        if (this.C == 0) {
            String str = this.f31061a;
            int i2 = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.f31062b;
            int hashCode2 = (((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f31063c) * 31) + this.f31064d) * 31) + this.f31065e) * 31;
            String str3 = this.f31066f;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Metadata metadata = this.f31067g;
            int hashCode4 = (hashCode3 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str4 = this.f31068h;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f31069i;
            int hashCode6 = (((((((((((((((((((((((((((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.j) * 31) + ((int) this.m)) * 31) + this.n) * 31) + this.o) * 31) + Float.floatToIntBits(this.p)) * 31) + this.q) * 31) + Float.floatToIntBits(this.r)) * 31) + this.s) * 31) + this.v) * 31) + this.w) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31;
            String str6 = this.A;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            this.C = ((hashCode6 + i2) * 31) + this.B;
        }
        return this.C;
    }

    public final boolean equals(Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Format format = (Format) obj;
            int i3 = this.C;
            if ((i3 == 0 || (i2 = format.C) == 0 || i3 == i2) && this.f31063c == format.f31063c && this.f31064d == format.f31064d && this.f31065e == format.f31065e && this.j == format.j && this.m == format.m && this.n == format.n && this.o == format.o && this.q == format.q && this.s == format.s && this.v == format.v && this.w == format.w && this.x == format.x && this.y == format.y && this.z == format.z && this.B == format.B && Float.compare(this.p, format.p) == 0 && Float.compare(this.r, format.r) == 0 && ae.a((Object) this.f31061a, (Object) format.f31061a) && ae.a((Object) this.f31062b, (Object) format.f31062b) && ae.a((Object) this.f31066f, (Object) format.f31066f) && ae.a((Object) this.f31068h, (Object) format.f31068h) && ae.a((Object) this.f31069i, (Object) format.f31069i) && ae.a((Object) this.A, (Object) format.A) && Arrays.equals(this.t, format.t) && ae.a((Object) this.f31067g, (Object) format.f31067g) && ae.a((Object) this.u, (Object) format.u) && ae.a((Object) this.l, (Object) format.l) && b(format)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(Format format) {
        if (this.k.size() != format.k.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (!Arrays.equals(this.k.get(i2), format.k.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f31061a);
        parcel.writeString(this.f31062b);
        parcel.writeInt(this.f31063c);
        parcel.writeInt(this.f31064d);
        parcel.writeInt(this.f31065e);
        parcel.writeString(this.f31066f);
        boolean z2 = false;
        parcel.writeParcelable(this.f31067g, 0);
        parcel.writeString(this.f31068h);
        parcel.writeString(this.f31069i);
        parcel.writeInt(this.j);
        int size = this.k.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.k.get(i3));
        }
        parcel.writeParcelable(this.l, 0);
        parcel.writeLong(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeFloat(this.p);
        parcel.writeInt(this.q);
        parcel.writeFloat(this.r);
        if (this.t != null) {
            z2 = true;
        }
        ae.a(parcel, z2);
        byte[] bArr = this.t;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.s);
        parcel.writeParcelable(this.u, i2);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
    }
}
