package com.business.common_module.zxingutils;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import com.business.common_module.utilities.LogUtility;

final class h implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7434a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final c f7435b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f7436c;

    /* renamed from: d  reason: collision with root package name */
    private int f7437d;

    h(c cVar) {
        this.f7435b = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(Handler handler, int i2) {
        this.f7436c = handler;
        this.f7437d = i2;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Point point = this.f7435b.f7407c;
        Handler handler = this.f7436c;
        if (point == null || handler == null) {
            LogUtility.d(f7434a, "Got preview callback, but no handler or resolution available");
            return;
        }
        handler.obtainMessage(this.f7437d, point.x, point.y, bArr).sendToTarget();
        this.f7436c = null;
    }
}
