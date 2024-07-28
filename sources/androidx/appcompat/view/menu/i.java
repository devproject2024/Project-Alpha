package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.menu.n;
import androidx.core.b.a.b;
import androidx.core.h.b;

public final class i implements b {
    private int A = 16;
    private int B = 0;
    private View C;
    private MenuItem.OnActionExpandListener D;
    private boolean E = false;

    /* renamed from: a  reason: collision with root package name */
    final int f1348a;

    /* renamed from: b  reason: collision with root package name */
    int f1349b = 4096;

    /* renamed from: c  reason: collision with root package name */
    int f1350c = 4096;

    /* renamed from: d  reason: collision with root package name */
    g f1351d;

    /* renamed from: e  reason: collision with root package name */
    public androidx.core.h.b f1352e;

    /* renamed from: f  reason: collision with root package name */
    ContextMenu.ContextMenuInfo f1353f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1354g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1355h;

    /* renamed from: i  reason: collision with root package name */
    private final int f1356i;
    private CharSequence j;
    private CharSequence k;
    private Intent l;
    private char m;
    private char n;
    private Drawable o;
    private int p = 0;
    private r q;
    private Runnable r;
    private MenuItem.OnMenuItemClickListener s;
    private CharSequence t;
    private CharSequence u;
    private ColorStateList v = null;
    private PorterDuff.Mode w = null;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;

    i(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f1351d = gVar;
        this.f1354g = i3;
        this.f1355h = i2;
        this.f1356i = i4;
        this.f1348a = i5;
        this.j = charSequence;
        this.B = i6;
    }

