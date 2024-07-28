package net.one97.paytm.payments.visascp.network;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import java.net.URL;
import net.one97.paytm.payments.visascp.security.certificatepinning.TLSSocketFactory;
import net.one97.paytm.payments.visascp.util.Logger;
import net.one97.paytm.payments.visascp.util.Utils;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class VolleyWrapper extends Volley {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f610 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f611 = 1;

    public static RequestQueue newRequestQueue(Context context, String str) {
        try {
            Logger.i(VisaSCPConstants.LOG_TAG, "Server Hostname: ".concat(String.valueOf(new URL(str).getHost())));
            int i2 = f610;
            int i3 = (i2 & 104) + (i2 | 104);
            int i4 = (i3 & -1) + (i3 | -1);
            f611 = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e2) {
            Logger.e(VisaSCPConstants.LOG_TAG, e2);
        }
        RequestQueue newRequestQueue = Volley.newRequestQueue(context);
        int i6 = f611;
        int i7 = ((i6 & 27) - (~(i6 | 27))) - 1;
        f610 = i7 % 128;
        if (i7 % 2 != 0) {
        }
        return newRequestQueue;
    }

    public static RequestQueue newRequestQueueForCertificatePinning(Context context, String str) {
        RequestQueue requestQueue = null;
        try {
            Logger.i(VisaSCPConstants.LOG_TAG, "Server Hostname for Certificate pinning: ".concat(String.valueOf(new URL(str).getHost())));
            requestQueue = Volley.newRequestQueue(context, (BaseHttpStack) new HurlStack((HurlStack.UrlRewriter) null, new TLSSocketFactory(Utils.getVisaCertificateFromServer(context))));
            int i2 = f610 + 51;
            f611 = i2 % 128;
            if (i2 % 2 != 0) {
            }
        } catch (Exception e2) {
            Logger.e(VisaSCPConstants.LOG_TAG, e2);
        }
        int i3 = f611;
        int i4 = (i3 ^ 115) + ((i3 & 115) << 1);
        f610 = i4 % 128;
        if (i4 % 2 != 0) {
        }
        return requestQueue;
    }
}
