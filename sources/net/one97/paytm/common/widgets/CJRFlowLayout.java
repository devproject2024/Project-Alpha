package net.one97.paytm.common.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CJRFlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f49702a;

    /* renamed from: b  reason: collision with root package name */
    private int f49703b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f49704c;

    /* JADX INFO: finally extract failed */
    public CJRFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
        try {
            this.f49702a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalSpacing, 0);
            this.f49703b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_verticalSpacing, 0);
            obtainStyledAttributes.recycle();
            this.f49704c = new Paint();
            this.f49704c.setAntiAlias(true);
            this.f49704c.setColor(-65536);
            this.f49704c.setStrokeWidth(2.0f);
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
            int i12 = this.f49702a;
            if (layoutParams.f49707c >= 0) {
                i12 = layoutParams.f49707c;
            }
            if (!z2 || (!z4 && childAt.getMeasuredWidth() + i6 <= size)) {
                z = false;
            } else {
                i7 += i11 + this.f49703b;
                int max = Math.max(i9, i6 - i12);
                i6 = getPaddingLeft();
                i9 = max;
                z = true;
                i11 = 0;
            }
            i11 = Math.max(i11, childAt.getMeasuredHeight());
            layoutParams.f49705a = i6;
            layoutParams.f49706b = i7;
            i6 += childAt.getMeasuredWidth() + i12;
            z4 = layoutParams.f49708d;
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
            childAt.layout(layoutParams.f49705a, layoutParams.f49706b, layoutParams.f49705a + childAt.getMeasuredWidth(), layoutParams.f49706b + childAt.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f49707c > 0) {
            float right = (float) view.getRight();
            float top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
            float f2 = top - 4.0f;
            float f3 = top + 4.0f;
            float f4 = right;
            canvas.drawLine(f4, f2, right, f3, this.f49704c);
            canvas.drawLine(f4, top, right + ((float) layoutParams.f49707c), top, this.f49704c);
            canvas.drawLine(right + ((float) layoutParams.f49707c), f2, right + ((float) layoutParams.f49707c), f3, this.f49704c);
        }
        if (layoutParams.f49708d) {
            float right2 = (float) view.getRight();
            float top2 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
            float f5 = top2 + 6.0f;
            Canvas canvas2 = canvas;
            float f6 = right2;
            float f7 = f5;
            canvas2.drawLine(f6, top2, right2, f7, this.f49704c);
            canvas2.drawLine(f6, f5, right2 + 6.0f, f7, this.f49704c);
        }
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f49705a;

        /* renamed from: b  reason: collision with root package name */
        int f49706b;

        /* renamed from: c  reason: collision with root package name */
        public int f49707c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f49708d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_LayoutParams);
            try {
                this.f49707c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, -1);
                this.f49708d = obtainStyledAttributes.getBoolean(R.styleable.FlowLayout_LayoutParams_layout_breakLine, false);
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
