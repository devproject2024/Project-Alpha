package net.one97.paytm;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.paytm.utility.q;
import java.io.File;
import java.lang.ref.WeakReference;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.json.JSONObject;

public class CSTH5FileUtil {

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f16172a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<Activity> f16173b;

        public a(String str, Activity activity) {
            this.f16172a = str;
            this.f16173b = new WeakReference<>(activity);
        }

        public final void run() {
            try {
                JSONObject jSONObject = new JSONObject(this.f16172a);
                CSTH5FileUtil.saveImageToStorage(String.valueOf(jSONObject.get("fileData")), String.valueOf(jSONObject.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME)), String.valueOf(jSONObject.get("fileType")), this.f16173b);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public void saveFileToStorage(String str, Activity activity) {
        new Thread(new a(str, activity)).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096 A[SYNTHETIC, Splitter:B:34:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5 A[SYNTHETIC, Splitter:B:40:0x00a5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveImageToStorage(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.ref.WeakReference<android.app.Activity> r8) {
        /*
            java.lang.String r0 = "pdf"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x000d
            boolean r5 = saveAttachmentToStorage(r5, r7, r6, r8)
            return r5
        L_0x000d:
            java.lang.String r0 = "image"
            boolean r0 = r7.contains(r0)
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            java.io.File r0 = new java.io.File
            java.lang.String r2 = android.os.Environment.DIRECTORY_PICTURES
            java.io.File r2 = android.os.Environment.getExternalStoragePublicDirectory(r2)
            java.lang.String r3 = "Paytm"
            r0.<init>(r2, r3)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            java.lang.String r4 = ".jpg"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r0, r3)
            r3 = 0
            boolean r4 = r0.exists()     // Catch:{ Exception -> 0x008c }
            if (r4 != 0) goto L_0x0043
            r0.mkdir()     // Catch:{ Exception -> 0x008c }
        L_0x0043:
            boolean r0 = r2.exists()     // Catch:{ Exception -> 0x008c }
            if (r0 != 0) goto L_0x0076
            r2.createNewFile()     // Catch:{ Exception -> 0x008c }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008c }
            r0.<init>(r2)     // Catch:{ Exception -> 0x008c }
            r2 = 2
            byte[] r5 = android.util.Base64.decode(r5, r2)     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            r3 = 100
            r5.compress(r2, r3, r0)     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            r5.recycle()     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            r0.flush()     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            r0.close()     // Catch:{ Exception -> 0x0073, all -> 0x0071 }
            r3 = r0
            goto L_0x0076
        L_0x0071:
            r5 = move-exception
            goto L_0x00a3
        L_0x0073:
            r5 = move-exception
            r3 = r0
            goto L_0x008d
        L_0x0076:
            openFile(r7, r6, r8)     // Catch:{ Exception -> 0x008c }
            if (r3 == 0) goto L_0x0087
            r3.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0087
        L_0x007f:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x0087:
            r5 = 1
            return r5
        L_0x0089:
            r5 = move-exception
            r0 = r3
            goto L_0x00a3
        L_0x008c:
            r5 = move-exception
        L_0x008d:
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0089 }
            com.paytm.utility.q.b(r5)     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x00a2
            r3.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x00a2:
            return r1
        L_0x00a3:
            if (r0 == 0) goto L_0x00b1
            r0.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00b1
        L_0x00a9:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x00b1:
            throw r5
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.CSTH5FileUtil.saveImageToStorage(java.lang.String, java.lang.String, java.lang.String, java.lang.ref.WeakReference):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[SYNTHETIC, Splitter:B:28:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080 A[SYNTHETIC, Splitter:B:33:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveAttachmentToStorage(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.ref.WeakReference<android.app.Activity> r7) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = android.os.Environment.DIRECTORY_PICTURES
            java.io.File r1 = android.os.Environment.getExternalStoragePublicDirectory(r1)
            java.lang.String r2 = "Paytm"
            r0.<init>(r1, r2)
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            java.lang.String r3 = ".pdf"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r0, r2)
            r2 = 0
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x0066 }
            if (r3 != 0) goto L_0x002d
            r0.mkdir()     // Catch:{ Exception -> 0x0066 }
        L_0x002d:
            boolean r0 = r1.exists()     // Catch:{ Exception -> 0x0066 }
            if (r0 != 0) goto L_0x0051
            r1.createNewFile()     // Catch:{ Exception -> 0x0066 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0066 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0066 }
            r1 = 2
            byte[] r4 = android.util.Base64.decode(r4, r1)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r0.write(r4)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r0.flush()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r0.close()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r2 = r0
            goto L_0x0051
        L_0x004b:
            r4 = move-exception
            r2 = r0
            goto L_0x007e
        L_0x004e:
            r4 = move-exception
            r2 = r0
            goto L_0x0067
        L_0x0051:
            openFile(r5, r6, r7)     // Catch:{ Exception -> 0x0066 }
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
        L_0x0062:
            r4 = 1
            return r4
        L_0x0064:
            r4 = move-exception
            goto L_0x007e
        L_0x0066:
            r4 = move-exception
        L_0x0067:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0064 }
            com.paytm.utility.q.b(r4)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x007c
            r2.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x007c
        L_0x0074:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
        L_0x007c:
            r4 = 0
            return r4
        L_0x007e:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x008c
        L_0x0084:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x008c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.CSTH5FileUtil.saveAttachmentToStorage(java.lang.String, java.lang.String, java.lang.String, java.lang.ref.WeakReference):boolean");
    }

    private static void openFile(String str, String str2, WeakReference<Activity> weakReference) {
        File file;
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Paytm");
        if (str.contains("pdf")) {
            file = new File(file2, str2 + ".pdf");
        } else {
            file = new File(file2, str2 + ".jpg");
        }
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", file));
            intent.addFlags(1);
            activity.runOnUiThread(new Runnable(activity, intent) {
                private final /* synthetic */ Activity f$0;
                private final /* synthetic */ Intent f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    this.f$0.startActivity(this.f$1);
                }
            });
        }
    }
}
