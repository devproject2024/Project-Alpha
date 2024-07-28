package com.travel.flight.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.paytm.network.model.IJRPaytmDataModel;

public final class b extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private int f25577a = 112;

    /* renamed from: b  reason: collision with root package name */
    private Context f25578b;

    /* renamed from: c  reason: collision with root package name */
    private IJRPaytmDataModel f25579c;

    /* renamed from: d  reason: collision with root package name */
    private String f25580d;

    /* renamed from: e  reason: collision with root package name */
    private com.travel.flight.f.b f25581e;

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    public b(Context context, IJRPaytmDataModel iJRPaytmDataModel, String str) {
        this.f25578b = context;
        this.f25579c = iJRPaytmDataModel;
        this.f25580d = str;
        this.f25581e = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009a, code lost:
        if (r0 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ab, code lost:
        if (r0 == null) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094 A[Catch:{ Exception -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a5 A[SYNTHETIC, Splitter:B:46:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b2 A[SYNTHETIC, Splitter:B:53:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ba A[Catch:{ Exception -> 0x00c0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Void a() {
        /*
            r7 = this;
            int r0 = r7.f25577a
            r1 = 111(0x6f, float:1.56E-43)
            r2 = 0
            if (r0 == r1) goto L_0x00c1
            r1 = 112(0x70, float:1.57E-43)
            if (r0 == r1) goto L_0x000d
            goto L_0x00cb
        L_0x000d:
            android.content.Context r0 = r7.f25578b
            com.paytm.network.model.IJRPaytmDataModel r1 = r7.f25579c
            java.lang.String r3 = r7.f25580d
            if (r0 == 0) goto L_0x00cb
            java.lang.String r4 = "/paytm"
            java.lang.String r3 = net.one97.paytmflight.common.b.c.a(r3)
            java.lang.String r5 = android.os.Environment.getExternalStorageState()
            java.lang.String r6 = "mounted"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0040
            java.io.File r0 = r0.getExternalCacheDir()
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            r5.<init>(r0)
            goto L_0x005c
        L_0x0040:
            java.io.File r0 = r0.getCacheDir()
            java.lang.String r0 = r0.getAbsolutePath()
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            r5.<init>(r0)
        L_0x005c:
            boolean r0 = r5.exists()
            if (r0 != 0) goto L_0x0065
            r5.mkdirs()
        L_0x0065:
            java.io.File r0 = new java.io.File
            r0.<init>(r5, r3)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009d, Exception -> 0x0090, all -> 0x008d }
            r3.<init>(r0)     // Catch:{ IOException -> 0x009d, Exception -> 0x0090, all -> 0x008d }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x008a, Exception -> 0x0088, all -> 0x0086 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x008a, Exception -> 0x0088, all -> 0x0086 }
            r0.writeObject(r1)     // Catch:{ IOException -> 0x0084, Exception -> 0x0092 }
            r3.flush()     // Catch:{ Exception -> 0x00cb }
            r3.close()     // Catch:{ Exception -> 0x00cb }
        L_0x007d:
            r0.flush()     // Catch:{ Exception -> 0x00cb }
        L_0x0080:
            r0.close()     // Catch:{ Exception -> 0x00cb }
            goto L_0x00cb
        L_0x0084:
            r1 = move-exception
            goto L_0x00a0
        L_0x0086:
            r1 = move-exception
            goto L_0x00b0
        L_0x0088:
            r0 = r2
            goto L_0x0092
        L_0x008a:
            r1 = move-exception
            r0 = r2
            goto L_0x00a0
        L_0x008d:
            r1 = move-exception
            r3 = r2
            goto L_0x00b0
        L_0x0090:
            r0 = r2
            r3 = r0
        L_0x0092:
            if (r3 == 0) goto L_0x0097
            r3.flush()     // Catch:{ Exception -> 0x00cb }
        L_0x0097:
            r3.close()     // Catch:{ Exception -> 0x00cb }
            if (r0 == 0) goto L_0x0080
            goto L_0x007d
        L_0x009d:
            r1 = move-exception
            r0 = r2
            r3 = r0
        L_0x00a0:
            r1.printStackTrace()     // Catch:{ all -> 0x00ae }
            if (r3 == 0) goto L_0x00a8
            r3.flush()     // Catch:{ Exception -> 0x00cb }
        L_0x00a8:
            r3.close()     // Catch:{ Exception -> 0x00cb }
            if (r0 == 0) goto L_0x0080
            goto L_0x007d
        L_0x00ae:
            r1 = move-exception
            r2 = r0
        L_0x00b0:
            if (r3 == 0) goto L_0x00b5
            r3.flush()     // Catch:{ Exception -> 0x00c0 }
        L_0x00b5:
            r3.close()     // Catch:{ Exception -> 0x00c0 }
            if (r2 == 0) goto L_0x00bd
            r2.flush()     // Catch:{ Exception -> 0x00c0 }
        L_0x00bd:
            r2.close()     // Catch:{ Exception -> 0x00c0 }
        L_0x00c0:
            throw r1
        L_0x00c1:
            android.content.Context r0 = r7.f25578b
            java.lang.String r1 = r7.f25580d
            com.paytm.network.model.IJRPaytmDataModel r0 = net.one97.paytmflight.common.b.c.a(r0, r1)
            r7.f25579c = r0
        L_0x00cb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.utils.b.a():java.lang.Void");
    }
}
