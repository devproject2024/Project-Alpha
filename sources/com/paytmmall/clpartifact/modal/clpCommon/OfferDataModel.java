package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;
import kotlin.g.b.k;

public final class OfferDataModel implements Serializable {
    @c(a = "icon")
    private final String mIcon;
    @c(a = "type")
    private final String mtype;

    public static /* synthetic */ OfferDataModel copy$default(OfferDataModel offerDataModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = offerDataModel.mIcon;
        }
        if ((i2 & 2) != 0) {
            str2 = offerDataModel.mtype;
        }
        return offerDataModel.copy(str, str2);
    }

    public final String component1() {
        return this.mIcon;
    }

    public final String component2() {
        return this.mtype;
    }

    public final OfferDataModel copy(String str, String str2) {
        k.c(str, "mIcon");
        k.c(str2, "mtype");
        return new OfferDataModel(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferDataModel)) {
            return false;
        }
        OfferDataModel offerDataModel = (OfferDataModel) obj;
        return k.a((Object) this.mIcon, (Object) offerDataModel.mIcon) && k.a((Object) this.mtype, (Object) offerDataModel.mtype);
    }

    public final int hashCode() {
        String str = this.mIcon;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mtype;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "OfferDataModel(mIcon=" + this.mIcon + ", mtype=" + this.mtype + ")";
    }

    public OfferDataModel(String str, String str2) {
        k.c(str, "mIcon");
        k.c(str2, "mtype");
        this.mIcon = str;
        this.mtype = str2;
    }

    public final String getMIcon() {
        return this.mIcon;
    }

    public final String getMtype() {
        return this.mtype;
    }
}
