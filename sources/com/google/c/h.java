package com.google.c;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<SoftReference<byte[]>> f37851a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f37852b;

    /* renamed from: c  reason: collision with root package name */
    private static final long f37853c;

    static {
        Class<?> a2 = a("java.io.FileOutputStream");
        f37852b = a2;
        f37853c = a(a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if ((r4 < r1 && ((float) r4) < ((float) r1) * 0.5f) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.nio.ByteBuffer r7, java.io.OutputStream r8) throws java.io.IOException {
        /*
            int r0 = r7.position()
            boolean r1 = r7.hasArray()     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x001f
            byte[] r1 = r7.array()     // Catch:{ all -> 0x0080 }
            int r2 = r7.arrayOffset()     // Catch:{ all -> 0x0080 }
            int r3 = r7.position()     // Catch:{ all -> 0x0080 }
            int r2 = r2 + r3
            int r3 = r7.remaining()     // Catch:{ all -> 0x0080 }
            r8.write(r1, r2, r3)     // Catch:{ all -> 0x0080 }
            goto L_0x007c
        L_0x001f:
            boolean r1 = b(r7, r8)     // Catch:{ all -> 0x0080 }
            if (r1 != 0) goto L_0x007c
            int r1 = r7.remaining()     // Catch:{ all -> 0x0080 }
            r2 = 1024(0x400, float:1.435E-42)
            int r1 = java.lang.Math.max(r1, r2)     // Catch:{ all -> 0x0080 }
            java.lang.ThreadLocal<java.lang.ref.SoftReference<byte[]>> r2 = f37851a     // Catch:{ all -> 0x0080 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0080 }
            java.lang.ref.SoftReference r2 = (java.lang.ref.SoftReference) r2     // Catch:{ all -> 0x0080 }
            if (r2 != 0) goto L_0x003b
            r2 = 0
            goto L_0x0041
        L_0x003b:
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0080 }
            byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x0080 }
        L_0x0041:
            r3 = 0
            if (r2 == 0) goto L_0x0056
            int r4 = r2.length     // Catch:{ all -> 0x0080 }
            if (r4 >= r1) goto L_0x0053
            float r4 = (float) r4     // Catch:{ all -> 0x0080 }
            float r5 = (float) r1     // Catch:{ all -> 0x0080 }
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0053
            r4 = 1
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            if (r4 == 0) goto L_0x0066
        L_0x0056:
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x0080 }
            r4 = 16384(0x4000, float:2.2959E-41)
            if (r1 > r4) goto L_0x0066
            java.lang.ThreadLocal<java.lang.ref.SoftReference<byte[]>> r1 = f37851a     // Catch:{ all -> 0x0080 }
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x0080 }
            r4.<init>(r2)     // Catch:{ all -> 0x0080 }
            r1.set(r4)     // Catch:{ all -> 0x0080 }
        L_0x0066:
            boolean r1 = r7.hasRemaining()     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x007c
            int r1 = r7.remaining()     // Catch:{ all -> 0x0080 }
            int r4 = r2.length     // Catch:{ all -> 0x0080 }
            int r1 = java.lang.Math.min(r1, r4)     // Catch:{ all -> 0x0080 }
            r7.get(r2, r3, r1)     // Catch:{ all -> 0x0080 }
            r8.write(r2, r3, r1)     // Catch:{ all -> 0x0080 }
            goto L_0x0066
        L_0x007c:
            r7.position(r0)
            return
        L_0x0080:
            r8 = move-exception
            r7.position(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.h.a(java.nio.ByteBuffer, java.io.OutputStream):void");
    }

    private static boolean b(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        WritableByteChannel writableByteChannel;
        if (f37853c < 0 || !f37852b.isInstance(outputStream)) {
            return false;
        }
        try {
            writableByteChannel = (WritableByteChannel) bx.f(outputStream, f37853c);
        } catch (ClassCastException unused) {
            writableByteChannel = null;
        }
        if (writableByteChannel == null) {
            return false;
        }
        writableByteChannel.write(byteBuffer);
        return true;
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static long a(Class<?> cls) {
        if (cls == null) {
            return -1;
        }
        try {
            if (bx.a()) {
                return bx.a(cls.getDeclaredField("channel"));
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
