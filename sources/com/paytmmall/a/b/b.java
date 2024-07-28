package com.paytmmall.a.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.v;
import java.util.HashMap;
import net.one97.paytm.phoenix.provider.PhoenixAuthProvider;

public final class b implements PhoenixAuthProvider {
    public final boolean logoutAllDevices(Activity activity, HashMap<String, Object> hashMap) {
        return false;
    }

    public final Intent login(Activity activity, HashMap<String, Object> hashMap) {
        Class<? extends Activity> intentClass;
        if (activity == null || (intentClass = t.e().getIntentClass(activity, "authActivity")) == null) {
            return null;
        }
        return new Intent(activity, intentClass);
    }

    public final boolean logout(Activity activity, HashMap<String, Object> hashMap) {
        if (activity == null) {
            return false;
        }
        a(activity);
        return true;
    }

    public final boolean sessionExpired(Activity activity, HashMap<String, Object> hashMap) {
        if (activity == null) {
            return false;
        }
        a(activity);
        return true;
    }

    public static void a(Activity activity) {
        t.e().clearSessionData(activity);
        v.a().a((Context) activity);
    }

    public final PhoenixAuthProvider.AuthData provideAuthToken(Activity activity) {
        if (activity != null) {
            return new PhoenixAuthProvider.AuthData(l.a((Context) activity), com.paytm.utility.b.m());
        }
        return null;
    }
}
