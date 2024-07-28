package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserBO$$Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class Album$$Parcelable implements Parcelable, e<Album> {
    public static final Parcelable.Creator<Album$$Parcelable> CREATOR = new Parcelable.Creator<Album$$Parcelable>() {
        public final Album$$Parcelable createFromParcel(Parcel parcel) {
            return new Album$$Parcelable(Album$$Parcelable.read(parcel, new a()));
        }

        public final Album$$Parcelable[] newArray(int i2) {
            return new Album$$Parcelable[i2];
        }
    };
    private Album album$$0;

    public int describeContents() {
        return 0;
    }

    public Album$$Parcelable(Album album) {
        this.album$$0 = album;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.album$$0, parcel, i2, new a());
    }

    public static void write(Album album, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) album);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) album));
        parcel.writeString(album.deepLinkUrl);
        if (album.photos == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(album.photos.size());
            Iterator<Photo> it2 = album.photos.iterator();
            while (it2.hasNext()) {
                Photo$$Parcelable.write(it2.next(), parcel, i2, aVar);
            }
        }
        parcel.writeString(album.createdAt);
        UserBO$$Parcelable.write(album.author, parcel, i2, aVar);
        parcel.writeInt(album.remote_id);
        parcel.writeString(album.title);
        parcel.writeString(album.body);
        parcel.writeString(album.updatedAt);
    }

    public Album getParcel() {
        return this.album$$0;
    }

    public static Album read(Parcel parcel, a aVar) {
        ArrayList<Photo> arrayList;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            Album album = new Album();
            aVar.a(a2, album);
            album.deepLinkUrl = parcel.readString();
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                ArrayList<Photo> arrayList2 = new ArrayList<>(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList2.add(Photo$$Parcelable.read(parcel, aVar));
                }
                arrayList = arrayList2;
            }
            album.photos = arrayList;
            album.createdAt = parcel.readString();
            album.author = UserBO$$Parcelable.read(parcel, aVar);
            album.remote_id = parcel.readInt();
            album.title = parcel.readString();
            album.body = parcel.readString();
            album.updatedAt = parcel.readString();
            aVar.a(readInt, album);
            return album;
        } else if (!aVar.b(readInt)) {
            return (Album) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
