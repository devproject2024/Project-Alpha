package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.tasks.Task;

public final class i extends d<Object> {
    public i(Activity activity) {
        super(activity, f.f11372a, null, (r) new a());
    }

    public i(Context context) {
        super(context, f.f11372a, null, (r) new a());
    }

    public final Task<g> a(LocationSettingsRequest locationSettingsRequest) {
        return com.google.android.gms.common.internal.r.a(f.f11375d.a(asGoogleApiClient(), locationSettingsRequest), new g());
    }
}
