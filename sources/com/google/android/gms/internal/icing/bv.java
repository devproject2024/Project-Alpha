package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;
import com.google.android.gms.internal.icing.bv.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class bv<MessageType extends bv<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends al<MessageType, BuilderType> {
    private static Map<Object, bv<?, ?>> zzjv = new ConcurrentHashMap();
    protected el zzjt = el.a();
    private int zzju = -1;

    public static class a<T extends bv<T, ?>> extends am<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f10105a;

        public a(T t) {
            this.f10105a = t;
        }
    }

    /* 'enum' modifier removed */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final int f10109a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f10110b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f10111c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f10112d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f10113e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f10114f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f10115g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final int f10116h = 1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f10117i = 2;
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] l = {f10109a, f10110b, f10111c, f10112d, f10113e, f10114f, f10115g};
        private static final /* synthetic */ int[] m = {f10116h, f10117i};
        private static final /* synthetic */ int[] n = {j, k};

        public static int[] a() {
            return (int[]) l.clone();
        }
    }

    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends bv<MessageType, BuilderType> implements df {
        protected bq<Object> zzko = bq.a();
    }

    /* access modifiers changed from: protected */
    public abstract Object b(int i2);

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        de.a(this, sb, 0);
        return sb.toString();
    }

    public int hashCode() {
        if (this.zzfp != 0) {
            return this.zzfp;
        }
        this.zzfp = dq.a().a(this).a(this);
        return this.zzfp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((bv) b(c.f10114f)).getClass().isInstance(obj)) {
            return false;
        }
        return dq.a().a(this).a(this, (bv) obj);
    }

    public static abstract class b<MessageType extends bv<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends an<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f10106a;

        /* renamed from: b  reason: collision with root package name */
        private final MessageType f10107b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10108c = false;

        protected b(MessageType messagetype) {
            this.f10107b = messagetype;
            this.f10106a = (bv) messagetype.b(c.f10112d);
        }

        public final boolean c() {
            return bv.a(this.f10106a, false);
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public MessageType b() {
            if (this.f10108c) {
                return this.f10106a;
            }
            MessageType messagetype = this.f10106a;
            dq.a().a(messagetype).b(messagetype);
            this.f10108c = true;
            return this.f10106a;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            dq.a().a(messagetype).b(messagetype, messagetype2);
        }

        public final /* synthetic */ an a() {
            return (b) clone();
        }

        public final /* synthetic */ dd f() {
            return this.f10107b;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) ((bv) this.f10107b).b(c.f10113e);
            bVar.a(b());
            return bVar;
        }

        public final BuilderType a(MessageType messagetype) {
            if (this.f10108c) {
                MessageType messagetype2 = (bv) this.f10106a.b(c.f10112d);
                a(messagetype2, this.f10106a);
                this.f10106a = messagetype2;
                this.f10108c = false;
            }
            a(this.f10106a, messagetype);
            return this;
        }

        public final /* synthetic */ dd d() {
            bv e2 = b();
            if (e2.c()) {
                return e2;
            }
            throw new ej(e2);
        }
    }

    public final boolean c() {
        return a(this, true);
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.zzju;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.zzju = i2;
    }

    public final void a(bf bfVar) throws IOException {
        bi biVar;
        dr<?> a2 = dq.a().a(getClass());
        if (bfVar.f10072c != null) {
            biVar = bfVar.f10072c;
        } else {
            biVar = new bi(bfVar);
        }
        a2.a(this, (fc) biVar);
    }

    public final int d() {
        if (this.zzju == -1) {
            this.zzju = dq.a().a(this).d(this);
        }
        return this.zzju;
    }

    static <T extends bv<?, ?>> T a(Class<T> cls) {
        T t = (bv) zzjv.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (bv) zzjv.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (bv) ((bv) eo.a(cls)).b(c.f10114f);
            if (t != null) {
                zzjv.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends bv<?, ?>> void a(Class<T> cls, T t) {
        zzjv.put(cls, t);
    }

    protected static Object a(dd ddVar, String str, Object[] objArr) {
        return new ds(ddVar, str, objArr);
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

    protected static final <T extends bv<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.b(c.f10109a)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c2 = dq.a().a(t).c(t);
        if (z) {
            t.b(c.f10110b);
        }
        return c2;
    }

    public final /* synthetic */ dc e() {
        b bVar = (b) b(c.f10113e);
        bVar.a(this);
        return bVar;
    }

    public final /* synthetic */ dd f() {
        return (bv) b(c.f10114f);
    }
}
