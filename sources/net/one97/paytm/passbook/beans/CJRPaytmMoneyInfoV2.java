package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPaytmMoneyInfoV2 extends IJRDataModel {
    @b(a = "data")
    private DataInfo dataInfo;
    @b(a = "meta")
    private MetaInfo metaInfo;

    public CJRPaytmMoneyInfoV2() {
        this((DataInfo) null, (MetaInfo) null, 3, (g) null);
    }

    public static /* synthetic */ CJRPaytmMoneyInfoV2 copy$default(CJRPaytmMoneyInfoV2 cJRPaytmMoneyInfoV2, DataInfo dataInfo2, MetaInfo metaInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dataInfo2 = cJRPaytmMoneyInfoV2.dataInfo;
        }
        if ((i2 & 2) != 0) {
            metaInfo2 = cJRPaytmMoneyInfoV2.metaInfo;
        }
        return cJRPaytmMoneyInfoV2.copy(dataInfo2, metaInfo2);
    }

    public final DataInfo component1() {
        return this.dataInfo;
    }

    public final MetaInfo component2() {
        return this.metaInfo;
    }

    public final CJRPaytmMoneyInfoV2 copy(DataInfo dataInfo2, MetaInfo metaInfo2) {
        return new CJRPaytmMoneyInfoV2(dataInfo2, metaInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRPaytmMoneyInfoV2)) {
            return false;
        }
        CJRPaytmMoneyInfoV2 cJRPaytmMoneyInfoV2 = (CJRPaytmMoneyInfoV2) obj;
        return k.a((Object) this.dataInfo, (Object) cJRPaytmMoneyInfoV2.dataInfo) && k.a((Object) this.metaInfo, (Object) cJRPaytmMoneyInfoV2.metaInfo);
    }

    public final int hashCode() {
        DataInfo dataInfo2 = this.dataInfo;
        int i2 = 0;
        int hashCode = (dataInfo2 != null ? dataInfo2.hashCode() : 0) * 31;
        MetaInfo metaInfo2 = this.metaInfo;
        if (metaInfo2 != null) {
            i2 = metaInfo2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRPaytmMoneyInfoV2(dataInfo=" + this.dataInfo + ", metaInfo=" + this.metaInfo + ")";
    }

    public final DataInfo getDataInfo() {
        return this.dataInfo;
    }

    public final void setDataInfo(DataInfo dataInfo2) {
        this.dataInfo = dataInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRPaytmMoneyInfoV2(DataInfo dataInfo2, MetaInfo metaInfo2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : dataInfo2, (i2 & 2) != 0 ? null : metaInfo2);
    }

    public final MetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public final void setMetaInfo(MetaInfo metaInfo2) {
        this.metaInfo = metaInfo2;
    }

    public CJRPaytmMoneyInfoV2(DataInfo dataInfo2, MetaInfo metaInfo2) {
        this.dataInfo = dataInfo2;
        this.metaInfo = metaInfo2;
    }
}
