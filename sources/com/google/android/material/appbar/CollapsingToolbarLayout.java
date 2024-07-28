package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.g.c;
import androidx.core.h.ab;
import androidx.core.h.q;
import androidx.core.h.u;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.b;
import com.google.android.material.internal.k;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final int f35851e = R.style.Widget_Design_CollapsingToolbar;

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.material.internal.a f35852a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f35853b;

    /* renamed from: c  reason: collision with root package name */
    int f35854c;

    /* renamed from: d  reason: collision with root package name */
    ab f35855d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35856f;

    /* renamed from: g  reason: collision with root package name */
    private int f35857g;

    /* renamed from: h  reason: collision with root package name */
    private Toolbar f35858h;

    /* renamed from: i  reason: collision with root package name */
    private View f35859i;
    private View j;
    private int k;
    private int l;
    private int m;
    private int n;
    private final Rect o;
    private boolean p;
    private boolean q;
    private Drawable r;
    private int s;
    private boolean t;
    private ValueAnimator u;
    private long v;
    private int w;
    private AppBarLayout.b x;

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f35851e), attributeSet, i2);
        this.f35856f = true;
        this.o = new Rect();
        this.w = -1;
        Context context2 = getContext();
        this.f35852a = new com.google.android.material.internal.a(this);
        this.f35852a.a(com.google.android.material.a.a.f35804e);
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i2, f35851e, new int[0]);
        this.f35852a.a(a2.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f35852a.b(a2.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = a2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.n = dimensionPixelSize;
        this.m = dimensionPixelSize;
        this.l = dimensionPixelSize;
        this.k = dimensionPixelSize;
        if (a2.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.k = a2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (a2.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.m = a2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (a2.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.l = a2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (a2.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.n = a2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.p = a2.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(a2.getText(R.styleable.CollapsingToolbarLayout_title));
        this.f35852a.d(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f35852a.c(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (a2.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f35852a.d(a2.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (a2.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f35852a.c(a2.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.w = a2.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (a2.hasValue(R.styleable.CollapsingToolbarLayout_maxLines)) {
            this.f35852a.e(a2.getInt(R.styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        this.v = (long) a2.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, H5PullContainer.DEFALUT_DURATION);
        setContentScrim(a2.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(a2.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f35857g = a2.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        a2.recycle();
        setWillNotDraw(false);
        u.a((View) this, (q) new q() {
            public final ab a(View view, ab abVar) {
                CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                ab abVar2 = u.A(collapsingToolbarLayout) ? abVar : null;
                if (!c.a(collapsingToolbarLayout.f35855d, abVar2)) {
                    collapsingToolbarLayout.f35855d = abVar2;
                    collapsingToolbarLayout.requestLayout();
                }
                return abVar.f3061b.c();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            u.b((View) this, u.A((View) parent));
            if (this.x == null) {
                this.x = new a();
            }
            ((AppBarLayout) parent).a(this.x);
            u.z(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.b bVar = this.x;
        if (bVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(bVar);
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f35858h == null && (drawable = this.r) != null && this.s > 0) {
            drawable.mutate().setAlpha(this.s);
            this.r.draw(canvas);
        }
        if (this.p && this.q) {
            this.f35852a.a(canvas);
        }
        if (this.f35853b != null && this.s > 0) {
            ab abVar = this.f35855d;
            int b2 = abVar != null ? abVar.b() : 0;
            if (b2 > 0) {
                this.f35853b.setBounds(0, -this.f35854c, getWidth(), b2 - this.f35854c);
                this.f35853b.mutate().setAlpha(this.s);
                this.f35853b.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean drawChild(android.graphics.Canvas r5, android.view.View r6, long r7) {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.r
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002f
            int r0 = r4.s
            if (r0 <= 0) goto L_0x002f
            android.view.View r0 = r4.f35859i
            if (r0 == 0) goto L_0x0014
            if (r0 != r4) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            if (r6 != r0) goto L_0x001a
            goto L_0x0018
        L_0x0014:
            androidx.appcompat.widget.Toolbar r0 = r4.f35858h
            if (r6 != r0) goto L_0x001a
        L_0x0018:
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 == 0) goto L_0x002f
            android.graphics.drawable.Drawable r0 = r4.r
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r3 = r4.s
            r0.setAlpha(r3)
            android.graphics.drawable.Drawable r0 = r4.r
            r0.draw(r5)
            r0 = 1
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            boolean r5 = super.drawChild(r5, r6, r7)
            if (r5 != 0) goto L_0x003a
            if (r0 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            return r2
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.r;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r6 = this;
            boolean r0 = r6.f35856f
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f35858h = r0
            r6.f35859i = r0
            int r1 = r6.f35857g
            r2 = -1
            if (r1 == r2) goto L_0x0021
            android.view.View r1 = r6.findViewById(r1)
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1
            r6.f35858h = r1
            androidx.appcompat.widget.Toolbar r1 = r6.f35858h
            if (r1 == 0) goto L_0x0021
            android.view.View r1 = r6.c(r1)
            r6.f35859i = r1
        L_0x0021:
            androidx.appcompat.widget.Toolbar r1 = r6.f35858h
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x002b:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof androidx.appcompat.widget.Toolbar
            if (r5 == 0) goto L_0x0039
            r0 = r4
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x002b
        L_0x003c:
            r6.f35858h = r0
        L_0x003e:
            r6.c()
            r6.f35856f = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.b():void");
    }

    private View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private void c() {
        View view;
        if (!this.p && (view = this.j) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.j);
            }
        }
        if (this.p && this.f35858h != null) {
            if (this.j == null) {
                this.j = new View(getContext());
            }
            if (this.j.getParent() == null) {
                this.f35858h.addView(this.j, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        ab abVar = this.f35855d;
        int b2 = abVar != null ? abVar.b() : 0;
        if (mode == 0 && b2 > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + b2, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        ab abVar = this.f35855d;
        if (abVar != null) {
            int b2 = abVar.b();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!u.A(childAt) && childAt.getTop() < b2) {
                    u.f(childAt, b2);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            a(getChildAt(i7)).a();
        }
        if (this.p && (view = this.j) != null) {
            boolean z2 = true;
            this.q = u.M(view) && this.j.getVisibility() == 0;
            if (this.q) {
                if (u.j(this) != 1) {
                    z2 = false;
                }
                View view2 = this.f35859i;
                if (view2 == null) {
                    view2 = this.f35858h;
                }
                int b3 = b(view2);
                b.b(this, this.j, this.o);
                this.f35852a.b(this.o.left + (z2 ? this.f35858h.getTitleMarginEnd() : this.f35858h.getTitleMarginStart()), this.o.top + b3 + this.f35858h.getTitleMarginTop(), this.o.right - (z2 ? this.f35858h.getTitleMarginStart() : this.f35858h.getTitleMarginEnd()), (this.o.bottom + b3) - this.f35858h.getTitleMarginBottom());
                this.f35852a.a(z2 ? this.m : this.k, this.o.top + this.l, (i4 - i2) - (z2 ? this.k : this.m), (i5 - i3) - this.n);
                this.f35852a.c();
            }
        }
        if (this.f35858h != null) {
            if (this.p && TextUtils.isEmpty(this.f35852a.f36439h)) {
                setTitle(this.f35858h.getTitle());
            }
            View view3 = this.f35859i;
            if (view3 == null || view3 == this) {
                setMinimumHeight(d(this.f35858h));
            } else {
                setMinimumHeight(d(view3));
            }
        }
        a();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            a(getChildAt(i8)).b();
        }
    }

    private static int d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static a a(View view) {
        a aVar = (a) view.getTag(R.id.view_offset_helper);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(view);
        view.setTag(R.id.view_offset_helper, aVar2);
        return aVar2;
    }

    public void setTitle(CharSequence charSequence) {
        this.f35852a.a(charSequence);
        e();
    }

    public CharSequence getTitle() {
        if (this.p) {
            return this.f35852a.f36439h;
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.p) {
            this.p = z;
            e();
            c();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, u.J(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.t != z) {
            int i2 = PriceRangeSeekBar.INVALID_POINTER_ID;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                b();
                ValueAnimator valueAnimator = this.u;
                if (valueAnimator == null) {
                    this.u = new ValueAnimator();
                    this.u.setDuration(this.v);
                    this.u.setInterpolator(i2 > this.s ? com.google.android.material.a.a.f35802c : com.google.android.material.a.a.f35803d);
                    this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else if (valueAnimator.isRunning()) {
                    this.u.cancel();
                }
                this.u.setIntValues(new int[]{this.s, i2});
                this.u.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.t = z;
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.s) {
            if (!(this.r == null || (toolbar = this.f35858h) == null)) {
                u.g(toolbar);
            }
            this.s = i2;
            u.g(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.s;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.r = drawable3;
            Drawable drawable4 = this.r;
            if (drawable4 != null) {
                drawable4.setBounds(0, 0, getWidth(), getHeight());
                this.r.setCallback(this);
                this.r.setAlpha(this.s);
            }
            u.g(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(androidx.core.content.b.a(getContext(), i2));
    }

    public Drawable getContentScrim() {
        return this.r;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f35853b;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f35853b = drawable3;
            Drawable drawable4 = this.f35853b;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.f35853b.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.f35853b, u.j(this));
                this.f35853b.setVisible(getVisibility() == 0, false);
                this.f35853b.setCallback(this);
                this.f35853b.setAlpha(this.s);
            }
            u.g(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f35853b;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.r;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.f35852a;
        if (aVar != null) {
            z |= aVar.a(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r || drawable == this.f35853b;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f35853b;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.f35853b.setVisible(z, false);
        }
        Drawable drawable2 = this.r;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.r.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(androidx.core.content.b.a(getContext(), i2));
    }

    public Drawable getStatusBarScrim() {
        return this.f35853b;
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.f35852a.c(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f35852a.a(colorStateList);
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f35852a.b(i2);
    }

    public int getCollapsedTitleGravity() {
        return this.f35852a.f36434c;
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.f35852a.d(i2);
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f35852a.b(colorStateList);
    }

    public void setExpandedTitleGravity(int i2) {
        this.f35852a.a(i2);
    }

    public int getExpandedTitleGravity() {
        return this.f35852a.f36433b;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f35852a.a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        com.google.android.material.internal.a aVar = this.f35852a;
        return aVar.f36437f != null ? aVar.f36437f : Typeface.DEFAULT;
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f35852a.b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        com.google.android.material.internal.a aVar = this.f35852a;
        return aVar.f36438g != null ? aVar.f36438g : Typeface.DEFAULT;
    }

    public void setExpandedTitleMargin(int i2, int i3, int i4, int i5) {
        this.k = i2;
        this.l = i3;
        this.m = i4;
        this.n = i5;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.k;
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.k = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.l;
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.l = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.m;
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.m = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.n;
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setMaxLines(int i2) {
        this.f35852a.e(i2);
    }

    public int getMaxLines() {
        return this.f35852a.k;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.w != i2) {
            this.w = i2;
            a();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.w;
        if (i2 >= 0) {
            return i2;
        }
        ab abVar = this.f35855d;
        int b2 = abVar != null ? abVar.b() : 0;
        int r2 = u.r(this);
        if (r2 > 0) {
            return Math.min((r2 * 2) + b2, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j2) {
        this.v = j2;
    }

    public long getScrimAnimationDuration() {
        return this.v;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams d() {
        return new LayoutParams(-1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f35862a = 0;

        /* renamed from: b  reason: collision with root package name */
        public float f35863b = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f35862a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.f35863b = obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2) {
            super(-1, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void a() {
            this.f35862a = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.r != null || this.f35853b != null) {
            setScrimsShown(getHeight() + this.f35854c < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(View view) {
        return ((getHeight() - a(view).f35873a) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private void e() {
        setContentDescription(getTitle());
    }

    class a implements AppBarLayout.b {
        a() {
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f35854c = i2;
            int b2 = collapsingToolbarLayout.f35855d != null ? CollapsingToolbarLayout.this.f35855d.b() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                a a2 = CollapsingToolbarLayout.a(childAt);
                int i4 = layoutParams.f35862a;
                if (i4 == 1) {
                    a2.a(androidx.core.c.a.a(-i2, 0, CollapsingToolbarLayout.this.b(childAt)));
                } else if (i4 == 2) {
                    a2.a(Math.round(((float) (-i2)) * layoutParams.f35863b));
                }
            }
            CollapsingToolbarLayout.this.a();
            if (CollapsingToolbarLayout.this.f35853b != null && b2 > 0) {
                u.g(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.f35852a.b(((float) Math.abs(i2)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - u.r(CollapsingToolbarLayout.this)) - b2)));
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
