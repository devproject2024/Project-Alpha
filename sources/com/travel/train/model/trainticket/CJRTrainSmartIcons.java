package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.train.i.ag;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSmartIcons extends IJRPaytmDataModel implements IJRDataModel {
    private ag clickActionType;
    @b(a = "image_url")
    private String imageUrl = "";
    @b(a = "name")
    private String name = "";
    @b(a = "url")
    private String url = "";
    @b(a = "url_info")
    private String urlInfo = "";
    @b(a = "url_type")
    private String urlType = "";

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        k.c(str, "<set-?>");
        this.imageUrl = str;
    }

    public final String getUrlInfo() {
        return this.urlInfo;
    }

    public final void setUrlInfo(String str) {
        k.c(str, "<set-?>");
        this.urlInfo = str;
    }

    public final String getUrlType() {
        return this.urlType;
    }

    public final void setUrlType(String str) {
        k.c(str, "<set-?>");
        this.urlType = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        k.c(str, "<set-?>");
        this.url = str;
    }

    public final void setClickActionType(ag agVar) {
        this.clickActionType = agVar;
    }

    public final ag getClickActionType() {
        ag agVar;
        ag.a aVar = ag.Companion;
        String str = this.urlType;
        k.c(str, "actionName");
        ag[] values = ag.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                agVar = ag.IGNORE_TYPE;
                break;
            }
            agVar = values[i2];
            if (agVar.getNameStr().equals(str)) {
                break;
            }
            i2++;
        }
        this.clickActionType = agVar;
        return this.clickActionType;
    }
}
