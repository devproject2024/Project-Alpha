package net.one97.paytm.googlenow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.CjrSafeJobIntentService;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.a.a.a.a.c;
import com.google.a.a.a.d;
import com.google.a.a.a.j;
import com.google.a.a.a.k;
import com.google.a.a.a.m;
import com.google.a.a.a.t;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class HttpPostService extends CjrSafeJobIntentService {
    public static void a(Context context, Intent intent) {
        a(context, (Class<?>) HttpPostService.class, 4256, intent);
    }

    public final void a(Intent intent) {
        j jVar;
        c cVar = new c();
        String stringExtra = intent.getStringExtra("method");
        try {
            net.one97.paytm.j.c.a();
            String a2 = net.one97.paytm.j.c.a("validatetoken", (String) null);
            a.c();
            if (stringExtra != null && a2 != null && !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(stringExtra)) {
                Intent intent2 = new Intent("com.google.api.services.paytm.now.paytmclient.BROADCAST");
                Bundle extras = intent.getExtras();
                HashMap hashMap = new HashMap();
                if (extras != null) {
                    intent2.putExtras(extras);
                    Serializable serializable = extras.getSerializable("params");
                    if (serializable != null) {
                        hashMap.putAll((HashMap) serializable);
                    }
                }
                k kVar = new k(cVar);
                t tVar = new t(hashMap);
                StringBuilder sb = new StringBuilder();
                sb.append(tVar);
                sb.append("params >>>>>");
                sb.append(hashMap);
                a.c();
                try {
                    if (stringExtra.startsWith(a2)) {
                        jVar = kVar.a(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, new com.google.a.a.a.c(stringExtra), (d) null);
                    } else {
                        jVar = kVar.a("POST", new com.google.a.a.a.c(stringExtra), tVar);
                    }
                    m a3 = jVar.a();
                    new StringBuilder("before respponse >>>>>").append(a3);
                    a.c();
                    int i2 = a3.f7514b;
                    a.c();
                    intent2.putExtra("statusCode", i2);
                    if (i2 == 200) {
                        intent2.putExtra("responseText", a3.c().trim());
                    }
                    new StringBuilder("response is >>>>>").append(a3.c().trim());
                    a.c();
                    a3.b();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    intent2.setPackage(getPackageName());
                    sendBroadcast(intent2);
                    throw th;
                }
                intent2.setPackage(getPackageName());
                sendBroadcast(intent2);
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }
}
