package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.core.g.e;
import androidx.core.h.a.c;
import androidx.core.h.u;
import androidx.interpolator.a.a.b;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.j;
import java.util.HashSet;

public class BottomNavigationMenuView extends ViewGroup implements n {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f35966i = {16842912};
    private static final int[] j = {-16842910};
    private SparseArray<BadgeDrawable> A;

    /* renamed from: a  reason: collision with root package name */
    final TransitionSet f35967a;

    /* renamed from: b  reason: collision with root package name */
    boolean f35968b;

    /* renamed from: c  reason: collision with root package name */
    int f35969c;

    /* renamed from: d  reason: collision with root package name */
    BottomNavigationItemView[] f35970d;

    /* renamed from: e  reason: collision with root package name */
    int f35971e;

    /* renamed from: f  reason: collision with root package name */
    int f35972f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public BottomNavigationPresenter f35973g;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public g f35974h;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final View.OnClickListener p;
    private final e.a<BottomNavigationItemView> q;
    private ColorStateList r;
    private int s;
    private ColorStateList t;
    private final ColorStateList u;
    private int v;
    private int w;
    private Drawable x;
    private int y;
    private int[] z;

    static boolean a(int i2, int i3) {
        return i2 == -1 ? i3 > 3 : i2 == 0;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public BottomNavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = new e.c(5);
        this.f35971e = 0;
        this.f35972f = 0;
        this.A = new SparseArray<>(5);
        Resources resources = getResources();
        this.k = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.l = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.m = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.n = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.o = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        this.u = a();
        this.f35967a = new AutoTransition();
        this.f35967a.b(0);
        this.f35967a.a(115);
        this.f35967a.a((TimeInterpolator) new b());
        this.f35967a.a((Transition) new j());
        this.p = new View.OnClickListener() {
            public final void onClick(View view) {
                i itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.f35974h.a((MenuItem) itemData, (m) BottomNavigationMenuView.this.f35973g, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.z = new int[5];
        u.c((View) this, 1);
    }

    public final void a(g gVar) {
        this.f35974h = gVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f35974h.i().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.o, 1073741824);
        if (!a(this.f35969c, size2) || !this.f35968b) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.m);
            int i4 = size - (size2 * min);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (getChildAt(i5).getVisibility() != 8) {
                    int[] iArr = this.z;
                    iArr[i5] = min;
                    if (i4 > 0) {
                        iArr[i5] = iArr[i5] + 1;
                        i4--;
                    }
                } else {
                    this.z[i5] = 0;
                }
            }
        } else {
            View childAt = getChildAt(this.f35972f);
            int i6 = this.n;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.m, Integer.MIN_VALUE), makeMeasureSpec);
                i6 = Math.max(i6, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.l * i7), Math.min(i6, this.m));
            int i8 = size - min2;
            int min3 = Math.min(i8 / (i7 == 0 ? 1 : i7), this.k);
            int i9 = i8 - (i7 * min3);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    this.z[i10] = i10 == this.f35972f ? min2 : min3;
                    if (i9 > 0) {
                        int[] iArr2 = this.z;
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.z[i10] = 0;
                }
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.z[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.o, makeMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (u.j(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        c.a(accessibilityNodeInfo).a((Object) c.b.a(1, this.f35974h.i().size(), false, 1));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView iconTintList : bottomNavigationItemViewArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.r;
    }

    public void setItemIconSize(int i2) {
        this.s = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView iconSize : bottomNavigationItemViewArr) {
                iconSize.setIconSize(i2);
            }
        }
    }

    public int getItemIconSize() {
        return this.s;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.t = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView textColor : bottomNavigationItemViewArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.t;
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.v = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.t;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceInactive() {
        return this.v;
    }

    public void setItemTextAppearanceActive(int i2) {
        this.w = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.t;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceActive() {
        return this.w;
    }

    public void setItemBackgroundRes(int i2) {
        this.y = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView itemBackground : bottomNavigationItemViewArr) {
                itemBackground.setItemBackground(i2);
            }
        }
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.y;
    }

    public void setItemBackground(Drawable drawable) {
        this.x = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView itemBackground : bottomNavigationItemViewArr) {
                itemBackground.setItemBackground(drawable);
            }
        }
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) {
            return this.x;
        }
        return bottomNavigationItemViewArr[0].getBackground();
    }

    public void setLabelVisibilityMode(int i2) {
        this.f35969c = i2;
    }

    public int getLabelVisibilityMode() {
        return this.f35969c;
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.f35968b = z2;
    }

    public final ColorStateList a() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16842808, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        return new ColorStateList(new int[][]{j, f35966i, EMPTY_STATE_SET}, new int[]{a2.getColorForState(j, defaultColor), i2, defaultColor});
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.f35973g = bottomNavigationPresenter;
    }

    public final void b() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.q.a(bottomNavigationItemView);
                    ImageView imageView = bottomNavigationItemView.f35957a;
                    if (bottomNavigationItemView.b()) {
                        if (imageView != null) {
                            bottomNavigationItemView.setClipChildren(true);
                            bottomNavigationItemView.setClipToPadding(true);
                            com.google.android.material.badge.a.b(bottomNavigationItemView.f35958b, imageView, bottomNavigationItemView.a((View) imageView));
                        }
                        bottomNavigationItemView.f35958b = null;
                    }
                }
            }
        }
        if (this.f35974h.size() == 0) {
            this.f35971e = 0;
            this.f35972f = 0;
            this.f35970d = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.f35974h.size(); i2++) {
            hashSet.add(Integer.valueOf(this.f35974h.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.A.size(); i3++) {
            int keyAt = this.A.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.A.delete(keyAt);
            }
        }
        this.f35970d = new BottomNavigationItemView[this.f35974h.size()];
        boolean a2 = a(this.f35969c, this.f35974h.i().size());
        for (int i4 = 0; i4 < this.f35974h.size(); i4++) {
            this.f35973g.f35977b = true;
            this.f35974h.getItem(i4).setCheckable(true);
            this.f35973g.f35977b = false;
            BottomNavigationItemView newItem = getNewItem();
            this.f35970d[i4] = newItem;
            newItem.setIconTintList(this.r);
            newItem.setIconSize(this.s);
            newItem.setTextColor(this.u);
            newItem.setTextAppearanceInactive(this.v);
            newItem.setTextAppearanceActive(this.w);
            newItem.setTextColor(this.t);
            Drawable drawable = this.x;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.y);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.f35969c);
            newItem.a((i) this.f35974h.getItem(i4));
            newItem.setItemPosition(i4);
            newItem.setOnClickListener(this.p);
            if (this.f35971e != 0 && this.f35974h.getItem(i4).getItemId() == this.f35971e) {
                this.f35972f = i4;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        this.f35972f = Math.min(this.f35974h.size() - 1, this.f35972f);
        this.f35974h.getItem(this.f35972f).setChecked(true);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView a2 = this.q.a();
        return a2 == null ? new BottomNavigationItemView(getContext()) : a2;
    }

    public int getSelectedItemId() {
        return this.f35971e;
    }

    /* access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.A = sparseArray;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.f35970d;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    private void setBadgeIfNeeded(BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        int id = bottomNavigationItemView.getId();
        if ((id != -1) && (badgeDrawable = this.A.get(id)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }
}
