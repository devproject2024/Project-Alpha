package com.alipay.mobile.nebulacore.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.localbroadcastmanager.a.a;
import com.alipay.android.phone.androidannotations.utils.PermissionUtils;
import com.alipay.mobile.nebula.activity.H5BaseActivity;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.view.H5Toast;
import com.alipay.mobile.nebulacore.web.H5WebChromeClient;
import java.io.File;

public class H5FileChooserActivity extends H5BaseActivity {
    private static final int REQPERMISSIONS_PERMISSIONS_REQUESTCODE = 1;
    public static final String TAG = "H5FileChooserActivity";
    private String cameraFilePath;
    private final String[] reqPermissionsPermissions = {"android.permission.CAMERA"};

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        reqPermissions();
    }

    /* access modifiers changed from: package-private */
    public void reqPermissions() {
        if (PermissionUtils.hasSelfPermissions(this, this.reqPermissionsPermissions)) {
            H5Log.d(TAG, "get CAMERA permission success!");
            try {
                startActivityForResult(createDefaultOpenableIntent(this), 1);
            } catch (ActivityNotFoundException e2) {
                H5Log.e(TAG, "exception detail", e2);
            }
        } else {
            PermissionUtils.requestPermissions(this, this.reqPermissionsPermissions, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void showDeniedForCamera() {
        H5Toast.showToast(this, H5Environment.getResources() == null ? getString(R.string.h5_choose_camera) : H5Environment.getResources().getString(R.string.h5_choose_camera), 300);
        Intent intent = new Intent();
        intent.setAction(H5WebChromeClient.FILE_CHOOSER_RESULT);
        intent.putExtra("fileUri", Uri.parse(""));
        Context context = H5Environment.getContext();
        if (context == null) {
            context = getApplicationContext();
        }
        if (context != null) {
            a.a(context).b(intent);
        }
        finish();
    }

    private Intent createDefaultOpenableIntent(Context context) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Intent createChooserIntent = createChooserIntent(context, createCameraIntent(), createCamcorderIntent(), createSoundRecorderIntent());
        createChooserIntent.putExtra("android.intent.extra.INTENT", intent);
        return createChooserIntent;
    }

    private Intent createChooserIntent(Context context, Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        intent.putExtra("android.intent.extra.TITLE", context.getString(R.string.h5_file_chooser));
        return intent;
    }

    private Intent createCameraIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File file = new File(externalStoragePublicDirectory.getAbsolutePath() + File.separator + "browser-photos");
        file.mkdirs();
        this.cameraFilePath = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
        intent.putExtra("output", Uri.fromFile(new File(this.cameraFilePath)));
        return intent;
    }

    private Intent createCamcorderIntent() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    private Intent createSoundRecorderIntent() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public void onDestroy() {
        H5Log.d(TAG, "EditAvatarModActivity onDestroy");
        super.onDestroy();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r2.exists() != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            java.lang.String r0 = "H5FileChooserActivity"
            r1 = 1
            if (r4 != r1) goto L_0x0060
            r4 = -1
            r2 = 0
            if (r6 == 0) goto L_0x0011
            if (r5 == r4) goto L_0x000c
            goto L_0x0011
        L_0x000c:
            android.net.Uri r6 = r6.getData()
            goto L_0x0012
        L_0x0011:
            r6 = r2
        L_0x0012:
            if (r5 != r4) goto L_0x0037
            java.lang.String r4 = r3.cameraFilePath
            if (r4 == 0) goto L_0x0024
            java.io.File r2 = new java.io.File
            r2.<init>(r4)
            boolean r4 = r2.exists()
            if (r4 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r6 != 0) goto L_0x0037
            if (r1 == 0) goto L_0x0037
            android.net.Uri r6 = android.net.Uri.fromFile(r2)
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r4.<init>(r5, r6)
            r3.sendBroadcast(r4)
        L_0x0037:
            if (r6 != 0) goto L_0x003e
            java.lang.String r4 = "result uri is null"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r4)
        L_0x003e:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>()
            java.lang.String r5 = "FILE_CHOOSER_RESULT"
            r4.setAction(r5)
            java.lang.String r5 = "fileUri"
            r4.putExtra(r5, r6)
            android.content.Context r5 = com.alipay.mobile.nebulacore.env.H5Environment.getContext()
            if (r5 != 0) goto L_0x0057
            android.content.Context r5 = r3.getApplicationContext()
        L_0x0057:
            if (r5 == 0) goto L_0x0060
            androidx.localbroadcastmanager.a.a r5 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r5)
            r5.b(r4)
        L_0x0060:
            java.lang.String r4 = "onActivityResult finish"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r4)
            r3.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.ui.H5FileChooserActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (PermissionUtils.verifyPermissions(iArr)) {
                H5Log.d(TAG, "get CAMERA permission success!");
                try {
                    startActivityForResult(createDefaultOpenableIntent(this), 1);
                } catch (ActivityNotFoundException e2) {
                    H5Log.e(TAG, "exception detail", e2);
                }
            } else {
                showDeniedForCamera();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }
}
