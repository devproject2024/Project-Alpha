package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment$$Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class ImageSolrObj$$Parcelable implements Parcelable, e<ImageSolrObj> {
    public static final Parcelable.Creator<ImageSolrObj$$Parcelable> CREATOR = new Parcelable.Creator<ImageSolrObj$$Parcelable>() {
        public final ImageSolrObj$$Parcelable createFromParcel(Parcel parcel) {
            return new ImageSolrObj$$Parcelable(ImageSolrObj$$Parcelable.read(parcel, new a()));
        }

        public final ImageSolrObj$$Parcelable[] newArray(int i2) {
            return new ImageSolrObj$$Parcelable[i2];
        }
    };
    private ImageSolrObj imageSolrObj$$0;

    public int describeContents() {
        return 0;
    }

    public ImageSolrObj$$Parcelable(ImageSolrObj imageSolrObj) {
        this.imageSolrObj$$0 = imageSolrObj;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.imageSolrObj$$0, parcel, i2, new a());
    }

    public static void write(ImageSolrObj imageSolrObj, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) imageSolrObj);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) imageSolrObj));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorCityName"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "blogLinkUrl"));
        Class cls3 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isBookmarked")).booleanValue() ? 1 : 0);
        Class cls4 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "noOfApplied")).intValue());
        Class<Integer> cls5 = Integer.class;
        if (b.a(FeedDetail.class, imageSolrObj, "entityOrParticipantTypeId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls6 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "entityOrParticipantTypeId")).intValue());
        }
        Class<String> cls7 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "postingDate"));
        Class<String> cls8 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "type"));
        Class cls9 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isActive")).booleanValue() ? 1 : 0);
        Class cls10 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "noOfChallengeAccepted")).intValue());
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "callFromName"));
        Class<String> cls12 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "deepLinkUrl"));
        Class<String> cls13 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "thumbnailImageUrl"));
        Class<String> cls14 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorLastName"));
        Class<String> cls15 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "streamType"));
        Class<String> cls16 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "ogImageUrlS"));
        Class cls17 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isLongPress")).booleanValue() ? 1 : 0);
        Class cls18 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isSpamPost")).booleanValue() ? 1 : 0);
        Class cls19 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, imageSolrObj, "authorParticipantId")).longValue());
        Class<String> cls20 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "id"));
        Class cls21 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isFeatured")).booleanValue() ? 1 : 0);
        Class<String> cls22 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorShortDescription"));
        Class<String> cls23 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "mentorDeepLinkUrl"));
        Class cls24 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "noOfLikes")).intValue());
        new b.C0602b();
        if (b.a(FeedDetail.class, imageSolrObj, "lastComments") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, imageSolrObj, "lastComments")).size());
            new b.C0602b();
            for (Comment write : (List) b.a(FeedDetail.class, imageSolrObj, "lastComments")) {
                Comment$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        new b.C0602b();
        if (b.a(FeedDetail.class, imageSolrObj, "tag_ids") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, imageSolrObj, "tag_ids")).size());
            new b.C0602b();
            for (Long l : (List) b.a(FeedDetail.class, imageSolrObj, "tag_ids")) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        Class<String> cls25 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "listShortDescription"));
        Class<String> cls26 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "shortDescription"));
        Class cls27 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isAuthorImagePublic")).booleanValue() ? 1 : 0);
        Class<String> cls28 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "participantDeepLinkingUrl"));
        new b.C0602b();
        if (b.a(FeedDetail.class, imageSolrObj, "tags") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, imageSolrObj, "tags")).size());
            new b.C0602b();
            for (String writeString : (List) b.a(FeedDetail.class, imageSolrObj, "tags")) {
                parcel.writeString(writeString);
            }
        }
        Class cls29 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isAuthorMentor")).booleanValue() ? 1 : 0);
        Class cls30 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isTrending")).booleanValue() ? 1 : 0);
        Class<String> cls31 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorCityId"));
        Class cls32 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, imageSolrObj, "profileId")).longValue());
        Class<String> cls33 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorName"));
        Class<String> cls34 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "ogRequestedUrlS"));
        Class cls35 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "lastReactionValue")).intValue());
        parcel.writeString(imageSolrObj.subType);
        Class<String> cls36 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorParticipantType"));
        Class cls37 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "reactedValue")).intValue());
        Class cls38 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isAuthorConfidential")).booleanValue() ? 1 : 0);
        Class cls39 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, imageSolrObj, "entityOrParticipantId")).longValue());
        Class<Date> cls40 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, imageSolrObj, "postingDateOnly"));
        Class cls41 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "noOfViews")).intValue());
        Class<String> cls42 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION));
        Class cls43 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isChallengeAccepted")).booleanValue() ? 1 : 0);
        Class cls44 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isViewed")).booleanValue() ? 1 : 0);
        Class<String> cls45 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "nameOrTitle"));
        Class cls46 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "noOfComments")).intValue());
        Class cls47 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isDeleted")).booleanValue() ? 1 : 0);
        Class<String> cls48 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorFirstName"));
        Class<String> cls49 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "imageUrl"));
        Class cls50 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isApplied")).booleanValue() ? 1 : 0);
        Class cls51 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "itemPosition")).intValue());
        Class<String> cls52 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "entityDeepLinkingUrl"));
        Class cls53 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, imageSolrObj, "idOfEntityOrParticipant")).longValue());
        Class<Date> cls54 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, imageSolrObj, "lastModifiedDate"));
        Class<String> cls55 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "ogDescriptionS"));
        Class<String> cls56 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "ogTitleS"));
        Class cls57 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, imageSolrObj, "authorId")).longValue());
        Class cls58 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, imageSolrObj, "noOfBookmarks")).intValue());
        Class<String> cls59 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "userSubType"));
        Class cls60 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isFromHome")).booleanValue() ? 1 : 0);
        Class<String> cls61 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "createdDate"));
        Class cls62 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isOgVideoLinkB")).booleanValue() ? 1 : 0);
        Class<String> cls63 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "postShortBranchUrls"));
        Class cls64 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, imageSolrObj, "createdBy")).longValue());
        Class<String> cls65 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "listDescription"));
        Class cls66 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, imageSolrObj, "isExpired")).booleanValue() ? 1 : 0);
        Class<String> cls67 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, imageSolrObj, "authorImageUrl"));
    }

    public ImageSolrObj getParcel() {
        return this.imageSolrObj$$0;
    }

    public static ImageSolrObj read(Parcel parcel, a aVar) {
        Integer num;
        ArrayList arrayList;
        ArrayList arrayList2;
        Long l;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            ImageSolrObj imageSolrObj = new ImageSolrObj();
            aVar.a(a2, imageSolrObj);
            b.a(FeedDetail.class, imageSolrObj, "authorCityName", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "blogLinkUrl", parcel.readString());
            boolean z = false;
            b.a(FeedDetail.class, imageSolrObj, "isBookmarked", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "noOfApplied", Integer.valueOf(parcel.readInt()));
            ArrayList arrayList3 = null;
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedDetail.class, imageSolrObj, "entityOrParticipantTypeId", num);
            b.a(FeedDetail.class, imageSolrObj, "postingDate", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "type", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "noOfChallengeAccepted", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, imageSolrObj, "callFromName", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "deepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "thumbnailImageUrl", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "authorLastName", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "streamType", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "ogImageUrlS", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isLongPress", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "isSpamPost", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "authorParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, imageSolrObj, "id", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isFeatured", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "authorShortDescription", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "mentorDeepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "noOfLikes", Integer.valueOf(parcel.readInt()));
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(Comment$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedDetail.class, imageSolrObj, "lastComments", arrayList);
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    if (parcel.readInt() < 0) {
                        l = null;
                    } else {
                        l = Long.valueOf(parcel.readLong());
                    }
                    arrayList2.add(l);
                }
            }
            b.a(FeedDetail.class, imageSolrObj, "tag_ids", arrayList2);
            b.a(FeedDetail.class, imageSolrObj, "listShortDescription", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "shortDescription", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isAuthorImagePublic", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "participantDeepLinkingUrl", parcel.readString());
            int readInt4 = parcel.readInt();
            if (readInt4 >= 0) {
                arrayList3 = new ArrayList(readInt4);
                for (int i4 = 0; i4 < readInt4; i4++) {
                    arrayList3.add(parcel.readString());
                }
            }
            b.a(FeedDetail.class, imageSolrObj, "tags", arrayList3);
            b.a(FeedDetail.class, imageSolrObj, "isAuthorMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "isTrending", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "authorCityId", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "profileId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, imageSolrObj, "authorName", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "ogRequestedUrlS", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "lastReactionValue", Integer.valueOf(parcel.readInt()));
            imageSolrObj.subType = parcel.readString();
            b.a(FeedDetail.class, imageSolrObj, "authorParticipantType", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "reactedValue", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, imageSolrObj, "isAuthorConfidential", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "entityOrParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, imageSolrObj, "postingDateOnly", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, imageSolrObj, "noOfViews", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, imageSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION, parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isChallengeAccepted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "isViewed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "nameOrTitle", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "noOfComments", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, imageSolrObj, "isDeleted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "authorFirstName", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "imageUrl", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isApplied", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "itemPosition", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, imageSolrObj, "entityDeepLinkingUrl", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "idOfEntityOrParticipant", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, imageSolrObj, "lastModifiedDate", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, imageSolrObj, "ogDescriptionS", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "ogTitleS", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "authorId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, imageSolrObj, "noOfBookmarks", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, imageSolrObj, "userSubType", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isFromHome", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "createdDate", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "isOgVideoLinkB", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, imageSolrObj, "postShortBranchUrls", parcel.readString());
            b.a(FeedDetail.class, imageSolrObj, "createdBy", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, imageSolrObj, "listDescription", parcel.readString());
            Class<FeedDetail> cls = FeedDetail.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, imageSolrObj, "isExpired", Boolean.valueOf(z));
            b.a(FeedDetail.class, imageSolrObj, "authorImageUrl", parcel.readString());
            aVar.a(readInt, imageSolrObj);
            return imageSolrObj;
        } else if (!aVar.b(readInt)) {
            return (ImageSolrObj) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
