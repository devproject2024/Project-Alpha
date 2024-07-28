package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.ae;
import androidx.core.content.b.f;
import androidx.core.h.a;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.R;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public class NavigationMenuItemView extends ForegroundLinearLayout implements n.a {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f36417f = {16842912};

    /* renamed from: c  reason: collision with root package name */
    boolean f36418c;

    /* renamed from: d  reason: collision with root package name */
    final CheckedTextView f36419d;

    /* renamed from: e  reason: collision with root package name */
    FrameLayout f36420e;

    /* renamed from: g  reason: collision with root package name */
    private int f36421g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36422h;

    /* renamed from: i  reason: collision with root package name */
    private i f36423i;
    private ColorStateList j;
    private boolean k;
    private Drawable l;
    private final a m;

    public final boolean a() {
        return false;
    }

    public void setShortcut(boolean z, char c2) {
    }

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = new a() {
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.a(NavigationMenuItemView.this.f36418c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        this.f36419d = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.f36419d.setDuplicateParentStateEnabled(true);
        u.a((View) this.f36419d, this.m);
    }

    public final void a(i iVar) {
        StateListDrawable stateListDrawable;
        this.f36423i = iVar;
        if (iVar.getItemId() > 0) {
            setId(iVar.getItemId());
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
        boolean z = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f36417f, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            u.a((View) this, (Drawable) stateListDrawable);
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        ae.a(this, iVar.getTooltipText());
        if (!(this.f36423i.getTitle() == null && this.f36423i.getIcon() == null && this.f36423i.getActionView() != null)) {
            z = false;
        }
        if (z) {
            this.f36419d.setVisibility(8);
            FrameLayout frameLayout = this.f36420e;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.width = -1;
                this.f36420e.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f36419d.setVisibility(0);
        FrameLayout frameLayout2 = this.f36420e;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            layoutParams2.width = -2;
            this.f36420e.setLayoutParams(layoutParams2);
        }
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f36420e == null) {
                this.f36420e = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f36420e.removeAllViews();
            this.f36420e.addView(view);
        }
    }

    public i getItemData() {
        return this.f36423i;
    }

    public void setTitle(CharSequence charSequence) {
        this.f36419d.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f36418c != z) {
            this.f36418c = z;
            this.m.sendAccessibilityEvent(this.f36419d, EmiUtil.EMI_PLAN_REQUEST_CODE);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f36419d.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.f(drawable).mutate();
                androidx.core.graphics.drawable.a.a(drawable, this.j);
            }
            int i2 = this.f36421g;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.f36422h) {
            if (this.l == null) {
                this.l = f.a(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.l;
                if (drawable2 != null) {
                    int i3 = this.f36421g;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.l;
        }
        androidx.core.widget.i.a(this.f36419d, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconSize(int i2) {
        this.f36421g = i2;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.f36423i;
        if (iVar != null && iVar.isCheckable() && this.f36423i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f36417f);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.k = this.j != null;
        i iVar = this.f36423i;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setTextAppearance(int i2) {
        androidx.core.widget.i.a((TextView) this.f36419d, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f36419d.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f36422h = z;
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIconPadding(int i2) {
        this.f36419d.setCompoundDrawablePadding(i2);
    }

    public void setMaxLines(int i2) {
        this.f36419d.setMaxLines(i2);
    }
}
