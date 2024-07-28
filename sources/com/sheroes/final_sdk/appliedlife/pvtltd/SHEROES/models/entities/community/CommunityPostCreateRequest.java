package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import java.util.ArrayList;
import java.util.List;

public class CommunityPostCreateRequest extends BaseRequest implements Parcelable {
    public static final Parcelable.Creator<CommunityPostCreateRequest> CREATOR = new Parcelable.Creator<CommunityPostCreateRequest>() {
        public final CommunityPostCreateRequest createFromParcel(Parcel parcel) {
            return new CommunityPostCreateRequest(parcel);
        }

        public final CommunityPostCreateRequest[] newArray(int i2) {
            return new CommunityPostCreateRequest[i2];
        }
    };
    @c(a = "community_id")
    @a
    private Long communityId;
    @c(a = "creator_type")
    @a
    private String creatorType;
    @c(a = "delete_image_id")
    @a
    private List<Long> deleteImagesIds;
    @c(a = "description")
    @a
    private String description;
    @c(a = "entity_start_date")
    @a
    private String entityStartDate;
    @c(a = "id")
    @a
    private Long id;
    @c(a = "images")
    @a
    private List<String> images;
    @c(a = "is_active")
    @a
    private boolean isActive;
    @c(a = "is_og_video_link_b")
    @a
    private boolean isOgVideoLinkB;
    @c(a = "is_post_to_facebook")
    @a
    private boolean isPostToFacebook;
    @c(a = "is_spam")
    @a
    private boolean isSpam;
    @c(a = "is_top_post_b")
    @a
    private boolean isTopPost;
    @c(a = "source_type")
    @a
    private String mSourceType;
    @c(a = "og_description_s")
    @a
    private String ogDescriptionS;
    @c(a = "og_image_url_s")
    @a
    private String ogImageUrlS;
    @c(a = "og_requested_url_s")
    @a
    private String ogRequestedUrlS;
    @c(a = "og_title_s")
    @a
    private String ogTitleS;
    @c(a = "crdt")
    @a
    private String schedulePost;
    @c(a = "source_entity_id")
    @a
    private Integer sourceEntityId;
    @c(a = "user_fb_access_token")
    @a
    private String userFbAccessToken;
    @c(a = "videoLink")
    @a
    private boolean videoLink;

    public int describeContents() {
        return 0;
    }

    public String getmSourceType() {
        return this.mSourceType;
    }

    public void setmSourceType(String str) {
        this.mSourceType = str;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public Long getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(Long l) {
        this.communityId = l;
    }

    public String getCreatorType() {
        return this.creatorType;
    }

    public void setCreatorType(String str) {
        this.creatorType = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public List<Long> getDeleteImagesIds() {
        return this.deleteImagesIds;
    }

    public void setDeleteImagesIds(List<Long> list) {
        this.deleteImagesIds = list;
    }

    public String getEntityStartDate() {
        return this.entityStartDate;
    }

    public void setEntityStartDate(String str) {
        this.entityStartDate = str;
    }

    public boolean isOgVideoLinkB() {
        return this.isOgVideoLinkB;
    }

    public void setOgVideoLinkB(boolean z) {
        this.isOgVideoLinkB = z;
    }

    public String getOgDescriptionS() {
        return this.ogDescriptionS;
    }

    public void setOgDescriptionS(String str) {
        this.ogDescriptionS = str;
    }

    public String getOgImageUrlS() {
        return this.ogImageUrlS;
    }

    public void setOgImageUrlS(String str) {
        this.ogImageUrlS = str;
    }

    public String getOgRequestedUrlS() {
        return this.ogRequestedUrlS;
    }

    public void setOgRequestedUrlS(String str) {
        this.ogRequestedUrlS = str;
    }

    public String getOgTitleS() {
        return this.ogTitleS;
    }

    public void setOgTitleS(String str) {
        this.ogTitleS = str;
    }

    public Integer getSourceEntityId() {
        return this.sourceEntityId;
    }

    public void setSourceEntityId(Integer num) {
        this.sourceEntityId = num;
    }

    public boolean isVideoLink() {
        return this.videoLink;
    }

    public void setVideoLink(boolean z) {
        this.videoLink = z;
    }

    public CommunityPostCreateRequest() {
        this.id = null;
        this.communityId = null;
        this.images = null;
        this.deleteImagesIds = null;
        this.isActive = true;
    }

    public boolean isSpam() {
        return this.isSpam;
    }

    public void setSpam(boolean z) {
        this.isSpam = z;
    }

    public boolean isTopPost() {
        return this.isTopPost;
    }

    public void setTopPost(boolean z) {
        this.isTopPost = z;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.entityStartDate);
        parcel.writeByte(this.isOgVideoLinkB ? (byte) 1 : 0);
        parcel.writeString(this.ogDescriptionS);
        parcel.writeString(this.ogImageUrlS);
        parcel.writeString(this.ogRequestedUrlS);
        parcel.writeString(this.ogTitleS);
        parcel.writeValue(this.sourceEntityId);
        parcel.writeByte(this.videoLink ? (byte) 1 : 0);
        parcel.writeString(this.mSourceType);
        parcel.writeValue(this.id);
        parcel.writeValue(this.communityId);
        parcel.writeString(this.creatorType);
        parcel.writeString(this.description);
        parcel.writeStringList(this.images);
        parcel.writeList(this.deleteImagesIds);
        parcel.writeByte(this.isActive ? (byte) 1 : 0);
        parcel.writeByte(this.isSpam ? (byte) 1 : 0);
        parcel.writeByte(this.isTopPost ? (byte) 1 : 0);
    }

    protected CommunityPostCreateRequest(Parcel parcel) {
        this.id = null;
        this.communityId = null;
        this.images = null;
        this.deleteImagesIds = null;
        boolean z = true;
        this.isActive = true;
        this.entityStartDate = parcel.readString();
        this.isOgVideoLinkB = parcel.readByte() != 0;
        this.ogDescriptionS = parcel.readString();
        this.ogImageUrlS = parcel.readString();
        this.ogRequestedUrlS = parcel.readString();
        this.ogTitleS = parcel.readString();
        this.sourceEntityId = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.videoLink = parcel.readByte() != 0;
        this.mSourceType = parcel.readString();
        this.id = (Long) parcel.readValue(Long.class.getClassLoader());
        this.communityId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.creatorType = parcel.readString();
        this.description = parcel.readString();
        this.images = parcel.createStringArrayList();
        this.deleteImagesIds = new ArrayList();
        parcel.readList(this.deleteImagesIds, Long.class.getClassLoader());
        this.isActive = parcel.readByte() != 0;
        this.isSpam = parcel.readByte() != 0;
        this.isTopPost = parcel.readByte() == 0 ? false : z;
    }

    public boolean isPostToFacebook() {
        return this.isPostToFacebook;
    }

    public void setPostToFacebook(boolean z) {
        this.isPostToFacebook = z;
    }

    public String isUserFbAccessToken() {
        return this.userFbAccessToken;
    }

    public void setUserFbAccessToken(String str) {
        this.userFbAccessToken = str;
    }

    public String getSchedulePost() {
        return this.schedulePost;
    }

    public void setSchedulePost(String str) {
        this.schedulePost = str;
    }
}
