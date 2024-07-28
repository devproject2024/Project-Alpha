package com.business.merchant_payments.settlement.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class SettlementBills extends BWBaseModel {
    @c(a = "ipRoleId")
    public final String ipRoleId;
    @c(a = "netAmount")
    public final NetAmount netAmount;
    @c(a = "netAmountInfo")
    public final NetAmountInfo netAmountInfo;
    @c(a = "payOutAmount")
    public final PayOutAmount payOutAmount;
    @c(a = "preUnsettledAmount")
    public final PreUnsettledAmount preUnsettledAmount;
    public final long serialVersionUID;
    @c(a = "settleStatus")
    public final String settleStatus;
    @c(a = "settledTime")
    public final String settledTime;
    @c(a = "settlementBillId")
    public final String settlementBillId;
    @c(a = "settlementTime")
    public final String settlementTime;
    @c(a = "transferredAmount")
    public final TransferredAmount transferredAmount;
    @c(a = "unSettledAmount")
    public final UnSettledAmount unSettledAmount;
    @c(a = "utrNoList")
    public final List<String> utrNoList;

    private final long component13() {
        return this.serialVersionUID;
    }

    public static /* synthetic */ SettlementBills copy$default(SettlementBills settlementBills, String str, NetAmount netAmount2, NetAmountInfo netAmountInfo2, PayOutAmount payOutAmount2, PreUnsettledAmount preUnsettledAmount2, String str2, String str3, String str4, String str5, TransferredAmount transferredAmount2, UnSettledAmount unSettledAmount2, List list, long j, int i2, Object obj) {
        SettlementBills settlementBills2 = settlementBills;
        int i3 = i2;
        return settlementBills.copy((i3 & 1) != 0 ? settlementBills2.ipRoleId : str, (i3 & 2) != 0 ? settlementBills2.netAmount : netAmount2, (i3 & 4) != 0 ? settlementBills2.netAmountInfo : netAmountInfo2, (i3 & 8) != 0 ? settlementBills2.payOutAmount : payOutAmount2, (i3 & 16) != 0 ? settlementBills2.preUnsettledAmount : preUnsettledAmount2, (i3 & 32) != 0 ? settlementBills2.settleStatus : str2, (i3 & 64) != 0 ? settlementBills2.settledTime : str3, (i3 & 128) != 0 ? settlementBills2.settlementBillId : str4, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? settlementBills2.settlementTime : str5, (i3 & 512) != 0 ? settlementBills2.transferredAmount : transferredAmount2, (i3 & TarConstants.EOF_BLOCK) != 0 ? settlementBills2.unSettledAmount : unSettledAmount2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? settlementBills2.utrNoList : list, (i3 & 4096) != 0 ? settlementBills2.serialVersionUID : j);
    }

    public final String component1() {
        return this.ipRoleId;
    }

    public final TransferredAmount component10() {
        return this.transferredAmount;
    }

    public final UnSettledAmount component11() {
        return this.unSettledAmount;
    }

    public final List<String> component12() {
        return this.utrNoList;
    }

    public final NetAmount component2() {
        return this.netAmount;
    }

    public final NetAmountInfo component3() {
        return this.netAmountInfo;
    }

    public final PayOutAmount component4() {
        return this.payOutAmount;
    }

    public final PreUnsettledAmount component5() {
        return this.preUnsettledAmount;
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

    public final SettlementBills copy(String str, NetAmount netAmount2, NetAmountInfo netAmountInfo2, PayOutAmount payOutAmount2, PreUnsettledAmount preUnsettledAmount2, String str2, String str3, String str4, String str5, TransferredAmount transferredAmount2, UnSettledAmount unSettledAmount2, List<String> list, long j) {
        return new SettlementBills(str, netAmount2, netAmountInfo2, payOutAmount2, preUnsettledAmount2, str2, str3, str4, str5, transferredAmount2, unSettledAmount2, list, j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementBills)) {
            return false;
        }
        SettlementBills settlementBills = (SettlementBills) obj;
        return k.a((Object) this.ipRoleId, (Object) settlementBills.ipRoleId) && k.a((Object) this.netAmount, (Object) settlementBills.netAmount) && k.a((Object) this.netAmountInfo, (Object) settlementBills.netAmountInfo) && k.a((Object) this.payOutAmount, (Object) settlementBills.payOutAmount) && k.a((Object) this.preUnsettledAmount, (Object) settlementBills.preUnsettledAmount) && k.a((Object) this.settleStatus, (Object) settlementBills.settleStatus) && k.a((Object) this.settledTime, (Object) settlementBills.settledTime) && k.a((Object) this.settlementBillId, (Object) settlementBills.settlementBillId) && k.a((Object) this.settlementTime, (Object) settlementBills.settlementTime) && k.a((Object) this.transferredAmount, (Object) settlementBills.transferredAmount) && k.a((Object) this.unSettledAmount, (Object) settlementBills.unSettledAmount) && k.a((Object) this.utrNoList, (Object) settlementBills.utrNoList) && this.serialVersionUID == settlementBills.serialVersionUID;
    }

    public final int hashCode() {
        String str = this.ipRoleId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        NetAmount netAmount2 = this.netAmount;
        int hashCode2 = (hashCode + (netAmount2 != null ? netAmount2.hashCode() : 0)) * 31;
        NetAmountInfo netAmountInfo2 = this.netAmountInfo;
        int hashCode3 = (hashCode2 + (netAmountInfo2 != null ? netAmountInfo2.hashCode() : 0)) * 31;
        PayOutAmount payOutAmount2 = this.payOutAmount;
        int hashCode4 = (hashCode3 + (payOutAmount2 != null ? payOutAmount2.hashCode() : 0)) * 31;
        PreUnsettledAmount preUnsettledAmount2 = this.preUnsettledAmount;
        int hashCode5 = (hashCode4 + (preUnsettledAmount2 != null ? preUnsettledAmount2.hashCode() : 0)) * 31;
        String str2 = this.settleStatus;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.settledTime;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.settlementBillId;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.settlementTime;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        TransferredAmount transferredAmount2 = this.transferredAmount;
        int hashCode10 = (hashCode9 + (transferredAmount2 != null ? transferredAmount2.hashCode() : 0)) * 31;
        UnSettledAmount unSettledAmount2 = this.unSettledAmount;
        int hashCode11 = (hashCode10 + (unSettledAmount2 != null ? unSettledAmount2.hashCode() : 0)) * 31;
        List<String> list = this.utrNoList;
        if (list != null) {
            i2 = list.hashCode();
        }
        long j = this.serialVersionUID;
        return ((hashCode11 + i2) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "SettlementBills(ipRoleId=" + this.ipRoleId + ", netAmount=" + this.netAmount + ", netAmountInfo=" + this.netAmountInfo + ", payOutAmount=" + this.payOutAmount + ", preUnsettledAmount=" + this.preUnsettledAmount + ", settleStatus=" + this.settleStatus + ", settledTime=" + this.settledTime + ", settlementBillId=" + this.settlementBillId + ", settlementTime=" + this.settlementTime + ", transferredAmount=" + this.transferredAmount + ", unSettledAmount=" + this.unSettledAmount + ", utrNoList=" + this.utrNoList + ", serialVersionUID=" + this.serialVersionUID + ")";
    }

    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    public final NetAmount getNetAmount() {
        return this.netAmount;
    }

    public final NetAmountInfo getNetAmountInfo() {
        return this.netAmountInfo;
    }

    public final PayOutAmount getPayOutAmount() {
        return this.payOutAmount;
    }

    public final PreUnsettledAmount getPreUnsettledAmount() {
        return this.preUnsettledAmount;
    }

    public final String getSettleStatus() {
        return this.settleStatus;
    }

    public final String getSettledTime() {
        return this.settledTime;
    }

    public final String getSettlementBillId() {
        return this.settlementBillId;
    }

    public final String getSettlementTime() {
        return this.settlementTime;
    }

    public final TransferredAmount getTransferredAmount() {
        return this.transferredAmount;
    }

    public final UnSettledAmount getUnSettledAmount() {
        return this.unSettledAmount;
    }

    public final List<String> getUtrNoList() {
        return this.utrNoList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SettlementBills(String str, NetAmount netAmount2, NetAmountInfo netAmountInfo2, PayOutAmount payOutAmount2, PreUnsettledAmount preUnsettledAmount2, String str2, String str3, String str4, String str5, TransferredAmount transferredAmount2, UnSettledAmount unSettledAmount2, List list, long j, int i2, g gVar) {
        this(str, netAmount2, netAmountInfo2, payOutAmount2, preUnsettledAmount2, str2, str3, str4, str5, transferredAmount2, unSettledAmount2, list, (i2 & 4096) != 0 ? 615534941386393934L : j);
    }

    public SettlementBills(String str, NetAmount netAmount2, NetAmountInfo netAmountInfo2, PayOutAmount payOutAmount2, PreUnsettledAmount preUnsettledAmount2, String str2, String str3, String str4, String str5, TransferredAmount transferredAmount2, UnSettledAmount unSettledAmount2, List<String> list, long j) {
        this.ipRoleId = str;
        this.netAmount = netAmount2;
        this.netAmountInfo = netAmountInfo2;
        this.payOutAmount = payOutAmount2;
        this.preUnsettledAmount = preUnsettledAmount2;
        this.settleStatus = str2;
        this.settledTime = str3;
        this.settlementBillId = str4;
        this.settlementTime = str5;
        this.transferredAmount = transferredAmount2;
        this.unSettledAmount = unSettledAmount2;
        this.utrNoList = list;
        this.serialVersionUID = j;
    }

    public static final class TransferredAmount extends BaseModel {
        @c(a = "currency")
        public final String currency;
        public final long serialVersionUID;
        @c(a = "value")
        public final String value;

        private final long component3() {
            return this.serialVersionUID;
        }

        public static /* synthetic */ TransferredAmount copy$default(TransferredAmount transferredAmount, String str, String str2, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = transferredAmount.currency;
            }
            if ((i2 & 2) != 0) {
                str2 = transferredAmount.value;
            }
            if ((i2 & 4) != 0) {
                j = transferredAmount.serialVersionUID;
            }
            return transferredAmount.copy(str, str2, j);
        }

        public final String component1() {
            return this.currency;
        }

        public final String component2() {
            return this.value;
        }

        public final TransferredAmount copy(String str, String str2, long j) {
            return new TransferredAmount(str, str2, j);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransferredAmount)) {
                return false;
            }
            TransferredAmount transferredAmount = (TransferredAmount) obj;
            return k.a((Object) this.currency, (Object) transferredAmount.currency) && k.a((Object) this.value, (Object) transferredAmount.value) && this.serialVersionUID == transferredAmount.serialVersionUID;
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j = this.serialVersionUID;
            return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "TransferredAmount(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TransferredAmount(String str, String str2, long j, int i2, g gVar) {
            this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
        }

        public TransferredAmount(String str, String str2, long j) {
            this.currency = str;
            this.value = str2;
            this.serialVersionUID = j;
        }
    }

    public static final class NetAmountInfo extends BaseModel {
        @c(a = "cancelAmount")
        public final CancelAmounts cancelAmount;
        @c(a = "cancelCommission")
        public final CancelCommissions cancelCommission;
        @c(a = "cancelCount")
        public final String cancelCount;
        @c(a = "cancelTax")
        public final CancelTaxs cancelTax;
        @c(a = "chargebackAmount")
        public final ChargebackAmounts chargebackAmount;
        @c(a = "chargebackCount")
        public final String chargebackCount;
        @c(a = "collectedAmount")
        public final CollectedAmounts collectedAmount;
        @c(a = "commission")
        public final Commission commission;
        @c(a = "gstAmount")
        public final GstAmounts gstAmount;
        @c(a = "paymentCount")
        public final String paymentCount;
        @c(a = "refundAmount")
        public final RefundAmounts refundAmount;
        @c(a = "refundCommission")
        public final RefundCommissions refundCommission;
        @c(a = "refundCount")
        public final String refundCount;
        @c(a = "refundTax")
        public final RefundTaxs refundTax;
        public final long serialVersionUID;

        private final long component15() {
            return this.serialVersionUID;
        }

        public static /* synthetic */ NetAmountInfo copy$default(NetAmountInfo netAmountInfo, CancelAmounts cancelAmounts, CancelCommissions cancelCommissions, String str, CancelTaxs cancelTaxs, ChargebackAmounts chargebackAmounts, String str2, CollectedAmounts collectedAmounts, Commission commission2, GstAmounts gstAmounts, String str3, RefundAmounts refundAmounts, RefundCommissions refundCommissions, String str4, RefundTaxs refundTaxs, long j, int i2, Object obj) {
            NetAmountInfo netAmountInfo2 = netAmountInfo;
            int i3 = i2;
            return netAmountInfo.copy((i3 & 1) != 0 ? netAmountInfo2.cancelAmount : cancelAmounts, (i3 & 2) != 0 ? netAmountInfo2.cancelCommission : cancelCommissions, (i3 & 4) != 0 ? netAmountInfo2.cancelCount : str, (i3 & 8) != 0 ? netAmountInfo2.cancelTax : cancelTaxs, (i3 & 16) != 0 ? netAmountInfo2.chargebackAmount : chargebackAmounts, (i3 & 32) != 0 ? netAmountInfo2.chargebackCount : str2, (i3 & 64) != 0 ? netAmountInfo2.collectedAmount : collectedAmounts, (i3 & 128) != 0 ? netAmountInfo2.commission : commission2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? netAmountInfo2.gstAmount : gstAmounts, (i3 & 512) != 0 ? netAmountInfo2.paymentCount : str3, (i3 & TarConstants.EOF_BLOCK) != 0 ? netAmountInfo2.refundAmount : refundAmounts, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? netAmountInfo2.refundCommission : refundCommissions, (i3 & 4096) != 0 ? netAmountInfo2.refundCount : str4, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? netAmountInfo2.refundTax : refundTaxs, (i3 & 16384) != 0 ? netAmountInfo2.serialVersionUID : j);
        }

        public final CancelAmounts component1() {
            return this.cancelAmount;
        }

        public final String component10() {
            return this.paymentCount;
        }

        public final RefundAmounts component11() {
            return this.refundAmount;
        }

        public final RefundCommissions component12() {
            return this.refundCommission;
        }

        public final String component13() {
            return this.refundCount;
        }

        public final RefundTaxs component14() {
            return this.refundTax;
        }

        public final CancelCommissions component2() {
            return this.cancelCommission;
        }

        public final String component3() {
            return this.cancelCount;
        }

        public final CancelTaxs component4() {
            return this.cancelTax;
        }

        public final ChargebackAmounts component5() {
            return this.chargebackAmount;
        }

        public final String component6() {
            return this.chargebackCount;
        }

        public final CollectedAmounts component7() {
            return this.collectedAmount;
        }

        public final Commission component8() {
            return this.commission;
        }

        public final GstAmounts component9() {
            return this.gstAmount;
        }

        public final NetAmountInfo copy(CancelAmounts cancelAmounts, CancelCommissions cancelCommissions, String str, CancelTaxs cancelTaxs, ChargebackAmounts chargebackAmounts, String str2, CollectedAmounts collectedAmounts, Commission commission2, GstAmounts gstAmounts, String str3, RefundAmounts refundAmounts, RefundCommissions refundCommissions, String str4, RefundTaxs refundTaxs, long j) {
            return new NetAmountInfo(cancelAmounts, cancelCommissions, str, cancelTaxs, chargebackAmounts, str2, collectedAmounts, commission2, gstAmounts, str3, refundAmounts, refundCommissions, str4, refundTaxs, j);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetAmountInfo)) {
                return false;
            }
            NetAmountInfo netAmountInfo = (NetAmountInfo) obj;
            return k.a((Object) this.cancelAmount, (Object) netAmountInfo.cancelAmount) && k.a((Object) this.cancelCommission, (Object) netAmountInfo.cancelCommission) && k.a((Object) this.cancelCount, (Object) netAmountInfo.cancelCount) && k.a((Object) this.cancelTax, (Object) netAmountInfo.cancelTax) && k.a((Object) this.chargebackAmount, (Object) netAmountInfo.chargebackAmount) && k.a((Object) this.chargebackCount, (Object) netAmountInfo.chargebackCount) && k.a((Object) this.collectedAmount, (Object) netAmountInfo.collectedAmount) && k.a((Object) this.commission, (Object) netAmountInfo.commission) && k.a((Object) this.gstAmount, (Object) netAmountInfo.gstAmount) && k.a((Object) this.paymentCount, (Object) netAmountInfo.paymentCount) && k.a((Object) this.refundAmount, (Object) netAmountInfo.refundAmount) && k.a((Object) this.refundCommission, (Object) netAmountInfo.refundCommission) && k.a((Object) this.refundCount, (Object) netAmountInfo.refundCount) && k.a((Object) this.refundTax, (Object) netAmountInfo.refundTax) && this.serialVersionUID == netAmountInfo.serialVersionUID;
        }

        public final int hashCode() {
            CancelAmounts cancelAmounts = this.cancelAmount;
            int i2 = 0;
            int hashCode = (cancelAmounts != null ? cancelAmounts.hashCode() : 0) * 31;
            CancelCommissions cancelCommissions = this.cancelCommission;
            int hashCode2 = (hashCode + (cancelCommissions != null ? cancelCommissions.hashCode() : 0)) * 31;
            String str = this.cancelCount;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            CancelTaxs cancelTaxs = this.cancelTax;
            int hashCode4 = (hashCode3 + (cancelTaxs != null ? cancelTaxs.hashCode() : 0)) * 31;
            ChargebackAmounts chargebackAmounts = this.chargebackAmount;
            int hashCode5 = (hashCode4 + (chargebackAmounts != null ? chargebackAmounts.hashCode() : 0)) * 31;
            String str2 = this.chargebackCount;
            int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
            CollectedAmounts collectedAmounts = this.collectedAmount;
            int hashCode7 = (hashCode6 + (collectedAmounts != null ? collectedAmounts.hashCode() : 0)) * 31;
            Commission commission2 = this.commission;
            int hashCode8 = (hashCode7 + (commission2 != null ? commission2.hashCode() : 0)) * 31;
            GstAmounts gstAmounts = this.gstAmount;
            int hashCode9 = (hashCode8 + (gstAmounts != null ? gstAmounts.hashCode() : 0)) * 31;
            String str3 = this.paymentCount;
            int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31;
            RefundAmounts refundAmounts = this.refundAmount;
            int hashCode11 = (hashCode10 + (refundAmounts != null ? refundAmounts.hashCode() : 0)) * 31;
            RefundCommissions refundCommissions = this.refundCommission;
            int hashCode12 = (hashCode11 + (refundCommissions != null ? refundCommissions.hashCode() : 0)) * 31;
            String str4 = this.refundCount;
            int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 31;
            RefundTaxs refundTaxs = this.refundTax;
            if (refundTaxs != null) {
                i2 = refundTaxs.hashCode();
            }
            long j = this.serialVersionUID;
            return ((hashCode13 + i2) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "NetAmountInfo(cancelAmount=" + this.cancelAmount + ", cancelCommission=" + this.cancelCommission + ", cancelCount=" + this.cancelCount + ", cancelTax=" + this.cancelTax + ", chargebackAmount=" + this.chargebackAmount + ", chargebackCount=" + this.chargebackCount + ", collectedAmount=" + this.collectedAmount + ", commission=" + this.commission + ", gstAmount=" + this.gstAmount + ", paymentCount=" + this.paymentCount + ", refundAmount=" + this.refundAmount + ", refundCommission=" + this.refundCommission + ", refundCount=" + this.refundCount + ", refundTax=" + this.refundTax + ", serialVersionUID=" + this.serialVersionUID + ")";
        }

        public final CancelAmounts getCancelAmount() {
            return this.cancelAmount;
        }

        public final CancelCommissions getCancelCommission() {
            return this.cancelCommission;
        }

        public final String getCancelCount() {
            return this.cancelCount;
        }

        public final CancelTaxs getCancelTax() {
            return this.cancelTax;
        }

        public final ChargebackAmounts getChargebackAmount() {
            return this.chargebackAmount;
        }

        public final String getChargebackCount() {
            return this.chargebackCount;
        }

        public final CollectedAmounts getCollectedAmount() {
            return this.collectedAmount;
        }

        public final Commission getCommission() {
            return this.commission;
        }

        public final GstAmounts getGstAmount() {
            return this.gstAmount;
        }

        public final String getPaymentCount() {
            return this.paymentCount;
        }

        public final RefundAmounts getRefundAmount() {
            return this.refundAmount;
        }

        public final RefundCommissions getRefundCommission() {
            return this.refundCommission;
        }

        public final String getRefundCount() {
            return this.refundCount;
        }

        public final RefundTaxs getRefundTax() {
            return this.refundTax;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetAmountInfo(CancelAmounts cancelAmounts, CancelCommissions cancelCommissions, String str, CancelTaxs cancelTaxs, ChargebackAmounts chargebackAmounts, String str2, CollectedAmounts collectedAmounts, Commission commission2, GstAmounts gstAmounts, String str3, RefundAmounts refundAmounts, RefundCommissions refundCommissions, String str4, RefundTaxs refundTaxs, long j, int i2, g gVar) {
            this(cancelAmounts, cancelCommissions, str, cancelTaxs, chargebackAmounts, str2, collectedAmounts, commission2, gstAmounts, str3, refundAmounts, refundCommissions, str4, refundTaxs, (i2 & 16384) != 0 ? 615534941386393934L : j);
        }

        public NetAmountInfo(CancelAmounts cancelAmounts, CancelCommissions cancelCommissions, String str, CancelTaxs cancelTaxs, ChargebackAmounts chargebackAmounts, String str2, CollectedAmounts collectedAmounts, Commission commission2, GstAmounts gstAmounts, String str3, RefundAmounts refundAmounts, RefundCommissions refundCommissions, String str4, RefundTaxs refundTaxs, long j) {
            this.cancelAmount = cancelAmounts;
            this.cancelCommission = cancelCommissions;
            this.cancelCount = str;
            this.cancelTax = cancelTaxs;
            this.chargebackAmount = chargebackAmounts;
            this.chargebackCount = str2;
            this.collectedAmount = collectedAmounts;
            this.commission = commission2;
            this.gstAmount = gstAmounts;
            this.paymentCount = str3;
            this.refundAmount = refundAmounts;
            this.refundCommission = refundCommissions;
            this.refundCount = str4;
            this.refundTax = refundTaxs;
            this.serialVersionUID = j;
        }

        public static final class RefundTaxs extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ RefundTaxs copy$default(RefundTaxs refundTaxs, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = refundTaxs.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = refundTaxs.value;
                }
                if ((i2 & 4) != 0) {
                    j = refundTaxs.serialVersionUID;
                }
                return refundTaxs.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final RefundTaxs copy(String str, String str2, long j) {
                return new RefundTaxs(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RefundTaxs)) {
                    return false;
                }
                RefundTaxs refundTaxs = (RefundTaxs) obj;
                return k.a((Object) this.currency, (Object) refundTaxs.currency) && k.a((Object) this.value, (Object) refundTaxs.value) && this.serialVersionUID == refundTaxs.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "RefundTaxs(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ RefundTaxs(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public RefundTaxs(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class CancelAmounts extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ CancelAmounts copy$default(CancelAmounts cancelAmounts, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = cancelAmounts.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = cancelAmounts.value;
                }
                if ((i2 & 4) != 0) {
                    j = cancelAmounts.serialVersionUID;
                }
                return cancelAmounts.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final CancelAmounts copy(String str, String str2, long j) {
                return new CancelAmounts(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CancelAmounts)) {
                    return false;
                }
                CancelAmounts cancelAmounts = (CancelAmounts) obj;
                return k.a((Object) this.currency, (Object) cancelAmounts.currency) && k.a((Object) this.value, (Object) cancelAmounts.value) && this.serialVersionUID == cancelAmounts.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "CancelAmounts(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CancelAmounts(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public CancelAmounts(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class GstAmounts extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ GstAmounts copy$default(GstAmounts gstAmounts, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = gstAmounts.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = gstAmounts.value;
                }
                if ((i2 & 4) != 0) {
                    j = gstAmounts.serialVersionUID;
                }
                return gstAmounts.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final GstAmounts copy(String str, String str2, long j) {
                return new GstAmounts(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GstAmounts)) {
                    return false;
                }
                GstAmounts gstAmounts = (GstAmounts) obj;
                return k.a((Object) this.currency, (Object) gstAmounts.currency) && k.a((Object) this.value, (Object) gstAmounts.value) && this.serialVersionUID == gstAmounts.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "GstAmounts(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ GstAmounts(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public GstAmounts(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class Commission extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ Commission copy$default(Commission commission, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = commission.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = commission.value;
                }
                if ((i2 & 4) != 0) {
                    j = commission.serialVersionUID;
                }
                return commission.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final Commission copy(String str, String str2, long j) {
                return new Commission(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Commission)) {
                    return false;
                }
                Commission commission = (Commission) obj;
                return k.a((Object) this.currency, (Object) commission.currency) && k.a((Object) this.value, (Object) commission.value) && this.serialVersionUID == commission.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "Commission(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Commission(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public Commission(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class CancelCommissions extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ CancelCommissions copy$default(CancelCommissions cancelCommissions, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = cancelCommissions.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = cancelCommissions.value;
                }
                if ((i2 & 4) != 0) {
                    j = cancelCommissions.serialVersionUID;
                }
                return cancelCommissions.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final CancelCommissions copy(String str, String str2, long j) {
                return new CancelCommissions(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CancelCommissions)) {
                    return false;
                }
                CancelCommissions cancelCommissions = (CancelCommissions) obj;
                return k.a((Object) this.currency, (Object) cancelCommissions.currency) && k.a((Object) this.value, (Object) cancelCommissions.value) && this.serialVersionUID == cancelCommissions.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "CancelCommissions(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CancelCommissions(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public CancelCommissions(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class CancelTaxs extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ CancelTaxs copy$default(CancelTaxs cancelTaxs, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = cancelTaxs.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = cancelTaxs.value;
                }
                if ((i2 & 4) != 0) {
                    j = cancelTaxs.serialVersionUID;
                }
                return cancelTaxs.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final CancelTaxs copy(String str, String str2, long j) {
                return new CancelTaxs(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CancelTaxs)) {
                    return false;
                }
                CancelTaxs cancelTaxs = (CancelTaxs) obj;
                return k.a((Object) this.currency, (Object) cancelTaxs.currency) && k.a((Object) this.value, (Object) cancelTaxs.value) && this.serialVersionUID == cancelTaxs.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "CancelTaxs(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CancelTaxs(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public CancelTaxs(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class ChargebackAmounts extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ ChargebackAmounts copy$default(ChargebackAmounts chargebackAmounts, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = chargebackAmounts.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = chargebackAmounts.value;
                }
                if ((i2 & 4) != 0) {
                    j = chargebackAmounts.serialVersionUID;
                }
                return chargebackAmounts.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final ChargebackAmounts copy(String str, String str2, long j) {
                return new ChargebackAmounts(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ChargebackAmounts)) {
                    return false;
                }
                ChargebackAmounts chargebackAmounts = (ChargebackAmounts) obj;
                return k.a((Object) this.currency, (Object) chargebackAmounts.currency) && k.a((Object) this.value, (Object) chargebackAmounts.value) && this.serialVersionUID == chargebackAmounts.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "ChargebackAmounts(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ChargebackAmounts(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public ChargebackAmounts(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class RefundAmounts extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ RefundAmounts copy$default(RefundAmounts refundAmounts, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = refundAmounts.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = refundAmounts.value;
                }
                if ((i2 & 4) != 0) {
                    j = refundAmounts.serialVersionUID;
                }
                return refundAmounts.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final RefundAmounts copy(String str, String str2, long j) {
                return new RefundAmounts(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RefundAmounts)) {
                    return false;
                }
                RefundAmounts refundAmounts = (RefundAmounts) obj;
                return k.a((Object) this.currency, (Object) refundAmounts.currency) && k.a((Object) this.value, (Object) refundAmounts.value) && this.serialVersionUID == refundAmounts.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "RefundAmounts(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ RefundAmounts(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public RefundAmounts(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class RefundCommissions extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ RefundCommissions copy$default(RefundCommissions refundCommissions, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = refundCommissions.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = refundCommissions.value;
                }
                if ((i2 & 4) != 0) {
                    j = refundCommissions.serialVersionUID;
                }
                return refundCommissions.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final RefundCommissions copy(String str, String str2, long j) {
                return new RefundCommissions(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RefundCommissions)) {
                    return false;
                }
                RefundCommissions refundCommissions = (RefundCommissions) obj;
                return k.a((Object) this.currency, (Object) refundCommissions.currency) && k.a((Object) this.value, (Object) refundCommissions.value) && this.serialVersionUID == refundCommissions.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "RefundCommissions(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ RefundCommissions(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public RefundCommissions(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }

        public static final class CollectedAmounts extends BaseModel {
            @c(a = "currency")
            public final String currency;
            public final long serialVersionUID;
            @c(a = "value")
            public final String value;

            private final long component3() {
                return this.serialVersionUID;
            }

            public static /* synthetic */ CollectedAmounts copy$default(CollectedAmounts collectedAmounts, String str, String str2, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = collectedAmounts.currency;
                }
                if ((i2 & 2) != 0) {
                    str2 = collectedAmounts.value;
                }
                if ((i2 & 4) != 0) {
                    j = collectedAmounts.serialVersionUID;
                }
                return collectedAmounts.copy(str, str2, j);
            }

            public final String component1() {
                return this.currency;
            }

            public final String component2() {
                return this.value;
            }

            public final CollectedAmounts copy(String str, String str2, long j) {
                return new CollectedAmounts(str, str2, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CollectedAmounts)) {
                    return false;
                }
                CollectedAmounts collectedAmounts = (CollectedAmounts) obj;
                return k.a((Object) this.currency, (Object) collectedAmounts.currency) && k.a((Object) this.value, (Object) collectedAmounts.value) && this.serialVersionUID == collectedAmounts.serialVersionUID;
            }

            public final int hashCode() {
                String str = this.currency;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.value;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                long j = this.serialVersionUID;
                return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "CollectedAmounts(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
            }

            public final String getCurrency() {
                return this.currency;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CollectedAmounts(String str, String str2, long j, int i2, g gVar) {
                this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
            }

            public CollectedAmounts(String str, String str2, long j) {
                this.currency = str;
                this.value = str2;
                this.serialVersionUID = j;
            }
        }
    }

    public static final class UnSettledAmount extends BaseModel {
        @c(a = "currency")
        public final String currency;
        public final long serialVersionUID;
        @c(a = "value")
        public final String value;

        private final long component3() {
            return this.serialVersionUID;
        }

        public static /* synthetic */ UnSettledAmount copy$default(UnSettledAmount unSettledAmount, String str, String str2, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = unSettledAmount.currency;
            }
            if ((i2 & 2) != 0) {
                str2 = unSettledAmount.value;
            }
            if ((i2 & 4) != 0) {
                j = unSettledAmount.serialVersionUID;
            }
            return unSettledAmount.copy(str, str2, j);
        }

        public final String component1() {
            return this.currency;
        }

        public final String component2() {
            return this.value;
        }

        public final UnSettledAmount copy(String str, String str2, long j) {
            return new UnSettledAmount(str, str2, j);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UnSettledAmount)) {
                return false;
            }
            UnSettledAmount unSettledAmount = (UnSettledAmount) obj;
            return k.a((Object) this.currency, (Object) unSettledAmount.currency) && k.a((Object) this.value, (Object) unSettledAmount.value) && this.serialVersionUID == unSettledAmount.serialVersionUID;
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j = this.serialVersionUID;
            return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "UnSettledAmount(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UnSettledAmount(String str, String str2, long j, int i2, g gVar) {
            this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
        }

        public UnSettledAmount(String str, String str2, long j) {
            this.currency = str;
            this.value = str2;
            this.serialVersionUID = j;
        }
    }

    public static final class PreUnsettledAmount extends BaseModel {
        @c(a = "currency")
        public final String currency;
        public final long serialVersionUID;
        @c(a = "value")
        public final String value;

        private final long component3() {
            return this.serialVersionUID;
        }

        public static /* synthetic */ PreUnsettledAmount copy$default(PreUnsettledAmount preUnsettledAmount, String str, String str2, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = preUnsettledAmount.currency;
            }
            if ((i2 & 2) != 0) {
                str2 = preUnsettledAmount.value;
            }
            if ((i2 & 4) != 0) {
                j = preUnsettledAmount.serialVersionUID;
            }
            return preUnsettledAmount.copy(str, str2, j);
        }

        public final String component1() {
            return this.currency;
        }

        public final String component2() {
            return this.value;
        }

        public final PreUnsettledAmount copy(String str, String str2, long j) {
            return new PreUnsettledAmount(str, str2, j);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PreUnsettledAmount)) {
                return false;
            }
            PreUnsettledAmount preUnsettledAmount = (PreUnsettledAmount) obj;
            return k.a((Object) this.currency, (Object) preUnsettledAmount.currency) && k.a((Object) this.value, (Object) preUnsettledAmount.value) && this.serialVersionUID == preUnsettledAmount.serialVersionUID;
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j = this.serialVersionUID;
            return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "PreUnsettledAmount(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PreUnsettledAmount(String str, String str2, long j, int i2, g gVar) {
            this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
        }

        public PreUnsettledAmount(String str, String str2, long j) {
            this.currency = str;
            this.value = str2;
            this.serialVersionUID = j;
        }
    }

    public static final class PayOutAmount extends BaseModel {
        @c(a = "currency")
        public final String currency;
        public final long serialVersionUID;
        @c(a = "value")
        public final String value;

        private final long component3() {
            return this.serialVersionUID;
        }

        public static /* synthetic */ PayOutAmount copy$default(PayOutAmount payOutAmount, String str, String str2, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = payOutAmount.currency;
            }
            if ((i2 & 2) != 0) {
                str2 = payOutAmount.value;
            }
            if ((i2 & 4) != 0) {
                j = payOutAmount.serialVersionUID;
            }
            return payOutAmount.copy(str, str2, j);
        }

        public final String component1() {
            return this.currency;
        }

        public final String component2() {
            return this.value;
        }

        public final PayOutAmount copy(String str, String str2, long j) {
            return new PayOutAmount(str, str2, j);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PayOutAmount)) {
                return false;
            }
            PayOutAmount payOutAmount = (PayOutAmount) obj;
            return k.a((Object) this.currency, (Object) payOutAmount.currency) && k.a((Object) this.value, (Object) payOutAmount.value) && this.serialVersionUID == payOutAmount.serialVersionUID;
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j = this.serialVersionUID;
            return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "PayOutAmount(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PayOutAmount(String str, String str2, long j, int i2, g gVar) {
            this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
        }

        public PayOutAmount(String str, String str2, long j) {
            this.currency = str;
            this.value = str2;
            this.serialVersionUID = j;
        }
    }

    public static final class NetAmount extends BaseModel {
        @c(a = "currency")
        public final String currency;
        public final long serialVersionUID;
        @c(a = "value")
        public final String value;

        private final long component3() {
            return this.serialVersionUID;
        }

        public static /* synthetic */ NetAmount copy$default(NetAmount netAmount, String str, String str2, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = netAmount.currency;
            }
            if ((i2 & 2) != 0) {
                str2 = netAmount.value;
            }
            if ((i2 & 4) != 0) {
                j = netAmount.serialVersionUID;
            }
            return netAmount.copy(str, str2, j);
        }

        public final String component1() {
            return this.currency;
        }

        public final String component2() {
            return this.value;
        }

        public final NetAmount copy(String str, String str2, long j) {
            return new NetAmount(str, str2, j);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetAmount)) {
                return false;
            }
            NetAmount netAmount = (NetAmount) obj;
            return k.a((Object) this.currency, (Object) netAmount.currency) && k.a((Object) this.value, (Object) netAmount.value) && this.serialVersionUID == netAmount.serialVersionUID;
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j = this.serialVersionUID;
            return ((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "NetAmount(currency=" + this.currency + ", value=" + this.value + ", serialVersionUID=" + this.serialVersionUID + ")";
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetAmount(String str, String str2, long j, int i2, g gVar) {
            this(str, str2, (i2 & 4) != 0 ? 615534941386393934L : j);
        }

        public NetAmount(String str, String str2, long j) {
            this.currency = str;
            this.value = str2;
            this.serialVersionUID = j;
        }
    }
}
