package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class UserBO$$Parcelable implements Parcelable, e<UserBO> {
    public static final Parcelable.Creator<UserBO$$Parcelable> CREATOR = new Parcelable.Creator<UserBO$$Parcelable>() {
        public final UserBO$$Parcelable createFromParcel(Parcel parcel) {
            return new UserBO$$Parcelable(UserBO$$Parcelable.read(parcel, new a()));
        }

        public final UserBO$$Parcelable[] newArray(int i2) {
            return new UserBO$$Parcelable[i2];
        }
    };
    private UserBO userBO$$0;

    public int describeContents() {
        return 0;
    }

    public UserBO$$Parcelable(UserBO userBO) {
        this.userBO$$0 = userBO;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.userBO$$0, parcel, i2, new a());
    }

    public static void write(UserBO userBO, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) userBO);
        if (b2 == -1) {
            parcel.writeInt(aVar.a((Object) userBO));
            Class cls = Integer.TYPE;
            parcel.writeInt(((Integer) b.a(UserBO.class, userBO, "userTypeId")).intValue());
            Class<String> cls2 = String.class;
            parcel.writeString((String) b.a(UserBO.class, userBO, "userSummary"));
            Class<String> cls3 = String.class;
            parcel.writeString((String) b.a(UserBO.class, userBO, "name"));
            Class cls4 = Long.TYPE;
            parcel.writeLong(((Long) b.a(UserBO.class, userBO, "id")).longValue());
            Class cls5 = Boolean.TYPE;
            b2 = ((Boolean) b.a(UserBO.class, userBO, "isActive")).booleanValue() ? 1 : 0;
        }
        parcel.writeInt(b2);
    }

    public UserBO getParcel() {
        return this.userBO$$0;
    }

    public static UserBO read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            UserBO userBO = new UserBO();
            aVar.a(a2, userBO);
            b.a(UserBO.class, userBO, "userTypeId", Integer.valueOf(parcel.readInt()));
            b.a(UserBO.class, userBO, "userSummary", parcel.readString());
            b.a(UserBO.class, userBO, "name", parcel.readString());
            b.a(UserBO.class, userBO, "id", Long.valueOf(parcel.readLong()));
            Class<UserBO> cls = UserBO.class;
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            b.a(cls, userBO, "isActive", Boolean.valueOf(z));
            aVar.a(readInt, userBO);
            return userBO;
        } else if (!aVar.b(readInt)) {
            return (UserBO) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
