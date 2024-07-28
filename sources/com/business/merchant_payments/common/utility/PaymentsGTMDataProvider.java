package com.business.merchant_payments.common.utility;

import java.util.HashMap;

public interface PaymentsGTMDataProvider {
    String businessWalletOrderDetail();

    String getBasicDetailAPI();

    String getCustomCardUrl();

    String getDayWiseSummaryListApi();

    String getEdcRefundPolicyTermsAndConditionsUrl();

    String getEdcRentalApi();

    String getGenerateOtpUrl();

    String getGenerateOtpUrlV2();

    String getHomePrimaryApi();

    String getIniateReportAPI();

    String getInitiateRefundAPI();

    String getKycBanksUrl();

    String getLimitsAndChargesFlowUrl();

    long getLocalisationSyncTime();

    String getMapQRUrl();

    String getMerchantAddress();

    String getMerchantHelplineNumer();

    String getMerchantProfileDisplayUrl();

    String getMerchantProfileGstinUrl();

    String getMerchantProfileLoginUrl();

    String getMerchantProfileSecondaryUrlV2();

    String getMerchantProfileTicketStatusUrl();

    String getMerchantProfileUpdateTicketUrl();

    int getMultipleNumberCount();

    String getNeedHelpNavEngineBaseUrl();

    String getNeedHelpNavEngineLevelsUrl();

    String getNewAggregatedApi();

    String getNonMigratedPaymentsApi();

    String getNotificationSettingsUrl();

    String getOfflineOrderDetailAPI();

    String getOnlineAggrigatedApi();

    String getOnlineOrderDetailAPI();

    String getOrderMerchandiseUrl();

    String getOrderSummaryV2();

    String getPaymentLinkDashboardUrl();

    String getPaymentLinkDashboardUrlV1();

    String getPaymentModeDetails();

    String getProfileKYCUrl();

    String getQRSaveSurveyAPI();

    String getQRSummeryAPI();

    String getRefundDetails();

    HashMap<String, String> getSSLPinningConfigAsHashMap();

    String getSettleNowUrl();

    String getSettlementBillListApiUrl();

    String getSettlementBillListItmDetailUrl();

    String getSettlementOnlineUTRSummaryApi();

    String getSettlementTime();

    String getSettlementUTRSummaryV2Api();

    String getSettlementUtrDetailsApi();

    String getSettlementV2Download();

    String getShareLinkEmailUrl();

    String getShareLinkSmsUrl();

    String getShareableQrLink();

    String getSignOutApi();

    String getThriceTime();

    String getTodaySettlementSummaryUrl();

    String getTwiceTime();

    String getUADPincodeApi();

    String getUMPBaseUrl();

    String getUPSBaseUrl();

    String getUPSPrefsUrl();

    String getUserInfoV2Url();

    String getV2OrderList();

    String getV3OrderDetail();

    String getVerifyQRUrl();

    String getWalletTransactionCharges();

    String geteedHelpNavEngineAccountsUrl();

    boolean isShowOrderQr();

    String mdrChargesFlag();

    boolean shouldShowSurveyScreen();

    boolean shouldShowUpgradeButton();

    boolean shouldUseCInfraNeedHelp();

    String taxInclusionFlag();
}
