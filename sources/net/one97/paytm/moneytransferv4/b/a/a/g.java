package net.one97.paytm.moneytransferv4.b.a.a;

import kotlin.g.b.k;

public enum g {
    WIDGET_TYPE_TITLE(1, "WIDGET_TYPE_TITLE"),
    WIDGET_TYPE_PAYMENT_OPTIONS(2, "WIDGET_TYPE_PAYMENT_OPTIONS"),
    WIDGET_TYPE_SEARCH(3, "WIDGET_TYPE_SEARCH"),
    WIDGET_TYPE_BENEFICIARIES(4, "WIDGET_TYPE_BENEFICIARIES"),
    WIDGET_TYPE_UPI_REGISTRATION(5, "WIDGET_TYPE_UPI_REGISTRATION"),
    WIDGET_TYPE_CONTACTS(6, "WIDGET_TYPE_CONTACTS"),
    WIDGET_TYPE_CONTACT_PERMISSION(7, "WIDGET_TYPE_CONTACT_PERMISSION"),
    WIDGET_TYPE_CONTACT_MOTIF(8, "WIDGET_TYPE_CONTACT_MOTIF"),
    WIDGET_TYPE_ALL_IN_ONE(9, "WIDGET_TYPE_ALL_IN_ONE"),
    WIDGET_TYPE_ADD_BANK(10, "WIDGET_TYPE_ADD_BANK"),
    WIDGET_TYPE_COLLECT_REQUEST(11, "WIDGET_TYPE_COLLECT_REQUEST");
    
    private int identifier;
    private String text;

    private g(int i2, String str) {
        this.identifier = i2;
        this.text = str;
    }

    public final int getIdentifier() {
        return this.identifier;
    }

    public final String getText() {
        return this.text;
    }

    public final void setIdentifier(int i2) {
        this.identifier = i2;
    }

    public final void setText(String str) {
        k.c(str, "<set-?>");
        this.text = str;
    }

    public final int getId() {
        return this.identifier;
    }

    public final String getName() {
        return this.text;
    }
}
