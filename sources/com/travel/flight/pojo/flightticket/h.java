package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.g;

public final class h implements Serializable {
    private e[] content;
    @b(a = "img_url")
    private String imgUrl;

    public h() {
        this((String) null, (e[]) null, 3, (g) null);
    }

    public h(String str, e[] eVarArr) {
        this.imgUrl = str;
        this.content = eVarArr;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final void setImgUrl(String str) {
        this.imgUrl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(String str, e[] eVarArr, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : eVarArr);
    }

    public final e[] getContent() {
        return this.content;
    }

    public final void setContent(e[] eVarArr) {
        this.content = eVarArr;
    }
}
