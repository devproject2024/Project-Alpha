package net.one97.paytm.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.j.a;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.c.p;

public final class bg {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static p f69720a;

    private static void b(Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("webview_popup_user_action", "seen");
            a.b("webview_update_popup", (Map<String, Object>) hashMap, context);
        } catch (Exception unused) {
        }
    }

    public static void a(final AppCompatActivity appCompatActivity) {
        if (appCompatActivity == null) {
            return;
        }
        if (b.d() == 21 || b.d() == 22 || b.d() == 23) {
            try {
                String str = appCompatActivity.getPackageManager().getPackageInfo("com.google.android.webview", 0).versionName;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.equals("54.0.2840.85") || str.equals("54.0.2840.68") || str.equals("53.0.2785.124") || str.equals("51.0.2704.81")) {
                    f69720a = new p(appCompatActivity.getString(R.string.webview_error), appCompatActivity.getString(R.string.webview_error_btn), new View.OnClickListener() {
                        public final void onClick(View view) {
                            bg.a((Context) appCompatActivity);
                            try {
                                appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.webview")));
                            } catch (ActivityNotFoundException unused) {
                                appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.webview")));
                            }
                            try {
                                bg.f69720a.dismiss();
                            } catch (IllegalStateException e2) {
                                q.b(e2.getMessage());
                            }
                        }
                    });
                    b(appCompatActivity);
                    androidx.fragment.app.q a2 = appCompatActivity.getSupportFragmentManager().a();
                    a2.a((Fragment) f69720a, "dialog");
                    a2.c();
                }
            } catch (PackageManager.NameNotFoundException unused) {
                q.b("Android System WebView is not found");
            }
        } else if (b.d() > 23) {
            try {
                String str2 = appCompatActivity.getPackageManager().getPackageInfo("com.android.chrome", 0).versionName;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (str2.equals("54.0.2840.85") || str2.equals("54.0.2840.68") || str2.equals("53.0.2785.124") || str2.equals("52.0.2743.98")) {
                    f69720a = new p(appCompatActivity.getString(R.string.chrome_webview_error), appCompatActivity.getString(R.string.chrome_webview_error_btn), new View.OnClickListener() {
                        public final void onClick(View view) {
                            bg.a((Context) appCompatActivity);
                            try {
                                appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.android.chrome")));
                            } catch (ActivityNotFoundException unused) {
                                appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.android.chrome")));
                            }
                            bg.f69720a.dismiss();
                        }
                    });
                    b(appCompatActivity);
                    f69720a.show(appCompatActivity.getSupportFragmentManager(), "dialog");
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                q.b("Android System WebView is not found");
            }
        }
    }

    static /* synthetic */ void a(Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("webview_popup_user_action", "clicked");
            a.b("webview_update_popup", (Map<String, Object>) hashMap, context);
        } catch (Exception unused) {
        }
    }
}
