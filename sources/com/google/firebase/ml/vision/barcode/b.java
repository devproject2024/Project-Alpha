package com.google.firebase.ml.vision.barcode;

import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.firebase_ml.bg;
import com.google.android.gms.internal.firebase_ml.br;
import com.google.android.gms.internal.firebase_ml.ds;
import com.google.android.gms.internal.firebase_ml.dt;
import com.google.android.gms.internal.firebase_ml.du;
import com.google.android.gms.internal.firebase_ml.ei;
import com.google.android.gms.internal.firebase_ml.en;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import com.google.firebase.ml.vision.b.a;
import com.google.firebase.ml.vision.barcode.internal.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b extends ei<List<a>> implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<du<c>, b> f39113c = new HashMap();

    public static synchronized b a(ds dsVar, c cVar) {
        b bVar;
        synchronized (b.class) {
            s.a(dsVar, (Object) "You must provide a valid MlKitContext.");
            s.a(dsVar.f9817b.h(), (Object) "Firebase app name must not be null");
            s.a(dsVar.f9817b.a(), (Object) "You must provide a valid Context.");
            s.a(cVar, (Object) "You must provide a valid FirebaseVisionBarcodeDetectorOptions.");
            du duVar = new du(dsVar.f9817b.h(), cVar);
            bVar = f39113c.get(duVar);
            if (bVar == null) {
                bVar = new b(dsVar, cVar);
                f39113c.put(duVar, bVar);
            }
        }
        return bVar;
    }

    private b(ds dsVar, c cVar) {
        super(dsVar, new d(dsVar, cVar));
        dt.a(dsVar).a(bg.e.a().a((bg.n) bg.n.a().a(cVar.a()).i()), br.ON_DEVICE_BARCODE_CREATE);
    }

    public final void close() throws IOException {
        super.close();
    }

    public final Task<List<a>> a(a aVar) {
        s.a(aVar, (Object) "FirebaseVisionImage can not be null");
        com.google.android.gms.vision.b a2 = aVar.a();
        if (a2.f12542a.f12546a < 32 || a2.f12542a.f12547b < 32) {
            return h.a((Exception) new com.google.firebase.ml.common.a("Image width and height should be at least 32!", 3));
        }
        return this.f9864b.a(this.f9863a, new en(aVar, a2));
    }
}
