package com.paytm.b.a;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.utility.f;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.utility.r;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f42659a = new e();

    private e() {
    }

    public static List<String> a(String str) {
        String str2 = str;
        k.c(str2, "prefName");
        if (k.a((Object) str2, (Object) a.c.TRAVEL_HOME.name())) {
            return kotlin.a.k.d(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, "is-model-file-existing", "language_change", "trainPushCount", "roaming_set_twice", "flight_recent_search_details", "flight-recent-city-source", "FLIGHT_NON_STOP_CHECK_ROUND_TRIP", "FLIGHT_NON_STOP_CHECK_ONE_WAY", "flight-recent-city-destination", "tentative_disclaimer", "registered_irctc_mobile_number", "registered_irctc_email_id", "registered_user_id", "train_show_tip_view_for_search_page", "train_show_tip_details_view", "new_user_flag", "train_color_info", "requestId", "UTM_STRING_HOTEL", "hotel_five_recent_search", "checkindate", "checkOutdate", "recent-location-list", "prefill-from-data", "prefill-to-data", "prefill-date-value", "prefill-date-value-tag", "RecentSearchOriginCity", "RecentSearchDestinationCity", "recent-search-list", "payment_tip_key", "bus_user_info_details", "email_bus", "citybus-prefill-to-data", "citybus-prefill-from-data", "e_purse_tt", "token_validation_tt", "pref_key_wallet_balance");
        }
        if (k.a((Object) str2, (Object) a.c.MOVIES.name())) {
            return kotlin.a.k.d("device_height", StringSet.height, "movies_cached_city_name", "movies_cached_city_value", "movie_transaction_success", "movies_cached_city_translated,", "movies_cached_city_saved_locale", "cityIsTopMovies", "movieLat", "movieLng", "movies_one_pager_selected_location", "key_user_recent_cities", "user_selected_city", "isUpdatedApp", "SEAT_SHARE_TUTORIAL_SHOWN_COUNT");
        }
        if (k.a((Object) str2, (Object) a.c.CASHBACK.name())) {
            return kotlin.a.k.d("cashback_merchant_toggle", "cashback_day_of_year", "points_active");
        }
        if (k.a((Object) str2, (Object) a.c.MALL.name())) {
            return kotlin.a.k.d(SDKConstants.KEY_UNIQUE_ID, "Locale.Helper.Selected.Language", "system_language_changed", "h5_kyc_display_name", "weex_mall_app_config", "startTime", "preferences_decode_1D_product", "preferences_decode_1D_industrial", "preferences_decode_QR", "preferences_decode_Data_Matrix", "preferences_decode_Aztec", "preferences_decode_PDF417", "SAVE_SELECTED_ADDRESS", "SAVE_SELECTED_ADDRESS_LIST_RESPONSE", "no_of_clicks", "key_added_rule");
        }
        if (k.a((Object) str2, (Object) a.c.RECHARGES.name())) {
            return kotlin.a.k.d("debug.setting.recharge.post.os.revamp", "clpClosedCount", "closedCount", "recharge.prefs.lang");
        }
        if (k.a((Object) str2, (Object) f.a.METRO_PREF.getPrefname())) {
            return kotlin.a.k.d("metroActiveTickets");
        }
        if (k.a((Object) str2, (Object) f.a.FEED.getPrefname())) {
            return kotlin.a.k.d("FEED_LANGUAGE_STATUS", "FEED_TOP_RANK", "FEED_BOTTOM_RANK", "FEED_REQUEST_ID", "FEED_TOGETU", "FEED_LANGUAGES", "FEED_LOGOUT", "FEED_NEXT_PAGE_NUM", "FEED_TOTAL_PAGE_COUNT", "FEED_PROFILE_UPDATE", "FEED_BASE_URL", "FEED_MERCHANT_URL", "FEED_SESSION_TIME", "FEED_REFRESH_COUNT", "FEED_FIRST_REQUEST", "FEED_ONE_OFF", "LANGUAGE_CARD_SHOWN");
        }
        if (k.a((Object) str2, (Object) a.c.WALLET.name())) {
            return kotlin.a.k.d("show_gallery_alert", "HOME_LAUNCH_MILLIS", "needToShowSliderHint", "needToShowFirstTimeShimmer", "firstTimeP2PTheme", "pref_key_your_requests_list_update_required", "pref_key_show_wallet_app_ad_banner", "last_health_sync", "contact_use_instrument_flag", "money_transfer_beneficiary_use_instrument_flag", "TRANSFER_BENEFICIARY", ContactsConstant.CONTACT_TYPE_VALUE, WalletSharedPrefs.CONTACT_SYNC_CONCENT_ASKED, "key_is_device_verified", WalletSharedPrefs.KEY_CONTACT_PERMISSION_ASKED_COUNT, "isSingleEnabled");
        }
        if (k.a((Object) str2, (Object) a.c.PAYMENTSBANK.name())) {
            return kotlin.a.k.d("min_kyc_pop_n", "full_kyc_pop_n", "aadhaar_number", "aadhaar_verified", "isMinKyc", "expiryType", "kycPrimeUserStatus", "isExpired", "isPanSubmitted", "isPanVerified", "isForm60", "keyKycExpiryDate", "kyc_expired_pop_n", "isMinor", "is_min_kyc_eligible", "aadhaarSubmittedAs", "cstPriorityCustomerTimestamp", "si_swipe_list", "bank_user_token", "bank_refresh_token", "bank_launch_count", "acc_nu", "pan_status_landing", "slfd_meta_response_s", "CURRENT_LATITUDE", "CURRENT_LONGITUDE", "caId", "bankDrawerOpened", "pb_show_cash_withdrawal");
        }
        if (k.a((Object) str2, (Object) a.c.GAMEPIND.name())) {
            return kotlin.a.k.d("gamepind_json_map_unconsumed_skus", "gamepind_json_map_dummy_responses", "gamepind_home_shortcut_updated");
        }
        if (k.a((Object) str2, (Object) a.c.ADDMONEY.name())) {
            return kotlin.a.k.d("pref_new_balance_wallet", "pref_new_balance_wallet_Gv", "show_confirmation_sheet", "show_scratch_promo");
        }
        if (k.a((Object) str2, (Object) a.c.UTILITY.name())) {
            return kotlin.a.k.d("unread message count", "isBankCustomer", "isEmailNotificationEnabled", "wishlist_dontshow", "first_login_permission", "PUSH_ATTRIBUTION_ID", "PUSH_START_TIME", "is_ipl_team_inserted", "irctc_user_id", "bus_intro_flag", "train_intro_flag ", "flight_intro_flag", "movie_time_slot_flag", "bank_customer_status", "mobile_number_entered", "paytmpostpaidformdataprefs", "key_language_dialog_shown", "lastExplicitlyLogoutTimestamp", "apBusinessWalletPopup");
        }
        if (k.a((Object) str2, (Object) f.a.PREF_NEARBY_CITY_STORE_FRONT.getPrefname())) {
            return kotlin.a.k.d("naerby_city_store_front");
        }
        if (k.a((Object) str2, (Object) f.a.KYC_SHARED_PREF.getPrefname())) {
            return kotlin.a.k.d("slotBookData");
        }
        if (k.a((Object) str2, (Object) f.a.FD_FIRST_TIME_TRACK.getPrefname())) {
            return kotlin.a.k.d("is_first_time");
        }
        if (k.a((Object) str2, (Object) f.a.CB_CACHE_PREF.getPrefname())) {
            return kotlin.a.k.d("CB_KEY_CB_LIST_RESPONSE", "CB_KEY_FIN_RESPONSE", "CB_ADDRESS_RESPONSE", "PRODUCT_ID");
        }
        if (k.a((Object) str2, (Object) f.a.PPB_ICA.getPrefname())) {
            return kotlin.a.k.d("bank_user_token", "bank_refresh_token", "bank_launch_count", "acc_nu", "pan_status_landing", "slfd_meta_response_s", "CURRENT_LATITUDE", "CURRENT_LONGITUDE", "caId", "bankDrawerOpened", "pb_show_cash_withdrawal");
        }
        if (k.a((Object) str2, (Object) f.a.TRAIN_MOST_PREF_KEY.getPrefname())) {
            return kotlin.a.k.d("searchedcitieswithdate", "searchedcitiesforsource", "searchedcitiesfordestination", "notificationread");
        }
        if (k.a((Object) str2, (Object) f.a.TRAIN_SEARCH_NOTIFICATION_SHARED.getPrefname())) {
            return kotlin.a.k.d("train_search_notification_key");
        }
        if (k.a((Object) str2, (Object) f.a.PREF_NAME.getPrefname())) {
            return kotlin.a.k.d("rta_install_date", "rta_launch_times", "rta_opt_out");
        }
        if (k.a((Object) str2, (Object) f.a.IN_APP_UPDATE.getPrefname())) {
            return kotlin.a.k.d("userConsentCountFlexibleUpdate", "userConsentCountImmediateUpdate");
        }
        if (k.a((Object) str2, (Object) f.a.PREFERENCE_FILE_KEY.getPrefname())) {
            return kotlin.a.k.d("enableEasyPay");
        }
        if (k.a((Object) str2, (Object) f.a.PREF_KEY_USER_NOT_VERIFIED.getPrefname())) {
            return kotlin.a.k.d("USER_SKIPPED_VERIFICATION");
        }
        if (k.a((Object) str2, (Object) a.c.UPI.name())) {
            return kotlin.a.k.d(UpiConstants.PREF_KEY_SETMPIN_VISIBLE_FLAG, UpiConstants.KEY_SHARED_PREF_VPA_INFO, UpiConstants.KEY_UPI_PROFILE_INFO, "ToolTipTime", "ToolTipTimeDisplayCount", "dont_show_cancel_confirmation", "is_animation_shown", UpiConstants.PREF_UPI_SECURITY_POPUP, UpiConstants.PREF_UPI_SCAN_PAY_POPUP);
        }
        if (k.a((Object) str2, (Object) a.c.MONEYTRANSFER.name())) {
            return kotlin.a.k.d("mt_pull_down_count", "show_all_in_one", "selected_account_number", "selected_account_ifsc", "p2p-last-used-bank-account-number", "mt_beneficiary_cache", "isRefreshRequired", "isMtPermissionAskedOnce", "set_pin_prev_time");
        }
        if (k.a((Object) str2, (Object) a.c.PASSBOOK.name())) {
            return kotlin.a.k.d("paytmpostpaidapprejectiontoast", "pass_wallet_grade_kyc_state", "pbCacheUserId", "isPreAuthMessageVisible", r.WALLET_ACTIVATED);
        }
        if (k.a((Object) str2, (Object) a.c.OAUTH.name())) {
            return kotlin.a.k.d(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "location_deny_count", "oauth_wallet_refresh_token", "oauth_paytm_access_token", "oauth_launch_set_lock_timestamp", "oauth_set_app_lock_timestamp", "device_binding_method", "oauth_sign_up_reminder");
        }
        if (k.a((Object) str2, (Object) f.a.PREF_APP_MANAGER.getPrefname())) {
            return kotlin.a.k.d(net.one97.paytm.appManager.storage.b.a.f49051a, "appmanager_version", net.one97.paytm.appManager.storage.b.a.f49052b);
        }
        if (k.a((Object) str2, (Object) f.a.SMS_SDK_PREF.getPrefname())) {
            return kotlin.a.k.d("sms_consent_set", "sms_wm_freq", "sms_sync_time", ContactsConstant.CONTACTS_CONSENT_KEY);
        }
        if (k.a((Object) str2, (Object) a.c.COMS.name())) {
            return kotlin.a.k.d(ContactsConstant.SEARCH_CONTACT_LAST_TIME_STAMP, ContactsConstant.LAST_LOCAL_CONTACT_SYNCED_TIME, ContactsConstant.HEALTH_API_LAST_TIME_STAMP);
        }
        return null;
    }
}
