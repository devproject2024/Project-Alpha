package com.business.merchant_payments.common.utility;

import android.content.Context;
import android.text.TextUtils;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.ups.Preferences;
import com.google.gson.b.a;
import com.google.gsonhtcfix.f;
import java.util.ArrayList;
import java.util.List;

public class APSharedPreferences {
    public static final String APP_OPENING_TIME = "app_opening_time";
    public static final String APP_OPENS_COUNT = "app_opens_count";
    public static final String CUSTOM_CARD_NEVER_SHOW_PREFERENCES = "customCardNeverShowPreferences";
    public static final String CUSTOM_CARD_NEXT_DAY_PREFERENCES = "customCardNextDayPreferences";
    public static final String DAYS_SINCE_LAST_SEEN_RATE_DIALOG = "days_since_last_seen_rate_dialog_count";
    public static final String INSTANT_SETTLED_TRACKED_MID = "instant_settled_tracked_mid";
    public static final String IS_ECHO_GA_ENABLED = "is_echo_ga_enabled";
    public static final String IS_VOICE_NOTIFICATION_ENABLED = "IS_VOICE_NOTIFICATION_ENABLED";
    public static final String KEY_DRAWER_VISIT = "drawer_visits";
    public static final String KEY_HELPLINE_NUMBER = "helpline_number";
    public static final String KEY_QR_TEXT = "key_qr_text";
    public static final String KEY_UPS_SYNC_TIMESTAMP = "key_ups_sync_timestamp";
    public static final String LIMIT_UPGRADE_LEAD_STATUS = "limit_upgrade_lead_status";
    public static final String LOCK_SCREEN_NOTIFICATION = "LOCK_SCREEN_NOTIFICATION";
    public static final String PAN_REGEX_ID = "pan_regex_id";
    public static final String SELECTED_LANGUAGE = "selected_language";
    public static final String SETTLEMENT_TOOL_TIP_SHOW_COUNT = "settlement_tool_tip_show_count";
    public static final String SETTLEMENT_TOOL_TIP_SHOW_TIME = "settlement_tool_tip_show_time";
    public static final String SETTLEMENT_TRIGGER_FREQUENCY = "settlement_trigger_frequency";
    public static final String SHOULD_CHECK_FOR_INSTANT_SETT = "should_check_for_instant_settlement";
    public static final String SHOULD_SHOW_VERIFY_QR = "should_Show_verify_qr";
    public static final String STORE_FRONT_RESPONSE = "storefront_response";
    public static final String TAG = "APSharedPreferences";
    public static final String TAG_LAT = "lat";
    public static final String TAG_LONG = "long";
    public static final String UPS_PREFERENCES_DATA = "ups_preferences_data";
    public static final String USER_SEEN_RATE_DIALOG = "user_seen_rate_dialog";
    public static final String VERIFY_QR_ACTION_TIMESTAMP = "VERIFY_QR_ACTION_TIMESTAMP";
    public static final String VOICE_LOCALE = "VOICE_LOCALE";
    public static final String WAS_INSTANT_SETTLEMENT_ENABLED = "was_instant_settlement_enabled";
    public static APSharedPreferences mInstance;
    public final Context context = PaymentsConfig.getInstance().getAppContext();

    public void onSignOut() {
    }

    public static APSharedPreferences getInstance() {
        if (mInstance == null) {
            synchronized (APSharedPreferences.class) {
                if (mInstance == null) {
                    mInstance = new APSharedPreferences();
                }
            }
        }
        return mInstance;
    }

    public String getUserToken() {
        return PaymentsConfig.getInstance().getMerchantDataProvider().B();
    }

    public String getMerchantMobile() {
        return PaymentsConfig.getInstance().getMerchantDataProvider().z();
    }

    public String getMerchantMid() {
        return PaymentsConfig.getInstance().getMerchantDataProvider().D();
    }

    public String getCustomerId() {
        return PaymentsConfig.getInstance().getMerchantDataProvider().H();
    }

    public String getLatitude(Context context2) {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(context2, "lat", "");
    }

    public String getLongitude(Context context2) {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(context2, "long", "");
    }

    public String getLanguage(Context context2) {
        String b2 = PaymentsConfig.getInstance().getAppSharedPreference().b(context2, "selected_language", "en");
        if (b2.equalsIgnoreCase("en") || b2.equalsIgnoreCase("hi") || b2.equalsIgnoreCase("ta") || b2.equalsIgnoreCase("te") || b2.equalsIgnoreCase("kn") || b2.equalsIgnoreCase("pa") || b2.equalsIgnoreCase("mr") || b2.equalsIgnoreCase("gu") || b2.equalsIgnoreCase("bn") || b2.equalsIgnoreCase("ml") || b2.equalsIgnoreCase("or")) {
            return b2;
        }
        return "en";
    }

