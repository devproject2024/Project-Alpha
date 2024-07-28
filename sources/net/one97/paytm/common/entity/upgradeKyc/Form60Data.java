package net.one97.paytm.common.entity.upgradeKyc;

import kotlin.g.b.g;

public final class Form60Data {
    private String agricultureIncome;
    private String nonAgricultureIncome;

    public Form60Data() {
        this((String) null, (String) null, 3, (g) null);
    }

    public Form60Data(String str, String str2) {
        this.agricultureIncome = str;
        this.nonAgricultureIncome = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Form60Data(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getAgricultureIncome() {
        return this.agricultureIncome;
    }

    public final String getNonAgricultureIncome() {
        return this.nonAgricultureIncome;
    }

    public final void setAgricultureIncome(String str) {
        this.agricultureIncome = str;
    }

    public final void setNonAgricultureIncome(String str) {
        this.nonAgricultureIncome = str;
    }
}
