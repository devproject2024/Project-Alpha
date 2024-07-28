package net.one97.paytm.hotel4.service.model.details;

import kotlin.g.b.g;

public final class TaxData {
    private String descri;
    private String price;

    public TaxData() {
        this((String) null, (String) null, 3, (g) null);
    }

    public TaxData(String str, String str2) {
        this.descri = str;
        this.price = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TaxData(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getDescri() {
        return this.descri;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setDescri(String str) {
        this.descri = str;
    }

    public final void setPrice(String str) {
        this.price = str;
    }
}
