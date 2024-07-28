package com.bumptech.glide.g;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f6621a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f6622b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f6623c;

    public i() {
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public final void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f6621a = cls;
        this.f6622b = cls2;
        this.f6623c = cls3;
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f6621a + ", second=" + this.f6622b + '}';
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f6621a.equals(iVar.f6621a) && this.f6622b.equals(iVar.f6622b) && k.a((Object) this.f6623c, (Object) iVar.f6623c);
    }

    public final int hashCode() {
        int hashCode = ((this.f6621a.hashCode() * 31) + this.f6622b.hashCode()) * 31;
        Class<?> cls = this.f6623c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }
}
