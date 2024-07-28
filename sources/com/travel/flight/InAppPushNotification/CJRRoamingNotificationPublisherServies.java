package com.travel.flight.InAppPushNotification;

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
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.utils.i;

public class CJRRoamingNotificationPublisherServies extends JobService {

    /* renamed from: a  reason: collision with root package name */
    private final int f23472a = 2020;

    /* renamed from: b  reason: collision with root package name */
    private Context f23473b;

    /* renamed from: c  reason: collision with root package name */
    private String f23474c;

    /* renamed from: d  reason: collision with root package name */
    private a f23475d;

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String b2;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(ContactColumn.PHONE_NUMBER);
            this.f23475d = i.a(getApplicationContext());
            this.f23474c = this.f23475d.b("roaming_mobile_no", "", true);
            this.f23473b = getApplicationContext();
            this.f23475d.a("key_roaming_alarm", "false", true);
            if (telephonyManager != null && telephonyManager.isNetworkRoaming() && this.f23474c != null && !this.f23474c.isEmpty()) {
                b.a();
                String G = b.b().G();
                if (G != null && G.equalsIgnoreCase("true") && (b2 = this.f23475d.b("is_postpaid", "", true)) != null && b2.equalsIgnoreCase("false") && com.paytm.utility.b.c(this.f23473b)) {
                    b.a();
                    Intent c2 = b.b().c(this.f23473b);
                    c2.setAction("android.intent.action.MAIN");
                    c2.addCategory("android.intent.category.LAUNCHER");
                    c2.setFlags(872415232);
                    c2.setData(Uri.parse("paytmmp://mobile_prepaid?url=https://catalog.paytm.com/v1/mobile/mobile-prepaid/17$recharge_number=" + this.f23474c + "$roaming=true$utm_source=push_notification$utm_medium=push_notification$utm_campaign=roaming"));
                    c2.putExtra("push_notification", false);
                    PendingIntent activity = PendingIntent.getActivity(this.f23473b, 0, c2, 0);
                    Bitmap decodeResource = BitmapFactory.decodeResource(this.f23473b.getResources(), R.drawable.pre_f_ic_launcher);
                    b.a();
                    String H = b.b().H();
                    if (H == null) {
                        H = "Recharge your phone with a Roaming pack and save money #PaytmKaro";
                    }
                    b.a();
                    String I = b.b().I();
                    if (I == null) {
                        I = "Looks like you are on Roaming!";
                    }
                    h.c a2 = new h.c().a((CharSequence) Html.fromHtml(H));
                    h.e eVar = new h.e(this.f23473b);
                    eVar.a(true);
                    eVar.a((CharSequence) I);
                    eVar.b((CharSequence) H);
                    eVar.f2723f = activity;
                    eVar.a(decodeResource);
                    eVar.a((h.C0039h) a2);
                    eVar.a(R.drawable.pre_f_ic_launcher_small);
                    eVar.l = 1;
                    eVar.b(3);
                    eVar.d();
                    Notification d2 = eVar.d();
                    d2.flags |= 16;
                    ((NotificationManager) this.f23473b.getSystemService("notification")).notify(0, d2);
                    String b3 = this.f23475d.b("roaming_set_twice", "false", true);
                    b.a();
                    int J = b.b().J();
                    if (J == 0) {
                        J = 259200000;
                    }
                    if (b3 != null && b3.equalsIgnoreCase("false")) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            JobInfo.Builder builder = new JobInfo.Builder(2020, new ComponentName(getPackageName(), CJRRoamingNotificationPublisherServies.class.getName()));
                            builder.setMinimumLatency(SystemClock.elapsedRealtime() + ((long) J));
                            builder.setPersisted(true);
                            int schedule = ((JobScheduler) this.f23473b.getSystemService("jobscheduler")).schedule(builder.build());
                        } else {
                            this.f23475d.a("key_roaming_alarm", "true", true);
                            this.f23475d.a("roaming_set_twice", "true", true);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
