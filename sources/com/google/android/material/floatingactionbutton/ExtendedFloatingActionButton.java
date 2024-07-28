package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.a.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.k;
import com.google.android.material.k.m;
import com.sendbird.android.constant.StringSet;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.a {

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f36273b = new Property<View, Float>(Float.class, StringSet.width) {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf((float) ((View) obj).getLayoutParams().width);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            view.getLayoutParams().width = ((Float) obj2).intValue();
            view.requestLayout();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Float> f36274c = new Property<View, Float>(Float.class, StringSet.height) {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf((float) ((View) obj).getLayoutParams().height);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            view.getLayoutParams().height = ((Float) obj2).intValue();
            view.requestLayout();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final int f36275e = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f36276f;

    /* renamed from: g  reason: collision with root package name */
    private final a f36277g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final f f36278h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final f f36279i;
    /* access modifiers changed from: private */
    public final f j;
    /* access modifiers changed from: private */
    public final f k;
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> l;
    /* access modifiers changed from: private */
    public boolean m;

    public static abstract class c {
    }

    interface e {
        int a();

        int b();

        ViewGroup.LayoutParams c();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36275e), attributeSet, i2);
        this.f36276f = 0;
        this.f36277g = new a();
        this.j = new d(this.f36277g);
        this.k = new b(this.f36277g);
        this.m = true;
        Context context2 = getContext();
        this.l = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.ExtendedFloatingActionButton, i2, f36275e, new int[0]);
        h a3 = h.a(context2, a2, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        h a4 = h.a(context2, a2, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        h a5 = h.a(context2, a2, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        h a6 = h.a(context2, a2, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        a aVar = new a();
        this.f36279i = new a(aVar, new e() {
            public final int a() {
                return ExtendedFloatingActionButton.this.getMeasuredWidth();
            }

            public final int b() {
                return ExtendedFloatingActionButton.this.getMeasuredHeight();
            }

            public final ViewGroup.LayoutParams c() {
                return new ViewGroup.LayoutParams(-2, -2);
            }
        }, true);
        this.f36278h = new a(aVar, new e() {
            public final int a() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }

            public final int b() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }

            public final ViewGroup.LayoutParams c() {
                return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.this.getCollapsedSize(), ExtendedFloatingActionButton.this.getCollapsedSize());
            }
        }, false);
        this.j.a(a3);
        this.k.a(a4);
        this.f36279i.a(a5);
        this.f36278h.a(a6);
        a2.recycle();
        setShapeAppearanceModel(m.a(context2, attributeSet, i2, f36275e, m.f36549a).a());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.m && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.m = false;
            this.f36278h.g();
        }
    }

    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.l;
    }

    public void setExtended(boolean z) {
        if (this.m != z) {
            f fVar = z ? this.f36279i : this.f36278h;
            if (!fVar.i()) {
                fVar.g();
            }
        }
    }

    public h getShowMotionSpec() {
        return this.j.c();
    }

    public void setShowMotionSpec(h hVar) {
        this.j.a(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.a(getContext(), i2));
    }

    public h getHideMotionSpec() {
        return this.k.c();
    }

    public void setHideMotionSpec(h hVar) {
        this.k.a(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.a(getContext(), i2));
    }

    public h getExtendMotionSpec() {
        return this.f36279i.c();
    }

    public void setExtendMotionSpec(h hVar) {
        this.f36279i.a(hVar);
    }

    public void setExtendMotionSpecResource(int i2) {
        setExtendMotionSpec(h.a(getContext(), i2));
    }

    public h getShrinkMotionSpec() {
        return this.f36278h.c();
    }

    public void setShrinkMotionSpec(h hVar) {
        this.f36278h.a(hVar);
    }

    public void setShrinkMotionSpecResource(int i2) {
        setShrinkMotionSpec(h.a(getContext(), i2));
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedSize() {
        return (Math.min(u.m(this), u.n(this)) * 2) + getIconSize();
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f36286a;

        /* renamed from: b  reason: collision with root package name */
        private c f36287b;

        /* renamed from: c  reason: collision with root package name */
        private c f36288c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f36289d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f36290e;

        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (ExtendedFloatingActionButton) view, rect);
        }

        public /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
                return false;
            } else if (!a(view2)) {
                return false;
            } else {
                b(view2, extendedFloatingActionButton);
                return false;
            }
        }

        public ExtendedFloatingActionButtonBehavior() {
            this.f36289d = false;
            this.f36290e = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f36289d = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f36290e = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.d dVar) {
            if (dVar.f2610h == 0) {
                dVar.f2610h = 80;
            }
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).f2603a instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) extendedFloatingActionButton.getLayoutParams();
            if ((this.f36289d || this.f36290e) && dVar.f2608f == view.getId()) {
                return true;
            }
            return false;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f36286a == null) {
                this.f36286a = new Rect();
            }
            Rect rect = this.f36286a;
            com.google.android.material.internal.b.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                a(extendedFloatingActionButton);
                return true;
            }
            b(extendedFloatingActionButton);
            return true;
        }

        private boolean b(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.d) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                a(extendedFloatingActionButton);
                return true;
            }
            b(extendedFloatingActionButton);
            return true;
        }

        private void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
            f fVar;
            c cVar = this.f36290e ? this.f36288c : this.f36287b;
            if (this.f36290e) {
                fVar = extendedFloatingActionButton.f36278h;
            } else {
                fVar = extendedFloatingActionButton.k;
            }
            ExtendedFloatingActionButton.a(extendedFloatingActionButton, fVar, cVar);
        }

        private void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
            f fVar;
            c cVar = this.f36290e ? this.f36288c : this.f36287b;
            if (this.f36290e) {
                fVar = extendedFloatingActionButton.f36279i;
            } else {
                fVar = extendedFloatingActionButton.j;
            }
            ExtendedFloatingActionButton.a(extendedFloatingActionButton, fVar, cVar);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> b2 = coordinatorLayout.b((View) extendedFloatingActionButton);
            int size = b2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = b2.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.b(extendedFloatingActionButton, i2);
            return true;
        }
    }

    class a extends b {

        /* renamed from: b  reason: collision with root package name */
        private final e f36292b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f36293c;

        a(a aVar, e eVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f36292b = eVar;
            this.f36293c = z;
        }

        public final void g() {
            boolean unused = ExtendedFloatingActionButton.this.m = this.f36293c;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.f36292b.c().width;
                layoutParams.height = this.f36292b.c().height;
                ExtendedFloatingActionButton.this.requestLayout();
            }
        }

        public final int h() {
            return R.animator.mtrl_extended_fab_change_size_motion_spec;
        }

        public final AnimatorSet f() {
            h a2 = a();
            if (a2.b(StringSet.width)) {
                PropertyValuesHolder[] c2 = a2.c(StringSet.width);
                c2[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getWidth(), (float) this.f36292b.a()});
                a2.a(StringSet.width, c2);
            }
            if (a2.b(StringSet.height)) {
                PropertyValuesHolder[] c3 = a2.c(StringSet.height);
                c3[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getHeight(), (float) this.f36292b.b()});
                a2.a(StringSet.height, c3);
            }
            return super.b(a2);
        }

        public final void a(Animator animator) {
            super.a(animator);
            boolean unused = ExtendedFloatingActionButton.this.m = this.f36293c;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        public final void d() {
            super.d();
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.f36292b.c().width;
                layoutParams.height = this.f36292b.c().height;
            }
        }

        public final boolean i() {
            return this.f36293c == ExtendedFloatingActionButton.this.m || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }
    }

    class d extends b {
        public d(a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        public final void g() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        public final int h() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        public final void a(Animator animator) {
            super.a(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.f36276f = 2;
        }

        public final void d() {
            super.d();
            int unused = ExtendedFloatingActionButton.this.f36276f = 0;
        }

        public final boolean i() {
            return ExtendedFloatingActionButton.f(ExtendedFloatingActionButton.this);
        }
    }

    class b extends b {

        /* renamed from: b  reason: collision with root package name */
        private boolean f36295b;

        public b(a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        public final void g() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        public final boolean i() {
            return ExtendedFloatingActionButton.g(ExtendedFloatingActionButton.this);
        }

        public final int h() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        public final void a(Animator animator) {
            super.a(animator);
            this.f36295b = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.f36276f = 1;
        }

        public final void e() {
            super.e();
            this.f36295b = true;
        }

        public final void d() {
            super.d();
            int unused = ExtendedFloatingActionButton.this.f36276f = 0;
            if (!this.f36295b) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void a(ExtendedFloatingActionButton extendedFloatingActionButton, final f fVar, final c cVar) {
        if (!fVar.i()) {
            if (!(u.J(extendedFloatingActionButton) && !extendedFloatingActionButton.isInEditMode())) {
                fVar.g();
                return;
            }
            extendedFloatingActionButton.measure(0, 0);
            AnimatorSet f2 = fVar.f();
            f2.addListener(new AnimatorListenerAdapter() {

                /* renamed from: d  reason: collision with root package name */
                private boolean f36285d;

                public final void onAnimationStart(Animator animator) {
                    fVar.a(animator);
                    this.f36285d = false;
                }

                public final void onAnimationCancel(Animator animator) {
                    this.f36285d = true;
                    fVar.e();
                }

                public final void onAnimationEnd(Animator animator) {
                    fVar.d();
                }
            });
            for (Animator.AnimatorListener addListener : fVar.b()) {
                f2.addListener(addListener);
            }
            f2.start();
        }
    }

    static /* synthetic */ boolean f(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.getVisibility() != 0 ? extendedFloatingActionButton.f36276f == 2 : extendedFloatingActionButton.f36276f != 1;
    }

    static /* synthetic */ boolean g(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.getVisibility() == 0 ? extendedFloatingActionButton.f36276f == 1 : extendedFloatingActionButton.f36276f != 2;
    }
}
