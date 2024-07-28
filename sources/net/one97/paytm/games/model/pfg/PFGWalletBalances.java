package net.one97.paytm.games.model.pfg;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PFGWalletBalances {
    private Double bonus_balance;
    private Double deposit_balance;
    private Double deposit_winning_balance;
    private Double total_balance;
    private Double winning_balance;

    public PFGWalletBalances() {
        this((Double) null, (Double) null, (Double) null, (Double) null, (Double) null, 31, (g) null);
    }

    public static /* synthetic */ PFGWalletBalances copy$default(PFGWalletBalances pFGWalletBalances, Double d2, Double d3, Double d4, Double d5, Double d6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = pFGWalletBalances.deposit_balance;
        }
        if ((i2 & 2) != 0) {
            d3 = pFGWalletBalances.winning_balance;
        }
        Double d7 = d3;
        if ((i2 & 4) != 0) {
            d4 = pFGWalletBalances.bonus_balance;
        }
        Double d8 = d4;
        if ((i2 & 8) != 0) {
            d5 = pFGWalletBalances.deposit_winning_balance;
        }
        Double d9 = d5;
        if ((i2 & 16) != 0) {
            d6 = pFGWalletBalances.total_balance;
        }
        return pFGWalletBalances.copy(d2, d7, d8, d9, d6);
    }

    public final Double component1() {
        return this.deposit_balance;
    }

    public final Double component2() {
        return this.winning_balance;
    }

    public final Double component3() {
        return this.bonus_balance;
    }

    public final Double component4() {
        return this.deposit_winning_balance;
    }

    public final Double component5() {
        return this.total_balance;
    }

    public final PFGWalletBalances copy(Double d2, Double d3, Double d4, Double d5, Double d6) {
        return new PFGWalletBalances(d2, d3, d4, d5, d6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PFGWalletBalances)) {
            return false;
        }
        PFGWalletBalances pFGWalletBalances = (PFGWalletBalances) obj;
        return k.a((Object) this.deposit_balance, (Object) pFGWalletBalances.deposit_balance) && k.a((Object) this.winning_balance, (Object) pFGWalletBalances.winning_balance) && k.a((Object) this.bonus_balance, (Object) pFGWalletBalances.bonus_balance) && k.a((Object) this.deposit_winning_balance, (Object) pFGWalletBalances.deposit_winning_balance) && k.a((Object) this.total_balance, (Object) pFGWalletBalances.total_balance);
    }

    public final int hashCode() {
        Double d2 = this.deposit_balance;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        Double d3 = this.winning_balance;
        int hashCode2 = (hashCode + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.bonus_balance;
        int hashCode3 = (hashCode2 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.deposit_winning_balance;
        int hashCode4 = (hashCode3 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.total_balance;
        if (d6 != null) {
            i2 = d6.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "PFGWalletBalances(deposit_balance=" + this.deposit_balance + ", winning_balance=" + this.winning_balance + ", bonus_balance=" + this.bonus_balance + ", deposit_winning_balance=" + this.deposit_winning_balance + ", total_balance=" + this.total_balance + ")";
    }

    public PFGWalletBalances(Double d2, Double d3, Double d4, Double d5, Double d6) {
        this.deposit_balance = d2;
        this.winning_balance = d3;
        this.bonus_balance = d4;
        this.deposit_winning_balance = d5;
        this.total_balance = d6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PFGWalletBalances(java.lang.Double r5, java.lang.Double r6, java.lang.Double r7, java.lang.Double r8, java.lang.Double r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.model.pfg.PFGWalletBalances.<init>(java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, int, kotlin.g.b.g):void");
    }

    public final Double getBonus_balance() {
        return this.bonus_balance;
    }

    public final Double getDeposit_balance() {
        return this.deposit_balance;
    }

    public final Double getDeposit_winning_balance() {
        return this.deposit_winning_balance;
    }

    public final Double getTotal_balance() {
        return this.total_balance;
    }

    public final Double getWinning_balance() {
        return this.winning_balance;
    }

    public final void setBonus_balance(Double d2) {
        this.bonus_balance = d2;
    }

    public final void setDeposit_balance(Double d2) {
        this.deposit_balance = d2;
    }

    public final void setDeposit_winning_balance(Double d2) {
        this.deposit_winning_balance = d2;
    }

    public final void setTotal_balance(Double d2) {
        this.total_balance = d2;
    }

    public final void setWinning_balance(Double d2) {
        this.winning_balance = d2;
    }
}
