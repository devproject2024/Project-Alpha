package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMovieHomeDataResponse extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "data")
    private CJRMovieHomeList data;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new CJRMovieHomeDataResponse(parcel.readInt() != 0 ? (CJRMovieHomeList) CJRMovieHomeList.CREATOR.createFromParcel(parcel) : null);
        }

        public final Object[] newArray(int i2) {
            return new CJRMovieHomeDataResponse[i2];
        }
    }

    public CJRMovieHomeDataResponse() {
        this((CJRMovieHomeList) null, 1, (g) null);
    }

    public static /* synthetic */ CJRMovieHomeDataResponse copy$default(CJRMovieHomeDataResponse cJRMovieHomeDataResponse, CJRMovieHomeList cJRMovieHomeList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRMovieHomeList = cJRMovieHomeDataResponse.data;
        }
        return cJRMovieHomeDataResponse.copy(cJRMovieHomeList);
    }

    public final CJRMovieHomeList component1() {
        return this.data;
    }

    public final CJRMovieHomeDataResponse copy(CJRMovieHomeList cJRMovieHomeList) {
        return new CJRMovieHomeDataResponse(cJRMovieHomeList);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRMovieHomeDataResponse) && k.a((Object) this.data, (Object) ((CJRMovieHomeDataResponse) obj).data);
        }
        return true;
    }

    public final int hashCode() {
        CJRMovieHomeList cJRMovieHomeList = this.data;
        if (cJRMovieHomeList != null) {
            return cJRMovieHomeList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRMovieHomeDataResponse(data=" + this.data + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        CJRMovieHomeList cJRMovieHomeList = this.data;
        if (cJRMovieHomeList != null) {
            parcel.writeInt(1);
            cJRMovieHomeList.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public CJRMovieHomeDataResponse(CJRMovieHomeList cJRMovieHomeList) {
        this.data = cJRMovieHomeList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMovieHomeDataResponse(CJRMovieHomeList cJRMovieHomeList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRMovieHomeList);
    }

    public final CJRMovieHomeList getData() {
        return this.data;
    }

    public final void setData(CJRMovieHomeList cJRMovieHomeList) {
        this.data = cJRMovieHomeList;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        if (fVar == null) {
            try {
                k.a();
            } catch (Exception unused) {
                return this;
            }
        }
        Object a2 = fVar.a(str, getClass());
        k.a((Object) a2, "p1!!.fromJson(p0,this.javaClass)");
        return (IJRPaytmDataModel) a2;
    }
}
