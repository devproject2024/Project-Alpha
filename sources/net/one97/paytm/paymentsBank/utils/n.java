package net.one97.paytm.paymentsBank.utils;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.utility.v;
import net.one97.paytm.bankCommon.utils.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class n {
    public static String q() {
        return "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=4&templateId=6";
    }

    public static boolean a() {
        return o.a().getBooleanFromGTM("isPBChequeBookActive_v3", false);
    }

    public static boolean b() {
        return o.a().getBooleanFromGTM("showAccountOpeningFromWallet_Android", false);
    }

    public static boolean c() {
        return o.a().getBooleanFromGTM("showAccountOpeningFromPassbook_Android", false);
    }

    public static int d() {
        int intFromGTM = o.a().getIntFromGTM("pb_show_email_count");
        if (intFromGTM >= 0) {
            return intFromGTM;
        }
        return 5;
    }

    public static boolean e() {
        boolean booleanFromGTM = o.a().getBooleanFromGTM("pbShowFdCreate", false);
        if (!j.b() || !booleanFromGTM) {
            return false;
        }
        return true;
    }

    public static String f() {
        String stringFromGTM = o.a().getStringFromGTM("slfd_balance_api_new");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v1/fd/user/fd-balance" : "https://secure.paytmbank.com/transaction/ext/v1/fd/user/fd-balance";
        }
        return stringFromGTM;
    }

    public static boolean g() {
        return o.a().getBooleanFromGTM("icaEnabled", false);
    }

    public static String h() {
        String stringFromGTM = o.a().getStringFromGTM("getCiffStatus");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://product-ite.paytmbank.com/product/ext/v1/slfd-cif/status" : "https://product.paytmbank.com/product/ext/v1/slfd-cif/status";
        }
        return stringFromGTM;
    }

    public static String i() {
        String stringFromGTM = o.a().getStringFromGTM("createCiff");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://product-ite.paytmbank.com/product/ext/v1/slfd-cif" : "https://product.paytmbank.com/product/ext/v1/slfd-cif";
        }
        return stringFromGTM;
    }

    public static String j() {
        String stringFromGTM = o.a().getStringFromGTM("slfd_create_api");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v1/fd/create" : "https://secure.paytmbank.com/transaction/ext/v1/fd/create";
        }
        return stringFromGTM;
    }

    public static String k() {
        String stringFromGTM = o.a().getStringFromGTM("slfd_validate_request_api");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v1/fd/validate-slfd-request" : "https://secure.paytmbank.com/transaction/ext/v1/fd/validate-slfd-request";
        }
        return stringFromGTM;
    }

    public static String l() {
        String stringFromGTM = o.a().getStringFromGTM("fdTransactionDetails");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-ite.paytmbank.com/transaction/ext/v2/fd/transaction-detail" : "https://secure.paytmbank.com/transaction/ext/v2/fd/transaction-detail";
        }
        return stringFromGTM;
    }

    public static String m() {
        String stringFromGTM = o.a().getStringFromGTM("fdInterestCalculator");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v1/fd/calculator" : "https://secure.paytmbank.com/transaction/ext/v1/fd/calculator";
        }
        return stringFromGTM;
    }

    public static String n() {
        String stringFromGTM = o.a().getStringFromGTM("fd_know_more");
        if (URLUtil.isValidUrl(stringFromGTM)) {
            return stringFromGTM;
        }
        o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API);
        return "https://www.paytmbank.com/blog/2019/06/explained-your-fixed-deposit-returns-and-taxation/";
    }

    public static String o() {
        String stringFromGTM = o.a().getStringFromGTM("cb_fetchTruncated_names");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://product-origin-ite.paytmbank.com/product/ext/v1/user-names" : "https://product.paytmbank.com/product/ext/v1/user-names";
        }
        return stringFromGTM;
    }

    public static String p() {
        String stringFromGTM = o.a().getStringFromGTM("fdCreationStartTimeNew");
        return TextUtils.isEmpty(stringFromGTM) ? "02:00:00" : stringFromGTM;
    }

    public static int r() {
        int intFromGTM = o.a().getIntFromGTM("AddNomineePopUpFrequency");
        if (intFromGTM >= 0) {
            return intFromGTM;
        }
        return 7;
    }

    public static String a(String str) {
        if (c.C0228c.RUPAY.stringValue.startsWith(str)) {
            return o.a().getStringFromGTM("rupayCardBenefitsUrl");
        }
        if (c.C0228c.VISA_PLATINUM.stringValue.startsWith(str) || c.C0228c.VISA_CLASSIC.stringValue.startsWith(str)) {
            return o.a().getStringFromGTM("visaCardBenefitsUrl");
        }
        if (c.C0228c.MASTER_PLATINUM.stringValue.startsWith(str) || c.C0228c.MASTER_CLASSIC.stringValue.startsWith(str)) {
            return o.a().getStringFromGTM("masterCardBenefitsUrl");
        }
        return "";
    }

    public static String s() {
        String stringFromGTM = o.a().getStringFromGTM("fdAddUserPrefrence");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://standinginstruction-ite.paytmbank.com/si/ext/v2/add/si" : "https://standinginstruction.paytmbank.com/si/ext/v2/add/si";
        }
        return stringFromGTM;
    }

    public static String t() {
        String stringFromGTM = o.a().getStringFromGTM("pbFdSeekDefaultValue");
        return TextUtils.isEmpty(stringFromGTM) ? "25000" : stringFromGTM;
    }

    public static String u() {
        String stringFromGTM = o.a().getStringFromGTM("fdUpdateUserPrefrence");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://standinginstruction-ite.paytmbank.com/si/ext/v2/update/si" : "https://standinginstruction.paytmbank.com/si/ext/v2/update/si";
        }
        return stringFromGTM;
    }

    public static String v() {
        String stringFromGTM = o.a().getStringFromGTM("seniorCitizenFDInterestRate");
        return TextUtils.isEmpty(stringFromGTM) ? "7.75%" : stringFromGTM;
    }

    static boolean w() {
        return o.a().getBooleanFromGTM("showBiometricLogin", false);
    }

    public static String x() {
        String stringFromGTM = o.a().getStringFromGTM("cb_acknowledge_sign");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://productpref-origin-ite.paytmbank.com/pps/ext/v1/signatures/acknowledgement" : "https://productpref.paytmbank.com/pps/ext/v1/signatures/acknowledgement";
        }
        return stringFromGTM;
    }

    public static String y() {
        String stringFromGTM = o.a().getStringFromGTM("cb_change_docType");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://productpref-origin-ite.paytmbank.com/pps/ext/v1/signature/{imageID}/support-documents?documentType={docType}" : "https://productpref.paytmbank.com/pps/ext/v1/signature/{imageID}/support-documents?documentType={docType}";
        }
        return stringFromGTM;
    }

    public static String z() {
        String stringFromGTM = o.a().getStringFromGTM("cb_get_signature_url");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://productpref-origin-ite.paytmbank.com/pps/ext/v1/signatures/{imageID}/url" : "https://productpref.paytmbank.com/pps/ext/v1/signatures/{imageID}/url";
        }
        return stringFromGTM;
    }

    public static String A() {
        String stringFromGTM = o.a().getStringFromGTM("cb_delete_document");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://productpref-origin-ite.paytmbank.com/pps/ext/v1/signature/{imageID}/support-documents/{docID}" : "https://productpref.paytmbank.com/pps/ext/v1/signature/{imageID}/support-documents/{docID}";
        }
        return stringFromGTM;
    }

    public static String B() {
        String stringFromGTM = o.a().getStringFromGTM("cb_fetch_uploadedData");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://productpref-origin-ite.paytmbank.com/pps/ext/v1/signatures?type=" : "https://productpref.paytmbank.com/pps/ext/v1/signatures?type=";
        }
        return stringFromGTM;
    }

    public static String C() {
        String stringFromGTM = o.a().getStringFromGTM("cb_fetch_docList");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://productpref-origin-ite.paytmbank.com/pps/ext/v1/document-types" : "https://productpref.paytmbank.com/pps/ext/v1/document-types";
        }
        return stringFromGTM;
    }

    public static String D() {
        String stringFromGTM = o.a().getStringFromGTM("cb_checkout_url_v2");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://bankfulfillment-ite-origin.paytmbank.com/fulfillment/chequeBook/ext/v2/checkout" : "https://bankfulfillment.paytmbank.com/fulfillment/chequeBook/ext/v2/checkout";
        }
        return stringFromGTM;
    }

    public static String E() {
        String stringFromGTM = o.a().getStringFromGTM("cb_createReplace_signature");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://productpref-origin-ite.paytmbank.com/pps/ext/v1/signatures" : "https://productpref.paytmbank.com/pps/ext/v1/signatures";
        }
        return stringFromGTM;
    }

    public static boolean F() {
        return o.a().getBooleanFromGTM("pb_dbt_yellow_banner_show", false);
    }

    public static boolean G() {
        return o.a().getBooleanFromGTM("pb_dbt_menu_item_show", false);
    }

    public static boolean H() {
        return o.a().getBooleanFromGTM("pbOpenH5DCflow", false);
    }

    public static boolean I() {
        return o.a().getBooleanFromGTM("pbopenH5FDflowAndroid", false);
    }

    public static boolean J() {
        return o.a().getBooleanFromGTM("pbopenH5ForgotPasscodeflowAndroid", false);
    }

    public static String K() {
        String stringFromGTM = o.a().getStringFromGTM("pbDebitCardUrl");
        return v.a(stringFromGTM) ? "https://bankapp-ite.paytmbank.com/ppbl/debitcard/" : stringFromGTM;
    }

    public static String L() {
        String stringFromGTM = o.a().getStringFromGTM("fdH5Url");
        return v.a(stringFromGTM) ? "https://bankapp-ite.paytmbank.com/ppbl/fd" : stringFromGTM;
    }

    public static String M() {
        String stringFromGTM = o.a().getStringFromGTM("kycUserDetailsUrl");
        return v.a(stringFromGTM) ? "https://bankapp-ite.paytmbank.com/ppbl/user/kyc-details" : stringFromGTM;
    }

    public static String N() {
        String stringFromGTM = o.a().getStringFromGTM("pbH5SavingsUrl");
        return v.a(stringFromGTM) ? "https://bankapp-ite.paytmbank.com/ppbl/savings/home" : stringFromGTM;
    }

    public static String O() {
        String stringFromGTM = o.a().getStringFromGTM("pbH5ForgotPasscodeUrl");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            return o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://bankapp-ite.paytmbank.com/ppbl/forgot-passcode" : "https://bankapp.paytmbank.com/ppbl/forgot-passcode";
        }
        return stringFromGTM;
    }

    public static String P() {
        String stringFromGTM = o.a().getStringFromGTM("pbH5HomeUrl");
        return v.a(stringFromGTM) ? "https://bankapp-service-staging.paytmbank.com/ppbl/home" : stringFromGTM;
    }

    public static String Q() {
        String stringFromGTM = o.a().getStringFromGTM("cashWithdrawalH5Url");
        return v.a(stringFromGTM) ? "https://bankapp-ite.paytmbank.com/ppbl/cash-withdrawl" : stringFromGTM;
    }

    public static boolean R() {
        return o.a().getBooleanFromGTM("pbH5openEditProfile", false);
    }

    public static boolean S() {
        return o.a().getBooleanFromGTM("pbH5openSavingsFlow", false);
    }

    public static boolean T() {
        return o.a().getBooleanFromGTM("pbH5openHomeFlow", false);
    }

    public static boolean U() {
        return o.a().getBooleanFromGTM("pbH5openCashWithdrawFlow", false);
    }

    public static boolean V() {
        return o.a().getBooleanFromGTM("pbEnableRootedCheck", false);
    }

    public static String W() {
        return o.a().getStringFromGTM("safety_net_api_key_core");
    }

    public static String X() {
        String stringFromGTM = o.a().getStringFromGTM("bankStatusBarColor");
        return v.a(stringFromGTM) ? "#FAFAFA" : stringFromGTM;
    }
}
