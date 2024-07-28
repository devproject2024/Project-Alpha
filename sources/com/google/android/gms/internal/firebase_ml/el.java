package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.j;

public final class el {

    /* renamed from: a  reason: collision with root package name */
    private static final j f9866a = new j("MLKitImageUtils", "");

    /* renamed from: b  reason: collision with root package name */
    private static el f9867b = new el();

    private el() {
    }

    public static el a() {
        return f9867b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r5 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r8 = android.graphics.Bitmap.createBitmap(r7, 0, 0, r3, r4, r5, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if (r7 == r8) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r7.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
        r5 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.content.ContentResolver r8, android.net.Uri r9) throws java.io.IOException {
        /*
            android.graphics.Bitmap r7 = android.provider.MediaStore.Images.Media.getBitmap(r8, r9)     // Catch:{ FileNotFoundException -> 0x005f }
            int r8 = b(r8, r9)     // Catch:{ FileNotFoundException -> 0x005f }
            android.graphics.Matrix r0 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x005f }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x005f }
            int r3 = r7.getWidth()     // Catch:{ FileNotFoundException -> 0x005f }
            int r4 = r7.getHeight()     // Catch:{ FileNotFoundException -> 0x005f }
            r1 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r2 = 1119092736(0x42b40000, float:90.0)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            switch(r8) {
                case 2: goto L_0x0044;
                case 3: goto L_0x003d;
                case 4: goto L_0x0039;
                case 5: goto L_0x0032;
                case 6: goto L_0x002e;
                case 7: goto L_0x0027;
                case 8: goto L_0x0023;
                default: goto L_0x0020;
            }     // Catch:{ FileNotFoundException -> 0x005f }
        L_0x0020:
            r8 = 0
        L_0x0021:
            r5 = r8
            goto L_0x004d
        L_0x0023:
            r0.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x005f }
            goto L_0x0042
        L_0x0027:
            r0.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x005f }
            r0.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005f }
            goto L_0x0042
        L_0x002e:
            r0.postRotate(r2)     // Catch:{ FileNotFoundException -> 0x005f }
            goto L_0x0042
        L_0x0032:
            r0.postRotate(r2)     // Catch:{ FileNotFoundException -> 0x005f }
            r0.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005f }
            goto L_0x0042
        L_0x0039:
            r0.postScale(r6, r5)     // Catch:{ FileNotFoundException -> 0x005f }
            goto L_0x0042
        L_0x003d:
            r8 = 1127481344(0x43340000, float:180.0)
            r0.postRotate(r8)     // Catch:{ FileNotFoundException -> 0x005f }
        L_0x0042:
            r5 = r0
            goto L_0x004d
        L_0x0044:
            android.graphics.Matrix r8 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x005f }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x005f }
            r8.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005f }
            goto L_0x0021
        L_0x004d:
            if (r5 == 0) goto L_0x005d
            r1 = 0
            r2 = 0
            r6 = 1
            r0 = r7
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ FileNotFoundException -> 0x005f }
            if (r7 == r8) goto L_0x005d
            r7.recycle()     // Catch:{ FileNotFoundException -> 0x005f }
            goto L_0x005e
        L_0x005d:
            r8 = r7
        L_0x005e:
            return r8
        L_0x005f:
            r8 = move-exception
            com.google.android.gms.common.internal.j r0 = f9866a
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r1 = java.lang.String.valueOf(r9)
            int r1 = r1.length()
            int r1 = r1 + 21
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Could not open file: "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r0.d(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.el.a(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(android.content.ContentResolver r4, android.net.Uri r5) {
        /*
            java.lang.String r0 = r5.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            r1 = 0
            if (r0 != 0) goto L_0x001a
            java.lang.String r0 = r5.getScheme()
            java.lang.String r2 = "file"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x001a
            return r1
        L_0x001a:
            r0 = 0
            java.io.InputStream r4 = r4.openInputStream(r5)     // Catch:{ IOException -> 0x0036 }
            androidx.exifinterface.a.a r2 = new androidx.exifinterface.a.a     // Catch:{ all -> 0x002a }
            r2.<init>((java.io.InputStream) r4)     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x005b
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x005b
        L_0x002a:
            r2 = move-exception
            if (r4 == 0) goto L_0x0035
            r4.close()     // Catch:{ all -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r4 = move-exception
            com.google.android.gms.internal.firebase_ml.az.a(r2, r4)     // Catch:{ IOException -> 0x0036 }
        L_0x0035:
            throw r2     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            r2 = r0
        L_0x0037:
            com.google.android.gms.common.internal.j r4 = f9866a
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = java.lang.String.valueOf(r5)
            int r0 = r0.length()
            int r0 = r0 + 48
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "failed to open file to read rotation meta data: "
            r3.append(r0)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r4.d(r5)
        L_0x005b:
            if (r2 != 0) goto L_0x005e
            return r1
        L_0x005e:
            java.lang.String r4 = "Orientation"
            int r4 = r2.a((java.lang.String) r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.el.b(android.content.ContentResolver, android.net.Uri):int");
    }
}