    public void storeLocationInPref(double d2, double d3) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, "lat", String.valueOf(d2));
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, "long", String.valueOf(d3));
    }

    public boolean isMerchantMigrated() {
        return PaymentsConfig.getInstance().getMerchantDataProvider().i();
    }

    public String getMerchantDisplayName(Context context2) {
        return PaymentsConfig.getInstance().getMerchantDataProvider().E();
    }

    public void setNoOfQRScreenVisits(int i2) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, SHOULD_SHOW_VERIFY_QR, i2);
    }

    public String getUserPANRegex() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, "pan_regex_id", "");
    }

    public boolean wasInstantSettlementActivated() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, WAS_INSTANT_SETTLEMENT_ENABLED, false);
    }

    public void setInstantSettlementStatus(boolean z) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, WAS_INSTANT_SETTLEMENT_ENABLED, z);
    }

    public boolean shouldCheckForInstantSett() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, SHOULD_CHECK_FOR_INSTANT_SETT, true);
    }

    public void setShouldCheckForInstantSett(boolean z) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, SHOULD_CHECK_FOR_INSTANT_SETT, z);
    }

    public String getISTrackedMerchantId() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, INSTANT_SETTLED_TRACKED_MID, "");
    }

    public void setISTrackedMerchantId(String str) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, INSTANT_SETTLED_TRACKED_MID, str);
    }

    public boolean getIfEchoGA(Context context2) {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(context2, IS_ECHO_GA_ENABLED, false);
    }

    public String getCurrentMerchantGuid() {
        return PaymentsConfig.getInstance().getMerchantDataProvider().A();
    }

    public boolean getIsAppTutorialComplete(Context context2) {
        if (context2 != null) {
            return PaymentsConfig.getInstance().getAppSharedPreference().b(context2, "is_app_walkthrough_complete", false);
        }
        return false;
    }

    public String getMerchantEmail() {
        return PaymentsConfig.getInstance().getMerchantDataProvider().C();
    }

    public String getUpgradeLimitLeadStatus() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, LIMIT_UPGRADE_LEAD_STATUS, "");
    }

    public void setLanguage(String str) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, "selected_language", str);
    }

    public int getSettlementToolTipCount() {
        return PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, SETTLEMENT_TOOL_TIP_SHOW_COUNT);
    }

    public void setSettlementToolTipShowCount(int i2) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, SETTLEMENT_TOOL_TIP_SHOW_COUNT, i2);
    }

    public void setSettlementToolTipShowTime(long j) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, SETTLEMENT_TOOL_TIP_SHOW_TIME, j);
    }

    public long getSettlementToolTipShowTime() {
        return (long) PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, SETTLEMENT_TOOL_TIP_SHOW_TIME);
    }

    public String getNeverShowCards() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, CUSTOM_CARD_NEVER_SHOW_PREFERENCES, "");
    }

    public String getCustomCardsNextDay() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, CUSTOM_CARD_NEXT_DAY_PREFERENCES, "");
    }

    public void removePreviousDayCards() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CUSTOM_CARD_NEXT_DAY_PREFERENCES);
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, (List<String>) arrayList);
    }

    public void saveNextDayCardPreference(String str) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, CUSTOM_CARD_NEXT_DAY_PREFERENCES, str);
    }

    public void saveNeverShowCards(String str) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, CUSTOM_CARD_NEVER_SHOW_PREFERENCES, str);
    }

    public void saveQrText(String str) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, KEY_QR_TEXT, str);
    }

    public void saveUPSSyncTimestamp(long j) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, KEY_UPS_SYNC_TIMESTAMP, j);
    }

    public long getUPSSyncTimestamp() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, KEY_UPS_SYNC_TIMESTAMP, 0);
    }

    public void saveUPSData(List<Preferences> list) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, UPS_PREFERENCES_DATA, new f().a((Object) list));
        saveUPSSyncTimestamp(System.currentTimeMillis());
    }

    public List<Preferences> getUPSData() {
        String b2 = PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, UPS_PREFERENCES_DATA, "");
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return (List) new f().a(b2, new a<List<Preferences>>(this) {
        }.getType());
    }

    public String getIsVoiceNotificationEnabled() {
        return String.valueOf(PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, IS_VOICE_NOTIFICATION_ENABLED, false));
    }

    public String getIsLockScreenNotificationEnabled() {
        return String.valueOf(PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, LOCK_SCREEN_NOTIFICATION, false));
    }

    public void setIsVoiceNotificationEnabled(boolean z) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, IS_VOICE_NOTIFICATION_ENABLED, z);
    }

    public void setSettlementTriggerFrequency(int i2) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, SETTLEMENT_TRIGGER_FREQUENCY, i2);
    }

    public void setIsLockScreenNotificationEnabled(boolean z) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, LOCK_SCREEN_NOTIFICATION, z);
    }

    public String getVoiceLocale() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, VOICE_LOCALE, "en");
    }

    public void setVoiceLocale(String str) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, VOICE_LOCALE, str);
    }

    public void saveVerifyQrActionTimeStamp(long j) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, VERIFY_QR_ACTION_TIMESTAMP, j);
    }

    private long getVerifyQrActionTimeStamp() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, VERIFY_QR_ACTION_TIMESTAMP, 0);
    }

    public long incrementDrawerVisits() {
        long drawerVisits = getDrawerVisits() + 1;
        if (drawerVisits < 0) {
            drawerVisits = 0;
        }
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, KEY_DRAWER_VISIT, drawerVisits);
        return drawerVisits;
    }

    public long getDrawerVisits() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, KEY_DRAWER_VISIT, 0);
    }

    public boolean shouldShowVerifyQRBottomSheet() {
        long drawerVisits = getDrawerVisits();
        if (DateUtility.checkDateIsTodayDate(getVerifyQrActionTimeStamp())) {
            return false;
        }
        int i2 = PaymentsConfig.getInstance().getGTMDataProvider().getInt(PaymentsGTMConstants.VERIFY_QR_POPUP_INTERVERVAL, 5);
        if (i2 == 0) {
            i2 = 5;
        }
        if (drawerVisits == 0 || drawerVisits % ((long) i2) != 0) {
            return false;
        }
        return true;
    }

    public void onSignOut(Context context2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("helpline_number");
        arrayList.add(SETTLEMENT_TOOL_TIP_SHOW_TIME);
        arrayList.add(SETTLEMENT_TOOL_TIP_SHOW_COUNT);
        arrayList.add("pan_regex_id");
        arrayList.add(LIMIT_UPGRADE_LEAD_STATUS);
        arrayList.add(STORE_FRONT_RESPONSE);
        arrayList.add(SHOULD_SHOW_VERIFY_QR);
        arrayList.add(CUSTOM_CARD_NEXT_DAY_PREFERENCES);
        arrayList.add(CUSTOM_CARD_NEVER_SHOW_PREFERENCES);
        arrayList.add("selected_language");
        arrayList.add("lat");
        arrayList.add("long");
        arrayList.add(KEY_QR_TEXT);
        arrayList.add(UPS_PREFERENCES_DATA);
        arrayList.add(KEY_UPS_SYNC_TIMESTAMP);
        arrayList.add(IS_VOICE_NOTIFICATION_ENABLED);
        arrayList.add(VOICE_LOCALE);
        arrayList.add(VERIFY_QR_ACTION_TIMESTAMP);
        arrayList.add(KEY_DRAWER_VISIT);
        PaymentsConfig.getInstance().getAppSharedPreference().a(context2, (List<String>) arrayList);
    }

    public void setAppOpenCount(int i2) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, "app_opens_count", i2);
    }

    public int getAppOpenCount() {
        return PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, "app_opens_count");
    }

    public void setLastSeenDialogCount(int i2) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, DAYS_SINCE_LAST_SEEN_RATE_DIALOG, i2);
    }

    public int getLastSeenDialogcount() {
        return PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, DAYS_SINCE_LAST_SEEN_RATE_DIALOG);
    }

    public void setUserSeenDialog(boolean z) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, USER_SEEN_RATE_DIALOG, z);
    }

    public boolean getUserSeenDialog() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, USER_SEEN_RATE_DIALOG, false);
    }

    public void saveAppOpeningTime(long j) {
        PaymentsConfig.getInstance().getAppSharedPreference().a(this.context, APP_OPENING_TIME, j);
    }

    public long getAppOpeningTime() {
        return PaymentsConfig.getInstance().getAppSharedPreference().b(this.context, APP_OPENING_TIME, System.currentTimeMillis());
    }
}
