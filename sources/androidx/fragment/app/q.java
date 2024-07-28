package androidx.fragment.app;

import android.view.View;
import androidx.core.h.u;
import androidx.lifecycle.k;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private final f f3461a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f3462b;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f3463d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    int f3464e;

    /* renamed from: f  reason: collision with root package name */
    int f3465f;

    /* renamed from: g  reason: collision with root package name */
    int f3466g;

    /* renamed from: h  reason: collision with root package name */
    int f3467h;

    /* renamed from: i  reason: collision with root package name */
    int f3468i;
    boolean j;
    boolean k = true;
    String l;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;
    public boolean s = false;
    ArrayList<Runnable> t;

    public abstract int b();

    public abstract int c();

    public abstract void d();

    public abstract void e();

    @Deprecated
    public final q j() {
        return this;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f3469a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f3470b;

        /* renamed from: c  reason: collision with root package name */
        int f3471c;

        /* renamed from: d  reason: collision with root package name */
        int f3472d;

        /* renamed from: e  reason: collision with root package name */
        int f3473e;

        /* renamed from: f  reason: collision with root package name */
        int f3474f;

        /* renamed from: g  reason: collision with root package name */
        k.b f3475g;

        /* renamed from: h  reason: collision with root package name */
        k.b f3476h;

        a() {
        }

        a(int i2, Fragment fragment) {
            this.f3469a = i2;
            this.f3470b = fragment;
            this.f3475g = k.b.RESUMED;
            this.f3476h = k.b.RESUMED;
        }

        a(Fragment fragment, k.b bVar) {
            this.f3469a = 10;
            this.f3470b = fragment;
            this.f3475g = fragment.mMaxState;
            this.f3476h = bVar;
        }
    }

    q(f fVar, ClassLoader classLoader) {
        this.f3461a = fVar;
        this.f3462b = classLoader;
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        this.f3463d.add(aVar);
        aVar.f3471c = this.f3464e;
        aVar.f3472d = this.f3465f;
        aVar.f3473e = this.f3466g;
        aVar.f3474f = this.f3467h;
    }

    public final q a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public final q a(int i2, Fragment fragment) {
        a(i2, fragment, (String) null, 1);
        return this;
    }

    public final q a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i2) {
                fragment.mFragmentId = i2;
                fragment.mContainerId = i2;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
        }
        b(new a(i3, fragment));
    }

    public final q b(int i2, Fragment fragment) {
        return b(i2, fragment, (String) null);
    }

    public final q b(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            a(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public q a(Fragment fragment) {
        b(new a(3, fragment));
        return this;
    }

    public q b(Fragment fragment) {
        b(new a(4, fragment));
        return this;
    }

    public q c(Fragment fragment) {
        b(new a(5, fragment));
        return this;
    }

    public q d(Fragment fragment) {
        b(new a(6, fragment));
        return this;
    }

    public final q f(Fragment fragment) {
        b(new a(7, fragment));
        return this;
    }

    public q e(Fragment fragment) {
        b(new a(8, fragment));
        return this;
    }

    public q a(Fragment fragment, k.b bVar) {
        b(new a(fragment, bVar));
        return this;
    }

    public boolean h() {
        return this.f3463d.isEmpty();
    }

    public final q a(int i2, int i3) {
        return a(i2, i3, 0, 0);
    }

    public final q a(int i2, int i3, int i4, int i5) {
        this.f3464e = i2;
        this.f3465f = i3;
        this.f3466g = i4;
        this.f3467h = i5;
        return this;
    }

    public final q a(View view, String str) {
        if (r.a()) {
            String x = u.x(view);
            if (x != null) {
                if (this.q == null) {
                    this.q = new ArrayList<>();
                    this.r = new ArrayList<>();
                } else if (this.r.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.q.contains(x)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + x + "' has already been added to the transaction.");
                }
                this.q.add(x);
                this.r.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    public final q i() {
        this.f3468i = 4097;
        return this;
    }

    public final q a(String str) {
        if (this.k) {
            this.j = true;
            this.l = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public final q k() {
        if (!this.j) {
            this.k = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public final q l() {
        this.s = true;
        return this;
    }

    public final q a(Runnable runnable) {
        k();
        if (this.t == null) {
            this.t = new ArrayList<>();
        }
        this.t.add(runnable);
        return this;
    }
}
