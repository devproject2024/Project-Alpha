package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMovieHomeList extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "movies")
    private ArrayList<CJRMovieHomeListItem> movies;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRMovieHomeListItem) CJRMovieHomeListItem.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new CJRMovieHomeList(arrayList);
        }

        public final Object[] newArray(int i2) {
            return new CJRMovieHomeList[i2];
        }
    }

    public CJRMovieHomeList() {
        this((ArrayList) null, 1, (g) null);
    }

    public static /* synthetic */ CJRMovieHomeList copy$default(CJRMovieHomeList cJRMovieHomeList, ArrayList<CJRMovieHomeListItem> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRMovieHomeList.movies;
        }
        return cJRMovieHomeList.copy(arrayList);
    }

    public final ArrayList<CJRMovieHomeListItem> component1() {
        return this.movies;
    }

    public final CJRMovieHomeList copy(ArrayList<CJRMovieHomeListItem> arrayList) {
        return new CJRMovieHomeList(arrayList);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRMovieHomeList) && k.a((Object) this.movies, (Object) ((CJRMovieHomeList) obj).movies);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<CJRMovieHomeListItem> arrayList = this.movies;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRMovieHomeList(movies=" + this.movies + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<CJRMovieHomeListItem> arrayList = this.movies;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (CJRMovieHomeListItem writeToParcel : arrayList) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRMovieHomeList(ArrayList<CJRMovieHomeListItem> arrayList) {
        this.movies = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMovieHomeList(ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList);
    }

    public final ArrayList<CJRMovieHomeListItem> getMovies() {
        return this.movies;
    }

    public final void setMovies(ArrayList<CJRMovieHomeListItem> arrayList) {
        this.movies = arrayList;
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
