package net.one97.paytm.nativesdk.instruments.upipush.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class MetaData implements BaseDataModel {
    private String npciHealthCategory;
    private String npciHealthMsg;

    public static /* synthetic */ MetaData copy$default(MetaData metaData, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = metaData.npciHealthCategory;
        }
        if ((i2 & 2) != 0) {
            str2 = metaData.npciHealthMsg;
        }
        return metaData.copy(str, str2);
    }

    public final String component1() {
        return this.npciHealthCategory;
    }

    public final String component2() {
        return this.npciHealthMsg;
    }

    public final MetaData copy(String str, String str2) {
        return new MetaData(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetaData)) {
            return false;
        }
        MetaData metaData = (MetaData) obj;
        return k.a((Object) this.npciHealthCategory, (Object) metaData.npciHealthCategory) && k.a((Object) this.npciHealthMsg, (Object) metaData.npciHealthMsg);
    }

    public final int hashCode() {
        String str = this.npciHealthCategory;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.npciHealthMsg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MetaData(npciHealthCategory=" + this.npciHealthCategory + ", npciHealthMsg=" + this.npciHealthMsg + ")";
    }

    public MetaData(String str, String str2) {
        this.npciHealthCategory = str;
        this.npciHealthMsg = str2;
    }

    public final String getNpciHealthCategory() {
        return this.npciHealthCategory;
    }

    public final void setNpciHealthCategory(String str) {
        this.npciHealthCategory = str;
    }

    public final String getNpciHealthMsg() {
        return this.npciHealthMsg;
    }

    public final void setNpciHealthMsg(String str) {
        this.npciHealthMsg = str;
    }
}
