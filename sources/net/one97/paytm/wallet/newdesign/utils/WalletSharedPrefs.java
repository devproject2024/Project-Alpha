package net.one97.paytm.wallet.newdesign.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.nebula.filecache.FileCache;
import com.google.gson.f;
import com.paytm.b.a.a;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.entity.wallet.CJRNobleInitiative;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.communicator.b;

public enum WalletSharedPrefs {
    INSTANCE;
    
    public static final String BANK_PRODUCT_SERVICE_CACHE = "prodBankServiceCache";
    public static final String BANK_SECURE_SERVICE_CACHE = "secureBankServiceCache";
    public static final String CGCP_HEADER = "cgcpHeader";
    public static final String CLIENT_ID = "clientId";
    public static final String CONTACT_SYNC_CONCENT_ASKED = "contactSycnConcentAsked";
    public static final String CONTACT_SYNC_FISRT_TIME_LOCAL = "contact_sync_first_time_local";
    public static final String CONTACT_SYNC_FISRT_TIME_SERVER = "contact_sync_first_time_server";
    public static final String EVENT_LOG_SYNC = "eventLogSync";
    public static final String IS_APP_FROM_BACKGROUND = "isappfrombg";
    public static final String IS_GENERATE_OTP_REQUESTED = "generateOtp";
    public static final String IS_LOCK_PATTERN_SESSION_SET = "lockpatternsession";
    public static final String IS_OK_GOT_IT_SHOWN = "okgotit";
    public static final String IS_OOPS_DIALOG_SHOWN_VIA_ERROR = "oopsdialogerror";
    public static final String IS_OOPS_DIALOG_SHOWN_VIA_MODEL = "oopsdialog";
    public static final String IS_SECURITY_DIALOG_NOT_ALLOWED = "securitydialog";
    public static final String IS_SECURITY_LOCK_ENABLED = "enabled";
    public static final String IS_SEC_LOCK_SHOWING = "isseclockShowing";
    public static final String IS_SEC_PROMPT_SESSION_SHOWN = "secpromptsession";
    public static final String KEY_CONTACT_PERMISSION_ASKED_COUNT = "contactPermissionAskedCount";
    public static final String KEY_OAUTH_LOGIN_METHOD = "oauth_login_method";
    public static final String NOBLE_PREFS = "wallet_prefs";
    public static final String OPEN_ACCOUNT_CLOSE_COUNT = "openAccountCloseCount";
    public static final String OTP_COUNTER_CACHE = "otpCounterCache";
    public static final String OTP_NOBLE_CACHE = "noble_sync";
    public static final String SERVER_TIME = "serverTime";
    public static final String TIME_INTERVAL = "timeInterval";
    public static final String UPI_SENDER_ONBOARDED = "is_upi_user";
    public static final String USER_DETAILV2_CACHE = "bankServiceCache";
    public static final String USER_DEVICE = "userDevice";
    public static final String VERSION = "version";

    public final void stopOpenAccountPopupFromComing() {
    }

    public final void saveNobleResponse(CJRNobleInitiative cJRNobleInitiative, Context context) {
        be.a(context.getApplicationContext()).a("wallet_prefs", new f().b(cJRNobleInitiative).toString(), true);
    }

    public final CJRNobleInitiative getNobleResponse(Context context) {
        String b2 = be.a(context.getApplicationContext()).b("wallet_prefs", (String) null, true);
        if (b2 == null) {
            return null;
        }
        return (CJRNobleInitiative) new f().a(b2, CJRNobleInitiative.class);
    }

    public final void storeNobelTime(long j, Context context) {
        be.a(context.getApplicationContext()).a("noble_sync", j, true);
    }

    public final boolean isNobleCacheValid(Context context, Long l) {
        if (System.currentTimeMillis() > be.a(context.getApplicationContext()).b("noble_sync", 0, true) + l.longValue()) {
            return true;
        }
        return false;
    }

