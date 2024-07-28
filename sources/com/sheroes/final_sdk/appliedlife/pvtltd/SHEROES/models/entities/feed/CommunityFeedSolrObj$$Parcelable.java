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

public class CommunityFeedSolrObj$$Parcelable implements Parcelable, e<CommunityFeedSolrObj> {
    public static final Parcelable.Creator<CommunityFeedSolrObj$$Parcelable> CREATOR = new Parcelable.Creator<CommunityFeedSolrObj$$Parcelable>() {
        public final CommunityFeedSolrObj$$Parcelable createFromParcel(Parcel parcel) {
            return new CommunityFeedSolrObj$$Parcelable(CommunityFeedSolrObj$$Parcelable.read(parcel, new a()));
        }

        public final CommunityFeedSolrObj$$Parcelable[] newArray(int i2) {
            return new CommunityFeedSolrObj$$Parcelable[i2];
        }
    };
    private CommunityFeedSolrObj communityFeedSolrObj$$0;

    public int describeContents() {
        return 0;
    }

    public CommunityFeedSolrObj$$Parcelable(CommunityFeedSolrObj communityFeedSolrObj) {
        this.communityFeedSolrObj$$0 = communityFeedSolrObj;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        write(this.communityFeedSolrObj$$0, parcel, i2, new a());
    }

