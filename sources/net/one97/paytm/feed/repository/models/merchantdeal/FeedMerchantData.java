package net.one97.paytm.feed.repository.models.merchantdeal;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class FeedMerchantData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final boolean canComment;
    private boolean canFollow;
    private final boolean canLike;
    private final boolean canShare;
    private final int commentCount;
    private final String createdAt;
    private final String deepLinkUrl;
    private final String description;
    private final String id;
    private final String imageUrl;
    private boolean isFollowed;
    private boolean isLiked;
    private final boolean isSensitive;
    private final int likeCount;
    private String likeCountDisplay;
    private final String logoUrl;
    private final String name;
    private final int shareCount;
    private String shareCountDisplay;
    private final String shareUrl;
    private final String title;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedMerchantData(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedMerchantData[i2];
        }
    }

    public static /* synthetic */ FeedMerchantData copy$default(FeedMerchantData feedMerchantData, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z4, boolean z5, int i2, int i3, int i4, String str9, boolean z6, boolean z7, String str10, String str11, int i5, Object obj) {
        FeedMerchantData feedMerchantData2 = feedMerchantData;
        int i6 = i5;
        return feedMerchantData.copy((i6 & 1) != 0 ? feedMerchantData2.id : str, (i6 & 2) != 0 ? feedMerchantData2.canLike : z, (i6 & 4) != 0 ? feedMerchantData2.canShare : z2, (i6 & 8) != 0 ? feedMerchantData2.canComment : z3, (i6 & 16) != 0 ? feedMerchantData2.description : str2, (i6 & 32) != 0 ? feedMerchantData2.createdAt : str3, (i6 & 64) != 0 ? feedMerchantData2.logoUrl : str4, (i6 & 128) != 0 ? feedMerchantData2.shareUrl : str5, (i6 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? feedMerchantData2.deepLinkUrl : str6, (i6 & 512) != 0 ? feedMerchantData2.name : str7, (i6 & TarConstants.EOF_BLOCK) != 0 ? feedMerchantData2.imageUrl : str8, (i6 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? feedMerchantData2.isLiked : z4, (i6 & 4096) != 0 ? feedMerchantData2.isSensitive : z5, (i6 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? feedMerchantData2.likeCount : i2, (i6 & 16384) != 0 ? feedMerchantData2.shareCount : i3, (i6 & 32768) != 0 ? feedMerchantData2.commentCount : i4, (i6 & 65536) != 0 ? feedMerchantData2.title : str9, (i6 & 131072) != 0 ? feedMerchantData2.isFollowed : z6, (i6 & 262144) != 0 ? feedMerchantData2.canFollow : z7, (i6 & 524288) != 0 ? feedMerchantData2.likeCountDisplay : str10, (i6 & 1048576) != 0 ? feedMerchantData2.shareCountDisplay : str11);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.name;
    }

    public final String component11() {
        return this.imageUrl;
    }

    public final boolean component12() {
        return this.isLiked;
    }

    public final boolean component13() {
        return this.isSensitive;
    }

    public final int component14() {
        return this.likeCount;
    }

    public final int component15() {
        return this.shareCount;
    }

    public final int component16() {
        return this.commentCount;
    }

    public final String component17() {
        return this.title;
    }

    public final boolean component18() {
        return this.isFollowed;
    }

    public final boolean component19() {
        return this.canFollow;
    }

    public final boolean component2() {
        return this.canLike;
    }

    public final String component20() {
        return this.likeCountDisplay;
    }

    public final String component21() {
        return this.shareCountDisplay;
    }

    public final boolean component3() {
        return this.canShare;
    }

    public final boolean component4() {
        return this.canComment;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.createdAt;
    }

    public final String component7() {
        return this.logoUrl;
    }

    public final String component8() {
        return this.shareUrl;
    }

    public final String component9() {
        return this.deepLinkUrl;
    }

    public final FeedMerchantData copy(String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z4, boolean z5, int i2, int i3, int i4, String str9, boolean z6, boolean z7, String str10, String str11) {
        String str12 = str;
        k.c(str12, "id");
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str3, "createdAt");
        k.c(str4, "logoUrl");
        k.c(str5, "shareUrl");
        k.c(str6, "deepLinkUrl");
        k.c(str7, "name");
        k.c(str8, "imageUrl");
        k.c(str9, "title");
        k.c(str10, "likeCountDisplay");
        k.c(str11, "shareCountDisplay");
        return new FeedMerchantData(str12, z, z2, z3, str2, str3, str4, str5, str6, str7, str8, z4, z5, i2, i3, i4, str9, z6, z7, str10, str11);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedMerchantData) {
                FeedMerchantData feedMerchantData = (FeedMerchantData) obj;
                if (k.a((Object) this.id, (Object) feedMerchantData.id)) {
                    if (this.canLike == feedMerchantData.canLike) {
                        if (this.canShare == feedMerchantData.canShare) {
                            if ((this.canComment == feedMerchantData.canComment) && k.a((Object) this.description, (Object) feedMerchantData.description) && k.a((Object) this.createdAt, (Object) feedMerchantData.createdAt) && k.a((Object) this.logoUrl, (Object) feedMerchantData.logoUrl) && k.a((Object) this.shareUrl, (Object) feedMerchantData.shareUrl) && k.a((Object) this.deepLinkUrl, (Object) feedMerchantData.deepLinkUrl) && k.a((Object) this.name, (Object) feedMerchantData.name) && k.a((Object) this.imageUrl, (Object) feedMerchantData.imageUrl)) {
                                if (this.isLiked == feedMerchantData.isLiked) {
                                    if (this.isSensitive == feedMerchantData.isSensitive) {
                                        if (this.likeCount == feedMerchantData.likeCount) {
                                            if (this.shareCount == feedMerchantData.shareCount) {
                                                if ((this.commentCount == feedMerchantData.commentCount) && k.a((Object) this.title, (Object) feedMerchantData.title)) {
                                                    if (this.isFollowed == feedMerchantData.isFollowed) {
                                                        if (!(this.canFollow == feedMerchantData.canFollow) || !k.a((Object) this.likeCountDisplay, (Object) feedMerchantData.likeCountDisplay) || !k.a((Object) this.shareCountDisplay, (Object) feedMerchantData.shareCountDisplay)) {
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
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.canLike;
        if (z) {
            z = true;
        }
        int i3 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z2 = this.canShare;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.canComment;
        if (z3) {
            z3 = true;
        }
        int i5 = (i4 + (z3 ? 1 : 0)) * 31;
        String str2 = this.description;
        int hashCode2 = (i5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.createdAt;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.logoUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.shareUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.deepLinkUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.name;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.imageUrl;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z4 = this.isLiked;
        if (z4) {
            z4 = true;
        }
        int i6 = (hashCode8 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isSensitive;
        if (z5) {
            z5 = true;
        }
        int hashCode9 = (((((((i6 + (z5 ? 1 : 0)) * 31) + Integer.valueOf(this.likeCount).hashCode()) * 31) + Integer.valueOf(this.shareCount).hashCode()) * 31) + Integer.valueOf(this.commentCount).hashCode()) * 31;
        String str9 = this.title;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        boolean z6 = this.isFollowed;
        if (z6) {
            z6 = true;
        }
        int i7 = (hashCode10 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.canFollow;
        if (z7) {
            z7 = true;
        }
        int i8 = (i7 + (z7 ? 1 : 0)) * 31;
        String str10 = this.likeCountDisplay;
        int hashCode11 = (i8 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.shareCountDisplay;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "FeedMerchantData(id=" + this.id + ", canLike=" + this.canLike + ", canShare=" + this.canShare + ", canComment=" + this.canComment + ", description=" + this.description + ", createdAt=" + this.createdAt + ", logoUrl=" + this.logoUrl + ", shareUrl=" + this.shareUrl + ", deepLinkUrl=" + this.deepLinkUrl + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ", isLiked=" + this.isLiked + ", isSensitive=" + this.isSensitive + ", likeCount=" + this.likeCount + ", shareCount=" + this.shareCount + ", commentCount=" + this.commentCount + ", title=" + this.title + ", isFollowed=" + this.isFollowed + ", canFollow=" + this.canFollow + ", likeCountDisplay=" + this.likeCountDisplay + ", shareCountDisplay=" + this.shareCountDisplay + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.canLike ? 1 : 0);
        parcel.writeInt(this.canShare ? 1 : 0);
        parcel.writeInt(this.canComment ? 1 : 0);
        parcel.writeString(this.description);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.shareUrl);
        parcel.writeString(this.deepLinkUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.isLiked ? 1 : 0);
        parcel.writeInt(this.isSensitive ? 1 : 0);
        parcel.writeInt(this.likeCount);
        parcel.writeInt(this.shareCount);
        parcel.writeInt(this.commentCount);
        parcel.writeString(this.title);
        parcel.writeInt(this.isFollowed ? 1 : 0);
        parcel.writeInt(this.canFollow ? 1 : 0);
        parcel.writeString(this.likeCountDisplay);
        parcel.writeString(this.shareCountDisplay);
    }

    public FeedMerchantData(String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z4, boolean z5, int i2, int i3, int i4, String str9, boolean z6, boolean z7, String str10, String str11) {
        String str12 = str2;
        String str13 = str3;
        String str14 = str4;
        String str15 = str5;
        String str16 = str6;
        String str17 = str7;
        String str18 = str8;
        String str19 = str9;
        String str20 = str10;
        String str21 = str11;
        k.c(str, "id");
        k.c(str12, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str13, "createdAt");
        k.c(str14, "logoUrl");
        k.c(str15, "shareUrl");
        k.c(str16, "deepLinkUrl");
        k.c(str17, "name");
        k.c(str18, "imageUrl");
        k.c(str19, "title");
        k.c(str20, "likeCountDisplay");
        k.c(str21, "shareCountDisplay");
        this.id = str;
        this.canLike = z;
        this.canShare = z2;
        this.canComment = z3;
        this.description = str12;
        this.createdAt = str13;
        this.logoUrl = str14;
        this.shareUrl = str15;
        this.deepLinkUrl = str16;
        this.name = str17;
        this.imageUrl = str18;
        this.isLiked = z4;
        this.isSensitive = z5;
        this.likeCount = i2;
        this.shareCount = i3;
        this.commentCount = i4;
        this.title = str19;
        this.isFollowed = z6;
        this.canFollow = z7;
        this.likeCountDisplay = str20;
        this.shareCountDisplay = str21;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getCanLike() {
        return this.canLike;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final boolean getCanComment() {
        return this.canComment;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }

    public final void setLiked(boolean z) {
        this.isLiked = z;
    }

    public final boolean isSensitive() {
        return this.isSensitive;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final int getShareCount() {
        return this.shareCount;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final String getTitle() {
        return this.title;
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
        k.c(str, "<set-?>");
        this.likeCountDisplay = str;
    }

    public final String getShareCountDisplay() {
        return this.shareCountDisplay;
    }

    public final void setShareCountDisplay(String str) {
        k.c(str, "<set-?>");
        this.shareCountDisplay = str;
    }
}
