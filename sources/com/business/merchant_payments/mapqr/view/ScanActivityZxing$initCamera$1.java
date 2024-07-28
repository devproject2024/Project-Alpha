package com.business.merchant_payments.mapqr.view;

import android.view.SurfaceHolder;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.zxingutils.e;
import com.business.merchant_payments.mapqr.zxingutils.ScanHandler;
import java.io.IOException;
import kotlin.g.b.k;

public final class ScanActivityZxing$initCamera$1 implements Runnable {
    public final /* synthetic */ SurfaceHolder $surfaceHolder;
    public final /* synthetic */ ScanActivityZxing this$0;

    public ScanActivityZxing$initCamera$1(ScanActivityZxing scanActivityZxing, SurfaceHolder surfaceHolder) {
        this.this$0 = scanActivityZxing;
        this.$surfaceHolder = surfaceHolder;
    }

    public final void run() {
        if (this.$surfaceHolder != null) {
            e cameraManager = this.this$0.getCameraManager();
            Boolean valueOf = cameraManager != null ? Boolean.valueOf(cameraManager.a()) : null;
            k.a((Object) valueOf);
            if (valueOf.booleanValue()) {
                LogUtility.d(ScanActivityZxing.Companion.getTAG(), "initCamera() while already open -- late SurfaceView callback?");
                return;
            }
            try {
                e cameraManager2 = this.this$0.getCameraManager();
                if (cameraManager2 != null) {
                    cameraManager2.a(this.$surfaceHolder);
                }
                if (this.this$0.getHandler() == null) {
                    this.this$0.setHandler(new ScanHandler(this.this$0, this.this$0.decodeFormats, this.this$0.decodeHints, this.this$0.characterSet, this.this$0.getCameraManager()));
                }
            } catch (IOException e2) {
                LogUtility.d(ScanActivityZxing.Companion.getTAG(), e2.toString());
            } catch (RuntimeException e3) {
                LogUtility.d(ScanActivityZxing.Companion.getTAG(), "Unexpected error initializing camera".concat(String.valueOf(e3)));
            }
        } else {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
    }
}
