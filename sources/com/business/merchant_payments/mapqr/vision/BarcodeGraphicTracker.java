package com.business.merchant_payments.mapqr.vision;

import android.content.Context;
import com.business.merchant_payments.mapqr.vision.camera.GraphicOverlay;
import com.google.android.gms.vision.a;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.e;

public class BarcodeGraphicTracker extends e<Barcode> {
    public BarcodeUpdateListener mBarcodeUpdateListener;
    public BarcodeGraphic mGraphic;
    public GraphicOverlay<BarcodeGraphic> mOverlay;

    public interface BarcodeUpdateListener {
        void onBarcodeDetected(Barcode barcode);
    }

    public BarcodeGraphicTracker(GraphicOverlay<BarcodeGraphic> graphicOverlay, BarcodeGraphic barcodeGraphic, Context context) {
        this.mOverlay = graphicOverlay;
        this.mGraphic = barcodeGraphic;
        if (context instanceof BarcodeUpdateListener) {
            this.mBarcodeUpdateListener = (BarcodeUpdateListener) context;
            return;
        }
        throw new RuntimeException("Hosting activity must implement BarcodeUpdateListener");
    }

    public void onNewItem(int i2, Barcode barcode) {
        this.mGraphic.setId(i2);
        this.mBarcodeUpdateListener.onBarcodeDetected(barcode);
    }

    public void onUpdate(a.C0163a<Barcode> aVar, Barcode barcode) {
        this.mOverlay.add(this.mGraphic);
        this.mGraphic.updateItem(barcode);
    }

    public void onMissing(a.C0163a<Barcode> aVar) {
        this.mOverlay.remove(this.mGraphic);
    }

    public void onDone() {
        this.mOverlay.remove(this.mGraphic);
    }
}
