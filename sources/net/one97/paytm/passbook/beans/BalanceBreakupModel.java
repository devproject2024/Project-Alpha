package net.one97.paytm.passbook.beans;

public final class BalanceBreakupModel {
    private double availableForPayment;
    private double onHold;
    private double totalBalance;

    public static /* synthetic */ BalanceBreakupModel copy$default(BalanceBreakupModel balanceBreakupModel, double d2, double d3, double d4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = balanceBreakupModel.availableForPayment;
        }
        double d5 = d2;
        if ((i2 & 2) != 0) {
            d3 = balanceBreakupModel.onHold;
        }
        double d6 = d3;
        if ((i2 & 4) != 0) {
            d4 = balanceBreakupModel.totalBalance;
        }
        return balanceBreakupModel.copy(d5, d6, d4);
    }

    public final double component1() {
        return this.availableForPayment;
    }

    public final double component2() {
        return this.onHold;
    }

    public final double component3() {
        return this.totalBalance;
    }

    public final BalanceBreakupModel copy(double d2, double d3, double d4) {
        return new BalanceBreakupModel(d2, d3, d4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BalanceBreakupModel)) {
            return false;
        }
        BalanceBreakupModel balanceBreakupModel = (BalanceBreakupModel) obj;
        return Double.compare(this.availableForPayment, balanceBreakupModel.availableForPayment) == 0 && Double.compare(this.onHold, balanceBreakupModel.onHold) == 0 && Double.compare(this.totalBalance, balanceBreakupModel.totalBalance) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.availableForPayment);
        long doubleToLongBits2 = Double.doubleToLongBits(this.onHold);
        long doubleToLongBits3 = Double.doubleToLongBits(this.totalBalance);
        return (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public final String toString() {
        return "BalanceBreakupModel(availableForPayment=" + this.availableForPayment + ", onHold=" + this.onHold + ", totalBalance=" + this.totalBalance + ")";
    }

    public BalanceBreakupModel(double d2, double d3, double d4) {
        this.availableForPayment = d2;
        this.onHold = d3;
        this.totalBalance = d4;
    }

    public final double getAvailableForPayment() {
        return this.availableForPayment;
    }

    public final double getOnHold() {
        return this.onHold;
    }

    public final double getTotalBalance() {
        return this.totalBalance;
    }

    public final void setAvailableForPayment(double d2) {
        this.availableForPayment = d2;
    }

    public final void setOnHold(double d2) {
        this.onHold = d2;
    }

    public final void setTotalBalance(double d2) {
        this.totalBalance = d2;
    }
}
