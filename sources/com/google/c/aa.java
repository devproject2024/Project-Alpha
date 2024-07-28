package com.google.c;

import com.google.c.a;
import com.google.c.aa;
import com.google.c.aa.a;
import com.google.c.ac;
import com.google.c.at;
import com.google.c.bz;
import com.google.c.e;
import com.google.c.w;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class aa<MessageType extends aa<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Object, aa<?, ?>> f37679a = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    protected bu f37680e = bu.a();

    /* renamed from: f  reason: collision with root package name */
    protected int f37681f = -1;

    public interface d extends au {
    }

    public static class f<ContainingType extends at, Type> extends p<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final at f37692a;

        /* renamed from: b  reason: collision with root package name */
        final e f37693b;
    }

    public enum g {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* access modifiers changed from: protected */
    public abstract Object a(g gVar);

    public final bd<MessageType> f() {
        return (bd) a(g.GET_PARSER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MessageType o() {
        return (aa) a(g.GET_DEFAULT_INSTANCE);
    }

    /* renamed from: g */
    public final BuilderType n() {
        return (a) a(g.NEW_BUILDER);
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        av.a(this, sb, 0);
        return sb.toString();
    }

    public int hashCode() {
        if (this.f37678d != 0) {
            return this.f37678d;
        }
        this.f37678d = bg.a().a(this).a(this);
        return this.f37678d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!o().getClass().isInstance(obj)) {
            return false;
        }
        return bg.a().a(this).a(this, (aa) obj);
    }

    /* access modifiers changed from: protected */
    public final void h() {
        bg.a().a(this).d(this);
    }

    public final boolean i() {
        return a(this, true);
    }

    /* access modifiers changed from: protected */
    public final Object b(g gVar) {
        return a(gVar);
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f37681f;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f37681f = i2;
    }

    public final void a(m mVar) throws IOException {
        n nVar;
        bm a2 = bg.a().a(this);
        if (mVar.f37892b != null) {
            nVar = mVar.f37892b;
        } else {
            nVar = new n(mVar);
        }
        a2.a(this, (ca) nVar);
    }

    public final int j() {
        if (this.f37681f == -1) {
            this.f37681f = bg.a().a(this).b(this);
        }
        return this.f37681f;
    }

    /* access modifiers changed from: package-private */
    public final Object k() throws Exception {
        return a(g.BUILD_MESSAGE_INFO);
    }

    static <T extends aa<?, ?>> T a(Class<T> cls) {
        T t = (aa) f37679a.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (aa) f37679a.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = ((aa) bx.a(cls)).o();
            if (t != null) {
                f37679a.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <T extends aa<?, ?>> void a(Class<T> cls, T t) {
        f37679a.put(cls, t);
    }

    protected static Object a(at atVar, String str, Object[] objArr) {
        return new bj(atVar, str, objArr);
    }

    public static abstract class a<MessageType extends aa<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.C0622a<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f37682a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f37683b = false;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f37684c;

        protected a(MessageType messagetype) {
            this.f37684c = messagetype;
            this.f37682a = (aa) messagetype.b(g.NEW_MUTABLE_INSTANCE);
        }

        private void d() {
            if (this.f37683b) {
                MessageType messagetype = (aa) this.f37682a.b(g.NEW_MUTABLE_INSTANCE);
                a(messagetype, this.f37682a);
                this.f37682a = messagetype;
                this.f37683b = false;
            }
        }

        public final boolean i() {
            return aa.a(this.f37682a, false);
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public MessageType b() {
            if (this.f37683b) {
                return this.f37682a;
            }
            this.f37682a.h();
            this.f37683b = true;
            return this.f37682a;
        }

        public final BuilderType a(MessageType messagetype) {
            d();
            a(this.f37682a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            bg.a().a(messagetype).b(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public BuilderType clone() {
            BuilderType g2 = this.f37684c.n();
            g2.a(b());
            return g2;
        }

        public final /* synthetic */ at c() {
            aa f2 = b();
            if (f2.i()) {
                return f2;
            }
            throw new bs((at) f2);
        }

        public final /* bridge */ /* synthetic */ at o() {
            return this.f37684c;
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends aa<MessageType, BuilderType> implements d<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected w<e> f37686a = w.a();

        /* access modifiers changed from: package-private */
        public final w<e> a() {
            if (this.f37686a.f37926b) {
                this.f37686a = this.f37686a.clone();
            }
            return this.f37686a;
        }
    }

    static final class e implements w.a<e> {

        /* renamed from: a  reason: collision with root package name */
        final ac.d<?> f37687a;

        /* renamed from: b  reason: collision with root package name */
        final int f37688b;

        /* renamed from: c  reason: collision with root package name */
        final bz.a f37689c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f37690d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f37691e;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f37688b - ((e) obj).f37688b;
        }

        public final int a() {
            return this.f37688b;
        }

        public final bz.a b() {
            return this.f37689c;
        }

        public final bz.b c() {
            return this.f37689c.getJavaType();
        }

        public final boolean d() {
            return this.f37690d;
        }

        public final boolean e() {
            return this.f37691e;
        }

        public final at.a a(at.a aVar, at atVar) {
            return ((a) aVar).a((aa) atVar);
        }
    }

    static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends aa<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(g.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean e2 = bg.a().a(t).e(t);
        if (z) {
            t.a(g.SET_MEMOIZED_IS_INITIALIZED);
        }
        return e2;
    }

    protected static <E> ac.i<E> l() {
        return bh.d();
    }

    public static class b<T extends aa<T, ?>> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f37685a;

        public b(T t) {
            this.f37685a = t;
        }

        public final /* bridge */ /* synthetic */ Object a(k kVar, r rVar) throws ad {
            return aa.a(this.f37685a, kVar, rVar);
        }
    }

    static <T extends aa<T, ?>> T a(T t, k kVar, r rVar) throws ad {
        l lVar;
        T t2 = (aa) t.a(g.NEW_MUTABLE_INSTANCE);
        try {
            bm a2 = bg.a().a(t2);
            if (kVar.f37868d != null) {
                lVar = kVar.f37868d;
            } else {
                lVar = new l(kVar);
            }
            a2.a(t2, lVar, rVar);
            a2.d(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof ad) {
                throw ((ad) e2.getCause());
            }
            throw new ad(e2.getMessage()).setUnfinishedMessage(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof ad) {
                throw ((ad) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends aa<T, ?>> T a(T t, byte[] bArr, int i2, r rVar) throws ad {
        T t2 = (aa) t.a(g.NEW_MUTABLE_INSTANCE);
        try {
            bm a2 = bg.a().a(t2);
            a2.a(t2, bArr, 0, i2 + 0, new e.a(rVar));
            a2.d(t2);
            if (t2.f37678d == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof ad) {
                throw ((ad) e2.getCause());
            }
            throw new ad(e2.getMessage()).setUnfinishedMessage(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw ad.truncatedMessage().setUnfinishedMessage(t2);
        }
    }

    public static <T extends aa<T, ?>> T a(T t, byte[] bArr) throws ad {
        return a(a(t, bArr, bArr.length, r.a()));
    }

    public static <T extends aa<T, ?>> T a(T t, InputStream inputStream) throws ad {
        return a(a(t, k.a(inputStream), r.a()));
    }

    private static <T extends aa<T, ?>> T a(T t) throws ad {
        if (t == null || a(t, true)) {
            return t;
        }
        throw t.e().asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    public final /* synthetic */ at.a m() {
        a aVar = (a) a(g.NEW_BUILDER);
        aVar.a(this);
        return aVar;
    }
}
