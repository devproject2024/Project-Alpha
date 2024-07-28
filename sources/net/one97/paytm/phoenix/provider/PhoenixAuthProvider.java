package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.content.Intent;
import java.util.HashMap;
import kotlin.g.b.k;

public interface PhoenixAuthProvider {
    Intent login(Activity activity, HashMap<String, Object> hashMap);

    boolean logout(Activity activity, HashMap<String, Object> hashMap);

    boolean logoutAllDevices(Activity activity, HashMap<String, Object> hashMap);

    AuthData provideAuthToken(Activity activity);

    boolean sessionExpired(Activity activity, HashMap<String, Object> hashMap);

    public static final class AuthData {
        private final String authToken;
        private final String authorizationValue;

        public static /* synthetic */ AuthData copy$default(AuthData authData, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = authData.authToken;
            }
            if ((i2 & 2) != 0) {
                str2 = authData.authorizationValue;
            }
            return authData.copy(str, str2);
        }

        public final String component1() {
            return this.authToken;
        }

        public final String component2() {
            return this.authorizationValue;
        }

        public final AuthData copy(String str, String str2) {
            return new AuthData(str, str2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AuthData)) {
                return false;
            }
            AuthData authData = (AuthData) obj;
            return k.a((Object) this.authToken, (Object) authData.authToken) && k.a((Object) this.authorizationValue, (Object) authData.authorizationValue);
        }

        public final int hashCode() {
            String str = this.authToken;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.authorizationValue;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "AuthData(authToken=" + this.authToken + ", authorizationValue=" + this.authorizationValue + ")";
        }

        public AuthData(String str, String str2) {
            this.authToken = str;
            this.authorizationValue = str2;
        }

        public final String getAuthToken() {
            return this.authToken;
        }

        public final String getAuthorizationValue() {
            return this.authorizationValue;
        }
    }
}
