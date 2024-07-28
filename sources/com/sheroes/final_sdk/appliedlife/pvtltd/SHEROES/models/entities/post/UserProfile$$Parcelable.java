package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserBO$$Parcelable;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class UserProfile$$Parcelable implements Parcelable, e<UserProfile> {
    public static final Parcelable.Creator<UserProfile$$Parcelable> CREATOR = new Parcelable.Creator<UserProfile$$Parcelable>() {
        public final UserProfile$$Parcelable createFromParcel(Parcel parcel) {
            return new UserProfile$$Parcelable(UserProfile$$Parcelable.read(parcel, new a()));
        }

        public final UserProfile$$Parcelable[] newArray(int i2) {
            return new UserProfile$$Parcelable[i2];
        }
    };
    private UserProfile userProfile$$0;

    public int describeContents() {
        return 0;
    }

    public UserProfile$$Parcelable(UserProfile userProfile) {
        this.userProfile$$0 = userProfile;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.userProfile$$0, parcel, i2, new a());
    }

    public static void write(UserProfile userProfile, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) userProfile);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) userProfile));
        parcel.writeString(userProfile.name);
        parcel.writeString(userProfile.bio);
        parcel.writeString(userProfile.shortDescription);
        parcel.writeString(userProfile.thumbUrl);
        parcel.writeString(userProfile.createdAt);
        UserBO$$Parcelable.write(userProfile.author, parcel, i2, aVar);
        parcel.writeInt(userProfile.remote_id);
        parcel.writeString(userProfile.title);
        parcel.writeString(userProfile.body);
        parcel.writeString(userProfile.updatedAt);
    }

    public UserProfile getParcel() {
        return this.userProfile$$0;
    }

    public static UserProfile read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            UserProfile userProfile = new UserProfile();
            aVar.a(a2, userProfile);
            userProfile.name = parcel.readString();
            userProfile.bio = parcel.readString();
            userProfile.shortDescription = parcel.readString();
            userProfile.thumbUrl = parcel.readString();
            userProfile.createdAt = parcel.readString();
            userProfile.author = UserBO$$Parcelable.read(parcel, aVar);
            userProfile.remote_id = parcel.readInt();
            userProfile.title = parcel.readString();
            userProfile.body = parcel.readString();
            userProfile.updatedAt = parcel.readString();
            aVar.a(readInt, userProfile);
            return userProfile;
        } else if (!aVar.b(readInt)) {
            return (UserProfile) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
