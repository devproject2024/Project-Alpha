package com.google.zxing.client.android.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

final class f implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40131a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final b f40132b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f40133c;

    /* renamed from: d  reason: collision with root package name */
    private int f40134d;

    f(b bVar) {
        this.f40132b = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(Handler handler, int i2) {
        this.f40133c = handler;
        this.f40134d = i2;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Point point = this.f40132b.f40120c;
        Handler handler = this.f40133c;
        if (point != null && handler != null) {
            handler.obtainMessage(this.f40134d, point.x, point.y, bArr).sendToTarget();
            this.f40133c = null;
        }
    }
}
