package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics;

import com.sendbird.android.constant.StringSet;
import java.util.Map;

public enum Event {
    APP_LOGIN(AnalyticsEventType.APP, "Login"),
    POST_LIKED(AnalyticsEventType.POST, "liked"),
    POST_UNLIKED(AnalyticsEventType.POST, "unLiked"),
    POST_SHARED(AnalyticsEventType.POST, "shared"),
    POST_SHARED_CLICKED(AnalyticsEventType.POST, "Shared Clicked"),
    PROFILE_SHARED(AnalyticsEventType.PROFILE, "Shared"),
    POST_BOOKMARKED(AnalyticsEventType.POST, "bookmarked"),
    POST_UNBOOKMARKED(AnalyticsEventType.POST, "unBookmarked"),
    POST_EDITED(AnalyticsEventType.POST, "edited"),
    POST_DELETED(AnalyticsEventType.POST, StringSet.deleted),
    POST_REPORTED(AnalyticsEventType.POST, "reported"),
    POST_APPROVED(AnalyticsEventType.POST, "approved"),
    POST_REJECTED(AnalyticsEventType.POST, "rejected"),
    POST_CREATED(AnalyticsEventType.POST, "created"),
    POST_TOP_POST(AnalyticsEventType.POST, "marked_top_post"),
    POST_LIKES_VIEWED(AnalyticsEventType.POST, "likes_viewed"),
    REPLY_CREATED(AnalyticsEventType.REPLY, "created"),
    REPLY_EDITED(AnalyticsEventType.REPLY, "edited"),
    REPLY_DELETED(AnalyticsEventType.REPLY, StringSet.deleted),
    REPLY_REPORTED(AnalyticsEventType.REPLY, "reported"),
    REPLY_LIKED(AnalyticsEventType.REPLY, "liked"),
    REPLY_UNLIKED(AnalyticsEventType.REPLY, "unliked"),
    JOBS_CREATED(AnalyticsEventType.JOB, "Created"),
    JOBS_SEARCH(AnalyticsEventType.JOB, "Search Performed"),
    JOBS_SEARCH_RESULT_CLICKED(AnalyticsEventType.JOB, "Search Result Click"),
    JOBS_APPLIED(AnalyticsEventType.JOB, "Applied"),
    JOBS_BOOKMARKED(AnalyticsEventType.JOB, "Bookmarked"),
    JOBS_EDITED(AnalyticsEventType.JOB, "Edited"),
    JOBS_DELETED(AnalyticsEventType.JOB, "Deleted"),
    JOBS_SHARED(AnalyticsEventType.JOB, "Shared"),
    JOBS_RECOMMENDED(AnalyticsEventType.JOB, "Recommended"),
    HELPLINE_MESSAGE_CREATED(AnalyticsEventType.HELPLINE_MESSAGE, "Created"),
    CHALLENGE_ACCEPTED(AnalyticsEventType.CHALLENGE, "Accepted"),
    CHALLENGE_SHARED(AnalyticsEventType.CHALLENGE, "Shared"),
    CHALLENGE_SHARED_CLICKED(AnalyticsEventType.CHALLENGE, "Shared Clicked"),
    CHALLENGE_COMPLETED(AnalyticsEventType.CHALLENGE, "Completed"),
    CHALLENGE_SUBMIT_CLICKED(AnalyticsEventType.CHALLENGE, "Submit Clicked"),
    SEND_ADDRESS_CLICKED(AnalyticsEventType.CHALLENGE, "Send Address Clicked"),
    COMMUNITY_JOINED(AnalyticsEventType.COMMUNITY, StringSet.joined),
    COMMUNITY_LEFT(AnalyticsEventType.COMMUNITY, "left"),
    COMMUNITY_SHARED(AnalyticsEventType.COMMUNITY, "shared"),
    COMMUNITY_ADDED_OWNER(AnalyticsEventType.COMMUNITY, "Added Owner"),
    COMMUNITY_REMOVE_OWNER(AnalyticsEventType.COMMUNITY, "Removed Owner"),
    COMMUNITY_ADDED_MEMBER(AnalyticsEventType.COMMUNITY, "Added Member"),
    COMMUNITY_REMOVED_MEMBER(AnalyticsEventType.COMMUNITY, "Removed Member"),
    COMMUNITY_INVITE_CLICKED(AnalyticsEventType.COMMUNITY, "Invite Clicked"),
    COMMUNITY_INVITE(AnalyticsEventType.COMMUNITY, "Invite"),
    APP_INVITE_CLICKED(AnalyticsEventType.APP, " Invite Clicked"),
    APP_INVITE(AnalyticsEventType.APP, " Invite"),
    FRIEND_INVITED(AnalyticsEventType.FRIEND, "Invited"),
    FRIEND_SEARCH(AnalyticsEventType.FRIEND, "Searched"),
    ORGANIZATION_UPVOTED(AnalyticsEventType.ORGANIZATION, "Upvoted"),
    USER_SIGNUP(AnalyticsEventType.USER, "Signed Up"),
    USER_ONBOARDED(AnalyticsEventType.APP, "Onboarded"),
    USER_LOG_OUT(AnalyticsEventType.USER, "Logout"),
    SEARCH_RESULT_SELECTED(AnalyticsEventType.SEARCH, "Result Selected"),
    SEARCH_PERFORMED(AnalyticsEventType.SEARCH, "Performed"),
    SEARCH_CLEARED(AnalyticsEventType.SEARCH, "Cleared"),
    PUSH_NOTIFICATION_SHOWN(AnalyticsEventType.PUSH_NOTIFICATION, "Shown"),
    PUSH_NOTIFICATION_CLICKED(AnalyticsEventType.PUSH_NOTIFICATION, "Clicked"),
    LINK_SHARED(AnalyticsEventType.LINK, "shared"),
    IMAGE_SHARED(AnalyticsEventType.IMAGE, "shared"),
    IMAGE_COPY_LINK(AnalyticsEventType.IMAGE, "copy_lnk"),
    LOOKING_FOR(AnalyticsEventType.LOOKING_FOR, "clicked"),
    PROMO_CARD(AnalyticsEventType.PROMO_CARD, "clicked"),
    IMAGE_CARD(AnalyticsEventType.IMAGE_CARD, "clicked"),
    PROFILE_FOLLOWED(AnalyticsEventType.PROFILE, "Followed"),
    PROFILE_UNFOLLOWED(AnalyticsEventType.PROFILE, "UnFollowed"),
    PROFILE_POST_COUNT(AnalyticsEventType.PROFILE, "Post Count Clicked"),
    PROFILE_EDIT_CLICKED(AnalyticsEventType.PROFILE, "Edit Clicked"),
    PROFILE_EDITED(AnalyticsEventType.PROFILE, "Edited"),
    PROFILE_PIC_EDIT_CLICKED(AnalyticsEventType.PROFILE, "Picture Edit Clicked"),
    PROFILE_FOLLOWER_COUNT(AnalyticsEventType.PROFILE, "Followers Count Clicked"),
    PROFILE_FOLLOWING_COUNT(AnalyticsEventType.PROFILE, "Following Count Clicked"),
    ONBOARDING_COMPLETED(AnalyticsEventType.ON_BOARDING, " Completed"),
    USER_INTRO_TUTORIAL(AnalyticsEventType.USER, "Intro Tutorial"),
    WALKTHROUGH_STARTED(AnalyticsEventType.WALKTHROUGH, " Started"),
    WALKTHROUGH_COMPLETED(AnalyticsEventType.WALKTHROUGH, " Completed"),
    CONTACT_SYNC_ALLOWED(AnalyticsEventType.ALLOWED_CONTACT_SYNC, ""),
    CONTACT_SYNC_DENIED(AnalyticsEventType.DENIED_CONTACT_SYNC, ""),
    POST_LOAD_MORE_CLICKED(AnalyticsEventType.POST_LOAD_MORE, "Clicked"),
    FEED_SCREEN_LOADED(AnalyticsEventType.FEED_SCREEN, "loaded"),
    POST_DETAIL_SCREEN_LOADED(AnalyticsEventType.POST_DETAIL_SCREEN, "loaded"),
    ALBUM_SCREEN_LOADED(AnalyticsEventType.ALBUM_SCREEN, "loaded"),
    CREATE_POST_SCREEN_LOADED(AnalyticsEventType.CREATE_POST_SCREEN, "loaded"),
    FEED_COLLECTION_SCREEN_LOADED(AnalyticsEventType.FEED_COLLECTION_SCREEN, "loaded"),
    VIDEO_SCREEN_LOADED(AnalyticsEventType.VIDEO_SCREEN, "loaded"),
    CREATE_POST_CHOOSE_COMMUNITY_SCREEN_LOADED(AnalyticsEventType.CREATE_POST_CHOOSE_COMMUNITY_SCREEN, "loaded"),
    FACEBOOK_PUBLISHED_CLICKED(AnalyticsEventType.FACEBOOK_PUBLISH, "Clicked"),
    FACEBOOK_PUBLISHED(AnalyticsEventType.FACEBOOK_PUBLISH, "");
    
    public String name;
    public final AnalyticsEventType type;

    private Event(AnalyticsEventType analyticsEventType, String str) {
        this.type = analyticsEventType;
        this.name = str;
    }

    public final String getFullName() {
        return this.type.name + "_" + this.name;
    }

    public final boolean trackEventToProvider(AnalyticsProvider analyticsProvider) {
        return analyticsProvider == AnalyticsProvider.PAYTM_ANALYTICS;
    }

    public final void addProperties(Map<String, Object> map) {
        this.type.addProperties(map);
    }
}
