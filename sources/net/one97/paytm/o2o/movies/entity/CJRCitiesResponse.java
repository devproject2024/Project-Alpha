package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRCitiesResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private CJRCitiesListData data;

    public CJRCitiesResponse() {
        this((CJRCitiesListData) null, 1, (g) null);
    }

    public static /* synthetic */ CJRCitiesResponse copy$default(CJRCitiesResponse cJRCitiesResponse, CJRCitiesListData cJRCitiesListData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRCitiesListData = cJRCitiesResponse.data;
        }
        return cJRCitiesResponse.copy(cJRCitiesListData);
    }

    public final CJRCitiesListData component1() {
        return this.data;
    }

    public final CJRCitiesResponse copy(CJRCitiesListData cJRCitiesListData) {
        return new CJRCitiesResponse(cJRCitiesListData);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRCitiesResponse) && k.a((Object) this.data, (Object) ((CJRCitiesResponse) obj).data);
        }
        return true;
    }

    public final int hashCode() {
        CJRCitiesListData cJRCitiesListData = this.data;
        if (cJRCitiesListData != null) {
            return cJRCitiesListData.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRCitiesResponse(data=" + this.data + ")";
    }

    public CJRCitiesResponse(CJRCitiesListData cJRCitiesListData) {
        this.data = cJRCitiesListData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRCitiesResponse(CJRCitiesListData cJRCitiesListData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRCitiesListData);
    }

    public final CJRCitiesListData getData() {
        return this.data;
    }

    public final void setData(CJRCitiesListData cJRCitiesListData) {
        this.data = cJRCitiesListData;
    }
}
