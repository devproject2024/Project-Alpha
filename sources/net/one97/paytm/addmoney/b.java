package net.one97.paytm.addmoney;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.AJRAddMoneyPaymentActivity;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJRForgotPassword;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRWebViewActivity;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.helper.a;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity;
import net.one97.paytm.passbook.main.entity.MultiSubWallet;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.f.c;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ak;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.c.n;

public final class b implements net.one97.paytm.helper.c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f48395b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static b f48396d;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<net.one97.paytm.wallet.d.c> f48397a;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f48398c;

    public final void a(Activity activity, CJRCart cJRCart) {
        kotlin.g.b.k.c(activity, "mActivity");
        kotlin.g.b.k.c(cJRCart, "cart");
    }

    public final String b() {
        return "net.one97.paytm";
    }

    public final String f() {
        return "market-app";
    }

    public final String m() {
        return "DEBIT_CARD,CREDIT_CARD,NET_BANKING,UPI,NET_BANKING_PPBL";
    }

    public final void b(String str, String str2, Context context) {
        kotlin.g.b.k.c(str, "gtmEventWalletInvalidPromoCode");
        kotlin.g.b.k.c(str2, "gtmKeyScreenBottomNav");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "gtmEventWalletInvalidPromoCode");
        kotlin.g.b.k.c(str2, "gtmKeyScreenBottomNav");
        kotlin.g.b.k.c(context, "context");
    }

    public final boolean a() {
        return !net.one97.paytm.upgradeKyc.utils.j.j(j()) && net.one97.paytm.upgradeKyc.utils.j.i(j()) && net.one97.paytm.upgradeKyc.utils.j.d(j()) == 0 && com.paytm.utility.a.p(j());
    }

    public final void a(Context context, int i2) {
        kotlin.g.b.k.c(context, "context");
        Intent intent = new Intent();
        intent.setAction("fd_create_new_task");
        intent.putExtra("status", i2);
        ae aeVar = ae.f50307a;
        ae.a(context, intent);
    }

    public final String a(int i2) {
        String string = j().getString(i2);
        kotlin.g.b.k.a((Object) string, "getApplicationContext().getString(message)");
        return string;
    }

    public final Object c() {
        return new net.one97.paytm.wallet.d.c();
    }

    public final void a(Context context, String str, Bundle bundle) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "url");
        h.a aVar = net.one97.paytm.deeplink.h.f50349a;
        h.a.a(context, str, bundle);
    }

    public final void a(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=3");
    }

    public static final class i extends com.google.gson.b.a<CJPayMethodResponse> {
        i() {
        }
    }

    public final IJRPaytmDataModel a(String str) {
        kotlin.g.b.k.c(str, Payload.RESPONSE);
        Object a2 = ak.a(str, new i().getType());
        if (a2 != null) {
            return (CJPayMethodResponse) a2;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse");
    }

    public final Context a(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        ContextThemeWrapper a2 = net.one97.paytm.locale.b.e.a(context);
        kotlin.g.b.k.a((Object) a2, "Restring.wrapContext(newBase)");
        return a2;
    }

    public static final class j implements net.one97.paytm.p2b.b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f48409a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f48410b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.wallet.f.h f48411c;

        public final void b() {
        }

        public final void c() {
        }

        j(b bVar, FragmentActivity fragmentActivity, net.one97.paytm.wallet.f.h hVar) {
            this.f48409a = bVar;
            this.f48410b = fragmentActivity;
            this.f48411c = hVar;
        }

        public final void a() {
            b bVar = this.f48409a;
            FragmentActivity fragmentActivity = this.f48410b;
            String canonicalName = fragmentActivity.getClass().getCanonicalName();
            bVar.a((Activity) fragmentActivity, canonicalName, (Bundle) null, Boolean.TRUE, Boolean.FALSE);
        }

        public final void a(IJRDataModel iJRDataModel) {
            this.f48411c.a(iJRDataModel);
        }
    }

    public final void a(FragmentActivity fragmentActivity, String str, net.one97.paytm.wallet.f.h hVar, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        String str11 = str;
        net.one97.paytm.wallet.f.h hVar2 = hVar;
        kotlin.g.b.k.c(fragmentActivity2, "activity");
        kotlin.g.b.k.c(str11, "p2B_transfer");
        kotlin.g.b.k.c(hVar2, "listenerIAddMoneyListener");
        String str12 = str2;
        kotlin.g.b.k.c(str12, "nickName");
        String str13 = str3;
        kotlin.g.b.k.c(str13, "senderName");
        String str14 = str4;
        kotlin.g.b.k.c(str14, "bankName");
        String str15 = str5;
        kotlin.g.b.k.c(str15, "ifscCode");
        String str16 = str6;
        kotlin.g.b.k.c(str16, "cleanAccountNumber");
        String str17 = str8;
        kotlin.g.b.k.c(str17, "amount");
        String str18 = str9;
        kotlin.g.b.k.c(str18, CJRQRScanResultModel.KEY_COMMENT_SMALL);
        String str19 = str10;
        kotlin.g.b.k.c(str19, "commissionValue");
        net.one97.paytm.p2b.d.d dVar = new net.one97.paytm.p2b.d.d();
        dVar.a((Activity) fragmentActivity2, str11, (net.one97.paytm.p2b.b.c) new j(this, fragmentActivity2, hVar2));
        dVar.a(str12, str13, str14, str15, str16, str7, str17, str18, str19);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean a(Activity activity, NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(activity, "activity");
        kotlin.g.b.k.c(networkCustomError, "error");
        return r.a((Context) activity, (Exception) networkCustomError, (String) null);
    }

    public final void a(String str, Map<String, Object> map, Context context) {
        kotlin.g.b.k.c(str, "gtmEventWalletError");
        kotlin.g.b.k.c(map, Item.CTA_URL_TYPE_MAP);
        kotlin.g.b.k.c(context, "applicationContext");
        net.one97.paytm.j.a.b(str, map, context);
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "mId");
        net.one97.paytm.b.a.c.a().f49483c = str;
    }

    public final void c(String str) {
        net.one97.paytm.b.a.c.a().f49482b = str;
    }

    public final boolean b(Context context) {
        kotlin.g.b.k.c(context, "context");
        return net.one97.paytm.utils.a.b.f(context);
    }

    public final void c(Context context) {
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.utils.a.b.h(context);
    }

    public final void d(Context context) {
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.utils.a.b.i(context);
    }

    public final void e(Context context) {
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.utils.a.b.j(context);
    }

    public final void b(Context context, int i2) {
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.utils.a.b.b(context, i2);
    }

    public final boolean f(Context context) {
        kotlin.g.b.k.c(context, "context");
        return net.one97.paytm.utils.a.b.e(context);
    }

    public final boolean g(Context context) {
        kotlin.g.b.k.c(context, "context");
        return net.one97.paytm.utils.a.b.b(context);
    }

    public final boolean h(Context context) {
        kotlin.g.b.k.c(context, "context");
        return net.one97.paytm.utils.a.b.a(context);
    }

    public final Intent i(Context context) {
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.payments.d.a.a(context, "paytmmp://payment_bank?featuretype=add_money_bank");
        return new Intent(context, AJRMainActivity.class);
    }

    public final Intent j(Context context) {
        kotlin.g.b.k.c(context, "context");
        return new Intent(context, AJREmbedWebView.class);
    }

    public final Intent k(Context context) {
        kotlin.g.b.k.c(context, "context");
        return new Intent(context, AJRAuthActivity.class);
    }

    public final Class<? extends Activity> d(String str) {
        kotlin.g.b.k.c(str, "name");
        Class<?> cls = Class.forName(str);
        if (cls != null) {
            return cls;
        }
        throw new u("null cannot be cast to non-null type java.lang.Class<out android.app.Activity>");
    }

    public final Intent l(Context context) {
        kotlin.g.b.k.c(context, "context");
        return new Intent(context, UpgradeKycActivity.class);
    }

    public final String d() {
        String d2 = net.one97.paytm.f.b.a().d();
        kotlin.g.b.k.a((Object) d2, "RiskInformationControlle…tJsonOfRiskExtendedInfo()");
        return d2;
    }

    public final void a(FragmentActivity fragmentActivity, Bundle bundle) {
        kotlin.g.b.k.c(fragmentActivity, "activity");
        i((Activity) fragmentActivity);
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            bundle2.putString(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (String) null);
            net.one97.paytm.deeplink.d.a((Context) fragmentActivity, bundle2, (m) new d(this, fragmentActivity));
            return;
        }
        net.one97.paytm.deeplink.d.a((Context) fragmentActivity, bundle, (m) new e(this, fragmentActivity));
    }

    public static final class d implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f48402a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f48403b;

        d(b bVar, FragmentActivity fragmentActivity) {
            this.f48402a = bVar;
            this.f48403b = fragmentActivity;
        }

        public final void dismiss() {
            b.a(this.f48402a);
        }

        public final void show() {
            this.f48402a.i((Activity) this.f48403b);
        }
    }

    public static final class e implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f48404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f48405b;

        e(b bVar, FragmentActivity fragmentActivity) {
            this.f48404a = bVar;
            this.f48405b = fragmentActivity;
        }

        public final void dismiss() {
            b.a(this.f48404a);
        }

        public final void show() {
            this.f48404a.i((Activity) this.f48405b);
        }
    }

    public final Intent a(FragmentActivity fragmentActivity) {
        kotlin.g.b.k.c(fragmentActivity, "activity");
        return new Intent(fragmentActivity, AJRAuthActivity.class);
    }

    public final Intent b(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        return new Intent(activity, AJRWebViewActivity.class);
    }

    public final String e() {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("pb_rsa_key", (String) null);
        kotlin.g.b.k.a((Object) a2, "GTMLoader.getInstance().…ring(KEY_PB_BANK_RSA_KEY)");
        return a2;
    }

    public final Intent c(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        return new Intent(activity, MoneyTransferV3Activity.class);
    }

    public final void e(String str) {
        kotlin.g.b.k.c(str, "amount");
        net.one97.paytm.b.a.c.a().f49481a = "";
    }

    public final void d(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        net.one97.paytm.payments.d.a.a(activity, "set_passcode");
    }

    public final Intent e(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        return new Intent(activity, AJRForgotPassword.class);
    }

    public final int g() {
        return net.one97.paytm.upgradeKyc.utils.j.b(j());
    }

    public final boolean h() {
        return net.one97.paytm.upgradeKyc.utils.j.j(j());
    }

    public final String i() {
        String a2 = net.one97.paytm.payments.d.a.a();
        kotlin.g.b.k.a((Object) a2, "DeeplinkManager.deeplinkSchemaName()");
        return a2;
    }

    public final void a(Exception exc) {
        kotlin.g.b.k.c(exc, "exception");
        com.google.firebase.crashlytics.c.a().a((Throwable) exc);
    }

    public final Intent f(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        net.one97.paytm.j.c.a();
        if (net.one97.paytm.j.c.a("isToUseDeferedFlowForAddMoney", true)) {
            return new Intent(activity, AJRAddMoneyPaymentActivity.class);
        }
        return new Intent(activity, AJRRechargePaymentActivity.class);
    }

    public final void a(Activity activity, String str, Bundle bundle) {
        kotlin.g.b.k.c(activity, "activity");
        a(activity, str, bundle, Boolean.TRUE, Boolean.FALSE);
    }

    public final void a(Activity activity, String str, Bundle bundle, Boolean bool, Boolean bool2) {
        kotlin.g.b.k.c(activity, "activity");
        r.a(activity, str, bundle, bool != null ? bool.booleanValue() : true, bool2 != null ? bool2.booleanValue() : false);
    }

    public final String a(CJRPGTokenList cJRPGTokenList) {
        kotlin.g.b.k.c(cJRPGTokenList, "tokenList");
        return t.a(cJRPGTokenList);
    }

    public final Context j() {
        Context appContext = CJRJarvisApplication.getAppContext();
        kotlin.g.b.k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public final String f(String str) {
        kotlin.g.b.k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public final String a(String str, String str2) {
        kotlin.g.b.k.c(str, "key");
        kotlin.g.b.k.c(str2, "defaultValue");
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a(str, str2);
        kotlin.g.b.k.a((Object) a2, "GTMLoader.getInstance().…tString(key,defaultValue)");
        return a2;
    }

    public final boolean g(String str) {
        kotlin.g.b.k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, false);
    }

    public final int h(String str) {
        kotlin.g.b.k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, 0);
    }

    public final void a(Context context, String str) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "url");
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "category");
        kotlin.g.b.k.c(str2, "action");
        kotlin.g.b.k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        kotlin.g.b.k.c(str5, "verticalId");
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "category");
        kotlin.g.b.k.c(str2, "action");
        kotlin.g.b.k.c(str7, "verticalId");
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public final void a(String str, String str2, Context context) {
        kotlin.g.b.k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        kotlin.g.b.k.c(str2, "vertical");
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void a(String str, String str2, String str3, String str4, Context context) {
        kotlin.g.b.k.c(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        kotlin.g.b.k.c(str2, "screenValue");
        kotlin.g.b.k.c(str3, "key");
        kotlin.g.b.k.c(str4, "value");
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.j.a.a(str, str2, str3, str4, context);
    }

    public final void g(Activity activity) {
        kotlin.g.b.k.c(activity, "ctx");
        Intent intent = new Intent(activity, AJRAuthActivity.class);
        intent.putExtra("launchSignUp", false);
        intent.putExtra("set_result_required", true);
        intent.putExtra("VERTICAL_NAME", "Wallet");
        activity.startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
    }

    public final void a(Context context, String str, String str2, String str3) {
        kotlin.g.b.k.c(context, "activity");
        net.one97.paytm.f.b.a().a(context, str, str2, false, str3, com.paytm.utility.a.g(context), com.paytm.utility.a.h(context));
    }

    public final void a(CJRRechargePayment cJRRechargePayment, Intent intent) {
        kotlin.g.b.k.c(cJRRechargePayment, "rechargePayment");
        kotlin.g.b.k.c(intent, "intent");
        ab.a(cJRRechargePayment, intent);
    }

    public final Intent b(FragmentActivity fragmentActivity) {
        kotlin.g.b.k.c(fragmentActivity, "activity");
        return new Intent(fragmentActivity, AJROrderSummaryActivity.class);
    }

    public static final class c implements FetchPayOptionsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.addmoney.togv.b.c f48401a;

        public final void onPaymentOptionsReceived(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse cJPayMethodResponse) {
            kotlin.g.b.k.c(cJPayMethodResponse, "cjPayMethodResponse");
        }

        public final void onVpaReceived(VpaFetch vpaFetch) {
            kotlin.g.b.k.c(vpaFetch, "vpaFetch");
        }

        c(net.one97.paytm.addmoney.togv.b.c cVar) {
            this.f48401a = cVar;
        }

        public final void onRequestStart() {
            this.f48401a.a();
        }

        public final void onPaymentOptionsError() {
            this.f48401a.c();
        }

        public final void onRequestEnd(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
            PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
            this.f48401a.b();
        }
    }

    public final void a(Context context, CJRRechargePayment cJRRechargePayment, net.one97.paytm.addmoney.togv.b.c cVar) {
        kotlin.g.b.k.c(context, "applicationContext");
        kotlin.g.b.k.c(cJRRechargePayment, "rechargePayment");
        kotlin.g.b.k.c(cVar, "fetchPaymentListener");
        t.a(context, cJRRechargePayment, (FetchPayOptionsListener) new c(cVar));
    }

    public static final class g implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f48407a;

        g(com.paytm.network.listener.b bVar) {
            this.f48407a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f48407a.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                this.f48407a.onApiSuccess(iJRPaytmDataModel);
            }
        }
    }

    public final void a(Context context, com.paytm.network.listener.b bVar) {
        kotlin.g.b.k.c(bVar, "paytmCommonApiListener");
        t.a(context, (com.paytm.network.listener.b) new g(bVar), a.c.ADDMONEY);
    }

    public static final class h implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f48408a;

        h(com.paytm.network.listener.b bVar) {
            this.f48408a = bVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f48408a.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                this.f48408a.onApiSuccess(iJRPaytmDataModel);
            }
        }
    }

    public final void a(Activity activity, com.paytm.network.listener.b bVar) {
        kotlin.g.b.k.c(activity, "mActivity");
        kotlin.g.b.k.c(bVar, "paytmCommonApiListener");
        t.a(activity, (com.paytm.network.listener.b) new h(bVar), a.c.ADDMONEY);
    }

    public final void k() {
        net.one97.paytm.f.b.a().c();
    }

    public final void a(androidx.fragment.app.j jVar, int i2) {
        kotlin.g.b.k.c(jVar, "supportFragmentManager");
        n nVar = new n();
        Bundle bundle = new Bundle();
        bundle.putInt("deal_type", 321);
        nVar.setArguments(bundle);
        jVar.a().a(0, 0).b(i2, nVar, n.f70086a).c();
    }

    public final View a(SFWidget sFWidget, Context context, androidx.fragment.app.j jVar, String str, String str2, net.one97.paytm.utils.b.a aVar, String str3) {
        net.one97.paytm.cashback.posttxn.e a2;
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(jVar, "supportFragmentManager");
        kotlin.g.b.k.c(str2, "verticalId");
        kotlin.g.b.k.c(aVar, "transactionType");
        kotlin.g.b.k.c(str3, "s2");
        if (!net.one97.paytm.deeplink.e.a() || (a2 = net.one97.paytm.cashback.posttxn.c.a()) == null || !a2.a(aVar.getId(), 0)) {
            return null;
        }
        a2.a((AppCompatActivity) context);
        f.a aVar2 = new f.a();
        if (str != null) {
            aVar2.f49546b = str;
        }
        aVar2.f49550f = a.c.ADDMONEY.name();
        a2.a(aVar2.a(), (net.one97.paytm.cashback.posttxn.a) new k(aVar, a2, context, str, sFWidget));
        return null;
    }

    public static final class k implements net.one97.paytm.cashback.posttxn.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.utils.b.a f48412a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.cashback.posttxn.e f48413b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f48414c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f48415d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ SFWidget f48416e;

        k(net.one97.paytm.utils.b.a aVar, net.one97.paytm.cashback.posttxn.e eVar, Context context, String str, SFWidget sFWidget) {
            this.f48412a = aVar;
            this.f48413b = eVar;
            this.f48414c = context;
            this.f48415d = str;
            this.f48416e = sFWidget;
        }

        public final void onAnimationEnd(String str) {
            SFWidget sFWidget = this.f48416e;
            if (sFWidget == null) {
                return;
            }
            if (sFWidget != null) {
                IStaticWidget iStaticWidget = (IStaticWidget) sFWidget;
                if (str == null) {
                    str = "cashback";
                }
                iStaticWidget.AnimateView(str);
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
        }

        public final Point getFloatingWidgetPos(String str) {
            SFWidget sFWidget = this.f48416e;
            if (sFWidget == null) {
                return null;
            }
            if (sFWidget != null) {
                IStaticWidget iStaticWidget = (IStaticWidget) sFWidget;
                if (str == null) {
                    str = "cashback";
                }
                return iStaticWidget.getViewPoint(str);
            }
            throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
        }
    }

    public final boolean a(Context context, NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(context, "mActivity");
        kotlin.g.b.k.c(networkCustomError, "error");
        return r.a(context, (Exception) networkCustomError);
    }

    public final String i(String str) {
        kotlin.g.b.k.c(str, "url");
        String b2 = ab.b(str);
        kotlin.g.b.k.a((Object) b2, "CJRRechargeUtilityConsta…reVerifyNativePGFlow(url)");
        return b2;
    }

    public final void a(Context context, Item item, int i2, String str) {
        kotlin.g.b.k.c(context, "mContext");
        kotlin.g.b.k.c(item, "item");
        kotlin.g.b.k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new C0847b(item, context, i2, str, (kotlin.d.d) null), 3, (Object) null);
    }

    public final View a(Context context, androidx.fragment.app.j jVar, String str) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(jVar, "supportFragmentManager");
        kotlin.g.b.k.c(str, "mBankTransactionId");
        if (!net.one97.paytm.deeplink.e.a()) {
            return new View(context);
        }
        net.one97.paytm.cashback.posttxn.e a2 = net.one97.paytm.cashback.posttxn.c.a();
        a2.a((AppCompatActivity) context);
        a2.a(new f.a().a(), (net.one97.paytm.cashback.posttxn.a) null);
        return new View(context);
    }

    public static final class f implements c.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.wallet.newdesign.addmoney.c.e f48406a;

        f(net.one97.paytm.wallet.newdesign.addmoney.c.e eVar) {
            this.f48406a = eVar;
        }

        public final void onNameInitialize(String str) {
            this.f48406a.a(str);
        }

        public final void onNameInitializationError(String str) {
            this.f48406a.b(str);
        }
    }

    public final void a(Context context, net.one97.paytm.wallet.newdesign.addmoney.c.e eVar) {
        kotlin.g.b.k.c(context, "mContext");
        kotlin.g.b.k.c(eVar, "nameInitailizeListner");
        net.one97.paytm.upgradeKyc.f.c.a().a(context, (c.b) new f(eVar));
    }

    public final boolean m(Context context) {
        kotlin.g.b.k.c(context, "context");
        boolean j2 = net.one97.paytm.upgradeKyc.utils.j.j(context);
        boolean i2 = net.one97.paytm.upgradeKyc.utils.j.i(context);
        int d2 = net.one97.paytm.upgradeKyc.utils.j.d(context);
        if (j2 || !i2 || d2 != 0 || !com.paytm.utility.a.p(context)) {
            return false;
        }
        try {
            net.one97.paytm.payments.d.a.a(context, net.one97.paytm.utils.j.a("paytmmp://cash_wallet?featuretype=add_money&tab=wallet", "wallet"));
            return true;
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
            return true;
        }
    }

    public final void a(Activity activity, Intent intent, net.one97.paytm.wallet.d.c cVar) {
        kotlin.g.b.k.c(activity, "activity");
        kotlin.g.b.k.c(intent, "intent");
        kotlin.g.b.k.c(cVar, "addMoneyHelper");
        String stringExtra = intent.getStringExtra(CJRRechargeCart.KEY_PAYMENT_INSTRUMENT);
        net.one97.paytm.j.c.a();
        if (net.one97.paytm.j.c.a("isToUseDeferedFlowForAddMoney", true)) {
            PaytmSDK.setResponse((net.one97.paytm.nativesdk.common.model.CJPayMethodResponse) new com.google.gson.f().a(stringExtra, net.one97.paytm.nativesdk.common.model.CJPayMethodResponse.class), (VpaFetch) null);
        }
        this.f48397a = new WeakReference<>(cVar);
        activity.startActivityForResult(intent, 104);
    }

    /* access modifiers changed from: private */
    public final void i(Activity activity) {
        Dialog dialog;
        try {
            if (this.f48398c == null) {
                this.f48398c = UpiAppUtils.getWalletStyleProgressDialog(activity);
            }
            if (this.f48398c != null) {
                Dialog dialog2 = this.f48398c;
                Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (!valueOf.booleanValue() && (dialog = this.f48398c) != null) {
                    dialog.show();
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final void a(Activity activity, Intent intent) {
        kotlin.g.b.k.c(activity, "activity");
        kotlin.g.b.k.c(intent, "intent");
        intent.setAction("passcode_activity");
        ae aeVar = ae.f50307a;
        ae.a(activity, intent);
    }

    public final void a(Context context, Integer num, Integer num2, String str) {
        kotlin.g.b.k.c(context, "context");
        Intent intent = new Intent(context, PassbookL2Activity.class);
        intent.putExtra("passbook_type", num);
        intent.putExtra("clicked_wallet_id", num2);
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            intent.putExtra("clickedWalletIssuerId", str);
        }
        context.startActivity(intent);
    }

    public final void a(Context context, Integer num, net.one97.paytm.newaddmoney.b.a aVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(aVar, "wallet");
        Intent intent = new Intent(context, PassbookSubwalletActivity.class);
        intent.putExtra("display_name", aVar.f55819b);
        intent.putExtra("subwallet-list", a(num, aVar));
        intent.putExtra("sub_wallet_type", num);
        intent.putExtra("isOpenFromNewPassbook", true);
        intent.setFlags(603979776);
        context.startActivity(intent);
    }

    private static MultiSubWallet a(Integer num, net.one97.paytm.newaddmoney.b.a aVar) {
        try {
            Object a2 = new com.google.gsonhtcfix.f().a(new com.google.gsonhtcfix.f().a((Object) aVar), CJRSubWallet.class);
            kotlin.g.b.k.a(a2, "com.google.gsonhtcfix.Gs…CJRSubWallet::class.java)");
            CJRSubWallet cJRSubWallet = (CJRSubWallet) a2;
            MultiSubWallet multiSubWallet = new MultiSubWallet(num != null ? num.intValue() : 0, false);
            multiSubWallet.addSubWallet(cJRSubWallet);
            return multiSubWallet;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @kotlin.d.b.a.f(b = "AddMoneyDataProvider.kt", c = {753}, d = "invokeSuspend", e = "net.one97.paytm.addmoney.AddMoneyDataProvider$addDataInGTMController$1")
    /* renamed from: net.one97.paytm.addmoney.b$b  reason: collision with other inner class name */
    static final class C0847b extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ Item $item;
        final /* synthetic */ Context $mContext;
        final /* synthetic */ int $position;
        final /* synthetic */ String $screenName;
        Object L$0;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0847b(Item item, Context context, int i2, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.$item = item;
            this.$mContext = context;
            this.$position = i2;
            this.$screenName = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            C0847b bVar = new C0847b(this.$item, this.$mContext, this.$position, this.$screenName, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C0847b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                this.L$0 = this.p$;
                this.label = 1;
                obj = SFGsonUtils.getClientPojo(this.$item, CJRHomePageItem.class, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                ResultKt.a(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) obj;
            Integer num = null;
            if (cJRHomePageItem != null) {
                Item item = this.$item;
                cJRHomePageItem.setLayoutType(item != null ? item.getParentType() : null);
            }
            if (cJRHomePageItem != null) {
                Item item2 = this.$item;
                if (item2 != null) {
                    num = Integer.valueOf(item2.getParentBindPosition());
                }
                cJRHomePageItem.setWidgetPosition(num.intValue());
            }
            if (cJRHomePageItem != null) {
                Item item3 = this.$item;
                if (item3 == null || (str = item3.getContainerinstatnceid()) == null) {
                    str = "";
                }
                cJRHomePageItem.mContainerInstanceID = str;
            }
            Context context = this.$mContext;
            int i3 = this.$position;
            net.one97.paytm.j.a.e(cJRHomePageItem, context, i3, this.$screenName + '-');
            return x.f47997a;
        }
    }

    public final void h(Activity activity) {
        kotlin.g.b.k.c(activity, "activity");
        net.one97.paytm.auth.b.b.a(activity, false);
    }

    public final String l() {
        return f("gvtitletextnew");
    }

    public static final /* synthetic */ void a(b bVar) {
        Dialog dialog;
        try {
            if (bVar.f48398c != null) {
                Dialog dialog2 = bVar.f48398c;
                Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (valueOf.booleanValue() && (dialog = bVar.f48398c) != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static final void o() {
        if (f48396d == null) {
            f48396d = new b();
        }
        a.C0911a aVar = net.one97.paytm.helper.a.f50546a;
        b bVar = f48396d;
        if (bVar == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.helper.c cVar = bVar;
        kotlin.g.b.k.c(cVar, "iAddMoneyListener");
        if (net.one97.paytm.helper.a.f50547c == null) {
            net.one97.paytm.helper.a.f50547c = new net.one97.paytm.helper.a();
            net.one97.paytm.helper.a a2 = net.one97.paytm.helper.a.f50547c;
            if (a2 != null) {
                a2.f50548b = cVar;
            }
        }
    }
}
