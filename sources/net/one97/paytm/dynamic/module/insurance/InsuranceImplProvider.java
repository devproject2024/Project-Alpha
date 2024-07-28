package net.one97.paytm.dynamic.module.insurance;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.q;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.insurance.a.a;
import net.one97.paytm.insurance.b.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;

public class InsuranceImplProvider implements a {
    private static InsuranceImplProvider mInstance;

    public String getDeeplinkDataKey() {
        return "EXTRA_DEEP_LINK_DATA";
    }

    public Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem) {
        return null;
    }

    public void handleH5Events(AppCompatActivity appCompatActivity, Bundle bundle, String str) {
    }

    public void loadMallPage(Context context, String str, HashMap<String, Serializable> hashMap) {
    }

    public void openNeedHelpBottomSheet(Context context, CJROrderSummary cJROrderSummary, j jVar) {
    }

    public static void init() {
        if (mInstance == null) {
            InsuranceImplProvider insuranceImplProvider = new InsuranceImplProvider();
            mInstance = insuranceImplProvider;
            c.a(insuranceImplProvider);
        }
    }

    public Context getApplicationContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public void openLandingActivity(Activity activity) {
        Intent intent = new Intent(activity, AJRMainActivity.class);
        intent.setFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    public String getLandingActivityClassName() {
        return AJRMainActivity.class.getName();
    }

    public Class getLandingActivityClass() {
        return AJRMainActivity.class;
    }

    public Class getAJROrderSummaryActivityClass() {
        return AJROrderSummaryActivity.class;
    }

    public ContextWrapper getBaseContext(Context context) {
        return e.a(context);
    }

    public boolean checkDeepLinking(Context context, String str) {
        if (str.contains("paytmmp://weexoffer")) {
            Bundle bundle = new Bundle();
            bundle.putString("title", Uri.parse(str).getQueryParameter("title"));
            h.a aVar = h.f50349a;
            return h.a.a(context, str, bundle);
        }
        h.a aVar2 = h.f50349a;
        return h.a.a(context, str, (Bundle) null);
    }

    public CJRHomePageItem getDeeplinkDataItem(Context context, String str) {
        return ac.a(context, str);
    }

    public void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.b(str, map, context);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public String getStringFromGTM(String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public String getStringFromGTM(String str, String str2) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, str2);
    }

    public String getStringFromGTMContainer4(String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, "");
    }

    public boolean getBooleanFromGTM(String str, boolean z) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public int getIntFromGTM(String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, 0);
    }

    public Dialog getWalletStyleProgressDialog(Activity activity) {
        q qVar = q.f50365a;
        return q.a(activity);
    }

    public void loadDeeplink(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        net.one97.paytm.utils.j.a(context, str, iJRDataModel, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null, (net.one97.paytm.c) null);
    }

    public void invokeCstModule(Context context, CJROrderSummary cJROrderSummary, m mVar, Integer num) {
        CJROrderedCart cJROrderedCart;
        ArrayList<CJROrderedCart> orderedCartList;
        q qVar = q.f50365a;
        k.c(context, "context");
        k.c(cJROrderSummary, Payload.RESPONSE);
        k.c(mVar, "progressBarHandler");
        if (num == null) {
            num = 0;
        }
        Bundle bundle = null;
        if (cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null) {
            cJROrderedCart = null;
        } else {
            if (num == null) {
                k.a();
            }
            cJROrderedCart = orderedCartList.get(num.intValue());
        }
        if (cJROrderedCart != null) {
            cJROrderedCart.setOrderId(cJROrderSummary != null ? cJROrderSummary.getId() : null);
        }
        if (cJROrderedCart != null) {
            bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
            CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
            cJRReplacementReason.setParentIssueId(1000001);
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason);
        }
        if (bundle != null) {
            mVar.show();
            d.a(context, bundle, mVar);
        }
    }

    public String getOrderDetailUrl() {
        f.a.a aVar = f.a.a.f13515a;
        if (f.a.a.g() != null) {
            f.a.a aVar2 = f.a.a.f13515a;
            if (f.a.a.g().equalsIgnoreCase("group")) {
                net.one97.paytm.j.c.a();
                return net.one97.paytm.j.c.a("orderdetail", (String) null);
            }
        }
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.h();
    }

    public String getCartVerifyUrl() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("insuranceVerifyCart", (String) null);
    }

    public String getCartCheckoutUrl() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("insuranceCheckout", (String) null);
    }

    public Class getAJRRechargePaymentActivity() {
        return AJRRechargePaymentActivity.class;
    }

    public Class getAJRAuthActivity() {
        return AJRAuthActivity.class;
    }

    public String getAddressUrl() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("addressesV2", (String) null);
    }

    public void getWalletToken(String str, Activity activity, b bVar) {
        t.a(activity, bVar, a.c.INSURANCE);
    }

    public String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return t.a(cJRPGTokenList);
    }

    public Map<String, String> getHeader(Context context) {
        return t.e(context);
    }

    public String getAadhaarNumber(Context context) {
        q qVar = q.f50365a;
        return q.b(context);
    }

    public Intent getKycAddressIntent(Context context, int i2) {
        q qVar = q.f50365a;
        return q.a(context);
    }

    public void handleError(Activity activity, NetworkCustomError networkCustomError, String str, Bundle bundle, Boolean bool) {
        r.a(activity, (Exception) networkCustomError, (String) null, (Bundle) null);
    }

    public boolean reportError(Context context, NetworkCustomError networkCustomError, String str) {
        return r.a(context, (Exception) networkCustomError, "error.utilities@paytm.com");
    }

    public boolean checkErrorCode(Context context, Exception exc) {
        return r.a(context, exc);
    }

    public boolean containsError(CJRRechargeCart cJRRechargeCart, Context context) {
        return r.a(cJRRechargeCart, context);
    }

    public void clearRiskExtendedInfo() {
        net.one97.paytm.f.b.a().c();
    }

    public void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3) {
        net.one97.paytm.f.b.a().a(context, str, str2, z, str3, com.paytm.utility.a.g(context), com.paytm.utility.a.h(context));
    }

    public String getRiskExtendedInfoJson() {
        return net.one97.paytm.f.b.a().d();
    }

    public boolean handleDeepLink(Context context, String str, Bundle bundle) {
        h.a aVar = h.f50349a;
        return h.a.a(context, str, bundle);
    }

    public String getSSOToken(Context context) {
        return com.paytm.utility.a.q(context);
    }

    public String getUserId(Context context) {
        return com.paytm.utility.a.a(context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openOrderSummary(android.app.Activity r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            int r0 = r0.intValue()
            net.one97.paytm.insurance.b.d.a((int) r0)
            f.a.a r0 = f.a.a.f13515a
            java.lang.String r0 = f.a.a.b()
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            switch(r1) {
                case -1196055108: goto L_0x0051;
                case 106016069: goto L_0x0047;
                case 106016131: goto L_0x003d;
                case 1128214733: goto L_0x0033;
                case 1523927324: goto L_0x0029;
                case 1569159718: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x005b
        L_0x001f:
            java.lang.String r1 = "insurance_type_cycle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005b
            r0 = 3
            goto L_0x005c
        L_0x0029:
            java.lang.String r1 = "insurance_type_health"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005b
            r0 = 1
            goto L_0x005c
        L_0x0033:
            java.lang.String r1 = "insurance_type_new_vehicle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005b
            r0 = 4
            goto L_0x005c
        L_0x003d:
            java.lang.String r1 = "insurance_type_4w"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005b
            r0 = 2
            goto L_0x005c
        L_0x0047:
            java.lang.String r1 = "insurance_type_2w"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005b
            r0 = 5
            goto L_0x005c
        L_0x0051:
            java.lang.String r1 = "insurance_type_life"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005b
            r0 = 0
            goto L_0x005c
        L_0x005b:
            r0 = -1
        L_0x005c:
            if (r0 == 0) goto L_0x007e
            if (r0 == r7) goto L_0x007e
            if (r0 == r5) goto L_0x0076
            if (r0 == r4) goto L_0x0076
            if (r0 == r3) goto L_0x0076
            if (r0 == r2) goto L_0x0076
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.insurance.a.a r1 = net.one97.paytm.insurance.b.c.a()
            java.lang.Class r1 = r1.getAJROrderSummaryActivityClass()
            r0.<init>(r9, r1)
            goto L_0x0092
        L_0x0076:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.InsuranceOrderSummary> r1 = net.one97.paytm.InsuranceOrderSummary.class
            r0.<init>(r9, r1)
            goto L_0x0092
        L_0x007e:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.InsurancePostPaymentActivity> r1 = net.one97.paytm.InsurancePostPaymentActivity.class
            r0.<init>(r9, r1)
            net.one97.paytm.insurance.a.a r1 = net.one97.paytm.insurance.b.c.a()
            java.lang.String r1 = r1.getOrderDetailUrl()
            java.lang.String r2 = "insurance_post_payment_url"
            r0.putExtra(r2, r1)
        L_0x0092:
            java.lang.String r1 = "IS_MY_ORDER_SCREEN"
            r0.putExtra(r1, r7)
            java.lang.String r1 = "IS_SHOW_HOME"
            r0.putExtra(r1, r6)
            java.lang.String r1 = "insurance-retail"
            java.lang.String r2 = "INSURANCE_LABEL"
            r0.putExtra(r2, r1)
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r11)
            java.lang.String r11 = "insurance_type"
            r0.putExtra(r11, r10)
            java.lang.String r10 = "From"
            java.lang.String r11 = "Order_history"
            r0.putExtra(r10, r11)
            r9.startActivityForResult(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.insurance.InsuranceImplProvider.openOrderSummary(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        r.a(activity, str, bundle);
    }

    public String getEmbedWebViewClassName() {
        return AJREmbedWebView.class.getName();
    }

    public void sendOpenScreenEvent(Context context, String str) {
        net.one97.paytm.j.a.b(context, str);
    }

    public void launchH5Page(Context context) {
        String str;
        net.one97.paytm.insurance.b.a.a();
        if (!TextUtils.isEmpty(net.one97.paytm.insurance.b.a.a("MyInsuranceMweb"))) {
            net.one97.paytm.insurance.b.a.a();
            str = net.one97.paytm.insurance.b.a.a("MyInsuranceMweb");
        } else {
            str = "";
        }
        u.a().a("insurance", "bdb415ca7bdaad7236801351d7e0a41c50793d73", str, (Bundle) null, (String) null, context);
    }

    public void openPaymentPage(final Activity activity, final CJRRechargePayment cJRRechargePayment) {
        if ("1".equals(cJRRechargePayment.isNativeEnabled())) {
            t.a(activity.getApplicationContext(), cJRRechargePayment, (FetchPayOptionsListener) new FetchPayOptionsListener() {
                public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
                }

                public void onRequestStart() {
                }

                public void onVpaReceived(VpaFetch vpaFetch) {
                }

                public void onPaymentOptionsError() {
                    InsuranceImplProvider.this.hitPg(activity, cJRRechargePayment);
                }

                public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                    PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                    InsuranceImplProvider.this.hitPg(activity, cJRRechargePayment);
                }
            });
        } else {
            hitPg(activity, cJRRechargePayment);
        }
    }

    /* access modifiers changed from: private */
    public void hitPg(Activity activity, CJRRechargePayment cJRRechargePayment) {
        Intent intent = new Intent(activity, AJRRechargePaymentActivity.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra(UpiConstants.FROM, "Insurance");
        intent.putExtra("FROM_INSURANCE_SCREEN", true);
        f.a.a aVar = f.a.a.f13515a;
        intent.putExtra("insurance_type", f.a.a.c());
        f.a.a aVar2 = f.a.a.f13515a;
        intent.putExtra("product_name", f.a.a.g());
        q qVar = q.f50365a;
        q.a(intent, cJRRechargePayment);
        activity.startActivityForResult(intent, 344);
    }

    public void signOut(Activity activity, boolean z, VolleyError volleyError) {
        net.one97.paytm.auth.b.b.a(activity, false);
    }
}
