package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.h;
import androidx.core.h.u;
import com.google.android.material.R;

public class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f36407a;

    /* renamed from: b  reason: collision with root package name */
    private int f36408b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f36409c;

    /* renamed from: d  reason: collision with root package name */
    private int f36410d;

    public FlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f36409c = false;
        a(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f36409c = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.f36407a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.f36408b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.f36407a;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i2) {
        this.f36407a = i2;
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.f36408b;
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i2) {
        this.f36408b = i2;
    }

    public boolean a() {
        return this.f36409c;
    }

    public void setSingleLine(boolean z) {
        this.f36409c = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i7 = paddingLeft;
        int i8 = paddingTop;
        int i9 = i8;
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                int i12 = i7;
                if (i7 + i5 + childAt.getMeasuredWidth() > paddingRight && !a()) {
                    int paddingLeft2 = getPaddingLeft();
                    i9 = this.f36407a + i8;
                    i12 = paddingLeft2;
                }
                int measuredWidth = i12 + i5 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                if (measuredWidth > i10) {
                    i10 = measuredWidth;
                }
                int measuredWidth2 = i12 + i5 + i4 + childAt.getMeasuredWidth() + this.f36408b;
                if (i11 == getChildCount() - 1) {
                    i10 += i4;
                }
                i8 = measuredHeight;
                i7 = measuredWidth2;
            } else {
                int i13 = i2;
                int i14 = i3;
                int i15 = i7;
            }
        }
        setMeasuredDimension(a(size, mode, i10 + getPaddingRight()), a(size2, mode2, i8 + getPaddingBottom()));
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 != Integer.MIN_VALUE) {
            return i3 != 1073741824 ? i4 : i2;
        }
        return Math.min(i4, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (getChildCount() == 0) {
            this.f36410d = 0;
            return;
        }
        this.f36410d = 1;
        boolean z2 = u.j(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i8 = (i4 - i2) - paddingLeft;
        int i9 = paddingRight;
        int i10 = paddingTop;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = h.a(marginLayoutParams);
                    i7 = h.b(marginLayoutParams);
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                int measuredWidth = i9 + i6 + childAt.getMeasuredWidth();
                if (!this.f36409c && measuredWidth > i8) {
                    i10 = paddingTop + this.f36407a;
                    this.f36410d++;
                    i9 = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f36410d - 1));
                int i12 = i9 + i6;
                int measuredWidth2 = childAt.getMeasuredWidth() + i12;
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                if (z2) {
                    childAt.layout(i8 - measuredWidth2, i10, (i8 - i9) - i6, measuredHeight);
                } else {
                    childAt.layout(i12, i10, measuredWidth2, measuredHeight);
                }
                i9 += i6 + i7 + childAt.getMeasuredWidth() + this.f36408b;
                paddingTop = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getRowCount() {
        return this.f36410d;
    }

    public static int a(View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }
}
