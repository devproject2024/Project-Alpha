package net.one97.paytm;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.Html;
import androidx.core.app.h;
import com.paytm.b.a.a;
import com.paytm.contactsSdk.database.ContactColumn;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;

public class CJRRoamingNotificationPublisher extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f51820a;

    /* renamed from: b  reason: collision with root package name */
    private String f51821b;

    /* renamed from: c  reason: collision with root package name */
    private a f51822c;

    public void onReceive(Context context, Intent intent) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
        this.f51822c = ag.a(context.getApplicationContext());
        this.f51821b = this.f51822c.b("roaming_mobile_no", "", true);
        this.f51820a = context;
        this.f51822c.a("key_roaming_alarm", "false", true);
        if (telephonyManager != null && telephonyManager.isNetworkRoaming() && (str = this.f51821b) != null && !str.isEmpty()) {
            c.a();
            String a2 = c.a("roamingEnabled", (String) null);
            if (a2 != null && a2.equalsIgnoreCase("true")) {
                String b2 = this.f51822c.b("is_postpaid", "", true);
                if (b2.equals("")) {
                    b2 = null;
                }
                if (b2 != null && b2.equalsIgnoreCase("false") && com.paytm.utility.a.m(this.f51820a)) {
                    Intent intent2 = new Intent(this.f51820a, AJRMainActivity.class);
                    intent2.setAction("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.LAUNCHER");
                    intent2.setFlags(872415232);
                    intent2.setData(Uri.parse("paytmmp://mobile_prepaid?url=https://catalog.paytm.com/v1/mobile/mobile-prepaid/17$recharge_number=" + this.f51821b + "$roaming=true$utm_source=push_notification$utm_medium=push_notification$utm_campaign=roaming"));
                    intent2.putExtra("push_notification", false);
                    PendingIntent activity = PendingIntent.getActivity(this.f51820a, 0, intent2, 0);
                    Bitmap decodeResource = BitmapFactory.decodeResource(this.f51820a.getResources(), R.drawable.ic_launcher);
                    c.a();
                    String a3 = c.a("roamingContent", (String) null);
                    if (a3 == null) {
                        a3 = "Recharge your phone with a Roaming pack and save money #PaytmKaro";
                    }
                    c.a();
                    String a4 = c.a("roamingTitle", (String) null);
                    if (a4 == null) {
                        a4 = "Looks like you are on Roaming!";
                    }
                    h.c a5 = new h.c().a((CharSequence) Html.fromHtml(a3));
                    h.e eVar = new h.e(this.f51820a);
                    eVar.a(true);
                    eVar.a((CharSequence) a4);
                    eVar.b((CharSequence) a3);
                    eVar.f2723f = activity;
                    eVar.a(decodeResource);
                    eVar.a((h.C0039h) a5);
                    eVar.a((int) R.drawable.ic_launcher_small);
                    eVar.l = 1;
                    eVar.b(3);
                    eVar.d();
                    Notification d2 = eVar.d();
                    d2.flags |= 16;
                    ((NotificationManager) this.f51820a.getSystemService("notification")).notify(0, d2);
                    String b3 = this.f51822c.b("roaming_set_twice", "false", true);
                    c.a();
                    int a6 = c.a("roamingSecondTime", 0);
                    if (a6 == 0) {
                        a6 = 259200000;
                    }
                    if (b3 != null && b3.equalsIgnoreCase("false")) {
                        ((AlarmManager) this.f51820a.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + ((long) a6), PendingIntent.getBroadcast(this.f51820a, 0, new Intent(this.f51820a, CJRRoamingNotificationPublisher.class), 134217728));
                        this.f51822c.a("key_roaming_alarm", "true", true);
                        this.f51822c.a("roaming_set_twice", "true", true);
                    }
                }
            }
        }
    }
}
