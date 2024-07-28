package net.one97.paytm.landingpage.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class a extends AsyncTask<String, Void, Void> {
    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0 A[SYNTHETIC, Splitter:B:25:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9 A[SYNTHETIC, Splitter:B:30:0x00a9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Void a(java.lang.String... r5) {
        /*
            r0 = 0
            r1 = 0
            r5 = r5[r0]     // Catch:{ Exception -> 0x00b6 }
            android.graphics.Bitmap r5 = a((java.lang.String) r5)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = "mounted"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x00b6 }
            if (r0 == 0) goto L_0x00b6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6 }
            r0.<init>()     // Catch:{ Exception -> 0x00b6 }
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b6 }
            r0.append(r2)     // Catch:{ Exception -> 0x00b6 }
            net.one97.paytm.common.b.a r2 = net.one97.paytm.common.b.d.b()     // Catch:{ Exception -> 0x00b6 }
            android.content.Context r2 = r2.a()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = com.paytm.utility.b.am(r2)     // Catch:{ Exception -> 0x00b6 }
            r0.append(r2)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = "/profilePicture.jpg"
            r0.append(r2)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6 }
            r2.<init>()     // Catch:{ Exception -> 0x00b6 }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b6 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b6 }
            net.one97.paytm.common.b.a r3 = net.one97.paytm.common.b.d.b()     // Catch:{ Exception -> 0x00b6 }
            android.content.Context r3 = r3.a()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r3 = com.paytm.utility.b.am(r3)     // Catch:{ Exception -> 0x00b6 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b6 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00b6 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00b6 }
            r2 = 1
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x00b6 }
            if (r4 != 0) goto L_0x006f
            boolean r2 = r3.mkdirs()     // Catch:{ Exception -> 0x00b6 }
        L_0x006f:
            if (r2 == 0) goto L_0x00b6
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0090 }
            r3 = 100
            r5.compress(r0, r3, r2)     // Catch:{ Exception -> 0x0090 }
            r5.recycle()     // Catch:{ Exception -> 0x0090 }
            r2.close()     // Catch:{ Exception -> 0x0090 }
            r2.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x00b6
        L_0x0087:
            r5 = move-exception
        L_0x0088:
            java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x00b6 }
            com.paytm.utility.q.b(r5)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00b6
        L_0x0090:
            r5 = move-exception
            goto L_0x0097
        L_0x0092:
            r5 = move-exception
            r2 = r1
            goto L_0x00a7
        L_0x0095:
            r5 = move-exception
            r2 = r1
        L_0x0097:
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x00a6 }
            com.paytm.utility.q.b(r5)     // Catch:{ all -> 0x00a6 }
            if (r2 == 0) goto L_0x00b6
            r2.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00b6
        L_0x00a4:
            r5 = move-exception
            goto L_0x0088
        L_0x00a6:
            r5 = move-exception
        L_0x00a7:
            if (r2 == 0) goto L_0x00b5
            r2.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b5
        L_0x00ad:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00b6 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x00b6 }
        L_0x00b5:
            throw r5     // Catch:{ Exception -> 0x00b6 }
        L_0x00b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.b.a.a(java.lang.String[]):java.lang.Void");
    }

    /* access modifiers changed from: protected */
    public final void onCancelled() {
        super.onCancelled();
    }

    private static Bitmap a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException | Exception unused) {
            return null;
        }
    }
}
