package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.g;
import androidx.core.content.b;
import androidx.core.h.ab;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.d;
import com.google.android.material.internal.e;
import com.google.android.material.k.i;

public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f36618d = {16842912};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f36619e = {-16842910};

    /* renamed from: f  reason: collision with root package name */
    private static final int f36620f = R.style.Widget_Design_NavigationView;

    /* renamed from: c  reason: collision with root package name */
    a f36621c;

    /* renamed from: g  reason: collision with root package name */
    private final d f36622g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final e f36623h;

    /* renamed from: i  reason: collision with root package name */
    private final int f36624i;
    /* access modifiers changed from: private */
    public final int[] j;
    private MenuInflater k;
    private ViewTreeObserver.OnGlobalLayoutListener l;

    public interface a {
        boolean a();
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r9v4, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r11v7, types: [android.graphics.drawable.InsetDrawable] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(android.content.Context r18, android.util.AttributeSet r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r2 = r19
            r4 = r20
            int r1 = f36620f
            r3 = r18
            android.content.Context r1 = com.google.android.material.theme.a.a.a(r3, r2, r4, r1)
            r0.<init>(r1, r2, r4)
            com.google.android.material.internal.e r1 = new com.google.android.material.internal.e
            r1.<init>()
            r0.f36623h = r1
            r1 = 2
            int[] r1 = new int[r1]
            r0.j = r1
            android.content.Context r7 = r17.getContext()
            com.google.android.material.internal.d r1 = new com.google.android.material.internal.d
            r1.<init>(r7)
            r0.f36622g = r1
            int[] r3 = com.google.android.material.R.styleable.NavigationView
            int r5 = f36620f
            r8 = 0
            int[] r6 = new int[r8]
            r1 = r7
            androidx.appcompat.widget.ac r1 = com.google.android.material.internal.k.b(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.NavigationView_android_background
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0045
            int r2 = com.google.android.material.R.styleable.NavigationView_android_background
            android.graphics.drawable.Drawable r2 = r1.a(r2)
            androidx.core.h.u.a((android.view.View) r0, (android.graphics.drawable.Drawable) r2)
        L_0x0045:
            android.graphics.drawable.Drawable r2 = r17.getBackground()
            if (r2 == 0) goto L_0x0053
            android.graphics.drawable.Drawable r2 = r17.getBackground()
            boolean r2 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r2 == 0) goto L_0x0073
        L_0x0053:
            android.graphics.drawable.Drawable r2 = r17.getBackground()
            com.google.android.material.k.h r3 = new com.google.android.material.k.h
            r3.<init>()
            boolean r4 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r4 == 0) goto L_0x006d
            android.graphics.drawable.ColorDrawable r2 = (android.graphics.drawable.ColorDrawable) r2
            int r2 = r2.getColor()
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r3.g(r2)
        L_0x006d:
            r3.a((android.content.Context) r7)
            androidx.core.h.u.a((android.view.View) r0, (android.graphics.drawable.Drawable) r3)
        L_0x0073:
            int r2 = com.google.android.material.R.styleable.NavigationView_elevation
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0085
            int r2 = com.google.android.material.R.styleable.NavigationView_elevation
            int r2 = r1.e(r2, r8)
            float r2 = (float) r2
            r0.setElevation(r2)
        L_0x0085:
            int r2 = com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows
            boolean r2 = r1.a((int) r2, (boolean) r8)
            r0.setFitsSystemWindows(r2)
            int r2 = com.google.android.material.R.styleable.NavigationView_android_maxWidth
            int r2 = r1.e(r2, r8)
            r0.f36624i = r2
            int r2 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x00a5
            int r2 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            android.content.res.ColorStateList r2 = r1.e(r2)
            goto L_0x00ac
        L_0x00a5:
            r2 = 16842808(0x1010038, float:2.3693715E-38)
            android.content.res.ColorStateList r2 = r0.a((int) r2)
        L_0x00ac:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            boolean r3 = r1.g(r3)
            r4 = 1
            if (r3 == 0) goto L_0x00be
            int r3 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            int r3 = r1.g(r3, r8)
            r5 = r3
            r3 = 1
            goto L_0x00c0
        L_0x00be:
            r3 = 0
            r5 = 0
        L_0x00c0:
            int r6 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x00d1
            int r6 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            int r6 = r1.e(r6, r8)
            r0.setItemIconSize(r6)
        L_0x00d1:
            r6 = 0
            int r9 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            boolean r9 = r1.g(r9)
            if (r9 == 0) goto L_0x00e0
            int r6 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            android.content.res.ColorStateList r6 = r1.e(r6)
        L_0x00e0:
            if (r3 != 0) goto L_0x00eb
            if (r6 != 0) goto L_0x00eb
            r6 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r6 = r0.a((int) r6)
        L_0x00eb:
            int r9 = com.google.android.material.R.styleable.NavigationView_itemBackground
            android.graphics.drawable.Drawable r9 = r1.a(r9)
            if (r9 != 0) goto L_0x0151
            int r10 = com.google.android.material.R.styleable.NavigationView_itemShapeAppearance
            boolean r10 = r1.g(r10)
            if (r10 != 0) goto L_0x0106
            int r10 = com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay
            boolean r10 = r1.g(r10)
            if (r10 == 0) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r10 = 0
            goto L_0x0107
        L_0x0106:
            r10 = 1
        L_0x0107:
            if (r10 == 0) goto L_0x0151
            int r9 = com.google.android.material.R.styleable.NavigationView_itemShapeAppearance
            int r9 = r1.g(r9, r8)
            int r10 = com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay
            int r10 = r1.g(r10, r8)
            com.google.android.material.k.h r12 = new com.google.android.material.k.h
            android.content.Context r11 = r17.getContext()
            com.google.android.material.k.m$a r9 = com.google.android.material.k.m.a((android.content.Context) r11, (int) r9, (int) r10)
            com.google.android.material.k.m r9 = r9.a()
            r12.<init>((com.google.android.material.k.m) r9)
            android.content.Context r9 = r17.getContext()
            int r10 = com.google.android.material.R.styleable.NavigationView_itemShapeFillColor
            android.content.res.ColorStateList r9 = com.google.android.material.h.c.a((android.content.Context) r9, (androidx.appcompat.widget.ac) r1, (int) r10)
            r12.g(r9)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart
            int r13 = r1.e(r9, r8)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop
            int r14 = r1.e(r9, r8)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd
            int r15 = r1.e(r9, r8)
            int r9 = com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom
            int r16 = r1.e(r9, r8)
            android.graphics.drawable.InsetDrawable r9 = new android.graphics.drawable.InsetDrawable
            r11 = r9
            r11.<init>(r12, r13, r14, r15, r16)
        L_0x0151:
            int r10 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            boolean r10 = r1.g(r10)
            if (r10 == 0) goto L_0x0164
            int r10 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            int r10 = r1.e(r10, r8)
            com.google.android.material.internal.e r11 = r0.f36623h
            r11.b((int) r10)
        L_0x0164:
            int r10 = com.google.android.material.R.styleable.NavigationView_itemIconPadding
            int r10 = r1.e(r10, r8)
            int r11 = com.google.android.material.R.styleable.NavigationView_itemMaxLines
            int r11 = r1.a((int) r11, (int) r4)
            r0.setItemMaxLines(r11)
            com.google.android.material.internal.d r11 = r0.f36622g
            com.google.android.material.navigation.NavigationView$1 r12 = new com.google.android.material.navigation.NavigationView$1
            r12.<init>()
            r11.a((androidx.appcompat.view.menu.g.a) r12)
            com.google.android.material.internal.e r11 = r0.f36623h
            r11.f36448d = r4
            com.google.android.material.internal.d r12 = r0.f36622g
            r11.a((android.content.Context) r7, (androidx.appcompat.view.menu.g) r12)
            com.google.android.material.internal.e r7 = r0.f36623h
            r7.a((android.content.res.ColorStateList) r2)
            com.google.android.material.internal.e r2 = r0.f36623h
            int r7 = r17.getOverScrollMode()
            r2.f(r7)
            if (r3 == 0) goto L_0x019b
            com.google.android.material.internal.e r2 = r0.f36623h
            r2.a((int) r5)
        L_0x019b:
            com.google.android.material.internal.e r2 = r0.f36623h
            r2.b((android.content.res.ColorStateList) r6)
            com.google.android.material.internal.e r2 = r0.f36623h
            r2.a((android.graphics.drawable.Drawable) r9)
            com.google.android.material.internal.e r2 = r0.f36623h
            r2.c((int) r10)
            com.google.android.material.internal.d r2 = r0.f36622g
            com.google.android.material.internal.e r3 = r0.f36623h
            r2.a((androidx.appcompat.view.menu.m) r3)
            com.google.android.material.internal.e r2 = r0.f36623h
            com.google.android.material.internal.NavigationMenuView r3 = r2.f36445a
            if (r3 != 0) goto L_0x01fb
            android.view.LayoutInflater r3 = r2.f36450f
            int r5 = com.google.android.material.R.layout.design_navigation_menu
            android.view.View r3 = r3.inflate(r5, r0, r8)
            com.google.android.material.internal.NavigationMenuView r3 = (com.google.android.material.internal.NavigationMenuView) r3
            r2.f36445a = r3
            com.google.android.material.internal.NavigationMenuView r3 = r2.f36445a
            com.google.android.material.internal.e$g r5 = new com.google.android.material.internal.e$g
            com.google.android.material.internal.NavigationMenuView r6 = r2.f36445a
            r5.<init>(r6)
            r3.setAccessibilityDelegateCompat(r5)
            com.google.android.material.internal.e$b r3 = r2.f36449e
            if (r3 != 0) goto L_0x01da
            com.google.android.material.internal.e$b r3 = new com.google.android.material.internal.e$b
            r3.<init>()
            r2.f36449e = r3
        L_0x01da:
            int r3 = r2.t
            r5 = -1
            if (r3 == r5) goto L_0x01e6
            com.google.android.material.internal.NavigationMenuView r3 = r2.f36445a
            int r5 = r2.t
            r3.setOverScrollMode(r5)
        L_0x01e6:
            android.view.LayoutInflater r3 = r2.f36450f
            int r5 = com.google.android.material.R.layout.design_navigation_item_header
            com.google.android.material.internal.NavigationMenuView r6 = r2.f36445a
            android.view.View r3 = r3.inflate(r5, r6, r8)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.f36446b = r3
            com.google.android.material.internal.NavigationMenuView r3 = r2.f36445a
            com.google.android.material.internal.e$b r5 = r2.f36449e
            r3.setAdapter(r5)
        L_0x01fb:
            com.google.android.material.internal.NavigationMenuView r2 = r2.f36445a
            android.view.View r2 = (android.view.View) r2
            r0.addView(r2)
            int r2 = com.google.android.material.R.styleable.NavigationView_menu
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0228
            int r2 = com.google.android.material.R.styleable.NavigationView_menu
            int r2 = r1.g(r2, r8)
            com.google.android.material.internal.e r3 = r0.f36623h
            r3.b((boolean) r4)
            android.view.MenuInflater r3 = r17.getMenuInflater()
            com.google.android.material.internal.d r4 = r0.f36622g
            r3.inflate(r2, r4)
            com.google.android.material.internal.e r2 = r0.f36623h
            r2.b((boolean) r8)
            com.google.android.material.internal.e r2 = r0.f36623h
            r2.a((boolean) r8)
        L_0x0228:
            int r2 = com.google.android.material.R.styleable.NavigationView_headerLayout
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0250
            int r2 = com.google.android.material.R.styleable.NavigationView_headerLayout
            int r2 = r1.g(r2, r8)
            com.google.android.material.internal.e r3 = r0.f36623h
            android.view.LayoutInflater r4 = r3.f36450f
            android.widget.LinearLayout r5 = r3.f36446b
            android.view.View r2 = r4.inflate(r2, r5, r8)
            android.widget.LinearLayout r4 = r3.f36446b
            r4.addView(r2)
            com.google.android.material.internal.NavigationMenuView r2 = r3.f36445a
            com.google.android.material.internal.NavigationMenuView r3 = r3.f36445a
            int r3 = r3.getPaddingBottom()
            r2.setPadding(r8, r8, r8, r3)
        L_0x0250:
            android.content.res.TypedArray r1 = r1.f1669a
            r1.recycle()
            com.google.android.material.navigation.NavigationView$2 r1 = new com.google.android.material.navigation.NavigationView$2
            r1.<init>()
            r0.l = r1
            android.view.ViewTreeObserver r1 = r17.getViewTreeObserver()
            android.view.ViewTreeObserver$OnGlobalLayoutListener r2 = r0.l
            r1.addOnGlobalLayoutListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        e eVar = this.f36623h;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        i.a((View) this, f2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f36627a = new Bundle();
        this.f36622g.a(savedState.f36627a);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        this.f36622g.b(savedState.f36627a);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.f36621c = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f36624i), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f36624i, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public final void a(ab abVar) {
        e eVar = this.f36623h;
        int b2 = abVar.b();
        if (eVar.r != b2) {
            eVar.r = b2;
            eVar.c();
        }
        eVar.f36445a.setPadding(0, eVar.f36445a.getPaddingTop(), 0, abVar.d());
        u.b((View) eVar.f36446b, abVar);
    }

    public Menu getMenu() {
        return this.f36622g;
    }

    public int getHeaderCount() {
        return this.f36623h.f36446b.getChildCount();
    }

    public ColorStateList getItemIconTintList() {
        return this.f36623h.j;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f36623h.a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f36623h.f36453i;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f36623h.b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f36623h.k;
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(b.a(getContext(), i2));
    }

    public void setItemBackground(Drawable drawable) {
        this.f36623h.a(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.f36623h.l;
    }

    public void setItemHorizontalPadding(int i2) {
        this.f36623h.b(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.f36623h.b(getResources().getDimensionPixelSize(i2));
    }

    public int getItemIconPadding() {
        return this.f36623h.m;
    }

    public void setItemIconPadding(int i2) {
        this.f36623h.c(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f36623h.c(getResources().getDimensionPixelSize(i2));
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.f36622g.findItem(i2);
        if (findItem != null) {
            this.f36623h.a((androidx.appcompat.view.menu.i) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f36622g.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f36623h.a((androidx.appcompat.view.menu.i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.f36623h.f36449e.f36456b;
    }

    public void setItemTextAppearance(int i2) {
        this.f36623h.a(i2);
    }

    public void setItemIconSize(int i2) {
        this.f36623h.e(i2);
    }

    public void setItemMaxLines(int i2) {
        this.f36623h.d(i2);
    }

    public int getItemMaxLines() {
        return this.f36623h.q;
    }

    private MenuInflater getMenuInflater() {
        if (this.k == null) {
            this.k = new g(getContext());
        }
        return this.k;
    }

    private ColorStateList a(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = androidx.appcompat.a.a.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        return new ColorStateList(new int[][]{f36619e, f36618d, EMPTY_STATE_SET}, new int[]{a2.getColorForState(f36619e, defaultColor), i3, defaultColor});
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.l);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
        }
    }

    public static class SavedState extends AbsSavedState {
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
        public Bundle f36627a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f36627a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f36627a);
        }
    }
}
