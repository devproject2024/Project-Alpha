package net.one97.paytm.googlenow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.j.c;

public class ResponseHandler extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("method");
        try {
            c.a();
            String a2 = c.a("validatetoken", (String) null);
            c.a();
            String a3 = c.a("authcode", (String) null);
            if (a2 != null && a3 != null && !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                a.c();
                if (stringExtra.startsWith(a2)) {
                    intent.getStringExtra("responseText");
                    a.c();
                    if (intent.getIntExtra("statusCode", 0) != 200) {
                        a(context);
                    }
                } else if (stringExtra.equals("GetAuthCode")) {
                    String stringExtra2 = intent.getStringExtra("authCode");
                    String stringExtra3 = intent.getStringExtra("access_token");
                    if (stringExtra3 != null) {
                        a.c();
                        Intent intent2 = new Intent(context, HttpPostService.class);
                        intent2.putExtra("method", "https://accounts.google.com/o/oauth2/revoke?token=".concat(String.valueOf(stringExtra3)));
                        HttpPostService.a(context, intent2);
                    } else if (stringExtra2 != null) {
                        Bundle bundle = new Bundle();
                        HashMap hashMap = new HashMap();
                        a.c();
                        hashMap.put("auth_code", stringExtra2);
                        bundle.putSerializable("params", hashMap);
                        try {
                            c.a();
                            String a4 = c.a("authcode", (String) null);
                            if (a4 == null) {
                                return;
                            }
                            if (!TextUtils.isEmpty(a4)) {
                                String b2 = b.b(CJRJarvisApplication.getAppContext(), a4);
                                Intent intent3 = new Intent(context, HttpPostService.class);
                                intent3.putExtra("method", b2);
                                intent3.putExtras(bundle);
                                HttpPostService.a(context, intent3);
                            }
                        } catch (Exception e2) {
                            if (b.v) {
                                q.b(e2.getMessage());
                            }
                        }
                    }
                } else if (stringExtra.startsWith(a3)) {
                    if (intent.getIntExtra("statusCode", 0) == 200) {
                        a.c();
                    }
                } else if (stringExtra.startsWith("https://accounts.google.com/o/oauth2/revoke") && intent.getIntExtra("statusCode", 0) == 200) {
                    a.c();
                    a(context);
                }
            }
        } catch (Exception e3) {
            if (b.v) {
                q.b(e3.getMessage());
            }
        }
    }

    private static void a(Context context) {
        Intent intent = new Intent(context, GetAuthCodeService.class);
        intent.putExtra("method", "GetAuthCode");
        GetAuthCodeService.a(context, intent);
    }
}
