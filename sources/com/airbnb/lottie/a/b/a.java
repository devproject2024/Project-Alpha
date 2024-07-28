package com.airbnb.lottie.a.b;

import java.util.ArrayList;
import java.util.List;

public abstract class a<K, A> {

    /* renamed from: a  reason: collision with root package name */
    final List<C0083a> f5749a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    public boolean f5750b = false;

    /* renamed from: c  reason: collision with root package name */
    protected float f5751c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    protected com.airbnb.lottie.g.c<A> f5752d;

    /* renamed from: e  reason: collision with root package name */
    private final c<K> f5753e;

    /* renamed from: f  reason: collision with root package name */
    private A f5754f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f5755g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f5756h = -1.0f;

    /* renamed from: com.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    public interface C0083a {
        void a();
    }

    interface c<T> {
        boolean a();

        boolean a(float f2);

        com.airbnb.lottie.g.a<T> b();

        boolean b(float f2);

        float c();

        float d();
    }

    /* access modifiers changed from: package-private */
    public abstract A a(com.airbnb.lottie.g.a<K> aVar, float f2);

    a(List<? extends com.airbnb.lottie.g.a<K>> list) {
        c<K> cVar;
        if (list.isEmpty()) {
            cVar = new b<>((byte) 0);
        } else if (list.size() == 1) {
            cVar = new e<>(list);
        } else {
            cVar = new d<>(list);
        }
        this.f5753e = cVar;
    }

    public final void a(C0083a aVar) {
        this.f5749a.add(aVar);
    }

    public void a(float f2) {
        if (!this.f5753e.a()) {
            if (f2 < h()) {
                f2 = h();
            } else if (f2 > e()) {
                f2 = e();
            }
            if (f2 != this.f5751c) {
                this.f5751c = f2;
                if (this.f5753e.a(f2)) {
                    a();
                }
            }
        }
    }

    public void a() {
        for (int i2 = 0; i2 < this.f5749a.size(); i2++) {
            this.f5749a.get(i2).a();
        }
    }

    /* access modifiers changed from: protected */
    public final com.airbnb.lottie.g.a<K> b() {
        com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.g.a<K> b2 = this.f5753e.b();
        com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final float c() {
        if (this.f5750b) {
            return 0.0f;
        }
        com.airbnb.lottie.g.a b2 = b();
        if (b2.d()) {
            return 0.0f;
        }
        return (this.f5751c - b2.b()) / (b2.c() - b2.b());
    }

    /* access modifiers changed from: protected */
    public final float d() {
        com.airbnb.lottie.g.a b2 = b();
        if (b2.d()) {
            return 0.0f;
        }
        return b2.f6137d.getInterpolation(c());
    }

    private float h() {
        if (this.f5755g == -1.0f) {
            this.f5755g = this.f5753e.c();
        }
        return this.f5755g;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        if (this.f5756h == -1.0f) {
            this.f5756h = this.f5753e.d();
        }
        return this.f5756h;
    }

    public A f() {
        float d2 = d();
        if (this.f5752d == null && this.f5753e.b(d2)) {
            return this.f5754f;
        }
        A a2 = a(b(), d2);
        this.f5754f = a2;
        return a2;
    }

    public final float g() {
        return this.f5751c;
    }

    public final void a(com.airbnb.lottie.g.c<A> cVar) {
        com.airbnb.lottie.g.c<A> cVar2 = this.f5752d;
        if (cVar2 != null) {
            cVar2.f6151c = null;
        }
        this.f5752d = cVar;
        if (cVar != null) {
            cVar.f6151c = this;
        }
    }

    static final class b<T> implements c<T> {
        public final boolean a() {
            return true;
        }

        public final boolean a(float f2) {
            return false;
        }

        public final float c() {
            return 0.0f;
        }

        public final float d() {
            return 1.0f;
        }

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final com.airbnb.lottie.g.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        public final boolean b(float f2) {
            throw new IllegalStateException("not implemented");
        }
    }

    static final class e<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.airbnb.lottie.g.a<T> f5761a;

        /* renamed from: b  reason: collision with root package name */
        private float f5762b = -1.0f;

        public final boolean a() {
            return false;
        }

        e(List<? extends com.airbnb.lottie.g.a<T>> list) {
            this.f5761a = (com.airbnb.lottie.g.a) list.get(0);
        }

        public final boolean a(float f2) {
            return !this.f5761a.d();
        }

        public final com.airbnb.lottie.g.a<T> b() {
            return this.f5761a;
        }

        public final float c() {
            return this.f5761a.b();
        }

        public final float d() {
            return this.f5761a.c();
        }

        public final boolean b(float f2) {
            if (this.f5762b == f2) {
                return true;
            }
            this.f5762b = f2;
            return false;
        }
    }

    static final class d<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends com.airbnb.lottie.g.a<T>> f5757a;

        /* renamed from: b  reason: collision with root package name */
        private com.airbnb.lottie.g.a<T> f5758b;

        /* renamed from: c  reason: collision with root package name */
        private com.airbnb.lottie.g.a<T> f5759c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f5760d = -1.0f;

        public final boolean a() {
            return false;
        }

        d(List<? extends com.airbnb.lottie.g.a<T>> list) {
            this.f5757a = list;
            this.f5758b = c(0.0f);
        }

        public final boolean a(float f2) {
            if (!this.f5758b.a(f2)) {
                this.f5758b = c(f2);
                return true;
            } else if (!this.f5758b.d()) {
                return true;
            } else {
                return false;
            }
        }

        private com.airbnb.lottie.g.a<T> c(float f2) {
            List<? extends com.airbnb.lottie.g.a<T>> list = this.f5757a;
            com.airbnb.lottie.g.a<T> aVar = (com.airbnb.lottie.g.a) list.get(list.size() - 1);
            if (f2 >= aVar.b()) {
                return aVar;
            }
            for (int size = this.f5757a.size() - 2; size > 0; size--) {
                com.airbnb.lottie.g.a<T> aVar2 = (com.airbnb.lottie.g.a) this.f5757a.get(size);
                if (this.f5758b != aVar2 && aVar2.a(f2)) {
                    return aVar2;
                }
            }
            return (com.airbnb.lottie.g.a) this.f5757a.get(0);
        }

        public final com.airbnb.lottie.g.a<T> b() {
            return this.f5758b;
        }

        public final float c() {
            return ((com.airbnb.lottie.g.a) this.f5757a.get(0)).b();
        }

        public final float d() {
            List<? extends com.airbnb.lottie.g.a<T>> list = this.f5757a;
            return ((com.airbnb.lottie.g.a) list.get(list.size() - 1)).c();
        }

        public final boolean b(float f2) {
            if (this.f5759c == this.f5758b && this.f5760d == f2) {
                return true;
            }
            this.f5759c = this.f5758b;
            this.f5760d = f2;
            return false;
        }
    }
}
