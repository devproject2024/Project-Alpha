package com.travel.bus.busticket.InAppPushNotification;

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
import android.text.TextUtils;
import androidx.core.app.h;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.b;
import com.travel.bus.R;
import com.travel.bus.b.a;

public class CJRRoamingNotificationPublisherServies extends JobService {

    /* renamed from: a  reason: collision with root package name */
    private final int f21528a = 2020;

    /* renamed from: b  reason: collision with root package name */
    private Context f21529b;

    /* renamed from: c  reason: collision with root package name */
    private String f21530c;

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(ContactColumn.PHONE_NUMBER);
            this.f21530c = a.a(getApplicationContext()).b("roaming_mobile_no", "", true);
            this.f21529b = getApplicationContext();
            a.a(getApplicationContext()).a("key_roaming_alarm", "false", true);
            if (telephonyManager != null && telephonyManager.isNetworkRoaming() && this.f21530c != null && !this.f21530c.isEmpty()) {
                com.travel.bus.a.a();
                String F = com.travel.bus.a.b().F();
                if (F != null && F.equalsIgnoreCase("true")) {
                    String b2 = a.a(getApplicationContext()).b("is_postpaid", "", true);
                    if (!TextUtils.isEmpty(b2) && b2.equalsIgnoreCase("false") && b.c(this.f21529b)) {
                        com.travel.bus.a.a();
                        Intent c2 = com.travel.bus.a.b().c(this.f21529b);
                        c2.setAction("android.intent.action.MAIN");
                        c2.addCategory("android.intent.category.LAUNCHER");
                        c2.setFlags(872415232);
                        c2.setData(Uri.parse("paytmmp://mobile_prepaid?url=https://catalog.paytm.com/v1/mobile/mobile-prepaid/17$recharge_number=" + this.f21530c + "$roaming=true$utm_source=push_notification$utm_medium=push_notification$utm_campaign=roaming"));
                        c2.putExtra("push_notification", false);
                        PendingIntent activity = PendingIntent.getActivity(this.f21529b, 0, c2, 0);
                        Bitmap decodeResource = BitmapFactory.decodeResource(this.f21529b.getResources(), R.drawable.ic_bus_launcher);
                        com.travel.bus.a.a();
                        String G = com.travel.bus.a.b().G();
                        if (G == null) {
                            G = "Recharge your phone with a Roaming pack and save money #PaytmKaro";
                        }
                        com.travel.bus.a.a();
                        String I = com.travel.bus.a.b().I();
                        if (I == null) {
                            I = "Looks like you are on Roaming!";
                        }
                        h.c a2 = new h.c().a((CharSequence) Html.fromHtml(G));
                        h.e eVar = new h.e(this.f21529b);
                        eVar.a(true);
                        eVar.a((CharSequence) I);
                        eVar.b((CharSequence) G);
                        eVar.f2723f = activity;
                        eVar.a(decodeResource);
                        eVar.a((h.C0039h) a2);
                        eVar.a(R.drawable.ic_bus_launcher_small);
                        eVar.l = 1;
                        eVar.b(3);
                        eVar.d();
                        Notification d2 = eVar.d();
                        d2.flags |= 16;
                        ((NotificationManager) this.f21529b.getSystemService("notification")).notify(0, d2);
                        String b3 = a.a(getApplicationContext()).b("roaming_set_twice", "false", true);
                        com.travel.bus.a.a();
                        int H = com.travel.bus.a.b().H();
                        if (H == 0) {
                            H = 259200000;
                        }
                        if (!TextUtils.isEmpty(b3) && b3.equalsIgnoreCase("false")) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                JobInfo.Builder builder = new JobInfo.Builder(2020, new ComponentName(getPackageName(), CJRRoamingNotificationPublisherServies.class.getName()));
                                builder.setMinimumLatency(SystemClock.elapsedRealtime() + ((long) H));
                                builder.setPersisted(true);
                                int schedule = ((JobScheduler) this.f21529b.getSystemService("jobscheduler")).schedule(builder.build());
                            } else {
                                a.a(getApplicationContext()).a("key_roaming_alarm", "true", true);
                                a.a(getApplicationContext()).a("roaming_set_twice", "true", true);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
