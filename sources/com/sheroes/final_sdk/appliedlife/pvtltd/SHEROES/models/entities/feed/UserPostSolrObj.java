package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.c;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class UserPostSolrObj extends FeedDetail {
    public static final String USER_POST_ID = "USER_POST_ID";
    public static final String USER_POST_OBJ = "USER_POST_OBJ";
    @c(a = "challenge_accept_post_text_s")
    private String challengeAcceptPostText;
    @c(a = "community_type_id_l")
    private Long commTypeId;
    @c(a = "community_i")
    public Long communityId;
    @c(a = "community_participant_id_l")
    private Long communityParticipantId;
    @c(a = "solr_ignore_community_type_id")
    private long communityTypeId;
    @c(a = "s_disp_third_party_unique_id")
    private String dispThirdPartyUniqueId;
    @c(a = "start_date_dt")
    private String entityStartDate;
    @c(a = "post_image_height_is")
    private List<Integer> imageHeight;
    @c(a = "post_image_dimention_ratio_ds")
    private List<Double> imageRatio;
    @c(a = "display_text_image_url")
    private List<String> imageUrls;
    @c(a = "post_image_width_is")
    private List<Integer> imageWidth;
    @c(a = "search_id_post_image")
    private List<Long> imagesIds;
    @c(a = "is_anonymous_b")
    private boolean isAnonymous;
    @c(a = "is_closed_b")
    private boolean isClosedCommunity;
    @c(a = "is_comment_allowed_b")
    private boolean isCommentAllowed;
    @c(a = "solr_ignore_is_community_owner")
    private boolean isCommunityOwner;
    @c(a = "is_commumity_post_b")
    private boolean isCommunityPost;
    private int isEditOrDelete;
    public Boolean isTextExpanded = Boolean.FALSE;
    @c(a = "is_top_post_b")
    private boolean isTopPost;
    private int noOfOpenings;
    @c(a = "solr_ignore_is_closed")
    private boolean postCommunityClosed;
    @c(a = "solr_ignore_post_community_logo")
    private String postCommunityLogo;
    @c(a = "solr_ignore_post_community_name")
    private String postCommunityName;
    @c(a = "rating_i")
    private Integer rating;
    @c(a = "source_type_s")
    private String sourceType;
    @c(a = "user_post_source_entity_id_l")
    private Long userPostSourceEntityId;

    public List<Long> getImagesIds() {
        return this.imagesIds;
    }

    public void setImagesIds(List<Long> list) {
        this.imagesIds = list;
    }

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public void setImageUrls(List<String> list) {
        this.imageUrls = list;
    }

    public Long getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(Long l) {
        this.communityId = l;
    }

    public boolean isCommunityPost() {
        return this.isCommunityPost;
    }

    public void setCommunityPost(boolean z) {
        this.isCommunityPost = z;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public void setAnonymous(boolean z) {
        this.isAnonymous = z;
    }

    public String getPostCommunityName() {
        return this.postCommunityName;
    }

    public void setPostCommunityName(String str) {
        this.postCommunityName = str;
    }

    public boolean isPostCommunityClosed() {
        return this.postCommunityClosed;
    }

    public void setPostCommunityClosed(boolean z) {
        this.postCommunityClosed = z;
    }

    public String getSolrIgnorePostCommunityLogo() {
        return this.postCommunityLogo;
    }

    public void getSolrIgnorePostCommunityLogo(String str) {
        this.postCommunityLogo = str;
    }

    public Long getCommunityParticipantId() {
        return this.communityParticipantId;
    }

    public void setCommunityParticipantId(Long l) {
        this.communityParticipantId = l;
    }

    public boolean isClosedCommunity() {
        return this.isClosedCommunity;
    }

    public void setClosedCommunity(boolean z) {
        this.isClosedCommunity = z;
    }

    public String getDispThirdPartyUniqueId() {
        return this.dispThirdPartyUniqueId;
    }

    public void setDispThirdPartyUniqueId(String str) {
        this.dispThirdPartyUniqueId = str;
    }

    public String getStartDateForEvent() {
        return this.entityStartDate;
    }

    public void setEntityStartDate(String str) {
        this.entityStartDate = str;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer num) {
        this.rating = num;
    }

    public boolean isCommentAllowed() {
        return this.isCommentAllowed;
    }

    public void setCommentAllowed(boolean z) {
        this.isCommentAllowed = z;
    }

    public long getCommunityTypeId() {
        return this.communityTypeId;
    }

    public void setCommunityTypeId(long j) {
        this.communityTypeId = j;
    }

    public boolean isCommunityOwner() {
        return this.isCommunityOwner;
    }

    public void setCommunityOwner(boolean z) {
        this.isCommunityOwner = z;
    }

    public List<Integer> getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(List<Integer> list) {
        this.imageWidth = list;
    }

    public List<Integer> getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(List<Integer> list) {
        this.imageHeight = list;
    }

    public List<Double> getImageRatio() {
        return this.imageRatio;
    }

    public void setImageRatio(List<Double> list) {
        this.imageRatio = list;
    }

    public Long getCommTypeId() {
        return this.commTypeId;
    }

    public void setCommTypeId(Long l) {
        this.commTypeId = l;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(String str) {
        this.sourceType = str;
    }

    public Long getUserPostSourceEntityId() {
        return this.userPostSourceEntityId;
    }

    public void setUserPostSourceEntityId(Long l) {
        this.userPostSourceEntityId = l;
    }

    public String getChallengeAcceptPostTextS() {
        return this.challengeAcceptPostText;
    }

    public void setChallengeAcceptPostText(String str) {
        this.challengeAcceptPostText = str;
    }

    public int getNoOfOpenings() {
        return this.noOfOpenings;
    }

    public void setNoOfOpenings(int i2) {
        this.noOfOpenings = i2;
    }

    public String getPostCommunityLogo() {
        return this.postCommunityLogo;
    }

    public void setPostCommunityLogo(String str) {
        this.postCommunityLogo = str;
    }

    public Boolean getCommunityOwner() {
        return Boolean.valueOf(this.isCommunityOwner);
    }

    public String getChallengeAcceptPostText() {
        return this.challengeAcceptPostText;
    }

    public int getIsEditOrDelete() {
        return this.isEditOrDelete;
    }

    public void setIsEditOrDelete(int i2) {
        this.isEditOrDelete = i2;
    }

    public boolean isTopPost() {
        return this.isTopPost;
    }

    public void setTopPost(boolean z) {
        this.isTopPost = z;
    }
}
