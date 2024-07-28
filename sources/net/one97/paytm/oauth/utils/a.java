package net.one97.paytm.oauth.utils;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.fragment.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56763a = new a();

    private a() {
    }

    public static boolean a(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService("keyguard");
        if (!(systemService instanceof KeyguardManager)) {
            systemService = null;
        }
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (keyguardManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return keyguardManager.isDeviceSecure();
        }
        return keyguardManager.isKeyguardSecure();
    }

    public static boolean a() {
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        return net.one97.paytm.oauth.a.f();
    }

    public static void a(Activity activity, int i2, String str) {
        k.c(activity, "activity");
        Object systemService = activity.getSystemService("keyguard");
        Intent intent = null;
        if (!(systemService instanceof KeyguardManager)) {
            systemService = null;
        }
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(R.string.lbl_unlock_paytm);
        }
        if (keyguardManager != null) {
            intent = keyguardManager.createConfirmDeviceCredentialIntent(str, activity.getString(R.string.lbl_confirm_screen_lock));
        }
        if (i2 <= 0) {
            i2 = 2001;
        }
        OauthModule.b().sendGAMultipleLabelEvent(activity, "verify_app_lock", "verify_app_lock_asked", (ArrayList<String>) null, (String) null, (String) null, p.f56796a);
        try {
            activity.startActivityForResult(intent, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Activity activity, int i2) {
        k.c(activity, "activity");
        Intent intent = new Intent("android.app.action.SET_NEW_PASSWORD");
        if (i2 <= 0) {
            i2 = H5RpcPlugin.RpcRequest.H5_APP_ERROR_CODE;
        }
        activity.startActivityForResult(intent, i2);
    }

    public static void a(AppCompatActivity appCompatActivity, boolean z, String str) {
        if (z) {
            if (a((Context) appCompatActivity)) {
                q qVar = q.f56798a;
                if (q.x()) {
                    a((Activity) appCompatActivity, 0, str);
                    return;
                }
            }
            q qVar2 = q.f56798a;
            q.b(false);
        }
    }

    public static void a(j jVar, int i2) {
        k.c(jVar, "fragmentManager");
        if (!a(jVar) && a() && Build.VERSION.SDK_INT >= 21) {
            b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            if (com.paytm.utility.b.r(b2.getApplicationContext())) {
                Bundle bundle = new Bundle();
                bundle.putInt("request_code", i2);
                t.a aVar = t.f56626a;
                t a2 = t.a.a(bundle);
                a2.setCancelable(false);
                q a3 = jVar.a();
                k.a((Object) a3, "fragmentManager.beginTransaction()");
                a3.a((Fragment) a2, t.class.getName());
                a3.c();
            }
        }
    }

    public static boolean a(j jVar) {
        return (jVar != null ? jVar.c(t.class.getName()) : null) != null;
    }
}
