package net.one97.paytm.passbook.utility;

import android.content.Context;
import com.alipay.mobile.nebula.filecache.FileCache;
import com.google.gson.f;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.passbook.beans.CJRNobleInitiative;
import net.one97.paytm.passbook.d;

public enum r {
    INSTANCE;
    
    public static final String BANK_PRODUCT_SERVICE_CACHE = "prodBankServiceCache";
    public static final String BANK_SECURE_SERVICE_CACHE = "secureBankServiceCache";
    public static final String CGCP_HEADER = "cgcpHeader";
    public static final String CLIENT_ID = "clientId";
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
    public static final String NOBLE_PREFS = "wallet_prefs";
    public static final String OPEN_ACCOUNT_CLOSE_COUNT = "openAccountCloseCount";
    public static final String OTP_COUNTER_CACHE = "otpCounterCache";
    public static final String OTP_NOBLE_CACHE = "noble_sync";
    public static final String SERVER_TIME = "serverTime";
    public static final String TIME_INTERVAL = "timeInterval";
    public static final String USER_DETAILV2_CACHE = "bankServiceCache";
    public static final String USER_DEVICE = "userDevice";
    public static final String VERSION = "version";
    public static final String WALLET_ACTIVATED = "walletActivation";

    public final void stopOpenAccountPopupFromComing() {
    }

    private Context getAppContext() {
        return d.b().b();
    }

    public final void saveNobleResponse(CJRNobleInitiative cJRNobleInitiative) {
        m.a(getAppContext()).a("wallet_prefs", new f().b(cJRNobleInitiative), true);
    }

    public final CJRNobleInitiative getNobleResponse(Context context) {
        String b2 = m.a(getAppContext()).b("wallet_prefs", "", true);
        if (b2.equals("")) {
            return null;
        }
        return (CJRNobleInitiative) new f().a(b2, CJRNobleInitiative.class);
    }

    public final void storeNobelTime(long j) {
        m.a(getAppContext()).a("noble_sync", j, true);
    }

    public final boolean isNobleCacheValid(Context context, Long l) {
        if (System.currentTimeMillis() > m.a(getAppContext()).b("noble_sync", 0, true) + l.longValue()) {
            return true;
        }
        return false;
    }

    public final void storeOfflineCounterCachedTime(long j) {
        m.a(getAppContext()).a("otpCounterCache", j, true);
    }

