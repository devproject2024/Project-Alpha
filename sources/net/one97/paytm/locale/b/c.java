package net.one97.paytm.locale.b;

import android.os.AsyncTask;
import androidx.arch.core.a.a;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import net.one97.paytm.locale.storage.LocaleDBQuery;

final class c {

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, String> f53098a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    String f53099b = null;

    /* renamed from: c  reason: collision with root package name */
    boolean f53100c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f53101d = true;

    public c() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                String a2 = j.a();
                c cVar = c.this;
                String[] split = "common_google_play_services_unknown_issue ,text_new, drawer_open, abc_searchview_description_search, search, change_language, auth_login_skip, lbl_otp_sent, lbl_password_reset_successful, lbl_please_login_using_new_password, ok, english_in_locale, hindi_in_locale, lbl_login_or_create_a_new_account, lbl_enter_mobile_number, lbl_forgot_password_login_issues, login_securely, terms_and_conditions_login_new, tnc_txt_login_new, privacy_txt_login_new, mobile_number, create_new_account, starts_in, view_all, ln_orders_bookings, ln_my_orders_detail, ln_settings, settings_msg_detail, ln_help_support, help_support_msg_detail, ln_choose_language_logout, ln_choose_language_detail, help_support_msg_detail_reseller, logintopaytm, text_ppbl_info, check_balance, logout_welcome_text, left_navi_login, invite_friend_text, referral_screen_title, open_query, raise_query, message_error_data_display, parse_error_title, parse_error_body, error_data_display, empty_mob_no_error, permissions_header_text, location_header, permission_error, location_description, phone_state_header, phone_state_description, sms_header, sms_description, oauth_deny, lbl_welcome_back, lbl_enter_paytm_password, lbl_forgot_password, lbl_submit, paytm_password, hi_login, msg_invalid_password, lbl_reset_password, lbl_enter_your_mobile_number_registered, lbl_otp_limit_reached, lbl_unable_to_receive_otp, lbl_reset_password_on_call, popup_window_default_title, msg_invalid_mobile, lbl_enter_otp, lbl_verify_your_mobile_number, lbl_one_time_password_otp, invalid_otp, lbl_request_otp, txt_request_another_otp, btn_confirm, lbl_resend_otp_in_seconds, empty_otp, lbl_set_new_password, lbl_for_account_linked_to, lbl_password_strength, lbl_atleast_five_character, lbl_special_character, lbl_alphabet, lbl_numberic, save, lbl_new_password_is_set, lbl_enter_new_paytm_password, lbl_re_enter_new_paytm_password, fill_all_fields, alert, lbl_strength_weak, password_do_not_match, txt_verifying_details, lbl_verify_mobile_number, having_login_isis, lbl_request_another_otp, txt_you_can_request_another_otp, oauth_invalid_otp_entered, txt_verifying_otp, text_ppbl_info_api_fail, hiuser, show_less, rupee_string, chat_notifications, chat_check_again_soon, chat_imp_updates, lbl_setting_up_your_experience, feed_title, no_saved_items, feed_login_paytm_text, feed_login_paytm, feed_hello, feed_share_location, feed_default_temp_text, message, login, more, keep_playing, all_game, playing_bar, players, chat_module_messages, chat_list_loading, chat_list_loading_content, enter_mobile_number_or_upi_id, pay_using, scanner_paytm_balance_hint, enable_camera_access, to_make_a_faster_payment_please_enable_your_camera_permission_to_start_scanning_any_qr_code, enable_camera, now_scan_any_qr_to_pay_using_paytm, ok_got_it_p2p, tb_flash_off, tb_flash_on, scanner_paytm_balance, chat_chat_text, chat_new_chat_text, chat_module_friend_search_hint, chat_module_cancel, chat_module_chat_no_results, chat_module_say_hi_point, chat_module_say_hi_or_start_a_chat_with_your_friends_or_family, chat_module_start_a_chat, feed_hide_static_header_text, feed_hide_static_text, done, hello_sign_in, enter_valid_mobile, oauth_error, some_went_wrong, common_google_play_services_unknown_issue,message_error_data_display, parse_error_title, parse_error_body, error_data_display, starts_in, view_all".replaceAll(" ", "").split(AppConstants.COMMA);
                if (!a.a().f1844a.d()) {
                    synchronized (cVar) {
                        LocaleDBQuery.getDB().updateDataList(cVar.f53098a, a2, split);
                        cVar.f53099b = a2;
                        cVar.f53100c = true;
                        cVar.notifyAll();
                    }
                    return;
                }
                throw new RuntimeException("Cannot Invoke " + "getStartStringKeyValuesInternal" + " on a main thread");
            }
        });
    }

    public final String a(String str, String str2) {
        synchronized (this) {
            if (!this.f53100c) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    q.b(e2.getMessage());
                }
            }
        }
        synchronized (this) {
            if (!(this.f53099b == null || str2 == null)) {
                if (!this.f53099b.equals(str)) {
                    this.f53098a.clear();
                } else if (this.f53098a.containsKey(str2)) {
                    String str3 = this.f53098a.get(str2);
                    return str3;
                }
            }
            if (this.f53101d) {
                com.google.firebase.crashlytics.c.a().a((Throwable) new Exception("MISSING_RESTRING_KEY: " + str2 + " | Debug: false"));
            }
            LocaleDBQuery.getDB().updateDataList(this.f53098a, str, str2);
            this.f53099b = str;
            String str4 = this.f53098a.get(str2);
            return str4;
        }
    }
}
