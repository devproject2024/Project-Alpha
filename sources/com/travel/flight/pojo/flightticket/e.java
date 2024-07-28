package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.g;

public final class e implements Serializable {
    @b(a = "sub_text")
    private String subText;
    private String text;

    public e() {
        this((String) null, (String) null, 3, (g) null);
    }

    public e(String str, String str2) {
        this.subText = str;
        this.text = str2;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final void setSubText(String str) {
        this.subText = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
