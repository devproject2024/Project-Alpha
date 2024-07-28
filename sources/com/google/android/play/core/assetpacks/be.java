package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.b.bq;
import java.util.Map;

final /* synthetic */ class be implements bn {

    /* renamed from: a  reason: collision with root package name */
    private final bo f37044a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f37045b;

    be(bo boVar, Bundle bundle) {
        this.f37044a = boVar;
        this.f37045b = bundle;
    }

    public final Object a() {
        bo boVar = this.f37044a;
        Bundle bundle = this.f37045b;
        int i2 = bundle.getInt("session_id");
        if (i2 == 0) {
            return Boolean.TRUE;
        }
        Map<Integer, bl> map = boVar.f37075e;
        Integer valueOf = Integer.valueOf(i2);
        if (!map.containsKey(valueOf)) {
            return Boolean.TRUE;
        }
        bl blVar = boVar.f37075e.get(valueOf);
        if (blVar.f37064c.f37059c == 6) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(!by.a(blVar.f37064c.f37059c, bundle.getInt(bq.a("status", bo.a(bundle)))));
    }
}
