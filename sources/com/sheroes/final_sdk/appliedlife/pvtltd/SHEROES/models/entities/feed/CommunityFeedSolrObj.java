package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.c;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class CommunityFeedSolrObj extends FeedDetail implements Cloneable {
    public static String COMMUNITY_OBJ = "Community Object";
    @c(a = "community_primary_color_s")
    public String communityPrimaryColor;
    @c(a = "community_secondary_color_s")
    public String communitySecondaryColor;
    @c(a = "solr_ignore_community_tabs")
    public List<CommunityTab> communityTabs;
    @c(a = "community_type_s")
    public String communityType;
    @c(a = "community_type_l")
    public Long communityTypeId;
    @c(a = "default_tab_joined_key_s")
    public String defaultTabJoinedKey;
    @c(a = "default_tab_key_s")
    public String defaultTabKey;
    @c(a = "is_closed_b")
    public boolean isClosedCommunity;
    @c(a = "solr_ignore_is_member")
    private boolean isMember;
    private boolean isMutualCommunityFirstItem;
    private boolean isOtherCommunityFirstItem;
    @c(a = "solr_ignore_is_owner")
    private boolean isOwner;
    @c(a = "solr_ignore_is_request_pending")
    private boolean isRequestPending;
    private int mutualCommunityCount;
    @c(a = "new_post_hint_s")
    public String newPostHint;
    @c(a = "solr_ignore_no_of_members")
    private int noOfMembers = 0;
    @c(a = "solr_ignore_no_of_pending_requests")
    private int noOfPendingRequest = 0;
    private boolean showHeader;
    @c(a = "title_text_color_s")
    public String titleTextColor;

    public boolean isMutualCommunityFirstItem() {
        return this.isMutualCommunityFirstItem;
    }

    public void setMutualCommunityFirstItem(boolean z) {
        this.isMutualCommunityFirstItem = z;
    }

    public boolean isOtherCommunityFirstItem() {
        return this.isOtherCommunityFirstItem;
    }

    public void setOtherCommunityFirstItem(boolean z) {
        this.isOtherCommunityFirstItem = z;
    }

    public int getMutualCommunityCount() {
        return this.mutualCommunityCount;
    }

    public void setMutualCommunityCount(int i2) {
        this.mutualCommunityCount = i2;
    }

    public boolean isShowHeader() {
        return this.showHeader;
    }

    public void setShowHeader(boolean z) {
        this.showHeader = z;
    }

    public String getCommunityType() {
        return this.communityType;
    }

    public void setCommunityType(String str) {
        this.communityType = str;
    }

    public Long getCommunityTypeId() {
        return this.communityTypeId;
    }

    public void setCommunityTypeId(Long l) {
        this.communityTypeId = l;
    }

    public boolean isClosedCommunity() {
        return this.isClosedCommunity;
    }

    public void setClosedCommunity(boolean z) {
        this.isClosedCommunity = z;
    }

    public int getNoOfMembers() {
        return this.noOfMembers;
    }

    public void setNoOfMembers(int i2) {
        this.noOfMembers = i2;
    }

    public int getNoOfPendingRequest() {
        return this.noOfPendingRequest;
    }

    public void setNoOfPendingRequest(int i2) {
        this.noOfPendingRequest = i2;
    }

    public boolean isOwner() {
        return this.isOwner;
    }

    public void setOwner(boolean z) {
        this.isOwner = z;
    }

    public boolean isMember() {
        return this.isMember;
    }

    public void setMember(boolean z) {
        this.isMember = z;
    }

    public boolean isRequestPending() {
        return this.isRequestPending;
    }

    public void setRequestPending(boolean z) {
        this.isRequestPending = z;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
