package net.one97.paytm.paymentsBank.h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2;
import net.one97.paytm.common.entity.IJRDataModel;

public interface a {
    void callWalletInfoLoginActivity(Activity activity);

    void checkDeepLink(Context context, String str);

    boolean checkDeepLinking(Context context, String str);

    void checkRiskInformationAvaiable(Map<String, String> map);

    Class getAJRConfirmIFSCActivityClass();

    Class getAJREnterPasscodeClass();

    Class getAJRForgotPasscodeClass();

    Class getAJRForgotPasswordClass();

    Class getAJRSetPasscodeClass();

    Class getAddMoneyToPPBActivityClass();

    Context getApplicationContext();

    ContextWrapper getBaseContext(Context context);

    boolean getBooleanFromGTM(String str, boolean z);

    String getBuildConfigBuildType();

    String getClient();

    Class getEmbeddedWebViewActivityClass();

    String getFetchStrategyParamsForUserInfo();

    Class getInfoActivityClass();

    int getIntFromGTM(String str);

    Class getMainActivityClass();

    Class getMoneyTransferActivityClass();

    Class getMoneyTransferActivityV3Class();

    void getNameFromKyc(Context context, d dVar);

    Class getNearByMainActivityClass();

    String getNonPersonalisedPDCProductId();

    void getPanCardNumber(Context context, d dVar);

    Class getPassbookMainActivityClass();

    Class getPaySendActivityClass();

    String getPersonalisedPDCProductId();

    Bitmap getQRCodeBitmap(String str, Activity activity);

    void getQRCodeBitmap(ImageView imageView, String str, Context context);

    String getStringFromGTM(String str);

    Class getTransferToBankActivityClass();

    void handleSessionTimeOut(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2);

    void initBottomBar(View view, Context context, d dVar);

    boolean isInstanceOfAJRMainActivity(Activity activity);

    void launchMainActivityWithBankTab(Activity activity);

    void loadPageActivityNavigation(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList arrayList, boolean z, String str3, Object obj);

    void openCST(Context context, String str);

    void openCstWithBundle(Context context, Bundle bundle);

    void openDbt(Context context, String str);

    void openEmailUpdatePage(Context context, CJRUserInfoV2 cJRUserInfoV2);

    void openHelpAndSupport(Context context, boolean z);

    void openICAAccountStatementPage(Context context);

    void openInnerSavingAccPasscodeActivity(Context context, String str, String str2, String str3, String str4);

    void openLandingActivity(Activity activity);

    void openLanguageChangeActivity(Activity activity);

    void openMainActivityFromSessionOut(Activity activity, String str, Bundle bundle, boolean z, boolean z2);

    void openManageBeneficiary(Activity activity);

    void openPanCardDeeplink(Context context, boolean z);

    void openPaySendActivityForActivatingPDC(Context context);

    void openProfile(Activity activity);

    void openSavingPassbookWithBalance(Context context, String str, String str2);

    void openStatements(Context context);

    void openUPIActivity(Context context, String str, String str2, d dVar);

    void openWebViewActivity(Context context, String str, String str2);

    void openYoutubePlayerFragment(Context context, String str);

    void putConvertedCustProductListonIntent(Intent intent, String str, CustProductList custProductList);

    void putConvertedISADetailsonIntent(Intent intent, String str, IsaDetailsModel isaDetailsModel);

    void saveUserInfo(CJRUserInfoV2 cJRUserInfoV2, Context context);

    void sendCustomEventWithMap(String str, Map<String, Object> map, Context context);

    void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

    void setBankPassCodeInAJRMainActivity(Activity activity, boolean z);

    void setPassCodeConsentSuccess();

    boolean showBankPassCode(Activity activity);

    void showSessionTimeOutAlert(Activity activity, String str, Bundle bundle, VolleyError volleyError);

    boolean showUPILinkingFragment(Fragment fragment, int i2);

    void signOutNetworkCustomError(Activity activity, boolean z, NetworkCustomError networkCustomError);
}
