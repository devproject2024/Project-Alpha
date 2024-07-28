package net.one97.paytm.feed.repository.models.provider;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class UserData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final long id;
    private boolean isFollowed;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new UserData(parcel.readLong(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i2) {
            return new UserData[i2];
        }
    }

    public static /* synthetic */ UserData copy$default(UserData userData, long j, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = userData.id;
        }
        if ((i2 & 2) != 0) {
            z = userData.isFollowed;
        }
        return userData.copy(j, z);
    }

    public final long component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.isFollowed;
    }

    public final UserData copy(long j, boolean z) {
        return new UserData(j, z);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UserData) {
                UserData userData = (UserData) obj;
                if (this.id == userData.id) {
                    if (this.isFollowed == userData.isFollowed) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Long.valueOf(this.id).hashCode() * 31;
        boolean z = this.isFollowed;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "UserData(id=" + this.id + ", isFollowed=" + this.isFollowed + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeInt(this.isFollowed ? 1 : 0);
    }

    public UserData(long j, boolean z) {
        this.id = j;
        this.isFollowed = z;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean isFollowed() {
        return this.isFollowed;
    }

    public final void setFollowed(boolean z) {
        this.isFollowed = z;
    }
}
