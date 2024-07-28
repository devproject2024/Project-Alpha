package net.one97.paytm.paymentsBank.utils;

public final class g<T> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19508a;

    /* renamed from: b  reason: collision with root package name */
    private final T f19509b;

    public g(T t) {
        this.f19509b = t;
    }

    public final T a() {
        if (this.f19508a) {
            return null;
        }
        this.f19508a = true;
        return this.f19509b;
    }
}
