package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import org.parceler.Parcel;

@Parcel
public class Comment extends BaseResponse {
    int byDefaultMenuOpen;
    @c(a = "solr_ignore_city")
    @a
    private String city;
    @c(a = "comment")
    @a
    private String comment;
    @c(a = "comments_id")
    @a
    private long commentsId;
    @c(a = "particitipating_entity_community_id_l")
    private String communityId;
    @c(a = "created_on")
    @a
    private String createdOn;
    @c(a = "entity_author_user_id_l")
    @a
    private Long entityAuthorUserId;
    @c(a = "entity_id")
    @a
    private long entityId;
    @c(a = "id")
    @a
    private int id;
    @c(a = "is_active")
    @a
    private boolean isActive;
    @c(a = "is_anonymous")
    @a
    private boolean isAnonymous;
    boolean isEdit;
    @c(a = "solr_ignore_is_my_own_like_on_comment")
    @a
    public boolean isLiked;
    @c(a = "solr_ignore_is_mentor")
    @a
    private boolean isVerifiedMentor;
    int itemPosition;
    @c(a = "last_modified_on")
    @a
    private String lastModifiedOn;
    @c(a = "solr_ignore_number_of_likes_on_comment")
    @a
    public int likeCount;
    @c(a = "like_value")
    @a
    private int likeValue;
    @c(a = "solr_ignore_my_own_participation")
    @a
    private boolean myOwnParticipation;
    @c(a = "solr_ignore_is_participant_active")
    @a
    private boolean participantActive = false;
    @c(a = "participant_id")
    @a
    private long participantId;
    @c(a = "solr_ignore_participant_image_url")
    @a
    private String participantImageUrl;
    @c(a = "solr_ignore_participant_name")
    @a
    private String participantName;
    @c(a = "solr_ignore_participant_user_id")
    private Long participantUserId;
    @c(a = "participation_type_id")
    @a
    private long participationTypeId;
    @c(a = "solr_ignore_created_on")
    @a
    private String postedDate;

    public boolean isEdit() {
        return this.isEdit;
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setItemPosition(int i2) {
        this.itemPosition = i2;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public long getCommentsId() {
        return this.commentsId;
    }

    public void setCommentsId(long j) {
        this.commentsId = j;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(String str) {
        this.createdOn = str;
    }

    public long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(long j) {
        this.entityId = j;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public void setAnonymous(boolean z) {
        this.isAnonymous = z;
    }

    public String getLastModifiedOn() {
        return this.lastModifiedOn;
    }

    public void setLastModifiedOn(String str) {
        this.lastModifiedOn = str;
    }

    public int getLikeValue() {
        return this.likeValue;
    }

    public void setLikeValue(int i2) {
        this.likeValue = i2;
    }

    public long getParticipantId() {
        return this.participantId;
    }

    public void setParticipantId(long j) {
        this.participantId = j;
    }

    public String getParticipantImageUrl() {
        return this.participantImageUrl;
    }

    public void setParticipantImageUrl(String str) {
        this.participantImageUrl = str;
    }

    public String getParticipantName() {
        return this.participantName;
    }

    public void setParticipantName(String str) {
        this.participantName = str;
    }

    public long getParticipationTypeId() {
        return this.participationTypeId;
    }

    public void setParticipationTypeId(long j) {
        this.participationTypeId = j;
    }

    public boolean isMyOwnParticipation() {
        return this.myOwnParticipation;
    }

    public void setMyOwnParticipation(boolean z) {
        this.myOwnParticipation = z;
    }

    public int getByDefaultMenuOpen() {
        return this.byDefaultMenuOpen;
    }

    public void setByDefaultMenuOpen(int i2) {
        this.byDefaultMenuOpen = i2;
    }

    public String getPostedDate() {
        return this.postedDate;
    }

    public void setPostedDate(String str) {
        this.postedDate = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public Long getEntityAuthorUserId() {
        return this.entityAuthorUserId;
    }

    public void setEntityAuthorUserId(Long l) {
        this.entityAuthorUserId = l;
    }

    public boolean isParticipantActive() {
        return this.participantActive;
    }

    public void setParticipantActive(boolean z) {
        this.participantActive = z;
    }

    public boolean isVerifiedMentor() {
        return this.isVerifiedMentor;
    }

    public void setVerifiedMentor(boolean z) {
        this.isVerifiedMentor = z;
    }

    public Long getParticipantUserId() {
        return this.participantUserId;
    }

    public void setParticipantUserId(Long l) {
        this.participantUserId = l;
    }

    public String getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(String str) {
        this.communityId = str;
    }
}
