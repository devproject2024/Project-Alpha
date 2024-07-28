package d.a.a;

import java.lang.reflect.Method;

final class k {

    /* renamed from: a  reason: collision with root package name */
    final Method f45984a;

    /* renamed from: b  reason: collision with root package name */
    final n f45985b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f45986c;

    /* renamed from: d  reason: collision with root package name */
    String f45987d;

    k(Method method, n nVar, Class<?> cls) {
        this.f45984a = method;
        this.f45985b = nVar;
        this.f45986c = cls;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        a();
        k kVar = (k) obj;
        kVar.a();
        return this.f45987d.equals(kVar.f45987d);
    }

    private synchronized void a() {
        if (this.f45987d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f45984a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f45984a.getName());
            sb.append('(');
            sb.append(this.f45986c.getName());
            this.f45987d = sb.toString();
        }
    }

    public final int hashCode() {
        return this.f45984a.hashCode();
    }
}
