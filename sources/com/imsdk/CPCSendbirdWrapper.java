package com.imsdk;

import com.imsdk.Datawrapper;
import com.paytm.android.chat.bean.UserInfoBean;
import com.paytm.android.chat.data.mappers.CPCDataMapperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.sendbird.android.ApplicationUserListQuery;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.ReactionEvent;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.ThreadInfoUpdateEvent;
import com.sendbird.android.User;
import com.sendbird.android.UserListQuery;
import com.sendbird.android.UserMessage;
import com.sendbird.android.UserMessageParams;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public class CPCSendbirdWrapper {
    /* access modifiers changed from: private */
    public final io.reactivex.rxjava3.j.a<Datawrapper<ConnectionStatus>> connectionStatusPublisher;

    static final class a<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f40586a = new a();

        a() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return Boolean.valueOf(((ConnectionStatus) obj).getStatus());
        }
    }

    static final class i<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f40707a = new i();

        i() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            GroupChannel groupChannel = (GroupChannel) obj;
            com.paytm.utility.q.d("fetchSendBirdChannel map, " + Thread.currentThread().toString());
            com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
            kotlin.g.b.k.a((Object) groupChannel, "channel");
            String url = groupChannel.getUrl();
            kotlin.g.b.k.a((Object) url, "channel.url");
            com.paytm.android.chat.d.a.a.a(url, groupChannel);
            return CPCDataMapperKt.mapBaseChannelToChatChannel(groupChannel);
        }
    }

    static final class l<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final l f40716a = new l();

        l() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return (User) ((List) obj).get(0);
        }
    }

    static final class n<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final n f40725a = new n();

        n() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return Boolean.valueOf(((ChatGroupChannelDataModel) obj).isPushEnabled());
        }
    }

    static final class p<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final p f40728a = new p();

        p() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Datawrapper.Success((ConnectionStatus) obj);
        }
    }

    static final class q<T, R> implements io.reactivex.rxjava3.d.h<Throwable, Datawrapper<? super ConnectionStatus>> {

        /* renamed from: a  reason: collision with root package name */
        public static final q f40729a = new q();

        q() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return new Datawrapper.Failure((Throwable) obj);
        }
    }

    public CPCSendbirdWrapper() {
        io.reactivex.rxjava3.j.a<Datawrapper<ConnectionStatus>> a2 = io.reactivex.rxjava3.j.a.a();
        kotlin.g.b.k.a((Object) a2, "BehaviorSubject.create()");
        this.connectionStatusPublisher = a2;
    }

    public static final class ConnectionStatus {
        private final boolean isImmediate;
        private final boolean status;
        private final String token;
        private final String userId;

        public static /* synthetic */ ConnectionStatus copy$default(ConnectionStatus connectionStatus, String str, String str2, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = connectionStatus.userId;
            }
            if ((i2 & 2) != 0) {
                str2 = connectionStatus.token;
            }
            if ((i2 & 4) != 0) {
                z = connectionStatus.status;
            }
            if ((i2 & 8) != 0) {
                z2 = connectionStatus.isImmediate;
            }
            return connectionStatus.copy(str, str2, z, z2);
        }

        public final String component1() {
            return this.userId;
        }

        public final String component2() {
            return this.token;
        }

        public final boolean component3() {
            return this.status;
        }

        public final boolean component4() {
            return this.isImmediate;
        }

        public final ConnectionStatus copy(String str, String str2, boolean z, boolean z2) {
            kotlin.g.b.k.c(str, "userId");
            return new ConnectionStatus(str, str2, z, z2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectionStatus)) {
                return false;
            }
            ConnectionStatus connectionStatus = (ConnectionStatus) obj;
            return kotlin.g.b.k.a((Object) this.userId, (Object) connectionStatus.userId) && kotlin.g.b.k.a((Object) this.token, (Object) connectionStatus.token) && this.status == connectionStatus.status && this.isImmediate == connectionStatus.isImmediate;
        }

        public final int hashCode() {
            String str = this.userId;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.token;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = (hashCode + i2) * 31;
            boolean z = this.status;
            if (z) {
                z = true;
            }
            int i4 = (i3 + (z ? 1 : 0)) * 31;
            boolean z2 = this.isImmediate;
            if (z2) {
                z2 = true;
            }
            return i4 + (z2 ? 1 : 0);
        }

        public final String toString() {
            return "ConnectionStatus(userId=" + this.userId + ", token=" + this.token + ", status=" + this.status + ", isImmediate=" + this.isImmediate + ")";
        }

        public ConnectionStatus(String str, String str2, boolean z, boolean z2) {
            kotlin.g.b.k.c(str, "userId");
            this.userId = str;
            this.token = str2;
            this.status = z;
            this.isImmediate = z2;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ConnectionStatus(String str, String str2, boolean z, boolean z2, int i2, kotlin.g.b.g gVar) {
            this(str, str2, (i2 & 4) != 0 ? true : z, z2);
        }

        public final boolean getStatus() {
            return this.status;
        }

        public final boolean isImmediate() {
            return this.isImmediate;
        }
    }

    public io.reactivex.rxjava3.a.y<Boolean> PFChatLogin(UserInfoBean userInfoBean) {
        kotlin.g.b.k.c(userInfoBean, "bean");
        String userId = userInfoBean.getUserId();
        kotlin.g.b.k.a((Object) userId, "bean.userId");
        String nickname = userInfoBean.getNickname();
        kotlin.g.b.k.a((Object) nickname, "bean.nickname");
        String phoneNumber = userInfoBean.getPhoneNumber();
        kotlin.g.b.k.a((Object) phoneNumber, "bean.phoneNumber");
        String profileUrl = userInfoBean.getProfileUrl();
        kotlin.g.b.k.a((Object) profileUrl, "bean.profileUrl");
        String token = userInfoBean.getToken();
        kotlin.g.b.k.a((Object) token, "bean.token");
        String accessToken = userInfoBean.getAccessToken();
        kotlin.g.b.k.a((Object) accessToken, "bean.accessToken");
        return PFChatLogin(userId, nickname, phoneNumber, profileUrl, token, accessToken);
    }

    public io.reactivex.rxjava3.a.y<Boolean> PFChatLogin(String str, String str2, String str3, String str4, String str5, String str6) {
        kotlin.g.b.k.c(str, "userId");
        kotlin.g.b.k.c(str2, "nikeName");
        kotlin.g.b.k.c(str3, "mobileNumber");
        kotlin.g.b.k.c(str4, UpiConstantServiceApi.KEY_PROFILE_PIC_URL);
        kotlin.g.b.k.c(str5, StringSet.token);
        kotlin.g.b.k.c(str6, "accessToken");
        setAutoBackgroundDetection(true);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_NAME, str2);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_MOBILE_NUMBER, str3);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_IMG, str4);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_TOKEN, str5);
        com.paytm.utility.q.b("PFChatLogin: ".concat(String.valueOf(str6)));
        io.reactivex.rxjava3.a.y<R> b2 = login(str, str2, str4, str6).b(a.f40586a);
        kotlin.g.b.k.a((Object) b2, "login(userId, nikeName, ….status\n                }");
        return b2;
    }

    public io.reactivex.rxjava3.a.y<ConnectionStatus> login(String str, String str2, String str3, String str4) {
        kotlin.g.b.k.c(str, "userId");
        io.reactivex.rxjava3.a.y<ConnectionStatus> a2 = io.reactivex.rxjava3.a.y.a(new r(this, str4, str));
        kotlin.g.b.k.a((Object) a2, "Single.defer {\n         …}\n            }\n        }");
        return a2;
    }

    public io.reactivex.rxjava3.a.h<Datawrapper<ConnectionStatus>> listenConnectionManagement(String str, String str2) {
        kotlin.g.b.k.c(str, "userId");
        kotlin.g.b.k.c(str2, "handlerId");
        SendBird.addConnectionHandler(str2, new CPCSendbirdWrapper$listenConnectionManagement$1(this, str));
        if (SendBird.getConnectionState() == SendBird.ConnectionState.OPEN) {
            io.reactivex.rxjava3.i.a.b().a((Runnable) new o(this, str));
        } else if (SendBird.getConnectionState() == SendBird.ConnectionState.CLOSED) {
            login(str, SharedPreferencesUtil.getNickname(), SharedPreferencesUtil.getProfileImg(), SharedPreferencesUtil.getSBToken()).e().map(p.f40728a).onErrorReturn(q.f40729a).observeOn(io.reactivex.rxjava3.i.a.b()).subscribe(this.connectionStatusPublisher);
        }
        io.reactivex.rxjava3.a.h<Datawrapper<ConnectionStatus>> flowable = this.connectionStatusPublisher.hide().toFlowable(io.reactivex.rxjava3.a.a.LATEST);
        kotlin.g.b.k.a((Object) flowable, "connectionStatusPublishe…kpressureStrategy.LATEST)");
        return flowable;
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper f40726a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f40727b;

        o(CPCSendbirdWrapper cPCSendbirdWrapper, String str) {
            this.f40726a = cPCSendbirdWrapper;
            this.f40727b = str;
        }

        public final void run() {
            this.f40726a.connectionStatusPublisher.onNext(new Datawrapper.Success(new ConnectionStatus(this.f40727b, (String) null, true, true)));
        }
    }

    public io.reactivex.rxjava3.a.b registPushTokenToSendbird(String str) {
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.d.r<? extends io.reactivex.rxjava3.a.f>) new w(str));
        kotlin.g.b.k.a((Object) a2, "Completable.defer {\n    …chedulers.io())\n        }");
        return a2;
    }

    public io.reactivex.rxjava3.a.b updateCurrentUserInfo(String str, String str2) {
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.d.r<? extends io.reactivex.rxjava3.a.f>) new ac(str, str2));
        kotlin.g.b.k.a((Object) a2, "Completable.defer {\n    …chedulers.io())\n        }");
        return a2;
    }

    public io.reactivex.rxjava3.a.b logout(boolean z2, String str) {
        kotlin.g.b.k.c(str, "sendBirdToken");
        io.reactivex.rxjava3.a.b b2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.d.r<? extends io.reactivex.rxjava3.a.f>) new s(str, z2)).b((io.reactivex.rxjava3.a.f) disConnect()).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) b2, "Completable.defer {\n    …scribeOn(Schedulers.io())");
        return b2;
    }

    public void disConnectAsync() {
        com.paytm.utility.q.b("disConnectAsync exec");
        disConnect().a(e.f40699a, f.f40700a);
    }

    static final class e implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f40699a = new e();

        e() {
        }

        public final void run() {
            com.paytm.utility.q.b("disConnectAsync exec complete");
        }
    }

    public io.reactivex.rxjava3.a.b disConnect() {
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.d.r<? extends io.reactivex.rxjava3.a.f>) d.f40696a);
        kotlin.g.b.k.a((Object) a2, "Completable.defer {\n    …chedulers.io())\n        }");
        return a2;
    }

    public void reConnectAsync() {
        reConnect().a(u.f40746a, (io.reactivex.rxjava3.d.g<? super Throwable>) v.f40747a);
    }

    public io.reactivex.rxjava3.a.y<ConnectionStatus> reConnect() {
        com.paytm.utility.q.b("reConnect");
        if (!isSenbirdWSConnected()) {
            com.paytm.utility.q.b("reConnect exec");
            return login(SharedPreferencesUtil.getUserId(), SharedPreferencesUtil.getNickname(), SharedPreferencesUtil.getProfileImg(), SharedPreferencesUtil.getSBToken());
        }
        io.reactivex.rxjava3.a.y<ConnectionStatus> b2 = io.reactivex.rxjava3.a.y.a(t.f40745a).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) b2, "Single.defer {\n         …scribeOn(Schedulers.io())");
        return b2;
    }

    public boolean isSenbirdWSConnected() {
        return SendBird.getConnectionState() == SendBird.ConnectionState.OPEN;
    }

    public void setAutoBackgroundDetection(boolean z2) {
        SendBird.setAutoBackgroundDetection(z2);
    }

    public io.reactivex.rxjava3.a.y<Boolean> isPushEnabled(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        io.reactivex.rxjava3.a.y<R> b2 = fetchSendBirdChannel(str).b(n.f40725a);
        kotlin.g.b.k.a((Object) b2, "fetchSendBirdChannel(cha…Enabled\n                }");
        return b2;
    }

    public io.reactivex.rxjava3.a.y<ChatGroupChannelDataModel> fetchSendBirdChannel(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        io.reactivex.rxjava3.a.y<ChatGroupChannelDataModel> b2 = io.reactivex.rxjava3.a.y.a(new h(str)).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b()).b(i.f40707a);
        kotlin.g.b.k.a((Object) b2, "Single.defer {\n         …hannel)\n                }");
        return b2;
    }

    public io.reactivex.rxjava3.a.y<List<ChatGroupChannelDataModel>> fetchChannelList() {
        io.reactivex.rxjava3.a.y<List<ChatGroupChannelDataModel>> a2 = io.reactivex.rxjava3.a.y.a(g.f40701a);
        kotlin.g.b.k.a((Object) a2, "Single.defer {\n         …}\n            }\n        }");
        return a2;
    }

    public io.reactivex.rxjava3.a.b setChannelPushPreferences(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z2) {
        kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.d.r<? extends io.reactivex.rxjava3.a.f>) new aa(chatGroupChannelDataModel, z2));
        kotlin.g.b.k.a((Object) a2, "Completable.defer {\n    …chedulers.io())\n        }");
        return a2;
    }

    public static abstract class ChannelUpdate {

        public static final class MessageReceived extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final BaseMessage message;

            public static /* synthetic */ MessageReceived copy$default(MessageReceived messageReceived, ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = messageReceived.channel;
                }
                if ((i2 & 2) != 0) {
                    baseMessage = messageReceived.message;
                }
                return messageReceived.copy(chatGroupChannelDataModel, baseMessage);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final BaseMessage component2() {
                return this.message;
            }

            public final MessageReceived copy(ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(baseMessage, "message");
                return new MessageReceived(chatGroupChannelDataModel, baseMessage);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MessageReceived)) {
                    return false;
                }
                MessageReceived messageReceived = (MessageReceived) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) messageReceived.channel) && kotlin.g.b.k.a((Object) this.message, (Object) messageReceived.message);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                BaseMessage baseMessage = this.message;
                if (baseMessage != null) {
                    i2 = baseMessage.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MessageReceived(channel=" + this.channel + ", message=" + this.message + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MessageReceived(ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(baseMessage, "message");
                this.channel = chatGroupChannelDataModel;
                this.message = baseMessage;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final BaseMessage getMessage() {
                return this.message;
            }
        }

        private ChannelUpdate() {
        }

        public /* synthetic */ ChannelUpdate(kotlin.g.b.g gVar) {
            this();
        }

        public static final class MentionReceived extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final BaseMessage message;

            public static /* synthetic */ MentionReceived copy$default(MentionReceived mentionReceived, ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = mentionReceived.channel;
                }
                if ((i2 & 2) != 0) {
                    baseMessage = mentionReceived.message;
                }
                return mentionReceived.copy(chatGroupChannelDataModel, baseMessage);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final BaseMessage component2() {
                return this.message;
            }

            public final MentionReceived copy(ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(baseMessage, "message");
                return new MentionReceived(chatGroupChannelDataModel, baseMessage);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MentionReceived)) {
                    return false;
                }
                MentionReceived mentionReceived = (MentionReceived) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) mentionReceived.channel) && kotlin.g.b.k.a((Object) this.message, (Object) mentionReceived.message);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                BaseMessage baseMessage = this.message;
                if (baseMessage != null) {
                    i2 = baseMessage.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MentionReceived(channel=" + this.channel + ", message=" + this.message + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MentionReceived(ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(baseMessage, "message");
                this.channel = chatGroupChannelDataModel;
                this.message = baseMessage;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final BaseMessage getMessage() {
                return this.message;
            }
        }

        public static final class MessageUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final BaseMessage message;

            public static /* synthetic */ MessageUpdated copy$default(MessageUpdated messageUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = messageUpdated.channel;
                }
                if ((i2 & 2) != 0) {
                    baseMessage = messageUpdated.message;
                }
                return messageUpdated.copy(chatGroupChannelDataModel, baseMessage);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final BaseMessage component2() {
                return this.message;
            }

            public final MessageUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(baseMessage, "message");
                return new MessageUpdated(chatGroupChannelDataModel, baseMessage);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MessageUpdated)) {
                    return false;
                }
                MessageUpdated messageUpdated = (MessageUpdated) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) messageUpdated.channel) && kotlin.g.b.k.a((Object) this.message, (Object) messageUpdated.message);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                BaseMessage baseMessage = this.message;
                if (baseMessage != null) {
                    i2 = baseMessage.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MessageUpdated(channel=" + this.channel + ", message=" + this.message + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MessageUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel, BaseMessage baseMessage) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(baseMessage, "message");
                this.channel = chatGroupChannelDataModel;
                this.message = baseMessage;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final BaseMessage getMessage() {
                return this.message;
            }
        }

        public static final class MessageDeleted extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final long messageID;

            public static /* synthetic */ MessageDeleted copy$default(MessageDeleted messageDeleted, ChatGroupChannelDataModel chatGroupChannelDataModel, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = messageDeleted.channel;
                }
                if ((i2 & 2) != 0) {
                    j = messageDeleted.messageID;
                }
                return messageDeleted.copy(chatGroupChannelDataModel, j);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final long component2() {
                return this.messageID;
            }

            public final MessageDeleted copy(ChatGroupChannelDataModel chatGroupChannelDataModel, long j) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new MessageDeleted(chatGroupChannelDataModel, j);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MessageDeleted)) {
                    return false;
                }
                MessageDeleted messageDeleted = (MessageDeleted) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) messageDeleted.channel) && this.messageID == messageDeleted.messageID;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int hashCode = chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0;
                long j = this.messageID;
                return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
            }

            public final String toString() {
                return "MessageDeleted(channel=" + this.channel + ", messageID=" + this.messageID + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MessageDeleted(ChatGroupChannelDataModel chatGroupChannelDataModel, long j) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
                this.messageID = j;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final long getMessageID() {
                return this.messageID;
            }
        }

        public static final class ChannelChanged extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ ChannelChanged copy$default(ChannelChanged channelChanged, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = channelChanged.channel;
                }
                return channelChanged.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final ChannelChanged copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new ChannelChanged(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ChannelChanged) && kotlin.g.b.k.a((Object) this.channel, (Object) ((ChannelChanged) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "ChannelChanged(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ChannelChanged(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class ChannelDeleted extends ChannelUpdate {
            private final BaseChannel.ChannelType channelType;
            private final String channelUrl;

            public static /* synthetic */ ChannelDeleted copy$default(ChannelDeleted channelDeleted, String str, BaseChannel.ChannelType channelType2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = channelDeleted.channelUrl;
                }
                if ((i2 & 2) != 0) {
                    channelType2 = channelDeleted.channelType;
                }
                return channelDeleted.copy(str, channelType2);
            }

            public final String component1() {
                return this.channelUrl;
            }

            public final BaseChannel.ChannelType component2() {
                return this.channelType;
            }

            public final ChannelDeleted copy(String str, BaseChannel.ChannelType channelType2) {
                kotlin.g.b.k.c(str, "channelUrl");
                kotlin.g.b.k.c(channelType2, "channelType");
                return new ChannelDeleted(str, channelType2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ChannelDeleted)) {
                    return false;
                }
                ChannelDeleted channelDeleted = (ChannelDeleted) obj;
                return kotlin.g.b.k.a((Object) this.channelUrl, (Object) channelDeleted.channelUrl) && kotlin.g.b.k.a((Object) this.channelType, (Object) channelDeleted.channelType);
            }

            public final int hashCode() {
                String str = this.channelUrl;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                BaseChannel.ChannelType channelType2 = this.channelType;
                if (channelType2 != null) {
                    i2 = channelType2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "ChannelDeleted(channelUrl=" + this.channelUrl + ", channelType=" + this.channelType + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ChannelDeleted(String str, BaseChannel.ChannelType channelType2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(str, "channelUrl");
                kotlin.g.b.k.c(channelType2, "channelType");
                this.channelUrl = str;
                this.channelType = channelType2;
            }

            public final BaseChannel.ChannelType getChannelType() {
                return this.channelType;
            }

            public final String getChannelUrl() {
                return this.channelUrl;
            }
        }

        public static final class ReactionUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final ReactionEvent reactionEvent;

            public static /* synthetic */ ReactionUpdated copy$default(ReactionUpdated reactionUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, ReactionEvent reactionEvent2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = reactionUpdated.channel;
                }
                if ((i2 & 2) != 0) {
                    reactionEvent2 = reactionUpdated.reactionEvent;
                }
                return reactionUpdated.copy(chatGroupChannelDataModel, reactionEvent2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final ReactionEvent component2() {
                return this.reactionEvent;
            }

            public final ReactionUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel, ReactionEvent reactionEvent2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(reactionEvent2, "reactionEvent");
                return new ReactionUpdated(chatGroupChannelDataModel, reactionEvent2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ReactionUpdated)) {
                    return false;
                }
                ReactionUpdated reactionUpdated = (ReactionUpdated) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) reactionUpdated.channel) && kotlin.g.b.k.a((Object) this.reactionEvent, (Object) reactionUpdated.reactionEvent);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                ReactionEvent reactionEvent2 = this.reactionEvent;
                if (reactionEvent2 != null) {
                    i2 = reactionEvent2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "ReactionUpdated(channel=" + this.channel + ", reactionEvent=" + this.reactionEvent + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ReactionUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel, ReactionEvent reactionEvent2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(reactionEvent2, "reactionEvent");
                this.channel = chatGroupChannelDataModel;
                this.reactionEvent = reactionEvent2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final ReactionEvent getReactionEvent() {
                return this.reactionEvent;
            }
        }

        public static final class ReadReceiptUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ ReadReceiptUpdated copy$default(ReadReceiptUpdated readReceiptUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = readReceiptUpdated.channel;
                }
                return readReceiptUpdated.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final ReadReceiptUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new ReadReceiptUpdated(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ReadReceiptUpdated) && kotlin.g.b.k.a((Object) this.channel, (Object) ((ReadReceiptUpdated) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "ReadReceiptUpdated(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ReadReceiptUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class DeliveryReceiptUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ DeliveryReceiptUpdated copy$default(DeliveryReceiptUpdated deliveryReceiptUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = deliveryReceiptUpdated.channel;
                }
                return deliveryReceiptUpdated.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final DeliveryReceiptUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new DeliveryReceiptUpdated(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof DeliveryReceiptUpdated) && kotlin.g.b.k.a((Object) this.channel, (Object) ((DeliveryReceiptUpdated) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "DeliveryReceiptUpdated(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DeliveryReceiptUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class TypingStatusUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ TypingStatusUpdated copy$default(TypingStatusUpdated typingStatusUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = typingStatusUpdated.channel;
                }
                return typingStatusUpdated.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final TypingStatusUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new TypingStatusUpdated(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof TypingStatusUpdated) && kotlin.g.b.k.a((Object) this.channel, (Object) ((TypingStatusUpdated) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "TypingStatusUpdated(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TypingStatusUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class UserReceivedInvitation extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final List<User> invitees;
            private final User inviter;

            public static /* synthetic */ UserReceivedInvitation copy$default(UserReceivedInvitation userReceivedInvitation, ChatGroupChannelDataModel chatGroupChannelDataModel, User user, List<User> list, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userReceivedInvitation.channel;
                }
                if ((i2 & 2) != 0) {
                    user = userReceivedInvitation.inviter;
                }
                if ((i2 & 4) != 0) {
                    list = userReceivedInvitation.invitees;
                }
                return userReceivedInvitation.copy(chatGroupChannelDataModel, user, list);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.inviter;
            }

            public final List<User> component3() {
                return this.invitees;
            }

            public final UserReceivedInvitation copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user, List<? extends User> list) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user, "inviter");
                kotlin.g.b.k.c(list, "invitees");
                return new UserReceivedInvitation(chatGroupChannelDataModel, user, list);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserReceivedInvitation)) {
                    return false;
                }
                UserReceivedInvitation userReceivedInvitation = (UserReceivedInvitation) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userReceivedInvitation.channel) && kotlin.g.b.k.a((Object) this.inviter, (Object) userReceivedInvitation.inviter) && kotlin.g.b.k.a((Object) this.invitees, (Object) userReceivedInvitation.invitees);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user = this.inviter;
                int hashCode2 = (hashCode + (user != null ? user.hashCode() : 0)) * 31;
                List<User> list = this.invitees;
                if (list != null) {
                    i2 = list.hashCode();
                }
                return hashCode2 + i2;
            }

            public final String toString() {
                return "UserReceivedInvitation(channel=" + this.channel + ", inviter=" + this.inviter + ", invitees=" + this.invitees + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserReceivedInvitation(ChatGroupChannelDataModel chatGroupChannelDataModel, User user, List<? extends User> list) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user, "inviter");
                kotlin.g.b.k.c(list, "invitees");
                this.channel = chatGroupChannelDataModel;
                this.inviter = user;
                this.invitees = list;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final List<User> getInvitees() {
                return this.invitees;
            }

            public final User getInviter() {
                return this.inviter;
            }
        }

        public static final class UserJoined extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserJoined copy$default(UserJoined userJoined, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userJoined.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userJoined.user;
                }
                return userJoined.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserJoined copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserJoined(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserJoined)) {
                    return false;
                }
                UserJoined userJoined = (UserJoined) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userJoined.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userJoined.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserJoined(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserJoined(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class UserDeclinedInvitation extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User invitee;
            private final User inviter;

            public static /* synthetic */ UserDeclinedInvitation copy$default(UserDeclinedInvitation userDeclinedInvitation, ChatGroupChannelDataModel chatGroupChannelDataModel, User user, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userDeclinedInvitation.channel;
                }
                if ((i2 & 2) != 0) {
                    user = userDeclinedInvitation.inviter;
                }
                if ((i2 & 4) != 0) {
                    user2 = userDeclinedInvitation.invitee;
                }
                return userDeclinedInvitation.copy(chatGroupChannelDataModel, user, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.inviter;
            }

            public final User component3() {
                return this.invitee;
            }

            public final UserDeclinedInvitation copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user, "inviter");
                kotlin.g.b.k.c(user2, "invitee");
                return new UserDeclinedInvitation(chatGroupChannelDataModel, user, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserDeclinedInvitation)) {
                    return false;
                }
                UserDeclinedInvitation userDeclinedInvitation = (UserDeclinedInvitation) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userDeclinedInvitation.channel) && kotlin.g.b.k.a((Object) this.inviter, (Object) userDeclinedInvitation.inviter) && kotlin.g.b.k.a((Object) this.invitee, (Object) userDeclinedInvitation.invitee);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user = this.inviter;
                int hashCode2 = (hashCode + (user != null ? user.hashCode() : 0)) * 31;
                User user2 = this.invitee;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode2 + i2;
            }

            public final String toString() {
                return "UserDeclinedInvitation(channel=" + this.channel + ", inviter=" + this.inviter + ", invitee=" + this.invitee + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserDeclinedInvitation(ChatGroupChannelDataModel chatGroupChannelDataModel, User user, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user, "inviter");
                kotlin.g.b.k.c(user2, "invitee");
                this.channel = chatGroupChannelDataModel;
                this.inviter = user;
                this.invitee = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getInvitee() {
                return this.invitee;
            }

            public final User getInviter() {
                return this.inviter;
            }
        }

        public static final class UserLeft extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserLeft copy$default(UserLeft userLeft, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userLeft.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userLeft.user;
                }
                return userLeft.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserLeft copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserLeft(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserLeft)) {
                    return false;
                }
                UserLeft userLeft = (UserLeft) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userLeft.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userLeft.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserLeft(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserLeft(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class UserEntered extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserEntered copy$default(UserEntered userEntered, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userEntered.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userEntered.user;
                }
                return userEntered.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserEntered copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserEntered(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserEntered)) {
                    return false;
                }
                UserEntered userEntered = (UserEntered) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userEntered.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userEntered.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserEntered(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserEntered(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class UserExited extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserExited copy$default(UserExited userExited, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userExited.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userExited.user;
                }
                return userExited.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserExited copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserExited(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserExited)) {
                    return false;
                }
                UserExited userExited = (UserExited) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userExited.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userExited.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserExited(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserExited(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class UserMuted extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserMuted copy$default(UserMuted userMuted, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userMuted.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userMuted.user;
                }
                return userMuted.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserMuted copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserMuted(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserMuted)) {
                    return false;
                }
                UserMuted userMuted = (UserMuted) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userMuted.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userMuted.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserMuted(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserMuted(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class UserUnmuted extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserUnmuted copy$default(UserUnmuted userUnmuted, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userUnmuted.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userUnmuted.user;
                }
                return userUnmuted.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserUnmuted copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserUnmuted(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserUnmuted)) {
                    return false;
                }
                UserUnmuted userUnmuted = (UserUnmuted) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userUnmuted.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userUnmuted.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserUnmuted(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserUnmuted(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class UserBanned extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserBanned copy$default(UserBanned userBanned, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userBanned.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userBanned.user;
                }
                return userBanned.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserBanned copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserBanned(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserBanned)) {
                    return false;
                }
                UserBanned userBanned = (UserBanned) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userBanned.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userBanned.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserBanned(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserBanned(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class UserUnbanned extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final User user;

            public static /* synthetic */ UserUnbanned copy$default(UserUnbanned userUnbanned, ChatGroupChannelDataModel chatGroupChannelDataModel, User user2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = userUnbanned.channel;
                }
                if ((i2 & 2) != 0) {
                    user2 = userUnbanned.user;
                }
                return userUnbanned.copy(chatGroupChannelDataModel, user2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final User component2() {
                return this.user;
            }

            public final UserUnbanned copy(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                return new UserUnbanned(chatGroupChannelDataModel, user2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserUnbanned)) {
                    return false;
                }
                UserUnbanned userUnbanned = (UserUnbanned) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) userUnbanned.channel) && kotlin.g.b.k.a((Object) this.user, (Object) userUnbanned.user);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                User user2 = this.user;
                if (user2 != null) {
                    i2 = user2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "UserUnbanned(channel=" + this.channel + ", user=" + this.user + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UserUnbanned(ChatGroupChannelDataModel chatGroupChannelDataModel, User user2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(user2, StringSet.user);
                this.channel = chatGroupChannelDataModel;
                this.user = user2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final User getUser() {
                return this.user;
            }
        }

        public static final class ChannelFrozen extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ ChannelFrozen copy$default(ChannelFrozen channelFrozen, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = channelFrozen.channel;
                }
                return channelFrozen.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final ChannelFrozen copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new ChannelFrozen(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ChannelFrozen) && kotlin.g.b.k.a((Object) this.channel, (Object) ((ChannelFrozen) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "ChannelFrozen(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ChannelFrozen(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class ChannelUnfrozen extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ ChannelUnfrozen copy$default(ChannelUnfrozen channelUnfrozen, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = channelUnfrozen.channel;
                }
                return channelUnfrozen.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final ChannelUnfrozen copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new ChannelUnfrozen(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ChannelUnfrozen) && kotlin.g.b.k.a((Object) this.channel, (Object) ((ChannelUnfrozen) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "ChannelUnfrozen(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ChannelUnfrozen(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class MetaDataCreated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final Map<String, String> metaDataMap;

            public static /* synthetic */ MetaDataCreated copy$default(MetaDataCreated metaDataCreated, ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, String> map, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = metaDataCreated.channel;
                }
                if ((i2 & 2) != 0) {
                    map = metaDataCreated.metaDataMap;
                }
                return metaDataCreated.copy(chatGroupChannelDataModel, map);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final Map<String, String> component2() {
                return this.metaDataMap;
            }

            public final MetaDataCreated copy(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, String> map) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaDataMap");
                return new MetaDataCreated(chatGroupChannelDataModel, map);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MetaDataCreated)) {
                    return false;
                }
                MetaDataCreated metaDataCreated = (MetaDataCreated) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) metaDataCreated.channel) && kotlin.g.b.k.a((Object) this.metaDataMap, (Object) metaDataCreated.metaDataMap);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                Map<String, String> map = this.metaDataMap;
                if (map != null) {
                    i2 = map.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MetaDataCreated(channel=" + this.channel + ", metaDataMap=" + this.metaDataMap + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MetaDataCreated(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, String> map) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaDataMap");
                this.channel = chatGroupChannelDataModel;
                this.metaDataMap = map;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final Map<String, String> getMetaDataMap() {
                return this.metaDataMap;
            }
        }

        public static final class MetaDataUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final Map<String, String> metaDataMap;

            public static /* synthetic */ MetaDataUpdated copy$default(MetaDataUpdated metaDataUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, String> map, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = metaDataUpdated.channel;
                }
                if ((i2 & 2) != 0) {
                    map = metaDataUpdated.metaDataMap;
                }
                return metaDataUpdated.copy(chatGroupChannelDataModel, map);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final Map<String, String> component2() {
                return this.metaDataMap;
            }

            public final MetaDataUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, String> map) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaDataMap");
                return new MetaDataUpdated(chatGroupChannelDataModel, map);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MetaDataUpdated)) {
                    return false;
                }
                MetaDataUpdated metaDataUpdated = (MetaDataUpdated) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) metaDataUpdated.channel) && kotlin.g.b.k.a((Object) this.metaDataMap, (Object) metaDataUpdated.metaDataMap);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                Map<String, String> map = this.metaDataMap;
                if (map != null) {
                    i2 = map.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MetaDataUpdated(channel=" + this.channel + ", metaDataMap=" + this.metaDataMap + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MetaDataUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, String> map) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaDataMap");
                this.channel = chatGroupChannelDataModel;
                this.metaDataMap = map;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final Map<String, String> getMetaDataMap() {
                return this.metaDataMap;
            }
        }

        public static final class MetaDataDeleted extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final List<String> keys;

            public static /* synthetic */ MetaDataDeleted copy$default(MetaDataDeleted metaDataDeleted, ChatGroupChannelDataModel chatGroupChannelDataModel, List<String> list, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = metaDataDeleted.channel;
                }
                if ((i2 & 2) != 0) {
                    list = metaDataDeleted.keys;
                }
                return metaDataDeleted.copy(chatGroupChannelDataModel, list);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final List<String> component2() {
                return this.keys;
            }

            public final MetaDataDeleted copy(ChatGroupChannelDataModel chatGroupChannelDataModel, List<String> list) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(list, "keys");
                return new MetaDataDeleted(chatGroupChannelDataModel, list);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MetaDataDeleted)) {
                    return false;
                }
                MetaDataDeleted metaDataDeleted = (MetaDataDeleted) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) metaDataDeleted.channel) && kotlin.g.b.k.a((Object) this.keys, (Object) metaDataDeleted.keys);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                List<String> list = this.keys;
                if (list != null) {
                    i2 = list.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MetaDataDeleted(channel=" + this.channel + ", keys=" + this.keys + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MetaDataDeleted(ChatGroupChannelDataModel chatGroupChannelDataModel, List<String> list) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(list, "keys");
                this.channel = chatGroupChannelDataModel;
                this.keys = list;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final List<String> getKeys() {
                return this.keys;
            }
        }

        public static final class MetaCountersDeleted extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final List<String> keys;

            public static /* synthetic */ MetaCountersDeleted copy$default(MetaCountersDeleted metaCountersDeleted, ChatGroupChannelDataModel chatGroupChannelDataModel, List<String> list, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = metaCountersDeleted.channel;
                }
                if ((i2 & 2) != 0) {
                    list = metaCountersDeleted.keys;
                }
                return metaCountersDeleted.copy(chatGroupChannelDataModel, list);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final List<String> component2() {
                return this.keys;
            }

            public final MetaCountersDeleted copy(ChatGroupChannelDataModel chatGroupChannelDataModel, List<String> list) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(list, "keys");
                return new MetaCountersDeleted(chatGroupChannelDataModel, list);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MetaCountersDeleted)) {
                    return false;
                }
                MetaCountersDeleted metaCountersDeleted = (MetaCountersDeleted) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) metaCountersDeleted.channel) && kotlin.g.b.k.a((Object) this.keys, (Object) metaCountersDeleted.keys);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                List<String> list = this.keys;
                if (list != null) {
                    i2 = list.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MetaCountersDeleted(channel=" + this.channel + ", keys=" + this.keys + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MetaCountersDeleted(ChatGroupChannelDataModel chatGroupChannelDataModel, List<String> list) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(list, "keys");
                this.channel = chatGroupChannelDataModel;
                this.keys = list;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final List<String> getKeys() {
                return this.keys;
            }
        }

        public static final class MetaCountersCreated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final Map<String, Integer> metaCounterMap;

            public static /* synthetic */ MetaCountersCreated copy$default(MetaCountersCreated metaCountersCreated, ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, Integer> map, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = metaCountersCreated.channel;
                }
                if ((i2 & 2) != 0) {
                    map = metaCountersCreated.metaCounterMap;
                }
                return metaCountersCreated.copy(chatGroupChannelDataModel, map);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final Map<String, Integer> component2() {
                return this.metaCounterMap;
            }

            public final MetaCountersCreated copy(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, Integer> map) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaCounterMap");
                return new MetaCountersCreated(chatGroupChannelDataModel, map);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MetaCountersCreated)) {
                    return false;
                }
                MetaCountersCreated metaCountersCreated = (MetaCountersCreated) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) metaCountersCreated.channel) && kotlin.g.b.k.a((Object) this.metaCounterMap, (Object) metaCountersCreated.metaCounterMap);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                Map<String, Integer> map = this.metaCounterMap;
                if (map != null) {
                    i2 = map.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MetaCountersCreated(channel=" + this.channel + ", metaCounterMap=" + this.metaCounterMap + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MetaCountersCreated(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, Integer> map) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaCounterMap");
                this.channel = chatGroupChannelDataModel;
                this.metaCounterMap = map;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final Map<String, Integer> getMetaCounterMap() {
                return this.metaCounterMap;
            }
        }

        public static final class MetaCountersUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final Map<String, Integer> metaCounterMap;

            public static /* synthetic */ MetaCountersUpdated copy$default(MetaCountersUpdated metaCountersUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, Integer> map, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = metaCountersUpdated.channel;
                }
                if ((i2 & 2) != 0) {
                    map = metaCountersUpdated.metaCounterMap;
                }
                return metaCountersUpdated.copy(chatGroupChannelDataModel, map);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final Map<String, Integer> component2() {
                return this.metaCounterMap;
            }

            public final MetaCountersUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, Integer> map) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaCounterMap");
                return new MetaCountersUpdated(chatGroupChannelDataModel, map);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MetaCountersUpdated)) {
                    return false;
                }
                MetaCountersUpdated metaCountersUpdated = (MetaCountersUpdated) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) metaCountersUpdated.channel) && kotlin.g.b.k.a((Object) this.metaCounterMap, (Object) metaCountersUpdated.metaCounterMap);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                Map<String, Integer> map = this.metaCounterMap;
                if (map != null) {
                    i2 = map.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "MetaCountersUpdated(channel=" + this.channel + ", metaCounterMap=" + this.metaCounterMap + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MetaCountersUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel, Map<String, Integer> map) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(map, "metaCounterMap");
                this.channel = chatGroupChannelDataModel;
                this.metaCounterMap = map;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final Map<String, Integer> getMetaCounterMap() {
                return this.metaCounterMap;
            }
        }

        public static final class ChannelHidden extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ ChannelHidden copy$default(ChannelHidden channelHidden, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = channelHidden.channel;
                }
                return channelHidden.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final ChannelHidden copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new ChannelHidden(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ChannelHidden) && kotlin.g.b.k.a((Object) this.channel, (Object) ((ChannelHidden) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "ChannelHidden(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ChannelHidden(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class OperatorUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;

            public static /* synthetic */ OperatorUpdated copy$default(OperatorUpdated operatorUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = operatorUpdated.channel;
                }
                return operatorUpdated.copy(chatGroupChannelDataModel);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final OperatorUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                return new OperatorUpdated(chatGroupChannelDataModel);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof OperatorUpdated) && kotlin.g.b.k.a((Object) this.channel, (Object) ((OperatorUpdated) obj).channel);
                }
                return true;
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                if (chatGroupChannelDataModel != null) {
                    return chatGroupChannelDataModel.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return "OperatorUpdated(channel=" + this.channel + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OperatorUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                this.channel = chatGroupChannelDataModel;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }
        }

        public static final class ThreadInfoUpdated extends ChannelUpdate {
            private final ChatGroupChannelDataModel channel;
            private final ThreadInfoUpdateEvent threadInfoUpdateEvent;

            public static /* synthetic */ ThreadInfoUpdated copy$default(ThreadInfoUpdated threadInfoUpdated, ChatGroupChannelDataModel chatGroupChannelDataModel, ThreadInfoUpdateEvent threadInfoUpdateEvent2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    chatGroupChannelDataModel = threadInfoUpdated.channel;
                }
                if ((i2 & 2) != 0) {
                    threadInfoUpdateEvent2 = threadInfoUpdated.threadInfoUpdateEvent;
                }
                return threadInfoUpdated.copy(chatGroupChannelDataModel, threadInfoUpdateEvent2);
            }

            public final ChatGroupChannelDataModel component1() {
                return this.channel;
            }

            public final ThreadInfoUpdateEvent component2() {
                return this.threadInfoUpdateEvent;
            }

            public final ThreadInfoUpdated copy(ChatGroupChannelDataModel chatGroupChannelDataModel, ThreadInfoUpdateEvent threadInfoUpdateEvent2) {
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(threadInfoUpdateEvent2, "threadInfoUpdateEvent");
                return new ThreadInfoUpdated(chatGroupChannelDataModel, threadInfoUpdateEvent2);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ThreadInfoUpdated)) {
                    return false;
                }
                ThreadInfoUpdated threadInfoUpdated = (ThreadInfoUpdated) obj;
                return kotlin.g.b.k.a((Object) this.channel, (Object) threadInfoUpdated.channel) && kotlin.g.b.k.a((Object) this.threadInfoUpdateEvent, (Object) threadInfoUpdated.threadInfoUpdateEvent);
            }

            public final int hashCode() {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.channel;
                int i2 = 0;
                int hashCode = (chatGroupChannelDataModel != null ? chatGroupChannelDataModel.hashCode() : 0) * 31;
                ThreadInfoUpdateEvent threadInfoUpdateEvent2 = this.threadInfoUpdateEvent;
                if (threadInfoUpdateEvent2 != null) {
                    i2 = threadInfoUpdateEvent2.hashCode();
                }
                return hashCode + i2;
            }

            public final String toString() {
                return "ThreadInfoUpdated(channel=" + this.channel + ", threadInfoUpdateEvent=" + this.threadInfoUpdateEvent + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ThreadInfoUpdated(ChatGroupChannelDataModel chatGroupChannelDataModel, ThreadInfoUpdateEvent threadInfoUpdateEvent2) {
                super((kotlin.g.b.g) null);
                kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
                kotlin.g.b.k.c(threadInfoUpdateEvent2, "threadInfoUpdateEvent");
                this.channel = chatGroupChannelDataModel;
                this.threadInfoUpdateEvent = threadInfoUpdateEvent2;
            }

            public final ChatGroupChannelDataModel getChannel() {
                return this.channel;
            }

            public final ThreadInfoUpdateEvent getThreadInfoUpdateEvent() {
                return this.threadInfoUpdateEvent;
            }
        }
    }

    static final class b<T> implements io.reactivex.rxjava3.a.s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40694a;

        b(String str) {
            this.f40694a = str;
        }

        public final void subscribe(io.reactivex.rxjava3.a.r<ChannelUpdate> rVar) {
            SendBird.addChannelHandler(this.f40694a, new CPCSendbirdWrapper$addChannelObserver$1$1(rVar));
        }
    }

    public io.reactivex.rxjava3.a.h<ChannelUpdate> addChannelObserver(String str) {
        io.reactivex.rxjava3.a.h<ChannelUpdate> flowable = io.reactivex.rxjava3.a.p.create(new b(str)).doOnDispose(new c(str)).toFlowable(io.reactivex.rxjava3.a.a.LATEST);
        kotlin.g.b.k.a((Object) flowable, "Observable.create<Channe…kpressureStrategy.LATEST)");
        return flowable;
    }

    static final class c implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40695a;

        c(String str) {
            this.f40695a = str;
        }

        public final void run() {
            SendBird.removeChannelHandler(this.f40695a);
        }
    }

    public io.reactivex.rxjava3.a.b updateCurrentUserProfileImage(File file) {
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.d.r<? extends io.reactivex.rxjava3.a.f>) new ad(file));
        kotlin.g.b.k.a((Object) a2, "Completable.defer {\n    …}\n            }\n        }");
        return a2;
    }

    public io.reactivex.rxjava3.a.y<List<User>> getUsersInfo(List<String> list) {
        kotlin.g.b.k.c(list, "userIds");
        io.reactivex.rxjava3.a.y<List<User>> a2 = io.reactivex.rxjava3.a.y.a(new m(list));
        kotlin.g.b.k.a((Object) a2, "Single.defer {\n         …chedulers.io())\n        }");
        return a2;
    }

    public io.reactivex.rxjava3.a.y<User> getUserInfo(String str) {
        kotlin.g.b.k.c(str, "userId");
        io.reactivex.rxjava3.a.y<R> b2 = getUsersInfo(kotlin.a.k.a(str)).b(l.f40716a);
        kotlin.g.b.k.a((Object) b2, "getUsersInfo(listOf(user…  it[0]\n                }");
        return b2;
    }

    public io.reactivex.rxjava3.a.y<List<User>> getBlockedUserList() {
        io.reactivex.rxjava3.a.y<List<User>> a2 = io.reactivex.rxjava3.a.y.a(j.f40708a);
        kotlin.g.b.k.a((Object) a2, "Single.defer {\n         …chedulers.io())\n        }");
        return a2;
    }

    public io.reactivex.rxjava3.a.b unblockUser(String str) {
        kotlin.g.b.k.c(str, "userId");
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.d.r<? extends io.reactivex.rxjava3.a.f>) new ab(str));
        kotlin.g.b.k.a((Object) a2, "Completable.defer {\n    …chedulers.io())\n        }");
        return a2;
    }

    public List<ChatUserDataModel> getOtherMembers(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        kotlin.g.b.k.c(chatGroupChannelDataModel, "mChannel");
        List<ChatUserDataModel> members = chatGroupChannelDataModel.getMembers();
        members.size();
        Collection arrayList = new ArrayList();
        for (Object next : members) {
            if (!kotlin.g.b.k.a((Object) ((ChatUserDataModel) next).getSendbirdUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public ChatUserDataModel getOtherMember(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        kotlin.g.b.k.c(chatGroupChannelDataModel, "mChannel");
        List<ChatUserDataModel> otherMembers = getOtherMembers(chatGroupChannelDataModel);
        if (!otherMembers.isEmpty()) {
            return otherMembers.get(0);
        }
        return null;
    }

    static final class z<T> implements io.reactivex.rxjava3.a.s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper f40765a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f40766b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ UserMessageParams f40767c;

        z(CPCSendbirdWrapper cPCSendbirdWrapper, ChatGroupChannelDataModel chatGroupChannelDataModel, UserMessageParams userMessageParams) {
            this.f40765a = cPCSendbirdWrapper;
            this.f40766b = chatGroupChannelDataModel;
            this.f40767c = userMessageParams;
        }

        public final void subscribe(io.reactivex.rxjava3.a.r<Datawrapper<UserMessage>> rVar) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f40766b;
            if (chatGroupChannelDataModel != null && com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl()) != null) {
                ChatUserDataModel otherMember = this.f40765a.getOtherMember(this.f40766b);
                if (otherMember != null) {
                    otherMember.isBlockedByMe();
                    otherMember.getSendbirdUsername();
                }
                kotlin.g.b.k.a((Object) rVar, "emitter");
                if (!rVar.isDisposed()) {
                    GroupChannel a2 = com.paytm.android.chat.d.a.b.a(this.f40766b.getChannelUrl());
                    UserMessage sendUserMessage = a2 != null ? a2.sendUserMessage(this.f40767c, (BaseChannel.SendUserMessageHandler) new a(rVar)) : null;
                    if (sendUserMessage != null) {
                        rVar.onNext(new Datawrapper.Success(sendUserMessage));
                    } else {
                        rVar.onNext(new Datawrapper.Failure((Throwable) null, 1, (kotlin.g.b.g) null));
                    }
                }
            }
        }

        static final class a implements BaseChannel.SendUserMessageHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ io.reactivex.rxjava3.a.r f40768a;

            a(io.reactivex.rxjava3.a.r rVar) {
                this.f40768a = rVar;
            }

            public final void onSent(final UserMessage userMessage, final SendBirdException sendBirdException) {
                io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f40769a;

                    {
                        this.f40769a = r1;
                    }

                    public final void run() {
                        io.reactivex.rxjava3.a.r rVar = this.f40769a.f40768a;
                        kotlin.g.b.k.a((Object) rVar, "emitter");
                        if (rVar.isDisposed()) {
                            return;
                        }
                        if (sendBirdException != null) {
                            this.f40769a.f40768a.onNext(new Datawrapper.Failure(sendBirdException));
                            com.paytm.utility.q.b(String.valueOf(sendBirdException.getCode()) + AppConstants.COLON + sendBirdException.getMessage());
                            return;
                        }
                        this.f40769a.f40768a.onNext(new Datawrapper.Success(userMessage));
                    }
                });
            }
        }
    }

    public io.reactivex.rxjava3.a.p<Datawrapper<UserMessage>> sendMessage(ChatGroupChannelDataModel chatGroupChannelDataModel, UserMessageParams userMessageParams) {
        io.reactivex.rxjava3.a.p<Datawrapper<UserMessage>> create = io.reactivex.rxjava3.a.p.create(new z(this, chatGroupChannelDataModel, userMessageParams));
        kotlin.g.b.k.a((Object) create, "Observable.create { emit…}\n            }\n        }");
        return create;
    }

    static final class y<T> implements io.reactivex.rxjava3.a.s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40759a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserMessage f40760b;

        y(BaseChannel baseChannel, UserMessage userMessage) {
            this.f40759a = baseChannel;
            this.f40760b = userMessage;
        }

        static final class a implements BaseChannel.ResendUserMessageHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ io.reactivex.rxjava3.a.r f40761a;

            a(io.reactivex.rxjava3.a.r rVar) {
                this.f40761a = rVar;
            }

            public final void onSent(final UserMessage userMessage, final SendBirdException sendBirdException) {
                io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f40762a;

                    {
                        this.f40762a = r1;
                    }

                    public final void run() {
                        if (sendBirdException != null) {
                            this.f40762a.f40761a.onNext(new Datawrapper.Failure(sendBirdException));
                            com.paytm.utility.q.b(String.valueOf(sendBirdException.getCode()) + AppConstants.COLON + sendBirdException.getMessage());
                            return;
                        }
                        this.f40762a.f40761a.onNext(new Datawrapper.Success(userMessage));
                    }
                });
            }
        }

        public final void subscribe(io.reactivex.rxjava3.a.r<Datawrapper<UserMessage>> rVar) {
            UserMessage resendMessage = this.f40759a.resendMessage(this.f40760b, new a(rVar));
            if (resendMessage != null) {
                rVar.onNext(new Datawrapper.Success(resendMessage));
            } else {
                rVar.onNext(new Datawrapper.Failure((Throwable) null, 1, (kotlin.g.b.g) null));
            }
        }
    }

    public io.reactivex.rxjava3.a.p<Datawrapper<UserMessage>> resendUserMessage(BaseChannel baseChannel, UserMessage userMessage) {
        kotlin.g.b.k.c(baseChannel, "channel");
        io.reactivex.rxjava3.a.p<Datawrapper<UserMessage>> subscribeOn = io.reactivex.rxjava3.a.p.create(new y(baseChannel, userMessage)).observeOn(io.reactivex.rxjava3.i.a.b()).subscribeOn(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) subscribeOn, "Observable.create<Datawr…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    static final class x<T> implements io.reactivex.rxjava3.a.s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseChannel f40752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileMessage f40753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f40754c;

        x(BaseChannel baseChannel, FileMessage fileMessage, File file) {
            this.f40752a = baseChannel;
            this.f40753b = fileMessage;
            this.f40754c = file;
        }

        static final class a implements BaseChannel.ResendFileMessageHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ io.reactivex.rxjava3.a.r f40755a;

            a(io.reactivex.rxjava3.a.r rVar) {
                this.f40755a = rVar;
            }

            public final void onSent(final FileMessage fileMessage, final SendBirdException sendBirdException) {
                io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f40756a;

                    {
                        this.f40756a = r1;
                    }

                    public final void run() {
                        if (sendBirdException != null) {
                            this.f40756a.f40755a.onNext(new Datawrapper.Failure(sendBirdException));
                            com.paytm.utility.q.b(String.valueOf(sendBirdException.getCode()) + AppConstants.COLON + sendBirdException.getMessage());
                            return;
                        }
                        this.f40756a.f40755a.onNext(new Datawrapper.Success(fileMessage));
                    }
                });
            }
        }

        public final void subscribe(io.reactivex.rxjava3.a.r<Datawrapper<FileMessage>> rVar) {
            FileMessage resendMessage = this.f40752a.resendMessage(this.f40753b, this.f40754c, (BaseChannel.ResendFileMessageHandler) new a(rVar));
            if (resendMessage != null) {
                rVar.onNext(new Datawrapper.Success(resendMessage));
            } else {
                rVar.onNext(new Datawrapper.Failure((Throwable) null, 1, (kotlin.g.b.g) null));
            }
        }
    }

    public io.reactivex.rxjava3.a.p<Datawrapper<FileMessage>> resendFileMessage(BaseChannel baseChannel, FileMessage fileMessage, File file) {
        kotlin.g.b.k.c(baseChannel, "channel");
        io.reactivex.rxjava3.a.p<Datawrapper<FileMessage>> subscribeOn = io.reactivex.rxjava3.a.p.create(new x(baseChannel, fileMessage, file)).observeOn(io.reactivex.rxjava3.i.a.b()).subscribeOn(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) subscribeOn, "Observable.create<Datawr…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public void markAsDelivered(String str) {
        SendBird.markAsDelivered(str);
    }

    static final class k<T> implements io.reactivex.rxjava3.a.ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40714a;

        k(String str) {
            this.f40714a = str;
        }

        public final void subscribe(final io.reactivex.rxjava3.a.z<GroupChannel> zVar) {
            GroupChannel.getChannel(this.f40714a, new GroupChannel.GroupChannelGetHandler() {
                public final void onResult(GroupChannel groupChannel, SendBirdException sendBirdException) {
                    io.reactivex.rxjava3.a.z zVar = zVar;
                    kotlin.g.b.k.a((Object) zVar, "emitter");
                    if (zVar.isDisposed()) {
                        return;
                    }
                    if (groupChannel != null) {
                        zVar.onSuccess(groupChannel);
                        return;
                    }
                    io.reactivex.rxjava3.a.z zVar2 = zVar;
                    Throwable th = sendBirdException;
                    if (sendBirdException == null) {
                        th = new UnsupportedOperationException("Channel is null");
                    }
                    zVar2.onError(th);
                }
            });
        }
    }

    public io.reactivex.rxjava3.a.y<GroupChannel> getSendbirdGroupChannel(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        io.reactivex.rxjava3.a.y<GroupChannel> a2 = io.reactivex.rxjava3.a.y.a(new k(str));
        kotlin.g.b.k.a((Object) a2, "Single.create { emitter …}\n            }\n        }");
        return a2;
    }

    static final class r<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.ac<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CPCSendbirdWrapper f40730a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f40731b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f40732c;

        r(CPCSendbirdWrapper cPCSendbirdWrapper, String str, String str2) {
            this.f40730a = cPCSendbirdWrapper;
            this.f40731b = str;
            this.f40732c = str2;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.y.a(new io.reactivex.rxjava3.a.ab<T>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ r f40733a;

                {
                    this.f40733a = r1;
                }

                public final void subscribe(final io.reactivex.rxjava3.a.z<ConnectionStatus> zVar) {
                    CharSequence charSequence = this.f40733a.f40731b;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        SendBird.connect(this.f40733a.f40732c, this.f40733a.f40731b, new SendBird.ConnectHandler(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ AnonymousClass1 f40734a;

                            {
                                this.f40734a = r1;
                            }

                            public final void onConnected(User user, final SendBirdException sendBirdException) {
                                if (sendBirdException == null) {
                                    com.paytm.utility.q.b("sendbird login success");
                                    final ConnectionStatus connectionStatus = new ConnectionStatus(this.f40734a.f40733a.f40732c, this.f40734a.f40733a.f40731b, true, false);
                                    io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                                        /* renamed from: a  reason: collision with root package name */
                                        final /* synthetic */ AnonymousClass1 f40736a;

                                        {
                                            this.f40736a = r1;
                                        }

                                        public final void run() {
                                            io.reactivex.rxjava3.a.z zVar = zVar;
                                            kotlin.g.b.k.a((Object) zVar, "emitter");
                                            if (!zVar.isDisposed()) {
                                                zVar.onSuccess(connectionStatus);
                                            }
                                            this.f40736a.f40734a.f40733a.f40730a.connectionStatusPublisher.onNext(new Datawrapper.Success(connectionStatus));
                                        }
                                    });
                                    return;
                                }
                                com.paytm.utility.q.b("sendbird login error -- " + sendBirdException.getCode() + AppConstants.COLON + sendBirdException.getMessage());
                                new ConnectionStatus(this.f40734a.f40733a.f40732c, (String) null, false, false);
                                io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AnonymousClass1 f40738a;

                                    {
                                        this.f40738a = r1;
                                    }

                                    public final void run() {
                                        io.reactivex.rxjava3.a.z zVar = zVar;
                                        kotlin.g.b.k.a((Object) zVar, "emitter");
                                        if (!zVar.isDisposed()) {
                                            zVar.onError(sendBirdException);
                                        }
                                        this.f40738a.f40734a.f40733a.f40730a.connectionStatusPublisher.onNext(new Datawrapper.Failure(sendBirdException));
                                    }
                                });
                            }
                        });
                    }
                }
            });
        }
    }

    static final class w<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40748a;

        w(String str) {
            this.f40748a = str;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) new io.reactivex.rxjava3.a.e(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ w f40749a;

                {
                    this.f40749a = r1;
                }

                public final void a(final io.reactivex.rxjava3.a.c cVar) {
                    SendBird.registerPushTokenForCurrentUser(this.f40749a.f40748a, (SendBird.RegisterPushTokenWithStatusHandler) new SendBird.RegisterPushTokenWithStatusHandler(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f40750a;

                        {
                            this.f40750a = r1;
                        }

                        public final void onRegistered(SendBird.PushTokenRegistrationStatus pushTokenRegistrationStatus, SendBirdException sendBirdException) {
                            if (sendBirdException != null) {
                                com.paytm.utility.q.a("push token===" + this.f40750a.f40749a.f40748a);
                                cVar.onComplete();
                            } else {
                                cVar.onError(sendBirdException);
                            }
                            com.paytm.utility.q.a("push success");
                        }
                    });
                }
            }).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class ac<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40598a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f40599b;

        ac(String str, String str2) {
            this.f40598a = str;
            this.f40599b = str2;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) new io.reactivex.rxjava3.a.e(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ac f40600a;

                {
                    this.f40600a = r1;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
                    if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1.getNickname()) != false) goto L_0x0034;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(final io.reactivex.rxjava3.a.c r4) {
                    /*
                        r3 = this;
                        com.imsdk.CPCSendbirdWrapper$ac r0 = r3.f40600a
                        java.lang.String r0 = r0.f40598a
                        if (r0 == 0) goto L_0x0034
                        com.imsdk.CPCSendbirdWrapper$ac r0 = r3.f40600a
                        java.lang.String r0 = r0.f40598a
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        int r0 = r0.length()
                        if (r0 != 0) goto L_0x0014
                        r0 = 1
                        goto L_0x0015
                    L_0x0014:
                        r0 = 0
                    L_0x0015:
                        if (r0 != 0) goto L_0x0034
                        com.sendbird.android.User r0 = com.sendbird.android.SendBird.getCurrentUser()
                        if (r0 == 0) goto L_0x0037
                        com.imsdk.CPCSendbirdWrapper$ac r0 = r3.f40600a
                        java.lang.String r0 = r0.f40598a
                        com.sendbird.android.User r1 = com.sendbird.android.SendBird.getCurrentUser()
                        java.lang.String r2 = "SendBird.getCurrentUser()"
                        kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                        java.lang.String r1 = r1.getNickname()
                        boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
                        if (r0 == 0) goto L_0x0037
                    L_0x0034:
                        r4.onComplete()
                    L_0x0037:
                        com.imsdk.CPCSendbirdWrapper$ac r0 = r3.f40600a
                        java.lang.String r0 = r0.f40598a
                        com.imsdk.CPCSendbirdWrapper$ac r1 = r3.f40600a
                        java.lang.String r1 = r1.f40599b
                        com.imsdk.CPCSendbirdWrapper$ac$1$1 r2 = new com.imsdk.CPCSendbirdWrapper$ac$1$1
                        r2.<init>(r4)
                        com.sendbird.android.SendBird$UserInfoUpdateHandler r2 = (com.sendbird.android.SendBird.UserInfoUpdateHandler) r2
                        com.sendbird.android.SendBird.updateCurrentUserInfo(r0, r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.imsdk.CPCSendbirdWrapper.ac.AnonymousClass1.a(io.reactivex.rxjava3.a.c):void");
                }
            }).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class s<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40740a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f40741b;

        s(String str, boolean z) {
            this.f40740a = str;
            this.f40741b = z;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) new io.reactivex.rxjava3.a.e(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ s f40742a;

                {
                    this.f40742a = r1;
                }

                public final void a(final io.reactivex.rxjava3.a.c cVar) {
                    try {
                        SendBird.unregisterPushTokenForCurrentUser(this.f40742a.f40740a, new SendBird.UnregisterPushTokenHandler(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ AnonymousClass1 f40743a;

                            {
                                this.f40743a = r1;
                            }

                            public final void onUnregistered(SendBirdException sendBirdException) {
                                if (this.f40743a.f40742a.f40741b) {
                                    return;
                                }
                                if (sendBirdException != null) {
                                    com.paytm.utility.q.b("sendbird logout error -- " + sendBirdException.getCode() + AppConstants.COLON + sendBirdException.getMessage());
                                    cVar.onError(sendBirdException);
                                    return;
                                }
                                cVar.onComplete();
                            }
                        });
                        if (this.f40742a.f40741b) {
                            cVar.onComplete();
                        }
                    } catch (Exception e2) {
                        cVar.onError(e2);
                    }
                }
            }).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class f<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f40700a = new f();

        f() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.b("disConnectAsync exec error");
        }
    }

    static final class d<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.f> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f40696a = new d();

        d() {
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) AnonymousClass1.f40697a).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class u<T> implements io.reactivex.rxjava3.d.g<ConnectionStatus> {

        /* renamed from: a  reason: collision with root package name */
        public static final u f40746a = new u();

        u() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.d("reConnectAsync success");
        }
    }

    static final class v<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final v f40747a = new v();

        v() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.d("reConnectAsync failure");
        }
    }

    static final class t<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.ac<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        public static final t f40745a = new t();

        t() {
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.y.a(new ConnectionStatus(SharedPreferencesUtil.getUserId(), SharedPreferencesUtil.getSBToken(), true, true));
        }
    }

    static final class h<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.ac<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40704a;

        h(String str) {
            this.f40704a = str;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.y.a(new io.reactivex.rxjava3.a.ab<T>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ h f40705a;

                {
                    this.f40705a = r1;
                }

                public final void subscribe(final io.reactivex.rxjava3.a.z<GroupChannel> zVar) {
                    kotlin.g.b.k.c(zVar, "emitter");
                    GroupChannel.getChannel(this.f40705a.f40704a, new GroupChannel.GroupChannelGetHandler() {
                        public final void onResult(GroupChannel groupChannel, SendBirdException sendBirdException) {
                            if (zVar.isDisposed()) {
                                return;
                            }
                            if (sendBirdException != null) {
                                zVar.onError(sendBirdException);
                            } else if (groupChannel != null) {
                                zVar.onSuccess(groupChannel);
                            }
                        }
                    });
                    com.paytm.utility.q.d("fetchSendBirdChannel, " + Thread.currentThread().toString());
                }
            });
        }
    }

    static final class g<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.ac<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f40701a = new g();

        g() {
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.y.a(AnonymousClass1.f40702a).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).b(AnonymousClass2.f40703a);
        }
    }

    static final class aa<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f40587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f40588b;

        aa(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z) {
            this.f40587a = chatGroupChannelDataModel;
            this.f40588b = z;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) new io.reactivex.rxjava3.a.e(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ aa f40589a;

                {
                    this.f40589a = r1;
                }

                public final void a(final io.reactivex.rxjava3.a.c cVar) {
                    GroupChannel.getChannel(this.f40589a.f40587a.getChannelUrl(), new GroupChannel.GroupChannelGetHandler(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f40590a;

                        {
                            this.f40590a = r1;
                        }

                        public final void onResult(GroupChannel groupChannel, SendBirdException sendBirdException) {
                            Throwable th;
                            if (groupChannel != null) {
                                groupChannel.setPushPreference(this.f40590a.f40589a.f40588b, new GroupChannel.GroupChannelSetPushPreferenceHandler(this) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AnonymousClass1 f40592a;

                                    {
                                        this.f40592a = r1;
                                    }

                                    public final void onResult(SendBirdException sendBirdException) {
                                        if (sendBirdException != null) {
                                            cVar.onError(sendBirdException);
                                            com.paytm.utility.q.b("sendbird setPushPreference error -- [" + sendBirdException.getCode() + "]:" + sendBirdException.getMessage());
                                            return;
                                        }
                                        cVar.onComplete();
                                    }
                                });
                                return;
                            }
                            io.reactivex.rxjava3.a.c cVar = cVar;
                            if (sendBirdException != null) {
                                th = sendBirdException;
                            } else {
                                th = new NullPointerException("GroupChannel not found with url");
                            }
                            cVar.onError(th);
                        }
                    });
                }
            }).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class ad<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f40602a;

        ad(File file) {
            this.f40602a = file;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) new io.reactivex.rxjava3.a.e(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ad f40603a;

                {
                    this.f40603a = r1;
                }

                public final void a(final io.reactivex.rxjava3.a.c cVar) {
                    String str;
                    if (SendBird.getCurrentUser() != null) {
                        User currentUser = SendBird.getCurrentUser();
                        kotlin.g.b.k.a((Object) currentUser, "SendBird.getCurrentUser()");
                        str = currentUser.getNickname();
                    } else {
                        str = "";
                    }
                    SendBird.updateCurrentUserInfoWithProfileImage(str, this.f40603a.f40602a, new SendBird.UserInfoUpdateHandler() {
                        public final void onUpdated(final SendBirdException sendBirdException) {
                            io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ AnonymousClass1 f40605a;

                                {
                                    this.f40605a = r1;
                                }

                                public final void run() {
                                    if (sendBirdException != null) {
                                        cVar.onError(sendBirdException);
                                        com.paytm.utility.q.b("sendbird updateCurrentUserInfoWithProfileImage error -- [" + sendBirdException.getCode() + "]:" + sendBirdException.getMessage());
                                        return;
                                    }
                                    User currentUser = SendBird.getCurrentUser();
                                    kotlin.g.b.k.a((Object) currentUser, "SendBird.getCurrentUser()");
                                    SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_IMG, currentUser.getProfileUrl());
                                    cVar.onComplete();
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    static final class m<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.ac<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f40719a;

        m(List list) {
            this.f40719a = list;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.y.a(new io.reactivex.rxjava3.a.ab<T>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ m f40720a;

                {
                    this.f40720a = r1;
                }

                public final void subscribe(final io.reactivex.rxjava3.a.z<List<User>> zVar) {
                    ApplicationUserListQuery createApplicationUserListQuery = SendBird.createApplicationUserListQuery();
                    createApplicationUserListQuery.setUserIdsFilter(this.f40720a.f40719a);
                    createApplicationUserListQuery.next(new UserListQuery.UserListQueryResultHandler() {
                        public final void onResult(final List<User> list, final SendBirdException sendBirdException) {
                            io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ AnonymousClass1 f40722a;

                                {
                                    this.f40722a = r1;
                                }

                                public final void run() {
                                    if (sendBirdException != null) {
                                        zVar.onError(sendBirdException);
                                        com.paytm.utility.q.b("sendbird applicationUserListQuery error -- [" + sendBirdException.getCode() + "]:" + sendBirdException.getMessage());
                                        return;
                                    }
                                    Collection collection = list;
                                    if (!(collection == null || collection.isEmpty())) {
                                        zVar.onSuccess(list);
                                    } else {
                                        zVar.onError(new NullPointerException());
                                    }
                                }
                            });
                        }
                    });
                }
            }).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class j<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.ac<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        public static final j f40708a = new j();

        j() {
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.y.a(AnonymousClass1.f40709a).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class ab<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40593a;

        ab(String str) {
            this.f40593a = str;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) new io.reactivex.rxjava3.a.e(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ab f40594a;

                {
                    this.f40594a = r1;
                }

                public final void a(final io.reactivex.rxjava3.a.c cVar) {
                    SendBird.unblockUserWithUserId(this.f40594a.f40593a, new SendBird.UserUnblockHandler() {
                        public final void onUnblocked(final SendBirdException sendBirdException) {
                            io.reactivex.rxjava3.i.a.b().a((Runnable) new Runnable(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ AnonymousClass1 f40596a;

                                {
                                    this.f40596a = r1;
                                }

                                public final void run() {
                                    if (sendBirdException != null) {
                                        cVar.onError(sendBirdException);
                                        com.paytm.utility.q.b("sendbird unblockUserWithUserId error -- [" + sendBirdException.getCode() + "]:" + sendBirdException.getMessage());
                                        return;
                                    }
                                    cVar.onComplete();
                                }
                            });
                        }
                    });
                }
            }).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.i.a.b());
        }
    }
}
