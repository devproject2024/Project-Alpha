package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class OfferDM {
    @c(a = "icon")
    private final String icon;
    @c(a = "pdpIcon")
    private final String pdpIcon;
    @c(a = "selectedText")
    private final String selectedText;
    @c(a = "singleRedemptionValue")
    private final Float singleRedemptionValue;
    @c(a = "text")
    private final String text;
    @c(a = "title")
    private final String title;
    @c(a = "type")
    private final String type;

    public static /* synthetic */ OfferDM copy$default(OfferDM offerDM, String str, String str2, String str3, String str4, String str5, String str6, Float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = offerDM.title;
        }
        if ((i2 & 2) != 0) {
            str2 = offerDM.text;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = offerDM.icon;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = offerDM.type;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = offerDM.selectedText;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = offerDM.pdpIcon;
        }
        String str11 = str6;
        if ((i2 & 64) != 0) {
            f2 = offerDM.singleRedemptionValue;
        }
        return offerDM.copy(str, str7, str8, str9, str10, str11, f2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.selectedText;
    }

    public final String component6() {
        return this.pdpIcon;
    }

    public final Float component7() {
        return this.singleRedemptionValue;
    }

    public final OfferDM copy(String str, String str2, String str3, String str4, String str5, String str6, Float f2) {
        return new OfferDM(str, str2, str3, str4, str5, str6, f2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferDM)) {
            return false;
        }
        OfferDM offerDM = (OfferDM) obj;
        return k.a((Object) this.title, (Object) offerDM.title) && k.a((Object) this.text, (Object) offerDM.text) && k.a((Object) this.icon, (Object) offerDM.icon) && k.a((Object) this.type, (Object) offerDM.type) && k.a((Object) this.selectedText, (Object) offerDM.selectedText) && k.a((Object) this.pdpIcon, (Object) offerDM.pdpIcon) && k.a((Object) this.singleRedemptionValue, (Object) offerDM.singleRedemptionValue);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.type;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.selectedText;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.pdpIcon;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Float f2 = this.singleRedemptionValue;
        if (f2 != null) {
            i2 = f2.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "OfferDM(title=" + this.title + ", text=" + this.text + ", icon=" + this.icon + ", type=" + this.type + ", selectedText=" + this.selectedText + ", pdpIcon=" + this.pdpIcon + ", singleRedemptionValue=" + this.singleRedemptionValue + ")";
    }

    public OfferDM(String str, String str2, String str3, String str4, String str5, String str6, Float f2) {
        this.title = str;
        this.text = str2;
        this.icon = str3;
        this.type = str4;
        this.selectedText = str5;
        this.pdpIcon = str6;
        this.singleRedemptionValue = f2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getText() {
        return this.text;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSelectedText() {
        return this.selectedText;
    }

    public final String getPdpIcon() {
        return this.pdpIcon;
    }

    public final Float getSingleRedemptionValue() {
        return this.singleRedemptionValue;
    }
}
