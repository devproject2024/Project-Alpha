package net.one97.paytm.paymentslimit.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.g;
import com.paytm.utility.k;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import net.one97.paytm.paymentslimit.b.d;
import net.one97.paytm.wallet.R;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f59347a = "Paytm Passbook";

    public static void a(final Activity activity, Throwable th, final String str) {
        NetworkCustomError networkCustomError;
        if (!activity.isFinishing() && (networkCustomError = (NetworkCustomError) th) != null) {
            networkCustomError.getAlertMessage();
            if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 404) || networkCustomError.getStatusCode() == 400 || networkCustomError.getStatusCode() == 503) {
                try {
                    if (!activity.isFinishing()) {
                        if (networkCustomError.getStatusCode() == 404 || networkCustomError.getStatusCode() == 400 || networkCustomError.getStatusCode() == 503) {
                            d.a((Context) activity, activity.getResources().getString(R.string.title_400), activity.getResources().getString(R.string.message_400));
                        }
                    }
                } catch (Exception e2) {
                    q.d(String.valueOf(e2));
                }
            } else if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
                if (activity != null && !activity.isFinishing() && (networkCustomError instanceof NetworkCustomError)) {
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
                    String b2 = com.paytm.utility.d.b(activity);
                    if (!TextUtils.isEmpty(b2)) {
                        String concat2 = "/".concat(String.valueOf(b2));
                        if (!TextUtils.isEmpty(string) && string.contains(concat2)) {
                            string = string.replace(concat2, "");
                        }
                    }
                    g.b(activity, str2, string, new g.c() {

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ Bundle f59350c = null;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ boolean f59351d = true;

                        /* renamed from: e  reason: collision with root package name */
                        final /* synthetic */ boolean f59352e = false;

                        public final void onDialogDismissed() {
                            net.one97.paytm.paymentslimit.a.b.f59274a.a(activity);
                            Intent intent = new Intent(activity, net.one97.paytm.paymentslimit.a.b.f59274a.b());
                            if (k.b()) {
                                intent.setFlags(32768);
                            }
                            intent.putExtra("authError", true);
                            if (str != null) {
                                intent.putExtra("sign_in_sign_up_with_step_2", true);
                                Bundle bundle = this.f59350c;
                                if (bundle != null) {
                                    intent.putExtra("resultant activity_bundle", bundle);
                                }
                            }
                            intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                            if (this.f59351d) {
                                activity.startActivityForResult(intent, 3);
                                return;
                            }
                            activity.startActivity(intent);
                            if (this.f59352e) {
                                activity.finish();
                            }
                        }
                    });
                }
            } else if (networkCustomError.getStatusCode() == -1) {
                d.a((Context) activity, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            } else if (networkCustomError.getStatusCode() != -1) {
                String url = networkCustomError.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append(networkCustomError.getStatusCode());
                com.paytm.utility.b.d((Context) activity, url, sb.toString());
            } else {
                d.a((Context) activity, activity.getResources().getString(R.string.network_error_heading), activity.getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            }
        }
    }
}
