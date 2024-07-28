package com.google.zxing.client.android;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.business.merchant_payments.mapqr.zxingutils.ScanDecodeThread;
import com.google.zxing.b.j;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.k;
import com.google.zxing.n;
import com.google.zxing.q;
import com.google.zxing.r;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40221a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final CaptureActivity f40222b;

    /* renamed from: c  reason: collision with root package name */
    private final k f40223c = new k();

    /* renamed from: d  reason: collision with root package name */
    private boolean f40224d = true;

    f(CaptureActivity captureActivity, Map<e, Object> map) {
        this.f40223c.a((Map<e, ?>) map);
        this.f40222b = captureActivity;
    }

    public final void handleMessage(Message message) {
        n nVar;
        if (this.f40224d) {
            if (message.what == R.id.decode) {
                byte[] bArr = (byte[]) message.obj;
                int i2 = message.arg1;
                int i3 = message.arg2;
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr2 = new byte[bArr.length];
                for (int i4 = 0; i4 < i3; i4++) {
                    for (int i5 = 0; i5 < i2; i5++) {
                        bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
                    }
                }
                Rect f2 = this.f40222b.f40086a.f();
                r rVar = null;
                if (f2 == null) {
                    nVar = null;
                } else {
                    nVar = new n(bArr2, i3, i2, f2.left, f2.top, f2.width(), f2.height());
                }
                if (nVar != null) {
                    try {
                        rVar = this.f40223c.a(new c(new j(nVar)));
                    } catch (q unused) {
                    } catch (Throwable th) {
                        this.f40223c.a();
                        throw th;
                    }
                    this.f40223c.a();
                }
                c cVar = this.f40222b.f40087b;
                if (rVar != null) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder("Found barcode in ");
                    sb.append(currentTimeMillis2 - currentTimeMillis);
                    sb.append(" ms");
                    if (cVar != null) {
                        Message obtain = Message.obtain(cVar, R.id.decode_succeeded, rVar);
                        Bundle bundle = new Bundle();
                        int[] e2 = nVar.e();
                        int i6 = nVar.f40562a / 2;
                        Bitmap createBitmap = Bitmap.createBitmap(e2, 0, i6, i6, nVar.f40563b / 2, Bitmap.Config.ARGB_8888);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                        bundle.putByteArray(ScanDecodeThread.BARCODE_BITMAP, byteArrayOutputStream.toByteArray());
                        bundle.putFloat(ScanDecodeThread.BARCODE_SCALED_FACTOR, ((float) i6) / ((float) nVar.f40562a));
                        obtain.setData(bundle);
                        obtain.sendToTarget();
                    }
                } else if (cVar != null) {
                    Message.obtain(cVar, R.id.decode_failed).sendToTarget();
                }
            } else if (message.what == R.id.quit) {
                this.f40224d = false;
                Looper.myLooper().quit();
            }
        }
    }
}
