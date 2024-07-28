package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.a;
import com.google.gson.a.c;
import org.parceler.Parcel;

@Parcel
public class LastComment {
    @c(a = "comment")
    @a
    private String comment;
    @c(a = "comments_id")
    @a
    private int commentsId;
    @c(a = "created_on")
    @a
    private String createdOn;
    @c(a = "entity_author_user_id_l")
    @a
    private int entityAuthorUserIdL;
    @c(a = "entity_id")
    @a
    private int entityId;
    @c(a = "id")
    @a
    private int id;
    @c(a = "is_active")
    @a
    private boolean isActive;
    @c(a = "is_anonymous")
    @a
    private boolean isAnonymous;
    @c(a = "solr_ignore_is_mentor")
    @a
    private boolean isVerifiedMentor;
    @c(a = "last_modified_on")
    @a
    private String lastModifiedOn;
    @c(a = "like_value")
    @a
    private int likeValue;
    @c(a = "solr_ignore_my_own_participation")
    @a
    private boolean myOwnParticipation;
    @c(a = "participant_id")
    @a
    private int participantId;
    @c(a = "solr_ignore_participant_image_url")
    @a
    private String participantImageUrl;
    @c(a = "solr_ignore_participant_name")
    @a
    private String participantName;
    @c(a = "participation_type_id")
    @a
    private int participationTypeId;

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public void setEntityId(int i2) {
        this.entityId = i2;
    }

    public int getParticipantId() {
        return this.participantId;
    }

    public void setParticipantId(int i2) {
        this.participantId = i2;
    }

    public int getCommentsId() {
        return this.commentsId;
    }

    public void setCommentsId(int i2) {
        this.commentsId = i2;
    }

    public int getParticipationTypeId() {
        return this.participationTypeId;
    }

    public void setParticipationTypeId(int i2) {
        this.participationTypeId = i2;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(String str) {
        this.createdOn = str;
    }

    public String getLastModifiedOn() {
        return this.lastModifiedOn;
    }

    public void setLastModifiedOn(String str) {
        this.lastModifiedOn = str;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean z) {
        this.isActive = z;
    }

    public boolean getIsAnonymous() {
        return this.isAnonymous;
    }

    public void setIsAnonymous(boolean z) {
        this.isAnonymous = z;
    }

    public int getLikeValue() {
        return this.likeValue;
    }

    public void setLikeValue(int i2) {
        this.likeValue = i2;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getParticipantName() {
        return this.participantName;
    }

    public void setParticipantName(String str) {
        this.participantName = str;
    }

    public String getParticipantImageUrl() {
        return this.participantImageUrl;
    }

    public void setParticipantImageUrl(String str) {
        this.participantImageUrl = str;
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

    public int getEntityAuthorUserIdL() {
        return this.entityAuthorUserIdL;
    }

    public void setEntityAuthorUserIdL(int i2) {
        this.entityAuthorUserIdL = i2;
    }

    public boolean isMyOwnParticipation() {
        return this.myOwnParticipation;
    }

    public void setMyOwnParticipation(boolean z) {
        this.myOwnParticipation = z;
    }

    public boolean isVerifiedMentor() {
        return this.isVerifiedMentor;
    }

    public void setVerifiedMentor(boolean z) {
        this.isVerifiedMentor = z;
    }
}
