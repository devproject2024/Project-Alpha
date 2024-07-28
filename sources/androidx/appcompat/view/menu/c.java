package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.a.g;
import androidx.core.b.a.b;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f1297a;

    /* renamed from: b  reason: collision with root package name */
    g<b, MenuItem> f1298b;

    /* renamed from: c  reason: collision with root package name */
    g<androidx.core.b.a.c, SubMenu> f1299c;

    c(Context context) {
        this.f1297a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f1298b == null) {
            this.f1298b = new g<>();
        }
        MenuItem menuItem2 = this.f1298b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f1297a, bVar);
        this.f1298b.put(bVar, jVar);
        return jVar;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof androidx.core.b.a.c)) {
            return subMenu;
        }
        androidx.core.b.a.c cVar = (androidx.core.b.a.c) subMenu;
        if (this.f1299c == null) {
            this.f1299c = new g<>();
        }
        SubMenu subMenu2 = this.f1299c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f1297a, cVar);
        this.f1299c.put(cVar, sVar);
        return sVar;
    }
}
