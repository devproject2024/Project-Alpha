package net.one97.paytm.fastag.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.d;
import com.paytm.utility.g;
import com.paytm.utility.k;
import com.paytmmall.clpartifact.utils.GAUtil;
import net.one97.paytm.fastag.R;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f13775a = "Paytm Passbook";

    public static void a(final Activity activity, Throwable th, final String str) {
        NetworkCustomError networkCustomError;
        if (!activity.isFinishing() && (networkCustomError = (NetworkCustomError) th) != null) {
            if (networkCustomError.getAlertMessage() != null) {
                networkCustomError.printStackTrace();
            }
            if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 404) || networkCustomError.getStatusCode() == 400 || networkCustomError.getStatusCode() == 503) {
                try {
                    if (!activity.isFinishing()) {
                        if (networkCustomError.getStatusCode() == 404 || networkCustomError.getStatusCode() == 400 || networkCustomError.getStatusCode() == 503) {
                            h.a((Context) activity, activity.getResources().getString(R.string.title_400), activity.getResources().getString(R.string.message_400));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                if (!activity.isFinishing() && (networkCustomError instanceof NetworkCustomError)) {
                    String str2 = null;
                    String string = TextUtils.isEmpty((CharSequence) null) ? activity.getResources().getString(R.string.message_401_410) : null;
                    if (TextUtils.isEmpty((CharSequence) null)) {
                        str2 = activity.getResources().getString(R.string.title_401_410);
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
                    g.b(activity, str2, string, new g.c() {

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ Bundle f13778c = null;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ boolean f13779d = true;

                        /* renamed from: e  reason: collision with root package name */
                        final /* synthetic */ boolean f13780e = false;

                        public final void onDialogDismissed() {
                            net.one97.paytm.fastag.c.a.a().f13559b.signOut(activity, false);
                            Intent intent = new Intent(activity, net.one97.paytm.fastag.c.a.a().f13559b.getAuthActivityClassFromMap());
                            if (k.b()) {
                                intent.setFlags(32768);
                            }
                            intent.putExtra("authError", true);
                            if (str != null) {
                                intent.putExtra("sign_in_sign_up_with_step_2", true);
                                Bundle bundle = this.f13778c;
                                if (bundle != null) {
                                    intent.putExtra("resultant activity_bundle", bundle);
                                }
                            }
                            intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                            if (this.f13779d) {
                                activity.startActivityForResult(intent, 3);
                                return;
                            }
                            activity.startActivity(intent);
                            if (this.f13780e) {
                                activity.finish();
                            }
                        }
                    });
                }
            } else if (networkCustomError.getStatusCode() == -1 || net.one97.paytm.fastag.c.a.a().f13559b.checkErrorCodeFromCommonUtility(activity, networkCustomError)) {
                h.a((Context) activity, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            } else if (networkCustomError.getStatusCode() != -1) {
                String url = networkCustomError.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append(networkCustomError.getStatusCode());
                b.d((Context) activity, url, sb.toString());
            } else {
                h.a((Context) activity, activity.getResources().getString(R.string.network_error_heading), activity.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            }
        }
    }
}
