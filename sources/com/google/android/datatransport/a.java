package com.google.android.datatransport;

public final class a<T> extends c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f7634a = null;

    /* renamed from: b  reason: collision with root package name */
    private final T f7635b;

    /* renamed from: c  reason: collision with root package name */
    private final d f7636c;

    public a(T t, d dVar) {
        if (t != null) {
            this.f7635b = t;
            if (dVar != null) {
                this.f7636c = dVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public final Integer a() {
        return this.f7634a;
    }

    public final T b() {
        return this.f7635b;
    }

    public final d c() {
        return this.f7636c;
    }

    public final String toString() {
        return "Event{code=" + this.f7634a + ", payload=" + this.f7635b + ", priority=" + this.f7636c + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            Integer num = this.f7634a;
            if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
                return this.f7635b.equals(cVar.b()) && this.f7636c.equals(cVar.c());
            }
        }
    }

    public final int hashCode() {
        Integer num = this.f7634a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f7635b.hashCode()) * 1000003) ^ this.f7636c.hashCode();
    }
}
