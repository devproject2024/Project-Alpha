package com.paytm.android.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytm.android.chat.R;

public class FlexBox extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f42488a;

    /* renamed from: b  reason: collision with root package name */
    private View f42489b;

    /* renamed from: c  reason: collision with root package name */
    private ConstraintLayout f42490c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f42491d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f42492e;

    /* renamed from: f  reason: collision with root package name */
    private TypedArray f42493f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout.LayoutParams f42494g;

    /* renamed from: h  reason: collision with root package name */
    private int f42495h;

    /* renamed from: i  reason: collision with root package name */
    private int f42496i;
    private FrameLayout.LayoutParams j;
    private int k;
    private int l;
    private FrameLayout.LayoutParams m;
    private int n;
    private int o;
    private FrameLayout.LayoutParams p;
    private int q;
    private int r;
    private FrameLayout.LayoutParams s;
    private int t;
    private int u;

    public FlexBox(Context context) {
        super(context);
    }

    public FlexBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42493f = context.obtainStyledAttributes(attributeSet, R.styleable.FlexBox, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f42488a = (TextView) findViewById(this.f42493f.getResourceId(R.styleable.FlexBox_msgTVId, -1));
        this.f42489b = findViewById(this.f42493f.getResourceId(R.styleable.FlexBox_timeStatusContainerId, -1));
        this.f42490c = (ConstraintLayout) findViewById(this.f42493f.getResourceId(R.styleable.FlexBox_replyContainerId, -1));
        this.f42491d = (TextView) findViewById(this.f42493f.getResourceId(R.styleable.FlexBox_forwardTipId, -1));
        this.f42492e = (TextView) findViewById(this.f42493f.getResourceId(R.styleable.FlexBox_senderTitleId, -1));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            super.onMeasure(r10, r11)
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            android.view.View.MeasureSpec.getSize(r11)
            android.widget.TextView r11 = r9.f42488a
            if (r11 == 0) goto L_0x0305
            android.view.View r11 = r9.f42489b
            if (r11 == 0) goto L_0x0305
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            if (r11 == 0) goto L_0x0305
            android.widget.TextView r11 = r9.f42491d
            if (r11 == 0) goto L_0x0305
            if (r10 > 0) goto L_0x001e
            goto L_0x0305
        L_0x001e:
            r10 = 1134231552(0x439b0000, float:310.0)
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r10)
            int r0 = r9.getPaddingLeft()
            int r11 = r11 - r0
            int r0 = r9.getPaddingRight()
            int r11 = r11 - r0
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
            android.widget.TextView r5 = r9.f42488a
            r6 = 0
            r5.measure(r1, r6)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r9.f42490c
            r1.measure(r3, r6)
            android.widget.TextView r1 = r9.f42491d
            r1.measure(r4, r6)
            android.view.View r1 = r9.f42489b
            r1.measure(r0, r6)
            android.widget.TextView r0 = r9.f42492e
            r0.measure(r2, r6)
            android.widget.TextView r0 = r9.f42488a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r9.f42494g = r0
            android.widget.TextView r0 = r9.f42488a
            int r0 = r0.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r1 = r9.f42494g
            int r1 = r1.leftMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.f42494g
            int r1 = r1.rightMargin
            int r0 = r0 + r1
            r9.f42495h = r0
            android.widget.TextView r0 = r9.f42488a
            int r0 = r0.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r1 = r9.f42494g
            int r1 = r1.topMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.f42494g
            int r1 = r1.bottomMargin
            int r0 = r0 + r1
            r9.f42496i = r0
            android.view.View r0 = r9.f42489b
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r9.j = r0
            android.view.View r0 = r9.f42489b
            int r0 = r0.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r1 = r9.j
            int r1 = r1.leftMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.j
            int r1 = r1.rightMargin
            int r0 = r0 + r1
            r9.k = r0
            android.view.View r0 = r9.f42489b
            int r0 = r0.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r1 = r9.j
            int r1 = r1.topMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.j
            int r1 = r1.bottomMargin
            int r0 = r0 + r1
            r9.l = r0
            androidx.constraintlayout.widget.ConstraintLayout r0 = r9.f42490c
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r9.m = r0
            androidx.constraintlayout.widget.ConstraintLayout r0 = r9.f42490c
            int r0 = r0.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r1 = r9.m
            int r1 = r1.leftMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.m
            int r1 = r1.rightMargin
            int r0 = r0 + r1
            r9.n = r0
            androidx.constraintlayout.widget.ConstraintLayout r0 = r9.f42490c
            int r0 = r0.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r1 = r9.m
            int r1 = r1.topMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.m
            int r1 = r1.bottomMargin
            int r0 = r0 + r1
            r9.o = r0
            android.widget.TextView r0 = r9.f42491d
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r9.p = r0
            android.widget.TextView r0 = r9.f42491d
            int r0 = r0.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r1 = r9.p
            int r1 = r1.leftMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.p
            int r1 = r1.rightMargin
            int r0 = r0 + r1
            r9.q = r0
            android.widget.TextView r0 = r9.f42491d
            int r0 = r0.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r1 = r9.p
            int r1 = r1.topMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.p
            int r1 = r1.bottomMargin
            int r0 = r0 + r1
            r9.r = r0
            android.widget.TextView r0 = r9.f42492e
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r9.s = r0
            android.widget.TextView r0 = r9.f42492e
            int r0 = r0.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r1 = r9.s
            int r1 = r1.leftMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.s
            int r1 = r1.rightMargin
            int r0 = r0 + r1
            r9.u = r0
            android.widget.TextView r0 = r9.f42492e
            int r0 = r0.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r1 = r9.s
            int r1 = r1.topMargin
            int r0 = r0 + r1
            android.widget.FrameLayout$LayoutParams r1 = r9.s
            int r1 = r1.bottomMargin
            int r0 = r0 + r1
            r9.t = r0
            android.widget.TextView r0 = r9.f42488a
            int r0 = r0.getLineCount()
            if (r0 <= 0) goto L_0x0159
            android.widget.TextView r1 = r9.f42488a
            android.text.Layout r1 = r1.getLayout()
            int r2 = r0 + -1
            float r1 = r1.getLineWidth(r2)
            goto L_0x015a
        L_0x0159:
            r1 = 0
        L_0x015a:
            int r2 = r9.getPaddingLeft()
            int r3 = r9.getPaddingRight()
            int r2 = r2 + r3
            int r3 = r9.getPaddingTop()
            int r4 = r9.getPaddingBottom()
            int r3 = r3 + r4
            r4 = 1
            r5 = 1090519040(0x41000000, float:8.0)
            if (r0 <= r4) goto L_0x01b0
            int r7 = r9.k
            float r7 = (float) r7
            float r7 = r7 + r1
            int r8 = com.paytm.android.chat.utils.DensityUtil.dp2px(r5)
            float r8 = (float) r8
            int r8 = java.lang.Math.round(r8)
            float r8 = (float) r8
            float r7 = r7 + r8
            float r8 = (float) r11
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 > 0) goto L_0x01b0
            int r11 = java.lang.Math.round(r1)
            int r0 = r9.k
            int r11 = r11 + r0
            int r0 = r9.f42495h
            if (r11 <= r0) goto L_0x01a2
            int r11 = java.lang.Math.round(r1)
            int r2 = r2 + r11
            int r11 = r9.k
            int r2 = r2 + r11
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r5)
            float r11 = (float) r11
            int r11 = java.lang.Math.round(r11)
            goto L_0x01ac
        L_0x01a2:
            int r2 = r2 + r0
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r5)
            float r11 = (float) r11
            int r11 = java.lang.Math.round(r11)
        L_0x01ac:
            int r2 = r2 + r11
            int r11 = r9.f42496i
            goto L_0x020b
        L_0x01b0:
            if (r0 <= r4) goto L_0x01d2
            int r7 = r9.k
            float r7 = (float) r7
            float r1 = r1 + r7
            int r7 = com.paytm.android.chat.utils.DensityUtil.dp2px(r5)
            float r7 = (float) r7
            int r7 = java.lang.Math.round(r7)
            float r7 = (float) r7
            float r1 = r1 + r7
            float r7 = (float) r11
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x01d2
            int r11 = r9.f42495h
            int r2 = r2 + r11
            int r11 = r9.f42496i
            int r3 = r3 + r11
            int r11 = r9.l
        L_0x01ce:
            int r3 = r3 + r11
            int r3 = r3 + 10
            goto L_0x020c
        L_0x01d2:
            if (r0 != r4) goto L_0x01f5
            int r0 = r9.f42495h
            int r1 = r9.k
            int r0 = r0 + r1
            int r1 = com.paytm.android.chat.utils.DensityUtil.dp2px(r5)
            float r1 = (float) r1
            int r1 = java.lang.Math.round(r1)
            int r0 = r0 + r1
            if (r0 < r11) goto L_0x01f5
            android.widget.TextView r11 = r9.f42488a
            int r11 = r11.getMeasuredWidth()
            int r2 = r2 + r11
            int r11 = r9.k
            int r2 = r2 + r11
            int r11 = r9.f42496i
            int r3 = r3 + r11
            int r11 = r9.l
            goto L_0x01ce
        L_0x01f5:
            android.widget.TextView r11 = r9.f42488a
            int r11 = r11.getMeasuredWidth()
            int r2 = r2 + r11
            int r11 = r9.k
            int r2 = r2 + r11
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r5)
            float r11 = (float) r11
            int r11 = java.lang.Math.round(r11)
            int r2 = r2 + r11
            int r11 = r9.f42496i
        L_0x020b:
            int r3 = r3 + r11
        L_0x020c:
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x02be
            int r11 = r9.o
            int r3 = r3 + r11
            int r3 = r3 + 20
            int r11 = r9.n
            r0 = 1073741824(0x40000000, float:2.0)
            if (r11 >= r2) goto L_0x0282
            r11 = 1113063424(0x42580000, float:54.0)
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r11)
            int r2 = r2 + r11
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r10)
            if (r2 <= r11) goto L_0x023f
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r10)
            int r1 = r9.getPaddingLeft()
            int r11 = r11 - r1
            int r1 = r9.getPaddingRight()
            int r11 = r11 - r1
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
            goto L_0x024e
        L_0x023f:
            int r11 = r9.getPaddingLeft()
            int r11 = r2 - r11
            int r1 = r9.getPaddingRight()
            int r11 = r11 - r1
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
        L_0x024e:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r9.f42490c
            r0.measure(r11, r6)
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r11 = (android.widget.FrameLayout.LayoutParams) r11
            r9.m = r11
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            int r11 = r11.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.leftMargin
            int r11 = r11 + r0
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.rightMargin
            int r11 = r11 + r0
            r9.n = r11
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            int r11 = r11.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.topMargin
            int r11 = r11 + r0
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.bottomMargin
            int r11 = r11 + r0
            r9.o = r11
            goto L_0x02c2
        L_0x0282:
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r0)
            r9.n = r11
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            int r0 = r9.n
            r11.measure(r0, r6)
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r11 = (android.widget.FrameLayout.LayoutParams) r11
            r9.m = r11
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            int r11 = r11.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.leftMargin
            int r11 = r11 + r0
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.rightMargin
            int r11 = r11 + r0
            r9.n = r11
            androidx.constraintlayout.widget.ConstraintLayout r11 = r9.f42490c
            int r11 = r11.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.topMargin
            int r11 = r11 + r0
            android.widget.FrameLayout$LayoutParams r0 = r9.m
            int r0 = r0.bottomMargin
            int r11 = r11 + r0
            r9.o = r11
            goto L_0x02c2
        L_0x02be:
            r9.o = r6
            r9.n = r6
        L_0x02c2:
            android.widget.TextView r11 = r9.f42491d
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x02d6
            int r11 = r9.r
            int r3 = r3 + r11
            int r11 = r9.n
            if (r11 >= r2) goto L_0x02da
            int r11 = r2 + 200
            r9.n = r11
            goto L_0x02da
        L_0x02d6:
            r9.r = r6
            r9.q = r6
        L_0x02da:
            android.widget.TextView r11 = r9.f42492e
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x02e6
            int r11 = r9.t
            int r3 = r3 + r11
            goto L_0x02ea
        L_0x02e6:
            r9.t = r6
            r9.u = r6
        L_0x02ea:
            int r11 = r9.n
            if (r2 >= r11) goto L_0x02f0
            int r2 = r11 + 40
        L_0x02f0:
            int r11 = r9.u
            int r0 = r11 + 48
            if (r2 >= r0) goto L_0x02f8
            int r2 = r11 + 48
        L_0x02f8:
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r10)
            if (r2 <= r11) goto L_0x0302
            int r2 = com.paytm.android.chat.utils.DensityUtil.dp2px(r10)
        L_0x0302:
            r9.setMeasuredDimension(r2, r3)
        L_0x0305:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.FlexBox.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ConstraintLayout constraintLayout;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f42488a != null && this.f42489b != null && (constraintLayout = this.f42490c) != null && this.f42491d != null) {
            if (constraintLayout.getVisibility() == 0) {
                this.f42490c.layout(getPaddingLeft(), getPaddingTop(), this.n + getPaddingLeft(), this.o + getPaddingTop());
                this.f42491d.layout(getPaddingLeft(), getPaddingTop() + this.o, getPaddingLeft() + this.q, getPaddingTop() + this.o + this.r);
                this.f42492e.layout(getPaddingLeft(), getPaddingTop() + this.o + this.r, getPaddingLeft() + this.u, getPaddingTop() + this.o + this.r + this.t);
                this.f42488a.layout(getPaddingLeft(), getPaddingTop() + this.o + 20 + this.r + this.t, this.f42495h + getPaddingLeft(), this.f42496i + getPaddingTop() + this.o + 20 + this.r + this.t);
                int i6 = i4 - i2;
                int i7 = i5 - i3;
                this.f42489b.layout((i6 - this.k) - getPaddingRight(), ((i7 - getPaddingBottom()) - this.l) + 4, i6 - getPaddingRight(), i7 - getPaddingBottom());
                return;
            }
            this.f42490c.layout(getPaddingLeft(), getPaddingTop(), this.n + getPaddingLeft(), this.o + getPaddingTop());
            this.f42491d.layout(getPaddingLeft(), getPaddingTop() + this.o, getPaddingLeft() + this.q, getPaddingTop() + this.o + this.r);
            this.f42492e.layout(getPaddingLeft(), getPaddingTop() + this.o + this.r, getPaddingLeft() + this.u, getPaddingTop() + this.o + this.r + this.t);
            this.f42488a.layout(getPaddingLeft(), getPaddingTop() + this.o + this.r + this.t, this.f42495h + getPaddingLeft(), this.f42496i + getPaddingTop() + this.o + this.r + this.t);
            int i8 = i4 - i2;
            int i9 = i5 - i3;
            this.f42489b.layout((i8 - this.k) - getPaddingRight(), ((i9 - getPaddingBottom()) - this.l) + 4, i8 - getPaddingRight(), i9 - getPaddingBottom());
        }
    }
}
