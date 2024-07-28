package net.one97.scanner.camera;

import com.google.android.gms.vision.a;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.e;

final class a extends e<Barcode> {

    /* renamed from: a  reason: collision with root package name */
    f f72463a;

    public final void onDone() {
    }

    public final void onMissing(a.C0163a<Barcode> aVar) {
    }

    public final /* synthetic */ void onUpdate(a.C0163a aVar, Object obj) {
        Barcode barcode = (Barcode) obj;
        f fVar = this.f72463a;
        if (fVar != null) {
            fVar.a(barcode);
        }
    }

    public a(f fVar) {
        this.f72463a = fVar;
    }
}
