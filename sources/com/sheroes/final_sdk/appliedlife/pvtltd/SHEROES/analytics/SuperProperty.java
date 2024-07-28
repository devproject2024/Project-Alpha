package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics;

import org.json.JSONException;
import org.json.JSONObject;

public enum SuperProperty {
    USER_ID("User Id"),
    DATE_OF_BIRTH("Date Of Birth"),
    CREATED_DATE("Created Date"),
    MOBILE_NUMBER("Mobile Number"),
    FEED_CONFIG_VERSION("Feed Config Version"),
    SET_ORDER_KEY("Set Order Key"),
    USER_NAME("User Name"),
    EMAIL_ID("Email Id"),
    CONFIG_TYPE("Config Type"),
    CONFIG_VERSION("Config Version"),
    APPSFLYER_ID("Appsflyer_id");
    
    private final String string;

    private SuperProperty(String str) {
        this.string = str;
    }

    public final String getString() {
        return this.string;
    }

    public static class Builder {
        private JSONObject superProperties;

        private static <T> boolean validateData(SuperProperty superProperty, T t) {
            return (superProperty == null || t == null) ? false : true;
        }

        public Builder() {
            this.superProperties = new JSONObject();
        }

        private <T> boolean put(SuperProperty superProperty, T t) {
            if (validateData(superProperty, t)) {
                try {
                    this.superProperties.put(superProperty.getString(), t);
                } catch (JSONException unused) {
                }
            }
            return t != null;
        }

        public Builder userName(String str) {
            put(SuperProperty.USER_NAME, str);
            return this;
        }

        public Builder userId(String str) {
            put(SuperProperty.USER_ID, str);
            return this;
        }

        public Builder dateOfBirth(String str) {
            put(SuperProperty.DATE_OF_BIRTH, str);
            return this;
        }

        public Builder createdDate(String str) {
            put(SuperProperty.CREATED_DATE, str);
            return this;
        }

        public Builder mobileNumber(String str) {
            put(SuperProperty.MOBILE_NUMBER, str);
            return this;
        }

        public Builder setOrderKey(String str) {
            put(SuperProperty.SET_ORDER_KEY, str);
            return this;
        }

        public Builder feedConfigVersion(String str) {
            put(SuperProperty.FEED_CONFIG_VERSION, str);
            return this;
        }

        public Builder emailId(String str) {
            put(SuperProperty.EMAIL_ID, str);
            return this;
        }

        public Builder appsflyerID(String str) {
            put(SuperProperty.APPSFLYER_ID, str);
            return this;
        }

        public Builder configType(String str) {
            put(SuperProperty.CONFIG_TYPE, str);
            return this;
        }

        public Builder configVersion(String str) {
            put(SuperProperty.CONFIG_VERSION, str);
            return this;
        }

        public JSONObject build() {
            return this.superProperties;
        }
    }
}
