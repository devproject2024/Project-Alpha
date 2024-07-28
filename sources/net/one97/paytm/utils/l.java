package net.one97.paytm.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.k;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRContingency;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.CJRUserDefaultInfo;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.RiskAnalysis.DeviceAccount;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.hometabs.HomeTabItem;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.y;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f69745a = "clientId";

    /* renamed from: b  reason: collision with root package name */
    public static String f69746b = "mid";

    /* renamed from: c  reason: collision with root package name */
    public static String f69747c = "requestId";

    /* renamed from: d  reason: collision with root package name */
    public static String f69748d = "token";

    /* renamed from: e  reason: collision with root package name */
    public static String f69749e = "tokenType";

    /* renamed from: f  reason: collision with root package name */
    public static String f69750f = "version";

    /* renamed from: g  reason: collision with root package name */
    public static String f69751g = "channelId";

    /* renamed from: h  reason: collision with root package name */
    public static String f69752h = "head";

    /* renamed from: i  reason: collision with root package name */
    public static String f69753i = "body";
    public static String j = "currency";
    public static String k = "orderId";
    public static String l = "SMART_NOTIFICATION_ID";
    public static String m = null;
    private static String n = "paytm";

    public static String a() {
        return CJRJarvisApplication.getAppContext().getString(R.string.app_stamping_scheme_others, new Object[]{"918b367", 720656, "1"});
    }

    public static String a(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        if (b.s()) {
            sb.append(".webp");
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02bc, code lost:
        if (net.one97.paytm.j.c.a("paytm_ga_mall_enabled", false) != false) goto L_0x02be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02fc, code lost:
        if (net.one97.paytm.j.c.a("notification_sdk_mall_enabled", false) != false) goto L_0x02fe;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.one97.paytm.common.entity.CJRUserInfoV2 r17, android.content.Context r18) {
        /*
            android.content.Context r0 = r18.getApplicationContext()
            com.paytm.b.a.a r0 = net.one97.paytm.utils.ag.a(r0)
            net.one97.paytm.common.entity.CJRUserDefaultInfo r1 = r17.getUserDefaultInfo()
            if (r1 != 0) goto L_0x000f
            return
        L_0x000f:
            net.one97.paytm.common.entity.wallet.MinKycDetails r2 = r17.getmMinKycDetails()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            boolean r5 = r2.getmIsMinKyc()
            java.lang.String r6 = "is_min_kyc"
            r0.a((java.lang.String) r6, (boolean) r5, (boolean) r4)
            java.lang.String r5 = r2.getmKycState()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r6 = "kyc_state"
            if (r5 != 0) goto L_0x0034
            java.lang.String r2 = r2.getmKycState()
            r0.a((java.lang.String) r6, (java.lang.String) r2, (boolean) r4)
            goto L_0x0037
        L_0x0034:
            r0.a((java.lang.String) r6, (java.lang.String) r3, (boolean) r4)
        L_0x0037:
            java.lang.String r2 = r1.getFirstName()
            java.lang.String r5 = r1.getLastName()
            java.lang.String r6 = r1.getEmail()
            java.lang.String r7 = r1.getPhone()
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 != 0) goto L_0x006a
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            if (r8 != 0) goto L_0x0068
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            java.lang.String r9 = " "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            goto L_0x006b
        L_0x0068:
            r8 = r2
            goto L_0x006b
        L_0x006a:
            r8 = r3
        L_0x006b:
            java.lang.String r9 = r17.getUserId()
            java.lang.String r10 = r1.getDob()
            java.lang.String r11 = r1.getUserPicture()
            java.lang.String r12 = r1.getGender()
            java.lang.String r13 = r1.getDisplayName()
            net.one97.paytm.common.entity.CJRDeviceBindingInfoV2 r14 = r17.getDeviceBindingInfo()
            if (r14 == 0) goto L_0x0092
            net.one97.paytm.oauth.utils.q r14 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.common.entity.CJRDeviceBindingInfoV2 r14 = r17.getDeviceBindingInfo()
            java.lang.String r14 = r14.getDeviceBindingMethod()
            net.one97.paytm.oauth.utils.q.i(r14)
        L_0x0092:
            java.util.ArrayList r14 = r17.getUserTypes()
            java.lang.String r15 = "userId"
            if (r9 == 0) goto L_0x00b4
            java.lang.String r16 = r9.trim()
            int r16 = r16.length()
            if (r16 <= 0) goto L_0x00b4
            r0.a((java.lang.String) r15, (java.lang.String) r9, (boolean) r4)
            java.lang.String r15 = net.one97.paytm.common.utility.b.aQ
            r0.a((java.lang.String) r15, (java.lang.String) r9, (boolean) r4)
            com.appsflyer.AppsFlyerLib r15 = com.appsflyer.AppsFlyerLib.getInstance()
            r15.setCustomerUserId(r9)
            goto L_0x00b7
        L_0x00b4:
            r0.a((java.lang.String) r15, (java.lang.String) r3, (boolean) r4)
        L_0x00b7:
            java.util.ArrayList r9 = r17.getUserSocialInfoList()
            java.lang.String r15 = "userImage"
            r3 = 0
            if (r9 == 0) goto L_0x00e3
            java.util.ArrayList r9 = r17.getUserSocialInfoList()
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x00e3
            java.util.ArrayList r9 = r17.getUserSocialInfoList()
            java.lang.Object r9 = r9.get(r3)
            net.one97.paytm.common.entity.CJRUserSocialInfoV2 r9 = (net.one97.paytm.common.entity.CJRUserSocialInfoV2) r9
            net.one97.paytm.common.entity.CJRUserSocialInfoV2$SocialSiteInfo r9 = r9.getSocialSiteInfo()
            java.lang.String r9 = r9.getPicture()
            com.paytm.utility.a.c()
            r0.a((java.lang.String) r15, (java.lang.String) r9, (boolean) r4)
            goto L_0x00ea
        L_0x00e3:
            com.paytm.utility.a.c()
            r9 = 0
            r0.a((java.lang.String) r15, (java.lang.String) r9, (boolean) r4)
        L_0x00ea:
            java.lang.String r9 = "isPasswordSet"
            boolean r15 = r0.b((java.lang.String) r9, (boolean) r3, (boolean) r4)
            if (r15 != 0) goto L_0x00ff
            boolean r15 = r17.isPasswordSet()
            if (r15 == 0) goto L_0x00ff
            boolean r15 = r17.isPasswordSet()
            r0.a((java.lang.String) r9, (boolean) r15, (boolean) r4)
        L_0x00ff:
            java.lang.String r9 = "first name"
            if (r2 == 0) goto L_0x0112
            java.lang.String r15 = r2.trim()
            int r15 = r15.length()
            if (r15 <= 0) goto L_0x0112
            r0.a((java.lang.String) r9, (java.lang.String) r2, (boolean) r4)
            r2 = 0
            goto L_0x0116
        L_0x0112:
            r2 = 0
            r0.a((java.lang.String) r9, (java.lang.String) r2, (boolean) r4)
        L_0x0116:
            java.lang.String r9 = "last name"
            if (r5 == 0) goto L_0x0128
            java.lang.String r15 = r5.trim()
            int r15 = r15.length()
            if (r15 <= 0) goto L_0x0128
            r0.a((java.lang.String) r9, (java.lang.String) r5, (boolean) r4)
            goto L_0x012b
        L_0x0128:
            r0.a((java.lang.String) r9, (java.lang.String) r2, (boolean) r4)
        L_0x012b:
            java.lang.String r5 = "email"
            if (r6 == 0) goto L_0x013d
            java.lang.String r9 = r6.trim()
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x013d
            r0.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r4)
            goto L_0x0140
        L_0x013d:
            r0.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r4)
        L_0x0140:
            java.lang.String r2 = "mobile"
            if (r7 == 0) goto L_0x0158
            java.lang.String r5 = r7.trim()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0158
            r0.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r4)
            java.lang.String r2 = "roaming_mobile_no"
            r0.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r4)
            r5 = 0
            goto L_0x015c
        L_0x0158:
            r5 = 0
            r0.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
        L_0x015c:
            java.lang.String r2 = "userName"
            if (r8 == 0) goto L_0x016e
            java.lang.String r6 = r8.trim()
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x016e
            r0.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r4)
            goto L_0x0171
        L_0x016e:
            r0.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
        L_0x0171:
            if (r10 == 0) goto L_0x0183
            java.lang.String r2 = r10.trim()
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0183
            java.lang.String r2 = "user_dob"
            r0.a((java.lang.String) r2, (java.lang.String) r10, (boolean) r4)
            goto L_0x0189
        L_0x0183:
            java.lang.String r2 = "user_dob"
            r5 = 0
            r0.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
        L_0x0189:
            if (r12 == 0) goto L_0x019b
            java.lang.String r2 = r12.trim()
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x019b
            java.lang.String r2 = "user_gender"
            r0.a((java.lang.String) r2, (java.lang.String) r12, (boolean) r4)
            goto L_0x01a1
        L_0x019b:
            java.lang.String r2 = "user_gender"
            r5 = 0
            r0.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
        L_0x01a1:
            if (r11 == 0) goto L_0x01b3
            java.lang.String r2 = r11.trim()
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x01b3
            java.lang.String r2 = "profilePic"
            r0.a((java.lang.String) r2, (java.lang.String) r11, (boolean) r4)
            goto L_0x01b9
        L_0x01b3:
            java.lang.String r2 = "profilePic"
            r5 = 0
            r0.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
        L_0x01b9:
            if (r13 == 0) goto L_0x01cb
            java.lang.String r2 = r13.trim()
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x01cb
            java.lang.String r2 = "display_name"
            r0.a((java.lang.String) r2, (java.lang.String) r13, (boolean) r4)
            goto L_0x01d1
        L_0x01cb:
            java.lang.String r2 = "display_name"
            r5 = 0
            r0.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
        L_0x01d1:
            java.lang.String r2 = "user_Type_merchant"
            java.lang.String r5 = "userType"
            java.lang.String r6 = "NO_MERCHANT"
            if (r14 == 0) goto L_0x022b
            r0.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r4)
            r0.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r4)
            r6 = 0
        L_0x01e0:
            int r7 = r14.size()
            if (r6 >= r7) goto L_0x0231
            java.lang.Object r7 = r14.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x01fe
            java.lang.String r8 = "SD_MERCHANT"
            boolean r8 = r7.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x01fe
            r0.a((java.lang.String) r5, (java.lang.String) r7, (boolean) r4)
            goto L_0x0228
        L_0x01fe:
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x0215
            java.lang.String r8 = "merchant"
            boolean r8 = r7.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0215
            r0.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r4)
            java.lang.String r7 = "is_merchant_user"
            r0.a((java.lang.String) r7, (boolean) r4, (boolean) r4)
            goto L_0x0228
        L_0x0215:
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x0228
            java.lang.String r8 = "IND_RESELLER"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x0228
            java.lang.String r7 = "is_reseller_user"
            r0.a((java.lang.String) r7, (boolean) r4, (boolean) r4)
        L_0x0228:
            int r6 = r6 + 1
            goto L_0x01e0
        L_0x022b:
            r0.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r4)
            r0.a((java.lang.String) r2, (java.lang.String) r6, (boolean) r4)
        L_0x0231:
            boolean r2 = r1.isKyc()
            java.lang.String r5 = "isPrime"
            r0.a((java.lang.String) r5, (boolean) r2, (boolean) r4)
            boolean r2 = r1.isPhoneVerificationStatus()
            java.lang.String r5 = "isVerifiedMobile"
            r0.a((java.lang.String) r5, (int) r2, (boolean) r4)
            java.lang.String r2 = "pref_key_fetching_user_info"
            r0.a((java.lang.String) r2, (boolean) r3, (boolean) r4)
            boolean r1 = r1.isEmailVerificationStatus()
            java.lang.String r2 = "isVerifiedEmail"
            r0.a((java.lang.String) r2, (int) r1, (boolean) r4)
            net.one97.paytm.common.entity.CJRUserInfoV2$PassbookUserAttributeInfo r1 = r17.getUserAttributeInfo()
            if (r1 == 0) goto L_0x0263
            net.one97.paytm.common.entity.CJRUserInfoV2$PassbookUserAttributeInfo r1 = r17.getUserAttributeInfo()
            boolean r1 = r1.getGoldAccountFlag()
            if (r1 == 0) goto L_0x0263
            r1 = 1
            goto L_0x0264
        L_0x0263:
            r1 = 0
        L_0x0264:
            net.one97.paytm.common.entity.CJRUserInfoV2$PassbookUserAttributeInfo r2 = r17.getUserAttributeInfo()
            if (r2 == 0) goto L_0x0277
            net.one97.paytm.common.entity.CJRUserInfoV2$PassbookUserAttributeInfo r2 = r17.getUserAttributeInfo()
            java.lang.String r2 = r2.getPostpaidStatus()
            java.lang.String r5 = "POSTPAID_STATUS"
            r0.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r4)
        L_0x0277:
            java.lang.String r2 = "isGoldUser"
            r0.a((java.lang.String) r2, (boolean) r1, (boolean) r4)
            net.one97.paytm.common.entity.CJRUserInfoV2$PassbookUserAttributeInfo r1 = r17.getUserAttributeInfo()
            if (r1 != 0) goto L_0x0284
            r1 = 0
            goto L_0x028c
        L_0x0284:
            net.one97.paytm.common.entity.CJRUserInfoV2$PassbookUserAttributeInfo r1 = r17.getUserAttributeInfo()
            boolean r1 = r1.getCreditCardFlag()
        L_0x028c:
            java.lang.String r2 = "isCreditCard"
            r0.a((java.lang.String) r2, (boolean) r1, (boolean) r4)
            com.paytm.utility.a.c()
            androidx.localbroadcastmanager.a.a r0 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r18)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "action_update_flyout"
            r1.<init>(r2)
            r0.a((android.content.Intent) r1)
            boolean r0 = com.paytm.utility.k.b()
            if (r0 != 0) goto L_0x0360
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r0 = "paytm_ga_enabled"
            boolean r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (boolean) r4)     // Catch:{ Exception -> 0x02e0 }
            if (r0 != 0) goto L_0x02be
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r0 = "paytm_ga_mall_enabled"
            boolean r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (boolean) r3)     // Catch:{ Exception -> 0x02e0 }
            if (r0 == 0) goto L_0x02e8
        L_0x02be:
            com.paytm.analytics.b$b r0 = com.paytm.analytics.b.f40911e     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r18)     // Catch:{ Exception -> 0x02e0 }
            kotlinx.coroutines.GlobalScope r1 = kotlinx.coroutines.GlobalScope.INSTANCE     // Catch:{ Exception -> 0x02e0 }
            r5 = r1
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5     // Catch:{ Exception -> 0x02e0 }
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x02e0 }
            r6 = r1
            kotlin.d.f r6 = (kotlin.d.f) r6     // Catch:{ Exception -> 0x02e0 }
            r7 = 0
            com.paytm.analytics.b$b$d r1 = new com.paytm.analytics.b$b$d     // Catch:{ Exception -> 0x02e0 }
            r2 = 0
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x02e0 }
            r8 = r1
            kotlin.g.a.m r8 = (kotlin.g.a.m) r8     // Catch:{ Exception -> 0x02e0 }
            r9 = 2
            r10 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x02e0 }
            goto L_0x02e8
        L_0x02e0:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x02e8:
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0308 }
            java.lang.String r0 = "notification_sdk_enabled"
            boolean r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (boolean) r4)     // Catch:{ Exception -> 0x0308 }
            if (r0 != 0) goto L_0x02fe
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0308 }
            java.lang.String r0 = "notification_sdk_mall_enabled"
            boolean r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (boolean) r3)     // Catch:{ Exception -> 0x0308 }
            if (r0 == 0) goto L_0x0310
        L_0x02fe:
            com.paytm.notification.g$c r0 = com.paytm.notification.g.f43191a     // Catch:{ Exception -> 0x0308 }
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r18)     // Catch:{ Exception -> 0x0308 }
            com.paytm.notification.g.c.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0308 }
            goto L_0x0310
        L_0x0308:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0310:
            com.paytm.erroranalytics.e r0 = com.paytm.erroranalytics.e.a()     // Catch:{ Exception -> 0x0358 }
            com.paytm.erroranalytics.c.a$a r1 = new com.paytm.erroranalytics.c.a$a     // Catch:{ Exception -> 0x0358 }
            r1.<init>()     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = com.paytm.utility.a.a((android.content.Context) r18)     // Catch:{ Exception -> 0x0358 }
            r1.f42719b = r2     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = com.paytm.utility.a.d(r18)     // Catch:{ Exception -> 0x0358 }
            r1.f42718a = r2     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = "release"
            r1.f42724g = r2     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = "paytm"
            r1.f42725h = r2     // Catch:{ Exception -> 0x0358 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = net.one97.paytm.j.c.R()     // Catch:{ Exception -> 0x0358 }
            r1.f42723f = r2     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = "androidapp"
            r1.f42726i = r2     // Catch:{ Exception -> 0x0358 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = "error_sdk_event_scheduling_time_sec"
            int r2 = net.one97.paytm.j.c.a((java.lang.String) r2, (int) r3)     // Catch:{ Exception -> 0x0358 }
            r1.j = r2     // Catch:{ Exception -> 0x0358 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0358 }
            java.lang.String r2 = "show_error_analytics_logs"
            boolean r2 = net.one97.paytm.j.c.a((java.lang.String) r2, (boolean) r3)     // Catch:{ Exception -> 0x0358 }
            r1.k = r2     // Catch:{ Exception -> 0x0358 }
            com.paytm.erroranalytics.c.a r1 = r1.a()     // Catch:{ Exception -> 0x0358 }
            r0.a((com.paytm.erroranalytics.c.a) r1)     // Catch:{ Exception -> 0x0358 }
            goto L_0x0360
        L_0x0358:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0360:
            net.one97.paytm.upi.i.a(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.l.a(net.one97.paytm.common.entity.CJRUserInfoV2, android.content.Context):void");
    }

    public static void a(CJRUserInfo cJRUserInfo, Context context) {
        String str;
        boolean z;
        String str2;
        boolean z2;
        a a2 = ag.a(context.getApplicationContext());
        String firstName = cJRUserInfo.getFirstName();
        String lastName = cJRUserInfo.getLastName();
        String email = cJRUserInfo.getEmail();
        String mobile = cJRUserInfo.getMobile();
        String userName = cJRUserInfo.getUserName();
        String id = cJRUserInfo.getId();
        String b2 = a2.b("userId", "", true);
        if (b2.equals("")) {
            b2 = null;
        }
        String dob = cJRUserInfo.getDOB();
        String displayName = cJRUserInfo.getDisplayName();
        String userPicture = cJRUserInfo.getUserPicture();
        String gender = cJRUserInfo.getGender();
        String isUserPrime = cJRUserInfo.getIsUserPrime();
        if (id == null || id.trim().length() <= 0) {
            a2.a("userId", (String) null, true);
        } else {
            a2.a("userId", cJRUserInfo.getId(), true);
            a2.a(net.one97.paytm.common.utility.b.aQ, cJRUserInfo.getId(), true);
        }
        if (cJRUserInfo.getUserSocialInfoList() == null || cJRUserInfo.getUserSocialInfoList().size() <= 0) {
            str = isUserPrime;
            com.paytm.utility.a.c();
            a2.a("userImage", (String) null, true);
        } else {
            str = isUserPrime;
            new StringBuilder("saving user image url :: ").append(cJRUserInfo.getUserSocialInfoList().get(0).getImageUrl());
            com.paytm.utility.a.c();
            a2.a("userImage", cJRUserInfo.getUserSocialInfoList().get(0).getImageUrl(), true);
        }
        if (id != null) {
            id.equalsIgnoreCase(b2);
        }
        if (firstName == null || firstName.trim().length() <= 0) {
            z = true;
            a2.a("first name", (String) null, true);
        } else {
            z = true;
            a2.a("first name", cJRUserInfo.getFirstName(), true);
        }
        if (lastName == null || lastName.trim().length() <= 0) {
            a2.a("last name", (String) null, z);
        } else {
            a2.a("last name", cJRUserInfo.getLastName(), z);
        }
        if (email == null || email.trim().length() <= 0) {
            a2.a(AppConstants.KEY_EMAIL, (String) null, z);
        } else {
            a2.a(AppConstants.KEY_EMAIL, cJRUserInfo.getEmail(), z);
        }
        if (mobile == null || mobile.trim().length() <= 0) {
            a2.a("mobile", (String) null, z);
        } else {
            a2.a("mobile", cJRUserInfo.getMobile(), z);
            a2.a("roaming_mobile_no", cJRUserInfo.getMobile(), z);
        }
        if (userName == null || userName.trim().length() <= 0) {
            a2.a("userName", (String) null, z);
        } else {
            a2.a("userName", cJRUserInfo.getUserName(), z);
        }
        if (dob == null || dob.trim().length() <= 0) {
            str2 = null;
            a2.a("user_dob", (String) null, z);
        } else {
            a2.a("user_dob", cJRUserInfo.getDOB(), z);
            str2 = null;
        }
        if (displayName == null || displayName.trim().length() <= 0) {
            a2.a("display_name", str2, z);
        } else {
            a2.a("display_name", displayName, z);
        }
        if (gender == null || gender.trim().length() <= 0) {
            a2.a("user_gender", (String) null, z);
        } else {
            a2.a("user_gender", cJRUserInfo.getGender(), z);
        }
        if (userPicture == null || userPicture.trim().length() <= 0) {
            a2.a(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, (String) null, z);
        } else {
            a2.a(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, cJRUserInfo.getUserPicture(), z);
        }
        if (str == null || str.trim().length() <= 0 || str == null || !str.equalsIgnoreCase("prime")) {
            z2 = false;
            a2.a("isPrime", false, z);
        } else {
            a2.a("isPrime", z, z);
            z2 = false;
        }
        a2.a("isVerifiedMobile", cJRUserInfo.getIsVerifiedMobile(), z);
        a2.a("pref_key_fetching_user_info", z2, z);
        a2.a("isVerifiedEmail", cJRUserInfo.getIsVerifiedEmail(), z);
        com.paytm.utility.a.c();
    }

    @Deprecated
    public static CJRUserInfoV2 a(CJRUserInfo cJRUserInfo) {
        CJRUserInfoV2 cJRUserInfoV2 = new CJRUserInfoV2();
        CJRUserDefaultInfo cJRUserDefaultInfo = new CJRUserDefaultInfo();
        cJRUserInfoV2.setUserDefaultInfo(cJRUserDefaultInfo);
        cJRUserInfoV2.setUserId(cJRUserInfo.getId());
        cJRUserInfoV2.setMessage(cJRUserInfo.getMessage());
        cJRUserDefaultInfo.setFirstName(cJRUserInfo.getFirstName());
        cJRUserDefaultInfo.setLastName(cJRUserInfo.getLastName());
        cJRUserDefaultInfo.setDisplayName(cJRUserInfo.getDisplayName());
        cJRUserDefaultInfo.setGender(cJRUserInfo.getGender());
        cJRUserDefaultInfo.setEmail(cJRUserInfo.getEmail());
        cJRUserDefaultInfo.setPhone(cJRUserInfo.getMobile());
        cJRUserDefaultInfo.setDob(cJRUserInfo.getDOB());
        cJRUserDefaultInfo.setIsKyc(cJRUserInfo.getIsUserPrime().equalsIgnoreCase("prime"));
        boolean z = false;
        cJRUserDefaultInfo.setEmailVerificationStatus(cJRUserInfo.getIsVerifiedEmail() == 1);
        if (cJRUserInfo.getIsVerifiedMobile() == 1) {
            z = true;
        }
        cJRUserDefaultInfo.setPhoneVerificationStatus(z);
        cJRUserDefaultInfo.setCustomerCreationDate(cJRUserInfo.getCreatedAt());
        cJRUserDefaultInfo.setCustomerStatus(cJRUserInfo.getStatus().equalsIgnoreCase("1") ? "active" : "inactive");
        cJRUserDefaultInfo.setUserPicture(cJRUserInfo.getUserPicture());
        return cJRUserInfoV2;
    }

    public static void a(Activity activity, NetworkCustomError networkCustomError) {
        String str;
        if (activity != null && !activity.isFinishing() && networkCustomError != null) {
            if (networkCustomError.getMessage() == null || (!networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401) && !networkCustomError.getMessage().equalsIgnoreCase("410") && !networkCustomError.getMessage().equalsIgnoreCase("403"))) {
                String fullUrl = networkCustomError.getFullUrl();
                if (!TextUtils.isEmpty(fullUrl)) {
                    StringBuilder sb = new StringBuilder();
                    c.a();
                    sb.append(c.B());
                    if (fullUrl.contains(sb.toString())) {
                        a((Context) activity, networkCustomError, "error.auth@paytm.com");
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    c.a();
                    sb2.append(c.A());
                    if (!fullUrl.contains(sb2.toString())) {
                        StringBuilder sb3 = new StringBuilder();
                        c.a();
                        sb3.append(c.z());
                        if (!fullUrl.contains(sb3.toString())) {
                            StringBuilder sb4 = new StringBuilder();
                            c.a();
                            sb4.append(c.C());
                            if (fullUrl.contains(sb4.toString())) {
                                a((Context) activity, networkCustomError, "error.wallet@paytm.com");
                                return;
                            }
                            return;
                        }
                    }
                    a((Context) activity, networkCustomError, "error.kyc@paytm.com");
                }
            } else if (activity != null && !activity.isFinishing()) {
                String str2 = null;
                if (networkCustomError != null) {
                    str2 = networkCustomError.getAlertMessage();
                    str = networkCustomError.getAlertTitle();
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = activity.getResources().getString(R.string.message_401_410);
                }
                if (TextUtils.isEmpty(str)) {
                    activity.getResources().getString(R.string.title_401_410);
                }
                String b2 = t.b((Context) activity);
                if (!TextUtils.isEmpty(b2)) {
                    String concat = "/".concat(String.valueOf(b2));
                    if (!TextUtils.isEmpty(str2) && str2.contains(concat)) {
                        str2 = str2.replace(concat, "");
                    }
                }
                String g2 = t.g(activity);
                if (!TextUtils.isEmpty(g2)) {
                    String concat2 = "/".concat(String.valueOf(g2));
                    if (!TextUtils.isEmpty(str2) && str2.contains(concat2)) {
                        str2.replace(concat2, "");
                    }
                }
                String q = com.paytm.utility.a.q(activity);
                as.a().a(activity);
                Intent intent = new Intent(activity, AJRAuthActivity.class);
                if (k.b()) {
                    intent.setFlags(32768);
                }
                intent.putExtra("authError", true);
                intent.putExtra("prev_token", q);
                intent.putExtra("finish_current", true);
                intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                activity.startActivity(intent);
            }
        }
    }

    private static boolean a(Context context, NetworkCustomError networkCustomError, String str) {
        String str2;
        String message = networkCustomError.getMessage();
        if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("failure_error")) {
            String str3 = null;
            if (TextUtils.isEmpty(message) || (!message.equalsIgnoreCase("499") && !message.equalsIgnoreCase("502") && !message.equalsIgnoreCase("503") && !message.equalsIgnoreCase("504"))) {
                str2 = null;
            } else {
                str3 = networkCustomError.getAlertMessage();
                str2 = networkCustomError.getAlertTitle();
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("499")) {
                    str3 = context.getResources().getString(R.string.message_499);
                    str2 = context.getResources().getString(R.string.title_499);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("502")) {
                    str3 = context.getResources().getString(R.string.message_502);
                    str2 = context.getResources().getString(R.string.title_502);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("503")) {
                    str3 = context.getResources().getString(R.string.message_503);
                    str2 = context.getResources().getString(R.string.title_503);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("504")) {
                    str3 = context.getResources().getString(R.string.message_504);
                    str2 = context.getResources().getString(R.string.title_504);
                }
            }
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("503")) {
                b(context, networkCustomError, str);
                return true;
            }
            b(context, str3, str2);
            return true;
        } else if (networkCustomError == null || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
            return false;
        } else {
            b.b(context, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            return true;
        }
    }

    private static void b(Context context, NetworkCustomError networkCustomError, String str) {
        if (context != null && networkCustomError != null) {
            String string = context.getString(R.string.error_dialog_title);
            String string2 = context.getString(R.string.error_dialog_message);
            String b2 = t.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat = "/".concat(String.valueOf(b2));
                if (string2.contains(concat)) {
                    string2 = string2.replace(concat, "");
                }
            }
            String g2 = t.g(context);
            if (!TextUtils.isEmpty(g2)) {
                String concat2 = "/".concat(String.valueOf(g2));
                if (string2.contains(concat2)) {
                    string2 = string2.replace(concat2, "");
                }
            }
            y.a(context, string, string2, new y.a(context, str) {
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onDialogDismissed() {
                    b.a(NetworkCustomError.this.getUrl(), NetworkCustomError.this.getMessage(), this.f$1, this.f$2);
                }
            });
        }
    }

    @Deprecated
    public static void a(Activity activity, NetworkCustomError networkCustomError, String str) {
        String str2;
        if (activity != null && !activity.isFinishing() && networkCustomError != null) {
            if (networkCustomError.getMessage() == null || (!networkCustomError.getMessage().equalsIgnoreCase("406") && !networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401) && !networkCustomError.getMessage().equalsIgnoreCase("410") && !networkCustomError.getMessage().equalsIgnoreCase("403"))) {
                String fullUrl = networkCustomError.getFullUrl();
                if (!TextUtils.isEmpty(fullUrl)) {
                    StringBuilder sb = new StringBuilder();
                    c.a();
                    sb.append(c.B());
                    if (fullUrl.contains(sb.toString())) {
                        d(activity, networkCustomError, "error.auth@paytm.com");
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    c.a();
                    sb2.append(c.A());
                    if (!fullUrl.contains(sb2.toString())) {
                        StringBuilder sb3 = new StringBuilder();
                        c.a();
                        sb3.append(c.z());
                        if (!fullUrl.contains(sb3.toString())) {
                            StringBuilder sb4 = new StringBuilder();
                            c.a();
                            sb4.append(c.C());
                            if (fullUrl.contains(sb4.toString())) {
                                d(activity, networkCustomError, "error.wallet@paytm.com");
                                return;
                            }
                            return;
                        }
                    }
                    d(activity, networkCustomError, "error.kyc@paytm.com");
                }
            } else if (activity != null && !activity.isFinishing()) {
                String str3 = null;
                if (networkCustomError != null) {
                    str3 = networkCustomError.getAlertMessage();
                    str2 = networkCustomError.getAlertTitle();
                } else {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = activity.getResources().getString(R.string.message_401_410);
                }
                if (TextUtils.isEmpty(str2)) {
                    activity.getResources().getString(R.string.title_401_410);
                }
                String b2 = t.b((Context) activity);
                if (!TextUtils.isEmpty(b2)) {
                    String concat = "/".concat(String.valueOf(b2));
                    if (!TextUtils.isEmpty(str3) && str3.contains(concat)) {
                        str3 = str3.replace(concat, "");
                    }
                }
                String g2 = t.g(activity);
                if (!TextUtils.isEmpty(g2)) {
                    String concat2 = "/".concat(String.valueOf(g2));
                    if (!TextUtils.isEmpty(str3) && str3.contains(concat2)) {
                        str3.replace(concat2, "");
                    }
                }
                String q = com.paytm.utility.a.q(activity);
                as.a().a(activity);
                Intent intent = new Intent(activity, AJRAuthActivity.class);
                if (k.b()) {
                    intent.setFlags(32768);
                }
                intent.putExtra("authError", true);
                intent.putExtra("prev_token", q);
                intent.putExtra("finish_current", true);
                if (str != null) {
                    intent.putExtra("resultant activity", str);
                    intent.putExtra("sign_in_sign_up_with_step_2", true);
                }
                intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                activity.startActivity(intent);
            }
        }
    }

    @Deprecated
    public static boolean a(Context context, VolleyError volleyError) {
        String str;
        if (context == null || volleyError == null) {
            return true;
        }
        net.one97.paytm.app.b bVar = (net.one97.paytm.app.b) volleyError;
        String message = bVar.getMessage();
        if ("parsing_error".equalsIgnoreCase(message)) {
            return false;
        }
        String alertTitle = bVar.getAlertTitle();
        String alertMessage = bVar.getAlertMessage();
        if (TextUtils.isEmpty(alertTitle) || TextUtils.isEmpty(alertMessage)) {
            CJRError a2 = net.one97.paytm.common.a.a.a(message);
            str = a2.getMessage() + "(" + bVar.getUrl() + " | HTTP " + bVar.getMessage() + ")";
            alertTitle = a2.getTitle();
        } else {
            str = alertMessage;
        }
        if (message.equalsIgnoreCase("503")) {
            b(context, str, alertTitle);
            return true;
        }
        b.b(context, alertTitle, str);
        return true;
    }

    @Deprecated
    public static CJRError b(Context context, VolleyError volleyError) {
        net.one97.paytm.app.b bVar = (net.one97.paytm.app.b) volleyError;
        String message = bVar.getMessage();
        if ("parsing_error".equalsIgnoreCase(message)) {
            return null;
        }
        CJRError cJRError = new CJRError();
        cJRError.setTitle(bVar.getAlertTitle());
        cJRError.setMessage(bVar.getAlertMessage());
        if (TextUtils.isEmpty(cJRError.getTitle()) || TextUtils.isEmpty(cJRError.getMessage())) {
            cJRError = net.one97.paytm.common.a.a.a(message);
            cJRError.setMessage(cJRError.getMessage() + "(" + bVar.getUrl() + " | HTTP " + bVar.getMessage() + ")");
        }
        if (!message.equalsIgnoreCase("503")) {
            return cJRError;
        }
        b(context, cJRError.getMessage(), cJRError.getTitle());
        return null;
    }

    public static CJRError a(Context context, NetworkCustomError networkCustomError) {
        StringBuilder sb = new StringBuilder();
        sb.append(networkCustomError.getStatusCode());
        String sb2 = sb.toString();
        if ("parsing_error".equalsIgnoreCase(sb2)) {
            return null;
        }
        CJRError cJRError = new CJRError();
        cJRError.setTitle(networkCustomError.getAlertTitle());
        cJRError.setMessage(networkCustomError.getAlertMessage());
        if (TextUtils.isEmpty(cJRError.getTitle()) || TextUtils.isEmpty(cJRError.getMessage())) {
            cJRError = net.one97.paytm.common.a.a.a(sb2);
            cJRError.setMessage(cJRError.getMessage() + "(" + networkCustomError.getUrl() + " | HTTP " + networkCustomError.getMessage() + ")");
        }
        if (!sb2.equalsIgnoreCase("503")) {
            return cJRError;
        }
        b(context, cJRError.getMessage(), cJRError.getTitle());
        return null;
    }

    @Deprecated
    private static void b(final Context context, final String str, final String str2) {
        if (context != null) {
            c.a();
            String g2 = c.g();
            if (g2 != null) {
                String c2 = com.paytm.utility.a.c(context, g2);
                String g3 = t.g(context);
                if (!TextUtils.isEmpty(g3)) {
                    c2 = c2 + "&cart_id=" + g3;
                }
                d.a(context, c2, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        CJRContingency cJRContingency = (CJRContingency) iJRPaytmDataModel;
                        if (cJRContingency == null) {
                            return;
                        }
                        if (cJRContingency.getStatus()) {
                            Intent intent = new Intent(context, AJREmbedWebView.class);
                            intent.putExtra("url", cJRContingency.getUrl());
                            intent.putExtra("title", cJRContingency.getMessage());
                            intent.putExtra(UpiConstants.FROM, "Contingency");
                            intent.putExtra("Maintenance", false);
                            intent.putExtra("maintaince_error_503", true);
                            intent.putExtra("Close", cJRContingency.getClose());
                            intent.putExtra("alert_title", str2);
                            intent.putExtra("alert_message", str);
                            intent.addFlags(67108864);
                            intent.addFlags(268435456);
                            context.startActivity(intent);
                            ((Activity) context).finish();
                            return;
                        }
                        b.b(context, str2, str);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (!TextUtils.isEmpty(networkCustomError.getMessage()) && networkCustomError.getMessage().equalsIgnoreCase("503")) {
                            String string = context.getResources().getString(R.string.contingency_503_message);
                            b.b(context, context.getResources().getString(R.string.contingency_503_title), string);
                        }
                    }
                }, com.paytm.utility.a.a((HashMap<String, String>) new HashMap(), context), (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRContingency(), a.c.HOME, a.b.SILENT).a();
                return;
            }
            b.b(context, str2, str);
        }
    }

    @Deprecated
    public static CJRError a(Context context, String str) {
        String string = context.getResources().getString(R.string.message_error_data_display);
        if (!TextUtils.isEmpty(str)) {
            string = string + "(" + str + ")";
        }
        String string2 = context.getResources().getString(R.string.error_data_display);
        CJRError cJRError = new CJRError();
        cJRError.setTitle(string2);
        cJRError.setMessage(string);
        return cJRError;
    }

    @Deprecated
    public static boolean a(CJRRechargeCart cJRRechargeCart, Context context) {
        String string = context.getResources().getString(R.string.unable_to_proceed);
        Iterator<CJRCartProduct> it2 = cJRRechargeCart.getCart().getCartItems().iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            if (next.getError() != null) {
                String errorCode = next.getErrorCode();
                if (TextUtils.isEmpty(errorCode) || (!"CT_CP_4001".equalsIgnoreCase(errorCode) && !"CT_CP_4010".equalsIgnoreCase(errorCode))) {
                    String errorTitle = next.getErrorTitle();
                    if (errorTitle == null || errorTitle.trim().length() <= 0) {
                        b.b(context, string, next.getError());
                    } else {
                        b.b(context, errorTitle, next.getError());
                    }
                    return true;
                }
                b.b(context, context.getResources().getString(R.string.title_msg_for_deals), context.getResources().getString(R.string.error_msg_for_deals));
                return true;
            }
        }
        if (cJRRechargeCart.getCart().getError() == null) {
            return false;
        }
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            b.b(context, context.getResources().getString(R.string.network_error_heading), context.getResources().getString(R.string.network_error_message));
        } else {
            String errorTitle2 = cJRRechargeCart.getCart().getErrorTitle();
            if (errorTitle2 != null && errorTitle2.trim().length() > 0) {
                string = errorTitle2;
            }
            b.b(context, string, cJRRechargeCart.getCart().getError());
        }
        return true;
    }

    @Deprecated
    public static String a(Context context, String str, String str2) {
        return c(context, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dc A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e3 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ea A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f1 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0102 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010b A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0112 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0130 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014c A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0154 A[Catch:{ Exception -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x015a A[Catch:{ Exception -> 0x0173 }] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.Context r24, java.lang.String r25, java.lang.String r26) {
        /*
            r1 = r25
            r2 = r26
            java.lang.String r3 = ""
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r10 = com.paytm.utility.a.g(r24)
            java.lang.String r11 = com.paytm.utility.a.h(r24)
            java.lang.String r12 = android.os.Build.MANUFACTURER
            java.lang.String r13 = android.os.Build.MODEL
            java.lang.String r14 = android.os.Build.VERSION.RELEASE
            java.lang.String r15 = com.paytm.utility.a.l(r24)
            r16 = r8
            java.lang.String r8 = android.os.Build.DEVICE
            java.lang.String r0 = "http.agent"
            java.lang.String r2 = java.lang.System.getProperty(r0)
            r17 = r9
            java.lang.String r9 = com.paytm.utility.a.s(r24)
            java.lang.String r1 = com.paytm.utility.a.w(r24)
            android.content.ContentResolver r0 = r24.getContentResolver()
            r18 = r5
            java.lang.String r5 = "android_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r0, r5)
            r19 = r5
            java.lang.String r5 = com.paytm.utility.a.d()
            android.content.pm.PackageManager r0 = r24.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0074 }
            r20 = r9
            java.lang.String r9 = r24.getPackageName()     // Catch:{ NameNotFoundException -> 0x0072 }
            r21 = r15
            r15 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r9, r15)     // Catch:{ NameNotFoundException -> 0x0070 }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x0070 }
            goto L_0x0085
        L_0x0070:
            r0 = move-exception
            goto L_0x0079
        L_0x0072:
            r0 = move-exception
            goto L_0x0077
        L_0x0074:
            r0 = move-exception
            r20 = r9
        L_0x0077:
            r21 = r15
        L_0x0079:
            boolean r9 = com.paytm.utility.b.v
            if (r9 == 0) goto L_0x0084
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0084:
            r0 = 0
        L_0x0085:
            r22 = 0
            boolean r9 = com.paytm.utility.a.p(r24)
            if (r9 == 0) goto L_0x00a1
            java.lang.String r9 = com.paytm.utility.a.a((android.content.Context) r24)
            boolean r15 = android.text.TextUtils.isEmpty(r9)
            if (r15 != 0) goto L_0x00a1
            boolean r15 = android.text.TextUtils.isDigitsOnly(r9)
            if (r15 == 0) goto L_0x00a1
            long r22 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x00a1 }
        L_0x00a1:
            r15 = r8
            r8 = r22
            r22 = r0
            java.lang.String r0 = "user_id"
            r4.put(r0, r8)     // Catch:{ Exception -> 0x0173 }
            if (r1 == 0) goto L_0x00b2
            java.lang.String r0 = "ga_id"
            r4.put(r0, r1)     // Catch:{ Exception -> 0x0173 }
        L_0x00b2:
            java.lang.String r0 = "experiment_id"
            java.lang.String r8 = net.one97.paytm.common.utility.b.s     // Catch:{ Exception -> 0x0173 }
            r4.put(r0, r8)     // Catch:{ Exception -> 0x0173 }
            if (r10 == 0) goto L_0x00c0
            java.lang.String r0 = "lat"
            r6.put(r0, r10)     // Catch:{ Exception -> 0x0173 }
        L_0x00c0:
            if (r11 == 0) goto L_0x00c7
            java.lang.String r0 = "long"
            r6.put(r0, r11)     // Catch:{ Exception -> 0x0173 }
        L_0x00c7:
            if (r2 == 0) goto L_0x00ce
            java.lang.String r0 = "ua"
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
        L_0x00ce:
            if (r5 == 0) goto L_0x00d5
            java.lang.String r0 = "ip"
            r7.put(r0, r5)     // Catch:{ Exception -> 0x0173 }
        L_0x00d5:
            java.lang.String r0 = "ip_v6"
            r7.put(r0, r3)     // Catch:{ Exception -> 0x0173 }
            if (r12 == 0) goto L_0x00e1
            java.lang.String r0 = "make"
            r7.put(r0, r12)     // Catch:{ Exception -> 0x0173 }
        L_0x00e1:
            if (r13 == 0) goto L_0x00e8
            java.lang.String r0 = "model_1"
            r7.put(r0, r13)     // Catch:{ Exception -> 0x0173 }
        L_0x00e8:
            if (r14 == 0) goto L_0x00ef
            java.lang.String r0 = "osv"
            r7.put(r0, r14)     // Catch:{ Exception -> 0x0173 }
        L_0x00ef:
            if (r15 == 0) goto L_0x00f7
            java.lang.String r0 = "hwv"
            r2 = r15
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
        L_0x00f7:
            if (r21 == 0) goto L_0x0100
            java.lang.String r0 = "connection_type"
            r2 = r21
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
        L_0x0100:
            if (r20 == 0) goto L_0x0109
            java.lang.String r0 = "carrier"
            r2 = r20
            r7.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
        L_0x0109:
            if (r1 == 0) goto L_0x0110
            java.lang.String r0 = "aaid"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0173 }
        L_0x0110:
            if (r19 == 0) goto L_0x0119
            java.lang.String r0 = "browser_uuid"
            r1 = r19
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0173 }
        L_0x0119:
            java.lang.String r0 = "device_type"
            java.lang.String r1 = "PHONE"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r0 = "os"
            java.lang.String r1 = "Android"
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r0 = "user"
            r1 = r18
            r1.put(r0, r4)     // Catch:{ Exception -> 0x0173 }
            if (r22 == 0) goto L_0x0137
            java.lang.String r0 = "version"
            r2 = r22
            r1.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
        L_0x0137:
            java.lang.String r0 = "geo"
            r1.put(r0, r6)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r0 = "device"
            r1.put(r0, r7)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r0 = "channel"
            java.lang.String r2 = "APP"
            r1.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
            r2 = r25
            if (r2 == 0) goto L_0x0154
            java.lang.String r0 = "prev_page"
            r4 = r17
            r4.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
            goto L_0x0156
        L_0x0154:
            r4 = r17
        L_0x0156:
            r2 = r26
            if (r2 == 0) goto L_0x015f
            java.lang.String r0 = "current_page"
            r4.put(r0, r2)     // Catch:{ Exception -> 0x0173 }
        L_0x015f:
            java.lang.String r0 = "referer_ui_element"
            r4.put(r0, r3)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r0 = "context"
            r2 = r16
            r2.put(r0, r1)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r0 = "tracking"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0171 }
            goto L_0x017d
        L_0x0171:
            r0 = move-exception
            goto L_0x0176
        L_0x0173:
            r0 = move-exception
            r2 = r16
        L_0x0176:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x017d:
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.l.c(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    @Deprecated
    public static String a(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        return (cJRHomePageLayoutV2 == null || cJRHomePageLayoutV2.getDatasources() == null || cJRHomePageLayoutV2.getDatasources().size() <= 0) ? "" : cJRHomePageLayoutV2.getDatasources().get(0).getmContainerInstanceID();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r4 = r4.getURL();
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(net.one97.paytm.common.entity.CJRItem r4) {
        /*
            java.lang.String r0 = ""
            if (r4 == 0) goto L_0x0036
            java.lang.String r1 = r4.getURL()     // Catch:{ Exception -> 0x002e }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0036
            java.lang.String r4 = r4.getURL()     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = "/"
            int r1 = r4.lastIndexOf(r1)     // Catch:{ Exception -> 0x002e }
            r2 = -1
            if (r1 == r2) goto L_0x0036
            java.lang.String r3 = "?"
            int r1 = r1 + 1
            int r3 = r4.indexOf(r3, r1)     // Catch:{ Exception -> 0x002e }
            if (r3 != r2) goto L_0x0029
            int r3 = r4.length()     // Catch:{ Exception -> 0x002e }
        L_0x0029:
            java.lang.String r0 = r4.substring(r1, r3)     // Catch:{ Exception -> 0x002e }
            goto L_0x0036
        L_0x002e:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.l.a(net.one97.paytm.common.entity.CJRItem):java.lang.String");
    }

    public static void a(Context context) {
        ba.j(context);
    }

    public static void b(Context context) {
        WalletSharedPrefs.INSTANCE.setLockPatternSession(context, false);
    }

    public static void c(Context context) {
        WalletSharedPrefs.INSTANCE.setSecPromptShownInSession(context, false);
    }

    @Deprecated
    private static void c(Context context, NetworkCustomError networkCustomError, String str) {
        if (context != null && networkCustomError != null) {
            String string = context.getString(R.string.error_dialog_title);
            String string2 = context.getString(R.string.error_dialog_message);
            String b2 = t.b(context);
            if (!TextUtils.isEmpty(b2)) {
                String concat = "/".concat(String.valueOf(b2));
                if (string2.contains(concat)) {
                    string2 = string2.replace(concat, "");
                }
            }
            String g2 = t.g(context);
            if (!TextUtils.isEmpty(g2)) {
                String concat2 = "/".concat(String.valueOf(g2));
                if (string2.contains(concat2)) {
                    string2 = string2.replace(concat2, "");
                }
            }
            y.a(context, string, string2, new y.a(context, str) {
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onDialogDismissed() {
                    b.a(NetworkCustomError.this.getUrl(), NetworkCustomError.this.getMessage(), this.f$1, this.f$2);
                }
            });
        }
    }

    public static boolean a(Context context, VolleyError volleyError, String str) {
        String str2;
        net.one97.paytm.app.b bVar = (net.one97.paytm.app.b) volleyError;
        String message = bVar.getMessage();
        if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("failure_error")) {
            String str3 = null;
            if (TextUtils.isEmpty(message) || (!message.equalsIgnoreCase("499") && !message.equalsIgnoreCase("502") && !message.equalsIgnoreCase("503") && !message.equalsIgnoreCase("504"))) {
                str2 = null;
            } else {
                str3 = bVar.getAlertMessage();
                str2 = bVar.getAlertTitle();
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("499")) {
                    str3 = context.getResources().getString(R.string.message_499);
                    str2 = context.getResources().getString(R.string.title_499);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("502")) {
                    str3 = context.getResources().getString(R.string.message_502);
                    str2 = context.getResources().getString(R.string.title_502);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("503")) {
                    str3 = context.getResources().getString(R.string.message_503);
                    str2 = context.getResources().getString(R.string.title_503);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("504")) {
                    str3 = context.getResources().getString(R.string.message_504);
                    str2 = context.getResources().getString(R.string.title_504);
                }
            }
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("503")) {
                if (!(context == null || bVar == null)) {
                    String string = context.getString(R.string.error_dialog_title);
                    String string2 = context.getString(R.string.error_dialog_message);
                    String b2 = t.b(context);
                    if (!TextUtils.isEmpty(b2)) {
                        String concat = "/".concat(String.valueOf(b2));
                        if (string2.contains(concat)) {
                            string2 = string2.replace(concat, "");
                        }
                    }
                    String g2 = t.g(context);
                    if (!TextUtils.isEmpty(g2)) {
                        String concat2 = "/".concat(String.valueOf(g2));
                        if (string2.contains(concat2)) {
                            string2 = string2.replace(concat2, "");
                        }
                    }
                    y.a(context, string, string2, new y.a(context, str) {
                        private final /* synthetic */ Context f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onDialogDismissed() {
                            b.a(net.one97.paytm.app.b.this.getUrl(), net.one97.paytm.app.b.this.getMessage(), this.f$1, this.f$2);
                        }
                    });
                }
                return true;
            }
            b(context, str3, str2);
            return true;
        } else if (bVar == null || bVar.getAlertTitle() == null || bVar.getAlertMessage() == null) {
            return false;
        } else {
            b.b(context, bVar.getAlertTitle(), bVar.getAlertMessage());
            return true;
        }
    }

    @Deprecated
    private static boolean d(Context context, NetworkCustomError networkCustomError, String str) {
        String str2;
        String message = networkCustomError.getMessage();
        if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("failure_error")) {
            String str3 = null;
            if (TextUtils.isEmpty(message) || (!message.equalsIgnoreCase("499") && !message.equalsIgnoreCase("502") && !message.equalsIgnoreCase("503") && !message.equalsIgnoreCase("504"))) {
                str2 = null;
            } else {
                str3 = networkCustomError.getAlertMessage();
                str2 = networkCustomError.getAlertTitle();
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("499")) {
                    str3 = context.getResources().getString(R.string.message_499);
                    str2 = context.getResources().getString(R.string.title_499);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("502")) {
                    str3 = context.getResources().getString(R.string.message_502);
                    str2 = context.getResources().getString(R.string.title_502);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("503")) {
                    str3 = context.getResources().getString(R.string.message_503);
                    str2 = context.getResources().getString(R.string.title_503);
                } else if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase("504")) {
                    str3 = context.getResources().getString(R.string.message_504);
                    str2 = context.getResources().getString(R.string.title_504);
                }
            }
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            if (TextUtils.isEmpty(message) || !message.equalsIgnoreCase("503")) {
                c(context, networkCustomError, str);
                return true;
            }
            b(context, str3, str2);
            return true;
        } else if (networkCustomError == null || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
            return false;
        } else {
            b.b(context, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            return true;
        }
    }

    public static void a(View view) {
        net.one97.paytm.landingpage.hometabs.a.a();
        net.one97.paytm.landingpage.hometabs.a.b();
        new LinearLayout.LayoutParams(-1, -1, 1.0f);
        a((ViewGroup) (LinearLayout) view.findViewById(R.id.parent_layout_bottom));
        if (view instanceof ViewGroup) {
            a((ViewGroup) view);
        }
    }

    public static void a(Activity activity, View view) {
        if (!view.isSelected()) {
            Object tag = view.getTag();
            if (!(tag instanceof HomeTabItem)) {
                q.c();
                return;
            }
            HomeTabItem homeTabItem = (HomeTabItem) tag;
            Intent intent = new Intent(activity, AJRMainActivity.class);
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.setFlags(536870912);
            intent.putExtra("CLEAR_MOBILE_DATA", true);
            if (!TextUtils.isEmpty(homeTabItem.getUrlType())) {
                intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, homeTabItem.getUrlType());
            } else {
                intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            }
            intent.putExtra("started_activity_from_recharge", true);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static void a(LinearLayout linearLayout) {
        a((ViewGroup) linearLayout);
    }

    @Deprecated
    public static void a(String str, String str2) {
        if (!k.b()) {
            try {
                com.google.firebase.crashlytics.c.a().a(str + " - " + str2);
            } catch (Exception e2) {
                q.b(e2.getMessage());
                q.b("Crashlytics not initialized");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r6, android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "&referrer=deeplink%3D"
            java.lang.String r1 = "android.intent.action.VIEW"
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 == 0) goto L_0x000c
            java.lang.String r8 = ""
        L_0x000c:
            if (r6 == 0) goto L_0x0086
            java.lang.String r2 = "paytmmp"
            boolean r2 = r6.startsWith(r2)
            if (r2 == 0) goto L_0x001d
            net.one97.paytm.deeplink.h$a r8 = net.one97.paytm.deeplink.h.f50349a
            r8 = 0
            net.one97.paytm.deeplink.h.a.a(r7, r6, r8)
            return
        L_0x001d:
            java.lang.String r2 = "com.paytmmall"
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch:{ Exception -> 0x007e }
            android.content.Intent r3 = r3.getLaunchIntentForPackage(r2)     // Catch:{ Exception -> 0x007e }
            if (r3 != 0) goto L_0x006e
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x007e }
            r3.<init>(r1)     // Catch:{ Exception -> 0x007e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x004d }
            java.lang.String r5 = "market://details?id="
            r4.<init>(r5)     // Catch:{ ActivityNotFoundException -> 0x004d }
            r4.append(r2)     // Catch:{ ActivityNotFoundException -> 0x004d }
            r4.append(r0)     // Catch:{ ActivityNotFoundException -> 0x004d }
            r4.append(r6)     // Catch:{ ActivityNotFoundException -> 0x004d }
            r4.append(r8)     // Catch:{ ActivityNotFoundException -> 0x004d }
            java.lang.String r8 = r4.toString()     // Catch:{ ActivityNotFoundException -> 0x004d }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ ActivityNotFoundException -> 0x004d }
            r3.setData(r8)     // Catch:{ ActivityNotFoundException -> 0x004d }
            goto L_0x0075
        L_0x004d:
            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x007e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007e }
            java.lang.String r5 = "https://play.google.com/store/apps/details?id="
            r4.<init>(r5)     // Catch:{ Exception -> 0x007e }
            r4.append(r2)     // Catch:{ Exception -> 0x007e }
            r4.append(r0)     // Catch:{ Exception -> 0x007e }
            r4.append(r6)     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x007e }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x007e }
            r8.<init>(r1, r6)     // Catch:{ Exception -> 0x007e }
            r7.startActivity(r8)     // Catch:{ Exception -> 0x007e }
            goto L_0x0075
        L_0x006e:
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x007e }
            r3.setData(r6)     // Catch:{ Exception -> 0x007e }
        L_0x0075:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r3.addFlags(r6)     // Catch:{ Exception -> 0x007e }
            r7.startActivity(r3)     // Catch:{ Exception -> 0x007e }
            return
        L_0x007e:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.l.a(java.lang.String, android.content.Context, java.lang.String):void");
    }

    @Deprecated
    public static void a(String str, String str2, Throwable th) {
        if (!k.b()) {
            a(str, str2);
            try {
                com.google.firebase.crashlytics.c.a().a(th);
            } catch (Exception e2) {
                q.b(e2.getMessage());
                q.b("Crashlytics not initialized");
            }
        }
    }

    public static ArrayList<DeviceAccount> d(Context context) {
        try {
            ArrayList<DeviceAccount> arrayList = new ArrayList<>();
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            Account[] accounts = AccountManager.get(context).getAccounts();
            if (accounts == null) {
                return null;
            }
            for (Account account : accounts) {
                if (account.type != null && (account.type.equalsIgnoreCase("com.google") || account.type.equalsIgnoreCase("com.samsung.android.coreapps") || account.type.equalsIgnoreCase("com.twitter.android.auth.login"))) {
                    arrayList.add(new DeviceAccount(account.type, account.name));
                }
            }
            return arrayList;
        } catch (Exception e2) {
            q.d("excepton in deviceAccounts" + e2.toString());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        return new net.one97.paytm.common.entity.RiskAnalysis.Contact(r12, false, "0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (r3 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        throw r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004e */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.common.entity.RiskAnalysis.Contact b(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "0"
            java.lang.String r1 = "contact_last_updated_timestamp"
            r2 = 0
            r3 = 0
            java.lang.String r4 = "data1"
            java.lang.String[] r7 = new java.lang.String[]{r1, r4}     // Catch:{ Exception -> 0x004e }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x004e }
            android.net.Uri r6 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch:{ Exception -> 0x004e }
            java.lang.String r8 = "data1 LIKE '%' || ?"
            r11 = 1
            java.lang.String[] r9 = new java.lang.String[r11]     // Catch:{ Exception -> 0x004e }
            r9[r2] = r12     // Catch:{ Exception -> 0x004e }
            r10 = 0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0043
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x004e }
            if (r4 == 0) goto L_0x0043
            int r4 = r3.getCount()     // Catch:{ Exception -> 0x004e }
            if (r4 <= 0) goto L_0x0043
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x004e }
            long r4 = r3.getLong(r1)     // Catch:{ Exception -> 0x004e }
            net.one97.paytm.common.entity.RiskAnalysis.Contact r1 = new net.one97.paytm.common.entity.RiskAnalysis.Contact     // Catch:{ Exception -> 0x004e }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x004e }
            r1.<init>(r12, r11, r4)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0042
            r3.close()
        L_0x0042:
            return r1
        L_0x0043:
            if (r3 == 0) goto L_0x0048
            r3.close()
        L_0x0048:
            net.one97.paytm.common.entity.RiskAnalysis.Contact r11 = new net.one97.paytm.common.entity.RiskAnalysis.Contact
            r11.<init>(r12, r2, r0)
            return r11
        L_0x004e:
            net.one97.paytm.common.entity.RiskAnalysis.Contact r11 = new net.one97.paytm.common.entity.RiskAnalysis.Contact     // Catch:{ all -> 0x0059 }
            r11.<init>(r12, r2, r0)     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x0058
            r3.close()
        L_0x0058:
            return r11
        L_0x0059:
            r11 = move-exception
            if (r3 == 0) goto L_0x005f
            r3.close()
        L_0x005f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.utils.l.b(android.content.Context, java.lang.String):net.one97.paytm.common.entity.RiskAnalysis.Contact");
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        c.a();
        return c.m().contains(str);
    }

    public static void e(Context context) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_from_upi", true);
        c.a();
        c.a("enableCSTWidget", true);
        net.one97.paytm.deeplink.d.b(context, bundle);
    }

    @Deprecated
    public static String a(CJRFrequentOrder cJRFrequentOrder, String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            if (BaseViewModel.PaymentType.POSTPAID.equalsIgnoreCase(cJRFrequentOrder.getPayType())) {
                jSONObject.put("paytype", BaseViewModel.PaymentType.POSTPAID);
            } else if ("prepaid".equalsIgnoreCase(cJRFrequentOrder.getPayType())) {
                jSONObject.put("paytype", "prepaid");
                CJRBillDetails cjrBillDetails = cJRFrequentOrder.getCjrBillDetails();
                if (cjrBillDetails != null && !TextUtils.isEmpty(cjrBillDetails.getPlan())) {
                    jSONObject.put("plan", cjrBillDetails.getPlan());
                }
            }
            jSONObject.put("recharge_number", cJRFrequentOrder.getRechargeNumber());
            if (!TextUtils.isEmpty(cJRFrequentOrder.getOperator())) {
                str2 = cJRFrequentOrder.getOperator();
            } else {
                str2 = cJRFrequentOrder.getOperatorLabel();
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(StringSet.operator, str2);
            }
            jSONObject.put(CLPConstants.PRODUCT_ID, cJRFrequentOrder.getProductID());
            jSONObject.put("amount", str);
            return jSONObject.toString();
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static boolean f(Context context) {
        if (context != null) {
            return ag.a(context.getApplicationContext()).b("is_paytm_prime_user", false, true);
        }
        return false;
    }

    public static boolean g(Context context) {
        if (context != null) {
            return ag.a(context.getApplicationContext()).b("isPasswordSet", false, true);
        }
        return true;
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            ag.a(context.getApplicationContext()).a("is_paytm_prime_user", z, true);
        }
    }

    public static void b(Context context, boolean z) {
        if (context != null) {
            ag.a(context.getApplicationContext()).a("is_paytm_post_paid_user", z, true);
        }
    }

    public static HashMap<String, Object> c(String str) {
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        HashMap<String, Object> hashMap = new HashMap<>();
        for (String next : queryParameterNames) {
            hashMap.put(next, parse.getQueryParameter(next));
        }
        return hashMap;
    }

    public static Intent a(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, AJREmbedWebView.class);
        intent.putExtra("url", str);
        intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, str2);
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("order_id", str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra(UpiConstants.FROM, str4);
        }
        return intent;
    }

    public static float b() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return (float) (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
    }

    public static boolean h(Context context) {
        if (context != null) {
            return ag.a(context.getApplicationContext()).b("is_remote_apps_enabled", false, true);
        }
        return false;
    }

    public static void c(Context context, boolean z) {
        if (context != null) {
            ag.a(context.getApplicationContext()).a("is_remote_apps_enabled", z, true);
        }
    }

    public static void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
