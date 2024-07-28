package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.entity.CJRAmenity;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;

public final class CJRMovieMeta implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "movies")

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRMovieHomeListItem> f75174a;
    @b(a = "cinemas")

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRCinemas> f75175b;
    @b(a = "filterData")

    /* renamed from: c  reason: collision with root package name */
    public CJRFilterData f75176c;
    @b(a = "amenities")

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRAmenity> f75177d;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            k.c(parcel, "in");
            ArrayList arrayList3 = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRMovieHomeListItem) parcel.readParcelable(CJRMovieMeta.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add((CJRCinemas) parcel.readParcelable(CJRMovieMeta.class.getClassLoader()));
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            CJRFilterData cJRFilterData = parcel.readInt() != 0 ? (CJRFilterData) CJRFilterData.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList4.add((CJRAmenity) parcel.readParcelable(CJRMovieMeta.class.getClassLoader()));
                    readInt3--;
                }
                arrayList3 = arrayList4;
            }
            return new CJRMovieMeta(arrayList, arrayList2, cJRFilterData, arrayList3);
        }

        public final Object[] newArray(int i2) {
            return new CJRMovieMeta[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRMovieMeta)) {
            return false;
        }
        CJRMovieMeta cJRMovieMeta = (CJRMovieMeta) obj;
        return k.a((Object) this.f75174a, (Object) cJRMovieMeta.f75174a) && k.a((Object) this.f75175b, (Object) cJRMovieMeta.f75175b) && k.a((Object) this.f75176c, (Object) cJRMovieMeta.f75176c) && k.a((Object) this.f75177d, (Object) cJRMovieMeta.f75177d);
    }

    public final int hashCode() {
        ArrayList<CJRMovieHomeListItem> arrayList = this.f75174a;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<CJRCinemas> arrayList2 = this.f75175b;
        int hashCode2 = (hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        CJRFilterData cJRFilterData = this.f75176c;
        int hashCode3 = (hashCode2 + (cJRFilterData != null ? cJRFilterData.hashCode() : 0)) * 31;
        ArrayList<CJRAmenity> arrayList3 = this.f75177d;
        if (arrayList3 != null) {
            i2 = arrayList3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRMovieMeta(movies=" + this.f75174a + ", cinemas=" + this.f75175b + ", filterData=" + this.f75176c + ", amenities=" + this.f75177d + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<CJRMovieHomeListItem> arrayList = this.f75174a;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (CJRMovieHomeListItem writeParcelable : arrayList) {
                parcel.writeParcelable(writeParcelable, i2);
            }
        } else {
            parcel.writeInt(0);
        }
        ArrayList<CJRCinemas> arrayList2 = this.f75175b;
        if (arrayList2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList2.size());
            for (CJRCinemas writeParcelable2 : arrayList2) {
                parcel.writeParcelable(writeParcelable2, i2);
            }
        } else {
            parcel.writeInt(0);
        }
        CJRFilterData cJRFilterData = this.f75176c;
        if (cJRFilterData != null) {
            parcel.writeInt(1);
            cJRFilterData.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        ArrayList<CJRAmenity> arrayList3 = this.f75177d;
        if (arrayList3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList3.size());
            for (CJRAmenity writeParcelable3 : arrayList3) {
                parcel.writeParcelable(writeParcelable3, i2);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRMovieMeta(ArrayList<CJRMovieHomeListItem> arrayList, ArrayList<CJRCinemas> arrayList2, CJRFilterData cJRFilterData, ArrayList<CJRAmenity> arrayList3) {
        this.f75174a = arrayList;
        this.f75175b = arrayList2;
        this.f75176c = cJRFilterData;
        this.f75177d = arrayList3;
    }

    private /* synthetic */ CJRMovieMeta() {
        this((ArrayList<CJRMovieHomeListItem>) null, (ArrayList<CJRCinemas>) null, (CJRFilterData) null, (ArrayList<CJRAmenity>) null);
    }
}
