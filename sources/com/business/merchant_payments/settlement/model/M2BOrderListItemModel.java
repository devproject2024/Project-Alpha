package com.business.merchant_payments.settlement.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class M2BOrderListItemModel {
    @c(a = "accountNo")
    public String accountNo;
    @c(a = "additionalInfo")
    public AdditionalInfoModel additionalInfo;
    @c(a = "bizOrderId")
    public String bizOrderId;
    @c(a = "bizType")
    public String bizType;
    @c(a = "ipRoleId")
    public String ipRoleId;
    @c(a = "merchantTransId")
    public String merchantTransId;
    @c(a = "nickName")
    public String nickName;
    @c(a = "oppositeAccountNo")
    public String oppositeAccountNo;
    @c(a = "oppositeUserId")
    public String oppositeUserId;
    @c(a = "orderCompletedTime")
    public String orderCompletedTime;
    @c(a = "orderCreatedTime")
    public String orderCreatedTime;
    @c(a = "orderStatus")
    public String orderStatus;
    @c(a = "payMoneyAmount")
    public AmountModel payMoneyAmount;
    @c(a = "productCode")
    public String productCode;
    @c(a = "reconId")
    public String reconId;
    @c(a = "terminalType")
    public String terminalType;

    public static /* synthetic */ M2BOrderListItemModel copy$default(M2BOrderListItemModel m2BOrderListItemModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, AmountModel amountModel, AdditionalInfoModel additionalInfoModel, String str12, String str13, String str14, int i2, Object obj) {
        M2BOrderListItemModel m2BOrderListItemModel2 = m2BOrderListItemModel;
        int i3 = i2;
        return m2BOrderListItemModel.copy((i3 & 1) != 0 ? m2BOrderListItemModel2.bizOrderId : str, (i3 & 2) != 0 ? m2BOrderListItemModel2.merchantTransId : str2, (i3 & 4) != 0 ? m2BOrderListItemModel2.orderCreatedTime : str3, (i3 & 8) != 0 ? m2BOrderListItemModel2.orderCompletedTime : str4, (i3 & 16) != 0 ? m2BOrderListItemModel2.bizType : str5, (i3 & 32) != 0 ? m2BOrderListItemModel2.orderStatus : str6, (i3 & 64) != 0 ? m2BOrderListItemModel2.ipRoleId : str7, (i3 & 128) != 0 ? m2BOrderListItemModel2.nickName : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? m2BOrderListItemModel2.accountNo : str9, (i3 & 512) != 0 ? m2BOrderListItemModel2.oppositeUserId : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? m2BOrderListItemModel2.oppositeAccountNo : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? m2BOrderListItemModel2.payMoneyAmount : amountModel, (i3 & 4096) != 0 ? m2BOrderListItemModel2.additionalInfo : additionalInfoModel, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? m2BOrderListItemModel2.terminalType : str12, (i3 & 16384) != 0 ? m2BOrderListItemModel2.reconId : str13, (i3 & 32768) != 0 ? m2BOrderListItemModel2.productCode : str14);
    }

    public final String component1() {
        return this.bizOrderId;
    }

    public final String component10() {
        return this.oppositeUserId;
    }

    public final String component11() {
        return this.oppositeAccountNo;
    }

    public final AmountModel component12() {
        return this.payMoneyAmount;
    }

    public final AdditionalInfoModel component13() {
        return this.additionalInfo;
    }

    public final String component14() {
        return this.terminalType;
    }

    public final String component15() {
        return this.reconId;
    }

    public final String component16() {
        return this.productCode;
    }

    public final String component2() {
        return this.merchantTransId;
    }

    public final String component3() {
        return this.orderCreatedTime;
    }

    public final String component4() {
        return this.orderCompletedTime;
    }

    public final String component5() {
        return this.bizType;
    }

    public final String component6() {
        return this.orderStatus;
    }

    public final String component7() {
        return this.ipRoleId;
    }

    public final String component8() {
        return this.nickName;
    }

    public final String component9() {
        return this.accountNo;
    }

    public final M2BOrderListItemModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, AmountModel amountModel, AdditionalInfoModel additionalInfoModel, String str12, String str13, String str14) {
        return new M2BOrderListItemModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, amountModel, additionalInfoModel, str12, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M2BOrderListItemModel)) {
            return false;
        }
        M2BOrderListItemModel m2BOrderListItemModel = (M2BOrderListItemModel) obj;
        return k.a((Object) this.bizOrderId, (Object) m2BOrderListItemModel.bizOrderId) && k.a((Object) this.merchantTransId, (Object) m2BOrderListItemModel.merchantTransId) && k.a((Object) this.orderCreatedTime, (Object) m2BOrderListItemModel.orderCreatedTime) && k.a((Object) this.orderCompletedTime, (Object) m2BOrderListItemModel.orderCompletedTime) && k.a((Object) this.bizType, (Object) m2BOrderListItemModel.bizType) && k.a((Object) this.orderStatus, (Object) m2BOrderListItemModel.orderStatus) && k.a((Object) this.ipRoleId, (Object) m2BOrderListItemModel.ipRoleId) && k.a((Object) this.nickName, (Object) m2BOrderListItemModel.nickName) && k.a((Object) this.accountNo, (Object) m2BOrderListItemModel.accountNo) && k.a((Object) this.oppositeUserId, (Object) m2BOrderListItemModel.oppositeUserId) && k.a((Object) this.oppositeAccountNo, (Object) m2BOrderListItemModel.oppositeAccountNo) && k.a((Object) this.payMoneyAmount, (Object) m2BOrderListItemModel.payMoneyAmount) && k.a((Object) this.additionalInfo, (Object) m2BOrderListItemModel.additionalInfo) && k.a((Object) this.terminalType, (Object) m2BOrderListItemModel.terminalType) && k.a((Object) this.reconId, (Object) m2BOrderListItemModel.reconId) && k.a((Object) this.productCode, (Object) m2BOrderListItemModel.productCode);
    }

    public final int hashCode() {
        String str = this.bizOrderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantTransId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.orderCreatedTime;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.orderCompletedTime;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bizType;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.orderStatus;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.ipRoleId;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.nickName;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.accountNo;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.oppositeUserId;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.oppositeAccountNo;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        AmountModel amountModel = this.payMoneyAmount;
        int hashCode12 = (hashCode11 + (amountModel != null ? amountModel.hashCode() : 0)) * 31;
        AdditionalInfoModel additionalInfoModel = this.additionalInfo;
        int hashCode13 = (hashCode12 + (additionalInfoModel != null ? additionalInfoModel.hashCode() : 0)) * 31;
        String str12 = this.terminalType;
        int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.reconId;
        int hashCode15 = (hashCode14 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.productCode;
        if (str14 != null) {
            i2 = str14.hashCode();
        }
        return hashCode15 + i2;
    }

    public final String toString() {
        return "M2BOrderListItemModel(bizOrderId=" + this.bizOrderId + ", merchantTransId=" + this.merchantTransId + ", orderCreatedTime=" + this.orderCreatedTime + ", orderCompletedTime=" + this.orderCompletedTime + ", bizType=" + this.bizType + ", orderStatus=" + this.orderStatus + ", ipRoleId=" + this.ipRoleId + ", nickName=" + this.nickName + ", accountNo=" + this.accountNo + ", oppositeUserId=" + this.oppositeUserId + ", oppositeAccountNo=" + this.oppositeAccountNo + ", payMoneyAmount=" + this.payMoneyAmount + ", additionalInfo=" + this.additionalInfo + ", terminalType=" + this.terminalType + ", reconId=" + this.reconId + ", productCode=" + this.productCode + ")";
    }

    public M2BOrderListItemModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, AmountModel amountModel, AdditionalInfoModel additionalInfoModel, String str12, String str13, String str14) {
        this.bizOrderId = str;
        this.merchantTransId = str2;
        this.orderCreatedTime = str3;
        this.orderCompletedTime = str4;
        this.bizType = str5;
        this.orderStatus = str6;
        this.ipRoleId = str7;
        this.nickName = str8;
        this.accountNo = str9;
        this.oppositeUserId = str10;
        this.oppositeAccountNo = str11;
        this.payMoneyAmount = amountModel;
        this.additionalInfo = additionalInfoModel;
        this.terminalType = str12;
        this.reconId = str13;
        this.productCode = str14;
    }

    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    public final void setBizOrderId(String str) {
        this.bizOrderId = str;
    }

    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    public final void setMerchantTransId(String str) {
        this.merchantTransId = str;
    }

    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    public final void setOrderCreatedTime(String str) {
        this.orderCreatedTime = str;
    }

    public final String getOrderCompletedTime() {
        return this.orderCompletedTime;
    }

    public final void setOrderCompletedTime(String str) {
        this.orderCompletedTime = str;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final void setBizType(String str) {
        this.bizType = str;
    }

    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    public final void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final String getAccountNo() {
        return this.accountNo;
    }

    public final void setAccountNo(String str) {
        this.accountNo = str;
    }

    public final String getOppositeUserId() {
        return this.oppositeUserId;
    }

    public final void setOppositeUserId(String str) {
        this.oppositeUserId = str;
    }

    public final String getOppositeAccountNo() {
        return this.oppositeAccountNo;
    }

    public final void setOppositeAccountNo(String str) {
        this.oppositeAccountNo = str;
    }

    public final AmountModel getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    public final void setPayMoneyAmount(AmountModel amountModel) {
        this.payMoneyAmount = amountModel;
    }

    public final AdditionalInfoModel getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final void setAdditionalInfo(AdditionalInfoModel additionalInfoModel) {
        this.additionalInfo = additionalInfoModel;
    }

    public final String getTerminalType() {
        return this.terminalType;
    }

    public final void setTerminalType(String str) {
        this.terminalType = str;
    }

    public final String getReconId() {
        return this.reconId;
    }

    public final void setReconId(String str) {
        this.reconId = str;
    }

    public final String getProductCode() {
        return this.productCode;
    }

    public final void setProductCode(String str) {
        this.productCode = str;
    }
}
