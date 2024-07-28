package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.appsflyer.internal.am;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class CrossPromotionHelper {

    /* renamed from: ɩ  reason: contains not printable characters */
    private static String f322 = "https://%simpression.%s";

    public static void trackAndOpenStore(Context context, String str, String str2) {
        trackAndOpenStore(context, str, str2, (Map<String, String>) null);
    }

    public static void trackAndOpenStore(Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator r4 = m216(context, str, str2, map, ServerConfigHandler.getUrl(Constants.f321));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, track And Open Store is disabled", true);
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("af_campaign", str2);
        AppsFlyerLib.getInstance().trackEvent(context, "af_cross_promotion", map);
        new Thread(new a(r4.generateLink(), new am(), context, AppsFlyerLib.getInstance().isTrackingStopped())).start();
    }

    public static void trackCrossPromoteImpression(Context context, String str, String str2) {
        trackCrossPromoteImpression(context, str, str2, (Map<String, String>) null);
    }

    public static void trackCrossPromoteImpression(Context context, String str, String str2, Map<String, String> map) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, Promote Impression is disabled", true);
        } else {
            new Thread(new a(m216(context, str, str2, map, ServerConfigHandler.getUrl(f322)).generateLink(), (am) null, (Context) null, AppsFlyerLib.getInstance().isTrackingStopped())).start();
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static LinkGenerator m216(Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.f332 = str3;
        linkGenerator.f337 = str;
        linkGenerator.addParameter(Constants.URL_SITE_ID, context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string != null) {
            linkGenerator.addParameter("advertising_id", string);
        }
        return linkGenerator;
    }

    static class a implements Runnable {

        /* renamed from: ı  reason: contains not printable characters */
        private final WeakReference<Context> f323;

        /* renamed from: ǃ  reason: contains not printable characters */
        private final String f324;

        /* renamed from: ɩ  reason: contains not printable characters */
        private final boolean f325;

        /* renamed from: Ι  reason: contains not printable characters */
        private final am f326;

        a(String str, am amVar, Context context, boolean z) {
            this.f324 = str;
            this.f326 = amVar;
            this.f323 = new WeakReference<>(context);
            this.f325 = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00c5 A[DONT_GENERATE] */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r6 = this;
                boolean r0 = r6.f325
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x00b7 }
                java.lang.String r2 = r6.f324     // Catch:{ all -> 0x00b7 }
                r1.<init>(r2)     // Catch:{ all -> 0x00b7 }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x00b7 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ all -> 0x00b7 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ all -> 0x00b7 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x00b7 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ all -> 0x00b5 }
                r0 = 0
                r1.setInstanceFollowRedirects(r0)     // Catch:{ all -> 0x00b5 }
                int r2 = r1.getResponseCode()     // Catch:{ all -> 0x00b5 }
                r3 = 200(0xc8, float:2.8E-43)
                if (r2 == r3) goto L_0x009c
                r3 = 301(0x12d, float:4.22E-43)
                if (r2 == r3) goto L_0x004e
                r3 = 302(0x12e, float:4.23E-43)
                if (r2 == r3) goto L_0x004e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = "call to "
                r0.<init>(r3)     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = r6.f324     // Catch:{ all -> 0x00b5 }
                r0.append(r3)     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = " failed: "
                r0.append(r3)     // Catch:{ all -> 0x00b5 }
                r0.append(r2)     // Catch:{ all -> 0x00b5 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b5 }
                com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x00b5 }
                goto L_0x00af
            L_0x004e:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = "Cross promotion redirection success: "
                r2.<init>(r3)     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = r6.f324     // Catch:{ all -> 0x00b5 }
                r2.append(r3)     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b5 }
                com.appsflyer.AFLogger.afInfoLog(r2, r0)     // Catch:{ all -> 0x00b5 }
                com.appsflyer.internal.am r0 = r6.f326     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x00af
                java.lang.ref.WeakReference<android.content.Context> r0 = r6.f323     // Catch:{ all -> 0x00b5 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x00af
                com.appsflyer.internal.am r0 = r6.f326     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Location"
                java.lang.String r2 = r1.getHeaderField(r2)     // Catch:{ all -> 0x00b5 }
                r0.f209 = r2     // Catch:{ all -> 0x00b5 }
                com.appsflyer.internal.am r0 = r6.f326     // Catch:{ all -> 0x00b5 }
                java.lang.ref.WeakReference<android.content.Context> r2 = r6.f323     // Catch:{ all -> 0x00b5 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00b5 }
                android.content.Context r2 = (android.content.Context) r2     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = r0.f209     // Catch:{ all -> 0x00b5 }
                if (r3 == 0) goto L_0x00af
                android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x00b5 }
                java.lang.String r4 = "android.intent.action.VIEW"
                java.lang.String r0 = r0.f209     // Catch:{ all -> 0x00b5 }
                android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ all -> 0x00b5 }
                r3.<init>(r4, r0)     // Catch:{ all -> 0x00b5 }
                r0 = 268435456(0x10000000, float:2.5243549E-29)
                android.content.Intent r0 = r3.setFlags(r0)     // Catch:{ all -> 0x00b5 }
                r2.startActivity(r0)     // Catch:{ all -> 0x00b5 }
                goto L_0x00af
            L_0x009c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = "Cross promotion impressions success: "
                r2.<init>(r3)     // Catch:{ all -> 0x00b5 }
                java.lang.String r3 = r6.f324     // Catch:{ all -> 0x00b5 }
                r2.append(r3)     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b5 }
                com.appsflyer.AFLogger.afInfoLog(r2, r0)     // Catch:{ all -> 0x00b5 }
            L_0x00af:
                if (r1 == 0) goto L_0x00c8
                r1.disconnect()
                return
            L_0x00b5:
                r0 = move-exception
                goto L_0x00bb
            L_0x00b7:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x00bb:
                java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x00c9 }
                r3 = 1
                com.appsflyer.AFLogger.afErrorLog(r2, r0, r3)     // Catch:{ all -> 0x00c9 }
                if (r1 == 0) goto L_0x00c8
                r1.disconnect()
            L_0x00c8:
                return
            L_0x00c9:
                r0 = move-exception
                if (r1 == 0) goto L_0x00cf
                r1.disconnect()
            L_0x00cf:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.share.CrossPromotionHelper.a.run():void");
        }
    }
}
