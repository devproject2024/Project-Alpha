package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, n> f39409b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    final String f39410a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f39411c;

    private n(Context context, String str) {
        this.f39411c = context;
        this.f39410a = str;
    }

    public final synchronized Void a(f fVar) throws IOException {
        FileOutputStream openFileOutput = this.f39411c.openFileOutput(this.f39410a, 0);
        try {
            openFileOutput.write(fVar.toString().getBytes(AppConstants.UTF_8));
        } finally {
            openFileOutput.close();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036 A[SYNTHETIC, Splitter:B:16:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A[Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.firebase.remoteconfig.internal.f a() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            android.content.Context r1 = r6.f39411c     // Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }
            java.lang.String r2 = r6.f39410a     // Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }
            int r2 = r1.available()     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            byte[] r2 = new byte[r2]     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            r3 = 0
            int r4 = r2.length     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            r1.read(r2, r3, r4)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            java.lang.String r3 = new java.lang.String     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            r2.<init>(r3)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            com.google.firebase.remoteconfig.internal.f r0 = com.google.firebase.remoteconfig.internal.f.a(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            r1.close()     // Catch:{ all -> 0x0041 }
        L_0x002a:
            monitor-exit(r6)
            return r0
        L_0x002c:
            r0 = move-exception
            goto L_0x0034
        L_0x002e:
            goto L_0x003b
        L_0x0030:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ all -> 0x0041 }
        L_0x0039:
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x003a:
            r1 = r0
        L_0x003b:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0044
        L_0x0041:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0044:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.n.a():com.google.firebase.remoteconfig.internal.f");
    }

    public final synchronized Void b() {
        this.f39411c.deleteFile(this.f39410a);
        return null;
    }

    public static synchronized n a(Context context, String str) {
        n nVar;
        synchronized (n.class) {
            if (!f39409b.containsKey(str)) {
                f39409b.put(str, new n(context, str));
            }
            nVar = f39409b.get(str);
        }
        return nVar;
    }
}
