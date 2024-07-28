package com.google.c;

final class al implements bn {

    /* renamed from: b  reason: collision with root package name */
    private static final as f37719b = new as() {
        public final boolean a(Class<?> cls) {
            return false;
        }

        public final ar b(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final as f37720a;

    private al(as asVar) {
        this.f37720a = (as) ac.a(asVar, "messageInfoFactory");
    }

    public final <T> bm<T> a(Class<T> cls) {
        bo.a((Class<?>) cls);
        ar b2 = this.f37720a.b(cls);
        if (b2.b()) {
            if (aa.class.isAssignableFrom(cls)) {
                return ax.a(bo.c(), u.a(), b2.c());
            }
            return ax.a(bo.a(), u.b(), b2.c());
        } else if (aa.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return aw.a(b2, ba.b(), aj.b(), bo.c(), u.a(), aq.b());
            }
            return aw.a(b2, ba.b(), aj.b(), bo.c(), (s<?>) null, aq.b());
        } else if (a(b2)) {
            return aw.a(b2, ba.a(), aj.a(), bo.a(), u.b(), aq.a());
        } else {
            return aw.a(b2, ba.a(), aj.a(), bo.b(), (s<?>) null, aq.a());
        }
    }

    private static boolean a(ar arVar) {
        return arVar.a() == bf.PROTO2;
    }

    static class a implements as {

        /* renamed from: a  reason: collision with root package name */
        private as[] f37721a;

        a(as... asVarArr) {
            this.f37721a = asVarArr;
        }

        public final boolean a(Class<?> cls) {
            for (as a2 : this.f37721a) {
                if (a2.a(cls)) {
                    return true;
                }
            }
            return false;
        }

        public final ar b(Class<?> cls) {
            for (as asVar : this.f37721a) {
                if (asVar.a(cls)) {
                    return asVar.b(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    private static as a() {
        try {
            return (as) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f37719b;
        }
    }

    public al() {
        this(new a(z.a(), a()));
    }
}
