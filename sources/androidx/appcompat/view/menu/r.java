package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.g;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class r extends g implements SubMenu {
    public g l;
    private i m;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.l = gVar;
        this.m = iVar;
    }

    public void setQwertyMode(boolean z) {
        this.l.setQwertyMode(z);
    }

    public final boolean c() {
        return this.l.c();
    }

    public final boolean d() {
        return this.l.d();
    }

    public MenuItem getItem() {
        return this.m;
    }

    public final void a(g.a aVar) {
        this.l.a(aVar);
    }

    public final g l() {
        return this.l.l();
    }

    /* access modifiers changed from: package-private */
    public final boolean a(g gVar, MenuItem menuItem) {
        return super.a(gVar, menuItem) || this.l.a(gVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.m.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i2) {
        this.m.setIcon(i2);
        return this;
    }

    public final boolean a(i iVar) {
        return this.l.a(iVar);
    }

    public final boolean b(i iVar) {
        return this.l.b(iVar);
    }

    public final String a() {
        i iVar = this.m;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.a() + AppConstants.COLON + itemId;
    }

    public void setGroupDividerEnabled(boolean z) {
        this.l.setGroupDividerEnabled(z);
    }

    public final boolean b() {
        return this.l.b();
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    public SubMenu setHeaderIcon(int i2) {
        super.a(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        super.a(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }
}
