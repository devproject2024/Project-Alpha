package com.business.merchant_payments.settlement.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class UTRV2Response {
    public Double cancelCount;
    public Double chargeBackCount;
    public String ipRoleId;
    public Double paymentCount;
    public Double refundCount;
    public ResultInfo resultInfo;
    public TotalCancelAmount totalCancelAmount;
    public TotalCancelCommission totalCancelCommission;
    public TotalCancelTaxAmount totalCancelTaxAmount;
    public TotalChargebackAmount totalChargebackAmount;
    public TotalCollectedAmount totalCollectedAmount;
    public TotalCommission totalCommission;
    public TotalGstAmount totalGstAmount;
    public TotalNetAmount totalNetAmount;
    public TotalRefundAmount totalRefundAmount;
    public TotalRefundCommission totalRefundCommission;
    public TotalRefundTaxAmount totalRefundTaxAmount;
    public TransferredAmount transferredAmount;

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

    public final TotalCancelAmount getTotalCancelAmount() {
        return this.totalCancelAmount;
    }

    public final void setTotalCancelAmount(TotalCancelAmount totalCancelAmount2) {
        this.totalCancelAmount = totalCancelAmount2;
    }

    public final TotalCancelCommission getTotalCancelCommission() {
        return this.totalCancelCommission;
    }

    public final void setTotalCancelCommission(TotalCancelCommission totalCancelCommission2) {
        this.totalCancelCommission = totalCancelCommission2;
    }

    public final TotalCancelTaxAmount getTotalCancelTaxAmount() {
        return this.totalCancelTaxAmount;
    }

    public final void setTotalCancelTaxAmount(TotalCancelTaxAmount totalCancelTaxAmount2) {
        this.totalCancelTaxAmount = totalCancelTaxAmount2;
    }

    public final TotalChargebackAmount getTotalChargebackAmount() {
        return this.totalChargebackAmount;
    }

    public final void setTotalChargebackAmount(TotalChargebackAmount totalChargebackAmount2) {
        this.totalChargebackAmount = totalChargebackAmount2;
    }

    public final TotalCollectedAmount getTotalCollectedAmount() {
        return this.totalCollectedAmount;
    }

    public final void setTotalCollectedAmount(TotalCollectedAmount totalCollectedAmount2) {
        this.totalCollectedAmount = totalCollectedAmount2;
    }

    public final TotalCommission getTotalCommission() {
        return this.totalCommission;
    }

    public final void setTotalCommission(TotalCommission totalCommission2) {
        this.totalCommission = totalCommission2;
    }

    public final TotalGstAmount getTotalGstAmount() {
        return this.totalGstAmount;
    }

    public final void setTotalGstAmount(TotalGstAmount totalGstAmount2) {
        this.totalGstAmount = totalGstAmount2;
    }

    public final TotalNetAmount getTotalNetAmount() {
        return this.totalNetAmount;
    }

    public final void setTotalNetAmount(TotalNetAmount totalNetAmount2) {
        this.totalNetAmount = totalNetAmount2;
    }

    public final TotalRefundAmount getTotalRefundAmount() {
        return this.totalRefundAmount;
    }

    public final void setTotalRefundAmount(TotalRefundAmount totalRefundAmount2) {
        this.totalRefundAmount = totalRefundAmount2;
    }

    public final TotalRefundCommission getTotalRefundCommission() {
        return this.totalRefundCommission;
    }

    public final void setTotalRefundCommission(TotalRefundCommission totalRefundCommission2) {
        this.totalRefundCommission = totalRefundCommission2;
    }

    public final TotalRefundTaxAmount getTotalRefundTaxAmount() {
        return this.totalRefundTaxAmount;
    }

    public final void setTotalRefundTaxAmount(TotalRefundTaxAmount totalRefundTaxAmount2) {
        this.totalRefundTaxAmount = totalRefundTaxAmount2;
    }

    public final TransferredAmount getTransferredAmount() {
        return this.transferredAmount;
    }

    public final void setTransferredAmount(TransferredAmount transferredAmount2) {
        this.transferredAmount = transferredAmount2;
    }

    public static final class TotalCommission {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCommission copy$default(TotalCommission totalCommission, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCommission.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCommission.value;
            }
            return totalCommission.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCommission copy(String str, Double d2) {
            return new TotalCommission(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCommission)) {
                return false;
            }
            TotalCommission totalCommission = (TotalCommission) obj;
            return k.a((Object) this.currency, (Object) totalCommission.currency) && k.a((Object) this.value, (Object) totalCommission.value);
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
            return "TotalCommission(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCommission(String str, Double d2) {
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

    public static final class TotalRefundCommission {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalRefundCommission copy$default(TotalRefundCommission totalRefundCommission, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalRefundCommission.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalRefundCommission.value;
            }
            return totalRefundCommission.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalRefundCommission copy(String str, Double d2) {
            return new TotalRefundCommission(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalRefundCommission)) {
                return false;
            }
            TotalRefundCommission totalRefundCommission = (TotalRefundCommission) obj;
            return k.a((Object) this.currency, (Object) totalRefundCommission.currency) && k.a((Object) this.value, (Object) totalRefundCommission.value);
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
            return "TotalRefundCommission(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalRefundCommission(String str, Double d2) {
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

    public static final class TotalCollectedAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCollectedAmount copy$default(TotalCollectedAmount totalCollectedAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCollectedAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCollectedAmount.value;
            }
            return totalCollectedAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCollectedAmount copy(String str, Double d2) {
            return new TotalCollectedAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCollectedAmount)) {
                return false;
            }
            TotalCollectedAmount totalCollectedAmount = (TotalCollectedAmount) obj;
            return k.a((Object) this.currency, (Object) totalCollectedAmount.currency) && k.a((Object) this.value, (Object) totalCollectedAmount.value);
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
            return "TotalCollectedAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCollectedAmount(String str, Double d2) {
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

    public static final class TotalCancelCommission {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCancelCommission copy$default(TotalCancelCommission totalCancelCommission, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCancelCommission.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCancelCommission.value;
            }
            return totalCancelCommission.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCancelCommission copy(String str, Double d2) {
            return new TotalCancelCommission(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCancelCommission)) {
                return false;
            }
            TotalCancelCommission totalCancelCommission = (TotalCancelCommission) obj;
            return k.a((Object) this.currency, (Object) totalCancelCommission.currency) && k.a((Object) this.value, (Object) totalCancelCommission.value);
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
            return "TotalCancelCommission(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCancelCommission(String str, Double d2) {
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

    public static final class TotalGstAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalGstAmount copy$default(TotalGstAmount totalGstAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalGstAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalGstAmount.value;
            }
            return totalGstAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalGstAmount copy(String str, Double d2) {
            return new TotalGstAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalGstAmount)) {
                return false;
            }
            TotalGstAmount totalGstAmount = (TotalGstAmount) obj;
            return k.a((Object) this.currency, (Object) totalGstAmount.currency) && k.a((Object) this.value, (Object) totalGstAmount.value);
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
            return "TotalGstAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalGstAmount(String str, Double d2) {
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

    public static final class TotalRefundAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalRefundAmount copy$default(TotalRefundAmount totalRefundAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalRefundAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalRefundAmount.value;
            }
            return totalRefundAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalRefundAmount copy(String str, Double d2) {
            return new TotalRefundAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalRefundAmount)) {
                return false;
            }
            TotalRefundAmount totalRefundAmount = (TotalRefundAmount) obj;
            return k.a((Object) this.currency, (Object) totalRefundAmount.currency) && k.a((Object) this.value, (Object) totalRefundAmount.value);
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
            return "TotalRefundAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalRefundAmount(String str, Double d2) {
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

    public static final class TotalChargebackAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalChargebackAmount copy$default(TotalChargebackAmount totalChargebackAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalChargebackAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalChargebackAmount.value;
            }
            return totalChargebackAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalChargebackAmount copy(String str, Double d2) {
            return new TotalChargebackAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalChargebackAmount)) {
                return false;
            }
            TotalChargebackAmount totalChargebackAmount = (TotalChargebackAmount) obj;
            return k.a((Object) this.currency, (Object) totalChargebackAmount.currency) && k.a((Object) this.value, (Object) totalChargebackAmount.value);
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
            return "TotalChargebackAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalChargebackAmount(String str, Double d2) {
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

    public static final class TotalRefundTaxAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalRefundTaxAmount copy$default(TotalRefundTaxAmount totalRefundTaxAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalRefundTaxAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalRefundTaxAmount.value;
            }
            return totalRefundTaxAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalRefundTaxAmount copy(String str, Double d2) {
            return new TotalRefundTaxAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalRefundTaxAmount)) {
                return false;
            }
            TotalRefundTaxAmount totalRefundTaxAmount = (TotalRefundTaxAmount) obj;
            return k.a((Object) this.currency, (Object) totalRefundTaxAmount.currency) && k.a((Object) this.value, (Object) totalRefundTaxAmount.value);
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
            return "TotalRefundTaxAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalRefundTaxAmount(String str, Double d2) {
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

    public static final class TotalCancelAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCancelAmount copy$default(TotalCancelAmount totalCancelAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCancelAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCancelAmount.value;
            }
            return totalCancelAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCancelAmount copy(String str, Double d2) {
            return new TotalCancelAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCancelAmount)) {
                return false;
            }
            TotalCancelAmount totalCancelAmount = (TotalCancelAmount) obj;
            return k.a((Object) this.currency, (Object) totalCancelAmount.currency) && k.a((Object) this.value, (Object) totalCancelAmount.value);
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
            return "TotalCancelAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCancelAmount(String str, Double d2) {
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

    public static final class TotalNetAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalNetAmount copy$default(TotalNetAmount totalNetAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalNetAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalNetAmount.value;
            }
            return totalNetAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalNetAmount copy(String str, Double d2) {
            return new TotalNetAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalNetAmount)) {
                return false;
            }
            TotalNetAmount totalNetAmount = (TotalNetAmount) obj;
            return k.a((Object) this.currency, (Object) totalNetAmount.currency) && k.a((Object) this.value, (Object) totalNetAmount.value);
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
            return "TotalNetAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalNetAmount(String str, Double d2) {
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
        public /* synthetic */ TotalNetAmount(String str, Double d2, int i2, g gVar) {
            this(str, (i2 & 2) != 0 ? Double.valueOf(-1.0d) : d2);
        }

        public final Double getValue() {
            return this.value;
        }

        public final void setValue(Double d2) {
            this.value = d2;
        }
    }

    public static final class TransferredAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TransferredAmount copy$default(TransferredAmount transferredAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = transferredAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = transferredAmount.value;
            }
            return transferredAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TransferredAmount copy(String str, Double d2) {
            return new TransferredAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransferredAmount)) {
                return false;
            }
            TransferredAmount transferredAmount = (TransferredAmount) obj;
            return k.a((Object) this.currency, (Object) transferredAmount.currency) && k.a((Object) this.value, (Object) transferredAmount.value);
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
            return "TransferredAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TransferredAmount(String str, Double d2) {
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

    public static final class TotalCancelTaxAmount {
        public String currency;
        public Double value;

        public static /* synthetic */ TotalCancelTaxAmount copy$default(TotalCancelTaxAmount totalCancelTaxAmount, String str, Double d2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = totalCancelTaxAmount.currency;
            }
            if ((i2 & 2) != 0) {
                d2 = totalCancelTaxAmount.value;
            }
            return totalCancelTaxAmount.copy(str, d2);
        }

        public final String component1() {
            return this.currency;
        }

        public final Double component2() {
            return this.value;
        }

        public final TotalCancelTaxAmount copy(String str, Double d2) {
            return new TotalCancelTaxAmount(str, d2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TotalCancelTaxAmount)) {
                return false;
            }
            TotalCancelTaxAmount totalCancelTaxAmount = (TotalCancelTaxAmount) obj;
            return k.a((Object) this.currency, (Object) totalCancelTaxAmount.currency) && k.a((Object) this.value, (Object) totalCancelTaxAmount.value);
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
            return "TotalCancelTaxAmount(currency=" + this.currency + ", value=" + this.value + ")";
        }

        public TotalCancelTaxAmount(String str, Double d2) {
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
