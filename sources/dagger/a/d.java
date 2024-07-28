package dagger.a;

public final class d<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f46000a = new d<>((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private final T f46001b;

    public static <T> c<T> a(T t) {
        return new d(g.a(t, "instance cannot be null"));
    }

    private d(T t) {
        this.f46001b = t;
    }

    public final T get() {
        return this.f46001b;
    }
}
