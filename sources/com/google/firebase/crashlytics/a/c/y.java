package com.google.firebase.crashlytics.a.c;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class y {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f38329a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    final File f38330b;

    public y(File file) {
        this.f38330b = file;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.firebase.crashlytics.a.c.ae a(java.lang.String r6) {
        /*
            r5 = this;
            java.io.File r6 = r5.b(r6)
            boolean r0 = r6.exists()
            if (r0 != 0) goto L_0x0010
            com.google.firebase.crashlytics.a.c.ae r6 = new com.google.firebase.crashlytics.a.c.ae
            r6.<init>()
            return r6
        L_0x0010:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f }
            r1.<init>(r6)     // Catch:{ Exception -> 0x003f }
            java.lang.String r6 = com.google.firebase.crashlytics.a.c.g.a((java.io.InputStream) r1)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            com.google.firebase.crashlytics.a.c.ae r6 = new com.google.firebase.crashlytics.a.c.ae     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r6.<init>()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.lang.String r3 = "userId"
            boolean r4 = r2.isNull(r3)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            if (r4 != 0) goto L_0x0031
            java.lang.String r0 = r2.optString(r3, r0)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
        L_0x0031:
            r6.a(r0)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r1)
            return r6
        L_0x0038:
            r6 = move-exception
            goto L_0x0050
        L_0x003a:
            r0 = r1
            goto L_0x003f
        L_0x003c:
            r6 = move-exception
            r1 = r0
            goto L_0x0050
        L_0x003f:
            com.google.firebase.crashlytics.a.b r6 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x003c }
            r1 = 6
            r6.a(r1)     // Catch:{ all -> 0x003c }
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r0)
            com.google.firebase.crashlytics.a.c.ae r6 = new com.google.firebase.crashlytics.a.c.ae
            r6.<init>()
            return r6
        L_0x0050:
            com.google.firebase.crashlytics.a.c.g.a((java.io.Closeable) r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.y.a(java.lang.String):com.google.firebase.crashlytics.a.c.ae");
    }

    public final File b(String str) {
        File file = this.f38330b;
        return new File(file, str + "user.meta");
    }

    static String a(final ae aeVar) throws JSONException {
        return new JSONObject() {
            {
                put("userId", ae.this.f38161a);
            }
        }.toString();
    }

    static String a(Map<String, String> map) throws JSONException {
        return new JSONObject(map).toString();
    }
}
