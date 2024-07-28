package com.google.android.exoplayer2.e.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.q;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import net.one97.paytm.upi.util.UpiConstants;

final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f31455b = {0, 7, 8, 15};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f31456c = {0, 119, -120, -1};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f31457d = {0, 17, 34, TarHeader.LF_CHR, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a  reason: collision with root package name */
    final h f31458a;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f31459e = new Paint();

    /* renamed from: f  reason: collision with root package name */
    private final Paint f31460f;

    /* renamed from: g  reason: collision with root package name */
    private final Canvas f31461g;

    /* renamed from: h  reason: collision with root package name */
    private final C0535b f31462h;

    /* renamed from: i  reason: collision with root package name */
    private final a f31463i;
    private Bitmap j;

    private static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    public b(int i2, int i3) {
        this.f31459e.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f31459e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f31459e.setPathEffect((PathEffect) null);
        this.f31460f = new Paint();
        this.f31460f.setStyle(Paint.Style.FILL);
        this.f31460f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f31460f.setPathEffect((PathEffect) null);
        this.f31461g = new Canvas();
        this.f31462h = new C0535b(719, 575, 0, 719, 0, 575);
        this.f31463i = new a(0, a(), b(), c());
        this.f31458a = new h(i2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.exoplayer2.e.b> a(byte[] r27, int r28) {
        /*
            r26 = this;
            r0 = r26
            com.google.android.exoplayer2.g.q r1 = new com.google.android.exoplayer2.g.q
            r2 = r27
            r3 = r28
            r1.<init>(r2, r3)
        L_0x000b:
            int r2 = r1.a()
            r3 = 48
            r4 = 3
            r5 = 2
            r7 = 1
            if (r2 < r3) goto L_0x0174
            r2 = 8
            int r3 = r1.c(r2)
            r8 = 15
            if (r3 != r8) goto L_0x0174
            com.google.android.exoplayer2.e.b.b$h r3 = r0.f31458a
            int r8 = r1.c(r2)
            r9 = 16
            int r10 = r1.c(r9)
            int r11 = r1.c(r9)
            int r12 = r1.c()
            int r12 = r12 + r11
            int r13 = r11 * 8
            int r14 = r1.a()
            if (r13 <= r14) goto L_0x0048
            com.google.android.exoplayer2.g.l.c()
            int r2 = r1.a()
            r1.b(r2)
            goto L_0x000b
        L_0x0048:
            r13 = 4
            switch(r8) {
                case 16: goto L_0x00fa;
                case 17: goto L_0x00d5;
                case 18: goto L_0x00b3;
                case 19: goto L_0x0091;
                case 20: goto L_0x004e;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x015b
        L_0x004e:
            int r2 = r3.f31499a
            if (r10 != r2) goto L_0x015b
            r1.b(r13)
            boolean r2 = r1.e()
            r1.b(r4)
            int r14 = r1.c(r9)
            int r15 = r1.c(r9)
            if (r2 == 0) goto L_0x007f
            int r2 = r1.c(r9)
            int r4 = r1.c(r9)
            int r5 = r1.c(r9)
            int r8 = r1.c(r9)
            r16 = r2
            r17 = r4
            r18 = r5
            r19 = r8
            goto L_0x0087
        L_0x007f:
            r17 = r14
            r19 = r15
            r16 = 0
            r18 = 0
        L_0x0087:
            com.google.android.exoplayer2.e.b.b$b r2 = new com.google.android.exoplayer2.e.b.b$b
            r13 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r3.f31506h = r2
            goto L_0x015b
        L_0x0091:
            int r2 = r3.f31499a
            if (r10 != r2) goto L_0x00a2
            com.google.android.exoplayer2.e.b.b$c r2 = a(r1)
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$c> r3 = r3.f31503e
            int r4 = r2.f31474a
            r3.put(r4, r2)
            goto L_0x015b
        L_0x00a2:
            int r2 = r3.f31500b
            if (r10 != r2) goto L_0x015b
            com.google.android.exoplayer2.e.b.b$c r2 = a(r1)
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$c> r3 = r3.f31505g
            int r4 = r2.f31474a
            r3.put(r4, r2)
            goto L_0x015b
        L_0x00b3:
            int r2 = r3.f31499a
            if (r10 != r2) goto L_0x00c4
            com.google.android.exoplayer2.e.b.b$a r2 = b(r1, r11)
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$a> r3 = r3.f31502d
            int r4 = r2.f31464a
            r3.put(r4, r2)
            goto L_0x015b
        L_0x00c4:
            int r2 = r3.f31500b
            if (r10 != r2) goto L_0x015b
            com.google.android.exoplayer2.e.b.b$a r2 = b(r1, r11)
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$a> r3 = r3.f31504f
            int r4 = r2.f31464a
            r3.put(r4, r2)
            goto L_0x015b
        L_0x00d5:
            com.google.android.exoplayer2.e.b.b$d r2 = r3.f31507i
            int r4 = r3.f31499a
            if (r10 != r4) goto L_0x015b
            if (r2 == 0) goto L_0x015b
            com.google.android.exoplayer2.e.b.b$f r4 = a((com.google.android.exoplayer2.g.q) r1, (int) r11)
            int r2 = r2.f31480c
            if (r2 != 0) goto L_0x00f2
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$f> r2 = r3.f31501c
            int r5 = r4.f31484a
            java.lang.Object r2 = r2.get(r5)
            com.google.android.exoplayer2.e.b.b$f r2 = (com.google.android.exoplayer2.e.b.b.f) r2
            r4.a(r2)
        L_0x00f2:
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$f> r2 = r3.f31501c
            int r3 = r4.f31484a
            r2.put(r3, r4)
            goto L_0x015b
        L_0x00fa:
            int r4 = r3.f31499a
            if (r10 != r4) goto L_0x015b
            com.google.android.exoplayer2.e.b.b$d r4 = r3.f31507i
            int r8 = r1.c(r2)
            int r10 = r1.c(r13)
            int r13 = r1.c(r5)
            r1.b(r5)
            int r11 = r11 + -2
            android.util.SparseArray r5 = new android.util.SparseArray
            r5.<init>()
        L_0x0116:
            if (r11 <= 0) goto L_0x0136
            int r14 = r1.c(r2)
            r1.b(r2)
            int r15 = r1.c(r9)
            int r2 = r1.c(r9)
            int r11 = r11 + -6
            com.google.android.exoplayer2.e.b.b$e r9 = new com.google.android.exoplayer2.e.b.b$e
            r9.<init>(r15, r2)
            r5.put(r14, r9)
            r2 = 8
            r9 = 16
            goto L_0x0116
        L_0x0136:
            com.google.android.exoplayer2.e.b.b$d r2 = new com.google.android.exoplayer2.e.b.b$d
            r2.<init>(r8, r10, r13, r5)
            int r5 = r2.f31480c
            if (r5 == 0) goto L_0x0151
            r3.f31507i = r2
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$f> r2 = r3.f31501c
            r2.clear()
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$a> r2 = r3.f31502d
            r2.clear()
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$c> r2 = r3.f31503e
            r2.clear()
            goto L_0x015b
        L_0x0151:
            if (r4 == 0) goto L_0x015b
            int r4 = r4.f31479b
            int r5 = r2.f31479b
            if (r4 == r5) goto L_0x015b
            r3.f31507i = r2
        L_0x015b:
            int r2 = r1.c()
            int r12 = r12 - r2
            int r2 = r1.f32564c
            if (r2 != 0) goto L_0x0166
            r6 = 1
            goto L_0x0167
        L_0x0166:
            r6 = 0
        L_0x0167:
            com.google.android.exoplayer2.g.a.b(r6)
            int r2 = r1.f32563b
            int r2 = r2 + r12
            r1.f32563b = r2
            r1.g()
            goto L_0x000b
        L_0x0174:
            com.google.android.exoplayer2.e.b.b$h r1 = r0.f31458a
            com.google.android.exoplayer2.e.b.b$d r1 = r1.f31507i
            if (r1 != 0) goto L_0x017f
            java.util.List r1 = java.util.Collections.emptyList()
            return r1
        L_0x017f:
            com.google.android.exoplayer2.e.b.b$h r1 = r0.f31458a
            com.google.android.exoplayer2.e.b.b$b r1 = r1.f31506h
            if (r1 == 0) goto L_0x018a
            com.google.android.exoplayer2.e.b.b$h r1 = r0.f31458a
            com.google.android.exoplayer2.e.b.b$b r1 = r1.f31506h
            goto L_0x018c
        L_0x018a:
            com.google.android.exoplayer2.e.b.b$b r1 = r0.f31462h
        L_0x018c:
            android.graphics.Bitmap r2 = r0.j
            if (r2 == 0) goto L_0x01a6
            int r2 = r1.f31468a
            int r2 = r2 + r7
            android.graphics.Bitmap r3 = r0.j
            int r3 = r3.getWidth()
            if (r2 != r3) goto L_0x01a6
            int r2 = r1.f31469b
            int r2 = r2 + r7
            android.graphics.Bitmap r3 = r0.j
            int r3 = r3.getHeight()
            if (r2 == r3) goto L_0x01bb
        L_0x01a6:
            int r2 = r1.f31468a
            int r2 = r2 + r7
            int r3 = r1.f31469b
            int r3 = r3 + r7
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r3, r8)
            r0.j = r2
            android.graphics.Canvas r2 = r0.f31461g
            android.graphics.Bitmap r3 = r0.j
            r2.setBitmap(r3)
        L_0x01bb:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.google.android.exoplayer2.e.b.b$h r3 = r0.f31458a
            com.google.android.exoplayer2.e.b.b$d r3 = r3.f31507i
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$e> r3 = r3.f31481d
            r8 = 0
        L_0x01c7:
            int r9 = r3.size()
            if (r8 >= r9) goto L_0x0336
            android.graphics.Canvas r9 = r0.f31461g
            r9.save()
            java.lang.Object r9 = r3.valueAt(r8)
            com.google.android.exoplayer2.e.b.b$e r9 = (com.google.android.exoplayer2.e.b.b.e) r9
            int r10 = r3.keyAt(r8)
            com.google.android.exoplayer2.e.b.b$h r11 = r0.f31458a
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$f> r11 = r11.f31501c
            java.lang.Object r10 = r11.get(r10)
            com.google.android.exoplayer2.e.b.b$f r10 = (com.google.android.exoplayer2.e.b.b.f) r10
            int r11 = r9.f31482a
            int r12 = r1.f31470c
            int r11 = r11 + r12
            int r9 = r9.f31483b
            int r12 = r1.f31472e
            int r9 = r9 + r12
            int r12 = r10.f31486c
            int r12 = r12 + r11
            int r13 = r1.f31471d
            int r12 = java.lang.Math.min(r12, r13)
            int r13 = r10.f31487d
            int r13 = r13 + r9
            int r14 = r1.f31473f
            int r13 = java.lang.Math.min(r13, r14)
            android.graphics.Canvas r14 = r0.f31461g
            r14.clipRect(r11, r9, r12, r13)
            com.google.android.exoplayer2.e.b.b$h r12 = r0.f31458a
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$a> r12 = r12.f31502d
            int r13 = r10.f31490g
            java.lang.Object r12 = r12.get(r13)
            com.google.android.exoplayer2.e.b.b$a r12 = (com.google.android.exoplayer2.e.b.b.a) r12
            if (r12 != 0) goto L_0x0225
            com.google.android.exoplayer2.e.b.b$h r12 = r0.f31458a
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$a> r12 = r12.f31504f
            int r13 = r10.f31490g
            java.lang.Object r12 = r12.get(r13)
            com.google.android.exoplayer2.e.b.b$a r12 = (com.google.android.exoplayer2.e.b.b.a) r12
            if (r12 != 0) goto L_0x0225
            com.google.android.exoplayer2.e.b.b$a r12 = r0.f31463i
        L_0x0225:
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$g> r13 = r10.k
            r14 = 0
        L_0x0228:
            int r15 = r13.size()
            if (r14 >= r15) goto L_0x02ab
            int r15 = r13.keyAt(r14)
            java.lang.Object r16 = r13.valueAt(r14)
            r6 = r16
            com.google.android.exoplayer2.e.b.b$g r6 = (com.google.android.exoplayer2.e.b.b.g) r6
            com.google.android.exoplayer2.e.b.b$h r7 = r0.f31458a
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$c> r7 = r7.f31503e
            java.lang.Object r7 = r7.get(r15)
            com.google.android.exoplayer2.e.b.b$c r7 = (com.google.android.exoplayer2.e.b.b.c) r7
            if (r7 != 0) goto L_0x0250
            com.google.android.exoplayer2.e.b.b$h r7 = r0.f31458a
            android.util.SparseArray<com.google.android.exoplayer2.e.b.b$c> r7 = r7.f31505g
            java.lang.Object r7 = r7.get(r15)
            com.google.android.exoplayer2.e.b.b$c r7 = (com.google.android.exoplayer2.e.b.b.c) r7
        L_0x0250:
            if (r7 == 0) goto L_0x0297
            boolean r15 = r7.f31475b
            if (r15 == 0) goto L_0x0258
            r15 = 0
            goto L_0x025a
        L_0x0258:
            android.graphics.Paint r15 = r0.f31459e
        L_0x025a:
            int r5 = r10.f31489f
            int r4 = r6.f31495c
            int r4 = r4 + r11
            int r6 = r6.f31496d
            int r6 = r6 + r9
            r23 = r3
            android.graphics.Canvas r3 = r0.f31461g
            r24 = r13
            r13 = 3
            if (r5 != r13) goto L_0x0270
            int[] r13 = r12.f31467d
        L_0x026d:
            r25 = r8
            goto L_0x0279
        L_0x0270:
            r13 = 2
            if (r5 != r13) goto L_0x0276
            int[] r13 = r12.f31466c
            goto L_0x026d
        L_0x0276:
            int[] r13 = r12.f31465b
            goto L_0x026d
        L_0x0279:
            byte[] r8 = r7.f31476c
            r16 = r8
            r17 = r13
            r18 = r5
            r19 = r4
            r20 = r6
            r21 = r15
            r22 = r3
            a(r16, r17, r18, r19, r20, r21, r22)
            byte[] r7 = r7.f31477d
            r8 = 1
            int r20 = r6 + 1
            r16 = r7
            a(r16, r17, r18, r19, r20, r21, r22)
            goto L_0x029e
        L_0x0297:
            r23 = r3
            r25 = r8
            r24 = r13
            r8 = 1
        L_0x029e:
            int r14 = r14 + 1
            r3 = r23
            r13 = r24
            r8 = r25
            r4 = 3
            r5 = 2
            r7 = 1
            goto L_0x0228
        L_0x02ab:
            r23 = r3
            r25 = r8
            r8 = 1
            boolean r3 = r10.f31485b
            if (r3 == 0) goto L_0x02ee
            int r3 = r10.f31489f
            r4 = 3
            if (r3 != r4) goto L_0x02c1
            int[] r3 = r12.f31467d
            int r5 = r10.f31491h
            r3 = r3[r5]
            r5 = 2
            goto L_0x02d3
        L_0x02c1:
            int r3 = r10.f31489f
            r5 = 2
            if (r3 != r5) goto L_0x02cd
            int[] r3 = r12.f31466c
            int r6 = r10.f31492i
            r3 = r3[r6]
            goto L_0x02d3
        L_0x02cd:
            int[] r3 = r12.f31465b
            int r6 = r10.j
            r3 = r3[r6]
        L_0x02d3:
            android.graphics.Paint r6 = r0.f31460f
            r6.setColor(r3)
            android.graphics.Canvas r12 = r0.f31461g
            float r13 = (float) r11
            float r14 = (float) r9
            int r3 = r10.f31486c
            int r3 = r3 + r11
            float r15 = (float) r3
            int r3 = r10.f31487d
            int r3 = r3 + r9
            float r3 = (float) r3
            android.graphics.Paint r6 = r0.f31460f
            r16 = r3
            r17 = r6
            r12.drawRect(r13, r14, r15, r16, r17)
            goto L_0x02f0
        L_0x02ee:
            r4 = 3
            r5 = 2
        L_0x02f0:
            android.graphics.Bitmap r3 = r0.j
            int r6 = r10.f31486c
            int r7 = r10.f31487d
            android.graphics.Bitmap r13 = android.graphics.Bitmap.createBitmap(r3, r11, r9, r6, r7)
            com.google.android.exoplayer2.e.b r3 = new com.google.android.exoplayer2.e.b
            float r6 = (float) r11
            int r7 = r1.f31468a
            float r7 = (float) r7
            float r14 = r6 / r7
            float r6 = (float) r9
            int r7 = r1.f31469b
            float r7 = (float) r7
            float r15 = r6 / r7
            r16 = 0
            int r6 = r10.f31486c
            float r6 = (float) r6
            int r7 = r1.f31468a
            float r7 = (float) r7
            float r17 = r6 / r7
            int r6 = r10.f31487d
            float r6 = (float) r6
            int r7 = r1.f31469b
            float r7 = (float) r7
            float r18 = r6 / r7
            r12 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18)
            r2.add(r3)
            android.graphics.Canvas r3 = r0.f31461g
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.CLEAR
            r7 = 0
            r3.drawColor(r7, r6)
            android.graphics.Canvas r3 = r0.f31461g
            r3.restore()
            int r3 = r25 + 1
            r8 = r3
            r3 = r23
            r7 = 1
            goto L_0x01c7
        L_0x0336:
            java.util.List r1 = java.util.Collections.unmodifiableList(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.b.a(byte[], int):java.util.List");
    }

    private static f a(q qVar, int i2) {
        int i3;
        int i4;
        q qVar2 = qVar;
        int c2 = qVar2.c(8);
        qVar2.b(4);
        boolean e2 = qVar.e();
        qVar2.b(3);
        int i5 = 16;
        int c3 = qVar2.c(16);
        int c4 = qVar2.c(16);
        int c5 = qVar2.c(3);
        int c6 = qVar2.c(3);
        int i6 = 2;
        qVar2.b(2);
        int c7 = qVar2.c(8);
        int c8 = qVar2.c(8);
        int c9 = qVar2.c(4);
        int c10 = qVar2.c(2);
        qVar2.b(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int c11 = qVar2.c(i5);
            int c12 = qVar2.c(i6);
            int c13 = qVar2.c(i6);
            int c14 = qVar2.c(12);
            int i8 = c10;
            qVar2.b(4);
            int c15 = qVar2.c(12);
            i7 -= 6;
            if (c12 == 1 || c12 == 2) {
                i7 -= 2;
                i4 = qVar2.c(8);
                i3 = qVar2.c(8);
            } else {
                i4 = 0;
                i3 = 0;
            }
            sparseArray.put(c11, new g(c12, c13, c14, c15, i4, i3));
            c10 = i8;
            i6 = 2;
            i5 = 16;
        }
        return new f(c2, e2, c3, c4, c5, c6, c7, c8, c9, c10, sparseArray);
    }

    private static a b(q qVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        q qVar2 = qVar;
        int i8 = 8;
        int c2 = qVar2.c(8);
        qVar2.b(8);
        int i9 = 2;
        int i10 = i2 - 2;
        int[] a2 = a();
        int[] b2 = b();
        int[] c3 = c();
        while (i10 > 0) {
            int c4 = qVar2.c(i8);
            int c5 = qVar2.c(i8);
            int i11 = i10 - 2;
            int[] iArr = (c5 & 128) != 0 ? a2 : (c5 & 64) != 0 ? b2 : c3;
            if ((c5 & 1) != 0) {
                i6 = qVar2.c(i8);
                i5 = qVar2.c(i8);
                i4 = qVar2.c(i8);
                i3 = qVar2.c(i8);
                i7 = i11 - 4;
            } else {
                i4 = qVar2.c(4) << 4;
                i7 = i11 - 2;
                int c6 = qVar2.c(4) << 4;
                i3 = qVar2.c(i9) << 6;
                i6 = qVar2.c(6) << i9;
                i5 = c6;
            }
            if (i6 == 0) {
                i5 = 0;
                i4 = 0;
                i3 = PriceRangeSeekBar.INVALID_POINTER_ID;
            }
            double d2 = (double) i6;
            double d3 = (double) (i5 - 128);
            double d4 = (double) (i4 - 128);
            iArr[c4] = a((byte) (255 - (i3 & PriceRangeSeekBar.INVALID_POINTER_ID)), ae.a((int) (d2 + (1.402d * d3)), 0, (int) PriceRangeSeekBar.INVALID_POINTER_ID), ae.a((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, (int) PriceRangeSeekBar.INVALID_POINTER_ID), ae.a((int) (d2 + (d4 * 1.772d)), 0, (int) PriceRangeSeekBar.INVALID_POINTER_ID));
            i10 = i7;
            c2 = c2;
            i8 = 8;
            i9 = 2;
        }
        return new a(c2, a2, b2, c3);
    }

    private static c a(q qVar) {
        byte[] bArr;
        int c2 = qVar.c(16);
        qVar.b(4);
        int c3 = qVar.c(2);
        boolean e2 = qVar.e();
        qVar.b(1);
        byte[] bArr2 = null;
        if (c3 == 1) {
            qVar.b(qVar.c(8) * 16);
        } else if (c3 == 0) {
            int c4 = qVar.c(16);
            int c5 = qVar.c(16);
            if (c4 > 0) {
                bArr2 = new byte[c4];
                qVar.c(bArr2, c4);
            }
            if (c5 > 0) {
                bArr = new byte[c5];
                qVar.c(bArr, c5);
                return new c(c2, e2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(c2, e2, bArr2, bArr);
    }

    private static int[] a() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = a(PriceRangeSeekBar.INVALID_POINTER_ID, (i2 & 1) != 0 ? PriceRangeSeekBar.INVALID_POINTER_ID : 0, (i2 & 2) != 0 ? PriceRangeSeekBar.INVALID_POINTER_ID : 0, (i2 & 4) != 0 ? PriceRangeSeekBar.INVALID_POINTER_ID : 0);
            } else {
                int i3 = 127;
                int i4 = (i2 & 1) != 0 ? 127 : 0;
                int i5 = (i2 & 2) != 0 ? 127 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(PriceRangeSeekBar.INVALID_POINTER_ID, i4, i5, i3);
            }
        }
        return iArr;
    }

    private static int[] c() {
        int[] iArr = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = PriceRangeSeekBar.INVALID_POINTER_ID;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? PriceRangeSeekBar.INVALID_POINTER_ID : 0;
                int i5 = (i2 & 2) != 0 ? PriceRangeSeekBar.INVALID_POINTER_ID : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(63, i4, i5, i3);
            } else {
                int i6 = i2 & 136;
                int i7 = 170;
                int i8 = 85;
                if (i6 == 0) {
                    int i9 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i10 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(PriceRangeSeekBar.INVALID_POINTER_ID, i9, i10, i8 + i7);
                } else if (i6 != 8) {
                    int i11 = 43;
                    if (i6 == 128) {
                        int i12 = ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0);
                        int i13 = ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        int i14 = i11 + 127;
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(PriceRangeSeekBar.INVALID_POINTER_ID, i12, i13, i14 + i8);
                    } else if (i6 == 136) {
                        int i15 = ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0);
                        int i16 = ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(PriceRangeSeekBar.INVALID_POINTER_ID, i15, i16, i11 + i8);
                    }
                } else {
                    int i17 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i18 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(127, i17, i18, i8 + i7);
                }
            }
        }
        return iArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v18, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v4, types: [byte] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f5 A[LOOP:3: B:82:0x015c->B:112:0x01f5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0136 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01f0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013c A[LOOP:2: B:35:0x009e->B:69:0x013c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            r0 = r24
            r7 = r27
            com.google.android.exoplayer2.g.q r8 = new com.google.android.exoplayer2.g.q
            r1 = r22
            r8.<init>(r1)
            r1 = r25
            r10 = r26
            r11 = 0
            r12 = 0
        L_0x0011:
            int r2 = r8.a()
            if (r2 == 0) goto L_0x01ff
            r13 = 8
            int r2 = r8.c(r13)
            r3 = 240(0xf0, float:3.36E-43)
            if (r2 == r3) goto L_0x01f9
            r14 = 3
            r15 = 4
            r16 = 0
            r6 = 1
            r5 = 2
            switch(r2) {
                case 16: goto L_0x0142;
                case 17: goto L_0x0092;
                case 18: goto L_0x003f;
                default: goto L_0x002a;
            }
        L_0x002a:
            switch(r2) {
                case 32: goto L_0x003a;
                case 33: goto L_0x0035;
                case 34: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0011
        L_0x002e:
            r2 = 16
            byte[] r11 = a(r2, r13, r8)
            goto L_0x0011
        L_0x0035:
            byte[] r11 = a(r15, r13, r8)
            goto L_0x0011
        L_0x003a:
            byte[] r12 = a(r15, r15, r8)
            goto L_0x0011
        L_0x003f:
            r14 = r1
            r1 = 0
        L_0x0041:
            int r2 = r8.c(r13)
            if (r2 == 0) goto L_0x004b
            r17 = r1
            r15 = 1
            goto L_0x006e
        L_0x004b:
            boolean r2 = r8.e()
            r3 = 7
            if (r2 != 0) goto L_0x0062
            int r2 = r8.c(r3)
            if (r2 == 0) goto L_0x005d
            r17 = r1
            r15 = r2
            r2 = 0
            goto L_0x006e
        L_0x005d:
            r2 = 0
            r15 = 0
            r17 = 1
            goto L_0x006e
        L_0x0062:
            int r2 = r8.c(r3)
            int r3 = r8.c(r13)
            r17 = r1
            r15 = r2
            r2 = r3
        L_0x006e:
            if (r15 == 0) goto L_0x0088
            if (r7 == 0) goto L_0x0088
            r1 = r23[r2]
            r7.setColor(r1)
            float r2 = (float) r14
            float r3 = (float) r10
            int r1 = r14 + r15
            float r4 = (float) r1
            int r1 = r10 + 1
            float r5 = (float) r1
            r1 = r28
            r9 = 1
            r6 = r27
            r1.drawRect(r2, r3, r4, r5, r6)
            goto L_0x0089
        L_0x0088:
            r9 = 1
        L_0x0089:
            int r14 = r14 + r15
            if (r17 == 0) goto L_0x008e
            r1 = r14
            goto L_0x0011
        L_0x008e:
            r1 = r17
            r6 = 1
            goto L_0x0041
        L_0x0092:
            r9 = 1
            if (r0 != r14) goto L_0x009a
            byte[] r2 = f31457d
            r17 = r2
            goto L_0x009c
        L_0x009a:
            r17 = 0
        L_0x009c:
            r6 = r1
            r1 = 0
        L_0x009e:
            int r2 = r8.c(r15)
            if (r2 == 0) goto L_0x00ab
            r19 = r1
            r3 = r2
        L_0x00a7:
            r18 = 1
            goto L_0x010b
        L_0x00ab:
            boolean r2 = r8.e()
            if (r2 != 0) goto L_0x00c5
            int r2 = r8.c(r14)
            if (r2 == 0) goto L_0x00bf
            int r2 = r2 + 2
            r19 = r1
            r18 = r2
            r3 = 0
            goto L_0x010b
        L_0x00bf:
            r3 = 0
            r18 = 0
            r19 = 1
            goto L_0x010b
        L_0x00c5:
            boolean r2 = r8.e()
            if (r2 != 0) goto L_0x00d9
            int r2 = r8.c(r5)
            int r2 = r2 + r15
            int r3 = r8.c(r15)
        L_0x00d4:
            r19 = r1
            r18 = r2
            goto L_0x010b
        L_0x00d9:
            int r2 = r8.c(r5)
            if (r2 == 0) goto L_0x0107
            if (r2 == r9) goto L_0x0101
            if (r2 == r5) goto L_0x00f6
            if (r2 == r14) goto L_0x00eb
            r19 = r1
            r3 = 0
            r18 = 0
            goto L_0x010b
        L_0x00eb:
            int r2 = r8.c(r13)
            int r2 = r2 + 25
            int r3 = r8.c(r15)
            goto L_0x00d4
        L_0x00f6:
            int r2 = r8.c(r15)
            int r2 = r2 + 9
            int r3 = r8.c(r15)
            goto L_0x00d4
        L_0x0101:
            r19 = r1
            r3 = 0
            r18 = 2
            goto L_0x010b
        L_0x0107:
            r19 = r1
            r3 = 0
            goto L_0x00a7
        L_0x010b:
            if (r18 == 0) goto L_0x012f
            if (r7 == 0) goto L_0x012f
            if (r17 == 0) goto L_0x0113
            byte r3 = r17[r3]
        L_0x0113:
            r1 = r23[r3]
            r7.setColor(r1)
            float r2 = (float) r6
            float r3 = (float) r10
            int r1 = r6 + r18
            float r4 = (float) r1
            int r1 = r10 + 1
            float r1 = (float) r1
            r20 = r1
            r1 = r28
            r15 = 2
            r5 = r20
            r20 = r6
            r6 = r27
            r1.drawRect(r2, r3, r4, r5, r6)
            goto L_0x0132
        L_0x012f:
            r20 = r6
            r15 = 2
        L_0x0132:
            int r6 = r20 + r18
            if (r19 == 0) goto L_0x013c
            r8.f()
        L_0x0139:
            r1 = r6
            goto L_0x0011
        L_0x013c:
            r1 = r19
            r5 = 2
            r15 = 4
            goto L_0x009e
        L_0x0142:
            r9 = 1
            r15 = 2
            if (r0 != r14) goto L_0x014f
            if (r11 != 0) goto L_0x014b
            byte[] r2 = f31456c
            goto L_0x014c
        L_0x014b:
            r2 = r11
        L_0x014c:
            r17 = r2
            goto L_0x015a
        L_0x014f:
            if (r0 != r15) goto L_0x0158
            if (r12 != 0) goto L_0x0156
            byte[] r2 = f31455b
            goto L_0x014c
        L_0x0156:
            r2 = r12
            goto L_0x014c
        L_0x0158:
            r17 = 0
        L_0x015a:
            r6 = r1
            r1 = 0
        L_0x015c:
            int r2 = r8.c(r15)
            if (r2 == 0) goto L_0x0169
            r19 = r1
            r3 = r2
        L_0x0165:
            r5 = 4
            r18 = 1
            goto L_0x01c3
        L_0x0169:
            boolean r2 = r8.e()
            if (r2 == 0) goto L_0x017e
            int r2 = r8.c(r14)
            int r2 = r2 + r14
            int r3 = r8.c(r15)
        L_0x0178:
            r19 = r1
            r18 = r2
            r5 = 4
            goto L_0x01c3
        L_0x017e:
            boolean r2 = r8.e()
            if (r2 == 0) goto L_0x0188
            r19 = r1
            r3 = 0
            goto L_0x0165
        L_0x0188:
            int r2 = r8.c(r15)
            if (r2 == 0) goto L_0x01bd
            if (r2 == r9) goto L_0x01b6
            if (r2 == r15) goto L_0x01a6
            if (r2 == r14) goto L_0x019b
            r19 = r1
            r3 = 0
            r5 = 4
            r18 = 0
            goto L_0x01c3
        L_0x019b:
            int r2 = r8.c(r13)
            int r2 = r2 + 29
            int r3 = r8.c(r15)
            goto L_0x0178
        L_0x01a6:
            r5 = 4
            int r2 = r8.c(r5)
            int r2 = r2 + 12
            int r3 = r8.c(r15)
            r19 = r1
            r18 = r2
            goto L_0x01c3
        L_0x01b6:
            r5 = 4
            r19 = r1
            r3 = 0
            r18 = 2
            goto L_0x01c3
        L_0x01bd:
            r5 = 4
            r3 = 0
            r18 = 0
            r19 = 1
        L_0x01c3:
            if (r18 == 0) goto L_0x01e8
            if (r7 == 0) goto L_0x01e8
            if (r17 == 0) goto L_0x01cb
            byte r3 = r17[r3]
        L_0x01cb:
            r1 = r23[r3]
            r7.setColor(r1)
            float r2 = (float) r6
            float r3 = (float) r10
            int r1 = r6 + r18
            float r4 = (float) r1
            int r1 = r10 + 1
            float r1 = (float) r1
            r20 = r1
            r1 = r28
            r21 = 4
            r5 = r20
            r20 = r6
            r6 = r27
            r1.drawRect(r2, r3, r4, r5, r6)
            goto L_0x01ec
        L_0x01e8:
            r20 = r6
            r21 = 4
        L_0x01ec:
            int r6 = r20 + r18
            if (r19 == 0) goto L_0x01f5
            r8.f()
            goto L_0x0139
        L_0x01f5:
            r1 = r19
            goto L_0x015c
        L_0x01f9:
            int r10 = r10 + 2
            r1 = r25
            goto L_0x0011
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.b.a(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] a(int i2, int i3, q qVar) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) qVar.c(i3);
        }
        return bArr;
    }

    static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final int f31499a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31500b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f31501c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<a> f31502d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<c> f31503e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<a> f31504f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<c> f31505g = new SparseArray<>();

        /* renamed from: h  reason: collision with root package name */
        public C0535b f31506h;

        /* renamed from: i  reason: collision with root package name */
        public d f31507i;

        public h(int i2, int i3) {
            this.f31499a = i2;
            this.f31500b = i3;
        }
    }

    /* renamed from: com.google.android.exoplayer2.e.b.b$b  reason: collision with other inner class name */
    static final class C0535b {

        /* renamed from: a  reason: collision with root package name */
        public final int f31468a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31469b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31470c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31471d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31472e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31473f;

        public C0535b(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f31468a = i2;
            this.f31469b = i3;
            this.f31470c = i4;
            this.f31471d = i5;
            this.f31472e = i6;
            this.f31473f = i7;
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f31478a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31479b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31480c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<e> f31481d;

        public d(int i2, int i3, int i4, SparseArray<e> sparseArray) {
            this.f31478a = i2;
            this.f31479b = i3;
            this.f31480c = i4;
            this.f31481d = sparseArray;
        }
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f31482a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31483b;

        public e(int i2, int i3) {
            this.f31482a = i2;
            this.f31483b = i3;
        }
    }

    static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f31484a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31485b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31486c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31487d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31488e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31489f;

        /* renamed from: g  reason: collision with root package name */
        public final int f31490g;

        /* renamed from: h  reason: collision with root package name */
        public final int f31491h;

        /* renamed from: i  reason: collision with root package name */
        public final int f31492i;
        public final int j;
        public final SparseArray<g> k;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.f31484a = i2;
            this.f31485b = z;
            this.f31486c = i3;
            this.f31487d = i4;
            this.f31488e = i5;
            this.f31489f = i6;
            this.f31490g = i7;
            this.f31491h = i8;
            this.f31492i = i9;
            this.j = i10;
            this.k = sparseArray;
        }

        public final void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.k;
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    this.k.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
                }
            }
        }
    }

    static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f31493a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31494b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31495c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31496d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31497e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31498f;

        public g(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f31493a = i2;
            this.f31494b = i3;
            this.f31495c = i4;
            this.f31496d = i5;
            this.f31497e = i6;
            this.f31498f = i7;
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f31464a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f31465b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f31466c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f31467d;

        public a(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f31464a = i2;
            this.f31465b = iArr;
            this.f31466c = iArr2;
            this.f31467d = iArr3;
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f31474a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31475b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f31476c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f31477d;

        public c(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            this.f31474a = i2;
            this.f31475b = z;
            this.f31476c = bArr;
            this.f31477d = bArr2;
        }
    }
}
