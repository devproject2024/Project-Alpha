package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.repository.models.merchantstorefront.Brand;
import net.one97.paytm.feed.repository.models.polls.PollsData;
import net.one97.paytm.feed.repository.models.promobanner.Banner;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.repository.models.trending.Trending;
import net.one97.paytm.feed.utility.b;

public class FeedDataMinimal extends FeedItem {
    public static final Parcelable.Creator<FeedDataMinimal> CREATOR = new Parcelable.Creator<FeedDataMinimal>() {
        public final FeedDataMinimal createFromParcel(Parcel parcel) {
            return new FeedDataMinimal(parcel);
        }

        public final FeedDataMinimal[] newArray(int i2) {
            return new FeedDataMinimal[i2];
        }
    };
    private String awayTeamAbbr;
    private String awayTeamId;
    private String awayTeamLogo;
    public List<Banner> bannersList;
    public List<Brand> brands;
    public boolean canComment;
    private boolean canFollow;
    public boolean canLike;
    public boolean canShare;
    private int category;
    public List<Channel> channelList;
    private String clickUrl;
    @c(a = "commentCountValue")
    private int commentCount;
    private String commentCountDisplay;
    public List<CommentResponse> commentList;
    private String createdAt;
    @c(a = "publisher")
    private CreatedBy createdBy;
    private String ctaDisplayText;
    private String ctaImageUrl;
    private String dataUrl;
    @c(a = "deepLink")
    private String deepLinkUrl;
    private String description;
    private String displayTime;
    private int duration;
    private String formatTime;
    private String height;
    private String homeTeamAbbr;
    private String homeTeamId;
    private String homeTeamLogo;
    private String id;
    private String imageUrl;
    private boolean isBookmarked;
    private boolean isFlaggedByUser;
    private boolean isFollowed;
    private boolean isLiked;
    private boolean isSensitive;
    @c(a = "likeCountValue")
    private int likeCount;
    private String likeCountDisplay;
    private String logoUrl;
    private String matchId;
    private MlProperties mlProperties;
    private boolean mute;
    private String name;
    public List<PollsData> pollsList;
    private String poweredBy;
    private String publisherImage;
    private int rank;
    public List<RecommendedApps> recommendedAppsList;
    public List<FeedOfFeed> recommendedList;
    @c(a = "shareCountValue")
    private int shareCount;
    private String shareCountDisplay;
    private String shareUrl;
    private String startTime;
    public List<Stories> storiesList;
    private String streamUrl;
    private String title;
    public List<Trending> trendingList;
    private int uiId;
    private String url;
    private String viewAllUrl;
    private int viewCount;
    private String webUrl;
    private String width;

    public int describeContents() {
        return 0;
    }

    public FeedDataMinimal() {
    }

