package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f8868a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8869b = this.f8868a.getResourcePackageName(R.string.common_google_play_services_unknown_issue);

    public v(Context context) {
        s.a(context);
        this.f8868a = context.getResources();
    }

    public final String a(String str) {
        int identifier = this.f8868a.getIdentifier(str, "string", this.f8869b);
        if (identifier == 0) {
            return null;
        }
        return this.f8868a.getString(identifier);
    }
}
