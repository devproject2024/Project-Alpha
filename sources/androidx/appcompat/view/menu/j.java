package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.b;
import java.lang.reflect.Method;

public final class j extends c implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    public final androidx.core.b.a.b f1358d;

    /* renamed from: e  reason: collision with root package name */
    public Method f1359e;

    public j(Context context, androidx.core.b.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f1358d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public final int getItemId() {
        return this.f1358d.getItemId();
    }

    public final int getGroupId() {
        return this.f1358d.getGroupId();
    }

    public final int getOrder() {
        return this.f1358d.getOrder();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f1358d.setTitle(charSequence);
        return this;
    }

    public final MenuItem setTitle(int i2) {
        this.f1358d.setTitle(i2);
        return this;
    }

    public final CharSequence getTitle() {
        return this.f1358d.getTitle();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1358d.setTitleCondensed(charSequence);
        return this;
    }

    public final CharSequence getTitleCondensed() {
        return this.f1358d.getTitleCondensed();
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f1358d.setIcon(drawable);
        return this;
    }

    public final MenuItem setIcon(int i2) {
        this.f1358d.setIcon(i2);
        return this;
    }

    public final Drawable getIcon() {
        return this.f1358d.getIcon();
    }

    public final MenuItem setIntent(Intent intent) {
        this.f1358d.setIntent(intent);
        return this;
    }

    public final Intent getIntent() {
        return this.f1358d.getIntent();
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.f1358d.setShortcut(c2, c3);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f1358d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2) {
        this.f1358d.setNumericShortcut(c2);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2, int i2) {
        this.f1358d.setNumericShortcut(c2, i2);
        return this;
    }

    public final char getNumericShortcut() {
        return this.f1358d.getNumericShortcut();
    }

    public final int getNumericModifiers() {
        return this.f1358d.getNumericModifiers();
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        this.f1358d.setAlphabeticShortcut(c2);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f1358d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.f1358d.getAlphabeticShortcut();
    }

    public final int getAlphabeticModifiers() {
        return this.f1358d.getAlphabeticModifiers();
    }

    public final MenuItem setCheckable(boolean z) {
        this.f1358d.setCheckable(z);
        return this;
    }

    public final boolean isCheckable() {
        return this.f1358d.isCheckable();
    }

    public final MenuItem setChecked(boolean z) {
        this.f1358d.setChecked(z);
        return this;
    }

    public final boolean isChecked() {
        return this.f1358d.isChecked();
    }

    public final MenuItem setVisible(boolean z) {
        return this.f1358d.setVisible(z);
    }

    public final boolean isVisible() {
        return this.f1358d.isVisible();
    }

    public final MenuItem setEnabled(boolean z) {
        this.f1358d.setEnabled(z);
        return this;
    }

    public final boolean isEnabled() {
        return this.f1358d.isEnabled();
    }

    public final boolean hasSubMenu() {
        return this.f1358d.hasSubMenu();
    }

    public final SubMenu getSubMenu() {
        return a(this.f1358d.getSubMenu());
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1358d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1358d.getMenuInfo();
    }

    public final void setShowAsAction(int i2) {
        this.f1358d.setShowAsAction(i2);
    }

    public final MenuItem setShowAsActionFlags(int i2) {
        this.f1358d.setShowAsActionFlags(i2);
        return this;
    }

    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f1358d.setActionView(view);
        return this;
    }

    public final MenuItem setActionView(int i2) {
        this.f1358d.setActionView(i2);
        View actionView = this.f1358d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f1358d.setActionView((View) new c(actionView));
        }
        return this;
    }

    public final View getActionView() {
        View actionView = this.f1358d.getActionView();
        return actionView instanceof c ? (View) ((c) actionView).f1364a : actionView;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.h.b bVar;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar = new b(this.f1297a, actionProvider);
        } else {
            bVar = new a(this.f1297a, actionProvider);
        }
        androidx.core.b.a.b bVar2 = this.f1358d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    public final ActionProvider getActionProvider() {
        androidx.core.h.b a2 = this.f1358d.a();
        if (a2 instanceof a) {
            return ((a) a2).f1360a;
        }
        return null;
    }

    public final boolean expandActionView() {
        return this.f1358d.expandActionView();
    }

    public final boolean collapseActionView() {
        return this.f1358d.collapseActionView();
    }

    public final boolean isActionViewExpanded() {
        return this.f1358d.isActionViewExpanded();
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1358d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f1358d.a(charSequence);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.f1358d.getContentDescription();
    }

    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f1358d.b(charSequence);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.f1358d.getTooltipText();
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1358d.setIconTintList(colorStateList);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.f1358d.getIconTintList();
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1358d.setIconTintMode(mode);
        return this;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.f1358d.getIconTintMode();
    }

    class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f1368b;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f1368b = onMenuItemClickListener;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return this.f1368b.onMenuItemClick(j.this.a(menuItem));
        }
    }

    class d implements MenuItem.OnActionExpandListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f1366b;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f1366b = onActionExpandListener;
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1366b.onMenuItemActionExpand(j.this.a(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1366b.onMenuItemActionCollapse(j.this.a(menuItem));
        }
    }

    class a extends androidx.core.h.b {

        /* renamed from: a  reason: collision with root package name */
        final ActionProvider f1360a;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1360a = actionProvider;
        }

        public final View a() {
            return this.f1360a.onCreateActionView();
        }

        public final boolean b() {
            return this.f1360a.onPerformDefaultAction();
        }

        public final boolean c() {
            return this.f1360a.hasSubMenu();
        }

        public final void a(SubMenu subMenu) {
            this.f1360a.onPrepareSubMenu(j.this.a(subMenu));
        }
    }

    class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f  reason: collision with root package name */
        private b.C0048b f1363f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public final View a(MenuItem menuItem) {
            return this.f1360a.onCreateActionView(menuItem);
        }

        public final boolean d() {
            return this.f1360a.overridesItemVisibility();
        }

        public final boolean e() {
            return this.f1360a.isVisible();
        }

        public final void a(b.C0048b bVar) {
            this.f1363f = bVar;
            this.f1360a.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            b.C0048b bVar = this.f1363f;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f1364a;

        c(View view) {
            super(view.getContext());
            this.f1364a = (CollapsibleActionView) view;
            addView(view);
        }

        public final void a() {
            this.f1364a.onActionViewExpanded();
        }

        public final void b() {
            this.f1364a.onActionViewCollapsed();
        }
    }
}
