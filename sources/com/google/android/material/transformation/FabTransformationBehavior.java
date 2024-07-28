package com.google.android.material.transformation;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f36866a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f36867b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f36868c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private final int[] f36869d = new int[2];

    /* renamed from: e  reason: collision with root package name */
    private float f36870e;

    /* renamed from: f  reason: collision with root package name */
    private float f36871f;

    /* access modifiers changed from: protected */
    public abstract a a(Context context, boolean z);

    public FabTransformationBehavior() {
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.d dVar) {
        if (dVar.f2610h == 0) {
            dVar.f2610h = 80;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0369 A[LOOP:0: B:90:0x0367->B:91:0x0369, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.AnimatorSet b(android.view.View r23, android.view.View r24, boolean r25, boolean r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r9 = r24
            r10 = r25
            android.content.Context r2 = r24.getContext()
            com.google.android.material.transformation.FabTransformationBehavior$a r11 = r0.a((android.content.Context) r2, (boolean) r10)
            if (r10 == 0) goto L_0x001e
            float r2 = r23.getTranslationX()
            r0.f36870e = r2
            float r2 = r23.getTranslationY()
            r0.f36871f = r2
        L_0x001e:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r14 = 21
            r15 = 0
            r8 = 1
            r7 = 0
            if (r2 < r14) goto L_0x0066
            float r2 = androidx.core.h.u.v(r24)
            float r3 = androidx.core.h.u.v(r23)
            float r2 = r2 - r3
            if (r10 == 0) goto L_0x004d
            if (r26 != 0) goto L_0x0042
            float r2 = -r2
            r9.setTranslationZ(r2)
        L_0x0042:
            android.util.Property r2 = android.view.View.TRANSLATION_Z
            float[] r3 = new float[r8]
            r3[r7] = r15
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofFloat(r9, r2, r3)
            goto L_0x0058
        L_0x004d:
            android.util.Property r3 = android.view.View.TRANSLATION_Z
            float[] r4 = new float[r8]
            float r2 = -r2
            r4[r7] = r2
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofFloat(r9, r3, r4)
        L_0x0058:
            com.google.android.material.a.h r3 = r11.f36883a
            java.lang.String r4 = "elevation"
            com.google.android.material.a.i r3 = r3.a((java.lang.String) r4)
            r3.a((android.animation.Animator) r2)
            r12.add(r2)
        L_0x0066:
            android.graphics.RectF r2 = r0.f36867b
            com.google.android.material.a.j r3 = r11.f36884b
            float r3 = r0.a((android.view.View) r1, (android.view.View) r9, (com.google.android.material.a.j) r3)
            com.google.android.material.a.j r4 = r11.f36884b
            float r4 = r0.b(r1, r9, r4)
            android.util.Pair r5 = a(r3, r4, r10, r11)
            java.lang.Object r6 = r5.first
            com.google.android.material.a.i r6 = (com.google.android.material.a.i) r6
            java.lang.Object r5 = r5.second
            com.google.android.material.a.i r5 = (com.google.android.material.a.i) r5
            if (r10 == 0) goto L_0x00ca
            if (r26 != 0) goto L_0x008c
            float r14 = -r3
            r9.setTranslationX(r14)
            float r14 = -r4
            r9.setTranslationY(r14)
        L_0x008c:
            android.util.Property r14 = android.view.View.TRANSLATION_X
            r17 = r13
            float[] r13 = new float[r8]
            r13[r7] = r15
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r9, r14, r13)
            android.util.Property r14 = android.view.View.TRANSLATION_Y
            r18 = r13
            float[] r13 = new float[r8]
            r13[r7] = r15
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r9, r14, r13)
            float r3 = -r3
            float r4 = -r4
            float r3 = a((com.google.android.material.transformation.FabTransformationBehavior.a) r11, (com.google.android.material.a.i) r6, (float) r3)
            float r4 = a((com.google.android.material.transformation.FabTransformationBehavior.a) r11, (com.google.android.material.a.i) r5, (float) r4)
            android.graphics.Rect r14 = r0.f36866a
            r9.getWindowVisibleDisplayFrame(r14)
            android.graphics.RectF r15 = r0.f36867b
            r15.set(r14)
            android.graphics.RectF r14 = r0.f36868c
            r0.a((android.view.View) r9, (android.graphics.RectF) r14)
            r14.offset(r3, r4)
            r14.intersect(r15)
            r2.set(r14)
            r3 = r13
            r13 = r18
            goto L_0x00e2
        L_0x00ca:
            r17 = r13
            android.util.Property r13 = android.view.View.TRANSLATION_X
            float[] r14 = new float[r8]
            float r3 = -r3
            r14[r7] = r3
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r9, r13, r14)
            android.util.Property r3 = android.view.View.TRANSLATION_Y
            float[] r14 = new float[r8]
            float r4 = -r4
            r14[r7] = r4
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r9, r3, r14)
        L_0x00e2:
            r6.a((android.animation.Animator) r13)
            r5.a((android.animation.Animator) r3)
            r12.add(r13)
            r12.add(r3)
            float r3 = r2.width()
            float r2 = r2.height()
            com.google.android.material.a.j r4 = r11.f36884b
            float r4 = r0.a((android.view.View) r1, (android.view.View) r9, (com.google.android.material.a.j) r4)
            com.google.android.material.a.j r5 = r11.f36884b
            float r5 = r0.b(r1, r9, r5)
            android.util.Pair r6 = a(r4, r5, r10, r11)
            java.lang.Object r13 = r6.first
            com.google.android.material.a.i r13 = (com.google.android.material.a.i) r13
            java.lang.Object r6 = r6.second
            com.google.android.material.a.i r6 = (com.google.android.material.a.i) r6
            android.util.Property r14 = android.view.View.TRANSLATION_X
            float[] r15 = new float[r8]
            if (r10 == 0) goto L_0x0115
            goto L_0x0117
        L_0x0115:
            float r4 = r0.f36870e
        L_0x0117:
            r15[r7] = r4
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r1, r14, r15)
            android.util.Property r14 = android.view.View.TRANSLATION_Y
            float[] r15 = new float[r8]
            if (r10 == 0) goto L_0x0124
            goto L_0x0126
        L_0x0124:
            float r5 = r0.f36871f
        L_0x0126:
            r15[r7] = r5
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofFloat(r1, r14, r15)
            r13.a((android.animation.Animator) r4)
            r6.a((android.animation.Animator) r5)
            r12.add(r4)
            r12.add(r5)
            boolean r13 = r9 instanceof com.google.android.material.circularreveal.c
            if (r13 == 0) goto L_0x018f
            boolean r4 = r1 instanceof android.widget.ImageView
            if (r4 != 0) goto L_0x0141
            goto L_0x018f
        L_0x0141:
            r4 = r9
            com.google.android.material.circularreveal.c r4 = (com.google.android.material.circularreveal.c) r4
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            android.graphics.drawable.Drawable r5 = r5.getDrawable()
            if (r5 == 0) goto L_0x018f
            r5.mutate()
            r6 = 255(0xff, float:3.57E-43)
            if (r10 == 0) goto L_0x0164
            if (r26 != 0) goto L_0x0159
            r5.setAlpha(r6)
        L_0x0159:
            android.util.Property<android.graphics.drawable.Drawable, java.lang.Integer> r6 = com.google.android.material.a.e.f35807a
            int[] r14 = new int[r8]
            r14[r7] = r7
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofInt(r5, r6, r14)
            goto L_0x016e
        L_0x0164:
            android.util.Property<android.graphics.drawable.Drawable, java.lang.Integer> r14 = com.google.android.material.a.e.f35807a
            int[] r15 = new int[r8]
            r15[r7] = r6
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofInt(r5, r14, r15)
        L_0x016e:
            com.google.android.material.transformation.FabTransformationBehavior$2 r14 = new com.google.android.material.transformation.FabTransformationBehavior$2
            r14.<init>(r9)
            r6.addUpdateListener(r14)
            com.google.android.material.a.h r14 = r11.f36883a
            java.lang.String r15 = "iconFade"
            com.google.android.material.a.i r14 = r14.a((java.lang.String) r15)
            r14.a((android.animation.Animator) r6)
            r12.add(r6)
            com.google.android.material.transformation.FabTransformationBehavior$3 r6 = new com.google.android.material.transformation.FabTransformationBehavior$3
            r6.<init>(r4, r5)
            r14 = r17
            r14.add(r6)
            goto L_0x0191
        L_0x018f:
            r14 = r17
        L_0x0191:
            if (r13 == 0) goto L_0x0284
            r15 = r9
            com.google.android.material.circularreveal.c r15 = (com.google.android.material.circularreveal.c) r15
            com.google.android.material.a.j r4 = r11.f36884b
            android.graphics.RectF r5 = r0.f36867b
            android.graphics.RectF r6 = r0.f36868c
            r0.b(r1, r5)
            r0.a((android.view.View) r9, (android.graphics.RectF) r6)
            float r4 = r0.a((android.view.View) r1, (android.view.View) r9, (com.google.android.material.a.j) r4)
            float r4 = -r4
            r7 = 0
            r6.offset(r4, r7)
            float r4 = r5.centerX()
            float r5 = r6.left
            float r4 = r4 - r5
            com.google.android.material.a.j r5 = r11.f36884b
            android.graphics.RectF r6 = r0.f36867b
            android.graphics.RectF r8 = r0.f36868c
            r0.b(r1, r6)
            r0.a((android.view.View) r9, (android.graphics.RectF) r8)
            float r5 = r0.b(r1, r9, r5)
            float r5 = -r5
            r8.offset(r7, r5)
            float r5 = r6.centerY()
            float r6 = r8.top
            float r5 = r5 - r6
            r6 = r1
            com.google.android.material.floatingactionbutton.FloatingActionButton r6 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r6
            android.graphics.Rect r7 = r0.f36866a
            r6.a((android.graphics.Rect) r7)
            android.graphics.Rect r6 = r0.f36866a
            int r6 = r6.width()
            float r6 = (float) r6
            r7 = 1073741824(0x40000000, float:2.0)
            float r8 = r6 / r7
            com.google.android.material.a.h r6 = r11.f36883a
            java.lang.String r7 = "expansion"
            com.google.android.material.a.i r7 = r6.a((java.lang.String) r7)
            if (r10 == 0) goto L_0x022e
            if (r26 != 0) goto L_0x01f4
            com.google.android.material.circularreveal.c$d r6 = new com.google.android.material.circularreveal.c$d
            r6.<init>(r4, r5, r8)
            r15.setRevealInfo(r6)
        L_0x01f4:
            if (r26 == 0) goto L_0x01fd
            com.google.android.material.circularreveal.c$d r6 = r15.getRevealInfo()
            float r6 = r6.f36134c
            r8 = r6
        L_0x01fd:
            float r2 = com.google.android.material.g.a.a(r4, r5, r3, r2)
            android.animation.Animator r6 = com.google.android.material.circularreveal.a.a(r15, r4, r5, r2)
            com.google.android.material.transformation.FabTransformationBehavior$4 r2 = new com.google.android.material.transformation.FabTransformationBehavior$4
            r2.<init>(r15)
            r6.addListener(r2)
            long r2 = r7.f35815a
            int r4 = (int) r4
            int r5 = (int) r5
            r19 = r2
            r2 = r24
            r16 = r4
            r3 = r19
            r19 = r5
            r5 = r16
            r16 = r6
            r6 = r19
            r0 = r7
            r1 = 0
            r7 = r8
            r1 = 1
            r8 = r12
            a(r2, r3, r5, r6, r7, r8)
            r21 = r11
            r1 = r16
            goto L_0x0275
        L_0x022e:
            r0 = r7
            r1 = 1
            com.google.android.material.circularreveal.c$d r2 = r15.getRevealInfo()
            float r7 = r2.f36134c
            android.animation.Animator r18 = com.google.android.material.circularreveal.a.a(r15, r4, r5, r8)
            long r2 = r0.f35815a
            int r6 = (int) r4
            int r5 = (int) r5
            r3 = r2
            r2 = r24
            r19 = r5
            r5 = r6
            r1 = r6
            r6 = r19
            r10 = r8
            r8 = r12
            a(r2, r3, r5, r6, r7, r8)
            long r2 = r0.f35815a
            long r4 = r0.f35816b
            com.google.android.material.a.h r6 = r11.f36883a
            long r6 = r6.a()
            int r8 = android.os.Build.VERSION.SDK_INT
            r21 = r11
            r11 = 21
            if (r8 < r11) goto L_0x0273
            long r2 = r2 + r4
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0273
            r4 = r19
            android.animation.Animator r1 = android.view.ViewAnimationUtils.createCircularReveal(r9, r1, r4, r10, r10)
            r1.setStartDelay(r2)
            long r6 = r6 - r2
            r1.setDuration(r6)
            r12.add(r1)
        L_0x0273:
            r1 = r18
        L_0x0275:
            r0.a((android.animation.Animator) r1)
            r12.add(r1)
            com.google.android.material.circularreveal.a$1 r0 = new com.google.android.material.circularreveal.a$1
            r0.<init>(r15)
            r14.add(r0)
            goto L_0x0286
        L_0x0284:
            r21 = r11
        L_0x0286:
            if (r13 == 0) goto L_0x02dd
            r0 = r9
            com.google.android.material.circularreveal.c r0 = (com.google.android.material.circularreveal.c) r0
            android.content.res.ColorStateList r1 = androidx.core.h.u.E(r23)
            if (r1 == 0) goto L_0x029e
            int[] r2 = r23.getDrawableState()
            int r3 = r1.getDefaultColor()
            int r7 = r1.getColorForState(r2, r3)
            goto L_0x029f
        L_0x029e:
            r7 = 0
        L_0x029f:
            r1 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r7
            r2 = r25
            if (r2 == 0) goto L_0x02b9
            if (r26 != 0) goto L_0x02ac
            r0.setCircularRevealScrimColor(r7)
        L_0x02ac:
            android.util.Property<com.google.android.material.circularreveal.c, java.lang.Integer> r3 = com.google.android.material.circularreveal.c.C0604c.f36131a
            r4 = 1
            int[] r5 = new int[r4]
            r6 = 0
            r5[r6] = r1
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofInt(r0, r3, r5)
            goto L_0x02c5
        L_0x02b9:
            r4 = 1
            r6 = 0
            android.util.Property<com.google.android.material.circularreveal.c, java.lang.Integer> r1 = com.google.android.material.circularreveal.c.C0604c.f36131a
            int[] r3 = new int[r4]
            r3[r6] = r7
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofInt(r0, r1, r3)
        L_0x02c5:
            com.google.android.material.a.c r1 = com.google.android.material.a.c.a()
            r0.setEvaluator(r1)
            r1 = r21
            com.google.android.material.a.h r3 = r1.f36883a
            java.lang.String r4 = "color"
            com.google.android.material.a.i r3 = r3.a((java.lang.String) r4)
            r3.a((android.animation.Animator) r0)
            r12.add(r0)
            goto L_0x02e1
        L_0x02dd:
            r2 = r25
            r1 = r21
        L_0x02e1:
            boolean r0 = r9 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x034d
            if (r13 == 0) goto L_0x02eb
            int r0 = com.google.android.material.circularreveal.b.f36119a
            if (r0 == 0) goto L_0x034d
        L_0x02eb:
            int r0 = com.google.android.material.R.id.mtrl_child_content_container
            android.view.View r0 = r9.findViewById(r0)
            if (r0 == 0) goto L_0x02f8
            android.view.ViewGroup r0 = a(r0)
            goto L_0x0312
        L_0x02f8:
            boolean r0 = r9 instanceof com.google.android.material.transformation.TransformationChildLayout
            if (r0 != 0) goto L_0x0306
            boolean r0 = r9 instanceof com.google.android.material.transformation.TransformationChildCard
            if (r0 == 0) goto L_0x0301
            goto L_0x0306
        L_0x0301:
            android.view.ViewGroup r0 = a(r24)
            goto L_0x0312
        L_0x0306:
            r0 = r9
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r3 = 0
            android.view.View r0 = r0.getChildAt(r3)
            android.view.ViewGroup r0 = a(r0)
        L_0x0312:
            if (r0 == 0) goto L_0x034d
            if (r2 == 0) goto L_0x0331
            if (r26 != 0) goto L_0x0322
            android.util.Property<android.view.ViewGroup, java.lang.Float> r3 = com.google.android.material.a.d.f35806a
            r4 = 0
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r3.set(r0, r4)
        L_0x0322:
            android.util.Property<android.view.ViewGroup, java.lang.Float> r3 = com.google.android.material.a.d.f35806a
            r4 = 1
            float[] r4 = new float[r4]
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r4[r6] = r5
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r3, r4)
            goto L_0x033e
        L_0x0331:
            r4 = 1
            r6 = 0
            android.util.Property<android.view.ViewGroup, java.lang.Float> r3 = com.google.android.material.a.d.f35806a
            float[] r4 = new float[r4]
            r5 = 0
            r4[r6] = r5
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r3, r4)
        L_0x033e:
            com.google.android.material.a.h r1 = r1.f36883a
            java.lang.String r3 = "contentFade"
            com.google.android.material.a.i r1 = r1.a((java.lang.String) r3)
            r1.a((android.animation.Animator) r0)
            r12.add(r0)
            goto L_0x034e
        L_0x034d:
            r6 = 0
        L_0x034e:
            android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
            r0.<init>()
            com.google.android.material.a.b.a(r0, r12)
            com.google.android.material.transformation.FabTransformationBehavior$1 r1 = new com.google.android.material.transformation.FabTransformationBehavior$1
            r5 = 0
            r3 = r22
            r4 = r23
            r1.<init>(r2, r9, r4)
            r0.addListener(r1)
            int r1 = r14.size()
        L_0x0367:
            if (r5 >= r1) goto L_0x0375
            java.lang.Object r2 = r14.get(r5)
            android.animation.Animator$AnimatorListener r2 = (android.animation.Animator.AnimatorListener) r2
            r0.addListener(r2)
            int r5 = r5 + 1
            goto L_0x0367
        L_0x0375:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.b(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
    }

    private static Pair<i, i> a(float f2, float f3, boolean z, a aVar) {
        i iVar;
        i iVar2;
        int i2;
        if (f2 == 0.0f || f3 == 0.0f) {
            iVar2 = aVar.f36883a.a("translationXLinear");
            iVar = aVar.f36883a.a("translationYLinear");
        } else if ((!z || f3 >= 0.0f) && (z || i2 <= 0)) {
            iVar2 = aVar.f36883a.a("translationXCurveDownwards");
            iVar = aVar.f36883a.a("translationYCurveDownwards");
        } else {
            iVar2 = aVar.f36883a.a("translationXCurveUpwards");
            iVar = aVar.f36883a.a("translationYCurveUpwards");
        }
        return new Pair<>(iVar2, iVar);
    }

    private float a(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f36867b;
        RectF rectF2 = this.f36868c;
        b(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f35820a & 7;
        if (i2 == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i2 == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i2 != 5) {
            f2 = 0.0f;
            return f2 + jVar.f35821b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + jVar.f35821b;
    }

    private float b(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f36867b;
        RectF rectF2 = this.f36868c;
        b(view, rectF);
        a(view2, rectF2);
        int i2 = jVar.f35820a & 112;
        if (i2 == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i2 == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i2 != 80) {
            f2 = 0.0f;
            return f2 + jVar.f35822c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + jVar.f35822c;
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f36869d;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void b(View view, RectF rectF) {
        a(view, rectF);
        rectF.offset(this.f36870e, this.f36871f);
    }

    private static ViewGroup a(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private static void a(View view, long j, int i2, int i3, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        public h f36883a;

        /* renamed from: b  reason: collision with root package name */
        public j f36884b;

        protected a() {
        }
    }

    private static float a(a aVar, i iVar, float f2) {
        long j = iVar.f35815a;
        long j2 = iVar.f35816b;
        i a2 = aVar.f36883a.a("expansion");
        return com.google.android.material.a.a.a(f2, 0.0f, iVar.a().getInterpolation(((float) (((a2.f35815a + a2.f35816b) + 17) - j)) / ((float) j2)));
    }
}
