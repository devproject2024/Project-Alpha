package com.sendbird.android;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.Command;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.GroupChannelListQuery;
import com.sendbird.android.GroupChannelTotalUnreadMessageCountParams;
import com.sendbird.android.UserListQuery;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.k;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.Conscrypt;

public final class SendBird {
    public static final int LOGGER_INFO = 1;
    public static final int LOGGER_NONE = 0;
    public static final String PUSH_TEMPLATE_ALTERNATIVE = "alternative";
    public static final String PUSH_TEMPLATE_DEFAULT = "default";
    private static String ekey = "";
    private static Map<a, String> exUserAgent = new HashMap();
    private static SendBird sInstance;
    private static final Handler sUIThreadHandler = new Handler(Looper.getMainLooper());
    final g applicationHandler = new g();
    private final Context mAppContext;
    private String mAppId;
    /* access modifiers changed from: private */
    public ConnectivityManager mConnectivityManager;
    private User mCurrentUser;
    boolean mIsAppBackground = true;
    boolean mIsAppBackgroundAndDisconnected = false;
    private boolean mIsNetworkAwarenessReconnection = true;
    private boolean mIsTrackingApplicationState = true;
    /* access modifiers changed from: private */
    public String mPushToken;
    final Map<String, UserEventHandler> mUserEventHandlers = new ConcurrentHashMap();

    public interface AddFriendsHandler {
        void onResult(List<User> list, SendBirdException sendBirdException);
    }

    public static abstract class ChannelHandler {
        public void onChannelChanged(BaseChannel baseChannel) {
        }

        public void onChannelDeleted(String str, BaseChannel.ChannelType channelType) {
        }

        public void onChannelFrozen(BaseChannel baseChannel) {
        }

        public void onChannelHidden(GroupChannel groupChannel) {
        }

        public void onChannelUnfrozen(BaseChannel baseChannel) {
        }

        public void onDeliveryReceiptUpdated(GroupChannel groupChannel) {
        }

        public void onMentionReceived(BaseChannel baseChannel, BaseMessage baseMessage) {
        }

        public void onMessageDeleted(BaseChannel baseChannel, long j) {
        }

        public abstract void onMessageReceived(BaseChannel baseChannel, BaseMessage baseMessage);

        public void onMessageUpdated(BaseChannel baseChannel, BaseMessage baseMessage) {
        }

        public void onMetaCountersCreated(BaseChannel baseChannel, Map<String, Integer> map) {
        }

        public void onMetaCountersDeleted(BaseChannel baseChannel, List<String> list) {
        }

        public void onMetaCountersUpdated(BaseChannel baseChannel, Map<String, Integer> map) {
        }

        public void onMetaDataCreated(BaseChannel baseChannel, Map<String, String> map) {
        }

        public void onMetaDataDeleted(BaseChannel baseChannel, List<String> list) {
        }

        public void onMetaDataUpdated(BaseChannel baseChannel, Map<String, String> map) {
        }

        public void onOperatorUpdated(BaseChannel baseChannel) {
        }

        public void onReactionUpdated(BaseChannel baseChannel, ReactionEvent reactionEvent) {
        }

        public void onReadReceiptUpdated(GroupChannel groupChannel) {
        }

        public void onThreadInfoUpdated(BaseChannel baseChannel, ThreadInfoUpdateEvent threadInfoUpdateEvent) {
        }

        public void onTypingStatusUpdated(GroupChannel groupChannel) {
        }

        public void onUserBanned(BaseChannel baseChannel, User user) {
        }

        public void onUserDeclinedInvitation(GroupChannel groupChannel, User user, User user2) {
        }

        public void onUserEntered(OpenChannel openChannel, User user) {
        }

        public void onUserExited(OpenChannel openChannel, User user) {
        }

        public void onUserJoined(GroupChannel groupChannel, User user) {
        }

        public void onUserLeft(GroupChannel groupChannel, User user) {
        }

        public void onUserMuted(BaseChannel baseChannel, User user) {
        }

        public void onUserReceivedInvitation(GroupChannel groupChannel, User user, List<User> list) {
        }

        public void onUserUnbanned(BaseChannel baseChannel, User user) {
        }

        public void onUserUnmuted(BaseChannel baseChannel, User user) {
        }
    }

    public interface ConnectHandler {
        void onConnected(User user, SendBirdException sendBirdException);
    }

    public interface ConnectionHandler {
        void onReconnectFailed();

        void onReconnectStarted();

        void onReconnectSucceeded();
    }

    public enum ConnectionState {
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public interface DeleteFriendDiscoveriesHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface DeleteFriendDiscoveryHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface DeleteFriendHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface DeleteFriendsHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface DisconnectHandler {
        void onDisconnected();
    }

    public interface GetAllEmojiHandler {
        void onResult(EmojiContainer emojiContainer, SendBirdException sendBirdException);
    }

    public interface GetChannelInvitationPreferenceHandler {
        void onResult(boolean z, SendBirdException sendBirdException);
    }

    public interface GetDoNotDisturbHandler {
        void onResult(boolean z, int i2, int i3, int i4, int i5, String str, SendBirdException sendBirdException);
    }

    public interface GetEmojiCategoryHandler {
        void onResult(EmojiCategory emojiCategory, SendBirdException sendBirdException);
    }

    public interface GetEmojiHandler {
        void onResult(Emoji emoji, SendBirdException sendBirdException);
    }

    public interface GetFriendChangeLogsByTokenHandler {
        void onResult(List<User> list, List<String> list2, boolean z, String str, SendBirdException sendBirdException);
    }

    public interface GetMyGroupChannelChangeLogsHandler {
        void onResult(List<GroupChannel> list, List<String> list2, boolean z, String str, SendBirdException sendBirdException);
    }

    public interface GetPushSoundHandler {
        void onResult(String str, SendBirdException sendBirdException);
    }

    public interface GetPushTemplateHandler {
        void onResult(String str, SendBirdException sendBirdException);
    }

    public interface GetPushTokensHandler {
        void onResult(List<String> list, PushTokenType pushTokenType, boolean z, String str, SendBirdException sendBirdException);
    }

    public interface GetPushTriggerOptionHandler {
        void onResult(PushTriggerOption pushTriggerOption, SendBirdException sendBirdException);
    }

    public interface GetSnoozePeriodHandler {
        void onResult(boolean z, long j, long j2, SendBirdException sendBirdException);
    }

    public interface MarkAsReadHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public enum PushTokenRegistrationStatus {
        SUCCESS,
        PENDING,
        ERROR
    }

    @Deprecated
    public interface RegisterPushTokenHandler {
        @Deprecated
        void onRegistered(SendBirdException sendBirdException);
    }

    public interface RegisterPushTokenWithStatusHandler {
        void onRegistered(PushTokenRegistrationStatus pushTokenRegistrationStatus, SendBirdException sendBirdException);
    }

    public interface SetChannelInvitationPreferenceHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface SetDoNotDisturbHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface SetPushSoundHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface SetPushTemplateHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface SetPushTriggerOptionHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface SetSnoozePeriodHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface UnregisterPushTokenHandler {
        void onUnregistered(SendBirdException sendBirdException);
    }

    public interface UploadFriendDiscoveriesHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface UserBlockHandler {
        void onBlocked(User user, SendBirdException sendBirdException);
    }

    public static abstract class UserEventHandler {
        public abstract void onFriendsDiscovered(List<User> list);

        public void onTotalUnreadMessageCountChanged(int i2, Map<String, Integer> map) {
        }
    }

    public interface UserInfoUpdateHandler {
        void onUpdated(SendBirdException sendBirdException);
    }

    public interface UserUnblockHandler {
        void onUnblocked(SendBirdException sendBirdException);
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Deprecated
    public static void notifyActivityPausedForOldAndroids() {
    }

    @Deprecated
    public static void notifyActivityResumedForOldAndroids() {
    }

    enum a {
        None("none", ""),
        Core(StringSet.core, "c"),
        SyncManager(StringSet.sb_syncmanager, "s"),
        UIKit(StringSet.sb_uikit, "u");
        
        private String key;
        private String shortCut;

        private a(String str, String str2) {
            this.key = str;
            this.shortCut = str2;
        }

        public final String getValue(String str) {
            return this.shortCut + str;
        }

        public static a from(String str) {
            for (a aVar : values()) {
                if (aVar.key.equals(str)) {
                    return aVar;
                }
            }
            return None;
        }
    }

    public static void addExtension(String str, String str2) {
        a from;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (from = a.from(str)) != a.None) {
            exUserAgent.put(from, str2);
        }
    }

    static String getAdditionalData() {
        StringBuilder sb = new StringBuilder();
        sb.append("premium_feature_list,");
        sb.append("file_upload_size_limit,");
        sb.append("application_attributes,");
        sb.append(StringSet.emoji_hash);
        Logger.i("additionalData : " + sb.toString(), new Object[0]);
        return sb.toString();
    }

    static String makeExUserAgentString() {
        StringBuilder sb = new StringBuilder(StringSet.Android);
        sb.append("/");
        sb.append(a.Core.getValue(BuildConfig.VERSION_NAME));
        for (a next : exUserAgent.keySet()) {
            sb.append("/");
            sb.append(next.getValue(exUserAgent.get(next)));
        }
        return sb.toString();
    }

    static int getMaxUnreadMessageCountOnSuperGroup() {
        return Connection.a().f44846i;
    }

    public static class Options {
        static int authenticationTimeout = 10;
        static int connectionTimeout = 10;
        static Handler mHandlerForThreadOption = null;
        static ThreadOption mThreadOption = ThreadOption.UI_THREAD;
        static int typingIndicatorThrottle = 1000;
        static boolean useMemberAsMessageSender = true;
        static int wsResponseTimeoutSec = 10;

