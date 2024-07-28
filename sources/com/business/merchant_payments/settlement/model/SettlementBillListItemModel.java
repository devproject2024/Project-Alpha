package com.business.merchant_payments.settlement.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class SettlementBillListItemModel {
    public ArrayList<LabelModel> amountDetails;
    @c(a = "bankDetails")
    public ArrayList<SettlementBankDetailModel> bankDetails;
    @c(a = "failedAmount")
    public AmountModel failedAmount;
    @c(a = "ipRoleId")
    public String ipRoleId;
    public boolean isExpanded;
    @c(a = "netAmount")
    public AmountModel netAmount;
    @c(a = "pendingAmount")
    public AmountModel pendingAmount;
    @c(a = "settleMode")
    public String settleMode;
    @c(a = "settleStatus")
    public String settleStatus;
    @c(a = "settledTime")
    public String settledTime;
    @c(a = "settlementAmountDetails")
    public ArrayList<LabelModel> settlementAmountDetails;
    @c(a = "settlementBillId")
    public String settlementBillId;
    public ArrayList<M2BOrderListItemModel> settlementBillListDetails;
    @c(a = "settlementTime")
    public String settlementTime;
    @c(a = "transferredAmount")
    public AmountModel transferredAmount;
    @c(a = "utrNoList")
    public ArrayList<String> utrNoList;
    @c(a = "utrProcessedTime")
    public String utrPRocessedTime;

    public static /* synthetic */ SettlementBillListItemModel copy$default(SettlementBillListItemModel settlementBillListItemModel, String str, AmountModel amountModel, AmountModel amountModel2, AmountModel amountModel3, ArrayList arrayList, String str2, String str3, String str4, String str5, AmountModel amountModel4, ArrayList arrayList2, String str6, String str7, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, boolean z, int i2, Object obj) {
        SettlementBillListItemModel settlementBillListItemModel2 = settlementBillListItemModel;
        int i3 = i2;
        return settlementBillListItemModel.copy((i3 & 1) != 0 ? settlementBillListItemModel2.ipRoleId : str, (i3 & 2) != 0 ? settlementBillListItemModel2.pendingAmount : amountModel, (i3 & 4) != 0 ? settlementBillListItemModel2.failedAmount : amountModel2, (i3 & 8) != 0 ? settlementBillListItemModel2.netAmount : amountModel3, (i3 & 16) != 0 ? settlementBillListItemModel2.settlementAmountDetails : arrayList, (i3 & 32) != 0 ? settlementBillListItemModel2.settleStatus : str2, (i3 & 64) != 0 ? settlementBillListItemModel2.settledTime : str3, (i3 & 128) != 0 ? settlementBillListItemModel2.settlementBillId : str4, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? settlementBillListItemModel2.settlementTime : str5, (i3 & 512) != 0 ? settlementBillListItemModel2.transferredAmount : amountModel4, (i3 & TarConstants.EOF_BLOCK) != 0 ? settlementBillListItemModel2.utrNoList : arrayList2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? settlementBillListItemModel2.utrPRocessedTime : str6, (i3 & 4096) != 0 ? settlementBillListItemModel2.settleMode : str7, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? settlementBillListItemModel2.bankDetails : arrayList3, (i3 & 16384) != 0 ? settlementBillListItemModel2.amountDetails : arrayList4, (i3 & 32768) != 0 ? settlementBillListItemModel2.settlementBillListDetails : arrayList5, (i3 & 65536) != 0 ? settlementBillListItemModel2.isExpanded : z);
    }

    public final String component1() {
        return this.ipRoleId;
    }

    public final AmountModel component10() {
        return this.transferredAmount;
    }

    public final ArrayList<String> component11() {
        return this.utrNoList;
    }

    public final String component12() {
        return this.utrPRocessedTime;
    }

    public final String component13() {
        return this.settleMode;
    }

    public final ArrayList<SettlementBankDetailModel> component14() {
        return this.bankDetails;
    }

    public final ArrayList<LabelModel> component15() {
        return this.amountDetails;
    }

    public final ArrayList<M2BOrderListItemModel> component16() {
        return this.settlementBillListDetails;
    }

    public final boolean component17() {
        return this.isExpanded;
    }

    public final AmountModel component2() {
        return this.pendingAmount;
    }

    public final AmountModel component3() {
        return this.failedAmount;
    }

    public final AmountModel component4() {
        return this.netAmount;
    }

    public final ArrayList<LabelModel> component5() {
        return this.settlementAmountDetails;
    }

    public final String component6() {
        return this.settleStatus;
    }

    public final String component7() {
        return this.settledTime;
    }

    public final String component8() {
        return this.settlementBillId;
    }

    public final String component9() {
        return this.settlementTime;
    }

    public final SettlementBillListItemModel copy(String str, AmountModel amountModel, AmountModel amountModel2, AmountModel amountModel3, ArrayList<LabelModel> arrayList, String str2, String str3, String str4, String str5, AmountModel amountModel4, ArrayList<String> arrayList2, String str6, String str7, ArrayList<SettlementBankDetailModel> arrayList3, ArrayList<LabelModel> arrayList4, ArrayList<M2BOrderListItemModel> arrayList5, boolean z) {
        return new SettlementBillListItemModel(str, amountModel, amountModel2, amountModel3, arrayList, str2, str3, str4, str5, amountModel4, arrayList2, str6, str7, arrayList3, arrayList4, arrayList5, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementBillListItemModel)) {
            return false;
        }
        SettlementBillListItemModel settlementBillListItemModel = (SettlementBillListItemModel) obj;
        return k.a((Object) this.ipRoleId, (Object) settlementBillListItemModel.ipRoleId) && k.a((Object) this.pendingAmount, (Object) settlementBillListItemModel.pendingAmount) && k.a((Object) this.failedAmount, (Object) settlementBillListItemModel.failedAmount) && k.a((Object) this.netAmount, (Object) settlementBillListItemModel.netAmount) && k.a((Object) this.settlementAmountDetails, (Object) settlementBillListItemModel.settlementAmountDetails) && k.a((Object) this.settleStatus, (Object) settlementBillListItemModel.settleStatus) && k.a((Object) this.settledTime, (Object) settlementBillListItemModel.settledTime) && k.a((Object) this.settlementBillId, (Object) settlementBillListItemModel.settlementBillId) && k.a((Object) this.settlementTime, (Object) settlementBillListItemModel.settlementTime) && k.a((Object) this.transferredAmount, (Object) settlementBillListItemModel.transferredAmount) && k.a((Object) this.utrNoList, (Object) settlementBillListItemModel.utrNoList) && k.a((Object) this.utrPRocessedTime, (Object) settlementBillListItemModel.utrPRocessedTime) && k.a((Object) this.settleMode, (Object) settlementBillListItemModel.settleMode) && k.a((Object) this.bankDetails, (Object) settlementBillListItemModel.bankDetails) && k.a((Object) this.amountDetails, (Object) settlementBillListItemModel.amountDetails) && k.a((Object) this.settlementBillListDetails, (Object) settlementBillListItemModel.settlementBillListDetails) && this.isExpanded == settlementBillListItemModel.isExpanded;
    }

    public final int hashCode() {
        String str = this.ipRoleId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AmountModel amountModel = this.pendingAmount;
        int hashCode2 = (hashCode + (amountModel != null ? amountModel.hashCode() : 0)) * 31;
        AmountModel amountModel2 = this.failedAmount;
        int hashCode3 = (hashCode2 + (amountModel2 != null ? amountModel2.hashCode() : 0)) * 31;
        AmountModel amountModel3 = this.netAmount;
        int hashCode4 = (hashCode3 + (amountModel3 != null ? amountModel3.hashCode() : 0)) * 31;
        ArrayList<LabelModel> arrayList = this.settlementAmountDetails;
        int hashCode5 = (hashCode4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str2 = this.settleStatus;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.settledTime;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.settlementBillId;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.settlementTime;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        AmountModel amountModel4 = this.transferredAmount;
        int hashCode10 = (hashCode9 + (amountModel4 != null ? amountModel4.hashCode() : 0)) * 31;
        ArrayList<String> arrayList2 = this.utrNoList;
        int hashCode11 = (hashCode10 + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        String str6 = this.utrPRocessedTime;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.settleMode;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        ArrayList<SettlementBankDetailModel> arrayList3 = this.bankDetails;
        int hashCode14 = (hashCode13 + (arrayList3 != null ? arrayList3.hashCode() : 0)) * 31;
        ArrayList<LabelModel> arrayList4 = this.amountDetails;
        int hashCode15 = (hashCode14 + (arrayList4 != null ? arrayList4.hashCode() : 0)) * 31;
        ArrayList<M2BOrderListItemModel> arrayList5 = this.settlementBillListDetails;
        if (arrayList5 != null) {
            i2 = arrayList5.hashCode();
        }
        int i3 = (hashCode15 + i2) * 31;
        boolean z = this.isExpanded;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "SettlementBillListItemModel(ipRoleId=" + this.ipRoleId + ", pendingAmount=" + this.pendingAmount + ", failedAmount=" + this.failedAmount + ", netAmount=" + this.netAmount + ", settlementAmountDetails=" + this.settlementAmountDetails + ", settleStatus=" + this.settleStatus + ", settledTime=" + this.settledTime + ", settlementBillId=" + this.settlementBillId + ", settlementTime=" + this.settlementTime + ", transferredAmount=" + this.transferredAmount + ", utrNoList=" + this.utrNoList + ", utrPRocessedTime=" + this.utrPRocessedTime + ", settleMode=" + this.settleMode + ", bankDetails=" + this.bankDetails + ", amountDetails=" + this.amountDetails + ", settlementBillListDetails=" + this.settlementBillListDetails + ", isExpanded=" + this.isExpanded + ")";
    }

    public SettlementBillListItemModel(String str, AmountModel amountModel, AmountModel amountModel2, AmountModel amountModel3, ArrayList<LabelModel> arrayList, String str2, String str3, String str4, String str5, AmountModel amountModel4, ArrayList<String> arrayList2, String str6, String str7, ArrayList<SettlementBankDetailModel> arrayList3, ArrayList<LabelModel> arrayList4, ArrayList<M2BOrderListItemModel> arrayList5, boolean z) {
        this.ipRoleId = str;
        this.pendingAmount = amountModel;
        this.failedAmount = amountModel2;
        this.netAmount = amountModel3;
        this.settlementAmountDetails = arrayList;
        this.settleStatus = str2;
        this.settledTime = str3;
        this.settlementBillId = str4;
        this.settlementTime = str5;
        this.transferredAmount = amountModel4;
        this.utrNoList = arrayList2;
        this.utrPRocessedTime = str6;
        this.settleMode = str7;
        this.bankDetails = arrayList3;
        this.amountDetails = arrayList4;
        this.settlementBillListDetails = arrayList5;
        this.isExpanded = z;
    }

    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    public final void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public final AmountModel getPendingAmount() {
        return this.pendingAmount;
    }

    public final void setPendingAmount(AmountModel amountModel) {
        this.pendingAmount = amountModel;
    }

    public final AmountModel getFailedAmount() {
        return this.failedAmount;
    }

    public final void setFailedAmount(AmountModel amountModel) {
        this.failedAmount = amountModel;
    }

    public final AmountModel getNetAmount() {
        return this.netAmount;
    }

    public final void setNetAmount(AmountModel amountModel) {
        this.netAmount = amountModel;
    }

    public final ArrayList<LabelModel> getSettlementAmountDetails() {
        return this.settlementAmountDetails;
    }

    public final void setSettlementAmountDetails(ArrayList<LabelModel> arrayList) {
        this.settlementAmountDetails = arrayList;
    }

    public final String getSettleStatus() {
        return this.settleStatus;
    }

    public final void setSettleStatus(String str) {
        this.settleStatus = str;
    }

    public final String getSettledTime() {
        return this.settledTime;
    }

    public final void setSettledTime(String str) {
        this.settledTime = str;
    }

    public final String getSettlementBillId() {
        return this.settlementBillId;
    }

    public final void setSettlementBillId(String str) {
        this.settlementBillId = str;
    }

    public final String getSettlementTime() {
        return this.settlementTime;
    }

    public final void setSettlementTime(String str) {
        this.settlementTime = str;
    }

    public final AmountModel getTransferredAmount() {
        return this.transferredAmount;
    }

    public final void setTransferredAmount(AmountModel amountModel) {
        this.transferredAmount = amountModel;
    }

    public final ArrayList<String> getUtrNoList() {
        return this.utrNoList;
    }

    public final void setUtrNoList(ArrayList<String> arrayList) {
        this.utrNoList = arrayList;
    }

    public final String getUtrPRocessedTime() {
        return this.utrPRocessedTime;
    }

    public final void setUtrPRocessedTime(String str) {
        this.utrPRocessedTime = str;
    }

    public final String getSettleMode() {
        return this.settleMode;
    }

    public final void setSettleMode(String str) {
        this.settleMode = str;
    }

    public final ArrayList<SettlementBankDetailModel> getBankDetails() {
        return this.bankDetails;
    }

    public final void setBankDetails(ArrayList<SettlementBankDetailModel> arrayList) {
        this.bankDetails = arrayList;
    }

    public final ArrayList<LabelModel> getAmountDetails() {
        return this.amountDetails;
    }

    public final void setAmountDetails(ArrayList<LabelModel> arrayList) {
        this.amountDetails = arrayList;
    }

    public final ArrayList<M2BOrderListItemModel> getSettlementBillListDetails() {
        return this.settlementBillListDetails;
    }

    public final void setSettlementBillListDetails(ArrayList<M2BOrderListItemModel> arrayList) {
        this.settlementBillListDetails = arrayList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SettlementBillListItemModel(java.lang.String r22, com.business.merchant_payments.settlement.model.AmountModel r23, com.business.merchant_payments.settlement.model.AmountModel r24, com.business.merchant_payments.settlement.model.AmountModel r25, java.util.ArrayList r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, com.business.merchant_payments.settlement.model.AmountModel r31, java.util.ArrayList r32, java.lang.String r33, java.lang.String r34, java.util.ArrayList r35, java.util.ArrayList r36, java.util.ArrayList r37, boolean r38, int r39, kotlin.g.b.g r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r18 = r2
            goto L_0x000c
        L_0x000a:
            r18 = r36
        L_0x000c:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0015
            r19 = r2
            goto L_0x0017
        L_0x0015:
            r19 = r37
        L_0x0017:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0020
            r0 = 0
            r20 = 0
            goto L_0x0022
        L_0x0020:
            r20 = r38
        L_0x0022:
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r29
            r12 = r30
            r13 = r31
            r14 = r32
            r15 = r33
            r16 = r34
            r17 = r35
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.settlement.model.SettlementBillListItemModel.<init>(java.lang.String, com.business.merchant_payments.settlement.model.AmountModel, com.business.merchant_payments.settlement.model.AmountModel, com.business.merchant_payments.settlement.model.AmountModel, java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.business.merchant_payments.settlement.model.AmountModel, java.util.ArrayList, java.lang.String, java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z) {
        this.isExpanded = z;
    }
}
