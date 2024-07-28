package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class FeedRequestPojo extends BaseRequest {
    @c(a = "article_categories")
    @a
    private List<String> articleCategories;
    @c(a = "author_id")
    @a
    private Integer autherId;
    @c(a = "category_ids")
    @a
    private List<Long> categoryIds;
    @c(a = "cities")
    @a
    private List<String> cities = null;
    @c(a = "community_id")
    @a
    public Long communityId = null;
    @c(a = "experience_from")
    @a
    private Integer experienceFrom = null;
    @c(a = "experience_to")
    @a
    private Integer experienceTo = null;
    @c(a = "functional_areas")
    @a
    private List<String> functionalAreas = null;
    @c(a = "id_of_entity_or_participant")
    @a
    private Long idForFeedDetail = null;
    @c(a = "is_accepted_or_active")
    @a
    private boolean isAcceptedOrActive;
    @c(a = "is_anonymous_post_hide")
    @a
    private boolean isAnonymousPostHide;
    @c(a = "is_onboarding_communities")
    @a
    private boolean isOnBoardingCommunities;
    @c(a = "is_spam_post_b")
    @a
    private boolean isSpamPost;
    @c(a = "only_active")
    @a
    private boolean onlyActive;
    @c(a = "opportunity_types")
    @a
    private List<String> opportunityTypes = null;
    @c(a = "posting_date_dt")
    @a
    private String postingDate;
    @c(a = "q")
    @a
    private String question;
    @c(a = "skills")
    @a
    private List<String> skills = null;
    @c(a = "source_entity_id")
    @a
    private Integer sourceEntityId;
    @c(a = "sub_type")
    @a
    private String subType;

    public Integer getSourceEntityId() {
        return this.sourceEntityId;
    }

    public void setSourceEntityId(Integer num) {
        this.sourceEntityId = num;
    }

    public Long getIdForFeedDetail() {
        return this.idForFeedDetail;
    }

    public void setIdForFeedDetail(Long l) {
        this.idForFeedDetail = l;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public List<String> getArticleCategories() {
        return this.articleCategories;
    }

    public void setArticleCategories(List<String> list) {
        this.articleCategories = list;
    }

    public boolean isOnlyActive() {
        return this.onlyActive;
    }

    public void setOnlyActive(boolean z) {
        this.onlyActive = z;
    }

    public boolean isAcceptedOrActive() {
        return this.isAcceptedOrActive;
    }

    public void setAcceptedOrActive(boolean z) {
        this.isAcceptedOrActive = z;
    }

    public List<Long> getCategoryIds() {
        return this.categoryIds;
    }

    public void setCategoryIds(List<Long> list) {
        this.categoryIds = list;
    }

    public Long getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(Long l) {
        this.communityId = l;
    }

    public List<String> getCities() {
        return this.cities;
    }

    public void setCities(List<String> list) {
        this.cities = list;
    }

    public Integer getExperienceFrom() {
        return this.experienceFrom;
    }

    public void setExperienceFrom(Integer num) {
        this.experienceFrom = num;
    }

    public Integer getExperienceTo() {
        return this.experienceTo;
    }

    public void setExperienceTo(Integer num) {
        this.experienceTo = num;
    }

    public List<String> getFunctionalAreas() {
        return this.functionalAreas;
    }

    public void setFunctionalAreas(List<String> list) {
        this.functionalAreas = list;
    }

    public List<String> getOpportunityTypes() {
        return this.opportunityTypes;
    }

    public void setOpportunityTypes(List<String> list) {
        this.opportunityTypes = list;
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public void setSkills(List<String> list) {
        this.skills = list;
    }

    public Integer getAutherId() {
        return this.autherId;
    }

    public void setAutherId(Integer num) {
        this.autherId = num;
    }

    public boolean isSpamPost() {
        return this.isSpamPost;
    }

    public void setSpamPost(boolean z) {
        this.isSpamPost = z;
    }

    public String getPostingDate() {
        return this.postingDate;
    }

    public void setPostingDate(String str) {
        this.postingDate = str;
    }

    public boolean isAnonymousPostHide() {
        return this.isAnonymousPostHide;
    }

    public void setAnonymousPostHide(boolean z) {
        this.isAnonymousPostHide = z;
    }

    public boolean isOnBoardingCommunities() {
        return this.isOnBoardingCommunities;
    }

    public void setOnBoardingCommunities(boolean z) {
        this.isOnBoardingCommunities = z;
    }
}
