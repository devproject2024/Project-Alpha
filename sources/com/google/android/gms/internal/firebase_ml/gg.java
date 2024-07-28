package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;
import com.google.android.gms.internal.firebase_ml.gg.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class gg<MessageType extends gg<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends fb<MessageType, BuilderType> {
    private static Map<Object, gg<?, ?>> zzcll = new ConcurrentHashMap();
    protected ja zzclj = ja.a();
    private int zzclk = -1;

    public static class a<T extends gg<T, ?>> extends fc<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f9918a;

        public a(T t) {
            this.f9918a = t;
        }
    }

    /* 'enum' modifier removed */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final int f9922a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f9923b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f9924c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f9925d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f9926e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f9927f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f9928g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final int f9929h = 1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f9930i = 2;
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] l = {f9922a, f9923b, f9924c, f9925d, f9926e, f9927f, f9928g};
        private static final /* synthetic */ int[] m = {f9929h, f9930i};
        private static final /* synthetic */ int[] n = {j, k};

        public static int[] a() {
            return (int[]) l.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i2, Object obj);

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends d<MessageType, BuilderType>> extends gg<MessageType, BuilderType> implements hp {
        protected fz<Object> zzclq = fz.a();

        /* access modifiers changed from: package-private */
        public final fz<Object> c() {
            if (this.zzclq.f9909b) {
                this.zzclq = (fz) this.zzclq.clone();
            }
            return this.zzclq;
        }
    }

    public static abstract class d<MessageType extends c<MessageType, BuilderType>, BuilderType extends d<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements hp {
        protected d(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        public final void d() {
            super.d();
            ((c) this.f9919a).zzclq = (fz) ((c) this.f9919a).zzclq.clone();
        }

        public final /* synthetic */ gg e() {
            return (c) g();
        }

        public final /* synthetic */ hn g() {
            if (this.f9920b) {
                return (c) this.f9919a;
            }
            ((c) this.f9919a).zzclq.b();
            return (c) super.g();
        }
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        hs.a(this, sb, 0);
        return sb.toString();
    }

    public int hashCode() {
        if (this.zzchd != 0) {
            return this.zzchd;
        }
        this.zzchd = ib.a().a(this).a(this);
        return this.zzchd;
    }

    public static abstract class b<MessageType extends gg<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends fa<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f9919a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f9920b = false;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f9921c;

        protected b(MessageType messagetype) {
            this.f9921c = messagetype;
            this.f9919a = (gg) messagetype.a(e.f9925d, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void d() {
            MessageType messagetype = (gg) this.f9919a.a(e.f9925d, (Object) null);
            a(messagetype, this.f9919a);
            this.f9919a = messagetype;
        }

        public final boolean h() {
            return gg.a(this.f9919a, false);
        }

        /* renamed from: e */
        public MessageType g() {
            if (this.f9920b) {
                return this.f9919a;
            }
            MessageType messagetype = this.f9919a;
            ib.a().a(messagetype).c(messagetype);
            this.f9920b = true;
            return this.f9919a;
        }

        /* renamed from: f */
        public final MessageType i() {
            MessageType messagetype = (gg) g();
            if (messagetype.h()) {
                return messagetype;
            }
            throw new iy(messagetype);
        }

        public final BuilderType a(MessageType messagetype) {
            if (this.f9920b) {
                d();
                this.f9920b = false;
            }
            a(this.f9919a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            ib.a().a(messagetype).b(messagetype, messagetype2);
        }

        public final /* synthetic */ fa c() {
            return (b) clone();
        }

        public final /* synthetic */ hn k() {
            return this.f9921c;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) ((gg) this.f9921c).a(e.f9926e, (Object) null);
            bVar.a((gg) g());
            return bVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ib.a().a(this).a(this, (gg) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends gg<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType g() {
        return (b) a(e.f9926e, (Object) null);
    }

    public final boolean h() {
        return a(this, true);
    }

    /* access modifiers changed from: package-private */
    public final int f() {
        return this.zzclk;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.zzclk = i2;
    }

    public final void a(ft ftVar) throws IOException {
        fv fvVar;
        ig a2 = ib.a().a(this);
        if (ftVar.f9889c != null) {
            fvVar = ftVar.f9889c;
        } else {
            fvVar = new fv(ftVar);
        }
        a2.a(this, (s) fvVar);
    }

    public final int i() {
        if (this.zzclk == -1) {
            this.zzclk = ib.a().a(this).b(this);
        }
        return this.zzclk;
    }

    static <T extends gg<?, ?>> T a(Class<T> cls) {
        T t = (gg) zzcll.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (gg) zzcll.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (gg) ((gg) d.a(cls)).a(e.f9927f, (Object) null);
            if (t != null) {
                zzcll.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends gg<?, ?>> void a(Class<T> cls, T t) {
        zzcll.put(cls, t);
    }

    protected static Object a(hn hnVar, String str, Object[] objArr) {
        return new id(hnVar, str, objArr);
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

    protected static final <T extends gg<T, ?>> boolean a(T t, boolean z) {
        T t2 = null;
        byte byteValue = ((Byte) t.a(e.f9922a, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = ib.a().a(t).d(t);
        if (z) {
            int i2 = e.f9923b;
            if (d2) {
                t2 = t;
            }
            t.a(i2, (Object) t2);
        }
        return d2;
    }

    protected static gn a(gn gnVar) {
        int size = gnVar.size();
        return gnVar.a(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ hq j() {
        b bVar = (b) a(e.f9926e, (Object) null);
        bVar.a(this);
        return bVar;
    }

    public final /* synthetic */ hn k() {
        return (gg) a(e.f9927f, (Object) null);
    }
}
