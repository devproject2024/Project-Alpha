package androidx.core.h;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3077a;

    /* renamed from: d  reason: collision with root package name */
    public a f3078d;

    /* renamed from: e  reason: collision with root package name */
    public C0048b f3079e;

    public interface a {
        void b(boolean z);
    }

    /* renamed from: androidx.core.h.b$b  reason: collision with other inner class name */
    public interface C0048b {
        void a();
    }

    public abstract View a();

    public void a(SubMenu subMenu) {
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public b(Context context) {
        this.f3077a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public final void a(boolean z) {
        a aVar = this.f3078d;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void a(C0048b bVar) {
        if (this.f3079e != null) {
            StringBuilder sb = new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
        }
        this.f3079e = bVar;
    }
}
