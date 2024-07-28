package com.imsdk;

import com.sendbird.android.User;
import java.util.List;

public class IMManager {
    private final String TAG;
    public String currentUrl;

    public interface ConnectCallback {
        void onConnected(LoginInfo loginInfo);

        void onFailed(int i2, String str);
    }

    public interface ContectStatusCallback {
        void status(boolean z);
    }

    public interface DisconnectCallback {
        void onDisconnected();

        void onFailed(int i2, String str);
    }

    public interface NotifyCallback {
        void onFailed(int i2, String str);

        void onSuccess();
    }

    public interface QueryUserCallback {
        void onFailed(int i2, String str);

        void onSuccess(User user);
    }

    public interface QueryUserListCallback {
        void onFailed(int i2, String str);

        void onSuccess(List<User> list);
    }

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final IMManager f40772a = new IMManager();
    }

    private IMManager() {
        this.TAG = "IMManager";
        this.currentUrl = "";
    }

    public static final IMManager getInstance() {
        return a.f40772a;
    }
}
