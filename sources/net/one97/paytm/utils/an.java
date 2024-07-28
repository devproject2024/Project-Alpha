package net.one97.paytm.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.LoanLeadActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.b.d;
import net.one97.paytm.j.c;
import net.one97.paytm.model.IJRLoanLeadData;

public final class an {

    /* renamed from: a  reason: collision with root package name */
    private Context f69617a;

    public an(Context context) {
        this.f69617a = context;
    }

    @JavascriptInterface
    public final void openHome() {
        Toast.makeText(this.f69617a, "HOME", 1).show();
    }

    @JavascriptInterface
    public final void backToNative(String str) {
        System.out.println("In backToNative...");
        a(str);
    }

    private void a(String str) {
        if (this.f69617a instanceof LoanLeadActivity) {
            c.a();
            String q = c.q();
            if (TextUtils.isEmpty(q)) {
                q = "https://loanleads.paytm.com/home/callback";
            }
            String str2 = q;
            c.a();
            String r = c.r();
            if (TextUtils.isEmpty(r)) {
                r = "hellopaytm99554";
            }
            c.a();
            String s = c.s();
            if (TextUtils.isEmpty(s)) {
                s = "CONSUMER";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept", "application/json");
            hashMap.put("xtoken", r);
            hashMap.put("solutionType", s);
            hashMap.put("sso-token", a.q(CJRJarvisApplication.getAppContext()));
            d.a(this.f69617a, str2, new b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    new StringBuilder("callback response").append(iJRPaytmDataModel.toString());
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.POST, str, new IJRLoanLeadData(), a.c.P2B, a.b.SILENT).a();
            String str3 = "http://baseurl/loan-home?page=/loan-home&json={\"template\":" + str + "}";
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                parse.getScheme();
                Uri.Builder buildUpon = parse.buildUpon();
                Intent intent = new Intent(this.f69617a, LoanLeadActivity.class);
                intent.setData(buildUpon.build());
                this.f69617a.startActivity(intent);
            }
        }
    }

    @JavascriptInterface
    public final void showApprovedStatusAndroid(String str) {
        System.out.println("In showApprovedStatusAndroid...");
        a(str);
    }

    @JavascriptInterface
    public final void showCancelledStatusAndroid(String str) {
        System.out.println("In showCancelledStatusAndroid...");
        a(str);
    }

    @JavascriptInterface
    public final void showRejectedStatusAndroid(String str) {
        System.out.println("In showRejectedStatusAndroid...");
        a(str);
    }

    @JavascriptInterface
    public final void showOrders(int i2) {
        Toast.makeText(this.f69617a, "ORder  ".concat(String.valueOf(i2)), 1).show();
        System.out.println("In showOrders... orderid: ".concat(String.valueOf(i2)));
    }
}
