package androidx.dynamicanimation.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.h.u;
import androidx.dynamicanimation.a.a;
import androidx.dynamicanimation.a.b;
import java.util.ArrayList;

public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0199b f14559a = new C0199b("translationX") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getTranslationX();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setTranslationX(f2);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final C0199b f14560b = new C0199b("translationY") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getTranslationY();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setTranslationY(f2);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final C0199b f14561c = new C0199b("translationZ") {
        public final /* synthetic */ float a(Object obj) {
            return u.w((View) obj);
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            u.h((View) obj, f2);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final C0199b f14562d = new C0199b("scaleX") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getScaleX();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setScaleX(f2);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final C0199b f14563e = new C0199b("scaleY") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getScaleY();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setScaleY(f2);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final C0199b f14564f = new C0199b("rotation") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getRotation();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setRotation(f2);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final C0199b f14565g = new C0199b("rotationX") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getRotationX();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setRotationX(f2);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final C0199b f14566h = new C0199b("rotationY") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getRotationY();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setRotationY(f2);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final C0199b f14567i = new C0199b("x") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getX();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setX(f2);
        }
    };
    public static final C0199b j = new C0199b("y") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getY();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setY(f2);
        }
    };
    public static final C0199b k = new C0199b("z") {
        public final /* synthetic */ float a(Object obj) {
            return u.K((View) obj);
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            u.i((View) obj, f2);
        }
    };
    public static final C0199b l = new C0199b("alpha") {
        public final /* synthetic */ float a(Object obj) {
            return ((View) obj).getAlpha();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setAlpha(f2);
        }
    };
    public static final C0199b m = new C0199b("scrollX") {
        public final /* synthetic */ float a(Object obj) {
            return (float) ((View) obj).getScrollX();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setScrollX((int) f2);
        }
    };
    public static final C0199b n = new C0199b("scrollY") {
        public final /* synthetic */ float a(Object obj) {
            return (float) ((View) obj).getScrollY();
        }

        public final /* synthetic */ void a(Object obj, float f2) {
            ((View) obj).setScrollY((int) f2);
        }
    };
    float o = 0.0f;
    float p = Float.MAX_VALUE;
    boolean q = false;
    final Object r;
    final c s;
    boolean t = false;
    float u = Float.MAX_VALUE;
    float v = (-this.u);
    float w;
    private long x = 0;
    private final ArrayList<Object> y = new ArrayList<>();
    private final ArrayList<Object> z = new ArrayList<>();

    /* access modifiers changed from: package-private */
    public abstract boolean b(long j2);

    /* renamed from: androidx.dynamicanimation.a.b$b  reason: collision with other inner class name */
    public static abstract class C0199b extends c<View> {
        /* synthetic */ C0199b(String str, byte b2) {
            this(str);
        }

        private C0199b(String str) {
            super(str);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        float f14568a;

        /* renamed from: b  reason: collision with root package name */
        float f14569b;

        a() {
        }
    }

    <K> b(K k2, c<K> cVar) {
        this.r = k2;
        this.s = cVar;
        c cVar2 = this.s;
        if (cVar2 == f14564f || cVar2 == f14565g || cVar2 == f14566h) {
            this.w = 0.1f;
        } else if (cVar2 == l) {
            this.w = 0.00390625f;
        } else if (cVar2 == f14562d || cVar2 == f14563e) {
            this.w = 0.00390625f;
        } else {
            this.w = 1.0f;
        }
    }

    public final T a() {
        this.o = 300.0f;
        return this;
    }

    private static <T> void a(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            boolean z2 = this.t;
            if (!z2 && !z2) {
                this.t = true;
                if (!this.q) {
                    this.p = this.s.a(this.r);
                }
                float f2 = this.p;
                if (f2 > this.u || f2 < this.v) {
                    throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                }
                a a2 = a.a();
                if (a2.f14545c.size() == 0) {
                    a2.b().a();
                }
                if (!a2.f14545c.contains(this)) {
                    a2.f14545c.add(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public final boolean a(long j2) {
        long j3 = this.x;
        if (j3 == 0) {
            this.x = j2;
            a(this.p);
            return false;
        }
        this.x = j2;
        boolean b2 = b(j2 - j3);
        this.p = Math.min(this.p, this.u);
        this.p = Math.max(this.p, this.v);
        a(this.p);
        if (b2) {
            this.t = false;
            a a2 = a.a();
            a2.f14544b.remove(this);
            int indexOf = a2.f14545c.indexOf(this);
            if (indexOf >= 0) {
                a2.f14545c.set(indexOf, (Object) null);
                a2.f14547e = true;
            }
            this.x = 0;
            this.q = false;
            for (int i2 = 0; i2 < this.y.size(); i2++) {
                if (this.y.get(i2) != null) {
                    this.y.get(i2);
                }
            }
            a(this.y);
        }
        return b2;
    }

    private void a(float f2) {
        this.s.a(this.r, f2);
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            if (this.z.get(i2) != null) {
                this.z.get(i2);
            }
        }
        a(this.z);
    }
}
