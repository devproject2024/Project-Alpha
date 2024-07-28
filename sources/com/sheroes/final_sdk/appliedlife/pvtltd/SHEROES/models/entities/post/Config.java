package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import org.parceler.Parcel;

@Parcel
public class Config {
    private static final String APP_SHARE_URL = "";
    public static final String COMMUNITY_POST_CHALLENGE_SHARE = "I found this challenge on Sheroes app. Download the app and view the complete challenge here";
    public static final String COMMUNITY_POST_IMAGE_SHARE = "I found this useful infographic on Sheroes app. Download the app and view the complete post here";

    public static Config getConfig() {
        return null;
    }

    public static String getShareUrl() {
        if (getConfig() == null) {
        }
        return "";
    }
}
