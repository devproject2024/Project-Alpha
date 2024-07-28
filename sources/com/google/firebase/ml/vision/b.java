package com.google.firebase.ml.vision;

import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.firebase_ml.ds;
import com.google.android.gms.internal.firebase_ml.dt;
import com.google.firebase.components.e;
import com.google.firebase.components.g;
import com.google.firebase.ml.vision.automl.internal.a;

final /* synthetic */ class b implements g {

    /* renamed from: a  reason: collision with root package name */
    static final g f39094a = new b();

    private b() {
    }

    public final Object a(e eVar) {
        s.b(((ds) eVar.a(ds.class)).f9817b.b().equals("[DEFAULT]"), "FirebaseAutoMLModelManager doesn't support Nondefault FirebaseApp");
        return new a((ds) eVar.a(ds.class), (dt) ((dt.a) eVar.a(dt.a.class)).a(5));
    }
}
