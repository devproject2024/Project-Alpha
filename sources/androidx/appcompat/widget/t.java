package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final g f1796a;

    /* renamed from: b  reason: collision with root package name */
    public final l f1797b;

    /* renamed from: c  reason: collision with root package name */
    public b f1798c;

    /* renamed from: d  reason: collision with root package name */
    public a f1799d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f1800e;

    /* renamed from: f  reason: collision with root package name */
    private final View f1801f;

    public interface a {
        void a();
    }

    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public t(Context context, View view) {
        this(context, view, (byte) 0);
    }

    private t(Context context, View view, byte b2) {
        this(context, view, 0, R.attr.popupMenuStyle);
    }

    public t(Context context, View view, int i2, int i3) {
        this.f1800e = context;
        this.f1801f = view;
        this.f1796a = new g(context);
        this.f1796a.a((g.a) new g.a() {
            public final void a(g gVar) {
            }

            public final boolean a(g gVar, MenuItem menuItem) {
                if (t.this.f1798c != null) {
                    return t.this.f1798c.onMenuItemClick(menuItem);
                }
                return false;
            }
        });
        this.f1797b = new l(context, this.f1796a, view, false, i3, 0);
        l lVar = this.f1797b;
        lVar.f1371b = i2;
        lVar.f1372c = new PopupWindow.OnDismissListener() {
            public final void onDismiss() {
                if (t.this.f1799d != null) {
                    t.this.f1799d.a();
                }
            }
        };
    }

    public final Menu a() {
        return this.f1796a;
    }

    public final MenuInflater b() {
        return new androidx.appcompat.view.g(this.f1800e);
    }

    public final void a(int i2) {
        b().inflate(i2, this.f1796a);
    }

    public final void c() {
        this.f1797b.a();
    }

    public final void a(b bVar) {
        this.f1798c = bVar;
    }
}
