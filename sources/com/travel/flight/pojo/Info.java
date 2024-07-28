package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class Info extends IJRPaytmDataModel {
    @a
    @b(a = "desc")
    private String desc;
    @a
    @b(a = "moreinfo")
    private MoreInfo moreInfo;
    @a
    @b(a = "title")
    private String title;

    public Info() {
        this((String) null, (String) null, (MoreInfo) null, 7, (g) null);
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
    public /* synthetic */ Info(String str, String str2, MoreInfo moreInfo2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : moreInfo2);
    }

    public final MoreInfo getMoreInfo() {
        return this.moreInfo;
    }

    public final void setMoreInfo(MoreInfo moreInfo2) {
        this.moreInfo = moreInfo2;
    }

    public Info(String str, String str2, MoreInfo moreInfo2) {
        this.title = str;
        this.desc = str2;
        this.moreInfo = moreInfo2;
    }
}
