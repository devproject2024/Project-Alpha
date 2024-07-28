package com.travel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.travel.R;

public class CustomRadioGroup extends RadioGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f28569a;

    /* renamed from: b  reason: collision with root package name */
    private int f28570b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f28571c;

    /* JADX INFO: finally extract failed */
    public CustomRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
        try {
            this.f28569a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalSpacing, 0);
            this.f28570b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_verticalSpacing, 0);
            obtainStyledAttributes.recycle();
            this.f28571c = new Paint();
            this.f28571c.setAntiAlias(true);
            this.f28571c.setColor(-65536);
            this.f28571c.setStrokeWidth(2.0f);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int i4 = i2;
        int i5 = i3;
        int size = View.MeasureSpec.getSize(i2) - getPaddingRight();
        boolean z2 = View.MeasureSpec.getMode(i2) != 0;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i6 = paddingLeft;
        int i7 = paddingTop;
        int i8 = 0;
        boolean z3 = false;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        boolean z4 = false;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            measureChild(childAt, i4, i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i12 = this.f28569a;
            if (layoutParams.f28574c >= 0) {
                i12 = layoutParams.f28574c;
            }
            if (!z2 || (!z4 && childAt.getMeasuredWidth() + i6 <= size)) {
                z = false;
            } else {
                i7 += i11 + this.f28570b;
                int max = Math.max(i9, i6 - i12);
                i6 = getPaddingLeft();
                i9 = max;
                z = true;
                i11 = 0;
            }
            i11 = Math.max(i11, childAt.getMeasuredHeight());
            layoutParams.f28572a = i6;
            layoutParams.f28573b = i7;
            i6 += childAt.getMeasuredWidth() + i12;
            z4 = layoutParams.f28575d;
            i8++;
            i10 = i12;
            z3 = z;
        }
        if (!z3) {
            i9 = Math.max(i9, i6 - i10);
        }
        setMeasuredDimension(resolveSize(i9 + getPaddingRight(), i4), resolveSize(i7 + i11 + getPaddingBottom(), i5));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.f28572a, layoutParams.f28573b, layoutParams.f28572a + childAt.getMeasuredWidth(), layoutParams.f28573b + childAt.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f28574c > 0) {
            float right = (float) view.getRight();
            float top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
            float f2 = top - 4.0f;
            float f3 = top + 4.0f;
            float f4 = right;
            canvas.drawLine(f4, f2, right, f3, this.f28571c);
            canvas.drawLine(f4, top, right + ((float) layoutParams.f28574c), top, this.f28571c);
            canvas.drawLine(right + ((float) layoutParams.f28574c), f2, right + ((float) layoutParams.f28574c), f3, this.f28571c);
        }
        if (layoutParams.f28575d) {
            float right2 = (float) view.getRight();
            float top2 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
            float f5 = top2 + 6.0f;
            Canvas canvas2 = canvas;
            float f6 = right2;
            float f7 = f5;
            canvas2.drawLine(f6, top2, right2, f7, this.f28571c);
            canvas2.drawLine(f6, f5, right2 + 6.0f, f7, this.f28571c);
        }
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams.width, layoutParams.height);
    }

    public static class LayoutParams extends RadioGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f28572a;

        /* renamed from: b  reason: collision with root package name */
        int f28573b;

        /* renamed from: c  reason: collision with root package name */
        public int f28574c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28575d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_LayoutParams);
            try {
                this.f28574c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, -1);
                this.f28575d = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_LayoutParams_layout_breakLine, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }
    }
}
