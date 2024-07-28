package com.paytmmall.artifact.common.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;
import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.q;
import com.paytmmall.artifact.d.c;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.h;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.u;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f15626a = "MallSendGTMTag";

    /* renamed from: b  reason: collision with root package name */
    private static Handler f15627b;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f15628c;

    public static void a(Map<String, Object> map) {
        Map<String, Object> b2;
        if (!(f15627b == null || map == null || (b2 = b(map)) == null)) {
            f15627b.post(new Runnable(b2) {
                private final /* synthetic */ Map f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    b.c(this.f$0);
                }
            });
        }
        t.e().sendEventToPaytmAnalytics(map, "customEvent", true, true, true);
    }

    private static Map<String, Object> b(Map<String, Object> map) {
        try {
            f fVar = new f();
            return (Map) fVar.a(fVar.a((Object) map), new a<Map<String, Object>>() {
            }.getType());
        } catch (Exception e2) {
            s.a(e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void c(Map<String, Object> map) {
        try {
            Context applicationContext = t.e().getApplicationContext();
            DataLayer dataLayer = TagManager.getInstance(applicationContext).getDataLayer();
            dataLayer.push(map == null ? new HashMap<>() : map);
            GoogleAnalytics.getInstance(applicationContext).getLogger().setLogLevel(0);
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, Object> key : map.entrySet()) {
                    hashMap.put(key.getKey(), "");
                }
            }
            dataLayer.push(hashMap);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(String str, Map<String, Object> map) {
        Map<String, Object> b2;
        if (!(f15627b == null || map == null || (b2 = b(map)) == null)) {
            f15627b.post(new Runnable(str, b2) {
                private final /* synthetic */ String f$0;
                private final /* synthetic */ Map f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    b.b(this.f$0, this.f$1);
                }
            });
        }
        t.e().sendEventToPaytmAnalytics(map, "customEvent", true, true, true);
    }

    /* access modifiers changed from: private */
    public static void b(String str, Map<String, Object> map) {
        try {
            Context applicationContext = t.e().getApplicationContext();
            DataLayer dataLayer = TagManager.getInstance(applicationContext).getDataLayer();
            if ("productClick".endsWith(str)) {
                dataLayer.push(map == null ? new HashMap<>() : map);
            } else {
                dataLayer.pushEvent(str, map == null ? new HashMap<>() : map);
            }
            GoogleAnalytics.getInstance(applicationContext).getLogger().setLogLevel(0);
            HashMap hashMap = new HashMap();
            hashMap.put(str, "");
            if (map != null) {
                for (Map.Entry<String, Object> key : map.entrySet()) {
                    hashMap.put(key.getKey(), "");
                }
            }
            dataLayer.push(hashMap);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(String str, String str2, Context context) {
        Handler handler = f15627b;
        if (handler != null) {
            handler.post(new Runnable(context, str, str2) {
                private final /* synthetic */ Context f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    b.b(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, String str, String str2) {
        try {
            DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
            Map mapOf = DataLayer.mapOf(new Object[]{AppConstants.NOTIFICATION_DETAILS.EVENT, str, SDKConstants.EVENT_KEY_SCREEN_NAME, str2});
            dataLayer.push(mapOf);
            t.e().sendEventToPaytmAnalytics(mapOf, "screen_name", false, true, true);
            dataLayer.push(DataLayer.mapOf(new Object[]{SDKConstants.EVENT_KEY_SCREEN_NAME, ""}));
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Handler handler = f15627b;
        if (handler != null) {
            handler.post(new Runnable(str, str2, str3, str4, context, str5, str6) {
                private final /* synthetic */ String f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ String f$3;
                private final /* synthetic */ Context f$4;
                private final /* synthetic */ String f$5;
                private final /* synthetic */ String f$6;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                }

                public final void run() {
                    b.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, String str3, String str4, Context context, String str5, String str6) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", a(str));
            hashMap.put("event_action", a(str2));
            hashMap.put("event_label", a(str3));
            if (TextUtils.isEmpty(str4)) {
                str4 = "0";
            }
            hashMap.put("event_value", str4);
            String a2 = a(context);
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(h.f15721b, a2);
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                hashMap.put("VERTICAL_NAME".toLowerCase(), str6);
            }
            b(GAUtil.CUSTOM_EVENT, hashMap);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String a(Context context) {
        return !TextUtils.isEmpty(l.a(context)) ? d.e() : "";
    }

    public static void b(String str, String str2, Context context) {
        Handler handler = f15627b;
        if (handler != null) {
            handler.post(new Runnable(context, str, str2) {
                private final /* synthetic */ Context f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    b.a(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str, String str2) {
        String str3;
        Context context2 = context;
        if (context2 != null) {
            try {
                TagManager.getInstance(context).getDataLayer();
                HashMap hashMap = new HashMap();
                hashMap.put(AppConstants.NOTIFICATION_DETAILS.EVENT, "openScreen");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
                hashMap.put("vertical_name", str2);
                hashMap.put("Device_Brand", c.c());
                hashMap.put("Device_Name", c.d());
                String b2 = u.a(context.getApplicationContext()).b("ADVERTISING_ID", "", false);
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("Advertising_ID", b2);
                }
                if (context2 != null) {
                    context2.getSystemService(ContactColumn.PHONE_NUMBER);
                    str3 = c.b(context);
                } else {
                    str3 = null;
                }
                if (str3 != null) {
                    hashMap.put("IMEI", Base64.encodeToString(str3.getBytes(), 0));
                }
                String b3 = b(context);
                if (b3 != null) {
                    hashMap.put("Custom_Device_ID", Base64.encodeToString(b3.getBytes(), 0));
                }
                if (!TextUtils.isEmpty(l.a(context))) {
                    if (!TextUtils.isEmpty(c.j(context))) {
                        hashMap.put("Customer_Id", c.j(context));
                    }
                    String k = c.k(context);
                    if (!TextUtils.isEmpty(k)) {
                        hashMap.put("Contact_Number", Base64.encodeToString(k.getBytes(), 0));
                    }
                    String i2 = c.i(context);
                    if (!TextUtils.isEmpty(i2)) {
                        hashMap.put("user_email", Base64.encodeToString(i2.getBytes(), 0));
                    }
                }
                c(hashMap);
                t.e().sendEventToPaytmAnalytics(hashMap, "openScreenDeviceInfo", false, true, true);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "");
                hashMap2.put("vertical_name", "");
                hashMap2.put("Device_Brand", "");
                hashMap2.put("Device_Name", "");
                hashMap2.put("Advertising_ID", "");
                hashMap2.put("IMEI", "");
                hashMap2.put("Custom_Device_ID", "");
                hashMap2.put("Customer_Id", "");
                hashMap2.put("Contact_Number", "");
                hashMap2.put("user_email", "");
                hashMap2.put("Channel_ID", "");
                hashMap2.put("ecommerce", "");
                c(hashMap2);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return android.provider.Settings.System.getString(r2.getContentResolver(), net.one97.paytm.upi.util.UpiContract.DeviceInfoColumns.ANDROID_ID);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(android.content.Context r2) {
        /*
            java.lang.String r0 = "android_id"
            android.content.ContentResolver r1 = r2.getContentResolver()     // Catch:{ Exception -> 0x000b }
            java.lang.String r2 = android.provider.Settings.System.getString(r1, r0)     // Catch:{ Exception -> 0x000b }
            goto L_0x0015
        L_0x000b:
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r2 = android.provider.Settings.System.getString(r2, r0)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.common.a.b.b(android.content.Context):java.lang.String");
    }

    public static void a(String str, String str2, String str3, String str4, Context context) {
        Handler handler = f15627b;
        if (handler != null) {
            handler.post(new Runnable(context, str, str2, str3, str4) {
                private final /* synthetic */ Context f$0;
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ String f$3;
                private final /* synthetic */ String f$4;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    b.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str, String str2, String str3, String str4) {
        try {
            DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
            dataLayer.push(DataLayer.mapOf(new Object[]{AppConstants.NOTIFICATION_DETAILS.EVENT, str, SDKConstants.EVENT_KEY_SCREEN_NAME, str2, str3, str4}));
            dataLayer.push(DataLayer.mapOf(new Object[]{SDKConstants.EVENT_KEY_SCREEN_NAME, "", str3, ""}));
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static void a(final String str, final Map<String, Object> map, final Context context) {
        Handler handler = f15627b;
        if (handler != null) {
            handler.post(new Runnable() {
                public final void run() {
                    try {
                        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
                        if ("productClick".endsWith(str)) {
                            dataLayer.push(map == null ? new HashMap() : map);
                        } else {
                            dataLayer.pushEvent(str, map == null ? new HashMap() : map);
                        }
                        GoogleAnalytics.getInstance(context).getLogger().setLogLevel(0);
                        HashMap hashMap = new HashMap();
                        hashMap.put(str, "");
                        if (map != null) {
                            for (Map.Entry key : map.entrySet()) {
                                hashMap.put(key.getKey(), "");
                            }
                        }
                        dataLayer.push(hashMap);
                    } catch (Exception e2) {
                        String unused = b.f15626a;
                        q.c(e2.getMessage());
                    }
                }
            });
        }
    }

    public static void a(Map<String, Object> map, Context context) {
        t.e().getDeviceInfoDetails(map, context);
    }
}
