package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.a.g;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;

public final class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f1224a;

    /* renamed from: b  reason: collision with root package name */
    final b f1225b;

    public f(Context context, b bVar) {
        this.f1224a = context;
        this.f1225b = bVar;
    }

    public final Object getTag() {
        return this.f1225b.f1210c;
    }

    public final void setTag(Object obj) {
        this.f1225b.f1210c = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f1225b.b(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.f1225b.a(charSequence);
    }

    public final void invalidate() {
        this.f1225b.d();
    }

    public final void finish() {
        this.f1225b.c();
    }

    public final Menu getMenu() {
        return new o(this.f1224a, (androidx.core.b.a.a) this.f1225b.b());
    }

    public final CharSequence getTitle() {
        return this.f1225b.f();
    }

    public final void setTitle(int i2) {
        this.f1225b.a(i2);
    }

    public final CharSequence getSubtitle() {
        return this.f1225b.g();
    }

    public final void setSubtitle(int i2) {
        this.f1225b.b(i2);
    }

    public final View getCustomView() {
        return this.f1225b.i();
    }

    public final void setCustomView(View view) {
        this.f1225b.a(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.f1225b.a();
    }

    public final boolean getTitleOptionalHint() {
        return this.f1225b.f1211d;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.f1225b.a(z);
    }

    public final boolean isTitleOptional() {
        return this.f1225b.h();
    }

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f1226a;

        /* renamed from: b  reason: collision with root package name */
        final Context f1227b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f1228c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f1229d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f1227b = context;
            this.f1226a = callback;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.f1226a.onCreateActionMode(b(bVar), a(menu));
        }

        public final boolean b(b bVar, Menu menu) {
            return this.f1226a.onPrepareActionMode(b(bVar), a(menu));
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.f1226a.onActionItemClicked(b(bVar), new j(this.f1227b, (androidx.core.b.a.b) menuItem));
        }

        public final void a(b bVar) {
            this.f1226a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f1229d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f1227b, (androidx.core.b.a.a) menu);
            this.f1229d.put(menu, oVar);
            return oVar;
        }

        public final ActionMode b(b bVar) {
            int size = this.f1228c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.f1228c.get(i2);
                if (fVar != null && fVar.f1225b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f1227b, bVar);
            this.f1228c.add(fVar2);
            return fVar2;
        }
    }
}
