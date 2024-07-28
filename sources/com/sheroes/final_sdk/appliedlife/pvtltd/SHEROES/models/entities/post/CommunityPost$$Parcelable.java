package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import android.os.Parcel;
import android.os.Parcelable;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserBO$$Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import org.parceler.a;
import org.parceler.e;
import org.parceler.f;

public class CommunityPost$$Parcelable implements Parcelable, e<CommunityPost> {
    public static final Parcelable.Creator<CommunityPost$$Parcelable> CREATOR = new Parcelable.Creator<CommunityPost$$Parcelable>() {
        public final CommunityPost$$Parcelable createFromParcel(Parcel parcel) {
            return new CommunityPost$$Parcelable(CommunityPost$$Parcelable.read(parcel, new a()));
        }

        public final CommunityPost$$Parcelable[] newArray(int i2) {
            return new CommunityPost$$Parcelable[i2];
        }
    };
    private CommunityPost communityPost$$0;

    public int describeContents() {
        return 0;
    }

    public CommunityPost$$Parcelable(CommunityPost communityPost) {
        this.communityPost$$0 = communityPost;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.communityPost$$0, parcel, i2, new a());
    }

    public static void write(CommunityPost communityPost, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) communityPost);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) communityPost));
        if (communityPost.myCommunitiesList == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(communityPost.myCommunitiesList.size());
            for (Community write : communityPost.myCommunitiesList) {
                Community$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        parcel.writeInt(communityPost.isPostByCommunity ? 1 : 0);
        parcel.writeInt(communityPost.isChallengeType ? 1 : 0);
        parcel.writeInt(communityPost.isMyPost ? 1 : 0);
        parcel.writeString(communityPost.challengeType);
        parcel.writeString(communityPost.challengeHashTag);
        Community$$Parcelable.write(communityPost.community, parcel, i2, aVar);
        if (communityPost.photos == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(communityPost.photos.size());
            Iterator<Photo> it2 = communityPost.photos.iterator();
            while (it2.hasNext()) {
                Photo$$Parcelable.write(it2.next(), parcel, i2, aVar);
            }
        }
        parcel.writeInt(communityPost.isAnonymous ? 1 : 0);
        parcel.writeInt(communityPost.challengeId);
        parcel.writeInt(communityPost.isCompanyAdmin ? 1 : 0);
        parcel.writeInt(communityPost.isEdit ? 1 : 0);
        parcel.writeInt(communityPost.createPostRequestFrom);
        parcel.writeString(communityPost.createdAt);
        UserBO$$Parcelable.write(communityPost.author, parcel, i2, aVar);
        parcel.writeInt(communityPost.remote_id);
        parcel.writeString(communityPost.title);
        parcel.writeString(communityPost.body);
        parcel.writeString(communityPost.updatedAt);
    }

    public CommunityPost getParcel() {
        return this.communityPost$$0;
    }

    public static CommunityPost read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            CommunityPost communityPost = new CommunityPost();
            aVar.a(a2, communityPost);
            int readInt2 = parcel.readInt();
            ArrayList<Photo> arrayList2 = null;
            boolean z = false;
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(Community$$Parcelable.read(parcel, aVar));
                }
            }
            communityPost.myCommunitiesList = arrayList;
            communityPost.isPostByCommunity = parcel.readInt() == 1;
            communityPost.isChallengeType = parcel.readInt() == 1;
            communityPost.isMyPost = parcel.readInt() == 1;
            communityPost.challengeType = parcel.readString();
            communityPost.challengeHashTag = parcel.readString();
            communityPost.community = Community$$Parcelable.read(parcel, aVar);
            int readInt3 = parcel.readInt();
            if (readInt3 >= 0) {
                arrayList2 = new ArrayList<>(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    arrayList2.add(Photo$$Parcelable.read(parcel, aVar));
                }
            }
            communityPost.photos = arrayList2;
            communityPost.isAnonymous = parcel.readInt() == 1;
            communityPost.challengeId = parcel.readInt();
            communityPost.isCompanyAdmin = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            communityPost.isEdit = z;
            communityPost.createPostRequestFrom = parcel.readInt();
            communityPost.createdAt = parcel.readString();
            communityPost.author = UserBO$$Parcelable.read(parcel, aVar);
            communityPost.remote_id = parcel.readInt();
            communityPost.title = parcel.readString();
            communityPost.body = parcel.readString();
            communityPost.updatedAt = parcel.readString();
            aVar.a(readInt, communityPost);
            return communityPost;
        } else if (!aVar.b(readInt)) {
            return (CommunityPost) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
