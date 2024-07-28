package com.appsflyer.internal;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class aa {

    /* renamed from: ɩ  reason: contains not printable characters */
    private static aa f162 = new aa();

    private aa() {
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static aa m116() {
        return f162;
    }

    /* renamed from: ι  reason: contains not printable characters */
    public static File m119(Context context) {
        return new File(context.getFilesDir(), "AFRequestCache");
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static List<j> m117(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    new StringBuilder("Found cached request").append(file2.getName());
                    arrayList.add(m115(file2));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[SYNTHETIC, Splitter:B:13:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c A[SYNTHETIC, Splitter:B:21:0x002c] */
    /* renamed from: ı  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.j m115(java.io.File r4) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x0029, all -> 0x0021 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0029, all -> 0x0021 }
            long r2 = r4.length()     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            int r3 = (int) r2     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            char[] r2 = new char[r3]     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r1.read(r2)     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            com.appsflyer.internal.j r3 = new com.appsflyer.internal.j     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r3.f265 = r4     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r3
        L_0x001f:
            r4 = move-exception
            goto L_0x0023
        L_0x0021:
            r4 = move-exception
            r1 = r0
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            throw r4
        L_0x0029:
            r1 = r0
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aa.m115(java.io.File):com.appsflyer.internal.j");
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static void m118(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("Deleting ");
        sb.append(str);
        sb.append(" from cache");
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder("Could not delete ");
                sb2.append(str);
                sb2.append(" from cache");
            }
        }
    }
}
