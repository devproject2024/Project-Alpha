package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.b.a.c;

final class s extends o implements SubMenu {

    /* renamed from: d  reason: collision with root package name */
    private final c f1391d;

    s(Context context, c cVar) {
        super(context, cVar);
        this.f1391d = cVar;
    }

    public final SubMenu setHeaderTitle(int i2) {
        this.f1391d.setHeaderTitle(i2);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1391d.setHeaderTitle(charSequence);
        return this;
    }

    public final SubMenu setHeaderIcon(int i2) {
        this.f1391d.setHeaderIcon(i2);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        this.f1391d.setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        this.f1391d.setHeaderView(view);
        return this;
    }

    public final void clearHeader() {
        this.f1391d.clearHeader();
    }

    public final SubMenu setIcon(int i2) {
        this.f1391d.setIcon(i2);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        this.f1391d.setIcon(drawable);
        return this;
    }

    public final MenuItem getItem() {
        return a(this.f1391d.getItem());
    }
}
