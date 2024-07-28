package androidx.core.h;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    public static final ab f3060a = new a().f3062a.a().f3061b.f().f3061b.d().f3061b.c();

    /* renamed from: b  reason: collision with root package name */
    public final e f3061b;

    private ab(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3061b = new i(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.f3061b = new h(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f3061b = new g(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f3061b = new f(this, windowInsets);
        } else {
            this.f3061b = new e(this);
        }
    }

    public ab() {
        this.f3061b = new e(this);
    }

    public static ab a(WindowInsets windowInsets) {
        return new ab((WindowInsets) androidx.core.g.f.a(windowInsets));
    }

    @Deprecated
    public final ab a(int i2, int i3, int i4, int i5) {
        return new a(this).a(androidx.core.graphics.b.a(i2, i3, i4, i5)).f3062a.a();
    }

    public final ab b(int i2, int i3, int i4, int i5) {
        return this.f3061b.a(i2, i3, i4, i5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        return androidx.core.g.c.a(this.f3061b, ((ab) obj).f3061b);
    }

    public final int hashCode() {
        e eVar = this.f3061b;
        if (eVar == null) {
            return 0;
        }
        return eVar.hashCode();
    }

    public final WindowInsets e() {
        e eVar = this.f3061b;
        if (eVar instanceof f) {
            return ((f) eVar).f3071b;
        }
        return null;
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        final ab f3070a;

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public c e() {
            return null;
        }

        e(ab abVar) {
            this.f3070a = abVar;
        }

        public ab c() {
            return this.f3070a;
        }

        public ab d() {
            return this.f3070a;
        }

        public ab f() {
            return this.f3070a;
        }

        public androidx.core.graphics.b g() {
            return androidx.core.graphics.b.f2972a;
        }

        /* access modifiers changed from: package-private */
        public androidx.core.graphics.b h() {
            return androidx.core.graphics.b.f2972a;
        }

        public androidx.core.graphics.b i() {
            return g();
        }

        /* access modifiers changed from: package-private */
        public ab a(int i2, int i3, int i4, int i5) {
            return ab.f3060a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return a() == eVar.a() && b() == eVar.b() && androidx.core.g.c.a(g(), eVar.g()) && androidx.core.g.c.a(h(), eVar.h()) && androidx.core.g.c.a(e(), eVar.e());
        }

        public int hashCode() {
            return androidx.core.g.c.a(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }
    }

    static class f extends e {

        /* renamed from: b  reason: collision with root package name */
        final WindowInsets f3071b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.core.graphics.b f3072c = null;

        f(ab abVar, WindowInsets windowInsets) {
            super(abVar);
            this.f3071b = windowInsets;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f3071b.isRound();
        }

        /* access modifiers changed from: package-private */
        public final androidx.core.graphics.b g() {
            if (this.f3072c == null) {
                this.f3072c = androidx.core.graphics.b.a(this.f3071b.getSystemWindowInsetLeft(), this.f3071b.getSystemWindowInsetTop(), this.f3071b.getSystemWindowInsetRight(), this.f3071b.getSystemWindowInsetBottom());
            }
            return this.f3072c;
        }

        /* access modifiers changed from: package-private */
        public ab a(int i2, int i3, int i4, int i5) {
            a aVar = new a(ab.a(this.f3071b));
            aVar.a(ab.a(g(), i2, i3, i4, i5));
            aVar.f3062a.b(ab.a(h(), i2, i3, i4, i5));
            return aVar.f3062a.a();
        }
    }

    static class g extends f {

        /* renamed from: c  reason: collision with root package name */
        private androidx.core.graphics.b f3073c = null;

        g(ab abVar, WindowInsets windowInsets) {
            super(abVar, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f3071b.isConsumed();
        }

        /* access modifiers changed from: package-private */
        public ab d() {
            return ab.a(this.f3071b.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        public ab c() {
            return ab.a(this.f3071b.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        public final androidx.core.graphics.b h() {
            if (this.f3073c == null) {
                this.f3073c = androidx.core.graphics.b.a(this.f3071b.getStableInsetLeft(), this.f3071b.getStableInsetTop(), this.f3071b.getStableInsetRight(), this.f3071b.getStableInsetBottom());
            }
            return this.f3073c;
        }
    }

    static class h extends g {
        h(ab abVar, WindowInsets windowInsets) {
            super(abVar, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public c e() {
            DisplayCutout displayCutout = this.f3071b.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new c(displayCutout);
        }

        /* access modifiers changed from: package-private */
        public ab f() {
            return ab.a(this.f3071b.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            return Objects.equals(this.f3071b, ((h) obj).f3071b);
        }

        public int hashCode() {
            return this.f3071b.hashCode();
        }
    }

    static class i extends h {

        /* renamed from: c  reason: collision with root package name */
        private androidx.core.graphics.b f3074c = null;

        /* renamed from: d  reason: collision with root package name */
        private androidx.core.graphics.b f3075d = null;

        /* renamed from: e  reason: collision with root package name */
        private androidx.core.graphics.b f3076e = null;

        i(ab abVar, WindowInsets windowInsets) {
            super(abVar, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public final androidx.core.graphics.b i() {
            if (this.f3075d == null) {
                this.f3075d = androidx.core.graphics.b.a(this.f3071b.getMandatorySystemGestureInsets());
            }
            return this.f3075d;
        }

        /* access modifiers changed from: package-private */
        public final ab a(int i2, int i3, int i4, int i5) {
            return ab.a(this.f3071b.inset(i2, i3, i4, i5));
        }
    }

    static androidx.core.graphics.b a(androidx.core.graphics.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.f2973b - i2);
        int max2 = Math.max(0, bVar.f2974c - i3);
        int max3 = Math.max(0, bVar.f2975d - i4);
        int max4 = Math.max(0, bVar.f2976e - i5);
        if (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) {
            return bVar;
        }
        return androidx.core.graphics.b.a(max, max2, max3, max4);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f3062a;

        public a() {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3062a = new d();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f3062a = new c();
            } else {
                this.f3062a = new b();
            }
        }

        public a(ab abVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3062a = new d(abVar);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f3062a = new c(abVar);
            } else {
                this.f3062a = new b(abVar);
            }
        }

        public final a a(androidx.core.graphics.b bVar) {
            this.f3062a.a(bVar);
            return this;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final ab f3063a;

        /* access modifiers changed from: package-private */
        public void a(androidx.core.graphics.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void b(androidx.core.graphics.b bVar) {
        }

        b() {
            this(new ab());
        }

        b(ab abVar) {
            this.f3063a = abVar;
        }

        public ab a() {
            return this.f3063a;
        }
    }

    static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private static Field f3064a = null;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f3065b = false;

        /* renamed from: c  reason: collision with root package name */
        private static Constructor<WindowInsets> f3066c = null;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f3067d = false;

        /* renamed from: e  reason: collision with root package name */
        private WindowInsets f3068e;

        c() {
            this.f3068e = b();
        }

        c(ab abVar) {
            this.f3068e = abVar.e();
        }

        /* access modifiers changed from: package-private */
        public final void a(androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f3068e;
            if (windowInsets != null) {
                this.f3068e = windowInsets.replaceSystemWindowInsets(bVar.f2973b, bVar.f2974c, bVar.f2975d, bVar.f2976e);
            }
        }

        /* access modifiers changed from: package-private */
        public final ab a() {
            return ab.a(this.f3068e);
        }

        private static WindowInsets b() {
            if (!f3065b) {
                try {
                    f3064a = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f3065b = true;
            }
            Field field = f3064a;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f3067d) {
                try {
                    f3066c = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException unused3) {
                }
                f3067d = true;
            }
            Constructor<WindowInsets> constructor = f3066c;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }
    }

    static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsets.Builder f3069a;

        d() {
            this.f3069a = new WindowInsets.Builder();
        }

        d(ab abVar) {
            WindowInsets.Builder builder;
            WindowInsets e2 = abVar.e();
            if (e2 != null) {
                builder = new WindowInsets.Builder(e2);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f3069a = builder;
        }

        /* access modifiers changed from: package-private */
        public final void a(androidx.core.graphics.b bVar) {
            this.f3069a.setSystemWindowInsets(bVar.a());
        }

        /* access modifiers changed from: package-private */
        public final void b(androidx.core.graphics.b bVar) {
            this.f3069a.setStableInsets(bVar.a());
        }

        /* access modifiers changed from: package-private */
        public final ab a() {
            return ab.a(this.f3069a.build());
        }
    }

    public final int a() {
        return this.f3061b.g().f2973b;
    }

    public final int b() {
        return this.f3061b.g().f2974c;
    }

    public final int c() {
        return this.f3061b.g().f2975d;
    }

    public final int d() {
        return this.f3061b.g().f2976e;
    }
}
