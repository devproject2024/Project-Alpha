package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.crashlytics.a.a.b;

final class a implements a.b {

    /* renamed from: a  reason: collision with root package name */
    b f38134a;

    /* renamed from: b  reason: collision with root package name */
    b f38135b;

    a() {
    }

    public final void a(int i2, Bundle bundle) {
        b bVar;
        com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
        StringBuilder sb = new StringBuilder("Received Analytics message: ");
        sb.append(i2);
        sb.append(" ");
        sb.append(bundle);
        a2.a(3);
        String string = bundle.getString("name");
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            if ("clx".equals(bundle2.getString("_o"))) {
                bVar = this.f38134a;
            } else {
                bVar = this.f38135b;
            }
            if (bVar != null) {
                bVar.b(string, bundle2);
            }
        }
    }
}
