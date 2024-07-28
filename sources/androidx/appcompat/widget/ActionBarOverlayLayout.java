package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.core.graphics.b;
import androidx.core.h.ab;
import androidx.core.h.m;
import androidx.core.h.n;
import androidx.core.h.o;
import androidx.core.h.p;
import androidx.core.h.u;
import net.one97.paytm.upi.util.UpiConstants;

public class ActionBarOverlayLayout extends ViewGroup implements n, m, n, o {

    /* renamed from: f  reason: collision with root package name */
    static final int[] f1406f = {R.attr.actionBarSize, 16842841};
    private ab A;
    private a B;
    private OverScroller C;
    private final Runnable D;
    private final Runnable E;
    private final p F;

    /* renamed from: a  reason: collision with root package name */
    ActionBarContainer f1407a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1408b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1409c;

    /* renamed from: d  reason: collision with root package name */
    ViewPropertyAnimator f1410d;

    /* renamed from: e  reason: collision with root package name */
    final AnimatorListenerAdapter f1411e;

    /* renamed from: g  reason: collision with root package name */
    private int f1412g;

    /* renamed from: h  reason: collision with root package name */
    private int f1413h;

    /* renamed from: i  reason: collision with root package name */
    private ContentFrameLayout f1414i;
    private o j;
    private Drawable k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private ab x;
    private ab y;
    private ab z;

    public interface a {
        void g(int i2);

        void g(boolean z);

        void n();

        void o();

        void p();
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1413h = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.x = ab.f3060a;
        this.y = ab.f3060a;
        this.z = ab.f3060a;
        this.A = ab.f3060a;
        this.f1411e = new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1410d = null;
                actionBarOverlayLayout.f1409c = false;
            }

