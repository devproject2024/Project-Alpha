package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.a.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.s;
import java.util.ArrayList;

public final class b extends Exception {
    private final a<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> zaba;

    public b(a<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> aVar) {
        this.zaba = aVar;
    }

    public final ConnectionResult getConnectionResult(d<? extends a.d> dVar) {
        com.google.android.gms.common.api.internal.b<? extends a.d> apiKey = dVar.getApiKey();
        s.b(this.zaba.get(apiKey) != null, "The given API was not part of the availability request.");
        return this.zaba.get(apiKey);
    }

    public final ConnectionResult getConnectionResult(f<? extends a.d> fVar) {
        com.google.android.gms.common.api.internal.b<? extends a.d> apiKey = fVar.getApiKey();
        s.b(this.zaba.get(apiKey) != null, "The given API was not part of the availability request.");
        return this.zaba.get(apiKey);
    }

    public final androidx.a.a<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> zaj() {
        return this.zaba;
    }

    public final String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (com.google.android.gms.common.api.internal.b next : this.zaba.keySet()) {
            ConnectionResult connectionResult = this.zaba.get(next);
            if (connectionResult.b()) {
                z = false;
            }
            String str = next.f8451a.f8364b;
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(valueOf).length());
            sb.append(str);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
