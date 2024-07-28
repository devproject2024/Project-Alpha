package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import org.parceler.Parcel;

@Parcel
public class MembersList extends BaseResponse {
    @c(a = "approved_date")
    @a
    private String approvedDate;
    @c(a = "city_master_id")
    @a
    private int cityMasterId;
    @c(a = "com_id")
    @a
    private int comId;
    @c(a = "com_logo_url")
    @a
    private String comLogoUrl;
    @c(a = "com_name")
    @a
    private String comName;
    @c(a = "com_type")
    @a
    private String comType;
    @c(a = "comm_is_active")
    @a
    private Boolean commIsActive;
    @c(a = "comm_is_closed")
    @a
    private Boolean commIsClosed;
    @c(a = "comm_is_deleted")
    @a
    private Boolean commIsDeleted;
    @c(a = "comm_is_featured")
    @a
    private Boolean commIsFeatured;
    @c(a = "community_id")
    @a
    private Long communityId;
    @c(a = "community_member_id")
    @a
    private Long communityMemberId;
    @c(a = "community_user_city_id")
    @a
    private int communityUserCityId;
    @c(a = "community_user_city_name")
    @a
    private String communityUserCityName;
    @c(a = "community_user_emailid")
    @a
    private String communityUserEmailid;
    @c(a = "community_user_first_name")
    @a
    private String communityUserFirstName;
    @c(a = "community_user_id")
    @a
    private int communityUserId;
    @c(a = "community_user_last_name")
    @a
    private String communityUserLastName;
    @c(a = "community_user_mobile")
    @a
    private String communityUserMobile;
    @c(a = "community_user_participant_id")
    @a
    private int communityUserParticipantId;
    @c(a = "community_user_photo_url_path")
    @a
    private String communityUserPhotoUrlPath;
    @c(a = "id")
    @a
    private String id;
    @c(a = "is_active")
    @a
    private Boolean isActive;
    @c(a = "is_approved")
    @a
    private Boolean isApproved;
    @c(a = "is_owner")
    @a
    private boolean isOwner;
    @c(a = "position")
    @a
    private int position;
    @c(a = "type_s")
    @a
    private String typeS;
    @c(a = "users_id")
    @a
    private Long usersId;

    public String getApprovedDate() {
        return this.approvedDate;
    }

    public void setApprovedDate(String str) {
        this.approvedDate = str;
    }

    public int getCityMasterId() {
        return this.cityMasterId;
    }

    public void setCityMasterId(int i2) {
        this.cityMasterId = i2;
    }

    public int getComId() {
        return this.comId;
    }

    public void setComId(int i2) {
        this.comId = i2;
    }

    public String getComLogoUrl() {
        return this.comLogoUrl;
    }

    public void setComLogoUrl(String str) {
        this.comLogoUrl = str;
    }

    public String getComName() {
        return this.comName;
    }

    public void setComName(String str) {
        this.comName = str;
    }

    public String getComType() {
        return this.comType;
    }

    public void setComType(String str) {
        this.comType = str;
    }

    public Boolean getCommIsActive() {
        return this.commIsActive;
    }

    public void setCommIsActive(Boolean bool) {
        this.commIsActive = bool;
    }

    public Boolean getCommIsClosed() {
        return this.commIsClosed;
    }

    public void setCommIsClosed(Boolean bool) {
        this.commIsClosed = bool;
    }

    public Boolean getCommIsDeleted() {
        return this.commIsDeleted;
    }

    public void setCommIsDeleted(Boolean bool) {
        this.commIsDeleted = bool;
    }

    public Boolean getCommIsFeatured() {
        return this.commIsFeatured;
    }

    public void setCommIsFeatured(Boolean bool) {
        this.commIsFeatured = bool;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public Long getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(Long l) {
        this.communityId = l;
    }

    public Long getCommunityMemberId() {
        return this.communityMemberId;
    }

    public void setCommunityMemberId(Long l) {
        this.communityMemberId = l;
    }

    public int getCommunityUserCityId() {
        return this.communityUserCityId;
    }

    public void setCommunityUserCityId(int i2) {
        this.communityUserCityId = i2;
    }

    public String getCommunityUserCityName() {
        return this.communityUserCityName;
    }

    public void setCommunityUserCityName(String str) {
        this.communityUserCityName = str;
    }

    public String getCommunityUserEmailid() {
        return this.communityUserEmailid;
    }

    public void setCommunityUserEmailid(String str) {
        this.communityUserEmailid = str;
    }

    public String getCommunityUserFirstName() {
        return this.communityUserFirstName;
    }

    public void setCommunityUserFirstName(String str) {
        this.communityUserFirstName = str;
    }

    public int getCommunityUserId() {
        return this.communityUserId;
    }

    public void setCommunityUserId(int i2) {
        this.communityUserId = i2;
    }

    public String getCommunityUserLastName() {
        return this.communityUserLastName;
    }

    public void setCommunityUserLastName(String str) {
        this.communityUserLastName = str;
    }

    public String getCommunityUserMobile() {
        return this.communityUserMobile;
    }

    public void setCommunityUserMobile(String str) {
        this.communityUserMobile = str;
    }

    public int getCommunityUserParticipantId() {
        return this.communityUserParticipantId;
    }

    public void setCommunityUserParticipantId(int i2) {
        this.communityUserParticipantId = i2;
    }

    public String getCommunityUserPhotoUrlPath() {
        return this.communityUserPhotoUrlPath;
    }

    public void setCommunityUserPhotoUrlPath(String str) {
        this.communityUserPhotoUrlPath = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean bool) {
        this.isActive = bool;
    }

    public Boolean getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(Boolean bool) {
        this.isApproved = bool;
    }

    public String getTypeS() {
        return this.typeS;
    }

    public void setTypeS(String str) {
        this.typeS = str;
    }

    public long getUsersId() {
        return this.usersId.longValue();
    }

    public void setUsersId(Long l) {
        this.usersId = l;
    }

    public boolean getIsOwner() {
        return this.isOwner;
    }

    public void setIsOwner(boolean z) {
        this.isOwner = z;
    }
}
