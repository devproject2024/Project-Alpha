package com.business.merchant_payments.mapqr.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.app.a;

public final class ScanActivityZxing$initializeNoCameraUI$1 implements View.OnClickListener {
    public final /* synthetic */ ScanActivityZxing this$0;

    public ScanActivityZxing$initializeNoCameraUI$1(ScanActivityZxing scanActivityZxing) {
        this.this$0 = scanActivityZxing;
    }

    public final void onClick(View view) {
        if (!a.a((Activity) this.this$0, "android.permission.CAMERA")) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.this$0.getPackageName(), (String) null));
            ScanActivityZxing scanActivityZxing = this.this$0;
            scanActivityZxing.startActivityForResult(intent, scanActivityZxing.REQUEST_PERMISSION_SETTING);
            return;
        }
        ScanActivityZxing scanActivityZxing2 = this.this$0;
        a.a(scanActivityZxing2, new String[]{"android.permission.CAMERA"}, scanActivityZxing2.RC_HANDLE_CAMERA_PERM);
    }
}
