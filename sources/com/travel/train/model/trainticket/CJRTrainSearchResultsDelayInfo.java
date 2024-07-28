package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsDelayInfo extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "colour")
    private String colour;
    @a
    @b(a = "display_text")
    private String displayText;
    @a
    @b(a = "enabled")
    private Boolean enabled;

    public CJRTrainSearchResultsDelayInfo() {
        this((Boolean) null, (String) null, (String) null, 7, (g) null);
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public final String getColour() {
        return this.colour;
    }

    public final void setColour(String str) {
        this.colour = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRTrainSearchResultsDelayInfo(Boolean bool, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bool, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final void setDisplayText(String str) {
        this.displayText = str;
    }

    public CJRTrainSearchResultsDelayInfo(Boolean bool, String str, String str2) {
        this.enabled = bool;
        this.colour = str;
        this.displayText = str2;
    }
}
