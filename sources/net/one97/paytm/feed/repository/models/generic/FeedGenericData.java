package net.one97.paytm.feed.repository.models.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.CreatedBy;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.feed.repository.models.MlProperties;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class FeedGenericData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Boolean canComment;
    private Boolean canFollow;
    private final Boolean canLike;
    private final Boolean canShare;
    private final Integer commentCount;
    private String commentCountDisplay;
    private final String createdAt;
    @c(a = "publisher")
    private final CreatedBy createdBy;
    private String ctaDisplayText;
    private String ctaImageUrl;
    private String deeplink;
    private final String description;
    private String displayTime;
    private Integer duration;
    private final String height;
    private final String id;
    private final String imageUrl;
    private boolean isBookmarked;
    private boolean isFollowed;
    private Boolean isLiked;
    private final Boolean isSensitive;
    private final Integer likeCount;
    private String likeCountDisplay;
    private final MlProperties mlProperties;
    private final boolean mute;
    private final String poweredBy;
    private String publisherImage;
    private final Integer shareCount;
    private String shareCountDisplay;
    private String streamUrl;
    private final String title;
    private String viewCountDisplay;
    private final String webUrl;
    private final String width;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Boolean bool4;
            Boolean bool5;
            Boolean bool6;
            Parcel parcel2 = parcel;
            k.c(parcel2, "in");
            String readString = parcel.readString();
            CreatedBy createdBy = (CreatedBy) parcel2.readParcelable(FeedGenericData.class.getClassLoader());
            MlProperties mlProperties = parcel.readInt() != 0 ? (MlProperties) MlProperties.CREATOR.createFromParcel(parcel2) : null;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf3 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
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
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                bool6 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool6 = null;
            }
            return new FeedGenericData(readString, createdBy, mlProperties, readString2, readString3, readString4, readString5, readString6, readString7, readString8, valueOf, valueOf2, valueOf3, bool, readString9, readString10, bool2, bool3, bool4, bool5, z, z2, bool6, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedGenericData[i2];
        }
    }

    public static /* synthetic */ FeedGenericData copy$default(FeedGenericData feedGenericData, String str, CreatedBy createdBy2, MlProperties mlProperties2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, Integer num3, Boolean bool, String str9, String str10, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, boolean z, boolean z2, Boolean bool6, String str11, String str12, String str13, String str14, String str15, Integer num4, String str16, String str17, boolean z3, String str18, String str19, int i2, int i3, Object obj) {
        FeedGenericData feedGenericData2 = feedGenericData;
        int i4 = i2;
        return feedGenericData.copy((i4 & 1) != 0 ? feedGenericData2.id : str, (i4 & 2) != 0 ? feedGenericData2.createdBy : createdBy2, (i4 & 4) != 0 ? feedGenericData2.mlProperties : mlProperties2, (i4 & 8) != 0 ? feedGenericData2.poweredBy : str2, (i4 & 16) != 0 ? feedGenericData2.createdAt : str3, (i4 & 32) != 0 ? feedGenericData2.imageUrl : str4, (i4 & 64) != 0 ? feedGenericData2.width : str5, (i4 & 128) != 0 ? feedGenericData2.height : str6, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? feedGenericData2.title : str7, (i4 & 512) != 0 ? feedGenericData2.webUrl : str8, (i4 & TarConstants.EOF_BLOCK) != 0 ? feedGenericData2.likeCount : num, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? feedGenericData2.commentCount : num2, (i4 & 4096) != 0 ? feedGenericData2.shareCount : num3, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? feedGenericData2.isLiked : bool, (i4 & 16384) != 0 ? feedGenericData2.description : str9, (i4 & 32768) != 0 ? feedGenericData2.displayTime : str10, (i4 & 65536) != 0 ? feedGenericData2.canLike : bool2, (i4 & 131072) != 0 ? feedGenericData2.canComment : bool3, (i4 & 262144) != 0 ? feedGenericData2.canShare : bool4, (i4 & 524288) != 0 ? feedGenericData2.isSensitive : bool5, (i4 & 1048576) != 0 ? feedGenericData2.isBookmarked : z, (i4 & 2097152) != 0 ? feedGenericData2.isFollowed : z2, (i4 & 4194304) != 0 ? feedGenericData2.canFollow : bool6, (i4 & 8388608) != 0 ? feedGenericData2.likeCountDisplay : str11, (i4 & 16777216) != 0 ? feedGenericData2.commentCountDisplay : str12, (i4 & 33554432) != 0 ? feedGenericData2.shareCountDisplay : str13, (i4 & 67108864) != 0 ? feedGenericData2.deeplink : str14, (i4 & 134217728) != 0 ? feedGenericData2.streamUrl : str15, (i4 & 268435456) != 0 ? feedGenericData2.duration : num4, (i4 & 536870912) != 0 ? feedGenericData2.viewCountDisplay : str16, (i4 & 1073741824) != 0 ? feedGenericData2.publisherImage : str17, (i4 & Integer.MIN_VALUE) != 0 ? feedGenericData2.mute : z3, (i3 & 1) != 0 ? feedGenericData2.ctaImageUrl : str18, (i3 & 2) != 0 ? feedGenericData2.ctaDisplayText : str19);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.webUrl;
    }

    public final Integer component11() {
        return this.likeCount;
    }

    public final Integer component12() {
        return this.commentCount;
    }

    public final Integer component13() {
        return this.shareCount;
    }

    public final Boolean component14() {
        return this.isLiked;
    }

    public final String component15() {
        return this.description;
    }

    public final String component16() {
        return this.displayTime;
    }

    public final Boolean component17() {
        return this.canLike;
    }

    public final Boolean component18() {
        return this.canComment;
    }

    public final Boolean component19() {
        return this.canShare;
    }

    public final CreatedBy component2() {
        return this.createdBy;
    }

    public final Boolean component20() {
        return this.isSensitive;
    }

    public final boolean component21() {
        return this.isBookmarked;
    }

    public final boolean component22() {
        return this.isFollowed;
    }

    public final Boolean component23() {
        return this.canFollow;
    }

    public final String component24() {
        return this.likeCountDisplay;
    }

    public final String component25() {
        return this.commentCountDisplay;
    }

    public final String component26() {
        return this.shareCountDisplay;
    }

    public final String component27() {
        return this.deeplink;
    }

    public final String component28() {
        return this.streamUrl;
    }

    public final Integer component29() {
        return this.duration;
    }

    public final MlProperties component3() {
        return this.mlProperties;
    }

    public final String component30() {
        return this.viewCountDisplay;
    }

    public final String component31() {
        return this.publisherImage;
    }

    public final boolean component32() {
        return this.mute;
    }

    public final String component33() {
        return this.ctaImageUrl;
    }

    public final String component34() {
        return this.ctaDisplayText;
    }

    public final String component4() {
        return this.poweredBy;
    }

    public final String component5() {
        return this.createdAt;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.width;
    }

    public final String component8() {
        return this.height;
    }

    public final String component9() {
        return this.title;
    }

    public final FeedGenericData copy(String str, CreatedBy createdBy2, MlProperties mlProperties2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, Integer num3, Boolean bool, String str9, String str10, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, boolean z, boolean z2, Boolean bool6, String str11, String str12, String str13, String str14, String str15, Integer num4, String str16, String str17, boolean z3, String str18, String str19) {
        String str20 = str;
        String str21 = str20;
        k.c(str20, "id");
        return new FeedGenericData(str20, createdBy2, mlProperties2, str2, str3, str4, str5, str6, str7, str8, num, num2, num3, bool, str9, str10, bool2, bool3, bool4, bool5, z, z2, bool6, str11, str12, str13, str14, str15, num4, str16, str17, z3, str18, str19);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedGenericData) {
                FeedGenericData feedGenericData = (FeedGenericData) obj;
                if (k.a((Object) this.id, (Object) feedGenericData.id) && k.a((Object) this.createdBy, (Object) feedGenericData.createdBy) && k.a((Object) this.mlProperties, (Object) feedGenericData.mlProperties) && k.a((Object) this.poweredBy, (Object) feedGenericData.poweredBy) && k.a((Object) this.createdAt, (Object) feedGenericData.createdAt) && k.a((Object) this.imageUrl, (Object) feedGenericData.imageUrl) && k.a((Object) this.width, (Object) feedGenericData.width) && k.a((Object) this.height, (Object) feedGenericData.height) && k.a((Object) this.title, (Object) feedGenericData.title) && k.a((Object) this.webUrl, (Object) feedGenericData.webUrl) && k.a((Object) this.likeCount, (Object) feedGenericData.likeCount) && k.a((Object) this.commentCount, (Object) feedGenericData.commentCount) && k.a((Object) this.shareCount, (Object) feedGenericData.shareCount) && k.a((Object) this.isLiked, (Object) feedGenericData.isLiked) && k.a((Object) this.description, (Object) feedGenericData.description) && k.a((Object) this.displayTime, (Object) feedGenericData.displayTime) && k.a((Object) this.canLike, (Object) feedGenericData.canLike) && k.a((Object) this.canComment, (Object) feedGenericData.canComment) && k.a((Object) this.canShare, (Object) feedGenericData.canShare) && k.a((Object) this.isSensitive, (Object) feedGenericData.isSensitive)) {
                    if (this.isBookmarked == feedGenericData.isBookmarked) {
                        if ((this.isFollowed == feedGenericData.isFollowed) && k.a((Object) this.canFollow, (Object) feedGenericData.canFollow) && k.a((Object) this.likeCountDisplay, (Object) feedGenericData.likeCountDisplay) && k.a((Object) this.commentCountDisplay, (Object) feedGenericData.commentCountDisplay) && k.a((Object) this.shareCountDisplay, (Object) feedGenericData.shareCountDisplay) && k.a((Object) this.deeplink, (Object) feedGenericData.deeplink) && k.a((Object) this.streamUrl, (Object) feedGenericData.streamUrl) && k.a((Object) this.duration, (Object) feedGenericData.duration) && k.a((Object) this.viewCountDisplay, (Object) feedGenericData.viewCountDisplay) && k.a((Object) this.publisherImage, (Object) feedGenericData.publisherImage)) {
                            if (!(this.mute == feedGenericData.mute) || !k.a((Object) this.ctaImageUrl, (Object) feedGenericData.ctaImageUrl) || !k.a((Object) this.ctaDisplayText, (Object) feedGenericData.ctaDisplayText)) {
                                return false;
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
        CreatedBy createdBy2 = this.createdBy;
        int hashCode2 = (hashCode + (createdBy2 != null ? createdBy2.hashCode() : 0)) * 31;
        MlProperties mlProperties2 = this.mlProperties;
        int hashCode3 = (hashCode2 + (mlProperties2 != null ? mlProperties2.hashCode() : 0)) * 31;
        String str2 = this.poweredBy;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.createdAt;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.width;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.height;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.title;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.webUrl;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num = this.likeCount;
        int hashCode11 = (hashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.commentCount;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.shareCount;
        int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Boolean bool = this.isLiked;
        int hashCode14 = (hashCode13 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str9 = this.description;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.displayTime;
        int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Boolean bool2 = this.canLike;
        int hashCode17 = (hashCode16 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.canComment;
        int hashCode18 = (hashCode17 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.canShare;
        int hashCode19 = (hashCode18 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.isSensitive;
        int hashCode20 = (hashCode19 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        boolean z = this.isBookmarked;
        if (z) {
            z = true;
        }
        int i3 = (hashCode20 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isFollowed;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        Boolean bool6 = this.canFollow;
        int hashCode21 = (i4 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        String str11 = this.likeCountDisplay;
        int hashCode22 = (hashCode21 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.commentCountDisplay;
        int hashCode23 = (hashCode22 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.shareCountDisplay;
        int hashCode24 = (hashCode23 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.deeplink;
        int hashCode25 = (hashCode24 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.streamUrl;
        int hashCode26 = (hashCode25 + (str15 != null ? str15.hashCode() : 0)) * 31;
        Integer num4 = this.duration;
        int hashCode27 = (hashCode26 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str16 = this.viewCountDisplay;
        int hashCode28 = (hashCode27 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.publisherImage;
        int hashCode29 = (hashCode28 + (str17 != null ? str17.hashCode() : 0)) * 31;
        boolean z3 = this.mute;
        if (z3) {
            z3 = true;
        }
        int i5 = (hashCode29 + (z3 ? 1 : 0)) * 31;
        String str18 = this.ctaImageUrl;
        int hashCode30 = (i5 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.ctaDisplayText;
        if (str19 != null) {
            i2 = str19.hashCode();
        }
        return hashCode30 + i2;
    }

    public final String toString() {
        return "FeedGenericData(id=" + this.id + ", createdBy=" + this.createdBy + ", mlProperties=" + this.mlProperties + ", poweredBy=" + this.poweredBy + ", createdAt=" + this.createdAt + ", imageUrl=" + this.imageUrl + ", width=" + this.width + ", height=" + this.height + ", title=" + this.title + ", webUrl=" + this.webUrl + ", likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", shareCount=" + this.shareCount + ", isLiked=" + this.isLiked + ", description=" + this.description + ", displayTime=" + this.displayTime + ", canLike=" + this.canLike + ", canComment=" + this.canComment + ", canShare=" + this.canShare + ", isSensitive=" + this.isSensitive + ", isBookmarked=" + this.isBookmarked + ", isFollowed=" + this.isFollowed + ", canFollow=" + this.canFollow + ", likeCountDisplay=" + this.likeCountDisplay + ", commentCountDisplay=" + this.commentCountDisplay + ", shareCountDisplay=" + this.shareCountDisplay + ", deeplink=" + this.deeplink + ", streamUrl=" + this.streamUrl + ", duration=" + this.duration + ", viewCountDisplay=" + this.viewCountDisplay + ", publisherImage=" + this.publisherImage + ", mute=" + this.mute + ", ctaImageUrl=" + this.ctaImageUrl + ", ctaDisplayText=" + this.ctaDisplayText + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
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
        Boolean bool2 = this.canLike;
        if (bool2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool3 = this.canComment;
        if (bool3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool4 = this.canShare;
        if (bool4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool5 = this.isSensitive;
        if (bool5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.isBookmarked ? 1 : 0);
        parcel.writeInt(this.isFollowed ? 1 : 0);
        Boolean bool6 = this.canFollow;
        if (bool6 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool6.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.likeCountDisplay);
        parcel.writeString(this.commentCountDisplay);
        parcel.writeString(this.shareCountDisplay);
        parcel.writeString(this.deeplink);
        parcel.writeString(this.streamUrl);
        Integer num4 = this.duration;
        if (num4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.viewCountDisplay);
        parcel.writeString(this.publisherImage);
        parcel.writeInt(this.mute ? 1 : 0);
        parcel.writeString(this.ctaImageUrl);
        parcel.writeString(this.ctaDisplayText);
    }

    public FeedGenericData(String str, CreatedBy createdBy2, MlProperties mlProperties2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, Integer num3, Boolean bool, String str9, String str10, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, boolean z, boolean z2, Boolean bool6, String str11, String str12, String str13, String str14, String str15, Integer num4, String str16, String str17, boolean z3, String str18, String str19) {
        k.c(str, "id");
        this.id = str;
        this.createdBy = createdBy2;
        this.mlProperties = mlProperties2;
        this.poweredBy = str2;
        this.createdAt = str3;
        this.imageUrl = str4;
        this.width = str5;
        this.height = str6;
        this.title = str7;
        this.webUrl = str8;
        this.likeCount = num;
        this.commentCount = num2;
        this.shareCount = num3;
        this.isLiked = bool;
        this.description = str9;
        this.displayTime = str10;
        this.canLike = bool2;
        this.canComment = bool3;
        this.canShare = bool4;
        this.isSensitive = bool5;
        this.isBookmarked = z;
        this.isFollowed = z2;
        this.canFollow = bool6;
        this.likeCountDisplay = str11;
        this.commentCountDisplay = str12;
        this.shareCountDisplay = str13;
        this.deeplink = str14;
        this.streamUrl = str15;
        this.duration = num4;
        this.viewCountDisplay = str16;
        this.publisherImage = str17;
        this.mute = z3;
        this.ctaImageUrl = str18;
        this.ctaDisplayText = str19;
    }

    public final String getId() {
        return this.id;
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

    public final void setLiked(Boolean bool) {
        this.isLiked = bool;
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

    public final Boolean getCanLike() {
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

    public final Boolean getCanFollow() {
        return this.canFollow;
    }

    public final void setCanFollow(Boolean bool) {
        this.canFollow = bool;
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

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final void setStreamUrl(String str) {
        this.streamUrl = str;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final void setDuration(Integer num) {
        this.duration = num;
    }

    public final String getViewCountDisplay() {
        return this.viewCountDisplay;
    }

    public final void setViewCountDisplay(String str) {
        this.viewCountDisplay = str;
    }

    public final String getPublisherImage() {
        return this.publisherImage;
    }

    public final void setPublisherImage(String str) {
        this.publisherImage = str;
    }

    public final boolean getMute() {
        return this.mute;
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
