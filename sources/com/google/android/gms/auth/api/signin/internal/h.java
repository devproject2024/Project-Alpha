package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.a.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.f;
import easypay.manager.Constants;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static a f8265a = new a("GoogleSignInCommon");

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f8265a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.EASY_PAY_CONFIG_PREF_KEY, signInConfiguration);
        intent.putExtra(Constants.EASY_PAY_CONFIG_PREF_KEY, bundle);
        return intent;
    }

    public static g<Status> a(e eVar, Context context, boolean z) {
        f8265a.a("Signing out", new Object[0]);
        a(context);
        if (z) {
            return com.google.android.gms.common.api.h.a(Status.f8354a, eVar);
        }
        return eVar.b(new k(eVar));
    }

    public static g<Status> b(e eVar, Context context, boolean z) {
        f8265a.a("Revoking access", new Object[0]);
        String a2 = b.a(context).a("refreshToken");
        a(context);
        if (z) {
            return d.a(a2);
        }
        return eVar.b(new m(eVar));
    }

    private static void a(Context context) {
        n.a(context).a();
        for (e c2 : e.a()) {
            c2.c();
        }
        f.b();
    }
}
