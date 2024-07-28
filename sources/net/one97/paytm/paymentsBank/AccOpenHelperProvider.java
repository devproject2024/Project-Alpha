package net.one97.paytm.paymentsBank;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.Map;
import net.one97.paytm.bankOpen.c;
import net.one97.paytm.bankOpen.c.a;
import net.one97.paytm.bankOpen.d;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.payments.model.CJROauthAadharValidate;
import net.one97.paytm.paymentsBank.model.slfd.SlfdListModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionModel;
import net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse;
import net.one97.paytm.paymentsBank.si.response.AllSIResponse;
import net.one97.paytm.paymentsBank.si.response.SIActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SICreationResponse;
import net.one97.paytm.paymentsBank.si.response.SIDeActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SIDeleteResponse;
import net.one97.paytm.paymentsBank.si.response.SIPrevalidateResponse;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDPostTransactionModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDTrialRedeemAmount;
import net.one97.paytm.paymentsBank.slfd.tds.modal.CertificateResponseModal;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;

public class AccOpenHelperProvider implements c, d {
    private static AccOpenHelperProvider mInstance;
    private boolean isBankAccOpen = false;

    public boolean canHandlePostAccOpenCall() {
        return false;
    }

    public String getAppChannel() {
        return UpiConstants.B2C_ANDROID;
    }

    public void onAccountCreated(Context context, Object obj) {
    }

    public boolean showPasscodeScreen(Context context) {
        return true;
    }

    private AccOpenHelperProvider() {
    }

    public static void init() {
        if (mInstance == null) {
            mInstance = new AccOpenHelperProvider();
        }
        f.a(mInstance);
    }

    public Class<?> getTransferToBankActivityClass() {
        return o.a().getTransferToBankActivityClass();
    }

    public Class<?> getMainActivityClass() {
        return o.a().getMainActivityClass();
    }

    public void openLandingActivity(Activity activity) {
        o.a().openLandingActivity(activity);
    }

    public a getAppType() {
        return a.PAYTMAPP;
    }

    public void signOutNetworkCustomError(Activity activity, boolean z, NetworkCustomError networkCustomError) {
        o.a().signOutNetworkCustomError(activity, z, networkCustomError);
    }

    public void openMainActivityFromSessionOut(Activity activity, String str, Bundle bundle, boolean z, boolean z2) {
        o.a().openMainActivityFromSessionOut(activity, str, bundle, z, z2);
    }

    public Context getApplicationContext() {
        return o.a().getApplicationContext();
    }

    public Context getBaseContext(Context context) {
        return o.a().getBaseContext(context);
    }

    public String getBuildConfigBuildType() {
        return o.a().getBuildConfigBuildType();
    }

    public String getStringFromGTM(String str) {
        return o.a().getStringFromGTM(str);
    }

    public boolean getBooleanFromGTM(String str, boolean z) {
        return o.a().getBooleanFromGTM(str, z);
    }

    public int getIntFromGTM(String str) {
        return o.a().getIntFromGTM(str);
    }

    public void openYoutubePlayerFragment(Context context, String str) {
        o.a().openYoutubePlayerFragment(context, str);
    }

    public String getAppVersion(Context context) {
        return b.Q(context);
    }

    public String getUserId(Context context) {
        return b.n(context);
    }

    public boolean isPasscodeSet(Context context) {
        return net.one97.paytm.bankCommon.h.b.a(context);
    }

    public void handleErrorV2(Context context, NetworkCustomError networkCustomError, int i2) {
        j.a(context, networkCustomError, i2);
    }

    public void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        j.a(activity, exc, str, bundle);
    }

    public boolean checkDeepLinking(Context context, String str) {
        return o.a().checkDeepLinking(context, str);
    }

    public void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        o.a().sendCustomGTMEvents(context, str, str2, str3, str4, str5, str6);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        o.a().sendOpenScreenWithDeviceInfo(str, str2, context);
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Context context) {
        o.a().sendCustomEventWithMap(str, map, context);
    }

    public void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        o.a().sendNewCustomGTMEvents(context, str, str2, str3, str4, str5, str6, str7);
    }

    public void getNameFromKyc(Context context, net.one97.paytm.bankCommon.f.d dVar) {
        o.a().getNameFromKyc(context, dVar);
    }

    public boolean handleResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        return (iJRPaytmDataModel instanceof FDProjectionListModel) || (iJRPaytmDataModel instanceof TransactionDetailResponse) || (iJRPaytmDataModel instanceof FDPostTransactionModel) || (iJRPaytmDataModel instanceof CertificateResponseModal) || (iJRPaytmDataModel instanceof SlfdTransactionModel) || (iJRPaytmDataModel instanceof FDTrialRedeemAmount) || (iJRPaytmDataModel instanceof SlfdListModel) || (iJRPaytmDataModel instanceof CJROauthAadharValidate) || (iJRPaytmDataModel instanceof SIDeActivateResponse) || (iJRPaytmDataModel instanceof SIActivateResponse) || (iJRPaytmDataModel instanceof SIDeleteResponse) || (iJRPaytmDataModel instanceof SIPrevalidateResponse) || (iJRPaytmDataModel instanceof SICreationResponse) || (iJRPaytmDataModel instanceof AllSIResponse);
    }

    public Class<?> getNearByMainActivityClass() {
        return o.a().getNearByMainActivityClass();
    }

    public void cancelBankDebitCardHandler() {
        net.one97.paytm.paymentsBank.customView.a.a(net.one97.paytm.paymentsBank.customView.c.MASKED_CARD);
        net.one97.paytm.paymentsBank.customView.a.c();
    }

    public void getPanCardNumber(Context context, net.one97.paytm.bankCommon.f.d dVar) {
        o.a().getPanCardNumber(context, dVar);
    }

    public String getUserToken(Context context) {
        return com.paytm.utility.a.q(context);
    }
}
