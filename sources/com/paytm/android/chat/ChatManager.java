package com.paytm.android.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.imsdk.CPCSendbirdWrapper;
import com.imsdk.CPCSendbirdWrapperProvider;
import com.imsdk.IMManager;
import com.imsdk.LoginInfo;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.bean.UserInfoBean;
import com.paytm.android.chat.bean.jsonbean.UserRegistJsonBean;
import com.paytm.android.chat.data.db.room.DBManager;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.data.repository.RPCChatRepository;
import com.paytm.android.chat.data.repository.datastores.CPCFirebaseInstanceIdWrapper;
import com.paytm.android.chat.data.repository.datastores.DPCRemoteDS;
import com.paytm.android.chat.data.repository.datastores.IPCRemoteDS;
import com.paytm.android.chat.network.requests.GetUserInfoRequest;
import com.paytm.android.chat.network.requests.GetUserSettingsRequest;
import com.paytm.android.chat.network.requests.RegistUserRequest;
import com.paytm.android.chat.network.response.ResponseOfRegister;
import com.paytm.android.chat.network.response.ResponseOfUserInfo;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.DatabaseManager;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.q;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import io.reactivex.rxjava3.d.g;

public class ChatManager {

    /* renamed from: a  reason: collision with root package name */
    public d f40989a;

    /* renamed from: b  reason: collision with root package name */
    String f40990b;

    /* renamed from: c  reason: collision with root package name */
    int f40991c;

    /* renamed from: d  reason: collision with root package name */
    int f40992d;

    /* renamed from: e  reason: collision with root package name */
    boolean f40993e;

    /* renamed from: f  reason: collision with root package name */
    public final ChatRepository f40994f;

    /* renamed from: g  reason: collision with root package name */
    private final IPCRemoteDS f40995g;

    public interface a {
    }

