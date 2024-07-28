package net.one97.paytm.addmoney.landing.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.addmoney.common.model.CJRAccountSummary;
import net.one97.paytm.addmoney.landing.a.a;
import net.one97.paytm.addmoney.utils.b;
import net.one97.paytm.addmoney.utils.h;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.addmoney.utils.n;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class a implements b, a.C0851a {

    /* renamed from: a  reason: collision with root package name */
    private final String f48577a;

    /* renamed from: b  reason: collision with root package name */
    private a.b f48578b;

    public a(a.b bVar, String str) {
        this.f48578b = bVar;
        this.f48577a = str;
    }

    public final void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Token", com.paytm.utility.a.q(this.f48578b.c().getApplicationContext()));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        String e2 = com.paytm.utility.b.e(this.f48578b.c().getApplicationContext(), net.one97.paytm.helper.a.b().f(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT));
        com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
        a2.f42877a = this.f48578b.c().getApplicationContext();
        a2.o = "AddMoneyToPPBActivity";
        a2.f42880d = e2;
        a2.f42882f = hashMap;
        a2.f42885i = new CustProductList();
        a2.j = this;
        com.paytm.network.a l = a2.l();
        l.a((Object) this.f48577a);
        l.a();
    }

    public final void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", com.paytm.utility.a.q(this.f48578b.c().getApplicationContext()));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        String f2 = net.one97.paytm.helper.a.b().f(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW);
        com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
        a2.f42877a = this.f48578b.c().getApplicationContext();
        a2.o = "AddMoneyToPPBActivity";
        a2.f42880d = f2;
        a2.f42882f = hashMap;
        a2.f42885i = new CJRAccountSummary();
        a2.j = this;
        com.paytm.network.a l = a2.l();
        l.a((Object) this.f48577a);
        l.a();
    }

    public final void a() {
        try {
            String f2 = net.one97.paytm.helper.a.b().f("check_user_balance_service");
            if (f2 == null) {
                return;
            }
            if (URLUtil.isValidUrl(f2)) {
                String e2 = com.paytm.utility.b.e((Context) this.f48578b.c(), f2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f48578b.c()));
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("Content-Type", "application/json");
                new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f48578b.c()));
                com.paytm.utility.b.j();
                new HashMap().put("screen_name", this.f48578b.c().getClass().getSimpleName());
                if (com.paytm.utility.b.c((Context) this.f48578b.c())) {
                    com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                    b2.f42877a = this.f48578b.c().getApplicationContext();
                    b2.o = "AddMoneyToPPBActivity";
                    b2.f42880d = e2;
                    b2.f42882f = hashMap;
                    b2.f42885i = new CJRCashWallet();
                    b2.f42884h = jSONObject.toString();
                    b2.j = this;
                    com.paytm.network.a l = b2.l();
                    l.a((Object) this.f48577a);
                    l.a();
                    return;
                }
                String str = "---";
                String a2 = j.a((Context) this.f48578b.c());
                if (j.c(this.f48578b.c()) != null) {
                    str = j.c(this.f48578b.c());
                }
                if (!TextUtils.isEmpty(a2)) {
                    a.b bVar = this.f48578b;
                    String d2 = j.d(this.f48578b.c().getApplicationContext());
                    a(h.a(this.f48578b.c().getApplicationContext()).b("kyc_state", "", true));
                    bVar.a(a2, str, d2);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private static boolean a(String str) {
        b.a[] values = b.a.values();
        if (values.length > 0) {
            b.a aVar = values[0];
            if (str.equalsIgnoreCase(aVar.getWalletUserState()) || str.equalsIgnoreCase(aVar.getv2UserState())) {
                String str2 = aVar.getv2UserState();
                String f2 = net.one97.paytm.helper.a.b().f("AddMoneyWalletBlockedStates");
                return TextUtils.isEmpty(f2) || !f2.contains(str2);
            }
        }
        return true;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        if (iJRPaytmDataModel instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
            if (cJRCashWallet.getResponse() == null || !cJRCashWallet.getStatusMessage().equalsIgnoreCase("SUCCESS")) {
                a.b bVar = this.f48578b;
                cJRCashWallet.getStatusMessage();
                bVar.d();
                return;
            }
            double paytmWalletBalance = cJRCashWallet.getResponse().getPaytmWalletBalance();
            j.a((Context) this.f48578b.c(), paytmWalletBalance);
            String b2 = com.paytm.utility.b.b(Double.valueOf(paytmWalletBalance));
            double d2 = 0.0d;
            for (int i2 = 0; i2 < cJRCashWallet.getResponse().getSubWalletDetailList().size(); i2++) {
                if (cJRCashWallet.getResponse().getSubWalletDetailList().get(i2).getSubWalletType() == n.GIFT_VOUCHER.getValue()) {
                    d2 += cJRCashWallet.getResponse().getSubWalletDetailList().get(i2).getBalance();
                }
            }
            j.b((Context) this.f48578b.c(), d2);
            String b3 = com.paytm.utility.b.b(Double.valueOf(d2));
            if (cJRCashWallet.getResponse() == null || cJRCashWallet.getResponse().getWalletGrade() == null) {
                str = "";
            } else {
                str = cJRCashWallet.getResponse().getWalletGrade();
                a(str);
            }
            h.a(this.f48578b.c().getApplicationContext()).a("kyc_state", str, true);
            this.f48578b.a(b2, b3, cJRCashWallet.getResponse().getWalletGrade());
        } else if (iJRPaytmDataModel instanceof CJROrderSummary) {
        } else {
            if (iJRPaytmDataModel instanceof CustProductList) {
                this.f48578b.a((CustProductList) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRAccountSummary) {
                this.f48578b.a((CJRAccountSummary) iJRPaytmDataModel);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a.b bVar = this.f48578b;
        if (bVar != null) {
            bVar.a(networkCustomError);
        }
    }
}
