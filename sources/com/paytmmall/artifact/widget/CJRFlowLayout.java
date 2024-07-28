package com.paytmmall.artifact.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.paytmmall.artifact.R;

public class CJRFlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f16020a;

    /* renamed from: b  reason: collision with root package name */
    private int f16021b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f16022c;

    /* JADX INFO: finally extract failed */
    public CJRFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
        try {
            this.f16020a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalSpacing, 0);
            this.f16021b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_verticalSpacing, 0);
            obtainStyledAttributes.recycle();
            this.f16022c = new Paint();
            this.f16022c.setAntiAlias(true);
            this.f16022c.setColor(-65536);
            this.f16022c.setStrokeWidth(2.0f);
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
            int i12 = this.f16020a;
            if (layoutParams.f16025c >= 0) {
                i12 = layoutParams.f16025c;
            }
            if (!z2 || (!z4 && childAt.getMeasuredWidth() + i6 <= size)) {
                z = false;
            } else {
                i7 += i11 + this.f16021b;
                int max = Math.max(i9, i6 - i12);
                i6 = getPaddingLeft();
                i9 = max;
                z = true;
                i11 = 0;
            }
            i11 = Math.max(i11, childAt.getMeasuredHeight());
            layoutParams.f16023a = i6;
            layoutParams.f16024b = i7;
            i6 += childAt.getMeasuredWidth() + i12;
            z4 = layoutParams.f16026d;
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
            childAt.layout(layoutParams.f16023a, layoutParams.f16024b, layoutParams.f16023a + childAt.getMeasuredWidth(), layoutParams.f16024b + childAt.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f16025c > 0) {
            float right = (float) view.getRight();
            float top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
            float f2 = top - 4.0f;
            float f3 = top + 4.0f;
            float f4 = right;
            canvas.drawLine(f4, f2, right, f3, this.f16022c);
            canvas.drawLine(f4, top, right + ((float) layoutParams.f16025c), top, this.f16022c);
            canvas.drawLine(right + ((float) layoutParams.f16025c), f2, right + ((float) layoutParams.f16025c), f3, this.f16022c);
        }
        if (layoutParams.f16026d) {
            float right2 = (float) view.getRight();
            float top2 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
            float f5 = top2 + 6.0f;
            Canvas canvas2 = canvas;
            float f6 = right2;
            float f7 = f5;
            canvas2.drawLine(f6, top2, right2, f7, this.f16022c);
            canvas2.drawLine(f6, f5, right2 + 6.0f, f7, this.f16022c);
        }
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f16023a;

        /* renamed from: b  reason: collision with root package name */
        int f16024b;

        /* renamed from: c  reason: collision with root package name */
        public int f16025c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16026d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_LayoutParams);
            try {
                this.f16025c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, -1);
                this.f16026d = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_LayoutParams_layout_breakLine, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams.width, layoutParams.height);
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
