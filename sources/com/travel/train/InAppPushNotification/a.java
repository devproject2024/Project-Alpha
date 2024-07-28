package com.travel.train.InAppPushNotification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import androidx.core.app.h;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.j.w;
import java.util.HashSet;
import java.util.Set;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f25796a = "CJRInAppNotificationGeneratorTrain";

    public static Notification a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Context context2 = context;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.pre_t_ic_launcher);
        h.c a2 = new h.c().a((CharSequence) Html.fromHtml(str3));
        b.a();
        Intent b2 = b.b().b(context);
        b2.setAction("android.intent.action.MAIN");
        b2.addCategory("android.intent.category.LAUNCHER");
        b2.setFlags(872415232);
        b2.setData(Uri.parse(v.a("paytmmp://", str, "?", "utm_medium", "=", SDKConstants.PUSH_FROM_PUSH, "$", "utm_source", "=", str5, "$", "utm_term", "=", str6, "$", "utm_campaign", "=", str2)));
        b2.putExtra("push_notification", false);
        PendingIntent activity = PendingIntent.getActivity(context, 0, b2, 0);
        h.e eVar = new h.e(context);
        eVar.a(true);
        eVar.a((CharSequence) str4);
        String str7 = str3;
        eVar.b((CharSequence) str3);
        eVar.f2723f = activity;
        eVar.a(decodeResource);
        eVar.a((h.C0039h) a2);
        eVar.a(R.drawable.pre_t_ic_launcher_small);
        eVar.l = 1;
        eVar.b(3);
        return eVar.d();
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Context context2 = context;
        Set hashSet = new HashSet();
        try {
            com.paytm.b.a.a a2 = w.a(context.getApplicationContext());
            f fVar = new f();
            String b2 = a2.b("userDropVerticalList", (String) null, false);
            if (!TextUtils.isEmpty(b2)) {
                hashSet = (Set) fVar.a(b2, new com.google.gson.b.a<Set<Integer>>() {
                }.getType());
            }
            hashSet.add(11);
            a2.a("userDropVerticalList", fVar.a((Object) hashSet), false);
            int i2 = 1800000;
            if (Build.VERSION.SDK_INT >= 21) {
                JobInfo.Builder builder = new JobInfo.Builder(2019, new ComponentName("net.one97.paytm", CJRNotificationPublisherServiceTrain.class.getName()));
                b.a();
                int R = b.b().R();
                if (R != 0) {
                    i2 = R;
                }
                builder.setMinimumLatency(SystemClock.elapsedRealtime() + ((long) i2));
                builder.setPersisted(true);
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString("ur_type", str);
                persistableBundle.putString("ur_type", str2);
                persistableBundle.putString("push_message", str4);
                persistableBundle.putString("push_title", str3);
                persistableBundle.putString("utm_source", str5);
                persistableBundle.putString("utm_temd", str6);
                persistableBundle.putInt("push_request_code", 11);
                builder.setExtras(persistableBundle);
                builder.setRequiredNetworkType(1);
                builder.setRequiresCharging(false);
                if (((JobScheduler) context2.getSystemService("jobscheduler")).schedule(builder.build()) == 1) {
                }
                return;
            }
            String str7 = str;
            String str8 = str2;
            String str9 = str3;
            String str10 = str4;
            String str11 = str5;
            String str12 = str6;
            Intent intent = new Intent(context2, CJRNotificationPublisherTrain.class);
            intent.putExtra(CJRNotificationPublisherTrain.f25789a, a(context, str, str2, str4, str3, str5, str6));
            intent.putExtra("push_request_code", 11);
            PendingIntent broadcast = PendingIntent.getBroadcast(context2, 11, intent, 134217728);
            b.a();
            int R2 = b.b().R();
            if (R2 != 0) {
                i2 = R2;
            }
            ((AlarmManager) context2.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + ((long) i2), broadcast);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}
