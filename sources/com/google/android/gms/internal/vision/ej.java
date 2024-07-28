package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;
import com.google.android.gms.internal.vision.ej.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ej<MessageType extends ej<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends cm<MessageType, BuilderType> {
    private static Map<Object, ej<?, ?>> zzwl = new ConcurrentHashMap();
    protected hd zzwj = hd.a();
    private int zzwk = -1;

    public static class b<T extends ej<T, ?>> extends cq<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f11094a;

        public b(T t) {
            this.f11094a = t;
        }
    }

    /* 'enum' modifier removed */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final int f11100a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f11101b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f11102c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f11103d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f11104e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f11105f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f11106g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final int f11107h = 1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f11108i = 2;
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] l = {f11100a, f11101b, f11102c, f11103d, f11104e, f11105f, f11106g};
        private static final /* synthetic */ int[] m = {f11107h, f11108i};
        private static final /* synthetic */ int[] n = {j, k};

        public static int[] a() {
            return (int[]) l.clone();
        }
    }

    public static class f<ContainingType extends ft, Type> extends dv<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final ft f11109a;

        /* renamed from: b  reason: collision with root package name */
        final c f11110b;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i2);

    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends ej<MessageType, BuilderType> implements fv {
        protected dz<c> zzwq = dz.a();

        /* access modifiers changed from: package-private */
        public final dz<c> a() {
            if (this.zzwq.f11076b) {
                this.zzwq = (dz) this.zzwq.clone();
            }
            return this.zzwq;
        }
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        fu.a(this, sb, 0);
        return sb.toString();
    }

    public int hashCode() {
        if (this.zzro != 0) {
            return this.zzro;
        }
        this.zzro = ge.a().a(this).a(this);
        return this.zzro;
    }

    static final class c implements eb<c> {

        /* renamed from: a  reason: collision with root package name */
        final em<?> f11095a;

        /* renamed from: b  reason: collision with root package name */
        final int f11096b;

        /* renamed from: c  reason: collision with root package name */
        final hs f11097c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f11098d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f11099e;

        public final int a() {
            return this.f11096b;
        }

        public final hs b() {
            return this.f11097c;
        }

        public final hv c() {
            return this.f11097c.zzip();
        }

        public final boolean d() {
            return this.f11098d;
        }

        public final boolean e() {
            return this.f11099e;
        }

        public final fs a(fs fsVar, ft ftVar) {
            return ((a) fsVar).a((ej) ftVar);
        }

        public final fy f() {
            throw new UnsupportedOperationException();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.f11096b - ((c) obj).f11096b;
        }
    }

    public static abstract class a<MessageType extends ej<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends co<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f11091a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f11092b = false;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f11093c;

        protected a(MessageType messagetype) {
            this.f11093c = messagetype;
            this.f11091a = (ej) messagetype.a(e.f11103d);
        }

        /* access modifiers changed from: protected */
        public final void b() {
            MessageType messagetype = (ej) this.f11091a.a(e.f11103d);
            a(messagetype, this.f11091a);
            this.f11091a = messagetype;
        }

        public final boolean g() {
            return ej.a(this.f11091a, false);
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public MessageType c() {
            if (this.f11092b) {
                return this.f11091a;
            }
            MessageType messagetype = this.f11091a;
            ge.a().a(messagetype).c(messagetype);
            this.f11092b = true;
            return this.f11091a;
        }

        public final BuilderType a(MessageType messagetype) {
            if (this.f11092b) {
                b();
                this.f11092b = false;
            }
            a(this.f11091a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            ge.a().a(messagetype).b(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final BuilderType a(byte[] bArr, int i2, du duVar) throws eu {
            if (this.f11092b) {
                b();
                this.f11092b = false;
            }
            try {
                ge.a().a(this.f11091a).a(this.f11091a, bArr, 0, i2 + 0, new ct(duVar));
                return this;
            } catch (eu e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw eu.zzgm();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final BuilderType a(dl dlVar, du duVar) throws IOException {
            dp dpVar;
            if (this.f11092b) {
                b();
                this.f11092b = false;
            }
            try {
                gi a2 = ge.a().a(this.f11091a);
                MessageType messagetype = this.f11091a;
                if (dlVar.f11040c != null) {
                    dpVar = dlVar.f11040c;
                } else {
                    dpVar = new dp(dlVar);
                }
                a2.a(messagetype, dpVar, duVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        public final /* synthetic */ co a() {
            return (a) clone();
        }

        public final /* synthetic */ ft k() {
            return this.f11093c;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) ((ej) this.f11093c).a(e.f11104e);
            aVar.a(c());
            return aVar;
        }

        public final /* synthetic */ ft d() {
            ej e2 = c();
            if (e2.g()) {
                return e2;
            }
            throw new hb(e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ge.a().a(this).a(this, (ej) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends ej<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType f() {
        return (a) a(e.f11104e);
    }

    public final boolean g() {
        return a(this, true);
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.zzwk;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        this.zzwk = i2;
    }

    public final void a(dr drVar) throws IOException {
        dt dtVar;
        gi a2 = ge.a().a(this);
        if (drVar.f11056c != null) {
            dtVar = drVar.f11056c;
        } else {
            dtVar = new dt(drVar);
        }
        a2.a(this, (hx) dtVar);
    }

    public final int h() {
        if (this.zzwk == -1) {
            this.zzwk = ge.a().a(this).b(this);
        }
        return this.zzwk;
    }

    static <T extends ej<?, ?>> T a(Class<T> cls) {
        T t = (ej) zzwl.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (ej) zzwl.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (ej) ((ej) hg.a(cls)).a(e.f11105f);
            if (t != null) {
                zzwl.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends ej<?, ?>> void a(Class<T> cls, T t) {
        zzwl.put(cls, t);
    }

    protected static Object a(ft ftVar, String str, Object[] objArr) {
        return new gg(ftVar, str, objArr);
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

    protected static final <T extends ej<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(e.f11100a)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = ge.a().a(t).d(t);
        if (z) {
            t.a(e.f11101b);
        }
        return d2;
    }

    public final /* synthetic */ fs i() {
        a aVar = (a) a(e.f11104e);
        aVar.a(this);
        return aVar;
    }

    public final /* synthetic */ fs j() {
        return (a) a(e.f11104e);
    }

    public final /* synthetic */ ft k() {
        return (ej) a(e.f11105f);
    }
}
