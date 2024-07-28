package com.bumptech.glide.load.c;

import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.InputStream;

public final class t implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final b f7084a;

    public final /* bridge */ /* synthetic */ boolean a(Object obj, File file, i iVar) {
        return a((InputStream) obj, file);
    }

    public t(b bVar) {
        this.f7084a = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035 A[SYNTHETIC, Splitter:B:21:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040 A[SYNTHETIC, Splitter:B:27:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.InputStream r5, java.io.File r6) {
        /*
            r4 = this;
            com.bumptech.glide.load.b.a.b r0 = r4.f7084a
            java.lang.Class<byte[]> r1 = byte[].class
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r0 = r0.a(r2, r1)
            byte[] r0 = (byte[]) r0
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002d }
            r3.<init>(r6)     // Catch:{ IOException -> 0x002d }
        L_0x0013:
            int r6 = r5.read(r0)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r2 = -1
            if (r6 == r2) goto L_0x001e
            r3.write(r0, r1, r6)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            goto L_0x0013
        L_0x001e:
            r3.close()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r1 = 1
            r3.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0038
        L_0x0026:
            r5 = move-exception
            r2 = r3
            goto L_0x003e
        L_0x0029:
            r2 = r3
            goto L_0x002d
        L_0x002b:
            r5 = move-exception
            goto L_0x003e
        L_0x002d:
            java.lang.String r5 = "StreamEncoder"
            r6 = 3
            android.util.Log.isLoggable(r5, r6)     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0038
            r2.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            com.bumptech.glide.load.b.a.b r5 = r4.f7084a
            r5.a(r0)
            return r1
        L_0x003e:
            if (r2 == 0) goto L_0x0043
            r2.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            com.bumptech.glide.load.b.a.b r6 = r4.f7084a
            r6.a(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.c.t.a(java.io.InputStream, java.io.File):boolean");
    }
}
