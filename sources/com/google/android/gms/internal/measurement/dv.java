package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;
import com.google.android.gms.internal.measurement.dv.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class dv<MessageType extends dv<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends ce<MessageType, BuilderType> {
    private static Map<Object, dv<?, ?>> zzd = new ConcurrentHashMap();
    protected gp zzb = gp.a();
    private int zzc = -1;

    public static class a<T extends dv<T, ?>> extends ch<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f10592a;

        public a(T t) {
            this.f10592a = t;
        }
    }

    /* 'enum' modifier removed */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final int f10596a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f10597b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f10598c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f10599d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f10600e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f10601f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f10602g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final int f10603h = 1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f10604i = 2;
        public static final int j = 1;
        public static final int k = 2;
        private static final /* synthetic */ int[] l = {f10596a, f10597b, f10598c, f10599d, f10600e, f10601f, f10602g};
        private static final /* synthetic */ int[] m = {f10603h, f10604i};
        private static final /* synthetic */ int[] n = {j, k};

        public static int[] a() {
            return (int[]) l.clone();
        }
    }

    public static class e<ContainingType extends ff, Type> extends di<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i2);

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends dv<MessageType, BuilderType> implements fh {
        protected dn<Object> zzc = dn.a();

        /* access modifiers changed from: package-private */
        public final dn<Object> a() {
            if (this.zzc.f10583b) {
                this.zzc = (dn) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        fg.a(this, sb, 0);
        return sb.toString();
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = fq.a().a(this).a(this);
        return this.zza;
    }

    public static abstract class b<MessageType extends dv<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends cf<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f10593a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f10594b = false;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f10595c;

        protected b(MessageType messagetype) {
            this.f10595c = messagetype;
            this.f10593a = (dv) messagetype.a(d.f10599d);
        }

        /* access modifiers changed from: protected */
        public final void t() {
            MessageType messagetype = (dv) this.f10593a.a(d.f10599d);
            a(messagetype, this.f10593a);
            this.f10593a = messagetype;
        }

        public final boolean l() {
            return dv.a(this.f10593a, false);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public MessageType v() {
            if (this.f10594b) {
                return this.f10593a;
            }
            MessageType messagetype = this.f10593a;
            fq.a().a(messagetype).c(messagetype);
            this.f10594b = true;
            return this.f10593a;
        }

        public final BuilderType a(MessageType messagetype) {
            if (this.f10594b) {
                t();
                this.f10594b = false;
            }
            a(this.f10593a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            fq.a().a(messagetype).b(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final BuilderType a(byte[] bArr, int i2, dh dhVar) throws eg {
            if (this.f10594b) {
                t();
                this.f10594b = false;
            }
            try {
                fq.a().a(this.f10593a).a(this.f10593a, bArr, 0, i2 + 0, new cl(dhVar));
                return this;
            } catch (eg e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw eg.zza();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public final BuilderType a(cz czVar, dh dhVar) throws IOException {
            dd ddVar;
            if (this.f10594b) {
                t();
                this.f10594b = false;
            }
            try {
                fv a2 = fq.a().a(this.f10593a);
                MessageType messagetype = this.f10593a;
                if (czVar.f10540c != null) {
                    ddVar = czVar.f10540c;
                } else {
                    ddVar = new dd(czVar);
                }
                a2.a(messagetype, ddVar, dhVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        public final /* synthetic */ cf a(byte[] bArr, int i2) throws eg {
            return a(bArr, i2, dh.a());
        }

        public final /* synthetic */ cf s() {
            return (b) clone();
        }

        public final /* synthetic */ ff q() {
            return this.f10595c;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) ((dv) this.f10595c).a(d.f10600e);
            bVar.a(v());
            return bVar;
        }

        /* renamed from: u */
        public final MessageType w() {
            MessageType a2 = v();
            if (a2.l()) {
                return a2;
            }
            throw new gn(a2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((dv) a(d.f10601f)).getClass().isInstance(obj)) {
            return false;
        }
        return fq.a().a(this).a(this, (dv) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends dv<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType k() {
        return (b) a(d.f10600e);
    }

    public final boolean l() {
        return a(this, true);
    }

    public final BuilderType m() {
        BuilderType buildertype = (b) a(d.f10600e);
        buildertype.a(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int j() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        this.zzc = i2;
    }

    public final void a(de deVar) throws IOException {
        dg dgVar;
        fv a2 = fq.a().a(this);
        if (deVar.f10560c != null) {
            dgVar = deVar.f10560c;
        } else {
            dgVar = new dg(deVar);
        }
        a2.a(this, (hk) dgVar);
    }

    public final int n() {
        if (this.zzc == -1) {
            this.zzc = fq.a().a(this).b(this);
        }
        return this.zzc;
    }

    static <T extends dv<?, ?>> T a(Class<T> cls) {
        T t = (dv) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (dv) zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (dv) ((dv) gt.a(cls)).a(d.f10601f);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends dv<?, ?>> void a(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object a(ff ffVar, String str, Object[] objArr) {
        return new ft(ffVar, str, objArr);
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

    protected static final <T extends dv<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(d.f10596a)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = fq.a().a(t).d(t);
        if (z) {
            t.a(d.f10597b);
        }
        return d2;
    }

    protected static ee a(ee eeVar) {
        int size = eeVar.size();
        return eeVar.c(size == 0 ? 10 : size << 1);
    }

    protected static <E> ed<E> a(ed<E> edVar) {
        int size = edVar.size();
        return edVar.a(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ fe o() {
        b bVar = (b) a(d.f10600e);
        bVar.a(this);
        return bVar;
    }

    public final /* synthetic */ fe p() {
        return (b) a(d.f10600e);
    }

    public final /* synthetic */ ff q() {
        return (dv) a(d.f10601f);
    }
}
