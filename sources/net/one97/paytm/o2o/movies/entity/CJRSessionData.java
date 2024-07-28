package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class CJRSessionData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "sessionCount")
    private int sessionCount;
    @b(a = "status")
    private int status;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new CJRSessionData(parcel.readInt(), parcel.readInt());
        }

        public final Object[] newArray(int i2) {
            return new CJRSessionData[i2];
        }
    }

    public static /* synthetic */ CJRSessionData copy$default(CJRSessionData cJRSessionData, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = cJRSessionData.sessionCount;
        }
        if ((i4 & 2) != 0) {
            i3 = cJRSessionData.status;
        }
        return cJRSessionData.copy(i2, i3);
    }

    public final int component1() {
        return this.sessionCount;
    }

    public final int component2() {
        return this.status;
    }

    public final CJRSessionData copy(int i2, int i3) {
        return new CJRSessionData(i2, i3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRSessionData)) {
            return false;
        }
        CJRSessionData cJRSessionData = (CJRSessionData) obj;
        return this.sessionCount == cJRSessionData.sessionCount && this.status == cJRSessionData.status;
    }

    public final int hashCode() {
        return (Integer.valueOf(this.sessionCount).hashCode() * 31) + Integer.valueOf(this.status).hashCode();
    }

    public final String toString() {
        return "CJRSessionData(sessionCount=" + this.sessionCount + ", status=" + this.status + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.sessionCount);
        parcel.writeInt(this.status);
    }

    public CJRSessionData(int i2, int i3) {
        this.sessionCount = i2;
        this.status = i3;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final void setSessionCount(int i2) {
        this.sessionCount = i2;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }
}
