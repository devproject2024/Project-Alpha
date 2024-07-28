package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.a.b;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ah;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static int f1097a = -100;

    /* renamed from: b  reason: collision with root package name */
    static final b<WeakReference<e>> f1098b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    static final Object f1099c = new Object();

    public Context a(Context context) {
        return context;
    }

    public abstract ActionBar a();

    public abstract androidx.appcompat.view.b a(b.a aVar);

    public void a(int i2) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract <T extends View> T b(int i2);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(int i2);

    public abstract void d();

    public abstract boolean d(int i2);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract a.C0021a j();

    public abstract void k();

    public int l() {
        return -100;
    }

    public static e a(Activity activity, d dVar) {
        return new AppCompatDelegateImpl(activity, dVar);
    }

    public static e a(Dialog dialog, d dVar) {
        return new AppCompatDelegateImpl(dialog, dVar);
    }

    e() {
    }

    public static void m() {
        ah.b();
    }

    static void a(e eVar) {
        synchronized (f1099c) {
            Iterator<WeakReference<e>> it2 = f1098b.iterator();
            while (it2.hasNext()) {
                e eVar2 = (e) it2.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it2.remove();
                }
            }
        }
    }
}
