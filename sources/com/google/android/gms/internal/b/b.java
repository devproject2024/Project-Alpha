package com.google.android.gms.internal.b;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.tasks.Task;

public final class b extends com.google.android.gms.auth.api.phone.b {
    public b(Context context) {
        super(context);
    }

    public b(Activity activity) {
        super(activity);
    }

    public final Task<Void> a() {
        t.a builder = t.builder();
        builder.f8629a = new o(this);
        builder.f8630b = new Feature[]{e.f9096c};
        return doWrite(builder.a());
    }

    public final Task<Void> b() {
        t.a builder = t.builder();
        builder.f8629a = new d(this);
        builder.f8630b = new Feature[]{e.f9097d};
        return doWrite(builder.a());
    }
}
