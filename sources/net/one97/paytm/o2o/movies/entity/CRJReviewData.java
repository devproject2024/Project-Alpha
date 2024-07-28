package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CRJReviewData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "isAvailable")
    private Boolean isAvailable;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new CRJReviewData(bool);
        }

        public final Object[] newArray(int i2) {
            return new CRJReviewData[i2];
        }
    }

    public CRJReviewData() {
        this((Boolean) null, 1, (g) null);
    }

    public static /* synthetic */ CRJReviewData copy$default(CRJReviewData cRJReviewData, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = cRJReviewData.isAvailable;
        }
        return cRJReviewData.copy(bool);
    }

    public final Boolean component1() {
        return this.isAvailable;
    }

    public final CRJReviewData copy(Boolean bool) {
        return new CRJReviewData(bool);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CRJReviewData) && k.a((Object) this.isAvailable, (Object) ((CRJReviewData) obj).isAvailable);
        }
        return true;
    }

    public final int hashCode() {
        Boolean bool = this.isAvailable;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CRJReviewData(isAvailable=" + this.isAvailable + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        boolean z;
        k.c(parcel, "parcel");
        Boolean bool = this.isAvailable;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        parcel.writeInt(z ? 1 : 0);
    }

    public CRJReviewData(Boolean bool) {
        this.isAvailable = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CRJReviewData(Boolean bool, int i2, g gVar) {
        this((i2 & 1) != 0 ? Boolean.FALSE : bool);
    }

    public final Boolean isAvailable() {
        return this.isAvailable;
    }

    public final void setAvailable(Boolean bool) {
        this.isAvailable = bool;
    }
}
