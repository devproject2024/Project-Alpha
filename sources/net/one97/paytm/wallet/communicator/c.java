package net.one97.paytm.wallet.communicator;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.postpaid.CJRPPAccount;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateDataModel;
import net.one97.paytm.m;
import net.one97.paytm.network.e;
import net.one97.paytm.p2mNewDesign.models.QrData;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.wallet.f.p;
import net.one97.paytm.wallet.newdesign.addbeneficiary.h;

public interface c {
    boolean a(Context context, String str);

    void addBeneficiaryAPICall(Context context, String str, h hVar, CJRAddBeneficiary cJRAddBeneficiary, Map<String, String> map, String str2);

    String addBeneficiaryURL(Activity activity);

    void callLoginActivity(Activity activity);

    void callVerifierIntent(Activity activity, CJRIMPSInitiateDataModel cJRIMPSInitiateDataModel);

    void checkAppCompatTheme(Context context);

    void checkDeepLinking(Context context, String str);

    void checkDeepLinking(Context context, String str, String str2) throws UnsupportedEncodingException;

    boolean checkErrorCode(Activity activity, NetworkCustomError networkCustomError);

    void checkPPBUpdateBalance(Context context, net.one97.paytm.wallet.newdesign.c.c cVar, String str, String str2, String str3);

    String contactExists(Activity activity, String str);

    String deeplinkSchemaName();

    Application getApplication();

    String getApplicationId();

    Class<?> getAuthActivityClass();

    Intent getBRTSIntent(Context context, IJRDataModel iJRDataModel);

    String getBankRSAKey();

    boolean getBooleanFromGTM(Context context, String str, boolean z);

    String getBuildType();

    Class getCarInfoActivityClass();

    View getCashbackView(Context context, String str);

    String getClientId();

    String getContactName(Context context, String str);

    Context getContext();

    void getCstOrderIssueIntent(Context context, Bundle bundle, m mVar);

    String getCurrentDateAndTimeFromUpiUtils();

    CJRHomePageItem getDeeplinkDataItem(Context context, String str);

    String getDeeplinkSchemeID();

    Intent getEnterPasscodeIntent(Activity activity);

    void getForgotPasscodeIntent(Context context);

    String getGoldPortFolioURL(Context context);

    Class getHealthInsPreQuoteActivityClass();

    int getIntegerFromGTM(Context context, String str);

