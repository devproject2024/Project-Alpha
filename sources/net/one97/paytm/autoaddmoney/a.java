package net.one97.paytm.autoaddmoney;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f49111a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f49112b;

    public a(T t) {
        this.f49111a = t;
    }

    public final T a() {
        if (this.f49112b) {
            return null;
        }
        this.f49112b = true;
        return this.f49111a;
    }
}
