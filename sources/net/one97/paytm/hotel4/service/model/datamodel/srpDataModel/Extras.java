package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Extras {
    @b(a = "axis_hc")
    private final String axisHc;
    @b(a = "city_id")
    private final String cityId;
    private final String otas;

    public Extras() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public Extras(String str, String str2, String str3) {
        k.c(str, "otas");
        k.c(str2, "axisHc");
        k.c(str3, "cityId");
        this.otas = str;
        this.axisHc = str2;
        this.cityId = str3;
    }

    public final String getOtas() {
        return this.otas;
    }

    public final String getAxisHc() {
        return this.axisHc;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Extras(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getCityId() {
        return this.cityId;
    }
}
