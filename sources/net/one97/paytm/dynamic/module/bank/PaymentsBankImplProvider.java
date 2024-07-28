package net.one97.paytm.dynamic.module.bank;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJRForgotPassword;
import net.one97.paytm.AJRWebViewActivity;
import net.one97.paytm.AJRYoutubeVideoPlay;
import net.one97.paytm.EmailMobileActivity;
import net.one97.paytm.addmoney.d;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.auth.b.b;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.model.CJRPGTokenList;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.managebeneficiary.ManageWalletBeneficiaryActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.activity.AJREnterPasscode;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.payments.activity.AJRSetPasscode;
import net.one97.paytm.paymentsBank.fragment.k;
import net.one97.paytm.paymentsBank.h.a;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upgradeKyc.activity.WalletUpgradedSuccessActivity;
import net.one97.paytm.upgradeKyc.f.c;
import net.one97.paytm.upi.UpiAddBankHelperActivity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.registration.view.v;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.activity.AJRConfirmIFSCActivity;
import net.one97.paytm.wallet.newdesign.acceptmoney.InfoActivity;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.nearby.NearByMainActivity;

public class PaymentsBankImplProvider implements a {
    private static PaymentsBankImplProvider mInstance;

    public Class<?> getAccountProviderActivityClass() {
        return null;
    }

    public Fragment getAddMoneyFailureFragment() {
        return null;
    }

    public Fragment getAddMoneySuccessFragment() {
        return null;
    }

    public String getBuildConfigFlavour() {
        return "paytm";
    }

    public String getClient() {
        return "androidapp";
    }

    public String getFetchStrategyParamsForUserInfo() {
        return "?fetch_strategy=DEFAULT,USERID,USER_TYPE,USER_CREDENTIAL,USER_ATTRIBUTE";
    }

    public Class getMoneyTransferActivityClass() {
        return null;
    }

    public String getNonPersonalisedPDCProductId() {
        return "146203608";
    }

    public void getPanCardNumber(Context context, d dVar) {
    }

    public Class getPassbookMainActivityClass() {
        return null;
    }

    public String getPersonalisedPDCProductId() {
        return "146203609";
    }

    public Class getTransferToBankActivityClass() {
        return null;
    }

    public void getWalletToken(String str, Activity activity, Response.Listener<IJRDataModel> listener, Response.ErrorListener errorListener) {
    }

    public boolean isBankEnabled() {
        return true;
    }

    private PaymentsBankImplProvider() {
    }

    public static void init() {
        if (mInstance == null) {
            mInstance = new PaymentsBankImplProvider();
            initH5();
        }
        o.a(mInstance);
    }

