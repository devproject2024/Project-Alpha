package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRCinemaDataResponse extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "data")
    private CJRSessionDatesData data;
    @b(a = "meta")
    private CJRCinemaMeta meta;
    @b(a = "pageData")
    private CJRSessionsPageData pageData;

    public static class a implements Parcelable.Creator {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsPageData} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object createFromParcel(android.os.Parcel r6) {
            /*
                r5 = this;
                java.lang.String r0 = "in"
                kotlin.g.b.k.c(r6, r0)
                net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse r0 = new net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse
                int r1 = r6.readInt()
                r2 = 0
                if (r1 == 0) goto L_0x0017
                android.os.Parcelable$Creator r1 = net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r6)
                net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = (net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta) r1
                goto L_0x0018
            L_0x0017:
                r1 = r2
            L_0x0018:
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0027
                android.os.Parcelable$Creator r3 = net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r6)
                net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData r3 = (net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData) r3
                goto L_0x0028
            L_0x0027:
                r3 = r2
            L_0x0028:
                int r4 = r6.readInt()
                if (r4 == 0) goto L_0x0037
                android.os.Parcelable$Creator r2 = net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsPageData.CREATOR
                java.lang.Object r6 = r2.createFromParcel(r6)
                r2 = r6
                net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsPageData r2 = (net.one97.paytm.o2o.movies.common.movies.search.CJRSessionsPageData) r2
            L_0x0037:
                r0.<init>(r1, r3, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse.a.createFromParcel(android.os.Parcel):java.lang.Object");
        }

        public final Object[] newArray(int i2) {
            return new CJRCinemaDataResponse[i2];
        }
    }

    public CJRCinemaDataResponse() {
        this((CJRCinemaMeta) null, (CJRSessionDatesData) null, (CJRSessionsPageData) null, 7, (g) null);
    }

    public static /* synthetic */ CJRCinemaDataResponse copy$default(CJRCinemaDataResponse cJRCinemaDataResponse, CJRCinemaMeta cJRCinemaMeta, CJRSessionDatesData cJRSessionDatesData, CJRSessionsPageData cJRSessionsPageData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRCinemaMeta = cJRCinemaDataResponse.meta;
        }
        if ((i2 & 2) != 0) {
            cJRSessionDatesData = cJRCinemaDataResponse.data;
        }
        if ((i2 & 4) != 0) {
            cJRSessionsPageData = cJRCinemaDataResponse.pageData;
        }
        return cJRCinemaDataResponse.copy(cJRCinemaMeta, cJRSessionDatesData, cJRSessionsPageData);
    }

    public final CJRCinemaMeta component1() {
        return this.meta;
    }

    public final CJRSessionDatesData component2() {
        return this.data;
    }

    public final CJRSessionsPageData component3() {
        return this.pageData;
    }

    public final CJRCinemaDataResponse copy(CJRCinemaMeta cJRCinemaMeta, CJRSessionDatesData cJRSessionDatesData, CJRSessionsPageData cJRSessionsPageData) {
        return new CJRCinemaDataResponse(cJRCinemaMeta, cJRSessionDatesData, cJRSessionsPageData);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCinemaDataResponse)) {
            return false;
        }
        CJRCinemaDataResponse cJRCinemaDataResponse = (CJRCinemaDataResponse) obj;
        return k.a((Object) this.meta, (Object) cJRCinemaDataResponse.meta) && k.a((Object) this.data, (Object) cJRCinemaDataResponse.data) && k.a((Object) this.pageData, (Object) cJRCinemaDataResponse.pageData);
    }

    public final int hashCode() {
        CJRCinemaMeta cJRCinemaMeta = this.meta;
        int i2 = 0;
        int hashCode = (cJRCinemaMeta != null ? cJRCinemaMeta.hashCode() : 0) * 31;
        CJRSessionDatesData cJRSessionDatesData = this.data;
        int hashCode2 = (hashCode + (cJRSessionDatesData != null ? cJRSessionDatesData.hashCode() : 0)) * 31;
        CJRSessionsPageData cJRSessionsPageData = this.pageData;
        if (cJRSessionsPageData != null) {
            i2 = cJRSessionsPageData.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRCinemaDataResponse(meta=" + this.meta + ", data=" + this.data + ", pageData=" + this.pageData + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        CJRCinemaMeta cJRCinemaMeta = this.meta;
        if (cJRCinemaMeta != null) {
            parcel.writeInt(1);
            cJRCinemaMeta.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        CJRSessionDatesData cJRSessionDatesData = this.data;
        if (cJRSessionDatesData != null) {
            parcel.writeInt(1);
            cJRSessionDatesData.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        CJRSessionsPageData cJRSessionsPageData = this.pageData;
        if (cJRSessionsPageData != null) {
            parcel.writeInt(1);
            cJRSessionsPageData.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public final CJRCinemaMeta getMeta() {
        return this.meta;
    }

    public final void setMeta(CJRCinemaMeta cJRCinemaMeta) {
        this.meta = cJRCinemaMeta;
    }

    public final CJRSessionDatesData getData() {
        return this.data;
    }

    public final void setData(CJRSessionDatesData cJRSessionDatesData) {
        this.data = cJRSessionDatesData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRCinemaDataResponse(CJRCinemaMeta cJRCinemaMeta, CJRSessionDatesData cJRSessionDatesData, CJRSessionsPageData cJRSessionsPageData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRCinemaMeta, (i2 & 2) != 0 ? null : cJRSessionDatesData, (i2 & 4) != 0 ? null : cJRSessionsPageData);
    }

    public final CJRSessionsPageData getPageData() {
        return this.pageData;
    }

    public final void setPageData(CJRSessionsPageData cJRSessionsPageData) {
        this.pageData = cJRSessionsPageData;
    }

    public CJRCinemaDataResponse(CJRCinemaMeta cJRCinemaMeta, CJRSessionDatesData cJRSessionDatesData, CJRSessionsPageData cJRSessionsPageData) {
        this.meta = cJRCinemaMeta;
        this.data = cJRSessionDatesData;
        this.pageData = cJRSessionsPageData;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return this;
        }
        IJRPaytmDataModel parseResponse = super.parseResponse(str, fVar);
        k.a((Object) parseResponse, "super.parseResponse(p0, p1)");
        return parseResponse;
    }
}
