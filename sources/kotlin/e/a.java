package kotlin.e;

import java.lang.reflect.Method;
import kotlin.g.b.k;
import kotlin.i.b;
import kotlin.i.c;

public class a {

    /* renamed from: kotlin.e.a$a  reason: collision with other inner class name */
    static final class C0837a {

        /* renamed from: a  reason: collision with root package name */
        public static final Method f47909a;

        /* renamed from: b  reason: collision with root package name */
        public static final Method f47910b;

        /* renamed from: c  reason: collision with root package name */
        public static final C0837a f47911c = new C0837a();

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
            if (kotlin.g.b.k.a((java.lang.Object) r8.length == 1 ? r8[0] : null, (java.lang.Object) r0) != false) goto L_0x004c;
         */
        static {
            /*
                kotlin.e.a$a r0 = new kotlin.e.a$a
                r0.<init>()
                f47911c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.g.b.k.b(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0016:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L_0x0052
                r7 = r1[r4]
                kotlin.g.b.k.b(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r9)
                r9 = 1
                if (r8 == 0) goto L_0x004b
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r10 = "it.parameterTypes"
                kotlin.g.b.k.b(r8, r10)
                java.lang.String r10 = "$this$singleOrNull"
                kotlin.g.b.k.d(r8, r10)
                int r10 = r8.length
                if (r10 != r9) goto L_0x0041
                r8 = r8[r3]
                goto L_0x0042
            L_0x0041:
                r8 = r6
            L_0x0042:
                java.lang.Class r8 = (java.lang.Class) r8
                boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r0)
                if (r8 == 0) goto L_0x004b
                goto L_0x004c
            L_0x004b:
                r9 = 0
            L_0x004c:
                if (r9 == 0) goto L_0x004f
                goto L_0x0053
            L_0x004f:
                int r4 = r4 + 1
                goto L_0x0016
            L_0x0052:
                r7 = r6
            L_0x0053:
                f47909a = r7
                int r0 = r1.length
            L_0x0056:
                if (r3 >= r0) goto L_0x006d
                r2 = r1[r3]
                kotlin.g.b.k.b(r2, r5)
                java.lang.String r4 = r2.getName()
                java.lang.String r7 = "getSuppressed"
                boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r7)
                if (r4 == 0) goto L_0x006a
                goto L_0x006e
            L_0x006a:
                int r3 = r3 + 1
                goto L_0x0056
            L_0x006d:
                r2 = r6
            L_0x006e:
                f47910b = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.e.a.C0837a.<clinit>():void");
        }

        private C0837a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        k.d(th, "cause");
        k.d(th2, "exception");
        Method method = C0837a.f47909a;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    public c a() {
        return new b();
    }
}
