package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ae;
import androidx.core.content.b;
import androidx.core.graphics.drawable.a;
import androidx.core.h.a.c;
import androidx.core.h.s;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;

public class BottomNavigationItemView extends FrameLayout implements n.a {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f35956c = {16842912};
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public ImageView f35957a;

    /* renamed from: b  reason: collision with root package name */
    BadgeDrawable f35958b;

    /* renamed from: d  reason: collision with root package name */
    private final int f35959d;

    /* renamed from: e  reason: collision with root package name */
    private float f35960e;

    /* renamed from: f  reason: collision with root package name */
    private float f35961f;

    /* renamed from: g  reason: collision with root package name */
    private float f35962g;

    /* renamed from: h  reason: collision with root package name */
    private int f35963h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f35964i;
    private final TextView j;
    private final TextView k;
    private int l;
    private i m;
    private ColorStateList n;
    private Drawable o;
    private Drawable p;

    public final boolean a() {
        return false;
    }

    public void setShortcut(boolean z, char c2) {
    }

    public BottomNavigationItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R.layout.design_bottom_navigation_item, this, true);
        setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.f35959d = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.f35957a = (ImageView) findViewById(R.id.icon);
        this.j = (TextView) findViewById(R.id.smallLabel);
        this.k = (TextView) findViewById(R.id.largeLabel);
        u.c((View) this.j, 2);
        u.c((View) this.k, 2);
        setFocusable(true);
        a(this.j.getTextSize(), this.k.getTextSize());
        ImageView imageView = this.f35957a;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (BottomNavigationItemView.this.f35957a.getVisibility() == 0) {
                        BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                        BottomNavigationItemView.a(bottomNavigationItemView, (View) bottomNavigationItemView.f35957a);
                    }
                }
            });
        }
    }

    public final void a(i iVar) {
        CharSequence charSequence;
        this.m = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        if (!TextUtils.isEmpty(iVar.getTooltipText())) {
            charSequence = iVar.getTooltipText();
        } else {
            charSequence = iVar.getTitle();
        }
        ae.a(this, charSequence);
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int i2) {
        this.l = i2;
    }

    public int getItemPosition() {
        return this.l;
    }

    public void setShifting(boolean z) {
        if (this.f35964i != z) {
            this.f35964i = z;
            if (this.m != null) {
                setChecked(this.m.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f35963h != i2) {
            this.f35963h = i2;
            if (this.m != null) {
                setChecked(this.m.isChecked());
            }
        }
    }

    public i getItemData() {
        return this.m;
    }

    public void setTitle(CharSequence charSequence) {
        this.j.setText(charSequence);
        this.k.setText(charSequence);
        i iVar = this.m;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        i iVar2 = this.m;
        if (iVar2 != null && !TextUtils.isEmpty(iVar2.getTooltipText())) {
            charSequence = this.m.getTooltipText();
        }
        ae.a(this, charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.k;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.k;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.j;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.j;
        textView4.setPivotY((float) textView4.getBaseline());
        int i2 = this.f35963h;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    a(this.f35957a, this.f35959d, 49);
                    a(this.k, 1.0f, 1.0f, 0);
                } else {
                    a(this.f35957a, this.f35959d, 17);
                    a(this.k, 0.5f, 0.5f, 4);
                }
                this.j.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    a(this.f35957a, this.f35959d, 17);
                    this.k.setVisibility(8);
                    this.j.setVisibility(8);
                }
            } else if (z) {
                a(this.f35957a, (int) (((float) this.f35959d) + this.f35960e), 49);
                a(this.k, 1.0f, 1.0f, 0);
                TextView textView5 = this.j;
                float f2 = this.f35961f;
                a(textView5, f2, f2, 4);
            } else {
                a(this.f35957a, this.f35959d, 49);
                TextView textView6 = this.k;
                float f3 = this.f35962g;
                a(textView6, f3, f3, 4);
                a(this.j, 1.0f, 1.0f, 0);
            }
        } else if (this.f35964i) {
            if (z) {
                a(this.f35957a, this.f35959d, 49);
                a(this.k, 1.0f, 1.0f, 0);
            } else {
                a(this.f35957a, this.f35959d, 17);
                a(this.k, 0.5f, 0.5f, 4);
            }
            this.j.setVisibility(4);
        } else if (z) {
            a(this.f35957a, (int) (((float) this.f35959d) + this.f35960e), 49);
            a(this.k, 1.0f, 1.0f, 0);
            TextView textView7 = this.j;
            float f4 = this.f35961f;
            a(textView7, f4, f4, 4);
        } else {
            a(this.f35957a, this.f35959d, 49);
            TextView textView8 = this.k;
            float f5 = this.f35962g;
            a(textView8, f5, f5, 4);
            a(this.j, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.f35958b;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.m.getTitle();
            if (!TextUtils.isEmpty(this.m.getContentDescription())) {
                title = this.m.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(title + ", " + this.f35958b.b());
        }
        c a2 = c.a(accessibilityNodeInfo);
        a2.b((Object) c.C0046c.a(0, 1, getItemPosition(), 1, false, isSelected()));
        if (isSelected()) {
            a2.g(false);
            a2.b(c.a.f3048e);
        }
        a2.g((CharSequence) getResources().getString(R.string.item_view_role_description));
    }

    private static void a(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private static void a(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.j.setEnabled(z);
        this.k.setEnabled(z);
        this.f35957a.setEnabled(z);
        if (z) {
            u.a((View) this, s.a(getContext()));
        } else {
            u.a((View) this, (s) null);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.m;
        if (iVar != null && iVar.isCheckable() && this.m.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f35956c);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != this.o) {
            this.o = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = a.f(drawable).mutate();
                this.p = drawable;
                ColorStateList colorStateList = this.n;
                if (colorStateList != null) {
                    a.a(this.p, colorStateList);
                }
            }
            this.f35957a.setImageDrawable(drawable);
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.n = colorStateList;
        if (this.m != null && (drawable = this.p) != null) {
            a.a(drawable, this.n);
            this.p.invalidateSelf();
        }
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f35957a.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f35957a.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int i2) {
        androidx.core.widget.i.a(this.j, i2);
        a(this.j.getTextSize(), this.k.getTextSize());
    }

    public void setTextAppearanceActive(int i2) {
        androidx.core.widget.i.a(this.k, i2);
        a(this.j.getTextSize(), this.k.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.j.setTextColor(colorStateList);
            this.k.setTextColor(colorStateList);
        }
    }

    private void a(float f2, float f3) {
        this.f35960e = f2 - f3;
        this.f35961f = (f3 * 1.0f) / f2;
        this.f35962g = (f2 * 1.0f) / f3;
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : b.a(getContext(), i2));
    }

    public void setItemBackground(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        u.a((View) this, drawable);
    }

    /* access modifiers changed from: package-private */
    public void setBadge(BadgeDrawable badgeDrawable) {
        this.f35958b = badgeDrawable;
        ImageView imageView = this.f35957a;
        if (imageView != null && b() && imageView != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.a.a(this.f35958b, imageView, a((View) imageView));
        }
    }

    /* access modifiers changed from: package-private */
    public BadgeDrawable getBadge() {
        return this.f35958b;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.f35958b != null;
    }

    /* access modifiers changed from: package-private */
    public final FrameLayout a(View view) {
        if (view != this.f35957a || !com.google.android.material.badge.a.f35899a) {
            return null;
        }
        return (FrameLayout) this.f35957a.getParent();
    }

    static /* synthetic */ void a(BottomNavigationItemView bottomNavigationItemView, View view) {
        if (bottomNavigationItemView.b()) {
            com.google.android.material.badge.a.c(bottomNavigationItemView.f35958b, view, bottomNavigationItemView.a(view));
        }
    }
}
