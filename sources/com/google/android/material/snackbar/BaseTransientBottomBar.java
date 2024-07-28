package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.ab;
import androidx.core.h.q;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.k;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a  reason: collision with root package name */
    static final Handler f36653a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).f();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).b(message.arg1);
                return true;
            }
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f36654f = (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19);

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f36655g = {R.attr.snackbarStyle};
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f36656h = BaseTransientBottomBar.class.getSimpleName();
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f36657b;

    /* renamed from: c  reason: collision with root package name */
    protected final SnackbarBaseLayout f36658c;

    /* renamed from: d  reason: collision with root package name */
    public int f36659d;

    /* renamed from: e  reason: collision with root package name */
    b.a f36660e = new b.a() {
        public final void a() {
            Handler handler = BaseTransientBottomBar.f36653a;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        public final void a(int i2) {
            Handler handler = BaseTransientBottomBar.f36653a;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f36661i;
    /* access modifiers changed from: private */
    public final a j;
    private boolean k;
    private View l;
    private final Runnable m = new Runnable() {
        public final void run() {
            int b2;
            if (BaseTransientBottomBar.this.f36658c != null && BaseTransientBottomBar.this.f36657b != null && (b2 = (BaseTransientBottomBar.b(BaseTransientBottomBar.this) - BaseTransientBottomBar.c(BaseTransientBottomBar.this)) + ((int) BaseTransientBottomBar.this.f36658c.getTranslationY())) < BaseTransientBottomBar.this.r) {
                ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f36658c.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    String unused = BaseTransientBottomBar.f36656h;
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.r - b2;
                BaseTransientBottomBar.this.f36658c.requestLayout();
            }
        }
    };
    private Rect n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public int q;
    /* access modifiers changed from: private */
    public int r;
    private int s;
    private List<a<B>> t;
    private Behavior u;
    private final AccessibilityManager v;

    public static abstract class a<B> {
        public void a(B b2) {
        }

        public void a(B b2, int i2) {
        }
    }

    protected interface c {
        void a();

        void b();
    }

    protected interface d {
        void a();
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, a aVar) {
        int i2;
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (aVar != null) {
            this.f36661i = viewGroup;
            this.j = aVar;
            this.f36657b = viewGroup.getContext();
            k.a(this.f36657b);
            LayoutInflater from = LayoutInflater.from(this.f36657b);
            TypedArray obtainStyledAttributes = this.f36657b.obtainStyledAttributes(f36655g);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            if (resourceId != -1) {
                i2 = R.layout.mtrl_layout_snackbar;
            } else {
                i2 = R.layout.design_layout_snackbar;
            }
            this.f36658c = (SnackbarBaseLayout) from.inflate(i2, this.f36661i, false);
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                float actionTextColorAlpha = this.f36658c.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.f36700a.setTextColor(com.google.android.material.b.a.a(com.google.android.material.h.b.a((View) snackbarContentLayout, R.attr.colorSurface), snackbarContentLayout.f36700a.getCurrentTextColor(), actionTextColorAlpha));
                }
            }
            this.f36658c.addView(view);
            ViewGroup.LayoutParams layoutParams = this.f36658c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.n = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            u.l(this.f36658c);
            u.c((View) this.f36658c, 1);
            u.b((View) this.f36658c, true);
            u.a((View) this.f36658c, (q) new q() {
                public final ab a(View view, ab abVar) {
                    int unused = BaseTransientBottomBar.this.o = abVar.d();
                    int unused2 = BaseTransientBottomBar.this.p = abVar.a();
                    int unused3 = BaseTransientBottomBar.this.q = abVar.c();
                    BaseTransientBottomBar.this.j();
                    return abVar;
                }
            });
            u.a((View) this.f36658c, (androidx.core.h.a) new androidx.core.h.a() {
                public final void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
                    super.onInitializeAccessibilityNodeInfo(view, cVar);
                    cVar.a(1048576);
                    cVar.k(true);
                }

                public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                    if (i2 != 1048576) {
                        return super.performAccessibilityAction(view, i2, bundle);
                    }
                    BaseTransientBottomBar.this.d();
                    return true;
                }
            });
            this.v = (AccessibilityManager) this.f36657b.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        if (((r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.d) && (((androidx.coordinatorlayout.widget.CoordinatorLayout.d) r0).f2603a instanceof com.google.android.material.behavior.SwipeDismissBehavior)) != false) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r4 = this;
            com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout r0 = r4.f36658c
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r1 == 0) goto L_0x0071
            android.graphics.Rect r1 = r4.n
            if (r1 != 0) goto L_0x000f
            goto L_0x0071
        L_0x000f:
            android.view.View r1 = r4.l
            if (r1 == 0) goto L_0x0016
            int r1 = r4.s
            goto L_0x0018
        L_0x0016:
            int r1 = r4.o
        L_0x0018:
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            android.graphics.Rect r2 = r4.n
            int r2 = r2.bottom
            int r2 = r2 + r1
            r0.bottomMargin = r2
            android.graphics.Rect r1 = r4.n
            int r1 = r1.left
            int r2 = r4.p
            int r1 = r1 + r2
            r0.leftMargin = r1
            android.graphics.Rect r1 = r4.n
            int r1 = r1.right
            int r2 = r4.q
            int r1 = r1 + r2
            r0.rightMargin = r1
            com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout r0 = r4.f36658c
            r0.requestLayout()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0071
            int r0 = r4.r
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0060
            boolean r0 = r4.k
            if (r0 != 0) goto L_0x0060
            com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout r0 = r4.f36658c
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r3 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.d
            if (r3 == 0) goto L_0x005c
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r0.f2603a
            boolean r0 = r0 instanceof com.google.android.material.behavior.SwipeDismissBehavior
            if (r0 == 0) goto L_0x005c
            r0 = 1
            goto L_0x005d
        L_0x005c:
            r0 = 0
        L_0x005d:
            if (r0 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            if (r1 == 0) goto L_0x0071
            com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout r0 = r4.f36658c
            java.lang.Runnable r1 = r4.m
            r0.removeCallbacks(r1)
            com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout r0 = r4.f36658c
            java.lang.Runnable r1 = r4.m
            r0.post(r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.BaseTransientBottomBar.j():void");
    }

    public int a() {
        return this.f36659d;
    }

    public final View b() {
        return this.f36658c;
    }

    public void c() {
        b a2 = b.a();
        int a3 = a();
        b.a aVar = this.f36660e;
        synchronized (a2.f36705a) {
            if (a2.f(aVar)) {
                a2.f36707c.f36711b = a3;
                a2.f36706b.removeCallbacksAndMessages(a2.f36707c);
                a2.a(a2.f36707c);
                return;
            }
            if (a2.g(aVar)) {
                a2.f36708d.f36711b = a3;
            } else {
                a2.f36708d = new b.C0609b(a3, aVar);
            }
            if (a2.f36707c == null || !a2.a(a2.f36707c, 4)) {
                a2.f36707c = null;
                a2.b();
            }
        }
    }

    public void d() {
        a(3);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        b.a().a(this.f36660e, i2);
    }

    public final B a(a<B> aVar) {
        if (aVar == null) {
            return this;
        }
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(aVar);
        return this;
    }

    public boolean e() {
        return b.a().d(this.f36660e);
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        int i2;
        this.f36658c.setOnAttachStateChangeListener(new c() {
            public final void a() {
                WindowInsets rootWindowInsets;
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = BaseTransientBottomBar.this.f36658c.getRootWindowInsets()) != null) {
                    int unused = BaseTransientBottomBar.this.r = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    BaseTransientBottomBar.this.j();
                }
            }

            public final void b() {
                if (b.a().e(BaseTransientBottomBar.this.f36660e)) {
                    BaseTransientBottomBar.f36653a.post(new Runnable() {
                        public final void run() {
                            BaseTransientBottomBar.this.c(3);
                        }
                    });
                }
            }
        });
        if (this.f36658c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f36658c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                Behavior behavior = this.u;
                if (behavior == null) {
                    behavior = new Behavior();
                }
                if (behavior instanceof Behavior) {
                    behavior.f36684g.f36693a = this.f36660e;
                }
                behavior.f35906b = new SwipeDismissBehavior.a() {
                    public final void a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.a(0);
                    }

                    public final void a(int i2) {
                        if (i2 == 0) {
                            b.a().c(BaseTransientBottomBar.this.f36660e);
                        } else if (i2 == 1 || i2 == 2) {
                            b.a().b(BaseTransientBottomBar.this.f36660e);
                        }
                    }
                };
                dVar.a((CoordinatorLayout.Behavior) behavior);
                if (this.l == null) {
                    dVar.f2609g = 80;
                }
            }
            View view = this.l;
            if (view == null) {
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i3 = iArr[1];
                int[] iArr2 = new int[2];
                this.f36661i.getLocationOnScreen(iArr2);
                i2 = (iArr2[1] + this.f36661i.getHeight()) - i3;
            }
            this.s = i2;
            j();
            this.f36658c.setVisibility(4);
            this.f36661i.addView(this.f36658c);
        }
        if (u.J(this.f36658c)) {
            k();
        } else {
            this.f36658c.setOnLayoutChangeListener(new d() {
                public final void a() {
                    BaseTransientBottomBar.this.f36658c.setOnLayoutChangeListener((d) null);
                    BaseTransientBottomBar.this.k();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        if (n()) {
            l();
            return;
        }
        this.f36658c.setVisibility(0);
        g();
    }

    private void l() {
        this.f36658c.post(new Runnable() {
            public final void run() {
                if (BaseTransientBottomBar.this.f36658c != null) {
                    BaseTransientBottomBar.this.f36658c.setVisibility(0);
                    if (BaseTransientBottomBar.this.f36658c.getAnimationMode() == 1) {
                        BaseTransientBottomBar.g(BaseTransientBottomBar.this);
                    } else {
                        BaseTransientBottomBar.h(BaseTransientBottomBar.this);
                    }
                }
            }
        });
    }

    private ValueAnimator a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.a.a.f35800a);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.f36658c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private int m() {
        int height = this.f36658c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f36658c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* access modifiers changed from: package-private */
    public final void b(final int i2) {
        if (!n() || this.f36658c.getVisibility() != 0) {
            c(i2);
        } else if (this.f36658c.getAnimationMode() == 1) {
            ValueAnimator a2 = a(1.0f, 0.0f);
            a2.setDuration(75);
            a2.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.c(i2);
                }
            });
            a2.start();
        } else {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{0, m()});
            valueAnimator.setInterpolator(com.google.android.material.a.a.f35801b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.j.b();
                }

                public final void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.c(i2);
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                /* renamed from: b  reason: collision with root package name */
                private int f36683b = 0;

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.f36654f) {
                        u.f((View) BaseTransientBottomBar.this.f36658c, intValue - this.f36683b);
                    } else {
                        BaseTransientBottomBar.this.f36658c.setTranslationY((float) intValue);
                    }
                    this.f36683b = intValue;
                }
            });
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        b.a().a(this.f36660e);
        List<a<B>> list = this.t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.t.get(size).a(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        b a2 = b.a();
        b.a aVar = this.f36660e;
        synchronized (a2.f36705a) {
            if (a2.f(aVar)) {
                a2.f36707c = null;
                if (a2.f36708d != null) {
                    a2.b();
                }
            }
        }
        List<a<B>> list = this.t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.t.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f36658c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f36658c);
        }
    }

    private boolean n() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.v.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    protected static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final View.OnTouchListener f36685a = new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private d f36686b;

        /* renamed from: c  reason: collision with root package name */
        private c f36687c;

        /* renamed from: d  reason: collision with root package name */
        private int f36688d;

        /* renamed from: e  reason: collision with root package name */
        private final float f36689e;

        /* renamed from: f  reason: collision with root package name */
        private final float f36690f;

        /* renamed from: g  reason: collision with root package name */
        private ColorStateList f36691g;

        /* renamed from: h  reason: collision with root package name */
        private PorterDuff.Mode f36692h;

        protected SnackbarBaseLayout(Context context) {
            this(context, (AttributeSet) null);
        }

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(com.google.android.material.theme.a.a.a(context, attributeSet, 0, 0), attributeSet);
            Drawable drawable;
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                u.g((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            this.f36688d = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.f36689e = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(com.google.android.material.h.c.a(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.q.a(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f36690f = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f36685a);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                int i2 = R.attr.colorSurface;
                int i3 = R.attr.colorOnSurface;
                gradientDrawable.setColor(com.google.android.material.b.a.a(com.google.android.material.h.b.a((View) this, i2), com.google.android.material.h.b.a((View) this, i3), getBackgroundOverlayColorAlpha()));
                if (this.f36691g != null) {
                    drawable = androidx.core.graphics.drawable.a.f(gradientDrawable);
                    androidx.core.graphics.drawable.a.a(drawable, this.f36691g);
                } else {
                    drawable = androidx.core.graphics.drawable.a.f(gradientDrawable);
                }
                u.a((View) this, drawable);
            }
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f36691g == null)) {
                drawable = androidx.core.graphics.drawable.a.f(drawable.mutate());
                androidx.core.graphics.drawable.a.a(drawable, this.f36691g);
                androidx.core.graphics.drawable.a.a(drawable, this.f36692h);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f36691g = colorStateList;
            if (getBackground() != null) {
                Drawable f2 = androidx.core.graphics.drawable.a.f(getBackground().mutate());
                androidx.core.graphics.drawable.a.a(f2, colorStateList);
                androidx.core.graphics.drawable.a.a(f2, this.f36692h);
                if (f2 != getBackground()) {
                    super.setBackgroundDrawable(f2);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f36692h = mode;
            if (getBackground() != null) {
                Drawable f2 = androidx.core.graphics.drawable.a.f(getBackground().mutate());
                androidx.core.graphics.drawable.a.a(f2, mode);
                if (f2 != getBackground()) {
                    super.setBackgroundDrawable(f2);
                }
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f36685a);
            super.setOnClickListener(onClickListener);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            d dVar = this.f36686b;
            if (dVar != null) {
                dVar.a();
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            c cVar = this.f36687c;
            if (cVar != null) {
                cVar.a();
            }
            u.z(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            c cVar = this.f36687c;
            if (cVar != null) {
                cVar.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(d dVar) {
            this.f36686b = dVar;
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(c cVar) {
            this.f36687c = cVar;
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.f36688d;
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int i2) {
            this.f36688d = i2;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.f36689e;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.f36690f;
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: g  reason: collision with root package name */
        private final b f36684g = new b(this);

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            b bVar = this.f36684g;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    b.a().c(bVar.f36693a);
                }
            } else if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                b.a().b(bVar.f36693a);
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public final boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }
    }

    public static class b {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public b.a f36693a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.f35909e = SwipeDismissBehavior.a(0.1f);
            swipeDismissBehavior.f35910f = SwipeDismissBehavior.a(0.6f);
            swipeDismissBehavior.f35907c = 0;
        }
    }

    static /* synthetic */ int b(BaseTransientBottomBar baseTransientBottomBar) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) baseTransientBottomBar.f36657b.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    static /* synthetic */ int c(BaseTransientBottomBar baseTransientBottomBar) {
        int[] iArr = new int[2];
        baseTransientBottomBar.f36658c.getLocationOnScreen(iArr);
        return iArr[1] + baseTransientBottomBar.f36658c.getHeight();
    }

    static /* synthetic */ void g(BaseTransientBottomBar baseTransientBottomBar) {
        ValueAnimator a2 = baseTransientBottomBar.a(0.0f, 1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(com.google.android.material.a.a.f35803d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.f36658c.setScaleX(floatValue);
                BaseTransientBottomBar.this.f36658c.setScaleY(floatValue);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{a2, ofFloat});
        animatorSet.setDuration(150);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.g();
            }
        });
        animatorSet.start();
    }

    static /* synthetic */ void h(BaseTransientBottomBar baseTransientBottomBar) {
        final int m2 = baseTransientBottomBar.m();
        if (f36654f) {
            u.f((View) baseTransientBottomBar.f36658c, m2);
        } else {
            baseTransientBottomBar.f36658c.setTranslationY((float) m2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{m2, 0});
        valueAnimator.setInterpolator(com.google.android.material.a.a.f35801b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.j.a();
            }

            public final void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.g();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: c  reason: collision with root package name */
            private int f36679c = m2;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f36654f) {
                    u.f((View) BaseTransientBottomBar.this.f36658c, intValue - this.f36679c);
                } else {
                    BaseTransientBottomBar.this.f36658c.setTranslationY((float) intValue);
                }
                this.f36679c = intValue;
            }
        });
        valueAnimator.start();
    }
}
