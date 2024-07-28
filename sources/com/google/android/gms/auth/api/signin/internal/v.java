package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.q;

public final class v extends p {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8273a;

    public v(Context context) {
        this.f8273a = context;
    }

    public final void a() {
        c();
        b a2 = b.a(this.f8273a);
        GoogleSignInAccount a3 = a2.a();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f8216f;
        if (a3 != null) {
            googleSignInOptions = a2.b();
        }
        b bVar = new b(this.f8273a, (GoogleSignInOptions) s.a(googleSignInOptions));
        boolean z = true;
        if (a3 != null) {
            e asGoogleApiClient = bVar.asGoogleApiClient();
            Context applicationContext = bVar.getApplicationContext();
            if (bVar.a() != b.C0119b.f8236c) {
                z = false;
            }
            r.a(h.b(asGoogleApiClient, applicationContext, z));
            return;
        }
        e asGoogleApiClient2 = bVar.asGoogleApiClient();
        Context applicationContext2 = bVar.getApplicationContext();
        if (bVar.a() != b.C0119b.f8236c) {
            z = false;
        }
        r.a(h.a(asGoogleApiClient2, applicationContext2, z));
    }

    public final void b() {
        c();
        n.a(this.f8273a).a();
    }

    private final void c() {
        if (!q.a(this.f8273a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder sb = new StringBuilder(52);
            sb.append("Calling UID ");
            sb.append(callingUid);
            sb.append(" is not Google Play services.");
            throw new SecurityException(sb.toString());
        }
    }
}
