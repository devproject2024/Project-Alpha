package com.google.firebase.ml.vision;

import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.firebase_ml.ds;
import com.google.android.gms.internal.firebase_ml.ef;
import com.google.firebase.ml.vision.a.a;
import com.google.firebase.ml.vision.barcode.c;
import com.google.firebase.ml.vision.c.a;
import com.google.firebase.ml.vision.d.a;
import com.google.firebase.ml.vision.e.a;
import com.google.firebase.ml.vision.e.b;
import com.google.firebase.ml.vision.f.a;
import com.google.firebase.ml.vision.objects.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final com.google.firebase.ml.vision.a.a f39069a = new a.C0652a().a();

    /* renamed from: b  reason: collision with root package name */
    private static final com.google.firebase.ml.vision.d.a f39070b;

    /* renamed from: c  reason: collision with root package name */
    private static final c f39071c = new c.a().a();

    /* renamed from: d  reason: collision with root package name */
    private static final com.google.firebase.ml.vision.f.a f39072d;

    /* renamed from: e  reason: collision with root package name */
    private static final com.google.firebase.ml.vision.c.a f39073e;

    /* renamed from: f  reason: collision with root package name */
    private static final b f39074f = new b(new b.a().f39156a, (byte) 0);

    /* renamed from: g  reason: collision with root package name */
    private static final com.google.firebase.ml.vision.e.a f39075g;

    /* renamed from: h  reason: collision with root package name */
    private static final com.google.firebase.ml.vision.objects.a f39076h;

    /* renamed from: i  reason: collision with root package name */
    private final ds f39077i;
    private final ef j;

    public static a a() {
        com.google.firebase.c e2 = com.google.firebase.c.e();
        s.a(e2, (Object) "MlKitContext can not be null");
        return (a) e2.a(a.class);
    }

    public final com.google.firebase.ml.vision.barcode.b a(c cVar) {
        return com.google.firebase.ml.vision.barcode.b.a(this.f39077i, (c) s.a(cVar, (Object) "Please provide a valid FirebaseVisionBarcodeDetectorOptions"));
    }

    a(ds dsVar) {
        this.f39077i = dsVar;
        this.j = ef.a(dsVar);
    }

    static {
        a.C0654a aVar = new a.C0654a();
        f39070b = new com.google.firebase.ml.vision.d.a(aVar.f39145a, aVar.f39146b, aVar.f39147c, aVar.f39148d, aVar.f39149e, aVar.f39150f, (byte) 0);
        a.C0656a aVar2 = new a.C0656a();
        f39072d = new com.google.firebase.ml.vision.f.a(aVar2.f39160a, aVar2.f39161b, aVar2.f39162c, (byte) 0);
        a.C0653a aVar3 = new a.C0653a();
        f39073e = new com.google.firebase.ml.vision.c.a(aVar3.f39136a, aVar3.f39137b, (byte) 0);
        a.C0655a aVar4 = new a.C0655a();
        f39075g = new com.google.firebase.ml.vision.e.a(aVar4.f39153a, aVar4.f39154b, (byte) 0);
        a.C0657a aVar5 = new a.C0657a();
        f39076h = new com.google.firebase.ml.vision.objects.a(aVar5.f39166a, aVar5.f39167b, aVar5.f39168c, (byte) 0);
    }
}
