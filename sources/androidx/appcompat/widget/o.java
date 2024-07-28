package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.core.h.x;

public interface o {
    ViewGroup a();

    x a(int i2, long j);

    void a(int i2);

    void a(Drawable drawable);

    void a(Menu menu, m.a aVar);

    void a(View view);

    void a(Window.Callback callback);

    void a(m.a aVar, g.a aVar2);

    void a(ScrollingTabContainerView scrollingTabContainerView);

    void a(CharSequence charSequence);

    void a(boolean z);

    Context b();

    void b(int i2);

    void b(Drawable drawable);

    void b(CharSequence charSequence);

    void c(int i2);

    void c(Drawable drawable);

    boolean c();

    void d();

    void d(int i2);

    CharSequence e();

    void e(int i2);

    void f(int i2);

    boolean f();

    boolean g();

    boolean h();

    boolean i();

    boolean j();

    void k();

    void l();

    int m();

    int n();

    int o();

    Menu p();
}