    private static void initH5() {
        try {
            u.a();
            u.a((Application) CJRJarvisApplication.getAppContext());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private static String getAddPanDeeplink(String str, String str2, boolean z) throws UnsupportedEncodingException {
        return net.one97.paytm.payments.d.a.a() + "add_pan?call_back_url=" + URLEncoder.encode(str, AppConstants.UTF_8) + "&vertical=" + str2 + "&form_60=" + z;
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

    public ContextWrapper getBaseContext(Context context) {
        return e.a(context);
    }

    public boolean checkDeepLinking(Context context, String str) {
        h.a aVar = h.f50349a;
        return h.a.a(context, str, (Bundle) null);
    }

    public void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.a(str, str2, context, "signal");
    }

    public String getStringFromGTM(String str) {
        c.a();
        return c.a(str, (String) null);
    }

    public boolean getBooleanFromGTM(String str, boolean z) {
        c.a();
        return c.a(str, z);
    }

    public int getIntFromGTM(String str) {
        c.a();
        return c.a(str, 0);
    }

    public void showNetworkDialog(j jVar) {
        k.a().show(jVar.a(), "dialog");
    }

    public void openWebViewActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, AJRWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        context.startActivity(intent);
    }

    public void signOutNetworkCustomError(Activity activity, boolean z, NetworkCustomError networkCustomError) {
        b.a(activity);
    }

    public void openMainActivityFromSessionOut(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        Intent intent = new Intent(activity, AJRAuthActivity.class);
        intent.putExtra("authError", true);
        if (str != null) {
            intent.putExtra("resultant activity", str);
            intent.putExtra("sign_in_sign_up_with_step_2", true);
            if (bundle != null) {
                intent.putExtra("resultant activity_bundle", bundle);
            }
        }
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        if (z) {
            activity.startActivityForResult(intent, 3);
            return;
        }
        activity.startActivity(intent);
        if (!(activity instanceof AJRMainActivity) && z2) {
            activity.finish();
        }
    }

    public void openPaySendActivityForActivatingPDC(Context context) {
        ae aeVar = ae.f50307a;
        kotlin.g.b.k.c(context, "context");
        Intent intent = new Intent(context, PaySendActivityV2.class);
        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
        intent.putExtra("barcode_only", false);
        ae.a(intent, context);
    }

    public void openCST(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_from_upi", true);
        bundle.putString("ACCOUNT_NUMBER", str);
        net.one97.paytm.deeplink.d.b(context, bundle);
    }

    public void openYoutubePlayerFragment(Context context, String str) {
        Intent intent = new Intent(context, AJRYoutubeVideoPlay.class);
        String e2 = com.paytm.utility.b.e(str);
        if (e2 == null) {
            e2 = com.paytm.utility.b.f(str);
        }
        if (!TextUtils.isEmpty(e2)) {
            intent.putExtra(net.one97.paytm.bankCommon.mapping.b.aN, e2);
            context.startActivity(intent);
        }
    }

    public void saveUserInfo(CJRUserInfoV2 cJRUserInfoV2, Context context) {
        l.a((net.one97.paytm.common.entity.CJRUserInfoV2) net.one97.paytm.paymentsBank.utils.j.a((Object) cJRUserInfoV2, net.one97.paytm.common.entity.CJRUserInfoV2.class), context);
    }

    public Class getMainActivityClass() {
        return AJRMainActivity.class;
    }

    public Class getMoneyTransferActivityV3Class() {
        return MoneyTransferV3Activity.class;
    }

    public Class getAJRForgotPasscodeClass() {
        return AJRForgotPasscode.class;
    }

    public Class getAJRSetPasscodeClass() {
        return AJRSetPasscode.class;
    }

    public Class getAJREnterPasscodeClass() {
        return AJREnterPasscode.class;
    }

    public static boolean isStaging() {
        c.a();
        String a2 = c.a("ppb_unblock_card", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            return a2.startsWith("https://product-ite.paytmbank.com");
        }
        return false;
    }

    public void getNameFromKyc(Context context, final d dVar) {
        net.one97.paytm.upgradeKyc.f.c a2 = net.one97.paytm.upgradeKyc.f.c.a();
        AnonymousClass1 r1 = new c.b() {
            public void onNameInitialize(String str) {
                dVar.onFragmentAction(1, str);
            }

            public void onNameInitializationError(String str) {
                dVar.onFragmentAction(2, str);
            }
        };
        if (context != null) {
            a2.f65977d = true;
            a2.a(context, (c.b) r1);
        }
    }

    public void initBottomBar(View view, Context context, d dVar) {
        net.one97.paytm.landingpage.hometabs.a.a();
        net.one97.paytm.landingpage.hometabs.a.b();
        l.a((ViewGroup) (LinearLayout) view);
    }

    public String getBuildConfigBuildType() {
        return isStaging() ? SDKConstants.KEY_STAGING_API : "release";
    }

    public void loadPageActivityNavigation(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList arrayList, boolean z, String str3, Object obj) {
        net.one97.paytm.utils.j.a(context, str, iJRDataModel, str2, i2, (ArrayList<? extends CJRItem>) arrayList, z, str3, (net.one97.paytm.c) null);
    }

    public Class getPaySendActivityClass() {
        return PaySendActivityV2.class;
    }

    public Class getInfoActivityClass() {
        return InfoActivity.class;
    }

    /* access modifiers changed from: private */
    public void fetchUpiProfileAndAddBank(final Context context, String str, String str2) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.please_wait));
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        g.a().a((a.C1382a) new a.C1382a() {
            public void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                ProgressDialog progressDialog = progressDialog;
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (!"success".equalsIgnoreCase(upiProfileModel.getStatus())) {
                        Toast.makeText(context, R.string.some_went_wrong, 1).show();
                    } else if (upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() == null) {
                        Toast.makeText(context, R.string.some_went_wrong, 1).show();
                    } else {
                        for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                            if (next.isPrimary()) {
                                String virtualAddress = next.getVirtualAddress();
                                UpiAddBankHelperActivity.a aVar = UpiAddBankHelperActivity.f66481a;
                                UpiAddBankHelperActivity.a.a(context, virtualAddress);
                                return;
                            }
                        }
                    }
                }
            }

            public void onError(UpiCustomVolleyError upiCustomVolleyError) {
                ProgressDialog progressDialog = progressDialog;
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                Toast.makeText(context, R.string.some_went_wrong, 1).show();
            }
        }, str, str2);
    }

    public Class getAddMoneyToPPBActivityClass() {
        d.a aVar = net.one97.paytm.addmoney.d.f48562a;
        d.a.a();
        return net.one97.paytm.addmoney.d.c();
    }

    public Class getPassbookSubwalletActivityClass() {
        return AJRMainActivity.class;
    }

    public void openPassbookActivity(Context context, boolean z) {
        if (z) {
            net.one97.paytm.payments.d.a.a(context, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet");
        } else {
            net.one97.paytm.payments.d.a.a(context, "paytmmp://cash_wallet?featuretype=cash_ledger");
        }
    }

    public void openStatements(Context context) {
        net.one97.paytm.payments.d.a.a(context, "paytmmp://passbook?featuretype=statement&type=ppbl");
    }

    public void openProfile(Activity activity) {
        checkDeepLink(activity, "paytmmp://bank_profile");
    }

    public void openLanguageChangeActivity(Activity activity) {
        net.one97.paytm.payments.d.a.a(activity, "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MvcHJlZmVycmVkLWxhbmd1YWdlIiwic3BhcmFtcyI6eyJjYW5QdWxsRG93biI6ZmFsc2UsInB1bGxSZWZyZXNoIjpmYWxzZSwic2hvd1RpdGxlQmFyIjpmYWxzZX19&url=https://paytm.com");
    }

    public Class getEmbeddedWebViewActivityClass() {
        return AJREmbedWebView.class;
    }

    public void openHelpAndSupport(Context context, boolean z) {
        l.e(context);
    }

    public Class getRedeemFixedDepositActivityClass() {
        return AJRMainActivity.class;
    }

    public void openSavingPassbookWithBalance(Context context, String str, String str2) {
        net.one97.paytm.payments.d.a.a(context, "paytmmp://cash_wallet?featuretype=cash_ledger&open_source=bank");
    }

    public void openInnerSavingAccPasscodeActivity(Context context, String str, String str2, String str3, String str4) {
        if ("ICA".equalsIgnoreCase(str4)) {
            net.one97.paytm.payments.d.a.a(context, String.format("paytmmp://cash_wallet?featuretype=cash_ledger&tab=ica&accountNumber=%s&balance=%s&totalBalance=%s", new Object[]{str2, str, str3}));
            return;
        }
        net.one97.paytm.payments.d.a.a(context, String.format("paytmmp://cash_wallet?featuretype=cash_ledger&tab=savings&accountNumber=%s&balance=%s&totalBalance=%s", new Object[]{str2, str, str3}));
    }

    public boolean showUPILinkingFragment(Fragment fragment, int i2) {
        try {
            v b2 = v.b("saved_payment", false);
            if (v.a((Context) fragment.getActivity())) {
                fragment.getChildFragmentManager().a().b(i2, b2, (String) null).c();
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void getQRCodeBitmap(ImageView imageView, String str, Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                imageView.setImageBitmap(com.google.zxing.client.android.d.a.a(str, 400, 400, false));
            } catch (Exception unused) {
            }
        }
    }

    public void openCstWithBundle(Context context, Bundle bundle) {
        net.one97.paytm.deeplink.d.a(context, bundle);
    }

    public void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        net.one97.paytm.j.a.b(context, str, str2, str3, str4, str5, str6, str7, "signal");
    }

    public void openICAAccountStatementPage(Context context) {
        net.one97.paytm.payments.d.a.a(context, "paytmmp://passbook?featuretype=statement&type=ppblICA");
    }

    public void openPanCardDeeplink(Context context, boolean z) {
        try {
            net.one97.paytm.payments.d.a.a(context, getAddPanDeeplink("", "kyc", false));
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
        }
    }

    public void checkDeepLink(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public boolean isWalletUpgradedSuccessActivity(Activity activity) {
        return activity instanceof WalletUpgradedSuccessActivity;
    }

    public boolean isInstanceOfAJRMainActivity(Activity activity) {
        return activity instanceof AJRMainActivity;
    }

    public boolean showBankPassCode(Activity activity) {
        if (activity instanceof AJRMainActivity) {
            return ((AJRMainActivity) activity).f52663a;
        }
        return false;
    }

    public void setBankPassCodeInAJRMainActivity(Activity activity, boolean z) {
        ((AJRMainActivity) activity).f52663a = z;
    }

    public void launchAJRSetPasscode(Activity activity, int i2) {
        activity.startActivityForResult(new Intent(activity, AJRSetPasscode.class), i2);
    }

    public Class getNearByMainActivityClass() {
        return NearByMainActivity.class;
    }

    public Class getAJRConfirmIFSCActivityClass() {
        return AJRConfirmIFSCActivity.class;
    }

    public Class getAJRCSTOrderIssuesActivity() {
        try {
            return Class.forName("net.one97.paytm.cst.activity.AJRCSTOrderIssues");
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public void showSessionTimeOutAlert(Activity activity, String str, Bundle bundle, VolleyError volleyError) {
        r.a(activity, str, bundle);
    }

    public String getWalletSSOToken(Context context) {
        return t.c(context);
    }

    public String getResourceId(CJRPGTokenList cJRPGTokenList) {
        return t.b((net.one97.paytm.common.entity.CJRPGTokenList) net.one97.paytm.paymentsBank.utils.j.a((Object) cJRPGTokenList, net.one97.paytm.common.entity.CJRPGTokenList.class));
    }

    public String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return t.a((net.one97.paytm.common.entity.CJRPGTokenList) net.one97.paytm.paymentsBank.utils.j.a((Object) cJRPGTokenList, net.one97.paytm.common.entity.CJRPGTokenList.class));
    }

    public void callWalletInfoLoginActivity(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, AJRAuthActivity.class);
            intent.putExtra("launchSignUp", false);
            intent.putExtra("set_result_required", true);
            intent.putExtra("VERTICAL_NAME", "Wallet");
            activity.startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
        }
    }

    public void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        net.one97.paytm.j.a.b(context, str, str2, str3, str4, str5, str6, "signal");
    }

    public void putConvertedCustProductListonIntent(Intent intent, String str, CustProductList custProductList) {
        intent.putExtra(str, (Serializable) net.one97.paytm.paymentsBank.utils.j.a((Object) custProductList, net.one97.paytm.common.entity.paymentsbank.CustProductList.class));
    }

    public void putConvertedISADetailsonIntent(Intent intent, String str, IsaDetailsModel isaDetailsModel) {
        intent.putExtra(str, (Serializable) net.one97.paytm.paymentsBank.utils.j.a((Object) isaDetailsModel, IsaDetailsModel.class));
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.a(str, map, context, "signal");
    }

    public Class getAJRForgotPasswordClass() {
        return AJRForgotPassword.class;
    }

    public void checkRiskInformationAvaiable(Map<String, String> map) {
        if (net.one97.paytm.f.b.a().f50402a != null && net.one97.paytm.f.b.a().f50403b) {
            map.put("risk_extended_info", new f().a((Object) net.one97.paytm.f.b.a().f50402a, new com.google.gson.b.a<RiskExtendedInfo>() {
            }.getType()));
        }
    }

    public void launchMainActivityWithBankTab(Activity activity) {
        Intent intent = new Intent(activity, AJRMainActivity.class);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    public void openEmailUpdatePage(Context context, CJRUserInfoV2 cJRUserInfoV2) {
        Intent intent = new Intent(context, EmailMobileActivity.class);
        intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, cJRUserInfoV2.getUserDefaultInfo().getEmail());
        intent.putExtra("extra_home_data", (Serializable) net.one97.paytm.paymentsBank.utils.j.a((Object) cJRUserInfoV2, net.one97.paytm.common.entity.CJRUserInfoV2.class));
        intent.putExtra("mobile_email", com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL);
        ((Activity) context).startActivityForResult(intent, 211);
    }

    public void openDbt(Context context, String str) {
        DbtUtils.INSTANCE.openDbt(context, str);
    }

    public void handleSessionTimeOut(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2) {
        r.a(activity, str, bundle, z, z2);
    }

    public void setPassCodeConsentSuccess() {
        net.one97.paytm.n.e eVar = net.one97.paytm.n.e.f55762a;
        net.one97.paytm.n.e.e();
    }

    public Bitmap getQRCodeBitmap(String str, Activity activity) {
        try {
            return com.google.zxing.client.android.d.a.a(str, 400, 400, false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void openManageBeneficiary(Activity activity) {
        activity.startActivity(new Intent(activity, ManageWalletBeneficiaryActivity.class));
    }

    public void openUPIActivity(Context context, String str, String str2, net.one97.paytm.bankCommon.f.d dVar) {
        final net.one97.paytm.bankCommon.f.d dVar2 = dVar;
        final Context context2 = context;
        final String str3 = str;
        final String str4 = str2;
        g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)).e(new a.C1389a() {
            public void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                net.one97.paytm.bankCommon.f.d dVar = dVar2;
                if (dVar != null) {
                    dVar.onFragmentAction(1, (Object) null);
                }
                if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel.getResponse() == null) {
                        return;
                    }
                    if (upiAvailabilityModel.getResponse().isUpiUser()) {
                        if (!upiAvailabilityModel.getResponse().ismBankAccountAdded()) {
                            PaymentsBankImplProvider.this.fetchUpiProfileAndAddBank(context2, str3, str4);
                            return;
                        }
                        Intent intent = new Intent(context2, UpiLandingPageActivity.class);
                        intent.putExtra(UpiConstants.FROM, 100);
                        context2.startActivity(intent);
                    } else if (upiAvailabilityModel.getResponse().isUpiProfileExist()) {
                        Context context = context2;
                        context.startActivity(UpiUtils.getUpiLandingPageActivityIntentWithoutRedirection(context));
                    } else {
                        Intent intent2 = new Intent(context2, UpiSelectBankActivity.class);
                        intent2.putExtra(UpiConstants.FROM, 100);
                        context2.startActivity(intent2);
                    }
                } else {
                    net.one97.paytm.bankCommon.f.d dVar2 = dVar2;
                    if (dVar2 != null) {
                        dVar2.onFragmentAction(2, (Object) null);
                    }
                }
            }

            public void onError(UpiCustomVolleyError upiCustomVolleyError) {
                net.one97.paytm.bankCommon.f.d dVar = dVar2;
                if (dVar != null) {
                    dVar.onFragmentAction(2, (Object) null);
                }
            }
        }, str, str2);
    }
}
