package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class FeedOfFeed implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String buckets;
    private final Boolean canComment;
    private boolean canFollow;
    private final boolean canLike;
    private final Boolean canShare;
    private int category;
    @c(a = "commentCountValue")
    private final Integer commentCount;
    private String commentCountDisplay;
    private String contentFormat;
    private String createdAt;
    @c(a = "publisher")
    private final CreatedBy createdBy;
    private String ctaDisplayText;
    private String ctaImageUrl;
    private final String deepLink;
    private final String description;
    private String displayTime;
    private final Integer duration;
    private int feedItemCategoryRank;
    private int feedItemRank;
    private String feedItemType;
    private int following;
    private int followingRank;
    private String groupId;
    private final String height;
    private String id;
    private final String imageUrl;
    private boolean isBookmarked;
    private Boolean isFlaggedByUser;
    private boolean isFollowed;
    private final Boolean isLiked;
    private final Boolean isSensitive;
    @c(a = "likeCountValue")
    private final Integer likeCount;
    private String likeCountDisplay;
    private String mlCategory;
    private final MlProperties mlProperties;
    private String mlVersion;
    private boolean mute;
    private final String poweredBy;
    private int profileRank;
    private int rank;
    private Double score;
    @c(a = "shareCountValue")
    private final Integer shareCount;
    private String shareCountDisplay;
    private final String streamUrl;
    private final String title;
    private int uiId;
    private final Integer viewCount;
    private final String webUrl;
    private final String width;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Boolean bool4;
            Boolean bool5;
            Parcel parcel2 = parcel;
            k.c(parcel2, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            int readInt2 = parcel.readInt();
            CreatedBy createdBy = (CreatedBy) parcel2.readParcelable(FeedOfFeed.class.getClassLoader());
            MlProperties mlProperties = parcel.readInt() != 0 ? (MlProperties) MlProperties.CREATOR.createFromParcel(parcel2) : null;
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf3 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            Integer valueOf4 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf5 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool2 = null;
            }
            if (parcel.readInt() != 0) {
                bool3 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool3 = null;
            }
            if (parcel.readInt() != 0) {
                bool4 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool4 = null;
            }
            if (parcel.readInt() != 0) {
                bool5 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool5 = null;
            }
            return new FeedOfFeed(readString, readInt, readString2, readInt2, createdBy, mlProperties, readString3, readString4, readString5, readString6, readString7, readString8, readString9, valueOf, valueOf2, valueOf3, bool, readString10, readString11, readString12, valueOf4, valueOf5, z, bool2, bool3, bool4, bool5, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedOfFeed[i2];
        }
    }

    public static /* synthetic */ FeedOfFeed copy$default(FeedOfFeed feedOfFeed, String str, int i2, String str2, int i3, CreatedBy createdBy2, MlProperties mlProperties2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, Boolean bool, String str10, String str11, String str12, Integer num4, Integer num5, boolean z, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str13, int i4, int i5, boolean z2, boolean z3, boolean z4, boolean z5, String str14, String str15, String str16, String str17, String str18, int i6, int i7, int i8, String str19, String str20, String str21, Double d2, int i9, String str22, String str23, int i10, int i11, Object obj) {
        FeedOfFeed feedOfFeed2 = feedOfFeed;
        int i12 = i10;
        int i13 = i11;
        return feedOfFeed.copy((i12 & 1) != 0 ? feedOfFeed2.id : str, (i12 & 2) != 0 ? feedOfFeed2.uiId : i2, (i12 & 4) != 0 ? feedOfFeed2.groupId : str2, (i12 & 8) != 0 ? feedOfFeed2.rank : i3, (i12 & 16) != 0 ? feedOfFeed2.createdBy : createdBy2, (i12 & 32) != 0 ? feedOfFeed2.mlProperties : mlProperties2, (i12 & 64) != 0 ? feedOfFeed2.poweredBy : str3, (i12 & 128) != 0 ? feedOfFeed2.createdAt : str4, (i12 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? feedOfFeed2.imageUrl : str5, (i12 & 512) != 0 ? feedOfFeed2.width : str6, (i12 & TarConstants.EOF_BLOCK) != 0 ? feedOfFeed2.height : str7, (i12 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? feedOfFeed2.title : str8, (i12 & 4096) != 0 ? feedOfFeed2.webUrl : str9, (i12 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? feedOfFeed2.likeCount : num, (i12 & 16384) != 0 ? feedOfFeed2.commentCount : num2, (i12 & 32768) != 0 ? feedOfFeed2.shareCount : num3, (i12 & 65536) != 0 ? feedOfFeed2.isLiked : bool, (i12 & 131072) != 0 ? feedOfFeed2.description : str10, (i12 & 262144) != 0 ? feedOfFeed2.displayTime : str11, (i12 & 524288) != 0 ? feedOfFeed2.streamUrl : str12, (i12 & 1048576) != 0 ? feedOfFeed2.duration : num4, (i12 & 2097152) != 0 ? feedOfFeed2.viewCount : num5, (i12 & 4194304) != 0 ? feedOfFeed2.canLike : z, (i12 & 8388608) != 0 ? feedOfFeed2.canComment : bool2, (i12 & 16777216) != 0 ? feedOfFeed2.canShare : bool3, (i12 & 33554432) != 0 ? feedOfFeed2.isSensitive : bool4, (i12 & 67108864) != 0 ? feedOfFeed2.isFlaggedByUser : bool5, (i12 & 134217728) != 0 ? feedOfFeed2.deepLink : str13, (i12 & 268435456) != 0 ? feedOfFeed2.category : i4, (i12 & 536870912) != 0 ? feedOfFeed2.following : i5, (i12 & 1073741824) != 0 ? feedOfFeed2.mute : z2, (i12 & Integer.MIN_VALUE) != 0 ? feedOfFeed2.isBookmarked : z3, (i13 & 1) != 0 ? feedOfFeed2.isFollowed : z4, (i13 & 2) != 0 ? feedOfFeed2.canFollow : z5, (i13 & 4) != 0 ? feedOfFeed2.likeCountDisplay : str14, (i13 & 8) != 0 ? feedOfFeed2.commentCountDisplay : str15, (i13 & 16) != 0 ? feedOfFeed2.shareCountDisplay : str16, (i13 & 32) != 0 ? feedOfFeed2.buckets : str17, (i13 & 64) != 0 ? feedOfFeed2.feedItemType : str18, (i13 & 128) != 0 ? feedOfFeed2.feedItemRank : i6, (i13 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? feedOfFeed2.feedItemCategoryRank : i7, (i13 & 512) != 0 ? feedOfFeed2.profileRank : i8, (i13 & TarConstants.EOF_BLOCK) != 0 ? feedOfFeed2.mlVersion : str19, (i13 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? feedOfFeed2.contentFormat : str20, (i13 & 4096) != 0 ? feedOfFeed2.mlCategory : str21, (i13 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? feedOfFeed2.score : d2, (i13 & 16384) != 0 ? feedOfFeed2.followingRank : i9, (i13 & 32768) != 0 ? feedOfFeed2.ctaImageUrl : str22, (i13 & 65536) != 0 ? feedOfFeed2.ctaDisplayText : str23);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.width;
    }

    public final String component11() {
        return this.height;
    }

    public final String component12() {
        return this.title;
    }

    public final String component13() {
        return this.webUrl;
    }

    public final Integer component14() {
        return this.likeCount;
    }

    public final Integer component15() {
        return this.commentCount;
    }

    public final Integer component16() {
        return this.shareCount;
    }

    public final Boolean component17() {
        return this.isLiked;
    }

    public final String component18() {
        return this.description;
    }

    public final String component19() {
        return this.displayTime;
    }

    public final int component2() {
        return this.uiId;
    }

    public final String component20() {
        return this.streamUrl;
    }

    public final Integer component21() {
        return this.duration;
    }

    public final Integer component22() {
        return this.viewCount;
    }

    public final boolean component23() {
        return this.canLike;
    }

    public final Boolean component24() {
        return this.canComment;
    }

    public final Boolean component25() {
        return this.canShare;
    }

    public final Boolean component26() {
        return this.isSensitive;
    }

    public final Boolean component27() {
        return this.isFlaggedByUser;
    }

    public final String component28() {
        return this.deepLink;
    }

    public final int component29() {
        return this.category;
    }

    public final String component3() {
        return this.groupId;
    }

    public final int component30() {
        return this.following;
    }

    public final boolean component31() {
        return this.mute;
    }

    public final boolean component32() {
        return this.isBookmarked;
    }

    public final boolean component33() {
        return this.isFollowed;
    }

    public final boolean component34() {
        return this.canFollow;
    }

    public final String component35() {
        return this.likeCountDisplay;
    }

    public final String component36() {
        return this.commentCountDisplay;
    }

    public final String component37() {
        return this.shareCountDisplay;
    }

    public final String component38() {
        return this.buckets;
    }

    public final String component39() {
        return this.feedItemType;
    }

    public final int component4() {
        return this.rank;
    }

    public final int component40() {
        return this.feedItemRank;
    }

    public final int component41() {
        return this.feedItemCategoryRank;
    }

    public final int component42() {
        return this.profileRank;
    }

    public final String component43() {
        return this.mlVersion;
    }

    public final String component44() {
        return this.contentFormat;
    }

    public final String component45() {
        return this.mlCategory;
    }

    public final Double component46() {
        return this.score;
    }

    public final int component47() {
        return this.followingRank;
    }

    public final String component48() {
        return this.ctaImageUrl;
    }

    public final String component49() {
        return this.ctaDisplayText;
    }

    public final CreatedBy component5() {
        return this.createdBy;
    }

    public final MlProperties component6() {
        return this.mlProperties;
    }

    public final String component7() {
        return this.poweredBy;
    }

    public final String component8() {
        return this.createdAt;
    }

    public final String component9() {
        return this.imageUrl;
    }

    public final FeedOfFeed copy(String str, int i2, String str2, int i3, CreatedBy createdBy2, MlProperties mlProperties2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, Boolean bool, String str10, String str11, String str12, Integer num4, Integer num5, boolean z, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str13, int i4, int i5, boolean z2, boolean z3, boolean z4, boolean z5, String str14, String str15, String str16, String str17, String str18, int i6, int i7, int i8, String str19, String str20, String str21, Double d2, int i9, String str22, String str23) {
        String str24 = str;
        String str25 = str24;
        k.c(str24, "id");
        return new FeedOfFeed(str24, i2, str2, i3, createdBy2, mlProperties2, str3, str4, str5, str6, str7, str8, str9, num, num2, num3, bool, str10, str11, str12, num4, num5, z, bool2, bool3, bool4, bool5, str13, i4, i5, z2, z3, z4, z5, str14, str15, str16, str17, str18, i6, i7, i8, str19, str20, str21, d2, i9, str22, str23);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedOfFeed) {
                FeedOfFeed feedOfFeed = (FeedOfFeed) obj;
                if (k.a((Object) this.id, (Object) feedOfFeed.id)) {
                    if ((this.uiId == feedOfFeed.uiId) && k.a((Object) this.groupId, (Object) feedOfFeed.groupId)) {
                        if ((this.rank == feedOfFeed.rank) && k.a((Object) this.createdBy, (Object) feedOfFeed.createdBy) && k.a((Object) this.mlProperties, (Object) feedOfFeed.mlProperties) && k.a((Object) this.poweredBy, (Object) feedOfFeed.poweredBy) && k.a((Object) this.createdAt, (Object) feedOfFeed.createdAt) && k.a((Object) this.imageUrl, (Object) feedOfFeed.imageUrl) && k.a((Object) this.width, (Object) feedOfFeed.width) && k.a((Object) this.height, (Object) feedOfFeed.height) && k.a((Object) this.title, (Object) feedOfFeed.title) && k.a((Object) this.webUrl, (Object) feedOfFeed.webUrl) && k.a((Object) this.likeCount, (Object) feedOfFeed.likeCount) && k.a((Object) this.commentCount, (Object) feedOfFeed.commentCount) && k.a((Object) this.shareCount, (Object) feedOfFeed.shareCount) && k.a((Object) this.isLiked, (Object) feedOfFeed.isLiked) && k.a((Object) this.description, (Object) feedOfFeed.description) && k.a((Object) this.displayTime, (Object) feedOfFeed.displayTime) && k.a((Object) this.streamUrl, (Object) feedOfFeed.streamUrl) && k.a((Object) this.duration, (Object) feedOfFeed.duration) && k.a((Object) this.viewCount, (Object) feedOfFeed.viewCount)) {
                            if ((this.canLike == feedOfFeed.canLike) && k.a((Object) this.canComment, (Object) feedOfFeed.canComment) && k.a((Object) this.canShare, (Object) feedOfFeed.canShare) && k.a((Object) this.isSensitive, (Object) feedOfFeed.isSensitive) && k.a((Object) this.isFlaggedByUser, (Object) feedOfFeed.isFlaggedByUser) && k.a((Object) this.deepLink, (Object) feedOfFeed.deepLink)) {
                                if (this.category == feedOfFeed.category) {
                                    if (this.following == feedOfFeed.following) {
                                        if (this.mute == feedOfFeed.mute) {
                                            if (this.isBookmarked == feedOfFeed.isBookmarked) {
                                                if (this.isFollowed == feedOfFeed.isFollowed) {
                                                    if ((this.canFollow == feedOfFeed.canFollow) && k.a((Object) this.likeCountDisplay, (Object) feedOfFeed.likeCountDisplay) && k.a((Object) this.commentCountDisplay, (Object) feedOfFeed.commentCountDisplay) && k.a((Object) this.shareCountDisplay, (Object) feedOfFeed.shareCountDisplay) && k.a((Object) this.buckets, (Object) feedOfFeed.buckets) && k.a((Object) this.feedItemType, (Object) feedOfFeed.feedItemType)) {
                                                        if (this.feedItemRank == feedOfFeed.feedItemRank) {
                                                            if (this.feedItemCategoryRank == feedOfFeed.feedItemCategoryRank) {
                                                                if ((this.profileRank == feedOfFeed.profileRank) && k.a((Object) this.mlVersion, (Object) feedOfFeed.mlVersion) && k.a((Object) this.contentFormat, (Object) feedOfFeed.contentFormat) && k.a((Object) this.mlCategory, (Object) feedOfFeed.mlCategory) && k.a((Object) this.score, (Object) feedOfFeed.score)) {
                                                                    if (!(this.followingRank == feedOfFeed.followingRank) || !k.a((Object) this.ctaImageUrl, (Object) feedOfFeed.ctaImageUrl) || !k.a((Object) this.ctaDisplayText, (Object) feedOfFeed.ctaDisplayText)) {
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.uiId).hashCode()) * 31;
        String str2 = this.groupId;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.valueOf(this.rank).hashCode()) * 31;
        CreatedBy createdBy2 = this.createdBy;
        int hashCode3 = (hashCode2 + (createdBy2 != null ? createdBy2.hashCode() : 0)) * 31;
        MlProperties mlProperties2 = this.mlProperties;
        int hashCode4 = (hashCode3 + (mlProperties2 != null ? mlProperties2.hashCode() : 0)) * 31;
        String str3 = this.poweredBy;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.createdAt;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.imageUrl;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.width;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.height;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.title;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.webUrl;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Integer num = this.likeCount;
        int hashCode12 = (hashCode11 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.commentCount;
        int hashCode13 = (hashCode12 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.shareCount;
        int hashCode14 = (hashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Boolean bool = this.isLiked;
        int hashCode15 = (hashCode14 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str10 = this.description;
        int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.displayTime;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.streamUrl;
        int hashCode18 = (hashCode17 + (str12 != null ? str12.hashCode() : 0)) * 31;
        Integer num4 = this.duration;
        int hashCode19 = (hashCode18 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.viewCount;
        int hashCode20 = (hashCode19 + (num5 != null ? num5.hashCode() : 0)) * 31;
        boolean z = this.canLike;
        if (z) {
            z = true;
        }
        int i3 = (hashCode20 + (z ? 1 : 0)) * 31;
        Boolean bool2 = this.canComment;
        int hashCode21 = (i3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.canShare;
        int hashCode22 = (hashCode21 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.isSensitive;
        int hashCode23 = (hashCode22 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.isFlaggedByUser;
        int hashCode24 = (hashCode23 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        String str13 = this.deepLink;
        int hashCode25 = (((((hashCode24 + (str13 != null ? str13.hashCode() : 0)) * 31) + Integer.valueOf(this.category).hashCode()) * 31) + Integer.valueOf(this.following).hashCode()) * 31;
        boolean z2 = this.mute;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode25 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.isBookmarked;
        if (z3) {
            z3 = true;
        }
        int i5 = (i4 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isFollowed;
        if (z4) {
            z4 = true;
        }
        int i6 = (i5 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.canFollow;
        if (z5) {
            z5 = true;
        }
        int i7 = (i6 + (z5 ? 1 : 0)) * 31;
        String str14 = this.likeCountDisplay;
        int hashCode26 = (i7 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.commentCountDisplay;
        int hashCode27 = (hashCode26 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.shareCountDisplay;
        int hashCode28 = (hashCode27 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.buckets;
        int hashCode29 = (hashCode28 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.feedItemType;
        int hashCode30 = (((((((hashCode29 + (str18 != null ? str18.hashCode() : 0)) * 31) + Integer.valueOf(this.feedItemRank).hashCode()) * 31) + Integer.valueOf(this.feedItemCategoryRank).hashCode()) * 31) + Integer.valueOf(this.profileRank).hashCode()) * 31;
        String str19 = this.mlVersion;
        int hashCode31 = (hashCode30 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.contentFormat;
        int hashCode32 = (hashCode31 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.mlCategory;
        int hashCode33 = (hashCode32 + (str21 != null ? str21.hashCode() : 0)) * 31;
        Double d2 = this.score;
        int hashCode34 = (((hashCode33 + (d2 != null ? d2.hashCode() : 0)) * 31) + Integer.valueOf(this.followingRank).hashCode()) * 31;
        String str22 = this.ctaImageUrl;
        int hashCode35 = (hashCode34 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.ctaDisplayText;
        if (str23 != null) {
            i2 = str23.hashCode();
        }
        return hashCode35 + i2;
    }

    public final String toString() {
        return "FeedOfFeed(id=" + this.id + ", uiId=" + this.uiId + ", groupId=" + this.groupId + ", rank=" + this.rank + ", createdBy=" + this.createdBy + ", mlProperties=" + this.mlProperties + ", poweredBy=" + this.poweredBy + ", createdAt=" + this.createdAt + ", imageUrl=" + this.imageUrl + ", width=" + this.width + ", height=" + this.height + ", title=" + this.title + ", webUrl=" + this.webUrl + ", likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", shareCount=" + this.shareCount + ", isLiked=" + this.isLiked + ", description=" + this.description + ", displayTime=" + this.displayTime + ", streamUrl=" + this.streamUrl + ", duration=" + this.duration + ", viewCount=" + this.viewCount + ", canLike=" + this.canLike + ", canComment=" + this.canComment + ", canShare=" + this.canShare + ", isSensitive=" + this.isSensitive + ", isFlaggedByUser=" + this.isFlaggedByUser + ", deepLink=" + this.deepLink + ", category=" + this.category + ", following=" + this.following + ", mute=" + this.mute + ", isBookmarked=" + this.isBookmarked + ", isFollowed=" + this.isFollowed + ", canFollow=" + this.canFollow + ", likeCountDisplay=" + this.likeCountDisplay + ", commentCountDisplay=" + this.commentCountDisplay + ", shareCountDisplay=" + this.shareCountDisplay + ", buckets=" + this.buckets + ", feedItemType=" + this.feedItemType + ", feedItemRank=" + this.feedItemRank + ", feedItemCategoryRank=" + this.feedItemCategoryRank + ", profileRank=" + this.profileRank + ", mlVersion=" + this.mlVersion + ", contentFormat=" + this.contentFormat + ", mlCategory=" + this.mlCategory + ", score=" + this.score + ", followingRank=" + this.followingRank + ", ctaImageUrl=" + this.ctaImageUrl + ", ctaDisplayText=" + this.ctaDisplayText + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.uiId);
        parcel.writeString(this.groupId);
        parcel.writeInt(this.rank);
        parcel.writeParcelable(this.createdBy, i2);
        MlProperties mlProperties2 = this.mlProperties;
        if (mlProperties2 != null) {
            parcel.writeInt(1);
            mlProperties2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.poweredBy);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.width);
        parcel.writeString(this.height);
        parcel.writeString(this.title);
        parcel.writeString(this.webUrl);
        Integer num = this.likeCount;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.commentCount;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.shareCount;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.isLiked;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.description);
        parcel.writeString(this.displayTime);
        parcel.writeString(this.streamUrl);
        Integer num4 = this.duration;
        if (num4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num5 = this.viewCount;
        if (num5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.canLike ? 1 : 0);
        Boolean bool2 = this.canComment;
        if (bool2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool3 = this.canShare;
        if (bool3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool4 = this.isSensitive;
        if (bool4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool5 = this.isFlaggedByUser;
        if (bool5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.deepLink);
        parcel.writeInt(this.category);
        parcel.writeInt(this.following);
        parcel.writeInt(this.mute ? 1 : 0);
        parcel.writeInt(this.isBookmarked ? 1 : 0);
        parcel.writeInt(this.isFollowed ? 1 : 0);
        parcel.writeInt(this.canFollow ? 1 : 0);
        parcel.writeString(this.likeCountDisplay);
        parcel.writeString(this.commentCountDisplay);
        parcel.writeString(this.shareCountDisplay);
        parcel.writeString(this.buckets);
        parcel.writeString(this.feedItemType);
        parcel.writeInt(this.feedItemRank);
        parcel.writeInt(this.feedItemCategoryRank);
        parcel.writeInt(this.profileRank);
        parcel.writeString(this.mlVersion);
        parcel.writeString(this.contentFormat);
        parcel.writeString(this.mlCategory);
        Double d2 = this.score;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.followingRank);
        parcel.writeString(this.ctaImageUrl);
        parcel.writeString(this.ctaDisplayText);
    }

    public FeedOfFeed(String str, int i2, String str2, int i3, CreatedBy createdBy2, MlProperties mlProperties2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, Boolean bool, String str10, String str11, String str12, Integer num4, Integer num5, boolean z, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str13, int i4, int i5, boolean z2, boolean z3, boolean z4, boolean z5, String str14, String str15, String str16, String str17, String str18, int i6, int i7, int i8, String str19, String str20, String str21, Double d2, int i9, String str22, String str23) {
        k.c(str, "id");
        this.id = str;
        this.uiId = i2;
        this.groupId = str2;
        this.rank = i3;
        this.createdBy = createdBy2;
        this.mlProperties = mlProperties2;
        this.poweredBy = str3;
        this.createdAt = str4;
        this.imageUrl = str5;
        this.width = str6;
        this.height = str7;
        this.title = str8;
        this.webUrl = str9;
        this.likeCount = num;
        this.commentCount = num2;
        this.shareCount = num3;
        this.isLiked = bool;
        this.description = str10;
        this.displayTime = str11;
        this.streamUrl = str12;
        this.duration = num4;
        this.viewCount = num5;
        this.canLike = z;
        this.canComment = bool2;
        this.canShare = bool3;
        this.isSensitive = bool4;
        this.isFlaggedByUser = bool5;
        this.deepLink = str13;
        this.category = i4;
        this.following = i5;
        this.mute = z2;
        this.isBookmarked = z3;
        this.isFollowed = z4;
        this.canFollow = z5;
        this.likeCountDisplay = str14;
        this.commentCountDisplay = str15;
        this.shareCountDisplay = str16;
        this.buckets = str17;
        this.feedItemType = str18;
        this.feedItemRank = i6;
        this.feedItemCategoryRank = i7;
        this.profileRank = i8;
        this.mlVersion = str19;
        this.contentFormat = str20;
        this.mlCategory = str21;
        this.score = d2;
        this.followingRank = i9;
        this.ctaImageUrl = str22;
        this.ctaDisplayText = str23;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final int getUiId() {
        return this.uiId;
    }

    public final void setUiId(int i2) {
        this.uiId = i2;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final int getRank() {
        return this.rank;
    }

    public final void setRank(int i2) {
        this.rank = i2;
    }

    public final CreatedBy getCreatedBy() {
        return this.createdBy;
    }

    public final MlProperties getMlProperties() {
        return this.mlProperties;
    }

    public final String getPoweredBy() {
        return this.poweredBy;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getWidth() {
        return this.width;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final Integer getLikeCount() {
        return this.likeCount;
    }

    public final Integer getCommentCount() {
        return this.commentCount;
    }

    public final Integer getShareCount() {
        return this.shareCount;
    }

    public final Boolean isLiked() {
        return this.isLiked;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisplayTime() {
        return this.displayTime;
    }

    public final void setDisplayTime(String str) {
        this.displayTime = str;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer getViewCount() {
        return this.viewCount;
    }

    public final boolean getCanLike() {
        return this.canLike;
    }

    public final Boolean getCanComment() {
        return this.canComment;
    }

    public final Boolean getCanShare() {
        return this.canShare;
    }

    public final Boolean isSensitive() {
        return this.isSensitive;
    }

    public final Boolean isFlaggedByUser() {
        return this.isFlaggedByUser;
    }

    public final void setFlaggedByUser(Boolean bool) {
        this.isFlaggedByUser = bool;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final int getCategory() {
        return this.category;
    }

    public final void setCategory(int i2) {
        this.category = i2;
    }

    public final int getFollowing() {
        return this.following;
    }

    public final void setFollowing(int i2) {
        this.following = i2;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final void setMute(boolean z) {
        this.mute = z;
    }

    public final boolean isBookmarked() {
        return this.isBookmarked;
    }

    public final void setBookmarked(boolean z) {
        this.isBookmarked = z;
    }

    public final boolean isFollowed() {
        return this.isFollowed;
    }

    public final void setFollowed(boolean z) {
        this.isFollowed = z;
    }

    public final boolean getCanFollow() {
        return this.canFollow;
    }

    public final void setCanFollow(boolean z) {
        this.canFollow = z;
    }

    public final String getLikeCountDisplay() {
        return this.likeCountDisplay;
    }

    public final void setLikeCountDisplay(String str) {
        this.likeCountDisplay = str;
    }

    public final String getCommentCountDisplay() {
        return this.commentCountDisplay;
    }

    public final void setCommentCountDisplay(String str) {
        this.commentCountDisplay = str;
    }

    public final String getShareCountDisplay() {
        return this.shareCountDisplay;
    }

    public final void setShareCountDisplay(String str) {
        this.shareCountDisplay = str;
    }

    public final String getBuckets() {
        return this.buckets;
    }

    public final void setBuckets(String str) {
        this.buckets = str;
    }

    public final String getFeedItemType() {
        return this.feedItemType;
    }

    public final void setFeedItemType(String str) {
        this.feedItemType = str;
    }

    public final int getFeedItemRank() {
        return this.feedItemRank;
    }

    public final void setFeedItemRank(int i2) {
        this.feedItemRank = i2;
    }

    public final int getFeedItemCategoryRank() {
        return this.feedItemCategoryRank;
    }

    public final void setFeedItemCategoryRank(int i2) {
        this.feedItemCategoryRank = i2;
    }

    public final int getProfileRank() {
        return this.profileRank;
    }

    public final void setProfileRank(int i2) {
        this.profileRank = i2;
    }

    public final String getMlVersion() {
        return this.mlVersion;
    }

    public final void setMlVersion(String str) {
        this.mlVersion = str;
    }

    public final String getContentFormat() {
        return this.contentFormat;
    }

    public final void setContentFormat(String str) {
        this.contentFormat = str;
    }

    public final String getMlCategory() {
        return this.mlCategory;
    }

    public final void setMlCategory(String str) {
        this.mlCategory = str;
    }

    public final Double getScore() {
        return this.score;
    }

    public final void setScore(Double d2) {
        this.score = d2;
    }

    public final int getFollowingRank() {
        return this.followingRank;
    }

    public final void setFollowingRank(int i2) {
        this.followingRank = i2;
    }

    public final String getCtaImageUrl() {
        return this.ctaImageUrl;
    }

    public final void setCtaImageUrl(String str) {
        this.ctaImageUrl = str;
    }

    public final String getCtaDisplayText() {
        return this.ctaDisplayText;
    }

    public final void setCtaDisplayText(String str) {
        this.ctaDisplayText = str;
    }
}
