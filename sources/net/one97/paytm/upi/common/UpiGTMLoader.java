package net.one97.paytm.upi.common;

import android.text.TextUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.LogUtility;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public class UpiGTMLoader {
    private static Object lock = new Object();
    private static UpiGTMLoader upiGtmLoader;
    private CJRSendGTMTag.OnCustomNewGTMEvent onCustomNewGTMEvent;

    public int getUpiTokenRetryCount() {
        return 2;
    }

    private UpiGTMLoader() {
    }

    public static void init() {
        getInstance();
    }

    public static UpiGTMLoader getInstance() {
        if (upiGtmLoader == null) {
            synchronized (lock) {
                if (upiGtmLoader == null) {
                    upiGtmLoader = new UpiGTMLoader();
                }
            }
        }
        return upiGtmLoader;
    }

    private String getGTMStringValue(String str, String str2) {
        String b2 = i.a().m.b(str, str2);
        return !TextUtils.isEmpty(b2) ? b2 : str2;
    }

    private String getGTMStringValueFromContainer4(String str, String str2) {
        String c2 = i.a().m.c(str, str2);
        return !TextUtils.isEmpty(c2) ? c2 : str2;
    }

    private boolean getGTMBooleanValue(String str, boolean z) {
        return i.a().m.a(str, z);
    }

    private int getGTMIntValue(String str, int i2) {
        return i.a().m.a(str, i2);
    }

    public String getBaseUpiUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_BASE_URL, isPaytmAppStaging() ? "https://upisecure-staging.paytmbank.com/Paytm_UPI/upi/" : "https://upisecure.paytmbank.com/Paytm_UPI/upi/");
    }

    public String getUpiGatewayBaseUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_GATEWAY_BASE_URL, isPaytmAppStaging() ? "https://upigateway-staging.paytmbank.com/" : "https://upigateway.paytmbank.com/");
    }

    public String getUpiListAccountProvider() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_LIST_ACCOUNT_PROVIDER, "lap");
    }

    public String getUpiListAccounts() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_LIST_ACCOUNTS, "la");
    }

    public String getUpiListKeys() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_LIST_KEYS, "list-keys");
    }

    public String getUpiCheckVa() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_CHECK_VA, "check-va");
    }

    public String getUpiGetToken() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_GET_TOKEN, "get-token");
    }

    public String getUpiDeleteBankAccount() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_DELETE_BANK_ACCOUNT, "Paytm_UPI/upi/delete-bank-account");
    }

    public String getUpiDeregisterProfile() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_DEREGISTER_PROFILE, "Paytm_UPI/upi/deregister-profile");
    }

    public String getUpiAddVpa() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_ADD_VPA, "add-vpa");
    }

    public String getUpiDeleteVpa() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_DELETE_VPA, "Paytm_UPI/upi/delete-vpa");
    }

    public String getUpiAddBankAccount() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_ADD_BANK_ACCOUNT, "add-bank-account");
    }

    public String getUpiRegisterMobile() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_REGISTER_MOBILE, "register-mobile");
    }

    public String getUpiGenerateOtp() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_GENERATE_OTP, "gotp");
    }

    public String getUpiGatewayMiniStmt() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_GATEWAY_MINI_STMT, "v1/ext/transaction/mini-stmt");
    }

    public String getUpiGatewayPendingRequestV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_GATEWAY_PENDING_REQUEST_V2, "v2/ext/transaction/get-pending-request");
    }

    public String getUpiSpamRequestList() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SPAM_REQUEST_LIST, "v1/ext/transaction/spam");
    }

    public String getUpiListCustomerAccount() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_LIST_CUSTOMER_ACCOUNT, "list-customer-acc");
    }

    public String getUpiListVa() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_LIST_VA, "list-va");
    }

    public String getUpiCommonPayRequestAsyncV2() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_COMMON_PAY_ASYNC_REQUEST_V2, "upi/ext/txn/v2/common-pay-request-async");
    }

    public String getUpiCommonPayRequestAsync() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_COMMON_PAY_ASYNC_REQUEST, "common-pay-request-async");
    }

    public String getUpiCommonPayRequest() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_COMMON_PAY_REQUEST, "common-pay-request");
    }

    public String getUpiSetDefaultAccount() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SET_DEFAULT_ACCOUNT, "Paytm_UPI/upi/set-default-account");
    }

    public String getUpiChangeMpin() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_CHANGE_MPIN_NEW, "upi/ext/meta/app/v1/user/change-mpin");
    }

    public String getUpiBalanceEnquiry() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_BALANCE_ENQUIRY, "bal-inq");
    }

    public String getUpiBalanceEnquiryV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_BALANCE_ENQUIRY_V2, "upi/ext/meta/txn/v2/bal-inq");
    }

    public String getUpiBalanceEnquiryV4() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_BALANCE_ENQUIRY_V4, "upi/ext/meta/txn/v4/bal-inq");
    }

    public String getUpiBalanceEnquiryStatus() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_BALANCE_ENQUIRY_STATUS, "upi/ext/meta/txn/v4/bal-inq/status");
    }

    public String getUpiCollectRequest() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_COLLECT_REQUEST, "collect-request");
    }

    public String getUpiValidateAddress() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_VALIDATE_ADDRESS, "validate-address");
    }

    public String getUpiValidateAddressV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_VALIDATE_ADDRESS_V2, "upi/ext/meta/txn/v2/validate-address");
    }

    public String getCheckBalStatusUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_CHECK_BAL_STATUS, "upi/ext/meta/txn/v2/check-bal");
    }

    public String getCreateSignatureUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_CREATE_SIGNATURE, "upi/ext/meta/profile/v1/signature/create");
    }

    public String getUpiMarkSpamUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_MARK_SPAM, "Paytm_UPI/upi/spam-vpa");
    }

    public String getUpiTransactionStatus() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_TRANSACTION_STATUS, "v1/ext/transaction/status");
    }

    public String getUpiTransactionStatusV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_TRANSACTION_STATUS_V2, "upi/ext/txn/v2/transaction/status");
    }

    public String getUpiCollectAuth() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_COLLECT_AUTH, "collect-auth");
    }

    public String getUpiBankLogoUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_BANK_LOGO_URL, "https://static.paytmbank.com/upi/images/bank-logo");
    }

    public String getUpiGatewaySetPrimaryVpaUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_GATEWAY_SET_PRIMARY_VPA, "v1/ext/user/vpa");
    }

    public String getUpiProfileUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_PROFILE_URL_v4, "upi/ext/meta/app/v4/user/profile");
    }

    public String getBankUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_GET_BANK, isPaytmAppStaging() ? "https://wallet-staging.paytm.in/wallet-web/wrapper/getBank" : "https://trust.paytm.in/wallet-web/wrapper/getBank");
    }

    public String getUpiOfferText() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_OFFER_TEXT, "");
    }

    public String getUpiQRHomeOfferText() {
        return getGTMStringValue("offlineUpiPromotionalText", "");
    }

    public String getUpiSendMoneyLowerLimit() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SEND_MONEY_LOWER_LIMIT, "1");
    }

    public String getUpiSendMoneyP2PUpperLimit() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SEND_MONEY_P2P_UPPER_LIMIT, "100000");
    }

    public String getUpiSendMoneyP2MUpperLimit() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SEND_MONEY_P2M_UPPER_LIMIT, "200000");
    }

    public String getUpiImpsSwitchLimit() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_IMPS_SWITCH_LIMIT, "100000");
    }

    public String getUpiAvailabilityUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_AVAILABILITY_URL, "/v1/ext/user/availability");
    }

    public String getUpiAvailabilityUrlV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_AVAILABILITY_URL_V2, "/upi/ext/meta/app/v2/user/availability");
    }

    public String getUpiTelcoNumber() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_TELCO_NUMBER, "9643896438");
    }

    public String getUpiTelcoNumberList() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_TELCO_NUMBER_LIST, "9643896438##9220555666");
    }

    public String getRandomTelcoNumberList() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_RANDOM_TELCO_NUMBER_LIST, "9643896438##9220555666##9740797407");
    }

    public int getCollectRequestExpiryTime() {
        try {
            return i.a().m.a(UpiConstantServiceApi.GTM_KEY_UPI_COLLECT_EXPIRY_TIME, 120);
        } catch (Exception e2) {
            LogUtility.d("UpiGTMLoader", e2.toString());
            return 120;
        }
    }

    public String getUpiInviteTitle() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_UPI_INVITE_TITLE, "");
    }

    public String getUpiInviteMsg() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_UPI_INVITE_MSG, "");
    }

    public String getUpiSelectBankTitle() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SELECT_BANK_TITLE, "");
    }

    public String getUpiInviteUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_UPI_INVITE_URL, "paytmmp://branchShare?campaign=upi_referral&b_key=upi_landing&title=Transfer%20Money%20using%20Paytm%20directly%20from%20Bank%20Account&sharesheet=false&description=1.%20Click%20on%20the%20invite%20link%20below%0A2.%20Link%20your%20Bank%20Account%20on%20Paytm%20App%0A3.%20Transfer%20Money%20directly%20from%20Bank%20account%20using%20BHIM%20UPI%0A4.%20Get%20₹1000%20Cashback%20every%20month%0A&campaignDisplayName=Paytm%20UPI%20Referral&imgUrl=https://paytm.com/offer/wp-content/uploads/2018/07/200x200-2.jpg");
    }

    public String getUpiInviteTerms() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_UPI_INVITE_TERMS, "1. Refer a friend and get ₹50 cashback after they complete their 1st Money Transfer of minimum ₹10 on Paytm using BHIM UPI. You can earn upto ₹10,000.<br>2. Referrer(Person who sends the invite) will be eligible for cashback if they have already linked their bank account through Paytm and completed a Money Transfer of minimum ₹10 before sending the invite.<br>3. Each Referee(Person who has received the invite) gets ₹20 after they complete 2 Money Transfers of minimum ₹10 on Paytm using BHIM UPI<br>4. Referee will be eligible for cashback if all of the below conditions are met--<br>&nbsp;&nbsp;a. Referee shouldn’t be on Paytm UPI before clicking on invite link<br>&nbsp;&nbsp;b. Referee should have clicked on shared invite and link their bank account on Paytm<br>&nbsp;&nbsp;c. Referee should have linked any of their non-Paytm payment bank account to Paytm<br>&nbsp;&nbsp;d. Referee should have completed 2 Money Transfers of minimum ₹10 on Paytm<br>5. Referee gets ₹20 cashback within 7 days after they are eligible for cashback<br>6. If a person is referred by multiple Paytm users, referral will be linked to the Paytm user whose shared link was clicked by the referee before signing up from Paytm BHIM UPI.<br>7. If a person was referred by multiple Paytm users and more than one referral link was clicked, referral will be attributed to the link which was clicked first.<br>8. Cashback won’t be processed if you have not completed your KYC. Ignore if KYC already done.<br>9. In cases where Paytm is not able to credit cashback because wallet is not created or KYC is not completed, Goldback will be credited for the same amount.Goldback is a cashback where instead of Paytm cash in your wallet, digital gold is given.Refer detailed terms <a href='https://paytm.com/offer/goldback'>here</a><br>10. Paytm reserves its sole right to change offer terms or stop the offer without any prior notice to customers.<br>11. This offer is valid on Paytm Android version 7.2.0 & above and iOS version 7.2.1 and above.");
    }

    public int getMaxVpaAllowed() {
        return i.a().m.a(UpiConstantServiceApi.GTM_KEY_MAX_VPA_ALLOWED, 2);
    }

    public boolean showUpiRefrralStrip() {
        return i.a().m.a(UpiConstantServiceApi.KEY_SHOW_UPI_REFERRAL_STRIP, true);
    }

    public void setOnCustomNewGTMEvent(CJRSendGTMTag.OnCustomNewGTMEvent onCustomNewGTMEvent2) {
        this.onCustomNewGTMEvent = onCustomNewGTMEvent2;
    }

    public CJRSendGTMTag.OnCustomNewGTMEvent getOnCustomNewGTMEvent() {
        return this.onCustomNewGTMEvent;
    }

    public String getBankTransferInviteText() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_BANK_TRANSFER_INVITE_TEXT, "Invite %1s to Paytm BHIM UPI|Earn ₹50 Cashback on your friend's first UPI transaction.");
    }

    public String getBankTransferInviteURL() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_BANK_TRANSFER_INVITE_URL, "paytmmp://branchShare?campaign=upi_referral&b_key=upi_landing&title=Transfer%20Money%20using%20Paytm%20directly%20from%20Bank%20Account&sharesheet=false&description=1.Click%20on%20the%20invite%20link%20below%0A2.Link%20your%20Bank%20Account%20on%20Paytm%20App%0A3.Transfer%20Money%20directly%20from%20Bank%20account%20using%20BHIM%20UPI%0A4.Get%20₹1000%20Cashback%20every%20month%0A&campaignDisplayName=Paytm%20UPI%20Referral&imgUrl=https://paytm.com/offer/wp-content/uploads/2018/07/200x200-2.jpg");
    }

    public String getUpiRefreshAccount() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_ACCOUNT_REFRESH, "upi/ext/meta/app/v2/user/refresh-account");
    }

    public String getConsolidatePaymentOptionURL() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_PAYMENT_COMBINATIONS_URL, isPaytmAppStaging() ? "https://transfer-ite.paytmbank.com/v2/ext/users/{userID}/payment-combinations" : "https://transfer.paytmbank.com/v2/ext/users/{userID}/payment-combinations");
    }

    public String getConsolidatePaymentOptionV4URL() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_PAYMENT_COMBINATIONS_URL, "https://transfer.paytmbank.com/v2/ext/users/{userID}/payment-combinations");
    }

    public String deleteBeneficiaryURL() {
        return getGTMStringValue(UpiConstantServiceApi.DELETE_BENEFICIARY_URL, "https://kyc.paytm.com/v1/deletebeneficiary");
    }

    public String getBeneficiaryURLV4() {
        return getGTMStringValue(UpiConstantServiceApi.GET_BENEFICIARY_URL_V4, isPaytmAppStaging() ? "https://kyc-staging.paytmbank.com/v2/getbeneficiary" : "https://kyc.paytmbank.com/v4/getbeneficiary");
    }

    public String getUpiCaptureEventApiUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_CAPTURE_EVENT, "v1/ext/capture/event");
    }

    public String getUpiDeviceBindingV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_DEVICE_BINDING_V2, "Paytm_UPI/upi/device-binding-v2");
    }

    public int getUpiDeviceBindingPollingTime() {
        return i.a().m.a(UpiConstantServiceApi.GTM_KEY_UPI_DEVICE_BINDING_POLLING_TIME);
    }

    public String getUpiInitiateSmsUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_INITIATE_SMS, "upi/ext/meta/profile/v1/initiate-sms");
    }

    public String getUpiInitiateSmsUrlV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_INITIATE_SMS_v2, "upi/ext/meta/profile/v2/initiate-sms");
    }

    public String getUpiSecureBaseUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SECURE_BASE_URL, isPaytmAppStaging() ? "https://upisecure-staging.paytmbank.com/" : "https://upisecure.paytmbank.com/");
    }

    public boolean getAutoCreateVpa() {
        return i.a().m.a(UpiConstantServiceApi.GTM_KEY_UPI_AUTOCREATE_VPA, false);
    }

    public boolean isUpiTransactionStatusPollingEnabled() {
        return i.a().m.a(UpiConstantServiceApi.GTM_KEY_ENABLE_UPI_TRANSACTION_STATUS_POLLING, true);
    }

    public boolean doCallExpireToken() {
        return i.a().m.a("deviceBindingExpiryFlag", false);
    }

    public String getUpiCheckVaAndAddVa() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_CHECK_VA_ADD_VA, "upi/vpa/v2/add-vpa");
    }

    public String getUpiTransactionStatusPollingLimit() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_TRANSACTION_STATUS_POLLING_LIMIT, "2,3,5,5,5,5,5,5,5,5,5,5,5");
    }

    public String getUpiGatewayMiniStmtV2() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_GATEWAY_MINI_STMT_V2, "v2/ext/transaction/mini-stmt");
    }

    public int getUpiNpciTokenExpiryDays() {
        return i.a().m.a(UpiConstantServiceApi.GTM_KEY_UPI_NPCI_TOKEN_EXPIRY_DAYS, 5);
    }

    public boolean doSendUpiSmsFromBothSim() {
        return i.a().m.a(UpiConstantServiceApi.GTM_KEY_UPI_SEND_SMS_BOTH_SIM, false);
    }

    public boolean isIncludeResponse() {
        return i.a().m.a(UpiConstantServiceApi.KEY_INCLUDE_RESPONSE_ERROR_ANALYTICS, false);
    }

    public String getUpiSecureV2BaseUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SECURE_V2_BASE_URL, "https://upisecurev2.paytmbank.com");
    }

    public String getUpiSecureBaseUrlV1() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SECURE_V2_BASE_URL, isPaytmAppStaging() ? "http://upisecure-staging.paytmbank.com/" : "http://upisecure.paytmbank.com/");
    }

    public String getPPBCustProductListUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT, "https://product.paytmbank.com/product/ext/v1/fin-products");
    }

    public String getPPBCardDetailsUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_PPB_CARD_DETAILS, "https://product.paytmbank.com/product/ext/v1/cards/{cardNumberAlias}");
    }

    public String getPaymentBankBalanceUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW, isPaytmAppStaging() ? "https://secure-origin-ite.paytmbank.com/transaction/ext/v1/user-balance?account_type=isa" : "https://secure.paytmbank.com/transaction/ext/v1/user-balance?account_type=isa");
    }

    public String getTokenUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_TOKEN, isPaytmAppStaging() ? "https://accounts-staging.paytm.in/oauth2/token" : "https://accounts.paytm.com/oauth2/token");
    }

    public String getUpiSmsTokenExpireUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_SMS_TOKEN_EXPIRY, "upi/ext/meta/profile/v1/token");
    }

    public String getUpiRequestMoneyPendingRequestUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_LIGHTER_API, "v1/ext/transaction/pending/collect");
    }

    public String getUpiMandatePendingRequestLighterUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_MANDATE_REQUESTS_LIGHTER_API, "v2/ext/transaction/pending/txn");
    }

    public String getCreateMandateUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_CREATE_MANDATE, "upi/v1/ext/mandate/create");
    }

    public String getUpdateMandateUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPDATE_MANDATE, "upi/v1/ext/mandate/update");
    }

    public String getAuthorizeMandateUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_AUTHORIZE_MANDATE_V2, "upi/v2/ext/mandate/authorize");
    }

    public String getPendingMandate() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_PENDING_MANDATE, "upi/ext/gateway/v1/mandate/pending/approval");
    }

    public String getReceivedMandateUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_RECEIVED_MANDATE, "upi/ext/gateway/v1/mandate/received");
    }

    public String getScheduledMandateUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_SCHEDULED_MANDATE, "upi/ext/gateway/v1/mandate/scheduled");
    }

    public String getExecuteMandateUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_EXECUTE_MANDATE, "upi/v1/ext/mandate/execute");
    }

    public String getJourneyMandateUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_JOURNEY_MANDATE, "upi/ext/gateway/v1/mandate/journey");
    }

    public boolean isPaytmAppStaging() {
        return SDKConstants.KEY_STAGING_API.equalsIgnoreCase(i.a().f66988i);
    }

    public String getUPIBankHealthUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_BANK_HEALTH_URL, "upi/ext/gateway/v1/bank/health");
    }

    public String getUpiCashbackBaseUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_CASHBACK_BASE_URL, isPaytmAppStaging() ? "https://upicashback-staging.paytmbank.com/" : "https://upicashback.paytmbank.com/");
    }

    public String getUpiGenerateReferralCodeUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_GENERATE_REFERRAL_CODE, "ext/cashback/referral/generate/link");
    }

    public String getUpiClaimReferralCodeUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_CLAIM_REFERRAL_CODE, "ext/cashback/referral/generate");
    }

    public String getUpiPmsBaseUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_PMS_BASE_URL, isPaytmAppStaging() ? "https://upipms-staging2.paytmbank.com/" : "https://upipms.paytmbank.com/");
    }

    public String getLinkbankAccountUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_LINK_BANK_ACCOUNT, "upi/ext/meta/app/v1/user/link-bank-account");
    }

    public String getListbankAccountUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_LIST_BANK_ACCOUNT, "upi/ext/meta/app/v2/user/list-account");
    }

    public String getCreateProfileUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_CREATE_PROFILE, "upi/ext/meta/app/v1/user/create-profile");
    }

    public String getSetUpProfileUrl() {
        return getGTMStringValueFromContainer4(UpiConstantServiceApi.GTM_KEY_UPI_SETUP_PROFILE, "upi/ext/meta/app/v1/user/set-up-profile");
    }

    public String getPPPCurrentAccountUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_PPB_CURRENT_ACCOUNT_URL, "https://veneer.paytmbank.com/product/ext/v1/fin-products");
    }

    public String getUpiVpaEditUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_EDIT_VPA_API, "upi/vpa/v1/edit-vpa");
    }

    public String getAddBankAccountSuccessUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_UPI_BANK_ACCOUNT_ADDED_FLYER, "https://storefront.paytm.com/v2/h/flyout-screen-02");
    }

    public String getUpiPostTransactionBannerUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_MONEY_TRANSFER_POST_TXN_BANNER, "https://storefront.paytm.com/v2/h/ump-money-transfer-post-txn-page");
    }

    public String getOtpForMpinUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_GET_OTP_FOR_MPIN, "upi/ext/meta/app/v1/user/generate-otp");
    }

    public String getSetMpinUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_SET_MPIN, "upi/ext/meta/app/v1/user/set-mpin");
    }

    public String getUpiInitiateSmsUrlV3() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_INITIATE_SMS_v3, "upi/ext/meta/app/v3/user/initiate-sms");
    }

    public String getUPIUserPreferenceURL() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_USER_PREFERENCE_URL, "upi/ext/meta/app/v1/user/preferences");
    }

    public String getInviteLink() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_APP_INVITE_LINK, "");
    }

    public String getUPSBaseUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_UPI_UPS_BASE_URL, "https://ups.paytmbank.com/");
    }

    public String getUPSWalletUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_UPI_UPS_WALLET_URL, "ups/v1/user-preferences");
    }

    public String getProfileUploadUrl() {
        return getGTMStringValue(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, "");
    }

    public boolean getWalletPreferenceStatus() {
        return getGTMBooleanValue(UpiConstantServiceApi.KEY_UPI_SETTINGS_WAALLET_PREFERENCE_STATUS, false);
    }

    public int getDayCount() {
        return getGTMIntValue(UpiConstantServiceApi.KEY_UPI_SETTINGS_TOOLTIP_DAY_COUNT, 5);
    }

    public String getUpiBenefitsBannerUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPI_BENEFITS_URL, "https://storefront.paytm.com/v2/h/upi-benefits");
    }

    public String getCreateRecurringMandateUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_CREATE_RECURRING_MANDATE, "upi/v1/ext/recurring/mandate/create");
    }

    public String getLighterApiV3Url() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_LIGHTER_API_V3, "upi/ext/gateway/v3/transaction/pending/txn");
    }

    public String getRecurringMandateUpdateUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_UPDATE_RECURRING_MANDATE, "upi/v1/ext/recurring/mandate/update");
    }

    public String getBottomBarUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_MANDATE_POST_TXN_BOTTOM_BAR, "https://storefront.paytm.com/v2/h/ump-money-transfer-post-txn-page");
    }

    public Boolean isRecurringMandateEnabled() {
        return Boolean.valueOf(i.a().m.a(UpiConstantServiceApi.GTM_KEY_RECURRING_MANDATE_ENABLED, false));
    }

    public Boolean isEditVpaEnabled() {
        return Boolean.valueOf(getGTMBooleanValue(UpiConstantServiceApi.GTM_KEY_EDIT_VPA_ENABLED, false));
    }

    public String getReferralDeeplink() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_REFERRAL_DEEPLINK, "paytmmp://referral?tag=REFERRAL");
    }

    public boolean isCollectPopUpAllowed() {
        return getGTMBooleanValue(UpiConstantServiceApi.GTM_KEY_COLLECT_POPUP_ALLOWED, false);
    }

    public String getPPBLBannerUrl() {
        return getGTMStringValue(UpiConstantServiceApi.GTM_KEY_BANK_LINKING_FAILURE_URL, "");
    }

    public boolean isOrderDetailsEnabled() {
        return getGTMBooleanValue(UpiConstantServiceApi.GTM_KEY_ORDER_DETAIL_ENABLED, false);
    }

    public boolean isAutoRedirectionEnabled() {
        return getGTMBooleanValue(UpiConstantServiceApi.GTM_KEY_AUTO_COLLECT_REDIRECTION, false);
    }
}
