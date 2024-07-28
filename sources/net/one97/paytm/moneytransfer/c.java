package net.one97.paytm.moneytransfer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CustProductListV2;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferUserHistoryActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransferv4.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f53587a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final String f53588b = f53588b;

    private c() {
    }

    private static String a() {
        return net.one97.paytm.payments.d.a.a() + "cash_wallet?featuretype=money_transfer";
    }

    private static void b(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (com.paytm.utility.a.p(context)) {
            ag.a aVar = ag.f69605a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            if (ag.a.a(applicationContext).b("is_upi_user", false, true) || net.one97.paytm.utils.a.b.b(context.getApplicationContext())) {
                c(context, deepLinkData);
                return;
            }
            c(context, deepLinkData);
            a();
            b.a(context).b(new a(context), new b());
            a(context, (a.C1389a) new C0961c(context));
            return;
        }
        Intent intent = new Intent(context, PaySendInfoActivity.class);
        intent.putExtra("dest", UpiConstants.WALLET_TYPE_MONEY_TRANSFER);
        context.startActivity(intent);
    }

    public static final class a implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f53598a;

        a(Context context) {
            this.f53598a = context;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            CustProductListV2 custProductListV2 = (CustProductListV2) iJRPaytmDataModel;
            if (p.a(custProductListV2.getStatus(), "SUCCESS", true) && custProductListV2.isSuccess() && custProductListV2.getResponse() != null) {
                CustProductListV2.Isa response = custProductListV2.getResponse();
                k.a((Object) response, "custProductList.response");
                if (!TextUtils.isEmpty(response.getIsaStatus())) {
                    CustProductListV2.Isa response2 = custProductListV2.getResponse();
                    k.a((Object) response2, "custProductList.response");
                    if (k.a((Object) response2.getIsaStatus(), (Object) "ISSUED")) {
                        net.one97.paytm.utils.a.b.j(this.f53598a);
                    }
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            String str = upiCustomVolleyError.getmErrorCode();
            if (!TextUtils.isEmpty(str) && k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
                Toast.makeText(this.f53598a, R.string.no_internet, 1).show();
            } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
                Context context = this.f53598a;
                if (context != null) {
                    new NetworkCustomError();
                    r.a((Activity) context, (String) null, (Bundle) null, true, true);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            } else {
                Toast.makeText(this.f53598a, R.string.some_went_wrong, 1).show();
            }
        }
    }

    public static final class b implements a.c {
        b() {
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.c$c  reason: collision with other inner class name */
    public static final class C0961c implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f53724a;

        C0961c(Context context) {
            this.f53724a = context;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                if (upiAvailabilityModel.getResponse() != null) {
                    UpiAvailabilityModel.UpiAvailabilityResponse response = upiAvailabilityModel.getResponse();
                    k.a((Object) response, "response.response");
                    response.isUpiUser();
                    return;
                }
                return;
            }
            Toast.makeText(this.f53724a, R.string.some_went_wrong, 1).show();
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            String str = upiCustomVolleyError.getmErrorCode();
            if (!TextUtils.isEmpty(str) && k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
                Toast.makeText(this.f53724a, R.string.no_internet, 1).show();
            } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
                Context context = this.f53724a;
                if (context != null) {
                    new NetworkCustomError();
                    r.a((Activity) context, (String) null, (Bundle) null, true, true);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            } else {
                Toast.makeText(this.f53724a, R.string.some_went_wrong, 1).show();
            }
        }
    }

    private static void c(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        Intent intent = new Intent(context, MoneyTransferV3Activity.class);
        intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent.setFlags(536870912);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) && p.a(deepLinkData.f50288f, UpiConstants.WALLET_TYPE_MONEY_TRANSFER, true)) {
            return true;
        }
        if (p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) && p.a(deepLinkData.f50288f, "money_transfer_bankaccount", true)) {
            return true;
        }
        if (p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) && p.a(deepLinkData.f50288f, f53588b, true)) {
            return true;
        }
        if (p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) && p.a(deepLinkData.f50288f, "money_transfer_self", true)) {
            return true;
        }
        if (p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) && p.a(deepLinkData.f50288f, "money_transfer_check_balance", true)) {
            return true;
        }
        if (!p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) || !p.a(deepLinkData.f50288f, "money_transfer_history", true)) {
            return false;
        }
        return true;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50288f, UpiConstants.WALLET_TYPE_MONEY_TRANSFER, true)) {
            b(context, deepLinkData);
        } else if (p.a(deepLinkData.f50288f, "money_transfer_bankaccount", true)) {
            c.a aVar = net.one97.paytm.moneytransferv4.c.f55350a;
            c.a.a(context, deepLinkData);
        } else if (p.a(deepLinkData.f50288f, f53588b, true)) {
            c.a aVar2 = net.one97.paytm.moneytransferv4.c.f55350a;
            c.a.a(context, deepLinkData);
        } else if (p.a(deepLinkData.f50288f, "money_transfer_self", true)) {
            k.c(context, "context");
            k.c(deepLinkData, "deepLinkData");
            c.a aVar3 = net.one97.paytm.moneytransferv4.c.f55350a;
            k.c(context, "context");
            k.c(deepLinkData, "deepLinkData");
            x.e eVar = new x.e();
            eVar.element = null;
            if (!m.b(context)) {
                eVar.element = new ProgressDialog(context);
                ((ProgressDialog) eVar.element).setMessage(context.getString(R.string.please_wait));
                ((ProgressDialog) eVar.element).setIndeterminate(true);
                ((ProgressDialog) eVar.element).show();
            }
            c.a.a(new c.a.e(eVar, context, deepLinkData));
        } else if (p.a(deepLinkData.f50288f, "money_transfer_check_balance", true)) {
            b(context, deepLinkData);
        } else if (p.a(deepLinkData.f50288f, "money_transfer_history", true)) {
            k.c(context, "context");
            k.c(deepLinkData, "deepLinkData");
            Intent intent = new Intent(context, MoneyTransferUserHistoryActivity.class);
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.setFlags(536870912);
            context.startActivity(intent);
        }
    }

    private static void a(Context context, a.C1389a aVar) {
        g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)).e(aVar, "", context.getClass().getSimpleName());
    }
}
