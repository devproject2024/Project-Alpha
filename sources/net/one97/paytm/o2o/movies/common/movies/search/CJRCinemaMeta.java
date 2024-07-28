package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.entity.CJRAmenity;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;

public final class CJRCinemaMeta implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "movies")

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRMovieHomeListItem> f75161a;
    @b(a = "cinema")

    /* renamed from: b  reason: collision with root package name */
    public CJRCinemas f75162b;
    @b(a = "amenities")

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRAmenity> f75163c;
    @b(a = "filterData")

    /* renamed from: d  reason: collision with root package name */
    private CJRFilterData f75164d;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            ArrayList arrayList2 = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRMovieHomeListItem) parcel.readParcelable(CJRCinemaMeta.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            CJRCinemas cJRCinemas = (CJRCinemas) parcel.readParcelable(CJRCinemaMeta.class.getClassLoader());
            CJRFilterData cJRFilterData = parcel.readInt() != 0 ? (CJRFilterData) CJRFilterData.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList3.add((CJRAmenity) parcel.readParcelable(CJRCinemaMeta.class.getClassLoader()));
                    readInt2--;
                }
                arrayList2 = arrayList3;
            }
            return new CJRCinemaMeta(arrayList, cJRCinemas, cJRFilterData, arrayList2);
        }

        public final Object[] newArray(int i2) {
            return new CJRCinemaMeta[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCinemaMeta)) {
            return false;
        }
        CJRCinemaMeta cJRCinemaMeta = (CJRCinemaMeta) obj;
        return k.a((Object) this.f75161a, (Object) cJRCinemaMeta.f75161a) && k.a((Object) this.f75162b, (Object) cJRCinemaMeta.f75162b) && k.a((Object) this.f75164d, (Object) cJRCinemaMeta.f75164d) && k.a((Object) this.f75163c, (Object) cJRCinemaMeta.f75163c);
    }

    public final int hashCode() {
        ArrayList<CJRMovieHomeListItem> arrayList = this.f75161a;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        CJRCinemas cJRCinemas = this.f75162b;
        int hashCode2 = (hashCode + (cJRCinemas != null ? cJRCinemas.hashCode() : 0)) * 31;
        CJRFilterData cJRFilterData = this.f75164d;
        int hashCode3 = (hashCode2 + (cJRFilterData != null ? cJRFilterData.hashCode() : 0)) * 31;
        ArrayList<CJRAmenity> arrayList2 = this.f75163c;
        if (arrayList2 != null) {
            i2 = arrayList2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRCinemaMeta(movies=" + this.f75161a + ", cinema=" + this.f75162b + ", filterData=" + this.f75164d + ", amenities=" + this.f75163c + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<CJRMovieHomeListItem> arrayList = this.f75161a;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (CJRMovieHomeListItem writeParcelable : arrayList) {
                parcel.writeParcelable(writeParcelable, i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.f75162b, i2);
        CJRFilterData cJRFilterData = this.f75164d;
        if (cJRFilterData != null) {
            parcel.writeInt(1);
            cJRFilterData.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        ArrayList<CJRAmenity> arrayList2 = this.f75163c;
        if (arrayList2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList2.size());
            for (CJRAmenity writeParcelable2 : arrayList2) {
                parcel.writeParcelable(writeParcelable2, i2);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRCinemaMeta(ArrayList<CJRMovieHomeListItem> arrayList, CJRCinemas cJRCinemas, CJRFilterData cJRFilterData, ArrayList<CJRAmenity> arrayList2) {
        this.f75161a = arrayList;
        this.f75162b = cJRCinemas;
        this.f75164d = cJRFilterData;
        this.f75163c = arrayList2;
    }

    private /* synthetic */ CJRCinemaMeta() {
        this((ArrayList<CJRMovieHomeListItem>) null, (CJRCinemas) null, (CJRFilterData) null, (ArrayList<CJRAmenity>) null);
    }
}
