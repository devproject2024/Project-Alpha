package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserBO$$Parcelable;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class Post$$Parcelable implements Parcelable, e<Post> {
    public static final Parcelable.Creator<Post$$Parcelable> CREATOR = new Parcelable.Creator<Post$$Parcelable>() {
        public final Post$$Parcelable createFromParcel(Parcel parcel) {
            return new Post$$Parcelable(Post$$Parcelable.read(parcel, new a()));
        }

        public final Post$$Parcelable[] newArray(int i2) {
            return new Post$$Parcelable[i2];
        }
    };
    private Post post$$0;

    public int describeContents() {
        return 0;
    }

    public Post$$Parcelable(Post post) {
        this.post$$0 = post;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.post$$0, parcel, i2, new a());
    }

    public static void write(Post post, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) post);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) post));
        parcel.writeString(post.createdAt);
        UserBO$$Parcelable.write(post.author, parcel, i2, aVar);
        parcel.writeInt(post.remote_id);
        parcel.writeString(post.title);
        parcel.writeString(post.body);
        parcel.writeString(post.updatedAt);
    }

    public Post getParcel() {
        return this.post$$0;
    }

    public static Post read(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            Post post = new Post();
            aVar.a(a2, post);
            post.createdAt = parcel.readString();
            post.author = UserBO$$Parcelable.read(parcel, aVar);
            post.remote_id = parcel.readInt();
            post.title = parcel.readString();
            post.body = parcel.readString();
            post.updatedAt = parcel.readString();
            aVar.a(readInt, post);
            return post;
        } else if (!aVar.b(readInt)) {
            return (Post) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
