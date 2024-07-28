package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class FeedData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String awayTeamAbbr;
    private String awayTeamId;
    private String awayTeamLogo;
    private String buckets;
    private final Boolean canComment;
    private boolean canFollow;
    private final boolean canLike;
    private final Boolean canShare;
    private int category;
    private String clickUrl;
    private final Integer commentCount;
    private String commentCountDisplay;
    private String contentFormat;
    private final String createdAt;
    private final CreatedBy createdBy;
    private String ctaDisplayText;
    private String ctaImageUrl;
    private String dataUrl;
    private final String deepLinkUrl;
    private final String description;
    private String displayTime;
    private final Integer duration;
    private int feedItemCategoryRank;
    private int feedItemRank;
    private String feedItemType;
    private int following;
    private int followingRank;
    private final String height;
    private String homeTeamAbbr;
    private String homeTeamId;
    private String homeTeamLogo;
    private String id;
    private final String imageUrl;
    private boolean isBookmarked;
    private Boolean isFlaggedByUser;
    private boolean isFollowed;
    private final Boolean isLiked;
    private final Boolean isSensitive;
    private final Integer likeCount;
    private String likeCountDisplay;
    private String logoUrl;
    private String matchId;
    private String mlCategory;
    private final MlProperties mlProperties;
    private String mlVersion;
    private boolean mute;
    private String name;
    private final String poweredBy;
    private int profileRank;
    private int rank;
    private double score;
    private final Integer shareCount;
    private String shareCountDisplay;
    private String shareUrl;
    private String startTime;
    private final String streamUrl;
    private final String title;
    private Integer uiId;
    private final String url;
    private String viewAllUrl;
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
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            int readInt = parcel.readInt();
            CreatedBy createdBy = (CreatedBy) parcel2.readParcelable(FeedData.class.getClassLoader());
            MlProperties mlProperties = parcel.readInt() != 0 ? (MlProperties) MlProperties.CREATOR.createFromParcel(parcel2) : null;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf3 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf4 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            Integer valueOf5 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf6 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
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
            return new FeedData(readString, valueOf, readInt, createdBy, mlProperties, readString2, readString3, readString4, readString5, readString6, readString7, readString8, valueOf2, valueOf3, valueOf4, bool, readString9, readString10, readString11, readString12, valueOf5, valueOf6, z, bool2, bool3, bool4, bool5, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedData[i2];
        }
    }

    public static /* synthetic */ FeedData copy$default(FeedData feedData, String str, Integer num, int i2, CreatedBy createdBy2, MlProperties mlProperties2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, Integer num3, Integer num4, Boolean bool, String str9, String str10, String str11, String str12, Integer num5, Integer num6, boolean z, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str13, int i3, int i4, String str14, String str15, String str16, String str17, String str18, String str19, int i5, int i6, int i7, int i8, boolean z2, String str20, String str21, String str22, double d2, boolean z3, boolean z4, boolean z5, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, int i9, int i10, Object obj) {
        FeedData feedData2 = feedData;
        int i11 = i9;
        int i12 = i10;
        return feedData.copy((i11 & 1) != 0 ? feedData2.id : str, (i11 & 2) != 0 ? feedData2.uiId : num, (i11 & 4) != 0 ? feedData2.rank : i2, (i11 & 8) != 0 ? feedData2.createdBy : createdBy2, (i11 & 16) != 0 ? feedData2.mlProperties : mlProperties2, (i11 & 32) != 0 ? feedData2.poweredBy : str2, (i11 & 64) != 0 ? feedData2.createdAt : str3, (i11 & 128) != 0 ? feedData2.imageUrl : str4, (i11 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? feedData2.width : str5, (i11 & 512) != 0 ? feedData2.height : str6, (i11 & TarConstants.EOF_BLOCK) != 0 ? feedData2.title : str7, (i11 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? feedData2.webUrl : str8, (i11 & 4096) != 0 ? feedData2.likeCount : num2, (i11 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? feedData2.commentCount : num3, (i11 & 16384) != 0 ? feedData2.shareCount : num4, (i11 & 32768) != 0 ? feedData2.isLiked : bool, (i11 & 65536) != 0 ? feedData2.description : str9, (i11 & 131072) != 0 ? feedData2.displayTime : str10, (i11 & 262144) != 0 ? feedData2.url : str11, (i11 & 524288) != 0 ? feedData2.streamUrl : str12, (i11 & 1048576) != 0 ? feedData2.duration : num5, (i11 & 2097152) != 0 ? feedData2.viewCount : num6, (i11 & 4194304) != 0 ? feedData2.canLike : z, (i11 & 8388608) != 0 ? feedData2.canComment : bool2, (i11 & 16777216) != 0 ? feedData2.canShare : bool3, (i11 & 33554432) != 0 ? feedData2.isSensitive : bool4, (i11 & 67108864) != 0 ? feedData2.isFlaggedByUser : bool5, (i11 & 134217728) != 0 ? feedData2.deepLinkUrl : str13, (i11 & 268435456) != 0 ? feedData2.category : i3, (i11 & 536870912) != 0 ? feedData2.following : i4, (i11 & 1073741824) != 0 ? feedData2.viewAllUrl : str14, (i11 & Integer.MIN_VALUE) != 0 ? feedData2.buckets : str15, (i12 & 1) != 0 ? feedData2.feedItemType : str16, (i12 & 2) != 0 ? feedData2.logoUrl : str17, (i12 & 4) != 0 ? feedData2.shareUrl : str18, (i12 & 8) != 0 ? feedData2.name : str19, (i12 & 16) != 0 ? feedData2.feedItemRank : i5, (i12 & 32) != 0 ? feedData2.feedItemCategoryRank : i6, (i12 & 64) != 0 ? feedData2.profileRank : i7, (i12 & 128) != 0 ? feedData2.followingRank : i8, (i12 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? feedData2.mute : z2, (i12 & 512) != 0 ? feedData2.mlVersion : str20, (i12 & TarConstants.EOF_BLOCK) != 0 ? feedData2.contentFormat : str21, (i12 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? feedData2.mlCategory : str22, (i12 & 4096) != 0 ? feedData2.score : d2, (i12 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? feedData2.isBookmarked : z3, (i12 & 16384) != 0 ? feedData2.isFollowed : z4, (i12 & 32768) != 0 ? feedData2.canFollow : z5, (i12 & 65536) != 0 ? feedData2.likeCountDisplay : str23, (i12 & 131072) != 0 ? feedData2.commentCountDisplay : str24, (i12 & 262144) != 0 ? feedData2.shareCountDisplay : str25, (i12 & 524288) != 0 ? feedData2.homeTeamAbbr : str26, (i12 & 1048576) != 0 ? feedData2.awayTeamAbbr : str27, (i12 & 2097152) != 0 ? feedData2.homeTeamLogo : str28, (i12 & 4194304) != 0 ? feedData2.awayTeamLogo : str29, (i12 & 8388608) != 0 ? feedData2.homeTeamId : str30, (i12 & 16777216) != 0 ? feedData2.awayTeamId : str31, (i12 & 33554432) != 0 ? feedData2.dataUrl : str32, (i12 & 67108864) != 0 ? feedData2.clickUrl : str33, (i12 & 134217728) != 0 ? feedData2.matchId : str34, (i12 & 268435456) != 0 ? feedData2.startTime : str35, (i12 & 536870912) != 0 ? feedData2.ctaImageUrl : str36, (i12 & 1073741824) != 0 ? feedData2.ctaDisplayText : str37);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.height;
    }

    public final String component11() {
        return this.title;
    }

    public final String component12() {
        return this.webUrl;
    }

    public final Integer component13() {
        return this.likeCount;
    }

    public final Integer component14() {
        return this.commentCount;
    }

    public final Integer component15() {
        return this.shareCount;
    }

    public final Boolean component16() {
        return this.isLiked;
    }

    public final String component17() {
        return this.description;
    }

    public final String component18() {
        return this.displayTime;
    }

    public final String component19() {
        return this.url;
    }

    public final Integer component2() {
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
        return this.deepLinkUrl;
    }

    public final int component29() {
        return this.category;
    }

    public final int component3() {
        return this.rank;
    }

    public final int component30() {
        return this.following;
    }

    public final String component31() {
        return this.viewAllUrl;
    }

    public final String component32() {
        return this.buckets;
    }

    public final String component33() {
        return this.feedItemType;
    }

    public final String component34() {
        return this.logoUrl;
    }

    public final String component35() {
        return this.shareUrl;
    }

    public final String component36() {
        return this.name;
    }

    public final int component37() {
        return this.feedItemRank;
    }

    public final int component38() {
        return this.feedItemCategoryRank;
    }

    public final int component39() {
        return this.profileRank;
    }

    public final CreatedBy component4() {
        return this.createdBy;
    }

    public final int component40() {
        return this.followingRank;
    }

    public final boolean component41() {
        return this.mute;
    }

    public final String component42() {
        return this.mlVersion;
    }

    public final String component43() {
        return this.contentFormat;
    }

    public final String component44() {
        return this.mlCategory;
    }

    public final double component45() {
        return this.score;
    }

    public final boolean component46() {
        return this.isBookmarked;
    }

    public final boolean component47() {
        return this.isFollowed;
    }

    public final boolean component48() {
        return this.canFollow;
    }

    public final String component49() {
        return this.likeCountDisplay;
    }

    public final MlProperties component5() {
        return this.mlProperties;
    }

    public final String component50() {
        return this.commentCountDisplay;
    }

    public final String component51() {
        return this.shareCountDisplay;
    }

    public final String component52() {
        return this.homeTeamAbbr;
    }

    public final String component53() {
        return this.awayTeamAbbr;
    }

    public final String component54() {
        return this.homeTeamLogo;
    }

    public final String component55() {
        return this.awayTeamLogo;
    }

    public final String component56() {
        return this.homeTeamId;
    }

    public final String component57() {
        return this.awayTeamId;
    }

    public final String component58() {
        return this.dataUrl;
    }

    public final String component59() {
        return this.clickUrl;
    }

    public final String component6() {
        return this.poweredBy;
    }

    public final String component60() {
        return this.matchId;
    }

    public final String component61() {
        return this.startTime;
    }

    public final String component62() {
        return this.ctaImageUrl;
    }

    public final String component63() {
        return this.ctaDisplayText;
    }

    public final String component7() {
        return this.createdAt;
    }

    public final String component8() {
        return this.imageUrl;
    }

    public final String component9() {
        return this.width;
    }

    public final FeedData copy(String str, Integer num, int i2, CreatedBy createdBy2, MlProperties mlProperties2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, Integer num3, Integer num4, Boolean bool, String str9, String str10, String str11, String str12, Integer num5, Integer num6, boolean z, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str13, int i3, int i4, String str14, String str15, String str16, String str17, String str18, String str19, int i5, int i6, int i7, int i8, boolean z2, String str20, String str21, String str22, double d2, boolean z3, boolean z4, boolean z5, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37) {
        String str38 = str;
        k.c(str38, "id");
        k.c(str16, "feedItemType");
        k.c(str20, "mlVersion");
        k.c(str21, "contentFormat");
        k.c(str22, "mlCategory");
        return new FeedData(str38, num, i2, createdBy2, mlProperties2, str2, str3, str4, str5, str6, str7, str8, num2, num3, num4, bool, str9, str10, str11, str12, num5, num6, z, bool2, bool3, bool4, bool5, str13, i3, i4, str14, str15, str16, str17, str18, str19, i5, i6, i7, i8, z2, str20, str21, str22, d2, z3, z4, z5, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedData) {
                FeedData feedData = (FeedData) obj;
                if (k.a((Object) this.id, (Object) feedData.id) && k.a((Object) this.uiId, (Object) feedData.uiId)) {
                    if ((this.rank == feedData.rank) && k.a((Object) this.createdBy, (Object) feedData.createdBy) && k.a((Object) this.mlProperties, (Object) feedData.mlProperties) && k.a((Object) this.poweredBy, (Object) feedData.poweredBy) && k.a((Object) this.createdAt, (Object) feedData.createdAt) && k.a((Object) this.imageUrl, (Object) feedData.imageUrl) && k.a((Object) this.width, (Object) feedData.width) && k.a((Object) this.height, (Object) feedData.height) && k.a((Object) this.title, (Object) feedData.title) && k.a((Object) this.webUrl, (Object) feedData.webUrl) && k.a((Object) this.likeCount, (Object) feedData.likeCount) && k.a((Object) this.commentCount, (Object) feedData.commentCount) && k.a((Object) this.shareCount, (Object) feedData.shareCount) && k.a((Object) this.isLiked, (Object) feedData.isLiked) && k.a((Object) this.description, (Object) feedData.description) && k.a((Object) this.displayTime, (Object) feedData.displayTime) && k.a((Object) this.url, (Object) feedData.url) && k.a((Object) this.streamUrl, (Object) feedData.streamUrl) && k.a((Object) this.duration, (Object) feedData.duration) && k.a((Object) this.viewCount, (Object) feedData.viewCount)) {
                        if ((this.canLike == feedData.canLike) && k.a((Object) this.canComment, (Object) feedData.canComment) && k.a((Object) this.canShare, (Object) feedData.canShare) && k.a((Object) this.isSensitive, (Object) feedData.isSensitive) && k.a((Object) this.isFlaggedByUser, (Object) feedData.isFlaggedByUser) && k.a((Object) this.deepLinkUrl, (Object) feedData.deepLinkUrl)) {
                            if (this.category == feedData.category) {
                                if ((this.following == feedData.following) && k.a((Object) this.viewAllUrl, (Object) feedData.viewAllUrl) && k.a((Object) this.buckets, (Object) feedData.buckets) && k.a((Object) this.feedItemType, (Object) feedData.feedItemType) && k.a((Object) this.logoUrl, (Object) feedData.logoUrl) && k.a((Object) this.shareUrl, (Object) feedData.shareUrl) && k.a((Object) this.name, (Object) feedData.name)) {
                                    if (this.feedItemRank == feedData.feedItemRank) {
                                        if (this.feedItemCategoryRank == feedData.feedItemCategoryRank) {
                                            if (this.profileRank == feedData.profileRank) {
                                                if (this.followingRank == feedData.followingRank) {
                                                    if ((this.mute == feedData.mute) && k.a((Object) this.mlVersion, (Object) feedData.mlVersion) && k.a((Object) this.contentFormat, (Object) feedData.contentFormat) && k.a((Object) this.mlCategory, (Object) feedData.mlCategory) && Double.compare(this.score, feedData.score) == 0) {
                                                        if (this.isBookmarked == feedData.isBookmarked) {
                                                            if (this.isFollowed == feedData.isFollowed) {
                                                                if (!(this.canFollow == feedData.canFollow) || !k.a((Object) this.likeCountDisplay, (Object) feedData.likeCountDisplay) || !k.a((Object) this.commentCountDisplay, (Object) feedData.commentCountDisplay) || !k.a((Object) this.shareCountDisplay, (Object) feedData.shareCountDisplay) || !k.a((Object) this.homeTeamAbbr, (Object) feedData.homeTeamAbbr) || !k.a((Object) this.awayTeamAbbr, (Object) feedData.awayTeamAbbr) || !k.a((Object) this.homeTeamLogo, (Object) feedData.homeTeamLogo) || !k.a((Object) this.awayTeamLogo, (Object) feedData.awayTeamLogo) || !k.a((Object) this.homeTeamId, (Object) feedData.homeTeamId) || !k.a((Object) this.awayTeamId, (Object) feedData.awayTeamId) || !k.a((Object) this.dataUrl, (Object) feedData.dataUrl) || !k.a((Object) this.clickUrl, (Object) feedData.clickUrl) || !k.a((Object) this.matchId, (Object) feedData.matchId) || !k.a((Object) this.startTime, (Object) feedData.startTime) || !k.a((Object) this.ctaImageUrl, (Object) feedData.ctaImageUrl) || !k.a((Object) this.ctaDisplayText, (Object) feedData.ctaDisplayText)) {
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
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.uiId;
        int hashCode2 = (((hashCode + (num != null ? num.hashCode() : 0)) * 31) + Integer.valueOf(this.rank).hashCode()) * 31;
        CreatedBy createdBy2 = this.createdBy;
        int hashCode3 = (hashCode2 + (createdBy2 != null ? createdBy2.hashCode() : 0)) * 31;
        MlProperties mlProperties2 = this.mlProperties;
        int hashCode4 = (hashCode3 + (mlProperties2 != null ? mlProperties2.hashCode() : 0)) * 31;
        String str2 = this.poweredBy;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.createdAt;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageUrl;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.width;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.height;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.title;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.webUrl;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num2 = this.likeCount;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.commentCount;
        int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.shareCount;
        int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Boolean bool = this.isLiked;
        int hashCode15 = (hashCode14 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str9 = this.description;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.displayTime;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.url;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.streamUrl;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 31;
        Integer num5 = this.duration;
        int hashCode20 = (hashCode19 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.viewCount;
        int hashCode21 = (hashCode20 + (num6 != null ? num6.hashCode() : 0)) * 31;
        boolean z = this.canLike;
        if (z) {
            z = true;
        }
        int i3 = (hashCode21 + (z ? 1 : 0)) * 31;
        Boolean bool2 = this.canComment;
        int hashCode22 = (i3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.canShare;
        int hashCode23 = (hashCode22 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.isSensitive;
        int hashCode24 = (hashCode23 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.isFlaggedByUser;
        int hashCode25 = (hashCode24 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        String str13 = this.deepLinkUrl;
        int hashCode26 = (((((hashCode25 + (str13 != null ? str13.hashCode() : 0)) * 31) + Integer.valueOf(this.category).hashCode()) * 31) + Integer.valueOf(this.following).hashCode()) * 31;
        String str14 = this.viewAllUrl;
        int hashCode27 = (hashCode26 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.buckets;
        int hashCode28 = (hashCode27 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.feedItemType;
        int hashCode29 = (hashCode28 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.logoUrl;
        int hashCode30 = (hashCode29 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.shareUrl;
        int hashCode31 = (hashCode30 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.name;
        int hashCode32 = (((((((((hashCode31 + (str19 != null ? str19.hashCode() : 0)) * 31) + Integer.valueOf(this.feedItemRank).hashCode()) * 31) + Integer.valueOf(this.feedItemCategoryRank).hashCode()) * 31) + Integer.valueOf(this.profileRank).hashCode()) * 31) + Integer.valueOf(this.followingRank).hashCode()) * 31;
        boolean z2 = this.mute;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode32 + (z2 ? 1 : 0)) * 31;
        String str20 = this.mlVersion;
        int hashCode33 = (i4 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.contentFormat;
        int hashCode34 = (hashCode33 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.mlCategory;
        int hashCode35 = (((hashCode34 + (str22 != null ? str22.hashCode() : 0)) * 31) + Double.valueOf(this.score).hashCode()) * 31;
        boolean z3 = this.isBookmarked;
        if (z3) {
            z3 = true;
        }
        int i5 = (hashCode35 + (z3 ? 1 : 0)) * 31;
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
        String str23 = this.likeCountDisplay;
        int hashCode36 = (i7 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.commentCountDisplay;
        int hashCode37 = (hashCode36 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.shareCountDisplay;
        int hashCode38 = (hashCode37 + (str25 != null ? str25.hashCode() : 0)) * 31;
        String str26 = this.homeTeamAbbr;
        int hashCode39 = (hashCode38 + (str26 != null ? str26.hashCode() : 0)) * 31;
        String str27 = this.awayTeamAbbr;
        int hashCode40 = (hashCode39 + (str27 != null ? str27.hashCode() : 0)) * 31;
        String str28 = this.homeTeamLogo;
        int hashCode41 = (hashCode40 + (str28 != null ? str28.hashCode() : 0)) * 31;
        String str29 = this.awayTeamLogo;
        int hashCode42 = (hashCode41 + (str29 != null ? str29.hashCode() : 0)) * 31;
        String str30 = this.homeTeamId;
        int hashCode43 = (hashCode42 + (str30 != null ? str30.hashCode() : 0)) * 31;
        String str31 = this.awayTeamId;
        int hashCode44 = (hashCode43 + (str31 != null ? str31.hashCode() : 0)) * 31;
        String str32 = this.dataUrl;
        int hashCode45 = (hashCode44 + (str32 != null ? str32.hashCode() : 0)) * 31;
        String str33 = this.clickUrl;
        int hashCode46 = (hashCode45 + (str33 != null ? str33.hashCode() : 0)) * 31;
        String str34 = this.matchId;
        int hashCode47 = (hashCode46 + (str34 != null ? str34.hashCode() : 0)) * 31;
        String str35 = this.startTime;
        int hashCode48 = (hashCode47 + (str35 != null ? str35.hashCode() : 0)) * 31;
        String str36 = this.ctaImageUrl;
        int hashCode49 = (hashCode48 + (str36 != null ? str36.hashCode() : 0)) * 31;
        String str37 = this.ctaDisplayText;
        if (str37 != null) {
            i2 = str37.hashCode();
        }
        return hashCode49 + i2;
    }

    public final String toString() {
        return "FeedData(id=" + this.id + ", uiId=" + this.uiId + ", rank=" + this.rank + ", createdBy=" + this.createdBy + ", mlProperties=" + this.mlProperties + ", poweredBy=" + this.poweredBy + ", createdAt=" + this.createdAt + ", imageUrl=" + this.imageUrl + ", width=" + this.width + ", height=" + this.height + ", title=" + this.title + ", webUrl=" + this.webUrl + ", likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", shareCount=" + this.shareCount + ", isLiked=" + this.isLiked + ", description=" + this.description + ", displayTime=" + this.displayTime + ", url=" + this.url + ", streamUrl=" + this.streamUrl + ", duration=" + this.duration + ", viewCount=" + this.viewCount + ", canLike=" + this.canLike + ", canComment=" + this.canComment + ", canShare=" + this.canShare + ", isSensitive=" + this.isSensitive + ", isFlaggedByUser=" + this.isFlaggedByUser + ", deepLinkUrl=" + this.deepLinkUrl + ", category=" + this.category + ", following=" + this.following + ", viewAllUrl=" + this.viewAllUrl + ", buckets=" + this.buckets + ", feedItemType=" + this.feedItemType + ", logoUrl=" + this.logoUrl + ", shareUrl=" + this.shareUrl + ", name=" + this.name + ", feedItemRank=" + this.feedItemRank + ", feedItemCategoryRank=" + this.feedItemCategoryRank + ", profileRank=" + this.profileRank + ", followingRank=" + this.followingRank + ", mute=" + this.mute + ", mlVersion=" + this.mlVersion + ", contentFormat=" + this.contentFormat + ", mlCategory=" + this.mlCategory + ", score=" + this.score + ", isBookmarked=" + this.isBookmarked + ", isFollowed=" + this.isFollowed + ", canFollow=" + this.canFollow + ", likeCountDisplay=" + this.likeCountDisplay + ", commentCountDisplay=" + this.commentCountDisplay + ", shareCountDisplay=" + this.shareCountDisplay + ", homeTeamAbbr=" + this.homeTeamAbbr + ", awayTeamAbbr=" + this.awayTeamAbbr + ", homeTeamLogo=" + this.homeTeamLogo + ", awayTeamLogo=" + this.awayTeamLogo + ", homeTeamId=" + this.homeTeamId + ", awayTeamId=" + this.awayTeamId + ", dataUrl=" + this.dataUrl + ", clickUrl=" + this.clickUrl + ", matchId=" + this.matchId + ", startTime=" + this.startTime + ", ctaImageUrl=" + this.ctaImageUrl + ", ctaDisplayText=" + this.ctaDisplayText + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        Integer num = this.uiId;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
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
        Integer num2 = this.likeCount;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.commentCount;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num4 = this.shareCount;
        if (num4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
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
        parcel.writeString(this.url);
        parcel.writeString(this.streamUrl);
        Integer num5 = this.duration;
        if (num5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num6 = this.viewCount;
        if (num6 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num6.intValue());
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
        parcel.writeString(this.deepLinkUrl);
        parcel.writeInt(this.category);
        parcel.writeInt(this.following);
        parcel.writeString(this.viewAllUrl);
        parcel.writeString(this.buckets);
        parcel.writeString(this.feedItemType);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.shareUrl);
        parcel.writeString(this.name);
        parcel.writeInt(this.feedItemRank);
        parcel.writeInt(this.feedItemCategoryRank);
        parcel.writeInt(this.profileRank);
        parcel.writeInt(this.followingRank);
        parcel.writeInt(this.mute ? 1 : 0);
        parcel.writeString(this.mlVersion);
        parcel.writeString(this.contentFormat);
        parcel.writeString(this.mlCategory);
        parcel.writeDouble(this.score);
        parcel.writeInt(this.isBookmarked ? 1 : 0);
        parcel.writeInt(this.isFollowed ? 1 : 0);
        parcel.writeInt(this.canFollow ? 1 : 0);
        parcel.writeString(this.likeCountDisplay);
        parcel.writeString(this.commentCountDisplay);
        parcel.writeString(this.shareCountDisplay);
        parcel.writeString(this.homeTeamAbbr);
        parcel.writeString(this.awayTeamAbbr);
        parcel.writeString(this.homeTeamLogo);
        parcel.writeString(this.awayTeamLogo);
        parcel.writeString(this.homeTeamId);
        parcel.writeString(this.awayTeamId);
        parcel.writeString(this.dataUrl);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.matchId);
        parcel.writeString(this.startTime);
        parcel.writeString(this.ctaImageUrl);
        parcel.writeString(this.ctaDisplayText);
    }

    public FeedData(String str, Integer num, int i2, CreatedBy createdBy2, MlProperties mlProperties2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, Integer num3, Integer num4, Boolean bool, String str9, String str10, String str11, String str12, Integer num5, Integer num6, boolean z, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str13, int i3, int i4, String str14, String str15, String str16, String str17, String str18, String str19, int i5, int i6, int i7, int i8, boolean z2, String str20, String str21, String str22, double d2, boolean z3, boolean z4, boolean z5, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37) {
        String str38 = str16;
        String str39 = str20;
        String str40 = str21;
        String str41 = str22;
        k.c(str, "id");
        k.c(str38, "feedItemType");
        k.c(str39, "mlVersion");
        k.c(str40, "contentFormat");
        k.c(str41, "mlCategory");
        this.id = str;
        this.uiId = num;
        this.rank = i2;
        this.createdBy = createdBy2;
        this.mlProperties = mlProperties2;
        this.poweredBy = str2;
        this.createdAt = str3;
        this.imageUrl = str4;
        this.width = str5;
        this.height = str6;
        this.title = str7;
        this.webUrl = str8;
        this.likeCount = num2;
        this.commentCount = num3;
        this.shareCount = num4;
        this.isLiked = bool;
        this.description = str9;
        this.displayTime = str10;
        this.url = str11;
        this.streamUrl = str12;
        this.duration = num5;
        this.viewCount = num6;
        this.canLike = z;
        this.canComment = bool2;
        this.canShare = bool3;
        this.isSensitive = bool4;
        this.isFlaggedByUser = bool5;
        this.deepLinkUrl = str13;
        this.category = i3;
        this.following = i4;
        this.viewAllUrl = str14;
        this.buckets = str15;
        this.feedItemType = str38;
        this.logoUrl = str17;
        this.shareUrl = str18;
        this.name = str19;
        this.feedItemRank = i5;
        this.feedItemCategoryRank = i6;
        this.profileRank = i7;
        this.followingRank = i8;
        this.mute = z2;
        this.mlVersion = str39;
        this.contentFormat = str40;
        this.mlCategory = str41;
        this.score = d2;
        this.isBookmarked = z3;
        this.isFollowed = z4;
        this.canFollow = z5;
        this.likeCountDisplay = str23;
        this.commentCountDisplay = str24;
        this.shareCountDisplay = str25;
        this.homeTeamAbbr = str26;
        this.awayTeamAbbr = str27;
        this.homeTeamLogo = str28;
        this.awayTeamLogo = str29;
        this.homeTeamId = str30;
        this.awayTeamId = str31;
        this.dataUrl = str32;
        this.clickUrl = str33;
        this.matchId = str34;
        this.startTime = str35;
        this.ctaImageUrl = str36;
        this.ctaDisplayText = str37;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final Integer getUiId() {
        return this.uiId;
    }

    public final void setUiId(Integer num) {
        this.uiId = num;
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

    public final String getUrl() {
        return this.url;
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

    public final String getDeepLinkUrl() {
        return this.deepLinkUrl;
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

    public final String getViewAllUrl() {
        return this.viewAllUrl;
    }

    public final void setViewAllUrl(String str) {
        this.viewAllUrl = str;
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
        k.c(str, "<set-?>");
        this.feedItemType = str;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
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

    public final int getFollowingRank() {
        return this.followingRank;
    }

    public final void setFollowingRank(int i2) {
        this.followingRank = i2;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final void setMute(boolean z) {
        this.mute = z;
    }

    public final String getMlVersion() {
        return this.mlVersion;
    }

    public final void setMlVersion(String str) {
        k.c(str, "<set-?>");
        this.mlVersion = str;
    }

    public final String getContentFormat() {
        return this.contentFormat;
    }

    public final void setContentFormat(String str) {
        k.c(str, "<set-?>");
        this.contentFormat = str;
    }

    public final String getMlCategory() {
        return this.mlCategory;
    }

    public final void setMlCategory(String str) {
        k.c(str, "<set-?>");
        this.mlCategory = str;
    }

    public final double getScore() {
        return this.score;
    }

    public final void setScore(double d2) {
        this.score = d2;
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

    public final String getHomeTeamAbbr() {
        return this.homeTeamAbbr;
    }

    public final void setHomeTeamAbbr(String str) {
        this.homeTeamAbbr = str;
    }

    public final String getAwayTeamAbbr() {
        return this.awayTeamAbbr;
    }

    public final void setAwayTeamAbbr(String str) {
        this.awayTeamAbbr = str;
    }

    public final String getHomeTeamLogo() {
        return this.homeTeamLogo;
    }

    public final void setHomeTeamLogo(String str) {
        this.homeTeamLogo = str;
    }

    public final String getAwayTeamLogo() {
        return this.awayTeamLogo;
    }

    public final void setAwayTeamLogo(String str) {
        this.awayTeamLogo = str;
    }

    public final String getHomeTeamId() {
        return this.homeTeamId;
    }

    public final void setHomeTeamId(String str) {
        this.homeTeamId = str;
    }

    public final String getAwayTeamId() {
        return this.awayTeamId;
    }

    public final void setAwayTeamId(String str) {
        this.awayTeamId = str;
    }

    public final String getDataUrl() {
        return this.dataUrl;
    }

    public final void setDataUrl(String str) {
        this.dataUrl = str;
    }

    public final String getClickUrl() {
        return this.clickUrl;
    }

    public final void setClickUrl(String str) {
        this.clickUrl = str;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    public final void setMatchId(String str) {
        this.matchId = str;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
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
