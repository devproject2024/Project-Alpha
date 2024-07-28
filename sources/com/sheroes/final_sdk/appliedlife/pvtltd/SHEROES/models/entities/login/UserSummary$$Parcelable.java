package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class UserSummary$$Parcelable implements Parcelable, e<UserSummary> {
    public static final Parcelable.Creator<UserSummary$$Parcelable> CREATOR = new Parcelable.Creator<UserSummary$$Parcelable>() {
        public final UserSummary$$Parcelable createFromParcel(Parcel parcel) {
            return new UserSummary$$Parcelable(UserSummary$$Parcelable.read(parcel, new a()));
        }

        public final UserSummary$$Parcelable[] newArray(int i2) {
            return new UserSummary$$Parcelable[i2];
        }
    };
    private UserSummary userSummary$$0;

    public int describeContents() {
        return 0;
    }

    public UserSummary$$Parcelable(UserSummary userSummary) {
        this.userSummary$$0 = userSummary;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.userSummary$$0, parcel, i2, new a());
    }

    public static void write(UserSummary userSummary, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) userSummary);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) userSummary));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(UserSummary.class, userSummary, "firstName"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(UserSummary.class, userSummary, "lastName"));
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(UserSummary.class, userSummary, "photoUrl"));
        Class<UserBO> cls4 = UserBO.class;
        UserBO$$Parcelable.write((UserBO) b.a(UserSummary.class, userSummary, "userBO"), parcel, i2, aVar);
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(UserSummary.class, userSummary, "mobile"));
        Class<String> cls6 = String.class;
        parcel.writeString((String) b.a(UserSummary.class, userSummary, "emailId"));
        Class cls7 = Long.TYPE;
        parcel.writeLong(((Long) b.a(UserSummary.class, userSummary, "userId")).longValue());
        Class<String> cls8 = String.class;
        parcel.writeString((String) b.a(UserSummary.class, userSummary, "appShareUrl"));
    }

    public UserSummary getParcel() {
        return this.userSummary$$0;
    }

    public static UserSummary read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            UserSummary userSummary = new UserSummary();
            aVar.a(a2, userSummary);
            b.a(UserSummary.class, userSummary, "firstName", parcel.readString());
            b.a(UserSummary.class, userSummary, "lastName", parcel.readString());
            b.a(UserSummary.class, userSummary, "photoUrl", parcel.readString());
            b.a(UserSummary.class, userSummary, "userBO", UserBO$$Parcelable.read(parcel, aVar));
            b.a(UserSummary.class, userSummary, "mobile", parcel.readString());
            b.a(UserSummary.class, userSummary, "emailId", parcel.readString());
            b.a(UserSummary.class, userSummary, "userId", Long.valueOf(parcel.readLong()));
            b.a(UserSummary.class, userSummary, "appShareUrl", parcel.readString());
            aVar.a(readInt, userSummary);
            return userSummary;
        } else if (!aVar.b(readInt)) {
            return (UserSummary) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
