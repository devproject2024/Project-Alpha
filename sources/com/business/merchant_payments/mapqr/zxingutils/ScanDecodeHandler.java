package com.business.merchant_payments.mapqr.zxingutils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.mapqr.view.ScanActivityZxing;
import com.google.zxing.b.j;
import com.google.zxing.c;
import com.google.zxing.client.android.R;
import com.google.zxing.e;
import com.google.zxing.k;
import com.google.zxing.m;
import com.google.zxing.n;
import com.google.zxing.q;
import com.google.zxing.r;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class ScanDecodeHandler extends Handler {
    public static final String TAG = ScanDecodeHandler.class.getSimpleName();
    public final ScanActivityZxing fragment;
    public final k multiFormatReader;
    public boolean running = true;

    public ScanDecodeHandler(ScanActivityZxing scanActivityZxing, Map<e, Object> map) {
        k kVar = new k();
        this.multiFormatReader = kVar;
        kVar.a((Map<e, ?>) map);
        this.fragment = scanActivityZxing;
    }

    public final void handleMessage(Message message) {
        if (this.running) {
            if (message.what == R.id.decode) {
                try {
                    if (((byte[]) message.obj).length / TarConstants.EOF_BLOCK <= ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 10) {
                        decode((byte[]) message.obj, message.arg1, message.arg2);
                        return;
                    }
                    throw new Exception("Size too big");
                } catch (Exception e2) {
                    e2.printStackTrace();
                } catch (Error e3) {
                    e3.printStackTrace();
                }
            } else if (message.what == R.id.quit) {
                this.running = false;
                Looper.myLooper().quit();
            }
        }
    }

    private void decode(byte[] bArr, int i2, int i3) {
        n nVar;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
            }
        }
        Rect f2 = this.fragment.getCameraManager().f();
        r rVar = null;
        if (f2 == null) {
            nVar = null;
        } else {
            nVar = new n(bArr2, i3, i2, f2.left, f2.top, f2.width(), f2.height());
        }
        if (nVar != null) {
            try {
                rVar = this.multiFormatReader.a(new c(new j(nVar)));
            } catch (q unused) {
            } catch (Throwable th) {
                this.multiFormatReader.a();
                throw th;
            }
            this.multiFormatReader.a();
            if (rVar == null) {
                try {
                    rVar = this.multiFormatReader.a(new c(new j(nVar.c())));
                } catch (m unused2) {
                } catch (Throwable th2) {
                    this.multiFormatReader.a();
                    throw th2;
                }
                this.multiFormatReader.a();
            }
        }
        ScanHandler handler = this.fragment.getHandler();
        if (rVar != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtility.d(TAG, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            if (handler != null) {
                Message obtain = Message.obtain(handler, R.id.decode_succeeded, rVar);
                Bundle bundle = new Bundle();
                bundleThumbnail(nVar, bundle);
                obtain.setData(bundle);
                obtain.sendToTarget();
            }
        } else if (handler != null) {
            Message.obtain(handler, R.id.decode_failed).sendToTarget();
        }
    }

    public static void bundleThumbnail(n nVar, Bundle bundle) {
        int[] e2 = nVar.e();
        int i2 = nVar.f40562a / 2;
        Bitmap createBitmap = Bitmap.createBitmap(e2, 0, i2, i2, nVar.f40563b / 2, Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(ScanDecodeThread.BARCODE_BITMAP, byteArrayOutputStream.toByteArray());
        bundle.putFloat(ScanDecodeThread.BARCODE_SCALED_FACTOR, ((float) i2) / ((float) nVar.f40562a));
    }
}
