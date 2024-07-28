package com.business.merchant_payments.mapqr.utility;

import android.app.Activity;
import android.content.Intent;
import com.business.merchant_payments.mapqr.view.ScanActivityVision;
import com.business.merchant_payments.mapqr.view.ScanActivityZxing;
import com.google.android.gms.vision.barcode.a;
import kotlin.g.b.k;

public final class ScanQRHandler {
    public final void scanQR(Activity activity, boolean z) {
        k.d(activity, "activity");
        a a2 = new a.C0165a(activity).a();
        k.b(a2, "BarcodeDetector.Builder(activity).build()");
        if (a2.b()) {
            Intent intent = new Intent(activity, ScanActivityVision.class);
            intent.putExtra("is_for_verifying_qr", z);
            activity.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(activity, ScanActivityZxing.class);
        intent2.putExtra("is_for_verifying_qr", z);
        activity.startActivity(intent2);
    }
}
