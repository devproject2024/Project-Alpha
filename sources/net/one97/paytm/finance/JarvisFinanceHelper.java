package net.one97.paytm.finance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import net.one97.paytm.cashback.posttxn.c;
import net.one97.paytm.cashback.posttxn.e;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.paymentsbank.CJRVerifyPasscodeResponse;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.BuildConfig;
import net.one97.paytm.payments.d.a;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;

public class JarvisFinanceHelper {
    private static JarvisFinanceHelper mInstance;
    private FinanceAccessProviderListener financeAccessProviderListener;

    private JarvisFinanceHelper() {
    }

    public static JarvisFinanceHelper getInstance() {
        JarvisFinanceHelper jarvisFinanceHelper = mInstance;
        if (jarvisFinanceHelper != null) {
            return jarvisFinanceHelper;
        }
        throw new RuntimeException("getInstance() called before initFinanceApp()");
    }

    private static void createInstance() {
        if (mInstance == null) {
            mInstance = new JarvisFinanceHelper();
        }
    }

    public static void initFinanceApp(FinanceAccessProviderListener financeAccessProviderListener2) {
        createInstance();
        getInstance().setFinanceAccessProviderListener(financeAccessProviderListener2);
    }

    public FinanceAccessProviderListener getFinanceAccessProviderListener() {
        return this.financeAccessProviderListener;
    }

    public void setFinanceAccessProviderListener(FinanceAccessProviderListener financeAccessProviderListener2) {
        getInstance().financeAccessProviderListener = financeAccessProviderListener2;
    }

    public void initPostVerifyNativePGFlow(CJRRechargePayment cJRRechargePayment, Intent intent) {
        ab.a(cJRRechargePayment, intent);
    }

    public void openPassbook(Context context, String str) {
        a.a(context, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet");
    }

    public boolean checkErrorCode(Context context, NetworkCustomError networkCustomError) {
        return r.a(context, (Exception) networkCustomError);
    }

    public void handleCustomError(Activity activity, NetworkCustomError networkCustomError, String str, Bundle bundle, boolean z) {
        r.a(activity, (Exception) networkCustomError, (String) null, (Bundle) null);
    }

    public String initPreVerifyNativePGFlow(String str) {
        return ab.b(str);
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        r.a(activity, str, bundle);
    }

    public void setUserPreference(String str, Context context, b bVar) {
        r.a(str, context);
    }

    public View onTransactionComplete(Context context, String str) {
        e a2 = net.one97.paytm.deeplink.e.a() ? c.a() : null;
        if (a2 == null) {
            return new View(context);
        }
        a2.a((AppCompatActivity) context);
        a2.a(new f.a().a(), (net.one97.paytm.cashback.posttxn.a) null);
        return new View(context);
    }

    public CJRVerifyPasscodeResponse getVerifyPasscodeResponseClass() {
        return new CJRVerifyPasscodeResponse();
    }

    public void verifyPasscode(Context context, String str, b bVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.j.c.a();
            String a2 = com.paytm.e.a.b.a(net.one97.paytm.j.c.a("pb_rsa_key", (String) null), str);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Authorization", com.paytm.utility.b.m());
            hashMap2.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap2.put("session_token", com.paytm.utility.a.q(context));
            net.one97.paytm.j.c.a();
            String e2 = com.paytm.utility.b.e(context, net.one97.paytm.j.c.a(UpiConstantServiceApi.KEY_TOKEN, (String) null));
            com.paytm.b.a.a a3 = ag.a(context.getApplicationContext());
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.n = a.b.SILENT;
            bVar2.o = "AutoSubscriptionUtil";
            bVar2.f42877a = context;
            bVar2.f42878b = a.c.GOLD;
            bVar2.f42879c = a.C0715a.POST;
            bVar2.f42880d = e2;
            bVar2.f42881e = null;
            bVar2.f42882f = hashMap2;
            bVar2.f42883g = hashMap;
            bVar2.f42884h = "grant_type=" + URLEncoder.encode("password", AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode(a3.b("mobile", "", true), AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(a2, AppConstants.UTF_8) + "&scope=" + URLEncoder.encode(BuildConfig.BANK_TXN_SCOPE, AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("passcode", AppConstants.UTF_8);
            bVar2.f42885i = getInstance().getVerifyPasscodeResponseClass();
            bVar2.j = bVar;
            bVar2.l().a();
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
    }
}
