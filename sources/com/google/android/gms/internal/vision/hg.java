package com.google.android.gms.internal.vision;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class hg {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f11215a = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f11216b = Logger.getLogger(hg.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final Unsafe f11217c = c();

    /* renamed from: d  reason: collision with root package name */
    private static final Class<?> f11218d = cs.b();

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f11219e = d(Long.TYPE);

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f11220f = d(Integer.TYPE);

    /* renamed from: g  reason: collision with root package name */
    private static final d f11221g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f11222h = e();

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f11223i = d();
    private static final long j = ((long) b(byte[].class));
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u = ((long) b(Object[].class));
    private static final long v = ((long) c(Object[].class));
    private static final long w;
    private static final int x = ((int) (j & 7));

    private hg() {
    }

    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            if (hg.f11215a) {
                return hg.k(obj, j);
            }
            return hg.l(obj, j);
        }

        public final void a(Object obj, long j, byte b2) {
            if (hg.f11215a) {
                hg.c(obj, j, b2);
            } else {
                hg.d(obj, j, b2);
            }
        }

        public final boolean b(Object obj, long j) {
            if (hg.f11215a) {
                return hg.i(obj, j);
            }
            return hg.j(obj, j);
        }

        public final void a(Object obj, long j, boolean z) {
            if (hg.f11215a) {
                hg.c(obj, j, r3 ? (byte) 1 : 0);
            } else {
                hg.d(obj, j, r3 ? (byte) 1 : 0);
            }
        }

        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            return this.f11224a.getByte(obj, j);
        }

        public final void a(Object obj, long j, byte b2) {
            this.f11224a.putByte(obj, j, b2);
        }

        public final boolean b(Object obj, long j) {
            return this.f11224a.getBoolean(obj, j);
        }

        public final void a(Object obj, long j, boolean z) {
            this.f11224a.putBoolean(obj, j, z);
        }

        public final float c(Object obj, long j) {
            return this.f11224a.getFloat(obj, j);
        }

        public final void a(Object obj, long j, float f2) {
            this.f11224a.putFloat(obj, j, f2);
        }

        public final double d(Object obj, long j) {
            return this.f11224a.getDouble(obj, j);
        }

        public final void a(Object obj, long j, double d2) {
            this.f11224a.putDouble(obj, j, d2);
        }
    }

    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            if (hg.f11215a) {
                return hg.k(obj, j);
            }
            return hg.l(obj, j);
        }

        public final void a(Object obj, long j, byte b2) {
            if (hg.f11215a) {
                hg.c(obj, j, b2);
            } else {
                hg.d(obj, j, b2);
            }
        }

        public final boolean b(Object obj, long j) {
            if (hg.f11215a) {
                return hg.i(obj, j);
            }
            return hg.j(obj, j);
        }

        public final void a(Object obj, long j, boolean z) {
            if (hg.f11215a) {
                hg.c(obj, j, r3 ? (byte) 1 : 0);
            } else {
                hg.d(obj, j, r3 ? (byte) 1 : 0);
            }
        }

        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static boolean a() {
        return f11223i;
    }

    static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        Unsafe f11224a;

        d(Unsafe unsafe) {
            this.f11224a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d2);

        public abstract void a(Object obj, long j, float f2);

        public abstract void a(Object obj, long j, boolean z);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final int e(Object obj, long j) {
            return this.f11224a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i2) {
            this.f11224a.putInt(obj, j, i2);
        }

        public final long f(Object obj, long j) {
            return this.f11224a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f11224a.putLong(obj, j, j2);
        }
    }

    static boolean b() {
        return f11222h;
    }

    static <T> T a(Class<T> cls) {
        try {
            return f11217c.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (f11223i) {
            return f11221g.f11224a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int c(Class<?> cls) {
        if (f11223i) {
            return f11221g.f11224a.arrayIndexScale(cls);
        }
        return -1;
    }

    static int a(Object obj, long j2) {
        return f11221g.e(obj, j2);
    }

    static void a(Object obj, long j2, int i2) {
        f11221g.a(obj, j2, i2);
    }

    static long b(Object obj, long j2) {
        return f11221g.f(obj, j2);
    }

    static void a(Object obj, long j2, long j3) {
        f11221g.a(obj, j2, j3);
    }

    static boolean c(Object obj, long j2) {
        return f11221g.b(obj, j2);
    }

    static void a(Object obj, long j2, boolean z) {
        f11221g.a(obj, j2, z);
    }

    static float d(Object obj, long j2) {
        return f11221g.c(obj, j2);
    }

    static void a(Object obj, long j2, float f2) {
        f11221g.a(obj, j2, f2);
    }

    static double e(Object obj, long j2) {
        return f11221g.d(obj, j2);
    }

    static void a(Object obj, long j2, double d2) {
        f11221g.a(obj, j2, d2);
    }

    static Object f(Object obj, long j2) {
        return f11221g.f11224a.getObject(obj, j2);
    }

    static void a(Object obj, long j2, Object obj2) {
        f11221g.f11224a.putObject(obj, j2, obj2);
    }

    static byte a(byte[] bArr, long j2) {
        return f11221g.a(bArr, j + j2);
    }

    static void a(byte[] bArr, long j2, byte b2) {
        f11221g.a((Object) bArr, j + j2, b2);
    }

    static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new hi());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean d() {
        Unsafe unsafe = f11217c;
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
            if (cs.a()) {
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
            Logger logger = f11216b;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean e() {
        Unsafe unsafe = f11217c;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (f() == null) {
                return false;
            }
            if (cs.a()) {
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
            Logger logger = f11216b;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean d(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!cs.a()) {
            return false;
        }
        try {
            Class<?> cls3 = f11218d;
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

    private static Field f() {
        Field a2;
        if (cs.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void c(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int a2 = a(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a2 & (~(PriceRangeSeekBar.INVALID_POINTER_ID << i2))));
    }

    /* access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & (~(PriceRangeSeekBar.INVALID_POINTER_ID << i2))));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d2, code lost:
        r1 = f11221g;
     */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            java.lang.Class<com.google.android.gms.internal.vision.hg> r5 = com.google.android.gms.internal.vision.hg.class
            java.lang.String r5 = r5.getName()
            java.util.logging.Logger r5 = java.util.logging.Logger.getLogger(r5)
            f11216b = r5
            sun.misc.Unsafe r5 = c()
            f11217c = r5
            java.lang.Class r5 = com.google.android.gms.internal.vision.cs.b()
            f11218d = r5
            java.lang.Class r5 = java.lang.Long.TYPE
            boolean r5 = d(r5)
            f11219e = r5
            java.lang.Class r5 = java.lang.Integer.TYPE
            boolean r5 = d(r5)
            f11220f = r5
            sun.misc.Unsafe r5 = f11217c
            r6 = 0
            if (r5 != 0) goto L_0x0038
            goto L_0x005d
        L_0x0038:
            boolean r5 = com.google.android.gms.internal.vision.cs.a()
            if (r5 == 0) goto L_0x0056
            boolean r5 = f11219e
            if (r5 == 0) goto L_0x004a
            com.google.android.gms.internal.vision.hg$c r6 = new com.google.android.gms.internal.vision.hg$c
            sun.misc.Unsafe r5 = f11217c
            r6.<init>(r5)
            goto L_0x005d
        L_0x004a:
            boolean r5 = f11220f
            if (r5 == 0) goto L_0x005d
            com.google.android.gms.internal.vision.hg$a r6 = new com.google.android.gms.internal.vision.hg$a
            sun.misc.Unsafe r5 = f11217c
            r6.<init>(r5)
            goto L_0x005d
        L_0x0056:
            com.google.android.gms.internal.vision.hg$b r6 = new com.google.android.gms.internal.vision.hg$b
            sun.misc.Unsafe r5 = f11217c
            r6.<init>(r5)
        L_0x005d:
            f11221g = r6
            boolean r5 = e()
            f11222h = r5
            boolean r5 = d()
            f11223i = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = b(r5)
            long r5 = (long) r5
            j = r5
            int r5 = b(r4)
            long r5 = (long) r5
            k = r5
            int r4 = c(r4)
            long r4 = (long) r4
            l = r4
            int r4 = b(r3)
            long r4 = (long) r4
            m = r4
            int r3 = c(r3)
            long r3 = (long) r3
            n = r3
            int r3 = b(r2)
            long r3 = (long) r3
            o = r3
            int r2 = c(r2)
            long r2 = (long) r2
            p = r2
            int r2 = b(r1)
            long r2 = (long) r2
            q = r2
            int r1 = c(r1)
            long r1 = (long) r1
            r = r1
            int r1 = b(r0)
            long r1 = (long) r1
            s = r1
            int r0 = c(r0)
            long r0 = (long) r0
            t = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = b(r0)
            long r0 = (long) r0
            u = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = c(r0)
            long r0 = (long) r0
            v = r0
            java.lang.reflect.Field r0 = f()
            if (r0 == 0) goto L_0x00de
            com.google.android.gms.internal.vision.hg$d r1 = f11221g
            if (r1 != 0) goto L_0x00d7
            goto L_0x00de
        L_0x00d7:
            sun.misc.Unsafe r1 = r1.f11224a
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00e0
        L_0x00de:
            r0 = -1
        L_0x00e0:
            w = r0
            long r0 = j
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            x = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f4
            r0 = 1
            goto L_0x00f5
        L_0x00f4:
            r0 = 0
        L_0x00f5:
            f11215a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.hg.<clinit>():void");
    }

    static /* synthetic */ boolean i(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    static /* synthetic */ boolean j(Object obj, long j2) {
        return l(obj, j2) != 0;
    }
}
