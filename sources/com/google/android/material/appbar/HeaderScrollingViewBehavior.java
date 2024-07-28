package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.c.a;
import androidx.core.h.ab;
import androidx.core.h.e;
import androidx.core.h.u;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: a  reason: collision with root package name */
    final Rect f35868a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    final Rect f35869b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    int f35870c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f35871d;

    /* access modifiers changed from: package-private */
    public float a(View view) {
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    public abstract View a(List<View> list);

    public HeaderScrollingViewBehavior() {
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View a2;
        ab lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (a2 = a(coordinatorLayout.b(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (u.A(a2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.b() + lastWindowInsets.d();
        }
        coordinatorLayout.a(view, i2, i3, View.MeasureSpec.makeMeasureSpec((size + b(a2)) - a2.getMeasuredHeight(), i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View a2 = a(coordinatorLayout.b(view));
        if (a2 != null) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
            Rect rect = this.f35868a;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, a2.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + a2.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            ab lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && u.A(coordinatorLayout) && !u.A(view)) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f35869b;
            int i3 = dVar.f2605c;
            e.a(i3 == 0 ? 8388659 : i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int c2 = c(a2);
            view.layout(rect2.left, rect2.top - c2, rect2.right, rect2.bottom - c2);
            this.f35870c = rect2.top - a2.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i2);
        this.f35870c = 0;
    }

    /* access modifiers changed from: package-private */
    public final int c(View view) {
        if (this.f35871d == 0) {
            return 0;
        }
        float a2 = a(view);
        int i2 = this.f35871d;
        return a.a((int) (a2 * ((float) i2)), 0, i2);
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        return view.getMeasuredHeight();
    }
}
