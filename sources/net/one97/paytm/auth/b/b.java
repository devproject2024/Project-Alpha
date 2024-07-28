package net.one97.paytm.auth.b;

import android.app.Activity;
import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.utility.c;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class b {
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x00b1 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r6) {
        /*
            android.content.Context r0 = r6.getApplicationContext()
            java.lang.String r0 = com.paytm.utility.b.G((android.content.Context) r0)
            com.paytm.contactsSdk.ContactsSdk r1 = com.paytm.contactsSdk.ContactsSdk.INSTANCE
            r1.onLogout()
            e(r6)
            f(r6)
            net.one97.paytm.utils.w.c(r6)
            net.one97.paytm.common.utility.c.a((android.content.Context) r6)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
        L_0x001b:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = "paytm_app_logout"
            r1.setAction(r2)
            androidx.localbroadcastmanager.a.a r2 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r6)
            r2.a((android.content.Intent) r1)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r1.<init>()
            android.content.Context r2 = r6.getApplicationContext()
            com.paytm.b.a.a r2 = net.one97.paytm.utils.ag.a(r2)
            r3 = 1
            java.lang.String r4 = "home_url"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.b((java.lang.String) r4, (java.lang.String) r5, (boolean) r3)
            r1.setUrl(r2)
            java.lang.String r1 = "frequent_order_list"
            net.one97.paytm.common.utility.c.a(r6, r1)
            net.one97.paytm.wallet.newdesign.utils.DelegateUtil r1 = net.one97.paytm.wallet.newdesign.utils.DelegateUtil.INSTANCE
            r1.deleteAllEventLogData()
            net.one97.paytm.upi.profile.b.b r1 = net.one97.paytm.upi.g.a()
            r1.b()
            java.lang.String r1 = "upi_recent_txns"
            net.one97.paytm.quickpay.b.a.b(r6, r1)
            java.lang.String r1 = "quick_pay"
            net.one97.paytm.quickpay.b.a.b(r6, r1)
            r1 = 0
            net.one97.paytm.utils.l.a((android.content.Context) r6, (boolean) r1)
            net.one97.paytm.trustlist.a.a()
            net.one97.paytm.trustlist.d.a()
            net.one97.paytm.trustlist.c r2 = net.one97.paytm.trustlist.c.a()
            r2.a((boolean) r1)
            d((android.app.Activity) r6)
            g(r6)
            h(r6)
            c((android.content.Context) r6)
            d((android.content.Context) r6)
            net.one97.paytm.contacts.utils.c r1 = net.one97.paytm.contacts.utils.c.f50249c
            net.one97.paytm.contacts.utils.c.a((android.content.Context) r6)
            net.one97.paytm.n.e r1 = net.one97.paytm.n.e.f55762a
            net.one97.paytm.n.e.g()
            boolean r1 = com.paytm.utility.k.b()
            if (r1 != 0) goto L_0x0094
            net.one97.paytm.utils.g.a(r6, r3)
        L_0x0094:
            net.one97.paytm.utils.l.a((android.content.Context) r6)
            net.one97.paytm.quickpay.d.a r1 = net.one97.paytm.quickpay.d.a.a()
            r1.e()
            androidx.localbroadcastmanager.a.a r1 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r6)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "action_update_login_status"
            r2.<init>(r3)
            r1.a((android.content.Intent) r2)
            com.paytm.notification.g$c r1 = com.paytm.notification.g.f43191a     // Catch:{ Exception -> 0x00b1 }
            com.paytm.notification.g.c.c()     // Catch:{ Exception -> 0x00b1 }
        L_0x00b1:
            com.paytm.analytics.b$b r1 = com.paytm.analytics.b.f40911e     // Catch:{ Exception -> 0x00be }
            com.paytm.analytics.b.C0683b.b()     // Catch:{ Exception -> 0x00be }
            net.one97.paytm.deeplink.u r1 = net.one97.paytm.deeplink.u.a()     // Catch:{ Exception -> 0x00be }
            r1.a((android.app.Activity) r6)     // Catch:{ Exception -> 0x00be }
            goto L_0x00bf
        L_0x00be:
        L_0x00bf:
            boolean r6 = com.paytm.utility.k.b()
            if (r6 != 0) goto L_0x00d0
            java.lang.String r6 = "Female"
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x00d0
            net.one97.paytm.deeplink.m.a()
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.auth.b.b.a(android.app.Activity):void");
    }

    public static void b(Activity activity) {
        a(activity, false);
    }

    public static void c(Activity activity) {
        a(activity, false);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x00b7 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r6, boolean r7) {
        /*
            android.content.Context r0 = r6.getApplicationContext()
            java.lang.String r0 = com.paytm.utility.b.G((android.content.Context) r0)
            com.paytm.contactsSdk.ContactsSdk r1 = com.paytm.contactsSdk.ContactsSdk.INSTANCE
            r1.onLogout()
            e(r6)
            f(r6)
            net.one97.paytm.utils.w.c(r6)
            net.one97.paytm.common.utility.c.a((android.content.Context) r6)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
        L_0x001b:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = "paytm_app_logout"
            r1.setAction(r2)
            androidx.localbroadcastmanager.a.a r2 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r6)
            r2.a((android.content.Intent) r1)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r1.<init>()
            android.content.Context r2 = r6.getApplicationContext()
            com.paytm.b.a.a r2 = net.one97.paytm.utils.ag.a(r2)
            r3 = 1
            java.lang.String r4 = "home_url"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.b((java.lang.String) r4, (java.lang.String) r5, (boolean) r3)
            r1.setUrl(r2)
            java.lang.String r1 = "frequent_order_list"
            net.one97.paytm.common.utility.c.a(r6, r1)
            net.one97.paytm.wallet.newdesign.utils.DelegateUtil r1 = net.one97.paytm.wallet.newdesign.utils.DelegateUtil.INSTANCE
            r1.deleteAllEventLogData()
            net.one97.paytm.upi.profile.b.b r1 = net.one97.paytm.upi.g.a()
            r1.b()
            java.lang.String r1 = "upi_recent_txns"
            net.one97.paytm.quickpay.b.a.b(r6, r1)
            java.lang.String r1 = "quick_pay"
            net.one97.paytm.quickpay.b.a.b(r6, r1)
            net.one97.paytm.contacts.utils.c r1 = net.one97.paytm.contacts.utils.c.f50249c
            net.one97.paytm.contacts.utils.c.a((android.content.Context) r6)
            net.one97.paytm.n.e r1 = net.one97.paytm.n.e.f55762a
            net.one97.paytm.n.e.g()
            r1 = 0
            net.one97.paytm.utils.l.a((android.content.Context) r6, (boolean) r1)
            net.one97.paytm.trustlist.a.a()
            net.one97.paytm.trustlist.d.a()
            net.one97.paytm.trustlist.c r2 = net.one97.paytm.trustlist.c.a()
            r2.a((boolean) r1)
            net.one97.paytm.deeplink.e.b()
            net.one97.paytm.deeplink.ag.a((android.content.Context) r6)
            d((android.app.Activity) r6)
            g(r6)
            h(r6)
            d((android.content.Context) r6)
            c((android.content.Context) r6)
            boolean r1 = com.paytm.utility.k.b()
            if (r1 != 0) goto L_0x009a
            net.one97.paytm.utils.g.a(r6, r3)
        L_0x009a:
            net.one97.paytm.utils.l.a((android.content.Context) r6)
            net.one97.paytm.quickpay.d.a r1 = net.one97.paytm.quickpay.d.a.a()
            r1.e()
            androidx.localbroadcastmanager.a.a r1 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r6)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "action_update_login_status"
            r2.<init>(r3)
            r1.a((android.content.Intent) r2)
            com.paytm.notification.g$c r1 = com.paytm.notification.g.f43191a     // Catch:{ Exception -> 0x00b7 }
            com.paytm.notification.g.c.c()     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            com.paytm.analytics.b$b r1 = com.paytm.analytics.b.f40911e     // Catch:{ Exception -> 0x00c4 }
            com.paytm.analytics.b.C0683b.b()     // Catch:{ Exception -> 0x00c4 }
            net.one97.paytm.deeplink.u r1 = net.one97.paytm.deeplink.u.a()     // Catch:{ Exception -> 0x00c4 }
            r1.a((android.app.Activity) r6)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00c5
        L_0x00c4:
        L_0x00c5:
            boolean r1 = com.paytm.utility.k.b()
            if (r1 != 0) goto L_0x00d6
            java.lang.String r1 = "Female"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00d6
            net.one97.paytm.deeplink.m.a()
        L_0x00d6:
            net.one97.paytm.deeplink.f r0 = net.one97.paytm.deeplink.f.f50341a
            net.one97.paytm.deeplink.f.a((android.content.Context) r6)
            net.one97.paytm.deeplink.m r0 = net.one97.paytm.deeplink.m.f50358c
            net.one97.paytm.deeplink.m.a((android.content.Context) r6)
            net.one97.paytm.deeplink.f r0 = net.one97.paytm.deeplink.f.f50341a
            net.one97.paytm.deeplink.f.a((android.content.Context) r6)
            if (r7 != 0) goto L_0x00ea
            net.one97.paytm.marketplace.a.a()
        L_0x00ea:
            net.one97.paytm.smssdk.b r7 = net.one97.paytm.smssdk.b.f65064b
            net.one97.paytm.smssdk.b.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.auth.b.b.a(android.app.Activity, boolean):void");
    }

    private static void d(Activity activity) {
        t.b(activity, "0");
        t.a((Context) activity, 0);
        t.a((Context) activity, (String) null);
        ((CJRJarvisApplication) activity.getApplication()).f49005a = null;
    }

    public static void a(Context context) {
        try {
            c.a(context.getApplicationContext(), "favorite_number_list");
            if (a.m(context)) {
                OauthModule.a((HashMap<String, String>) new HashMap(), (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        new StringBuilder().append(i2);
                    }
                });
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private static void e(Activity activity) {
        com.paytm.b.a.a a2 = ag.a(activity.getApplicationContext());
        a2.a("sso_token=", (String) null, true);
        a2.a("wallet_sso_token=", (String) null, true);
        a2.a("encrypted_sso_token", (String) null, true);
    }

    private static void f(Activity activity) {
        com.paytm.b.a.a a2 = ag.a(activity.getApplicationContext());
        a2.a("first name", (String) null, true);
        a2.a("default_address_pincode", (String) null, true);
        a2.a("last name", (String) null, true);
        a2.a(AppConstants.KEY_EMAIL, (String) null, true);
        a2.a("mobile", (String) null, true);
        a2.a("user_dob", (String) null, true);
        a2.a("user_gender", (String) null, true);
        a2.a("userImage", (String) null, true);
        a2.a(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, (String) null, true);
        a2.a("pan_number", (String) null, true);
        a2.a("pan_card_time_stamp", (String) null, true);
        a2.a("profile_pic_update", false, true);
        a2.a("isPrime", true, true);
        a2.a("isPasswordSet", false, true);
        a2.a("entity_merchant_ID", (String) null, true);
        a2.a("userType", (String) null, true);
        a2.a("user_Type_merchant", (String) null, true);
        a2.a("is_accept_money_bank_sel", false, true);
        a2.a("merchant_qr_id", (String) null, true);
        a2.a("is_sd_merchant_active", true, true);
        a2.a("do_merchant_has_permission", false, true);
        a2.a("sd_merchant_name", (String) null, true);
        a2.a("aadhar", (String) null, true);
        a2.a("pan", (String) null, true);
        a2.a("kyc_first_name", (String) null, true);
        a2.a("kyc_last_name", (String) null, true);
        a2.a("kyc_gender", (String) null, true);
        a2.a("kyc_dob", (String) null, true);
        a2.a("is_adhar_verified", false, true);
        a2.a("is_pan_verified", false, true);
        WalletSharedPrefs walletSharedPrefs = WalletSharedPrefs.INSTANCE;
        a2.a("contact_sync_first_time_local", true, true);
        WalletSharedPrefs walletSharedPrefs2 = WalletSharedPrefs.INSTANCE;
        a2.a("contact_sync_first_time_server", true, true);
        a2.a("is_first_time_chat", true, true);
        a2.a("is_chat_synced", false, true);
        a2.a("is_welcome_shown", false, true);
        a2.a("is_contact_synced", false, true);
        a2.a("imei", true);
        a2.a("simSerial", (String) null, true);
        a2.a("display_name", (String) null, true);
        a2.a("merchant_qr_id", (String) null, true);
        a2.a("openAccountCloseCount", 0, true);
        a2.a("userDevice", (String) null, true);
        a2.a("version", (String) null, true);
        a2.a("clientId", (String) null, true);
        a2.a("timeInterval", 60, true);
        a2.a("otpCounterCache", 0, true);
        a2.a("eventLogSync", 0, true);
        a2.a("cgcpHeader", (String) null, true);
        WalletSharedPrefs walletSharedPrefs3 = WalletSharedPrefs.INSTANCE;
        a2.a("cgcpHeader", (String) null, true);
        a2.a("gamepind_cas_user_id_1", (String) null, true);
        a2.a("gamepind_cas_masked_msisdn_1", (String) null, true);
        a2.a("gamepind_cas_customer_id_1", (String) null, true);
        a2.a("gamepind_cas_access_token_1", (String) null, true);
        a2.a("gamepind_signup_popup_shown_data_1", true);
        a2.a("gamepind_popup_time_1", true);
        a2.a("search_cookie", (String) null, true);
        a2.a("pref_key_mall_tab_click", false, true);
        a2.a("cart_failed_promo_map", (String) null, true);
        a2.a("is_apply_promo_failed", false, true);
        a2.a("postpaid_init_popup_count_shown", 0, true);
        a2.a("paytm_gold_init_popup_count_shown", 0, true);
        a2.a(WalletSharedPrefs.KEY_CONTACT_PERMISSION_ASKED_COUNT, -1, true);
        a2.a("accountStatementDownloadTimestamp", 0, true);
        a2.a("accountStatementDownloadCount", 0, true);
        a2.a("cache_merchantt_context", 0, true);
        a2.a("language_suggest_popup_timestamp", 0, true);
        a2.a("language_suggest_push_locale", (String) null, true);
        a2.a("system_sync_time", 0, true);
        a2.a("prime_status_sync_time", 0, true);
        a2.a(UpiConstants.PREF_KEY_IS_UPI_PROFILE_TIP_CLICKED, true);
        a2.a("language_suggest_popup_timestamp", 0, true);
        a2.a("language_suggest_push_locale", (String) null, true);
        a2.a("userId", (String) null, true);
        a2.a("isPhoneNoAdded", false, true);
        a2.a(CLPConstants.PRODUCT_ID, "", true);
        a2.a("credit_url", "", true);
        a2.a("paytm_credit_cache_time", 0, true);
        a2.a("is_reseller_user", false, true);
        a2.a("is_merchant_user", false, true);
        a2.a("selected_user_profile", e.b.CONSUMER.name(), true);
        a2.a("is_min_kyc", false, true);
        net.one97.paytm.utils.a.b.g(activity);
        a();
        b();
        j.a((Context) activity);
        t.k(activity);
        net.one97.paytm.marketplace.a.b(activity);
        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
        net.one97.paytm.oauth.utils.q.o();
    }

    private static void a() {
        com.paytm.b.a.a a2 = ag.a(CJRJarvisApplication.getAppContext());
        a2.a("is_bank_user", false, true);
        a2.a("is_passcode_set", false, true);
        a2.a("is_bank_lead", false, true);
        a2.a("open_bank_invite", false, true);
        a2.a("is_bank_kyc", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("is_pan", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("is_form60", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("nominee_status", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("is_aadhaar", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
        a2.a("show_bank_pop_up", true, true);
        a2.a("acc_status", net.one97.paytm.utils.a.DEFAULT.getNumVal(), true);
        a2.a("show_open_bank_acc_bottom_sheet_count", 1, true);
        a2.a("show_pdc_activate_popup", false, true);
        a2.a("bioEncypData", (String) null, true);
        a2.a("bioEncypIv", (String) null, true);
        a2.a("isTurnedOn", (String) null, true);
        a2.a("bank_cersai_launch_count", 0, true);
        a2.a("bank_nominee_launch_count", 0, true);
    }

    private static void g(Activity activity) {
        com.paytm.b.a.a a2 = ag.a(activity.getApplicationContext());
        a2.a("passbook_subwallet_offline", true);
        a2.a("passbook_offline", true);
    }

    private static void b() {
        com.paytm.b.a.a a2 = ag.a(CJRJarvisApplication.getAppContext());
        a2.a("has_qr_permission", false, true);
        a2.a("isSDMerchant", true, true);
        a2.a("BUSINESS_WALLET_ACTIVE", true);
        a2.a("has_qr_permission", true);
        a2.a("isSDMerchant", true);
        a2.a("MERCHANT_TYPE", true);
        a2.a("cache_merchantt_context", true);
        if (net.one97.paytm.acceptPayment.configs.a.f52046a != null) {
            net.one97.paytm.acceptPayment.configs.a.c();
        }
    }

    private static void h(Activity activity) {
        ag.a(activity.getApplicationContext()).a("bank_passbook_offline", true);
    }

    private static void b(Context context) {
        com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
        a2.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN, true);
        a2.a(UpiConstants.KEY_SHARED_PREF_UPI_TOKEN_CREATION_TIME, true);
        a2.a(UpiConstants.KEY_LIST_KEYS_RESPONSE, true);
        a2.a(UpiConstants.PREF_KEY_IS_SAME_DEVICE, true);
        a2.a("is_upi_user", true);
        a2.a(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, true);
        a2.a(UpiConstants.PREF_KEY_IS_BANK_ACCOUNT_ADDED, true);
        a2.a(UpiConstants.PREF_KEY_IS_MPIN_SET, true);
        a2.a(UpiConstants.PREF_KEY_IS_SELECT_BANK_DIALOG_TIME, true);
        a2.a(UpiConstants.PREF_KEY_IS_SELECT_BANK_DIALOG_INTERVAL, true);
    }

    private static void c(Context context) {
        m.e(context);
        UpiUtils.logout(context);
        b(context);
    }

    private static void d(Context context) {
        RecentDataNetworkManager.clearRecentData(context);
        ag.a(context.getApplicationContext()).a("should_download_recent_payments_data", true, true);
    }
}
