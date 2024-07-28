package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements g.b, n {

    /* renamed from: a  reason: collision with root package name */
    g f1429a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1430b;

    /* renamed from: c  reason: collision with root package name */
    ActionMenuPresenter f1431c;

    /* renamed from: d  reason: collision with root package name */
    g.a f1432d;

    /* renamed from: e  reason: collision with root package name */
    d f1433e;

    /* renamed from: f  reason: collision with root package name */
    private Context f1434f;

    /* renamed from: g  reason: collision with root package name */
    private int f1435g;

    /* renamed from: h  reason: collision with root package name */
    private m.a f1436h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1437i;
    private int j;
    private int k;
    private int l;

    public interface a {
        boolean c();

        boolean d();
    }

    public interface d {
        boolean a(MenuItem menuItem);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ LinearLayoutCompat.LayoutParams b(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ LinearLayoutCompat.LayoutParams c() {
        return d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f2);
        this.l = (int) (f2 * 4.0f);
        this.f1434f = context;
        this.f1435g = 0;
    }

    public void setPopupTheme(int i2) {
        if (this.f1435g != i2) {
            this.f1435g = i2;
            if (i2 == 0) {
                this.f1434f = getContext();
            } else {
                this.f1434f = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1435g;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1431c = actionMenuPresenter;
        this.f1431c.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1431c;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(false);
            if (this.f1431c.j()) {
                this.f1431c.g();
                this.f1431c.e();
            }
        }
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.f1433e = dVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        g gVar;
        boolean z3 = this.f1437i;
        this.f1437i = View.MeasureSpec.getMode(i2) == 1073741824;
        if (z3 != this.f1437i) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.f1437i || (gVar = this.f1429a) == null || size == this.j)) {
            this.j = size;
            gVar.b(true);
        }
        int childCount = getChildCount();
        if (!this.f1437i || childCount <= 0) {
            int i9 = i3;
            for (int i10 = 0; i10 < childCount; i10++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int size3 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i3, paddingTop, -2);
        int i11 = size2 - paddingLeft;
        int i12 = this.k;
        int i13 = i11 / i12;
        int i14 = i11 % i12;
        if (i13 == 0) {
            setMeasuredDimension(i11, 0);
            return;
        }
        int i15 = i12 + (i14 / i13);
        int childCount2 = getChildCount();
        int i16 = i13;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        boolean z4 = false;
        int i20 = 0;
        int i21 = 0;
        long j2 = 0;
        while (i18 < childCount2) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                i20++;
                if (z5) {
                    int i22 = this.l;
                    i8 = size3;
                    z2 = false;
                    childAt.setPadding(i22, 0, i22, 0);
                } else {
                    i8 = size3;
                    z2 = false;
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.f1443f = z2;
                layoutParams2.f1440c = z2 ? 1 : 0;
                layoutParams2.f1439b = z2;
                layoutParams2.f1441d = z2;
                layoutParams2.leftMargin = z2;
                layoutParams2.rightMargin = z2;
                layoutParams2.f1442e = z5 && ((ActionMenuItemView) childAt).b();
                int a2 = a(childAt, i15, layoutParams2.f1438a ? 1 : i16, childMeasureSpec, paddingTop);
                i17 = Math.max(i17, a2);
                if (layoutParams2.f1441d) {
                    i21++;
                }
                if (layoutParams2.f1438a) {
                    z4 = true;
                }
                i16 -= a2;
                int max = Math.max(i19, childAt.getMeasuredHeight());
                if (a2 == 1) {
                    j2 |= (long) (1 << i18);
                }
                i19 = max;
            } else {
                i8 = size3;
            }
            i18++;
            size3 = i8;
        }
        int i23 = size3;
        boolean z6 = z4 && i20 == 2;
        int i24 = i16;
        boolean z7 = false;
        while (true) {
            if (i21 > 0 && i24 > 0) {
                int i25 = Integer.MAX_VALUE;
                int i26 = 0;
                int i27 = 0;
                long j3 = 0;
                while (i26 < childCount2) {
                    boolean z8 = z7;
                    LayoutParams layoutParams3 = (LayoutParams) getChildAt(i26).getLayoutParams();
                    int i28 = i19;
                    if (layoutParams3.f1441d) {
                        if (layoutParams3.f1439b < i25) {
                            i25 = layoutParams3.f1439b;
                            j3 = 1 << i26;
                            i27 = 1;
                        } else if (layoutParams3.f1439b == i25) {
                            j3 |= 1 << i26;
                            i27++;
                        }
                    }
                    i26++;
                    i19 = i28;
                    z7 = z8;
                }
                z = z7;
                i5 = i19;
                j2 |= j3;
                if (i27 > i24) {
                    i6 = mode;
                    i4 = i11;
                    break;
                }
                int i29 = i25 + 1;
                int i30 = i24;
                int i31 = 0;
                while (i31 < childCount2) {
                    View childAt2 = getChildAt(i31);
                    LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                    int i32 = i11;
                    int i33 = mode;
                    long j4 = (long) (1 << i31);
                    if ((j3 & j4) == 0) {
                        if (layoutParams4.f1439b == i29) {
                            j2 |= j4;
                        }
                        i7 = i29;
                    } else {
                        if (!z6 || !layoutParams4.f1442e || i30 != 1) {
                            i7 = i29;
                        } else {
                            int i34 = this.l;
                            i7 = i29;
                            childAt2.setPadding(i34 + i15, 0, i34, 0);
                        }
                        layoutParams4.f1439b++;
                        layoutParams4.f1443f = true;
                        i30--;
                    }
                    i31++;
                    mode = i33;
                    i29 = i7;
                    i11 = i32;
                }
                i24 = i30;
                i19 = i5;
                z7 = true;
            } else {
                i6 = mode;
                i4 = i11;
                z = z7;
                i5 = i19;
            }
        }
        boolean z9 = !z4 && i20 == 1;
        if (i24 > 0 && j2 != 0 && (i24 < i20 - 1 || z9 || i17 > 1)) {
            float bitCount = (float) Long.bitCount(j2);
            if (!z9) {
                if ((j2 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f1442e) {
                    bitCount -= 0.5f;
                }
                int i35 = childCount2 - 1;
                if ((j2 & ((long) (1 << i35))) != 0 && !((LayoutParams) getChildAt(i35).getLayoutParams()).f1442e) {
                    bitCount -= 0.5f;
                }
            }
            int i36 = bitCount > 0.0f ? (int) (((float) (i24 * i15)) / bitCount) : 0;
            boolean z10 = z;
            for (int i37 = 0; i37 < childCount2; i37++) {
                if ((j2 & ((long) (1 << i37))) != 0) {
                    View childAt3 = getChildAt(i37);
                    LayoutParams layoutParams5 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams5.f1440c = i36;
                        layoutParams5.f1443f = true;
                        if (i37 == 0 && !layoutParams5.f1442e) {
                            layoutParams5.leftMargin = (-i36) / 2;
                        }
                    } else if (layoutParams5.f1438a) {
                        layoutParams5.f1440c = i36;
                        layoutParams5.f1443f = true;
                        layoutParams5.rightMargin = (-i36) / 2;
                    } else {
                        if (i37 != 0) {
                            layoutParams5.leftMargin = i36 / 2;
                        }
                        if (i37 != childCount2 - 1) {
                            layoutParams5.rightMargin = i36 / 2;
                        }
                    }
                    z10 = true;
                }
            }
            z = z10;
        }
        if (z) {
            for (int i38 = 0; i38 < childCount2; i38++) {
                View childAt4 = getChildAt(i38);
                LayoutParams layoutParams6 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams6.f1443f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams6.f1439b * i15) + layoutParams6.f1440c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i6 != 1073741824 ? i5 : i23);
    }

    static int a(View view, int i2, int i3, int i4, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.b();
        int i6 = 2;
        if (i3 <= 0 || (z2 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z2 || i7 >= 2) {
                i6 = i7;
            }
        }
        if (layoutParams.f1438a || !z2) {
            z = false;
        }
        layoutParams.f1441d = z;
        layoutParams.f1439b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (!this.f1437i) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = i4 - i2;
        int paddingRight = (i11 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = ai.a(this);
        int i12 = paddingRight;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1438a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (b(i15)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i8 = getPaddingLeft() + layoutParams.leftMargin;
                        i9 = i8 + measuredWidth;
                    } else {
                        i9 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i8 = i9 - measuredWidth;
                    }
                    int i16 = i10 - (measuredHeight / 2);
                    childAt.layout(i8, i16, i9, measuredHeight + i16);
                    i12 -= measuredWidth;
                    i13 = 1;
                } else {
                    i12 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    b(i15);
                    i14++;
                }
            }
        }
        if (childCount == 1 && i13 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = (i11 / 2) - (measuredWidth2 / 2);
            int i18 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth2 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i14 - (i13 ^ 1);
        if (i19 > 0) {
            i6 = i12 / i19;
            i7 = 0;
        } else {
            i7 = 0;
            i6 = 0;
        }
        int max = Math.max(i7, i6);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            while (i7 < childCount) {
                View childAt3 = getChildAt(i7);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1438a) {
                    int i20 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i21 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i20 - measuredWidth3, i21, i20, measuredHeight3 + i21);
                    width = i20 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
                i7++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i7 < childCount) {
            View childAt4 = getChildAt(i7);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1438a) {
                int i22 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i10 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft = i22 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
            i7++;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f1431c;
        if (actionMenuPresenter.f1418i != null) {
            actionMenuPresenter.f1418i.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.k = true;
        actionMenuPresenter.j = drawable;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.f1431c;
        if (actionMenuPresenter.f1418i != null) {
            return actionMenuPresenter.f1418i.getDrawable();
        }
        if (actionMenuPresenter.k) {
            return actionMenuPresenter.j;
        }
        return null;
    }

    public void setOverflowReserved(boolean z) {
        this.f1430b = z;
    }

    private static LayoutParams d() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.f1552h = 16;
        return layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return d();
        }
        if (layoutParams instanceof LayoutParams) {
            layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (layoutParams2.f1552h <= 0) {
            layoutParams2.f1552h = 16;
        }
        return layoutParams2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static LayoutParams a() {
        LayoutParams d2 = d();
        d2.f1438a = true;
        return d2;
    }

    public final boolean a(i iVar) {
        return this.f1429a.a((MenuItem) iVar, (m) null, 0);
    }

    public final void a(g gVar) {
        this.f1429a = gVar;
    }

    public Menu getMenu() {
        if (this.f1429a == null) {
            Context context = getContext();
            this.f1429a = new g(context);
            this.f1429a.a((g.a) new c());
            this.f1431c = new ActionMenuPresenter(context);
            this.f1431c.d();
            ActionMenuPresenter actionMenuPresenter = this.f1431c;
            m.a aVar = this.f1436h;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter.f1293f = aVar;
            this.f1429a.a((m) this.f1431c, this.f1434f);
            this.f1431c.a(this);
        }
        return this.f1429a;
    }

    public void setMenuCallbacks(m.a aVar, g.a aVar2) {
        this.f1436h = aVar;
        this.f1432d = aVar2;
    }

    public final void b() {
        ActionMenuPresenter actionMenuPresenter = this.f1431c;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h();
        }
    }

    private boolean b(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).d();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).c();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1431c.l = z;
    }

    class c implements g.a {
        c() {
        }

        public final boolean a(g gVar, MenuItem menuItem) {
            return ActionMenuView.this.f1433e != null && ActionMenuView.this.f1433e.a(menuItem);
        }

        public final void a(g gVar) {
            if (ActionMenuView.this.f1432d != null) {
                ActionMenuView.this.f1432d.a(gVar);
            }
        }
    }

    static class b implements m.a {
        public final void a(g gVar, boolean z) {
        }

        public final boolean a(g gVar) {
            return false;
        }

        b() {
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f1438a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f1439b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f1440c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f1441d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f1442e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1443f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1438a = layoutParams.f1438a;
        }

        public LayoutParams() {
            super(-2, -2);
            this.f1438a = false;
        }
    }
}
