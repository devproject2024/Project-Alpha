package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.Bamboo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AnalyticsManager {
    private static final String TAG = "AnalyticsManager";
    private static Context sAppContext;

    private static boolean canSend() {
        return sAppContext != null;
    }

    public static void initializeAnalyticsManager(Context context) {
        sAppContext = context;
    }

    public static void trackScreenView(Event event, String str, Map<String, Object> map) {
        if (str != null) {
            trackScreenView(event, str, (String) null, map);
        }
    }

    public static void trackScreenView(Event event, String str, String str2, Map<String, Object> map) {
        if (canSend()) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (!TextUtils.isEmpty(str2)) {
                if (map.containsKey(EventProperty.EVENT_LABEL_2.getString())) {
                    ((HashMap) map.get(EventProperty.EVENT_LABEL_2.getString())).put(EventProperty.SOURCE.getString(), str2);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put(EventProperty.SOURCE.getString(), str2);
                    map.put(EventProperty.EVENT_LABEL_2.getString(), hashMap);
                }
                map.put(EventProperty.SOURCE.getString(), str2);
            }
            trackScreenOpen(event, sAppContext, str, map);
        }
    }

    public static void trackScreenOpen(Event event, Context context, String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(EventProperty.SCREEN_NAME.getString(), str);
        trackEvent(context, event.getFullName(), map);
        HashMap hashMap = new HashMap();
        hashMap.put(EventProperty.SCREEN_NAME.getString(), str);
        hashMap.put(EventProperty.EVENT.getString(), "openScreen");
        SheroesSdk.getAnalyticsCallback().onEventTriggered(hashMap);
    }

    public static void trackEvent(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        new JSONObject(map);
        map.put(EventProperty.EVENT_CATEGORY.getString(), "sheroes");
        map.put(EventProperty.EVENT_ACTION.getString(), str);
        map.put(EventProperty.VERTICAL_NAME.getString(), "inbox");
        map.put(EventProperty.EVENT.getString(), GAUtil.CUSTOM_EVENT);
        map.put(EventProperty.USER_ID.getString(), CommonUtil.getPref(AppConstants.SHEROES_USER_ID));
        SheroesSdk.getAnalyticsCallback().onEventTriggered(map);
        Bamboo.i(AnalyticsManager.class.getSimpleName(), new JSONObject(map).toString());
    }

    public static void timeScreenView(String str) {
        if (!canSend()) {
        }
    }

    @Deprecated
    public static void trackEvent(Event event, Map<String, Object> map, String str) {
        trackEvent(event, str, map);
    }

    public static void trackEvent(Event event, String str, Map<String, Object> map) {
        if (canSend()) {
            if (map == null) {
                map = new HashMap<>();
            }
            event.addProperties(map);
            if (StringUtil.isNotNullOrEmptyString(str) && !map.containsKey(str)) {
                map.put(EventProperty.SCREEN_NAME.getString(), str);
            }
            if (event.trackEventToProvider(AnalyticsProvider.PAYTM_ANALYTICS)) {
                map.put(EventProperty.EVENT_CATEGORY.getString(), "sheroes");
                map.put(EventProperty.EVENT_ACTION.getString(), event.getFullName());
                map.put(EventProperty.USER_ID.getString(), CommonUtil.getPref(AppConstants.SHEROES_USER_ID));
                map.put(EventProperty.VERTICAL_NAME.getString(), "inbox");
                SheroesSdk.getAnalyticsCallback().onEventTriggered(map);
                Bamboo.i(AnalyticsManager.class.getSimpleName(), new JSONObject(map).toString());
            }
        }
    }

    public static void trackPostAction(Event event, FeedDetail feedDetail, String str) {
        if (canSend()) {
            trackPostActionEvent(event, feedDetail, str);
        }
    }

    public static void trackCommunityAction(Event event, CommunityFeedSolrObj communityFeedSolrObj, String str) {
        if (canSend()) {
            trackCommunityEvent(event, communityFeedSolrObj, str);
        }
    }

    public static void trackPostActionEvent(Event event, FeedDetail feedDetail, String str) {
        if (feedDetail != null && StringUtil.isNotNullOrEmptyString(feedDetail.getSubType())) {
            UserPostSolrObj userPostSolrObj = null;
            if (feedDetail instanceof UserPostSolrObj) {
                userPostSolrObj = (UserPostSolrObj) feedDetail;
            }
            HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString(feedDetail.getIdOfEntityOrParticipant())).title(feedDetail.getNameOrTitle()).positionInList(Integer.valueOf(feedDetail.getItemPosition())).build();
            String str2 = "";
            EventProperty.Builder communityId = new EventProperty.Builder().communityName(userPostSolrObj != null ? userPostSolrObj.getPostCommunityName() : str2).communityId(userPostSolrObj != null ? Long.toString(userPostSolrObj.getCommunityId().longValue()) : "not defined");
            if (CommonUtil.isNotEmpty(feedDetail.getStreamType())) {
                str2 = feedDetail.getStreamType();
            }
            HashMap<String, Object> build2 = new EventProperty.Builder().eventLabel(build).eventLabel2(communityId.streamType(str2).build()).build();
            build2.put(EventProperty.SCREEN_NAME.getString(), str);
            trackEvent(event, str, (Map<String, Object>) build2);
        }
    }

    public static HashMap<String, Object> getPostProperties(FeedDetail feedDetail, String str) {
        UserPostSolrObj userPostSolrObj = null;
        if (feedDetail == null || !StringUtil.isNotNullOrEmptyString(feedDetail.getSubType())) {
            return null;
        }
        if (feedDetail instanceof UserPostSolrObj) {
            userPostSolrObj = (UserPostSolrObj) feedDetail;
        }
        HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString(feedDetail.getIdOfEntityOrParticipant())).title(feedDetail.getNameOrTitle()).positionInList(Integer.valueOf(feedDetail.getItemPosition())).build();
        String str2 = "";
        EventProperty.Builder communityName = new EventProperty.Builder().communityId(userPostSolrObj != null ? Long.toString(userPostSolrObj.getCommunityId().longValue()) : "not defined").communityName(userPostSolrObj != null ? userPostSolrObj.getPostCommunityName() : str2);
        if (CommonUtil.isNotEmpty(feedDetail.getStreamType())) {
            str2 = feedDetail.getStreamType();
        }
        HashMap<String, Object> build2 = new EventProperty.Builder().eventLabel(build).eventLabel2(communityName.streamType(str2).build()).build();
        build2.put(EventProperty.SCREEN_NAME.getString(), str);
        return build2;
    }

    public static void trackCommunityEvent(Event event, CommunityFeedSolrObj communityFeedSolrObj, String str) {
        if (StringUtil.isNotNullOrEmptyString(communityFeedSolrObj.getSubType())) {
            HashMap<String, Object> build = new EventProperty.Builder().eventLabel(new EventProperty.Builder().communityId(Long.toString(communityFeedSolrObj.getIdOfEntityOrParticipant())).communityName(communityFeedSolrObj.getNameOrTitle()).build()).build();
            build.put(EventProperty.SCREEN_NAME.getString(), str);
            trackEvent(event, communityFeedSolrObj.getScreenName(), (Map<String, Object>) build);
        }
    }
}