    int getIntegerFromGTM(String str, int i2);

    Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem);

    boolean getIsMinKyc(Context context);

    String getJWTToken(Map<String, Object> map, Map<String, Object> map2, String str, String str2);

    int getKYCExpriy(Context context);

    int getKYCUserStatus(Context context);

    long getLongFromGTM(Context context, String str);

    Class<?> getMainActivityClass();

    Intent getMoneyTransferIntent(Context context);

    Intent getPaymentReminderCreationActivity(Context context);

    Intent getPaymentSuccessIntent(Context context);

    String getPgToken(CJRPGTokenList cJRPGTokenList);

    Fragment getPostPaymentDealsFragment();

    Intent getRechargeActivityIntent(Context context);

    String getSchema();

    int getScpAnimation();

    Fragment getSfBannerFragment(Activity activity, View view, String str, a.c cVar);

    Class getShopInsLandingActivityClass();

    String getShowCodeRSAKey();

    String getStringFromGTM(Context context, String str);

    String getTokenUrl();

    Class<?> getTrustSealActivity();

    String getUpgradeKycDeeplink(String str, String str2, boolean z, boolean z2) throws UnsupportedEncodingException;

    void getUserVpaInfo(Context context, p pVar);

    String getValidateBeneficiaryUrl(Context context);

    Intent getVerifyPasscodeActivity(Activity activity, Intent intent);

    String getVersionName();

    String getWalletSSOToken(Context context);

    void getWalletToken(String str, Activity activity, b bVar);

    long getWalletTokenExpireTime(Context context);

    Intent getWebViewIntent(Context context);

    boolean handleDeepLink(Context context, String str, Bundle bundle);

    boolean handleDeeplinkByEngine(Activity activity, String str, Bundle bundle);

    void handleDeeplinkByMall(Context context, CJRHomePageItem cJRHomePageItem, String str, String str2, String str3, String str4, String str5);

    void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z);

    void handlePrimeIntent(Context context, CJRHomePageItem cJRHomePageItem);

    void handleSessionTimeout(Activity activity, Exception exc, String str, Bundle bundle, boolean z);

    void handleSessionTimeout(Activity activity, Exception exc, String str, Bundle bundle, boolean z, boolean z2);

    boolean handleUPIDeepLink(Activity activity, String str, boolean z, Long l, boolean z2, Long l2);

    boolean initializeCashbackJarvisHelper();

    boolean instanceOfAddToPPB(Activity activity);

    boolean instanceOfIDPostcardActiovity(Activity activity);

    boolean instanceOfTransferToBank(Activity activity);

    void interceptHttpRequestResponse(e eVar);

    boolean isAppAccepted(CJRPPAccount cJRPPAccount);

    boolean isAppConfirmed(CJRPPAccount cJRPPAccount);

    boolean isAppRejected(CJRPPAccount cJRPPAccount);

    boolean isBranchShareUrl(String str);

    boolean isFromAppEvoke(Activity activity);

    boolean isFromMainActivity(Activity activity);

    boolean isMall();

    boolean isMinKycDone(Context context);

    boolean isPPBCustomer(Context context);

    boolean isPaymentBankUser(Context context);

    void isValidBharatQRCode(Context context, String str, boolean z, Long l, boolean z2, Long l2, int i2) throws Exception;

    boolean isVscpEnabled(Context context);

    IJRPaytmDataModel jsonToModel(String str);

    void markAsPaid(String str, String str2, boolean z, Context context);

    String maskNumber(String str);

    void onAddMoneyIntent(Context context, CJRHomePageItem cJRHomePageItem);

    boolean onInsuranceIntent(Context context);

    void onMoneyTransferIntent(Context context);

    void onPostcardIntent(Context context);

    void openAddMoneyScreen(Activity activity);

    void openEDCReceiptActivity(Context context, String str);

    void openH5(Activity activity, Bundle bundle, m mVar);

    Intent openManageBeneficiaryIntent(Context context);

    void openPaytmInviteScreen(Context context, String str, String str2);

    void openScreenViaDeeplink(Context context, String str);

    void pushClickOnPayHawkeyeEvent(Context context, String str, long j);

    void pushCrashEventToCrashlytics(String str, String str2, Throwable th);

    void pushHawkeyeEvent(Context context, int i2, String str, String str2, String str3, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar);

    void pushScanCodeHawkeyeEvent(Context context, QrData qrData);

    void pushScanSessionHawkeyeEvent(Context context, QrData qrData);

    boolean reportError(Context context, NetworkCustomError networkCustomError, String str);

    void sendCustomEventWithMap(String str, Map<String, Object> map, Context context);

    void sendCustomGTMEvent(Context context, String str, Map<String, Object> map);

    void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void sendCustomGTMEvents(String str, String str2, String str3, String str4, Context context, String str5, String str6);

    void sendDeeplinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context);

    void sendGTMOpenScreenWithDeviceInfo(Context context, String str, String str2);

    void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, Object obj, Object obj2, String str5, String str6);

    void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5);

    void sendPaymentSessionEvent(Context context, QrData qrData);

    void setBankAccStatus(Activity activity, CustProductList custProductList);

    void setInsuranceType(int i2);

    void setKYCUserStatus(Activity activity, int i2);

    void shareBranchLink(Activity activity, boolean z, String str);

    void showJewellerPriceAlert(Context context, String str);

    void showP2PSnackBar(Context context, ViewGroup viewGroup, String str);

    void showSessionTimeoutAlert(Activity activity);

    boolean showSetReminderView(String str, String str2);

    void showSnackBar(Context context, String str, String str2, Fragment fragment);

    void showToolTipView(AppCompatActivity appCompatActivity, View view, int i2, String str, int i3, int i4, boolean z);

    void signOut(Activity activity);

    void signOut(Activity activity, boolean z, NetworkCustomError networkCustomError);

    void startHelpAndSupport(Context context);

    void startMTFromDeeplink(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2);

    void startMTFromScan(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2);

    void startManageBeneficiary(Activity activity);

    void startMoneyTransferActivity(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2);

    void startMoneyTransferActivity(Context context, boolean z, Bundle bundle);

    void startMoneyTransferActivityForPayResult(Activity activity, int i2, IJRDataModel iJRDataModel, String str, String str2, int i3);

    void startMoneyTransferActivityForResult(Activity activity, int i2, IJRDataModel iJRDataModel, String str, String str2, int i3);

    void startMoneyTransferActivityForResult(Activity activity, IJRDataModel iJRDataModel, int i2);

    void startMoneyTransferFromPay(Context context, int i2, IJRDataModel iJRDataModel, String str, String str2);

    void startPassbookSubwalletActivity(Activity activity);

    void startQRDisplayActivity(Context context, Double d2, String str);

    void startSetMpinActivity(UpiProfileDefaultBank upiProfileDefaultBank, Activity activity);

    Context wrapContextByRestring(Context context);

    /* renamed from: net.one97.paytm.wallet.communicator.c$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$a(c _this, Context context, String str) {
            try {
                String stringFromGTM = b.a().getStringFromGTM(context, "whiteListedMallH5Domains");
                if (TextUtils.isEmpty(stringFromGTM)) {
                    return false;
                }
                Uri parse = Uri.parse(str);
                if (!(TextUtils.isEmpty(stringFromGTM) || parse == null || parse.getHost() == null)) {
                    return stringFromGTM.contains("\"" + parse.getHost() + "\"");
                }
                return false;
            } catch (Exception unused) {
            }
        }
    }
}