            public final void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1410d = null;
                actionBarOverlayLayout.f1409c = false;
            }
        };
        this.D = new Runnable() {
            public final void run() {
                ActionBarOverlayLayout.this.a();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1410d = actionBarOverlayLayout.f1407a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1411e);
            }
        };
        this.E = new Runnable() {
            public final void run() {
                ActionBarOverlayLayout.this.a();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f1410d = actionBarOverlayLayout.f1407a.animate().translationY((float) (-ActionBarOverlayLayout.this.f1407a.getHeight())).setListener(ActionBarOverlayLayout.this.f1411e);
            }
        };
        a(context);
        this.F = new p();
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1406f);
        boolean z2 = false;
        this.f1412g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.k = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.k == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.l = z2;
        this.C = new OverScroller(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.B = aVar;
        if (getWindowToken() != null) {
            this.B.g(this.f1413h);
            int i2 = this.p;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                u.z(this);
            }
        }
    }

    public void setOverlayMode(boolean z2) {
        this.f1408b = z2;
        this.l = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.m = z2;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        u.z(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        h();
        int i3 = this.p ^ i2;
        this.p = i2;
        boolean z2 = false;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0) {
            z2 = true;
        }
        a aVar = this.B;
        if (aVar != null) {
            aVar.g(!z2);
            if (z3 || !z2) {
                this.B.n();
            } else {
                this.B.o();
            }
        }
        if ((i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 && this.B != null) {
            u.z(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f1413h = i2;
        a aVar = this.B;
        if (aVar != null) {
            aVar.g(i2);
        }
    }

    private static boolean a(View view, Rect rect, boolean z2) {
        boolean z3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z3 = true;
        } else {
            z3 = false;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z3 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z3 = true;
        }
        if (!z2 || layoutParams.bottomMargin == rect.bottom) {
            return z3;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        h();
        boolean a2 = a(this.f1407a, rect, false);
        this.t.set(rect);
        ai.a(this, this.t, this.q);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a2 = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        h();
        ab a2 = ab.a(windowInsets);
        boolean a3 = a(this.f1407a, new Rect(a2.f3061b.g().f2973b, a2.f3061b.g().f2974c, a2.f3061b.g().f2975d, a2.f3061b.g().f2976e), false);
        u.a((View) this, a2, this.q);
        this.x = a2.b(this.q.left, this.q.top, this.q.right, this.q.bottom);
        if (!this.y.equals(this.x)) {
            this.y = this.x;
            a3 = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a3 = true;
        }
        if (a3) {
            requestLayout();
        }
        return a2.f3061b.f().f3061b.c().f3061b.d().e();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        h();
        measureChildWithMargins(this.f1407a, i2, 0, i3, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1407a.getLayoutParams();
        int max = Math.max(0, this.f1407a.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.f1407a.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1407a.getMeasuredState());
        boolean z2 = (u.y(this) & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0;
        if (z2) {
            i4 = this.f1412g;
            if (this.m && this.f1407a.getTabContainer() != null) {
                i4 += this.f1412g;
            }
        } else {
            i4 = this.f1407a.getVisibility() != 8 ? this.f1407a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        if (Build.VERSION.SDK_INT >= 21) {
            this.z = this.x;
        } else {
            this.v.set(this.t);
        }
        if (!this.f1408b && !z2) {
            this.s.top += i4;
            this.s.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.z = this.z.b(0, i4, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.z = new ab.a(this.z).a(b.a(this.z.f3061b.g().f2973b, this.z.f3061b.g().f2974c + i4, this.z.f3061b.g().f2975d, this.z.f3061b.g().f2976e + 0)).f3062a.a();
        } else {
            this.v.top += i4;
            this.v.bottom += 0;
        }
        a(this.f1414i, this.s, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.A.equals(this.z)) {
            ab abVar = this.z;
            this.A = abVar;
            u.b((View) this.f1414i, abVar);
        } else if (Build.VERSION.SDK_INT < 21 && !this.w.equals(this.v)) {
            this.w.set(this.v);
            this.f1414i.a(this.v);
        }
        measureChildWithMargins(this.f1414i, i2, 0, i3, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1414i.getLayoutParams();
        int max3 = Math.max(max, this.f1414i.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.f1414i.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1414i.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                int i8 = layoutParams.topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.k != null && !this.l) {
            int bottom = this.f1407a.getVisibility() == 0 ? (int) (((float) this.f1407a.getBottom()) + this.f1407a.getTranslationY() + 0.5f) : 0;
            this.k.setBounds(0, bottom, getWidth(), this.k.getIntrinsicHeight() + bottom);
            this.k.draw(canvas);
        }
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        a(view, i2, i3, i4, i5, i6);
    }

    public final boolean a(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public final void b(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    public final void a(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f1407a.getVisibility() != 0) {
            return false;
        }
        return this.n;
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.F.a(i2, 0);
        this.o = getActionBarHideOffset();
        a();
        a aVar = this.B;
        if (aVar != null) {
            aVar.p();
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        this.o += i3;
        setActionBarHideOffset(this.o);
    }

    public void onStopNestedScroll(View view) {
        if (this.n && !this.f1409c) {
            if (this.o <= this.f1407a.getHeight()) {
                a();
                postDelayed(this.D, 600);
                return;
            }
            a();
            postDelayed(this.E, 600);
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        boolean z3 = false;
        if (!this.n || !z2) {
            return false;
        }
        this.C.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.C.getFinalY() > this.f1407a.getHeight()) {
            z3 = true;
        }
        if (z3) {
            a();
            this.E.run();
        } else {
            a();
            this.D.run();
        }
        this.f1409c = true;
        return true;
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    private void h() {
        if (this.f1414i == null) {
            this.f1414i = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f1407a = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.j = a(findViewById(R.id.action_bar));
        }
    }

    private static o a(View view) {
        if (view instanceof o) {
            return (o) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.n) {
            this.n = z2;
            if (!z2) {
                a();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1407a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i2) {
        a();
        this.f1407a.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f1407a.getHeight()))));
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.f1410d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void setWindowCallback(Window.Callback callback) {
        h();
        this.j.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        h();
        this.j.a(charSequence);
    }

    public CharSequence getTitle() {
        h();
        return this.j.e();
    }

    public final void a(int i2) {
        h();
        if (i2 != 2 && i2 != 5 && i2 == 109) {
            setOverlayMode(true);
        }
    }

    public void setIcon(int i2) {
        h();
        this.j.a(i2);
    }

    public void setIcon(Drawable drawable) {
        h();
        this.j.a(drawable);
    }

    public void setLogo(int i2) {
        h();
        this.j.b(i2);
    }

    public final boolean b() {
        h();
        return this.j.f();
    }

    public final boolean c() {
        h();
        return this.j.g();
    }

    public final boolean d() {
        h();
        return this.j.h();
    }

    public final boolean e() {
        h();
        return this.j.i();
    }

    public final boolean f() {
        h();
        return this.j.j();
    }

    public void setMenuPrepared() {
        h();
        this.j.k();
    }

    public void setMenu(Menu menu, m.a aVar) {
        h();
        this.j.a(menu, aVar);
    }

    public final void g() {
        h();
        this.j.l();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
