package net.one97.paytm.oauth;

public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f52602a;

    /* renamed from: b  reason: collision with root package name */
    public T f52603b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f52604c;

    /* renamed from: d  reason: collision with root package name */
    public String f52605d;

    private e(int i2, T t, Throwable th, String str) {
        this.f52602a = i2;
        this.f52603b = t;
        this.f52604c = th;
        this.f52605d = str;
    }

    public static <T> e<T> a(T t) {
        return new e<>(101, t, (Throwable) null, (String) null);
    }

    public static <T> e<T> a(T t, String str) {
        return new e<>(101, t, (Throwable) null, str);
    }

    public static <T> e<T> a(T t, Throwable th) {
        return new e<>(102, t, th, (String) null);
    }

    public static <T> e<T> a(T t, Throwable th, String str) {
        return new e<>(102, t, th, str);
    }

    public static <T> e<T> b(T t) {
        return new e<>(104, t, (Throwable) null, (String) null);
    }
}
