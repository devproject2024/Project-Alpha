package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserBO$$Parcelable;
import java.io.File;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class Photo$$Parcelable implements Parcelable, e<Photo> {
    public static final Parcelable.Creator<Photo$$Parcelable> CREATOR = new Parcelable.Creator<Photo$$Parcelable>() {
        public final Photo$$Parcelable createFromParcel(Parcel parcel) {
            return new Photo$$Parcelable(Photo$$Parcelable.read(parcel, new a()));
        }

        public final Photo$$Parcelable[] newArray(int i2) {
            return new Photo$$Parcelable[i2];
        }
    };
    private Photo photo$$0;

    public int describeContents() {
        return 0;
    }

    public Photo$$Parcelable(Photo photo) {
        this.photo$$0 = photo;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.photo$$0, parcel, i2, new a());
    }

    public static void write(Photo photo, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) photo);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) photo));
        parcel.writeSerializable(photo.file);
        parcel.writeInt(photo.isNew ? 1 : 0);
        parcel.writeString(photo.url);
        parcel.writeString(photo.createdAt);
        UserBO$$Parcelable.write(photo.author, parcel, i2, aVar);
        parcel.writeInt(photo.remote_id);
        parcel.writeString(photo.title);
        parcel.writeString(photo.body);
        parcel.writeString(photo.updatedAt);
    }

    public Photo getParcel() {
        return this.photo$$0;
    }

    public static Photo read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            Photo photo = new Photo();
            aVar.a(a2, photo);
            photo.file = (File) parcel.readSerializable();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            photo.isNew = z;
            photo.url = parcel.readString();
            photo.createdAt = parcel.readString();
            photo.author = UserBO$$Parcelable.read(parcel, aVar);
            photo.remote_id = parcel.readInt();
            photo.title = parcel.readString();
            photo.body = parcel.readString();
            photo.updatedAt = parcel.readString();
            aVar.a(readInt, photo);
            return photo;
        } else if (!aVar.b(readInt)) {
            return (Photo) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
