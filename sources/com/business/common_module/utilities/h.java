package com.business.common_module.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class h {
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.io.InputStream r2) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0014 }
            a(r2, r0, r1)     // Catch:{ all -> 0x0014 }
            byte[] r2 = r0.toByteArray()     // Catch:{ all -> 0x0014 }
            r0.close()
            return r2
        L_0x0014:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x001f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common_module.utilities.h.a(java.io.InputStream):byte[]");
    }

    private static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