        public enum ThreadOption {
            UI_THREAD,
            NEW_THREAD,
            HANDLER
        }

        static void init() {
            useMemberAsMessageSender = true;
            mThreadOption = ThreadOption.UI_THREAD;
            connectionTimeout = 10;
            authenticationTimeout = 10;
            typingIndicatorThrottle = 1000;
        }

        public static void useMemberAsMessageSender(boolean z) {
            useMemberAsMessageSender = z;
        }

        @Deprecated
        public static void useUiThreadForCallbacks(boolean z) {
            if (z) {
                mThreadOption = ThreadOption.UI_THREAD;
            } else {
                mThreadOption = ThreadOption.NEW_THREAD;
            }
        }

        @Deprecated
        public static void setHandlerForCallbacks(Handler handler) {
            if (handler != null) {
                mThreadOption = ThreadOption.HANDLER;
                mHandlerForThreadOption = handler;
                return;
            }
            mThreadOption = ThreadOption.UI_THREAD;
        }

        public static void setThreadOption(ThreadOption threadOption, Handler handler) {
            if (threadOption != null) {
                mThreadOption = threadOption;
                if (threadOption == ThreadOption.HANDLER) {
                    mHandlerForThreadOption = handler;
                }
            }
        }

        public static void setConnectionTimeout(int i2) {
            if (i2 > 0) {
                connectionTimeout = i2;
            } else {
                connectionTimeout = 10;
            }
        }

        public static void setAuthenticationTimeout(int i2) {
            if (i2 > 0) {
                authenticationTimeout = i2;
            } else {
                authenticationTimeout = 10;
            }
        }

        public static void setTypingIndicatorThrottle(int i2) {
            if (i2 >= 1000 && i2 <= 9000) {
                typingIndicatorThrottle = i2;
            }
        }

        public static void setWebSocketResponseTimeout(int i2) {
            if (i2 < 5) {
                i2 = 5;
            } else if (i2 > 300) {
                i2 = 300;
            }
            wsResponseTimeoutSec = i2;
        }
    }

