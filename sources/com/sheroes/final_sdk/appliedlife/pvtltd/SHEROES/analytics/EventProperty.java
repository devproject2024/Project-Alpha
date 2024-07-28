package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics;

import android.text.TextUtils;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public enum EventProperty {
    AUTH_PROVIDER("AUTH_PROVIDER"),
    IS_NEW_USER("Is New User"),
    ID("id"),
    LIST("List"),
    NAME("Name"),
    EVENT(AppConstants.NOTIFICATION_DETAILS.EVENT),
    SOURCE("Source"),
    SCREEN_NAME(SDKConstants.EVENT_KEY_SCREEN_NAME),
    VERTICAL_NAME("vertical_name"),
    USER_ID("user_id"),
    TITLE("title"),
    TYPE(AppManagerUtil.EXTEND_TYPE),
    URL("url"),
    VIDEO_URL("video_url"),
    SOURCE_URL("Source Url"),
    ACTION("Action"),
    POSITION_IN_LIST(CLPConstants.ARGUMENT_KEY_POSITION),
    POST_TYPE("Post Type"),
    POST_ID("Post Id"),
    BODY("Body"),
    COMPANY_ID("Company Id"),
    LOCATION("Location"),
    COMMUNITY_ID("communityid"),
    CHALLENGE_ID("Challenge Id"),
    COMMUNITY_NAME("commmunityname"),
    KEYWORD("Keyword"),
    SHARED_TO("Share To"),
    ENTITY_ID("Entity Id"),
    ACTIVITY_NAME("Activity Name"),
    LOOKING_FOR_NAME("Looking For Name"),
    TAB_TITLE("Tab Title"),
    TAB_KEY("Tab Key"),
    SOURCE_SCREEN_ID("Source Screen Id"),
    SOURCE_TAB_KEY("Source Tab Key"),
    SOURCE_TAB_TITLE("Source Tab Title"),
    IS_MOENGAGE(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.IS_MOENGAGE),
    POSITION_IN_SEQUENCE("Position In Sequence"),
    IS_MENTOR("Is Mentor"),
    IS_OWN_PROFILE("Is Own Profile"),
    DESCRIPTION("Description"),
    COMMUNITY_CATEGORY("Community Category"),
    POSITION_IN_CAROUSEL("Position In Carousel"),
    IS_CHECKED("Is Checked"),
    COLLECTION_NAME("collection_name"),
    STREAM_TYPE("streamtype"),
    SOURCE_COLLECTION_NAME("Source Collection Name"),
    EVENT_ACTION("event_action"),
    EVENT_CATEGORY("event_category"),
    EVENT_LABEL("event_label"),
    EVENT_LABEL_2("event_label 2"),
    POSITION_OF_CAROUSEL("Position Of Carousel");
    
    private final String string;

    private EventProperty(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.string = str;
            return;
        }
        throw new IllegalStateException("EventProperty name not initialized!");
    }

    public final String getString() {
        return this.string;
    }

    public static class Builder {
        private HashMap<String, Object> properties;

        private static <T> boolean validateData(EventProperty eventProperty, T t) {
            return (eventProperty == null || t == null) ? false : true;
        }

        public Builder() {
            this.properties = new HashMap<>();
        }

        private <T> boolean put(EventProperty eventProperty, T t) {
            if (validateData(eventProperty, t)) {
                this.properties.put(eventProperty.getString(), t);
            }
            return t != null;
        }

        public Builder action(String str) {
            put(EventProperty.ACTION, str);
            return this;
        }

        public Builder id(String str) {
            put(EventProperty.ID, str);
            return this;
        }

        public Builder name(String str) {
            put(EventProperty.NAME, str);
            return this;
        }

        public Builder title(String str) {
            put(EventProperty.TITLE, str);
            return this;
        }

        public Builder postType(String str) {
            put(EventProperty.POST_TYPE, str);
            return this;
        }

        public Builder postId(String str) {
            put(EventProperty.POST_ID, str);
            return this;
        }

        public Builder body(String str) {
            put(EventProperty.BODY, str);
            return this;
        }

        public Builder type(String str) {
            put(EventProperty.TYPE, str);
            return this;
        }

        public Builder authProvider(String str) {
            put(EventProperty.AUTH_PROVIDER, str);
            return this;
        }

        public Builder isNewUser(boolean z) {
            put(EventProperty.IS_NEW_USER, Boolean.valueOf(z));
            return this;
        }

        public Builder list(String str) {
            put(EventProperty.LIST, str);
            return this;
        }

        public Builder url(String str) {
            put(EventProperty.URL, str);
            return this;
        }

        public Builder sourceUrl(String str) {
            put(EventProperty.SOURCE_URL, str);
            return this;
        }

        public Builder companyId(String str) {
            put(EventProperty.COMPANY_ID, str);
            return this;
        }

        public Builder location(String str) {
            put(EventProperty.LOCATION, str);
            return this;
        }

        public Builder communityId(String str) {
            put(EventProperty.COMMUNITY_ID, str);
            return this;
        }

        public Builder eventLabel(HashMap<String, Object> hashMap) {
            put(EventProperty.EVENT_LABEL, hashMap);
            return this;
        }

        public Builder eventLabel2(HashMap<String, Object> hashMap) {
            put(EventProperty.EVENT_LABEL_2, hashMap);
            return this;
        }

        public Builder eventAction(String str) {
            put(EventProperty.EVENT_ACTION, str);
            return this;
        }

        public Builder challengeId(String str) {
            put(EventProperty.CHALLENGE_ID, str);
            return this;
        }

        public Builder entityId(String str) {
            put(EventProperty.ENTITY_ID, str);
            return this;
        }

        public Builder communityName(String str) {
            put(EventProperty.COMMUNITY_NAME, str);
            return this;
        }

        public Builder communityCategory(String str) {
            put(EventProperty.COMMUNITY_CATEGORY, str);
            return this;
        }

        public Builder positionInCarousel(String str) {
            put(EventProperty.POSITION_IN_CAROUSEL, str);
            return this;
        }

        public Builder positionOfCarousel(String str) {
            put(EventProperty.POSITION_OF_CAROUSEL, str);
            return this;
        }

        public Builder isMonengage(boolean z) {
            put(EventProperty.IS_MOENGAGE, Boolean.valueOf(z));
            return this;
        }

        public Builder keyword(String str) {
            put(EventProperty.KEYWORD, str);
            return this;
        }

        public HashMap<String, Object> build() {
            return this.properties;
        }

        public Builder positionInList(Integer num) {
            put(EventProperty.POSITION_IN_LIST, num);
            return this;
        }

        public Builder sharedTo(String str) {
            put(EventProperty.SHARED_TO, str);
            return this;
        }

        public Builder activityName(String str) {
            put(EventProperty.ACTIVITY_NAME, str);
            return this;
        }

        public Builder lookingForName(String str) {
            put(EventProperty.LOOKING_FOR_NAME, str);
            return this;
        }

        public Builder tabTitle(String str) {
            put(EventProperty.TAB_TITLE, str);
            return this;
        }

        public Builder tabKey(String str) {
            put(EventProperty.TAB_KEY, str);
            return this;
        }

        public Builder sourceScreenId(String str) {
            put(EventProperty.SOURCE_SCREEN_ID, str);
            return this;
        }

        public Builder sourceTabKey(String str) {
            put(EventProperty.SOURCE_TAB_KEY, str);
            return this;
        }

        public Builder sourceTabTitle(String str) {
            put(EventProperty.SOURCE_TAB_TITLE, str);
            return this;
        }

        public Builder positionInSequence(String str) {
            put(EventProperty.POSITION_IN_SEQUENCE, str);
            return this;
        }

        public Builder description(String str) {
            put(EventProperty.DESCRIPTION, str);
            return this;
        }

        public Builder isMentor(boolean z) {
            put(EventProperty.IS_MENTOR, Boolean.valueOf(z));
            return this;
        }

        public Builder isChecked(boolean z) {
            put(EventProperty.IS_CHECKED, Boolean.valueOf(z));
            return this;
        }

        public Builder isOwnProfile(boolean z) {
            put(EventProperty.IS_OWN_PROFILE, Boolean.valueOf(z));
            return this;
        }

        public Builder collectionName(String str) {
            put(EventProperty.COLLECTION_NAME, str);
            return this;
        }

        public Builder sourceCollectionName(String str) {
            put(EventProperty.SOURCE_COLLECTION_NAME, str);
            return this;
        }

        public Builder streamType(String str) {
            put(EventProperty.STREAM_TYPE, str);
            return this;
        }
    }
}
