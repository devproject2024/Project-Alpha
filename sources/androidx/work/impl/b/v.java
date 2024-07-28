package androidx.work.impl.b;

import androidx.work.a;
import androidx.work.m;
import androidx.work.u;

public final class v {
    public static int a(u.a aVar) {
        switch (aVar) {
            case ENQUEUED:
                return 0;
            case RUNNING:
                return 1;
            case SUCCEEDED:
                return 2;
            case FAILED:
                return 3;
            case BLOCKED:
                return 4;
            case CANCELLED:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
    }

    public static u.a a(int i2) {
        if (i2 == 0) {
            return u.a.ENQUEUED;
        }
        if (i2 == 1) {
            return u.a.RUNNING;
        }
        if (i2 == 2) {
            return u.a.SUCCEEDED;
        }
        if (i2 == 3) {
            return u.a.FAILED;
        }
        if (i2 == 4) {
            return u.a.BLOCKED;
        }
        if (i2 == 5) {
            return u.a.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i2 + " to State");
    }

    public static a b(int i2) {
        if (i2 == 0) {
            return a.EXPONENTIAL;
        }
        if (i2 == 1) {
            return a.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i2 + " to BackoffPolicy");
    }

    /* renamed from: androidx.work.impl.b.v$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5223b = new int[a.values().length];

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f5224c = new int[m.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0070 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0098 */
        static {
            /*
                androidx.work.m[] r0 = androidx.work.m.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5224c = r0
                r0 = 1
                int[] r1 = f5224c     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.work.m r2 = androidx.work.m.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f5224c     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.work.m r3 = androidx.work.m.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f5224c     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.work.m r4 = androidx.work.m.UNMETERED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f5224c     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.work.m r5 = androidx.work.m.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f5224c     // Catch:{ NoSuchFieldError -> 0x0040 }
                androidx.work.m r6 = androidx.work.m.METERED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                androidx.work.a[] r5 = androidx.work.a.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f5223b = r5
                int[] r5 = f5223b     // Catch:{ NoSuchFieldError -> 0x0053 }
                androidx.work.a r6 = androidx.work.a.EXPONENTIAL     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r5 = f5223b     // Catch:{ NoSuchFieldError -> 0x005d }
                androidx.work.a r6 = androidx.work.a.LINEAR     // Catch:{ NoSuchFieldError -> 0x005d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                androidx.work.u$a[] r5 = androidx.work.u.a.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f5222a = r5
                int[] r5 = f5222a     // Catch:{ NoSuchFieldError -> 0x0070 }
                androidx.work.u$a r6 = androidx.work.u.a.ENQUEUED     // Catch:{ NoSuchFieldError -> 0x0070 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0070 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0070 }
            L_0x0070:
                int[] r0 = f5222a     // Catch:{ NoSuchFieldError -> 0x007a }
                androidx.work.u$a r5 = androidx.work.u.a.RUNNING     // Catch:{ NoSuchFieldError -> 0x007a }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = f5222a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.work.u$a r1 = androidx.work.u.a.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f5222a     // Catch:{ NoSuchFieldError -> 0x008e }
                androidx.work.u$a r1 = androidx.work.u.a.FAILED     // Catch:{ NoSuchFieldError -> 0x008e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                int[] r0 = f5222a     // Catch:{ NoSuchFieldError -> 0x0098 }
                androidx.work.u$a r1 = androidx.work.u.a.BLOCKED     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                int[] r0 = f5222a     // Catch:{ NoSuchFieldError -> 0x00a3 }
                androidx.work.u$a r1 = androidx.work.u.a.CANCELLED     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.b.v.AnonymousClass1.<clinit>():void");
        }
    }

    public static m c(int i2) {
        if (i2 == 0) {
            return m.NOT_REQUIRED;
        }
        if (i2 == 1) {
            return m.CONNECTED;
        }
        if (i2 == 2) {
            return m.UNMETERED;
        }
        if (i2 == 3) {
            return m.NOT_ROAMING;
        }
        if (i2 == 4) {
            return m.METERED;
        }
        throw new IllegalArgumentException("Could not convert " + i2 + " to NetworkType");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054 A[SYNTHETIC, Splitter:B:26:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A[SYNTHETIC, Splitter:B:37:0x006b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0042=Splitter:B:15:0x0042, B:30:0x005c=Splitter:B:30:0x005c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(androidx.work.d r4) {
        /*
            int r0 = r4.a()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x004e }
            r2.<init>(r0)     // Catch:{ IOException -> 0x004e }
            int r1 = r4.a()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.util.Set<androidx.work.d$a> r4 = r4.f5089a     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
        L_0x001f:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            androidx.work.d$a r1 = (androidx.work.d.a) r1     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            android.net.Uri r3 = r1.f5090a     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            boolean r1 = r1.f5091b     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.writeBoolean(r1)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            goto L_0x001f
        L_0x003a:
            r2.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0042:
            r0.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0046:
            r4 = move-exception
            goto L_0x0069
        L_0x0048:
            r4 = move-exception
            r1 = r2
            goto L_0x004f
        L_0x004b:
            r4 = move-exception
            r2 = r1
            goto L_0x0069
        L_0x004e:
            r4 = move-exception
        L_0x004f:
            r4.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005c:
            r0.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0064:
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x0069:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0073:
            r0.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.b.v.a(androidx.work.d):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[SYNTHETIC, Splitter:B:25:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061 A[SYNTHETIC, Splitter:B:36:0x0061] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0055=Splitter:B:29:0x0055, B:15:0x003a=Splitter:B:15:0x003a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.d a(byte[] r7) {
        /*
            androidx.work.d r0 = new androidx.work.d
            r0.<init>()
            if (r7 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            int r7 = r2.readInt()     // Catch:{ IOException -> 0x003e }
        L_0x0017:
            if (r7 <= 0) goto L_0x0032
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x003e }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ IOException -> 0x003e }
            boolean r4 = r2.readBoolean()     // Catch:{ IOException -> 0x003e }
            androidx.work.d$a r5 = new androidx.work.d$a     // Catch:{ IOException -> 0x003e }
            r5.<init>(r3, r4)     // Catch:{ IOException -> 0x003e }
            java.util.Set<androidx.work.d$a> r3 = r0.f5089a     // Catch:{ IOException -> 0x003e }
            r3.add(r5)     // Catch:{ IOException -> 0x003e }
            int r7 = r7 + -1
            goto L_0x0017
        L_0x0032:
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r7 = move-exception
            r7.printStackTrace()
        L_0x003a:
            r1.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x003e:
            r7 = move-exception
            goto L_0x0048
        L_0x0040:
            r0 = move-exception
            r2 = r7
            r7 = r0
            goto L_0x005f
        L_0x0044:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
        L_0x0048:
            r7.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0055:
            r1.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005d:
            return r0
        L_0x005e:
            r7 = move-exception
        L_0x005f:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0069:
            r1.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0071:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.b.v.a(byte[]):androidx.work.d");
    }
}
