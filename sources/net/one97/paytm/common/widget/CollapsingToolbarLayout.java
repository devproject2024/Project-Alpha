package net.one97.paytm.common.widget;

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
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.widget.h;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f49648a;

    /* renamed from: b  reason: collision with root package name */
    int f49649b;

    /* renamed from: c  reason: collision with root package name */
    ab f49650c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49651d;

    /* renamed from: e  reason: collision with root package name */
    private int f49652e;

    /* renamed from: f  reason: collision with root package name */
    private Toolbar f49653f;

    /* renamed from: g  reason: collision with root package name */
    private View f49654g;

    /* renamed from: h  reason: collision with root package name */
    private View f49655h;

    /* renamed from: i  reason: collision with root package name */
    private int f49656i;
    private int j;
    private int k;
    private int l;
    private final Rect m;
    /* access modifiers changed from: private */
    public final a n;
    private boolean o;
    private boolean p;
    private Drawable q;
    private int r;
    private boolean s;
    private ValueAnimator t;
    private long u;
    private int v;
    private AppBarLayout.b w;

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f49651d = true;
        this.m = new Rect();
        this.v = -1;
        b.a().checkAppCompatTheme(context);
        this.n = new a(this);
        a aVar = this.n;
        aVar.w = net.one97.paytm.wallet.newdesign.universalp2p.utils.a.f71455e;
        aVar.c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout, i2, R.style.Widget_Design_MultilineCollapsingToolbar);
        this.n.a(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.n.b(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.l = dimensionPixelSize;
        this.k = dimensionPixelSize;
        this.j = dimensionPixelSize;
        this.f49656i = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f49656i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.o = obtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        this.n.d(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.n.c(R.style.ActionBar_Title);
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.n.d(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.n.c(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.u = (long) obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, H5PullContainer.DEFALUT_DURATION);
        setContentScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f49652e = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        u.a((View) this, (q) new q() {
            public final ab a(View view, ab abVar) {
                CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                ab abVar2 = u.A(collapsingToolbarLayout) ? abVar : null;
                if (!c.a(collapsingToolbarLayout.f49650c, abVar2)) {
                    collapsingToolbarLayout.f49650c = abVar2;
                    collapsingToolbarLayout.requestLayout();
                }
                return abVar.f3061b.c();
            }
        });
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayoutExtension, i2, 0);
        this.n.e(obtainStyledAttributes2.getInteger(R.styleable.CollapsingToolbarLayoutExtension_maxLines1, 3));
        this.n.a(obtainStyledAttributes2.getFloat(R.styleable.CollapsingToolbarLayoutExtension_lineSpacingExtra, 0.0f));
        this.n.b(obtainStyledAttributes2.getFloat(R.styleable.CollapsingToolbarLayoutExtension_lineSpacingMultiplier, 1.0f));
        obtainStyledAttributes2.recycle();
    }

    public void setMaxLines(int i2) {
        this.n.e(i2);
    }

    public int getMaxLines() {
        return this.n.E;
    }

    /* access modifiers changed from: package-private */
    public void setLineSpacingExtra(float f2) {
        this.n.a(f2);
    }

    /* access modifiers changed from: package-private */
    public float getLineSpacingExtra() {
        return this.n.F;
    }

    /* access modifiers changed from: package-private */
    public void setLineSpacingMultiplier(float f2) {
        this.n.b(f2);
    }

    /* access modifiers changed from: package-private */
    public float getLineSpacingMultiplier() {
        return this.n.G;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            u.b((View) this, u.A((View) parent));
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
        if (this.f49653f == null && (drawable = this.q) != null && this.r > 0) {
            drawable.mutate().setAlpha(this.r);
            this.q.draw(canvas2);
        }
        if (this.o && this.p) {
            a aVar = this.n;
            int save = canvas.save();
            if (aVar.n != null && aVar.f49662a) {
                float f3 = aVar.f49670i;
                float f4 = aVar.j;
                boolean z = aVar.o && aVar.p != null;
                aVar.v.setTextSize(aVar.s);
                if (z) {
                    f2 = 0.0f;
                } else {
                    f2 = aVar.v.ascent() * aVar.r;
                }
                if (aVar.r != 1.0f) {
                    canvas2.scale(aVar.r, aVar.r, f3, f4);
                }
                float lineLeft = (aVar.f49670i + aVar.A.getLineLeft(0)) - (aVar.D * 2.0f);
                if (z) {
                    aVar.q.setAlpha((int) (aVar.C * 255.0f));
                    canvas2.drawBitmap(aVar.p, lineLeft, f4, aVar.q);
                    aVar.q.setAlpha((int) (aVar.B * 255.0f));
                    canvas2.drawBitmap(aVar.y, f3, f4, aVar.q);
                    aVar.q.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
                    canvas2.drawBitmap(aVar.z, f3, f4, aVar.q);
                } else {
                    canvas2.translate(lineLeft, f4);
                    aVar.v.setAlpha((int) (aVar.C * 255.0f));
                    aVar.A.draw(canvas2);
                    canvas2.translate(f3 - lineLeft, 0.0f);
                    aVar.v.setAlpha((int) (aVar.B * 255.0f));
                    float f5 = -f2;
                    canvas.drawText(aVar.x, 0, aVar.x.length(), 0.0f, f5 / aVar.r, aVar.v);
                    String trim = aVar.x.toString().trim();
                    if (trim.endsWith("…")) {
                        trim = trim.substring(0, trim.length() - 1);
                    }
                    String str = trim;
                    aVar.v.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
                    canvas.drawText(str, 0, aVar.A.getLineEnd(0) <= str.length() ? aVar.A.getLineEnd(0) : str.length(), 0.0f, f5 / aVar.r, aVar.v);
                }
            }
            canvas2.restoreToCount(save);
        }
        if (this.f49648a != null && this.r > 0) {
            ab abVar = this.f49650c;
            int b2 = abVar != null ? abVar.b() : 0;
            if (b2 > 0) {
                this.f49648a.setBounds(0, -this.f49649b, getWidth(), b2 - this.f49649b);
                this.f49648a.mutate().setAlpha(this.r);
                this.f49648a.draw(canvas2);
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
            android.view.View r0 = r4.f49654g
            if (r0 == 0) goto L_0x0014
            if (r0 != r4) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            if (r6 != r0) goto L_0x001a
            goto L_0x0018
        L_0x0014:
            androidx.appcompat.widget.Toolbar r0 = r4.f49653f
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.widget.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
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
            boolean r0 = r6.f49651d
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f49653f = r0
            r6.f49654g = r0
            int r1 = r6.f49652e
            r2 = -1
            if (r1 == r2) goto L_0x0021
            android.view.View r1 = r6.findViewById(r1)
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1
            r6.f49653f = r1
            androidx.appcompat.widget.Toolbar r1 = r6.f49653f
            if (r1 == 0) goto L_0x0021
            android.view.View r1 = r6.c(r1)
            r6.f49654g = r1
        L_0x0021:
            androidx.appcompat.widget.Toolbar r1 = r6.f49653f
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
            r6.f49653f = r0
        L_0x003e:
            r6.c()
            r6.f49651d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.widget.CollapsingToolbarLayout.b():void");
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
        if (!this.o && (view = this.f49655h) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f49655h);
            }
        }
        if (this.o && this.f49653f != null) {
            if (this.f49655h == null) {
                this.f49655h = new View(getContext());
            }
            if (this.f49655h.getParent() == null) {
                this.f49653f.addView(this.f49655h, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        ab abVar = this.f49650c;
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
        ab abVar = this.f49650c;
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
        if (this.o && (view = this.f49655h) != null) {
            this.p = u.M(view) && this.f49655h.getVisibility() == 0;
            if (this.p) {
                boolean z2 = u.j(this) == 1;
                View view2 = this.f49654g;
                if (view2 == null) {
                    view2 = this.f49653f;
                }
                int b3 = b(view2);
                androidx.coordinatorlayout.widget.b.a((ViewGroup) this, this.f49655h, this.m);
                a aVar = this.n;
                int i9 = this.m.left;
                if (z2) {
                    i6 = this.f49653f.getTitleMarginEnd();
                } else {
                    i6 = this.f49653f.getTitleMarginStart();
                }
                int i10 = i9 + i6;
                int titleMarginTop = this.m.top + b3 + this.f49653f.getTitleMarginTop();
                int i11 = this.m.right;
                if (z2) {
                    i7 = this.f49653f.getTitleMarginStart();
                } else {
                    i7 = this.f49653f.getTitleMarginEnd();
                }
                int i12 = i11 + i7;
                int titleMarginBottom = (this.m.bottom + b3) - this.f49653f.getTitleMarginBottom();
                if (!a.a(aVar.f49665d, i10, titleMarginTop, i12, titleMarginBottom)) {
                    aVar.f49665d.set(i10, titleMarginTop, i12, titleMarginBottom);
                    aVar.u = true;
                    aVar.a();
                }
                a aVar2 = this.n;
                int i13 = z2 ? this.k : this.f49656i;
                int i14 = this.m.top + this.j;
                int i15 = (i4 - i2) - (z2 ? this.f49656i : this.k);
                int i16 = (i5 - i3) - this.l;
                if (!a.a(aVar2.f49664c, i13, i14, i15, i16)) {
                    aVar2.f49664c.set(i13, i14, i15, i16);
                    aVar2.u = true;
                    aVar2.a();
                }
                this.n.c();
            }
        }
        int childCount2 = getChildCount();
        for (int i17 = 0; i17 < childCount2; i17++) {
            h a2 = a(getChildAt(i17));
            a2.f72431b = a2.f72430a.getTop();
            a2.f72432c = a2.f72430a.getLeft();
            a2.a();
        }
        if (this.f49653f != null) {
            if (this.o && TextUtils.isEmpty(this.n.m)) {
                this.n.a(this.f49653f.getTitle());
            }
            View view3 = this.f49654g;
            if (view3 == null || view3 == this) {
                setMinimumHeight(d(this.f49653f));
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

    static h a(View view) {
        h hVar = (h) view.getTag(R.id.view_offset_helper);
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(view);
        view.setTag(R.id.view_offset_helper, hVar2);
        return hVar2;
    }

    public void setTitle(CharSequence charSequence) {
        this.n.a(charSequence);
    }

    public CharSequence getTitle() {
        if (this.o) {
            return this.n.m;
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.o) {
            this.o = z;
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
                    this.t.setInterpolator(i2 > this.r ? net.one97.paytm.wallet.newdesign.universalp2p.utils.a.f71453c : net.one97.paytm.wallet.newdesign.universalp2p.utils.a.f71454d);
                    this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            if (!(this.q == null || (toolbar = this.f49653f) == null)) {
                u.g(toolbar);
            }
            this.r = i2;
            u.g(this);
        }
    }

    /* access modifiers changed from: package-private */
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
        Drawable drawable2 = this.f49648a;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f49648a = drawable3;
            Drawable drawable4 = this.f49648a;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.f49648a.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.f49648a, u.j(this));
                this.f49648a.setVisible(getVisibility() == 0, false);
                this.f49648a.setCallback(this);
                this.f49648a.setAlpha(this.r);
            }
            u.g(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f49648a;
        boolean z = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState) | false;
        Drawable drawable2 = this.q;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        a aVar = this.n;
        if (aVar != null) {
            aVar.t = drawableState;
            if ((aVar.f49669h != null && aVar.f49669h.isStateful()) || (aVar.f49668g != null && aVar.f49668g.isStateful())) {
                aVar.c();
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
        return super.verifyDrawable(drawable) || drawable == this.q || drawable == this.f49648a;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f49648a;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.f49648a.setVisible(z, false);
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
        return this.f49648a;
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.n.c(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        a aVar = this.n;
        if (aVar.f49669h != colorStateList) {
            aVar.f49669h = colorStateList;
            aVar.c();
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.n.b(i2);
    }

    public int getCollapsedTitleGravity() {
        return this.n.f49667f;
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.n.d(i2);
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        a aVar = this.n;
        if (aVar.f49668g != colorStateList) {
            aVar.f49668g = colorStateList;
            aVar.c();
        }
    }

    public void setExpandedTitleGravity(int i2) {
        this.n.a(i2);
    }

    public int getExpandedTitleGravity() {
        return this.n.f49666e;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        a aVar = this.n;
        if (a.a(aVar.k, typeface)) {
            aVar.k = typeface;
            aVar.c();
        }
    }

    public Typeface getCollapsedTitleTypeface() {
        a aVar = this.n;
        return aVar.k != null ? aVar.k : Typeface.DEFAULT;
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        a aVar = this.n;
        if (a.a(aVar.l, typeface)) {
            aVar.l = typeface;
            aVar.c();
        }
    }

    public Typeface getExpandedTitleTypeface() {
        a aVar = this.n;
        return aVar.l != null ? aVar.l : Typeface.DEFAULT;
    }

    public void setExpandedTitleMargin(int i2, int i3, int i4, int i5) {
        this.f49656i = i2;
        this.j = i3;
        this.k = i4;
        this.l = i5;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.f49656i;
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f49656i = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.j;
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.j = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.k;
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.k = i2;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.l;
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.l = i2;
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
        ab abVar = this.f49650c;
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

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f49659a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f49660b = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f49659a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.f49660b = obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.q != null || this.f49648a != null) {
            setScrimsShown(getHeight() + this.f49649b < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(View view) {
        return ((getHeight() - a(view).f72431b) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    class a implements AppBarLayout.b {
        a() {
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f49649b = i2;
            int b2 = collapsingToolbarLayout.f49650c != null ? CollapsingToolbarLayout.this.f49650c.b() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                h a2 = CollapsingToolbarLayout.a(childAt);
                int i4 = layoutParams.f49659a;
                if (i4 == 1) {
                    a2.a(androidx.core.c.a.a(-i2, 0, CollapsingToolbarLayout.this.b(childAt)));
                } else if (i4 == 2) {
                    a2.a(Math.round(((float) (-i2)) * layoutParams.f49660b));
                }
            }
            CollapsingToolbarLayout.this.a();
            if (CollapsingToolbarLayout.this.f49648a != null && b2 > 0) {
                u.g(CollapsingToolbarLayout.this);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - u.r(CollapsingToolbarLayout.this)) - b2;
            a a3 = CollapsingToolbarLayout.this.n;
            float a4 = androidx.core.c.a.a(((float) Math.abs(i2)) / ((float) height), 0.0f, 1.0f);
            if (a4 != a3.f49663b) {
                a3.f49663b = a4;
                a3.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
