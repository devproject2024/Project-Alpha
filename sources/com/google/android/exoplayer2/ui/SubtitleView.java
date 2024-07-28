package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.e.a;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.g.ae;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View implements k {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f33561a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f33562b;

    /* renamed from: c  reason: collision with root package name */
    private int f33563c;

    /* renamed from: d  reason: collision with root package name */
    private float f33564d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33565e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33566f;

    /* renamed from: g  reason: collision with root package name */
    private a f33567g;

    /* renamed from: h  reason: collision with root package name */
    private float f33568h;

    private static float a(int i2, float f2, int i3, int i4) {
        float f3;
        if (i2 == 0) {
            f3 = (float) i4;
        } else if (i2 == 1) {
            f3 = (float) i3;
        } else if (i2 != 2) {
            return Float.MIN_VALUE;
        } else {
            return f2;
        }
        return f2 * f3;
    }

    public SubtitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33561a = new ArrayList();
        this.f33563c = 0;
        this.f33564d = 0.0533f;
        this.f33565e = true;
        this.f33566f = true;
        this.f33567g = a.f31388a;
        this.f33568h = 0.08f;
    }

    public final void a(List<b> list) {
        setCues(list);
    }

    public final void setCues(List<b> list) {
        int i2;
        if (this.f33562b != list) {
            this.f33562b = list;
            if (list == null) {
                i2 = 0;
            } else {
                i2 = list.size();
            }
            while (this.f33561a.size() < i2) {
                this.f33561a.add(new b(getContext()));
            }
            invalidate();
        }
    }

    public final void setFixedTextSize(int i2, float f2) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        a(2, TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }

    public final void setUserDefaultTextSize() {
        setFractionalTextSize(((ae.f32499a < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
    }

    public final void setFractionalTextSize(float f2) {
        setFractionalTextSize(f2, false);
    }

    public final void setFractionalTextSize(float f2, boolean z) {
        a(z ? 1 : 0, f2);
    }

    private void a(int i2, float f2) {
        if (this.f33563c != i2 || this.f33564d != f2) {
            this.f33563c = i2;
            this.f33564d = f2;
            invalidate();
        }
    }

    public final void setApplyEmbeddedStyles(boolean z) {
        if (this.f33565e != z || this.f33566f != z) {
            this.f33565e = z;
            this.f33566f = z;
            invalidate();
        }
    }

    public final void setApplyEmbeddedFontSizes(boolean z) {
        if (this.f33566f != z) {
            this.f33566f = z;
            invalidate();
        }
    }

    public final void setUserDefaultStyle() {
        setStyle((ae.f32499a < 19 || !((CaptioningManager) getContext().getSystemService("captioning")).isEnabled() || isInEditMode()) ? a.f31388a : getUserCaptionStyleV19());
    }

    public final void setStyle(a aVar) {
        if (this.f33567g != aVar) {
            this.f33567g = aVar;
            invalidate();
        }
    }

    public final void setBottomPaddingFraction(float f2) {
        if (this.f33568h != f2) {
            this.f33568h = f2;
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:166:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0449  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0547  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchDraw(android.graphics.Canvas r36) {
        /*
            r35 = this;
            r0 = r35
            r7 = r36
            java.util.List<com.google.android.exoplayer2.e.b> r8 = r0.f33562b
            if (r8 == 0) goto L_0x0570
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto L_0x0010
            goto L_0x0570
        L_0x0010:
            int r9 = r35.getHeight()
            int r10 = r35.getPaddingLeft()
            int r11 = r35.getPaddingTop()
            int r1 = r35.getWidth()
            int r2 = r35.getPaddingRight()
            int r12 = r1 - r2
            int r1 = r35.getPaddingBottom()
            int r13 = r9 - r1
            if (r13 <= r11) goto L_0x0570
            if (r12 > r10) goto L_0x0032
            goto L_0x0570
        L_0x0032:
            int r14 = r13 - r11
            int r1 = r0.f33563c
            float r2 = r0.f33564d
            float r15 = a(r1, r2, r9, r14)
            r6 = 0
            int r1 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x0042
            return
        L_0x0042:
            int r5 = r8.size()
            r3 = 0
        L_0x0047:
            if (r3 >= r5) goto L_0x0570
            java.lang.Object r1 = r8.get(r3)
            com.google.android.exoplayer2.e.b r1 = (com.google.android.exoplayer2.e.b) r1
            int r2 = r1.n
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r17 = 1
            if (r2 == r4) goto L_0x006b
            float r2 = r1.o
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x005e
            goto L_0x006b
        L_0x005e:
            int r2 = r1.n
            float r4 = r1.o
            float r2 = a(r2, r4, r9, r14)
            float r2 = java.lang.Math.max(r2, r6)
            goto L_0x006c
        L_0x006b:
            r2 = 0
        L_0x006c:
            java.util.List<com.google.android.exoplayer2.ui.b> r4 = r0.f33561a
            java.lang.Object r4 = r4.get(r3)
            com.google.android.exoplayer2.ui.b r4 = (com.google.android.exoplayer2.ui.b) r4
            boolean r6 = r0.f33565e
            r18 = r3
            boolean r3 = r0.f33566f
            r19 = r5
            com.google.android.exoplayer2.e.a r5 = r0.f33567g
            r20 = r8
            float r8 = r0.f33568h
            android.graphics.Bitmap r0 = r1.f31448d
            r21 = r9
            if (r0 != 0) goto L_0x008a
            r0 = 1
            goto L_0x008b
        L_0x008a:
            r0 = 0
        L_0x008b:
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r0 == 0) goto L_0x00bc
            java.lang.CharSequence r9 = r1.f31446b
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00a9
            boolean r9 = r1.l
            if (r9 == 0) goto L_0x00a0
            if (r6 == 0) goto L_0x00a0
            int r9 = r1.m
            goto L_0x00a2
        L_0x00a0:
            int r9 = r5.f31391d
        L_0x00a2:
            r22 = r9
            r9 = r22
            r22 = r14
            goto L_0x00c0
        L_0x00a9:
            r8 = r7
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r22 = r14
        L_0x00b4:
            r12 = r18
            r16 = r19
            r9 = 0
            r14 = 0
            goto L_0x0558
        L_0x00bc:
            r22 = r14
            r9 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x00c0:
            java.lang.CharSequence r14 = r4.f33587h
            java.lang.CharSequence r7 = r1.f31446b
            if (r14 == r7) goto L_0x00d1
            if (r14 == 0) goto L_0x00cf
            boolean r7 = r14.equals(r7)
            if (r7 == 0) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r7 = 0
            goto L_0x00d2
        L_0x00d1:
            r7 = 1
        L_0x00d2:
            if (r7 == 0) goto L_0x0182
            android.text.Layout$Alignment r7 = r4.f33588i
            android.text.Layout$Alignment r14 = r1.f31447c
            boolean r7 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r7, (java.lang.Object) r14)
            if (r7 == 0) goto L_0x0182
            android.graphics.Bitmap r7 = r4.j
            android.graphics.Bitmap r14 = r1.f31448d
            if (r7 != r14) goto L_0x0182
            float r7 = r4.k
            float r14 = r1.f31449e
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x0182
            int r7 = r4.l
            int r14 = r1.f31450f
            if (r7 != r14) goto L_0x0182
            int r7 = r4.m
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r14 = r1.f31451g
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            boolean r7 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r7, (java.lang.Object) r14)
            if (r7 == 0) goto L_0x0182
            float r7 = r4.n
            float r14 = r1.f31452h
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x0182
            int r7 = r4.o
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r14 = r1.f31453i
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            boolean r7 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r7, (java.lang.Object) r14)
            if (r7 == 0) goto L_0x0182
            float r7 = r4.p
            float r14 = r1.j
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x0182
            float r7 = r4.q
            float r14 = r1.k
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x0182
            boolean r7 = r4.r
            if (r7 != r6) goto L_0x0182
            boolean r7 = r4.s
            if (r7 != r3) goto L_0x0182
            int r7 = r4.t
            int r14 = r5.f31389b
            if (r7 != r14) goto L_0x0182
            int r7 = r4.u
            int r14 = r5.f31390c
            if (r7 != r14) goto L_0x0182
            int r7 = r4.v
            if (r7 != r9) goto L_0x0182
            int r7 = r4.x
            int r14 = r5.f31392e
            if (r7 != r14) goto L_0x0182
            int r7 = r4.w
            int r14 = r5.f31393f
            if (r7 != r14) goto L_0x0182
            android.text.TextPaint r7 = r4.f33585f
            android.graphics.Typeface r7 = r7.getTypeface()
            android.graphics.Typeface r14 = r5.f31394g
            boolean r7 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r7, (java.lang.Object) r14)
            if (r7 == 0) goto L_0x0182
            float r7 = r4.y
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 != 0) goto L_0x0182
            float r7 = r4.z
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0182
            float r7 = r4.A
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0182
            int r7 = r4.B
            if (r7 != r10) goto L_0x0182
            int r7 = r4.C
            if (r7 != r11) goto L_0x0182
            int r7 = r4.D
            if (r7 != r12) goto L_0x0182
            int r7 = r4.E
            if (r7 == r13) goto L_0x0207
        L_0x0182:
            java.lang.CharSequence r7 = r1.f31446b
            r4.f33587h = r7
            android.text.Layout$Alignment r7 = r1.f31447c
            r4.f33588i = r7
            android.graphics.Bitmap r7 = r1.f31448d
            r4.j = r7
            float r7 = r1.f31449e
            r4.k = r7
            int r7 = r1.f31450f
            r4.l = r7
            int r7 = r1.f31451g
            r4.m = r7
            float r7 = r1.f31452h
            r4.n = r7
            int r7 = r1.f31453i
            r4.o = r7
            float r7 = r1.j
            r4.p = r7
            float r1 = r1.k
            r4.q = r1
            r4.r = r6
            r4.s = r3
            int r1 = r5.f31389b
            r4.t = r1
            int r1 = r5.f31390c
            r4.u = r1
            r4.v = r9
            int r1 = r5.f31392e
            r4.x = r1
            int r1 = r5.f31393f
            r4.w = r1
            android.text.TextPaint r1 = r4.f33585f
            android.graphics.Typeface r3 = r5.f31394g
            r1.setTypeface(r3)
            r4.y = r15
            r4.z = r2
            r4.A = r8
            r4.B = r10
            r4.C = r11
            r4.D = r12
            r4.E = r13
            if (r0 == 0) goto L_0x03dc
            int r1 = r4.D
            int r2 = r4.B
            int r1 = r1 - r2
            int r2 = r4.E
            int r3 = r4.C
            int r2 = r2 - r3
            android.text.TextPaint r3 = r4.f33585f
            float r5 = r4.y
            r3.setTextSize(r5)
            float r3 = r4.y
            r5 = 1040187392(0x3e000000, float:0.125)
            float r3 = r3 * r5
            r5 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r5
            int r3 = (int) r3
            int r5 = r3 * 2
            int r6 = r1 - r5
            float r7 = r4.p
            int r7 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r7 == 0) goto L_0x0202
            float r6 = (float) r6
            float r7 = r4.p
            float r6 = r6 * r7
            int r6 = (int) r6
        L_0x0202:
            if (r6 > 0) goto L_0x0213
            com.google.android.exoplayer2.g.l.c()
        L_0x0207:
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
        L_0x020f:
            r5 = 0
            r10 = 0
            goto L_0x0462
        L_0x0213:
            java.lang.CharSequence r7 = r4.f33587h
            boolean r8 = r4.r
            if (r8 != 0) goto L_0x0220
            java.lang.String r7 = r7.toString()
            r31 = r10
            goto L_0x027d
        L_0x0220:
            boolean r8 = r4.s
            if (r8 != 0) goto L_0x025c
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r7)
            int r7 = r8.length()
            java.lang.Class<android.text.style.AbsoluteSizeSpan> r14 = android.text.style.AbsoluteSizeSpan.class
            r9 = 0
            java.lang.Object[] r14 = r8.getSpans(r9, r7, r14)
            android.text.style.AbsoluteSizeSpan[] r14 = (android.text.style.AbsoluteSizeSpan[]) r14
            r31 = r10
            java.lang.Class<android.text.style.RelativeSizeSpan> r10 = android.text.style.RelativeSizeSpan.class
            java.lang.Object[] r7 = r8.getSpans(r9, r7, r10)
            android.text.style.RelativeSizeSpan[] r7 = (android.text.style.RelativeSizeSpan[]) r7
            int r9 = r14.length
            r10 = 0
        L_0x0242:
            if (r10 >= r9) goto L_0x0250
            r24 = r9
            r9 = r14[r10]
            r8.removeSpan(r9)
            int r10 = r10 + 1
            r9 = r24
            goto L_0x0242
        L_0x0250:
            int r9 = r7.length
            r10 = 0
        L_0x0252:
            if (r10 >= r9) goto L_0x027c
            r14 = r7[r10]
            r8.removeSpan(r14)
            int r10 = r10 + 1
            goto L_0x0252
        L_0x025c:
            r31 = r10
            float r8 = r4.z
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 <= 0) goto L_0x027d
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r7)
            android.text.style.AbsoluteSizeSpan r7 = new android.text.style.AbsoluteSizeSpan
            float r9 = r4.z
            int r9 = (int) r9
            r7.<init>(r9)
            int r9 = r8.length()
            r10 = 16711680(0xff0000, float:2.3418052E-38)
            r14 = 0
            r8.setSpan(r7, r14, r9, r10)
        L_0x027c:
            r7 = r8
        L_0x027d:
            int r8 = r4.u
            int r8 = android.graphics.Color.alpha(r8)
            if (r8 <= 0) goto L_0x029c
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r7)
            android.text.style.BackgroundColorSpan r7 = new android.text.style.BackgroundColorSpan
            int r9 = r4.u
            r7.<init>(r9)
            int r9 = r8.length()
            r10 = 16711680(0xff0000, float:2.3418052E-38)
            r14 = 0
            r8.setSpan(r7, r14, r9, r10)
            r7 = r8
        L_0x029c:
            android.text.Layout$Alignment r8 = r4.f33588i
            if (r8 != 0) goto L_0x02a3
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x02a5
        L_0x02a3:
            android.text.Layout$Alignment r8 = r4.f33588i
        L_0x02a5:
            android.text.StaticLayout r9 = new android.text.StaticLayout
            android.text.TextPaint r10 = r4.f33585f
            float r14 = r4.f33583d
            r32 = r11
            float r11 = r4.f33584e
            r30 = 1
            r23 = r9
            r24 = r7
            r25 = r10
            r26 = r6
            r27 = r8
            r28 = r14
            r29 = r11
            r23.<init>(r24, r25, r26, r27, r28, r29, r30)
            r4.F = r9
            android.text.StaticLayout r9 = r4.F
            int r9 = r9.getHeight()
            android.text.StaticLayout r10 = r4.F
            int r10 = r10.getLineCount()
            r11 = 0
            r14 = 0
        L_0x02d2:
            if (r11 >= r10) goto L_0x02f3
            r23 = r10
            android.text.StaticLayout r10 = r4.F
            float r10 = r10.getLineWidth(r11)
            r33 = r12
            r34 = r13
            double r12 = (double) r10
            double r12 = java.lang.Math.ceil(r12)
            int r10 = (int) r12
            int r14 = java.lang.Math.max(r10, r14)
            int r11 = r11 + 1
            r10 = r23
            r12 = r33
            r13 = r34
            goto L_0x02d2
        L_0x02f3:
            r33 = r12
            r34 = r13
            float r10 = r4.p
            int r10 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r10 == 0) goto L_0x0300
            if (r14 >= r6) goto L_0x0300
            r14 = r6
        L_0x0300:
            int r14 = r14 + r5
            float r5 = r4.n
            int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x0331
            float r1 = (float) r1
            float r5 = r4.n
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            int r5 = r4.B
            int r1 = r1 + r5
            int r5 = r4.o
            r6 = 2
            if (r5 != r6) goto L_0x031a
            int r1 = r1 - r14
            goto L_0x0323
        L_0x031a:
            int r5 = r4.o
            r10 = 1
            if (r5 != r10) goto L_0x0323
            int r1 = r1 * 2
            int r1 = r1 - r14
            int r1 = r1 / r6
        L_0x0323:
            int r5 = r4.B
            int r1 = java.lang.Math.max(r1, r5)
            int r14 = r14 + r1
            int r5 = r4.D
            int r5 = java.lang.Math.min(r14, r5)
            goto L_0x0339
        L_0x0331:
            r6 = 2
            int r1 = r1 - r14
            int r1 = r1 / r6
            int r5 = r4.B
            int r1 = r1 + r5
            int r5 = r1 + r14
        L_0x0339:
            int r26 = r5 - r1
            if (r26 > 0) goto L_0x0342
            com.google.android.exoplayer2.g.l.c()
            goto L_0x020f
        L_0x0342:
            float r5 = r4.k
            int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x03ac
            int r5 = r4.l
            if (r5 != 0) goto L_0x035b
            float r2 = (float) r2
            float r5 = r4.k
            float r2 = r2 * r5
            int r2 = java.lang.Math.round(r2)
            int r5 = r4.C
            int r2 = r2 + r5
            r5 = 0
            r10 = 0
            goto L_0x038b
        L_0x035b:
            android.text.StaticLayout r2 = r4.F
            r5 = 0
            int r2 = r2.getLineBottom(r5)
            android.text.StaticLayout r6 = r4.F
            int r6 = r6.getLineTop(r5)
            int r2 = r2 - r6
            float r6 = r4.k
            r10 = 0
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 < 0) goto L_0x037c
            float r6 = r4.k
            float r2 = (float) r2
            float r6 = r6 * r2
            int r2 = java.lang.Math.round(r6)
            int r6 = r4.C
            goto L_0x038a
        L_0x037c:
            float r6 = r4.k
            r11 = 1065353216(0x3f800000, float:1.0)
            float r6 = r6 + r11
            float r2 = (float) r2
            float r6 = r6 * r2
            int r2 = java.lang.Math.round(r6)
            int r6 = r4.E
        L_0x038a:
            int r2 = r2 + r6
        L_0x038b:
            int r6 = r4.m
            r11 = 2
            if (r6 != r11) goto L_0x0392
            int r2 = r2 - r9
            goto L_0x039b
        L_0x0392:
            int r6 = r4.m
            r12 = 1
            if (r6 != r12) goto L_0x039b
            int r2 = r2 * 2
            int r2 = r2 - r9
            int r2 = r2 / r11
        L_0x039b:
            int r6 = r2 + r9
            int r11 = r4.E
            if (r6 <= r11) goto L_0x03a5
            int r2 = r4.E
            int r2 = r2 - r9
            goto L_0x03b9
        L_0x03a5:
            int r6 = r4.C
            if (r2 >= r6) goto L_0x03b9
            int r2 = r4.C
            goto L_0x03b9
        L_0x03ac:
            r5 = 0
            r10 = 0
            int r6 = r4.E
            int r6 = r6 - r9
            float r2 = (float) r2
            float r9 = r4.A
            float r2 = r2 * r9
            int r2 = (int) r2
            int r2 = r6 - r2
        L_0x03b9:
            android.text.StaticLayout r6 = new android.text.StaticLayout
            android.text.TextPaint r9 = r4.f33585f
            float r11 = r4.f33583d
            float r12 = r4.f33584e
            r30 = 1
            r23 = r6
            r24 = r7
            r25 = r9
            r27 = r8
            r28 = r11
            r29 = r12
            r23.<init>(r24, r25, r26, r27, r28, r29, r30)
            r4.F = r6
            r4.G = r1
            r4.H = r2
            r4.I = r3
            goto L_0x0462
        L_0x03dc:
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r5 = 0
            r10 = 0
            int r1 = r4.D
            int r2 = r4.B
            int r1 = r1 - r2
            int r2 = r4.E
            int r3 = r4.C
            int r2 = r2 - r3
            int r3 = r4.B
            float r3 = (float) r3
            float r1 = (float) r1
            float r6 = r4.n
            float r6 = r6 * r1
            float r3 = r3 + r6
            int r6 = r4.C
            float r6 = (float) r6
            float r2 = (float) r2
            float r7 = r4.k
            float r7 = r7 * r2
            float r6 = r6 + r7
            float r7 = r4.p
            float r1 = r1 * r7
            int r1 = java.lang.Math.round(r1)
            float r7 = r4.q
            int r7 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r7 == 0) goto L_0x0419
            float r7 = r4.q
            float r2 = r2 * r7
            int r2 = java.lang.Math.round(r2)
            goto L_0x042f
        L_0x0419:
            float r2 = (float) r1
            android.graphics.Bitmap r7 = r4.j
            int r7 = r7.getHeight()
            float r7 = (float) r7
            android.graphics.Bitmap r8 = r4.j
            int r8 = r8.getWidth()
            float r8 = (float) r8
            float r7 = r7 / r8
            float r2 = r2 * r7
            int r2 = java.lang.Math.round(r2)
        L_0x042f:
            int r7 = r4.o
            r8 = 2
            if (r7 != r8) goto L_0x0437
            float r7 = (float) r1
        L_0x0435:
            float r3 = r3 - r7
            goto L_0x0440
        L_0x0437:
            int r7 = r4.o
            r8 = 1
            if (r7 != r8) goto L_0x0440
            int r7 = r1 / 2
            float r7 = (float) r7
            goto L_0x0435
        L_0x0440:
            int r3 = java.lang.Math.round(r3)
            int r7 = r4.m
            r8 = 2
            if (r7 != r8) goto L_0x044c
            float r7 = (float) r2
        L_0x044a:
            float r6 = r6 - r7
            goto L_0x0455
        L_0x044c:
            int r7 = r4.m
            r8 = 1
            if (r7 != r8) goto L_0x0455
            int r7 = r2 / 2
            float r7 = (float) r7
            goto L_0x044a
        L_0x0455:
            int r6 = java.lang.Math.round(r6)
            android.graphics.Rect r7 = new android.graphics.Rect
            int r1 = r1 + r3
            int r2 = r2 + r6
            r7.<init>(r3, r6, r1, r2)
            r4.J = r7
        L_0x0462:
            if (r0 == 0) goto L_0x0547
            android.text.StaticLayout r0 = r4.F
            if (r0 == 0) goto L_0x0543
            int r7 = r36.save()
            int r1 = r4.G
            float r1 = (float) r1
            int r2 = r4.H
            float r2 = (float) r2
            r8 = r36
            r8.translate(r1, r2)
            int r1 = r4.v
            int r1 = android.graphics.Color.alpha(r1)
            if (r1 <= 0) goto L_0x04aa
            android.graphics.Paint r1 = r4.f33586g
            int r2 = r4.v
            r1.setColor(r2)
            int r1 = r4.I
            int r1 = -r1
            float r2 = (float) r1
            r3 = 0
            int r1 = r0.getWidth()
            int r6 = r4.I
            int r1 = r1 + r6
            float r6 = (float) r1
            int r1 = r0.getHeight()
            float r9 = (float) r1
            android.graphics.Paint r11 = r4.f33586g
            r1 = r36
            r12 = r18
            r13 = r4
            r14 = 0
            r4 = r6
            r16 = r19
            r5 = r9
            r9 = 0
            r6 = r11
            r1.drawRect(r2, r3, r4, r5, r6)
            goto L_0x04b1
        L_0x04aa:
            r13 = r4
            r12 = r18
            r16 = r19
            r9 = 0
            r14 = 0
        L_0x04b1:
            int r1 = r13.x
            r2 = 1
            if (r1 != r2) goto L_0x04d6
            android.text.TextPaint r1 = r13.f33585f
            android.graphics.Paint$Join r2 = android.graphics.Paint.Join.ROUND
            r1.setStrokeJoin(r2)
            android.text.TextPaint r1 = r13.f33585f
            float r2 = r13.f33580a
            r1.setStrokeWidth(r2)
            android.text.TextPaint r1 = r13.f33585f
            int r2 = r13.w
            r1.setColor(r2)
            android.text.TextPaint r1 = r13.f33585f
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL_AND_STROKE
            r1.setStyle(r2)
            r0.draw(r8)
            goto L_0x0529
        L_0x04d6:
            int r1 = r13.x
            r3 = 2
            if (r1 != r3) goto L_0x04e9
            android.text.TextPaint r1 = r13.f33585f
            float r2 = r13.f33581b
            float r3 = r13.f33582c
            float r4 = r13.f33582c
            int r5 = r13.w
            r1.setShadowLayer(r2, r3, r4, r5)
            goto L_0x0529
        L_0x04e9:
            int r1 = r13.x
            r3 = 3
            if (r1 == r3) goto L_0x04f3
            int r1 = r13.x
            r4 = 4
            if (r1 != r4) goto L_0x0529
        L_0x04f3:
            int r1 = r13.x
            if (r1 != r3) goto L_0x04f8
            goto L_0x04f9
        L_0x04f8:
            r2 = 0
        L_0x04f9:
            r1 = -1
            if (r2 == 0) goto L_0x04fe
            r3 = -1
            goto L_0x0500
        L_0x04fe:
            int r3 = r13.w
        L_0x0500:
            if (r2 == 0) goto L_0x0504
            int r1 = r13.w
        L_0x0504:
            float r2 = r13.f33581b
            r4 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r4
            android.text.TextPaint r4 = r13.f33585f
            int r5 = r13.t
            r4.setColor(r5)
            android.text.TextPaint r4 = r13.f33585f
            android.graphics.Paint$Style r5 = android.graphics.Paint.Style.FILL
            r4.setStyle(r5)
            android.text.TextPaint r4 = r13.f33585f
            float r5 = r13.f33581b
            float r6 = -r2
            r4.setShadowLayer(r5, r6, r6, r3)
            r0.draw(r8)
            android.text.TextPaint r3 = r13.f33585f
            float r4 = r13.f33581b
            r3.setShadowLayer(r4, r2, r2, r1)
        L_0x0529:
            android.text.TextPaint r1 = r13.f33585f
            int r2 = r13.t
            r1.setColor(r2)
            android.text.TextPaint r1 = r13.f33585f
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL
            r1.setStyle(r2)
            r0.draw(r8)
            android.text.TextPaint r0 = r13.f33585f
            r0.setShadowLayer(r9, r9, r9, r14)
            r8.restoreToCount(r7)
            goto L_0x0558
        L_0x0543:
            r8 = r36
            goto L_0x00b4
        L_0x0547:
            r8 = r36
            r13 = r4
            r12 = r18
            r16 = r19
            r9 = 0
            r14 = 0
            android.graphics.Bitmap r0 = r13.j
            android.graphics.Rect r1 = r13.J
            r2 = 0
            r8.drawBitmap(r0, r2, r1, r2)
        L_0x0558:
            int r3 = r12 + 1
            r0 = r35
            r7 = r8
            r5 = r16
            r8 = r20
            r9 = r21
            r14 = r22
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r6 = 0
            goto L_0x0047
        L_0x0570:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.SubtitleView.dispatchDraw(android.graphics.Canvas):void");
    }

    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    private a getUserCaptionStyleV19() {
        return a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
