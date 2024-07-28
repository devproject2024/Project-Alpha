package com.business.merchant_payments.mapqr.view;

import android.widget.ImageView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.utility.QRCodeGenerator;

public final class MapQRSuccessScreen$createQrImageFromText$1 implements Runnable {
    public final /* synthetic */ ImageView $qrImageView;
    public final /* synthetic */ String $text;
    public final /* synthetic */ MapQRSuccessScreen this$0;

    public MapQRSuccessScreen$createQrImageFromText$1(MapQRSuccessScreen mapQRSuccessScreen, String str, ImageView imageView) {
        this.this$0 = mapQRSuccessScreen;
        this.$text = str;
        this.$qrImageView = imageView;
    }

    public final void run() {
        MapQRSuccessScreen mapQRSuccessScreen = this.this$0;
        mapQRSuccessScreen.qRBitmap = QRCodeGenerator.getQrCodeBitmap(this.$text, mapQRSuccessScreen.qrDimen, AppConstants.MapQrConstants.QR_KEY_BLACK);
        this.this$0.runOnUiThread(new Runnable(this) {
            public final /* synthetic */ MapQRSuccessScreen$createQrImageFromText$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                if (this.this$0.this$0.qRBitmap != null) {
                    MapQRSuccessScreen$createQrImageFromText$1 mapQRSuccessScreen$createQrImageFromText$1 = this.this$0;
                    mapQRSuccessScreen$createQrImageFromText$1.$qrImageView.setImageBitmap(mapQRSuccessScreen$createQrImageFromText$1.this$0.qRBitmap);
                }
            }
        });
    }
}
