package com.google.android.gms.safetynet;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.j.k;
import com.google.android.gms.internal.j.x;
import com.google.android.gms.internal.j.y;

public final class SafetyNet {
    @Deprecated
    public static final a<Object> API = new a<>("SafetyNet.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final a.C0125a<x, Object> CLIENT_BUILDER = new zzk();
    private static final a.g<x> CLIENT_KEY = new a.g<>();
    @Deprecated
    public static final SafetyNetApi SafetyNetApi = new k();
    private static final zzo zzu = new y();

    private SafetyNet() {
    }

    public static SafetyNetClient getClient(Activity activity) {
        return new SafetyNetClient(activity);
    }

    public static SafetyNetClient getClient(Context context) {
        return new SafetyNetClient(context);
    }
}
