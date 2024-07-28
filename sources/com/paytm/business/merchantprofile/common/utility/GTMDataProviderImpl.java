package com.paytm.business.merchantprofile.common.utility;

import com.business.common_module.b.f;
import com.paytm.business.merchantprofile.ProfileConfig;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import org.json.JSONArray;
import org.json.JSONObject;

public final class GTMDataProviderImpl implements f {
    public static final Companion Companion = new Companion((g) null);
    public static final GTMDataProviderImpl mInstance = new GTMDataProviderImpl();

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final GTMDataProviderImpl getMInstance() {
            return GTMDataProviderImpl.mInstance;
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        k.d(str, "key");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getBoolean(str, z);
    }

    public final int getInt(String str, int i2) {
        k.d(str, "key");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getInt(str, i2);
    }

    public final long getLong(String str, long j) {
        k.d(str, "key");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getLong(str, j);
    }

    public final String getString(String str, String str2) {
        k.d(str, "key");
        k.d(str2, "defaultValue");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getString(str, str2);
    }

    public final boolean getConsumerBoolean(String str, boolean z) {
        k.d(str, "key");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerBoolean(str, z);
    }

    public final int getConsumerInt(String str, int i2) {
        k.d(str, "key");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerInt(str, i2);
    }

    public final long getConsumerLong(String str, long j) {
        k.d(str, "key");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerLong(str, j);
    }

    public final String getConsumerString(String str, String str2) {
        k.d(str, "key");
        k.d(str2, "defaultValue");
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        return instance.getGTMDataProvider().getConsumerString(str, str2);
    }

    public final HashMap<String, String> getSSLPinningConfigAsHashMap() {
        try {
            if (AppConstants.domainPinsMap != null && AppConstants.domainPinsMap.size() > 0) {
                return AppConstants.domainPinsMap;
            }
            JSONArray jSONArray = new JSONArray(getString("sslPinningConfig", ""));
            HashMap<String, String> hashMap = new HashMap<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getBoolean("isEnabled")) {
                    String string = jSONObject.getString("domain");
                    k.b(string, "jsonObj.getString(ProfileGTMConstants.SSL_DOMAIN)");
                    String string2 = jSONObject.getString("value");
                    k.b(string2, "jsonObj.getString(Profil…MConstants.SSL_KEY_VALUE)");
                    hashMap.put(string, string2);
                }
            }
            AppConstants.domainPinsMap = hashMap;
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getUMPBaseUrl() {
        return mInstance.getString("ump_base_url", "");
    }

    public final String getMerchantProfileGstinUrl() {
        return mInstance.getString("merchantprofile_gstin", "");
    }

    public final String getBasicDetailAPI() {
        return mInstance.getString("basic_detail_api", "");
    }

    public final String getMerchantProfileDisplayUrl() {
        return mInstance.getString("merchantprofile_display", "");
    }

    public final String getMerchantProfileTicketStatusUrl() {
        return mInstance.getString("merchantprofile_ticketStatus", "");
    }

    public final String getMerchantProfileSecondaryUrlV2() {
        return getUMPBaseUrl() + mInstance.getString("merchantprofile_secondary_v2", "");
    }

    public final String getEdcRentalApi() {
        return mInstance.getString("edc_rental_api", "");
    }

    public final String getMerchantAddress() {
        return mInstance.getString("profile_address_api", "");
    }

    public final String getUADPincodeApi() {
        return mInstance.getString("uadPincode", "");
    }

    public final String getEdcRefundPolicyTermsAndConditionsUrl() {
        return mInstance.getString("edc_refund_tnc_url", "");
    }

    public final String getGenerateOtpUrl() {
        return getString("key_generate_otp_url", "");
    }

    public final String geteedHelpNavEngineAccountsUrl() {
        return getNeedHelpNavEngineBaseUrl() + getString("need_help_accounts_url", "");
    }

    public final String getMerchantProfileLoginUrl() {
        return getString("merchantprofile_login", "");
    }

    public final String getProfileKYCUrl() {
        return getString("merchant_kyc_url", "");
    }

    public final String getNeedHelpNavEngineBaseUrl() {
        return getUMPBaseUrl() + getString("ump_redirect_url", "");
    }

    public final String getSignOutApi() {
        return getString("sign_out_api", "");
    }

    public final String getMerchantProfileUpdateTicketUrl() {
        return getString("merchantprofile_update_ticket", "");
    }

    public final String getGenerateOtpUrlV2() {
        return getUMPBaseUrl() + getString("key_generate_otp_url_v2", "");
    }
}
