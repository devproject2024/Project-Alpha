package com.paytm;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.y;
import c.a.a.r;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.imsdk.LoginInfo;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse;
import com.paytm.android.chat.data.models.users.payments.UserInfoByIdsData;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.network.requests.RegistUserRequest;
import com.paytm.android.chat.network.response.CreateChannelResponse;
import com.paytm.android.chat.network.response.ResponseBase;
import com.paytm.android.chat.network.response.ResponseOfRegister;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.ChatGTMConstants;
import com.paytm.android.chat.utils.ChatNotificationHelper;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.q;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.UserMessage;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f40821a;

    /* renamed from: b  reason: collision with root package name */
    public static final y<Integer> f40822b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public static final a f40823c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static String f40824d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f40825e = true;

    /* renamed from: f  reason: collision with root package name */
    private static io.reactivex.rxjava3.b.c f40826f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static boolean f40827g;

    static final class l<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final l f40849a = new l();

        l() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    /* renamed from: com.paytm.a$a  reason: collision with other inner class name */
    static final class C0675a<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0675a f40828a = new C0675a();

        C0675a() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            ChatManager b2 = ChatManager.b();
            kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
            ChatRepository a2 = b2.a();
            kotlin.g.b.k.a((Object) list, "it");
            a2.updateLocalChannel((List<ChatGroupChannelDataModel>) list).b();
            return x.f47997a;
        }
    }

    static final class e extends kotlin.g.b.l implements kotlin.g.a.b<LoginInfo, x> {
        final /* synthetic */ kotlin.g.a.a $alreadyConnected$inlined;
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ kotlin.g.a.m $failure$inlined;
        final /* synthetic */ kotlin.g.a.m $success$inlined;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(kotlin.g.a.a aVar, Context context, kotlin.g.a.m mVar, kotlin.g.a.m mVar2) {
            super(1);
            this.$alreadyConnected$inlined = aVar;
            this.$context$inlined = context;
            this.$failure$inlined = mVar;
            this.$success$inlined = mVar2;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LoginInfo) obj);
            return x.f47997a;
        }

        public final void invoke(LoginInfo loginInfo) {
            q.d("registerAndConnectSendBird sucess connect");
            kotlin.g.a.m mVar = this.$success$inlined;
            if (mVar != null) {
                mVar.invoke(null, loginInfo);
            }
        }
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.m<Integer, String, x> {
        final /* synthetic */ kotlin.g.a.a $alreadyConnected$inlined;
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ kotlin.g.a.m $failure$inlined;
        final /* synthetic */ kotlin.g.a.m $success$inlined;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(kotlin.g.a.a aVar, Context context, kotlin.g.a.m mVar, kotlin.g.a.m mVar2) {
            super(2);
            this.$alreadyConnected$inlined = aVar;
            this.$context$inlined = context;
            this.$failure$inlined = mVar;
            this.$success$inlined = mVar2;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (String) obj2);
            return x.f47997a;
        }

        public final void invoke(int i2, String str) {
            q.d("registerAndConnectSendBird failed connect\nerrorCode: " + i2 + "\nmsg: " + str);
            kotlin.g.a.m mVar = this.$failure$inlined;
            if (mVar != null) {
                mVar.invoke(Integer.valueOf(i2), str);
            }
        }
    }

    static final class j<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final j f40847a = new j();

        j() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            Integer num = (Integer) obj;
            q.d("getUnreadMessageCountObserver ".concat(String.valueOf(num)));
            return num;
        }
    }

    static final class k<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f40848a = new k();

        k() {
        }

        public final /* synthetic */ void accept(Object obj) {
            a aVar = a.f40823c;
            a.f40822b.postValue((Integer) obj);
        }
    }

    private a() {
    }

    public static final /* synthetic */ Context d() {
        Context context = f40821a;
        if (context == null) {
            kotlin.g.b.k.a("context");
        }
        return context;
    }

    public static void a(String str) {
        f40824d = str;
    }

    public static void a(boolean z) {
        f40825e = z;
    }

    public static /* synthetic */ void a(Context context, kotlin.g.a.a aVar, kotlin.g.a.m mVar, int i2) {
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        if ((i2 & 4) != 0) {
            mVar = null;
        }
        a(context, (kotlin.g.a.a<x>) aVar, (kotlin.g.a.m<? super ResponseOfRegister, ? super LoginInfo, x>) mVar, (kotlin.g.a.m<? super Integer, ? super String, x>) null);
    }

    public static void a(Context context, kotlin.g.a.a<x> aVar, kotlin.g.a.m<? super ResponseOfRegister, ? super LoginInfo, x> mVar, kotlin.g.a.m<? super Integer, ? super String, x> mVar2) {
        if (context != null) {
            ChatManager b2 = ChatManager.b();
            kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
            if (!b2.a().isSenbirdWSConnected()) {
                boolean r = com.paytm.utility.b.r(context);
                q.d("registerAndConnectSendBird ".concat(String.valueOf(r)));
                if (r) {
                    kotlin.g.b.k.a((Object) ChatManager.b(), "ChatManager.getInstance()");
                    if (!ChatManager.h() || !AppUtilKt.checkIfRegisterIsUptoDateWithVersion()) {
                        SharedPreferencesUtil.updateUserData(context);
                        AppUtilKt.registerChatToServer(context, new g(aVar, context, mVar2, mVar));
                        return;
                    }
                    AppUtilKt.connectChatToServer(context, new e(aVar, context, mVar2, mVar), new f(aVar, context, mVar2, mVar));
                } else if (mVar2 != null) {
                    mVar2.invoke(666, null);
                }
            } else if (aVar != null) {
                aVar.invoke();
            }
        }
    }

    public static final class g implements RegistUserRequest.PFRegistCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.a f40843a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f40844b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.m f40845c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.m f40846d;

        g(kotlin.g.a.a aVar, Context context, kotlin.g.a.m mVar, kotlin.g.a.m mVar2) {
            this.f40843a = aVar;
            this.f40844b = context;
            this.f40845c = mVar;
            this.f40846d = mVar2;
        }

        public final void onSuccess(ResponseOfRegister responseOfRegister) {
            ChatManager b2 = ChatManager.b();
            kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
            com.paytm.android.chat.d g2 = b2.g();
            kotlin.g.b.k.a((Object) g2, "ChatManager.getInstance().chatGenericListener");
            SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.LAST_REGISTER_CALLED_FOR_VERSION, g2.a());
            q.d("registerAndConnectSendBird success register");
            kotlin.g.a.m mVar = this.f40846d;
            if (mVar != null) {
                mVar.invoke(responseOfRegister, null);
            }
        }

        public final void onFailure(int i2, String str) {
            q.d("registerAndConnectSendBird failed register\nerrorCode: " + i2 + "\nmsg: " + str);
            kotlin.g.a.m mVar = this.f40845c;
            if (mVar != null) {
                mVar.invoke(Integer.valueOf(i2), str);
            }
        }
    }

    public static CreateChannelResponse a(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2, String str, String str2) {
        kotlin.g.b.k.c(chatPayeeUser, "sender");
        kotlin.g.b.k.c(chatPayeeUser2, "receiver");
        String a2 = new com.google.gsonhtcfix.f().a((Object) chatPayeeUser2);
        q.d("Request\n".concat(String.valueOf(a2)));
        RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), a2);
        String url = UrlManager.getUrl(UrlProfileList.REGIST_SENDBIRD_V2);
        r.a(url);
        Uri.parse(url).buildUpon().appendQueryParameter("chat-type", str).appendQueryParameter("source", str2).build();
        Request build = new Request.Builder().url(url).post(create).headers(new Headers.Builder().add(AppConstants.SSO_TOKEN, SharedPreferencesUtil.getToken()).build()).build();
        c.a.a.j b2 = c.a.a.j.b();
        kotlin.g.b.k.a((Object) b2, "OkHttpFinal.getInstance()");
        try {
            Response execute = FirebasePerfOkHttpClient.execute(b2.c().newCall(build));
            CreateChannelResponse.Companion companion = CreateChannelResponse.Companion;
            kotlin.g.b.k.a((Object) execute, Payload.RESPONSE);
            return companion.createFromResponse(execute);
        } catch (Exception unused) {
            return null;
        }
    }

    public static GetUserInfoByIdsResponse a(List<String> list) {
        kotlin.g.b.k.c(list, "list");
        com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
        String a2 = fVar.a((Object) list);
        q.d("Request\n".concat(String.valueOf(a2)));
        RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), a2);
        String url = UrlManager.getUrl(UrlProfileList.GET_USER_INFO_BY_ID);
        r.a(url);
        Request build = new Request.Builder().url(url).post(create).headers(new Headers.Builder().add(AppConstants.SSO_TOKEN, SharedPreferencesUtil.getToken()).build()).build();
        c.a.a.j b2 = c.a.a.j.b();
        kotlin.g.b.k.a((Object) b2, "OkHttpFinal.getInstance()");
        try {
            Response execute = FirebasePerfOkHttpClient.execute(b2.c().newCall(build));
            kotlin.g.b.k.a((Object) execute, Payload.RESPONSE);
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                String string = body != null ? body.string() : null;
                q.d("response\n".concat(String.valueOf(string)));
                Object a3 = fVar.a(string, GetUserInfoByIdsResponse.class);
                ((GetUserInfoByIdsResponse) a3).setStatusCode(execute.code());
                return (GetUserInfoByIdsResponse) a3;
            }
            GetUserInfoByIdsResponse getUserInfoByIdsResponse = new GetUserInfoByIdsResponse((UserInfoByIdsData) null, 1, (kotlin.g.b.g) null);
            getUserInfoByIdsResponse.setStatusCode(execute.code());
            return getUserInfoByIdsResponse;
        } catch (Exception unused) {
            return null;
        }
    }

    public static ResponseBase a(TxNotifyData txNotifyData) {
        kotlin.g.b.k.c(txNotifyData, "requestBody");
        com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
        String a2 = fVar.a((Object) txNotifyData);
        q.d("Request\n".concat(String.valueOf(a2)));
        String url = UrlManager.getUrl("/pcchat/api/user/txNotify");
        RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), a2);
        String a3 = com.paytm.android.chat.e.a().a(ChatGTMConstants.CHAT_NOTIFY_PAYMENT_STATUS, url);
        r.a(a3);
        Headers.Builder add = new Headers.Builder().add(AppManagerUtil.EXTEND_PREFIX_DEFAULT, "paytm");
        String token = SharedPreferencesUtil.getToken();
        if (token == null) {
            token = "";
        }
        Request build = new Request.Builder().url(a3).post(create).headers(add.add(AppConstants.SSO_TOKEN, token).build()).build();
        c.a.a.j b2 = c.a.a.j.b();
        kotlin.g.b.k.a((Object) b2, "OkHttpFinal.getInstance()");
        try {
            Response execute = FirebasePerfOkHttpClient.execute(b2.c().newCall(build));
            kotlin.g.b.k.a((Object) execute, Payload.RESPONSE);
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                String string = body != null ? body.string() : null;
                q.d("response\n".concat(String.valueOf(string)));
                return (ResponseBase) fVar.a(string, ResponseBase.class);
            }
            ResponseBase responseBase = new ResponseBase();
            responseBase.setSuccess(false);
            return responseBase;
        } catch (Exception unused) {
            return null;
        }
    }

    static final class d<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f40841a;

        d(List list) {
            this.f40841a = list;
        }

        public final void subscribe(final z<Boolean> zVar) {
            Collection collection = this.f40841a;
            if (collection == null || collection.isEmpty()) {
                kotlin.g.b.k.a((Object) zVar, "emitter");
                if (!zVar.isDisposed()) {
                    zVar.onSuccess(Boolean.FALSE);
                    return;
                }
                return;
            }
            Iterable<ChatGroupChannelDataModel> iterable = this.f40841a;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (ChatGroupChannelDataModel channelUrl : iterable) {
                arrayList.add(channelUrl.getChannelUrl());
            }
            SendBird.markAsReadWithChannelUrls((List) arrayList, new SendBird.MarkAsReadHandler() {
                public final void onResult(SendBirdException sendBirdException) {
                    z zVar = zVar;
                    kotlin.g.b.k.a((Object) zVar, "emitter");
                    if (!zVar.isDisposed()) {
                        if (sendBirdException != null) {
                            zVar.onSuccess(Boolean.FALSE);
                        }
                        if (sendBirdException != null) {
                            zVar.onSuccess(Boolean.TRUE);
                        }
                    }
                }
            });
        }
    }

    public static io.reactivex.rxjava3.a.y<Boolean> b(List<ChatGroupChannelDataModel> list) {
        io.reactivex.rxjava3.a.y<Boolean> a2 = io.reactivex.rxjava3.a.y.a(new d(list)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a());
        kotlin.g.b.k.a((Object) a2, "Single.create<Boolean> {…dSchedulers.mainThread())");
        return a2;
    }

    public static void a() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new h((kotlin.d.d) null), 2, (Object) null);
    }

    public static void b() {
        io.reactivex.rxjava3.b.c cVar = f40826f;
        if (cVar != null) {
            cVar.dispose();
        }
        ChatManager b2 = ChatManager.b();
        kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
        f40826f = b2.a().observeUnreadCountOnLocalChannels().a(j.f40847a).d().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(k.f40848a, (io.reactivex.rxjava3.d.g<? super Throwable>) l.f40849a);
    }

    public static final class i extends SendBird.ChannelHandler {
        i() {
        }

        public final void onMessageReceived(BaseChannel baseChannel, BaseMessage baseMessage) {
            MessageDBHelperKt.insertOrUpdateMessage(baseChannel, baseMessage);
            a aVar = a.f40823c;
            a.a(baseChannel, baseMessage);
        }

        public final void onChannelDeleted(String str, BaseChannel.ChannelType channelType) {
            if (str != null) {
                ChatManager b2 = ChatManager.b();
                kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
                b2.a().deleteLocalChannel(str);
            }
        }

        public final void onMessageDeleted(BaseChannel baseChannel, long j) {
            MessageDBHelperKt.deleteMessage(j);
        }

        public final void onMessageUpdated(BaseChannel baseChannel, BaseMessage baseMessage) {
            MessageDBHelperKt.insertOrUpdateMessage(baseChannel, baseMessage);
        }

        public final void onChannelChanged(BaseChannel baseChannel) {
            if (baseChannel != null) {
                ChatManager b2 = ChatManager.b();
                kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
                b2.a().updateLocalChannel(baseChannel);
            }
        }
    }

    public static void c() {
        SendBird.addChannelHandler("SendBirdHelper.COMMON_CHANNEL_HANDLER", new i());
    }

    static final class m implements io.reactivex.rxjava3.a.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f40850a;

        m(Map map) {
            this.f40850a = map;
        }

        public final void a(final io.reactivex.rxjava3.a.c cVar) {
            SendBird.uploadFriendDiscoveries(this.f40850a, new SendBird.UploadFriendDiscoveriesHandler() {
                public final void onResult(SendBirdException sendBirdException) {
                    if (sendBirdException == null) {
                        cVar.onComplete();
                    } else {
                        cVar.onError(sendBirdException);
                    }
                }
            });
        }
    }

    public static io.reactivex.rxjava3.a.b a(Map<String, String> map) {
        kotlin.g.b.k.c(map, "discoveryMap");
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((io.reactivex.rxjava3.a.e) new m(map)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) a2, "Completable.create { emi…bserveOn(Schedulers.io())");
        return a2;
    }

    @kotlin.d.b.a.f(b = "SendBirdHelper.kt", c = {}, d = "invokeSuspend", e = "com.paytm.SendBirdHelper$registerAndFetchAllChannels$1")
    static final class h extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;

        h(kotlin.d.d dVar) {
            super(2, dVar);
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            h hVar = new h(dVar);
            hVar.p$ = (CoroutineScope) obj;
            return hVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((h) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                a aVar2 = a.f40823c;
                a.a(a.d(), (kotlin.g.a.a) AnonymousClass1.INSTANCE, (kotlin.g.a.m) AnonymousClass2.INSTANCE, 8);
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final /* synthetic */ void e() {
        if (!f40827g) {
            f40827g = true;
            ChatManager b2 = ChatManager.b();
            kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
            b2.a().fetchChannelList().b(C0675a.f40828a).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(b.f40839a, (io.reactivex.rxjava3.d.g<? super Throwable>) c.f40840a);
        }
    }

    static final class b<T> implements io.reactivex.rxjava3.d.g<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f40839a = new b();

        b() {
        }

        public final /* synthetic */ void accept(Object obj) {
            a aVar = a.f40823c;
            a.f40827g = false;
        }
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f40840a = new c();

        c() {
        }

        public final /* synthetic */ void accept(Object obj) {
            a aVar = a.f40823c;
            a.f40827g = false;
        }
    }

    public static final /* synthetic */ void a(BaseChannel baseChannel, BaseMessage baseMessage) {
        if (f40825e) {
            String str = f40824d;
            if (str != null) {
                if (p.a(str, baseChannel != null ? baseChannel.getUrl() : null, false)) {
                    return;
                }
            }
            if ((baseMessage instanceof UserMessage) || (baseMessage instanceof FileMessage)) {
                ChatNotificationHelper chatNotificationHelper = ChatNotificationHelper.INSTANCE;
                Context context = f40821a;
                if (context == null) {
                    kotlin.g.b.k.a("context");
                }
                chatNotificationHelper.postNotification(context, baseChannel, baseMessage);
            }
        }
    }
}
