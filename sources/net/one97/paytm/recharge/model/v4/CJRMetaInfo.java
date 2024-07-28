package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMetaInfo implements IJRDataModel {
    @b(a = "trackingId")
    private final String trackingId;

    public CJRMetaInfo() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ CJRMetaInfo copy$default(CJRMetaInfo cJRMetaInfo, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRMetaInfo.trackingId;
        }
        return cJRMetaInfo.copy(str);
    }

    public final String component1() {
        return this.trackingId;
    }

    public final CJRMetaInfo copy(String str) {
        return new CJRMetaInfo(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRMetaInfo) && k.a((Object) this.trackingId, (Object) ((CJRMetaInfo) obj).trackingId);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.trackingId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRMetaInfo(trackingId=" + this.trackingId + ")";
    }

    public CJRMetaInfo(String str) {
        this.trackingId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMetaInfo(String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str);
    }

    public final String getTrackingId() {
        return this.trackingId;
    }
}