    static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ChatManager f41013a = new ChatManager((byte) 0);
    }

    public interface c {
        void onFailed(int i2, String str);

        void onSuccess();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, CPCSendbirdWrapper.ConnectionStatus connectionStatus) throws Throwable {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th) throws Throwable {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void j() throws Throwable {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k() throws Throwable {
    }

    /* synthetic */ ChatManager(byte b2) {
        this();
    }

    private ChatManager() {
        this.f40990b = "";
        this.f40991c = 0;
        this.f40992d = 3;
        this.f40993e = false;
        this.f40995g = new DPCRemoteDS(CPCSendbirdWrapperProvider.getSendbirdWrapper(c.a(), c.g()), CPCFirebaseInstanceIdWrapper.getINSTANCE());
        this.f40994f = new RPCChatRepository(this.f40995g);
    }

    public final ChatRepository a() {
        return this.f40994f;
    }

    public static final ChatManager b() {
        return b.f41013a;
    }

    public final void c() {
        a(false);
    }

    private void a(boolean z) {
        this.f40994f.logout(z).a($$Lambda$ChatManager$fQXS880dawQaWtm9pCDSq3KI.INSTANCE, new g() {
            public final void accept(Object obj) {
                ChatManager.this.b((Throwable) obj);
            }
        });
        ChatManager unused = b.f41013a;
        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.IS_REGIST, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Throwable th) throws Throwable {
        a(true);
    }

    public final void d() {
        this.f40994f.reConnectAsync();
    }

    public static void e() {
        ContactManager.getInstance().clearContactsCache();
        DatabaseManager.clearDB();
        DBManager.INSTANCE.clearAllData();
        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.IS_REGIST, false);
    }

    public static void f() {
        SharedPreferencesUtil.clear();
    }

    public final d g() {
        return this.f40989a;
    }

    public final d a(String str) {
        this.f40990b = str;
        return this.f40989a;
    }

    public static boolean h() {
        return SharedPreferencesUtil.isRegist();
    }

    public static void i() {
        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.IS_REGIST, true);
    }

    public final void a(Context context, boolean z, a aVar) {
        SendBird.ConnectionState connectionState = SendBird.getConnectionState();
        if (connectionState != SendBird.ConnectionState.OPEN && connectionState != SendBird.ConnectionState.CONNECTING) {
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.setUserId(SharedPreferencesUtil.getUserId());
            userInfoBean.setNickname(SharedPreferencesUtil.getNickname());
            userInfoBean.setPhoneNumber(SharedPreferencesUtil.getMobileNumber());
            userInfoBean.setProfileUrl(SharedPreferencesUtil.getProfileImg());
            userInfoBean.setToken(SharedPreferencesUtil.getToken());
            userInfoBean.setAccessToken(SharedPreferencesUtil.getSBToken());
            this.f40994f.chatLogin(userInfoBean).a(new g() {
                public final void accept(Object obj) {
                    ChatManager.a(ChatManager.a.this, (CPCSendbirdWrapper.ConnectionStatus) obj);
                }
            }, (g<? super Throwable>) new g(z, context, aVar) {
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ Context f$2;
                private final /* synthetic */ ChatManager.a f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void accept(Object obj) {
                    ChatManager.this.a(this.f$1, this.f$2, this.f$3, (Throwable) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(final boolean z, final Context context, final a aVar, Throwable th) throws Throwable {
        if (z && context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed() || activity.isFinishing()) {
                    return;
                }
            }
            new AlertDialog.Builder(context).setMessage(R.string.chat_module_dialog_connect_sendbird_failed).setPositiveButton(R.string.chat_module_dialog_btn_retry, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    ChatManager.this.a(context, z, aVar);
                }
            }).setNegativeButton(R.string.chat_module_dialog_btn_cancel, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, RegistUserRequest.PFRegistCallBack pFRegistCallBack) {
        UserRegistJsonBean userRegistJsonBean = new UserRegistJsonBean();
        if (str != null && !str.isEmpty()) {
            userRegistJsonBean.setUserId(str);
        }
        userRegistJsonBean.setUserName(str2);
        userRegistJsonBean.setToken(str5);
        userRegistJsonBean.setMobile(str3);
        userRegistJsonBean.setAvatar(str4);
        final RegistUserRequest.PFRegistCallBack pFRegistCallBack2 = pFRegistCallBack;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final String str9 = str5;
        new RegistUserRequest(userRegistJsonBean, new RegistUserRequest.PFRegistCallBack() {
            public final void onSuccess(final ResponseOfRegister responseOfRegister) {
                if (responseOfRegister == null) {
                    RegistUserRequest.PFRegistCallBack pFRegistCallBack = pFRegistCallBack2;
                    if (pFRegistCallBack != null) {
                        pFRegistCallBack.onFailure(-2, "RegistUserRequest return null");
                    }
                } else if (responseOfRegister.getUserId() == null) {
                    pFRegistCallBack2.onFailure(-3, "userId is null");
                } else {
                    if (responseOfRegister.getData().getSiteIdFilter() != null) {
                        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.site_id_filter, responseOfRegister.getData().getSiteIdFilter());
                    }
                    if (responseOfRegister.getData().isFirstTimeUser()) {
                        c.c();
                        ChatAnalyticsHelperKt.fireNewUserRegisteredEvent(c.a().getApplicationContext(), responseOfRegister.getData().getUserType());
                    }
                    new GetUserInfoRequest(responseOfRegister.getUserId(), new c.a.a.a<ResponseOfUserInfo>() {
                        public final /* synthetic */ void a(Object obj) {
                            ResponseOfUserInfo responseOfUserInfo = (ResponseOfUserInfo) obj;
                            ChatManager.b();
                            ChatManager.i();
                            new GetUserSettingsRequest(SharedPreferencesUtil.getUserId());
                            if (responseOfUserInfo == null || !responseOfUserInfo.getResultCode().equals("0") || responseOfUserInfo.getData() == null) {
                                q.b("server userInfo == null");
                            } else {
                                q.b("server userInfo avatar:" + responseOfUserInfo.getData().toString());
                                if (responseOfUserInfo.getData().getUserName() != null) {
                                    SharedPreferencesUtil.saveNickname(responseOfUserInfo.getData().getUserName());
                                }
                                if (responseOfUserInfo.getData().getAvatar() != null) {
                                    SharedPreferencesUtil.saveProfileImg(responseOfUserInfo.getData().getAvatar());
                                }
                                if (responseOfUserInfo.getData().getBirthday() <= 0) {
                                    SharedPreferencesUtil.saveProfileBirth(responseOfUserInfo.getData().getBirthday());
                                }
                                if (responseOfUserInfo.getData().getSex() != null) {
                                    SharedPreferencesUtil.saveProfileGender(responseOfUserInfo.getData().getSex());
                                }
                                if (responseOfUserInfo.getData().getAccessToken() != null && !responseOfUserInfo.getData().getAccessToken().isEmpty()) {
                                    SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SB_TOKEN, responseOfUserInfo.getData().getAccessToken());
                                }
                            }
                            ChatManager.this.b(responseOfRegister.getUserId(), str6, str7, str8, str9, responseOfRegister.getAccessToken(), new IMManager.ConnectCallback() {
                                public final void onConnected(LoginInfo loginInfo) {
                                    if (pFRegistCallBack2 != null) {
                                        pFRegistCallBack2.onSuccess(responseOfRegister);
                                    }
                                }

                                public final void onFailed(int i2, String str) {
                                    if (pFRegistCallBack2 != null) {
                                        pFRegistCallBack2.onFailure(i2, str);
                                    }
                                }
                            });
                        }

                        public final void a(int i2, String str) {
                            if (pFRegistCallBack2 != null) {
                                pFRegistCallBack2.onFailure(i2, str);
                            }
                        }
                    });
                }
            }

            public final void onFailure(int i2, String str) {
                RegistUserRequest.PFRegistCallBack pFRegistCallBack = pFRegistCallBack2;
                if (pFRegistCallBack != null) {
                    pFRegistCallBack.onFailure(i2, str);
                }
            }
        });
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, IMManager.ConnectCallback connectCallback) {
        b(str, str2, str3, str4, str5, str6, connectCallback);
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4, String str5, String str6, IMManager.ConnectCallback connectCallback) {
        if (a.f41025a) {
            q.d("connectToSendBird--\nPaytmId:" + str + "\nuserName:" + str2 + "\nmobile:" + str3 + "\navatar:" + str4 + "\ntoken:" + str5 + "\nsendbirdToken:" + str6);
        }
        this.f40994f.chatLogin(str, str2, str3, str4, str5, str6).a(io.reactivex.rxjava3.android.b.a.a()).a(new g(connectCallback) {
            private final /* synthetic */ IMManager.ConnectCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                ChatManager.this.a(this.f$1, (CPCSendbirdWrapper.ConnectionStatus) obj);
            }
        }, (g<? super Throwable>) new g() {
            public final void accept(Object obj) {
                ChatManager.a(IMManager.ConnectCallback.this, (Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IMManager.ConnectCallback connectCallback, CPCSendbirdWrapper.ConnectionStatus connectionStatus) throws Throwable {
        this.f40994f.registPushToken().b(io.reactivex.rxjava3.i.a.b()).a($$Lambda$ChatManager$93OlWQthTjCexQQRZz8oBhElLnY.INSTANCE, $$Lambda$ChatManager$IYnllNZXMY3MXgHXY93gcyZhLo.INSTANCE);
        if (connectCallback != null) {
            connectCallback.onConnected(new LoginInfo(connectionStatus.getUserId(), connectionStatus.getToken()));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(IMManager.ConnectCallback connectCallback, Throwable th) throws Throwable {
        if (connectCallback != null && (th instanceof SendBirdException)) {
            SendBirdException sendBirdException = (SendBirdException) th;
            connectCallback.onFailed(sendBirdException.getCode(), sendBirdException.getMessage());
        }
    }

    public final void a(final c cVar) {
        try {
            new GetUserInfoRequest(SharedPreferencesUtil.getUserId(), new c.a.a.a<ResponseOfUserInfo>() {
                public final /* synthetic */ void a(Object obj) {
                    ResponseOfUserInfo responseOfUserInfo = (ResponseOfUserInfo) obj;
                    ChatManager.b();
                    ChatManager.i();
                    new GetUserSettingsRequest(SharedPreferencesUtil.getUserId());
                    if (responseOfUserInfo == null || !responseOfUserInfo.getResultCode().equals("0") || responseOfUserInfo.getData() == null) {
                        q.b("GetUserInfoRequest server userInfo == null");
                        c cVar = cVar;
                        if (cVar != null) {
                            cVar.onFailed(-1, "server userInfo == null");
                            return;
                        }
                        return;
                    }
                    q.b("GetUserInfoRequest server avatar:" + responseOfUserInfo.getData().toString());
                    if (responseOfUserInfo.getData().getUserName() != null) {
                        SharedPreferencesUtil.saveNickname(responseOfUserInfo.getData().getUserName());
                    }
                    if (responseOfUserInfo.getData().getAvatar() != null) {
                        SharedPreferencesUtil.saveProfileImg(responseOfUserInfo.getData().getAvatar());
                    }
                    if (responseOfUserInfo.getData().getBirthday() <= 0) {
                        SharedPreferencesUtil.saveProfileBirth(responseOfUserInfo.getData().getBirthday());
                    }
                    if (responseOfUserInfo.getData().getSex() != null) {
                        SharedPreferencesUtil.saveProfileGender(responseOfUserInfo.getData().getSex());
                    }
                    if (responseOfUserInfo.getData().getAccessToken() != null && !responseOfUserInfo.getData().getAccessToken().isEmpty()) {
                        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SB_TOKEN, responseOfUserInfo.getData().getAccessToken());
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.onSuccess();
                    }
                }

                public final void a(int i2, String str) {
                    q.b("GetUserInfoRequest onFailure[" + i2 + "]" + str);
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.onFailed(i2, str);
                    }
                }
            });
        } catch (Exception unused) {
            q.b("getUserInfo: Failed to obtain personal information");
        }
    }
}
