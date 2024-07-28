package com.business.merchant_payments.event;

import android.graphics.Bitmap;
import com.business.merchant_payments.model.qrsummarymodel.QRSummaryListItem;

public class QrShareEvent {
    public boolean isForDownload;
    public int position;
    public Bitmap qrBitmap;
    public String qrDisplayName;
    public String qrShareLink;
    public QRSummaryListItem qrSummaryListItem;
    public String qrType;

    public QrShareEvent(String str, int i2, Bitmap bitmap, String str2, String str3, QRSummaryListItem qRSummaryListItem) {
        this.position = i2;
        this.qrBitmap = bitmap;
        this.qrDisplayName = str2;
        this.qrShareLink = str3;
        this.qrType = str;
        this.qrSummaryListItem = qRSummaryListItem;
    }

    public int getPosition() {
        return this.position;
    }

    public String getQrShareLink() {
        return this.qrShareLink;
    }

    public String getQrDisplayName() {
        return this.qrDisplayName;
    }

    public Bitmap getQrBitmap() {
        return this.qrBitmap;
    }

    public QRSummaryListItem getQrSummaryListItem() {
        return this.qrSummaryListItem;
    }

    public boolean isForDownload() {
        return this.isForDownload;
    }

    public void setForDownload(boolean z) {
        this.isForDownload = z;
    }

    public String getQrType() {
        return this.qrType;
    }
}
