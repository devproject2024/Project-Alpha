package com.paytm.android.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.paytm.android.chat.R;

public class FlexBoxImage extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f42497a;

    /* renamed from: b  reason: collision with root package name */
    private View f42498b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f42499c;

    /* renamed from: d  reason: collision with root package name */
    private TypedArray f42500d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout.LayoutParams f42501e;

    /* renamed from: f  reason: collision with root package name */
    private int f42502f;

    /* renamed from: g  reason: collision with root package name */
    private int f42503g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout.LayoutParams f42504h;

    /* renamed from: i  reason: collision with root package name */
    private int f42505i;
    private int j;
    private FrameLayout.LayoutParams k;
    private int l;
    private int m;

    public FlexBoxImage(Context context) {
        super(context);
    }

    public FlexBoxImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42500d = context.obtainStyledAttributes(attributeSet, R.styleable.FlexBox, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f42497a = (TextView) findViewById(this.f42500d.getResourceId(R.styleable.FlexBox_msgTVId, -1));
        this.f42498b = findViewById(this.f42500d.getResourceId(R.styleable.FlexBox_timeStatusContainerId, -1));
        this.f42499c = (TextView) findViewById(this.f42500d.getResourceId(R.styleable.FlexBox_forwardTipId, -1));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            super.onMeasure(r10, r11)
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            android.view.View.MeasureSpec.getSize(r11)
            android.widget.TextView r11 = r9.f42497a
            if (r11 == 0) goto L_0x01a2
            android.view.View r11 = r9.f42498b
            if (r11 == 0) goto L_0x01a2
            android.widget.TextView r11 = r9.f42499c
            if (r11 == 0) goto L_0x01a2
            if (r10 > 0) goto L_0x001a
            goto L_0x01a2
        L_0x001a:
            r10 = 1133314048(0x438d0000, float:282.0)
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r10)
            r0 = 1106247680(0x41f00000, float:30.0)
            int r1 = com.paytm.android.chat.utils.DensityUtil.dp2px(r0)
            int r11 = r11 - r1
            int r1 = r9.getPaddingLeft()
            int r11 = r11 - r1
            int r1 = r9.getPaddingRight()
            int r11 = r11 - r1
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r1)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r1)
            android.widget.TextView r4 = r9.f42497a
            r5 = 0
            r4.measure(r2, r5)
            android.widget.TextView r2 = r9.f42499c
            r2.measure(r3, r5)
            android.view.View r2 = r9.f42498b
            r2.measure(r1, r5)
            android.widget.TextView r1 = r9.f42497a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r9.f42501e = r1
            android.widget.TextView r1 = r9.f42497a
            int r1 = r1.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r2 = r9.f42501e
            int r2 = r2.leftMargin
            int r1 = r1 + r2
            android.widget.FrameLayout$LayoutParams r2 = r9.f42501e
            int r2 = r2.rightMargin
            int r1 = r1 + r2
            r9.f42502f = r1
            android.widget.TextView r1 = r9.f42497a
            int r1 = r1.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r2 = r9.f42501e
            int r2 = r2.topMargin
            int r1 = r1 + r2
            android.widget.FrameLayout$LayoutParams r2 = r9.f42501e
            int r2 = r2.bottomMargin
            int r1 = r1 + r2
            r9.f42503g = r1
            android.view.View r1 = r9.f42498b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r9.f42504h = r1
            android.view.View r1 = r9.f42498b
            int r1 = r1.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r2 = r9.f42504h
            int r2 = r2.leftMargin
            int r1 = r1 + r2
            android.widget.FrameLayout$LayoutParams r2 = r9.f42504h
            int r2 = r2.rightMargin
            int r1 = r1 + r2
            r9.f42505i = r1
            android.view.View r1 = r9.f42498b
            int r1 = r1.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r2 = r9.f42504h
            int r2 = r2.topMargin
            int r1 = r1 + r2
            android.widget.FrameLayout$LayoutParams r2 = r9.f42504h
            int r2 = r2.bottomMargin
            int r1 = r1 + r2
            r9.j = r1
            android.widget.TextView r1 = r9.f42499c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r9.k = r1
            android.widget.TextView r1 = r9.f42499c
            int r1 = r1.getMeasuredWidth()
            android.widget.FrameLayout$LayoutParams r2 = r9.k
            int r2 = r2.leftMargin
            int r1 = r1 + r2
            android.widget.FrameLayout$LayoutParams r2 = r9.k
            int r2 = r2.rightMargin
            int r1 = r1 + r2
            r9.l = r1
            android.widget.TextView r1 = r9.f42499c
            int r1 = r1.getMeasuredHeight()
            android.widget.FrameLayout$LayoutParams r2 = r9.k
            int r2 = r2.topMargin
            int r1 = r1 + r2
            android.widget.FrameLayout$LayoutParams r2 = r9.k
            int r2 = r2.bottomMargin
            int r1 = r1 + r2
            r9.m = r1
            android.widget.TextView r1 = r9.f42497a
            int r1 = r1.getLineCount()
            if (r1 <= 0) goto L_0x00ee
            android.widget.TextView r2 = r9.f42497a
            android.text.Layout r2 = r2.getLayout()
            int r3 = r1 + -1
            float r2 = r2.getLineWidth(r3)
            goto L_0x00ef
        L_0x00ee:
            r2 = 0
        L_0x00ef:
            r9.getPaddingLeft()
            r9.getPaddingRight()
            int r3 = r9.getPaddingTop()
            int r4 = r9.getPaddingBottom()
            int r3 = r3 + r4
            r4 = 1
            r6 = 1090519040(0x41000000, float:8.0)
            if (r1 <= r4) goto L_0x0139
            int r7 = r9.f42505i
            float r7 = (float) r7
            float r7 = r7 + r2
            int r8 = com.paytm.android.chat.utils.DensityUtil.dp2px(r6)
            float r8 = (float) r8
            int r8 = java.lang.Math.round(r8)
            float r8 = (float) r8
            float r7 = r7 + r8
            float r8 = (float) r11
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 > 0) goto L_0x0139
            int r11 = java.lang.Math.round(r2)
            int r1 = r9.f42505i
            int r11 = r11 + r1
            int r1 = r9.f42502f
            if (r11 <= r1) goto L_0x012e
            java.lang.Math.round(r2)
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r6)
            float r11 = (float) r11
            java.lang.Math.round(r11)
            goto L_0x0136
        L_0x012e:
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r6)
            float r11 = (float) r11
            java.lang.Math.round(r11)
        L_0x0136:
            int r11 = r9.f42503g
            goto L_0x0185
        L_0x0139:
            if (r1 <= r4) goto L_0x0158
            int r7 = r9.f42505i
            float r7 = (float) r7
            float r2 = r2 + r7
            int r7 = com.paytm.android.chat.utils.DensityUtil.dp2px(r6)
            float r7 = (float) r7
            int r7 = java.lang.Math.round(r7)
            float r7 = (float) r7
            float r2 = r2 + r7
            float r7 = (float) r11
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0158
            int r11 = r9.f42503g
            int r3 = r3 + r11
            int r11 = r9.j
        L_0x0154:
            int r3 = r3 + r11
            int r3 = r3 + 10
            goto L_0x0186
        L_0x0158:
            if (r1 != r4) goto L_0x0176
            int r1 = r9.f42502f
            int r2 = r9.f42505i
            int r1 = r1 + r2
            int r2 = com.paytm.android.chat.utils.DensityUtil.dp2px(r6)
            float r2 = (float) r2
            int r2 = java.lang.Math.round(r2)
            int r1 = r1 + r2
            if (r1 < r11) goto L_0x0176
            android.widget.TextView r11 = r9.f42497a
            r11.getMeasuredWidth()
            int r11 = r9.f42503g
            int r3 = r3 + r11
            int r11 = r9.j
            goto L_0x0154
        L_0x0176:
            android.widget.TextView r11 = r9.f42497a
            r11.getMeasuredWidth()
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r6)
            float r11 = (float) r11
            java.lang.Math.round(r11)
            int r11 = r9.f42503g
        L_0x0185:
            int r3 = r3 + r11
        L_0x0186:
            android.widget.TextView r11 = r9.f42499c
            int r11 = r11.getVisibility()
            if (r11 != 0) goto L_0x0192
            int r11 = r9.m
            int r3 = r3 + r11
            goto L_0x0196
        L_0x0192:
            r9.m = r5
            r9.l = r5
        L_0x0196:
            int r10 = com.paytm.android.chat.utils.DensityUtil.dp2px(r10)
            int r11 = com.paytm.android.chat.utils.DensityUtil.dp2px(r0)
            int r10 = r10 - r11
            r9.setMeasuredDimension(r10, r3)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.FlexBoxImage.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        TextView textView;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f42497a != null && this.f42498b != null && (textView = this.f42499c) != null) {
            textView.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.l, getPaddingTop() + this.m);
            this.f42497a.layout(getPaddingLeft(), getPaddingTop() + this.m, this.f42502f + getPaddingLeft(), this.f42503g + getPaddingTop() + this.m);
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            this.f42498b.layout((i6 - this.f42505i) - getPaddingRight(), ((i7 - getPaddingBottom()) - this.j) + 4, i6 - getPaddingRight(), i7 - getPaddingBottom());
        }
    }
}
