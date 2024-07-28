package net.one97.paytm.vipcashback.f;

import android.text.TextUtils;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.vipcashback.c.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f20890a;

    public static f a() {
        if (f20890a == null) {
            f20890a = new f();
        }
        return f20890a;
    }

    public static List<Integer> b() {
        try {
            String b2 = b("cashbackPostTxnEnabledOfferIds");
            if (TextUtils.isEmpty(b2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((Object[]) new com.google.gson.f().a(b2, Integer[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static String c() {
        return b("cashbackAllOffersV3Url");
    }

    public static String d() {
        return b("cashbackAllOffersV4Url");
    }

    public static String e() {
        return b("pathFetchGameDetail");
    }

    public static String f() {
        return b("cashbackSelectOfferV4Url");
    }

    public static String g() {
        return b("cashbackCampaignDetailV4Url");
    }

    public static String h() {
        return b("merchantCashbackCampaignList");
    }

    public static String i() {
        return b("merchantCashbackGameListV2");
    }

    public static String j() {
        return b("merchantCashbackGameTransactionsAndroid");
    }

    public static String k() {
        return b("merchantCashbackActivateOfferV2");
    }

    public static String l() {
        return b("merchantCashbackActivateGame");
    }

    public static String m() {
        return b("cashBackMyVouchersV3Url");
    }

    public static String n() {
        return b("cashbackMyVoucherFilterV1Url");
    }

    public static String o() {
        return b("cashBackMyVouchersDetailV3Url");
    }

    public static String p() {
        return b("cashbackOfferWithTagV4OfferTag");
    }

    public static String q() {
        return b("cashbackScratchCardById");
    }

    public static String r() {
        return b("cashbackNewOffersV4");
    }

    public static String s() {
        return b("cashbackLandingSFV2");
    }

    public static String t() {
        return b("cbLandingAmountFromDate");
    }

    public static String u() {
        return b("cbLandingAmountToDate");
    }

    public static String v() {
        return b("cashbackPostTxnAsyncV4Url");
    }

    public static List<Integer> w() {
        try {
            if (TextUtils.isEmpty("[1,2,1]")) {
                return new ArrayList(0);
            }
            return Arrays.asList((Object[]) new com.google.gson.f().a("[1,2,1]", Integer[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static String x() {
        return b("fetchTotalCashback");
    }

    public static String y() {
        return b("cbBreakUpDeepLink");
    }

    public static String z() {
        return b("paytmCoinsCheckBalance");
    }

    public static String A() {
        return b("paytmMerchantCheckBalance");
    }

    public static String B() {
        String b2 = b("paytmCoinsPassbook");
        return TextUtils.isEmpty(b2) ? a.a().f20708b.getBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://securegw-stage.paytm.in/fund-service/fundproxy/loyaltypoints/v1/passbook" : "https://securegw.paytm.in/fund-service/fundproxy/loyaltypoints/v1/passbook" : b2;
    }

    public static boolean C() {
        return a("paytmCoinsIsRedeemFlowEnabled");
    }

    public static String D() {
        String b2 = b("paytmCoinsRedeemLimit");
        return TextUtils.isEmpty(b2) ? Constants.RESULT_STATUS_SUCCESS : b2;
    }

    public static String E() {
        return b("cashbackScratchCardById") + "getCardListByUser?userType=CUSTOMER";
    }

    public static String F() {
        return b("cblandingMergedOffers");
    }

    public static String G() {
        return b("cbLandingCBCoins");
    }

    public static Boolean H() {
        return Boolean.valueOf(a("cbWebCashbackEnable"));
    }

    public static String I() {
        String b2 = b("paytmCoinsGetRewards");
        return TextUtils.isEmpty(b2) ? a.a().f20708b.getBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://catalog-staging.paytm.com/v1/g/deals-for-you/reward?attributes=all" : "https://catalog.paytm.com/v1/g/deals-store/deals-rewards?attributes=all" : b2;
    }

    public static String J() {
        return b("paytmMerchantGetRewards");
    }

    public static String K() {
        return b("paytmCoinsCheckout");
    }

    public static String L() {
        return b("cashbackScratchCardById") + "getCardListByIds?scratchCardIds=";
    }

    public static String M() {
        return b("cashbackAllOffersV4Url") + "/eventOffer";
    }

    public static String N() {
        return b(PaymentsGTMConstants.KEY_MERCHANT_POINTS_DEEPLINK);
    }

    public static boolean O() {
        return a("merchant_points_hidden");
    }

    public static int P() {
        return c("cbScratchCardExpiryLimitHour");
    }

    public static int Q() {
        return c("androidScratchThreshold");
    }

    public static String R() {
        return b("referral_landing");
    }

    public static String S() {
        return b("referral_offer_link");
    }

    public static String T() {
        return b("referral_campign_image");
    }

    public static String U() {
        return b("paytmMerchantOrderSummary");
    }

    public static String V() {
        return b("cbPointPassbookDeeplinkKey");
    }

    public static String W() {
        return b("cbRedeemPointDeeplinkKey");
    }

    public static String X() {
        return b("referral_caching_short_url");
    }

    private static String b(String str) {
        return a.a().f20708b.getStringFromGTM(str);
    }

    public static boolean a(String str) {
        return a.a().f20708b.getBooleanFromGTM(str, false);
    }

    private static int c(String str) {
        return a.a().f20708b.getIntFromGTM(str);
    }
}
