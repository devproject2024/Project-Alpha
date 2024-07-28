package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.u;
import com.google.android.material.f.b;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f36859a = 0;

    /* access modifiers changed from: protected */
    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i2) {
        final b bVar;
        if (!u.J(view)) {
            List<View> b2 = coordinatorLayout.b(view);
            int size = b2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    bVar = null;
                    break;
                }
                View view2 = b2.get(i3);
                if (layoutDependsOn(coordinatorLayout, view, view2)) {
                    bVar = (b) view2;
                    break;
                }
                i3++;
            }
            if (bVar != null && a(bVar.a())) {
                this.f36859a = bVar.a() ? 1 : 2;
                final int i4 = this.f36859a;
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (ExpandableBehavior.this.f36859a == i4) {
                            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                            b bVar = bVar;
                            expandableBehavior.a((View) bVar, view, bVar.a(), false);
                        }
                        return false;
                    }
                });
            }
        }
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f36859a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    private boolean a(boolean z) {
        if (!z) {
            return this.f36859a == 1;
        }
        int i2 = this.f36859a;
        return i2 == 0 || i2 == 2;
    }
}
