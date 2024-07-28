package net.one97.paytm.fastag.f;

public final class b {
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6 A[SYNTHETIC, Splitter:B:48:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ac A[SYNTHETIC, Splitter:B:51:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(java.lang.String r12) {
        /*
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r2 = 1
            r1.inJustDecodeBounds = r2
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeFile(r12, r1)
            int r4 = r1.outHeight
            int r5 = r1.outWidth
            r6 = 816(0x330, float:1.143E-42)
            if (r4 > r6) goto L_0x001d
            if (r5 <= r6) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r7 = 1
            goto L_0x002d
        L_0x001d:
            int r4 = r4 / 2
            int r5 = r5 / 2
            r7 = 1
        L_0x0022:
            int r8 = r4 / r7
            if (r8 < r6) goto L_0x002d
            int r8 = r5 / r7
            if (r8 < r6) goto L_0x002d
            int r7 = r7 * 2
            goto L_0x0022
        L_0x002d:
            r1.inSampleSize = r7
            r4 = 0
            r1.inJustDecodeBounds = r4
            r1.inPurgeable = r2
            r1.inInputShareable = r2
            r2 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r2]
            r1.inTempStorage = r2
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeFile(r12, r1)     // Catch:{ OutOfMemoryError -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0045:
            if (r3 == 0) goto L_0x00b0
            android.media.ExifInterface r1 = new android.media.ExifInterface     // Catch:{ IOException -> 0x0084 }
            r1.<init>(r12)     // Catch:{ IOException -> 0x0084 }
            java.lang.String r2 = "Orientation"
            int r1 = r1.getAttributeInt(r2, r4)     // Catch:{ IOException -> 0x0084 }
            android.graphics.Matrix r10 = new android.graphics.Matrix     // Catch:{ IOException -> 0x0084 }
            r10.<init>()     // Catch:{ IOException -> 0x0084 }
            r2 = 6
            if (r1 != r2) goto L_0x0060
            r1 = 1119092736(0x42b40000, float:90.0)
            r10.postRotate(r1)     // Catch:{ IOException -> 0x0084 }
            goto L_0x0072
        L_0x0060:
            r2 = 3
            if (r1 != r2) goto L_0x0069
            r1 = 1127481344(0x43340000, float:180.0)
            r10.postRotate(r1)     // Catch:{ IOException -> 0x0084 }
            goto L_0x0072
        L_0x0069:
            r2 = 8
            if (r1 != r2) goto L_0x0072
            r1 = 1132920832(0x43870000, float:270.0)
            r10.postRotate(r1)     // Catch:{ IOException -> 0x0084 }
        L_0x0072:
            r6 = 0
            r7 = 0
            int r8 = r3.getWidth()     // Catch:{ IOException -> 0x0084 }
            int r9 = r3.getHeight()     // Catch:{ IOException -> 0x0084 }
            r11 = 1
            r5 = r3
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ IOException -> 0x0084 }
            r3 = r1
            goto L_0x0088
        L_0x0084:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0088:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00a0 }
            r1.<init>(r12)     // Catch:{ FileNotFoundException -> 0x00a0 }
            android.graphics.Bitmap$CompressFormat r12 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException -> 0x009b, all -> 0x0098 }
            r0 = 100
            r3.compress(r12, r0, r1)     // Catch:{ FileNotFoundException -> 0x009b, all -> 0x0098 }
            r1.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b0
        L_0x0098:
            r12 = move-exception
            r0 = r1
            goto L_0x00aa
        L_0x009b:
            r12 = move-exception
            r0 = r1
            goto L_0x00a1
        L_0x009e:
            r12 = move-exception
            goto L_0x00aa
        L_0x00a0:
            r12 = move-exception
        L_0x00a1:
            r12.printStackTrace()     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x00b0
            r0.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b0
        L_0x00aa:
            if (r0 == 0) goto L_0x00af
            r0.close()     // Catch:{ IOException -> 0x00af }
        L_0x00af:
            throw r12
        L_0x00b0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastag.f.b.a(java.lang.String):android.graphics.Bitmap");
    }
}
