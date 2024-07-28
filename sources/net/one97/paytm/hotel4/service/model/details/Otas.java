package net.one97.paytm.hotel4.service.model.details;

import kotlin.g.b.g;

public final class Otas {
    private String name;
    private Integer price;

    public Otas() {
        this((String) null, (Integer) null, 3, (g) null);
    }

    public Otas(String str, Integer num) {
        this.name = str;
        this.price = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Otas(String str, Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : num);
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final void setPrice(Integer num) {
        this.price = num;
    }
}
