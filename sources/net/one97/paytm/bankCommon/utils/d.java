package net.one97.paytm.bankCommon.utils;

import android.webkit.URLUtil;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f16327a;

    public static String y() {
        return "https://catalogue-ite-origin.paytmbank.com/catalogue/ext/v1/fetchProducts?productType=CHEQUE_BOOK";
    }

    public static d a() {
        if (f16327a == null) {
            f16327a = new d();
        }
        return f16327a;
    }

    public static d b() {
        if (f16327a == null) {
            f16327a = new d();
        }
        return f16327a;
    }

    public static String a(String str) {
        return f.a().getStringFromGTM(str);
    }

    public static boolean a(String str, boolean z) {
        return f.a().getBooleanFromGTM(str, z);
    }

    public static String c() {
        return a(PaymentsGTMConstants.USER_DETAILS);
    }

    public static String d() {
        return a("kyc_tnc_user_url");
    }

    public static String e() {
        return a("bank_tnc");
    }

    public static boolean f() {
        return a("upi_enabled", false);
    }

    public static String g() {
        return a("saving_acc_interest");
    }

    public static boolean h() {
        return a("share_acc_details", false);
    }

    public static boolean i() {
        return a("bank_faq", false);
    }

    public static String j() {
        return a("total_balance_desc");
    }

    public static String k() {
        return a("wallet_desc");
    }

    public static String m() {
        return a("slfd_create_api");
    }

    public static String n() {
        return a("slfd_meta_api");
    }

    public static String o() {
        return a("slfd_trial_redeem_amount_api");
    }

    public static String p() {
        return a("slfd_list_api");
    }

    public static String q() {
        return a("slfd_nominee_list_api");
    }

    public static String r() {
        return a("slfd_validate_request_api");
    }

    public static String s() {
        return a("slfd_transaction_api");
    }

    public static String t() {
        return a("slfd_timeline_api");
    }

    public static String u() {
        return a("slfd_nominee_details_api");
    }

    public static boolean v() {
        return a("showPendingReqNachNew", false);
    }

    public static boolean w() {
        return a("nachFeatureEnabled", false);
    }

    public static boolean x() {
        return a("showBankRateOption", false);
    }

    public static boolean z() {
        return a("isRecurringPaymentsAvailable8.2.6", false);
    }

    public static String A() {
        return a("fg_status_api");
    }

    public static boolean B() {
        return a("isWithdrawCashAvailable", false);
    }

    public static String C() {
        return a("generate_qrcode_withdraw_cash");
    }

    public static String D() {
        String a2 = a("updateICALead");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://goldengate-staging.paytmbank.com/MerchantService/v1/diy/currentAccount/update" : "https://goldengate.paytmbank.com/MerchantService/v1/diy/currentAccount/update";
        }
        return a2;
    }

    public static String E() {
        String a2 = a("fetchICAPostPaidTnc");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://kyc-staging.paytmbank.com/kyc/tnc/v2/set/CA_Individual_IndusInd" : "https://kyc.paytmbank.com/kyc/tnc/v2/set/CA_Individual_IndusInd";
        }
        return a2;
    }

    public static String F() {
        String a2 = a("fetchICATnc");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://kyc-staging.paytmbank.com/kyc/tnc/v2/set/current_account_tnc" : "https://kyc.paytmbank.com/kyc/tnc/v2/set/current_account_tnc";
        }
        return a2;
    }

    public static String G() {
        String a2 = a("trackICASubmitted");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://goldengate-staging.paytmbank.com/MerchantService/v1/trackLeadCompletion" : "https://goldengate.paytmbank.com/MerchantService/v1/trackLeadCompletion";
        }
        return a2;
    }

    public static String H() {
        String a2 = a("createICALead");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://goldengate-staging.paytmbank.com/MerchantService/v1/diy/currentAccount" : "https://goldengate.paytmbank.com/MerchantService/v1/diy/currentAccount";
        }
        return a2;
    }

    public static String I() {
        String a2 = a("getICALeadStatus");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://goldengate-staging.paytmbank.com/MerchantService/v1/getLeadStatus" : "https://goldengate.paytmbank.com/MerchantService/v1/getLeadStatus";
        }
        return a2;
    }

    public static String J() {
        String a2 = a("getICAQuesList");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://goldengate-staging.paytmbank.com/MerchantService/v1/qna/fetchQuestions" : "https://goldengate.paytmbank.com/MerchantService/v1/qna/fetchQuestions";
        }
        return a2;
    }

    public static String K() {
        return a("updateEmailV3");
    }

    public static String L() {
        String a2 = a("slfd_transactions_api_new");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v2/fd/transactions" : "https://secure.paytmbank.com/transaction/ext/v2/fd/transactions";
        }
        return a2;
    }

    public static String M() {
        String a2 = a("slfd_redeem_api_new");
        if (!URLUtil.isValidUrl(a2)) {
            return f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v2/fd/redeem" : "https://secure.paytmbank.com/transaction/ext/v2/fd/redeem";
        }
        return a2;
    }

    public static String N() {
        return a("pb_atm_rsa_key");
    }

    public static String O() {
        return a("pb_passcode_rsa_key");
    }

    public static String P() {
        return a("bank_scope_token_url");
    }

    public static Boolean Q() {
        return Boolean.valueOf(a("is_bank_scopetoken_enabled", false));
    }

    public static String R() {
        return a("bankscope_client_id_android");
    }

    public static String S() {
        return a("bankscope_secret_key_android");
    }

    public static int l() {
        return f.a().getIntFromGTM("thresholdForTransferToBank");
    }
}
