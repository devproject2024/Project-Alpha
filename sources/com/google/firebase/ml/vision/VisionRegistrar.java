package com.google.firebase.ml.vision;

import com.google.android.gms.internal.firebase_ml.as;
import com.google.android.gms.internal.firebase_ml.ds;
import com.google.android.gms.internal.firebase_ml.dt;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.ml.common.a.b;
import com.google.firebase.ml.vision.automl.internal.a;
import java.util.List;

public class VisionRegistrar implements h {
    public List<b<?>> getComponents() {
        return as.zza(b.a(a.class).a(n.b(ds.class)).a(c.f39133a).a(), b.a(a.class).a(n.b(dt.a.class)).a(n.b(ds.class)).a(b.f39094a).a(), b.b(b.a.class).a(n.d(a.class)).a(d.f39138a).a());
    }
}
