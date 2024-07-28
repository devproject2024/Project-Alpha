package net.one97.paytmflight.common.b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087 A[SYNTHETIC, Splitter:B:37:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c A[Catch:{ IOException -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094 A[SYNTHETIC, Splitter:B:47:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a1 A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6 A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ab A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b0 A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b5 A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ba A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00bf A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.network.model.IJRPaytmDataModel a(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = com.paytm.utility.b.v
            java.lang.String r6 = a(r6)
            java.lang.String r1 = "/paytm"
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0031
            java.io.File r5 = r5.getExternalCacheDir()
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            r2.<init>(r5)
            goto L_0x004d
        L_0x0031:
            java.io.File r5 = r5.getCacheDir()
            java.lang.String r5 = r5.getAbsolutePath()
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            r2.<init>(r5)
        L_0x004d:
            boolean r5 = r2.exists()
            if (r5 != 0) goto L_0x0054
            return r0
        L_0x0054:
            java.io.File r5 = new java.io.File
            r5.<init>(r2, r6)
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bb, StreamCorruptedException -> 0x00b1, IOException -> 0x00a7, ClassNotFoundException -> 0x009d, Exception -> 0x0090, all -> 0x0083 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00bb, StreamCorruptedException -> 0x00b1, IOException -> 0x00a7, ClassNotFoundException -> 0x009d, Exception -> 0x0090, all -> 0x0083 }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x0081, StreamCorruptedException -> 0x007f, IOException -> 0x007d, ClassNotFoundException -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0081, StreamCorruptedException -> 0x007f, IOException -> 0x007d, ClassNotFoundException -> 0x007b, Exception -> 0x0079, all -> 0x0077 }
            java.lang.Object r1 = r5.readObject()     // Catch:{ FileNotFoundException -> 0x00bd, StreamCorruptedException -> 0x00b3, IOException -> 0x00a9, ClassNotFoundException -> 0x009f, Exception -> 0x0092, all -> 0x0072 }
            com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1     // Catch:{ FileNotFoundException -> 0x00bd, StreamCorruptedException -> 0x00b3, IOException -> 0x00a9, ClassNotFoundException -> 0x009f, Exception -> 0x0092, all -> 0x0072 }
            r6.close()     // Catch:{ IOException -> 0x006f }
            r5.close()     // Catch:{ IOException -> 0x006f }
        L_0x006f:
            r0 = r1
            goto L_0x00c5
        L_0x0072:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0085
        L_0x0077:
            r5 = move-exception
            goto L_0x0085
        L_0x0079:
            r5 = r0
            goto L_0x0092
        L_0x007b:
            r5 = r0
            goto L_0x009f
        L_0x007d:
            r5 = r0
            goto L_0x00a9
        L_0x007f:
            r5 = r0
            goto L_0x00b3
        L_0x0081:
            r5 = r0
            goto L_0x00bd
        L_0x0083:
            r5 = move-exception
            r6 = r0
        L_0x0085:
            if (r6 == 0) goto L_0x008a
            r6.close()     // Catch:{ IOException -> 0x008f }
        L_0x008a:
            if (r0 == 0) goto L_0x008f
            r0.close()     // Catch:{ IOException -> 0x008f }
        L_0x008f:
            throw r5
        L_0x0090:
            r5 = r0
            r6 = r5
        L_0x0092:
            if (r6 == 0) goto L_0x0097
            r6.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x0097:
            if (r5 == 0) goto L_0x00c5
        L_0x0099:
            r5.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c5
        L_0x009d:
            r5 = r0
            r6 = r5
        L_0x009f:
            if (r6 == 0) goto L_0x00a4
            r6.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00a4:
            if (r5 == 0) goto L_0x00c5
            goto L_0x0099
        L_0x00a7:
            r5 = r0
            r6 = r5
        L_0x00a9:
            if (r6 == 0) goto L_0x00ae
            r6.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00ae:
            if (r5 == 0) goto L_0x00c5
            goto L_0x0099
        L_0x00b1:
            r5 = r0
            r6 = r5
        L_0x00b3:
            if (r6 == 0) goto L_0x00b8
            r6.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00b8:
            if (r5 == 0) goto L_0x00c5
            goto L_0x0099
        L_0x00bb:
            r5 = r0
            r6 = r5
        L_0x00bd:
            if (r6 == 0) goto L_0x00c2
            r6.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00c2:
            if (r5 == 0) goto L_0x00c5
            goto L_0x0099
        L_0x00c5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytmflight.common.b.c.a(android.content.Context, java.lang.String):com.paytm.network.model.IJRPaytmDataModel");
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length << 1);
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(Character.forDigit((digest[i2] & 240) >> 4, 16));
                sb.append(Character.forDigit(digest[i2] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
