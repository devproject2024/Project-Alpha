package com.business.merchant_payments.mapqr.utility;

import kotlin.g.b.k;

public final class QRScannedFinishEvent {
    public final String qrCode;

    public QRScannedFinishEvent(String str) {
        k.d(str, "qrCode");
        this.qrCode = str;
    }

    public final String getQrCode() {
        return this.qrCode;
    }
}
