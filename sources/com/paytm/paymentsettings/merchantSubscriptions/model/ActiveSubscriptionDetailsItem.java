package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class ActiveSubscriptionDetailsItem extends IJRPaytmDataModel {
    @b(a = "accountHolderName")
    private String accountHolderName;
    @b(a = "customerDetails")
    private ActiveSubscriptionsCustomerDetails customerDetails;
    @b(a = "frequency")
    private int frequency;
    @b(a = "frequencyUnit")
    private String frequencyUnit;
    @b(a = "isAutoRenewal")
    private String isAutoRenewal;
    @b(a = "isAutoRetry")
    private String isAutoRetry;
    @b(a = "isCommunicationManager")
    private String isCommunicationManager;
    @b(a = "onusMerchant")
    private boolean isOnusMerchant;
    @b(a = "issuerBankAccNo")
    private String issuerBankAccNo;
    @b(a = "issuerBankIfsc")
    private String issuerBankIfsc;
    @b(a = "lastUpdatedDate")
    private String lastUpdatedDate;
    @b(a = "merchantId")
    private String merchantId;
    @b(a = "merchantLogo")
    private String merchantLogo;
    @b(a = "merchantName")
    private String merchantName;
    @b(a = "nextRenewalDate")
    private String nextRenewalDate;
    @b(a = "paymentDetails")
    private ActiveSubscriptionsPaymentDetails paymentDetails;
    @b(a = "renewalAmount")
    private String renewalAmount;
    @b(a = "savedCardId")
    private String savedCardId;
    @b(a = "subsCallbackUrl")
    private String subsCallbackUrl;
    @b(a = "subsHistoryDetails")
    private ActiveSubscriptionsHistoryDetails subsHistoryDetails;
    @b(a = "subsPaymentInstDetails")
    private ActiveSubscriptionsPaymentInstrumentDetails subsPaymentInstDetails;
    @b(a = "subscriptionAmount")
    private String subscriptionAmount;
    @b(a = "subscriptionAmountType")
    private String subscriptionAmountType;
    @b(a = "subscriptionEndDate")
    private String subscriptionEndDate;
    @b(a = "subscriptionId")
    private String subscriptionId;
    @b(a = "subscriptionStartDate")
    private String subscriptionStartDate;
    @b(a = "subscriptionType")
    private String subscriptionType;
    @b(a = "upfrontAmount")
    private String upfrontAmount;

    public ActiveSubscriptionDetailsItem() {
        this((String) null, (String) null, (String) null, (String) null, 0, (String) null, (ActiveSubscriptionsHistoryDetails) null, (String) null, (String) null, (String) null, (String) null, (ActiveSubscriptionsPaymentDetails) null, (ActiveSubscriptionsCustomerDetails) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (ActiveSubscriptionsPaymentInstrumentDetails) null, (String) null, (String) null, (String) null, 268435455, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionDetailsItem copy$default(ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem, String str, String str2, String str3, String str4, int i2, String str5, ActiveSubscriptionsHistoryDetails activeSubscriptionsHistoryDetails, String str6, String str7, String str8, String str9, ActiveSubscriptionsPaymentDetails activeSubscriptionsPaymentDetails, ActiveSubscriptionsCustomerDetails activeSubscriptionsCustomerDetails, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, String str16, String str17, String str18, String str19, ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails, String str20, String str21, String str22, int i3, Object obj) {
        ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem2 = activeSubscriptionDetailsItem;
        int i4 = i3;
        return activeSubscriptionDetailsItem.copy((i4 & 1) != 0 ? activeSubscriptionDetailsItem2.frequencyUnit : str, (i4 & 2) != 0 ? activeSubscriptionDetailsItem2.subsCallbackUrl : str2, (i4 & 4) != 0 ? activeSubscriptionDetailsItem2.accountHolderName : str3, (i4 & 8) != 0 ? activeSubscriptionDetailsItem2.merchantName : str4, (i4 & 16) != 0 ? activeSubscriptionDetailsItem2.frequency : i2, (i4 & 32) != 0 ? activeSubscriptionDetailsItem2.isCommunicationManager : str5, (i4 & 64) != 0 ? activeSubscriptionDetailsItem2.subsHistoryDetails : activeSubscriptionsHistoryDetails, (i4 & 128) != 0 ? activeSubscriptionDetailsItem2.merchantId : str6, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? activeSubscriptionDetailsItem2.issuerBankAccNo : str7, (i4 & 512) != 0 ? activeSubscriptionDetailsItem2.isAutoRenewal : str8, (i4 & TarConstants.EOF_BLOCK) != 0 ? activeSubscriptionDetailsItem2.subscriptionStartDate : str9, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? activeSubscriptionDetailsItem2.paymentDetails : activeSubscriptionsPaymentDetails, (i4 & 4096) != 0 ? activeSubscriptionDetailsItem2.customerDetails : activeSubscriptionsCustomerDetails, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? activeSubscriptionDetailsItem2.subscriptionEndDate : str10, (i4 & 16384) != 0 ? activeSubscriptionDetailsItem2.merchantLogo : str11, (i4 & 32768) != 0 ? activeSubscriptionDetailsItem2.subscriptionAmountType : str12, (i4 & 65536) != 0 ? activeSubscriptionDetailsItem2.upfrontAmount : str13, (i4 & 131072) != 0 ? activeSubscriptionDetailsItem2.isAutoRetry : str14, (i4 & 262144) != 0 ? activeSubscriptionDetailsItem2.lastUpdatedDate : str15, (i4 & 524288) != 0 ? activeSubscriptionDetailsItem2.isOnusMerchant : z, (i4 & 1048576) != 0 ? activeSubscriptionDetailsItem2.subscriptionType : str16, (i4 & 2097152) != 0 ? activeSubscriptionDetailsItem2.subscriptionAmount : str17, (i4 & 4194304) != 0 ? activeSubscriptionDetailsItem2.subscriptionId : str18, (i4 & 8388608) != 0 ? activeSubscriptionDetailsItem2.issuerBankIfsc : str19, (i4 & 16777216) != 0 ? activeSubscriptionDetailsItem2.subsPaymentInstDetails : activeSubscriptionsPaymentInstrumentDetails, (i4 & 33554432) != 0 ? activeSubscriptionDetailsItem2.renewalAmount : str20, (i4 & 67108864) != 0 ? activeSubscriptionDetailsItem2.nextRenewalDate : str21, (i4 & 134217728) != 0 ? activeSubscriptionDetailsItem2.savedCardId : str22);
    }

    public final String component1() {
        return this.frequencyUnit;
    }

    public final String component10() {
        return this.isAutoRenewal;
    }

    public final String component11() {
        return this.subscriptionStartDate;
    }

    public final ActiveSubscriptionsPaymentDetails component12() {
        return this.paymentDetails;
    }

    public final ActiveSubscriptionsCustomerDetails component13() {
        return this.customerDetails;
    }

    public final String component14() {
        return this.subscriptionEndDate;
    }

    public final String component15() {
        return this.merchantLogo;
    }

    public final String component16() {
        return this.subscriptionAmountType;
    }

    public final String component17() {
        return this.upfrontAmount;
    }

    public final String component18() {
        return this.isAutoRetry;
    }

    public final String component19() {
        return this.lastUpdatedDate;
    }

    public final String component2() {
        return this.subsCallbackUrl;
    }

    public final boolean component20() {
        return this.isOnusMerchant;
    }

    public final String component21() {
        return this.subscriptionType;
    }

    public final String component22() {
        return this.subscriptionAmount;
    }

    public final String component23() {
        return this.subscriptionId;
    }

    public final String component24() {
        return this.issuerBankIfsc;
    }

    public final ActiveSubscriptionsPaymentInstrumentDetails component25() {
        return this.subsPaymentInstDetails;
    }

    public final String component26() {
        return this.renewalAmount;
    }

    public final String component27() {
        return this.nextRenewalDate;
    }

    public final String component28() {
        return this.savedCardId;
    }

    public final String component3() {
        return this.accountHolderName;
    }

    public final String component4() {
        return this.merchantName;
    }

    public final int component5() {
        return this.frequency;
    }

    public final String component6() {
        return this.isCommunicationManager;
    }

    public final ActiveSubscriptionsHistoryDetails component7() {
        return this.subsHistoryDetails;
    }

    public final String component8() {
        return this.merchantId;
    }

    public final String component9() {
        return this.issuerBankAccNo;
    }

    public final ActiveSubscriptionDetailsItem copy(String str, String str2, String str3, String str4, int i2, String str5, ActiveSubscriptionsHistoryDetails activeSubscriptionsHistoryDetails, String str6, String str7, String str8, String str9, ActiveSubscriptionsPaymentDetails activeSubscriptionsPaymentDetails, ActiveSubscriptionsCustomerDetails activeSubscriptionsCustomerDetails, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, String str16, String str17, String str18, String str19, ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails, String str20, String str21, String str22) {
        return new ActiveSubscriptionDetailsItem(str, str2, str3, str4, i2, str5, activeSubscriptionsHistoryDetails, str6, str7, str8, str9, activeSubscriptionsPaymentDetails, activeSubscriptionsCustomerDetails, str10, str11, str12, str13, str14, str15, z, str16, str17, str18, str19, activeSubscriptionsPaymentInstrumentDetails, str20, str21, str22);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionDetailsItem)) {
            return false;
        }
        ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem = (ActiveSubscriptionDetailsItem) obj;
        return k.a((Object) this.frequencyUnit, (Object) activeSubscriptionDetailsItem.frequencyUnit) && k.a((Object) this.subsCallbackUrl, (Object) activeSubscriptionDetailsItem.subsCallbackUrl) && k.a((Object) this.accountHolderName, (Object) activeSubscriptionDetailsItem.accountHolderName) && k.a((Object) this.merchantName, (Object) activeSubscriptionDetailsItem.merchantName) && this.frequency == activeSubscriptionDetailsItem.frequency && k.a((Object) this.isCommunicationManager, (Object) activeSubscriptionDetailsItem.isCommunicationManager) && k.a((Object) this.subsHistoryDetails, (Object) activeSubscriptionDetailsItem.subsHistoryDetails) && k.a((Object) this.merchantId, (Object) activeSubscriptionDetailsItem.merchantId) && k.a((Object) this.issuerBankAccNo, (Object) activeSubscriptionDetailsItem.issuerBankAccNo) && k.a((Object) this.isAutoRenewal, (Object) activeSubscriptionDetailsItem.isAutoRenewal) && k.a((Object) this.subscriptionStartDate, (Object) activeSubscriptionDetailsItem.subscriptionStartDate) && k.a((Object) this.paymentDetails, (Object) activeSubscriptionDetailsItem.paymentDetails) && k.a((Object) this.customerDetails, (Object) activeSubscriptionDetailsItem.customerDetails) && k.a((Object) this.subscriptionEndDate, (Object) activeSubscriptionDetailsItem.subscriptionEndDate) && k.a((Object) this.merchantLogo, (Object) activeSubscriptionDetailsItem.merchantLogo) && k.a((Object) this.subscriptionAmountType, (Object) activeSubscriptionDetailsItem.subscriptionAmountType) && k.a((Object) this.upfrontAmount, (Object) activeSubscriptionDetailsItem.upfrontAmount) && k.a((Object) this.isAutoRetry, (Object) activeSubscriptionDetailsItem.isAutoRetry) && k.a((Object) this.lastUpdatedDate, (Object) activeSubscriptionDetailsItem.lastUpdatedDate) && this.isOnusMerchant == activeSubscriptionDetailsItem.isOnusMerchant && k.a((Object) this.subscriptionType, (Object) activeSubscriptionDetailsItem.subscriptionType) && k.a((Object) this.subscriptionAmount, (Object) activeSubscriptionDetailsItem.subscriptionAmount) && k.a((Object) this.subscriptionId, (Object) activeSubscriptionDetailsItem.subscriptionId) && k.a((Object) this.issuerBankIfsc, (Object) activeSubscriptionDetailsItem.issuerBankIfsc) && k.a((Object) this.subsPaymentInstDetails, (Object) activeSubscriptionDetailsItem.subsPaymentInstDetails) && k.a((Object) this.renewalAmount, (Object) activeSubscriptionDetailsItem.renewalAmount) && k.a((Object) this.nextRenewalDate, (Object) activeSubscriptionDetailsItem.nextRenewalDate) && k.a((Object) this.savedCardId, (Object) activeSubscriptionDetailsItem.savedCardId);
    }

    public final int hashCode() {
        String str = this.frequencyUnit;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subsCallbackUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountHolderName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.merchantName;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.frequency) * 31;
        String str5 = this.isCommunicationManager;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        ActiveSubscriptionsHistoryDetails activeSubscriptionsHistoryDetails = this.subsHistoryDetails;
        int hashCode6 = (hashCode5 + (activeSubscriptionsHistoryDetails != null ? activeSubscriptionsHistoryDetails.hashCode() : 0)) * 31;
        String str6 = this.merchantId;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.issuerBankAccNo;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.isAutoRenewal;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.subscriptionStartDate;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        ActiveSubscriptionsPaymentDetails activeSubscriptionsPaymentDetails = this.paymentDetails;
        int hashCode11 = (hashCode10 + (activeSubscriptionsPaymentDetails != null ? activeSubscriptionsPaymentDetails.hashCode() : 0)) * 31;
        ActiveSubscriptionsCustomerDetails activeSubscriptionsCustomerDetails = this.customerDetails;
        int hashCode12 = (hashCode11 + (activeSubscriptionsCustomerDetails != null ? activeSubscriptionsCustomerDetails.hashCode() : 0)) * 31;
        String str10 = this.subscriptionEndDate;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.merchantLogo;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.subscriptionAmountType;
        int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.upfrontAmount;
        int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.isAutoRetry;
        int hashCode17 = (hashCode16 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.lastUpdatedDate;
        int hashCode18 = (hashCode17 + (str15 != null ? str15.hashCode() : 0)) * 31;
        boolean z = this.isOnusMerchant;
        if (z) {
            z = true;
        }
        int i3 = (hashCode18 + (z ? 1 : 0)) * 31;
        String str16 = this.subscriptionType;
        int hashCode19 = (i3 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.subscriptionAmount;
        int hashCode20 = (hashCode19 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.subscriptionId;
        int hashCode21 = (hashCode20 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.issuerBankIfsc;
        int hashCode22 = (hashCode21 + (str19 != null ? str19.hashCode() : 0)) * 31;
        ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails = this.subsPaymentInstDetails;
        int hashCode23 = (hashCode22 + (activeSubscriptionsPaymentInstrumentDetails != null ? activeSubscriptionsPaymentInstrumentDetails.hashCode() : 0)) * 31;
        String str20 = this.renewalAmount;
        int hashCode24 = (hashCode23 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.nextRenewalDate;
        int hashCode25 = (hashCode24 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.savedCardId;
        if (str22 != null) {
            i2 = str22.hashCode();
        }
        return hashCode25 + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionDetailsItem(frequencyUnit=" + this.frequencyUnit + ", subsCallbackUrl=" + this.subsCallbackUrl + ", accountHolderName=" + this.accountHolderName + ", merchantName=" + this.merchantName + ", frequency=" + this.frequency + ", isCommunicationManager=" + this.isCommunicationManager + ", subsHistoryDetails=" + this.subsHistoryDetails + ", merchantId=" + this.merchantId + ", issuerBankAccNo=" + this.issuerBankAccNo + ", isAutoRenewal=" + this.isAutoRenewal + ", subscriptionStartDate=" + this.subscriptionStartDate + ", paymentDetails=" + this.paymentDetails + ", customerDetails=" + this.customerDetails + ", subscriptionEndDate=" + this.subscriptionEndDate + ", merchantLogo=" + this.merchantLogo + ", subscriptionAmountType=" + this.subscriptionAmountType + ", upfrontAmount=" + this.upfrontAmount + ", isAutoRetry=" + this.isAutoRetry + ", lastUpdatedDate=" + this.lastUpdatedDate + ", isOnusMerchant=" + this.isOnusMerchant + ", subscriptionType=" + this.subscriptionType + ", subscriptionAmount=" + this.subscriptionAmount + ", subscriptionId=" + this.subscriptionId + ", issuerBankIfsc=" + this.issuerBankIfsc + ", subsPaymentInstDetails=" + this.subsPaymentInstDetails + ", renewalAmount=" + this.renewalAmount + ", nextRenewalDate=" + this.nextRenewalDate + ", savedCardId=" + this.savedCardId + ")";
    }

    public final String getFrequencyUnit() {
        return this.frequencyUnit;
    }

    public final void setFrequencyUnit(String str) {
        this.frequencyUnit = str;
    }

    public final String getSubsCallbackUrl() {
        return this.subsCallbackUrl;
    }

    public final void setSubsCallbackUrl(String str) {
        this.subsCallbackUrl = str;
    }

    public final String getAccountHolderName() {
        return this.accountHolderName;
    }

    public final void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final void setMerchantName(String str) {
        this.merchantName = str;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final void setFrequency(int i2) {
        this.frequency = i2;
    }

    public final String isCommunicationManager() {
        return this.isCommunicationManager;
    }

    public final void setCommunicationManager(String str) {
        this.isCommunicationManager = str;
    }

    public final ActiveSubscriptionsHistoryDetails getSubsHistoryDetails() {
        return this.subsHistoryDetails;
    }

    public final void setSubsHistoryDetails(ActiveSubscriptionsHistoryDetails activeSubscriptionsHistoryDetails) {
        this.subsHistoryDetails = activeSubscriptionsHistoryDetails;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getIssuerBankAccNo() {
        return this.issuerBankAccNo;
    }

    public final void setIssuerBankAccNo(String str) {
        this.issuerBankAccNo = str;
    }

    public final String isAutoRenewal() {
        return this.isAutoRenewal;
    }

    public final void setAutoRenewal(String str) {
        this.isAutoRenewal = str;
    }

    public final String getSubscriptionStartDate() {
        return this.subscriptionStartDate;
    }

    public final void setSubscriptionStartDate(String str) {
        this.subscriptionStartDate = str;
    }

    public final ActiveSubscriptionsPaymentDetails getPaymentDetails() {
        return this.paymentDetails;
    }

    public final void setPaymentDetails(ActiveSubscriptionsPaymentDetails activeSubscriptionsPaymentDetails) {
        this.paymentDetails = activeSubscriptionsPaymentDetails;
    }

    public final ActiveSubscriptionsCustomerDetails getCustomerDetails() {
        return this.customerDetails;
    }

    public final void setCustomerDetails(ActiveSubscriptionsCustomerDetails activeSubscriptionsCustomerDetails) {
        this.customerDetails = activeSubscriptionsCustomerDetails;
    }

    public final String getSubscriptionEndDate() {
        return this.subscriptionEndDate;
    }

    public final void setSubscriptionEndDate(String str) {
        this.subscriptionEndDate = str;
    }

    public final String getMerchantLogo() {
        return this.merchantLogo;
    }

    public final void setMerchantLogo(String str) {
        this.merchantLogo = str;
    }

    public final String getSubscriptionAmountType() {
        return this.subscriptionAmountType;
    }

    public final void setSubscriptionAmountType(String str) {
        this.subscriptionAmountType = str;
    }

    public final String getUpfrontAmount() {
        return this.upfrontAmount;
    }

    public final void setUpfrontAmount(String str) {
        this.upfrontAmount = str;
    }

    public final String isAutoRetry() {
        return this.isAutoRetry;
    }

    public final void setAutoRetry(String str) {
        this.isAutoRetry = str;
    }

    public final String getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public final void setLastUpdatedDate(String str) {
        this.lastUpdatedDate = str;
    }

    public final boolean isOnusMerchant() {
        return this.isOnusMerchant;
    }

    public final void setOnusMerchant(boolean z) {
        this.isOnusMerchant = z;
    }

    public final String getSubscriptionType() {
        return this.subscriptionType;
    }

    public final void setSubscriptionType(String str) {
        this.subscriptionType = str;
    }

    public final String getSubscriptionAmount() {
        return this.subscriptionAmount;
    }

    public final void setSubscriptionAmount(String str) {
        this.subscriptionAmount = str;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public final String getIssuerBankIfsc() {
        return this.issuerBankIfsc;
    }

    public final void setIssuerBankIfsc(String str) {
        this.issuerBankIfsc = str;
    }

    public final ActiveSubscriptionsPaymentInstrumentDetails getSubsPaymentInstDetails() {
        return this.subsPaymentInstDetails;
    }

    public final void setSubsPaymentInstDetails(ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails) {
        this.subsPaymentInstDetails = activeSubscriptionsPaymentInstrumentDetails;
    }

    public final String getRenewalAmount() {
        return this.renewalAmount;
    }

    public final void setRenewalAmount(String str) {
        this.renewalAmount = str;
    }

    public final String getNextRenewalDate() {
        return this.nextRenewalDate;
    }

    public final void setNextRenewalDate(String str) {
        this.nextRenewalDate = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ActiveSubscriptionDetailsItem(java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, java.lang.String r35, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsHistoryDetails r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentDetails r41, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsCustomerDetails r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, boolean r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, int r58, kotlin.g.b.g r59) {
        /*
            r29 = this;
            r0 = r58
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r30
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r31
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r32
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r33
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r34
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = 0
            goto L_0x0032
        L_0x0030:
            r8 = r35
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r36
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r37
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            r11 = 0
            goto L_0x004a
        L_0x0048:
            r11 = r38
        L_0x004a:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r39
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r40
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r41
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r42
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r43
        L_0x0072:
            r7 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x0078
            r7 = 0
            goto L_0x007a
        L_0x0078:
            r7 = r44
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r45
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r46
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r47
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r48
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r49
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r50
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r51
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r52
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r53
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r54
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r55
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r56
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r28
            if (r0 == 0) goto L_0x0107
            r0 = 0
            goto L_0x0109
        L_0x0107:
            r0 = r57
        L_0x0109:
            r30 = r29
            r31 = r1
            r32 = r3
            r33 = r4
            r34 = r5
            r35 = r6
            r36 = r8
            r37 = r9
            r38 = r10
            r39 = r11
            r40 = r12
            r41 = r13
            r42 = r14
            r43 = r15
            r44 = r2
            r45 = r7
            r46 = r16
            r47 = r17
            r48 = r18
            r49 = r19
            r50 = r20
            r51 = r21
            r52 = r22
            r53 = r23
            r54 = r24
            r55 = r25
            r56 = r26
            r57 = r27
            r58 = r0
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsHistoryDetails, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentDetails, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsCustomerDetails, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getSavedCardId() {
        return this.savedCardId;
    }

    public final void setSavedCardId(String str) {
        this.savedCardId = str;
    }

    public ActiveSubscriptionDetailsItem(String str, String str2, String str3, String str4, int i2, String str5, ActiveSubscriptionsHistoryDetails activeSubscriptionsHistoryDetails, String str6, String str7, String str8, String str9, ActiveSubscriptionsPaymentDetails activeSubscriptionsPaymentDetails, ActiveSubscriptionsCustomerDetails activeSubscriptionsCustomerDetails, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, String str16, String str17, String str18, String str19, ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails, String str20, String str21, String str22) {
        this.frequencyUnit = str;
        this.subsCallbackUrl = str2;
        this.accountHolderName = str3;
        this.merchantName = str4;
        this.frequency = i2;
        this.isCommunicationManager = str5;
        this.subsHistoryDetails = activeSubscriptionsHistoryDetails;
        this.merchantId = str6;
        this.issuerBankAccNo = str7;
        this.isAutoRenewal = str8;
        this.subscriptionStartDate = str9;
        this.paymentDetails = activeSubscriptionsPaymentDetails;
        this.customerDetails = activeSubscriptionsCustomerDetails;
        this.subscriptionEndDate = str10;
        this.merchantLogo = str11;
        this.subscriptionAmountType = str12;
        this.upfrontAmount = str13;
        this.isAutoRetry = str14;
        this.lastUpdatedDate = str15;
        this.isOnusMerchant = z;
        this.subscriptionType = str16;
        this.subscriptionAmount = str17;
        this.subscriptionId = str18;
        this.issuerBankIfsc = str19;
        this.subsPaymentInstDetails = activeSubscriptionsPaymentInstrumentDetails;
        this.renewalAmount = str20;
        this.nextRenewalDate = str21;
        this.savedCardId = str22;
    }
}
