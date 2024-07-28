package net.one97.paytm.oauth.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Telephony;
import android.telephony.SmsManager;
import com.alipay.mobile.nebula.util.H5Utils;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.utility.q;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.j;
import kotlin.m.l;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.e.f;
import net.one97.paytm.oauth.utils.OtpSmsRetrieveBroadcastReceiver;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f56805a = new x();

    /* renamed from: b  reason: collision with root package name */
    private static BroadcastReceiver f56806b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f56807c;

    private x() {
    }

    public static boolean a() {
        return f56807c;
    }

    public static void b() {
        f56807c = true;
    }

    public static OtpSmsRetrieveBroadcastReceiver a(Activity activity, OtpSmsRetrieveBroadcastReceiver.a aVar) {
        k.c(activity, "activity");
        k.c(aVar, "listener");
        try {
            OtpSmsRetrieveBroadcastReceiver otpSmsRetrieveBroadcastReceiver = new OtpSmsRetrieveBroadcastReceiver();
            otpSmsRetrieveBroadcastReceiver.a(aVar);
            activity.registerReceiver(otpSmsRetrieveBroadcastReceiver, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
            return otpSmsRetrieveBroadcastReceiver;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Activity activity, OtpSmsRetrieveBroadcastReceiver otpSmsRetrieveBroadcastReceiver) {
        k.c(activity, "activity");
        if (otpSmsRetrieveBroadcastReceiver != null) {
            try {
                otpSmsRetrieveBroadcastReceiver.a((OtpSmsRetrieveBroadcastReceiver.a) null);
                activity.unregisterReceiver(otpSmsRetrieveBroadcastReceiver);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, int i2, String str, f fVar, List<String> list, int i3) {
        k.c(context, "context");
        k.c(str, "smsText");
        k.c(fVar, "listener");
        k.c(list, "vmnList");
        new Handler(Looper.getMainLooper());
        int i4 = 0;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("SMS_SENT"), 0);
        x.c cVar = new x.c();
        cVar.element = 0;
        f56806b = new SmsOtpUtils$sendDirectSMS$1(cVar, fVar, list, context);
        context.registerReceiver(f56806b, new IntentFilter("SMS_SENT"));
        int size = list.size();
        long j = 0;
        for (String str2 : list) {
            if (i4 <= size - 1) {
                b(i2, str2, str, broadcast, fVar, j);
                j = ((long) i3) * 1000;
                i4++;
            } else {
                return;
            }
        }
    }

    public static void b(Context context, int i2, String str, f fVar, List<String> list, int i3) {
        Context context2 = context;
        List<String> list2 = list;
        k.c(context2, "context");
        k.c(str, "smsText");
        k.c(fVar, "listener");
        k.c(list2, "vmnList");
        x.c cVar = new x.c();
        cVar.element = 0;
        PendingIntent broadcast = PendingIntent.getBroadcast(context2, 0, new Intent("SMS_SENT"), 0);
        f56806b = new SmsOtpUtils$sendDirectSMSSequentially$1(cVar, fVar, list, i2, str, broadcast, i3, context);
        context2.registerReceiver(f56806b, new IntentFilter("SMS_SENT"));
        b(i2, list2.get(cVar.element), str, broadcast, fVar, 0);
        cVar.element++;
    }

    /* access modifiers changed from: private */
    public static void b(int i2, String str, String str2, PendingIntent pendingIntent, f fVar, long j) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (Build.VERSION.SDK_INT >= 22) {
            handler.postDelayed(new a(i2, str, str2, pendingIntent, fVar), j);
            return;
        }
        handler.postDelayed(new b(str, str2, pendingIntent), j);
        OauthModule.b().logHawEyeEvent(new net.one97.paytm.oauth.models.a("send_sms", "/login-signup", str, (String) null, (String) null, 0, 56));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f56808a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56809b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f56810c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PendingIntent f56811d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f f56812e;

        a(int i2, String str, String str2, PendingIntent pendingIntent, f fVar) {
            this.f56808a = i2;
            this.f56809b = str;
            this.f56810c = str2;
            this.f56811d = pendingIntent;
            this.f56812e = fVar;
        }

        public final void run() {
            try {
                SmsManager.getSmsManagerForSubscriptionId(this.f56808a).sendTextMessage(this.f56809b, (String) null, this.f56810c, this.f56811d, (PendingIntent) null);
                new StringBuilder("SMS Time:").append(System.currentTimeMillis());
                q.b();
                OauthModule.b().logHawEyeEvent(new net.one97.paytm.oauth.models.a("send_sms", "/login-signup", this.f56809b, (String) null, (String) null, 0, 56));
            } catch (Exception e2) {
                e2.printStackTrace();
                f fVar = this.f56812e;
                String localizedMessage = e2.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = H5Utils.NETWORK_TYPE_UNKNOWN;
                }
                fVar.a(localizedMessage);
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f56813a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56814b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PendingIntent f56815c;

        b(String str, String str2, PendingIntent pendingIntent) {
            this.f56813a = str;
            this.f56814b = str2;
            this.f56815c = pendingIntent;
        }

        public final void run() {
            SmsManager.getDefault().sendTextMessage(this.f56813a, (String) null, this.f56814b, this.f56815c, (PendingIntent) null);
        }
    }

    public static void a(Context context) {
        BroadcastReceiver broadcastReceiver = f56806b;
        if (broadcastReceiver != null) {
            if (context != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
            f56806b = null;
            q.b();
        }
    }

    public static String a(Context context, String str) {
        k.c(str, "otp");
        l lVar = new l("(\\d{6})");
        if (context != null) {
            if (androidx.core.app.a.a(context, "android.permission.READ_SMS") != 0) {
                q.b("SMS_READ permission not granted");
                return null;
            }
            Cursor query = context.getContentResolver().query(Telephony.Sms.CONTENT_URI, (String[]) null, (String) null, (String[]) null, "date DESC");
            int i2 = 10;
            while (query != null && query.moveToNext() && i2 > 0) {
                i2--;
                String string = query.getString(query.getColumnIndexOrThrow("body"));
                k.a((Object) string, "body");
                j find$default = l.find$default(lVar, string, 0, 2, (Object) null);
                String string2 = query.getString(query.getColumnIndexOrThrow(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS));
                StringBuilder sb = new StringBuilder("SMS SenderId:");
                sb.append(string2);
                sb.append(" , Count:");
                sb.append(10 - i2);
                q.b();
                if (k.a((Object) str, (Object) find$default != null ? find$default.b() : null)) {
                    query.close();
                    return string2;
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return null;
    }
}
