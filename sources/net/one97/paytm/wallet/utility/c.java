package net.one97.paytm.wallet.utility;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f72317a;

    /* renamed from: b  reason: collision with root package name */
    private final T f72318b;

    public c(T t) {
        this.f72318b = t;
    }

    public final T a() {
        if (this.f72317a) {
            return null;
        }
        this.f72317a = true;
        return this.f72318b;
    }
}
