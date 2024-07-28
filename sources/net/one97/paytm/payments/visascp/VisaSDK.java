package net.one97.paytm.payments.visascp;

import android.content.Context;
import net.one97.paytm.payments.visascp.VisaSCPMain;

public class VisaSDK {
    public static String SAFETY_NET_API_KEY;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Server f550;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static VisaSCP f551;

    public static VisaSCP getInstance(Context context, String str) {
        if (f551 == null) {
            f551 = new VisaSCPMain.VisaSCPBuilder().setApplicationContext(context).build();
        }
        SAFETY_NET_API_KEY = str;
        return f551;
    }

    public static void setServer(Server server) {
        f550 = server;
    }

    public static boolean isStaging() {
        return f550 == Server.STAGING;
    }
}
