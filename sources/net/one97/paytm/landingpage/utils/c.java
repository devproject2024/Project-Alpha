package net.one97.paytm.landingpage.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.t;

public final class c extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private int f52902a = 112;

    /* renamed from: b  reason: collision with root package name */
    private Context f52903b;

    /* renamed from: c  reason: collision with root package name */
    private IJRDataModel f52904c;

    /* renamed from: d  reason: collision with root package name */
    private String f52905d;

    /* renamed from: e  reason: collision with root package name */
    private t f52906e;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    public c(Context context, t tVar, IJRDataModel iJRDataModel, String str) {
        this.f52903b = context;
        this.f52904c = iJRDataModel;
        this.f52905d = str;
        this.f52906e = tVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a8, code lost:
        if (r0 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bd, code lost:
        if (r0 == null) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2 A[SYNTHETIC, Splitter:B:39:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7 A[SYNTHETIC, Splitter:B:48:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c3 A[SYNTHETIC, Splitter:B:54:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cb A[Catch:{ Exception -> 0x00d1 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0099=Splitter:B:36:0x0099, B:45:0x00ae=Splitter:B:45:0x00ae} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Void a() {
        /*
            r7 = this;
            int r0 = r7.f52902a
            r1 = 111(0x6f, float:1.56E-43)
            r2 = 0
            if (r0 == r1) goto L_0x00d2
            r1 = 112(0x70, float:1.57E-43)
            if (r0 == r1) goto L_0x000d
            goto L_0x00dc
        L_0x000d:
            android.content.Context r0 = r7.f52903b
            net.one97.paytm.common.entity.IJRDataModel r1 = r7.f52904c
            java.lang.String r3 = r7.f52905d
            if (r0 == 0) goto L_0x00dc
            java.lang.String r4 = "/paytm"
            java.lang.String r3 = com.paytm.utility.b.a((java.lang.String) r3)
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
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00ab, Exception -> 0x0096, all -> 0x0092 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x00ab, Exception -> 0x0096, all -> 0x0092 }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x008f, Exception -> 0x008c, all -> 0x0089 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x008f, Exception -> 0x008c, all -> 0x0089 }
            r0.writeObject(r1)     // Catch:{ IOException -> 0x0087, Exception -> 0x0085 }
            r3.flush()     // Catch:{ Exception -> 0x00dc }
            r3.close()     // Catch:{ Exception -> 0x00dc }
        L_0x007d:
            r0.flush()     // Catch:{ Exception -> 0x00dc }
        L_0x0080:
            r0.close()     // Catch:{ Exception -> 0x00dc }
            goto L_0x00dc
        L_0x0085:
            r1 = move-exception
            goto L_0x0099
        L_0x0087:
            r1 = move-exception
            goto L_0x00ae
        L_0x0089:
            r1 = move-exception
            r0 = r2
            goto L_0x00c1
        L_0x008c:
            r1 = move-exception
            r0 = r2
            goto L_0x0099
        L_0x008f:
            r1 = move-exception
            r0 = r2
            goto L_0x00ae
        L_0x0092:
            r1 = move-exception
            r0 = r2
            r3 = r0
            goto L_0x00c1
        L_0x0096:
            r1 = move-exception
            r0 = r2
            r3 = r0
        L_0x0099:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00c0 }
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x00c0 }
            if (r3 == 0) goto L_0x00a5
            r3.flush()     // Catch:{ Exception -> 0x00dc }
        L_0x00a5:
            r3.close()     // Catch:{ Exception -> 0x00dc }
            if (r0 == 0) goto L_0x0080
            goto L_0x007d
        L_0x00ab:
            r1 = move-exception
            r0 = r2
            r3 = r0
        L_0x00ae:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00c0 }
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x00c0 }
            if (r3 == 0) goto L_0x00ba
            r3.flush()     // Catch:{ Exception -> 0x00dc }
        L_0x00ba:
            r3.close()     // Catch:{ Exception -> 0x00dc }
            if (r0 == 0) goto L_0x0080
            goto L_0x007d
        L_0x00c0:
            r1 = move-exception
        L_0x00c1:
            if (r3 == 0) goto L_0x00c6
            r3.flush()     // Catch:{ Exception -> 0x00d1 }
        L_0x00c6:
            r3.close()     // Catch:{ Exception -> 0x00d1 }
            if (r0 == 0) goto L_0x00ce
            r0.flush()     // Catch:{ Exception -> 0x00d1 }
        L_0x00ce:
            r0.close()     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            throw r1
        L_0x00d2:
            android.content.Context r0 = r7.f52903b
            java.lang.String r1 = r7.f52905d
            net.one97.paytm.common.entity.IJRDataModel r0 = net.one97.paytm.common.utility.c.c(r0, r1)
            r7.f52904c = r0
        L_0x00dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.c.a():java.lang.Void");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        t tVar;
        t tVar2;
        if (this.f52903b == null) {
            return;
        }
        if (this.f52902a == 111 && (tVar2 = this.f52906e) != null) {
            tVar2.onFileReadComplete((IJRPaytmDataModel) this.f52904c, this.f52905d);
        } else if (this.f52902a == 112 && (tVar = this.f52906e) != null) {
            tVar.onFileWriteComplete(this.f52905d);
        }
    }
}
