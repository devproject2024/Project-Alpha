package com.paytm.notification.models;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class Click {
    @c(a = "label")
    private String label;
    @c(a = "type")
    private String type = "";
    @c(a = "value")
    private String value = "";

    public static /* synthetic */ void label$annotations() {
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        k.c(str, "<set-?>");
        this.type = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        k.c(str, "<set-?>");
        this.value = str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final String toString() {
        return "Click(type='" + this.type + "', value='" + this.value + "', label=" + this.label + ')';
    }
}
