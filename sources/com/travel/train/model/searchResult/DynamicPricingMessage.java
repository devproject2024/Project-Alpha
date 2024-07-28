package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class DynamicPricingMessage extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "enabled")
    private Boolean enabled;
    @a
    @b(a = "message_text")
    private String message_text;

    public DynamicPricingMessage() {
        this((Boolean) null, (String) null, 3, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicPricingMessage(Boolean bool, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? null : str);
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public DynamicPricingMessage(Boolean bool, String str) {
        this.enabled = bool;
        this.message_text = str;
    }

    public final String getMessage_text() {
        return this.message_text;
    }

    public final void setMessage_text(String str) {
        this.message_text = str;
    }
}
