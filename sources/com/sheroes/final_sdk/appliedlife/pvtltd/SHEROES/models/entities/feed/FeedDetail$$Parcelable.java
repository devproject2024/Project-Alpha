package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import android.os.Parcel;
import android.os.Parcelable;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment$$Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;
import org.parceler.e;
import org.parceler.f;

public class FeedDetail$$Parcelable implements Parcelable, e<FeedDetail> {
    public static final Parcelable.Creator<FeedDetail$$Parcelable> CREATOR = new Parcelable.Creator<FeedDetail$$Parcelable>() {
        public final FeedDetail$$Parcelable createFromParcel(Parcel parcel) {
            return new FeedDetail$$Parcelable(FeedDetail$$Parcelable.read(parcel, new a()));
        }

        public final FeedDetail$$Parcelable[] newArray(int i2) {
            return new FeedDetail$$Parcelable[i2];
        }
    };
    private FeedDetail feedDetail$$0;

    public int describeContents() {
        return 0;
    }

    public FeedDetail$$Parcelable(FeedDetail feedDetail) {
        this.feedDetail$$0 = feedDetail;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.feedDetail$$0, parcel, i2, new a());
    }

    public static void write(FeedDetail feedDetail, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) feedDetail);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) feedDetail));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorCityName"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "blogLinkUrl"));
        Class cls3 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isBookmarked")).booleanValue() ? 1 : 0);
        Class cls4 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "noOfApplied")).intValue());
        Class<Integer> cls5 = Integer.class;
        if (b.a(FeedDetail.class, feedDetail, "entityOrParticipantTypeId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls6 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "entityOrParticipantTypeId")).intValue());
        }
        Class<String> cls7 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "postingDate"));
        Class<String> cls8 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "type"));
        Class cls9 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isActive")).booleanValue() ? 1 : 0);
        Class cls10 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "noOfChallengeAccepted")).intValue());
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "callFromName"));
        Class<String> cls12 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "deepLinkUrl"));
        Class<String> cls13 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "thumbnailImageUrl"));
        Class<String> cls14 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorLastName"));
        Class<String> cls15 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "streamType"));
        Class<String> cls16 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "ogImageUrlS"));
        Class cls17 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isLongPress")).booleanValue() ? 1 : 0);
        Class cls18 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isSpamPost")).booleanValue() ? 1 : 0);
        Class cls19 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, feedDetail, "authorParticipantId")).longValue());
        Class<String> cls20 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "id"));
        Class cls21 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isFeatured")).booleanValue() ? 1 : 0);
        Class<String> cls22 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorShortDescription"));
        Class<String> cls23 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "mentorDeepLinkUrl"));
        Class cls24 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "noOfLikes")).intValue());
        new b.C0602b();
        if (b.a(FeedDetail.class, feedDetail, "lastComments") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, feedDetail, "lastComments")).size());
            new b.C0602b();
            for (Comment write : (List) b.a(FeedDetail.class, feedDetail, "lastComments")) {
                Comment$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        new b.C0602b();
        if (b.a(FeedDetail.class, feedDetail, "tag_ids") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, feedDetail, "tag_ids")).size());
            new b.C0602b();
            for (Long l : (List) b.a(FeedDetail.class, feedDetail, "tag_ids")) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        Class<String> cls25 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "listShortDescription"));
        Class<String> cls26 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "shortDescription"));
        Class cls27 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isAuthorImagePublic")).booleanValue() ? 1 : 0);
        Class<String> cls28 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "participantDeepLinkingUrl"));
        new b.C0602b();
        if (b.a(FeedDetail.class, feedDetail, "tags") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, feedDetail, "tags")).size());
            new b.C0602b();
            for (String writeString : (List) b.a(FeedDetail.class, feedDetail, "tags")) {
                parcel.writeString(writeString);
            }
        }
        Class cls29 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isAuthorMentor")).booleanValue() ? 1 : 0);
        Class cls30 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isTrending")).booleanValue() ? 1 : 0);
        Class<String> cls31 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorCityId"));
        Class cls32 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, feedDetail, "profileId")).longValue());
        Class<String> cls33 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorName"));
        Class<String> cls34 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "ogRequestedUrlS"));
        Class cls35 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "lastReactionValue")).intValue());
        parcel.writeString(feedDetail.subType);
        Class<String> cls36 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorParticipantType"));
        Class cls37 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "reactedValue")).intValue());
        Class cls38 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isAuthorConfidential")).booleanValue() ? 1 : 0);
        Class cls39 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, feedDetail, "entityOrParticipantId")).longValue());
        Class<Date> cls40 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, feedDetail, "postingDateOnly"));
        Class cls41 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "noOfViews")).intValue());
        Class<String> cls42 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, RequestConfirmationDialogFragment.KEY_DESCRIPTION));
        Class cls43 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isChallengeAccepted")).booleanValue() ? 1 : 0);
        Class cls44 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isViewed")).booleanValue() ? 1 : 0);
        Class<String> cls45 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "nameOrTitle"));
        Class cls46 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "noOfComments")).intValue());
        Class cls47 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isDeleted")).booleanValue() ? 1 : 0);
        Class<String> cls48 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorFirstName"));
        Class<String> cls49 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "imageUrl"));
        Class cls50 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isApplied")).booleanValue() ? 1 : 0);
        Class cls51 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "itemPosition")).intValue());
        Class<String> cls52 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "entityDeepLinkingUrl"));
        Class cls53 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, feedDetail, "idOfEntityOrParticipant")).longValue());
        Class<Date> cls54 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, feedDetail, "lastModifiedDate"));
        Class<String> cls55 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "ogDescriptionS"));
        Class<String> cls56 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "ogTitleS"));
        Class cls57 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, feedDetail, "authorId")).longValue());
        Class cls58 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, feedDetail, "noOfBookmarks")).intValue());
        Class<String> cls59 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "userSubType"));
        Class cls60 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isFromHome")).booleanValue() ? 1 : 0);
        Class<String> cls61 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "createdDate"));
        Class cls62 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isOgVideoLinkB")).booleanValue() ? 1 : 0);
        Class<String> cls63 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "postShortBranchUrls"));
        Class cls64 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, feedDetail, "createdBy")).longValue());
        Class<String> cls65 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "listDescription"));
        Class cls66 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, feedDetail, "isExpired")).booleanValue() ? 1 : 0);
        Class<String> cls67 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, feedDetail, "authorImageUrl"));
        Class cls68 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, feedDetail, "numFound")).intValue());
        Class cls69 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(BaseResponse.class, feedDetail, "start")).intValue());
        new b.C0602b();
        if (b.a(BaseResponse.class, feedDetail, "fieldErrorMessageMap") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((HashMap) b.a(BaseResponse.class, feedDetail, "fieldErrorMessageMap")).size());
            new b.C0602b();
            for (Map.Entry entry : ((HashMap) b.a(BaseResponse.class, feedDetail, "fieldErrorMessageMap")).entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        Class<String> cls70 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, feedDetail, SDKConstants.EVENT_KEY_SCREEN_NAME));
        Class<String> cls71 = String.class;
        parcel.writeString((String) b.a(BaseResponse.class, feedDetail, "status"));
    }

    public FeedDetail getParcel() {
        return this.feedDetail$$0;
    }

    public static FeedDetail read(Parcel parcel, a aVar) {
        Integer num;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Long l;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            FeedDetail feedDetail = new FeedDetail();
            aVar.a(a2, feedDetail);
            b.a(FeedDetail.class, feedDetail, "authorCityName", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "blogLinkUrl", parcel.readString());
            boolean z = true;
            b.a(FeedDetail.class, feedDetail, "isBookmarked", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "noOfApplied", Integer.valueOf(parcel.readInt()));
            HashMap hashMap = null;
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedDetail.class, feedDetail, "entityOrParticipantTypeId", num);
            b.a(FeedDetail.class, feedDetail, "postingDate", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "type", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "noOfChallengeAccepted", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, feedDetail, "callFromName", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "deepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "thumbnailImageUrl", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "authorLastName", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "streamType", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "ogImageUrlS", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isLongPress", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "isSpamPost", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "authorParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, feedDetail, "id", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isFeatured", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "authorShortDescription", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "mentorDeepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "noOfLikes", Integer.valueOf(parcel.readInt()));
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(Comment$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedDetail.class, feedDetail, "lastComments", arrayList);
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
            b.a(FeedDetail.class, feedDetail, "tag_ids", arrayList2);
            b.a(FeedDetail.class, feedDetail, "listShortDescription", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "shortDescription", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isAuthorImagePublic", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "participantDeepLinkingUrl", parcel.readString());
            int readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(readInt4);
                for (int i4 = 0; i4 < readInt4; i4++) {
                    arrayList3.add(parcel.readString());
                }
            }
            b.a(FeedDetail.class, feedDetail, "tags", arrayList3);
            b.a(FeedDetail.class, feedDetail, "isAuthorMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "isTrending", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "authorCityId", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "profileId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, feedDetail, "authorName", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "ogRequestedUrlS", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "lastReactionValue", Integer.valueOf(parcel.readInt()));
            feedDetail.subType = parcel.readString();
            b.a(FeedDetail.class, feedDetail, "authorParticipantType", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "reactedValue", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, feedDetail, "isAuthorConfidential", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "entityOrParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, feedDetail, "postingDateOnly", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, feedDetail, "noOfViews", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, feedDetail, RequestConfirmationDialogFragment.KEY_DESCRIPTION, parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isChallengeAccepted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "isViewed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "nameOrTitle", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "noOfComments", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, feedDetail, "isDeleted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "authorFirstName", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "imageUrl", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isApplied", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "itemPosition", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, feedDetail, "entityDeepLinkingUrl", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "idOfEntityOrParticipant", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, feedDetail, "lastModifiedDate", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, feedDetail, "ogDescriptionS", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "ogTitleS", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "authorId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, feedDetail, "noOfBookmarks", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, feedDetail, "userSubType", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isFromHome", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "createdDate", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "isOgVideoLinkB", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, feedDetail, "postShortBranchUrls", parcel.readString());
            b.a(FeedDetail.class, feedDetail, "createdBy", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, feedDetail, "listDescription", parcel.readString());
            Class<FeedDetail> cls = FeedDetail.class;
            if (parcel.readInt() != 1) {
                z = false;
            }
            b.a(cls, feedDetail, "isExpired", Boolean.valueOf(z));
            b.a(FeedDetail.class, feedDetail, "authorImageUrl", parcel.readString());
            b.a(BaseResponse.class, feedDetail, "numFound", Integer.valueOf(parcel.readInt()));
            b.a(BaseResponse.class, feedDetail, "start", Integer.valueOf(parcel.readInt()));
            int readInt5 = parcel.readInt();
            if (readInt5 >= 0) {
                hashMap = new HashMap(c.a(readInt5));
                for (int i5 = 0; i5 < readInt5; i5++) {
                    hashMap.put(parcel.readString(), parcel.readString());
                }
            }
            b.a(BaseResponse.class, feedDetail, "fieldErrorMessageMap", hashMap);
            b.a(BaseResponse.class, feedDetail, SDKConstants.EVENT_KEY_SCREEN_NAME, parcel.readString());
            b.a(BaseResponse.class, feedDetail, "status", parcel.readString());
            aVar.a(readInt, feedDetail);
            return feedDetail;
        } else if (!aVar.b(readInt)) {
            return (FeedDetail) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
