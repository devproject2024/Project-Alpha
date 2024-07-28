package com.business.merchant_payments.mapqr.zxingutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.business.common_module.zxingutils.e;
import com.business.common_module.zxingutils.i;
import com.business.merchant_payments.mapqr.view.ScanActivityZxing;
import com.google.zxing.a;
import com.google.zxing.client.android.R;
import com.google.zxing.r;
import java.util.Collection;
import java.util.Map;

public final class ScanHandler extends Handler {
    public static final String TAG = ScanHandler.class.getSimpleName();
    public final ScanActivityZxing activity;
    public final e cameraManagerModified;
    public final ScanDecodeThread decodeThread;
    public State state = State.SUCCESS;

    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public ScanHandler(ScanActivityZxing scanActivityZxing, Collection<a> collection, Map<com.google.zxing.e, ?> map, String str, e eVar) {
        this.activity = scanActivityZxing;
        ScanDecodeThread scanDecodeThread = new ScanDecodeThread(scanActivityZxing, collection, map, str, new i(scanActivityZxing.getViewfinderView()));
        this.decodeThread = scanDecodeThread;
        scanDecodeThread.start();
        this.cameraManagerModified = eVar;
        eVar.c();
        restartPreviewAndDecode();
    }

    public final void handleMessage(Message message) {
        if (message.what == R.id.restart_preview) {
            restartPreviewAndDecode();
        } else if (message.what == R.id.decode_succeeded) {
            this.state = State.SUCCESS;
            Bundle data = message.getData();
            Bitmap bitmap = null;
            if (data != null) {
                byte[] byteArray = data.getByteArray(ScanDecodeThread.BARCODE_BITMAP);
                if (byteArray != null) {
                    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, (BitmapFactory.Options) null).copy(Bitmap.Config.ARGB_8888, true);
                }
                data.getFloat(ScanDecodeThread.BARCODE_SCALED_FACTOR);
            }
            this.activity.handleDecode((r) message.obj, bitmap);
        } else if (message.what == R.id.decode_failed) {
            this.state = State.PREVIEW;
            this.cameraManagerModified.a(this.decodeThread.getHandler(), R.id.decode);
        } else if (message.what != R.id.return_scan_result) {
            int i2 = message.what;
            int i3 = R.id.launch_product_query;
        }
    }

    public final void quitSynchronously() {
        this.state = State.DONE;
        this.cameraManagerModified.d();
        Message.obtain(this.decodeThread.getHandler(), R.id.quit).sendToTarget();
        try {
            this.decodeThread.join(500);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    private void restartPreviewAndDecode() {
        if (this.state == State.SUCCESS) {
            this.state = State.PREVIEW;
            this.cameraManagerModified.a(this.decodeThread.getHandler(), R.id.decode);
            this.activity.drawViewfinder();
        }
    }
}