    public final boolean b() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.s;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f1351d;
        if (gVar.a(gVar, (MenuItem) this)) {
            return true;
        }
        Runnable runnable = this.r;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.l != null) {
            try {
                this.f1351d.f1335a.startActivity(this.l);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        androidx.core.h.b bVar = this.f1352e;
        if (bVar == null || !bVar.b()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.A & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.A |= 16;
        } else {
            this.A &= -17;
        }
        this.f1351d.b(false);
        return this;
    }

    public final int getGroupId() {
        return this.f1355h;
    }

    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f1354g;
    }

    public final int getOrder() {
        return this.f1356i;
    }

    public final Intent getIntent() {
        return this.l;
    }

    public final MenuItem setIntent(Intent intent) {
        this.l = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.n;
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.n == c2) {
            return this;
        }
        this.n = Character.toLowerCase(c2);
        this.f1351d.b(false);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.n == c2 && this.f1350c == i2) {
            return this;
        }
        this.n = Character.toLowerCase(c2);
        this.f1350c = KeyEvent.normalizeMetaState(i2);
        this.f1351d.b(false);
        return this;
    }

    public final int getAlphabeticModifiers() {
        return this.f1350c;
    }

    public final char getNumericShortcut() {
        return this.m;
    }

    public final int getNumericModifiers() {
        return this.f1349b;
    }

    public final MenuItem setNumericShortcut(char c2) {
        if (this.m == c2) {
            return this;
        }
        this.m = c2;
        this.f1351d.b(false);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2, int i2) {
        if (this.m == c2 && this.f1349b == i2) {
            return this;
        }
        this.m = c2;
        this.f1349b = KeyEvent.normalizeMetaState(i2);
        this.f1351d.b(false);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.m = c2;
        this.n = Character.toLowerCase(c3);
        this.f1351d.b(false);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.m = c2;
        this.f1349b = KeyEvent.normalizeMetaState(i2);
        this.n = Character.toLowerCase(c3);
        this.f1350c = KeyEvent.normalizeMetaState(i3);
        this.f1351d.b(false);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final char c() {
        return this.f1351d.c() ? this.n : this.m;
    }

    static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return this.f1351d.d() && c() != 0;
    }

    public final SubMenu getSubMenu() {
        return this.q;
    }

    public final boolean hasSubMenu() {
        return this.q != null;
    }

    public final void a(r rVar) {
        this.q = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final CharSequence a(n.a aVar) {
        if (aVar.a()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.j = charSequence;
        this.f1351d.b(false);
        r rVar = this.q;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i2) {
        return setTitle((CharSequence) this.f1351d.f1335a.getString(i2));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.k;
        if (charSequence == null) {
            charSequence = this.j;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.k = charSequence;
        this.f1351d.b(false);
        return this;
    }

    public final Drawable getIcon() {
        Drawable drawable = this.o;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.p == 0) {
            return null;
        }
        Drawable b2 = a.b(this.f1351d.f1335a, this.p);
        this.p = 0;
        this.o = b2;
        return a(b2);
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.p = 0;
        this.o = drawable;
        this.z = true;
        this.f1351d.b(false);
        return this;
    }

    public final MenuItem setIcon(int i2) {
        this.o = null;
        this.p = i2;
        this.z = true;
        this.f1351d.b(false);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.v = colorStateList;
        this.x = true;
        this.z = true;
        this.f1351d.b(false);
        return this;
    }

    public final ColorStateList getIconTintList() {
        return this.v;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.w = mode;
        this.y = true;
        this.z = true;
        this.f1351d.b(false);
        return this;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.w;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.z && (this.x || this.y)) {
            drawable = androidx.core.graphics.drawable.a.f(drawable).mutate();
            if (this.x) {
                androidx.core.graphics.drawable.a.a(drawable, this.v);
            }
            if (this.y) {
                androidx.core.graphics.drawable.a.a(drawable, this.w);
            }
            this.z = false;
        }
        return drawable;
    }

    public final boolean isCheckable() {
        return (this.A & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z2) {
        int i2 = this.A;
        this.A = z2 | (i2 & true) ? 1 : 0;
        if (i2 != this.A) {
            this.f1351d.b(false);
        }
        return this;
    }

    public final void a(boolean z2) {
        this.A = (z2 ? 4 : 0) | (this.A & -5);
    }

    public final boolean e() {
        return (this.A & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.A & 2) == 2;
    }

    public final MenuItem setChecked(boolean z2) {
        if ((this.A & 4) != 0) {
            g gVar = this.f1351d;
            int groupId = getGroupId();
            int size = gVar.f1337c.size();
            gVar.e();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = gVar.f1337c.get(i2);
                if (iVar.getGroupId() == groupId && iVar.e() && iVar.isCheckable()) {
                    iVar.e(iVar == this);
                }
            }
            gVar.f();
        } else {
            e(z2);
        }
        return this;
    }

    private void e(boolean z2) {
        int i2 = this.A;
        this.A = (z2 ? 2 : 0) | (i2 & -3);
        if (i2 != this.A) {
            this.f1351d.b(false);
        }
    }

    public final boolean isVisible() {
        androidx.core.h.b bVar = this.f1352e;
        return (bVar == null || !bVar.d()) ? (this.A & 8) == 0 : (this.A & 8) == 0 && this.f1352e.e();
    }

    /* access modifiers changed from: package-private */
    public final boolean b(boolean z2) {
        int i2 = this.A;
        this.A = (z2 ? 0 : 8) | (i2 & -9);
        if (i2 != this.A) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z2) {
        if (b(z2)) {
            this.f1351d.g();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.s = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.j;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1353f;
    }

    public final boolean f() {
        return (this.A & 32) == 32;
    }

    public final boolean g() {
        return (this.B & 1) == 1;
    }

    public final boolean h() {
        return (this.B & 2) == 2;
    }

    public final void c(boolean z2) {
        if (z2) {
            this.A |= 32;
        } else {
            this.A &= -33;
        }
    }

    public final boolean i() {
        return (this.B & 4) == 4;
    }

    public final void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.B = i2;
            this.f1351d.h();
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public b setActionView(View view) {
        int i2;
        this.C = view;
        this.f1352e = null;
        if (view != null && view.getId() == -1 && (i2 = this.f1354g) > 0) {
            view.setId(i2);
        }
        this.f1351d.h();
        return this;
    }

    public final View getActionView() {
        View view = this.C;
        if (view != null) {
            return view;
        }
        androidx.core.h.b bVar = this.f1352e;
        if (bVar == null) {
            return null;
        }
        this.C = bVar.a((MenuItem) this);
        return this.C;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final androidx.core.h.b a() {
        return this.f1352e;
    }

    public final b a(androidx.core.h.b bVar) {
        androidx.core.h.b bVar2 = this.f1352e;
        if (bVar2 != null) {
            bVar2.f3079e = null;
            bVar2.f3078d = null;
        }
        this.C = null;
        this.f1352e = bVar;
        this.f1351d.b(true);
        androidx.core.h.b bVar3 = this.f1352e;
        if (bVar3 != null) {
            bVar3.a((b.C0048b) new b.C0048b() {
                public final void a() {
                    i.this.f1351d.g();
                }
            });
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.D;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1351d.a(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.B & 8) == 0) {
            return false;
        }
        if (this.C == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.D;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1351d.b(this);
        }
        return false;
    }

    public final boolean j() {
        androidx.core.h.b bVar;
        if ((this.B & 8) != 0) {
            if (this.C == null && (bVar = this.f1352e) != null) {
                this.C = bVar.a((MenuItem) this);
            }
            if (this.C != null) {
                return true;
            }
        }
        return false;
    }

    public final void d(boolean z2) {
        this.E = z2;
        this.f1351d.b(false);
    }

    public final boolean isActionViewExpanded() {
        return this.E;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.D = onActionExpandListener;
        return this;
    }

    /* renamed from: a */
    public final androidx.core.b.a.b setContentDescription(CharSequence charSequence) {
        this.t = charSequence;
        this.f1351d.b(false);
        return this;
    }

    public final CharSequence getContentDescription() {
        return this.t;
    }

    /* renamed from: b */
    public final androidx.core.b.a.b setTooltipText(CharSequence charSequence) {
        this.u = charSequence;
        this.f1351d.b(false);
        return this;
    }

    public final CharSequence getTooltipText() {
        return this.u;
    }

    public final /* synthetic */ MenuItem setActionView(int i2) {
        Context context = this.f1351d.f1335a;
        setActionView(LayoutInflater.from(context).inflate(i2, new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }
}
