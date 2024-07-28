package com.appsflyer.internal;

import android.content.Context;

public final class ac extends ContentFetcher<String> {
    public ac(Context context) {
        super(context, "com.facebook.katana.provider.AttributionIdProvider", "e3f9e1e0cf99d0e56a055ba65e241b3399f7cea524326b0cdd6ec1327ed0fdc1", 500);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final String m124() {
        start();
        return (String) super.get();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* renamed from: ǃ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String query() {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r1 = "aid"
            android.content.Context r2 = r9.context     // Catch:{ all -> 0x0048 }
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = "content://"
            r2.<init>(r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = r9.authority     // Catch:{ all -> 0x0048 }
            r2.append(r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0048 }
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0048 }
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch:{ all -> 0x0048 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0042
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x0042
            int r0 = r2.getColumnIndex(r1)     // Catch:{ all -> 0x003e }
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x003d
            r2.close()
        L_0x003d:
            return r0
        L_0x003e:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x0049
        L_0x0042:
            if (r2 == 0) goto L_0x0047
            r2.close()
        L_0x0047:
            return r0
        L_0x0048:
            r1 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()
        L_0x004e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ac.query():java.lang.String");
    }

    public final /* synthetic */ Object get() {
        start();
        return (String) super.get();
    }
}
