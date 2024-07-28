package net.one97.paytm.appManager.beans;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class MetaInfo extends IJRPaytmDataModel {
    @b(a = "has_next")
    private boolean hasNext;
    @b(a = "response_type")
    private String responseType;
    @b(a = "current_version")
    private long version;

    public static /* synthetic */ MetaInfo copy$default(MetaInfo metaInfo, long j, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = metaInfo.version;
        }
        if ((i2 & 2) != 0) {
            str = metaInfo.responseType;
        }
        if ((i2 & 4) != 0) {
            z = metaInfo.hasNext;
        }
        return metaInfo.copy(j, str, z);
    }

    public final long component1() {
        return this.version;
    }

    public final String component2() {
        return this.responseType;
    }

    public final boolean component3() {
        return this.hasNext;
    }

    public final MetaInfo copy(long j, String str, boolean z) {
        k.c(str, "responseType");
        return new MetaInfo(j, str, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetaInfo)) {
            return false;
        }
        MetaInfo metaInfo = (MetaInfo) obj;
        return this.version == metaInfo.version && k.a((Object) this.responseType, (Object) metaInfo.responseType) && this.hasNext == metaInfo.hasNext;
    }

    public final int hashCode() {
        long j = this.version;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.responseType;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.hasNext;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "MetaInfo(version=" + this.version + ", responseType=" + this.responseType + ", hasNext=" + this.hasNext + ")";
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setVersion(long j) {
        this.version = j;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final void setResponseType(String str) {
        k.c(str, "<set-?>");
        this.responseType = str;
    }

    public MetaInfo(long j, String str, boolean z) {
        k.c(str, "responseType");
        this.version = j;
        this.responseType = str;
        this.hasNext = z;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }
}