    public final void storeOfflineCounterCachedTime(Context context, long j) {
        be.a(context.getApplicationContext()).a("otpCounterCache", j, true);
    }

    public final boolean isOTPCounterCacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > be.a(context.getApplicationContext()).b("otpCounterCache", 0, true) + FileCache.EXPIRE_TIME) {
            return true;
        }
        return false;
    }

    public final void storeEventLogSyncTime(Context context, long j) {
        be.a(context.getApplicationContext()).a("eventLogSync", j, true);
    }

    public final boolean isReadyToSync(Context context) {
        if (System.currentTimeMillis() > be.a(context.getApplicationContext()).b("eventLogSync", 0, true) + 86400000) {
            return true;
        }
        return false;
    }

    public final void storeOfflineTimeCounter(Context context, long j) {
        be.a(context.getApplicationContext()).a("timeInterval", j, true);
    }

    public final void storeUserDeviceMap(Context context, String str) {
        be.a(context.getApplicationContext()).a("userDevice", str, true);
    }

    public final void storeCGCPHeader(Context context, String str) {
        be.a(context.getApplicationContext()).a("cgcpHeader", str, false);
    }

    public final void storeServerTime(Context context, long j) {
        be.a(context.getApplicationContext()).a("serverTime", j, true);
    }

    public final String getUserDeviceMap(Context context) {
        String b2 = be.a(context.getApplicationContext()).b("userDevice", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final long getServerTime(Context context) {
        return be.a(context.getApplicationContext()).b("serverTime", 0, true);
    }

    public final String getCGCPHeader(Context context) {
        String b2 = be.a(context.getApplicationContext()).b("cgcpHeader", "", false);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final void setContactSyncFirstTimeWithServer(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("contact_sync_first_time_server", z, true);
    }

    public final boolean isContactSyncFirstTimeWithServer(Context context) {
        return be.a(context.getApplicationContext()).b("contact_sync_first_time_server", true, true);
    }

    public final long getOfflineTimeCounter(Context context) {
        return be.a(context.getApplicationContext()).b("timeInterval", 60, true);
    }

    public final void showSecFeatureModelPref(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("securitydialog", z, true);
    }

    public final boolean getSecFeatureModelPref(Context context) {
        return be.a(context.getApplicationContext()).b("securitydialog", false, true);
    }

    public final void setGenerateOTPRequest(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("generateOtp", z, true);
    }

    public final boolean isGenerateOTPRequested(Context context) {
        return be.a(context.getApplicationContext()).b("generateOtp", false, true);
    }

    public final void setPatternLock(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("enabled", z, true);
    }

    public final boolean isPatternLockEnabled(Context context) {
        return be.a(context.getApplicationContext()).b("enabled", false, true);
    }

    public final void setSecFeatureSuccessShown(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("okgotit", z, true);
    }

    public final boolean isSecFeatureSuccesShown(Context context) {
        return be.a(context.getApplicationContext()).b("okgotit", false, true);
    }

    public final void setIsOopsDialogShownViaModel(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("oopsdialog", z, true);
    }

    public final boolean isOopsDialogShownViaModel(Context context) {
        return be.a(context.getApplicationContext()).b("oopsdialog", false, true);
    }

    public final void setIsOopsDialogShownViaSecError(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("oopsdialogerror", z, true);
    }

    public final boolean isOopsDialogShownViaSecError(Context context) {
        return be.a(context.getApplicationContext()).b("oopsdialogerror", false, true);
    }

    public final boolean isLockPatternSessionSet(Context context) {
        return be.a(context.getApplicationContext()).b("lockpatternsession", false, true);
    }

    public final void setLockPatternSession(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("lockpatternsession", z, true);
    }

    public final boolean isSecPromptShownInSession(Context context) {
        return be.a(context.getApplicationContext()).b("secpromptsession", false, true);
    }

    public final void setSecPromptShownInSession(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("secpromptsession", z, true);
    }

    public final boolean isAppFromBackGround(Context context) {
        return be.a(context.getApplicationContext()).b("isappfrombg", false, true);
    }

    public final void setIsAppFromBackground(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("isappfrombg", z, true);
    }

    public final boolean issecLockShowing(Context context) {
        return be.a(context.getApplicationContext()).b("isseclockShowing", false, true);
    }

    public final void setIsSecLockShowing(Context context, boolean z) {
        be.a(context.getApplicationContext()).a("isseclockShowing", z, true);
    }

    public final boolean isBankProductServiceCacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > be.a(context.getApplicationContext()).b("prodBankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final boolean isBankSecureServiceCacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > be.a(context.getApplicationContext()).b("secureBankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final void resetProductBankServiceCachedTime(Context context) {
        be.a(context.getApplicationContext()).a("prodBankServiceCache", System.currentTimeMillis(), true);
    }

    public final void resetSecureBankServiceCachedTime(Context context) {
        be.a(context.getApplicationContext()).a("secureBankServiceCache", System.currentTimeMillis(), true);
    }

    public final boolean isUserDetailV2CacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > be.a(context.getApplicationContext()).b("bankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final void resetUserDetailV2CachedTime(Context context) {
        be.a(context.getApplicationContext()).a("bankServiceCache", System.currentTimeMillis(), true);
    }

    public final long getHealthSyncTime(Context context) {
        a a2 = be.a(context.getApplicationContext());
        e eVar = e.f50261a;
        return a2.b(e.o(), 0, false);
    }

    public final void setHealthSyncTime(Context context, Long l) {
        a a2 = be.a(context.getApplicationContext());
        e eVar = e.f50261a;
        a2.a(e.o(), l.longValue(), false);
    }

    public final boolean isUseInstrumentFlagOn(Context context, int i2) {
        a a2 = be.a(context.getApplicationContext());
        if (i2 == e.b.PHONEBOOK.getType()) {
            return a2.b("contact_use_instrument_flag", false, false);
        }
        if (i2 == e.b.TRANSFER_BENEFICIARY.getType()) {
            return a2.b("money_transfer_beneficiary_use_instrument_flag", false, false);
        }
        return false;
    }

    public final void setUseInstrumentFlagOn(Context context, int i2, boolean z) {
        String str;
        if (i2 == e.b.PHONEBOOK.getType()) {
            str = e.b.PHONEBOOK.name();
        } else {
            str = i2 == e.b.TRANSFER_BENEFICIARY.getType() ? e.b.TRANSFER_BENEFICIARY.name() : "";
        }
        if (!TextUtils.isEmpty(str)) {
            be.a(context.getApplicationContext()).a(str, z, false);
        }
    }

    public static boolean isToContactSyncConcentAsked() {
        return be.a(b.a().getContext().getApplicationContext()).b(CONTACT_SYNC_CONCENT_ASKED, false, false);
    }

    public static void setContactSyncConcentAsked() {
        be.a(b.a().getContext().getApplicationContext()).a(CONTACT_SYNC_CONCENT_ASKED, true, false);
    }

    public static boolean isUPIOnboarded() {
        return be.a(b.a().getContext().getApplicationContext()).b("is_upi_user", false, true);
    }

    public static boolean getBoolean(String str, boolean z) {
        return be.a(b.a().getContext().getApplicationContext()).b(str, z, false);
    }

    public static int getContactPermissionAskedCount() {
        return be.a(b.a().getContext().getApplicationContext()).b(KEY_CONTACT_PERMISSION_ASKED_COUNT, -1, false);
    }

    public static void setContactPermissionAskedCount(int i2) {
        be.a(b.a().getContext().getApplicationContext()).a(KEY_CONTACT_PERMISSION_ASKED_COUNT, i2, false);
    }

    public static void setBoolean(String str, boolean z) {
        be.a(b.a().getContext().getApplicationContext()).a(str, z, false);
    }

    public final String getOauthLoginMethod() {
        String b2 = be.a(b.a().getContext().getApplicationContext()).b(KEY_OAUTH_LOGIN_METHOD, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }
}