    public static void runOnUIThread(final Runnable runnable) {
        if (runnable != null) {
            int i2 = AnonymousClass39.f44605a[Options.mThreadOption.ordinal()];
            if (i2 == 1) {
                new Thread() {
                    public final void run() {
                        Runnable runnable = runnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                }.start();
            } else if (i2 != 2) {
                Handler handler = sUIThreadHandler;
                if (handler != null) {
                    handler.post(runnable);
                }
            } else if (Options.mHandlerForThreadOption != null) {
                Options.mHandlerForThreadOption.post(runnable);
            }
        }
    }

    public static String getOSVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getApplicationId() {
        return getInstance().mAppId;
    }

    private boolean setNewApplicationId(String str) {
        if (getConnectionState() != ConnectionState.CLOSED) {
            return false;
        }
        setAppId(str);
        return true;
    }

    public static void setLoggerLevel(int i2) {
        Logger.setLoggerLevel(i2);
    }

    private void setAppId(String str) {
        this.mAppId = str;
    }

    private SendBird(String str, Context context) {
        setAppId(str);
        this.mAppContext = context;
        if (context != null) {
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            context.registerReceiver(new b(this, (byte) 0), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        initConscrypt();
    }

    private static void initConscrypt() {
        try {
            Security.insertProviderAt(Conscrypt.newProvider(), 1);
        } catch (NoClassDefFoundError e2) {
            System.out.println("[SendBird] To enable TLS 1.3, do not exclude conscrypt from your build.gradle");
            e2.printStackTrace();
        } catch (Throwable th) {
            System.out.println("[SendBird] TLS 1.3 might be disabled for some unknown reason.");
            th.printStackTrace();
        }
    }

    protected static SendBird getInstance() {
        SendBird sendBird = sInstance;
        if (sendBird != null) {
            return sendBird;
        }
        Logger.e("SendBird instance hasn't been initialized. Try SendBird.init().");
        throw new RuntimeException("SendBird instance hasn't been initialized.");
    }

    protected static synchronized boolean isInitialized() {
        boolean z;
        synchronized (SendBird.class) {
            z = sInstance != null;
        }
        return z;
    }

    public static synchronized boolean init(String str, Context context) {
        boolean z;
        synchronized (SendBird.class) {
            if (sInstance == null) {
                sInstance = new SendBird(str, context.getApplicationContext());
                APIClient.a(context.getApplicationContext());
                if (sInstance.mAppContext instanceof Application) {
                    ((Application) sInstance.mAppContext).registerActivityLifecycleCallbacks(sInstance.applicationHandler);
                }
                z = true;
            } else if (str != null && str.length() > 0 && getApplicationId() != null && str.equals(getApplicationId())) {
                return true;
            } else {
                z = sInstance.setNewApplicationId(str);
                u.a().a(true, (DisconnectHandler) null);
            }
            sInstance.mIsTrackingApplicationState = true;
            sInstance.mIsNetworkAwarenessReconnection = true;
            return z;
        }
    }

    public static synchronized boolean initFromForeground(String str, Context context) {
        boolean init;
        synchronized (SendBird.class) {
            init = init(str, context);
            getInstance().applicationHandler.a();
        }
        return init;
    }

    static boolean isAppBackground() {
        SendBird sendBird = sInstance;
        return sendBird != null && sendBird.mIsAppBackground;
    }

    /* access modifiers changed from: package-private */
    public final int isActive() {
        return this.mIsAppBackground ? 0 : 1;
    }

    public static void setAutoBackgroundDetection(boolean z) {
        getInstance().mIsTrackingApplicationState = z;
    }

    public static boolean getAutoBackgroundDetection() {
        return getInstance().mIsTrackingApplicationState;
    }

    public static void setNetworkAwarenessReconnection(boolean z) {
        getInstance().mIsNetworkAwarenessReconnection = z;
    }

    public static boolean getNetworkAwarenessReconnection() {
        return getInstance().mIsNetworkAwarenessReconnection;
    }

    public static ConnectionState getConnectionState() {
        if (!isInitialized()) {
            return ConnectionState.CLOSED;
        }
        return u.a().c();
    }

    public static void connect(String str, ConnectHandler connectHandler) {
        _connect(str, (String) null, (String) null, (String) null, connectHandler);
    }

    public static void connect(String str, String str2, ConnectHandler connectHandler) {
        _connect(str, str2, (String) null, (String) null, connectHandler);
    }

    public static void connect(String str, String str2, String str3, String str4, ConnectHandler connectHandler) {
        _connect(str, str2, str3, str4, connectHandler);
    }

    private static void _connect(String str, String str2, String str3, String str4, ConnectHandler connectHandler) {
        u.a().a(str, str2, str3, str4, connectHandler);
    }

    public static synchronized boolean reconnect() {
        boolean a2;
        synchronized (SendBird.class) {
            a2 = u.a().a(false);
        }
        return a2;
    }

    public static void addChannelHandler(String str, ChannelHandler channelHandler) {
        if (str != null && str.length() != 0 && channelHandler != null) {
            k a2 = k.a.f44826a;
            if (str != null && str.length() != 0 && channelHandler != null) {
                a2.f44724a.put(str, channelHandler);
            }
        }
    }

    public static ChannelHandler removeChannelHandler(String str) {
        if (!(str == null || str.length() == 0)) {
            k a2 = k.a.f44826a;
            if (!(str == null || str.length() == 0)) {
                return a2.f44724a.remove(str);
            }
        }
        return null;
    }

    public static void addUserEventHandler(String str, UserEventHandler userEventHandler) {
        if (str != null && str.length() != 0 && userEventHandler != null) {
            getInstance().mUserEventHandlers.put(str, userEventHandler);
        }
    }

    public static UserEventHandler removeUserEventHandler(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return getInstance().mUserEventHandlers.remove(str);
    }

    public static void removeAllUserEventHandlers() {
        getInstance().mUserEventHandlers.clear();
    }

    public static void addConnectionHandler(String str, ConnectionHandler connectionHandler) {
        if (str != null && str.length() != 0 && connectionHandler != null) {
            u a2 = u.a();
            if (str != null && str.length() != 0 && connectionHandler != null) {
                a2.f45288e.put(str, connectionHandler);
            }
        }
    }

    public static ConnectionHandler removeConnectionHandler(String str) {
        if (!(str == null || str.length() == 0)) {
            u a2 = u.a();
            if (!(str == null || str.length() == 0)) {
                return a2.f45288e.remove(str);
            }
        }
        return null;
    }

    public static void removeAllConnectionHandlers() {
        u.a().f45288e.clear();
    }

    public static void disconnect(DisconnectHandler disconnectHandler) {
        u.a().a(true, disconnectHandler);
    }

    public static AppInfo getAppInfo() {
        return Connection.b();
    }

    public static User getCurrentUser() {
        return getInstance().mCurrentUser;
    }

    static void setCurrentUser(User user) {
        getInstance().mCurrentUser = user;
    }

    public static long getLastConnectedAt() {
        if (getConnectionState() == ConnectionState.OPEN) {
            return Connection.a().f44844g;
        }
        return 0;
    }

    @Deprecated
    public static UserListQuery createUserListQuery() {
        return new UserListQuery(UserListQuery.a.ALL_USER);
    }

    @Deprecated
    public static UserListQuery createUserListQuery(List<String> list) {
        return new UserListQuery(UserListQuery.a.FILTERED_USER, list);
    }

    public static ApplicationUserListQuery createApplicationUserListQuery() {
        return new ApplicationUserListQuery();
    }

    public static BlockedUserListQuery createBlockedUserListQuery() {
        return new BlockedUserListQuery();
    }

    public static void updateCurrentUserInfoWithProfileImage(String str, File file, UserInfoUpdateHandler userInfoUpdateHandler) {
        updateCurrentUserInfoWithProfileImage(str, file, (List<String>) null, userInfoUpdateHandler);
    }

    private static void updateCurrentUserInfoWithProfileImage(final String str, final File file, final List<String> list, final UserInfoUpdateHandler userInfoUpdateHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                UserInfoUpdateHandler userInfoUpdateHandler = userInfoUpdateHandler;
                if (userInfoUpdateHandler != null) {
                    userInfoUpdateHandler.onUpdated(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String str = str;
                File file = file;
                List<String> list = list;
                if (SendBird.getCurrentUser() != null) {
                    HashMap hashMap = new HashMap();
                    String str2 = null;
                    if (str != null) {
                        hashMap.put("nickname", str);
                    }
                    if (file != null) {
                        str2 = "profile_file";
                    }
                    if (list != null) {
                        StringBuilder sb = new StringBuilder();
                        String str3 = "";
                        for (String append : list) {
                            sb.append(str3);
                            sb.append(append);
                            str3 = AppConstants.COMMA;
                        }
                        hashMap.put("discovery_keys", sb.toString());
                    }
                    JsonElement b2 = a2.b(String.format(b.USERS_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), hashMap, str2, file);
                    JsonObject asJsonObject = b2.getAsJsonObject();
                    User currentUser = SendBird.getCurrentUser();
                    if (asJsonObject.has("nickname")) {
                        currentUser.setNickname(asJsonObject.get("nickname").getAsString());
                    }
                    if (asJsonObject.has("profile_url")) {
                        currentUser.setProfileUrl(asJsonObject.get("profile_url").getAsString());
                    }
                    if (asJsonObject.has(StringSet.require_auth_for_profile_image)) {
                        currentUser.setRequireAuth(asJsonObject.get(StringSet.require_auth_for_profile_image).getAsBoolean());
                    }
                    return b2;
                }
                throw u.b();
            }
        });
    }

    public static void updateCurrentUserInfo(String str, String str2, UserInfoUpdateHandler userInfoUpdateHandler) {
        updateCurrentUserInfo(str, str2, (List<String>) null, (List<String>) null, userInfoUpdateHandler);
    }

    public static void updateCurrentUserInfo(List<String> list, final UserInfoUpdateHandler userInfoUpdateHandler) {
        if (list != null) {
            updateCurrentUserInfo((String) null, (String) null, (List<String>) null, list, userInfoUpdateHandler);
        } else if (userInfoUpdateHandler != null) {
            runOnUIThread(new Runnable() {
                public final void run() {
                    userInfoUpdateHandler.onUpdated(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    private static void updateCurrentUserInfo(String str, String str2, List<String> list, List<String> list2, UserInfoUpdateHandler userInfoUpdateHandler) {
        final String str3 = str;
        final String str4 = str2;
        final List<String> list3 = list;
        final List<String> list4 = list2;
        final UserInfoUpdateHandler userInfoUpdateHandler2 = userInfoUpdateHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                UserInfoUpdateHandler userInfoUpdateHandler = userInfoUpdateHandler2;
                if (userInfoUpdateHandler != null) {
                    userInfoUpdateHandler.onUpdated(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String str = str3;
                String str2 = str4;
                List<String> list = list3;
                List<String> list2 = list4;
                if (SendBird.getCurrentUser() != null) {
                    JsonObject e2 = APIClient.e();
                    if (str != null) {
                        e2.addProperty("nickname", str);
                    }
                    if (str2 != null) {
                        e2.addProperty("profile_url", str2);
                    }
                    if (list != null) {
                        JsonArray jsonArray = new JsonArray();
                        for (String add : list) {
                            jsonArray.add(add);
                        }
                        e2.add("discovery_keys", jsonArray);
                    }
                    if (list2 != null) {
                        JsonArray jsonArray2 = new JsonArray();
                        for (String add2 : list2) {
                            jsonArray2.add(add2);
                        }
                        e2.add("preferred_languages", jsonArray2);
                    }
                    JsonElement b2 = a2.b(String.format(b.USERS_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), e2);
                    JsonObject asJsonObject = b2.getAsJsonObject();
                    User currentUser = SendBird.getCurrentUser();
                    if (asJsonObject.has("nickname")) {
                        currentUser.setNickname(asJsonObject.get("nickname").getAsString());
                    }
                    if (asJsonObject.has("profile_url")) {
                        currentUser.setProfileUrl(asJsonObject.get("profile_url").getAsString());
                    }
                    currentUser.parsePreferredLanguages(asJsonObject);
                    return b2;
                }
                throw u.b();
            }
        });
    }

    public static String getPendingPushToken() {
        return getInstance().mPushToken;
    }

    @Deprecated
    public static void registerPushTokenForCurrentUser(final String str, final RegisterPushTokenHandler registerPushTokenHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                RegisterPushTokenHandler registerPushTokenHandler = registerPushTokenHandler;
                if (registerPushTokenHandler != null) {
                    registerPushTokenHandler.onRegistered(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    return APIClient.a().a(PushTokenType.GCM, str, false, false, false);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void registerPushTokenForCurrentUser(String str, RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
        registerPushTokenForCurrentUser(str, false, registerPushTokenWithStatusHandler);
    }

    public static void registerPushTokenForCurrentUser(String str, boolean z, RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
        registerPushTokenForCurrentUser(PushTokenType.GCM, str, z, false, false, registerPushTokenWithStatusHandler);
    }

    static void registerPushTokenForCurrentUserInternal(PushTokenType pushTokenType, String str, boolean z, boolean z2, RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
        registerPushTokenForCurrentUser(pushTokenType, str, z, z2, true, registerPushTokenWithStatusHandler);
    }

    static void registerPushTokenForCurrentUser(PushTokenType pushTokenType, String str, boolean z, boolean z2, boolean z3, RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
        final String str2 = str;
        final PushTokenType pushTokenType2 = pushTokenType;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler2 = registerPushTokenWithStatusHandler;
        d.a(new q<PushTokenRegistrationStatus>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                PushTokenRegistrationStatus pushTokenRegistrationStatus = (PushTokenRegistrationStatus) obj;
                RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler = registerPushTokenWithStatusHandler2;
                if (registerPushTokenWithStatusHandler != null) {
                    registerPushTokenWithStatusHandler.onRegistered(pushTokenRegistrationStatus, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str2 == null) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                } else if (SendBird.getCurrentUser() == null) {
                    String unused = SendBird.getInstance().mPushToken = str2;
                    return PushTokenRegistrationStatus.PENDING;
                } else {
                    APIClient.a().a(pushTokenType2, str2, z4, z5, z6);
                    String unused2 = SendBird.getInstance().mPushToken = null;
                    return PushTokenRegistrationStatus.SUCCESS;
                }
            }
        });
    }

    public static void unregisterPushTokenForCurrentUser(String str, UnregisterPushTokenHandler unregisterPushTokenHandler) {
        unregisterPushTokenForCurrentUser(PushTokenType.GCM, str, unregisterPushTokenHandler);
    }

    static void unregisterPushTokenForCurrentUser(final PushTokenType pushTokenType, final String str, final UnregisterPushTokenHandler unregisterPushTokenHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                UnregisterPushTokenHandler unregisterPushTokenHandler = unregisterPushTokenHandler;
                if (unregisterPushTokenHandler != null) {
                    unregisterPushTokenHandler.onUnregistered(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    PushTokenType pushTokenType = pushTokenType;
                    String str = str;
                    if (SendBird.getCurrentUser() != null) {
                        return a2.a(String.format(b.USERS_USERID_PUSH_UNREGISTER.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), pushTokenType.getValue(), b.urlEncodeUTF8(str)}), (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void unregisterPushTokenAllForCurrentUser(final UnregisterPushTokenHandler unregisterPushTokenHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                UnregisterPushTokenHandler unregisterPushTokenHandler = unregisterPushTokenHandler;
                if (unregisterPushTokenHandler != null) {
                    unregisterPushTokenHandler.onUnregistered(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                return APIClient.a().f();
            }
        });
    }

    public enum PushTokenType {
        GCM(StringSet.gcm),
        APNS(StringSet.apns),
        APNS_VOIP(StringSet.apns_voip),
        HMS("huawei");
        
        private String value;

        private PushTokenType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        public static PushTokenType from(String str) {
            for (PushTokenType pushTokenType : values()) {
                if (pushTokenType.value.equalsIgnoreCase(str)) {
                    return pushTokenType;
                }
            }
            return GCM;
        }
    }

    public static void getMyPushTokensByToken(String str, PushTokenType pushTokenType, GetPushTokensHandler getPushTokensHandler) {
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final AtomicReference atomicReference3 = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final PushTokenType pushTokenType2 = pushTokenType;
        final String str2 = str;
        final GetPushTokensHandler getPushTokensHandler2 = getPushTokensHandler;
        d.a(new q<Boolean>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                GetPushTokensHandler getPushTokensHandler = getPushTokensHandler2;
                if (getPushTokensHandler == null) {
                    return;
                }
                if (sendBirdException != null) {
                    getPushTokensHandler.onResult((List<String>) null, (PushTokenType) null, false, (String) null, sendBirdException);
                } else {
                    getPushTokensHandler.onResult((List) atomicReference.get(), (PushTokenType) atomicReference2.get(), atomicBoolean.get(), (String) atomicReference3.get(), (SendBirdException) null);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (pushTokenType2 != null) {
                    APIClient a2 = APIClient.a();
                    String str = str2;
                    PushTokenType pushTokenType = pushTokenType2;
                    if (SendBird.getCurrentUser() != null) {
                        boolean z = true;
                        String format = String.format(b.USERS_USERID_PUSH_TOKENTYPE_DEVICETOKENS.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), pushTokenType.getValue()});
                        HashMap hashMap = new HashMap();
                        if (str != null) {
                            hashMap.put(StringSet.token, str);
                        }
                        JsonObject asJsonObject = a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject();
                        atomicReference2.set(asJsonObject.has("type") ? PushTokenType.from(asJsonObject.get("type").getAsString()) : PushTokenType.GCM);
                        atomicReference3.set(asJsonObject.has(StringSet.token) ? asJsonObject.get(StringSet.token).getAsString() : "");
                        AtomicBoolean atomicBoolean = atomicBoolean;
                        if (!asJsonObject.has(StringSet.has_more) || !asJsonObject.get(StringSet.has_more).getAsBoolean()) {
                            z = false;
                        }
                        atomicBoolean.set(z);
                        ArrayList arrayList = new ArrayList();
                        JsonArray asJsonArray = asJsonObject.get(StringSet.device_tokens).getAsJsonArray();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            arrayList.add(asJsonArray.get(i2).getAsString());
                        }
                        atomicReference.set(arrayList);
                        return Boolean.TRUE;
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void setDoNotDisturb(boolean z, int i2, int i3, int i4, int i5, String str, SetDoNotDisturbHandler setDoNotDisturbHandler) {
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        final int i9 = i5;
        final boolean z2 = z;
        final String str2 = str;
        final SetDoNotDisturbHandler setDoNotDisturbHandler2 = setDoNotDisturbHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                SetDoNotDisturbHandler setDoNotDisturbHandler = setDoNotDisturbHandler2;
                if (setDoNotDisturbHandler != null) {
                    setDoNotDisturbHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                int i2;
                int i3;
                int i4;
                int i5 = i6;
                if (i5 < 0 || i5 > 23 || (i2 = i7) < 0 || i2 > 59 || (i3 = i8) < 0 || i3 > 23 || (i4 = i9) < 0 || i4 > 59) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                boolean z = z2;
                int i6 = i6;
                int i7 = i7;
                int i8 = i8;
                int i9 = i9;
                String str = str2;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_PUSHPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty(StringSet.do_not_disturb, Boolean.valueOf(z));
                    e2.addProperty(StringSet.start_hour, (Number) Integer.valueOf(i6));
                    e2.addProperty(StringSet.start_min, (Number) Integer.valueOf(i7));
                    e2.addProperty(StringSet.end_hour, (Number) Integer.valueOf(i8));
                    e2.addProperty(StringSet.end_min, (Number) Integer.valueOf(i9));
                    e2.addProperty(StringSet.timezone, str);
                    return a2.b(format, e2);
                }
                throw u.b();
            }
        });
    }

    public static void getDoNotDisturb(final GetDoNotDisturbHandler getDoNotDisturbHandler) {
        d.a(new s<Boolean>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    APIClient a2 = APIClient.a();
                    if (SendBird.getCurrentUser() != null) {
                        JsonObject asJsonObject = a2.a(String.format(b.USERS_USERID_PUSHPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), (Map<String, String>) null, (Map<String, Collection<String>>) null).getAsJsonObject();
                        final boolean asBoolean = asJsonObject.get(StringSet.do_not_disturb).getAsBoolean();
                        final int asInt = asJsonObject.get(StringSet.start_hour).getAsInt();
                        final int asInt2 = asJsonObject.get(StringSet.start_min).getAsInt();
                        final int asInt3 = asJsonObject.get(StringSet.end_hour).getAsInt();
                        final int asInt4 = asJsonObject.get(StringSet.end_min).getAsInt();
                        final String asString = asJsonObject.get(StringSet.timezone).getAsString();
                        if (getDoNotDisturbHandler != null) {
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    getDoNotDisturbHandler.onResult(asBoolean, asInt, asInt2, asInt3, asInt4, asString, (SendBirdException) null);
                                }
                            });
                        }
                        return Boolean.TRUE;
                    }
                    throw u.b();
                } catch (SendBirdException e2) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            getDoNotDisturbHandler.onResult(false, 0, 0, 0, 0, (String) null, e2);
                        }
                    });
                }
            }
        });
    }

