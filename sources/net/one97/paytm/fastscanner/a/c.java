package net.one97.paytm.fastscanner.a;

import android.hardware.Camera;
import net.one97.paytm.fastscanner.b.b;
import net.one97.paytm.fastscanner.b.f;
import net.one97.paytm.fastscanner.c.a;

final class c implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f50419a = c.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private final a f50420b;

    /* renamed from: c  reason: collision with root package name */
    private int f50421c;

    c(a aVar) {
        this.f50420b = aVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f50421c = i2;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        a aVar = a.f50448b;
        if (!a.c()) {
            a aVar2 = a.f50448b;
            a.a(true);
            a aVar3 = a.f50448b;
            a.i();
        }
        Camera.Parameters parameters = null;
        try {
            parameters = camera.getParameters();
        } catch (Exception e2) {
            b bVar = b.f50423a;
            b.b("ganesh", "error while getting parameters : " + e2.getMessage());
        }
        f.a().a(this.f50421c, this.f50420b.f50407a.f50409a, this.f50420b.f50407a.f50410b, bArr, parameters);
    }
}