    public final boolean isOTPCounterCacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > m.a(getAppContext()).b("otpCounterCache", 0, true) + FileCache.EXPIRE_TIME) {
            return true;
        }
        return false;
    }

    public final void storeEventLogSyncTime(long j) {
        m.a(getAppContext()).a("eventLogSync", j, true);
    }

    public final boolean isReadyToSync(Context context) {
        if (System.currentTimeMillis() > m.a(getAppContext()).b("eventLogSync", 0, true) + 86400000) {
            return true;
        }
        return false;
    }

    public final void storeOfflineTimeCounter(long j) {
        m.a(getAppContext()).a("timeInterval", j, true);
    }

    public final void storeUserDeviceMap(String str) {
        m.a(getAppContext()).a("userDevice", str, true);
    }

    public final void storeCGCPHeader(String str) {
        m.a(getAppContext()).a("cgcpHeader", str, true);
    }

    public final void storeServerTime(long j) {
        m.a(getAppContext()).a("serverTime", j, true);
    }

    public final String getUserDeviceMap(Context context) {
        String b2 = m.a(getAppContext()).b("userDevice", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final long getServerTime(Context context) {
        return m.a(getAppContext()).b("serverTime", 0, true);
    }

    public final String getCGCPHeader(Context context) {
        String b2 = m.a(getAppContext()).b("cgcpHeader", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final void setContactSyncFirstTimeWithServer(boolean z) {
        m.a(getAppContext()).a("contact_sync_first_time_server", z, true);
    }

    public final boolean isContactSyncFirstTimeWithServer(Context context) {
        return m.a(getAppContext()).b("contact_sync_first_time_server", true, true);
    }

    public final long getOfflineTimeCounter(Context context) {
        return m.a(getAppContext()).b("timeInterval", 60, true);
    }

    public final void showSecFeatureModelPref(boolean z) {
        m.a(getAppContext()).a("securitydialog", z, true);
    }

    public final boolean getSecFeatureModelPref(Context context) {
        return m.a(getAppContext()).b("securitydialog", false, true);
    }

    public final void setGenerateOTPRequest(boolean z) {
        m.a(getAppContext()).a("generateOtp", z, true);
    }

    public final boolean isGenerateOTPRequested(Context context) {
        return m.a(getAppContext()).b("generateOtp", false, true);
    }

    public final void setPatternLock(boolean z) {
        m.a(getAppContext()).a("enabled", z, true);
    }

    public final boolean isPatternLockEnabled(Context context) {
        return m.a(getAppContext()).b("enabled", false, true);
    }

    public final void setSecFeatureSuccessShown(boolean z) {
        m.a(getAppContext()).a("okgotit", z, true);
    }

    public final boolean isSecFeatureSuccesShown(Context context) {
        return m.a(getAppContext()).b("okgotit", false, true);
    }

    public final void setIsOopsDialogShownViaModel(boolean z) {
        m.a(getAppContext()).a("oopsdialog", z, true);
    }

    public final boolean isOopsDialogShownViaModel(Context context) {
        return m.a(getAppContext()).b("oopsdialog", false, true);
    }

    public final void setIsOopsDialogShownViaSecError(boolean z) {
        m.a(getAppContext()).a("oopsdialogerror", z, true);
    }

    public final boolean isOopsDialogShownViaSecError(Context context) {
        return m.a(getAppContext()).b("oopsdialogerror", false, true);
    }

    public final boolean isLockPatternSessionSet(Context context) {
        return m.a(getAppContext()).b("lockpatternsession", false, true);
    }

    public final void setLockPatternSession(boolean z) {
        m.a(getAppContext()).a("lockpatternsession", z, true);
    }

    public final boolean isSecPromptShownInSession(Context context) {
        return m.a(getAppContext()).b("secpromptsession", false, true);
    }

    public final void setSecPromptShownInSession(boolean z) {
        m.a(getAppContext()).a("secpromptsession", z, true);
    }

    public final boolean isAppFromBackGround(Context context) {
        return m.a(getAppContext()).b("isappfrombg", false, true);
    }

    public final void setIsAppFromBackground(boolean z) {
        m.a(getAppContext()).a("isappfrombg", z, true);
    }

    public final boolean issecLockShowing(Context context) {
        return m.a(getAppContext()).b("isseclockShowing", false, true);
    }

    public final void setIsSecLockShowing(boolean z) {
        m.a(getAppContext()).a("isseclockShowing", z, true);
    }

    public final boolean isBankProductServiceCacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > m.a(getAppContext()).b("prodBankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final boolean isBankSecureServiceCacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > m.a(getAppContext()).b("secureBankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final void resetProductBankServiceCachedTime() {
        m.a(getAppContext()).a("prodBankServiceCache", System.currentTimeMillis(), true);
    }

    public final void resetSecureBankServiceCachedTime() {
        m.a(getAppContext()).a("secureBankServiceCache", System.currentTimeMillis(), true);
    }

    public final boolean isUserDetailV2CacheNeedRefresh(Context context) {
        if (System.currentTimeMillis() > m.a(getAppContext()).b("bankServiceCache", 0, true) + TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final void resetUserDetailV2CachedTime() {
        m.a(getAppContext()).a("bankServiceCache", System.currentTimeMillis(), true);
    }

    public final void setIsWalletActivated(String str) {
        m.a(getAppContext()).a(WALLET_ACTIVATED, str, false);
    }

    public final String getIsWalletActivated(Context context) {
        return m.a(getAppContext()).b(WALLET_ACTIVATED, "true", false);
    }
}
