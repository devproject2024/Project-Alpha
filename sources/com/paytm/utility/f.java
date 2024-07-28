package com.paytm.utility;

public final class f {

    public enum a {
        PPB_ICA("ppb_ica"),
        PREF_NEARBY_CITY_STORE_FRONT("nearby_store_front"),
        FD_FIRST_TIME_TRACK("fd_first_time_track_file"),
        PREF_APP_MANAGER("appManager"),
        METRO_PREF("metro_prefs"),
        KYC_SHARED_PREF("kycSharedPref"),
        CB_CACHE_PREF("CB_CACHE_PREF"),
        SMS_SDK_PREF("smssdk_pref"),
        FEED("feed"),
        TRAIN_MOST_PREF_KEY("train_most_visited"),
        TRAIN_SEARCH_NOTIFICATION_SHARED("train_search_notification_shared"),
        PREF_NAME("RateThisApp"),
        IN_APP_UPDATE("inAppUpdate"),
        PREFERENCE_FILE_KEY("com.paytm.easypay.PREFERENCE_FILE_KEY"),
        PREF_KEY_USER_NOT_VERIFIED("USER_NOT_VERIFIED");
        
        private final String prefname;

        private a(String str) {
            this.prefname = str;
        }

        public final String getPrefname() {
            return this.prefname;
        }
    }
}
