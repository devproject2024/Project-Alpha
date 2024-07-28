package net.one97.paytm.referral.c;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.c.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f20028a = new b();

    private b() {
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        k.c(context, "context");
        switch (str3.hashCode()) {
            case -1920703281:
                if (str3.equals("back_clicked")) {
                    Context context2 = context;
                    a.b().sendNewCustomGTMEventsWithMultipleLabel(context2, "primary offer", "back_clicked", kotlin.a.k.d(str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case -1531986341:
                if (str3.equals("twitter_clicked")) {
                    net.one97.paytm.vipcashback.c.b b2 = a.b();
                    Context context3 = context;
                    b2.sendNewCustomGTMEventsWithMultipleLabel(context3, "primary offer", "twitter_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case -1374335759:
                if (str3.equals("invite_clicked")) {
                    net.one97.paytm.vipcashback.c.b b3 = a.b();
                    Context context4 = context;
                    b3.sendNewCustomGTMEventsWithMultipleLabel(context4, "primary offer", "invite_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case -864466279:
                if (str3.equals("primary_page_load")) {
                    Context context5 = context;
                    a.b().sendNewCustomGTMEventsWithMultipleLabel(context5, "primary offer", "primary_page_load", kotlin.a.k.d(str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case -581219011:
                if (str3.equals("more_clicked")) {
                    net.one97.paytm.vipcashback.c.b b4 = a.b();
                    Context context6 = context;
                    b4.sendNewCustomGTMEventsWithMultipleLabel(context6, "primary offer", "more_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case -136076687:
                if (str3.equals("know_more_clicked")) {
                    net.one97.paytm.vipcashback.c.b b5 = a.b();
                    Context context7 = context;
                    b5.sendNewCustomGTMEventsWithMultipleLabel(context7, "primary offer", "know_more_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case 1026597213:
                if (str3.equals("copy_clicked")) {
                    net.one97.paytm.vipcashback.c.b b6 = a.b();
                    Context context8 = context;
                    b6.sendNewCustomGTMEventsWithMultipleLabel(context8, "primary offer", "copy_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case 1083804481:
                if (str3.equals("sms_clicked")) {
                    net.one97.paytm.vipcashback.c.b b7 = a.b();
                    Context context9 = context;
                    b7.sendNewCustomGTMEventsWithMultipleLabel(context9, "primary offer", "sms_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case 1532011293:
                if (str3.equals("total_cashback_clicked")) {
                    Context context10 = context;
                    a.b().sendNewCustomGTMEventsWithMultipleLabel(context10, "primary offer", "total_cashback_clicked", kotlin.a.k.d(str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            case 2079054770:
                if (str3.equals("wa_clicked")) {
                    net.one97.paytm.vipcashback.c.b b8 = a.b();
                    Context context11 = context;
                    b8.sendNewCustomGTMEventsWithMultipleLabel(context11, "primary offer", "wa_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_landing", "");
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5) {
        k.c(context, "context");
        switch (str3.hashCode()) {
            case -1920703281:
                if (str3.equals("back_clicked")) {
                    net.one97.paytm.vipcashback.c.b b2 = a.b();
                    Context context2 = context;
                    b2.sendNewCustomGTMEventsWithMultipleLabel(context2, "secondary offer", "back_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_secondary_landing", "");
                    return;
                }
                return;
            case -1531986341:
                if (str3.equals("twitter_clicked")) {
                    net.one97.paytm.vipcashback.c.b b3 = a.b();
                    Context context3 = context;
                    b3.sendNewCustomGTMEventsWithMultipleLabel(context3, "secondary offer", "twitter_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_secondary_landing", "");
                    return;
                }
                return;
            case -793213045:
                if (str3.equals("secondary_page_load")) {
                    net.one97.paytm.vipcashback.c.b b4 = a.b();
                    Context context4 = context;
                    b4.sendNewCustomGTMEventsWithMultipleLabel(context4, "secondary offer", "secondary_page_load", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_secondary_landing", "");
                    return;
                }
                return;
            case -581219011:
                if (str3.equals("more_clicked")) {
                    net.one97.paytm.vipcashback.c.b b5 = a.b();
                    Context context5 = context;
                    b5.sendNewCustomGTMEventsWithMultipleLabel(context5, "secondary offer", "more_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_secondary_landing", "");
                    return;
                }
                return;
            case 1026597213:
                if (str3.equals("copy_clicked")) {
                    net.one97.paytm.vipcashback.c.b b6 = a.b();
                    Context context6 = context;
                    b6.sendNewCustomGTMEventsWithMultipleLabel(context6, "secondary offer", "offer&rewards_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_secondary_landing", "");
                    return;
                }
                return;
            case 1083804481:
                if (str3.equals("sms_clicked")) {
                    net.one97.paytm.vipcashback.c.b b7 = a.b();
                    Context context7 = context;
                    b7.sendNewCustomGTMEventsWithMultipleLabel(context7, "secondary offer", "sms_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_secondary_landing", "");
                    return;
                }
                return;
            case 2079054770:
                if (str3.equals("wa_clicked")) {
                    net.one97.paytm.vipcashback.c.b b8 = a.b();
                    Context context8 = context;
                    b8.sendNewCustomGTMEventsWithMultipleLabel(context8, "secondary offer", "wa_clicked", kotlin.a.k.d(str4, str5, str, str2), "", "/referral_secondary_landing", "");
                    return;
                }
                return;
            default:
                return;
        }
    }
}
