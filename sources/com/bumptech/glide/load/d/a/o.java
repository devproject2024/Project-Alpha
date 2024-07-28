package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.m;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final h<b> f7159a = h.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", b.DEFAULT);

    /* renamed from: b  reason: collision with root package name */
    public static final h<j> f7160b = h.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", j.SRGB);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final h<n> f7161c = n.f7157h;

    /* renamed from: d  reason: collision with root package name */
    public static final h<Boolean> f7162d = h.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);

    /* renamed from: e  reason: collision with root package name */
    public static final h<Boolean> f7163e = h.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);

    /* renamed from: f  reason: collision with root package name */
    static final a f7164f = new a() {
        public final void a() {
        }

        public final void a(e eVar, Bitmap bitmap) {
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final Set<String> f7165i = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    private static final Set<ImageHeaderParser.ImageType> j = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> k = k.a(0);

    /* renamed from: g  reason: collision with root package name */
    final com.bumptech.glide.load.b.a.b f7166g;

    /* renamed from: h  reason: collision with root package name */
    final List<ImageHeaderParser> f7167h;
    private final e l;
    private final DisplayMetrics m;
    private final t n = t.a();

    public interface a {
        void a();

        void a(e eVar, Bitmap bitmap) throws IOException;
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public o(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, e eVar, com.bumptech.glide.load.b.a.b bVar) {
        this.f7167h = list;
        this.m = (DisplayMetrics) com.bumptech.glide.g.j.a(displayMetrics, "Argument must not be null");
        this.l = (e) com.bumptech.glide.g.j.a(eVar, "Argument must not be null");
        this.f7166g = (com.bumptech.glide.load.b.a.b) com.bumptech.glide.g.j.a(bVar, "Argument must not be null");
    }

    public static boolean a() {
        return m.c();
    }

    public final v<Bitmap> a(InputStream inputStream, int i2, int i3, i iVar, a aVar) throws IOException {
        return a((u) new u.a(inputStream, this.f7167h, this.f7166g), i2, i3, iVar, aVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d3 A[Catch:{ all -> 0x0502 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f7 A[Catch:{ all -> 0x0502 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01fb A[Catch:{ all -> 0x0502 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0209 A[Catch:{ all -> 0x0502 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0273 A[Catch:{ all -> 0x0502 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.load.b.v<android.graphics.Bitmap> a(com.bumptech.glide.load.d.a.u r36, int r37, int r38, com.bumptech.glide.load.i r39, com.bumptech.glide.load.d.a.o.a r40) throws java.io.IOException {
        /*
            r35 = this;
            r1 = r35
            r0 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            com.bumptech.glide.load.b.a.b r6 = r1.f7166g
            java.lang.Class<byte[]> r7 = byte[].class
            r8 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r6 = r6.a(r8, r7)
            byte[] r6 = (byte[]) r6
            android.graphics.BitmapFactory$Options r7 = b()
            r7.inTempStorage = r6
            com.bumptech.glide.load.h<com.bumptech.glide.load.b> r8 = f7159a
            java.lang.Object r8 = r4.a(r8)
            com.bumptech.glide.load.b r8 = (com.bumptech.glide.load.b) r8
            com.bumptech.glide.load.h<com.bumptech.glide.load.j> r9 = f7160b
            java.lang.Object r9 = r4.a(r9)
            com.bumptech.glide.load.j r9 = (com.bumptech.glide.load.j) r9
            com.bumptech.glide.load.h<com.bumptech.glide.load.d.a.n> r10 = com.bumptech.glide.load.d.a.n.f7157h
            java.lang.Object r10 = r4.a(r10)
            com.bumptech.glide.load.d.a.n r10 = (com.bumptech.glide.load.d.a.n) r10
            com.bumptech.glide.load.h<java.lang.Boolean> r11 = f7162d
            java.lang.Object r11 = r4.a(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            com.bumptech.glide.load.h<java.lang.Boolean> r12 = f7163e
            java.lang.Object r12 = r4.a(r12)
            r13 = 0
            r14 = 1
            if (r12 == 0) goto L_0x005c
            com.bumptech.glide.load.h<java.lang.Boolean> r12 = f7163e
            java.lang.Object r4 = r4.a(r12)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x005c
            r4 = 1
            goto L_0x005d
        L_0x005c:
            r4 = 0
        L_0x005d:
            long r15 = com.bumptech.glide.g.f.a()     // Catch:{ all -> 0x050b }
            com.bumptech.glide.load.b.a.e r12 = r1.l     // Catch:{ all -> 0x050b }
            int[] r12 = a(r0, r7, r5, r12)     // Catch:{ all -> 0x050b }
            r39 = r4
            r4 = r12[r13]     // Catch:{ all -> 0x050b }
            r12 = r12[r14]     // Catch:{ all -> 0x050b }
            java.lang.String r13 = r7.outMimeType     // Catch:{ all -> 0x050b }
            r14 = -1
            if (r4 == r14) goto L_0x007a
            if (r12 != r14) goto L_0x0075
            goto L_0x007a
        L_0x0075:
            r14 = r39
            r17 = r6
            goto L_0x007d
        L_0x007a:
            r17 = r6
            r14 = 0
        L_0x007d:
            int r6 = r36.b()     // Catch:{ all -> 0x0506 }
            r18 = r15
            int r15 = com.bumptech.glide.load.d.a.ad.a((int) r6)     // Catch:{ all -> 0x0506 }
            r16 = r13
            boolean r13 = com.bumptech.glide.load.d.a.ad.b((int) r6)     // Catch:{ all -> 0x0506 }
            r39 = r6
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r6) goto L_0x009c
            boolean r20 = a((int) r15)     // Catch:{ all -> 0x0506 }
            if (r20 == 0) goto L_0x009b
            r2 = r12
            goto L_0x009c
        L_0x009b:
            r2 = r4
        L_0x009c:
            if (r3 != r6) goto L_0x00a8
            boolean r6 = a((int) r15)     // Catch:{ all -> 0x0506 }
            if (r6 == 0) goto L_0x00a6
            r6 = r4
            goto L_0x00a9
        L_0x00a6:
            r6 = r12
            goto L_0x00a9
        L_0x00a8:
            r6 = r3
        L_0x00a9:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r3 = r36.a()     // Catch:{ all -> 0x0506 }
            r20 = r9
            com.bumptech.glide.load.b.a.e r9 = r1.l     // Catch:{ all -> 0x0506 }
            r21 = 1065353216(0x3f800000, float:1.0)
            r22 = r11
            java.lang.String r11 = "]"
            r23 = r8
            java.lang.String r8 = ", density: "
            r24 = r13
            java.lang.String r13 = "Downsampler"
            r25 = r14
            java.lang.String r14 = "x"
            if (r4 <= 0) goto L_0x02c5
            if (r12 > 0) goto L_0x00ca
            goto L_0x02c5
        L_0x00ca:
            boolean r26 = a((int) r15)     // Catch:{ all -> 0x0502 }
            if (r26 == 0) goto L_0x00d7
            r27 = r8
            r26 = r11
            r1 = r12
            r11 = r4
            goto L_0x00dd
        L_0x00d7:
            r1 = r4
            r27 = r8
            r26 = r11
            r11 = r12
        L_0x00dd:
            float r8 = r10.a(r1, r11, r2, r6)     // Catch:{ all -> 0x0502 }
            r28 = 0
            int r28 = (r8 > r28 ? 1 : (r8 == r28 ? 0 : -1))
            if (r28 <= 0) goto L_0x0285
            r28 = r15
            com.bumptech.glide.load.d.a.n$g r15 = r10.b(r1, r11, r2, r6)     // Catch:{ all -> 0x0502 }
            if (r15 == 0) goto L_0x027d
            r29 = r12
            float r12 = (float) r1     // Catch:{ all -> 0x0502 }
            r30 = r14
            float r14 = r8 * r12
            r31 = r13
            double r13 = (double) r14     // Catch:{ all -> 0x0502 }
            r32 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r13 = r13 + r32
            int r13 = (int) r13     // Catch:{ all -> 0x0502 }
            float r14 = (float) r11     // Catch:{ all -> 0x0502 }
            r34 = r4
            float r4 = r8 * r14
            double r4 = (double) r4     // Catch:{ all -> 0x0502 }
            double r4 = r4 + r32
            int r4 = (int) r4     // Catch:{ all -> 0x0502 }
            int r5 = r1 / r13
            int r4 = r11 / r4
            com.bumptech.glide.load.d.a.n$g r13 = com.bumptech.glide.load.d.a.n.g.MEMORY     // Catch:{ all -> 0x0502 }
            if (r15 != r13) goto L_0x0114
            int r4 = java.lang.Math.max(r5, r4)     // Catch:{ all -> 0x0502 }
            goto L_0x0118
        L_0x0114:
            int r4 = java.lang.Math.min(r5, r4)     // Catch:{ all -> 0x0502 }
        L_0x0118:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0502 }
            r13 = 23
            if (r5 > r13) goto L_0x012a
            java.util.Set<java.lang.String> r5 = f7165i     // Catch:{ all -> 0x0502 }
            java.lang.String r13 = r7.outMimeType     // Catch:{ all -> 0x0502 }
            boolean r5 = r5.contains(r13)     // Catch:{ all -> 0x0502 }
            if (r5 == 0) goto L_0x012a
            r4 = 1
            goto L_0x0140
        L_0x012a:
            int r4 = java.lang.Integer.highestOneBit(r4)     // Catch:{ all -> 0x0502 }
            r5 = 1
            int r4 = java.lang.Math.max(r5, r4)     // Catch:{ all -> 0x0502 }
            com.bumptech.glide.load.d.a.n$g r5 = com.bumptech.glide.load.d.a.n.g.MEMORY     // Catch:{ all -> 0x0502 }
            if (r15 != r5) goto L_0x0140
            float r5 = (float) r4     // Catch:{ all -> 0x0502 }
            float r13 = r21 / r8
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0140
            int r4 = r4 << 1
        L_0x0140:
            r7.inSampleSize = r4     // Catch:{ all -> 0x0502 }
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ all -> 0x0502 }
            if (r3 != r5) goto L_0x0166
            r1 = 8
            int r1 = java.lang.Math.min(r4, r1)     // Catch:{ all -> 0x0502 }
            float r1 = (float) r1     // Catch:{ all -> 0x0502 }
            float r12 = r12 / r1
            double r11 = (double) r12     // Catch:{ all -> 0x0502 }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ all -> 0x0502 }
            int r5 = (int) r11     // Catch:{ all -> 0x0502 }
            float r14 = r14 / r1
            double r11 = (double) r14     // Catch:{ all -> 0x0502 }
            double r11 = java.lang.Math.ceil(r11)     // Catch:{ all -> 0x0502 }
            int r1 = (int) r11     // Catch:{ all -> 0x0502 }
            int r9 = r4 / 8
            if (r9 <= 0) goto L_0x0161
            int r5 = r5 / r9
            int r1 = r1 / r9
        L_0x0161:
            r9 = r5
            r5 = r1
            r1 = r40
            goto L_0x01c8
        L_0x0166:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ all -> 0x0502 }
            if (r3 == r5) goto L_0x01b7
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ all -> 0x0502 }
            if (r3 != r5) goto L_0x016f
            goto L_0x01b7
        L_0x016f:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ all -> 0x0502 }
            if (r3 == r5) goto L_0x0194
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ all -> 0x0502 }
            if (r3 != r5) goto L_0x0178
            goto L_0x0194
        L_0x0178:
            int r5 = r1 % r4
            if (r5 != 0) goto L_0x0186
            int r5 = r11 % r4
            if (r5 == 0) goto L_0x0181
            goto L_0x0186
        L_0x0181:
            int r5 = r1 / r4
            int r1 = r11 / r4
            goto L_0x0161
        L_0x0186:
            r1 = r40
            int[] r5 = a(r0, r7, r1, r9)     // Catch:{ all -> 0x0502 }
            r9 = 0
            r11 = r5[r9]     // Catch:{ all -> 0x0502 }
            r9 = 1
            r5 = r5[r9]     // Catch:{ all -> 0x0502 }
            r9 = r11
            goto L_0x01c8
        L_0x0194:
            r1 = r40
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0502 }
            r9 = 24
            if (r5 < r9) goto L_0x01a8
            float r5 = (float) r4     // Catch:{ all -> 0x0502 }
            float r12 = r12 / r5
            int r9 = java.lang.Math.round(r12)     // Catch:{ all -> 0x0502 }
            float r14 = r14 / r5
            int r5 = java.lang.Math.round(r14)     // Catch:{ all -> 0x0502 }
            goto L_0x01c8
        L_0x01a8:
            float r5 = (float) r4     // Catch:{ all -> 0x0502 }
            float r12 = r12 / r5
            double r11 = (double) r12     // Catch:{ all -> 0x0502 }
            double r11 = java.lang.Math.floor(r11)     // Catch:{ all -> 0x0502 }
            int r9 = (int) r11     // Catch:{ all -> 0x0502 }
            float r14 = r14 / r5
            double r11 = (double) r14     // Catch:{ all -> 0x0502 }
            double r11 = java.lang.Math.floor(r11)     // Catch:{ all -> 0x0502 }
            goto L_0x01c7
        L_0x01b7:
            r1 = r40
            float r5 = (float) r4     // Catch:{ all -> 0x0502 }
            float r12 = r12 / r5
            double r11 = (double) r12     // Catch:{ all -> 0x0502 }
            double r11 = java.lang.Math.floor(r11)     // Catch:{ all -> 0x0502 }
            int r9 = (int) r11     // Catch:{ all -> 0x0502 }
            float r14 = r14 / r5
            double r11 = (double) r14     // Catch:{ all -> 0x0502 }
            double r11 = java.lang.Math.floor(r11)     // Catch:{ all -> 0x0502 }
        L_0x01c7:
            int r5 = (int) r11     // Catch:{ all -> 0x0502 }
        L_0x01c8:
            float r10 = r10.a(r9, r5, r2, r6)     // Catch:{ all -> 0x0502 }
            double r10 = (double) r10     // Catch:{ all -> 0x0502 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0502 }
            r13 = 19
            if (r12 < r13) goto L_0x01f1
            int r12 = a((double) r10)     // Catch:{ all -> 0x0502 }
            double r13 = (double) r12     // Catch:{ all -> 0x0502 }
            double r13 = r13 * r10
            double r13 = r13 + r32
            int r13 = (int) r13     // Catch:{ all -> 0x0502 }
            float r14 = (float) r13     // Catch:{ all -> 0x0502 }
            float r12 = (float) r12     // Catch:{ all -> 0x0502 }
            float r14 = r14 / r12
            double r14 = (double) r14     // Catch:{ all -> 0x0502 }
            double r14 = r10 / r14
            double r12 = (double) r13     // Catch:{ all -> 0x0502 }
            double r14 = r14 * r12
            double r14 = r14 + r32
            int r12 = (int) r14     // Catch:{ all -> 0x0502 }
            r7.inTargetDensity = r12     // Catch:{ all -> 0x0502 }
            int r12 = a((double) r10)     // Catch:{ all -> 0x0502 }
            r7.inDensity = r12     // Catch:{ all -> 0x0502 }
        L_0x01f1:
            boolean r12 = a((android.graphics.BitmapFactory.Options) r7)     // Catch:{ all -> 0x0502 }
            if (r12 == 0) goto L_0x01fb
            r12 = 1
            r7.inScaled = r12     // Catch:{ all -> 0x0502 }
            goto L_0x0200
        L_0x01fb:
            r12 = 0
            r7.inTargetDensity = r12     // Catch:{ all -> 0x0502 }
            r7.inDensity = r12     // Catch:{ all -> 0x0502 }
        L_0x0200:
            r13 = r31
            r12 = 2
            boolean r14 = android.util.Log.isLoggable(r13, r12)     // Catch:{ all -> 0x0502 }
            if (r14 == 0) goto L_0x0273
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0502 }
            java.lang.String r14 = "Calculate scaling, source: ["
            r12.<init>(r14)     // Catch:{ all -> 0x0502 }
            r14 = r34
            r12.append(r14)     // Catch:{ all -> 0x0502 }
            r15 = r30
            r12.append(r15)     // Catch:{ all -> 0x0502 }
            r0 = r29
            r12.append(r0)     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = "], degreesToRotate: "
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            r1 = r28
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = ", target: ["
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            r12.append(r2)     // Catch:{ all -> 0x0502 }
            r12.append(r15)     // Catch:{ all -> 0x0502 }
            r12.append(r6)     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = "], power of two scaled: ["
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            r12.append(r9)     // Catch:{ all -> 0x0502 }
            r12.append(r15)     // Catch:{ all -> 0x0502 }
            r12.append(r5)     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = "], exact scale factor: "
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            r12.append(r8)     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = ", power of 2 sample size: "
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            r12.append(r4)     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = ", adjusted scale factor: "
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            r12.append(r10)     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = ", target density: "
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            int r1 = r7.inTargetDensity     // Catch:{ all -> 0x0502 }
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            r1 = r27
            r12.append(r1)     // Catch:{ all -> 0x0502 }
            int r4 = r7.inDensity     // Catch:{ all -> 0x0502 }
            r12.append(r4)     // Catch:{ all -> 0x0502 }
            goto L_0x02ec
        L_0x0273:
            r1 = r27
            r0 = r29
            r15 = r30
            r14 = r34
            goto L_0x02ec
        L_0x027d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0502 }
            java.lang.String r1 = "Cannot round with null rounding"
            r0.<init>(r1)     // Catch:{ all -> 0x0502 }
            throw r0     // Catch:{ all -> 0x0502 }
        L_0x0285:
            r0 = r12
            r15 = r14
            r14 = r4
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0502 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0502 }
            java.lang.String r4 = "Cannot scale with factor: "
            r3.<init>(r4)     // Catch:{ all -> 0x0502 }
            r3.append(r8)     // Catch:{ all -> 0x0502 }
            java.lang.String r4 = " from: "
            r3.append(r4)     // Catch:{ all -> 0x0502 }
            r3.append(r10)     // Catch:{ all -> 0x0502 }
            java.lang.String r4 = ", source: ["
            r3.append(r4)     // Catch:{ all -> 0x0502 }
            r3.append(r14)     // Catch:{ all -> 0x0502 }
            r3.append(r15)     // Catch:{ all -> 0x0502 }
            r3.append(r0)     // Catch:{ all -> 0x0502 }
            java.lang.String r0 = "], target: ["
            r3.append(r0)     // Catch:{ all -> 0x0502 }
            r3.append(r2)     // Catch:{ all -> 0x0502 }
            r3.append(r15)     // Catch:{ all -> 0x0502 }
            r3.append(r6)     // Catch:{ all -> 0x0502 }
            r4 = r26
            r3.append(r4)     // Catch:{ all -> 0x0502 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0502 }
            r1.<init>(r0)     // Catch:{ all -> 0x0502 }
            throw r1     // Catch:{ all -> 0x0502 }
        L_0x02c5:
            r1 = r8
            r0 = r12
            r15 = r14
            r14 = r4
            r4 = r11
            r5 = 3
            boolean r8 = android.util.Log.isLoggable(r13, r5)     // Catch:{ all -> 0x0502 }
            if (r8 == 0) goto L_0x02ec
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0502 }
            java.lang.String r8 = "Unable to determine dimensions for: "
            r5.<init>(r8)     // Catch:{ all -> 0x0502 }
            r5.append(r3)     // Catch:{ all -> 0x0502 }
            java.lang.String r8 = " with target ["
            r5.append(r8)     // Catch:{ all -> 0x0502 }
            r5.append(r2)     // Catch:{ all -> 0x0502 }
            r5.append(r15)     // Catch:{ all -> 0x0502 }
            r5.append(r6)     // Catch:{ all -> 0x0502 }
            r5.append(r4)     // Catch:{ all -> 0x0502 }
        L_0x02ec:
            r4 = r35
            com.bumptech.glide.load.d.a.t r5 = r4.n     // Catch:{ all -> 0x0500 }
            r8 = r24
            r9 = r25
            boolean r5 = r5.a(r2, r6, r9, r8)     // Catch:{ all -> 0x0500 }
            if (r5 == 0) goto L_0x0302
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.HARDWARE     // Catch:{ all -> 0x0500 }
            r7.inPreferredConfig = r8     // Catch:{ all -> 0x0500 }
            r8 = 0
            r7.inMutable = r8     // Catch:{ all -> 0x0500 }
            goto L_0x0303
        L_0x0302:
            r8 = 0
        L_0x0303:
            if (r5 != 0) goto L_0x0344
            com.bumptech.glide.load.b r5 = com.bumptech.glide.load.b.PREFER_ARGB_8888     // Catch:{ all -> 0x0500 }
            r9 = r23
            if (r9 == r5) goto L_0x0340
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0500 }
            r10 = 16
            if (r5 != r10) goto L_0x0312
            goto L_0x0340
        L_0x0312:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r36.a()     // Catch:{ IOException -> 0x031b }
            boolean r5 = r5.hasAlpha()     // Catch:{ IOException -> 0x031b }
            goto L_0x032d
        L_0x031b:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r13, r5)     // Catch:{ all -> 0x0500 }
            if (r5 == 0) goto L_0x032c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0500 }
            java.lang.String r10 = "Cannot determine whether the image has alpha or not from header, format "
            r5.<init>(r10)     // Catch:{ all -> 0x0500 }
            r5.append(r9)     // Catch:{ all -> 0x0500 }
        L_0x032c:
            r5 = 0
        L_0x032d:
            if (r5 == 0) goto L_0x0332
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0500 }
            goto L_0x0334
        L_0x0332:
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ all -> 0x0500 }
        L_0x0334:
            r7.inPreferredConfig = r5     // Catch:{ all -> 0x0500 }
            android.graphics.Bitmap$Config r5 = r7.inPreferredConfig     // Catch:{ all -> 0x0500 }
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ all -> 0x0500 }
            if (r5 != r9) goto L_0x0344
            r5 = 1
            r7.inDither = r5     // Catch:{ all -> 0x0500 }
            goto L_0x0344
        L_0x0340:
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0500 }
            r7.inPreferredConfig = r5     // Catch:{ all -> 0x0500 }
        L_0x0344:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0500 }
            r9 = 19
            if (r5 < r9) goto L_0x034c
            r5 = 1
            goto L_0x034d
        L_0x034c:
            r5 = 0
        L_0x034d:
            int r9 = r7.inSampleSize     // Catch:{ all -> 0x0500 }
            r10 = 26
            r11 = 1
            if (r9 == r11) goto L_0x0356
            if (r5 == 0) goto L_0x0409
        L_0x0356:
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0500 }
            r12 = 19
            if (r9 < r12) goto L_0x035e
            r3 = 1
            goto L_0x0364
        L_0x035e:
            java.util.Set<com.bumptech.glide.load.ImageHeaderParser$ImageType> r9 = j     // Catch:{ all -> 0x0500 }
            boolean r3 = r9.contains(r3)     // Catch:{ all -> 0x0500 }
        L_0x0364:
            if (r3 == 0) goto L_0x0409
            if (r14 < 0) goto L_0x0370
            if (r0 < 0) goto L_0x0370
            if (r22 == 0) goto L_0x0370
            if (r5 == 0) goto L_0x0370
            goto L_0x03ec
        L_0x0370:
            boolean r2 = a((android.graphics.BitmapFactory.Options) r7)     // Catch:{ all -> 0x0500 }
            if (r2 == 0) goto L_0x0381
            int r2 = r7.inTargetDensity     // Catch:{ all -> 0x0500 }
            float r2 = (float) r2     // Catch:{ all -> 0x0500 }
            int r3 = r7.inDensity     // Catch:{ all -> 0x0500 }
            float r3 = (float) r3     // Catch:{ all -> 0x0500 }
            float r21 = r2 / r3
            r2 = r21
            goto L_0x0383
        L_0x0381:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0383:
            int r3 = r7.inSampleSize     // Catch:{ all -> 0x0500 }
            float r5 = (float) r14     // Catch:{ all -> 0x0500 }
            float r6 = (float) r3     // Catch:{ all -> 0x0500 }
            float r5 = r5 / r6
            double r8 = (double) r5     // Catch:{ all -> 0x0500 }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x0500 }
            int r5 = (int) r8     // Catch:{ all -> 0x0500 }
            float r8 = (float) r0     // Catch:{ all -> 0x0500 }
            float r8 = r8 / r6
            double r8 = (double) r8     // Catch:{ all -> 0x0500 }
            double r8 = java.lang.Math.ceil(r8)     // Catch:{ all -> 0x0500 }
            int r6 = (int) r8     // Catch:{ all -> 0x0500 }
            float r5 = (float) r5     // Catch:{ all -> 0x0500 }
            float r5 = r5 * r2
            int r5 = java.lang.Math.round(r5)     // Catch:{ all -> 0x0500 }
            float r6 = (float) r6     // Catch:{ all -> 0x0500 }
            float r6 = r6 * r2
            int r6 = java.lang.Math.round(r6)     // Catch:{ all -> 0x0500 }
            r8 = 2
            boolean r9 = android.util.Log.isLoggable(r13, r8)     // Catch:{ all -> 0x0500 }
            if (r9 == 0) goto L_0x03eb
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0500 }
            java.lang.String r9 = "Calculated target ["
            r8.<init>(r9)     // Catch:{ all -> 0x0500 }
            r8.append(r5)     // Catch:{ all -> 0x0500 }
            r8.append(r15)     // Catch:{ all -> 0x0500 }
            r8.append(r6)     // Catch:{ all -> 0x0500 }
            java.lang.String r9 = "] for source ["
            r8.append(r9)     // Catch:{ all -> 0x0500 }
            r8.append(r14)     // Catch:{ all -> 0x0500 }
            r8.append(r15)     // Catch:{ all -> 0x0500 }
            r8.append(r0)     // Catch:{ all -> 0x0500 }
            java.lang.String r9 = "], sampleSize: "
            r8.append(r9)     // Catch:{ all -> 0x0500 }
            r8.append(r3)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = ", targetDensity: "
            r8.append(r3)     // Catch:{ all -> 0x0500 }
            int r3 = r7.inTargetDensity     // Catch:{ all -> 0x0500 }
            r8.append(r3)     // Catch:{ all -> 0x0500 }
            r8.append(r1)     // Catch:{ all -> 0x0500 }
            int r3 = r7.inDensity     // Catch:{ all -> 0x0500 }
            r8.append(r3)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = ", density multiplier: "
            r8.append(r3)     // Catch:{ all -> 0x0500 }
            r8.append(r2)     // Catch:{ all -> 0x0500 }
        L_0x03eb:
            r2 = r5
        L_0x03ec:
            if (r2 <= 0) goto L_0x0409
            if (r6 <= 0) goto L_0x0409
            com.bumptech.glide.load.b.a.e r3 = r4.l     // Catch:{ all -> 0x0500 }
            r5 = 0
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0500 }
            if (r8 < r10) goto L_0x03ff
            android.graphics.Bitmap$Config r5 = r7.inPreferredConfig     // Catch:{ all -> 0x0500 }
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.HARDWARE     // Catch:{ all -> 0x0500 }
            if (r5 == r8) goto L_0x0409
            android.graphics.Bitmap$Config r5 = r7.outConfig     // Catch:{ all -> 0x0500 }
        L_0x03ff:
            if (r5 != 0) goto L_0x0403
            android.graphics.Bitmap$Config r5 = r7.inPreferredConfig     // Catch:{ all -> 0x0500 }
        L_0x0403:
            android.graphics.Bitmap r2 = r3.b(r2, r6, r5)     // Catch:{ all -> 0x0500 }
            r7.inBitmap = r2     // Catch:{ all -> 0x0500 }
        L_0x0409:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0500 }
            r3 = 28
            if (r2 < r3) goto L_0x0431
            com.bumptech.glide.load.j r2 = com.bumptech.glide.load.j.DISPLAY_P3     // Catch:{ all -> 0x0500 }
            r9 = r20
            if (r9 != r2) goto L_0x0422
            android.graphics.ColorSpace r2 = r7.outColorSpace     // Catch:{ all -> 0x0500 }
            if (r2 == 0) goto L_0x0422
            android.graphics.ColorSpace r2 = r7.outColorSpace     // Catch:{ all -> 0x0500 }
            boolean r2 = r2.isWideGamut()     // Catch:{ all -> 0x0500 }
            if (r2 == 0) goto L_0x0422
            goto L_0x0423
        L_0x0422:
            r11 = 0
        L_0x0423:
            if (r11 == 0) goto L_0x0428
            android.graphics.ColorSpace$Named r2 = android.graphics.ColorSpace.Named.DISPLAY_P3     // Catch:{ all -> 0x0500 }
            goto L_0x042a
        L_0x0428:
            android.graphics.ColorSpace$Named r2 = android.graphics.ColorSpace.Named.SRGB     // Catch:{ all -> 0x0500 }
        L_0x042a:
            android.graphics.ColorSpace r2 = android.graphics.ColorSpace.get(r2)     // Catch:{ all -> 0x0500 }
            r7.inPreferredColorSpace = r2     // Catch:{ all -> 0x0500 }
            goto L_0x043d
        L_0x0431:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0500 }
            if (r2 < r10) goto L_0x043d
            android.graphics.ColorSpace$Named r2 = android.graphics.ColorSpace.Named.SRGB     // Catch:{ all -> 0x0500 }
            android.graphics.ColorSpace r2 = android.graphics.ColorSpace.get(r2)     // Catch:{ all -> 0x0500 }
            r7.inPreferredColorSpace = r2     // Catch:{ all -> 0x0500 }
        L_0x043d:
            com.bumptech.glide.load.b.a.e r2 = r4.l     // Catch:{ all -> 0x0500 }
            r3 = r40
            r5 = r0
            r0 = r36
            android.graphics.Bitmap r0 = b(r0, r7, r3, r2)     // Catch:{ all -> 0x0500 }
            com.bumptech.glide.load.b.a.e r2 = r4.l     // Catch:{ all -> 0x0500 }
            r3.a(r2, r0)     // Catch:{ all -> 0x0500 }
            r2 = 2
            boolean r2 = android.util.Log.isLoggable(r13, r2)     // Catch:{ all -> 0x0500 }
            if (r2 == 0) goto L_0x04d2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = "Decoded "
            r2.<init>(r3)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0500 }
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = " from ["
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            r2.append(r14)     // Catch:{ all -> 0x0500 }
            r2.append(r15)     // Catch:{ all -> 0x0500 }
            r2.append(r5)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = "] "
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            r3 = r16
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = " with inBitmap "
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            android.graphics.Bitmap r3 = r7.inBitmap     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = a((android.graphics.Bitmap) r3)     // Catch:{ all -> 0x0500 }
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = " for ["
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            r3 = r37
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            r2.append(r15)     // Catch:{ all -> 0x0500 }
            r3 = r38
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            java.lang.String r3 = "], sample size: "
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            int r3 = r7.inSampleSize     // Catch:{ all -> 0x0500 }
            r2.append(r3)     // Catch:{ all -> 0x0500 }
            r2.append(r1)     // Catch:{ all -> 0x0500 }
            int r1 = r7.inDensity     // Catch:{ all -> 0x0500 }
            r2.append(r1)     // Catch:{ all -> 0x0500 }
            java.lang.String r1 = ", target density: "
            r2.append(r1)     // Catch:{ all -> 0x0500 }
            int r1 = r7.inTargetDensity     // Catch:{ all -> 0x0500 }
            r2.append(r1)     // Catch:{ all -> 0x0500 }
            java.lang.String r1 = ", thread: "
            r2.append(r1)     // Catch:{ all -> 0x0500 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0500 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0500 }
            r2.append(r1)     // Catch:{ all -> 0x0500 }
            java.lang.String r1 = ", duration: "
            r2.append(r1)     // Catch:{ all -> 0x0500 }
            double r5 = com.bumptech.glide.g.f.a(r18)     // Catch:{ all -> 0x0500 }
            r2.append(r5)     // Catch:{ all -> 0x0500 }
        L_0x04d2:
            r1 = 0
            if (r0 == 0) goto L_0x04ef
            android.util.DisplayMetrics r1 = r4.m     // Catch:{ all -> 0x0500 }
            int r1 = r1.densityDpi     // Catch:{ all -> 0x0500 }
            r0.setDensity(r1)     // Catch:{ all -> 0x0500 }
            com.bumptech.glide.load.b.a.e r1 = r4.l     // Catch:{ all -> 0x0500 }
            r2 = r39
            android.graphics.Bitmap r1 = com.bumptech.glide.load.d.a.ad.a((com.bumptech.glide.load.b.a.e) r1, (android.graphics.Bitmap) r0, (int) r2)     // Catch:{ all -> 0x0500 }
            boolean r2 = r0.equals(r1)     // Catch:{ all -> 0x0500 }
            if (r2 != 0) goto L_0x04ef
            com.bumptech.glide.load.b.a.e r2 = r4.l     // Catch:{ all -> 0x0500 }
            r2.a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0500 }
        L_0x04ef:
            com.bumptech.glide.load.b.a.e r0 = r4.l     // Catch:{ all -> 0x0500 }
            com.bumptech.glide.load.d.a.e r0 = com.bumptech.glide.load.d.a.e.a(r1, r0)     // Catch:{ all -> 0x0500 }
            b(r7)
            com.bumptech.glide.load.b.a.b r1 = r4.f7166g
            r6 = r17
            r1.a(r6)
            return r0
        L_0x0500:
            r0 = move-exception
            goto L_0x0508
        L_0x0502:
            r0 = move-exception
            r4 = r35
            goto L_0x0508
        L_0x0506:
            r0 = move-exception
            r4 = r1
        L_0x0508:
            r6 = r17
            goto L_0x050d
        L_0x050b:
            r0 = move-exception
            r4 = r1
        L_0x050d:
            b(r7)
            com.bumptech.glide.load.b.a.b r1 = r4.f7166g
            r1.a(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.o.a(com.bumptech.glide.load.d.a.u, int, int, com.bumptech.glide.load.i, com.bumptech.glide.load.d.a.o$a):com.bumptech.glide.load.b.v");
    }

    private static int a(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] a(u uVar, BitmapFactory.Options options, a aVar, e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        b(uVar, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        throw r4;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0075 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap b(com.bumptech.glide.load.d.a.u r7, android.graphics.BitmapFactory.Options r8, com.bumptech.glide.load.d.a.o.a r9, com.bumptech.glide.load.b.a.e r10) throws java.io.IOException {
        /*
            boolean r0 = r8.inJustDecodeBounds
            if (r0 != 0) goto L_0x000a
            r9.a()
            r7.c()
        L_0x000a:
            int r0 = r8.outWidth
            int r1 = r8.outHeight
            java.lang.String r2 = r8.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.d.a.ad.a()
            r3.lock()
            android.graphics.Bitmap r7 = r7.a(r8)     // Catch:{ IllegalArgumentException -> 0x0025 }
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.d.a.ad.a()
            r8.unlock()
            return r7
        L_0x0023:
            r7 = move-exception
            goto L_0x0077
        L_0x0025:
            r3 = move-exception
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0023 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            r5.<init>(r6)     // Catch:{ all -> 0x0023 }
            r5.append(r0)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = ", outHeight: "
            r5.append(r0)     // Catch:{ all -> 0x0023 }
            r5.append(r1)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = ", outMimeType: "
            r5.append(r0)     // Catch:{ all -> 0x0023 }
            r5.append(r2)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = ", inBitmap: "
            r5.append(r0)     // Catch:{ all -> 0x0023 }
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0023 }
            r5.append(r0)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0023 }
            r4.<init>(r0, r3)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = "Downsampler"
            r1 = 3
            android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0023 }
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0076
            android.graphics.Bitmap r0 = r8.inBitmap     // Catch:{ IOException -> 0x0075 }
            r10.a((android.graphics.Bitmap) r0)     // Catch:{ IOException -> 0x0075 }
            r0 = 0
            r8.inBitmap = r0     // Catch:{ IOException -> 0x0075 }
            android.graphics.Bitmap r7 = b(r7, r8, r9, r10)     // Catch:{ IOException -> 0x0075 }
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.d.a.ad.a()
            r8.unlock()
            return r7
        L_0x0075:
            throw r4     // Catch:{ all -> 0x0023 }
        L_0x0076:
            throw r4     // Catch:{ all -> 0x0023 }
        L_0x0077:
            java.util.concurrent.locks.Lock r8 = com.bumptech.glide.load.d.a.ad.a()
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.o.b(com.bumptech.glide.load.d.a.u, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.d.a.o$a, com.bumptech.glide.load.b.a.e):android.graphics.Bitmap");
    }

    private static boolean a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options b() {
        BitmapFactory.Options poll;
        synchronized (o.class) {
            synchronized (k) {
                poll = k.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                c(poll);
            }
        }
        return poll;
    }

    private static void b(BitmapFactory.Options options) {
        c(options);
        synchronized (k) {
            k.offer(options);
        }
    }

    private static void c(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
