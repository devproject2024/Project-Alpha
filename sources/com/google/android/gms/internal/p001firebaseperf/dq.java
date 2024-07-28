package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;
import com.google.android.gms.internal.p001firebaseperf.dq.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.dq  reason: invalid package */
public abstract class dq<MessageType extends dq<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends ci<MessageType, BuilderType> {
    private static Map<Object, dq<?, ?>> zzqy = new ConcurrentHashMap();
    protected gf zzqw = gf.a();
    private int zzqx = -1;

    /* renamed from: com.google.android.gms.internal.firebase-perf.dq$b */
    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType> extends dq<MessageType, BuilderType> implements ez {
        protected di<Object> zzqz = di.a();
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.dq$c */
    public static class c<T extends dq<T, ?>> extends ck<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f9568a;

        public c(T t) {
            this.f9568a = t;
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: com.google.android.gms.internal.firebase-perf.dq$d */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final int f9569a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f9570b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f9571c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f9572d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f9573e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f9574f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f9575g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final int f9576h = 1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f9577i = 2;
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] l = {f9569a, f9570b, f9571c, f9572d, f9573e, f9574f, f9575g};
        private static final /* synthetic */ int[] m = {f9576h, f9577i};
        private static final /* synthetic */ int[] n = {j, k};

        public static int[] a() {
            return (int[]) l.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i2);

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        fd.a(this, sb, 0);
        return sb.toString();
    }

    public int hashCode() {
        if (this.zzmu != 0) {
            return this.zzmu;
        }
        this.zzmu = fk.a().a(this).a(this);
        return this.zzmu;
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.dq$a */
    public static abstract class a<MessageType extends dq<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends ch<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f9565a;

        /* renamed from: b  reason: collision with root package name */
        private final MessageType f9566b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9567c = false;

        protected a(MessageType messagetype) {
            this.f9566b = messagetype;
            this.f9565a = (dq) messagetype.a(d.f9572d);
        }

        /* access modifiers changed from: protected */
        public final void h() {
            if (this.f9567c) {
                MessageType messagetype = (dq) this.f9565a.a(d.f9572d);
                a(messagetype, this.f9565a);
                this.f9565a = messagetype;
                this.f9567c = false;
            }
        }

        public final boolean m() {
            return dq.a(this.f9565a, false);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public MessageType j() {
            if (this.f9567c) {
                return this.f9565a;
            }
            MessageType messagetype = this.f9565a;
            fk.a().a(messagetype).c(messagetype);
            this.f9567c = true;
            return this.f9565a;
        }

        public final BuilderType a(MessageType messagetype) {
            h();
            a(this.f9565a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            fk.a().a(messagetype).b(messagetype, messagetype2);
        }

        public final /* synthetic */ ch g() {
            return (a) clone();
        }

        public final /* synthetic */ ex q() {
            return this.f9566b;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) ((dq) this.f9566b).a(d.f9573e);
            aVar.a(j());
            return aVar;
        }

        /* renamed from: i */
        public final MessageType k() {
            MessageType a2 = j();
            if (a2.m()) {
                return a2;
            }
            throw new gd(a2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((dq) a(d.f9574f)).getClass().isInstance(obj)) {
            return false;
        }
        return fk.a().a(this).a(this, (dq) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends dq<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType l() {
        return (a) a(d.f9573e);
    }

    public final boolean m() {
        return a(this, true);
    }

    public final BuilderType n() {
        BuilderType buildertype = (a) a(d.f9573e);
        buildertype.a(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int k() {
        return this.zzqx;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        this.zzqx = i2;
    }

    public final void a(da daVar) throws IOException {
        dd ddVar;
        fp<?> a2 = fk.a().a(getClass());
        if (daVar.f9535c != null) {
            ddVar = daVar.f9535c;
        } else {
            ddVar = new dd(daVar);
        }
        a2.a(this, (ha) ddVar);
    }

    public final int o() {
        if (this.zzqx == -1) {
            this.zzqx = fk.a().a(this).b(this);
        }
        return this.zzqx;
    }

    static <T extends dq<?, ?>> T a(Class<T> cls) {
        T t = (dq) zzqy.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (dq) zzqy.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (dq) ((dq) gm.a(cls)).a(d.f9574f);
            if (t != null) {
                zzqy.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends dq<?, ?>> void a(Class<T> cls, T t) {
        zzqy.put(cls, t);
    }

    protected static Object a(ex exVar, String str, Object[] objArr) {
        return new fm(exVar, str, objArr);
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

    protected static final <T extends dq<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(d.f9569a)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = fk.a().a(t).d(t);
        if (z) {
            t.a(d.f9570b);
        }
        return d2;
    }

    protected static <E> dz<E> a(dz<E> dzVar) {
        int size = dzVar.size();
        return dzVar.d(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ fa p() {
        a aVar = (a) a(d.f9573e);
        aVar.a(this);
        return aVar;
    }

    public final /* synthetic */ ex q() {
        return (dq) a(d.f9574f);
    }
}
