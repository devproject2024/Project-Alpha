package net.one97.paytm.paymentsBank.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.g;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.e;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRContingency;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    public static int a(Context context, float f2) {
        return (int) (f2 * context.getResources().getDisplayMetrics().density);
    }

    public static boolean a(Activity activity, Exception exc, String str, Bundle bundle) {
        if (exc instanceof e) {
            exc = ((e) exc).getNetworkCustomError();
        }
        if (activity == null || activity.isFinishing() || !(exc instanceof NetworkCustomError)) {
            return false;
        }
        NetworkCustomError networkCustomError = (NetworkCustomError) exc;
        if ((networkCustomError.getMessage() != null && (networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401) || networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase("403"))) || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
            a(activity, str, bundle, (Exception) networkCustomError);
            return true;
        }
        String fullUrl = networkCustomError.getFullUrl();
        if (!TextUtils.isEmpty(fullUrl)) {
            StringBuilder sb = new StringBuilder();
            d.b();
            sb.append(d.a("base_url_auth"));
            if (fullUrl.contains(sb.toString())) {
                a((Context) activity, (Exception) networkCustomError, "error.auth@paytm.com");
            } else {
                StringBuilder sb2 = new StringBuilder();
                d.b();
                sb2.append(d.a("base_url_kyc"));
                if (!fullUrl.contains(sb2.toString())) {
                    StringBuilder sb3 = new StringBuilder();
                    d.b();
                    sb3.append(d.a("base_url_golden_gate"));
                    if (!fullUrl.contains(sb3.toString())) {
                        StringBuilder sb4 = new StringBuilder();
                        d.b();
                        sb4.append(d.a("base_url_wallet"));
                        if (fullUrl.contains(sb4.toString())) {
                            a((Context) activity, (Exception) networkCustomError, "error.wallet@paytm.com");
                        } else {
                            b.b((Context) activity, activity.getString(R.string.error), activity.getString(R.string.some_went_wrong));
                        }
                    }
                }
                a((Context) activity, (Exception) networkCustomError, "error.kyc@paytm.com");
            }
        } else {
            b.b((Context) activity, activity.getString(R.string.error), activity.getString(R.string.some_went_wrong));
        }
        return false;
    }

    private static boolean a(Context context, Exception exc, String str) {
        String str2;
        if (exc instanceof NetworkCustomError) {
            NetworkCustomError networkCustomError = (NetworkCustomError) exc;
            String message = networkCustomError.getMessage();
            if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("failure_error")) {
                String valueOf = String.valueOf(networkCustomError.getStatusCode());
                String str3 = null;
                if (TextUtils.isEmpty(valueOf) || (!valueOf.equalsIgnoreCase("499") && !valueOf.equalsIgnoreCase("502") && !valueOf.equalsIgnoreCase("503") && !valueOf.equalsIgnoreCase("504"))) {
                    str2 = null;
                } else {
                    str3 = networkCustomError.getAlertMessage();
                    str2 = networkCustomError.getAlertTitle();
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    if (!TextUtils.isEmpty(valueOf) && valueOf.equalsIgnoreCase("499")) {
                        str3 = context.getResources().getString(R.string.message_499);
                        str2 = context.getResources().getString(R.string.title_499);
                    } else if (!TextUtils.isEmpty(valueOf) && valueOf.equalsIgnoreCase("502")) {
                        str3 = context.getResources().getString(R.string.message_502);
                        str2 = context.getResources().getString(R.string.title_502);
                    } else if (!TextUtils.isEmpty(valueOf) && valueOf.equalsIgnoreCase("503")) {
                        str3 = context.getResources().getString(R.string.message_503);
                        str2 = context.getResources().getString(R.string.title_503);
                    } else if (!TextUtils.isEmpty(valueOf) && valueOf.equalsIgnoreCase("504")) {
                        str3 = context.getResources().getString(R.string.message_504);
                        str2 = context.getResources().getString(R.string.title_504);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    if (TextUtils.isEmpty(valueOf) || !valueOf.equalsIgnoreCase("503")) {
                        b(context, networkCustomError, str);
                        return true;
                    }
                    a(context, str3, str2);
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

    private static void a(Activity activity, String str, Bundle bundle, Exception exc) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && (exc instanceof NetworkCustomError)) {
            o.a().handleSessionTimeOut(activity, str, bundle, exc, true, false);
        }
    }

    private static void b(Context context, Exception exc, String str) {
        if (context != null && exc != null) {
            NetworkCustomError networkCustomError = (NetworkCustomError) exc;
            String string = context.getString(R.string.error_dialog_title);
            String string2 = context.getString(R.string.error_dialog_message);
            String q = a.q(context);
            if (!TextUtils.isEmpty(q)) {
                String concat = "/".concat(String.valueOf(q));
                if (string2.contains(concat)) {
                    string2 = string2.replace(concat, "");
                }
            }
            String b2 = com.paytm.utility.d.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat2 = "/".concat(String.valueOf(b2));
                if (string2.contains(concat2)) {
                    string2 = string2.replace(concat2, "");
                }
            }
            g.a(context, string, string2, (g.c) new g.c(context, str) {
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onDialogDismissed() {
                    b.a(NetworkCustomError.this.getUrl(), NetworkCustomError.this.getMessage(), this.f$1, this.f$2);
                }
            });
        }
    }

    private static void a(final Context context, final String str, final String str2) {
        if (context != null) {
            d.b();
            String a2 = d.a("leadAPIOnAppLaunch");
            if (a2 != null) {
                String s = b.s(context, a2);
                String b2 = com.paytm.utility.d.b(context);
                if (!TextUtils.isEmpty(b2)) {
                    s = s + "&cart_id=" + b2;
                }
                HashMap<String, String> a3 = b.a((HashMap<String, String>) new HashMap(), context);
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", "PBUtils");
                net.one97.paytm.bankCommon.g.a aVar = new net.one97.paytm.bankCommon.g.a(s, (g.b) new g.b<IJRPaytmDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        PBCJRContingency pBCJRContingency;
                        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                        if ((iJRPaytmDataModel instanceof PBCJRContingency) && (pBCJRContingency = (PBCJRContingency) iJRPaytmDataModel) != null) {
                            if (pBCJRContingency.getStatus()) {
                                Intent intent = new Intent(context, o.a().getEmbeddedWebViewActivityClass());
                                intent.putExtra("url", pBCJRContingency.getUrl());
                                intent.putExtra("title", pBCJRContingency.getMessage());
                                intent.putExtra(UpiConstants.FROM, "Contingency");
                                intent.putExtra("Maintenance", false);
                                intent.putExtra("maintaince_error_503", true);
                                intent.putExtra("Close", pBCJRContingency.getClose());
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
                }, (g.a) new g.a() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("503")) {
                            String string = context.getResources().getString(R.string.contingency_503_message);
                            b.b(context, context.getResources().getString(R.string.contingency_503_title), string);
                        }
                    }
                }, (IJRPaytmDataModel) new PBCJRContingency(), (Map<String, String>) null, (Map<String, String>) a3, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
                context.getApplicationContext();
                new c();
                c.a(aVar);
                return;
            }
            b.b(context, str2, str);
        }
    }

    public static <T> T a(Object obj, Class<T> cls) {
        f fVar = new f();
        return fVar.a(fVar.a(obj), cls);
    }

    public static String a(String str, String str2) {
        return new SimpleDateFormat(str2).format(new Date(Long.parseLong(str)));
    }

    public static boolean a(Context context, NetworkCustomError networkCustomError) {
        int i2;
        NetworkResponse networkResponse = networkCustomError.networkResponse;
        String str = "";
        if (networkResponse != null) {
            i2 = networkResponse.statusCode;
            String str2 = networkResponse.headers.get("Content-Encoding");
            if (networkResponse.data != null) {
                if (str2 == null || !str2.equals("gzip")) {
                    str = new String(networkResponse.data);
                } else {
                    Reader a2 = com.paytm.network.b.g.a(networkResponse.data);
                    if (a2 != null) {
                        str = com.paytm.network.b.g.a(a2);
                    }
                }
            }
        } else {
            i2 = -1;
        }
        if (!(i2 == 410 || i2 == 401 || i2 == 403 || TextUtils.isEmpty(str))) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE)) {
                    String string = jSONObject.getString(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
                    if (!TextUtils.isEmpty(string)) {
                        if (context != null) {
                            b.b(context, context.getString(R.string.error), string);
                        }
                        return true;
                    }
                } else if (jSONObject.has("message")) {
                    String string2 = jSONObject.getString("message");
                    if (!TextUtils.isEmpty(string2)) {
                        if (context != null) {
                            b.b(context, context.getString(R.string.error), string2);
                        }
                        return true;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, NetworkCustomError networkCustomError, int i2) {
        if (i2 == -1) {
            if (context == null) {
                return true;
            }
            b.b(context, context.getString(R.string.network_error_heading), context.getString(R.string.pb_check_your_network));
            return true;
        } else if (!a(context, networkCustomError)) {
            return a((Activity) context, (Exception) networkCustomError, (String) null, (Bundle) null);
        } else {
            return false;
        }
    }

    public static String a(String str, boolean... zArr) {
        String str2;
        if (!(zArr.length > 0 ? zArr[0] : a().equals("ICA")) || TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("?")) {
            str2 = str + "&accType=ICA";
        } else {
            str2 = str + "?accType=ICA";
        }
        if (o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API)) {
            return str2.replace("product-ite.paytmbank.com", "veneer-ite.paytmbank.com");
        }
        return str2.replace("product.paytmbank.com", "veneer.paytmbank.com");
    }

    public static String a() {
        String b2 = net.one97.paytm.bankCommon.h.b.b(o.a().getApplicationContext());
        return TextUtils.isEmpty(b2) ? "ISA" : b2;
    }

    public static boolean b() {
        return "ISA".equalsIgnoreCase(a());
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 23 && androidx.biometric.b.a(o.a().getApplicationContext()).a() == 0 && n.w();
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 23 && androidx.biometric.b.a(o.a().getApplicationContext()).a() != 12 && n.w();
    }
}
