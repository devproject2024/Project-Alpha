package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics;

import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import java.util.Map;

public enum AnalyticsEventType {
    APP("App"),
    POST("post"),
    PROFILE("Profile"),
    REPLY("reply"),
    JOB("Job"),
    HELPLINE_MESSAGE("Helpline Message "),
    CHALLENGE("Challenge"),
    COMMUNITY("Community"),
    ON_BOARDING("Onboarding"),
    WALKTHROUGH("Walkthrough"),
    FACEBOOK_PUBLISH("Facebook Publish"),
    ALLOWED_CONTACT_SYNC("Allowed Contact Sync"),
    DENIED_CONTACT_SYNC("Denied Contact Sync"),
    ORGANIZATION("Organization"),
    ARTICLE("Article"),
    CHAT("Chat"),
    NOTIFICATION_LIST("Notification List"),
    PUSH_NOTIFICATION("Push Notification"),
    USER("User"),
    SEARCH("Search"),
    IMAGE(H5ResourceHandlerUtil.IMAGE),
    LOOKING_FOR("Looking For"),
    LINK("Link"),
    PROMO_CARD("Promo Card"),
    POST_LOAD_MORE("Post Load More"),
    FRIEND("Friend"),
    FEED_SCREEN("feed_screen"),
    POST_DETAIL_SCREEN("post_detail_screen"),
    ALBUM_SCREEN("album_screen"),
    CREATE_POST_SCREEN("create_post_screen"),
    VIDEO_SCREEN("video_screen"),
    FEED_COLLECTION_SCREEN("feed_collection_screen"),
    CREATE_POST_CHOOSE_COMMUNITY_SCREEN("create_post_choose_community_screen"),
    IMAGE_CARD("Image Card");
    
    public final String name;

    public final void addProperties(Map<String, Object> map) {
    }

    private AnalyticsEventType(String str) {
        this.name = str;
    }
}
