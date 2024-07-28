package com.travel.train.InAppPushNotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.Html;
import androidx.core.app.h;
import com.paytm.b.a.a;
import com.paytm.contactsSdk.database.ContactColumn;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.j.w;

public class CJRRoamingNotificationPublisherServiesTrain extends JobService {

    /* renamed from: a  reason: collision with root package name */
    private final int f25792a = 2020;

    /* renamed from: b  reason: collision with root package name */
    private Context f25793b;

    /* renamed from: c  reason: collision with root package name */
    private String f25794c;

    /* renamed from: d  reason: collision with root package name */
    private a f25795d;

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String b2;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(ContactColumn.PHONE_NUMBER);
            this.f25795d = w.a(getApplicationContext());
            this.f25794c = this.f25795d.b("roaming_mobile_no", "", true);
            this.f25793b = getApplicationContext();
            this.f25795d.a("key_roaming_alarm", "false", true);
            if (telephonyManager != null && telephonyManager.isNetworkRoaming() && this.f25794c != null && !this.f25794c.isEmpty()) {
                b.a();
                String S = b.b().S();
                if (S != null && S.equalsIgnoreCase("true") && (b2 = this.f25795d.b("is_postpaid", "", true)) != null && b2.equalsIgnoreCase("false") && com.paytm.utility.b.c(this.f25793b)) {
                    b.a();
                    Intent b3 = b.b().b(this.f25793b);
                    b3.setAction("android.intent.action.MAIN");
                    b3.addCategory("android.intent.category.LAUNCHER");
                    b3.setFlags(872415232);
                    b3.setData(Uri.parse("paytmmp://mobile_prepaid?url=https://catalog.paytm.com/v1/mobile/mobile-prepaid/17$recharge_number=" + this.f25794c + "$roaming=true$utm_source=push_notification$utm_medium=push_notification$utm_campaign=roaming"));
                    b3.putExtra("push_notification", false);
                    PendingIntent activity = PendingIntent.getActivity(this.f25793b, 0, b3, 0);
                    Bitmap decodeResource = BitmapFactory.decodeResource(this.f25793b.getResources(), R.drawable.pre_t_ic_launcher);
                    b.a();
                    String T = b.b().T();
                    if (T == null) {
                        T = "Recharge your phone with a Roaming pack and save money #PaytmKaro";
                    }
                    b.a();
                    String U = b.b().U();
                    if (U == null) {
                        U = "Looks like you are on Roaming!";
                    }
                    h.c a2 = new h.c().a((CharSequence) Html.fromHtml(T));
                    h.e eVar = new h.e(this.f25793b);
                    eVar.a(true);
                    eVar.a((CharSequence) U);
                    eVar.b((CharSequence) T);
                    eVar.f2723f = activity;
                    eVar.a(decodeResource);
                    eVar.a((h.C0039h) a2);
                    eVar.a(R.drawable.pre_t_ic_launcher_small);
                    eVar.l = 1;
                    eVar.b(3);
                    eVar.d();
                    Notification d2 = eVar.d();
                    d2.flags |= 16;
                    ((NotificationManager) this.f25793b.getSystemService("notification")).notify(0, d2);
                    String b4 = this.f25795d.b("roaming_set_twice", "false", false);
                    b.a();
                    int V = b.b().V();
                    if (V == 0) {
                        V = 259200000;
                    }
                    if (b4 != null && b4.equalsIgnoreCase("false")) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            JobInfo.Builder builder = new JobInfo.Builder(2020, new ComponentName(getPackageName(), CJRRoamingNotificationPublisherServiesTrain.class.getName()));
                            builder.setMinimumLatency(SystemClock.elapsedRealtime() + ((long) V));
                            builder.setPersisted(true);
                            int schedule = ((JobScheduler) this.f25793b.getSystemService("jobscheduler")).schedule(builder.build());
                        } else {
                            this.f25795d.a("key_roaming_alarm", "true", true);
                            this.f25795d.a("roaming_set_twice", "true", false);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
