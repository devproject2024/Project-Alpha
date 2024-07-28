package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.util.Base64;
import androidx.browser.trusted.d;
import androidx.browser.trusted.e;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    Context f37661a;

    public c(Context context) {
        this.f37661a = context;
    }

    public final androidx.browser.trusted.c a() {
        String string = this.f37661a.getSharedPreferences("com.google.androidbrowserhelper", 0).getString("SharedPreferencesTokenStore.TOKEN", (String) null);
        if (string == null) {
            return null;
        }
        return new androidx.browser.trusted.c(new d(Base64.decode(string, 3)));
    }
}
