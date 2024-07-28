package net.one97.paytm.common.utility;

import android.content.Context;
import android.os.Environment;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.io.File;

public final class c {
    public static void a(Context context, String str) {
        File file;
        if (context != null) {
            String a2 = b.a(str);
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    File externalCacheDir = context.getExternalCacheDir();
                    file = new File(externalCacheDir + "/paytm");
                } else {
                    String absolutePath = context.getCacheDir().getAbsolutePath();
                    file = new File(absolutePath + "/paytm");
                }
                if (file.exists()) {
                    File file2 = new File(file, a2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public static void a(Context context) {
        File file;
        if (context != null) {
            String a2 = b.a("ledger_list");
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    File externalCacheDir = context.getExternalCacheDir();
                    file = new File(externalCacheDir + "/paytm");
                } else {
                    String absolutePath = context.getCacheDir().getAbsolutePath();
                    file = new File(absolutePath + "/paytm");
                }
                if (file.exists()) {
                    File file2 = new File(file, a2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public static boolean b(Context context, String str) {
        File file;
        if (context == null) {
            return false;
        }
        String a2 = b.a(str);
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File externalCacheDir = context.getExternalCacheDir();
                file = new File(externalCacheDir + "/paytm");
            } else {
                String absolutePath = context.getCacheDir().getAbsolutePath();
                file = new File(absolutePath + "/paytm");
            }
            if (!file.exists()) {
                return false;
            }
            final File file2 = new File(file, a2);
            new Thread() {
                public final void run() {
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            }.start();
            return false;
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
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
    public static net.one97.paytm.common.entity.IJRDataModel c(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = com.paytm.utility.b.v
            java.lang.String r6 = com.paytm.utility.b.a((java.lang.String) r6)
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
            net.one97.paytm.common.entity.IJRDataModel r1 = (net.one97.paytm.common.entity.IJRDataModel) r1     // Catch:{ FileNotFoundException -> 0x0085, StreamCorruptedException -> 0x0082, IOException -> 0x007f, ClassNotFoundException -> 0x007d, Exception -> 0x007b }
            r6.close()     // Catch:{ IOException -> 0x0070 }
            r5.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0078
        L_0x0070:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
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
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x0119 }
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
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x0119 }
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
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x0119 }
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
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x0119 }
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
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x0119 }
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
            com.paytm.utility.q.b(r5)
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
            com.paytm.utility.q.b(r5)
        L_0x012f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.utility.c.c(android.content.Context, java.lang.String):net.one97.paytm.common.entity.IJRDataModel");
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        String[] list = file.list();
        for (int i2 = 0; i2 < list.length; i2++) {
            if (!a(str + File.separator + list[i2])) {
                return false;
            }
        }
        return file.delete();
    }
}
