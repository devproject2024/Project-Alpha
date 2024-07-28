package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import java.util.Date;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class FeedDetail extends BaseResponse implements Cloneable {
    public static final String FEED_DETAIL_ID = "FEED_DETAIL_ID";
    public static final String FEED_DETAIL_OBJ = "FEED_DETAIL_OBJ";
    @c(a = "author_city_id")
    private String authorCityId;
    @c(a = "author_city_name")
    private String authorCityName;
    @c(a = "author_first_name")
    private String authorFirstName;
    @c(a = "author_id")
    private long authorId;
    @c(a = "author_image_url")
    private String authorImageUrl;
    @c(a = "author_last_name")
    private String authorLastName;
    @c(a = "author_name")
    private String authorName;
    @c(a = "author_participant_id")
    private long authorParticipantId;
    @c(a = "author_participant_type")
    private String authorParticipantType;
    @c(a = "author_short_description")
    private String authorShortDescription;
    @c(a = "blog_link_s")
    private String blogLinkUrl;
    private String callFromName;
    @c(a = "created_by_l")
    private long createdBy;
    @c(a = "p_crdt")
    private String createdDate;
    @c(a = "solr_ignore_deep_link_url")
    private String deepLinkUrl;
    @c(a = "description")
    private String description;
    @c(a = "solr_ignore_entity_deep_link_url")
    private String entityDeepLinkingUrl;
    @c(a = "entity_or_participant_id")
    private long entityOrParticipantId;
    @c(a = "entity_or_participant_type_id_i")
    private Integer entityOrParticipantTypeId;
    @c(a = "id")
    private String id;
    @c(a = "id_of_entity_or_participant")
    private long idOfEntityOrParticipant;
    @c(a = "image_url")
    private String imageUrl;
    @c(a = "p_is_active")
    private boolean isActive;
    @c(a = "solr_ignore_is_applied")
    private boolean isApplied;
    @c(a = "is_author_confidential")
    private boolean isAuthorConfidential;
    @c(a = "is_author_image_public")
    private boolean isAuthorImagePublic;
    @c(a = "solr_ignore_is_author_mentor")
    private boolean isAuthorMentor;
    @c(a = "solr_ignore_is_bookmarked")
    private boolean isBookmarked;
    @c(a = "solr_ignore_is_challenge_accepted")
    private boolean isChallengeAccepted;
    @c(a = "p_is_deleted")
    private boolean isDeleted;
    @c(a = "is_expired")
    private boolean isExpired;
    @c(a = "is_featured")
    private boolean isFeatured;
    private boolean isFromHome;
    private boolean isLongPress;
    @c(a = "is_og_video_link_b")
    private boolean isOgVideoLinkB;
    @c(a = "is_spam_post_b")
    private boolean isSpamPost;
    private boolean isTrending;
    @c(a = "solr_ignore_is_viewed")
    private boolean isViewed;
    private int itemPosition;
    @c(a = "solr_ignore_last_comments")
    private List<Comment> lastComments;
    @c(a = "p_last_modified_on")
    private Date lastModifiedDate;
    private int lastReactionValue;
    @c(a = "list_description")
    private String listDescription;
    @c(a = "list_short_description")
    private String listShortDescription;
    @c(a = "solr_ignore_mentor_deep_link_url")
    private String mentorDeepLinkUrl;
    @c(a = "name")
    private String nameOrTitle;
    @c(a = "solr_ignore_no_of_applies")
    private int noOfApplied;
    @c(a = "solr_ignore_no_of_bookmarks")
    private int noOfBookmarks = 0;
    @c(a = "solr_ignore_no_of_challenge_accepted")
    private int noOfChallengeAccepted = 0;
    @c(a = "solr_ignore_no_of_comments")
    private int noOfComments = 0;
    @c(a = "solr_ignore_no_of_likes")
    private int noOfLikes = 0;
    @c(a = "solr_ignore_no_of_views")
    private int noOfViews = 0;
    @c(a = "og_description_s")
    private String ogDescriptionS;
    @c(a = "og_image_url_s")
    private String ogImageUrlS;
    @c(a = "og_requested_url_s")
    private String ogRequestedUrlS;
    @c(a = "og_title_s")
    private String ogTitleS;
    @c(a = "solr_ignore_participant_deep_link_url")
    private String participantDeepLinkingUrl;
    @c(a = "post_partner_branch_url_s")
    private String postShortBranchUrls;
    @c(a = "posting_date_dt")
    private String postingDate;
    @c(a = "posting_date_only_dt")
    private Date postingDateOnly;
    @c(a = "display_id_profile_id")
    private long profileId;
    @c(a = "solr_ignore_reacted_value")
    private int reactedValue;
    @c(a = "short_description")
    private String shortDescription;
    @c(a = "solr_ignore_stream_name")
    private String streamType;
    @c(a = "sub_type")
    public String subType;
    @c(a = "tag_ids")
    private List<Long> tag_ids;
    @c(a = "tag_names")
    private List<String> tags;
    @c(a = "thumbnail_image_url")
    private String thumbnailImageUrl;
    @c(a = "type")
    private String type;
    @c(a = "user_sub_type_s")
    private String userSubType;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getEntityOrParticipantId() {
        return this.entityOrParticipantId;
    }

    public void setEntityOrParticipantId(long j) {
        this.entityOrParticipantId = j;
    }

    public Integer getEntityOrParticipantTypeId() {
        return this.entityOrParticipantTypeId;
    }

    public void setEntityOrParticipantTypeId(Integer num) {
        this.entityOrParticipantTypeId = num;
    }

    public long getProfileId() {
        return this.profileId;
    }

    public void setProfileId(long j) {
        this.profileId = j;
    }

    public long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(long j) {
        this.createdBy = j;
    }

    public long getIdOfEntityOrParticipant() {
        return this.idOfEntityOrParticipant;
    }

    public void setIdOfEntityOrParticipant(long j) {
        this.idOfEntityOrParticipant = j;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public String getNameOrTitle() {
        return this.nameOrTitle;
    }

    public void setNameOrTitle(String str) {
        this.nameOrTitle = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getThumbnailImageUrl() {
        return this.thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String str) {
        this.thumbnailImageUrl = str;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String str) {
        this.shortDescription = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getListShortDescription() {
        return this.listShortDescription;
    }

    public void setListShortDescription(String str) {
        this.listShortDescription = str;
    }

    public String getListDescription() {
        return this.listDescription;
    }

    public void setListDescription(String str) {
        this.listDescription = str;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean z) {
        this.isDeleted = z;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String str) {
        this.createdDate = str;
    }

    public String getPostedDate() {
        return this.postingDate;
    }

    public void setPostedDate(String str) {
        this.postingDate = str;
    }

    public Date getPostingDateOnly() {
        return this.postingDateOnly;
    }

    public void setPostingDateOnly(Date date) {
        this.postingDateOnly = date;
    }

    public boolean isExpired() {
        return this.isExpired;
    }

    public void setExpired(boolean z) {
        this.isExpired = z;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public long getAuthorParticipantId() {
        return this.authorParticipantId;
    }

    public void setAuthorParticipantId(long j) {
        this.authorParticipantId = j;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(long j) {
        this.authorId = j;
    }

    public boolean isAuthorConfidential() {
        return this.isAuthorConfidential;
    }

    public void setAuthorConfidential(boolean z) {
        this.isAuthorConfidential = z;
    }

    public String getAuthorParticipantType() {
        return this.authorParticipantType;
    }

    public void setAuthorParticipantType(String str) {
        this.authorParticipantType = str;
    }

    public String getAuthorFirstName() {
        return this.authorFirstName;
    }

    public void setAuthorFirstName(String str) {
        this.authorFirstName = str;
    }

    public String getAuthorLastName() {
        return this.authorLastName;
    }

    public void setAuthorLastName(String str) {
        this.authorLastName = str;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public String getAuthorImageUrl() {
        return this.authorImageUrl;
    }

    public void setAuthorImageUrl(String str) {
        this.authorImageUrl = str;
    }

    public boolean isAuthorImagePublic() {
        return this.isAuthorImagePublic;
    }

    public void setAuthorImagePublic(boolean z) {
        this.isAuthorImagePublic = z;
    }

    public String getAuthorCityId() {
        return this.authorCityId;
    }

    public void setAuthorCityId(String str) {
        this.authorCityId = str;
    }

    public String getAuthorCityName() {
        return this.authorCityName;
    }

    public void setAuthorCityName(String str) {
        this.authorCityName = str;
    }

    public String getAuthorShortDescription() {
        return this.authorShortDescription;
    }

    public void setAuthorShortDescription(String str) {
        this.authorShortDescription = str;
    }

    public boolean isFeatured() {
        return this.isFeatured;
    }

    public void setFeatured(boolean z) {
        this.isFeatured = z;
    }

    public int getNoOfLikes() {
        return this.noOfLikes;
    }

    public void setNoOfLikes(int i2) {
        this.noOfLikes = i2;
    }

    public int getNoOfComments() {
        return this.noOfComments;
    }

    public void setNoOfComments(int i2) {
        this.noOfComments = i2;
    }

    public List<Comment> getLastComments() {
        return this.lastComments;
    }

    public void setLastComments(List<Comment> list) {
        this.lastComments = list;
    }

    public int getReactionValue() {
        return this.reactedValue;
    }

    public void setReactionValue(int i2) {
        this.reactedValue = i2;
    }

    public boolean isBookmarked() {
        return this.isBookmarked;
    }

    public void setBookmarked(boolean z) {
        this.isBookmarked = z;
    }

    public int getNoOfBookmarks() {
        return this.noOfBookmarks;
    }

    public void setNoOfBookmarks(int i2) {
        this.noOfBookmarks = i2;
    }

    public int getNoOfViews() {
        return this.noOfViews;
    }

    public void setNoOfViews(int i2) {
        this.noOfViews = i2;
    }

    public int getNoOfChallengeAccepted() {
        return this.noOfChallengeAccepted;
    }

    public void setNoOfChallengeAccepted(int i2) {
        this.noOfChallengeAccepted = i2;
    }

    public boolean isChallengeAccepted() {
        return this.isChallengeAccepted;
    }

    public void setChallengeAccepted(boolean z) {
        this.isChallengeAccepted = z;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setItemPosition(int i2) {
        this.itemPosition = i2;
    }

    public boolean isLongPress() {
        return this.isLongPress;
    }

    public void setLongPress(boolean z) {
        this.isLongPress = z;
    }

    public String getCallFromName() {
        return this.callFromName;
    }

    public void setCallFromName(String str) {
        this.callFromName = str;
    }

    public boolean isTrending() {
        return this.isTrending;
    }

    public void setTrending(boolean z) {
        this.isTrending = z;
    }

    public boolean isFromHome() {
        return this.isFromHome;
    }

    public void setFromHome(boolean z) {
        this.isFromHome = z;
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public int getLastReactionValue() {
        return this.lastReactionValue;
    }

    public void setLastReactionValue(int i2) {
        this.lastReactionValue = i2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getPostingDate() {
        return this.postingDate;
    }

    public void setPostingDate(String str) {
        this.postingDate = str;
    }

    public int getReactedValue() {
        return this.reactedValue;
    }

    public void setReactedValue(int i2) {
        this.reactedValue = i2;
    }

    public boolean isApplied() {
        return this.isApplied;
    }

    public void setApplied(boolean z) {
        this.isApplied = z;
    }

    public boolean isViewed() {
        return this.isViewed;
    }

    public void setViewed(boolean z) {
        this.isViewed = z;
    }

    public int getNoOfApplied() {
        return this.noOfApplied;
    }

    public void setNoOfApplied(int i2) {
        this.noOfApplied = i2;
    }

    public List<Long> getTag_ids() {
        return this.tag_ids;
    }

    public void setTag_ids(List<Long> list) {
        this.tag_ids = list;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public String getParticipantDeepLinkingUrl() {
        return this.participantDeepLinkingUrl;
    }

    public void setParticipantDeepLinkingUrl(String str) {
        this.participantDeepLinkingUrl = str;
    }

    public String getEntityDeepLinkingUrl() {
        return this.entityDeepLinkingUrl;
    }

    public void setEntityDeepLinkingUrl(String str) {
        this.entityDeepLinkingUrl = str;
    }

    public String getOgImageUrlS() {
        return this.ogImageUrlS;
    }

    public void setOgImageUrlS(String str) {
        this.ogImageUrlS = str;
    }

    public String getOgTitleS() {
        return this.ogTitleS;
    }

    public void setOgTitleS(String str) {
        this.ogTitleS = str;
    }

    public String getOgDescriptionS() {
        return this.ogDescriptionS;
    }

    public void setOgDescriptionS(String str) {
        this.ogDescriptionS = str;
    }

    public String getOgRequestedUrlS() {
        return this.ogRequestedUrlS;
    }

    public void setOgRequestedUrlS(String str) {
        this.ogRequestedUrlS = str;
    }

    public boolean isOgVideoLinkB() {
        return this.isOgVideoLinkB;
    }

    public void setOgVideoLinkB(boolean z) {
        this.isOgVideoLinkB = z;
    }

    public boolean isAuthorMentor() {
        return this.isAuthorMentor;
    }

    public void setAuthorMentor(boolean z) {
        this.isAuthorMentor = z;
    }

    public String getMentorDeepLinkUrl() {
        return this.mentorDeepLinkUrl;
    }

    public void setMentorDeepLinkUrl(String str) {
        this.mentorDeepLinkUrl = str;
    }

    public String getBlogLinkUrl() {
        return this.blogLinkUrl;
    }

    public void setBlogLinkUrl(String str) {
        this.blogLinkUrl = str;
    }

    public String getUserSubType() {
        return this.userSubType;
    }

    public void setUserSubType(String str) {
        this.userSubType = str;
    }

    public boolean isSpamPost() {
        return this.isSpamPost;
    }

    public void setSpamPost(boolean z) {
        this.isSpamPost = z;
    }

    public String getPostShortBranchUrls() {
        return this.postShortBranchUrls;
    }

    public void setPostShortBranchUrls(String str) {
        this.postShortBranchUrls = str;
    }

    public String getStreamType() {
        return this.streamType;
    }

    public void setStreamType(String str) {
        this.streamType = str;
    }
}
