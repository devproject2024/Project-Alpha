package com.google.android.gms.internal.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.clearcut.c;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.r;

public final class cy extends d<Object> implements c {
    private cy(Context context) {
        super(context, a.f8298a, null, (r) new com.google.android.gms.common.api.internal.a());
    }

    public static c a(Context context) {
        return new cy(context);
    }

    public final g<Status> a(zze zze) {
        return doBestEffortWrite(new fz(zze, asGoogleApiClient()));
    }
}
