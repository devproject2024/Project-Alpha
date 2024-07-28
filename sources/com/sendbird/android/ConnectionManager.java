package com.sendbird.android;

import com.sendbird.android.log.Logger;

public class ConnectionManager {

    public interface AuthInfoRequestHandler {
        void onAuthInfoRequest(AuthInfoRequester authInfoRequester);
    }

    public interface AuthInfoRequester {
        void setAuthInfo(String str, String str2);

        void setAuthInfoWithHostInfo(String str, String str2, String str3, String str4);
    }

    public interface AuthenticateHandler {
        void onAuthenticated(User user, SendBirdException sendBirdException);
    }

    public static abstract class NetworkHandler {
        public abstract void onReconnected();
    }

    public static void authenticate(AuthInfoRequestHandler authInfoRequestHandler, AuthenticateHandler authenticateHandler) {
        Logger.d("[ConnectionManager] authenticate()");
        u.a().a(authInfoRequestHandler, authenticateHandler);
    }

    public static void addNetworkHandler(String str, NetworkHandler networkHandler) {
        u a2 = u.a();
        if (str != null && str.length() != 0 && networkHandler != null) {
            a2.f45289f.put(str, networkHandler);
        }
    }

    public static void removeNetworkHandler(String str) {
        u a2 = u.a();
        if (str != null && str.length() != 0) {
            a2.f45289f.remove(str);
        }
    }

    public static void removeAllNetworkHandlers() {
        u.a().f45289f.clear();
    }
}
