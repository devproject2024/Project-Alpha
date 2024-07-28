package net.one97.paytm.upgradeKyc.editprofile.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upgradeKyc.editprofile.view.c;

public final class b extends AsyncTask<String, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<c> f65815a;

    public b(c cVar) {
        k.c(cVar, "activity");
        this.f65815a = new WeakReference<>(cVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ce A[SYNTHETIC, Splitter:B:33:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d7 A[SYNTHETIC, Splitter:B:38:0x00d7] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Void doInBackground(java.lang.String... r7) {
        /*
            r6 = this;
            java.lang.String r0 = "HomeHelper.getModuleInterface()"
            java.lang.String r1 = "strings"
            kotlin.g.b.k.c(r7, r1)
            r1 = 0
            java.lang.ref.WeakReference<net.one97.paytm.upgradeKyc.editprofile.view.c> r2 = r6.f65815a     // Catch:{ Exception -> 0x00e4 }
            if (r2 != 0) goto L_0x0011
            java.lang.String r3 = "mActivity"
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00e4 }
        L_0x0011:
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x00e4 }
            if (r2 == 0) goto L_0x00e4
            r2 = 0
            r7 = r7[r2]     // Catch:{ Exception -> 0x00e4 }
            android.graphics.Bitmap r7 = a((java.lang.String) r7)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r3 = "mounted"
            r4 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)     // Catch:{ Exception -> 0x00e4 }
            if (r2 == 0) goto L_0x00e4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e4 }
            r2.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00e4 }
            r2.append(r3)     // Catch:{ Exception -> 0x00e4 }
            net.one97.paytm.common.b.e r3 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x00e4 }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x00e4 }
            android.content.Context r3 = r3.D()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r3 = com.paytm.utility.b.am(r3)     // Catch:{ Exception -> 0x00e4 }
            r2.append(r3)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r3 = "/profilePicture.jpg"
            r2.append(r3)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e4 }
            r3.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00e4 }
            r3.append(r5)     // Catch:{ Exception -> 0x00e4 }
            net.one97.paytm.common.b.e r5 = net.one97.paytm.common.b.d.a()     // Catch:{ Exception -> 0x00e4 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x00e4 }
            android.content.Context r0 = r5.D()     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = com.paytm.utility.b.am(r0)     // Catch:{ Exception -> 0x00e4 }
            r3.append(r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00e4 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00e4 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00e4 }
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00e4 }
            if (r0 != 0) goto L_0x008b
            boolean r4 = r3.mkdirs()     // Catch:{ Exception -> 0x00e4 }
        L_0x008b:
            if (r4 == 0) goto L_0x00e4
            if (r7 != 0) goto L_0x0092
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00e4 }
        L_0x0092:
            java.lang.String r0 = "bitmap"
            kotlin.g.b.k.c(r7, r0)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r0 = "photoPath"
            kotlin.g.b.k.c(r2, r0)     // Catch:{ Exception -> 0x00e4 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00be }
            r3 = 100
            r4 = r0
            java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch:{ Exception -> 0x00be }
            r7.compress(r2, r3, r4)     // Catch:{ Exception -> 0x00be }
            r7.recycle()     // Catch:{ Exception -> 0x00be }
            r0.close()     // Catch:{ Exception -> 0x00be }
            r0.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00e4
        L_0x00b5:
            r7 = move-exception
        L_0x00b6:
            java.lang.String r7 = r7.getMessage()     // Catch:{ Exception -> 0x00e4 }
            com.paytm.utility.q.b(r7)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00e4
        L_0x00be:
            r7 = move-exception
            goto L_0x00c5
        L_0x00c0:
            r7 = move-exception
            r0 = r1
            goto L_0x00d5
        L_0x00c3:
            r7 = move-exception
            r0 = r1
        L_0x00c5:
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00d4 }
            com.paytm.utility.q.b(r7)     // Catch:{ all -> 0x00d4 }
            if (r0 == 0) goto L_0x00e4
            r0.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00e4
        L_0x00d2:
            r7 = move-exception
            goto L_0x00b6
        L_0x00d4:
            r7 = move-exception
        L_0x00d5:
            if (r0 == 0) goto L_0x00e3
            r0.close()     // Catch:{ IOException -> 0x00db }
            goto L_0x00e3
        L_0x00db:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00e4 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x00e4 }
        L_0x00e3:
            throw r7     // Catch:{ Exception -> 0x00e4 }
        L_0x00e4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.c.b.doInBackground(java.lang.String[]):java.lang.Void");
    }

    /* access modifiers changed from: protected */
    public final void onCancelled() {
        super.onCancelled();
        WeakReference<c> weakReference = this.f65815a;
        if (weakReference == null) {
            k.a("mActivity");
        }
        if (weakReference.get() != null) {
            WeakReference<c> weakReference2 = this.f65815a;
            if (weakReference2 == null) {
                k.a("mActivity");
            }
            Object obj = weakReference2.get();
            if (obj == null) {
                k.a();
            }
            ((c) obj).f65928b = null;
        }
    }

    private static Bitmap a(String str) {
        k.c(str, "src");
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            if (uRLConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            throw new u("null cannot be cast to non-null type java.net.HttpURLConnection");
        } catch (IOException | Exception unused) {
            return null;
        }
    }
}
