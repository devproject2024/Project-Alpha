package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.b.a.b;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f1279a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1280b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1281c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f1282d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f1283e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f1284f;

    /* renamed from: g  reason: collision with root package name */
    private char f1285g;

    /* renamed from: h  reason: collision with root package name */
    private int f1286h = 4096;

    /* renamed from: i  reason: collision with root package name */
    private char f1287i;
    private int j = 4096;
    private Drawable k;
    private Context l;
    private MenuItem.OnMenuItemClickListener m;
    private CharSequence n;
    private CharSequence o;
    private ColorStateList p = null;
    private PorterDuff.Mode q = null;
    private boolean r = false;
    private boolean s = false;
    private int t = 16;

    public final androidx.core.h.b a() {
        return null;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean expandActionView() {
        return false;
    }

    public final View getActionView() {
        return null;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final void setShowAsAction(int i2) {
    }

    public a(Context context, CharSequence charSequence) {
        this.l = context;
        this.f1279a = 16908332;
        this.f1280b = 0;
        this.f1281c = 0;
        this.f1282d = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.f1287i;
    }

    public final int getAlphabeticModifiers() {
        return this.j;
    }

    public final int getGroupId() {
        return this.f1280b;
    }

    public final Drawable getIcon() {
        return this.k;
    }

    public final Intent getIntent() {
        return this.f1284f;
    }

    public final int getItemId() {
        return this.f1279a;
    }

    public final char getNumericShortcut() {
        return this.f1285g;
    }

    public final int getNumericModifiers() {
        return this.f1286h;
    }

    public final int getOrder() {
        return this.f1281c;
    }

    public final CharSequence getTitle() {
        return this.f1282d;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1283e;
        return charSequence != null ? charSequence : this.f1282d;
    }

    public final boolean isCheckable() {
        return (this.t & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.t & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.t & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.t & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        this.f1287i = Character.toLowerCase(c2);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f1287i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.t = z | (this.t & true) ? 1 : 0;
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.t = (z ? 2 : 0) | (this.t & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.t = (z ? 16 : 0) | (this.t & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        b();
        return this;
    }

    public final MenuItem setIcon(int i2) {
        this.k = androidx.core.content.b.a(this.l, i2);
        b();
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f1284f = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c2) {
        this.f1285g = c2;
        return this;
    }

    public final MenuItem setNumericShortcut(char c2, int i2) {
        this.f1285g = c2;
        this.f1286h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.f1285g = c2;
        this.f1287i = Character.toLowerCase(c3);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f1285g = c2;
        this.f1286h = KeyEvent.normalizeMetaState(i2);
        this.f1287i = Character.toLowerCase(c3);
        this.j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f1282d = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i2) {
        this.f1282d = this.l.getResources().getString(i2);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1283e = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.t & 8;
        if (z) {
            i2 = 0;
        }
        this.t = i3 | i2;
        return this;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final b a(androidx.core.h.b bVar) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final b a(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.n;
    }

    public final b b(CharSequence charSequence) {
        this.o = charSequence;
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.o;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        this.r = true;
        b();
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.p;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.q = mode;
        this.s = true;
        b();
        return this;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.q;
    }

    private void b() {
        if (this.k == null) {
            return;
        }
        if (this.r || this.s) {
            this.k = androidx.core.graphics.drawable.a.f(this.k);
            this.k = this.k.mutate();
            if (this.r) {
                androidx.core.graphics.drawable.a.a(this.k, this.p);
            }
            if (this.s) {
                androidx.core.graphics.drawable.a.a(this.k, this.q);
            }
        }
    }

    public final /* synthetic */ MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        this.o = charSequence;
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }
}
