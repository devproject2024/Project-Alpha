package net.one97.paytm.feed.repository.models.stories;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.k;

public final class User implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "canFollow")
    private final boolean userCanFollow;
    @c(a = "id")
    private final int userId;
    @c(a = "imageUrl")
    private final String userImageUrl;
    @c(a = "name")
    private final String userName;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new User(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new User[i2];
        }
    }

    public static /* synthetic */ User copy$default(User user, boolean z, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = user.userCanFollow;
        }
        if ((i3 & 2) != 0) {
            i2 = user.userId;
        }
        if ((i3 & 4) != 0) {
            str = user.userImageUrl;
        }
        if ((i3 & 8) != 0) {
            str2 = user.userName;
        }
        return user.copy(z, i2, str, str2);
    }

    public final boolean component1() {
        return this.userCanFollow;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.userImageUrl;
    }

    public final String component4() {
        return this.userName;
    }

    public final User copy(boolean z, int i2, String str, String str2) {
        k.c(str, "userImageUrl");
        k.c(str2, "userName");
        return new User(z, i2, str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof User) {
                User user = (User) obj;
                if (this.userCanFollow == user.userCanFollow) {
                    if (!(this.userId == user.userId) || !k.a((Object) this.userImageUrl, (Object) user.userImageUrl) || !k.a((Object) this.userName, (Object) user.userName)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.userCanFollow;
        if (z) {
            z = true;
        }
        int hashCode = (((z ? 1 : 0) * true) + Integer.valueOf(this.userId).hashCode()) * 31;
        String str = this.userImageUrl;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.userName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "User(userCanFollow=" + this.userCanFollow + ", userId=" + this.userId + ", userImageUrl=" + this.userImageUrl + ", userName=" + this.userName + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.userCanFollow ? 1 : 0);
        parcel.writeInt(this.userId);
        parcel.writeString(this.userImageUrl);
        parcel.writeString(this.userName);
    }

    public User(boolean z, int i2, String str, String str2) {
        k.c(str, "userImageUrl");
        k.c(str2, "userName");
        this.userCanFollow = z;
        this.userId = i2;
        this.userImageUrl = str;
        this.userName = str2;
    }

    public final boolean getUserCanFollow() {
        return this.userCanFollow;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getUserImageUrl() {
        return this.userImageUrl;
    }

    public final String getUserName() {
        return this.userName;
    }
}
