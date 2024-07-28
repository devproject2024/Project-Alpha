package com.paytm.notification.models;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class Buttons {
    @c(a = "alias")
    private String alias = "";
    @c(a = "display")
    private String display = "";
    @c(a = "label")
    private String label = "";
    @c(a = "type")
    private String type = "";
    @c(a = "value")
    private String value = "";

    public static /* synthetic */ void alias$annotations() {
    }

    public static /* synthetic */ void label$annotations() {
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        k.c(str, "<set-?>");
        this.label = str;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final void setAlias(String str) {
        k.c(str, "<set-?>");
        this.alias = str;
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

    public final String getDisplay() {
        return this.display;
    }

    public final void setDisplay(String str) {
        k.c(str, "<set-?>");
        this.display = str;
    }

    public final String toString() {
        return "Buttons(label='" + this.label + "', alias='" + this.alias + "', type='" + this.type + "', value='" + this.value + "', display='" + this.display + "')";
    }
}
