package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.c;
import java.util.Date;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class UserSolrObj extends FeedDetail {
    @c(a = "search_id_can_help_in")
    private List<Long> canHelpInIds;
    @c(a = "search_text_can_help_in")
    private List<String> canHelpIns;
    @c(a = "id_city_l")
    private long cityId;
    @c(a = "city_name_s")
    private String cityName;
    @c(a = "display_id_curr_experience_company")
    private List<Long> currExperienceCompanyIds;
    @c(a = "display_text_curr_experience_company")
    private List<String> currExperienceCompanyNames;
    @c(a = "display_id_curr_experience")
    private List<Long> currExperienceIds;
    @c(a = "display_text_curr_experience_title")
    private List<String> currExperienceTitles;
    public int currentItemPosition;
    @c(a = "currently_s")
    private String currently;
    @c(a = "currently_l")
    private Long currently_id;
    @c(a = "search_id_education_degree")
    private List<Long> educationDegreeIds;
    @c(a = "search_text_education_degree_name")
    private List<String> educationDegreeNames;
    @c(a = "search_id_education_id")
    private List<Long> educationIds;
    @c(a = "search_id_education_school")
    private List<Long> educationSchoolIds;
    @c(a = "search_text_education_school_name")
    private List<String> educationSchoolNames;
    @c(a = "s_disp_emailid")
    private String emailId;
    @c(a = "search_id_experience_company")
    private List<Long> experienceCompanyIds;
    @c(a = "search_text_experience_company")
    private List<String> experienceCompanyNames;
    @c(a = "search_id_experience")
    private List<Long> experienceIds;
    @c(a = "search_text_experience_title")
    private List<String> experienceTitles;
    @c(a = "search_id_field_of_study_master")
    private List<Long> fieldOfStudyMasterIds;
    @c(a = "search_text_field_of_study_master_name")
    private List<String> fieldOfStudyMasterNames;
    @c(a = "functional_area_ls")
    private List<Long> functionalAreaIds;
    @c(a = "functional_area_ss")
    private List<String> functionalAreaNames;
    @c(a = "gender_s")
    private String gender;
    @c(a = "interest_ls")
    private List<Long> interestId;
    @c(a = "ineterest_ss")
    private List<String> interestNames;
    private boolean isCompactView;
    @c(a = "p_is_company_admin_b")
    private boolean isCompanyAdmin;
    private boolean isSuggested;
    @c(a = "last_activity_date_dt")
    private Date lastActivityDate;
    @c(a = "mars_user_current_salary_i")
    private int marsUserCurrentSalary;
    @c(a = "mars_user_preferred_time_s")
    private String marsUserPreferredTime;
    @c(a = "s_disp_mobile")
    private String mobileNo;
    @c(a = "no_of_children_i")
    private int noOfChildren;
    @c(a = "search_id_opportunities")
    private List<Long> opportunityTypeIds;
    @c(a = "search_text_opportunities")
    private List<String> opportunityTypes;
    @c(a = "profile_id_l")
    private long profileId;
    @c(a = "search_id_communities")
    private List<Long> searchIdCommunities;
    @c(a = "search_id_skills")
    private List<Long> skillIds;
    @c(a = "search_text_skills")
    private List<String> skills;
    @c(a = "solr_ignore_has_user_asked_question")
    private boolean solrIgnoreHasUserAskedQuestion;
    @c(a = "solr_ignore_is_mentor_followed")
    private boolean solrIgnoreIsMentorFollowed;
    @c(a = "solr_ignore_is_user_followed")
    private boolean solrIgnoreIsUserFollowed;
    @c(a = "solr_ignore_mentor_community_id")
    private long solrIgnoreMentorCommunityId;
    @c(a = "solr_ignore_mentor_status")
    private String solrIgnoreMentorStatus;
    @c(a = "solr_ignore_no_of_mentor_answers")
    private int solrIgnoreNoOfMentorAnswers;
    @c(a = "solr_ignore_no_of_mentor_followers")
    private int solrIgnoreNoOfMentorFollowers;
    @c(a = "solr_ignore_total_no_of_post_created")
    private int solrIgnoreNoOfMentorPosts;
    @c(a = "total_exp_i")
    private int totalExperience;
    @c(a = "solr_ignore_total_no_of_comments_created")
    private int userCommentsCount;
    @c(a = "solr_ignore_no_of_user_followers")
    private int userFollowersCount;
    private int userFollowing;

    public int getTotalExperience() {
        return this.totalExperience;
    }

    public void setTotalExperience(int i2) {
        this.totalExperience = i2;
    }

    public Long getCityId() {
        return Long.valueOf(this.cityId);
    }

    public void setCityId(Long l) {
        this.cityId = l.longValue();
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public List<Long> getSkillIds() {
        return this.skillIds;
    }

    public void setSkillIds(List<Long> list) {
        this.skillIds = list;
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public void setSkills(List<String> list) {
        this.skills = list;
    }

    public List<Long> getOpportunityTypeIds() {
        return this.opportunityTypeIds;
    }

    public void setOpportunityTypeIds(List<Long> list) {
        this.opportunityTypeIds = list;
    }

    public List<String> getOpportunityTypes() {
        return this.opportunityTypes;
    }

    public void setOpportunityTypes(List<String> list) {
        this.opportunityTypes = list;
    }

    public List<Long> getCanHelpInIds() {
        return this.canHelpInIds;
    }

    public void setCanHelpInIds(List<Long> list) {
        this.canHelpInIds = list;
    }

    public List<String> getCanHelpIns() {
        return this.canHelpIns;
    }

    public void setCanHelpIns(List<String> list) {
        this.canHelpIns = list;
    }

    public List<Long> getExperienceIds() {
        return this.experienceIds;
    }

    public void setExperienceIds(List<Long> list) {
        this.experienceIds = list;
    }

    public List<String> getExperienceTitles() {
        return this.experienceTitles;
    }

    public void setExperienceTitles(List<String> list) {
        this.experienceTitles = list;
    }

    public List<Long> getExperienceCompanyIds() {
        return this.experienceCompanyIds;
    }

    public void setExperienceCompanyIds(List<Long> list) {
        this.experienceCompanyIds = list;
    }

    public List<String> getExperienceCompanyNames() {
        return this.experienceCompanyNames;
    }

    public void setExperienceCompanyNames(List<String> list) {
        this.experienceCompanyNames = list;
    }

    public List<Long> getCurrExperienceIds() {
        return this.currExperienceIds;
    }

    public void setCurrExperienceIds(List<Long> list) {
        this.currExperienceIds = list;
    }

    public List<String> getCurrExperienceTitles() {
        return this.currExperienceTitles;
    }

    public void setCurrExperienceTitles(List<String> list) {
        this.currExperienceTitles = list;
    }

    public List<Long> getCurrExperienceCompanyIds() {
        return this.currExperienceCompanyIds;
    }

    public void setCurrExperienceCompanyIds(List<Long> list) {
        this.currExperienceCompanyIds = list;
    }

    public List<String> getCurrExperienceCompanyNames() {
        return this.currExperienceCompanyNames;
    }

    public void setCurrExperienceCompanyNames(List<String> list) {
        this.currExperienceCompanyNames = list;
    }

    public List<Long> getEducationIds() {
        return this.educationIds;
    }

    public void setEducationIds(List<Long> list) {
        this.educationIds = list;
    }

    public List<Long> getEducationSchoolIds() {
        return this.educationSchoolIds;
    }

    public void setEducationSchoolIds(List<Long> list) {
        this.educationSchoolIds = list;
    }

    public List<String> getEducationSchoolNames() {
        return this.educationSchoolNames;
    }

    public void setEducationSchoolNames(List<String> list) {
        this.educationSchoolNames = list;
    }

    public List<Long> getEducationDegreeIds() {
        return this.educationDegreeIds;
    }

    public void setEducationDegreeIds(List<Long> list) {
        this.educationDegreeIds = list;
    }

    public List<String> getEducationDegreeNames() {
        return this.educationDegreeNames;
    }

    public void setEducationDegreeNames(List<String> list) {
        this.educationDegreeNames = list;
    }

    public List<Long> getFieldOfStudyMasterIds() {
        return this.fieldOfStudyMasterIds;
    }

    public void setFieldOfStudyMasterIds(List<Long> list) {
        this.fieldOfStudyMasterIds = list;
    }

    public List<String> getFieldOfStudyMasterNames() {
        return this.fieldOfStudyMasterNames;
    }

    public void setFieldOfStudyMasterNames(List<String> list) {
        this.fieldOfStudyMasterNames = list;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public long getCurrently_id() {
        return this.currently_id.longValue();
    }

    public void setCurrently_id(long j) {
        this.currently_id = Long.valueOf(j);
    }

    public long getProfileId() {
        return this.profileId;
    }

    public void setProfileId(long j) {
        this.profileId = j;
    }

    public String getCurrently() {
        return this.currently;
    }

    public void setCurrently(String str) {
        this.currently = str;
    }

    public int getNoOfChildren() {
        return this.noOfChildren;
    }

    public void setNoOfChildren(int i2) {
        this.noOfChildren = i2;
    }

    public List<Long> getInterestId() {
        return this.interestId;
    }

    public void setInterestId(List<Long> list) {
        this.interestId = list;
    }

    public List<String> getInterestNames() {
        return this.interestNames;
    }

    public void setInterestNames(List<String> list) {
        this.interestNames = list;
    }

    public List<Long> getFunctionalAreaIds() {
        return this.functionalAreaIds;
    }

    public void setFunctionalAreaIds(List<Long> list) {
        this.functionalAreaIds = list;
    }

    public List<String> getFunctionalAreaNames() {
        return this.functionalAreaNames;
    }

    public void setFunctionalAreaNames(List<String> list) {
        this.functionalAreaNames = list;
    }

    public List<Long> getSearchIdCommunities() {
        return this.searchIdCommunities;
    }

    public void setSearchIdCommunities(List<Long> list) {
        this.searchIdCommunities = list;
    }

    public Date getLastActivityDate() {
        return this.lastActivityDate;
    }

    public void setLastActivityDate(Date date) {
        this.lastActivityDate = date;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String str) {
        this.emailId = str;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public boolean getCompanyAdmin() {
        return this.isCompanyAdmin;
    }

    public void setCompanyAdmin(boolean z) {
        this.isCompanyAdmin = z;
    }

    public int getMarsUserCurrentSalary() {
        return this.marsUserCurrentSalary;
    }

    public void setMarsUserCurrentSalary(int i2) {
        this.marsUserCurrentSalary = i2;
    }

    public String getMarsUserPreferredTime() {
        return this.marsUserPreferredTime;
    }

    public void setMarsUserPreferredTime(String str) {
        this.marsUserPreferredTime = str;
    }

    public void setCityId(long j) {
        this.cityId = j;
    }

    public void setCurrently_id(Long l) {
        this.currently_id = l;
    }

    public int getSolrIgnoreNoOfMentorFollowers() {
        return this.solrIgnoreNoOfMentorFollowers;
    }

    public void setSolrIgnoreNoOfMentorFollowers(int i2) {
        this.solrIgnoreNoOfMentorFollowers = i2;
    }

    public String getSolrIgnoreMentorStatus() {
        return this.solrIgnoreMentorStatus;
    }

    public void setSolrIgnoreMentorStatus(String str) {
        this.solrIgnoreMentorStatus = str;
    }

    public boolean isSolrIgnoreHasUserAskedQuestion() {
        return this.solrIgnoreHasUserAskedQuestion;
    }

    public void setSolrIgnoreHasUserAskedQuestion(boolean z) {
        this.solrIgnoreHasUserAskedQuestion = z;
    }

    public long getSolrIgnoreMentorCommunityId() {
        return this.solrIgnoreMentorCommunityId;
    }

    public void setSolrIgnoreMentorCommunityId(long j) {
        this.solrIgnoreMentorCommunityId = j;
    }

    public int getSolrIgnoreNoOfMentorAnswers() {
        return this.solrIgnoreNoOfMentorAnswers;
    }

    public void setSolrIgnoreNoOfMentorAnswers(int i2) {
        this.solrIgnoreNoOfMentorAnswers = i2;
    }

    public boolean isSolrIgnoreIsMentorFollowed() {
        return this.solrIgnoreIsMentorFollowed;
    }

    public void setSolrIgnoreIsMentorFollowed(boolean z) {
        this.solrIgnoreIsMentorFollowed = z;
    }

    public boolean isSuggested() {
        return this.isSuggested;
    }

    public void setSuggested(boolean z) {
        this.isSuggested = z;
    }

    public int getSolrIgnoreNoOfMentorPosts() {
        return this.solrIgnoreNoOfMentorPosts;
    }

    public void setSolrIgnoreNoOfMentorPosts(int i2) {
        this.solrIgnoreNoOfMentorPosts = i2;
    }

    public boolean isSolrIgnoreIsUserFollowed() {
        return this.solrIgnoreIsUserFollowed;
    }

    public void setSolrIgnoreIsUserFollowed(boolean z) {
        this.solrIgnoreIsUserFollowed = z;
    }

    public int getUserFollowing() {
        return this.userFollowing;
    }

    public void setUserFollowing(int i2) {
        this.userFollowing = i2;
    }

    public boolean isCompactView() {
        return this.isCompactView;
    }

    public void setCompactView(boolean z) {
        this.isCompactView = z;
    }

    public int getUserFollowersCount() {
        return this.userFollowersCount;
    }

    public void setUserFollowersCount(int i2) {
        this.userFollowersCount = i2;
    }

    public int getUserCommentsCount() {
        return this.userCommentsCount;
    }

    public void setUserCommentsCount(int i2) {
        this.userCommentsCount = i2;
    }
}
