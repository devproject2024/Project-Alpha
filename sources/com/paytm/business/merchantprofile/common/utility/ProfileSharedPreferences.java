package com.paytm.business.merchantprofile.common.utility;

import android.content.Context;
import android.util.Pair;
import com.paytm.business.merchantprofile.ProfileConfig;
import java.util.ArrayList;
import java.util.List;

public class ProfileSharedPreferences {
    public static final String ACCOuNT_REACTIVATION_PENDING = "ACCOuNT_REACTIVATION_PENDING";
    public static final String AREA = "area";
    public static final String CHANNELS_PERMISSION_API_TIME = "channels_permission_api_time";
    public static final String CHANNEL_LANGUAGE = "channel_language";
    public static final String CITY = "city";
    public static final String IS_USER_LAT_LONG_PRESENT = "is_user_lat_long_present";
    public static final String KEY_HELPLINE_NUMBER = "helpline_number";
    public static final String KEY_MERCHANT_GV_LEAD_REQUEST_TIMESTAMP = "key_merchant_gv_lead_request_timestamp";
    public static final String KEY_MERCHANT_GV_LEAD_STATUS = "key_merchant_gv_lead_status";
    public static final String PAN_REGEX_ID = "pan_regex_id";
    public static final String SELECTED_LANGUAGE = "selected_language";
    public static final String SHOULD_SHOW_CHANNELS = "should_show_channels";
    public static final String TAG = "APSharedPreferences";
    public static final String TAG_LAT = "lat";
    public static final String TAG_LONG = "long";
    public static final String USER_LAT_LONG_UPDATED_TIMER = "user_lat_long_updated_timer";
    public static ProfileSharedPreferences mInstance;
    public final Context context = ProfileConfig.getInstance().getAppContext();

    public void onSignOut() {
    }

    public static ProfileSharedPreferences getInstance() {
        if (mInstance == null) {
            synchronized (ProfileSharedPreferences.class) {
                if (mInstance == null) {
                    mInstance = new ProfileSharedPreferences();
                }
            }
        }
        return mInstance;
    }

    public String getUserToken() {
        return ProfileConfig.getInstance().getMerchantDataProvider().B();
    }

    public String getMerchantMid() {
        return ProfileConfig.getInstance().getMerchantDataProvider().D();
    }

    public String getLatitude(Context context2) {
        return ProfileConfig.getInstance().getAppSharedPreference().b(context2, "lat", "");
    }

    public String getLongitude(Context context2) {
        return ProfileConfig.getInstance().getAppSharedPreference().b(context2, "long", "");
    }

    public String getLanguage(Context context2) {
        String b2 = ProfileConfig.getInstance().getAppSharedPreference().b(context2, "selected_language", "en");
        if (b2.equalsIgnoreCase("en") || b2.equalsIgnoreCase("hi") || b2.equalsIgnoreCase("ta") || b2.equalsIgnoreCase("te") || b2.equalsIgnoreCase("kn") || b2.equalsIgnoreCase("pa") || b2.equalsIgnoreCase("mr") || b2.equalsIgnoreCase("gu") || b2.equalsIgnoreCase("bn") || b2.equalsIgnoreCase("ml") || b2.equalsIgnoreCase("or")) {
            return b2;
        }
        return "en";
    }

    public String getMerchantDisplayName(Context context2) {
        return ProfileConfig.getInstance().getMerchantDataProvider().E();
    }

    public String getUserPANRegex() {
        return ProfileConfig.getInstance().getAppSharedPreference().b(this.context, "pan_regex_id", "");
    }

    public String getUserPicUrl() {
        return ProfileConfig.getInstance().getMerchantDataProvider().a();
    }

    public void setCurrentMerchantName(String str) {
        ProfileConfig.getInstance().getMerchantDataProvider().a(str);
    }

    public void setUserCity(String str) {
        ProfileConfig.getInstance().getAppSharedPreference().a(this.context, "city", str);
    }

    public void setUserArea(String str) {
        ProfileConfig.getInstance().getAppSharedPreference().a(this.context, AREA, str);
    }

    public void clearChannelsPreferences() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(IS_USER_LAT_LONG_PRESENT, Boolean.FALSE));
        arrayList.add(new Pair(SHOULD_SHOW_CHANNELS, Boolean.FALSE));
        arrayList.add(new Pair(USER_LAT_LONG_UPDATED_TIMER, 0));
        arrayList.add(new Pair(CHANNELS_PERMISSION_API_TIME, 0));
        arrayList.add(new Pair(CHANNEL_LANGUAGE, ""));
        ProfileConfig.getInstance().getAppSharedPreference().b(this.context, arrayList);
    }

    public void clearGVPreferences() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(KEY_MERCHANT_GV_LEAD_STATUS, (Object) null));
        arrayList.add(new Pair(KEY_MERCHANT_GV_LEAD_REQUEST_TIMESTAMP, 0));
        ProfileConfig.getInstance().getAppSharedPreference().b(this.context, arrayList);
    }

    public void onSignOut(Context context2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ACCOuNT_REACTIVATION_PENDING);
        ProfileConfig.getInstance().getAppSharedPreference().a(context2, (List<String>) arrayList);
    }
}
