package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRBrowseByCinema extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "data")
    private CJRBrowseByData data;
    @b(a = "meta")
    private CJRBrowseByCinemaMeta meta;

    public static class Creator implements Parcelable.Creator {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: net.one97.paytm.o2o.movies.entity.CJRBrowseByData} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object createFromParcel(android.os.Parcel r5) {
            /*
                r4 = this;
                java.lang.String r0 = "in"
                kotlin.g.b.k.c(r5, r0)
                net.one97.paytm.o2o.movies.entity.CJRBrowseByCinema r0 = new net.one97.paytm.o2o.movies.entity.CJRBrowseByCinema
                int r1 = r5.readInt()
                r2 = 0
                if (r1 == 0) goto L_0x0017
                android.os.Parcelable$Creator r1 = net.one97.paytm.o2o.movies.entity.CJRBrowseByCinemaMeta.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r5)
                net.one97.paytm.o2o.movies.entity.CJRBrowseByCinemaMeta r1 = (net.one97.paytm.o2o.movies.entity.CJRBrowseByCinemaMeta) r1
                goto L_0x0018
            L_0x0017:
                r1 = r2
            L_0x0018:
                int r3 = r5.readInt()
                if (r3 == 0) goto L_0x0027
                android.os.Parcelable$Creator r2 = net.one97.paytm.o2o.movies.entity.CJRBrowseByData.CREATOR
                java.lang.Object r5 = r2.createFromParcel(r5)
                r2 = r5
                net.one97.paytm.o2o.movies.entity.CJRBrowseByData r2 = (net.one97.paytm.o2o.movies.entity.CJRBrowseByData) r2
            L_0x0027:
                r0.<init>(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.CJRBrowseByCinema.Creator.createFromParcel(android.os.Parcel):java.lang.Object");
        }

        public final Object[] newArray(int i2) {
            return new CJRBrowseByCinema[i2];
        }
    }

    public CJRBrowseByCinema() {
        this((CJRBrowseByCinemaMeta) null, (CJRBrowseByData) null, 3, (g) null);
    }

    public static /* synthetic */ CJRBrowseByCinema copy$default(CJRBrowseByCinema cJRBrowseByCinema, CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta, CJRBrowseByData cJRBrowseByData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRBrowseByCinemaMeta = cJRBrowseByCinema.meta;
        }
        if ((i2 & 2) != 0) {
            cJRBrowseByData = cJRBrowseByCinema.data;
        }
        return cJRBrowseByCinema.copy(cJRBrowseByCinemaMeta, cJRBrowseByData);
    }

    public final CJRBrowseByCinemaMeta component1() {
        return this.meta;
    }

    public final CJRBrowseByData component2() {
        return this.data;
    }

    public final CJRBrowseByCinema copy(CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta, CJRBrowseByData cJRBrowseByData) {
        return new CJRBrowseByCinema(cJRBrowseByCinemaMeta, cJRBrowseByData);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRBrowseByCinema)) {
            return false;
        }
        CJRBrowseByCinema cJRBrowseByCinema = (CJRBrowseByCinema) obj;
        return k.a((Object) this.meta, (Object) cJRBrowseByCinema.meta) && k.a((Object) this.data, (Object) cJRBrowseByCinema.data);
    }

    public final int hashCode() {
        CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta = this.meta;
        int i2 = 0;
        int hashCode = (cJRBrowseByCinemaMeta != null ? cJRBrowseByCinemaMeta.hashCode() : 0) * 31;
        CJRBrowseByData cJRBrowseByData = this.data;
        if (cJRBrowseByData != null) {
            i2 = cJRBrowseByData.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRBrowseByCinema(meta=" + this.meta + ", data=" + this.data + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta = this.meta;
        if (cJRBrowseByCinemaMeta != null) {
            parcel.writeInt(1);
            cJRBrowseByCinemaMeta.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        CJRBrowseByData cJRBrowseByData = this.data;
        if (cJRBrowseByData != null) {
            parcel.writeInt(1);
            cJRBrowseByData.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public final CJRBrowseByCinemaMeta getMeta() {
        return this.meta;
    }

    public final void setMeta(CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta) {
        this.meta = cJRBrowseByCinemaMeta;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRBrowseByCinema(CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta, CJRBrowseByData cJRBrowseByData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRBrowseByCinemaMeta, (i2 & 2) != 0 ? null : cJRBrowseByData);
    }

    public final CJRBrowseByData getData() {
        return this.data;
    }

    public final void setData(CJRBrowseByData cJRBrowseByData) {
        this.data = cJRBrowseByData;
    }

    public CJRBrowseByCinema(CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta, CJRBrowseByData cJRBrowseByData) {
        this.meta = cJRBrowseByCinemaMeta;
        this.data = cJRBrowseByData;
    }
}
