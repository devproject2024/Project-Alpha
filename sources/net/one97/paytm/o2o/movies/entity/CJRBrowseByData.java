package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRBrowseByData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "cinemas")
    private ArrayList<CJRCinemas> cinemas;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRCinemas) CJRCinemas.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new CJRBrowseByData(arrayList);
        }

        public final Object[] newArray(int i2) {
            return new CJRBrowseByData[i2];
        }
    }

    public CJRBrowseByData() {
        this((ArrayList) null, 1, (g) null);
    }

    public static /* synthetic */ CJRBrowseByData copy$default(CJRBrowseByData cJRBrowseByData, ArrayList<CJRCinemas> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRBrowseByData.cinemas;
        }
        return cJRBrowseByData.copy(arrayList);
    }

    public final ArrayList<CJRCinemas> component1() {
        return this.cinemas;
    }

    public final CJRBrowseByData copy(ArrayList<CJRCinemas> arrayList) {
        return new CJRBrowseByData(arrayList);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRBrowseByData) && k.a((Object) this.cinemas, (Object) ((CJRBrowseByData) obj).cinemas);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<CJRCinemas> arrayList = this.cinemas;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRBrowseByData(cinemas=" + this.cinemas + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<CJRCinemas> arrayList = this.cinemas;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (CJRCinemas writeToParcel : arrayList) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRBrowseByData(ArrayList<CJRCinemas> arrayList) {
        this.cinemas = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRBrowseByData(ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList);
    }

    public final ArrayList<CJRCinemas> getCinemas() {
        return this.cinemas;
    }

    public final void setCinemas(ArrayList<CJRCinemas> arrayList) {
        this.cinemas = arrayList;
    }
}