    public static void write(CommunityFeedSolrObj communityFeedSolrObj, Parcel parcel, int i2, a aVar) {
        int b2 = aVar.b((Object) communityFeedSolrObj);
        if (b2 != -1) {
            parcel.writeInt(b2);
            return;
        }
        parcel.writeInt(aVar.a((Object) communityFeedSolrObj));
        parcel.writeString(communityFeedSolrObj.defaultTabJoinedKey);
        parcel.writeString(communityFeedSolrObj.titleTextColor);
        Class cls = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "mutualCommunityCount")).intValue());
        parcel.writeString(communityFeedSolrObj.newPostHint);
        parcel.writeString(communityFeedSolrObj.communityPrimaryColor);
        Class cls2 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "showHeader")).booleanValue() ? 1 : 0);
        parcel.writeString(communityFeedSolrObj.defaultTabKey);
        Class cls3 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "noOfPendingRequest")).intValue());
        parcel.writeString(communityFeedSolrObj.communitySecondaryColor);
        Class cls4 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isMember")).booleanValue() ? 1 : 0);
        Class cls5 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isRequestPending")).booleanValue() ? 1 : 0);
        parcel.writeString(communityFeedSolrObj.communityType);
        Class cls6 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isOwner")).booleanValue() ? 1 : 0);
        if (communityFeedSolrObj.communityTabs == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(communityFeedSolrObj.communityTabs.size());
            for (CommunityTab write : communityFeedSolrObj.communityTabs) {
                CommunityTab$$Parcelable.write(write, parcel, i2, aVar);
            }
        }
        if (communityFeedSolrObj.communityTypeId == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(communityFeedSolrObj.communityTypeId.longValue());
        }
        Class cls7 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "noOfMembers")).intValue());
        Class cls8 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isMutualCommunityFirstItem")).booleanValue() ? 1 : 0);
        parcel.writeInt(communityFeedSolrObj.isClosedCommunity ? 1 : 0);
        Class cls9 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isOtherCommunityFirstItem")).booleanValue() ? 1 : 0);
        Class<String> cls10 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorCityName"));
        Class<String> cls11 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "blogLinkUrl"));
        Class cls12 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isBookmarked")).booleanValue() ? 1 : 0);
        Class cls13 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "noOfApplied")).intValue());
        Class<Integer> cls14 = Integer.class;
        if (b.a(FeedDetail.class, communityFeedSolrObj, "entityOrParticipantTypeId") == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(1);
            Class<Integer> cls15 = Integer.class;
            parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "entityOrParticipantTypeId")).intValue());
        }
        Class<String> cls16 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "postingDate"));
        Class<String> cls17 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "type"));
        Class cls18 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isActive")).booleanValue() ? 1 : 0);
        Class cls19 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "noOfChallengeAccepted")).intValue());
        Class<String> cls20 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "callFromName"));
        Class<String> cls21 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "deepLinkUrl"));
        Class<String> cls22 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "thumbnailImageUrl"));
        Class<String> cls23 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorLastName"));
        Class<String> cls24 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "streamType"));
        Class<String> cls25 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "ogImageUrlS"));
        Class cls26 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isLongPress")).booleanValue() ? 1 : 0);
        Class cls27 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isSpamPost")).booleanValue() ? 1 : 0);
        Class cls28 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, communityFeedSolrObj, "authorParticipantId")).longValue());
        Class<String> cls29 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "id"));
        Class cls30 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isFeatured")).booleanValue() ? 1 : 0);
        Class<String> cls31 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorShortDescription"));
        Class<String> cls32 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "mentorDeepLinkUrl"));
        Class cls33 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "noOfLikes")).intValue());
        new b.C0602b();
        if (b.a(FeedDetail.class, communityFeedSolrObj, "lastComments") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, communityFeedSolrObj, "lastComments")).size());
            new b.C0602b();
            for (Comment write2 : (List) b.a(FeedDetail.class, communityFeedSolrObj, "lastComments")) {
                Comment$$Parcelable.write(write2, parcel, i2, aVar);
            }
        }
        new b.C0602b();
        if (b.a(FeedDetail.class, communityFeedSolrObj, "tag_ids") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, communityFeedSolrObj, "tag_ids")).size());
            new b.C0602b();
            for (Long l : (List) b.a(FeedDetail.class, communityFeedSolrObj, "tag_ids")) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        Class<String> cls34 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "listShortDescription"));
        Class<String> cls35 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "shortDescription"));
        Class cls36 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isAuthorImagePublic")).booleanValue() ? 1 : 0);
        Class<String> cls37 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "participantDeepLinkingUrl"));
        new b.C0602b();
        if (b.a(FeedDetail.class, communityFeedSolrObj, "tags") == null) {
            parcel.writeInt(-1);
        } else {
            new b.C0602b();
            parcel.writeInt(((List) b.a(FeedDetail.class, communityFeedSolrObj, "tags")).size());
            new b.C0602b();
            for (String writeString : (List) b.a(FeedDetail.class, communityFeedSolrObj, "tags")) {
                parcel.writeString(writeString);
            }
        }
        Class cls38 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isAuthorMentor")).booleanValue() ? 1 : 0);
        Class cls39 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isTrending")).booleanValue() ? 1 : 0);
        Class<String> cls40 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorCityId"));
        Class cls41 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, communityFeedSolrObj, "profileId")).longValue());
        Class<String> cls42 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorName"));
        Class<String> cls43 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "ogRequestedUrlS"));
        Class cls44 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "lastReactionValue")).intValue());
        parcel.writeString(communityFeedSolrObj.subType);
        Class<String> cls45 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorParticipantType"));
        Class cls46 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "reactedValue")).intValue());
        Class cls47 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isAuthorConfidential")).booleanValue() ? 1 : 0);
        Class cls48 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, communityFeedSolrObj, "entityOrParticipantId")).longValue());
        Class<Date> cls49 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, communityFeedSolrObj, "postingDateOnly"));
        Class cls50 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "noOfViews")).intValue());
        Class<String> cls51 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION));
        Class cls52 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isChallengeAccepted")).booleanValue() ? 1 : 0);
        Class cls53 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isViewed")).booleanValue() ? 1 : 0);
        Class<String> cls54 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "nameOrTitle"));
        Class cls55 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "noOfComments")).intValue());
        Class cls56 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isDeleted")).booleanValue() ? 1 : 0);
        Class<String> cls57 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorFirstName"));
        Class<String> cls58 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "imageUrl"));
        Class cls59 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isApplied")).booleanValue() ? 1 : 0);
        Class cls60 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "itemPosition")).intValue());
        Class<String> cls61 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "entityDeepLinkingUrl"));
        Class cls62 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, communityFeedSolrObj, "idOfEntityOrParticipant")).longValue());
        Class<Date> cls63 = Date.class;
        parcel.writeSerializable((Serializable) b.a(FeedDetail.class, communityFeedSolrObj, "lastModifiedDate"));
        Class<String> cls64 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "ogDescriptionS"));
        Class<String> cls65 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "ogTitleS"));
        Class cls66 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, communityFeedSolrObj, "authorId")).longValue());
        Class cls67 = Integer.TYPE;
        parcel.writeInt(((Integer) b.a(FeedDetail.class, communityFeedSolrObj, "noOfBookmarks")).intValue());
        Class<String> cls68 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "userSubType"));
        Class cls69 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isFromHome")).booleanValue() ? 1 : 0);
        Class<String> cls70 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "createdDate"));
        Class cls71 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isOgVideoLinkB")).booleanValue() ? 1 : 0);
        Class<String> cls72 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "postShortBranchUrls"));
        Class cls73 = Long.TYPE;
        parcel.writeLong(((Long) b.a(FeedDetail.class, communityFeedSolrObj, "createdBy")).longValue());
        Class<String> cls74 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "listDescription"));
        Class cls75 = Boolean.TYPE;
        parcel.writeInt(((Boolean) b.a(FeedDetail.class, communityFeedSolrObj, "isExpired")).booleanValue() ? 1 : 0);
        Class<String> cls76 = String.class;
        parcel.writeString((String) b.a(FeedDetail.class, communityFeedSolrObj, "authorImageUrl"));
    }

    public CommunityFeedSolrObj getParcel() {
        return this.communityFeedSolrObj$$0;
    }

    public static CommunityFeedSolrObj read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        Long l;
        Integer num;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Long l2;
        int readInt = parcel.readInt();
        if (!aVar.a(readInt)) {
            int a2 = aVar.a(a.f35791a);
            CommunityFeedSolrObj communityFeedSolrObj = new CommunityFeedSolrObj();
            aVar.a(a2, communityFeedSolrObj);
            communityFeedSolrObj.defaultTabJoinedKey = parcel.readString();
            communityFeedSolrObj.titleTextColor = parcel.readString();
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "mutualCommunityCount", Integer.valueOf(parcel.readInt()));
            communityFeedSolrObj.newPostHint = parcel.readString();
            communityFeedSolrObj.communityPrimaryColor = parcel.readString();
            boolean z = false;
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "showHeader", Boolean.valueOf(parcel.readInt() == 1));
            communityFeedSolrObj.defaultTabKey = parcel.readString();
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "noOfPendingRequest", Integer.valueOf(parcel.readInt()));
            communityFeedSolrObj.communitySecondaryColor = parcel.readString();
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isMember", Boolean.valueOf(parcel.readInt() == 1));
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isRequestPending", Boolean.valueOf(parcel.readInt() == 1));
            communityFeedSolrObj.communityType = parcel.readString();
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isOwner", Boolean.valueOf(parcel.readInt() == 1));
            int readInt2 = parcel.readInt();
            ArrayList arrayList4 = null;
            if (readInt2 < 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    arrayList.add(CommunityTab$$Parcelable.read(parcel, aVar));
                }
            }
            communityFeedSolrObj.communityTabs = arrayList;
            if (parcel.readInt() < 0) {
                l = null;
            } else {
                l = Long.valueOf(parcel.readLong());
            }
            communityFeedSolrObj.communityTypeId = l;
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "noOfMembers", Integer.valueOf(parcel.readInt()));
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isMutualCommunityFirstItem", Boolean.valueOf(parcel.readInt() == 1));
            communityFeedSolrObj.isClosedCommunity = parcel.readInt() == 1;
            b.a(CommunityFeedSolrObj.class, communityFeedSolrObj, "isOtherCommunityFirstItem", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "authorCityName", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "blogLinkUrl", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isBookmarked", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "noOfApplied", Integer.valueOf(parcel.readInt()));
            if (parcel.readInt() < 0) {
                num = null;
            } else {
                num = Integer.valueOf(parcel.readInt());
            }
            b.a(FeedDetail.class, communityFeedSolrObj, "entityOrParticipantTypeId", num);
            b.a(FeedDetail.class, communityFeedSolrObj, "postingDate", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "type", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isActive", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "noOfChallengeAccepted", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, communityFeedSolrObj, "callFromName", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "deepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "thumbnailImageUrl", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "authorLastName", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "streamType", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "ogImageUrlS", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isLongPress", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "isSpamPost", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "authorParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, communityFeedSolrObj, "id", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isFeatured", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "authorShortDescription", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "mentorDeepLinkUrl", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "noOfLikes", Integer.valueOf(parcel.readInt()));
            int readInt3 = parcel.readInt();
            if (readInt3 < 0) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(readInt3);
                for (int i3 = 0; i3 < readInt3; i3++) {
                    arrayList2.add(Comment$$Parcelable.read(parcel, aVar));
                }
            }
            b.a(FeedDetail.class, communityFeedSolrObj, "lastComments", arrayList2);
            int readInt4 = parcel.readInt();
            if (readInt4 < 0) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(readInt4);
                for (int i4 = 0; i4 < readInt4; i4++) {
                    if (parcel.readInt() < 0) {
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(parcel.readLong());
                    }
                    arrayList3.add(l2);
                }
            }
            b.a(FeedDetail.class, communityFeedSolrObj, "tag_ids", arrayList3);
            b.a(FeedDetail.class, communityFeedSolrObj, "listShortDescription", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "shortDescription", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isAuthorImagePublic", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "participantDeepLinkingUrl", parcel.readString());
            int readInt5 = parcel.readInt();
            if (readInt5 >= 0) {
                arrayList4 = new ArrayList(readInt5);
                for (int i5 = 0; i5 < readInt5; i5++) {
                    arrayList4.add(parcel.readString());
                }
            }
            b.a(FeedDetail.class, communityFeedSolrObj, "tags", arrayList4);
            b.a(FeedDetail.class, communityFeedSolrObj, "isAuthorMentor", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "isTrending", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "authorCityId", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "profileId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, communityFeedSolrObj, "authorName", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "ogRequestedUrlS", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "lastReactionValue", Integer.valueOf(parcel.readInt()));
            communityFeedSolrObj.subType = parcel.readString();
            b.a(FeedDetail.class, communityFeedSolrObj, "authorParticipantType", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "reactedValue", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, communityFeedSolrObj, "isAuthorConfidential", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "entityOrParticipantId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, communityFeedSolrObj, "postingDateOnly", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, communityFeedSolrObj, "noOfViews", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, communityFeedSolrObj, RequestConfirmationDialogFragment.KEY_DESCRIPTION, parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isChallengeAccepted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "isViewed", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "nameOrTitle", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "noOfComments", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, communityFeedSolrObj, "isDeleted", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "authorFirstName", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "imageUrl", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isApplied", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "itemPosition", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, communityFeedSolrObj, "entityDeepLinkingUrl", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "idOfEntityOrParticipant", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, communityFeedSolrObj, "lastModifiedDate", (Date) parcel.readSerializable());
            b.a(FeedDetail.class, communityFeedSolrObj, "ogDescriptionS", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "ogTitleS", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "authorId", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, communityFeedSolrObj, "noOfBookmarks", Integer.valueOf(parcel.readInt()));
            b.a(FeedDetail.class, communityFeedSolrObj, "userSubType", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isFromHome", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "createdDate", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "isOgVideoLinkB", Boolean.valueOf(parcel.readInt() == 1));
            b.a(FeedDetail.class, communityFeedSolrObj, "postShortBranchUrls", parcel.readString());
            b.a(FeedDetail.class, communityFeedSolrObj, "createdBy", Long.valueOf(parcel.readLong()));
            b.a(FeedDetail.class, communityFeedSolrObj, "listDescription", parcel.readString());
            Class<FeedDetail> cls = FeedDetail.class;
            if (parcel.readInt() == 1) {
                z = true;
            }
            b.a(cls, communityFeedSolrObj, "isExpired", Boolean.valueOf(z));
            b.a(FeedDetail.class, communityFeedSolrObj, "authorImageUrl", parcel.readString());
            aVar.a(readInt, communityFeedSolrObj);
            return communityFeedSolrObj;
        } else if (!aVar.b(readInt)) {
            return (CommunityFeedSolrObj) aVar.c(readInt);
        } else {
            throw new f("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
