package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.i;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.o;
import androidx.core.h.u;
import java.util.ArrayList;

final class j extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    o f1118a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1119b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f1120c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1121d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1122e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Object> f1123f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f1124g = new Runnable() {
        public final void run() {
            j jVar = j.this;
            Menu n = jVar.n();
            g gVar = n instanceof g ? (g) n : null;
            if (gVar != null) {
                gVar.e();
            }
            try {
                n.clear();
                if (!jVar.f1120c.onCreatePanelMenu(0, n) || !jVar.f1120c.onPreparePanel(0, (View) null, n)) {
                    n.clear();
                }
            } finally {
                if (gVar != null) {
                    gVar.f();
                }
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final Toolbar.b f1125h = new Toolbar.b() {
        public final boolean a(MenuItem menuItem) {
            return j.this.f1120c.onMenuItemSelected(0, menuItem);
        }
    };

    public final void d(boolean z) {
    }

    public final void e(boolean z) {
    }

    j(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f1118a = new ad(toolbar, false);
        this.f1120c = new c(callback);
        this.f1118a.a(this.f1120c);
        toolbar.setOnMenuItemClickListener(this.f1125h);
        this.f1118a.a(charSequence);
    }

    public final void a(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f1118a.a(view);
    }

    public final void a(int i2) {
        a(LayoutInflater.from(this.f1118a.b()).inflate(i2, this.f1118a.a(), false), new ActionBar.LayoutParams(-2, -2));
    }

    public final void b(int i2) {
        this.f1118a.a(i2);
    }

    public final void c(int i2) {
        this.f1118a.b(i2);
    }

    public final void a(float f2) {
        u.g((View) this.f1118a.a(), f2);
    }

    public final Context g() {
        return this.f1118a.b();
    }

    public final void b(Drawable drawable) {
        this.f1118a.b(drawable);
    }

    public final void e(int i2) {
        this.f1118a.d(i2);
    }

    public final void f(int i2) {
        this.f1118a.e(i2);
    }

    public final void a(Configuration configuration) {
        super.a(configuration);
    }

    public final void a(CharSequence charSequence) {
        this.f1118a.b(charSequence);
    }

    public final void d(int i2) {
        o oVar = this.f1118a;
        oVar.b(i2 != 0 ? oVar.b().getText(i2) : null);
    }

    public final void b(CharSequence charSequence) {
        this.f1118a.a(charSequence);
    }

    public final void a() {
        a(16, -1);
    }

    private void a(int i2, int i3) {
        this.f1118a.c((i2 & i3) | ((~i3) & this.f1118a.m()));
    }

    public final void a(boolean z) {
        a(z ? 2 : 0, 2);
    }

    public final void b(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public final void c(boolean z) {
        a(z ? 8 : 0, 8);
    }

    public final void b() {
        a(16, 16);
    }

    public final void a(Drawable drawable) {
        this.f1118a.c(drawable);
    }

    public final int c() {
        return this.f1118a.m();
    }

    public final int d() {
        return this.f1118a.o();
    }

    public final void e() {
        this.f1118a.f(0);
    }

    public final void f() {
        this.f1118a.f(8);
    }

    public final boolean i() {
        return this.f1118a.i();
    }

    public final boolean j() {
        return this.f1118a.j();
    }

    public final boolean k() {
        this.f1118a.a().removeCallbacks(this.f1124g);
        u.a((View) this.f1118a.a(), this.f1124g);
        return true;
    }

    public final boolean l() {
        if (!this.f1118a.c()) {
            return false;
        }
        this.f1118a.d();
        return true;
    }

    public final boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            i();
        }
        return true;
    }

    public final boolean a(int i2, KeyEvent keyEvent) {
        Menu n = n();
        if (n == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        n.setQwertyMode(z);
        return n.performShortcut(i2, keyEvent, 0);
    }

    /* access modifiers changed from: package-private */
    public final void m() {
        this.f1118a.a().removeCallbacks(this.f1124g);
    }

    public final void f(boolean z) {
        if (z != this.f1122e) {
            this.f1122e = z;
            int size = this.f1123f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1123f.get(i2);
            }
        }
    }

    class c extends i {
        public c(Window.Callback callback) {
            super(callback);
        }

        public final boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (onPreparePanel && !j.this.f1119b) {
                j.this.f1118a.k();
                j.this.f1119b = true;
            }
            return onPreparePanel;
        }

        public final View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(j.this.f1118a.b());
            }
            return super.onCreatePanelView(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final Menu n() {
        if (!this.f1121d) {
            this.f1118a.a((m.a) new a(), (g.a) new b());
            this.f1121d = true;
        }
        return this.f1118a.p();
    }

    final class a implements m.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1129b;

        a() {
        }

        public final boolean a(g gVar) {
            if (j.this.f1120c == null) {
                return false;
            }
            j.this.f1120c.onMenuOpened(108, gVar);
            return true;
        }

        public final void a(g gVar, boolean z) {
            if (!this.f1129b) {
                this.f1129b = true;
                j.this.f1118a.l();
                if (j.this.f1120c != null) {
                    j.this.f1120c.onPanelClosed(108, gVar);
                }
                this.f1129b = false;
            }
        }
    }

    final class b implements g.a {
        public final boolean a(g gVar, MenuItem menuItem) {
            return false;
        }

        b() {
        }

        public final void a(g gVar) {
            if (j.this.f1120c == null) {
                return;
            }
            if (j.this.f1118a.g()) {
                j.this.f1120c.onPanelClosed(108, gVar);
            } else if (j.this.f1120c.onPreparePanel(0, (View) null, gVar)) {
                j.this.f1120c.onMenuOpened(108, gVar);
            }
        }
    }
}
