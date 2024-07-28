package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class Config$$Parcelable implements Parcelable, e<Config> {
    public static final Parcelable.Creator<Config$$Parcelable> CREATOR = new Parcelable.Creator<Config$$Parcelable>() {
        public final Config$$Parcelable createFromParcel(Parcel parcel) {
            return new Config$$Parcelable(Config$$Parcelable.read(parcel, new a()));
        }

        public final Config$$Parcelable[] newArray(int i2) {
            return new Config$$Parcelable[i2];
        }
    };
    private Config config$$0;

    public int describeContents() {
        return 0;
    }

    public Config$$Parcelable(Config config) {
        this.config$$0 = config;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.config$$0, parcel, i2, new a());
    }

    public static void write(Config config, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) config);
        if (b2 != -1) {
            parcel.writeInt(b2);
        } else {
            parcel.writeInt(aVar.a((Object) config));
        }
    }

    public Config getParcel() {
        return this.config$$0;
    }

    public static Config read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            Config config = new Config();
            aVar.a(a2, config);
            aVar.a(readInt, config);
            return config;
        } else if (!aVar.b(readInt)) {
            return (Config) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
