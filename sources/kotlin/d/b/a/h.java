package kotlin.d.b.a;

import java.lang.reflect.Method;

final class h {

    /* renamed from: a  reason: collision with root package name */
    static final a f47898a = new a((Method) null, (Method) null, (Method) null);

    /* renamed from: b  reason: collision with root package name */
    public static a f47899b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f47900c = new h();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f47901a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f47902b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f47903c;

        public a(Method method, Method method2, Method method3) {
            this.f47901a = method;
            this.f47902b = method2;
            this.f47903c = method3;
        }
    }

    private h() {
    }

    static a a(a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f47899b = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f47898a;
            f47899b = aVar3;
            return aVar3;
        }
    }
}
