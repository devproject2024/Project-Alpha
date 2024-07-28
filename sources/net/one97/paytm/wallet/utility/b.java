package net.one97.paytm.wallet.utility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.d;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import net.one97.paytm.wallet.R;

public final class b {
    public static boolean a(int i2, ArrayList<Integer> arrayList) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (i2 == arrayList.get(i3).intValue()) {
                return true;
            }
        }
        return false;
    }

    public static void a(final Activity activity, final String str, Exception exc) {
        if (activity != null && !activity.isFinishing() && (exc instanceof NetworkCustomError)) {
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
                final /* synthetic */ Bundle f72314c = null;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ boolean f72315d = false;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ boolean f72316e = true;

                public final void onDialogDismissed() {
                    net.one97.paytm.wallet.communicator.b.a().signOut(activity);
                    Intent intent = new Intent(activity, net.one97.paytm.wallet.communicator.b.a().getAuthActivityClass());
                    intent.putExtra("authError", true);
                    String str = str;
                    if (str != null) {
                        intent.putExtra("resultant activity", str);
                        intent.putExtra("sign_in_sign_up_with_step_2", true);
                        Bundle bundle = this.f72314c;
                        if (bundle != null) {
                            intent.putExtra("resultant activity_bundle", bundle);
                        }
                    }
                    intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                    if (this.f72315d) {
                        activity.startActivityForResult(intent, 3);
                        return;
                    }
                    activity.startActivity(intent);
                    if (this.f72316e) {
                        activity.finish();
                    }
                }
            });
        }
    }
}
