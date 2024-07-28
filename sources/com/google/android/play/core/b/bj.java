package com.google.android.play.core.b;

public final class bj<T> implements bh, bl {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f37288a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile bl<T> f37289b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f37290c = f37288a;

    private bj(bl<T> blVar) {
        this.f37289b = blVar;
    }

    public static <P extends bl<T>, T> bl<T> a(P p) {
        return !(p instanceof bj) ? new bj(p) : p;
    }

    public static <P extends bl<T>, T> bh<T> b(P p) {
        return p instanceof bh ? (bh) p : new bj(p);
    }

    public final T a() {
        T t = this.f37290c;
        if (t == f37288a) {
            synchronized (this) {
                t = this.f37290c;
                if (t == f37288a) {
                    t = this.f37289b.a();
                    T t2 = this.f37290c;
                    if (t2 == f37288a || (t2 instanceof bk) || t2 == t) {
                        this.f37290c = t;
                        this.f37289b = null;
                    } else {
                        String valueOf = String.valueOf(t2);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
        }
        return t;
    }
}
