package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.h.u;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f1392a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f1393b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f1394c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1395d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1396e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1397f;

    /* renamed from: g  reason: collision with root package name */
    private View f1398g;

    /* renamed from: h  reason: collision with root package name */
    private View f1399h;

    /* renamed from: i  reason: collision with root package name */
    private View f1400i;
    private int j;

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u.a((View) this, (Drawable) new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f1392a = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f1393b = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.f1395d = true;
            this.f1394c = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f1395d ? this.f1392a == null && this.f1393b == null : this.f1394c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1399h = findViewById(R.id.action_bar);
        this.f1400i = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1392a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1392a);
        }
        this.f1392a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1399h;
            if (view != null) {
                this.f1392a.setBounds(view.getLeft(), this.f1399h.getTop(), this.f1399h.getRight(), this.f1399h.getBottom());
            }
        }
        boolean z = true;
        if (!this.f1395d ? !(this.f1392a == null && this.f1393b == null) : this.f1394c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1393b;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1393b);
        }
        this.f1393b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1396e && (drawable2 = this.f1393b) != null) {
                drawable2.setBounds(this.f1398g.getLeft(), this.f1398g.getTop(), this.f1398g.getRight(), this.f1398g.getBottom());
            }
        }
        boolean z = true;
        if (!this.f1395d ? !(this.f1392a == null && this.f1393b == null) : this.f1394c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1394c;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1394c);
        }
        this.f1394c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1395d && (drawable2 = this.f1394c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1395d ? this.f1392a == null && this.f1393b == null : this.f1394c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f1392a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f1393b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f1394c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f1392a && !this.f1395d) {
            return true;
        }
        if (drawable != this.f1393b || !this.f1396e) {
            return (drawable == this.f1394c && this.f1395d) || super.verifyDrawable(drawable);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1392a;
        if (drawable != null && drawable.isStateful()) {
            this.f1392a.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1393b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1393b.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1394c;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1394c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1392a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1393b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1394c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f1397f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1397f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1398g;
        if (view != null) {
            removeView(view);
        }
        this.f1398g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1398g;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    private static boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.f1399h == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.j) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f1399h != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view = this.f1398g;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!a(this.f1399h)) {
                    i4 = b(this.f1399h);
                } else {
                    i4 = !a(this.f1400i) ? b(this.f1400i) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + b(this.f1398g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f1398g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i4, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f1395d) {
            Drawable drawable2 = this.f1394c;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f1392a != null) {
                if (this.f1399h.getVisibility() == 0) {
                    this.f1392a.setBounds(this.f1399h.getLeft(), this.f1399h.getTop(), this.f1399h.getRight(), this.f1399h.getBottom());
                } else {
                    View view2 = this.f1400i;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f1392a.setBounds(0, 0, 0, 0);
                    } else {
                        this.f1392a.setBounds(this.f1400i.getLeft(), this.f1400i.getTop(), this.f1400i.getRight(), this.f1400i.getBottom());
                    }
                }
                z3 = true;
            }
            this.f1396e = z4;
            if (!z4 || (drawable = this.f1393b) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }
}
