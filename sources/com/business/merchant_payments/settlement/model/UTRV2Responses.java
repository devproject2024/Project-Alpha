package com.business.merchant_payments.settlement.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class UTRV2Responses {
    public Double cancelCount;
    public Double chargeBackCount;
    public String ipRoleId;
    public Double paymentCount;
    public Double refundCount;
    public ResultInfo resultInfo;
    public TotalCancelAmounts totalCancelAmount;
    public TotalCancelCommissions totalCancelCommission;
    public TotalCancelTaxAmounts totalCancelTaxAmount;
    public TotalChargebackAmounts totalChargebackAmount;
    public TotalCollectedAmounts totalCollectedAmount;
    public TotalCommissions totalCommission;
    public TotalGstAmounts totalGstAmount;
    public TotalNetAmounts totalNetAmount;
    public TotalRefundAmounts totalRefundAmount;
    public TotalRefundCommissions totalRefundCommission;
    public TotalRefundTaxAmounts totalRefundTaxAmount;
    public TransferredAmounts transferredAmount;

    public final Double getCancelCount() {
        return this.cancelCount;
    }

    public final void setCancelCount(Double d2) {
        this.cancelCount = d2;
    }

    public final Double getChargeBackCount() {
        return this.chargeBackCount;
    }

    public final void setChargeBackCount(Double d2) {
        this.chargeBackCount = d2;
    }

    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    public final void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public final Double getPaymentCount() {
        return this.paymentCount;
    }

    public final void setPaymentCount(Double d2) {
        this.paymentCount = d2;
    }

    public final Double getRefundCount() {
        return this.refundCount;
    }

    public final void setRefundCount(Double d2) {
        this.refundCount = d2;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public final TotalCancelAmounts getTotalCancelAmount() {
        return this.totalCancelAmount;
    }

    public final void setTotalCancelAmount(TotalCancelAmounts totalCancelAmounts) {
        this.totalCancelAmount = totalCancelAmounts;
    }

    public final TotalCancelCommissions getTotalCancelCommission() {
        return this.totalCancelCommission;
    }

    public final void setTotalCancelCommission(TotalCancelCommissions totalCancelCommissions) {
        this.totalCancelCommission = totalCancelCommissions;
    }

    public final TotalCancelTaxAmounts getTotalCancelTaxAmount() {
        return this.totalCancelTaxAmount;
    }

    public final void setTotalCancelTaxAmount(TotalCancelTaxAmounts totalCancelTaxAmounts) {
        this.totalCancelTaxAmount = totalCancelTaxAmounts;
    }

    public final TotalChargebackAmounts getTotalChargebackAmount() {
        return this.totalChargebackAmount;
    }

    public final void setTotalChargebackAmount(TotalChargebackAmounts totalChargebackAmounts) {
        this.totalChargebackAmount = totalChargebackAmounts;
    }

    public final TotalCollectedAmounts getTotalCollectedAmount() {
        return this.totalCollectedAmount;
    }

    public final void setTotalCollectedAmount(TotalCollectedAmounts totalCollectedAmounts) {
        this.totalCollectedAmount = totalCollectedAmounts;
    }

    public final TotalCommissions getTotalCommission() {
        return this.totalCommission;
    }

    public final void setTotalCommission(TotalCommissions totalCommissions) {
        this.totalCommission = totalCommissions;
    }

    public final TotalGstAmounts getTotalGstAmount() {
        return this.totalGstAmount;
    }

    public final void setTotalGstAmount(TotalGstAmounts totalGstAmounts) {
        this.totalGstAmount = totalGstAmounts;
    }

    public final TotalNetAmounts getTotalNetAmount() {
        return this.totalNetAmount;
    }

    public final void setTotalNetAmount(TotalNetAmounts totalNetAmounts) {
        this.totalNetAmount = totalNetAmounts;
    }

    public final TotalRefundAmounts getTotalRefundAmount() {
        return this.totalRefundAmount;
    }

    public final void setTotalRefundAmount(TotalRefundAmounts totalRefundAmounts) {
        this.totalRefundAmount = totalRefundAmounts;
    }

    public final TotalRefundCommissions getTotalRefundCommission() {
        return this.totalRefundCommission;
    }

    public final void setTotalRefundCommission(TotalRefundCommissions totalRefundCommissions) {
        this.totalRefundCommission = totalRefundCommissions;
    }

    public final TotalRefundTaxAmounts getTotalRefundTaxAmount() {
        return this.totalRefundTaxAmount;
    }

    public final void setTotalRefundTaxAmount(TotalRefundTaxAmounts totalRefundTaxAmounts) {
        this.totalRefundTaxAmount = totalRefundTaxAmounts;
    }

    public final TransferredAmounts getTransferredAmount() {
        return this.transferredAmount;
    }

    public final void setTransferredAmount(TransferredAmounts transferredAmounts) {
        this.transferredAmount = transferredAmounts;
    }

    public static final class TotalCommissions {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCommissions copy$default(TotalCommissions totalCommissions, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCommissions.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCommissions.value;
            }
            return totalCommissions.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCommissions copy(String str, Double d2) {
            return new TotalCommissions(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCommissions)) {
                return false;
            }
            TotalCommissions totalCommissions = (TotalCommissions) obj;
            return k.a((Object) this.currency, (Object) totalCommissions.currency) && k.a((Object) this.value, (Object) totalCommissions.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalCommissions(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCommissions(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalRefundCommissions {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalRefundCommissions copy$default(TotalRefundCommissions totalRefundCommissions, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalRefundCommissions.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalRefundCommissions.value;
            }
            return totalRefundCommissions.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalRefundCommissions copy(String str, Double d2) {
            return new TotalRefundCommissions(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalRefundCommissions)) {
                return false;
            }
            TotalRefundCommissions totalRefundCommissions = (TotalRefundCommissions) obj;
            return k.a((Object) this.currency, (Object) totalRefundCommissions.currency) && k.a((Object) this.value, (Object) totalRefundCommissions.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalRefundCommissions(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalRefundCommissions(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalCollectedAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCollectedAmounts copy$default(TotalCollectedAmounts totalCollectedAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCollectedAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCollectedAmounts.value;
            }
            return totalCollectedAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCollectedAmounts copy(String str, Double d2) {
            return new TotalCollectedAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCollectedAmounts)) {
                return false;
            }
            TotalCollectedAmounts totalCollectedAmounts = (TotalCollectedAmounts) obj;
            return k.a((Object) this.currency, (Object) totalCollectedAmounts.currency) && k.a((Object) this.value, (Object) totalCollectedAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalCollectedAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCollectedAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalCancelCommissions {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCancelCommissions copy$default(TotalCancelCommissions totalCancelCommissions, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCancelCommissions.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCancelCommissions.value;
            }
            return totalCancelCommissions.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCancelCommissions copy(String str, Double d2) {
            return new TotalCancelCommissions(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCancelCommissions)) {
                return false;
            }
            TotalCancelCommissions totalCancelCommissions = (TotalCancelCommissions) obj;
            return k.a((Object) this.currency, (Object) totalCancelCommissions.currency) && k.a((Object) this.value, (Object) totalCancelCommissions.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalCancelCommissions(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCancelCommissions(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalGstAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalGstAmounts copy$default(TotalGstAmounts totalGstAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalGstAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalGstAmounts.value;
            }
            return totalGstAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalGstAmounts copy(String str, Double d2) {
            return new TotalGstAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalGstAmounts)) {
                return false;
            }
            TotalGstAmounts totalGstAmounts = (TotalGstAmounts) obj;
            return k.a((Object) this.currency, (Object) totalGstAmounts.currency) && k.a((Object) this.value, (Object) totalGstAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalGstAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalGstAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalRefundAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalRefundAmounts copy$default(TotalRefundAmounts totalRefundAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalRefundAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalRefundAmounts.value;
            }
            return totalRefundAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalRefundAmounts copy(String str, Double d2) {
            return new TotalRefundAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalRefundAmounts)) {
                return false;
            }
            TotalRefundAmounts totalRefundAmounts = (TotalRefundAmounts) obj;
            return k.a((Object) this.currency, (Object) totalRefundAmounts.currency) && k.a((Object) this.value, (Object) totalRefundAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalRefundAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalRefundAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalChargebackAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalChargebackAmounts copy$default(TotalChargebackAmounts totalChargebackAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalChargebackAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalChargebackAmounts.value;
            }
            return totalChargebackAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalChargebackAmounts copy(String str, Double d2) {
            return new TotalChargebackAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalChargebackAmounts)) {
                return false;
            }
            TotalChargebackAmounts totalChargebackAmounts = (TotalChargebackAmounts) obj;
            return k.a((Object) this.currency, (Object) totalChargebackAmounts.currency) && k.a((Object) this.value, (Object) totalChargebackAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalChargebackAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalChargebackAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalRefundTaxAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalRefundTaxAmounts copy$default(TotalRefundTaxAmounts totalRefundTaxAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalRefundTaxAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalRefundTaxAmounts.value;
            }
            return totalRefundTaxAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalRefundTaxAmounts copy(String str, Double d2) {
            return new TotalRefundTaxAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalRefundTaxAmounts)) {
                return false;
            }
            TotalRefundTaxAmounts totalRefundTaxAmounts = (TotalRefundTaxAmounts) obj;
            return k.a((Object) this.currency, (Object) totalRefundTaxAmounts.currency) && k.a((Object) this.value, (Object) totalRefundTaxAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalRefundTaxAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalRefundTaxAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalCancelAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCancelAmounts copy$default(TotalCancelAmounts totalCancelAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCancelAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCancelAmounts.value;
            }
            return totalCancelAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCancelAmounts copy(String str, Double d2) {
            return new TotalCancelAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCancelAmounts)) {
                return false;
            }
            TotalCancelAmounts totalCancelAmounts = (TotalCancelAmounts) obj;
            return k.a((Object) this.currency, (Object) totalCancelAmounts.currency) && k.a((Object) this.value, (Object) totalCancelAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalCancelAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCancelAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TotalNetAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalNetAmounts copy$default(TotalNetAmounts totalNetAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalNetAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalNetAmounts.value;
            }
            return totalNetAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalNetAmounts copy(String str, Double d2) {
            return new TotalNetAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalNetAmounts)) {
                return false;
            }
            TotalNetAmounts totalNetAmounts = (TotalNetAmounts) obj;
            return k.a((Object) this.currency, (Object) totalNetAmounts.currency) && k.a((Object) this.value, (Object) totalNetAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalNetAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalNetAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TotalNetAmounts(String str, Double d2, int i2, g gVar) {
            this(str, (i2 & 2) != 0 ? Double.valueOf(-1.0d) : d2);
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TransferredAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TransferredAmounts copy$default(TransferredAmounts transferredAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = transferredAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = transferredAmounts.value;
            }
            return transferredAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TransferredAmounts copy(String str, Double d2) {
            return new TransferredAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransferredAmounts)) {
                return false;
            }
            TransferredAmounts transferredAmounts = (TransferredAmounts) obj;
            return k.a((Object) this.currency, (Object) transferredAmounts.currency) && k.a((Object) this.value, (Object) transferredAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TransferredAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TransferredAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class ResultInfo {
        public String resultCode;
        public String resultCodeId;
        public String resultMsg;
        public String resultStatus;

        public static /* synthetic */ ResultInfo copy$default(ResultInfo resultInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = resultInfo.resultCode;
            }
            if ((i2 & 2) != 0) {
                str2 = resultInfo.resultCodeId;
            }
            if ((i2 & 4) != 0) {
                str3 = resultInfo.resultMsg;
            }
            if ((i2 & 8) != 0) {
                str4 = resultInfo.resultStatus;
            }
            return resultInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.resultCode;
        }

        public final String component2() {
            return this.resultCodeId;
        }

        public final String component3() {
            return this.resultMsg;
        }

        public final String component4() {
            return this.resultStatus;
        }

        public final ResultInfo copy(String str, String str2, String str3, String str4) {
            return new ResultInfo(str, str2, str3, str4);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultInfo)) {
                return false;
            }
            ResultInfo resultInfo = (ResultInfo) obj;
            return k.a((Object) this.resultCode, (Object) resultInfo.resultCode) && k.a((Object) this.resultCodeId, (Object) resultInfo.resultCodeId) && k.a((Object) this.resultMsg, (Object) resultInfo.resultMsg) && k.a((Object) this.resultStatus, (Object) resultInfo.resultStatus);
        }

        public final int hashCode() {
            String str = this.resultCode;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.resultCodeId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.resultMsg;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.resultStatus;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return hashCode3 + i2;
        }

        public final String toString() {
            return "ResultInfo(resultCode=" + this.resultCode + ", resultCodeId=" + this.resultCodeId + ", resultMsg=" + this.resultMsg + ", resultStatus=" + this.resultStatus + ")";
        }

        public ResultInfo(String str, String str2, String str3, String str4) {
            this.resultCode = str;
            this.resultCodeId = str2;
            this.resultMsg = str3;
            this.resultStatus = str4;
        }

        public final String getResultCode() {
            return this.resultCode;
        }

        public final void setResultCode(String str) {
            this.resultCode = str;
        }

        public final String getResultCodeId() {
            return this.resultCodeId;
        }

        public final void setResultCodeId(String str) {
            this.resultCodeId = str;
        }

        public final String getResultMsg() {
            return this.resultMsg;
        }

        public final void setResultMsg(String str) {
            this.resultMsg = str;
        }

        public final String getResultStatus() {
            return this.resultStatus;
        }

        public final void setResultStatus(String str) {
            this.resultStatus = str;
        }
    }

    public static final class TotalCancelTaxAmounts {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCancelTaxAmounts copy$default(TotalCancelTaxAmounts totalCancelTaxAmounts, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCancelTaxAmounts.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCancelTaxAmounts.value;
            }
            return totalCancelTaxAmounts.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCancelTaxAmounts copy(String str, Double d2) {
            return new TotalCancelTaxAmounts(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCancelTaxAmounts)) {
                return false;
            }
            TotalCancelTaxAmounts totalCancelTaxAmounts = (TotalCancelTaxAmounts) obj;
            return k.a((Object) this.currency, (Object) totalCancelTaxAmounts.currency) && k.a((Object) this.value, (Object) totalCancelTaxAmounts.value);
        }

        public final int hashCode() {
            String str = this.currency;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Double d2 = this.value;
            if (d2 != null) {
                i2 = d2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "TotalCancelTaxAmounts(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCancelTaxAmounts(String str, Double d2) {
            this.currency = str;
            this.value = d2;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }
}
