package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.ab;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.a.k;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.h.c;
import com.google.android.material.internal.q;
import com.google.android.material.k.h;
import com.google.android.material.k.i;
import com.google.android.material.k.m;
import com.google.android.material.theme.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {

    /* renamed from: d  reason: collision with root package name */
    private static final int f35921d = R.style.Widget_MaterialComponents_BottomAppBar;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final h f35922a;

    /* renamed from: b  reason: collision with root package name */
    AnimatorListenerAdapter f35923b;

    /* renamed from: c  reason: collision with root package name */
    k<FloatingActionButton> f35924c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f35925e;

    /* renamed from: f  reason: collision with root package name */
    private Animator f35926f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Animator f35927g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f35928h;

    /* renamed from: i  reason: collision with root package name */
    private int f35929i;
    private boolean j;
    /* access modifiers changed from: private */
    public final boolean k;
    /* access modifiers changed from: private */
    public final boolean l;
    /* access modifiers changed from: private */
    public final boolean m;
    private int n;
    private ArrayList<Object> o;
    /* access modifiers changed from: private */
    public boolean p;
    private Behavior q;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public int s;
    /* access modifiers changed from: private */
    public int t;

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i2) {
        super(a.a(context, attributeSet, i2, f35921d), attributeSet, i2);
        this.f35922a = new h();
        this.n = 0;
        this.p = true;
        this.f35923b = new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.a(bottomAppBar.f35928h, BottomAppBar.this.p);
            }
        };
        this.f35924c = new k<FloatingActionButton>() {
            public final /* synthetic */ void a(View view) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                float translationX = floatingActionButton.getTranslationX();
                if (BottomAppBar.this.getTopEdgeTreatment().f35955e != translationX) {
                    BottomAppBar.this.getTopEdgeTreatment().f35955e = translationX;
                    BottomAppBar.this.f35922a.invalidateSelf();
                }
                float f2 = 0.0f;
                float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
                if (BottomAppBar.this.getTopEdgeTreatment().f35954d != max) {
                    BottomAppBar.this.getTopEdgeTreatment().a(max);
                    BottomAppBar.this.f35922a.invalidateSelf();
                }
                h c2 = BottomAppBar.this.f35922a;
                if (floatingActionButton.getVisibility() == 0) {
                    f2 = floatingActionButton.getScaleY();
                }
                c2.p(f2);
            }

            public final /* synthetic */ void b(View view) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                BottomAppBar.this.f35922a.p(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }
        };
        Context context2 = getContext();
        TypedArray a2 = com.google.android.material.internal.k.a(context2, attributeSet, R.styleable.BottomAppBar, i2, f35921d, new int[0]);
        ColorStateList a3 = c.a(context2, a2, R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = a2.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        this.f35928h = a2.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.f35929i = a2.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.j = a2.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.k = a2.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.l = a2.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.m = a2.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        a2.recycle();
        this.f35925e = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        a aVar = new a((float) a2.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0), (float) a2.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0), (float) a2.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0));
        m.a a4 = m.a();
        a4.f36566i = aVar;
        this.f35922a.setShapeAppearanceModel(a4.a());
        this.f35922a.h();
        h hVar = this.f35922a;
        hVar.G.v = Paint.Style.FILL;
        hVar.j();
        this.f35922a.a(context2);
        setElevation((float) dimensionPixelSize);
        androidx.core.graphics.drawable.a.a((Drawable) this.f35922a, a3);
        u.a((View) this, (Drawable) this.f35922a);
        int i3 = f35921d;
        AnonymousClass3 r1 = new q.a() {
            public final ab a(View view, ab abVar, q.b bVar) {
                boolean z;
                if (BottomAppBar.this.k) {
                    int unused = BottomAppBar.this.r = abVar.d();
                }
                boolean z2 = false;
                if (BottomAppBar.this.l) {
                    z = BottomAppBar.this.t != abVar.a();
                    int unused2 = BottomAppBar.this.t = abVar.a();
                } else {
                    z = false;
                }
                if (BottomAppBar.this.m) {
                    if (BottomAppBar.this.s != abVar.c()) {
                        z2 = true;
                    }
                    int unused3 = BottomAppBar.this.s = abVar.c();
                }
                if (z || z2) {
                    BottomAppBar.this.e();
                    BottomAppBar.this.f();
                    BottomAppBar.this.g();
                }
                return abVar;
            }
        };
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        q.a((View) this, (q.a) new q.a(z, z2, z3, r1) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f36500a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f36501b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f36502c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ a f36503d;

            {
                this.f36500a = r1;
                this.f36501b = r2;
                this.f36502c = r3;
                this.f36503d = r4;
            }

            public final ab a(View view, ab abVar, b bVar) {
                if (this.f36500a) {
                    bVar.f36509d += abVar.d();
                }
                boolean a2 = q.a(view);
                if (this.f36501b) {
                    if (a2) {
                        bVar.f36508c += abVar.a();
                    } else {
                        bVar.f36506a += abVar.a();
                    }
                }
                if (this.f36502c) {
                    if (a2) {
                        bVar.f36506a += abVar.c();
                    } else {
                        bVar.f36508c += abVar.c();
                    }
                }
                bVar.a(view);
                a aVar = this.f36503d;
                return aVar != null ? aVar.a(view, abVar, bVar) : abVar;
            }
        });
    }

    public int getFabAlignmentMode() {
        return this.f35928h;
    }

    public int getFabAnimationMode() {
        return this.f35929i;
    }

    public void setFabAnimationMode(int i2) {
        this.f35929i = i2;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a((Drawable) this.f35922a, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.f35922a.G.f36542g;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f35952b;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().f35952b = f2;
            this.f35922a.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f35951a;
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f35951a = f2;
            this.f35922a.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f35954d;
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().a(f2);
            this.f35922a.invalidateSelf();
            f();
        }
    }

    public boolean getHideOnScroll() {
        return this.j;
    }

    public void setHideOnScroll(boolean z) {
        this.j = z;
    }

    public void setElevation(float f2) {
        this.f35922a.r(f2);
        int l2 = this.f35922a.G.r - this.f35922a.l();
        Behavior behavior = getBehavior();
        behavior.f35902c = l2;
        if (behavior.f35901b == 1) {
            setTranslationY((float) (behavior.f35900a + behavior.f35902c));
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        ArrayList<Object> arrayList;
        int i2 = this.n;
        this.n = i2 + 1;
        if (i2 == 0 && (arrayList = this.o) != null) {
            Iterator<Object> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton b() {
        View c2 = c();
        if (c2 instanceof FloatingActionButton) {
            return (FloatingActionButton) c2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View c() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.c((android.view.View) r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.c():android.view.View");
    }

    private boolean d() {
        FloatingActionButton b2 = b();
        return b2 != null && b2.getImpl().l();
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (u.J(this)) {
            Animator animator = this.f35927g;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!d()) {
                i2 = 0;
                z = false;
            }
            a(i2, z, (List<Animator>) arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f35927g = animatorSet;
            this.f35927g.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    BottomAppBar.this.a();
                }

                public final void onAnimationEnd(Animator animator) {
                    BottomAppBar.n(BottomAppBar.this);
                    Animator unused = BottomAppBar.this.f35927g = null;
                }
            });
            this.f35927g.start();
        }
    }

    private void a(final int i2, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            if (Math.abs(actionMenuView.getTranslationX() - ((float) b(actionMenuView, i2, z))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    public boolean f35938a;

                    public final void onAnimationCancel(Animator animator) {
                        this.f35938a = true;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        if (!this.f35938a) {
                            BottomAppBar.this.a(actionMenuView, i2, z);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150);
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().f35954d;
    }

    /* access modifiers changed from: private */
    public float a(int i2) {
        boolean a2 = q.a(this);
        int i3 = 1;
        if (i2 != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (this.f35925e + (a2 ? this.t : this.s));
        if (a2) {
            i3 = -1;
        }
        return (float) (measuredWidth * i3);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return a(this.f35928h);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i2, boolean z) {
        actionMenuView.setTranslationX((float) b(actionMenuView, i2, z));
    }

    private int b(ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean a2 = q.a(this);
        int measuredWidth = a2 ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f991a & 8388615) == 8388611) {
                if (a2) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((a2 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (a2 ? this.s : -this.t));
    }

    /* access modifiers changed from: private */
    public void e() {
        Animator animator = this.f35927g;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f35926f;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            e();
            f();
        }
        g();
    }

    /* access modifiers changed from: package-private */
    public a getTopEdgeTreatment() {
        return (a) this.f35922a.G.f36536a.j;
    }

    /* access modifiers changed from: private */
    public void f() {
        getTopEdgeTreatment().f35955e = getFabTranslationX();
        View c2 = c();
        this.f35922a.p((!this.p || !d()) ? 0.0f : 1.0f);
        if (c2 != null) {
            c2.setTranslationY(getFabTranslationY());
            c2.setTranslationX(getFabTranslationX());
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!d()) {
                a(actionMenuView, 0, false);
            } else {
                a(actionMenuView, this.f35928h, this.p);
            }
        }
    }

    /* access modifiers changed from: private */
    public int getBottomInset() {
        return this.r;
    }

    /* access modifiers changed from: private */
    public int getRightInset() {
        return this.s;
    }

    /* access modifiers changed from: private */
    public int getLeftInset() {
        return this.t;
    }

    public Behavior getBehavior() {
        if (this.q == null) {
            this.q = new Behavior();
        }
        return this.q;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this, this.f35922a);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final Rect f35944d = new Rect();
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<BottomAppBar> f35945e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f35946f;

        /* renamed from: g  reason: collision with root package name */
        private final View.OnLayoutChangeListener f35947g = new View.OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f35945e.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Rect b2 = Behavior.this.f35944d;
                b2.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                floatingActionButton.b(b2);
                int height = Behavior.this.f35944d.height();
                float f2 = (float) height;
                if (f2 != bottomAppBar.getTopEdgeTreatment().f35953c) {
                    bottomAppBar.getTopEdgeTreatment().f35953c = f2;
                    bottomAppBar.f35922a.invalidateSelf();
                }
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
                if (Behavior.this.f35946f == 0) {
                    dVar.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    dVar.leftMargin = bottomAppBar.getLeftInset();
                    dVar.rightMargin = bottomAppBar.getRightInset();
                    if (q.a(floatingActionButton)) {
                        dVar.leftMargin += bottomAppBar.f35925e;
                    } else {
                        dVar.rightMargin += bottomAppBar.f35925e;
                    }
                }
            }
        };

        public /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view2, view3, i2, i3);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            this.f35945e = new WeakReference<>(bottomAppBar);
            View v = bottomAppBar.c();
            if (v != null && !u.J(v)) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) v.getLayoutParams();
                dVar.f2606d = 49;
                this.f35946f = dVar.bottomMargin;
                if (v instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) v;
                    floatingActionButton.addOnLayoutChangeListener(this.f35947g);
                    BottomAppBar.a(bottomAppBar, floatingActionButton);
                }
                bottomAppBar.f();
            }
            coordinatorLayout.b(bottomAppBar, i2);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i2);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f35949a = this.f35928h;
        savedState.f35950b = this.p;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        this.f35928h = savedState.f35949a;
        this.p = savedState.f35950b;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f35949a;

        /* renamed from: b  reason: collision with root package name */
        boolean f35950b;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f35949a = parcel.readInt();
            this.f35950b = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f35949a);
            parcel.writeInt(this.f35950b ? 1 : 0);
        }
    }

    public void setFabAlignmentMode(final int i2) {
        if (this.f35928h != i2 && u.J(this)) {
            Animator animator = this.f35926f;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f35929i == 1) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b(), "translationX", new float[]{a(i2)});
                ofFloat.setDuration(300);
                arrayList.add(ofFloat);
            } else {
                FloatingActionButton b2 = b();
                if (b2 != null && !b2.getImpl().m()) {
                    a();
                    b2.b(new FloatingActionButton.a() {
                        public final void a(FloatingActionButton floatingActionButton) {
                            floatingActionButton.setTranslationX(BottomAppBar.this.a(i2));
                            floatingActionButton.a((FloatingActionButton.a) new FloatingActionButton.a() {
                                public final void a() {
                                    BottomAppBar.n(BottomAppBar.this);
                                }
                            }, true);
                        }
                    }, true);
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f35926f = animatorSet;
            this.f35926f.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    BottomAppBar.this.a();
                }

                public final void onAnimationEnd(Animator animator) {
                    BottomAppBar.n(BottomAppBar.this);
                }
            });
            this.f35926f.start();
        }
        a(i2, this.p);
        this.f35928h = i2;
    }

    static /* synthetic */ void n(BottomAppBar bottomAppBar) {
        ArrayList<Object> arrayList;
        int i2 = bottomAppBar.n - 1;
        bottomAppBar.n = i2;
        if (i2 == 0 && (arrayList = bottomAppBar.o) != null) {
            Iterator<Object> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    static /* synthetic */ void a(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        AnimatorListenerAdapter animatorListenerAdapter = bottomAppBar.f35923b;
        d impl = floatingActionButton.getImpl();
        if (impl.r == null) {
            impl.r = new ArrayList<>();
        }
        impl.r.add(animatorListenerAdapter);
        AnonymousClass8 r0 = new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                BottomAppBar.this.f35923b.onAnimationStart(animator);
                FloatingActionButton p = BottomAppBar.this.b();
                if (p != null) {
                    p.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        };
        d impl2 = floatingActionButton.getImpl();
        if (impl2.q == null) {
            impl2.q = new ArrayList<>();
        }
        impl2.q.add(r0);
        k<FloatingActionButton> kVar = bottomAppBar.f35924c;
        d impl3 = floatingActionButton.getImpl();
        FloatingActionButton.c cVar = new FloatingActionButton.c(kVar);
        if (impl3.s == null) {
            impl3.s = new ArrayList<>();
        }
        impl3.s.add(cVar);
    }
}
