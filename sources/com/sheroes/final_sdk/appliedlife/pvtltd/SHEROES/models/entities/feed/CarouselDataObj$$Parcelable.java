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
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.parceler.a;
import org.parceler.b;
import org.parceler.e;
import org.parceler.f;

public class CarouselDataObj$$Parcelable implements Parcelable, e<CarouselDataObj> {
    public static final Parcelable.Creator<CarouselDataObj$$Parcelable> CREATOR = new Parcelable.Creator<CarouselDataObj$$Parcelable>() {
        public final CarouselDataObj$$Parcelable createFromParcel(Parcel parcel) {
            return new CarouselDataObj$$Parcelable(CarouselDataObj$$Parcelable.read(parcel, new a()));
        }

        public final CarouselDataObj$$Parcelable[] newArray(int i2) {
            return new CarouselDataObj$$Parcelable[i2];
        }
    };
    private CarouselDataObj carouselDataObj$$0;

    public int describeContents() {
        return 0;
    }

    public CarouselDataObj$$Parcelable(CarouselDataObj carouselDataObj) {
        this.carouselDataObj$$0 = carouselDataObj;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.carouselDataObj$$0, parcel, i2, new a());
    }

    public static void write(CarouselDataObj carouselDataObj, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) carouselDataObj);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) carouselDataObj));
        Class<String> cls = String.class;
        parcel.writeString((String) b.a(CarouselDataObj.class, carouselDataObj, "screenTitle"));
        Class<String> cls2 = String.class;
        parcel.writeString((String) b.a(CarouselDataObj.class, carouselDataObj, SDKConstants.ICON_URL));
        new b.C0602b();
        if (b.a(CarouselDataObj.class, carouselDataObj, "feedDetails") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(CarouselDataObj.class, carouselDataObj, "feedDetails")).size());
            new b.C0602b();
            for (FeedDetail write : (List) b.a(CarouselDataObj.class, carouselDataObj, "feedDetails")) {
                FeedDetail$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        Class<String> cls3 = String.class;
        parcel.writeString((String) b.a(CarouselDataObj.class, carouselDataObj, "title"));
        Class<String> cls4 = String.class;
        parcel.writeString((String) b.a(CarouselDataObj.class, carouselDataObj, "body"));
        Class<String> cls5 = String.class;
        parcel.writeString((String) b.a(CarouselDataObj.class, carouselDataObj, "endPointUrl"));
        Class<String> cls6 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorCityName"));
        Class<String> cls7 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "blogLinkUrl"));
        Class cls8 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isBookmarked")).booleanValue() ? 1 : 0);
        Class cls9 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "noOfApplied")).intValue());
        Class<Integer> cls10 = Integer.class;
        if (b.a(FeedDetail.class, carouselDataObj, "entityOrParticipantTypeId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls11 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "entityOrParticipantTypeId")).intValue());
        }
        Class<String> cls12 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "postingDate"));
        Class<String> cls13 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "type"));
        Class cls14 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isActive")).booleanValue() ? 1 : 0);
        Class cls15 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "noOfChallengeAccepted")).intValue());
        Class<String> cls16 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "callFromName"));
        Class<String> cls17 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "deepLinkUrl"));
        Class<String> cls18 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "thumbnailImageUrl"));
        Class<String> cls19 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorLastName"));
        Class<String> cls20 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "streamType"));
        Class<String> cls21 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "ogImageUrlS"));
        Class cls22 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isLongPress")).booleanValue() ? 1 : 0);
        Class cls23 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isSpamPost")).booleanValue() ? 1 : 0);
        Class cls24 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, carouselDataObj, "authorParticipantId")).longValue());
        Class<String> cls25 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "id"));
        Class cls26 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isFeatured")).booleanValue() ? 1 : 0);
        Class<String> cls27 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorShortDescription"));
        Class<String> cls28 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "mentorDeepLinkUrl"));
        Class cls29 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "noOfLikes")).intValue());
        new b.C0602b();
        if (b.a(FeedDetail.class, carouselDataObj, "lastComments") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, carouselDataObj, "lastComments")).size());
            new b.C0602b();
            for (Comment write2 : (List) b.a(FeedDetail.class, carouselDataObj, "lastComments")) {
                Comment$$Parcelable.write(write2, parcel, i2, aVar);
            }
        }
        new b.C0602b();
        if (b.a(FeedDetail.class, carouselDataObj, "tag_ids") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, carouselDataObj, "tag_ids")).size());
            new b.C0602b();
            for (Long l : (List) b.a(FeedDetail.class, carouselDataObj, "tag_ids")) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        Class<String> cls30 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "listShortDescription"));
        Class<String> cls31 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "shortDescription"));
        Class cls32 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isAuthorImagePublic")).booleanValue() ? 1 : 0);
        Class<String> cls33 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "participantDeepLinkingUrl"));
        new b.C0602b();
        if (b.a(FeedDetail.class, carouselDataObj, "tags") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, carouselDataObj, "tags")).size());
            new b.C0602b();
            for (String writeString : (List) b.a(FeedDetail.class, carouselDataObj, "tags")) {
                parcel.writeString(writeString);
            }
        }
        Class cls34 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isAuthorMentor")).booleanValue() ? 1 : 0);
        Class cls35 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isTrending")).booleanValue() ? 1 : 0);
        Class<String> cls36 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorCityId"));
        Class cls37 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, carouselDataObj, "profileId")).longValue());
        Class<String> cls38 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorName"));
        Class<String> cls39 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "ogRequestedUrlS"));
        Class cls40 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "lastReactionValue")).intValue());
        parcel.writeString(carouselDataObj.subType);
        Class<String> cls41 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorParticipantType"));
        Class cls42 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "reactedValue")).intValue());
        Class cls43 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isAuthorConfidential")).booleanValue() ? 1 : 0);
        Class cls44 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, carouselDataObj, "entityOrParticipantId")).longValue());
        Class<Date> cls45 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, carouselDataObj, "postingDateOnly"));
        Class cls46 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "noOfViews")).intValue());
        Class<String> cls47 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION));
        Class cls48 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isChallengeAccepted")).booleanValue() ? 1 : 0);
        Class cls49 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isViewed")).booleanValue() ? 1 : 0);
        Class<String> cls50 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "nameOrTitle"));
        Class cls51 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "noOfComments")).intValue());
        Class cls52 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isDeleted")).booleanValue() ? 1 : 0);
        Class<String> cls53 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorFirstName"));
        Class<String> cls54 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "imageUrl"));
        Class cls55 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isApplied")).booleanValue() ? 1 : 0);
        Class cls56 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "itemPosition")).intValue());
        Class<String> cls57 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "entityDeepLinkingUrl"));
        Class cls58 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, carouselDataObj, "idOfEntityOrParticipant")).longValue());
        Class<Date> cls59 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, carouselDataObj, "lastModifiedDate"));
        Class<String> cls60 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "ogDescriptionS"));
        Class<String> cls61 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "ogTitleS"));
        Class cls62 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, carouselDataObj, "authorId")).longValue());
        Class cls63 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, carouselDataObj, "noOfBookmarks")).intValue());
        Class<String> cls64 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "userSubType"));
        Class cls65 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isFromHome")).booleanValue() ? 1 : 0);
        Class<String> cls66 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "createdDate"));
        Class cls67 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isOgVideoLinkB")).booleanValue() ? 1 : 0);
        Class<String> cls68 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "postShortBranchUrls"));
        Class cls69 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, carouselDataObj, "createdBy")).longValue());
        Class<String> cls70 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "listDescription"));
        Class cls71 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, carouselDataObj, "isExpired")).booleanValue() ? 1 : 0);
        Class<String> cls72 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, carouselDataObj, "authorImageUrl"));
    }

    public CarouselDataObj getParcel() {
        return this.carouselDataObj$$0;
    }

    public static CarouselDataObj read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        Integer num;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Long l;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            CarouselDataObj carouselDataObj = new CarouselDataObj();
            aVar.a(a2, carouselDataObj);
            b.a(CarouselDataObj.class, carouselDataObj, "screenTitle", parcel.readString());
            b.a(CarouselDataObj.class, carouselDataObj, SDKConstants.ICON_URL, parcel.readString());
            int readInt2 = parcel.readInt();
            ArrayList arrayList4 = null;
            boolean z = false;
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(FeedDetail$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(CarouselDataObj.class, carouselDataObj, "feedDetails", arrayList);
            b.a(CarouselDataObj.class, carouselDataObj, "title", parcel.readString());
            b.a(CarouselDataObj.class, carouselDataObj, "body", parcel.readString());
            b.a(CarouselDataObj.class, carouselDataObj, "endPointUrl", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "authorCityName", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "blogLinkUrl", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isBookmarked", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "noOfApplied", Integer.valueOf(parcel.readInt()));
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedDetail.class, carouselDataObj, "entityOrParticipantTypeId", num);
            b.a(FeedDetail.class, carouselDataObj, "postingDate", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "type", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "noOfChallengeAccepted", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, carouselDataObj, "callFromName", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "deepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "thumbnailImageUrl", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "authorLastName", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "streamType", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "ogImageUrlS", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isLongPress", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "isSpamPost", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "authorParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, carouselDataObj, "id", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isFeatured", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "authorShortDescription", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "mentorDeepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "noOfLikes", Integer.valueOf(parcel.readInt()));
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    arrayList2.add(Comment$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedDetail.class, carouselDataObj, "lastComments", arrayList2);
            int readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(readInt4);
                for (int i4 = 0; i4 < readInt4; i4++) {
                    if (parcel.readInt() < 0) {
                        l = null;
                    } else {
                        l = Long.valueOf(parcel.readLong());
                    }
                    arrayList3.add(l);
                }
            }
            b.a(FeedDetail.class, carouselDataObj, "tag_ids", arrayList3);
            b.a(FeedDetail.class, carouselDataObj, "listShortDescription", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "shortDescription", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isAuthorImagePublic", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "participantDeepLinkingUrl", parcel.readString());
            int readInt5 = parcel.readInt();
            if (readInt5 >= 0) {
                arrayList4 = new ArrayList(readInt5);
                for (int i5 = 0; i5 < readInt5; i5++) {
                    arrayList4.add(parcel.readString());
                }
            }
            b.a(FeedDetail.class, carouselDataObj, "tags", arrayList4);
            b.a(FeedDetail.class, carouselDataObj, "isAuthorMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "isTrending", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "authorCityId", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "profileId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, carouselDataObj, "authorName", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "ogRequestedUrlS", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "lastReactionValue", Integer.valueOf(parcel.readInt()));
            carouselDataObj.subType = parcel.readString();
            b.a(FeedDetail.class, carouselDataObj, "authorParticipantType", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "reactedValue", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, carouselDataObj, "isAuthorConfidential", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "entityOrParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, carouselDataObj, "postingDateOnly", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, carouselDataObj, "noOfViews", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, carouselDataObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION, parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isChallengeAccepted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "isViewed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "nameOrTitle", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "noOfComments", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, carouselDataObj, "isDeleted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "authorFirstName", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "imageUrl", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isApplied", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "itemPosition", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, carouselDataObj, "entityDeepLinkingUrl", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "idOfEntityOrParticipant", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, carouselDataObj, "lastModifiedDate", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, carouselDataObj, "ogDescriptionS", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "ogTitleS", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "authorId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, carouselDataObj, "noOfBookmarks", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, carouselDataObj, "userSubType", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isFromHome", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "createdDate", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "isOgVideoLinkB", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, carouselDataObj, "postShortBranchUrls", parcel.readString());
            b.a(FeedDetail.class, carouselDataObj, "createdBy", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, carouselDataObj, "listDescription", parcel.readString());
            Class<FeedDetail> cls = FeedDetail.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, carouselDataObj, "isExpired", Boolean.valueOf(z));
            b.a(FeedDetail.class, carouselDataObj, "authorImageUrl", parcel.readString());
            aVar.a(readInt, carouselDataObj);
            return carouselDataObj;
        } else if (!aVar.b(readInt)) {
            return (CarouselDataObj) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
