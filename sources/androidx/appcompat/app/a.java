package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.b;
import androidx.appcompat.b.a.d;
import androidx.drawerlayout.widget.DrawerLayout;
import net.one97.paytm.paytm_finance.R;

public class a implements DrawerLayout.c {

    /* renamed from: a  reason: collision with root package name */
    public final DrawerLayout f1079a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f1080b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1081c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1082d;

    /* renamed from: e  reason: collision with root package name */
    private final C0021a f1083e;

    /* renamed from: f  reason: collision with root package name */
    private d f1084f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1085g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1086h;

    /* renamed from: i  reason: collision with root package name */
    private final int f1087i;
    private boolean j;

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    public interface C0021a {
        Drawable a();

        void a(int i2);

        void a(Drawable drawable, int i2);

        Context b();

        boolean c();
    }

    public interface b {
        C0021a getDrawerToggleDelegate();
    }

    public a(Activity activity, DrawerLayout drawerLayout, int i2, int i3) {
        this(activity, drawerLayout, i2, i3, (byte) 0);
    }

    private a(Activity activity, DrawerLayout drawerLayout, int i2, int i3, byte b2) {
        this.f1085g = true;
        this.f1081c = true;
        this.j = false;
        if (activity instanceof b) {
            this.f1083e = ((b) activity).getDrawerToggleDelegate();
        } else {
            this.f1083e = new c(activity);
        }
        this.f1079a = drawerLayout;
        this.f1086h = i2;
        this.f1087i = i3;
        this.f1084f = new d(this.f1083e.b());
        this.f1080b = d();
    }

    public final void a() {
        if (this.f1079a.e(8388611)) {
            b(1.0f);
        } else {
            b(0.0f);
        }
        if (this.f1081c) {
            a(this.f1084f, this.f1079a.e(8388611) ? this.f1087i : this.f1086h);
        }
    }

    public final void b() {
        Drawable drawable = this.f1079a.getResources().getDrawable(R.drawable.fake_home_up_enabled);
        if (drawable == null) {
            this.f1080b = d();
            this.f1082d = false;
        } else {
            this.f1080b = drawable;
            this.f1082d = true;
        }
        if (!this.f1081c) {
            a(this.f1080b, 0);
        }
    }

    public final void c() {
        if (this.f1081c) {
            a(this.f1080b, 0);
            this.f1081c = false;
        }
    }

    public final void a(float f2) {
        if (this.f1085g) {
            b(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            b(0.0f);
        }
    }

    public void onDrawerOpened(View view) {
        b(1.0f);
        if (this.f1081c) {
            a(this.f1087i);
        }
    }

    public void onDrawerClosed(View view) {
        b(0.0f);
        if (this.f1081c) {
            a(this.f1086h);
        }
    }

    private void a(Drawable drawable, int i2) {
        if (!this.j && !this.f1083e.c()) {
            this.j = true;
        }
        this.f1083e.a(drawable, i2);
    }

    private void a(int i2) {
        this.f1083e.a(i2);
    }

    public final Drawable d() {
        return this.f1083e.a();
    }

    private void b(float f2) {
        if (f2 == 1.0f) {
            this.f1084f.a(true);
        } else if (f2 == 0.0f) {
            this.f1084f.a(false);
        }
        this.f1084f.setProgress(f2);
    }

    static class c implements C0021a {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f1088a;

        /* renamed from: b  reason: collision with root package name */
        private b.a f1089b;

        c(Activity activity) {
            this.f1088a = activity;
        }

        public final Drawable a() {
            if (Build.VERSION.SDK_INT < 18) {
                return b.a(this.f1088a);
            }
            TypedArray obtainStyledAttributes = b().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public final Context b() {
            ActionBar actionBar = this.f1088a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f1088a;
        }

        public final boolean c() {
            ActionBar actionBar = this.f1088a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public final void a(Drawable drawable, int i2) {
            ActionBar actionBar = this.f1088a.getActionBar();
            if (actionBar == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i2);
                return;
            }
            actionBar.setDisplayShowHomeEnabled(true);
            this.f1089b = b.a(this.f1088a, drawable, i2);
            actionBar.setDisplayShowHomeEnabled(false);
        }

        public final void a(int i2) {
            if (Build.VERSION.SDK_INT >= 18) {
                ActionBar actionBar = this.f1088a.getActionBar();
                if (actionBar != null) {
                    actionBar.setHomeActionContentDescription(i2);
                    return;
                }
                return;
            }
            this.f1089b = b.a(this.f1089b, this.f1088a, i2);
        }
    }
}
