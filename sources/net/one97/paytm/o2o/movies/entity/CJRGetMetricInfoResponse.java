package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRGetMetricInfoResponse extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "data")
    private HashMap<String, CJRMetricInfoDataItem> data;
    @b(a = "metaData")
    private CJRMetricInfoMeta metaData;

    public static class Creator implements Parcelable.Creator {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: net.one97.paytm.o2o.movies.entity.CJRMetricInfoMeta} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object createFromParcel(android.os.Parcel r7) {
            /*
                r6 = this;
                java.lang.String r0 = "in"
                kotlin.g.b.k.c(r7, r0)
                net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse r0 = new net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse
                int r1 = r7.readInt()
                r2 = 0
                if (r1 == 0) goto L_0x002b
                int r1 = r7.readInt()
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>(r1)
            L_0x0017:
                if (r1 == 0) goto L_0x002c
                java.lang.String r4 = r7.readString()
                android.os.Parcelable$Creator r5 = net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r7)
                net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem r5 = (net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem) r5
                r3.put(r4, r5)
                int r1 = r1 + -1
                goto L_0x0017
            L_0x002b:
                r3 = r2
            L_0x002c:
                int r1 = r7.readInt()
                if (r1 == 0) goto L_0x003b
                android.os.Parcelable$Creator r1 = net.one97.paytm.o2o.movies.entity.CJRMetricInfoMeta.CREATOR
                java.lang.Object r7 = r1.createFromParcel(r7)
                r2 = r7
                net.one97.paytm.o2o.movies.entity.CJRMetricInfoMeta r2 = (net.one97.paytm.o2o.movies.entity.CJRMetricInfoMeta) r2
            L_0x003b:
                r0.<init>(r3, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse.Creator.createFromParcel(android.os.Parcel):java.lang.Object");
        }

        public final Object[] newArray(int i2) {
            return new CJRGetMetricInfoResponse[i2];
        }
    }

    public CJRGetMetricInfoResponse() {
        this((HashMap) null, (CJRMetricInfoMeta) null, 3, (g) null);
    }

    public static /* synthetic */ CJRGetMetricInfoResponse copy$default(CJRGetMetricInfoResponse cJRGetMetricInfoResponse, HashMap<String, CJRMetricInfoDataItem> hashMap, CJRMetricInfoMeta cJRMetricInfoMeta, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hashMap = cJRGetMetricInfoResponse.data;
        }
        if ((i2 & 2) != 0) {
            cJRMetricInfoMeta = cJRGetMetricInfoResponse.metaData;
        }
        return cJRGetMetricInfoResponse.copy(hashMap, cJRMetricInfoMeta);
    }

    public final HashMap<String, CJRMetricInfoDataItem> component1() {
        return this.data;
    }

    public final CJRMetricInfoMeta component2() {
        return this.metaData;
    }

    public final CJRGetMetricInfoResponse copy(HashMap<String, CJRMetricInfoDataItem> hashMap, CJRMetricInfoMeta cJRMetricInfoMeta) {
        return new CJRGetMetricInfoResponse(hashMap, cJRMetricInfoMeta);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRGetMetricInfoResponse)) {
            return false;
        }
        CJRGetMetricInfoResponse cJRGetMetricInfoResponse = (CJRGetMetricInfoResponse) obj;
        return k.a((Object) this.data, (Object) cJRGetMetricInfoResponse.data) && k.a((Object) this.metaData, (Object) cJRGetMetricInfoResponse.metaData);
    }

    public final int hashCode() {
        HashMap<String, CJRMetricInfoDataItem> hashMap = this.data;
        int i2 = 0;
        int hashCode = (hashMap != null ? hashMap.hashCode() : 0) * 31;
        CJRMetricInfoMeta cJRMetricInfoMeta = this.metaData;
        if (cJRMetricInfoMeta != null) {
            i2 = cJRMetricInfoMeta.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRGetMetricInfoResponse(data=" + this.data + ", metaData=" + this.metaData + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        HashMap<String, CJRMetricInfoDataItem> hashMap = this.data;
        if (hashMap != null) {
            parcel.writeInt(1);
            parcel.writeInt(hashMap.size());
            for (Map.Entry<String, CJRMetricInfoDataItem> next : hashMap.entrySet()) {
                parcel.writeString(next.getKey());
                next.getValue().writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        CJRMetricInfoMeta cJRMetricInfoMeta = this.metaData;
        if (cJRMetricInfoMeta != null) {
            parcel.writeInt(1);
            cJRMetricInfoMeta.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public final HashMap<String, CJRMetricInfoDataItem> getData() {
        return this.data;
    }

    public final void setData(HashMap<String, CJRMetricInfoDataItem> hashMap) {
        this.data = hashMap;
    }

    public CJRGetMetricInfoResponse(HashMap<String, CJRMetricInfoDataItem> hashMap, CJRMetricInfoMeta cJRMetricInfoMeta) {
        this.data = hashMap;
        this.metaData = cJRMetricInfoMeta;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRGetMetricInfoResponse(HashMap hashMap, CJRMetricInfoMeta cJRMetricInfoMeta, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : hashMap, (i2 & 2) != 0 ? null : cJRMetricInfoMeta);
    }

    public final CJRMetricInfoMeta getMetaData() {
        return this.metaData;
    }

    public final void setMetaData(CJRMetricInfoMeta cJRMetricInfoMeta) {
        this.metaData = cJRMetricInfoMeta;
    }
}