    public static void setSnoozePeriod(boolean z, long j, long j2, SetSnoozePeriodHandler setSnoozePeriodHandler) {
        final long j3 = j;
        final long j4 = j2;
        final boolean z2 = z;
        final SetSnoozePeriodHandler setSnoozePeriodHandler2 = setSnoozePeriodHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                SetSnoozePeriodHandler setSnoozePeriodHandler = setSnoozePeriodHandler2;
                if (setSnoozePeriodHandler != null) {
                    setSnoozePeriodHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (j3 < j4) {
                    APIClient a2 = APIClient.a();
                    boolean z = z2;
                    long j = j3;
                    long j2 = j4;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_PUSHPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        JsonObject e2 = APIClient.e();
                        e2.addProperty(StringSet.snooze_enabled, Boolean.valueOf(z));
                        e2.addProperty(StringSet.snooze_start_ts, (Number) Long.valueOf(j));
                        e2.addProperty(StringSet.snooze_end_ts, (Number) Long.valueOf(j2));
                        return a2.b(format, e2);
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void getSnoozePeriod(final GetSnoozePeriodHandler getSnoozePeriodHandler) {
        d.a(new s<Boolean>() {
            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0074 A[Catch:{ SendBirdException -> 0x00ba }] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0076 A[Catch:{ SendBirdException -> 0x00ba }] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[Catch:{ SendBirdException -> 0x00ba }] */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0083 A[Catch:{ SendBirdException -> 0x00ba }] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2 A[Catch:{ SendBirdException -> 0x00ba }] */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4 A[Catch:{ SendBirdException -> 0x00ba }] */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9 A[Catch:{ SendBirdException -> 0x00ba }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Boolean call() {
                /*
                    r13 = this;
                    java.lang.String r0 = "snooze_enabled"
                    java.lang.String r1 = "snooze_end_ts"
                    java.lang.String r2 = "snooze_start_ts"
                    com.sendbird.android.APIClient r3 = com.sendbird.android.APIClient.a()     // Catch:{ SendBirdException -> 0x00ba }
                    com.sendbird.android.User r4 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ SendBirdException -> 0x00ba }
                    if (r4 == 0) goto L_0x00b5
                    com.sendbird.android.b r4 = com.sendbird.android.b.USERS_USERID_PUSHPREFERENCE     // Catch:{ SendBirdException -> 0x00ba }
                    java.lang.String r4 = r4.publicUrl()     // Catch:{ SendBirdException -> 0x00ba }
                    r5 = 1
                    java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ SendBirdException -> 0x00ba }
                    com.sendbird.android.User r7 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ SendBirdException -> 0x00ba }
                    java.lang.String r7 = r7.getUserId()     // Catch:{ SendBirdException -> 0x00ba }
                    java.lang.String r7 = com.sendbird.android.b.urlEncodeUTF8((java.lang.String) r7)     // Catch:{ SendBirdException -> 0x00ba }
                    r8 = 0
                    r6[r8] = r7     // Catch:{ SendBirdException -> 0x00ba }
                    java.lang.String r4 = java.lang.String.format(r4, r6)     // Catch:{ SendBirdException -> 0x00ba }
                    r6 = 0
                    com.sendbird.android.shadow.com.google.gson.JsonElement r3 = r3.a((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.String>) r6, (java.util.Map<java.lang.String, java.util.Collection<java.lang.String>>) r6)     // Catch:{ SendBirdException -> 0x00ba }
                    com.sendbird.android.shadow.com.google.gson.JsonObject r3 = r3.getAsJsonObject()     // Catch:{ SendBirdException -> 0x00ba }
                    boolean r4 = r3.has(r2)     // Catch:{ SendBirdException -> 0x00ba }
                    java.lang.String r6 = ""
                    if (r4 == 0) goto L_0x0053
                    com.sendbird.android.shadow.com.google.gson.JsonElement r4 = r3.get(r2)     // Catch:{ SendBirdException -> 0x00ba }
                    boolean r4 = r4.isJsonNull()     // Catch:{ SendBirdException -> 0x00ba }
                    if (r4 != 0) goto L_0x0053
                    com.sendbird.android.shadow.com.google.gson.JsonElement r2 = r3.get(r2)     // Catch:{ SendBirdException -> 0x00ba }
                    java.lang.String r2 = r2.getAsString()     // Catch:{ SendBirdException -> 0x00ba }
                    goto L_0x0054
                L_0x0053:
                    r2 = r6
                L_0x0054:
                    boolean r4 = r3.has(r1)     // Catch:{ SendBirdException -> 0x00ba }
                    if (r4 == 0) goto L_0x006c
                    com.sendbird.android.shadow.com.google.gson.JsonElement r4 = r3.get(r1)     // Catch:{ SendBirdException -> 0x00ba }
                    boolean r4 = r4.isJsonNull()     // Catch:{ SendBirdException -> 0x00ba }
                    if (r4 != 0) goto L_0x006c
                    com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r3.get(r1)     // Catch:{ SendBirdException -> 0x00ba }
                    java.lang.String r6 = r1.getAsString()     // Catch:{ SendBirdException -> 0x00ba }
                L_0x006c:
                    boolean r1 = r2.isEmpty()     // Catch:{ SendBirdException -> 0x00ba }
                    r9 = 0
                    if (r1 == 0) goto L_0x0076
                    r11 = r9
                    goto L_0x007b
                L_0x0076:
                    long r1 = java.lang.Long.parseLong(r2)     // Catch:{ SendBirdException -> 0x00ba }
                    r11 = r1
                L_0x007b:
                    boolean r1 = r6.isEmpty()     // Catch:{ SendBirdException -> 0x00ba }
                    if (r1 == 0) goto L_0x0083
                    r6 = r9
                    goto L_0x0088
                L_0x0083:
                    long r1 = java.lang.Long.parseLong(r6)     // Catch:{ SendBirdException -> 0x00ba }
                    r6 = r1
                L_0x0088:
                    boolean r1 = r3.has(r0)     // Catch:{ SendBirdException -> 0x00ba }
                    if (r1 == 0) goto L_0x00a4
                    com.sendbird.android.shadow.com.google.gson.JsonElement r1 = r3.get(r0)     // Catch:{ SendBirdException -> 0x00ba }
                    boolean r1 = r1.isJsonNull()     // Catch:{ SendBirdException -> 0x00ba }
                    if (r1 != 0) goto L_0x00a4
                    com.sendbird.android.shadow.com.google.gson.JsonElement r0 = r3.get(r0)     // Catch:{ SendBirdException -> 0x00ba }
                    boolean r0 = r0.getAsBoolean()     // Catch:{ SendBirdException -> 0x00ba }
                    if (r0 == 0) goto L_0x00a4
                    r3 = 1
                    goto L_0x00a5
                L_0x00a4:
                    r3 = 0
                L_0x00a5:
                    com.sendbird.android.SendBird$GetSnoozePeriodHandler r0 = r1     // Catch:{ SendBirdException -> 0x00ba }
                    if (r0 == 0) goto L_0x00c7
                    com.sendbird.android.SendBird$5$1 r0 = new com.sendbird.android.SendBird$5$1     // Catch:{ SendBirdException -> 0x00ba }
                    r1 = r0
                    r2 = r13
                    r4 = r11
                    r1.<init>(r3, r4, r6)     // Catch:{ SendBirdException -> 0x00ba }
                    com.sendbird.android.SendBird.runOnUIThread(r0)     // Catch:{ SendBirdException -> 0x00ba }
                    goto L_0x00c7
                L_0x00b5:
                    com.sendbird.android.SendBirdException r0 = com.sendbird.android.u.b()     // Catch:{ SendBirdException -> 0x00ba }
                    throw r0     // Catch:{ SendBirdException -> 0x00ba }
                L_0x00ba:
                    r0 = move-exception
                    com.sendbird.android.SendBird$GetSnoozePeriodHandler r1 = r1
                    if (r1 == 0) goto L_0x00c7
                    com.sendbird.android.SendBird$5$2 r1 = new com.sendbird.android.SendBird$5$2
                    r1.<init>(r0)
                    com.sendbird.android.SendBird.runOnUIThread(r1)
                L_0x00c7:
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBird.AnonymousClass5.call():java.lang.Boolean");
            }
        });
    }

    public static void setPushSound(final String str, final SetPushSoundHandler setPushSoundHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                SetPushSoundHandler setPushSoundHandler = setPushSoundHandler;
                if (setPushSoundHandler != null) {
                    setPushSoundHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    String str = str;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_PUSHPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        JsonObject e2 = APIClient.e();
                        e2.addProperty(StringSet.push_sound, str);
                        return a2.b(format, e2);
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void getPushSound(final GetPushSoundHandler getPushSoundHandler) {
        d.a(new q<String>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                String str = (String) obj;
                GetPushSoundHandler getPushSoundHandler = getPushSoundHandler;
                if (getPushSoundHandler != null) {
                    getPushSoundHandler.onResult(str, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                if (SendBird.getCurrentUser() != null) {
                    JsonObject asJsonObject = a2.a(String.format(b.USERS_USERID_PUSHPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), (Map<String, String>) null, (Map<String, Collection<String>>) null).getAsJsonObject();
                    return (!asJsonObject.has(StringSet.push_sound) || asJsonObject.get(StringSet.push_sound).isJsonNull()) ? "" : asJsonObject.get(StringSet.push_sound).getAsString();
                }
                throw u.b();
            }
        });
    }

    public static void setPushTemplate(final String str, final SetPushTemplateHandler setPushTemplateHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                SetPushTemplateHandler setPushTemplateHandler = setPushTemplateHandler;
                if (setPushTemplateHandler != null) {
                    setPushTemplateHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    String str = str;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_PUSH_TEMPLATE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        JsonObject e2 = APIClient.e();
                        e2.addProperty("name", str);
                        return a2.b(format, e2);
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void getPushTemplate(final GetPushTemplateHandler getPushTemplateHandler) {
        d.a(new q<String>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                String str = (String) obj;
                GetPushTemplateHandler getPushTemplateHandler = getPushTemplateHandler;
                if (getPushTemplateHandler != null) {
                    getPushTemplateHandler.onResult(str, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                if (SendBird.getCurrentUser() != null) {
                    return a2.a(String.format(b.USERS_USERID_PUSH_TEMPLATE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), (Map<String, String>) null, (Map<String, Collection<String>>) null).getAsJsonObject().get("name").getAsString();
                }
                throw u.b();
            }
        });
    }

    public enum PushTriggerOption {
        ALL(StringSet.all),
        OFF(StringSet.off),
        MENTION_ONLY(StringSet.mention_only);
        
        private String value;

        private PushTriggerOption(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        public static PushTriggerOption from(String str) {
            for (PushTriggerOption pushTriggerOption : values()) {
                if (pushTriggerOption.getValue().equalsIgnoreCase(str)) {
                    return pushTriggerOption;
                }
            }
            return ALL;
        }
    }

    public static void setPushTriggerOption(final PushTriggerOption pushTriggerOption, final SetPushTriggerOptionHandler setPushTriggerOptionHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                SetPushTriggerOptionHandler setPushTriggerOptionHandler = setPushTriggerOptionHandler;
                if (setPushTriggerOptionHandler != null) {
                    setPushTriggerOptionHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                PushTriggerOption pushTriggerOption = pushTriggerOption;
                if (SendBird.getCurrentUser() != null) {
                    JsonObject e2 = APIClient.e();
                    e2.addProperty(StringSet.push_trigger_option, pushTriggerOption.getValue());
                    return a2.b(String.format(b.USERS_USERID_PUSHPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), e2);
                }
                throw u.b();
            }
        });
    }

    public static void getPushTriggerOption(final GetPushTriggerOptionHandler getPushTriggerOptionHandler) {
        d.a(new q<PushTriggerOption>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                PushTriggerOption pushTriggerOption = (PushTriggerOption) obj;
                GetPushTriggerOptionHandler getPushTriggerOptionHandler = getPushTriggerOptionHandler;
                if (getPushTriggerOptionHandler != null) {
                    getPushTriggerOptionHandler.onResult(pushTriggerOption, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                if (SendBird.getCurrentUser() != null) {
                    JsonObject asJsonObject = a2.a(String.format(b.USERS_USERID_PUSHPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), (Map<String, String>) null, (Map<String, Collection<String>>) null).getAsJsonObject();
                    return asJsonObject.has(StringSet.push_trigger_option) ? PushTriggerOption.from(asJsonObject.get(StringSet.push_trigger_option).getAsString()) : PushTriggerOption.ALL;
                }
                throw u.b();
            }
        });
    }

    public static class HMS {
        public static String getPendingPushToken() {
            return SendBird.getInstance().mPushToken;
        }

        public static void registerPushTokenForCurrentUser(String str, RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
            registerPushTokenForCurrentUser(str, false, registerPushTokenWithStatusHandler);
        }

        public static void registerPushTokenForCurrentUser(String str, boolean z, RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
            SendBird.registerPushTokenForCurrentUser(PushTokenType.HMS, str, z, false, false, registerPushTokenWithStatusHandler);
        }

        public static void unregisterPushTokenForCurrentUser(String str, UnregisterPushTokenHandler unregisterPushTokenHandler) {
            SendBird.unregisterPushTokenForCurrentUser(PushTokenType.HMS, str, unregisterPushTokenHandler);
        }

        public static void unregisterPushTokenAllForCurrentUser(UnregisterPushTokenHandler unregisterPushTokenHandler) {
            SendBird.unregisterPushTokenAllForCurrentUser(unregisterPushTokenHandler);
        }

        public static void getMyPushTokensByToken(String str, PushTokenType pushTokenType, GetPushTokensHandler getPushTokensHandler) {
            SendBird.getMyPushTokensByToken(str, pushTokenType, getPushTokensHandler);
        }

        public static void setDoNotDisturb(boolean z, int i2, int i3, int i4, int i5, String str, SetDoNotDisturbHandler setDoNotDisturbHandler) {
            SendBird.setDoNotDisturb(z, i2, i3, i4, i5, str, setDoNotDisturbHandler);
        }

        public static void getDoNotDisturb(GetDoNotDisturbHandler getDoNotDisturbHandler) {
            SendBird.getDoNotDisturb(getDoNotDisturbHandler);
        }

        public static void setSnoozePeriod(boolean z, long j, long j2, SetSnoozePeriodHandler setSnoozePeriodHandler) {
            SendBird.setSnoozePeriod(z, j, j2, setSnoozePeriodHandler);
        }

        public static void getSnoozePeriod(GetSnoozePeriodHandler getSnoozePeriodHandler) {
            SendBird.getSnoozePeriod(getSnoozePeriodHandler);
        }

        public static void setPushSound(String str, SetPushSoundHandler setPushSoundHandler) {
            SendBird.setPushSound(str, setPushSoundHandler);
        }

        public static void getPushSound(GetPushSoundHandler getPushSoundHandler) {
            SendBird.getPushSound(getPushSoundHandler);
        }

        public static void setPushTemplate(String str, SetPushTemplateHandler setPushTemplateHandler) {
            SendBird.setPushTemplate(str, setPushTemplateHandler);
        }

        public static void getPushTemplate(GetPushTemplateHandler getPushTemplateHandler) {
            SendBird.getPushTemplate(getPushTemplateHandler);
        }

        public static void setPushTriggerOption(PushTriggerOption pushTriggerOption, SetPushTriggerOptionHandler setPushTriggerOptionHandler) {
            SendBird.setPushTriggerOption(pushTriggerOption, setPushTriggerOptionHandler);
        }

        public static void getPushTriggerOption(GetPushTriggerOptionHandler getPushTriggerOptionHandler) {
            SendBird.getPushTriggerOption(getPushTriggerOptionHandler);
        }
    }

    public static void setChannelInvitationPreference(final boolean z, final SetChannelInvitationPreferenceHandler setChannelInvitationPreferenceHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                SetChannelInvitationPreferenceHandler setChannelInvitationPreferenceHandler = setChannelInvitationPreferenceHandler;
                if (setChannelInvitationPreferenceHandler != null) {
                    setChannelInvitationPreferenceHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                boolean z = z;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_CHANNELINVITATIONPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("auto_accept", Boolean.valueOf(z));
                    return a2.b(format, e2);
                }
                throw u.b();
            }
        });
    }

    public static void getChannelInvitationPreference(final GetChannelInvitationPreferenceHandler getChannelInvitationPreferenceHandler) {
        d.a(new q<Boolean>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Boolean bool = (Boolean) obj;
                GetChannelInvitationPreferenceHandler getChannelInvitationPreferenceHandler = getChannelInvitationPreferenceHandler;
                if (getChannelInvitationPreferenceHandler != null) {
                    getChannelInvitationPreferenceHandler.onResult(bool != null ? bool.booleanValue() : false, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                if (SendBird.getCurrentUser() != null) {
                    return Boolean.valueOf(a2.a(String.format(b.USERS_USERID_CHANNELINVITATIONPREFERENCE.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), (Map<String, String>) null, (Map<String, Collection<String>>) null).getAsJsonObject().get("auto_accept").getAsBoolean());
                }
                throw u.b();
            }
        });
    }

    public static void blockUser(User user, final UserBlockHandler userBlockHandler) {
        if (user != null) {
            blockUserWithUserId(user.getUserId(), userBlockHandler);
        } else if (userBlockHandler != null) {
            runOnUIThread(new Runnable() {
                public final void run() {
                    userBlockHandler.onBlocked((User) null, new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public static void blockUserWithUserId(final String str, final UserBlockHandler userBlockHandler) {
        d.a(new q<User>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                User user = (User) obj;
                UserBlockHandler userBlockHandler = userBlockHandler;
                if (userBlockHandler != null) {
                    userBlockHandler.onBlocked(user, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    String str = str;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_BLOCK.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        JsonObject e2 = APIClient.e();
                        e2.addProperty("target_id", str);
                        return new User(a2.a(format, (JsonElement) e2));
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void unblockUser(User user, final UserUnblockHandler userUnblockHandler) {
        if (user != null) {
            unblockUserWithUserId(user.getUserId(), userUnblockHandler);
        } else if (userUnblockHandler != null) {
            runOnUIThread(new Runnable() {
                public final void run() {
                    userUnblockHandler.onUnblocked(new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public static void unblockUserWithUserId(final String str, final UserUnblockHandler userUnblockHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                UserUnblockHandler userUnblockHandler = userUnblockHandler;
                if (userUnblockHandler != null) {
                    userUnblockHandler.onUnblocked(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    String str = str;
                    if (SendBird.getCurrentUser() != null) {
                        return a2.a(String.format(b.USERS_USERID_BLOCK_TARGETID.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(str)}), (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void addFriends(final List<String> list, final AddFriendsHandler addFriendsHandler) {
        d.a(new q<List<User>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                List list = (List) obj;
                AddFriendsHandler addFriendsHandler = addFriendsHandler;
                if (addFriendsHandler != null) {
                    addFriendsHandler.onResult(list, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                JsonObject asJsonObject;
                JsonArray asJsonArray;
                List list = list;
                if (list == null || list.size() == 0) {
                    throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                ArrayList arrayList = new ArrayList();
                JsonElement a2 = APIClient.a().a((List<String>) list);
                if (!(a2 == null || (asJsonObject = a2.getAsJsonObject()) == null || !asJsonObject.has(StringSet.users) || (asJsonArray = asJsonObject.getAsJsonArray(StringSet.users)) == null)) {
                    for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                        arrayList.add(new User(asJsonArray.get(i2)));
                    }
                }
                return arrayList;
            }
        });
    }

    public static void deleteFriends(final List<String> list, final DeleteFriendsHandler deleteFriendsHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteFriendsHandler deleteFriendsHandler = deleteFriendsHandler;
                if (deleteFriendsHandler != null) {
                    deleteFriendsHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                List list = list;
                if (list == null || list.size() == 0) {
                    throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                List list2 = list;
                String format = String.format(b.USERS_USERID_FRIENDS.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                HashMap hashMap = new HashMap();
                hashMap.put("user_ids", list2);
                return a2.a(format, (Map<String, Collection<String>>) hashMap, (JsonElement) APIClient.e());
            }
        });
    }

    public static void deleteFriend(final String str, final DeleteFriendHandler deleteFriendHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteFriendHandler deleteFriendHandler = deleteFriendHandler;
                if (deleteFriendHandler != null) {
                    deleteFriendHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str = str;
                if (str == null || str.length() == 0) {
                    throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                String str2 = str;
                if (SendBird.getCurrentUser() != null) {
                    return a2.a(String.format(b.USERS_USERID_FRIENDS_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(str2)}), (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                }
                throw u.b();
            }
        });
    }

    public static void uploadFriendDiscoveries(final Map<String, String> map, final UploadFriendDiscoveriesHandler uploadFriendDiscoveriesHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                UploadFriendDiscoveriesHandler uploadFriendDiscoveriesHandler = uploadFriendDiscoveriesHandler;
                if (uploadFriendDiscoveriesHandler != null) {
                    uploadFriendDiscoveriesHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                Map map = map;
                if (map == null || map.size() == 0) {
                    throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                Map map2 = map;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_FRIENDDISCOVERIES.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                    JsonObject e2 = APIClient.e();
                    JsonArray jsonArray = new JsonArray();
                    for (String str : map2.keySet()) {
                        if (str != null && str.length() > 0) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("friend_discovery_key", str);
                            jsonObject.addProperty("friend_name", (String) map2.get(str));
                            jsonArray.add((JsonElement) jsonObject);
                        }
                    }
                    e2.add("friend_discoveries", jsonArray);
                    return a2.b(format, e2);
                }
                throw u.b();
            }
        });
    }

    public static void deleteFriendDiscoveries(final List<String> list, final DeleteFriendDiscoveriesHandler deleteFriendDiscoveriesHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteFriendDiscoveriesHandler deleteFriendDiscoveriesHandler = deleteFriendDiscoveriesHandler;
                if (deleteFriendDiscoveriesHandler != null) {
                    deleteFriendDiscoveriesHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                List list = list;
                if (list == null || list.size() == 0) {
                    throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                List list2 = list;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_FRIENDDISCOVERIES.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                    HashMap hashMap = new HashMap();
                    hashMap.put("friend_discovery_keys", list2);
                    return a2.a(format, (Map<String, Collection<String>>) hashMap, (JsonElement) APIClient.e());
                }
                throw u.b();
            }
        });
    }

    public static void deleteFriendDiscovery(final String str, final DeleteFriendDiscoveryHandler deleteFriendDiscoveryHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteFriendDiscoveryHandler deleteFriendDiscoveryHandler = deleteFriendDiscoveryHandler;
                if (deleteFriendDiscoveryHandler != null) {
                    deleteFriendDiscoveryHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str = str;
                if (str == null || str.length() == 0) {
                    throw new SendBirdException("Invalid operation.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                String str2 = str;
                if (SendBird.getCurrentUser() != null) {
                    return a2.a(String.format(b.USERS_USERID_FRIENDDISCOVERIES_DISCOVERYKEY.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), b.urlEncodeUTF8(str2)}), (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                }
                throw u.b();
            }
        });
    }

    public static void getFriendChangeLogsByToken(final String str, final GetFriendChangeLogsByTokenHandler getFriendChangeLogsByTokenHandler) {
        d.a(new s<Boolean>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Boolean call() {
                try {
                    APIClient a2 = APIClient.a();
                    String str = str;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_FRIENDS_CHANGELOGS.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        HashMap hashMap = new HashMap();
                        if (str != null) {
                            hashMap.put(StringSet.token, str);
                        }
                        JsonObject asJsonObject = a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject();
                        JsonArray asJsonArray = asJsonObject.get(StringSet.updated).getAsJsonArray();
                        final ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            arrayList.add(new User(asJsonArray.get(i2)));
                        }
                        JsonArray asJsonArray2 = asJsonObject.get(StringSet.deleted).getAsJsonArray();
                        final ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < asJsonArray2.size(); i3++) {
                            arrayList2.add(asJsonArray2.get(i3).getAsString());
                        }
                        final boolean asBoolean = asJsonObject.get(StringSet.has_more).getAsBoolean();
                        final String asString = asJsonObject.get("next").getAsString();
                        if (getFriendChangeLogsByTokenHandler != null) {
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    getFriendChangeLogsByTokenHandler.onResult(arrayList, arrayList2, asBoolean, asString, (SendBirdException) null);
                                }
                            });
                        }
                        return Boolean.TRUE;
                    }
                    throw u.b();
                } catch (SendBirdException e2) {
                    if (getFriendChangeLogsByTokenHandler != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                getFriendChangeLogsByTokenHandler.onResult((List<User>) null, (List<String>) null, false, (String) null, e2);
                            }
                        });
                    }
                }
            }
        });
    }

    public static FriendListQuery createFriendListQuery() {
        return new FriendListQuery();
    }

    @Deprecated
    public static void getMyGroupChannelChangeLogsByToken(String str, List<String> list, GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler) {
        getMyGroupChannelChangeLogs(str, (Long) null, list, true, true, getMyGroupChannelChangeLogsHandler);
    }

    @Deprecated
    public static void getMyGroupChannelChangeLogsByTimestamp(long j, List<String> list, GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler) {
        getMyGroupChannelChangeLogs((String) null, Long.valueOf(j), list, true, true, getMyGroupChannelChangeLogsHandler);
    }

    @Deprecated
    public static void getMyGroupChannelChangeLogsByToken(String str, List<String> list, boolean z, GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler) {
        getMyGroupChannelChangeLogs(str, (Long) null, list, z, true, getMyGroupChannelChangeLogsHandler);
    }

    @Deprecated
    public static void getMyGroupChannelChangeLogsByTimestamp(long j, List<String> list, boolean z, GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler) {
        getMyGroupChannelChangeLogs((String) null, Long.valueOf(j), list, z, true, getMyGroupChannelChangeLogsHandler);
    }

    public static void getMyGroupChannelChangeLogsByTokenWithParams(String str, GroupChannelChangeLogsParams groupChannelChangeLogsParams, final GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler) {
        if (groupChannelChangeLogsParams != null) {
            getMyGroupChannelChangeLogs(str, (Long) null, groupChannelChangeLogsParams.customTypes, groupChannelChangeLogsParams.includeEmpty, groupChannelChangeLogsParams.includeFrozen, getMyGroupChannelChangeLogsHandler);
        } else if (getMyGroupChannelChangeLogsHandler != null) {
            runOnUIThread(new Runnable() {
                public final void run() {
                    getMyGroupChannelChangeLogsHandler.onResult((List<GroupChannel>) null, (List<String>) null, false, (String) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public static void getMyGroupChannelChangeLogsByTimestampWithParams(long j, GroupChannelChangeLogsParams groupChannelChangeLogsParams, final GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler) {
        if (groupChannelChangeLogsParams != null) {
            getMyGroupChannelChangeLogs((String) null, Long.valueOf(j), groupChannelChangeLogsParams.customTypes, groupChannelChangeLogsParams.includeEmpty, groupChannelChangeLogsParams.includeFrozen, getMyGroupChannelChangeLogsHandler);
        } else if (getMyGroupChannelChangeLogsHandler != null) {
            runOnUIThread(new Runnable() {
                public final void run() {
                    getMyGroupChannelChangeLogsHandler.onResult((List<GroupChannel>) null, (List<String>) null, false, (String) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    private static void getMyGroupChannelChangeLogs(String str, Long l, List<String> list, boolean z, boolean z2, GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler) {
        final Long l2 = l;
        final List<String> list2 = list;
        final boolean z3 = z;
        final boolean z4 = z2;
        final String str2 = str;
        final GetMyGroupChannelChangeLogsHandler getMyGroupChannelChangeLogsHandler2 = getMyGroupChannelChangeLogsHandler;
        d.a(new s<Boolean>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Boolean call() {
                try {
                    if (l2 != null) {
                        if (l2.longValue() < 0) {
                            throw new SendBirdException("Invalid Arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                        }
                    }
                    List list = list2;
                    if (list2 != null) {
                        list = new ArrayList(new LinkedHashSet(list2));
                    }
                    GroupChannelChangeLogsParams groupChannelChangeLogsParams = new GroupChannelChangeLogsParams(list, z3, z4);
                    APIClient a2 = APIClient.a();
                    String str = str2;
                    Long l = l2;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_MYGROUPCHANNELS_CHANGELOGS.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        HashMap hashMap = new HashMap();
                        if (str != null) {
                            hashMap.put(StringSet.token, str);
                        }
                        if (l != null) {
                            hashMap.put(StringSet.change_ts, String.valueOf(l));
                        }
                        HashMap hashMap2 = new HashMap();
                        List<String> customTypes = groupChannelChangeLogsParams.getCustomTypes();
                        if (customTypes != null && customTypes.size() > 0) {
                            hashMap2.put(StringSet.custom_types, customTypes);
                        }
                        hashMap.put(StringSet.show_member, "true");
                        hashMap.put(StringSet.show_read_receipt, "true");
                        hashMap.put(StringSet.show_delivery_receipt, "true");
                        hashMap.put(StringSet.show_empty, String.valueOf(groupChannelChangeLogsParams.shouldIncludeEmpty()));
                        hashMap.put(StringSet.show_frozen, String.valueOf(groupChannelChangeLogsParams.shouldIncludeFrozen()));
                        JsonObject asJsonObject = a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2).getAsJsonObject();
                        JsonArray asJsonArray = asJsonObject.get(StringSet.updated).getAsJsonArray();
                        final ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            arrayList.add(GroupChannel.upsert(asJsonArray.get(i2), false));
                        }
                        JsonArray asJsonArray2 = asJsonObject.get(StringSet.deleted).getAsJsonArray();
                        final ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < asJsonArray2.size(); i3++) {
                            arrayList2.add(asJsonArray2.get(i3).getAsString());
                        }
                        final boolean asBoolean = asJsonObject.get(StringSet.has_more).getAsBoolean();
                        final String asString = asJsonObject.get("next").getAsString();
                        if (getMyGroupChannelChangeLogsHandler2 != null) {
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    getMyGroupChannelChangeLogsHandler2.onResult(arrayList, arrayList2, asBoolean, asString, (SendBirdException) null);
                                }
                            });
                        }
                        return Boolean.TRUE;
                    }
                    throw u.b();
                } catch (SendBirdException e2) {
                    if (getMyGroupChannelChangeLogsHandler2 != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                getMyGroupChannelChangeLogsHandler2.onResult((List<GroupChannel>) null, (List<String>) null, false, (String) null, e2);
                            }
                        });
                    }
                }
            }
        });
    }

    public static void markAsDelivered(String str) {
        Logger.d(">> markAsDelivered()");
        GroupChannel.getChannel(str, new GroupChannel.GroupChannelGetHandler() {
            public final void onResult(GroupChannel groupChannel, SendBirdException sendBirdException) {
                if (groupChannel != null) {
                    groupChannel.markAsDelivered();
                }
            }
        });
    }

    public static void markAsReadAll(MarkAsReadHandler markAsReadHandler) {
        GroupChannel.localMarkAsReadAll((List<String>) null, markAsReadHandler);
    }

    public static void markAsReadWithChannelUrls(List<String> list, MarkAsReadHandler markAsReadHandler) {
        GroupChannel.localMarkAsReadWithChannelUrls(list, markAsReadHandler);
    }

    public static void getAllEmoji(final GetAllEmojiHandler getAllEmojiHandler) {
        d.a(new q<EmojiContainer>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                EmojiContainer emojiContainer = (EmojiContainer) obj;
                GetAllEmojiHandler getAllEmojiHandler = getAllEmojiHandler;
                if (getAllEmojiHandler != null) {
                    getAllEmojiHandler.onResult(emojiContainer, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                return new EmojiContainer(APIClient.a().a(b.EMOJI_CATEGORIES.publicUrl(), (Map<String, String>) null, (Map<String, Collection<String>>) null));
            }
        });
    }

    public static void getEmojiCategory(final long j, final GetEmojiCategoryHandler getEmojiCategoryHandler) {
        d.a(new q<EmojiCategory>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                EmojiCategory emojiCategory = (EmojiCategory) obj;
                GetEmojiCategoryHandler getEmojiCategoryHandler = getEmojiCategoryHandler;
                if (getEmojiCategoryHandler != null) {
                    getEmojiCategoryHandler.onResult(emojiCategory, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (j >= 0) {
                    APIClient a2 = APIClient.a();
                    long j = j;
                    return new EmojiCategory(a2.a(String.format(b.EMOJI_CATEGORY.publicUrl(), new Object[]{Long.valueOf(j)}), (Map<String, String>) null, (Map<String, Collection<String>>) null));
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public static void getEmoji(final String str, final GetEmojiHandler getEmojiHandler) {
        d.a(new q<Emoji>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Emoji emoji = (Emoji) obj;
                GetEmojiHandler getEmojiHandler = getEmojiHandler;
                if (getEmojiHandler != null) {
                    getEmojiHandler.onResult(emoji, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str = str;
                if (str == null || str.length() == 0) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                String str2 = str;
                return new Emoji(a2.a(String.format(b.EMOJI.publicUrl(), new Object[]{b.urlEncodeUTF8(str2)}), (Map<String, String>) null, (Map<String, Collection<String>>) null));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void sendCommand(Command command, boolean z, Command.SendCommandHandler sendCommandHandler) {
        u.a().a(command, z, sendCommandHandler);
    }

    class b extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private boolean f44644b;

        private b() {
            this.f44644b = false;
        }

        /* synthetic */ b(SendBird sendBird, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            NetworkInfo networkInfo;
            try {
                networkInfo = SendBird.this.mConnectivityManager.getActiveNetworkInfo();
            } catch (Exception e2) {
                e2.printStackTrace();
                networkInfo = null;
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                if (networkInfo == null) {
                    this.f44644b = true;
                    if (SendBird.getConnectionState() == ConnectionState.OPEN) {
                        u.a().a(false, (DisconnectHandler) null);
                    }
                }
            } else if (this.f44644b && !SendBird.this.mIsAppBackgroundAndDisconnected) {
                this.f44644b = false;
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            if (SendBird.getNetworkAwarenessReconnection()) {
                                u.a().a(true);
                            }
                        } catch (RuntimeException e2) {
                            e2.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }

    public static void getTotalUnreadMessageCount(GroupChannel.GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        localGetTotalUnreadMessageCount((GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter) null, (List<String>) null, groupChannelTotalUnreadMessageCountHandler);
    }

    public static void getTotalUnreadMessageCount(List<String> list, GroupChannel.GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        localGetTotalUnreadMessageCount((GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter) null, list, groupChannelTotalUnreadMessageCountHandler);
    }

    public static void getTotalUnreadMessageCount(GroupChannelTotalUnreadMessageCountParams groupChannelTotalUnreadMessageCountParams, GroupChannel.GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        localGetTotalUnreadMessageCount(groupChannelTotalUnreadMessageCountParams.mSuperChannelFilter, groupChannelTotalUnreadMessageCountParams.mChannelCustomTypes, groupChannelTotalUnreadMessageCountHandler);
    }

    static void localGetTotalUnreadMessageCount(final GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter superChannelFilter, final List<String> list, final GroupChannel.GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler) {
        d.a(new q<Integer>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Integer num = (Integer) obj;
                GroupChannel.GroupChannelTotalUnreadMessageCountHandler groupChannelTotalUnreadMessageCountHandler = groupChannelTotalUnreadMessageCountHandler;
                if (groupChannelTotalUnreadMessageCountHandler != null) {
                    groupChannelTotalUnreadMessageCountHandler.onResult(num != null ? num.intValue() : 0, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter superChannelFilter = superChannelFilter;
                List list = list;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_UNREADMESSAGECOUNT.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                    HashMap hashMap = new HashMap();
                    if (superChannelFilter == GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter.ALL) {
                        hashMap.put(StringSet.super_mode, StringSet.all);
                    } else if (superChannelFilter == GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter.SUPER_CHANNEL_ONLY) {
                        hashMap.put(StringSet.super_mode, StringSet.SUPER);
                    } else if (superChannelFilter == GroupChannelTotalUnreadMessageCountParams.SuperChannelFilter.NONSUPER_CHANNEL_ONLY) {
                        hashMap.put(StringSet.super_mode, StringSet.nonsuper);
                    }
                    HashMap hashMap2 = new HashMap();
                    if (list != null && list.size() > 0) {
                        hashMap2.put(StringSet.custom_types, list);
                    }
                    return Integer.valueOf(a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2).getAsJsonObject().get(CLPConstants.FLAG_NOTIFICATIONS_UNREAD_COUNT).getAsInt());
                }
                throw u.b();
            }
        });
    }

    public static void getUnreadItemCount(final Collection<GroupChannel.UnreadItemKey> collection, final GroupChannel.GroupChannelGetUnreadItemCountHandler groupChannelGetUnreadItemCountHandler) {
        d.a(new q<Map<GroupChannel.UnreadItemKey, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                GroupChannel.GroupChannelGetUnreadItemCountHandler groupChannelGetUnreadItemCountHandler = groupChannelGetUnreadItemCountHandler;
                if (groupChannelGetUnreadItemCountHandler != null) {
                    groupChannelGetUnreadItemCountHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                Collection collection = collection;
                if (collection == null || collection.size() <= 0) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                JsonObject asJsonObject = APIClient.a().a((Collection<GroupChannel.UnreadItemKey>) collection).getAsJsonObject();
                HashMap hashMap = new HashMap();
                for (Map.Entry next : asJsonObject.entrySet()) {
                    if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                        GroupChannel.UnreadItemKey unreadItemKey = null;
                        String str = (String) next.getKey();
                        if (str.equals("group_channel_unread_message_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.GROUP_CHANNEL_UNREAD_MESSAGE_COUNT;
                        } else if (str.equals("group_channel_unread_mention_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.GROUP_CHANNEL_UNREAD_MENTION_COUNT;
                        } else if (str.equals("group_channel_invitation_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.GROUP_CHANNEL_INVITATION_COUNT;
                        } else if (str.equals("non_super_group_channel_unread_message_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.NONSUPER_UNREAD_MESSAGE_COUNT;
                        } else if (str.equals("super_group_channel_unread_message_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.SUPER_UNREAD_MESSAGE_COUNT;
                        } else if (str.equals("non_super_group_channel_unread_mention_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.NONSUPER_UNREAD_MENTION_COUNT;
                        } else if (str.equals("super_group_channel_unread_mention_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.SUPER_UNREAD_MENTION_COUNT;
                        } else if (str.equals("non_super_group_channel_invitation_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.NONSUPER_INVITATION_COUNT;
                        } else if (str.equals("super_group_channel_invitation_count")) {
                            unreadItemKey = GroupChannel.UnreadItemKey.SUPER_INVITATION_COUNT;
                        }
                        if (unreadItemKey != null) {
                            hashMap.put(unreadItemKey, Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                }
                return hashMap;
            }
        });
    }

    public static void getTotalUnreadChannelCount(final GroupChannel.GroupChannelTotalUnreadChannelCountHandler groupChannelTotalUnreadChannelCountHandler) {
        d.a(new q<Integer>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Integer num = (Integer) obj;
                GroupChannel.GroupChannelTotalUnreadChannelCountHandler groupChannelTotalUnreadChannelCountHandler = groupChannelTotalUnreadChannelCountHandler;
                if (groupChannelTotalUnreadChannelCountHandler != null) {
                    groupChannelTotalUnreadChannelCountHandler.onResult(num != null ? num.intValue() : 0, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                return Integer.valueOf(APIClient.a().g().getAsJsonObject().get(CLPConstants.FLAG_NOTIFICATIONS_UNREAD_COUNT).getAsInt());
            }
        });
    }

    /* renamed from: com.sendbird.android.SendBird$39  reason: invalid class name */
    static /* synthetic */ class AnonymousClass39 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44605a = new int[Options.ThreadOption.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f44606b = new int[GroupChannelListQuery.MemberStateFilter.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter[] r0 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44606b = r0
                r0 = 1
                int[] r1 = f44606b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r2 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.ALL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f44606b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r3 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.INVITED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = f44606b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r3 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.INVITED_BY_FRIEND     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r2 = f44606b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r3 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.INVITED_BY_NON_FRIEND     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r2 = f44606b     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.sendbird.android.GroupChannelListQuery$MemberStateFilter r3 = com.sendbird.android.GroupChannelListQuery.MemberStateFilter.JOINED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                com.sendbird.android.SendBird$Options$ThreadOption[] r2 = com.sendbird.android.SendBird.Options.ThreadOption.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f44605a = r2
                int[] r2 = f44605a     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.sendbird.android.SendBird$Options$ThreadOption r3 = com.sendbird.android.SendBird.Options.ThreadOption.NEW_THREAD     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f44605a     // Catch:{ NoSuchFieldError -> 0x005d }
                com.sendbird.android.SendBird$Options$ThreadOption r2 = com.sendbird.android.SendBird.Options.ThreadOption.HANDLER     // Catch:{ NoSuchFieldError -> 0x005d }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBird.AnonymousClass39.<clinit>():void");
        }
    }

    public static void getGroupChannelCount(GroupChannelListQuery.MemberStateFilter memberStateFilter, GroupChannel.GroupChannelChannelCountHandler groupChannelChannelCountHandler) {
        int i2 = AnonymousClass39.f44606b[memberStateFilter.ordinal()];
        localGetGroupChannelCount(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? null : StringSet.joined : StringSet.invited_by_non_friend : StringSet.invited_by_friend : "invited" : StringSet.all, groupChannelChannelCountHandler);
    }

    static void localGetGroupChannelCount(final String str, final GroupChannel.GroupChannelChannelCountHandler groupChannelChannelCountHandler) {
        d.a(new q<Integer>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Integer num = (Integer) obj;
                GroupChannel.GroupChannelChannelCountHandler groupChannelChannelCountHandler = groupChannelChannelCountHandler;
                if (groupChannelChannelCountHandler != null) {
                    groupChannelChannelCountHandler.onResult(num != null ? num.intValue() : 0, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String str = str;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.USERS_USERID_GROUPCHANNELCOUNT.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                    HashMap hashMap = new HashMap();
                    if (str != null) {
                        hashMap.put("state", str);
                    }
                    return Integer.valueOf(a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject().get("group_channel_count").getAsInt());
                }
                throw u.b();
            }
        });
    }

    static void setEkey(String str) {
        ekey = str;
    }

    public static String getEkey() {
        return ekey;
    }

    public static void removeAllChannelHandlers() {
        k.a.f44826a.f44724a.clear();
    }

    public static int getSubscribedTotalUnreadMessageCount() {
        return k.a.f44826a.f44725b.f45334a;
    }

    public static int getSubscribedCustomTypeTotalUnreadMessageCount() {
        return k.a.f44826a.f44725b.f45335b;
    }

    public static int getSubscribedCustomTypeUnreadMessageCount(String str) {
        Integer num;
        w wVar = k.a.f44826a.f44725b;
        if (str == null || (num = wVar.f45337d.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
