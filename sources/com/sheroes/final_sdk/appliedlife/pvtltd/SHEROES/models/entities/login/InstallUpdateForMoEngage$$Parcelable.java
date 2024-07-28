package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class InstallUpdateForMoEngage$$Parcelable implements Parcelable, e<InstallUpdateForMoEngage> {
    public static final Parcelable.Creator<InstallUpdateForMoEngage$$Parcelable> CREATOR = new Parcelable.Creator<InstallUpdateForMoEngage$$Parcelable>() {
        public final InstallUpdateForMoEngage$$Parcelable createFromParcel(Parcel parcel) {
            return new InstallUpdateForMoEngage$$Parcelable(InstallUpdateForMoEngage$$Parcelable.read(parcel, new a()));
        }

        public final InstallUpdateForMoEngage$$Parcelable[] newArray(int i2) {
            return new InstallUpdateForMoEngage$$Parcelable[i2];
        }
    };
    private InstallUpdateForMoEngage installUpdateForMoEngage$$0;

    public int describeContents() {
        return 0;
    }

    public InstallUpdateForMoEngage$$Parcelable(InstallUpdateForMoEngage installUpdateForMoEngage) {
        this.installUpdateForMoEngage$$0 = installUpdateForMoEngage;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.installUpdateForMoEngage$$0, parcel, i2, new a());
    }

    public static void write(InstallUpdateForMoEngage installUpdateForMoEngage, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) installUpdateForMoEngage);
        if (b2 == -1) {
            parcel.writeInt(aVar.a((Object) installUpdateForMoEngage));
            Class cls = Integer.TYPE;
            parcel.writeInt(((Integer) b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "appVersion")).intValue());
            Class cls2 = Boolean.TYPE;
            parcel.writeInt(((Boolean) b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isAppInstallFirstTime")).booleanValue() ? 1 : 0);
            Class cls3 = Boolean.TYPE;
            parcel.writeInt(((Boolean) b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isOnBoardingSkipped")).booleanValue() ? 1 : 0);
            Class cls4 = Boolean.TYPE;
            parcel.writeInt(((Boolean) b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isWalkThroughShown")).booleanValue() ? 1 : 0);
            Class cls5 = Boolean.TYPE;
            parcel.writeInt(((Boolean) b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isFirstOpen")).booleanValue() ? 1 : 0);
            Class cls6 = Boolean.TYPE;
            b2 = ((Boolean) b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isWelcome")).booleanValue() ? 1 : 0;
        }
        parcel.writeInt(b2);
    }

    public InstallUpdateForMoEngage getParcel() {
        return this.installUpdateForMoEngage$$0;
    }

    public static InstallUpdateForMoEngage read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            InstallUpdateForMoEngage installUpdateForMoEngage = new InstallUpdateForMoEngage();
            aVar.a(a2, installUpdateForMoEngage);
            b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "appVersion", Integer.valueOf(parcel.readInt()));
            boolean z = false;
            b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isAppInstallFirstTime", Boolean.valueOf(parcel.readInt() == 1));
            b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isOnBoardingSkipped", Boolean.valueOf(parcel.readInt() == 1));
            b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isWalkThroughShown", Boolean.valueOf(parcel.readInt() == 1));
            b.a(InstallUpdateForMoEngage.class, installUpdateForMoEngage, "isFirstOpen", Boolean.valueOf(parcel.readInt() == 1));
            Class<InstallUpdateForMoEngage> cls = InstallUpdateForMoEngage.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, installUpdateForMoEngage, "isWelcome", Boolean.valueOf(z));
            aVar.a(readInt, installUpdateForMoEngage);
            return installUpdateForMoEngage;
        } else if (!aVar.b(readInt)) {
            return (InstallUpdateForMoEngage) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
