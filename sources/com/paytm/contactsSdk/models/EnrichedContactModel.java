package com.paytm.contactsSdk.models;

import com.paytm.contactsSdk.database.ContactColumn;
import kotlin.g.b.k;

public final class EnrichedContactModel {
    private final String featureJson;
    private final String name;
    private final String phone;

    public static /* synthetic */ EnrichedContactModel copy$default(EnrichedContactModel enrichedContactModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = enrichedContactModel.name;
        }
        if ((i2 & 2) != 0) {
            str2 = enrichedContactModel.phone;
        }
        if ((i2 & 4) != 0) {
            str3 = enrichedContactModel.featureJson;
        }
        return enrichedContactModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.phone;
    }

    public final String component3() {
        return this.featureJson;
    }

    public final EnrichedContactModel copy(String str, String str2, String str3) {
        k.c(str, "name");
        k.c(str2, ContactColumn.PHONE_NUMBER);
        k.c(str3, "featureJson");
        return new EnrichedContactModel(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnrichedContactModel)) {
            return false;
        }
        EnrichedContactModel enrichedContactModel = (EnrichedContactModel) obj;
        return k.a((Object) this.name, (Object) enrichedContactModel.name) && k.a((Object) this.phone, (Object) enrichedContactModel.phone) && k.a((Object) this.featureJson, (Object) enrichedContactModel.featureJson);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.featureJson;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "EnrichedContactModel(name=" + this.name + ", phone=" + this.phone + ", featureJson=" + this.featureJson + ")";
    }

    public EnrichedContactModel(String str, String str2, String str3) {
        k.c(str, "name");
        k.c(str2, ContactColumn.PHONE_NUMBER);
        k.c(str3, "featureJson");
        this.name = str;
        this.phone = str2;
        this.featureJson = str3;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getFeatureJson() {
        return this.featureJson;
    }
}
