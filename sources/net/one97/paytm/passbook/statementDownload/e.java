package net.one97.paytm.passbook.statementDownload;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

final class e extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f58676a = {16843049, 16843561, 16843562};

    /* renamed from: b  reason: collision with root package name */
    private Drawable f58677b;

    /* renamed from: c  reason: collision with root package name */
    private int f58678c;

    /* renamed from: d  reason: collision with root package name */
    private int f58679d;

    /* renamed from: e  reason: collision with root package name */
    private int f58680e;

    /* renamed from: f  reason: collision with root package name */
    private int f58681f;

    public e(Context context, int i2) {
        super(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f58676a, i2, 0);
        setDividerDrawable(obtainStyledAttributes.getDrawable(0));
        this.f58681f = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f58680e = obtainStyledAttributes.getInteger(1, 0);
        obtainStyledAttributes.recycle();
    }

    public final void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f58677b) {
            this.f58677b = drawable;
            boolean z = false;
            if (drawable != null) {
                this.f58678c = drawable.getIntrinsicWidth();
                this.f58679d = drawable.getIntrinsicHeight();
            } else {
                this.f58678c = 0;
                this.f58679d = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        int indexOfChild = indexOfChild(view);
        int orientation = getOrientation();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (a(indexOfChild)) {
            if (orientation == 1) {
                layoutParams.topMargin = this.f58679d;
            } else {
                layoutParams.leftMargin = this.f58678c;
            }
        }
        int childCount = getChildCount();
        if (indexOfChild == childCount - 1 && a(childCount)) {
            if (orientation == 1) {
                layoutParams.bottomMargin = this.f58679d;
            } else {
                layoutParams.rightMargin = this.f58678c;
            }
        }
        super.measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i2;
        int i3;
        if (this.f58677b != null) {
            int i4 = 0;
            if (getOrientation() == 1) {
                int childCount = getChildCount();
                while (i4 < childCount) {
                    View childAt = getChildAt(i4);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !a(i4))) {
                        a(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
                    }
                    i4++;
                }
                if (a(childCount)) {
                    View childAt2 = getChildAt(childCount - 1);
                    if (childAt2 == null) {
                        i3 = (getHeight() - getPaddingBottom()) - this.f58679d;
                    } else {
                        i3 = childAt2.getBottom();
                    }
                    a(canvas, i3);
                }
            } else {
                int childCount2 = getChildCount();
                while (i4 < childCount2) {
                    View childAt3 = getChildAt(i4);
                    if (!(childAt3 == null || childAt3.getVisibility() == 8 || !a(i4))) {
                        b(canvas, childAt3.getLeft() - ((LinearLayout.LayoutParams) childAt3.getLayoutParams()).leftMargin);
                    }
                    i4++;
                }
                if (a(childCount2)) {
                    View childAt4 = getChildAt(childCount2 - 1);
                    if (childAt4 == null) {
                        i2 = (getWidth() - getPaddingRight()) - this.f58678c;
                    } else {
                        i2 = childAt4.getRight();
                    }
                    b(canvas, i2);
                }
            }
        }
        super.onDraw(canvas);
    }

    private void a(Canvas canvas, int i2) {
        this.f58677b.setBounds(getPaddingLeft() + this.f58681f, i2, (getWidth() - getPaddingRight()) - this.f58681f, this.f58679d + i2);
        this.f58677b.draw(canvas);
    }

    private void b(Canvas canvas, int i2) {
        this.f58677b.setBounds(i2, getPaddingTop() + this.f58681f, this.f58678c + i2, (getHeight() - getPaddingBottom()) - this.f58681f);
        this.f58677b.draw(canvas);
    }

    private boolean a(int i2) {
        if (i2 == 0 || i2 == getChildCount() || (this.f58680e & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }
}
