package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRBrowseByCinemaMeta implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "amenities")
    private ArrayList<CJRAmenity> amenities;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRAmenity) CJRAmenity.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new CJRBrowseByCinemaMeta(arrayList);
        }

        public final Object[] newArray(int i2) {
            return new CJRBrowseByCinemaMeta[i2];
        }
    }

    public CJRBrowseByCinemaMeta() {
        this((ArrayList) null, 1, (g) null);
    }

    public static /* synthetic */ CJRBrowseByCinemaMeta copy$default(CJRBrowseByCinemaMeta cJRBrowseByCinemaMeta, ArrayList<CJRAmenity> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRBrowseByCinemaMeta.amenities;
        }
        return cJRBrowseByCinemaMeta.copy(arrayList);
    }

    public final ArrayList<CJRAmenity> component1() {
        return this.amenities;
    }

    public final CJRBrowseByCinemaMeta copy(ArrayList<CJRAmenity> arrayList) {
        return new CJRBrowseByCinemaMeta(arrayList);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRBrowseByCinemaMeta) && k.a((Object) this.amenities, (Object) ((CJRBrowseByCinemaMeta) obj).amenities);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<CJRAmenity> arrayList = this.amenities;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRBrowseByCinemaMeta(amenities=" + this.amenities + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        ArrayList<CJRAmenity> arrayList = this.amenities;
        if (arrayList != null) {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            for (CJRAmenity writeToParcel : arrayList) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public CJRBrowseByCinemaMeta(ArrayList<CJRAmenity> arrayList) {
        this.amenities = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRBrowseByCinemaMeta(ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList);
    }

    public final ArrayList<CJRAmenity> getAmenities() {
        return this.amenities;
    }

    public final void setAmenities(ArrayList<CJRAmenity> arrayList) {
        this.amenities = arrayList;
    }
}
