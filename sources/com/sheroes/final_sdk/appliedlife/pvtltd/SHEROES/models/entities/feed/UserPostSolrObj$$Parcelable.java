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

public class UserPostSolrObj$$Parcelable implements Parcelable, e<UserPostSolrObj> {
    public static final Parcelable.Creator<UserPostSolrObj$$Parcelable> CREATOR = new Parcelable.Creator<UserPostSolrObj$$Parcelable>() {
        public final UserPostSolrObj$$Parcelable createFromParcel(Parcel parcel) {
            return new UserPostSolrObj$$Parcelable(UserPostSolrObj$$Parcelable.read(parcel, new a()));
        }

        public final UserPostSolrObj$$Parcelable[] newArray(int i2) {
            return new UserPostSolrObj$$Parcelable[i2];
        }
    };
    private UserPostSolrObj userPostSolrObj$$0;

    public int describeContents() {
        return 0;
    }

    public UserPostSolrObj$$Parcelable(UserPostSolrObj userPostSolrObj) {
        this.userPostSolrObj$$0 = userPostSolrObj;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.userPostSolrObj$$0, parcel, i2, new a());
    }

    public static void write(UserPostSolrObj userPostSolrObj, Parcel parcel, int i2, a aVar) {
        int i3;
        int b2 = aVar.b((Object) userPostSolrObj);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) userPostSolrObj));
        Class cls = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserPostSolrObj.class, userPostSolrObj, "postCommunityClosed")).booleanValue() ? 1 : 0);
        Class cls2 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserPostSolrObj.class, userPostSolrObj, "isCommentAllowed")).booleanValue() ? 1 : 0);
        Class<Integer> cls3 = Integer.class;
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "rating") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls4 = Integer.class;
            parcel.writeInt(((Integer) b.a(UserPostSolrObj.class, userPostSolrObj, "rating")).intValue());
        }
        Class<Long> cls5 = Long.class;
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "commTypeId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls6 = Long.class;
            parcel.writeLong(((Long) b.a(UserPostSolrObj.class, userPostSolrObj, "commTypeId")).longValue());
        }
        Class cls7 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserPostSolrObj.class, userPostSolrObj, "noOfOpenings")).intValue());
        Class cls8 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserPostSolrObj.class, userPostSolrObj, "isCommunityPost")).booleanValue() ? 1 : 0);
        new b.C0602b();
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "imagesIds") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserPostSolrObj.class, userPostSolrObj, "imagesIds")).size());
            new b.C0602b();
            for (Long l : (List) b.a(UserPostSolrObj.class, userPostSolrObj, "imagesIds")) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        Class cls9 = Long.TYPE;
        parcel.writeLong(((Long) b.a(UserPostSolrObj.class, userPostSolrObj, "communityTypeId")).longValue());
        Class<String> cls10 = String.class;
        parcel.writeString((String) b.a(UserPostSolrObj.class, userPostSolrObj, "postCommunityName"));
        Class cls11 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(UserPostSolrObj.class, userPostSolrObj, "isEditOrDelete")).intValue());
        if (userPostSolrObj.communityId == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(userPostSolrObj.communityId.longValue());
        }
        Class<Long> cls12 = Long.class;
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "communityParticipantId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls13 = Long.class;
            parcel.writeLong(((Long) b.a(UserPostSolrObj.class, userPostSolrObj, "communityParticipantId")).longValue());
        }
        if (userPostSolrObj.isTextExpanded == null) {
            i3 = -1;
        } else {
            parcel.writeInt(1);
            i3 = userPostSolrObj.isTextExpanded.booleanValue() ? 1 : 0;
        }
        parcel.writeInt(i3);
        new b.C0602b();
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "imageWidth") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageWidth")).size());
            new b.C0602b();
            for (Integer num : (List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageWidth")) {
                if (num == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(num.intValue());
                }
            }
        }
        Class cls14 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserPostSolrObj.class, userPostSolrObj, "isCommunityOwner")).booleanValue() ? 1 : 0);
        Class<String> cls15 = String.class;
        parcel.writeString((String) b.a(UserPostSolrObj.class, userPostSolrObj, "dispThirdPartyUniqueId"));
        Class<String> cls16 = String.class;
        parcel.writeString((String) b.a(UserPostSolrObj.class, userPostSolrObj, "challengeAcceptPostText"));
        new b.C0602b();
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "imageHeight") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageHeight")).size());
            new b.C0602b();
            for (Integer num2 : (List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageHeight")) {
                if (num2 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(num2.intValue());
                }
            }
        }
        Class<Long> cls17 = Long.class;
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "userPostSourceEntityId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Long> cls18 = Long.class;
            parcel.writeLong(((Long) b.a(UserPostSolrObj.class, userPostSolrObj, "userPostSourceEntityId")).longValue());
        }
        new b.C0602b();
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "imageRatio") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageRatio")).size());
            new b.C0602b();
            for (Double d2 : (List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageRatio")) {
                if (d2 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeDouble(d2.doubleValue());
                }
            }
        }
        Class cls19 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserPostSolrObj.class, userPostSolrObj, "isAnonymous")).booleanValue() ? 1 : 0);
        Class<String> cls20 = String.class;
        parcel.writeString((String) b.a(UserPostSolrObj.class, userPostSolrObj, "sourceType"));
        Class cls21 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserPostSolrObj.class, userPostSolrObj, "isTopPost")).booleanValue() ? 1 : 0);
        new b.C0602b();
        if (b.a(UserPostSolrObj.class, userPostSolrObj, "imageUrls") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageUrls")).size());
            new b.C0602b();
            for (String writeString : (List) b.a(UserPostSolrObj.class, userPostSolrObj, "imageUrls")) {
                parcel.writeString(writeString);
            }
        }
        Class<String> cls22 = String.class;
        parcel.writeString((String) b.a(UserPostSolrObj.class, userPostSolrObj, "postCommunityLogo"));
        Class cls23 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(UserPostSolrObj.class, userPostSolrObj, "isClosedCommunity")).booleanValue() ? 1 : 0);
        Class<String> cls24 = String.class;
        parcel.writeString((String) b.a(UserPostSolrObj.class, userPostSolrObj, "entityStartDate"));
        Class<String> cls25 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorCityName"));
        Class<String> cls26 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "blogLinkUrl"));
        Class cls27 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isBookmarked")).booleanValue() ? 1 : 0);
        Class cls28 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "noOfApplied")).intValue());
        Class<Integer> cls29 = Integer.class;
        if (b.a(FeedDetail.class, userPostSolrObj, "entityOrParticipantTypeId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls30 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "entityOrParticipantTypeId")).intValue());
        }
        Class<String> cls31 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "postingDate"));
        Class<String> cls32 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "type"));
        Class cls33 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isActive")).booleanValue() ? 1 : 0);
        Class cls34 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "noOfChallengeAccepted")).intValue());
        Class<String> cls35 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "callFromName"));
        Class<String> cls36 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "deepLinkUrl"));
        Class<String> cls37 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "thumbnailImageUrl"));
        Class<String> cls38 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorLastName"));
        Class<String> cls39 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "streamType"));
        Class<String> cls40 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "ogImageUrlS"));
        Class cls41 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isLongPress")).booleanValue() ? 1 : 0);
        Class cls42 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isSpamPost")).booleanValue() ? 1 : 0);
        Class cls43 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userPostSolrObj, "authorParticipantId")).longValue());
        Class<String> cls44 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "id"));
        Class cls45 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isFeatured")).booleanValue() ? 1 : 0);
        Class<String> cls46 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorShortDescription"));
        Class<String> cls47 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "mentorDeepLinkUrl"));
        Class cls48 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "noOfLikes")).intValue());
        new b.C0602b();
        if (b.a(FeedDetail.class, userPostSolrObj, "lastComments") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, userPostSolrObj, "lastComments")).size());
            new b.C0602b();
            for (Comment write : (List) b.a(FeedDetail.class, userPostSolrObj, "lastComments")) {
                Comment$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        new b.C0602b();
        if (b.a(FeedDetail.class, userPostSolrObj, "tag_ids") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, userPostSolrObj, "tag_ids")).size());
            new b.C0602b();
            for (Long l2 : (List) b.a(FeedDetail.class, userPostSolrObj, "tag_ids")) {
                if (l2 == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l2.longValue());
                }
            }
        }
        Class<String> cls49 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "listShortDescription"));
        Class<String> cls50 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "shortDescription"));
        Class cls51 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isAuthorImagePublic")).booleanValue() ? 1 : 0);
        Class<String> cls52 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "participantDeepLinkingUrl"));
        new b.C0602b();
        if (b.a(FeedDetail.class, userPostSolrObj, "tags") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, userPostSolrObj, "tags")).size());
            new b.C0602b();
            for (String writeString2 : (List) b.a(FeedDetail.class, userPostSolrObj, "tags")) {
                parcel.writeString(writeString2);
            }
        }
        Class cls53 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isAuthorMentor")).booleanValue() ? 1 : 0);
        Class cls54 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isTrending")).booleanValue() ? 1 : 0);
        Class<String> cls55 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorCityId"));
        Class cls56 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userPostSolrObj, "profileId")).longValue());
        Class<String> cls57 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorName"));
        Class<String> cls58 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "ogRequestedUrlS"));
        Class cls59 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "lastReactionValue")).intValue());
        parcel.writeString(userPostSolrObj.subType);
        Class<String> cls60 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorParticipantType"));
        Class cls61 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "reactedValue")).intValue());
        Class cls62 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isAuthorConfidential")).booleanValue() ? 1 : 0);
        Class cls63 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userPostSolrObj, "entityOrParticipantId")).longValue());
        Class<Date> cls64 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, userPostSolrObj, "postingDateOnly"));
        Class cls65 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "noOfViews")).intValue());
        Class<String> cls66 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION));
        Class cls67 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isChallengeAccepted")).booleanValue() ? 1 : 0);
        Class cls68 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isViewed")).booleanValue() ? 1 : 0);
        Class<String> cls69 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "nameOrTitle"));
        Class cls70 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "noOfComments")).intValue());
        Class cls71 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isDeleted")).booleanValue() ? 1 : 0);
        Class<String> cls72 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorFirstName"));
        Class<String> cls73 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "imageUrl"));
        Class cls74 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isApplied")).booleanValue() ? 1 : 0);
        Class cls75 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "itemPosition")).intValue());
        Class<String> cls76 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "entityDeepLinkingUrl"));
        Class cls77 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userPostSolrObj, "idOfEntityOrParticipant")).longValue());
        Class<Date> cls78 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, userPostSolrObj, "lastModifiedDate"));
        Class<String> cls79 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "ogDescriptionS"));
        Class<String> cls80 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "ogTitleS"));
        Class cls81 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userPostSolrObj, "authorId")).longValue());
        Class cls82 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, userPostSolrObj, "noOfBookmarks")).intValue());
        Class<String> cls83 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "userSubType"));
        Class cls84 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isFromHome")).booleanValue() ? 1 : 0);
        Class<String> cls85 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "createdDate"));
        Class cls86 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isOgVideoLinkB")).booleanValue() ? 1 : 0);
        Class<String> cls87 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "postShortBranchUrls"));
        Class cls88 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, userPostSolrObj, "createdBy")).longValue());
        Class<String> cls89 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "listDescription"));
        Class cls90 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, userPostSolrObj, "isExpired")).booleanValue() ? 1 : 0);
        Class<String> cls91 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, userPostSolrObj, "authorImageUrl"));
    }

    public UserPostSolrObj getParcel() {
        return this.userPostSolrObj$$0;
    }

    public static UserPostSolrObj read(Parcel parcel, a aVar) {
        Integer num;
        Long l;
        ArrayList arrayList;
        Long l2;
        Long l3;
        Boolean bool;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Long l4;
        ArrayList arrayList4;
        ArrayList arrayList5;
        Integer num2;
        ArrayList arrayList6;
        ArrayList arrayList7;
        Long l5;
        Double d2;
        Integer num3;
        Integer num4;
        Long l6;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            UserPostSolrObj userPostSolrObj = new UserPostSolrObj();
            aVar.a(a2, userPostSolrObj);
            boolean z = false;
            b.a(UserPostSolrObj.class, userPostSolrObj, "postCommunityClosed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserPostSolrObj.class, userPostSolrObj, "isCommentAllowed", Boolean.valueOf(parcel.readInt() == 1));
            ArrayList arrayList8 = null;
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "rating", num);
            if (parcel.readInt() < 0) {
                l = null;
            } else {
                l = Long.valueOf(parcel.readLong());
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "commTypeId", l);
            b.a(UserPostSolrObj.class, userPostSolrObj, "noOfOpenings", Integer.valueOf(parcel.readInt()));
            b.a(UserPostSolrObj.class, userPostSolrObj, "isCommunityPost", Boolean.valueOf(parcel.readInt() == 1));
            int readInt2 = parcel.readInt();
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    if (parcel.readInt() < 0) {
                        l6 = null;
                    } else {
                        l6 = Long.valueOf(parcel.readLong());
                    }
                    arrayList.add(l6);
                }
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "imagesIds", arrayList);
            b.a(UserPostSolrObj.class, userPostSolrObj, "communityTypeId", Long.valueOf(parcel.readLong()));
            b.a(UserPostSolrObj.class, userPostSolrObj, "postCommunityName", parcel.readString());
            b.a(UserPostSolrObj.class, userPostSolrObj, "isEditOrDelete", Integer.valueOf(parcel.readInt()));
            if (parcel.readInt() < 0) {
                l2 = null;
            } else {
                l2 = Long.valueOf(parcel.readLong());
            }
            userPostSolrObj.communityId = l2;
            if (parcel.readInt() < 0) {
                l3 = null;
            } else {
                l3 = Long.valueOf(parcel.readLong());
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "communityParticipantId", l3);
            if (parcel.readInt() < 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() == 1);
            }
            userPostSolrObj.isTextExpanded = bool;
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    if (parcel.readInt() < 0) {
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(parcel.readInt());
                    }
                    arrayList2.add(num4);
                }
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "imageWidth", arrayList2);
            b.a(UserPostSolrObj.class, userPostSolrObj, "isCommunityOwner", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserPostSolrObj.class, userPostSolrObj, "dispThirdPartyUniqueId", parcel.readString());
            b.a(UserPostSolrObj.class, userPostSolrObj, "challengeAcceptPostText", parcel.readString());
            int readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(readInt4);
                for (int i4 = 0; i4 < readInt4; i4++) {
                    if (parcel.readInt() < 0) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(parcel.readInt());
                    }
                    arrayList3.add(num3);
                }
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "imageHeight", arrayList3);
            if (parcel.readInt() < 0) {
                l4 = null;
            } else {
                l4 = Long.valueOf(parcel.readLong());
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "userPostSourceEntityId", l4);
            int readInt5 = parcel.readInt();
            if (readInt5 < 0) {
                arrayList4 = null;
            } else {
                arrayList4 = new ArrayList(readInt5);
                for (int i5 = 0; i5 < readInt5; i5++) {
                    if (parcel.readInt() < 0) {
                        d2 = null;
                    } else {
                        d2 = Double.valueOf(parcel.readDouble());
                    }
                    arrayList4.add(d2);
                }
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "imageRatio", arrayList4);
            b.a(UserPostSolrObj.class, userPostSolrObj, "isAnonymous", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserPostSolrObj.class, userPostSolrObj, "sourceType", parcel.readString());
            b.a(UserPostSolrObj.class, userPostSolrObj, "isTopPost", Boolean.valueOf(parcel.readInt() == 1));
            int readInt6 = parcel.readInt();
            if (readInt6 < 0) {
                arrayList5 = null;
            } else {
                arrayList5 = new ArrayList(readInt6);
                for (int i6 = 0; i6 < readInt6; i6++) {
                    arrayList5.add(parcel.readString());
                }
            }
            b.a(UserPostSolrObj.class, userPostSolrObj, "imageUrls", arrayList5);
            b.a(UserPostSolrObj.class, userPostSolrObj, "postCommunityLogo", parcel.readString());
            b.a(UserPostSolrObj.class, userPostSolrObj, "isClosedCommunity", Boolean.valueOf(parcel.readInt() == 1));
            b.a(UserPostSolrObj.class, userPostSolrObj, "entityStartDate", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "authorCityName", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "blogLinkUrl", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isBookmarked", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "noOfApplied", Integer.valueOf(parcel.readInt()));
            if (parcel.readInt() < 0) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedDetail.class, userPostSolrObj, "entityOrParticipantTypeId", num2);
            b.a(FeedDetail.class, userPostSolrObj, "postingDate", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "type", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "noOfChallengeAccepted", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userPostSolrObj, "callFromName", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "deepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "thumbnailImageUrl", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "authorLastName", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "streamType", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "ogImageUrlS", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isLongPress", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "isSpamPost", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "authorParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userPostSolrObj, "id", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isFeatured", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "authorShortDescription", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "mentorDeepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "noOfLikes", Integer.valueOf(parcel.readInt()));
            int readInt7 = parcel.readInt();
            if (readInt7 < 0) {
                arrayList6 = null;
            } else {
                arrayList6 = new ArrayList(readInt7);
                for (int i7 = 0; i7 < readInt7; i7++) {
                    arrayList6.add(Comment$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedDetail.class, userPostSolrObj, "lastComments", arrayList6);
            int readInt8 = parcel.readInt();
            if (readInt8 < 0) {
                arrayList7 = null;
            } else {
                arrayList7 = new ArrayList(readInt8);
                for (int i8 = 0; i8 < readInt8; i8++) {
                    if (parcel.readInt() < 0) {
                        l5 = null;
                    } else {
                        l5 = Long.valueOf(parcel.readLong());
                    }
                    arrayList7.add(l5);
                }
            }
            b.a(FeedDetail.class, userPostSolrObj, "tag_ids", arrayList7);
            b.a(FeedDetail.class, userPostSolrObj, "listShortDescription", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "shortDescription", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isAuthorImagePublic", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "participantDeepLinkingUrl", parcel.readString());
            int readInt9 = parcel.readInt();
            if (readInt9 >= 0) {
                arrayList8 = new ArrayList(readInt9);
                for (int i9 = 0; i9 < readInt9; i9++) {
                    arrayList8.add(parcel.readString());
                }
            }
            b.a(FeedDetail.class, userPostSolrObj, "tags", arrayList8);
            b.a(FeedDetail.class, userPostSolrObj, "isAuthorMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "isTrending", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "authorCityId", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "profileId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userPostSolrObj, "authorName", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "ogRequestedUrlS", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "lastReactionValue", Integer.valueOf(parcel.readInt()));
            userPostSolrObj.subType = parcel.readString();
            b.a(FeedDetail.class, userPostSolrObj, "authorParticipantType", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "reactedValue", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userPostSolrObj, "isAuthorConfidential", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "entityOrParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userPostSolrObj, "postingDateOnly", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, userPostSolrObj, "noOfViews", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userPostSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION, parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isChallengeAccepted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "isViewed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "nameOrTitle", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "noOfComments", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userPostSolrObj, "isDeleted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "authorFirstName", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "imageUrl", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isApplied", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "itemPosition", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userPostSolrObj, "entityDeepLinkingUrl", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "idOfEntityOrParticipant", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userPostSolrObj, "lastModifiedDate", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, userPostSolrObj, "ogDescriptionS", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "ogTitleS", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "authorId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userPostSolrObj, "noOfBookmarks", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, userPostSolrObj, "userSubType", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isFromHome", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "createdDate", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "isOgVideoLinkB", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, userPostSolrObj, "postShortBranchUrls", parcel.readString());
            b.a(FeedDetail.class, userPostSolrObj, "createdBy", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, userPostSolrObj, "listDescription", parcel.readString());
            Class<FeedDetail> cls = FeedDetail.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, userPostSolrObj, "isExpired", Boolean.valueOf(z));
            b.a(FeedDetail.class, userPostSolrObj, "authorImageUrl", parcel.readString());
            aVar.a(readInt, userPostSolrObj);
            return userPostSolrObj;
        } else if (!aVar.b(readInt)) {
            return (UserPostSolrObj) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
