package com.business.merchant_payments.mapqr.vision;

import android.content.Context;
import com.business.merchant_payments.mapqr.vision.camera.GraphicOverlay;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.d;
import com.google.android.gms.vision.e;

public class BarcodeTrackerFactory implements d.b<Barcode> {
    public Context mContext;
    public GraphicOverlay<BarcodeGraphic> mGraphicOverlay;

    public BarcodeTrackerFactory(GraphicOverlay<BarcodeGraphic> graphicOverlay, Context context) {
        this.mGraphicOverlay = graphicOverlay;
        this.mContext = context;
    }

    public e<Barcode> create(Barcode barcode) {
        return new BarcodeGraphicTracker(this.mGraphicOverlay, new BarcodeGraphic(this.mGraphicOverlay), this.mContext);
    }
}
