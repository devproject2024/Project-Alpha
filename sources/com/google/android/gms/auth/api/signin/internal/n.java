package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.s;
import org.json.JSONObject;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static n f8269a;

    /* renamed from: b  reason: collision with root package name */
    private b f8270b;

    /* renamed from: c  reason: collision with root package name */
    private GoogleSignInAccount f8271c = this.f8270b.a();

    /* renamed from: d  reason: collision with root package name */
    private GoogleSignInOptions f8272d = this.f8270b.b();

    private n(Context context) {
        this.f8270b = b.a(context);
    }

    public static synchronized n a(Context context) {
        n b2;
        synchronized (n.class) {
            b2 = b(context.getApplicationContext());
        }
        return b2;
    }

    private static synchronized n b(Context context) {
        synchronized (n.class) {
            if (f8269a != null) {
                n nVar = f8269a;
                return nVar;
            }
            n nVar2 = new n(context);
            f8269a = nVar2;
            return nVar2;
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void a() {
        b bVar = this.f8270b;
        bVar.f8258a.lock();
        try {
            bVar.f8259b.edit().clear().apply();
            bVar.f8258a.unlock();
            this.f8271c = null;
            this.f8272d = null;
        } catch (Throwable th) {
            bVar.f8258a.unlock();
            throw th;
        }
    }

    public final synchronized void a(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        b bVar = this.f8270b;
        s.a(googleSignInAccount);
        s.a(googleSignInOptions);
        bVar.a("defaultGoogleSignInAccount", googleSignInAccount.f8204b);
        s.a(googleSignInAccount);
        s.a(googleSignInOptions);
        String str = googleSignInAccount.f8204b;
        String b2 = b.b("googleSignInAccount", str);
        JSONObject b3 = googleSignInAccount.b();
        b3.remove("serverAuthCode");
        bVar.a(b2, b3.toString());
        bVar.a(b.b("googleSignInOptions", str), googleSignInOptions.b().toString());
        this.f8271c = googleSignInAccount;
        this.f8272d = googleSignInOptions;
    }
}
