package com.travel.bus.busticket.InAppPushNotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Html;
import androidx.core.app.h;
import com.paytm.utility.v;
import com.travel.bus.R;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a {
    public static Notification a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Context context2 = context;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bus_launcher);
        h.c a2 = new h.c().a((CharSequence) Html.fromHtml(str3));
        com.travel.bus.a.a();
        Intent c2 = com.travel.bus.a.b().c(context);
        c2.setAction("android.intent.action.MAIN");
        c2.addCategory("android.intent.category.LAUNCHER");
        c2.setFlags(872415232);
        c2.setData(Uri.parse(v.a("paytmmp://", str, "?", "utm_medium", "=", SDKConstants.PUSH_FROM_PUSH, "$", "utm_source", "=", str5, "$", "utm_term", "=", str6, "$", "utm_campaign", "=", str2)));
        c2.putExtra("push_notification", false);
        PendingIntent activity = PendingIntent.getActivity(context, 0, c2, 0);
        h.e eVar = new h.e(context);
        eVar.a(true);
        eVar.a((CharSequence) str4);
        String str7 = str3;
        eVar.b((CharSequence) str3);
        eVar.f2723f = activity;
        eVar.a(decodeResource);
        eVar.a((h.C0039h) a2);
        eVar.a(R.drawable.ic_bus_launcher_small);
        eVar.l = 1;
        eVar.b(3);
        return eVar.d();
    }
}
