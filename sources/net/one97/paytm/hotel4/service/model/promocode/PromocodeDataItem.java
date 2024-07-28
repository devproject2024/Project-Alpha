package net.one97.paytm.hotel4.service.model.promocode;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PromocodeDataItem extends IJRPaytmDataModel {
    private final String code;
    private final String offerText;
    private final Integer priority;
    private final String terms;

    public PromocodeDataItem() {
        this((String) null, (String) null, (String) null, (Integer) null, 15, (g) null);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final String getTerms() {
        return this.terms;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromocodeDataItem(String str, String str2, String str3, Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? null : num);
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public PromocodeDataItem(String str, String str2, String str3, Integer num) {
        k.c(str, "code");
        k.c(str2, "offerText");
        k.c(str3, "terms");
        this.code = str;
        this.offerText = str2;
        this.terms = str3;
        this.priority = num;
    }
}
