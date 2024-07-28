package net.one97.paytm.passbook.mapping;

import android.text.TextUtils;
import net.one97.paytm.passbook.d;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f57892a;

    public static String o() {
        return "https://trust.paytm.in/service/wrapper/seacrhUserTransactionHistory";
    }

    public static e a() {
        if (f57892a == null) {
            synchronized (e.class.getName()) {
                if (f57892a == null) {
                    f57892a = new e();
                }
            }
        }
        return f57892a;
    }

    public static String b() {
        return d.b().a("getUnClaimedGiftCardList");
    }

    public static boolean c() {
        return d.b().a("isPassbookClosingBalanceEnable", false);
    }

    public static String d() {
        return d.b().a("pp_accounts_v3_url");
    }

    public static String e() {
        return d.b().a("loyaltyPointTitle");
    }

    public static String f() {
        return d.b().a("giftVoucherTitle");
    }

    public static String g() {
        return d.b().a("searchUserTransactionHistoryUrl");
    }

    public static boolean h() {
        return d.b().a("disableNewtxndetail", false);
    }

    public static String i() {
        return d.b().a("PaytmCashLedger");
    }

    public static String j() {
        return d.b().a("check_user_balance_service");
    }

    public static String k() {
        return d.b().a(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW);
    }

    public static String l() {
        return d.b().a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT);
    }

    public static String m() {
        return d.b().a("preAuthTxnURL");
    }

    public static String n() {
        return d.b().a("merchantTransactionDetialURL");
    }

    public static String p() {
        return d.b().a("tolltagDeActivate");
    }

    public static String q() {
        return d.b().a("tolltagActivate");
    }

    public static String r() {
        return d.b().a("tollTxnHistory");
    }

    public static String s() {
        return d.b().a("tolltag");
    }

    public static boolean t() {
        return d.b().a("shouldShowP2PThemes", false);
    }

    public static String u() {
        return d.b().a("p2pThemesAssetsURL");
    }

    public static String a(String str) {
        return d.b().a("passbookCreditCardInfoURL") + str;
    }

    public static String v() {
        return d.b().a("createWalletUrl");
    }

    public static String w() {
        return d.b().a("fetchTncActivateWalletUrl");
    }

    public static String x() {
        return d.b().a("acceptTncActivateWalletUrl");
    }

    public static String y() {
        return d.b().a("getAllpassbookTransactionTagURL");
    }

    public static String z() {
        return d.b().a("getSavePassbookTransactionTagURL");
    }

    public static String A() {
        return d.b().a("fetchAllMGVTemplatesURL");
    }

    public static String B() {
        return d.b().a("getUTHHistoryListURL");
    }

    public static String C() {
        return d.b().a("getUTHDetailsURL");
    }

    public static String D() {
        String a2 = d.b().a("getPpblPassbookListingUrlV2");
        return TextUtils.isEmpty(a2) ? "https://account-summary.paytmbank.com/transaction/ext/v2/transactions" : a2;
    }

    public static boolean E() {
        return d.b().a("isToLoadUthListing", true);
    }

    public static boolean F() {
        return d.b().a("pass_fastagInitCardEnabled", true);
    }
}
