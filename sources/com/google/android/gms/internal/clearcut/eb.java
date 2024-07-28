package com.google.android.gms.internal.clearcut;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class eb {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f9329a = Logger.getLogger(eb.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f9330b = c();

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f9331c = v.b();

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f9332d = c(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f9333e = c(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    private static final d f9334f;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f9335g = g();

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f9336h = f();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final long f9337i = ((long) a((Class<?>) byte[].class));
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t = ((long) a((Class<?>) Object[].class));
    private static final long u = ((long) b((Class<?>) Object[].class));
    private static final long v = b(h());
    private static final long w;
    /* access modifiers changed from: private */
    public static final boolean x = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            return eb.x ? eb.k(obj, j) : eb.l(obj, j);
        }

        public final void a(long j, byte b2) {
            Memory.pokeByte((int) (j & -1), b2);
        }

        public final void a(Object obj, long j, byte b2) {
            if (eb.x) {
                eb.c(obj, j, b2);
            } else {
                eb.d(obj, j, b2);
            }
        }

        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }

        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        public final void a(Object obj, long j, boolean z) {
            if (eb.x) {
                eb.c(obj, j, r3 ? (byte) 1 : 0);
            } else {
                eb.d(obj, j, r3 ? (byte) 1 : 0);
            }
        }

        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }

        public final boolean b(Object obj, long j) {
            return eb.x ? eb.i(obj, j) : eb.j(obj, j);
        }

        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }
    }

    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            return eb.x ? eb.k(obj, j) : eb.l(obj, j);
        }

        public final void a(long j, byte b2) {
            Memory.pokeByte(j, b2);
        }

        public final void a(Object obj, long j, byte b2) {
            if (eb.x) {
                eb.c(obj, j, b2);
            } else {
                eb.d(obj, j, b2);
            }
        }

        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }

        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        public final void a(Object obj, long j, boolean z) {
            if (eb.x) {
                eb.c(obj, j, r3 ? (byte) 1 : 0);
            } else {
                eb.d(obj, j, r3 ? (byte) 1 : 0);
            }
        }

        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        public final boolean b(Object obj, long j) {
            return eb.x ? eb.i(obj, j) : eb.j(obj, j);
        }

        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }
    }

    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            return this.f9338a.getByte(obj, j);
        }

        public final void a(long j, byte b2) {
            this.f9338a.putByte(j, b2);
        }

        public final void a(Object obj, long j, byte b2) {
            this.f9338a.putByte(obj, j, b2);
        }

        public final void a(Object obj, long j, double d2) {
            this.f9338a.putDouble(obj, j, d2);
        }

        public final void a(Object obj, long j, float f2) {
            this.f9338a.putFloat(obj, j, f2);
        }

        public final void a(Object obj, long j, boolean z) {
            this.f9338a.putBoolean(obj, j, z);
        }

        public final void a(byte[] bArr, long j, long j2, long j3) {
            this.f9338a.copyMemory(bArr, eb.f9337i + j, (Object) null, j2, j3);
        }

        public final boolean b(Object obj, long j) {
            return this.f9338a.getBoolean(obj, j);
        }

        public final float c(Object obj, long j) {
            return this.f9338a.getFloat(obj, j);
        }

        public final double d(Object obj, long j) {
            return this.f9338a.getDouble(obj, j);
        }
    }

    static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f9338a;

        d(Unsafe unsafe) {
            this.f9338a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public final long a(Field field) {
            return this.f9338a.objectFieldOffset(field);
        }

        public abstract void a(long j, byte b2);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d2);

        public abstract void a(Object obj, long j, float f2);

        public final void a(Object obj, long j, int i2) {
            this.f9338a.putInt(obj, j, i2);
        }

        public final void a(Object obj, long j, long j2) {
            this.f9338a.putLong(obj, j, j2);
        }

        public abstract void a(Object obj, long j, boolean z);

        public abstract void a(byte[] bArr, long j, long j2, long j3);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final int e(Object obj, long j) {
            return this.f9338a.getInt(obj, j);
        }

        public final long f(Object obj, long j) {
            return this.f9338a.getLong(obj, j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fc  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            java.lang.Class<com.google.android.gms.internal.clearcut.eb> r5 = com.google.android.gms.internal.clearcut.eb.class
            java.lang.String r5 = r5.getName()
            java.util.logging.Logger r5 = java.util.logging.Logger.getLogger(r5)
            f9329a = r5
            sun.misc.Unsafe r5 = c()
            f9330b = r5
            java.lang.Class r5 = com.google.android.gms.internal.clearcut.v.b()
            f9331c = r5
            java.lang.Class r5 = java.lang.Long.TYPE
            boolean r5 = c(r5)
            f9332d = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            boolean r5 = c(r5)
            f9333e = r5
            sun.misc.Unsafe r5 = f9330b
            r6 = 0
            if (r5 != 0) goto L_0x0039
        L_0x0037:
            r5 = r6
            goto L_0x005e
        L_0x0039:
            boolean r5 = com.google.android.gms.internal.clearcut.v.a()
            if (r5 == 0) goto L_0x0057
            boolean r5 = f9332d
            if (r5 == 0) goto L_0x004b
            com.google.android.gms.internal.clearcut.eb$b r5 = new com.google.android.gms.internal.clearcut.eb$b
            sun.misc.Unsafe r7 = f9330b
            r5.<init>(r7)
            goto L_0x005e
        L_0x004b:
            boolean r5 = f9333e
            if (r5 == 0) goto L_0x0037
            com.google.android.gms.internal.clearcut.eb$a r5 = new com.google.android.gms.internal.clearcut.eb$a
            sun.misc.Unsafe r7 = f9330b
            r5.<init>(r7)
            goto L_0x005e
        L_0x0057:
            com.google.android.gms.internal.clearcut.eb$c r5 = new com.google.android.gms.internal.clearcut.eb$c
            sun.misc.Unsafe r7 = f9330b
            r5.<init>(r7)
        L_0x005e:
            f9334f = r5
            boolean r5 = g()
            f9335g = r5
            boolean r5 = f()
            f9336h = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = a((java.lang.Class<?>) r5)
            long r7 = (long) r5
            f9337i = r7
            int r5 = a((java.lang.Class<?>) r4)
            long r7 = (long) r5
            j = r7
            int r4 = b((java.lang.Class<?>) r4)
            long r4 = (long) r4
            k = r4
            int r4 = a((java.lang.Class<?>) r3)
            long r4 = (long) r4
            l = r4
            int r3 = b((java.lang.Class<?>) r3)
            long r3 = (long) r3
            m = r3
            int r3 = a((java.lang.Class<?>) r2)
            long r3 = (long) r3
            n = r3
            int r2 = b((java.lang.Class<?>) r2)
            long r2 = (long) r2
            o = r2
            int r2 = a((java.lang.Class<?>) r1)
            long r2 = (long) r2
            p = r2
            int r1 = b((java.lang.Class<?>) r1)
            long r1 = (long) r1
            q = r1
            int r1 = a((java.lang.Class<?>) r0)
            long r1 = (long) r1
            r = r1
            int r0 = b((java.lang.Class<?>) r0)
            long r0 = (long) r0
            s = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = a((java.lang.Class<?>) r0)
            long r0 = (long) r0
            t = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = b((java.lang.Class<?>) r0)
            long r0 = (long) r0
            u = r0
            java.lang.reflect.Field r0 = h()
            long r0 = b((java.lang.reflect.Field) r0)
            v = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "value"
            java.lang.reflect.Field r0 = a((java.lang.Class<?>) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x00eb
            java.lang.Class r1 = r0.getType()
            java.lang.Class<char[]> r2 = char[].class
            if (r1 != r2) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r0 = r6
        L_0x00ec:
            long r0 = b((java.lang.reflect.Field) r0)
            w = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00fc
            r0 = 1
            goto L_0x00fd
        L_0x00fc:
            r0 = 0
        L_0x00fd:
            x = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.eb.<clinit>():void");
    }

    private eb() {
    }

    static byte a(byte[] bArr, long j2) {
        return f9334f.a((Object) bArr, f9337i + j2);
    }

    private static int a(Class<?> cls) {
        if (f9336h) {
            return f9334f.f9338a.arrayBaseOffset(cls);
        }
        return -1;
    }

    static int a(Object obj, long j2) {
        return f9334f.e(obj, j2);
    }

    static long a(Field field) {
        return f9334f.a(field);
    }

    static long a(ByteBuffer byteBuffer) {
        return f9334f.f(byteBuffer, v);
    }

    private static Field a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    static void a(long j2, byte b2) {
        f9334f.a(j2, b2);
    }

    static void a(Object obj, long j2, double d2) {
        f9334f.a(obj, j2, d2);
    }

    static void a(Object obj, long j2, float f2) {
        f9334f.a(obj, j2, f2);
    }

    static void a(Object obj, long j2, int i2) {
        f9334f.a(obj, j2, i2);
    }

    static void a(Object obj, long j2, long j3) {
        f9334f.a(obj, j2, j3);
    }

    static void a(Object obj, long j2, Object obj2) {
        f9334f.f9338a.putObject(obj, j2, obj2);
    }

    static void a(Object obj, long j2, boolean z) {
        f9334f.a(obj, j2, z);
    }

    static void a(byte[] bArr, long j2, byte b2) {
        f9334f.a((Object) bArr, f9337i + j2, b2);
    }

    static void a(byte[] bArr, long j2, long j3, long j4) {
        f9334f.a(bArr, j2, j3, j4);
    }

    static boolean a() {
        return f9336h;
    }

    private static int b(Class<?> cls) {
        if (f9336h) {
            return f9334f.f9338a.arrayIndexScale(cls);
        }
        return -1;
    }

    static long b(Object obj, long j2) {
        return f9334f.f(obj, j2);
    }

    private static long b(Field field) {
        d dVar;
        if (field == null || (dVar = f9334f) == null) {
            return -1;
        }
        return dVar.a(field);
    }

    static boolean b() {
        return f9335g;
    }

    static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new ec());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void c(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int a2 = a(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a2 & (~(PriceRangeSeekBar.INVALID_POINTER_ID << i2))));
    }

    private static boolean c(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!v.a()) {
            return false;
        }
        try {
            Class<?> cls3 = f9331c;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean c(Object obj, long j2) {
        return f9334f.b(obj, j2);
    }

    static float d(Object obj, long j2) {
        return f9334f.c(obj, j2);
    }

    /* access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & (~(PriceRangeSeekBar.INVALID_POINTER_ID << i2))));
    }

    static double e(Object obj, long j2) {
        return f9334f.d(obj, j2);
    }

    static Object f(Object obj, long j2) {
        return f9334f.f9338a.getObject(obj, j2);
    }

    private static boolean f() {
        Unsafe unsafe = f9330b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (v.a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f9329a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean g() {
        Unsafe unsafe = f9330b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (h() == null) {
                return false;
            }
            if (v.a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f9329a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field h() {
        Field a2;
        if (v.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    /* access modifiers changed from: private */
    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    static /* synthetic */ boolean i(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    static /* synthetic */ boolean j(Object obj, long j2) {
        return l(obj, j2) != 0;
    }
}
