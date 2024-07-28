package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ac;
import androidx.core.h.ab;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.h.c;
import com.google.android.material.internal.k;
import com.google.android.material.internal.q;
import com.google.android.material.k.h;
import com.google.android.material.k.i;

public class BottomNavigationView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private static final int f35982b = R.style.Widget_Design_BottomNavigationView;

    /* renamed from: a  reason: collision with root package name */
    final BottomNavigationMenuView f35983a;

    /* renamed from: c  reason: collision with root package name */
    private final g f35984c;

    /* renamed from: d  reason: collision with root package name */
    private final BottomNavigationPresenter f35985d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f35986e;

    /* renamed from: f  reason: collision with root package name */
    private MenuInflater f35987f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f35988g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f35989h;

    public interface a {
    }

    public interface b {
        boolean a();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public BottomNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f35982b), attributeSet, i2);
        this.f35985d = new BottomNavigationPresenter();
        Context context2 = getContext();
        this.f35984c = new a(context2);
        this.f35983a = new BottomNavigationMenuView(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f35983a.setLayoutParams(layoutParams);
        BottomNavigationPresenter bottomNavigationPresenter = this.f35985d;
        BottomNavigationMenuView bottomNavigationMenuView = this.f35983a;
        bottomNavigationPresenter.f35976a = bottomNavigationMenuView;
        bottomNavigationPresenter.f35978c = 1;
        bottomNavigationMenuView.setPresenter(bottomNavigationPresenter);
        this.f35984c.a((m) this.f35985d);
        this.f35985d.a(getContext(), this.f35984c);
        ac b2 = k.b(context2, attributeSet, R.styleable.BottomNavigationView, i2, R.style.Widget_Design_BottomNavigationView, R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive);
        if (b2.g(R.styleable.BottomNavigationView_itemIconTint)) {
            this.f35983a.setIconTintList(b2.e(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            BottomNavigationMenuView bottomNavigationMenuView2 = this.f35983a;
            bottomNavigationMenuView2.setIconTintList(bottomNavigationMenuView2.a());
        }
        setItemIconSize(b2.e(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (b2.g(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(b2.g(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (b2.g(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(b2.g(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (b2.g(R.styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(b2.e(R.styleable.BottomNavigationView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            h hVar = new h();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                hVar.g(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            hVar.a(context2);
            u.a((View) this, (Drawable) hVar);
        }
        if (b2.g(R.styleable.BottomNavigationView_elevation)) {
            u.g((View) this, (float) b2.e(R.styleable.BottomNavigationView_elevation, 0));
        }
        androidx.core.graphics.drawable.a.a(getBackground().mutate(), c.a(context2, b2, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(b2.c(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(b2.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int g2 = b2.g(R.styleable.BottomNavigationView_itemBackground, 0);
        if (g2 != 0) {
            this.f35983a.setItemBackgroundRes(g2);
        } else {
            setItemRippleColor(c.a(context2, b2, R.styleable.BottomNavigationView_itemRippleColor));
        }
        if (b2.g(R.styleable.BottomNavigationView_menu)) {
            int g3 = b2.g(R.styleable.BottomNavigationView_menu, 0);
            this.f35985d.f35977b = true;
            getMenuInflater().inflate(g3, this.f35984c);
            BottomNavigationPresenter bottomNavigationPresenter2 = this.f35985d;
            bottomNavigationPresenter2.f35977b = false;
            bottomNavigationPresenter2.a(true);
        }
        b2.f1669a.recycle();
        addView(this.f35983a, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            View view = new View(context2);
            view.setBackgroundColor(androidx.core.content.b.c(context2, R.color.design_bottom_navigation_shadow_color));
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
            addView(view);
        }
        this.f35984c.a((g.a) new g.a() {
            public final void a(g gVar) {
            }

            public final boolean a(g gVar, MenuItem menuItem) {
                if (BottomNavigationView.this.f35989h != null && menuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()) {
                    a unused = BottomNavigationView.this.f35989h;
                    return true;
                } else if (BottomNavigationView.this.f35988g == null || BottomNavigationView.this.f35988g.a()) {
                    return false;
                } else {
                    return true;
                }
            }
        });
        q.a((View) this, (q.a) new q.a() {
            public final ab a(View view, ab abVar, q.b bVar) {
                bVar.f36509d += abVar.d();
                bVar.a(view);
                return abVar;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a((View) this, f2);
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.f35988g = bVar;
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.f35989h = aVar;
    }

    public Menu getMenu() {
        return this.f35984c;
    }

    public ColorStateList getItemIconTintList() {
        return this.f35983a.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f35983a.setIconTintList(colorStateList);
    }

    public void setItemIconSize(int i2) {
        this.f35983a.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public int getItemIconSize() {
        return this.f35983a.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.f35983a.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f35983a.setItemTextColor(colorStateList);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f35983a.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i2) {
        this.f35983a.setItemBackgroundRes(i2);
        this.f35986e = null;
    }

    public Drawable getItemBackground() {
        return this.f35983a.getItemBackground();
    }

    public void setItemBackground(Drawable drawable) {
        this.f35983a.setItemBackground(drawable);
        this.f35986e = null;
    }

    public ColorStateList getItemRippleColor() {
        return this.f35986e;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.f35986e != colorStateList) {
            this.f35986e = colorStateList;
            if (colorStateList == null) {
                this.f35983a.setItemBackground((Drawable) null);
                return;
            }
            ColorStateList a2 = com.google.android.material.i.b.a(colorStateList);
            if (Build.VERSION.SDK_INT >= 21) {
                this.f35983a.setItemBackground(new RippleDrawable(a2, (Drawable) null, (Drawable) null));
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(1.0E-5f);
            Drawable f2 = androidx.core.graphics.drawable.a.f(gradientDrawable);
            androidx.core.graphics.drawable.a.a(f2, a2);
            this.f35983a.setItemBackground(f2);
        } else if (colorStateList == null && this.f35983a.getItemBackground() != null) {
            this.f35983a.setItemBackground((Drawable) null);
        }
    }

    public int getSelectedItemId() {
        return this.f35983a.getSelectedItemId();
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.f35984c.findItem(i2);
        if (findItem != null && !this.f35984c.a(findItem, (m) this.f35985d, 0)) {
            findItem.setChecked(true);
        }
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f35983a.getLabelVisibilityMode() != i2) {
            this.f35983a.setLabelVisibilityMode(i2);
            this.f35985d.a(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.f35983a.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f35983a.setItemTextAppearanceInactive(i2);
    }

    public int getItemTextAppearanceInactive() {
        return this.f35983a.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f35983a.setItemTextAppearanceActive(i2);
    }

    public int getItemTextAppearanceActive() {
        return this.f35983a.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f35983a.f35968b != z) {
            this.f35983a.setItemHorizontalTranslationEnabled(z);
            this.f35985d.a(false);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.f35987f == null) {
            this.f35987f = new androidx.appcompat.view.g(getContext());
        }
        return this.f35987f;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f35992a = new Bundle();
        this.f35984c.a(savedState.f35992a);
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
        this.f35984c.b(savedState.f35992a);
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
        Bundle f35992a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f35992a = parcel.readBundle(classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f35992a);
        }
    }
}
