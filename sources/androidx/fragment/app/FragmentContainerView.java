package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R;
import java.util.ArrayList;

public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<View> f3358a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<View> f3359b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3360c;

    public FragmentContainerView(Context context) {
        super(context);
        this.f3360c = true;
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3360c = true;
        if (!isInEditMode()) {
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to be instantiated from XML.");
        }
    }

    FragmentContainerView(Context context, AttributeSet attributeSet, j jVar) {
        super(context, attributeSet);
        this.f3360c = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment c2 = jVar.c(id);
        if (classAttribute != null && c2 == null) {
            if (id <= 0) {
                String concat = string != null ? " with tag ".concat(String.valueOf(string)) : "";
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + concat);
            }
            Fragment c3 = jVar.u().c(context.getClassLoader(), classAttribute);
            c3.onInflate(context, attributeSet, (Bundle) null);
            q a2 = jVar.a();
            a2.s = true;
            c3.mContainer = this;
            a2.a(getId(), c3, string).e();
        }
    }

    public final void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
        }
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        if (this.f3360c && this.f3358a != null) {
            for (int i2 = 0; i2 < this.f3358a.size(); i2++) {
                super.drawChild(canvas, this.f3358a.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public final boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList<View> arrayList;
        if (!this.f3360c || (arrayList = this.f3358a) == null || arrayList.size() <= 0 || !this.f3358a.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f3359b == null) {
                this.f3359b = new ArrayList<>();
            }
            this.f3359b.add(view);
        }
        super.startViewTransition(view);
    }

    public final void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f3359b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f3358a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f3360c = true;
            }
        }
        super.endViewTransition(view);
    }

    /* access modifiers changed from: package-private */
    public final void setDrawDisappearingViewsLast(boolean z) {
        this.f3360c = z;
    }

    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (j.a(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    /* access modifiers changed from: protected */
    public final boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (j.a(view) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public final void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public final void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    public final void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    /* access modifiers changed from: protected */
    public final void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    private void a(View view) {
        ArrayList<View> arrayList;
        if (view.getAnimation() != null || ((arrayList = this.f3359b) != null && arrayList.contains(view))) {
            if (this.f3358a == null) {
                this.f3358a = new ArrayList<>();
            }
            this.f3358a.add(view);
        }
    }
}
