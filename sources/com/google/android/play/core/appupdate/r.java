package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.e;

final class r extends e.a {

    /* renamed from: a  reason: collision with root package name */
    Integer f36933a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f36934b;

    r() {
    }

    public final e.a a() {
        this.f36934b = Boolean.FALSE;
        return this;
    }

    public final e b() {
        String str = "";
        if (this.f36933a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.f36934b == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new s(this.f36933a.intValue(), this.f36934b.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() == 0 ? new String("Missing required properties:") : "Missing required properties:".concat(valueOf));
    }
}
