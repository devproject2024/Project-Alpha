package net.one97.paytm.moneytransferv4.search;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SearchTitleModel implements IJRDataModel {
    private final String titleText;

    public SearchTitleModel(String str) {
        k.c(str, "titleText");
        this.titleText = str;
    }

    public final String getTitleText() {
        return this.titleText;
    }
}
