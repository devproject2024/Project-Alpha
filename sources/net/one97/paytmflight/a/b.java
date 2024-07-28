package net.one97.paytmflight.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.d;
import com.paytm.utility.g;
import com.paytm.utility.k;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.flight.R;
import com.travel.flight.activity.FlightWebViewActivity;
import java.util.HashMap;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytmflight.common.entity.CJRFlightContingency;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f29994a = "CJRPaytmCommonUtility";

    public static void a(final Activity activity, Exception exc) {
        if (activity != null && !activity.isFinishing() && exc != null && (exc instanceof NetworkCustomError)) {
            final NetworkCustomError networkCustomError = (NetworkCustomError) exc;
            if ((networkCustomError.getMessage() == null || (!networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401) && !networkCustomError.getMessage().equalsIgnoreCase("410"))) && networkCustomError.getStatusCode() != 410 && networkCustomError.getStatusCode() != 401 && networkCustomError.getStatusCode() != 403) {
                String fullUrl = networkCustomError.getFullUrl();
                if (!TextUtils.isEmpty(fullUrl)) {
                    StringBuilder sb = new StringBuilder();
                    com.travel.flight.b.a();
                    sb.append(com.travel.flight.b.b().m());
                    if (fullUrl.contains(sb.toString())) {
                        a((Context) activity, (Exception) networkCustomError, "error.auth@paytm.com");
                    }
                }
            } else if (activity != null && !activity.isFinishing() && (networkCustomError instanceof NetworkCustomError)) {
                String str = null;
                String string = TextUtils.isEmpty((CharSequence) null) ? activity.getResources().getString(R.string.message_401_410) : null;
                if (TextUtils.isEmpty((CharSequence) null)) {
                    str = activity.getResources().getString(R.string.title_401_410);
                }
                String q = a.q(activity);
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
                        string = string.replace(concat2, "");
                    }
                }
                g.b(activity, str, string, new g.c() {

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ String f29996b = null;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ Bundle f29997c = null;

                    /* renamed from: e  reason: collision with root package name */
                    final /* synthetic */ boolean f29999e;

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ boolean f30000f;

                    {
                        this.f29999e = true;
                        this.f30000f = false;
                    }

                    public final void onDialogDismissed() {
                        try {
                            com.travel.flight.b.a();
                            com.travel.flight.b.b().a(activity, this.f29996b, this.f29997c, networkCustomError, this.f29999e, this.f30000f);
                        } catch (Exception unused) {
                        }
                        Intent intent = new Intent(activity, FlightWebViewActivity.class);
                        if (k.b()) {
                            intent.setFlags(32768);
                        }
                        intent.putExtra("authError", true);
                        String str = this.f29996b;
                        if (str != null) {
                            intent.putExtra("resultant activity", str);
                            intent.putExtra("sign_in_sign_up_with_step_2", true);
                            Bundle bundle = this.f29997c;
                            if (bundle != null) {
                                intent.putExtra("resultant activity_bundle", bundle);
                            }
                        }
                        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                        if (this.f30000f) {
                            activity.startActivityForResult(intent, 3);
                            return;
                        }
                        activity.startActivity(intent);
                        if (this.f29999e) {
                            activity.finish();
                        }
                    }
                });
            }
        }
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
                        a(context, str3, str2);
                        return true;
                    }
                    b(context, networkCustomError, str);
                    return true;
                }
            } else if (networkCustomError == null || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                return false;
            } else {
                com.paytm.utility.b.b(context, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                return true;
            }
        }
        return false;
    }

    private static void a(final Context context, final String str, final String str2) {
        if (context != null) {
            com.travel.flight.b.a();
            String l = com.travel.flight.b.b().l();
            if (l != null) {
                String s = com.paytm.utility.b.s(context, l);
                String b2 = d.b(context);
                if (!TextUtils.isEmpty(b2)) {
                    s = s + "&cart_id=" + b2;
                }
                HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), context);
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = context;
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = s;
                bVar.f42881e = null;
                bVar.f42882f = a2;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRFlightContingency();
                bVar.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        CJRFlightContingency cJRFlightContingency;
                        if ((iJRPaytmDataModel instanceof CJRFlightContingency) && (cJRFlightContingency = (CJRFlightContingency) iJRPaytmDataModel) != null) {
                            if (cJRFlightContingency.getStatus()) {
                                Intent intent = new Intent(context, FlightWebViewActivity.class);
                                intent.putExtra("url", cJRFlightContingency.getUrl());
                                intent.putExtra("title", cJRFlightContingency.getMessage());
                                intent.putExtra(UpiConstants.FROM, "Contingency");
                                intent.putExtra("Maintenance", false);
                                intent.putExtra("maintaince_error_503", true);
                                intent.putExtra("Close", cJRFlightContingency.getClose());
                                intent.putExtra("alert_title", str2);
                                intent.putExtra("alert_message", str);
                                intent.addFlags(67108864);
                                intent.addFlags(268435456);
                                context.startActivity(intent);
                                ((Activity) context).finish();
                                return;
                            }
                            com.paytm.utility.b.b(context, str2, str);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("503")) {
                            String string = context.getResources().getString(R.string.contingency_503_message);
                            com.paytm.utility.b.b(context, context.getResources().getString(R.string.contingency_503_title), string);
                        }
                    }
                };
                bVar.t = null;
                bVar.l().a();
                return;
            }
            com.paytm.utility.b.b(context, str2, str);
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
                    com.paytm.utility.b.a(networkCustomError.getUrl(), networkCustomError.getMessage(), context, str);
                }
            });
        }
    }
}
