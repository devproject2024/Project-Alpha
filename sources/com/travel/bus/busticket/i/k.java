package com.travel.bus.busticket.i;

import com.paytm.utility.q;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static String f22448a = "CJRBusFileUtility";

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0093 A[SYNTHETIC, Splitter:B:38:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b A[Catch:{ Exception -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ad A[SYNTHETIC, Splitter:B:50:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b5 A[Catch:{ Exception -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bf A[SYNTHETIC, Splitter:B:59:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c7 A[Catch:{ Exception -> 0x00cd }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x00a4=Splitter:B:47:0x00a4, B:35:0x008a=Splitter:B:35:0x008a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3, com.paytm.network.model.IJRPaytmDataModel r4, java.lang.String r5) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "/paytm"
            java.lang.String r5 = a(r5)
            java.lang.String r1 = android.os.Environment.getExternalStorageState()
            java.lang.String r2 = "mounted"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x002e
            java.io.File r3 = r3.getExternalCacheDir()
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = r2.toString()
            r1.<init>(r3)
            goto L_0x004a
        L_0x002e:
            java.io.File r3 = r3.getCacheDir()
            java.lang.String r3 = r3.getAbsolutePath()
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = r2.toString()
            r1.<init>(r3)
        L_0x004a:
            boolean r3 = r1.exists()
            if (r3 != 0) goto L_0x0053
            r1.mkdirs()
        L_0x0053:
            java.io.File r3 = new java.io.File
            r3.<init>(r1, r5)
            r5 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a2, Exception -> 0x0088, all -> 0x0085 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x00a2, Exception -> 0x0088, all -> 0x0085 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0081, Exception -> 0x007d, all -> 0x0079 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0081, Exception -> 0x007d, all -> 0x0079 }
            r3.writeObject(r4)     // Catch:{ IOException -> 0x0077, Exception -> 0x0075, all -> 0x0073 }
            r0.flush()     // Catch:{ Exception -> 0x0072 }
            r0.close()     // Catch:{ Exception -> 0x0072 }
            r3.flush()     // Catch:{ Exception -> 0x0072 }
            r3.close()     // Catch:{ Exception -> 0x0072 }
        L_0x0072:
            return
        L_0x0073:
            r4 = move-exception
            goto L_0x007b
        L_0x0075:
            r4 = move-exception
            goto L_0x007f
        L_0x0077:
            r4 = move-exception
            goto L_0x0083
        L_0x0079:
            r4 = move-exception
            r3 = r5
        L_0x007b:
            r5 = r0
            goto L_0x00bd
        L_0x007d:
            r4 = move-exception
            r3 = r5
        L_0x007f:
            r5 = r0
            goto L_0x008a
        L_0x0081:
            r4 = move-exception
            r3 = r5
        L_0x0083:
            r5 = r0
            goto L_0x00a4
        L_0x0085:
            r4 = move-exception
            r3 = r5
            goto L_0x00bd
        L_0x0088:
            r4 = move-exception
            r3 = r5
        L_0x008a:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00bc }
            com.paytm.utility.q.c(r4)     // Catch:{ all -> 0x00bc }
            if (r5 == 0) goto L_0x0096
            r5.flush()     // Catch:{ Exception -> 0x00a1 }
        L_0x0096:
            r5.close()     // Catch:{ Exception -> 0x00a1 }
            if (r3 == 0) goto L_0x009e
            r3.flush()     // Catch:{ Exception -> 0x00a1 }
        L_0x009e:
            r3.close()     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            return
        L_0x00a2:
            r4 = move-exception
            r3 = r5
        L_0x00a4:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00bc }
            com.paytm.utility.q.c(r4)     // Catch:{ all -> 0x00bc }
            if (r5 == 0) goto L_0x00b0
            r5.flush()     // Catch:{ Exception -> 0x00bb }
        L_0x00b0:
            r5.close()     // Catch:{ Exception -> 0x00bb }
            if (r3 == 0) goto L_0x00b8
            r3.flush()     // Catch:{ Exception -> 0x00bb }
        L_0x00b8:
            r3.close()     // Catch:{ Exception -> 0x00bb }
        L_0x00bb:
            return
        L_0x00bc:
            r4 = move-exception
        L_0x00bd:
            if (r5 == 0) goto L_0x00c2
            r5.flush()     // Catch:{ Exception -> 0x00cd }
        L_0x00c2:
            r5.close()     // Catch:{ Exception -> 0x00cd }
            if (r3 == 0) goto L_0x00ca
            r3.flush()     // Catch:{ Exception -> 0x00cd }
        L_0x00ca:
            r3.close()     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.i.k.a(android.content.Context, com.paytm.network.model.IJRPaytmDataModel, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b0 A[SYNTHETIC, Splitter:B:46:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b5 A[Catch:{ IOException -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c6 A[SYNTHETIC, Splitter:B:55:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cb A[Catch:{ IOException -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00db A[SYNTHETIC, Splitter:B:64:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e0 A[Catch:{ IOException -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f0 A[SYNTHETIC, Splitter:B:73:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f5 A[Catch:{ IOException -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0105 A[SYNTHETIC, Splitter:B:82:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010d A[Catch:{ IOException -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011c A[SYNTHETIC, Splitter:B:91:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0124 A[Catch:{ IOException -> 0x0120 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x00d2=Splitter:B:61:0x00d2, B:43:0x00a7=Splitter:B:43:0x00a7, B:70:0x00e7=Splitter:B:70:0x00e7, B:79:0x00fc=Splitter:B:79:0x00fc, B:52:0x00bd=Splitter:B:52:0x00bd} */
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
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00f9, StreamCorruptedException -> 0x00e4, IOException -> 0x00cf, ClassNotFoundException -> 0x00ba, Exception -> 0x00a4, all -> 0x009e }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00f9, StreamCorruptedException -> 0x00e4, IOException -> 0x00cf, ClassNotFoundException -> 0x00ba, Exception -> 0x00a4, all -> 0x009e }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x009a, StreamCorruptedException -> 0x0097, IOException -> 0x0094, ClassNotFoundException -> 0x0091, Exception -> 0x008e, all -> 0x0088 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x009a, StreamCorruptedException -> 0x0097, IOException -> 0x0094, ClassNotFoundException -> 0x0091, Exception -> 0x008e, all -> 0x0088 }
            java.lang.Object r1 = r5.readObject()     // Catch:{ FileNotFoundException -> 0x0085, StreamCorruptedException -> 0x0082, IOException -> 0x007f, ClassNotFoundException -> 0x007d, Exception -> 0x007b }
            com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1     // Catch:{ FileNotFoundException -> 0x0085, StreamCorruptedException -> 0x0082, IOException -> 0x007f, ClassNotFoundException -> 0x007d, Exception -> 0x007b }
            r6.close()     // Catch:{ IOException -> 0x0070 }
            r5.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0078
        L_0x0070:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.c(r5)
        L_0x0078:
            r0 = r1
            goto L_0x0118
        L_0x007b:
            r1 = move-exception
            goto L_0x00a7
        L_0x007d:
            r1 = move-exception
            goto L_0x00bd
        L_0x007f:
            r1 = move-exception
            goto L_0x00d2
        L_0x0082:
            r1 = move-exception
            goto L_0x00e7
        L_0x0085:
            r1 = move-exception
            goto L_0x00fc
        L_0x0088:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x011a
        L_0x008e:
            r1 = move-exception
            r5 = r0
            goto L_0x00a7
        L_0x0091:
            r1 = move-exception
            r5 = r0
            goto L_0x00bd
        L_0x0094:
            r1 = move-exception
            r5 = r0
            goto L_0x00d2
        L_0x0097:
            r1 = move-exception
            r5 = r0
            goto L_0x00e7
        L_0x009a:
            r1 = move-exception
            r5 = r0
            goto L_0x00fc
        L_0x009e:
            r5 = move-exception
            r6 = r0
            r0 = r5
            r5 = r6
            goto L_0x011a
        L_0x00a4:
            r1 = move-exception
            r5 = r0
            r6 = r5
        L_0x00a7:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0119 }
            com.paytm.utility.q.c(r1)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x00b3
            r6.close()     // Catch:{ IOException -> 0x0109 }
        L_0x00b3:
            if (r5 == 0) goto L_0x0118
            r5.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0118
        L_0x00ba:
            r1 = move-exception
            r5 = r0
            r6 = r5
        L_0x00bd:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0119 }
            com.paytm.utility.q.c(r1)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x00c9
            r6.close()     // Catch:{ IOException -> 0x0109 }
        L_0x00c9:
            if (r5 == 0) goto L_0x0118
            r5.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0118
        L_0x00cf:
            r1 = move-exception
            r5 = r0
            r6 = r5
        L_0x00d2:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0119 }
            com.paytm.utility.q.c(r1)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x00de
            r6.close()     // Catch:{ IOException -> 0x0109 }
        L_0x00de:
            if (r5 == 0) goto L_0x0118
            r5.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0118
        L_0x00e4:
            r1 = move-exception
            r5 = r0
            r6 = r5
        L_0x00e7:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0119 }
            com.paytm.utility.q.c(r1)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x00f3
            r6.close()     // Catch:{ IOException -> 0x0109 }
        L_0x00f3:
            if (r5 == 0) goto L_0x0118
            r5.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0118
        L_0x00f9:
            r1 = move-exception
            r5 = r0
            r6 = r5
        L_0x00fc:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0119 }
            com.paytm.utility.q.c(r1)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x010b
            r6.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x010b
        L_0x0109:
            r5 = move-exception
            goto L_0x0111
        L_0x010b:
            if (r5 == 0) goto L_0x0118
            r5.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0118
        L_0x0111:
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.c(r5)
        L_0x0118:
            return r0
        L_0x0119:
            r0 = move-exception
        L_0x011a:
            if (r6 == 0) goto L_0x0122
            r6.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0122
        L_0x0120:
            r5 = move-exception
            goto L_0x0128
        L_0x0122:
            if (r5 == 0) goto L_0x012f
            r5.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x012f
        L_0x0128:
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.c(r5)
        L_0x012f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.i.k.a(android.content.Context, java.lang.String):com.paytm.network.model.IJRPaytmDataModel");
    }

    private static String a(String str) {
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
        } catch (NoSuchAlgorithmException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }
}
