package net.one97.paytm.oauth.utils;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.b.a.a;
import kotlin.g.b.k;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.utils.r;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f56798a = new q();

    private q() {
    }

    public static void a(long j) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_sign_up_reminder", j, false);
    }

    public static long a() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_sign_up_reminder", -1, false);
    }

    public static void a(int i2) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_sign_up_gtm_index", i2, true);
    }

    public static int b() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_sign_up_gtm_index", 0, true);
    }

    public static void b(long j) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_sim_changed_reminder", j, true);
    }

    public static long c() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_sim_changed_reminder", -1, true);
    }

    public static void b(int i2) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_sim_changed_daily_count", i2, true);
    }

    public static int d() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_sim_changed_daily_count", 1, true);
    }

    public static void c(int i2) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_sim_changed_index", i2, true);
    }

    public static int e() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_sim_changed_index", 0, true);
    }

    public static void a(String str) {
        k.c(str, "value");
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_sim_numbers", str, true);
    }

    public static String f() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_sim_numbers", "", true);
    }

    public static String g() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("acquisition_source", "", true);
    }

    public static String h() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("acquisition_medium", "", true);
    }

    public static String i() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("acquisition_campaign", "", true);
    }

    public static boolean j() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("isPasswordSet", false, true);
    }

    public static void a(boolean z) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_is_new_sign_up", z, true);
    }

    public static void b(String str) {
        k.c(str, "value");
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_cst_phone_number", str, true);
    }

    public static String k() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_cst_phone_number", "", true);
    }

    public static void c(String str) {
        k.c(str, "value");
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_password_strength", str, true);
    }

    public static String l() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_password_strength", "", true);
    }

    public static void c(long j) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_add_email_timestamp", j, true);
    }

    public static long m() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_add_email_timestamp", -1, true);
    }

    public static void n() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        a a2 = r.a.a(applicationContext);
        a2.a("oauth_sim_changed_reminder", -1, true);
        a2.a("oauth_sim_changed_daily_count", 1, true);
        a2.a("oauth_sim_changed_index", 0, true);
    }

    public static void o() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        a a2 = r.a.a(applicationContext);
        a2.a("oauth_sign_up_reminder", -1, false);
        a2.a("oauth_sign_up_gtm_index", 0, true);
        a2.a("oauth_cst_phone_number", "", true);
        a2.a("oauth_password_strength", "", true);
        a2.a("oauth_add_email_timestamp", -1, true);
        a2.a("password_violation", false, false);
        n();
        a2.a(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "simple_login", true);
        a2.a("location_deny_count", 0, false);
    }

    public static void p() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        a a2 = r.a.a(applicationContext);
        a2.a("oauth_paytm_refresh_token", "", true);
        a2.a("oauth_wallet_refresh_token", "", false);
        a2.a("oauth_paytm_token_expiry", 0, true);
        a2.a("oauth_paytm_access_token", "null", false);
    }

    public static void q() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("isPasswordSet", true, true);
    }

    public static void d(String str) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_paytm_refresh_token", str, true);
    }

    public static String r() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_paytm_refresh_token", "", true);
    }

    public static void e(String str) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_wallet_refresh_token", str, false);
    }

    public static String s() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_wallet_refresh_token", "", false);
    }

    public static void d(long j) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_paytm_token_expiry", j, true);
    }

    public static long t() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_paytm_token_expiry", 0, true);
    }

    public static void f(String str) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_paytm_access_token", str, false);
    }

    public static String u() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        String b3 = r.a.a(applicationContext).b("oauth_paytm_access_token", "", false);
        if (b3.equals("")) {
            return null;
        }
        return b3;
    }

    public static void g(String str) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a(AppConstants.KEY_EMAIL, str, true);
    }

    public static void v() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_app_lock_pop_up_shown", true, true);
    }

    public static boolean w() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_app_lock_pop_up_shown", false, true);
    }

    public static void b(boolean z) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("enabled", z, true);
    }

    public static boolean x() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("enabled", false, true);
    }

    public static void e(long j) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_set_app_lock_timestamp", j, false);
    }

    public static long y() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_set_app_lock_timestamp", 0, false);
    }

    public static void f(long j) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("oauth_launch_set_lock_timestamp", j, false);
    }

    public static long z() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("oauth_launch_set_lock_timestamp", 0, false);
    }

    public static void h(String str) {
        k.c(str, "value");
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, str, true);
    }

    public static String A() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b(WalletSharedPrefs.KEY_OAUTH_LOGIN_METHOD, "simple_login", true);
    }

    public static void i(String str) {
        k.c(str, "value");
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("device_binding_method", str, true);
    }

    public static void j(String str) {
        k.c(str, "value");
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("pref_key_latitude", str, true);
    }

    public static void k(String str) {
        k.c(str, "value");
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("pref_key_longitude", str, true);
    }

    public static void d(int i2) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("location_deny_count", i2, false);
    }

    public static int B() {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        return r.a.a(applicationContext).b("location_deny_count", 0, false);
    }

    public static void c(boolean z) {
        r.a aVar = r.f56799a;
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        Context applicationContext = b2.getApplicationContext();
        k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        r.a.a(applicationContext).a("password_violation", z, false);
    }
}
