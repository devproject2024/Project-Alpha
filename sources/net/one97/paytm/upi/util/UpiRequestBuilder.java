package net.one97.paytm.upi.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.c;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class UpiRequestBuilder {
    private static final String ACC_REF_ID_CAMEL_CASE = "accRefId";
    public static final int ADD_BANK_ACCOUNT = 18;
    public static final int ADD_VIRTUAL_ADDRESS = 19;
    public static final int CHANGE_MPIN = 20;
    public static final int CHECK_ACCOUNT_BALANCE = 21;
    public static final int CHECK_VPA_AVAILABILITY = 13;
    public static final int CHECK_VPA_AVAILABILITY_ADD_VPA = 32;
    public static final int COMMON_PAY_REQUEST = 24;
    private static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_URL_ENCODED = "application/x-www-form-urlencoded";
    public static final int DELETE_BANK_ACCOUNT = 26;
    public static final int DELETE_VPA = 28;
    public static final int DEREGISTER_PROFILE = 27;
    public static final int DEVICE_BIND_REQUEST = 33;
    public static final int GENERATE_OTP = 15;
    public static final int GET_ACCOUNT_PROVIDER = 12;
    public static final int GET_MINI_STMT = 24;
    public static final int GET_MINI_STMT_V2 = 31;
    public static final int GET_PENDING_REQUEST = 25;
    public static final int GET_PROFILE_DETAILS = 23;
    private static final String KEY_ACCOUNT_NO = "account-no";
    private static final String KEY_ACCOUNT_NO_CAMEL_CASE = "accountNo";
    private static final String KEY_ACCOUNT_NUMBER = "account-number";
    private static final String KEY_ACCOUNT_PROVIDER = "account-provider";
    private static final String KEY_ACCOUNT_TYPE = "account-type";
    private static final String KEY_ACC_NUMBER = "accountNumber";
    private static final String KEY_ACTION = "action";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_APPROVED_AMOUNT = "approved-amount";
    private static final String KEY_APP_ID = "app-id";
    private static final String KEY_ATMPIN = "atmpin";
    private static final String KEY_ATM_PIN_CAMEL_CASE = "atmPin";
    private static final String KEY_AUTO_CREATE_VA = "auto-create-va";
    private static final String KEY_CARD_DIGITS = "card-digits";
    private static final String KEY_CARD_DIGITS_CAMEL_CASE = "cardDigits";
    private static final String KEY_CARRIER = "carrier";
    private static final String KEY_CHALLENGE = "challenge";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CHANNEL_CODE = "channel-code";
    private static final String KEY_CHANNEL_TOKEN = "channel-token";
    private static final String KEY_CIRCLE = "circle";
    private static final String KEY_CONTENT_TYPE = "Content-Type";
    private static final String KEY_CRED_BLOCK = "cred-block";
    private static final String KEY_CUSTOMER_CODE = "customer-code";
    private static final String KEY_CUSTOMER_EMAIL_ID = "customer-email-id";
    private static final String KEY_CUSTOMER_NAME = "customer-name";
    private static final String KEY_CUSTOMER_TYPE = "customer-type";
    private static final String KEY_CUSTOMER_VPA = "customer-vpa";
    private static final String KEY_DATA = "data";
    private static final String KEY_DEFAULT_CREDIT = "default-credit";
    private static final String KEY_DEFAULT_DEBIT = "default-debit";
    private static final String KEY_DEVICE_ID = "device-id";
    public static final String KEY_DEVICE_ID_CAMEL_CASE = "deviceId";
    private static final String KEY_ENCRYPTED_DATA = "encrypted-data";
    private static final String KEY_ENCRYPTED_DATA_CAMEL_CASE = "encryptedData";
    private static final String KEY_EXPIRE_AFTER = "expire-after";
    private static final String KEY_EXPIRE_DATE_CAMEL_CASE = "expiryDate";
    private static final String KEY_EXPIRY_DATE = "expiry-date";
    private static final String KEY_EXTENDED_INFO = "extended_info";
    private static final String KEY_FETCH_ACCOUNTS = "fetchAccounts";
    private static final String KEY_GET_SUGGESTED_VA = "get-suggested-va";
    public static final String KEY_IFSC = "ifsc";
    private static final String KEY_IFSC_CODE = "ifsc-code";
    private static final String KEY_MMID = "mmid";
    public static final String KEY_MOBILE_NUM = "mobile";
    private static final String KEY_MPIN = "mpin";
    private static final String KEY_NAME = "name";
    private static final String KEY_NEW_MPIN = "new-mpin";
    private static final String KEY_NEW_MPIN_CAMEL_CASE = "newMpin";
    private static final String KEY_NOTE = "note";
    private static final String KEY_OLD_MPIN = "old-mpin";
    private static final String KEY_OLD_MPIN_CAMEL_CASE = "oldMpin";
    private static final String KEY_OPERATION = "operation";
    private static final String KEY_OPERATION_TYPE = "operation-type";
    private static final String KEY_ORG_ID = "orgId";
    private static final String KEY_OTP = "otp";
    private static final String KEY_PAGE_NUMBER = "page-no";
    private static final String KEY_PAYEE_MOBILE_NO = "payeeMobileNo";
    private static final String KEY_PAYEE_NAME = "payee-name";
    private static final String KEY_PAYEE_VA = "payee-va";
    private static final String KEY_PAYEE_VPA = "payeeVa";
    private static final String KEY_PAYER_NAME = "payer-name";
    public static final String KEY_PAYER_VA = "payer-va";
    public static final String KEY_PAYER_VPA = "payerVpa";
    private static final String KEY_PRE_APPROVED = "pre-approved";
    private static final String KEY_PROFILE_ID = "profile-id";
    private static final String KEY_REASON = "reason";
    private static final String KEY_REF_ID = "ref-id";
    private static final String KEY_REQUESTED_AMOUNT = "requested-amount";
    private static final String KEY_REQUEST_ID = "requestId";
    private static final String KEY_SEQ_NO = "seq-no";
    public static final String KEY_SEQ_NO_CAMEL_CASE = "seqNo";
    private static final String KEY_SIGNATURE = "signature";
    private static final String KEY_SUB_TYPE = "sub-type";
    private static final String KEY_TXN_ID = "txn-id";
    private static final String KEY_UMN = "umn";
    private static final String KEY_UPI_TRAN_LOG_ID = "upi-tranlog-id";
    private static final String KEY_USER_VPA = "userVpa";
    private static final String KEY_VALIDATE_VA = "validate-va";
    private static final String KEY_VERIFICATION_DATA = "verification-data";
    private static final String KEY_VIRTUAL_ADDRESS = "virtual-address";
    private static final String KEY_VPA = "vpa";
    public static final int LIST_BANK_ACCOUNTS = 10;
    public static final int LIST_CUSTOMER_ACCOUNTS = 11;
    public static final int LIST_CUSTOMER_VPA = 17;
    public static final String PAYTM_CHANNEL = UpiUtils.getChannel();
    public static final int REFRESH_BANK_ACCOUNT = 30;
    public static final int REGISTER_MOBILE = 16;
    public static final String SESSION_TOKEN = "session-token";
    public static final int SET_DEFAULT_ACCOUNT = 22;
    public static final int STORE_ACCOUNT_DETAILS = 14;
    public static final int TRANSACTION_STATUS = 29;
    private static final String VALUE_GET_SUGGESTED_VA = "true";
    private static final String VALUE_VALIDATE_VA = "true";

    public static class ResponseCodes {
        public static final String SUCCESS_RESPONSE_CODE = "0";
    }

    private UpiRequestBuilder() {
    }

    public static String getUrlWithCommonParams(String str, Context context) {
        String str2 = str + UpiAppUtils.getAuthDefaultParams(context);
        return b.t(context, str2) + "&child_site_id=" + a.b() + "&site_id=" + a.a();
    }

    public static Map<String, String> getHeaders(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("channel-token", i.a().f66980a);
        hashMap.put("channel", PAYTM_CHANNEL);
        PaytmLogs.d("[Headers]", hashMap.toString());
        return hashMap;
    }

    public static Map<String, String> getHeadersWithApplicationJson(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel-token", i.a().f66980a);
        hashMap.put("channel", PAYTM_CHANNEL);
        PaytmLogs.d("[Headers]", hashMap.toString());
        return hashMap;
    }

    public static Map<String, String> getCommonDeviceParams(Context context) {
        HashMap hashMap = new HashMap();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        hashMap.put("risk-device-id", str + "-" + str2);
        hashMap.put("deviceIdentifier", str + "-" + str2);
        hashMap.put("deviceManufacturer", str);
        hashMap.put("deviceName", str2);
        hashMap.put("client", "androidapp");
        hashMap.put("version", b.Q(context));
        if (UpiAppUtils.isPlayStoreInstall(context)) {
            hashMap.put("playStore", "true");
        } else {
            hashMap.put("playStore", "false");
        }
        String a2 = c.a();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put("osVersion", a2);
        }
        String networkType = UpiAppUtils.getNetworkType(context);
        if (!TextUtils.isEmpty(networkType)) {
            hashMap.put("networkType", networkType);
        }
        String i2 = a.i(context);
        if (!TextUtils.isEmpty(i2)) {
            hashMap.put("language", i2);
        }
        String k = a.k(context);
        if (!TextUtils.isEmpty(k)) {
            hashMap.put(ContactsConstant.LOCALE, k);
        }
        String g2 = a.g(context);
        if (!TextUtils.isEmpty(g2)) {
            hashMap.put("latitude", g2);
        }
        String h2 = a.h(context);
        if (!TextUtils.isEmpty(h2)) {
            hashMap.put("longitude", h2);
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (!TextUtils.isEmpty(valueOf)) {
            hashMap.put("timestamp", valueOf);
        }
        String deviceID = UpiAppUtils.getDeviceID(context);
        if (!TextUtils.isEmpty(deviceID)) {
            hashMap.put("deviceId", deviceID);
        }
        return hashMap;
    }

    public static String getBankIconUrl(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String upiBankLogoUrl = UpiGTMLoader.getInstance().getUpiBankLogoUrl();
            String substring = str.substring(0, 4);
            try {
                Uri.Builder buildUpon = Uri.parse(upiBankLogoUrl).buildUpon();
                return buildUpon.appendPath(substring + ".png").build().toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getBankIconUrlForIin(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri.Builder buildUpon = Uri.parse(UpiGTMLoader.getInstance().getUpiBankLogoUrl()).buildUpon();
                return buildUpon.appendPath(str + ".png").build().toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final class AccountProviderRequest {
        private AccountProviderRequest() {
        }

        public static String getAccountProviderUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiListAccountProvider();
        }

        public static Map<String, String> getParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class ListKeys {
        private ListKeys() {
        }

        public static String getListKeysUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiListKeys();
        }

        public static Map<String, String> getParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class ListAccountRequest {
        private ListAccountRequest() {
        }

        public static String getListAccountUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiListAccounts();
        }

        public static Map<String, String> getParams(Context context, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put("ifsc", str);
            hashMap.put(UpiRequestBuilder.KEY_PAYER_VA, str2);
            hashMap.put(UpiRequestBuilder.KEY_PAYER_NAME, UpiUtils.getCustomerName(context));
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CheckVpaAvailability {
        private CheckVpaAvailability() {
        }

        public static String getCheckVpaAvailability(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiCheckVa();
        }

        public static Map<String, String> getParams(Context context, String str) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_VIRTUAL_ADDRESS, str);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CheckVpaAvailabilityAndAddVpa {
        private CheckVpaAvailabilityAndAddVpa() {
        }

        public static String getCheckVpaAvailabilityAndAddVpa(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiCheckVaAndAddVa();
        }

        public static Map<String, String> getParams(Context context, UserUpiDetails userUpiDetails) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_CODE, userUpiDetails.getCustomerCode());
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_TYPE, userUpiDetails.getCustomerType());
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_NAME, UpiUtils.getCustomerName(context));
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_VPA, userUpiDetails.getVpa());
            hashMap.put(UpiRequestBuilder.KEY_VALIDATE_VA, "true");
            hashMap.put(UpiRequestBuilder.KEY_GET_SUGGESTED_VA, "true");
            StringBuilder sb = new StringBuilder();
            sb.append(UpiGTMLoader.getInstance().getAutoCreateVpa());
            hashMap.put(UpiRequestBuilder.KEY_AUTO_CREATE_VA, sb.toString());
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class DeviceBindingRequest {
        private DeviceBindingRequest() {
        }

        public static Map<String, String> getParams(Context context, String str, HashMap<String, String> hashMap) {
            String str2;
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap2.putAll(hashMap);
            hashMap2.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap2.put("mobile", UpiUtils.getMobile(context));
            hashMap2.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap2.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            if (i.a().f66982c == null) {
                str2 = "xyz@xyz.com";
            } else {
                str2 = i.a().f66982c;
            }
            hashMap2.put(UpiRequestBuilder.KEY_CUSTOMER_EMAIL_ID, str2);
            hashMap2.put(UpiRequestBuilder.KEY_VERIFICATION_DATA, str);
            PaytmLogs.d("[Params]", hashMap2.toString());
            return hashMap2;
        }
    }

    public static final class DeviceBindingV2Request {
        private DeviceBindingV2Request() {
        }

        public static String getDeviceBindingV2Url(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiDeviceBindingV2();
        }

        public static Map<String, String> getParams(Context context, String str, HashMap<String, String> hashMap) {
            String str2;
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap2.putAll(hashMap);
            hashMap2.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap2.put("mobile", UpiUtils.getMobile(context));
            hashMap2.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap2.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            if (i.a().f66982c == null) {
                str2 = "xyz@xyz.com";
            } else {
                str2 = i.a().f66982c;
            }
            hashMap2.put(UpiRequestBuilder.KEY_CUSTOMER_EMAIL_ID, str2);
            hashMap2.put(UpiRequestBuilder.KEY_VERIFICATION_DATA, str);
            PaytmLogs.d("[Params]", hashMap2.toString());
            return hashMap2;
        }
    }

    public static final class GetTokenRequest {
        private GetTokenRequest() {
        }

        public static String getGetTokenUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiGetToken();
        }

        public static Map<String, String> getParams(Context context, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_APP_ID, UpiUtils.getAppId(context));
            hashMap.put(UpiRequestBuilder.KEY_SUB_TYPE, str);
            hashMap.put(UpiRequestBuilder.KEY_CHALLENGE, str2);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static class DeleteBankAccount {
        private DeleteBankAccount() {
        }

        public static String getDeleteBankAccount(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiDeleteBankAccount();
        }

        public static Map<String, String> getParams(Context context, UserUpiDetails userUpiDetails) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            hashMap.put(UpiRequestBuilder.KEY_IFSC_CODE, selectedBankAccount.getIfsc());
            if (!TextUtils.isEmpty(selectedBankAccount.getAccRefNumber())) {
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NO, selectedBankAccount.getAccRefNumber());
            } else {
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NO, selectedBankAccount.getAccount());
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static class DeregisterProfile {
        private DeregisterProfile() {
        }

        public static String getDeregisterProfile(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiDeregisterProfile();
        }

        public static Map<String, String> getParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put("reason", "dummy reason");
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class AddVirtualAddress {
        private AddVirtualAddress() {
        }

        public static String getAddVirtualAddress(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiAddVpa();
        }

        public static Map<String, String> getParams(Context context, UserUpiDetails userUpiDetails) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_CODE, userUpiDetails.getCustomerCode());
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_TYPE, userUpiDetails.getCustomerType());
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_NAME, UpiUtils.getCustomerName(context));
            hashMap.put(UpiRequestBuilder.KEY_CUSTOMER_VPA, userUpiDetails.getVpa());
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class DeleteVirtualAddress {
        private DeleteVirtualAddress() {
        }

        public static String getDeleteVirtualAddress(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiDeleteVpa();
        }

        public static Map<String, String> getParams(Context context, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_VIRTUAL_ADDRESS, str);
            hashMap.put("reason", str2);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class AddBankAccount {
        private AddBankAccount() {
        }

        public static String getAddBankAccount(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiAddBankAccount();
        }

        public static Map<String, String> getParams(Context context, UserUpiDetails userUpiDetails, boolean z) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            hashMap.put(UpiRequestBuilder.KEY_IFSC_CODE, selectedBankAccount.getIfsc());
            if (!TextUtils.isEmpty(selectedBankAccount.getAccRefNumber())) {
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NO, selectedBankAccount.getAccRefNumber());
            } else {
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NO, selectedBankAccount.getAccount());
            }
            hashMap.put(UpiRequestBuilder.KEY_CRED_BLOCK, selectedBankAccount.getCredsAsJson());
            hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_TYPE, selectedBankAccount.getAccountType());
            if (z) {
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_DEBIT, UpiConstants.DEFAULT_ACCOUNT_CONSTANT);
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_CREDIT, UpiConstants.DEFAULT_ACCOUNT_CONSTANT);
            } else {
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_DEBIT, UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT);
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_CREDIT, UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT);
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class RefreshBankAccount {
        private RefreshBankAccount() {
        }

        public static String getRefreshAccountUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiRefreshAccount();
        }

        public static Map<String, String> getParams(Context context, UserUpiDetails userUpiDetails, String str) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_OPERATION_TYPE, str);
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            hashMap.put(UpiRequestBuilder.KEY_PAYER_NAME, selectedBankAccount.getCustomerName());
            hashMap.put(UpiRequestBuilder.KEY_PAYER_VA, userUpiDetails.getVpa());
            hashMap.put("ifsc", selectedBankAccount.getIfsc());
            if (!TextUtils.isEmpty(selectedBankAccount.getAccRefNumber())) {
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NO, selectedBankAccount.getAccRefNumber());
            } else {
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NO, selectedBankAccount.getAccount());
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class RegisterMobileNumber {
        private RegisterMobileNumber() {
        }

        public static String getRegisterMobileUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getSetMpinUrl();
        }

        public static Map<String, String> getRequestParams(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, str);
            return hashMap;
        }

        public static String getBodyParams(Context context, UserMpinDetails userMpinDetails, UserUpiDetails userUpiDetails) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put("deviceId", UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            hashMap.put(UpiRequestBuilder.ACC_REF_ID_CAMEL_CASE, selectedBankAccount.getAccRefId());
            hashMap.put(UpiRequestBuilder.KEY_PAYER_NAME, selectedBankAccount.getCustomerName());
            hashMap.put(UpiRequestBuilder.KEY_USER_VPA, userUpiDetails.getVpa());
            hashMap.put("ifsc", selectedBankAccount.getIfsc());
            if (!TextUtils.isEmpty(selectedBankAccount.getMmid())) {
                hashMap.put(UpiRequestBuilder.KEY_MMID, selectedBankAccount.getMmid());
            }
            hashMap.put("otp", userMpinDetails.getOtp());
            hashMap.put("mpin", userMpinDetails.getMpin());
            if (!TextUtils.isEmpty(userMpinDetails.getAtmPin())) {
                hashMap.put(UpiRequestBuilder.KEY_ATM_PIN_CAMEL_CASE, userMpinDetails.getAtmPin());
            }
            hashMap.put(UpiRequestBuilder.KEY_EXPIRE_DATE_CAMEL_CASE, userMpinDetails.getExpiryDate());
            hashMap.put(UpiRequestBuilder.KEY_CARD_DIGITS_CAMEL_CASE, userMpinDetails.getCardDigits());
            hashMap.put(UpiRequestBuilder.KEY_ENCRYPTED_DATA_CAMEL_CASE, "");
            JSONObject jSONObject = new JSONObject(hashMap);
            PaytmLogs.d("[Params]", hashMap.toString());
            return jSONObject.toString();
        }
    }

    public static final class GenerateOTP {
        private GenerateOTP() {
        }

        public static Map<String, String> getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
            return hashMap;
        }

        public static String getUrl() {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getOtpForMpinUrl();
        }

        public static String getRequestBody(BankAccountDetails.BankAccount bankAccount, Context context) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                jSONObject.put("mobile", UpiUtils.getMobile(context));
                jSONObject.put(UpiRequestBuilder.ACC_REF_ID_CAMEL_CASE, bankAccount.getAccRefId());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public static final class GetMiniStatement {
        private GetMiniStatement() {
        }

        public static String getMiniStatementUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getUpiGatewayMiniStmt();
        }

        public static Map<String, String> getParams(Context context, int i2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_PAGE_NUMBER, String.valueOf(i2));
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class GetPendingRequests {
        private GetPendingRequests() {
        }

        public static String getPendingRequestsUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getUpiGatewayPendingRequestV2();
        }

        public static Map<String, String> getParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }

        public static Map<String, String> getParams(Context context, int i2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_PAGE_NUMBER, String.valueOf(i2));
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CollectAuthRequest {
        private CollectAuthRequest() {
        }

        public static String getCollectRequestAuthUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiCollectAuth();
        }

        public static Map<String, String> getParams(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("ifsc", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NUMBER, str2);
            }
            if ("M".equalsIgnoreCase(str11)) {
                hashMap.put("mpin", str3);
            }
            hashMap.put(UpiRequestBuilder.KEY_PAYEE_VA, str4);
            hashMap.put(UpiRequestBuilder.KEY_PAYER_VA, str5);
            hashMap.put(UpiRequestBuilder.KEY_REQUESTED_AMOUNT, str6);
            hashMap.put(UpiRequestBuilder.KEY_NOTE, str7);
            hashMap.put(UpiRequestBuilder.KEY_APPROVED_AMOUNT, str8);
            hashMap.put(UpiRequestBuilder.KEY_UPI_TRAN_LOG_ID, str9);
            hashMap.put("action", str10);
            hashMap.put(UpiRequestBuilder.KEY_PRE_APPROVED, str11);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class MarkSpamRequest {
        private MarkSpamRequest() {
        }

        public static String getMarkSpamUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiMarkSpamUrl();
        }

        public static Map<String, String> getParams(Context context, String str, String str2, String str3) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_PAYEE_VA, str2);
            hashMap.put(UpiRequestBuilder.KEY_PAYER_VA, str3);
            hashMap.put(UpiRequestBuilder.KEY_OPERATION, str);
            hashMap.put("reason", "mark as spam");
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class GetSpamRequests {
        private GetSpamRequests() {
        }

        public static String getSpamRequestsUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getUpiSpamRequestList();
        }

        public static Map<String, String> getHeaders(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.put("channel-token", i.a().f66980a);
            hashMap.put("channel", UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Headers]", hashMap.toString());
            return hashMap;
        }

        public static Map<String, String> getParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class ListCustomerAccounts {
        private ListCustomerAccounts() {
        }

        public static String getListCustomerAccounts(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiListCustomerAccount();
        }

        public static Map<String, String> getParams(String str, Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class ListVPA {
        private ListVPA() {
        }

        public static String getListCustomerVpa(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiListVa();
        }

        public static Map<String, String> getParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CommonPayVPA {
        private static final String COMMON_PAY_KEY_ACCOUNT_NUMBER = "account-number";
        private static final String COMMON_PAY_KEY_IFSC = "ifsc";
        private static final String KEY_AMOUNT = "amount";
        private static final String KEY_EXT_MERCHANT_ID = "external-merchant-id";
        private static final String KEY_GLOBAL_ADDRESS_TYPE = "global-address-type";
        private static final String KEY_INITIATION_MODE = "initiation-mode";
        private static final String KEY_MERCHANT_STORE_ID = "merchant-store-id";
        private static final String KEY_MERCHANT_TERMINAL_ID = "merchant-terminal-id";
        private static final String KEY_MPIN = "mpin";
        private static final String KEY_NOTE = "note";
        private static final String KEY_ORG_ID = "org-id";
        private static final String KEY_PAYEE_MCC = "payee-mcc";
        private static final String KEY_PAYEE_NAME = "payee-name";
        private static final String KEY_PAYEE_TYPE = "payee-type";
        private static final String KEY_PAYEE_VA = "payee-va";
        private static final String KEY_PAYER_VA = "payer-va";
        private static final String KEY_PREAPPROVED = "pre-approved";
        private static final String KEY_PURPOSE = "purpose";
        private static final String KEY_REF_CATEGORY = "ref-category";
        private static final String KEY_REF_ID = "ref-id";
        private static final String KEY_REF_URL = "ref-url";
        private static final String KEY_TXN_TYPE = "txn-type";

        private CommonPayVPA() {
        }

        public static String getCommonPayVpaUrl(Context context, boolean z) {
            if (z) {
                return getCommonPayAsyncUrlV2();
            }
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiCommonPayRequest();
        }

        private static String getCommonPayAsyncUrl() {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiCommonPayRequestAsync();
        }

        private static String getCommonPayAsyncUrlV2() {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiCommonPayRequestAsyncV2();
        }

        private static Map<String, String> getCommonParams(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            HashMap hashMap = new HashMap();
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, str);
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put("mpin", str2);
            hashMap.put(KEY_PAYEE_VA, str3);
            hashMap.put("payer-va", str4);
            hashMap.put("amount", str5);
            hashMap.put(KEY_NOTE, str6);
            hashMap.put(KEY_PREAPPROVED, "M");
            hashMap.put(KEY_PAYEE_NAME, str7);
            return hashMap;
        }

        public static Map<String, String> getParamsForAADHAR(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put("ifsc", upiProfileDefaultBank.getDebitBank().getIfsc());
            hashMap.put(COMMON_PAY_KEY_ACCOUNT_NUMBER, upiProfileDefaultBank.getDebitBank().getAccount());
            if (TextUtils.isEmpty(str9) || "0000".equalsIgnoreCase(str9)) {
                hashMap.put(KEY_PAYEE_MCC, "0000");
                hashMap.put(KEY_PAYEE_TYPE, "PERSON");
                hashMap.put(KEY_GLOBAL_ADDRESS_TYPE, str8);
                hashMap.put(KEY_TXN_TYPE, "paytoGlobal");
            } else {
                hashMap.put(KEY_PAYEE_MCC, str9);
                hashMap.put(KEY_PAYEE_TYPE, "ENTITY");
                hashMap.put(KEY_GLOBAL_ADDRESS_TYPE, str8);
                hashMap.put(KEY_TXN_TYPE, "payMerchantGlobal");
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }

        public static Map<String, String> getParamsForVPA(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UpiProfileDefaultBank upiProfileDefaultBank, String str11, boolean z, CommonPayParams commonPayParams, String str12, String str13) {
            String str14 = str8;
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.putAll(getCommonParams(context, str, str2, str3, str4, str5, str6, str7));
            hashMap.put("ifsc", upiProfileDefaultBank.getDebitBank().getIfsc());
            hashMap.put(COMMON_PAY_KEY_ACCOUNT_NUMBER, upiProfileDefaultBank.getDebitBank().getAccount());
            if (!TextUtils.isEmpty(str13)) {
                hashMap.put("theme_id", str13);
            }
            if (TextUtils.isEmpty(str8) || "0000".equalsIgnoreCase(str8)) {
                hashMap.put(KEY_PAYEE_MCC, "0000");
                hashMap.put(KEY_TXN_TYPE, "payRequest");
                hashMap.put(KEY_PAYEE_TYPE, "PERSON");
            } else {
                hashMap.put(KEY_PAYEE_MCC, str8);
                hashMap.put(KEY_TXN_TYPE, "payMerchantRequest");
                hashMap.put(KEY_PAYEE_TYPE, "ENTITY");
                hashMap.put("currency", "INR");
            }
            if (!TextUtils.isEmpty(str11) && UpiAppUtils.isValidAmount(str11)) {
                hashMap.put("min-amount", str11);
            }
            if (!TextUtils.isEmpty(str9)) {
                hashMap.put(KEY_REF_ID, str9);
            }
            if (!TextUtils.isEmpty(str10)) {
                hashMap.put(KEY_REF_URL, str10);
            }
            if (!TextUtils.isEmpty(str12)) {
                hashMap.put(UpiRequestBuilder.KEY_PAYEE_MOBILE_NO, str12);
            }
            if (commonPayParams != null) {
                if (!TextUtils.isEmpty(commonPayParams.getMode())) {
                    hashMap.put(KEY_INITIATION_MODE, commonPayParams.getMode());
                }
                if (!TextUtils.isEmpty(commonPayParams.getOrgid())) {
                    hashMap.put(KEY_ORG_ID, commonPayParams.getOrgid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getMsid())) {
                    hashMap.put(KEY_MERCHANT_STORE_ID, commonPayParams.getMsid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getMtid())) {
                    hashMap.put(KEY_MERCHANT_TERMINAL_ID, commonPayParams.getMtid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getRefCategory())) {
                    hashMap.put(KEY_REF_CATEGORY, commonPayParams.getRefCategory());
                }
                if (!TextUtils.isEmpty(commonPayParams.getPurpose())) {
                    hashMap.put(KEY_PURPOSE, commonPayParams.getPurpose());
                }
                if (!TextUtils.isEmpty(commonPayParams.getMid())) {
                    hashMap.put(KEY_EXT_MERCHANT_ID, commonPayParams.getMid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getSign())) {
                    hashMap.put("data", commonPayParams.getSign());
                }
                if (commonPayParams.getExtendedInfo() != null) {
                    for (Map.Entry next : commonPayParams.getExtendedInfo().entrySet()) {
                        hashMap.put(next.getKey(), next.getValue());
                    }
                }
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }

        public static Map<String, String> getParamsForBankAccount(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, UpiProfileDefaultBank upiProfileDefaultBank, String str10, CommonPayParams commonPayParams, String str11, String str12) {
            String str13 = str10;
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.putAll(getCommonParams(context, str, str4, str5, str6, str7, str8, str9));
            hashMap.put("ifsc", upiProfileDefaultBank.getDebitBank().getIfsc());
            hashMap.put(COMMON_PAY_KEY_ACCOUNT_NUMBER, upiProfileDefaultBank.getDebitBank().getAccount());
            if (!TextUtils.isEmpty(str12)) {
                hashMap.put("theme_id", str12);
            }
            if (!TextUtils.isEmpty(str11)) {
                hashMap.put(UpiRequestBuilder.KEY_PAYEE_MOBILE_NO, str11);
            }
            if (TextUtils.isEmpty(str10) || "0000".equalsIgnoreCase(str13)) {
                hashMap.put(KEY_PAYEE_MCC, "0000");
                hashMap.put(KEY_PAYEE_TYPE, "PERSON");
                hashMap.put(KEY_GLOBAL_ADDRESS_TYPE, "ACCOUNTIFSC");
                hashMap.put(KEY_TXN_TYPE, "paytoGlobal");
            } else {
                hashMap.put(KEY_PAYEE_MCC, str13);
                hashMap.put(KEY_PAYEE_TYPE, "ENTITY");
                hashMap.put(KEY_GLOBAL_ADDRESS_TYPE, "ACCOUNTIFSC");
                hashMap.put(KEY_TXN_TYPE, "payMerchantGlobal");
            }
            if (commonPayParams != null) {
                if (!TextUtils.isEmpty(commonPayParams.getMode())) {
                    hashMap.put(KEY_INITIATION_MODE, commonPayParams.getMode());
                }
                if (!TextUtils.isEmpty(commonPayParams.getOrgid())) {
                    hashMap.put(KEY_ORG_ID, commonPayParams.getOrgid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getMsid())) {
                    hashMap.put(KEY_MERCHANT_STORE_ID, commonPayParams.getMsid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getMtid())) {
                    hashMap.put(KEY_MERCHANT_TERMINAL_ID, commonPayParams.getMtid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getRefCategory())) {
                    hashMap.put(KEY_REF_CATEGORY, commonPayParams.getRefCategory());
                }
                if (!TextUtils.isEmpty(commonPayParams.getPurpose())) {
                    hashMap.put(KEY_PURPOSE, commonPayParams.getPurpose());
                }
                if (!TextUtils.isEmpty(commonPayParams.getMid())) {
                    hashMap.put(KEY_EXT_MERCHANT_ID, commonPayParams.getMid());
                }
                if (!TextUtils.isEmpty(commonPayParams.getSign())) {
                    hashMap.put("data", commonPayParams.getSign());
                }
                if (commonPayParams.getExtendedInfo() != null) {
                    for (Map.Entry next : commonPayParams.getExtendedInfo().entrySet()) {
                        hashMap.put(next.getKey(), next.getValue());
                    }
                }
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CollectPayRequest {
        private static final String COMMON_PAY_KEY_ACCOUNT_NUMBER = "account-number";
        private static final String COMMON_PAY_KEY_IFSC = "ifsc";
        private static final String KEY_ACTION_ID = "action";
        private static final String KEY_APPR_AMOUNT = "approved-amount";
        private static final String KEY_GLOBAL_ADDRESS_TYPE = "global-address-type";
        private static final String KEY_MPIN = "mpin";
        private static final String KEY_NOTE = "note";
        private static final String KEY_PAYEE_MCC = "payee-mcc";
        private static final String KEY_PAYEE_NAME = "payee-name";
        private static final String KEY_PAYEE_TYPE = "payee-type";
        private static final String KEY_PAYEE_VA = "payee-va";
        private static final String KEY_PAYER_VA = "payer-va";
        private static final String KEY_PREAPPROVED = "pre-approved";
        private static final String KEY_REQ_AMOUNT = "requested-amount";
        private static final String KEY_TXN_TYPE = "txn-type";
        private static final String UPI_TRAN_LOG_ID = "upi-tranlog-id";

        private CollectPayRequest() {
        }

        public static String getCommonPayVpaUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiCollectAuth();
        }

        public static Map<String, String> getParamsForCollectReqPay(Context context, String str, String str2, String str3, String str4, String str5, String str6, UpiProfileDefaultBank upiProfileDefaultBank, String str7, String str8, String str9) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, str);
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put("ifsc", upiProfileDefaultBank.getDebitBank().getIfsc());
            hashMap.put(COMMON_PAY_KEY_ACCOUNT_NUMBER, upiProfileDefaultBank.getDebitBank().getAccount());
            hashMap.put("mpin", str2);
            hashMap.put(KEY_PAYEE_VA, str3);
            hashMap.put("payer-va", str4);
            hashMap.put(KEY_REQ_AMOUNT, str5);
            if (!TextUtils.isEmpty(str6)) {
                hashMap.put(KEY_NOTE, str6);
            }
            hashMap.put(KEY_PAYEE_NAME, str8);
            hashMap.put(KEY_APPR_AMOUNT, str5);
            hashMap.put(UPI_TRAN_LOG_ID, str7);
            hashMap.put("action", "A");
            hashMap.put(KEY_PREAPPROVED, "M");
            hashMap.put(UpiRequestBuilder.KEY_UMN, str9);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class SetDefaultAccount {
        private SetDefaultAccount() {
        }

        public static String getSetDefaultAccount(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiSetDefaultAccount();
        }

        public static Map<String, String> getParams(Context context, UserUpiDetails userUpiDetails, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            hashMap.put(UpiRequestBuilder.KEY_IFSC_CODE, selectedBankAccount.getIfsc());
            hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NO, selectedBankAccount.getAccount());
            hashMap.put(UpiRequestBuilder.KEY_VIRTUAL_ADDRESS, userUpiDetails.getVpa());
            UpiConstants.BANK_ACCOUNT_TYPE.valueOf("SAVINGS");
            if (profile_vpa_account_type.equals(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.CREDIT)) {
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_CREDIT, UpiConstants.DEFAULT_ACCOUNT_CONSTANT);
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_DEBIT, UpiConstants.DEFAULT_ACCOUNT_CONSTANT);
            } else if (profile_vpa_account_type.equals(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT)) {
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_DEBIT, UpiConstants.DEFAULT_ACCOUNT_CONSTANT);
                hashMap.put(UpiRequestBuilder.KEY_DEFAULT_CREDIT, UpiConstants.DEFAULT_ACCOUNT_CONSTANT);
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class ChangeMPIN {
        private ChangeMPIN() {
        }

        public static Map<String, String> getRequestParams(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, str);
            return hashMap;
        }

        public static String getUrl() {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiChangeMpin();
        }

        public static String getBodyParams(Context context, UserUpiDetails userUpiDetails, UserMpinDetails userMpinDetails) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put("deviceId", UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            hashMap.put("ifsc", selectedBankAccount.getIfsc());
            hashMap.put(UpiRequestBuilder.KEY_USER_VPA, userUpiDetails.getVpa());
            hashMap.put(UpiRequestBuilder.ACC_REF_ID_CAMEL_CASE, selectedBankAccount.getAccRefId());
            hashMap.put(UpiRequestBuilder.KEY_OLD_MPIN_CAMEL_CASE, userMpinDetails.getOldMpin());
            hashMap.put(UpiRequestBuilder.KEY_NEW_MPIN_CAMEL_CASE, userMpinDetails.getNewMpin());
            JSONObject jSONObject = new JSONObject(hashMap);
            PaytmLogs.d("[Params]", hashMap.toString());
            return jSONObject.toString();
        }
    }

    public static final class CheckAccountBalanceV2 {
        private CheckAccountBalanceV2() {
        }

        public static String getCheckAccountBalanceV2() {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiBalanceEnquiryV2();
        }

        public static Map<String, String> getParams(Context context, String str, UserUpiDetails userUpiDetails, UserMpinDetails userMpinDetails) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            try {
                hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
                hashMap.put("mobile", UpiUtils.getMobile(context));
                hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, str);
                hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
                BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
                hashMap.put("ifsc", selectedBankAccount.getIfsc());
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NUMBER, selectedBankAccount.getAccount());
                hashMap.put(UpiRequestBuilder.KEY_VIRTUAL_ADDRESS, userUpiDetails.getVpa());
                hashMap.put("mpin", userMpinDetails.getMpin());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }

        public static Map<String, String> getParams(Context context, String str, UpiProfileDefaultBank upiProfileDefaultBank, UserMpinDetails userMpinDetails) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            try {
                hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
                hashMap.put("mobile", UpiUtils.getMobile(context));
                hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, str);
                hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
                BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
                hashMap.put("ifsc", debitBank.getIfsc());
                hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NUMBER, debitBank.getAccount());
                hashMap.put(UpiRequestBuilder.KEY_VIRTUAL_ADDRESS, upiProfileDefaultBank.getVirtualAddress());
                hashMap.put("mpin", userMpinDetails.getMpin());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CheckAccountBalance {
        private CheckAccountBalance() {
        }

        public static String getCheckAccountBalanceV4(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiBalanceEnquiryV4();
        }

        public static String getCheckAccountBalanceStatus(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiBalanceEnquiryStatus();
        }

        public static String getRequestBody(Context context, String str, UpiProfileDefaultBank upiProfileDefaultBank, UserMpinDetails userMpinDetails) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                jSONObject.put("mobile", UpiUtils.getMobile(context));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, str);
                jSONObject.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
                BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
                jSONObject.put("ifsc", debitBank.getIfsc());
                jSONObject.put("vpa", upiProfileDefaultBank.getVirtualAddress());
                jSONObject.put("mpin", userMpinDetails.getMpin());
                jSONObject.put(UpiRequestBuilder.ACC_REF_ID_CAMEL_CASE, debitBank.getAccRefId());
            } catch (Exception unused) {
            }
            PaytmLogs.d("[Params]", jSONObject.toString());
            return jSONObject.toString();
        }

        public static String getRequestBody(Context context, String str, UserUpiDetails userUpiDetails, UserMpinDetails userMpinDetails) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                jSONObject.put("mobile", UpiUtils.getMobile(context));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, str);
                jSONObject.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
                BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
                jSONObject.put("ifsc", selectedBankAccount.getIfsc());
                jSONObject.put("vpa", userUpiDetails.getVpa());
                jSONObject.put(UpiRequestBuilder.ACC_REF_ID_CAMEL_CASE, selectedBankAccount.getAccRefId());
                jSONObject.put("mpin", userMpinDetails.getMpin());
            } catch (Exception unused) {
            }
            PaytmLogs.d("[Params]", jSONObject.toString());
            return jSONObject.toString();
        }

        public static String getRequestBody(String str, Context context) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                jSONObject.put("mobile", UpiUtils.getMobile(context));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, str);
            } catch (Exception e2) {
                PaytmLogs.d("check balance", "Error", e2);
            }
            return jSONObject.toString();
        }
    }

    public static final class CollectRequest {
        private CollectRequest() {
        }

        public static String getCollectRequestUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiCollectRequest();
        }

        public static Map<String, String> getParams(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put("ifsc", str);
            hashMap.put(UpiRequestBuilder.KEY_ACCOUNT_NUMBER, str2);
            hashMap.put(UpiRequestBuilder.KEY_PAYEE_VA, str3);
            hashMap.put(UpiRequestBuilder.KEY_PAYER_VA, str4);
            hashMap.put("amount", str5);
            hashMap.put(UpiRequestBuilder.KEY_NOTE, str6);
            hashMap.put(UpiRequestBuilder.KEY_EXPIRE_AFTER, String.valueOf(str7));
            hashMap.put(UpiRequestBuilder.KEY_PAYER_NAME, str8);
            hashMap.put(UpiRequestBuilder.KEY_REF_ID, UpiUtils.getUpiSequenceNo());
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class ValidateAddress {
        private ValidateAddress() {
        }

        public static String getValidateAddressUrl(Context context) {
            return UpiGTMLoader.getInstance().getBaseUpiUrl() + UpiGTMLoader.getInstance().getUpiValidateAddress();
        }

        public static Map<String, String> getParams(Context context, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_VIRTUAL_ADDRESS, str);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(UpiRequestBuilder.KEY_PAYEE_NAME, str2);
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class ValidateAddressV2 {
        private ValidateAddressV2() {
        }

        public static String getValidateAddressV2Url(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiValidateAddressV2();
        }

        public static Map<String, String> getParams(Context context, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_VIRTUAL_ADDRESS, str);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("data", str2);
            }
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CheckBalanceStatus {
        private CheckBalanceStatus() {
        }

        public static String CheckBalStatusUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getCheckBalStatusUrl();
        }

        public static Map<String, String> getParams(Context context, UpiProfileDefaultBank upiProfileDefaultBank, String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put("mpin", str);
            hashMap.put("amount", str2);
            hashMap.put("ifsc", upiProfileDefaultBank.getDebitBank().getIfsc());
            hashMap.put(UpiRequestBuilder.KEY_PAYER_VA, upiProfileDefaultBank.getVirtualAddress());
            hashMap.put("accountNumber", upiProfileDefaultBank.getDebitBank().getAccount());
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class CreateSignature {
        private CreateSignature() {
        }

        public static String CreateSignatureUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getCreateSignatureUrl();
        }

        public static Map<String, String> getParams(Context context, String str) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
            hashMap.put("data", str);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class UpiTransactionStatus {
        private UpiTransactionStatus() {
        }

        public static String getUpiTransactionStatusUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiTransactionStatusV2();
        }

        public static Map<String, String> getParams(Context context, String str) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_TXN_ID, str);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static final class UpiInitiateSms {
        private UpiInitiateSms() {
        }

        public static String getUpiInitiateSmsUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiInitiateSmsUrl();
        }

        public static String getUpiInitiateSmsUrlV2(Context context) {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiInitiateSmsUrlV2();
        }

        public static String getUpiInitiateSmsUrlV3() {
            return UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiInitiateSmsUrlV3();
        }

        public static Map<String, String> getParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }

        public static String getRequestBody(Context context, boolean z, String str, String str2) {
            JSONObject jSONObject = new JSONObject(UpiRequestBuilder.getCommonDeviceParams(context));
            try {
                jSONObject.put(UpiRequestBuilder.KEY_FETCH_ACCOUNTS, z);
                jSONObject.put("requestId", UpiUtils.getUpiSequenceNo());
                jSONObject.put(UpiRequestBuilder.KEY_CIRCLE, str);
                jSONObject.put(UpiRequestBuilder.KEY_CARRIER, str2);
            } catch (Exception unused) {
                PaytmLogs.d("initiate sms v3", "json error");
            }
            return jSONObject.toString();
        }
    }

    public static final class UpiExpireSmsToken {
        private UpiExpireSmsToken() {
        }

        public static String getUpiSmsTokenExpireUrl(Context context) {
            return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUpiSmsTokenExpireUrl();
        }

        public static Map<String, String> getParams(Context context, String str) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(UpiRequestBuilder.getCommonDeviceParams(context));
            hashMap.put(UpiRequestBuilder.KEY_DEVICE_ID, UpiUtils.getDeviceId(context));
            hashMap.put("mobile", UpiUtils.getMobile(context));
            hashMap.put(UpiRequestBuilder.KEY_SEQ_NO, UpiUtils.getUpiSequenceNo());
            hashMap.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put(UpiRequestBuilder.KEY_VERIFICATION_DATA, str);
            PaytmLogs.d("[Params]", hashMap.toString());
            return hashMap;
        }
    }

    public static class EditVpa {
        private EditVpa() {
        }

        public static String getRequestBody(Context context, String str, Boolean bool) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("listVA", bool);
                jSONObject.put("customerVpa", str);
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
                jSONObject.put("deviceId", UpiUtils.getDeviceId(context));
                jSONObject.put(UpiRequestBuilder.KEY_CHANNEL_CODE, UpiRequestBuilder.PAYTM_CHANNEL);
                jSONObject.put("mobile", UpiUtils.getMobile(context));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }

        public static String getUrl(Context context) {
            return (UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiVpaEditUrl()) + "?mobile=" + UpiUtils.getMobile(context);
        }
    }

    public static final class AddBankAccountSuccessPopup {
        private AddBankAccountSuccessPopup() {
        }

        public static Map<String, String> getQueryParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.put("client", "androidapp");
            hashMap.put("version", b.Q(context));
            return hashMap;
        }

        public static String getUrl() {
            return UpiGTMLoader.getInstance().getAddBankAccountSuccessUrl();
        }
    }

    public static final class PostTransactionBanner {
        private PostTransactionBanner() {
        }

        public static Map<String, String> getQueryParams(Context context) {
            HashMap hashMap = new HashMap();
            hashMap.put("client", "androidapp");
            hashMap.put("version", b.Q(context));
            hashMap.put("user_id", i.a().f66984e);
            return hashMap;
        }

        public static String getUrl() {
            return UpiGTMLoader.getInstance().getUpiPostTransactionBannerUrl();
        }
    }

    public static String getUPIBankHealthUrl() {
        return UpiGTMLoader.getInstance().getUpiSecureBaseUrl() + UpiGTMLoader.getInstance().getUPIBankHealthUrl();
    }
}
