package com.google.firebase.ml.common;

import android.content.Context;
import com.google.android.gms.internal.firebase_ml.Cdo;
import com.google.android.gms.internal.firebase_ml.as;
import com.google.android.gms.internal.firebase_ml.ds;
import com.google.android.gms.internal.firebase_ml.dt;
import com.google.android.gms.internal.firebase_ml.ec;
import com.google.android.gms.internal.firebase_ml.ef;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.ml.common.a.b;
import java.util.List;

public class CommonComponentRegistrar implements h {
    public List<b<?>> getComponents() {
        return as.zza(dt.j, Cdo.f9807b, ec.f9843c, ef.f9854a, ds.f9816a, b.a(dt.b.class).a(n.b(Context.class)).a(c.f39068a).a(), b.a(com.google.firebase.ml.common.a.b.class).a(n.c(b.a.class)).a(b.f39067a).a());
    }
}
