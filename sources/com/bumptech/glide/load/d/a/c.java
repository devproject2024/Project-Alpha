package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;

public final class c implements l<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final h<Integer> f7134a = h.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: b  reason: collision with root package name */
    public static final h<Bitmap.CompressFormat> f7135b = h.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: c  reason: collision with root package name */
    private final b f7136c;

    public c(b bVar) {
        this.f7136c = bVar;
    }

    @Deprecated
    public c() {
        this.f7136c = null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:27|(2:41|42)|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r6 != null) goto L_0x0058;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b3 */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0 A[SYNTHETIC, Splitter:B:41:0x00b0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.bumptech.glide.load.b.v<android.graphics.Bitmap> r9, java.io.File r10, com.bumptech.glide.load.i r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.b()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            com.bumptech.glide.load.h<android.graphics.Bitmap$CompressFormat> r1 = f7135b
            java.lang.Object r1 = r11.a(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L_0x0013
            goto L_0x001e
        L_0x0013:
            boolean r1 = r9.hasAlpha()
            if (r1 == 0) goto L_0x001c
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x001e
        L_0x001c:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x001e:
            int r2 = r9.getWidth()
            java.lang.Integer.valueOf(r2)
            int r2 = r9.getHeight()
            java.lang.Integer.valueOf(r2)
            long r2 = com.bumptech.glide.g.f.a()     // Catch:{ all -> 0x00b4 }
            com.bumptech.glide.load.h<java.lang.Integer> r4 = f7134a     // Catch:{ all -> 0x00b4 }
            java.lang.Object r4 = r11.a(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00b4 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00b4 }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0063 }
            r7.<init>(r10)     // Catch:{ IOException -> 0x0063 }
            com.bumptech.glide.load.b.a.b r10 = r8.f7136c     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            if (r10 == 0) goto L_0x0050
            com.bumptech.glide.load.a.c r10 = new com.bumptech.glide.load.a.c     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            com.bumptech.glide.load.b.a.b r6 = r8.f7136c     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r10.<init>(r7, r6)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r6 = r10
            goto L_0x0051
        L_0x0050:
            r6 = r7
        L_0x0051:
            r9.compress(r1, r4, r6)     // Catch:{ IOException -> 0x0063 }
            r6.close()     // Catch:{ IOException -> 0x0063 }
            r5 = 1
        L_0x0058:
            r6.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006a
        L_0x005c:
            r9 = move-exception
            r6 = r7
            goto L_0x00ae
        L_0x005f:
            r6 = r7
            goto L_0x0063
        L_0x0061:
            r9 = move-exception
            goto L_0x00ae
        L_0x0063:
            r10 = 3
            android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x0061 }
            if (r6 == 0) goto L_0x006a
            goto L_0x0058
        L_0x006a:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x00b4 }
            if (r10 == 0) goto L_0x00ad
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            java.lang.String r0 = "Compressed with type: "
            r10.<init>(r0)     // Catch:{ all -> 0x00b4 }
            r10.append(r1)     // Catch:{ all -> 0x00b4 }
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch:{ all -> 0x00b4 }
            int r0 = com.bumptech.glide.g.k.a((android.graphics.Bitmap) r9)     // Catch:{ all -> 0x00b4 }
            r10.append(r0)     // Catch:{ all -> 0x00b4 }
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch:{ all -> 0x00b4 }
            double r0 = com.bumptech.glide.g.f.a(r2)     // Catch:{ all -> 0x00b4 }
            r10.append(r0)     // Catch:{ all -> 0x00b4 }
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch:{ all -> 0x00b4 }
            com.bumptech.glide.load.h<android.graphics.Bitmap$CompressFormat> r0 = f7135b     // Catch:{ all -> 0x00b4 }
            java.lang.Object r11 = r11.a(r0)     // Catch:{ all -> 0x00b4 }
            r10.append(r11)     // Catch:{ all -> 0x00b4 }
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch:{ all -> 0x00b4 }
            boolean r9 = r9.hasAlpha()     // Catch:{ all -> 0x00b4 }
            r10.append(r9)     // Catch:{ all -> 0x00b4 }
        L_0x00ad:
            return r5
        L_0x00ae:
            if (r6 == 0) goto L_0x00b3
            r6.close()     // Catch:{ IOException -> 0x00b3 }
        L_0x00b3:
            throw r9     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.c.a(com.bumptech.glide.load.b.v, java.io.File, com.bumptech.glide.load.i):boolean");
    }

    public final com.bumptech.glide.load.c a(i iVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }
}
