package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserBO$$Parcelable;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class Community$$Parcelable implements Parcelable, e<Community> {
    public static final Parcelable.Creator<Community$$Parcelable> CREATOR = new Parcelable.Creator<Community$$Parcelable>() {
        public final Community$$Parcelable createFromParcel(Parcel parcel) {
            return new Community$$Parcelable(Community$$Parcelable.read(parcel, new a()));
        }

        public final Community$$Parcelable[] newArray(int i2) {
            return new Community$$Parcelable[i2];
        }
    };
    private Community community$$0;

    public int describeContents() {
        return 0;
    }

    public Community$$Parcelable(Community community) {
        this.community$$0 = community;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.community$$0, parcel, i2, new a());
    }

    public static void write(Community community, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) community);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) community));
        parcel.writeInt(community.isOwner ? 1 : 0);
        parcel.writeString(community.imageUrl);
        parcel.writeString(community.name);
        parcel.writeInt(community.isFirstOther ? 1 : 0);
        parcel.writeLong(community.id);
        parcel.writeInt(community.isChecked ? 1 : 0);
        parcel.writeString(community.thumbImageUrl);
        parcel.writeString(community.createdAt);
        UserBO$$Parcelable.write(community.author, parcel, i2, aVar);
        parcel.writeInt(community.remote_id);
        parcel.writeString(community.title);
        parcel.writeString(community.body);
        parcel.writeString(community.updatedAt);
    }

    public Community getParcel() {
        return this.community$$0;
    }

    public static Community read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            Community community = new Community();
            aVar.a(a2, community);
            boolean z = false;
            community.isOwner = parcel.readInt() == 1;
            community.imageUrl = parcel.readString();
            community.name = parcel.readString();
            community.isFirstOther = parcel.readInt() == 1;
            community.id = parcel.readLong();
            if (parcel.readInt() == 1) {
                z = true;
            }
            community.isChecked = z;
            community.thumbImageUrl = parcel.readString();
            community.createdAt = parcel.readString();
            community.author = UserBO$$Parcelable.read(parcel, aVar);
            community.remote_id = parcel.readInt();
            community.title = parcel.readString();
            community.body = parcel.readString();
            community.updatedAt = parcel.readString();
            aVar.a(readInt, community);
            return community;
        } else if (!aVar.b(readInt)) {
            return (Community) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
