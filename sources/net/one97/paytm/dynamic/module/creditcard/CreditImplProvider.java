package net.one97.paytm.dynamic.module.creditcard;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.deeplink.g;
import net.one97.paytm.dynamic.module.creditcard.helper.CCtoH5Response;
import net.one97.paytm.dynamic.module.creditcard.helper.PassbookAuthResponseModel;
import net.one97.paytm.dynamic.module.creditcard.helper.TokenModel;
import net.one97.paytm.dynamic.module.creditcard.helper.TokenizationApiResponse;
import net.one97.paytm.dynamic.module.creditcard.helper.UserInfo;
import net.one97.paytm.h5.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.utils.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class CreditImplProvider {
    private static final String BIN_NUMBER = "438106";
    private static final String BIN_NUMBER_STAGING = "438106";
    private static final String CATEGORY_ID = "156705";
    private static final String CATEGORY_ID_STAGING = "131655";
    private static String CC_AUTH_BASE_URL = "";
    public static final String CC_AUTH_URL_PROD = "https://accounts.paytm.com/";
    public static final String CC_AUTH_URL_STAGING = "https://accounts-staging.paytm.in/";
    private static final String PRODUCT_ID = "238990225";
    private static final String PRODUCT_ID_STAGING = "1200168078";
    /* access modifiers changed from: private */
    public static boolean isCancelClicked = false;
    private static CreditImplProvider mInstance = null;
    public static final String tokenzationCardCardIdUrlStaging = "https://pgp-staging.paytm.in/billproxy/api/v2/creditCardId/cc/cardTokenize/request";
    public static final String tokenzationCardIdUrl = "https://securegw.paytm.in/billproxy/api/v2/creditCardId/cc/cardTokenize/request";
    public static final String tokenzationCardNumberUrl = "https://securegw.paytm.in/billproxy/api/v2/cardNumber/cc/cardTokenize/request";
    public static final String tokenzationCardNumberUrlStaging = "https://pgp-staging.paytm.in/billproxy/api/v2/cardNumber/cc/cardTokenize/request";
    public static final String tokenzationSavedCardUrl = "https://securegw.paytm.in/billproxy/api/v2/savedCardId/cc/cardTokenize/request";
    public static final String tokenzationSavedCardUrlStaging = "https://pgp-staging.paytm.in/billproxy/api/v2/savedCardId/cc/cardTokenize/request";
    private String panNumber = "";

    public static void cancelNetworkCalls(c.C0910c cVar) {
    }

    private static String getAuthorization() {
        return "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=";
    }

    public static String getBankKey() {
        return "63uxcxggq6kqjjsgwagub2k877w562v0qnqgkzrki7203cjfr2fwnwuofewsnq5wjv4603cnhwz8dj14mujzmirehg6ysfjuyoua6qjlvnivcxhjk5xes68umpp4mmprs369wb7i4ifp212hvl";
    }

    public static void init(Context context) {
        if (mInstance == null) {
            mInstance = new CreditImplProvider();
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setSso_token(t.b(context));
        userInfo.setFirstName(b.h(context));
        userInfo.setLastName(b.i(context));
        userInfo.setDob(b.F(context));
        userInfo.setMobileNo(a.b(context));
        userInfo.setUserId(a.a(context));
        userInfo.setEmail(a.c(context));
        userInfo.setAuthorization(getAuthorization());
        c cVar = c.f50543a;
        c.a(CreditCardConstant.CREDIT_CARD_VERTICAL_NAME, new c.b(context, userInfo) {
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ UserInfo f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void provideValuesForKeys(String str, c.C0910c cVar) {
                CreditImplProvider.lambda$init$0(this.f$0, this.f$1, str, cVar);
            }
        });
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x017c, code lost:
        if (r8.equals("GTM_getSavedCard") != false) goto L_0x018b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void lambda$init$0(android.content.Context r6, net.one97.paytm.dynamic.module.creditcard.helper.UserInfo r7, java.lang.String r8, net.one97.paytm.h5.c.C0910c r9) {
        /*
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "authantication_"
            boolean r0 = r8.startsWith(r0)
            r1 = 15
            if (r0 == 0) goto L_0x0015
            java.lang.String r7 = r8.substring(r1)
            getPasswordAuth(r6, r7, r9)
            return
        L_0x0015:
            java.lang.String r0 = "checkout_"
            boolean r0 = r8.startsWith(r0)
            r2 = 9
            r3 = 0
            if (r0 == 0) goto L_0x002a
            isCancelClicked = r3
            java.lang.String r7 = r8.substring(r2)
            performTokenization(r6, r7, r9)
            return
        L_0x002a:
            r0 = -1
            int r4 = r8.hashCode()
            r5 = 1
            switch(r4) {
                case -2084119863: goto L_0x017f;
                case -2006996896: goto L_0x0176;
                case -1910517652: goto L_0x016b;
                case -1859428086: goto L_0x0161;
                case -1043807292: goto L_0x0156;
                case -976835437: goto L_0x014b;
                case -394344992: goto L_0x0140;
                case -384847027: goto L_0x0135;
                case -267640083: goto L_0x012a;
                case -266803431: goto L_0x011f;
                case 93257320: goto L_0x0113;
                case 132835675: goto L_0x0108;
                case 242780154: goto L_0x00fd;
                case 389542064: goto L_0x00f2;
                case 502208426: goto L_0x00e6;
                case 611084402: goto L_0x00da;
                case 785298387: goto L_0x00cf;
                case 810989253: goto L_0x00c3;
                case 917174448: goto L_0x00b7;
                case 1136436956: goto L_0x00ab;
                case 1231490185: goto L_0x009f;
                case 1323702528: goto L_0x0093;
                case 1338705501: goto L_0x0087;
                case 1804881851: goto L_0x007c;
                case 1829503400: goto L_0x0070;
                case 1898449010: goto L_0x0064;
                case 1968868065: goto L_0x0058;
                case 1971595265: goto L_0x004d;
                case 1984898529: goto L_0x0041;
                case 2003423917: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x018a
        L_0x0035:
            java.lang.String r1 = "GTM_paytmCCName"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 25
            goto L_0x018b
        L_0x0041:
            java.lang.String r1 = "GTM_creditCardtnc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 9
            goto L_0x018b
        L_0x004d:
            java.lang.String r1 = "GTM_creditCardProductListv2"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 3
            goto L_0x018b
        L_0x0058:
            java.lang.String r1 = "GTM_creditCardFaqURL"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 23
            goto L_0x018b
        L_0x0064:
            java.lang.String r1 = "GTM_frequentOrders"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 16
            goto L_0x018b
        L_0x0070:
            java.lang.String r1 = "GTM_creditCardPollingtime"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 21
            goto L_0x018b
        L_0x007c:
            java.lang.String r1 = "GTM_creditCardPincodeService"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 5
            goto L_0x018b
        L_0x0087:
            java.lang.String r1 = "GTM_creditCardAuth2FA"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 11
            goto L_0x018b
        L_0x0093:
            java.lang.String r1 = "GTM_addressesV3"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 13
            goto L_0x018b
        L_0x009f:
            java.lang.String r1 = "GTM_creditCardSubmitTnc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 8
            goto L_0x018b
        L_0x00ab:
            java.lang.String r1 = "GTM_paytmCCNameFor"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 26
            goto L_0x018b
        L_0x00b7:
            java.lang.String r1 = "GTM_creditCardPassbookInfo"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 19
            goto L_0x018b
        L_0x00c3:
            java.lang.String r1 = "GTM_creditCardProductList"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 18
            goto L_0x018b
        L_0x00cf:
            java.lang.String r1 = "GTM_creditCardPassbookDetail"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 6
            goto L_0x018b
        L_0x00da:
            java.lang.String r1 = "GTM_applicationFormFC"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 12
            goto L_0x018b
        L_0x00e6:
            java.lang.String r1 = "GTM_creditCardPassbookReadStatus"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 10
            goto L_0x018b
        L_0x00f2:
            java.lang.String r1 = "GTM_creditCardSubmitApplication"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 7
            goto L_0x018b
        L_0x00fd:
            java.lang.String r1 = "GTM_creditCardApplicationStatus"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 4
            goto L_0x018b
        L_0x0108:
            java.lang.String r1 = "firstName"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 2
            goto L_0x018b
        L_0x0113:
            java.lang.String r1 = "GTM_creditCardcaChachTime"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 20
            goto L_0x018b
        L_0x011f:
            java.lang.String r1 = "userInfo"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 0
            goto L_0x018b
        L_0x012a:
            java.lang.String r1 = "GTM_creditCardCstVerticalId"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 22
            goto L_0x018b
        L_0x0135:
            java.lang.String r1 = "GTM_creditCardFetchBillPayment"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 17
            goto L_0x018b
        L_0x0140:
            java.lang.String r1 = "cancelCheckout"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 29
            goto L_0x018b
        L_0x014b:
            java.lang.String r1 = "GTM_firstCardFormFlow"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 28
            goto L_0x018b
        L_0x0156:
            java.lang.String r1 = "GTM_creditCardPaymentDeepLink"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 24
            goto L_0x018b
        L_0x0161:
            java.lang.String r1 = "bankInfo"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 1
            goto L_0x018b
        L_0x016b:
            java.lang.String r1 = "GTM_getLocation"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 14
            goto L_0x018b
        L_0x0176:
            java.lang.String r2 = "GTM_getSavedCard"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x018a
            goto L_0x018b
        L_0x017f:
            java.lang.String r1 = "GTM_firstCardPassbookFlow"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x018a
            r1 = 27
            goto L_0x018b
        L_0x018a:
            r1 = -1
        L_0x018b:
            java.lang.String r8 = ""
            r0 = 0
            switch(r1) {
                case 0: goto L_0x0479;
                case 1: goto L_0x0469;
                case 2: goto L_0x0461;
                case 3: goto L_0x0441;
                case 4: goto L_0x0421;
                case 5: goto L_0x0401;
                case 6: goto L_0x03e1;
                case 7: goto L_0x03c1;
                case 8: goto L_0x03a1;
                case 9: goto L_0x0381;
                case 10: goto L_0x0361;
                case 11: goto L_0x0341;
                case 12: goto L_0x0321;
                case 13: goto L_0x0301;
                case 14: goto L_0x02e1;
                case 15: goto L_0x02c8;
                case 16: goto L_0x02af;
                case 17: goto L_0x0296;
                case 18: goto L_0x027d;
                case 19: goto L_0x0264;
                case 20: goto L_0x024f;
                case 21: goto L_0x023a;
                case 22: goto L_0x0225;
                case 23: goto L_0x020c;
                case 24: goto L_0x01f3;
                case 25: goto L_0x01de;
                case 26: goto L_0x01c9;
                case 27: goto L_0x01b0;
                case 28: goto L_0x0197;
                case 29: goto L_0x0193;
                default: goto L_0x0191;
            }
        L_0x0191:
            goto L_0x047d
        L_0x0193:
            isCancelClicked = r5
            goto L_0x047d
        L_0x0197:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "firstCardFormFlow"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x01a8
            java.lang.String r7 = "https://webappsstatic.paytm.com/firstcard/v1/index.html"
        L_0x01a8:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x01b0:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "firstCardPassbookFlow"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x01c1
            java.lang.String r7 = "https://webappsstatic.paytm.com/firstcard/v1/index.html?login"
        L_0x01c1:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x01c9:
            net.one97.paytm.j.c.a()
            java.lang.String r6 = "paytmCCNameFor"
            java.lang.String r6 = net.one97.paytm.j.c.a((java.lang.String) r6, (java.lang.String) r0)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x01da
            java.lang.String r6 = "For Paytm First Card"
        L_0x01da:
            r9.onResult(r6)
            return
        L_0x01de:
            net.one97.paytm.j.c.a()
            java.lang.String r6 = "paytmCCName"
            java.lang.String r6 = net.one97.paytm.j.c.a((java.lang.String) r6, (java.lang.String) r0)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x01ef
            java.lang.String r6 = "Paytm First Card"
        L_0x01ef:
            r9.onResult(r6)
            return
        L_0x01f3:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "creditCardPaymentDeepLink"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x0204
            java.lang.String r7 = "paytmmp://utility_creditcard?url=https://catalog.paytm.com/v2/mobile/getproductlist/156705"
        L_0x0204:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x020c:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "creditCardFaqURL"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x021d
            java.lang.String r7 = "https://paytm.com/offer/paytm-credit-card-faqs/"
        L_0x021d:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x0225:
            net.one97.paytm.j.c.a()
            java.lang.String r6 = "creditCardCstVerticalId"
            java.lang.String r6 = net.one97.paytm.j.c.a((java.lang.String) r6, (java.lang.String) r0)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0236
            java.lang.String r6 = "750001"
        L_0x0236:
            r9.onResult(r6)
            return
        L_0x023a:
            net.one97.paytm.j.c.a()
            java.lang.String r6 = "creditCardPollingtime"
            java.lang.String r6 = net.one97.paytm.j.c.a((java.lang.String) r6, (java.lang.String) r0)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x024b
            java.lang.String r6 = "6"
        L_0x024b:
            r9.onResult(r6)
            return
        L_0x024f:
            net.one97.paytm.j.c.a()
            java.lang.String r6 = "creditCardcaChachTime"
            java.lang.String r6 = net.one97.paytm.j.c.a((java.lang.String) r6, (java.lang.String) r0)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0260
            java.lang.String r6 = "172800"
        L_0x0260:
            r9.onResult(r6)
            return
        L_0x0264:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "creditCardPassbookInfo"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x0275
            java.lang.String r7 = "https://credit-card.paytm.com/creditCard/passbook/v1/show"
        L_0x0275:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x027d:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "creditCardProductList"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x028e
            java.lang.String r7 = "https://credit-card.paytm.com/creditCard/product/v1/fetchDetails"
        L_0x028e:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x0296:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "creditCardFetchBillPayment"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x02a7
            java.lang.String r7 = "https://credit-card.paytm.com/creditCard/billing/v1/fetchDetails"
        L_0x02a7:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x02af:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "frequentOrders"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x02c0
            java.lang.String r7 = "https://digitalproxy.paytm.com/v1/frequentorders"
        L_0x02c0:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x02c8:
            net.one97.paytm.j.c.a()
            java.lang.String r7 = "get_saved_credit_card"
            java.lang.String r7 = net.one97.paytm.j.c.a((java.lang.String) r7, (java.lang.String) r0)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x02d9
            java.lang.String r7 = "https://securegw.paytm.in/savedcardservice/savedcardOpenAPIService/savedcardsBycardTypeSsoToken"
        L_0x02d9:
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r7)
            r9.onResult(r6)
            return
        L_0x02e1:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "getLocation"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0301:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "addressesV3"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0321:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "applicationFormFC"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0341:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardAuth2FA"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0361:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardPassbookReadStatus"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0381:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardtnc"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x03a1:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardSubmitTnc"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x03c1:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardSubmitApplication"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x03e1:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardPassbookDetail"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0401:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardPincodeService"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0421:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardApplicationStatus"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0441:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "creditCardProductListv2"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r0)
            r7.append(r0)
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r6, (java.lang.String) r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r9.onResult(r6)
            return
        L_0x0461:
            java.lang.String r6 = com.paytm.utility.b.h((android.content.Context) r6)
            r9.onResult(r6)
            return
        L_0x0469:
            net.one97.paytm.dynamic.module.creditcard.helper.TokenModel r7 = new net.one97.paytm.dynamic.module.creditcard.helper.TokenModel
            r7.<init>()
            java.lang.String r6 = net.one97.paytm.dynamic.module.creditcard.CreditCardConstant.getProductId(r6)
            r7.setProductId(r6)
            r9.onResult(r7)
            return
        L_0x0479:
            r9.onResult(r7)
            return
        L_0x047d:
            r9.onResult(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.creditcard.CreditImplProvider.lambda$init$0(android.content.Context, net.one97.paytm.dynamic.module.creditcard.helper.UserInfo, java.lang.String, net.one97.paytm.h5.c$c):void");
    }

    public void checkDeepLinking(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public static void getPasswordAuth(Context context, String str, final c.C0910c cVar) {
        CC_AUTH_BASE_URL = CC_AUTH_URL_PROD;
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a(CreditCardConstant.CREDIT_CARD_2FA, (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = CC_AUTH_BASE_URL + CreditCardConstant.CREDIT_CARD_2FA_URL;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", b.m());
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = context;
        bVar.f42882f = hashMap;
        bVar.f42878b = a.c.CST;
        bVar.f42879c = a.C0715a.POST;
        bVar.o = "CreditCardAuth";
        bVar.f42884h = getAuthPassBookBody(str, context);
        bVar.n = a.b.SILENT;
        bVar.f42880d = a2;
        bVar.f42885i = new PassbookAuthResponseModel();
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                TokenModel tokenModel = new TokenModel();
                tokenModel.setAccess_token(((PassbookAuthResponseModel) iJRPaytmDataModel).getAccessToken());
                cVar.onResult(tokenModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                String str = new String();
                try {
                    JSONObject jSONObject = new JSONObject(new String(networkResponse.data));
                    if (jSONObject.has("error_description")) {
                        str = jSONObject.getString("error_description");
                    } else if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                        str = networkCustomError.getAlertMessage();
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                TokenModel tokenModel = new TokenModel();
                if (!TextUtils.isEmpty(str)) {
                    tokenModel.setError(str);
                } else {
                    tokenModel.setError("Something Went Wrong");
                }
                tokenModel.setErrorCode(i2);
                cVar.onResult(tokenModel);
            }
        };
        com.paytm.network.a l = bVar.l();
        if (com.paytm.utility.a.m(context)) {
            l.a();
            return;
        }
        TokenModel tokenModel = new TokenModel();
        tokenModel.setError("Network Unavailable");
        tokenModel.setErrorCode(10);
        cVar.onResult(tokenModel);
    }

    private static String getAuthPassBookBody(String str, Context context) {
        try {
            return "grant_type=" + URLEncoder.encode("password", AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode(com.paytm.utility.a.b(context), AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(com.paytm.e.a.b.a(getBankKey(), str), AppConstants.UTF_8) + "&scope=" + URLEncoder.encode("BASIC", AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("password", AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
            return "";
        } catch (NoSuchAlgorithmException e3) {
            q.b(e3.getMessage());
            return "";
        } catch (NoSuchPaddingException e4) {
            q.b(e4.getMessage());
            return "";
        } catch (InvalidKeyException e5) {
            q.b(e5.getMessage());
            return "";
        } catch (IllegalBlockSizeException e6) {
            q.b(e6.getMessage());
            return "";
        } catch (BadPaddingException e7) {
            q.b(e7.getMessage());
            return "";
        } catch (InvalidKeySpecException e8) {
            q.b(e8.getMessage());
            return "";
        }
    }

    public static void performTokenization(final Context context, String str, final c.C0910c cVar) {
        String str2;
        try {
            final JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("cardKeyInformation");
            char c2 = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -1630619484) {
                if (hashCode != -406709838) {
                    if (hashCode == 508016249 && string.equals(SDKConstants.CARD_NUMBER)) {
                        c2 = 0;
                    }
                } else if (string.equals("savedCardId")) {
                    c2 = 1;
                }
            } else if (string.equals("creditCardId")) {
                c2 = 2;
            }
            if (c2 == 0) {
                net.one97.paytm.j.c.a();
                str2 = net.one97.paytm.j.c.a("credit_card_tokenization_api_cardEntryV2", (String) null);
                if (TextUtils.isEmpty(str2)) {
                    str2 = tokenzationCardNumberUrl;
                }
            } else if (c2 == 1) {
                net.one97.paytm.j.c.a();
                str2 = net.one97.paytm.j.c.a("credit_card_tokenization_api_savedV2", (String) null);
                if (TextUtils.isEmpty(str2)) {
                    str2 = tokenzationSavedCardUrl;
                }
            } else if (c2 != 2) {
                sendError(10, "Unknown CardInformation Key", cVar);
                return;
            } else {
                net.one97.paytm.j.c.a();
                str2 = net.one97.paytm.j.c.a("credit_card_tokenization_api_recentV2", (String) null);
                if (TextUtils.isEmpty(str2)) {
                    str2 = tokenzationCardIdUrl;
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssoToken", t.b(context));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = context;
            bVar.f42882f = hashMap;
            bVar.f42878b = a.c.CST;
            bVar.f42879c = a.C0715a.POST;
            bVar.o = "CreditCardBillPayment";
            bVar.f42884h = getPaytmCardTokenizerBody(jSONObject);
            bVar.n = a.b.SILENT;
            bVar.f42880d = str2;
            bVar.f42885i = new TokenizationApiResponse();
            bVar.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (CreditImplProvider.isCancelClicked) {
                        boolean unused = CreditImplProvider.isCancelClicked = false;
                        return;
                    }
                    CreditImplProvider.performVerify(context, jSONObject, (TokenizationApiResponse) iJRPaytmDataModel, cVar);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    NetworkResponse networkResponse = networkCustomError.networkResponse;
                    String str = new String();
                    try {
                        JSONObject jSONObject = new JSONObject(new String(networkResponse.data));
                        if (jSONObject.has("error_description")) {
                            str = jSONObject.getString("error_description");
                        } else if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                            str = networkCustomError.getAlertMessage();
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                    CreditImplProvider.sendError(i2, str, cVar);
                }
            };
            com.paytm.network.a l = bVar.l();
            if (com.paytm.utility.a.m(context)) {
                l.a();
            } else {
                sendError(10, "Network Unavailable", cVar);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
            sendError(10, "", cVar);
        }
    }

    private static String getPaytmCardTokenizerBody(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(jSONObject.getString("cardKeyInformation"), jSONObject.get("cardInfomation"));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        try {
            jSONObject3.put("clientId", "APP");
            jSONObject3.put("signature", "");
            jSONObject3.put("requestTimeStamp", Calendar.getInstance().getTimeInMillis());
            jSONObject3.put("channelId", "APP");
            jSONObject3.put("version", "v2");
        } catch (JSONException e3) {
            q.b(e3.getMessage());
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("body", jSONObject2);
            jSONObject4.put("head", jSONObject3);
        } catch (JSONException e4) {
            q.b(e4.getMessage());
        }
        return jSONObject4.toString();
    }

    public static void performVerify(final Context context, final JSONObject jSONObject, final TokenizationApiResponse tokenizationApiResponse, final c.C0910c cVar) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("cartVerify", (String) null);
        if (TextUtils.isEmpty(a2)) {
            sendError(10, "", cVar);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a3 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, context);
        a3.put("wallet_token", t.c(context));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = context;
        bVar.f42878b = a.c.EDUCATION;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = a2;
        bVar.f42881e = null;
        bVar.f42884h = getBodyForVerifyAndCheckoutCall(tokenizationApiResponse, jSONObject, context);
        bVar.f42882f = a3;
        bVar.f42885i = new CJRRechargeCart();
        bVar.k = true;
        bVar.n = a.b.USER_FACING;
        bVar.o = "PaytmFirstCreditCardBillPayment";
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (CreditImplProvider.isCancelClicked) {
                    boolean unused = CreditImplProvider.isCancelClicked = false;
                    return;
                }
                CreditImplProvider.performCheckoutCall(context, tokenizationApiResponse, jSONObject, (CJRRechargeCart) iJRPaytmDataModel, cVar);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                String str = new String();
                try {
                    JSONObject jSONObject = new JSONObject(new String(networkResponse.data));
                    if (jSONObject.has("error_description")) {
                        str = jSONObject.getString("error_description");
                    } else if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                        str = networkCustomError.getAlertMessage();
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                CreditImplProvider.sendError(i2, str, cVar);
            }
        };
        bVar.l = true;
        bVar.k = true;
        com.paytm.network.a l = bVar.l();
        if (com.paytm.utility.a.m(context)) {
            l.a();
        } else {
            sendError(10, "Network Unavailable", cVar);
        }
    }

    /* access modifiers changed from: private */
    public static void performCheckoutCall(final Context context, TokenizationApiResponse tokenizationApiResponse, JSONObject jSONObject, final CJRRechargeCart cJRRechargeCart, final c.C0910c cVar) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("cartCheckout", (String) null);
        if (TextUtils.isEmpty(a2)) {
            sendError(10, "", cVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        HashMap<String, String> a3 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, context);
        a3.put("wallet_token", t.c(context));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("client_id", b.k());
        hashMap2.put("native_withdraw", "1");
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = context;
        bVar.f42878b = a.c.EDUCATION;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = a2;
        bVar.f42881e = null;
        bVar.f42884h = getBodyForVerifyAndCheckoutCall(tokenizationApiResponse, jSONObject, context);
        bVar.f42882f = a3;
        bVar.f42883g = hashMap2;
        bVar.f42885i = new CJRRechargePayment();
        bVar.n = a.b.USER_FACING;
        bVar.r = true;
        bVar.k = true;
        bVar.o = "PaytmFirstCreditCardBillPayment";
        bVar.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (CreditImplProvider.isCancelClicked) {
                    boolean unused = CreditImplProvider.isCancelClicked = false;
                } else {
                    CreditImplProvider.enablenativeSdk((CJRRechargePayment) iJRPaytmDataModel, cJRRechargeCart, context, cVar);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                String str = new String();
                try {
                    JSONObject jSONObject = new JSONObject(new String(networkResponse.data));
                    if (jSONObject.has("error_description")) {
                        str = jSONObject.getString("error_description");
                    } else if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                        str = networkCustomError.getAlertMessage();
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                CreditImplProvider.sendError(i2, str, cVar);
            }
        };
        bVar.l = true;
        bVar.k = true;
        com.paytm.network.a l = bVar.l();
        if (com.paytm.utility.a.m(context)) {
            l.a();
        } else {
            sendError(10, "Network Unavailable", cVar);
        }
    }

    private static String getBodyForVerifyAndCheckoutCall(TokenizationApiResponse tokenizationApiResponse, JSONObject jSONObject, Context context) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        try {
            jSONObject3.put("vertical_id", "");
            jSONObject3.put("qty", 1);
            if (jSONObject.has("productId")) {
                jSONObject3.put(CLPConstants.PRODUCT_ID, jSONObject.getString("productId"));
            } else {
                jSONObject3.put(CLPConstants.PRODUCT_ID, PRODUCT_ID);
            }
            jSONObject2.put("category_id", CATEGORY_ID);
            jSONObject4.put("bin_number", "438106");
            jSONObject2.put("recharge_number", tokenizationApiResponse.getBody().getMaskedCardNumber());
            jSONObject2.put("recharge_number_2", tokenizationApiResponse.getBody().getCardToken());
            jSONObject2.put("token_id", tokenizationApiResponse.getBody().getCardToken());
            jSONObject2.put("price", jSONObject.getString("amount"));
            jSONObject2.put("totalamount", jSONObject.getString("amount"));
            jSONObject4.put("enable_visa_direct", "0");
            jSONObject4.put("customer_mobile", com.paytm.utility.a.b(context));
            jSONObject4.put("id", com.paytm.utility.a.a(context));
            jSONObject4.put("enable_bill_payment", "1");
            jSONObject3.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject2);
            jSONObject3.put("metadata", jSONObject4);
            jSONArray.put(jSONObject3);
            jSONObject5.put("cart_items", jSONArray);
            jSONObject5.put("payment_request_type", "CC_BILL_PAYMENT");
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return jSONObject5.toString();
    }

    /* access modifiers changed from: private */
    public static void enablenativeSdk(final CJRRechargePayment cJRRechargePayment, final CJRRechargeCart cJRRechargeCart, final Context context, final c.C0910c cVar) {
        if ("1".equals(cJRRechargePayment.isNativeEnabled())) {
            t.a(context.getApplicationContext(), cJRRechargePayment, (FetchPayOptionsListener) new FetchPayOptionsListener() {
                public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
                }

                public final void onRequestStart() {
                }

                public final void onVpaReceived(VpaFetch vpaFetch) {
                }

                public final void onPaymentOptionsError() {
                    CreditImplProvider.openPG(context, cJRRechargePayment, cJRRechargeCart, cVar);
                }

                public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                    PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                    CreditImplProvider.openPG(context, cJRRechargePayment, cJRRechargeCart, cVar);
                }
            });
        } else {
            openPG(context, cJRRechargePayment, cJRRechargeCart, cVar);
        }
    }

    /* access modifiers changed from: private */
    public static void sendError(int i2, String str, c.C0910c cVar) {
        TokenModel tokenModel = new TokenModel();
        if (!TextUtils.isEmpty(str)) {
            tokenModel.setError(str);
        } else {
            tokenModel.setError("Something Went Wrong");
        }
        tokenModel.setErrorCode(i2);
        CCtoH5Response cCtoH5Response = new CCtoH5Response();
        cCtoH5Response.setData(tokenModel);
        cVar.onResult(new f().a((Object) cCtoH5Response));
    }

    /* access modifiers changed from: private */
    public static void openPG(Context context, CJRRechargePayment cJRRechargePayment, CJRRechargeCart cJRRechargeCart, c.C0910c cVar) {
        Intent intent = new Intent(context, AJRRechargePaymentActivity.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.setFlags(268435456);
        intent.putExtra("recharge cart", cJRRechargeCart);
        g.a(intent, cJRRechargePayment);
        context.startActivity(intent);
        cVar.onResult((Object) null);
    }
}
