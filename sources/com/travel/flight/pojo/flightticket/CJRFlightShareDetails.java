package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CJRFlightShareDetails extends IJRPaytmDataModel {
    @a
    @b(a = "desc")
    private String desc;
    @a
    @b(a = "icon")
    private String iconUrl;
    @a
    @b(a = "title")
    private String title;

    public CJRFlightShareDetails() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightShareDetails(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public CJRFlightShareDetails(String str, String str2, String str3) {
        this.title = str;
        this.desc = str2;
        this.iconUrl = str3;
    }
}
