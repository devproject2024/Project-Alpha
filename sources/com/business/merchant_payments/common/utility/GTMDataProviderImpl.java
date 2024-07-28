package com.business.merchant_payments.common.utility;

import com.business.common_module.b.f;
import com.business.merchant_payments.PaymentsConfig;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import org.json.JSONArray;
import org.json.JSONObject;

public final class GTMDataProviderImpl implements f, PaymentsGTMDataProvider {
    public static final Companion Companion = new Companion((g) null);
    public static final GTMDataProviderImpl mInstance = new GTMDataProviderImpl();

    public final long getLocalisationSyncTime() {
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final GTMDataProviderImpl getMInstance() {
            return GTMDataProviderImpl.mInstance;
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        k.d(str, "key");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getBoolean(str, z);
    }

    public final int getInt(String str, int i2) {
        k.d(str, "key");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getInt(str, i2);
    }

    public final long getLong(String str, long j) {
        k.d(str, "key");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getLong(str, j);
    }

    public final String getString(String str, String str2) {
        k.d(str, "key");
        k.d(str2, "defaultValue");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getString(str, str2);
    }

    public final boolean getConsumerBoolean(String str, boolean z) {
        k.d(str, "key");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerBoolean(str, z);
    }

    public final int getConsumerInt(String str, int i2) {
        k.d(str, "key");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerInt(str, i2);
    }

    public final long getConsumerLong(String str, long j) {
        k.d(str, "key");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerLong(str, j);
    }

    public final String getConsumerString(String str, String str2) {
        k.d(str, "key");
        k.d(str2, "defaultValue");
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerString(str, str2);
    }

    public final HashMap<String, String> getSSLPinningConfigAsHashMap() {
        try {
            if (AppConstants.domainPinsMap != null && AppConstants.domainPinsMap.size() > 0) {
                return AppConstants.domainPinsMap;
            }
            JSONArray jSONArray = new JSONArray(getString("sslPinningConfig", ""));
            HashMap<String, String> hashMap = new HashMap<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getBoolean("isEnabled")) {
                    String string = jSONObject.getString("domain");
                    k.b(string, "jsonObj.getString(PaymentsGTMConstants.SSL_DOMAIN)");
                    String string2 = jSONObject.getString("value");
                    k.b(string2, "jsonObj.getString(Paymen…MConstants.SSL_KEY_VALUE)");
                    hashMap.put(string, string2);
                }
            }
            AppConstants.domainPinsMap = hashMap;
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getUMPBaseUrl() {
        return mInstance.getString("ump_base_url", "");
    }

    private final String getOnBoardingBaseUrl() {
        return mInstance.getString(PaymentsGTMConstants.ON_BOARDING_BASE_URL, "");
    }

    private final String getUadUrl() {
        return mInstance.getString(PaymentsGTMConstants.UAD_URL, "");
    }

    public final String getThriceTime() {
        return mInstance.getString(PaymentsGTMConstants.SETTLEMENT_THRICE_TIME_NEW, "");
    }

    public final String getSettlementBillListApiUrl() {
        return mInstance.getString(PaymentsGTMConstants.SETTLEMENT_BILL_LIST_V4_API, "");
    }

    public final String getShareableQrLink() {
        return mInstance.getString(PaymentsGTMConstants.GET_SHAREABLE_QR_LINK, "");
    }

    public final String getQRSaveSurveyAPI() {
        return mInstance.getString(PaymentsGTMConstants.SURVEY_RESPONSE_API, "");
    }

    public final String getOnlineOrderDetailAPI() {
        return getUMPBaseUrl() + mInstance.getString(PaymentsGTMConstants.ONLINE_ORDER_DETAIL, "");
    }

    public final String getVerifyQRUrl() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.VERIFY_QR, "");
    }

    public final String getV3OrderDetail() {
        return getUMPBaseUrl() + mInstance.getString(PaymentsGTMConstants.API_V3_ORDER_DETAILS, "");
    }

    public final String getCustomCardUrl() {
        return mInstance.getString(PaymentsGTMConstants.CUSTOM_CARD_URL, "");
    }

    public final String getUserInfoV2Url() {
        return getString(PaymentsGTMConstants.USER_DETAILS, "");
    }

    public final String getMerchantProfileGstinUrl() {
        return mInstance.getString("merchantprofile_gstin", "");
    }

    public final String getBasicDetailAPI() {
        return mInstance.getString("basic_detail_api", "");
    }

    public final String getRefundDetails() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        boolean q = instance.getMerchantDataProvider().q();
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        boolean r = instance2.getMerchantDataProvider().r();
        if (q || r) {
            return getV2OrderList();
        }
        return getString(PaymentsGTMConstants.KEY_OFFLINE_TRANSACTION_API, "");
    }

    public final String getNeedHelpNavEngineLevelsUrl() {
        return getNeedHelpNavEngineBaseUrl() + mInstance.getString(PaymentsGTMConstants.NEED_HELP_LEVELS_URL, "");
    }

    public final String getMerchantProfileDisplayUrl() {
        return mInstance.getString("merchantprofile_display", "");
    }

    public final boolean isShowOrderQr() {
        return mInstance.getBoolean(PaymentsGTMConstants.KEY_SHOW_ORDER_QR, false);
    }

    public final boolean shouldUseCInfraNeedHelp() {
        return mInstance.getBoolean(PaymentsGTMConstants.SHOULD_USE_CINFRA_NEED_HELP, false);
    }

    public final String getMerchantProfileTicketStatusUrl() {
        return mInstance.getString("merchantprofile_ticketStatus", "");
    }

    public final String getMerchantProfileSecondaryUrlV2() {
        return getUMPBaseUrl() + mInstance.getString("merchantprofile_secondary_v2", "");
    }

    public final String getMapQRUrl() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.MAP_QR, "");
    }

    public final String getPaymentLinkDashboardUrlV1() {
        return mInstance.getString(PaymentsGTMConstants.PAYMENT_LINK_DASHBOARD, "");
    }

    public final String getEdcRentalApi() {
        return mInstance.getString("edc_rental_api", "");
    }

    public final String getMerchantAddress() {
        return mInstance.getString("profile_address_api", "");
    }

    public final String getUADPincodeApi() {
        return mInstance.getString("uadPincode", "");
    }

    public final String getTwiceTime() {
        return mInstance.getString(PaymentsGTMConstants.SETTLEMENT_TWICE_TIME_NEW, "");
    }

    public final String getEdcRefundPolicyTermsAndConditionsUrl() {
        return mInstance.getString("edc_refund_tnc_url", "");
    }

    public final String getPaymentLinkDashboardUrl() {
        return mInstance.getString(PaymentsGTMConstants.PAYMENT_LINK_DASHBOARD_V2, "");
    }

    public final int getMultipleNumberCount() {
        try {
            return Integer.parseInt(mInstance.getString(PaymentsGTMConstants.MULTIPLE_CONTACT_COUNT_LIMIT, ""));
        } catch (Exception unused) {
            return 5;
        }
    }

    public final String getSettlementTime() {
        return getString(PaymentsGTMConstants.SETTLEMENT_ONCE_TIME, "");
    }

    public final String getLimitsAndChargesFlowUrl() {
        return getString(PaymentsGTMConstants.LIMITS_AND_CHARGES_FLOW_URL, "");
    }

    public final String getQRSummeryAPI() {
        return getString(PaymentsGTMConstants.KEY_QR_SUMMERY_API, "");
    }

    public final String getHomePrimaryApi() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.HOME_PRIMARY_API, "");
    }

    public final String getOfflineOrderDetailAPI() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.OFFLINE_ORDER_DETAIL, "");
    }

    public final String getIniateReportAPI() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().q()) {
            return getString(PaymentsGTMConstants.ONLINE_INITIATE_REPORT_API, "");
        }
        return getString(PaymentsGTMConstants.INITIATE_REPORT_API, "");
    }

    public final String getNonMigratedPaymentsApi() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.NON_MIGRATED_PAYMENTS_API, "");
    }

    public final String getMerchantHelplineNumer() {
        return getString(PaymentsGTMConstants.KEY_ACCEPT_PAYMENT_MERCHANT_HELPLINE, "");
    }

    public final String getShareLinkEmailUrl() {
        return getPaymentLinkDashboardUrlV1() + getString(PaymentsGTMConstants.SHARE_VIA_EMAIL_URL, "");
    }

    public final String getShareLinkSmsUrl() {
        return getPaymentLinkDashboardUrlV1() + getString(PaymentsGTMConstants.SHARE_VIA_SMS_URL, "");
    }

    public final String getKycBanksUrl() {
        return getUMPBaseUrl() + "/" + getString(PaymentsGTMConstants.KYC_BANK_INFO, "");
    }

    public final String mdrChargesFlag() {
        return getString(PaymentsGTMConstants.MDR_CHARGES_FLAG, "");
    }

    public final boolean shouldShowUpgradeButton() {
        try {
            return Boolean.parseBoolean(getString(PaymentsGTMConstants.MERCHANT_LIMIT_UPGRADE_V3_FLAG, ""));
        } catch (Exception unused) {
            return false;
        }
    }

    public final String getSettlementBillListItmDetailUrl() {
        return getString(PaymentsGTMConstants.SETTLEMENT_BILL_LIST_DETAIL_API, "");
    }

    public final String getGenerateOtpUrl() {
        return getString("key_generate_otp_url", "");
    }

    public final String getTodaySettlementSummaryUrl() {
        return getString(PaymentsGTMConstants.TODAY_SETTLEMENT_SUMMARY_API, "");
    }

    public final String getPaymentModeDetails() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.FETCH_PAYMENT_MODE, "");
    }

    public final String getInitiateRefundAPI() {
        APSharedPreferences instance = APSharedPreferences.getInstance();
        k.b(instance, "APSharedPreferences.getInstance()");
        if (instance.isMerchantMigrated()) {
            return getUMPBaseUrl() + getString(PaymentsGTMConstants.V2_INITIATE_REFUND, "");
        }
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        if (instance2.getMerchantDataProvider().q()) {
            return getString(PaymentsGTMConstants.ONLINE_INITIATE_REFUND_API, "");
        }
        return getString(PaymentsGTMConstants.KEY_INITIATE_REFUND_API, "");
    }

    public final String geteedHelpNavEngineAccountsUrl() {
        return getNeedHelpNavEngineBaseUrl() + getString("need_help_accounts_url", "");
    }

    public final boolean shouldShowSurveyScreen() {
        return getBoolean(PaymentsGTMConstants.SHOW_QR_SURVEY_SCREEN, false);
    }

    public final String getOrderMerchandiseUrl() {
        return getString(PaymentsGTMConstants.ORDER_MERCHANDISE_WS_URL, "");
    }

    public final String getMerchantProfileLoginUrl() {
        return getString("merchantprofile_login", "");
    }

    public final String getProfileKYCUrl() {
        return getString("merchant_kyc_url", "");
    }

    public final String getNeedHelpNavEngineBaseUrl() {
        return getUMPBaseUrl() + getString("ump_redirect_url", "");
    }

    public final String getSignOutApi() {
        return getString("sign_out_api", "");
    }

    public final String getV2OrderList() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.V2_ORDER_LIST, "");
    }

    public final String getNotificationSettingsUrl() {
        return getString(PaymentsGTMConstants.NOTIFICATION_SETTINGS_URL, "");
    }

    public final String getMerchantProfileUpdateTicketUrl() {
        return getString("merchantprofile_update_ticket", "");
    }

    public final String getDayWiseSummaryListApi() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.DAY_WISE_SUMMARY_LIST_API, "");
    }

    public final String businessWalletOrderDetail() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.BW_ORDER_DETAIL, "");
    }

    public final String getSettlementV2Download() {
        return getString(PaymentsGTMConstants.SETTLEMENT_V2_DOWNLOAD_API, "");
    }

    public final String taxInclusionFlag() {
        return getString(PaymentsGTMConstants.TAX_INCLUSION_FLAG, "");
    }

    public final String getWalletTransactionCharges() {
        return getString(PaymentsGTMConstants.WALLET_TRANSACTION_CHARGES, "");
    }

    public final String getGenerateOtpUrlV2() {
        return getUMPBaseUrl() + getString("key_generate_otp_url_v2", "");
    }

    public final String getSettleNowUrl() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.SETTLE_NOW_URL, "");
    }

    public final String getOrderSummaryV2() {
        return getUMPBaseUrl() + getString(PaymentsGTMConstants.V2_ORDER_SUMMARY, "");
    }

    public final String getNewAggregatedApi() {
        return getString(PaymentsGTMConstants.KEY_NEW_AGGREGATE_API, "");
    }

    public final String getOnlineAggrigatedApi() {
        return getString(PaymentsGTMConstants.ONLINE_AGGREGATE_API, "");
    }

    public final String getSettlementOnlineUTRSummaryApi() {
        return getString("online_utr_details_api", "");
    }

    public final String getSettlementUtrDetailsApi() {
        return getString("utr_details_api", "");
    }

    public final String getSettlementUTRSummaryV2Api() {
        return getUMPBaseUrl() + getString("v2_settlement_utr_summary", "");
    }

    public final String getUPSBaseUrl() {
        return getString(PaymentsGTMConstants.UPS_BASE_URL, "");
    }

    public final String getUPSPrefsUrl() {
        return getString(PaymentsGTMConstants.UPS_ENDPOINT, "");
    }

    public final String getApStorefrontHomePageUrl() {
        return getString(PaymentsGTMConstants.AP_STOREFRONT_HOMEPAGE_URL, "");
    }
}
