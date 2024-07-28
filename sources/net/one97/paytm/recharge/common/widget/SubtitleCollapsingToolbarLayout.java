package net.one97.paytm.recharge.common.widget;

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
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.b;
import net.one97.paytm.recharge.common.utils.bg;
import net.one97.paytm.recharge.common.utils.bk;

public class SubtitleCollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    final bg f62112a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f62113b;

    /* renamed from: c  reason: collision with root package name */
    int f62114c;

    /* renamed from: d  reason: collision with root package name */
    ab f62115d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f62116e;

    /* renamed from: f  reason: collision with root package name */
    private int f62117f;

    /* renamed from: g  reason: collision with root package name */
    private Toolbar f62118g;

    /* renamed from: h  reason: collision with root package name */
    private View f62119h;

    /* renamed from: i  reason: collision with root package name */
    private View f62120i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final Rect n;
    private boolean o;
    private boolean p;
    private Drawable q;
    private int r;
    private boolean s;
    private ValueAnimator t;
    private long u;
    private int v;
    private AppBarLayout.b w;

    public SubtitleCollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubtitleCollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubtitleCollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f62116e = true;
        this.n = new Rect();
        this.v = -1;
        this.f62112a = new bg(this);
        bg bgVar = this.f62112a;
        bgVar.J = b.f61538d;
        bgVar.c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SubtitleCollapsingToolbarLayout, i2, R.style.Widget_Design_SubtitleCollapsingToolbar);
        this.f62112a.a(obtainStyledAttributes.getInt(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f62112a.b(obtainStyledAttributes.getInt(R.styleable.SubtitleCollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMargin, 0);
        this.m = dimensionPixelSize;
        this.l = dimensionPixelSize;
        this.k = dimensionPixelSize;
        this.j = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.o = obtainStyledAttributes.getBoolean(R.styleable.SubtitleCollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R.styleable.SubtitleCollapsingToolbarLayout_title));
        setSubtitle(obtainStyledAttributes.getText(R.styleable.SubtitleCollapsingToolbarLayout_subtitle));
        this.f62112a.d(R.style.TextAppearance_Design_SubtitleCollapsingToolbar_ExpandedTitle);
        this.f62112a.c(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f62112a.d(obtainStyledAttributes.getResourceId(R.styleable.SubtitleCollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f62112a.c(obtainStyledAttributes.getResourceId(R.styleable.SubtitleCollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.f62112a.f(R.style.TextAppearance_Design_SubtitleCollapsingToolbar_ExpandedSubtitle);
        this.f62112a.e(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Subtitle);
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_expandedSubtitleTextAppearance)) {
            this.f62112a.f(obtainStyledAttributes.getResourceId(R.styleable.SubtitleCollapsingToolbarLayout_expandedSubtitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SubtitleCollapsingToolbarLayout_collapsedSubtitleTextAppearance)) {
            this.f62112a.e(obtainStyledAttributes.getResourceId(R.styleable.SubtitleCollapsingToolbarLayout_collapsedSubtitleTextAppearance, 0));
        }
        this.v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SubtitleCollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.u = (long) obtainStyledAttributes.getInt(R.styleable.SubtitleCollapsingToolbarLayout_scrimAnimationDuration, H5PullContainer.DEFALUT_DURATION);
        setContentScrim(obtainStyledAttributes.getDrawable(R.styleable.SubtitleCollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(R.styleable.SubtitleCollapsingToolbarLayout_statusBarScrim));
        this.f62117f = obtainStyledAttributes.getResourceId(R.styleable.SubtitleCollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        u.a((View) this, (q) new q() {
            public final ab a(View view, ab abVar) {
                SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = SubtitleCollapsingToolbarLayout.this;
                ab abVar2 = u.A(subtitleCollapsingToolbarLayout) ? abVar : null;
                if (!c.a(subtitleCollapsingToolbarLayout.f62115d, abVar2)) {
                    subtitleCollapsingToolbarLayout.f62115d = abVar2;
                    subtitleCollapsingToolbarLayout.requestLayout();
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
            View view = (View) parent;
            setFitsSystemWindows(u.A(view));
            setFitsSystemWindows(u.A(view));
            if (this.w == null) {
                this.w = new a();
            }
            ((AppBarLayout) parent).a(this.w);
            u.z(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.b bVar = this.w;
        if (bVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(bVar);
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        float f2;
        Drawable drawable;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        b();
        if (this.f62118g == null && (drawable = this.q) != null && this.r > 0) {
            drawable.mutate().setAlpha(this.r);
            this.q.draw(canvas2);
        }
        if (this.o && this.p) {
            bg bgVar = this.f62112a;
            int save = canvas.save();
            if (bgVar.t != null && bgVar.f61594a) {
                float f3 = bgVar.k;
                float f4 = bgVar.l;
                float f5 = bgVar.o;
                float f6 = bgVar.p;
                boolean z = bgVar.w && bgVar.x != null;
                float f7 = 0.0f;
                if (z) {
                    f7 = bgVar.z * bgVar.D;
                    f2 = bgVar.C * bgVar.E;
                } else {
                    bgVar.I.ascent();
                    bgVar.I.descent();
                    bgVar.I.ascent();
                    bgVar.I.descent();
                    f2 = 0.0f;
                }
                if (z) {
                    f4 += f7;
                    f6 += f2;
                }
                float f8 = f4;
                float f9 = f6;
                int save2 = canvas.save();
                if (!TextUtils.isEmpty(bgVar.u)) {
                    if (bgVar.E != 1.0f) {
                        canvas2.scale(bgVar.E, bgVar.E, f5, f9);
                    }
                    if (z) {
                        canvas2.drawBitmap(bgVar.A, f5, f9, bgVar.B);
                    } else {
                        canvas.drawText(bgVar.v, 0, bgVar.v.length(), f5, f9, bgVar.I);
                    }
                    canvas2.restoreToCount(save2);
                }
                if (bgVar.D != 1.0f) {
                    canvas2.scale(bgVar.D, bgVar.D, f3, f8);
                }
                if (z) {
                    canvas2.drawBitmap(bgVar.x, f3, f8, bgVar.y);
                } else {
                    canvas.drawText(bgVar.t, 0, bgVar.t.length(), f3, f8, bgVar.H);
                }
            }
            canvas2.restoreToCount(save);
        }
        if (this.f62113b != null && this.r > 0) {
            ab abVar = this.f62115d;
            int b2 = abVar != null ? abVar.b() : 0;
            if (b2 > 0) {
                this.f62113b.setBounds(0, -this.f62114c, getWidth(), b2 - this.f62114c);
                this.f62113b.mutate().setAlpha(this.r);
                this.f62113b.draw(canvas2);
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
            android.graphics.drawable.Drawable r0 = r4.q
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002f
            int r0 = r4.r
            if (r0 <= 0) goto L_0x002f
            android.view.View r0 = r4.f62119h
            if (r0 == 0) goto L_0x0014
            if (r0 != r4) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            if (r6 != r0) goto L_0x001a
            goto L_0x0018
        L_0x0014:
            androidx.appcompat.widget.Toolbar r0 = r4.f62118g
            if (r6 != r0) goto L_0x001a
        L_0x0018:
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            if (r0 == 0) goto L_0x002f
            android.graphics.drawable.Drawable r0 = r4.q
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r3 = r4.r
            r0.setAlpha(r3)
            android.graphics.drawable.Drawable r0 = r4.q
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.q;
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
            boolean r0 = r6.f62116e
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f62118g = r0
            r6.f62119h = r0
            int r1 = r6.f62117f
            r2 = -1
            if (r1 == r2) goto L_0x0021
            android.view.View r1 = r6.findViewById(r1)
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1
            r6.f62118g = r1
            androidx.appcompat.widget.Toolbar r1 = r6.f62118g
            if (r1 == 0) goto L_0x0021
            android.view.View r1 = r6.c(r1)
            r6.f62119h = r1
        L_0x0021:
            androidx.appcompat.widget.Toolbar r1 = r6.f62118g
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
            r6.f62118g = r0
        L_0x003e:
            r6.c()
            r6.f62116e = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout.b():void");
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
        if (!this.o && (view = this.f62120i) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f62120i);
            }
        }
        if (this.o && this.f62118g != null) {
            if (this.f62120i == null) {
                this.f62120i = new View(getContext());
            }
            if (this.f62120i.getParent() == null) {
                this.f62118g.addView(this.f62120i, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        ab abVar = this.f62115d;
        int b2 = abVar != null ? abVar.b() : 0;
        if (mode == 0 && b2 > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + b2, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        int i6;
        int i7;
        super.onLayout(z, i2, i3, i4, i5);
        ab abVar = this.f62115d;
        if (abVar != null) {
            int b2 = abVar.b();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (!u.A(childAt) && childAt.getTop() < b2) {
                    u.f(childAt, b2);
                }
            }
        }
        if (this.o && (view = this.f62120i) != null) {
            this.p = u.M(view) && this.f62120i.getVisibility() == 0;
            if (this.p) {
                boolean z2 = u.j(this) == 1;
                View view2 = this.f62119h;
                if (view2 == null) {
                    view2 = this.f62118g;
                }
                int b3 = b(view2);
                androidx.coordinatorlayout.widget.b.a((ViewGroup) this, this.f62120i, this.n);
                bg bgVar = this.f62112a;
                int i9 = this.n.left;
                if (z2) {
                    i6 = this.f62118g.getTitleMarginEnd();
                } else {
                    i6 = this.f62118g.getTitleMarginStart();
                }
                int i10 = i9 + i6;
                int titleMarginTop = this.n.top + b3 + this.f62118g.getTitleMarginTop();
                int i11 = this.n.right;
                if (z2) {
                    i7 = this.f62118g.getTitleMarginStart();
                } else {
                    i7 = this.f62118g.getTitleMarginEnd();
                }
                int i12 = i11 + i7;
                int titleMarginBottom = (this.n.bottom + b3) - this.f62118g.getTitleMarginBottom();
                if (!bg.a(bgVar.f61597d, i10, titleMarginTop, i12, titleMarginBottom)) {
                    bgVar.f61597d.set(i10, titleMarginTop, i12, titleMarginBottom);
                    bgVar.G = true;
                    bgVar.a();
                }
                bg bgVar2 = this.f62112a;
                int i13 = z2 ? this.l : this.j;
                int i14 = this.n.top + this.k;
                int i15 = (i4 - i2) - (z2 ? this.j : this.l);
                int i16 = (i5 - i3) - this.m;
                if (!bg.a(bgVar2.f61596c, i13, i14, i15, i16)) {
                    bgVar2.f61596c.set(i13, i14, i15, i16);
                    bgVar2.G = true;
                    bgVar2.a();
                }
                this.f62112a.c();
            }
        }
        int childCount2 = getChildCount();
        for (int i17 = 0; i17 < childCount2; i17++) {
            bk a2 = a(getChildAt(i17));
            a2.f61612b = a2.f61611a.getTop();
            a2.f61613c = a2.f61611a.getLeft();
            a2.a();
        }
        if (this.f62118g != null) {
            if (this.o && TextUtils.isEmpty(this.f62112a.s)) {
                setTitle(this.f62118g.getTitle());
            }
            View view3 = this.f62119h;
            if (view3 == null || view3 == this) {
                setMinimumHeight(d(this.f62118g));
            } else {
                setMinimumHeight(d(view3));
            }
        }
        a();
    }

    private static int d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static bk a(View view) {
        bk bkVar = (bk) view.getTag(R.id.view_offset_helper);
        if (bkVar != null) {
            return bkVar;
        }
        bk bkVar2 = new bk(view);
        view.setTag(R.id.view_offset_helper, bkVar2);
        return bkVar2;
    }

    public void setTitle(CharSequence charSequence) {
        bg bgVar = this.f62112a;
        if (charSequence == null || !charSequence.equals(bgVar.s)) {
            bgVar.s = charSequence;
            bgVar.t = null;
            bgVar.d();
            bgVar.c();
        }
        e();
    }

    public CharSequence getTitle() {
        if (this.o) {
            return this.f62112a.s;
        }
        return null;
    }

    public void setSubtitle(CharSequence charSequence) {
        bg bgVar = this.f62112a;
        if (charSequence == null || !charSequence.equals(bgVar.u)) {
            bgVar.u = charSequence;
            bgVar.v = null;
            bgVar.d();
            bgVar.c();
        }
        e();
    }

    public CharSequence getSubtitle() {
        if (this.o) {
            return this.f62112a.u;
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.o) {
            this.o = z;
            e();
            c();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, u.J(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.s != z) {
            int i2 = PriceRangeSeekBar.INVALID_POINTER_ID;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                b();
                ValueAnimator valueAnimator = this.t;
                if (valueAnimator == null) {
                    this.t = new ValueAnimator();
                    this.t.setDuration(this.u);
                    this.t.setInterpolator(i2 > this.r ? b.f61536b : b.f61537c);
                    this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SubtitleCollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else if (valueAnimator.isRunning()) {
                    this.t.cancel();
                }
                this.t.setIntValues(new int[]{this.r, i2});
                this.t.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.s = z;
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.r) {
            if (!(this.q == null || (toolbar = this.f62118g) == null)) {
                u.g(toolbar);
            }
            this.r = i2;
            u.g(this);
        }
    }

    public int getScrimAlpha() {
        return this.r;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.q = drawable3;
            Drawable drawable4 = this.q;
            if (drawable4 != null) {
                drawable4.setBounds(0, 0, getWidth(), getHeight());
                this.q.setCallback(this);
                this.q.setAlpha(this.r);
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
        return this.q;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f62113b;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f62113b = drawable3;
            Drawable drawable4 = this.f62113b;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.f62113b.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.f62113b, u.j(this));
                this.f62113b.setVisible(getVisibility() == 0, false);
                this.f62113b.setCallback(this);
                this.f62113b.setAlpha(this.r);
            }
            u.g(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f62113b;
        boolean z = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState) | false;
        Drawable drawable2 = this.q;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        bg bgVar = this.f62112a;
        if (bgVar != null) {
            bgVar.F = drawableState;
            if ((bgVar.f61601h != null && bgVar.f61601h.isStateful()) || (bgVar.f61600g != null && bgVar.f61600g.isStateful())) {
                bgVar.c();
                z = true;
            }
            state |= z;
        }
        if (state) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q || drawable == this.f62113b;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f62113b;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.f62113b.setVisible(z, false);
        }
        Drawable drawable2 = this.q;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.q.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(androidx.core.content.b.a(getContext(), i2));
    }

    public Drawable getStatusBarScrim() {
        return this.f62113b;
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.f62112a.c(i2);
    }

    public void setCollapsedSubtitleTextAppearance(int i2) {
        this.f62112a.e(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        bg bgVar = this.f62112a;
        if (bgVar.f61601h != colorStateList) {
            bgVar.f61601h = colorStateList;
            bgVar.c();
        }
    }

    public void setCollapsedSubtitleTextColor(int i2) {
        setCollapsedSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedSubtitleTextColor(ColorStateList colorStateList) {
        bg bgVar = this.f62112a;
        if (bgVar.j != colorStateList) {
            bgVar.j = colorStateList;
            bgVar.c();
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f62112a.b(i2);
    }

    public int getCollapsedTitleGravity() {
        return this.f62112a.f61599f;
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.f62112a.d(i2);
    }

    public void setExpandedSubtitleTextAppearance(int i2) {
        this.f62112a.f(i2);
    }

    public void setExpandedTitleTextColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        bg bgVar = this.f62112a;
        if (bgVar.f61600g != colorStateList) {
            bgVar.f61600g = colorStateList;
            bgVar.c();
        }
    }

    public void setExpandedSubtitleTextColor(int i2) {
        setExpandedSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedSubtitleTextColor(ColorStateList colorStateList) {
        bg bgVar = this.f62112a;
        if (bgVar.f61602i != colorStateList) {
            bgVar.f61602i = colorStateList;
            bgVar.c();
        }
    }

    public void setExpandedTitleGravity(int i2) {
        this.f62112a.a(i2);
    }

    public int getExpandedTitleGravity() {
        return this.f62112a.f61598e;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        bg bgVar = this.f62112a;
        if (bgVar.m != typeface) {
            bgVar.m = typeface;
            bgVar.c();
        }
    }

    public Typeface getCollapsedTitleTypeface() {
        bg bgVar = this.f62112a;
        return bgVar.m != null ? bgVar.m : Typeface.DEFAULT;
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        bg bgVar = this.f62112a;
        if (bgVar.n != typeface) {
            bgVar.n = typeface;
            bgVar.c();
        }
    }

    public Typeface getExpandedTitleTypeface() {
        bg bgVar = this.f62112a;
        return bgVar.n != null ? bgVar.n : Typeface.DEFAULT;
    }

    public void setCollapsedSubtitleTypeface(Typeface typeface) {
        bg bgVar = this.f62112a;
        if (bgVar.q != typeface) {
            bgVar.q = typeface;
            bgVar.c();
        }
    }

    public Typeface getCollapsedSubtitleTypeface() {
        bg bgVar = this.f62112a;
        return bgVar.q != null ? bgVar.q : Typeface.DEFAULT;
    }

    public void setExpandedSubtitleTypeface(Typeface typeface) {
        bg bgVar = this.f62112a;
        if (bgVar.r != typeface) {
            bgVar.r = typeface;
            bgVar.c();
        }
    }

    public Typeface getExpandedSubtitleTypeface() {
        bg bgVar = this.f62112a;
        return bgVar.r != null ? bgVar.r : Typeface.DEFAULT;
    }

    public void setExpandedTitleMargin(int i2, int i3, int i4, int i5) {
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.j;
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.j = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.k;
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.k = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.l;
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.l = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.m;
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.v != i2) {
            this.v = i2;
            a();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.v;
        if (i2 >= 0) {
            return i2;
        }
        ab abVar = this.f62115d;
        int b2 = abVar != null ? abVar.b() : 0;
        int r2 = u.r(this);
        if (r2 > 0) {
            return Math.min((r2 * 2) + b2, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j2) {
        this.u = j2;
    }

    public long getScrimAnimationDuration() {
        return this.u;
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

    public static class LayoutParams extends CollapsingToolbarLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2) {
            super(i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.q != null || this.f62113b != null) {
            setScrimsShown(getHeight() + this.f62114c < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(View view) {
        return ((getHeight() - a(view).f61612b) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private void e() {
        setContentDescription(getTitle());
    }

    class a implements AppBarLayout.b {
        a() {
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = SubtitleCollapsingToolbarLayout.this;
            subtitleCollapsingToolbarLayout.f62114c = i2;
            int b2 = subtitleCollapsingToolbarLayout.f62115d != null ? SubtitleCollapsingToolbarLayout.this.f62115d.b() : 0;
            int childCount = SubtitleCollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = SubtitleCollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                bk a2 = SubtitleCollapsingToolbarLayout.a(childAt);
                int i4 = layoutParams.f35862a;
                if (i4 == 1) {
                    a2.a(androidx.core.c.a.a(-i2, 0, SubtitleCollapsingToolbarLayout.this.b(childAt)));
                } else if (i4 == 2) {
                    a2.a(Math.round(((float) (-i2)) * layoutParams.f35863b));
                }
            }
            SubtitleCollapsingToolbarLayout.this.a();
            if (SubtitleCollapsingToolbarLayout.this.f62113b != null && b2 > 0) {
                u.g(SubtitleCollapsingToolbarLayout.this);
            }
            int height = (SubtitleCollapsingToolbarLayout.this.getHeight() - u.r(SubtitleCollapsingToolbarLayout.this)) - b2;
            bg bgVar = SubtitleCollapsingToolbarLayout.this.f62112a;
            float a3 = androidx.core.c.a.a(((float) Math.abs(i2)) / ((float) height), 0.0f, 1.0f);
            if (a3 != bgVar.f61595b) {
                bgVar.f61595b = a3;
                bgVar.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
