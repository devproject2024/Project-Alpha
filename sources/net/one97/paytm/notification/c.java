package net.one97.paytm.notification;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.j.a;
import net.one97.paytm.landingpage.activity.AJRMainActivity;

public final class c {
    public final boolean a(final Context context, final b bVar) {
        q.d("User clicked notification. Alert: " + bVar.a());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        boolean z = runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200;
        q.d("URL from push bundle " + bVar.b().getString("url"));
        if (z) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public final void run() {
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("notificationBundle", bVar.b());
                        a.b(context, intent);
                    } catch (Exception unused) {
                    }
                }
            });
            h.a aVar = h.f50349a;
            h.a.a(context, (String) null, bVar.b());
            String a2 = bVar.a();
            String string = bVar.b().getString("url");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("nav_push_text", a2);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put("nav_push_destination_url", string);
                }
                if (com.paytm.utility.a.p(context)) {
                    String a3 = com.paytm.utility.a.a(context);
                    if (!TextUtils.isEmpty(a3)) {
                        hashMap.put("Customer_Id", a3);
                        hashMap.put("nav_push_user_id", a3);
                    }
                }
                a.b("nav_push_notification_clicked", (Map<String, Object>) hashMap, context);
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
            return true;
        }
        Intent intent = new Intent(context, AJRMainActivity.class);
        intent.putExtra("notificationBundle", bVar.b());
        intent.putExtra("isFromNotification", true);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(872415232);
        context.startActivity(intent);
        return true;
    }
}
