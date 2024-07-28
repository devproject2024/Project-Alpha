package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.h.u;
import androidx.core.h.x;
import androidx.core.h.y;

abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0024a f1653a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f1654b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f1655c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuPresenter f1656d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1657e;

    /* renamed from: f  reason: collision with root package name */
    protected x f1658f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1659g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1660h;

    protected static int a(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    a(Context context) {
        this(context, (AttributeSet) null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1653a = new C0024a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1654b = context;
        } else {
            this.f1654b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1656d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.c();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1659g = false;
        }
        if (!this.f1659g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1659g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1659g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1660h = false;
        }
        if (!this.f1660h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1660h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1660h = false;
        }
        return true;
    }

    public void setContentHeight(int i2) {
        this.f1657e = i2;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1657e;
    }

    public int getAnimatedVisibility() {
        if (this.f1658f != null) {
            return this.f1653a.f1661a;
        }
        return getVisibility();
    }

    public x a(int i2, long j) {
        x xVar = this.f1658f;
        if (xVar != null) {
            xVar.b();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            x a2 = u.s(this).a(1.0f);
            a2.a(j);
            a2.a((y) this.f1653a.a(a2, i2));
            return a2;
        }
        x a3 = u.s(this).a(0.0f);
        a3.a(j);
        a3.a((y) this.f1653a.a(a3, i2));
        return a3;
    }

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            x xVar = this.f1658f;
            if (xVar != null) {
                xVar.b();
            }
            super.setVisibility(i2);
        }
    }

    public boolean a() {
        ActionMenuPresenter actionMenuPresenter = this.f1656d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.e();
        }
        return false;
    }

    protected static int a(View view, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - 0);
    }

    protected static int a(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0024a implements y {

        /* renamed from: a  reason: collision with root package name */
        int f1661a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1663c = false;

        protected C0024a() {
        }

        public final C0024a a(x xVar, int i2) {
            a.this.f1658f = xVar;
            this.f1661a = i2;
            return this;
        }

        public final void onAnimationStart(View view) {
            a.super.setVisibility(0);
            this.f1663c = false;
        }

        public final void onAnimationEnd(View view) {
            if (!this.f1663c) {
                a aVar = a.this;
                aVar.f1658f = null;
                a.super.setVisibility(this.f1661a);
            }
        }

        public final void onAnimationCancel(View view) {
            this.f1663c = true;
        }
    }
}
