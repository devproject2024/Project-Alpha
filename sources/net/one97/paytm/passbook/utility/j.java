package net.one97.paytm.passbook.utility;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.genericPassbook.d.a.f;
import net.one97.paytm.passbook.mapping.c;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static String f59255a = "Paytm Passbook";

    public static void a(Activity activity, Throwable th) {
        NetworkCustomError networkCustomError;
        if (activity != null && !activity.isFinishing() && (networkCustomError = (NetworkCustomError) th) != null) {
            networkCustomError.getAlertMessage();
            if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 404) || networkCustomError.getStatusCode() == 400 || networkCustomError.getStatusCode() == 503) {
                try {
                    if (!activity.isFinishing()) {
                        if (networkCustomError.getStatusCode() == 404 || networkCustomError.getStatusCode() == 400 || networkCustomError.getStatusCode() == 503) {
                            c.a((Context) activity, activity.getResources().getString(R.string.title_400), activity.getResources().getString(R.string.message_400));
                        }
                    }
                } catch (Exception unused) {
                }
            } else if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                a(activity, networkCustomError, false, true);
            } else if (networkCustomError.getStatusCode() == -1 || d.b().a(activity, (Exception) networkCustomError)) {
                if (networkCustomError.mErrorType == null || TextUtils.isEmpty(networkCustomError.mErrorType.name()) || !networkCustomError.mErrorType.name().equalsIgnoreCase("NoConnectionError")) {
                    c.a((Context) activity, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                    return;
                }
                c.a((Context) activity, activity.getResources().getString(R.string.pass_network_error_heading), activity.getResources().getString(R.string.pass_network_error_message));
            } else if (networkCustomError.getStatusCode() != -1) {
                String url = networkCustomError.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append(networkCustomError.getStatusCode());
                b.d((Context) activity, url, sb.toString());
            } else {
                c.a((Context) activity, activity.getResources().getString(R.string.pass_network_error_heading), activity.getResources().getString(R.string.pass_network_error_message) + " " + networkCustomError.getUrl());
            }
        }
    }

    public static void a(Activity activity, Exception exc, boolean z, boolean z2) {
        if (activity != null && !activity.isFinishing() && (exc instanceof NetworkCustomError)) {
            f fVar = f.f57462b;
            f.b();
            d.b().a(activity, activity.getClass().getName(), z, z2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A[SYNTHETIC, Splitter:B:21:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r5, com.paytm.network.model.NetworkCustomError r6) {
        /*
            java.lang.String r0 = "message"
            java.lang.String r1 = "errorMessage"
            com.paytm.network.model.NetworkResponse r6 = r6.networkResponse
            r2 = 0
            if (r6 == 0) goto L_0x0047
            int r3 = r6.statusCode
            r4 = 401(0x191, float:5.62E-43)
            if (r3 == r4) goto L_0x0046
            r4 = 403(0x193, float:5.65E-43)
            if (r3 == r4) goto L_0x0046
            r4 = 410(0x19a, float:5.75E-43)
            if (r3 != r4) goto L_0x0018
            goto L_0x0046
        L_0x0018:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.headers
            java.lang.String r4 = "Content-Encoding"
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            byte[] r4 = r6.data
            if (r4 == 0) goto L_0x0047
            if (r3 == 0) goto L_0x003d
            java.lang.String r4 = "gzip"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x003d
            byte[] r6 = r6.data
            java.io.Reader r6 = com.paytm.network.b.g.a((byte[]) r6)
            if (r6 == 0) goto L_0x0047
            java.lang.String r6 = com.paytm.network.b.g.a((java.io.Reader) r6)
            goto L_0x0049
        L_0x003d:
            java.lang.String r3 = new java.lang.String
            byte[] r6 = r6.data
            r3.<init>(r6)
            r6 = r3
            goto L_0x0049
        L_0x0046:
            return r2
        L_0x0047:
            java.lang.String r6 = ""
        L_0x0049:
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            if (r3 != 0) goto L_0x0089
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0089 }
            r3.<init>(r6)     // Catch:{ JSONException -> 0x0089 }
            boolean r6 = r3.has(r1)     // Catch:{ JSONException -> 0x0089 }
            r4 = 1
            if (r6 == 0) goto L_0x006f
            java.lang.String r6 = r3.getString(r1)     // Catch:{ JSONException -> 0x0089 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0089 }
            if (r0 != 0) goto L_0x0089
            int r0 = net.one97.paytm.passbook.R.string.error     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ JSONException -> 0x0089 }
            com.paytm.utility.b.b((android.content.Context) r5, (java.lang.String) r0, (java.lang.String) r6)     // Catch:{ JSONException -> 0x0089 }
            return r4
        L_0x006f:
            boolean r6 = r3.has(r0)     // Catch:{ JSONException -> 0x0089 }
            if (r6 == 0) goto L_0x0089
            java.lang.String r6 = r3.getString(r0)     // Catch:{ JSONException -> 0x0089 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0089 }
            if (r0 != 0) goto L_0x0089
            int r0 = net.one97.paytm.passbook.R.string.error     // Catch:{ JSONException -> 0x0089 }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ JSONException -> 0x0089 }
            com.paytm.utility.b.b((android.content.Context) r5, (java.lang.String) r0, (java.lang.String) r6)     // Catch:{ JSONException -> 0x0089 }
            return r4
        L_0x0089:
            int r6 = net.one97.paytm.passbook.R.string.error
            java.lang.String r6 = r5.getString(r6)
            int r0 = net.one97.paytm.passbook.R.string.some_went_wrong
            java.lang.String r0 = r5.getString(r0)
            com.paytm.utility.b.b((android.content.Context) r5, (java.lang.String) r6, (java.lang.String) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.utility.j.a(android.content.Context, com.paytm.network.model.NetworkCustomError):boolean");
    }
}
