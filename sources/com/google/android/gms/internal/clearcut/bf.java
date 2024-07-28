package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;
import com.google.android.gms.internal.clearcut.bf.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class bf<MessageType extends bf<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends r<MessageType, BuilderType> {
    private static Map<Object, bf<?, ?>> zzjr = new ConcurrentHashMap();
    protected dw zzjp = dw.a();
    private int zzjq = -1;

    public static abstract class a<MessageType extends bf<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends s<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f9183a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f9184b = false;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f9185c;

        protected a(MessageType messagetype) {
            this.f9185c = messagetype;
            this.f9183a = (bf) messagetype.a(g.f9199d, (Object) null);
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            cz.a().a(messagetype).b(messagetype, messagetype2);
        }

        public final BuilderType a(MessageType messagetype) {
            b();
            a(this.f9183a, messagetype);
            return this;
        }

        public final /* synthetic */ s a() {
            return (a) clone();
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (this.f9184b) {
                MessageType messagetype = (bf) this.f9183a.a(g.f9199d, (Object) null);
                a(messagetype, this.f9183a);
                this.f9183a = messagetype;
                this.f9184b = false;
            }
        }

        /* renamed from: c */
        public MessageType f() {
            if (this.f9184b) {
                return this.f9183a;
            }
            MessageType messagetype = this.f9183a;
            cz.a().a(messagetype).c(messagetype);
            this.f9184b = true;
            return this.f9183a;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) ((bf) this.f9185c).a(g.f9200e, (Object) null);
            aVar.a((bf) f());
            return aVar;
        }

        public final boolean d() {
            return bf.a(this.f9183a);
        }

        public final MessageType e() {
            MessageType messagetype = (bf) f();
            MessageType messagetype2 = null;
            byte byteValue = ((Byte) messagetype.a(g.f9196a, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = cz.a().a(messagetype).d(messagetype);
                    int i2 = g.f9197b;
                    if (z) {
                        messagetype2 = messagetype;
                    }
                    messagetype.a(i2, (Object) messagetype2);
                }
            }
            if (z) {
                return messagetype;
            }
            throw new du(messagetype);
        }

        public final /* synthetic */ cm g() {
            bf bfVar = (bf) f();
            bf bfVar2 = null;
            byte byteValue = ((Byte) bfVar.a(g.f9196a, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = cz.a().a(bfVar).d(bfVar);
                    int i2 = g.f9197b;
                    if (z) {
                        bfVar2 = bfVar;
                    }
                    bfVar.a(i2, (Object) bfVar2);
                }
            }
            if (z) {
                return bfVar;
            }
            throw new du(bfVar);
        }

        public final /* synthetic */ cm h() {
            return this.f9185c;
        }
    }

    public static class b<T extends bf<T, ?>> extends t<T> {

        /* renamed from: a  reason: collision with root package name */
        private T f9186a;

        public b(T t) {
            this.f9186a = t;
        }
    }

    public static abstract class c<MessageType extends d<MessageType, BuilderType>, BuilderType extends c<MessageType, BuilderType>> extends a<MessageType, BuilderType> implements co {
        protected c(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        public final void b() {
            if (this.f9184b) {
                super.b();
                ((d) this.f9183a).zzjv = (aw) ((d) this.f9183a).zzjv.clone();
            }
        }

        public final /* synthetic */ bf c() {
            return (d) f();
        }

        public final /* synthetic */ cm f() {
            bf c2;
            if (this.f9184b) {
                c2 = this.f9183a;
            } else {
                ((d) this.f9183a).zzjv.b();
                c2 = super.f();
            }
            return (d) c2;
        }
    }

    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType extends c<MessageType, BuilderType>> extends bf<MessageType, BuilderType> implements co {
        protected aw<e> zzjv = aw.a();
    }

    static final class e implements az<e> {

        /* renamed from: a  reason: collision with root package name */
        final int f9187a = 66321687;

        /* renamed from: b  reason: collision with root package name */
        final ej f9188b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f9189c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f9190d;

        /* renamed from: e  reason: collision with root package name */
        private final bj<?> f9191e = null;

        e(ej ejVar) {
            this.f9188b = ejVar;
            this.f9189c = false;
            this.f9190d = false;
        }

        public final int a() {
            return this.f9187a;
        }

        public final cn a(cn cnVar, cm cmVar) {
            return ((a) cnVar).a((bf) cmVar);
        }

        public final ej b() {
            return this.f9188b;
        }

        public final eo c() {
            return this.f9188b.zzek();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.f9187a - ((e) obj).f9187a;
        }

        public final ct d() {
            throw new UnsupportedOperationException();
        }
    }

    public static class f<ContainingType extends cm, Type> extends ap<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        private final ContainingType f9192a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f9193b;

        /* renamed from: c  reason: collision with root package name */
        private final cm f9194c;

        /* renamed from: d  reason: collision with root package name */
        private final e f9195d;

        f(ContainingType containingtype, Type type, cm cmVar, e eVar) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (eVar.f9188b == ej.MESSAGE && cmVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f9192a = containingtype;
                this.f9193b = type;
                this.f9194c = cmVar;
                this.f9195d = eVar;
            }
        }
    }

    /* 'enum' modifier removed */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final int f9196a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f9197b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f9198c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f9199d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f9200e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f9201f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f9202g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final int f9203h = 1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f9204i = 2;
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] l = {f9196a, f9197b, f9198c, f9199d, f9200e, f9201f, f9202g};
        private static final /* synthetic */ int[] m = {f9203h, f9204i};
        private static final /* synthetic */ int[] n = {j, k};

        public static int[] a() {
            return (int[]) l.clone();
        }
    }

    protected static <T extends bf<T, ?>> T a(T t, byte[] bArr) throws bn {
        T b2 = b(t, bArr);
        if (b2 != null) {
            T t2 = null;
            byte byteValue = ((Byte) b2.a(g.f9196a, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = cz.a().a(b2).d(b2);
                    int i2 = g.f9197b;
                    if (z) {
                        t2 = b2;
                    }
                    b2.a(i2, (Object) t2);
                }
            }
            if (!z) {
                throw new bn(new du(b2).getMessage()).zzg(b2);
            }
        }
        return b2;
    }

    static <T extends bf<?, ?>> T a(Class<T> cls) {
        T t = (bf) zzjr.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (bf) zzjr.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t != null) {
            return t;
        }
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? "Unable to get default instance for: ".concat(valueOf) : new String("Unable to get default instance for: "));
    }

    protected static Object a(cm cmVar, String str, Object[] objArr) {
        return new db(cmVar, str, objArr);
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

    protected static <T extends bf<?, ?>> void a(Class<T> cls, T t) {
        zzjr.put(cls, t);
    }

    protected static final <T extends bf<T, ?>> boolean a(T t) {
        byte byteValue = ((Byte) t.a(g.f9196a, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return cz.a().a(t).d(t);
    }

    private static <T extends bf<T, ?>> T b(T t, byte[] bArr) throws bn {
        T t2 = (bf) t.a(g.f9199d, (Object) null);
        try {
            cz.a().a(t2).a(t2, bArr, 0, bArr.length, new x());
            cz.a().a(t2).c(t2);
            if (t2.zzex == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof bn) {
                throw ((bn) e2.getCause());
            }
            throw new bn(e2.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw bn.zzbl().zzg(t2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i2, Object obj);

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.zzjq = i2;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.zzjq;
    }

    public final boolean d() {
        bf bfVar = null;
        byte byteValue = ((Byte) a(g.f9196a, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = cz.a().a(this).d(this);
        int i2 = g.f9197b;
        if (d2) {
            bfVar = this;
        }
        a(i2, (Object) bfVar);
        return d2;
    }

    public final int e() {
        if (this.zzjq == -1) {
            this.zzjq = cz.a().a(this).b(this);
        }
        return this.zzjq;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((bf) a(g.f9201f, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return cz.a().a(this).a(this, (bf) obj);
    }

    public final /* synthetic */ cn f() {
        a aVar = (a) a(g.f9200e, (Object) null);
        aVar.a(this);
        return aVar;
    }

    public final /* synthetic */ cn g() {
        return (a) a(g.f9200e, (Object) null);
    }

    public final /* synthetic */ cm h() {
        return (bf) a(g.f9201f, (Object) null);
    }

    public int hashCode() {
        if (this.zzex != 0) {
            return this.zzex;
        }
        this.zzex = cz.a().a(this).a(this);
        return this.zzex;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        cp.a(this, sb, 0);
        return sb.toString();
    }

    public final void a(am amVar) throws IOException {
        cz.a().a(getClass()).a(this, (ep) amVar.f9139b != null ? amVar.f9139b : new an(amVar));
    }
}
