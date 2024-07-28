package net.one97.paytm.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.google.firebase.crashlytics.c;
import com.paytm.network.a;
import com.paytm.network.b.f;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.R;
import com.paytm.utility.b;
import com.paytm.utility.d;
import com.paytm.utility.g;
import com.paytm.utility.k;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.CJRContingency;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.h.a;
import net.one97.paytm.h.e;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static String f69780a = "CJRPaytmCommonUtility";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static a f69781b;

    public static CJRError a(Context context, String str) {
        if (context == null) {
            return null;
        }
        String string = context.getResources().getString(R.string.message_error_data_display);
        if (!TextUtils.isEmpty(str)) {
            string = string + "(" + str + ")";
        }
        String string2 = context.getResources().getString(R.string.error_data_display);
        CJRError cJRError = new CJRError();
        cJRError.setTitle(string2);
        cJRError.setMessage(string);
        return cJRError;
    }

    public static boolean a(CJRRechargeCart cJRRechargeCart, Context context) {
        String string = context.getResources().getString(R.string.unable_to_proceed);
        Iterator<CJRCartProduct> it2 = cJRRechargeCart.getCart().getCartItems().iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            if (next.getError() != null) {
                String errorCode = next.getErrorCode();
                if (TextUtils.isEmpty(errorCode) || (!"CT_CP_4001".equalsIgnoreCase(errorCode) && !"CT_CP_4010".equalsIgnoreCase(errorCode))) {
                    String errorTitle = next.getErrorTitle();
                    if (errorTitle == null || errorTitle.trim().length() <= 0) {
                        b.b(context, string, next.getError());
                    } else {
                        b.b(context, errorTitle, next.getError());
                    }
                    return true;
                }
                b.b(context, context.getResources().getString(R.string.title_msg_for_deals), context.getResources().getString(R.string.error_msg_for_deals));
                return true;
            }
        }
        if (cJRRechargeCart.getCart().getError() == null) {
            return false;
        }
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            b.b(context, context.getResources().getString(R.string.network_error_heading), context.getResources().getString(R.string.network_error_message));
        } else {
            String errorTitle2 = cJRRechargeCart.getCart().getErrorTitle();
            if (errorTitle2 != null && errorTitle2.trim().length() > 0) {
                string = errorTitle2;
            }
            b.b(context, string, cJRRechargeCart.getCart().getError());
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d1 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00df A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e6 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ed A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f4 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0100 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0107 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010e A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0115 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011d A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0126 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012f A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0136 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0154 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0170 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0178 A[Catch:{ Exception -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017e A[Catch:{ Exception -> 0x0197 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r24, java.lang.String r25, java.lang.String r26, net.one97.paytm.common.entity.CJRSelectCityModel r27) {
        /*
            r1 = r25
            r2 = r26
            java.lang.String r3 = ""
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            if (r27 == 0) goto L_0x0043
            java.lang.String r0 = r27.getLatitude()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = r27.getLongitude()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = r27.getLatitude()
            java.lang.String r10 = r27.getLongitude()
            goto L_0x004b
        L_0x0043:
            java.lang.String r0 = com.paytm.utility.b.s((android.content.Context) r24)
            java.lang.String r10 = com.paytm.utility.b.t((android.content.Context) r24)
        L_0x004b:
            r11 = r10
            r10 = r0
            java.lang.String r12 = android.os.Build.MANUFACTURER
            java.lang.String r13 = android.os.Build.MODEL
            java.lang.String r14 = android.os.Build.VERSION.RELEASE
            java.lang.String r15 = com.paytm.utility.b.b((android.content.Context) r24)
            r16 = r8
            java.lang.String r8 = android.os.Build.DEVICE
            java.lang.String r0 = "http.agent"
            java.lang.String r2 = java.lang.System.getProperty(r0)
            r17 = r9
            java.lang.String r9 = com.paytm.utility.b.u((android.content.Context) r24)
            java.lang.String r1 = com.paytm.utility.b.V((android.content.Context) r24)
            android.content.ContentResolver r0 = r24.getContentResolver()
            r18 = r5
            java.lang.String r5 = "android_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r0, r5)
            r27 = r5
            java.lang.String r5 = com.paytm.utility.b.o()
            r19 = 0
            android.content.pm.PackageManager r0 = r24.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0097 }
            r20 = r9
            java.lang.String r9 = r24.getPackageName()     // Catch:{ NameNotFoundException -> 0x0095 }
            r21 = r15
            r15 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r9, r15)     // Catch:{ NameNotFoundException -> 0x0093 }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x0093 }
            goto L_0x00a9
        L_0x0093:
            r0 = move-exception
            goto L_0x009c
        L_0x0095:
            r0 = move-exception
            goto L_0x009a
        L_0x0097:
            r0 = move-exception
            r20 = r9
        L_0x009a:
            r21 = r15
        L_0x009c:
            boolean r9 = com.paytm.utility.b.v
            if (r9 == 0) goto L_0x00a7
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x00a7:
            r0 = r19
        L_0x00a9:
            r22 = 0
            boolean r9 = com.paytm.utility.b.r((android.content.Context) r24)
            if (r9 == 0) goto L_0x00c5
            java.lang.String r9 = com.paytm.utility.b.n((android.content.Context) r24)
            boolean r15 = android.text.TextUtils.isEmpty(r9)
            if (r15 != 0) goto L_0x00c5
            boolean r15 = android.text.TextUtils.isDigitsOnly(r9)
            if (r15 == 0) goto L_0x00c5
            long r22 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x00c5 }
        L_0x00c5:
            r19 = r0
            r15 = r8
            r8 = r22
            java.lang.String r0 = "user_id"
            r4.put(r0, r8)     // Catch:{ Exception -> 0x0197 }
            if (r1 == 0) goto L_0x00d6
            java.lang.String r0 = "ga_id"
            r4.put(r0, r1)     // Catch:{ Exception -> 0x0197 }
        L_0x00d6:
            java.lang.String r0 = "experiment_id"
            java.lang.String r8 = com.paytm.utility.e.s     // Catch:{ Exception -> 0x0197 }
            r4.put(r0, r8)     // Catch:{ Exception -> 0x0197 }
            if (r10 == 0) goto L_0x00e4
            java.lang.String r0 = "lat"
            r6.put(r0, r10)     // Catch:{ Exception -> 0x0197 }
        L_0x00e4:
            if (r11 == 0) goto L_0x00eb
            java.lang.String r0 = "long"
            r6.put(r0, r11)     // Catch:{ Exception -> 0x0197 }
        L_0x00eb:
            if (r2 == 0) goto L_0x00f2
            java.lang.String r0 = "ua"
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
        L_0x00f2:
            if (r5 == 0) goto L_0x00f9
            java.lang.String r0 = "ip"
            r7.put(r0, r5)     // Catch:{ Exception -> 0x0197 }
        L_0x00f9:
            java.lang.String r0 = "ip_v6"
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0197 }
            if (r12 == 0) goto L_0x0105
            java.lang.String r0 = "make"
            r7.put(r0, r12)     // Catch:{ Exception -> 0x0197 }
        L_0x0105:
            if (r13 == 0) goto L_0x010c
            java.lang.String r0 = "model_1"
            r7.put(r0, r13)     // Catch:{ Exception -> 0x0197 }
        L_0x010c:
            if (r14 == 0) goto L_0x0113
            java.lang.String r0 = "osv"
            r7.put(r0, r14)     // Catch:{ Exception -> 0x0197 }
        L_0x0113:
            if (r15 == 0) goto L_0x011b
            java.lang.String r0 = "hwv"
            r2 = r15
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
        L_0x011b:
            if (r21 == 0) goto L_0x0124
            java.lang.String r0 = "connection_type"
            r2 = r21
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
        L_0x0124:
            if (r20 == 0) goto L_0x012d
            java.lang.String r0 = "carrier"
            r2 = r20
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
        L_0x012d:
            if (r1 == 0) goto L_0x0134
            java.lang.String r0 = "aaid"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0197 }
        L_0x0134:
            if (r27 == 0) goto L_0x013d
            java.lang.String r0 = "browser_uuid"
            r1 = r27
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0197 }
        L_0x013d:
            java.lang.String r0 = "device_type"
            java.lang.String r1 = "PHONE"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r0 = "os"
            java.lang.String r1 = "Android"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r0 = "user"
            r1 = r18
            r1.put(r0, r4)     // Catch:{ Exception -> 0x0197 }
            if (r19 == 0) goto L_0x015b
            java.lang.String r0 = "version"
            r2 = r19
            r1.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
        L_0x015b:
            java.lang.String r0 = "geo"
            r1.put(r0, r6)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r0 = "device"
            r1.put(r0, r7)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r0 = "channel"
            java.lang.String r2 = "APP"
            r1.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
            r2 = r25
            if (r2 == 0) goto L_0x0178
            java.lang.String r0 = "prev_page"
            r4 = r17
            r4.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
            goto L_0x017a
        L_0x0178:
            r4 = r17
        L_0x017a:
            r2 = r26
            if (r2 == 0) goto L_0x0183
            java.lang.String r0 = "current_page"
            r4.put(r0, r2)     // Catch:{ Exception -> 0x0197 }
        L_0x0183:
            java.lang.String r0 = "referer_ui_element"
            r4.put(r0, r3)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r0 = "context"
            r2 = r16
            r2.put(r0, r1)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r0 = "tracking"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0195 }
            goto L_0x01a1
        L_0x0195:
            r0 = move-exception
            goto L_0x019a
        L_0x0197:
            r0 = move-exception
            r2 = r16
        L_0x019a:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x01a1:
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.r.a(android.content.Context, java.lang.String, java.lang.String, net.one97.paytm.common.entity.CJRSelectCityModel):java.lang.String");
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, (CJRSelectCityModel) null);
    }

    public static String a(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        return (cJRHomePageLayoutV2 == null || cJRHomePageLayoutV2.getDatasources() == null || cJRHomePageLayoutV2.getDatasources().size() <= 0) ? "" : cJRHomePageLayoutV2.getDatasources().get(0).getmContainerInstanceID();
    }

    public static void a(Activity activity, Exception exc, String str, Bundle bundle) {
        if (activity != null && !activity.isFinishing() && exc != null && (exc instanceof NetworkCustomError)) {
            NetworkCustomError networkCustomError = (NetworkCustomError) exc;
            if ((networkCustomError.getMessage() != null && (networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401) || networkCustomError.getMessage().equalsIgnoreCase("410"))) || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                a(activity, str, bundle, true);
                return;
            }
            String fullUrl = networkCustomError.getFullUrl();
            if (!TextUtils.isEmpty(fullUrl)) {
                if (fullUrl.contains(e.a())) {
                    a((Context) activity, (Exception) networkCustomError, "error.auth@paytm.com");
                    return;
                }
                if (!fullUrl.contains(e.b())) {
                    if (!fullUrl.contains(e.c())) {
                        if (fullUrl.contains(e.d())) {
                            a((Context) activity, (Exception) networkCustomError, "error.wallet@paytm.com");
                            return;
                        }
                        return;
                    }
                }
                a((Context) activity, (Exception) networkCustomError, "error.kyc@paytm.com");
            }
        }
    }

    public static void a(Activity activity, String str, Bundle bundle, boolean z) {
        a(activity, str, bundle, z, false);
    }

    public static void a(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        if (activity != null && !activity.isFinishing()) {
            String string = TextUtils.isEmpty((CharSequence) null) ? activity.getResources().getString(R.string.message_401_410) : null;
            if (TextUtils.isEmpty((CharSequence) null)) {
                activity.getResources().getString(R.string.title_401_410);
            }
            String q = com.paytm.utility.a.q(activity);
            if (!TextUtils.isEmpty(q)) {
                String concat = "/".concat(String.valueOf(q));
                if (!TextUtils.isEmpty(string) && string.contains(concat)) {
                    string = string.replace(concat, "");
                }
            }
            String b2 = d.b(activity);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (!TextUtils.isEmpty(string) && string.contains(concat2)) {
                    string.replace(concat2, "");
                }
            }
            String q2 = com.paytm.utility.a.q(activity);
            as.a().a(activity);
            f69781b = net.one97.paytm.h.d.b();
            Intent intent = new Intent(activity, f69781b.a().get(a.C0908a.AuthActivity));
            if (k.b()) {
                intent.setFlags(32768);
            }
            intent.putExtra("authError", true);
            intent.putExtra("prev_token", q2);
            intent.putExtra("finish_current", z);
            if (str != null) {
                intent.putExtra("resultant activity", str);
                intent.putExtra("sign_in_sign_up_with_step_2", true);
            }
            if (bundle != null) {
                intent.putExtra("resultant activity_bundle", bundle);
            }
            intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
            if (z2) {
                activity.startActivityForResult(intent, 3);
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public static void a(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2, int i2) {
        if (activity != null && !activity.isFinishing() && (exc instanceof NetworkCustomError)) {
            String string = TextUtils.isEmpty((CharSequence) null) ? activity.getResources().getString(R.string.message_401_410) : null;
            if (TextUtils.isEmpty((CharSequence) null)) {
                activity.getResources().getString(R.string.title_401_410);
            }
            String q = com.paytm.utility.a.q(activity);
            if (!TextUtils.isEmpty(q)) {
                String concat = "/".concat(String.valueOf(q));
                if (!TextUtils.isEmpty(string) && string.contains(concat)) {
                    string = string.replace(concat, "");
                }
            }
            String b2 = d.b(activity);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (!TextUtils.isEmpty(string) && string.contains(concat2)) {
                    string.replace(concat2, "");
                }
            }
            String q2 = com.paytm.utility.a.q(activity);
            as.a().a(activity);
            f69781b = net.one97.paytm.h.d.b();
            Intent intent = new Intent(activity, f69781b.a().get(a.C0908a.AuthActivity));
            if (k.b()) {
                intent.setFlags(32768);
            }
            intent.putExtra("authError", true);
            intent.putExtra("prev_token", q2);
            intent.putExtra("finish_current", z);
            if (str != null) {
                intent.putExtra("resultant activity", str);
                intent.putExtra("sign_in_sign_up_with_step_2", true);
            }
            if (bundle != null) {
                intent.putExtra("resultant activity_bundle", bundle);
            }
            intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
            if (z2) {
                activity.startActivityForResult(intent, i2);
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public static void a(Activity activity, Fragment fragment, String str, Bundle bundle, Exception exc, boolean z, boolean z2) {
        if (activity != null && !activity.isFinishing() && (exc instanceof NetworkCustomError)) {
            String string = TextUtils.isEmpty((CharSequence) null) ? activity.getResources().getString(R.string.message_401_410) : null;
            if (TextUtils.isEmpty((CharSequence) null)) {
                activity.getResources().getString(R.string.title_401_410);
            }
            String q = com.paytm.utility.a.q(activity);
            if (!TextUtils.isEmpty(q)) {
                String concat = "/".concat(String.valueOf(q));
                if (!TextUtils.isEmpty(string) && string.contains(concat)) {
                    string = string.replace(concat, "");
                }
            }
            String b2 = d.b(activity);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (!TextUtils.isEmpty(string) && string.contains(concat2)) {
                    string.replace(concat2, "");
                }
            }
            String q2 = com.paytm.utility.a.q(activity);
            as.a().a(activity);
            f69781b = net.one97.paytm.h.d.b();
            Intent intent = new Intent(activity, f69781b.a().get(a.C0908a.AuthActivity));
            if (k.b()) {
                intent.setFlags(32768);
            }
            intent.putExtra("authError", true);
            intent.putExtra("prev_token", q2);
            intent.putExtra("finish_current", z);
            if (str != null) {
                intent.putExtra("resultant activity", str);
                intent.putExtra("sign_in_sign_up_with_step_2", true);
            }
            if (bundle != null) {
                intent.putExtra("resultant activity_bundle", bundle);
            }
            intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
            if (z2) {
                fragment.startActivityForResult(intent, 3);
            } else {
                fragment.startActivity(intent);
            }
        }
    }

    public static void a(Activity activity, Fragment fragment, String str, Bundle bundle, Exception exc, boolean z, boolean z2, int i2) {
        if (activity != null && !activity.isFinishing() && (exc instanceof NetworkCustomError)) {
            String string = TextUtils.isEmpty((CharSequence) null) ? activity.getResources().getString(R.string.message_401_410) : null;
            if (TextUtils.isEmpty((CharSequence) null)) {
                activity.getResources().getString(R.string.title_401_410);
            }
            String q = com.paytm.utility.a.q(activity);
            if (!TextUtils.isEmpty(q)) {
                String concat = "/".concat(String.valueOf(q));
                if (!TextUtils.isEmpty(string) && string.contains(concat)) {
                    string = string.replace(concat, "");
                }
            }
            String b2 = d.b(activity);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (!TextUtils.isEmpty(string) && string.contains(concat2)) {
                    string.replace(concat2, "");
                }
            }
            String q2 = com.paytm.utility.a.q(activity);
            as.a().a(activity);
            f69781b = net.one97.paytm.h.d.b();
            Intent intent = new Intent(activity, f69781b.a().get(a.C0908a.AuthActivity));
            if (k.b()) {
                intent.setFlags(32768);
            }
            intent.putExtra("authError", true);
            intent.putExtra("prev_token", q2);
            intent.putExtra("finish_current", z);
            if (str != null) {
                intent.putExtra("resultant activity", str);
                intent.putExtra("sign_in_sign_up_with_step_2", true);
            }
            if (bundle != null) {
                intent.putExtra("resultant activity_bundle", bundle);
            }
            intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
            if (z2) {
                fragment.startActivityForResult(intent, i2);
            } else {
                fragment.startActivity(intent);
            }
        }
    }

    public static void a(Activity activity, String str, Bundle bundle) {
        a(activity, str, bundle, true);
    }

    public static boolean a(Context context, Exception exc, String str) {
        String str2;
        if (exc instanceof NetworkCustomError) {
            NetworkCustomError networkCustomError = (NetworkCustomError) exc;
            String message = networkCustomError.getMessage();
            if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("failure_error")) {
                String str3 = null;
                if ((!TextUtils.isEmpty(String.valueOf(networkCustomError.getStatusCode())) && networkCustomError.getStatusCode() == 499) || networkCustomError.getStatusCode() == 502 || networkCustomError.getStatusCode() == 503 || networkCustomError.getStatusCode() == 504) {
                    str3 = networkCustomError.getAlertMessage();
                    str2 = networkCustomError.getAlertTitle();
                } else {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    if (networkCustomError.getStatusCode() == 499) {
                        str3 = context.getResources().getString(R.string.message_499);
                        str2 = context.getResources().getString(R.string.title_499);
                    } else if (networkCustomError.getStatusCode() == 502) {
                        str3 = context.getResources().getString(R.string.message_502);
                        str2 = context.getResources().getString(R.string.title_502);
                    } else if (networkCustomError.getStatusCode() == 503) {
                        str3 = context.getResources().getString(R.string.message_503);
                        str2 = context.getResources().getString(R.string.title_503);
                    } else if (networkCustomError.getStatusCode() == 504) {
                        str3 = context.getResources().getString(R.string.message_504);
                        str2 = context.getResources().getString(R.string.title_504);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    if (networkCustomError.getStatusCode() == 503) {
                        b(context, str3, str2);
                        return true;
                    }
                    b(context, (Exception) networkCustomError, str);
                    return true;
                }
            } else if (networkCustomError == null || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                return false;
            } else {
                b.b(context, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, Exception exc) {
        String str;
        if (context == null || exc == null) {
            return true;
        }
        NetworkCustomError networkCustomError = (NetworkCustomError) exc;
        String message = networkCustomError.getMessage();
        if ("parsing_error".equalsIgnoreCase(message)) {
            return false;
        }
        String alertTitle = networkCustomError.getAlertTitle();
        String alertMessage = networkCustomError.getAlertMessage();
        if (TextUtils.isEmpty(alertTitle) || TextUtils.isEmpty(alertMessage)) {
            CJRError a2 = f.a(message, context);
            str = a2.getMessage() + "(" + networkCustomError.getUrl() + " | HTTP " + networkCustomError.getMessage() + ")";
            alertTitle = a2.getTitle();
        } else {
            str = alertMessage;
        }
        if (message == null || !message.equalsIgnoreCase("503")) {
            b.b(context, alertTitle, str);
            return true;
        }
        b(context, str, alertTitle);
        return true;
    }

    public static boolean a(Context context, NetworkCustomError networkCustomError) {
        String str;
        if (context == null || networkCustomError == null) {
            return true;
        }
        String valueOf = String.valueOf(networkCustomError.getStatusCode());
        if ("parsing_error".equalsIgnoreCase(valueOf)) {
            return false;
        }
        String alertTitle = networkCustomError.getAlertTitle();
        String alertMessage = networkCustomError.getAlertMessage();
        if (TextUtils.isEmpty(alertTitle) || TextUtils.isEmpty(alertMessage)) {
            CJRError a2 = f.a(valueOf, context);
            str = a2.getMessage() + "(" + networkCustomError.getUrl() + " | HTTP " + networkCustomError.getMessage() + ")";
            alertTitle = a2.getTitle();
        } else {
            str = alertMessage;
        }
        if (valueOf == null || !valueOf.equalsIgnoreCase("503")) {
            b.b(context, alertTitle, str);
            return true;
        }
        b(context, str, alertTitle);
        return true;
    }

    private static void b(final Context context, final String str, final String str2) {
        if (context != null) {
            String e2 = e.e();
            if (e2 != null) {
                String s = b.s(context, e2);
                String b2 = d.b(context);
                if (!TextUtils.isEmpty(b2)) {
                    s = s + "&cart_id=" + b2;
                }
                HashMap<String, String> a2 = b.a((HashMap<String, String>) new HashMap(), context);
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = context;
                bVar.f42878b = a.c.HOME;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = s;
                bVar.f42881e = null;
                bVar.f42882f = a2;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRContingency();
                bVar.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        CJRContingency cJRContingency;
                        if ((iJRPaytmDataModel instanceof CJRContingency) && (cJRContingency = (CJRContingency) iJRPaytmDataModel) != null) {
                            if (cJRContingency.getStatus()) {
                                net.one97.paytm.h.a unused = r.f69781b = net.one97.paytm.h.d.b();
                                Intent intent = new Intent(context, r.f69781b.a().get(a.C0908a.WebViewActivity));
                                intent.putExtra("url", cJRContingency.getUrl());
                                intent.putExtra("title", cJRContingency.getMessage());
                                intent.putExtra(UpiConstants.FROM, "Contingency");
                                intent.putExtra("Maintenance", false);
                                intent.putExtra("maintaince_error_503", true);
                                intent.putExtra("Close", cJRContingency.getClose());
                                intent.putExtra("alert_title", str2);
                                intent.putExtra("alert_message", str);
                                intent.addFlags(67108864);
                                intent.addFlags(268435456);
                                context.startActivity(intent);
                                ((Activity) context).finish();
                                return;
                            }
                            b.b(context, str2, str);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("503")) {
                            String string = context.getResources().getString(R.string.contingency_503_message);
                            b.b(context, context.getResources().getString(R.string.contingency_503_title), string);
                        }
                    }
                };
                bVar.t = null;
                bVar.l().a();
                return;
            }
            b.b(context, str2, str);
        }
    }

    private static void b(final Context context, Exception exc, final String str) {
        if (context != null && exc != null) {
            final NetworkCustomError networkCustomError = (NetworkCustomError) exc;
            String string = context.getString(R.string.error_dialog_title);
            String string2 = context.getString(R.string.error_dialog_message);
            String q = com.paytm.utility.a.q(context);
            if (!TextUtils.isEmpty(q)) {
                String concat = "/".concat(String.valueOf(q));
                if (string2.contains(concat)) {
                    string2 = string2.replace(concat, "");
                }
            }
            String b2 = d.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (string2.contains(concat2)) {
                    string2 = string2.replace(concat2, "");
                }
            }
            g.a(context, string, string2, (g.c) new g.c() {
                public final void onDialogDismissed() {
                    b.a(networkCustomError.getUrl(), networkCustomError.getMessage(), context, str);
                }
            });
        }
    }

    public static CJRError b(Context context, Exception exc) {
        NetworkCustomError networkCustomError = (NetworkCustomError) exc;
        String message = networkCustomError.getMessage();
        if ("parsing_error".equalsIgnoreCase(message)) {
            return null;
        }
        CJRError cJRError = new CJRError();
        cJRError.setTitle(networkCustomError.getAlertTitle());
        cJRError.setMessage(networkCustomError.getAlertMessage());
        if (TextUtils.isEmpty(cJRError.getTitle()) || TextUtils.isEmpty(cJRError.getMessage())) {
            cJRError = f.a(message, context);
            cJRError.setMessage(cJRError.getMessage() + "(" + networkCustomError.getUrl() + " | HTTP " + networkCustomError.getMessage() + ")");
        }
        if (!"503".equalsIgnoreCase(message)) {
            return cJRError;
        }
        b(context, cJRError.getMessage(), cJRError.getTitle());
        return null;
    }

    public static void a(String str, Context context) {
        String str2 = str + "-IN";
        e.f();
        new HashMap().put("session_token", com.paytm.utility.a.q(context));
        try {
            new JSONObject().put("language", str2);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
    }

    public static void a(com.paytm.network.a aVar, Context context) {
        a(aVar, context, (DialogInterface.OnCancelListener) null);
    }

    public static void a(final com.paytm.network.a aVar, final Context context, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (b.c(context)) {
                    com.paytm.network.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                r.a(aVar, context);
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    public static void a(String str, String str2) {
        try {
            c.a().a(str + " - " + str2);
        } catch (Exception e2) {
            q.b("Crashlytics not initialized " + e2.getMessage());
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (!k.b()) {
            a(str, str2);
            try {
                c.a().a(th);
            } catch (Exception e2) {
                q.b("Crashlytics not initialized " + e2.getMessage());
            }
        }
    }

    public static void b(String str, String str2) {
        try {
            l.b(str, str2);
        } catch (Exception e2) {
            q.b("Crashlytics not initialized " + e2.getMessage());
        }
    }

    public static String a(CJRHomePageItem cJRHomePageItem) {
        if (TextUtils.isEmpty(cJRHomePageItem.getGACategory())) {
            return cJRHomePageItem.getName();
        }
        return cJRHomePageItem.getGACategory() + "/" + cJRHomePageItem.getName();
    }
}