    protected FeedDataMinimal(Parcel parcel) {
        this.id = parcel.readString();
        this.rank = parcel.readInt();
        this.createdBy = (CreatedBy) parcel.readParcelable(CreatedBy.class.getClassLoader());
        this.mlProperties = (MlProperties) parcel.readParcelable(MlProperties.class.getClassLoader());
        this.poweredBy = parcel.readString();
        this.createdAt = parcel.readString();
        this.imageUrl = parcel.readString();
        this.width = parcel.readString();
        this.height = parcel.readString();
        this.title = parcel.readString();
        this.webUrl = parcel.readString();
        this.likeCount = parcel.readInt();
        this.commentCount = parcel.readInt();
        this.shareCount = parcel.readInt();
        boolean z = true;
        this.isLiked = parcel.readByte() != 0;
        this.description = parcel.readString();
        this.displayTime = parcel.readString();
        this.url = parcel.readString();
        this.streamUrl = parcel.readString();
        this.duration = parcel.readInt();
        this.viewCount = parcel.readInt();
        this.canLike = parcel.readByte() != 0;
        this.canComment = parcel.readByte() != 0;
        this.canShare = parcel.readByte() != 0;
        this.isSensitive = parcel.readByte() != 0;
        this.isFlaggedByUser = parcel.readByte() != 0;
        this.deepLinkUrl = parcel.readString();
        this.category = parcel.readInt();
        this.viewAllUrl = parcel.readString();
        this.name = parcel.readString();
        this.logoUrl = parcel.readString();
        this.shareUrl = parcel.readString();
        this.formatTime = parcel.readString();
        this.channelList = parcel.createTypedArrayList(Channel.CREATOR);
        this.brands = parcel.createTypedArrayList(Brand.CREATOR);
        this.bannersList = parcel.createTypedArrayList(Banner.CREATOR);
        this.trendingList = (List) parcel.readParcelable(Trending.class.getClassLoader());
        this.mute = parcel.readByte() == 0 ? false : z;
        this.publisherImage = parcel.readString();
        this.dataUrl = parcel.readString();
        this.clickUrl = parcel.readString();
        this.matchId = parcel.readString();
        this.startTime = parcel.readString();
        this.uiId = parcel.readInt();
        this.ctaImageUrl = parcel.readString();
        this.ctaDisplayText = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeInt(this.rank);
        parcel.writeParcelable(this.createdBy, i2);
        parcel.writeParcelable(this.mlProperties, i2);
        parcel.writeString(this.poweredBy);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.width);
        parcel.writeString(this.height);
        parcel.writeString(this.title);
        parcel.writeString(this.webUrl);
        parcel.writeInt(this.likeCount);
        parcel.writeInt(this.commentCount);
        parcel.writeInt(this.shareCount);
        parcel.writeByte(this.isLiked ? (byte) 1 : 0);
        parcel.writeString(this.description);
        parcel.writeString(this.displayTime);
        parcel.writeString(this.url);
        parcel.writeString(this.streamUrl);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.viewCount);
        parcel.writeByte(this.canLike ? (byte) 1 : 0);
        parcel.writeByte(this.canComment ? (byte) 1 : 0);
        parcel.writeByte(this.canShare ? (byte) 1 : 0);
        parcel.writeByte(this.isSensitive ? (byte) 1 : 0);
        parcel.writeByte(this.isFlaggedByUser ? (byte) 1 : 0);
        parcel.writeString(this.deepLinkUrl);
        parcel.writeInt(this.category);
        parcel.writeString(this.viewAllUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.shareUrl);
        parcel.writeString(this.formatTime);
        parcel.writeTypedList(this.channelList);
        parcel.writeTypedList(this.brands);
        parcel.writeTypedList(this.bannersList);
        parcel.writeTypedList(this.trendingList);
        parcel.writeByte(this.mute ? (byte) 1 : 0);
        parcel.writeString(this.publisherImage);
        parcel.writeString(this.dataUrl);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.matchId);
        parcel.writeString(this.startTime);
        parcel.writeInt(this.uiId);
        parcel.writeString(this.ctaImageUrl);
        parcel.writeString(this.ctaDisplayText);
    }

    public String getId() {
        return this.id;
    }

    public int getRank() {
        return this.rank;
    }

    public CreatedBy getCreatedBy() {
        return this.createdBy;
    }

    public MlProperties getMlProperties() {
        return this.mlProperties;
    }

    public String getPoweredBy() {
        return this.poweredBy;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getWidth() {
        return this.width;
    }

    public String getHeight() {
        return this.height;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public int getShareCount() {
        return this.shareCount;
    }

    public boolean isLiked() {
        return this.isLiked;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisplayTime() {
        return this.displayTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String getStreamUrl() {
        return this.streamUrl;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getViewCount() {
        return this.viewCount;
    }

    public boolean isCanLike() {
        return this.canLike;
    }

    public boolean isCanComment() {
        return this.canComment;
    }

    public boolean isCanShare() {
        return this.canShare;
    }

    public boolean isSensitive() {
        return this.isSensitive;
    }

    public boolean isFlaggedByUser() {
        return this.isFlaggedByUser;
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public List<Channel> getChannelList() {
        return this.channelList;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setRank(int i2) {
        this.rank = i2;
    }

    public void setCreatedBy(CreatedBy createdBy2) {
        this.createdBy = createdBy2;
    }

    public void setMlProperties(MlProperties mlProperties2) {
        this.mlProperties = mlProperties2;
    }

    public void setPoweredBy(String str) {
        this.poweredBy = str;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
        this.formatTime = b.a(str);
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public void setLikeCount(int i2) {
        this.likeCount = i2;
    }

    public void setCommentCount(int i2) {
        this.commentCount = i2;
    }

    public void setShareCount(int i2) {
        this.shareCount = i2;
    }

    public void setLiked(boolean z) {
        this.isLiked = z;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDisplayTime(String str) {
        this.displayTime = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setStreamUrl(String str) {
        this.streamUrl = str;
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setViewCount(int i2) {
        this.viewCount = i2;
    }

    public void setCanLike(boolean z) {
        this.canLike = z;
    }

    public void setCanComment(boolean z) {
        this.canComment = z;
    }

    public void setCanShare(boolean z) {
        this.canShare = z;
    }

    public void setSensitive(boolean z) {
        this.isSensitive = z;
    }

    public void setFlaggedByUser(boolean z) {
        this.isFlaggedByUser = z;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setChannelList(List<Channel> list) {
        this.channelList = list;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int i2) {
        this.category = i2;
    }

    public String getViewAllUrl() {
        return this.viewAllUrl;
    }

    public void setViewAllUrl(String str) {
        this.viewAllUrl = str;
    }

    public List<Brand> getBrands() {
        return this.brands;
    }

    public void setBrands(List<Brand> list) {
        this.brands = list;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public String getFormatTime() {
        return this.formatTime;
    }

    public void setFormatTime(String str) {
        this.formatTime = str;
    }

    public List<CommentResponse> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<CommentResponse> list) {
        this.commentList = list;
    }

    public boolean isBookmarked() {
        return this.isBookmarked;
    }

    public void setBookmarked(boolean z) {
        this.isBookmarked = z;
    }

    public boolean isFollowed() {
        return this.isFollowed;
    }

    public void setFollowed(boolean z) {
        this.isFollowed = z;
    }

    public boolean isCanFollow() {
        return this.canFollow;
    }

    public void setCanFollow(boolean z) {
        this.canFollow = z;
    }

    public String getLikeCountDisplay() {
        return this.likeCountDisplay;
    }

    public void setLikeCountDisplay(String str) {
        this.likeCountDisplay = str;
    }

    public String getCommentCountDisplay() {
        return this.commentCountDisplay;
    }

    public void setCommentCountDisplay(String str) {
        this.commentCountDisplay = str;
    }

    public String getShareCountDisplay() {
        return this.shareCountDisplay;
    }

    public void setShareCountDisplay(String str) {
        this.shareCountDisplay = str;
    }

    public List<Banner> getBannersList() {
        return this.bannersList;
    }

    public void setBannersList(List<Banner> list) {
        this.bannersList = list;
    }

    public List<Trending> getTrendingList() {
        return this.trendingList;
    }

    public void setTrendingList(List<Trending> list) {
        this.trendingList = list;
    }

    public String getHomeTeamAbbr() {
        return this.homeTeamAbbr;
    }

    public void setHomeTeamAbbr(String str) {
        this.homeTeamAbbr = str;
    }

    public String getAwayTeamAbbr() {
        return this.awayTeamAbbr;
    }

    public void setAwayTeamAbbr(String str) {
        this.awayTeamAbbr = str;
    }

    public String getHomeTeamLogo() {
        return this.homeTeamLogo;
    }

    public void setHomeTeamLogo(String str) {
        this.homeTeamLogo = str;
    }

    public String getAwayTeamLogo() {
        return this.awayTeamLogo;
    }

    public void setAwayTeamLogo(String str) {
        this.awayTeamLogo = str;
    }

    public String getHomeTeamId() {
        return this.homeTeamId;
    }

    public void setHomeTeamId(String str) {
        this.homeTeamId = str;
    }

    public String getAwayTeamId() {
        return this.awayTeamId;
    }

    public void setAwayTeamId(String str) {
        this.awayTeamId = str;
    }

    public boolean isMute() {
        return this.mute;
    }

    public void setMute(boolean z) {
        this.mute = z;
    }

    public String getPublisherImage() {
        return this.publisherImage;
    }

    public void setPublisherImage(String str) {
        this.publisherImage = str;
    }

    public String getDataUrl() {
        return this.dataUrl;
    }

    public void setDataUrl(String str) {
        this.dataUrl = str;
    }

    public String getClickUrl() {
        return this.clickUrl;
    }

    public void setClickUrl(String str) {
        this.clickUrl = str;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public void setMatchId(String str) {
        this.matchId = str;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public int getUiId() {
        return this.uiId;
    }

    public void setUiId(int i2) {
        this.uiId = i2;
    }

    public String getCtaImageUrl() {
        return this.ctaImageUrl;
    }

    public void setCtaImageUrl(String str) {
        this.ctaImageUrl = str;
    }

    public String getCtaDisplayText() {
        return this.ctaDisplayText;
    }

    public void setCtaDisplayText(String str) {
        this.ctaDisplayText = str;
    }
}
