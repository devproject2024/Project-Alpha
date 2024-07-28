package c.a.a;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f5553a;

    /* renamed from: b  reason: collision with root package name */
    private final OkHttpClient f5554b = new OkHttpClient();

    public interface a {
        void a();

        void a(int i2);

        void a(File file);
    }

    public static c a() {
        if (f5553a == null) {
            f5553a = new c();
        }
        return f5553a;
    }

    private c() {
    }

    public final void a(String str, final String str2, final String str3, final a aVar) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http") || str.startsWith("https")) {
                FirebasePerfOkHttpClient.enqueue(this.f5554b.newCall(new Request.Builder().url(str).build()), new Callback() {
                    public final void onFailure(Call call, IOException iOException) {
                        aVar.a();
                    }

                    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|8|(3:9|10|(1:12)(1:52))|13|(2:15|16)|17|18|53) */
                    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0067 */
                    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f A[SYNTHETIC, Splitter:B:34:0x007f] */
                    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086 A[SYNTHETIC, Splitter:B:38:0x0086] */
                    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f A[SYNTHETIC, Splitter:B:44:0x008f] */
                    /* JADX WARNING: Removed duplicated region for block: B:48:0x0096 A[SYNTHETIC, Splitter:B:48:0x0096] */
                    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void onResponse(okhttp3.Call r10, okhttp3.Response r11) throws java.io.IOException {
                        /*
                            r9 = this;
                            r10 = 2048(0x800, float:2.87E-42)
                            byte[] r10 = new byte[r10]
                            java.lang.String r0 = r3
                            java.io.File r1 = new java.io.File
                            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
                            r1.<init>(r2, r0)
                            boolean r0 = r1.mkdirs()
                            if (r0 != 0) goto L_0x0018
                            r1.createNewFile()
                        L_0x0018:
                            java.lang.String r0 = r1.getAbsolutePath()
                            r1 = 0
                            okhttp3.ResponseBody r2 = r11.body()     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
                            java.io.InputStream r2 = r2.byteStream()     // Catch:{ Exception -> 0x0077, all -> 0x0073 }
                            okhttp3.ResponseBody r11 = r11.body()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                            long r3 = r11.contentLength()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                            java.lang.String r5 = r4     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                            r11.<init>(r0, r5)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                            r0.<init>(r11)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
                            r5 = 0
                        L_0x003b:
                            int r1 = r2.read(r10)     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            r7 = -1
                            if (r1 == r7) goto L_0x005a
                            r7 = 0
                            r0.write(r10, r7, r1)     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            long r7 = (long) r1     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            long r5 = r5 + r7
                            float r1 = (float) r5     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            r7 = 1065353216(0x3f800000, float:1.0)
                            float r1 = r1 * r7
                            float r7 = (float) r3     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            float r1 = r1 / r7
                            r7 = 1120403456(0x42c80000, float:100.0)
                            float r1 = r1 * r7
                            int r1 = (int) r1     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            c.a.a.c$a r7 = r5     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            r7.a((int) r1)     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            goto L_0x003b
                        L_0x005a:
                            r0.flush()     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            c.a.a.c$a r10 = r5     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            r10.a((java.io.File) r11)     // Catch:{ Exception -> 0x0071, all -> 0x006b }
                            if (r2 == 0) goto L_0x0067
                            r2.close()     // Catch:{ IOException -> 0x0067 }
                        L_0x0067:
                            r0.close()     // Catch:{ IOException -> 0x006a }
                        L_0x006a:
                            return
                        L_0x006b:
                            r10 = move-exception
                            goto L_0x008d
                        L_0x006d:
                            r10 = move-exception
                            r0 = r1
                            goto L_0x008d
                        L_0x0070:
                            r0 = r1
                        L_0x0071:
                            r1 = r2
                            goto L_0x0078
                        L_0x0073:
                            r10 = move-exception
                            r0 = r1
                            r2 = r0
                            goto L_0x008d
                        L_0x0077:
                            r0 = r1
                        L_0x0078:
                            c.a.a.c$a r10 = r5     // Catch:{ all -> 0x008b }
                            r10.a()     // Catch:{ all -> 0x008b }
                            if (r1 == 0) goto L_0x0084
                            r1.close()     // Catch:{ IOException -> 0x0083 }
                            goto L_0x0084
                        L_0x0083:
                        L_0x0084:
                            if (r0 == 0) goto L_0x008a
                            r0.close()     // Catch:{ IOException -> 0x008a }
                        L_0x008a:
                            return
                        L_0x008b:
                            r10 = move-exception
                            r2 = r1
                        L_0x008d:
                            if (r2 == 0) goto L_0x0094
                            r2.close()     // Catch:{ IOException -> 0x0093 }
                            goto L_0x0094
                        L_0x0093:
                        L_0x0094:
                            if (r0 == 0) goto L_0x0099
                            r0.close()     // Catch:{ IOException -> 0x0099 }
                        L_0x0099:
                            throw r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: c.a.a.c.AnonymousClass1.onResponse(okhttp3.Call, okhttp3.Response):void");
                    }
                });
            }
        }
    }
}
