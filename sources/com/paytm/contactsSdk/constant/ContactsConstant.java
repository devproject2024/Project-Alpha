package com.paytm.contactsSdk.constant;

import java.util.ArrayList;
import kotlin.a.k;

public final class ContactsConstant {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APP_VERSION = "appVersion";
    public static final String Android_OS = "android";
    public static final String BASE_URL = "https://cms-staging-external.paytm.com";
    public static final String CONTACTS_CONSENT_KEY = "ocl.permission.contact_management.contact_sync_consent";
    public static final int CONTACTS_PERMISSION_REQUEST_CODE = 200;
    public static final String CONTACT_TYPE_VALUE = "PHONEBOOK";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEVICE_ID = "deviceId";
    private static final ArrayList<String> GET_CONTACT_CONSENT_KEY_LIST = k.d(CONTACTS_CONSENT_KEY);
    public static final String HEALTH_API_LAST_TIME_STAMP = "HEALTH_API_LAST_TIME_STAMP";
    public static final ContactsConstant INSTANCE = new ContactsConstant();
    public static final String IP = "ip";
    public static final String LAST_LOCAL_CONTACT_SYNCED_TIME = "LAST_LOCAL_CONTACT_SYNCED_TIME";
    public static final String LAT_LONG = "Lat-Lng";
    public static final String LOCALE = "locale";
    public static final String NETWORK = "network";
    public static final String OS_TYPE = "OS";
    public static final String PAGE_NUMBER = "Page_number";
    public static final String REQUEST_ID = "requestId";
    public static final String SEARCH_CONTACT_LAST_TIME_STAMP = "SEARCH_CONTACT_LAST_TIME_STAMP";
    public static final String SEARCH_PARAM = "search_param";
    public static final String SSO_TOKEN = "sso-token";
    public static final String TIME_STAMP = "timestamp";
    public static final String USER_AGENT = "user-agent";

    private ContactsConstant() {
    }

    public final ArrayList<String> getGET_CONTACT_CONSENT_KEY_LIST() {
        return GET_CONTACT_CONSENT_KEY_LIST;
    }
}
