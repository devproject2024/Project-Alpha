package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class MyCommunities$$Parcelable implements Parcelable, e<MyCommunities> {
    public static final Parcelable.Creator<MyCommunities$$Parcelable> CREATOR = new Parcelable.Creator<MyCommunities$$Parcelable>() {
        public final MyCommunities$$Parcelable createFromParcel(Parcel parcel) {
            return new MyCommunities$$Parcelable(MyCommunities$$Parcelable.read(parcel, new a()));
        }

        public final MyCommunities$$Parcelable[] newArray(int i2) {
            return new MyCommunities$$Parcelable[i2];
        }
    };
    private MyCommunities myCommunities$$0;

    public int describeContents() {
        return 0;
    }

    public MyCommunities$$Parcelable(MyCommunities myCommunities) {
        this.myCommunities$$0 = myCommunities;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.myCommunities$$0, parcel, i2, new a());
    }

    public static void write(MyCommunities myCommunities, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) myCommunities);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) myCommunities));
        if (myCommunities.myCommunities == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(myCommunities.myCommunities.size());
        for (Community write : myCommunities.myCommunities) {
            Community$$Parcelable.write(write, parcel, i2, aVar);
        }
    }

    public MyCommunities getParcel() {
        return this.myCommunities$$0;
    }

    public static MyCommunities read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            MyCommunities myCommunities = new MyCommunities();
            aVar.a(a2, myCommunities);
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList2.add(Community$$Parcelable.read(parcel, aVar));
                }
                arrayList = arrayList2;
            }
            myCommunities.myCommunities = arrayList;
            aVar.a(readInt, myCommunities);
            return myCommunities;
        } else if (!aVar.b(readInt)) {
            return (MyCommunities) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
