package com.paytm.android.chat.h;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import androidx.recyclerview.widget.h;
import c.a.a.c;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.imsdk.CPCSendbirdWrapper;
import com.imsdk.Datawrapper;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.ChatType;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.RegistrationStatus;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.SendContactBean;
import com.paytm.android.chat.bean.SettingsInfoBean;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.bean.jsonbean.FileDataBean;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse;
import com.paytm.android.chat.data.models.users.payments.UserInfoByIdsData;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.g.a;
import com.paytm.android.chat.network.response.ResponseBase;
import com.paytm.android.chat.utils.CPCMessageUtilsKt;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.ChatVariantUtilKt;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.FileUtils;
import com.paytm.android.chat.utils.MessageAdapterEvent;
import com.paytm.android.chat.utils.MessageDiffUtil;
import com.paytm.android.chat.utils.NetUtils;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.utils.TopActivityManager;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.FileMessage;
import com.sendbird.android.FileMessageParams;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.MessageListParams;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.Sender;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import com.sendbird.android.UserMessageParams;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class a extends com.paytm.android.chat.base.f<com.paytm.android.chat.g.a> {
    /* access modifiers changed from: private */
    public boolean A;
    private boolean B = true;
    private final String C = "LOG_TAG";

    /* renamed from: a  reason: collision with root package name */
    public ChatGroupChannelDataModel f42166a;

    /* renamed from: b  reason: collision with root package name */
    String f42167b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f42168c = new Gson();

    /* renamed from: d  reason: collision with root package name */
    public String f42169d;

    /* renamed from: e  reason: collision with root package name */
    public io.reactivex.rxjava3.b.c f42170e;

    /* renamed from: f  reason: collision with root package name */
    public io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> f42171f = io.reactivex.rxjava3.j.a.a();

    /* renamed from: g  reason: collision with root package name */
    public GetUserInfoByIdsResponse f42172g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42173h;

    /* renamed from: i  reason: collision with root package name */
    public final ChatRepository f42174i;
    private io.reactivex.rxjava3.b.c j;
    private io.reactivex.rxjava3.b.c k;
    /* access modifiers changed from: private */
    public final String l = "VPCGroupChatViewModel";
    private SettingsInfoBean m = com.paytm.android.chat.c.f();
    private ChatUserDataModel n;
    /* access modifiers changed from: private */
    public List<String> o = new ArrayList();
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public long r = Long.MAX_VALUE;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public String t;
    private io.reactivex.rxjava3.b.c u;
    /* access modifiers changed from: private */
    public List<? extends ChatMessageDataModel> v = new ArrayList();
    private Handler w = new Handler();
    private final int x = 30;
    private final String y = "CONNECTION_HANDLER_GROUP_CHAT";
    private final String z = "CHANNEL_HANDLER_GROUP_CHANNEL_CHAT";

    static final class af<T> implements io.reactivex.rxjava3.d.g<ResponseBase> {

        /* renamed from: a  reason: collision with root package name */
        public static final af f42199a = new af();

        af() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class ag<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final ag f42200a = new ag();

        ag() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public static final class am<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final am f42206a = new am();

        am() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public static final class ap extends com.google.gsonhtcfix.c.a<List<? extends SelectContactsBean>> {
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f42223a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class e<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f42225a = new e();

        e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class f implements BaseChannel.DeleteMessageHandler {

        /* renamed from: a  reason: collision with root package name */
        public static final f f42226a = new f();

        f() {
        }

        public final void onResult(SendBirdException sendBirdException) {
        }
    }

    /* renamed from: com.paytm.android.chat.h.a$a  reason: collision with other inner class name */
    static final class C0700a<T> implements io.reactivex.rxjava3.d.q<CPCSendbirdWrapper.ChannelUpdate> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0700a f42177a = new C0700a();

        C0700a() {
        }

        public final /* bridge */ /* synthetic */ boolean test(Object obj) {
            CPCSendbirdWrapper.ChannelUpdate channelUpdate = (CPCSendbirdWrapper.ChannelUpdate) obj;
            return (channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.MessageReceived) || (channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.ReadReceiptUpdated) || (channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.DeliveryReceiptUpdated) || (channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.TypingStatusUpdated);
        }
    }

    static final class ab<T> implements io.reactivex.rxjava3.d.g<GetUserInfoByIdsResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ChatUserDataModel f42193b;

        ab(a aVar, ChatUserDataModel chatUserDataModel) {
            this.f42192a = aVar;
            this.f42193b = chatUserDataModel;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42192a.f42171f.onNext(new a.z(this.f42193b, this.f42192a.f42166a, new com.paytm.android.chat.e.c(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ab f42194a;

                /* renamed from: com.paytm.android.chat.h.a$ab$1$b */
                static final class b<T> implements io.reactivex.rxjava3.d.g<Throwable> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final b f42196a = new b();

                    b() {
                    }

                    public final /* bridge */ /* synthetic */ void accept(Object obj) {
                    }
                }

                /* renamed from: com.paytm.android.chat.h.a$ab$1$a  reason: collision with other inner class name */
                static final class C0702a<T> implements io.reactivex.rxjava3.d.g<ChatGroupChannelDataModel> {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f42195a;

                    C0702a(AnonymousClass1 r1) {
                        this.f42195a = r1;
                    }

                    public final /* synthetic */ void accept(Object obj) {
                        ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
                        kotlin.g.b.k.c(chatGroupChannelDataModel, "result");
                        this.f42195a.f42194a.f42192a.f42166a = chatGroupChannelDataModel;
                        this.f42195a.f42194a.f42192a.f42171f.onNext(new a.y(chatGroupChannelDataModel));
                    }
                }

                {
                    this.f42194a = r1;
                }

                public final void a() {
                    ChatRepository chatRepository = this.f42194a.f42192a.f42174i;
                    String str = this.f42194a.f42192a.f42169d;
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    chatRepository.fetchChannelForDisplay(str).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new C0702a(this), (io.reactivex.rxjava3.d.g<? super Throwable>) b.f42196a);
                }

                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
                    if ((r5.length() == 0) != false) goto L_0x0069;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x00be, code lost:
                    if (r6 != false) goto L_0x00c0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void b() {
                    /*
                        r8 = this;
                        com.paytm.android.chat.utils.ContactManager r0 = com.paytm.android.chat.utils.ContactManager.getInstance()
                        com.paytm.android.chat.h.a$ab r1 = r8.f42194a
                        com.paytm.android.chat.h.a r1 = r1.f42192a
                        java.lang.String r1 = r1.f42169d
                        com.paytm.android.chat.bean.daobean.SyncContactBean r0 = r0.searchContactDBByUrl(r1)
                        if (r0 == 0) goto L_0x0114
                        java.lang.String r1 = r0.getPtId()
                        if (r1 == 0) goto L_0x0114
                        java.lang.String r1 = r0.getPtId()
                        com.paytm.android.chat.h.a$ab r2 = r8.f42194a
                        com.paytm.android.chat.h.a r2 = r2.f42192a
                        java.lang.String unused = r2.l
                        java.lang.String r2 = java.lang.String.valueOf(r1)
                        java.lang.String r3 = "chat_log otherPtId:"
                        java.lang.String r2 = r3.concat(r2)
                        com.paytm.utility.q.a(r2)
                        if (r1 == 0) goto L_0x0114
                        java.lang.String r2 = "-1"
                        r4 = 0
                        boolean r5 = kotlin.m.p.b(r1, r2, r4)
                        if (r5 != 0) goto L_0x0041
                        java.lang.String r5 = "-2"
                        boolean r5 = kotlin.m.p.b(r1, r5, r4)
                        if (r5 == 0) goto L_0x0114
                    L_0x0041:
                        com.paytm.android.chat.h.a$ab r5 = r8.f42194a
                        com.paytm.android.chat.h.a r5 = r5.f42192a
                        r5.p = true
                        com.paytm.android.chat.h.a$ab r5 = r8.f42194a
                        com.paytm.android.chat.h.a r5 = r5.f42192a
                        java.lang.String r5 = r5.f42167b
                        r6 = 1
                        if (r5 == 0) goto L_0x0069
                        com.paytm.android.chat.h.a$ab r5 = r8.f42194a
                        com.paytm.android.chat.h.a r5 = r5.f42192a
                        java.lang.String r5 = r5.f42167b
                        if (r5 != 0) goto L_0x005c
                        kotlin.g.b.k.a()
                    L_0x005c:
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        int r5 = r5.length()
                        if (r5 != 0) goto L_0x0066
                        r5 = 1
                        goto L_0x0067
                    L_0x0066:
                        r5 = 0
                    L_0x0067:
                        if (r5 == 0) goto L_0x00da
                    L_0x0069:
                        com.paytm.android.chat.h.a$ab r5 = r8.f42194a
                        com.paytm.android.chat.h.a r5 = r5.f42192a
                        java.lang.String unused = r5.l
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        java.lang.String r7 = "chat_log syncContactBean.getContactPhone():"
                        r5.<init>(r7)
                        java.lang.String r7 = r0.getContactPhone()
                        r5.append(r7)
                        java.lang.String r5 = r5.toString()
                        com.paytm.utility.q.a(r5)
                        com.paytm.android.chat.h.a$ab r5 = r8.f42194a
                        com.paytm.android.chat.h.a r5 = r5.f42192a
                        java.lang.String unused = r5.l
                        java.lang.String r5 = java.lang.String.valueOf(r1)
                        java.lang.String r3 = r3.concat(r5)
                        com.paytm.utility.q.a(r3)
                        com.paytm.android.chat.h.a$ab r3 = r8.f42194a
                        com.paytm.android.chat.h.a r3 = r3.f42192a
                        java.lang.String r0 = r0.getContactPhone()
                        r3.f42167b = r0
                        com.paytm.android.chat.h.a$ab r0 = r8.f42194a
                        com.paytm.android.chat.h.a r0 = r0.f42192a
                        java.lang.String r0 = r0.f42167b
                        if (r0 == 0) goto L_0x00c0
                        com.paytm.android.chat.h.a$ab r0 = r8.f42194a
                        com.paytm.android.chat.h.a r0 = r0.f42192a
                        java.lang.String r0 = r0.f42167b
                        if (r0 != 0) goto L_0x00b4
                        kotlin.g.b.k.a()
                    L_0x00b4:
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        int r0 = r0.length()
                        if (r0 != 0) goto L_0x00bd
                        goto L_0x00be
                    L_0x00bd:
                        r6 = 0
                    L_0x00be:
                        if (r6 == 0) goto L_0x00da
                    L_0x00c0:
                        boolean r0 = kotlin.m.p.b(r1, r2, r4)
                        if (r0 == 0) goto L_0x00da
                        com.paytm.android.chat.h.a$ab r0 = r8.f42194a
                        com.paytm.android.chat.h.a r0 = r0.f42192a
                        int r2 = r1.length()
                        r3 = 2
                        java.lang.String r1 = r1.substring(r3, r2)
                        java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                        kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                        r0.f42167b = r1
                    L_0x00da:
                        com.paytm.android.chat.h.a$ab r0 = r8.f42194a
                        com.paytm.android.chat.h.a r0 = r0.f42192a
                        com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = r0.f42166a
                        r1 = 0
                        if (r0 == 0) goto L_0x00e8
                        com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r0.getReceiverDisplayInfo()
                        goto L_0x00e9
                    L_0x00e8:
                        r0 = r1
                    L_0x00e9:
                        com.paytm.android.chat.h.a$ab r2 = r8.f42194a
                        com.paytm.android.chat.h.a r2 = r2.f42192a
                        io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r2 = r2.f42171f
                        if (r0 == 0) goto L_0x00fc
                        java.lang.String r0 = r0.getName()
                        if (r0 == 0) goto L_0x00fc
                        com.paytm.android.chat.g.a$t r1 = new com.paytm.android.chat.g.a$t
                        r1.<init>(r0)
                    L_0x00fc:
                        r2.onNext(r1)
                        com.paytm.android.chat.h.a$ab r0 = r8.f42194a
                        com.paytm.android.chat.h.a r0 = r0.f42192a
                        io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r0 = r0.f42171f
                        com.paytm.android.chat.g.a$s r1 = new com.paytm.android.chat.g.a$s
                        r1.<init>(r4)
                        r0.onNext(r1)
                        com.paytm.android.chat.h.a$ab r0 = r8.f42194a
                        com.paytm.android.chat.h.a r0 = r0.f42192a
                        r0.q = true
                    L_0x0114:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.a.ab.AnonymousClass1.b():void");
                }
            }, (GetUserInfoByIdsResponse) obj));
        }
    }

    static final class ah<T, R> implements io.reactivex.rxjava3.d.h<T, io.reactivex.rxjava3.a.ac<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42201a;

        ah(a aVar) {
            this.f42201a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            kotlin.g.b.k.c(chatGroupChannelDataModel, "chatGroupChannel");
            if (com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl()) != null) {
                return this.f42201a.f42174i.fetchAndUpdateDeletedMessages(chatGroupChannelDataModel).a(io.reactivex.rxjava3.a.y.a(chatGroupChannelDataModel));
            }
            return io.reactivex.rxjava3.a.y.a(chatGroupChannelDataModel);
        }
    }

    static final class ai<T> implements io.reactivex.rxjava3.d.g<ChatGroupChannelDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42202a;

        ai(a aVar) {
            this.f42202a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            kotlin.g.b.k.c(chatGroupChannelDataModel, "chatGroupChannel");
            this.f42202a.A = false;
            String unused = this.f42202a.l;
            com.paytm.utility.q.d("fetchChannel success " + chatGroupChannelDataModel.getChannelUrl());
            a aVar = this.f42202a;
            aVar.f42166a = chatGroupChannelDataModel;
            aVar.i();
            ChatGroupChannelDataModel chatGroupChannelDataModel2 = this.f42202a.f42166a;
            if (chatGroupChannelDataModel2 != null) {
                this.f42202a.f42171f.onNext(new a.C0697a(chatGroupChannelDataModel2));
            }
            this.f42202a.b(false);
        }
    }

    static final class aj<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42203a;

        aj(a aVar) {
            this.f42203a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Throwable th = (Throwable) obj;
            this.f42203a.A = false;
            String unused = this.f42203a.l;
            StringBuilder sb = new StringBuilder("fetchSendBirdChannel Fail ");
            sb.append(th != null ? th.getLocalizedMessage() : null);
            com.paytm.utility.q.c(sb.toString());
            if ((th instanceof SendBirdException) && ((SendBirdException) th).getCode() == 400201) {
                ContactManager.getInstance().clearContact(this.f42203a.f42169d);
            }
            this.f42203a.f42171f.onNext(new a.d());
        }
    }

    public static final class al<T> implements io.reactivex.rxjava3.d.g<Datawrapper<? super UserMessage>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GroupChannel f42205a;

        public al(GroupChannel groupChannel) {
            this.f42205a = groupChannel;
        }

        public final /* synthetic */ void accept(Object obj) {
            Datawrapper datawrapper = (Datawrapper) obj;
            if (datawrapper instanceof Datawrapper.Success) {
                MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) this.f42205a, (BaseMessage) ((Datawrapper.Success) datawrapper).getData());
            }
        }
    }

    public static final class an<T> implements io.reactivex.rxjava3.d.g<Datawrapper<? super FileMessage>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42207a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GroupChannel f42208b;

        public an(a aVar, GroupChannel groupChannel) {
            this.f42207a = aVar;
            this.f42208b = groupChannel;
        }

        public final /* synthetic */ void accept(Object obj) {
            Datawrapper datawrapper = (Datawrapper) obj;
            if (datawrapper instanceof Datawrapper.Success) {
                MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) this.f42208b, (BaseMessage) (FileMessage) ((Datawrapper.Success) datawrapper).getData());
                return;
            }
            String unused = this.f42207a.l;
            StringBuilder sb = new StringBuilder("resendFileMessage failure ");
            Throwable th = null;
            if (!(datawrapper instanceof Datawrapper.Failure)) {
                datawrapper = null;
            }
            Datawrapper.Failure failure = (Datawrapper.Failure) datawrapper;
            if (failure != null) {
                th = failure.getFailure();
            }
            sb.append(th);
            com.paytm.utility.q.b(sb.toString());
        }
    }

    public static final class ao<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42209a;

        public ao(a aVar) {
            this.f42209a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String unused = this.f42209a.l;
            com.paytm.utility.q.b("resendFileMessage failure ".concat(String.valueOf((Throwable) obj)));
        }
    }

    static final class av<T> implements io.reactivex.rxjava3.d.g<Datawrapper<? super UserMessage>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42215a;

        av(a aVar) {
            this.f42215a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
            r0 = (r0 = r0.getChatType()).name();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void accept(java.lang.Object r4) {
            /*
                r3 = this;
                com.imsdk.Datawrapper r4 = (com.imsdk.Datawrapper) r4
                boolean r0 = r4 instanceof com.imsdk.Datawrapper.Success
                if (r0 == 0) goto L_0x0032
                com.imsdk.Datawrapper$Success r4 = (com.imsdk.Datawrapper.Success) r4
                java.lang.Object r4 = r4.getData()
                com.sendbird.android.UserMessage r4 = (com.sendbird.android.UserMessage) r4
                com.paytm.android.chat.h.a r0 = r3.f42215a
                java.lang.String r0 = r0.f42169d
                if (r0 != 0) goto L_0x0017
                kotlin.g.b.k.a()
            L_0x0017:
                com.sendbird.android.GroupChannel r0 = com.paytm.android.chat.d.a.b.a(r0)
                if (r0 == 0) goto L_0x0060
                com.paytm.android.chat.h.a r0 = r3.f42215a
                java.lang.String r0 = r0.f42169d
                if (r0 != 0) goto L_0x0026
                kotlin.g.b.k.a()
            L_0x0026:
                com.sendbird.android.GroupChannel r0 = com.paytm.android.chat.d.a.b.a(r0)
                com.sendbird.android.BaseChannel r0 = (com.sendbird.android.BaseChannel) r0
                com.sendbird.android.BaseMessage r4 = (com.sendbird.android.BaseMessage) r4
                com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.insertOrUpdateMessage((com.sendbird.android.BaseChannel) r0, (com.sendbird.android.BaseMessage) r4)
                return
            L_0x0032:
                if (r4 == 0) goto L_0x0061
                com.imsdk.Datawrapper$Failure r4 = (com.imsdk.Datawrapper.Failure) r4
                java.lang.Throwable r4 = r4.getFailure()
                if (r4 == 0) goto L_0x0060
                com.paytm.android.chat.h.a r4 = r3.f42215a
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r4 = r4.f42171f
                com.paytm.android.chat.h.a r0 = r3.f42215a
                com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r0.e()
                if (r0 == 0) goto L_0x005c
                com.paytm.android.chat.bean.ChatType r0 = r0.getChatType()
                if (r0 == 0) goto L_0x005c
                java.lang.String r0 = r0.name()
                if (r0 == 0) goto L_0x005c
                com.paytm.android.chat.g.a$f r1 = new com.paytm.android.chat.g.a$f
                java.lang.String r2 = "Text"
                r1.<init>(r0, r2)
                goto L_0x005d
            L_0x005c:
                r1 = 0
            L_0x005d:
                r4.onNext(r1)
            L_0x0060:
                return
            L_0x0061:
                kotlin.u r4 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type com.imsdk.Datawrapper.Failure<com.sendbird.android.UserMessage>"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.a.av.accept(java.lang.Object):void");
        }
    }

    static final class aw<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42216a;

        aw(a aVar) {
            this.f42216a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            r0 = (r0 = r0.getChatType()).name();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void accept(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                if (r4 == 0) goto L_0x0028
                com.paytm.android.chat.h.a r4 = r3.f42216a
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r4 = r4.f42171f
                com.paytm.android.chat.h.a r0 = r3.f42216a
                com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r0.e()
                if (r0 == 0) goto L_0x0024
                com.paytm.android.chat.bean.ChatType r0 = r0.getChatType()
                if (r0 == 0) goto L_0x0024
                java.lang.String r0 = r0.name()
                if (r0 == 0) goto L_0x0024
                com.paytm.android.chat.g.a$f r1 = new com.paytm.android.chat.g.a$f
                java.lang.String r2 = "Text"
                r1.<init>(r0, r2)
                goto L_0x0025
            L_0x0024:
                r1 = 0
            L_0x0025:
                r4.onNext(r1)
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.a.aw.accept(java.lang.Object):void");
        }
    }

    public static final class ax<T, R> implements io.reactivex.rxjava3.d.h<T, io.reactivex.rxjava3.a.u<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42217a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserMessageParams f42218b;

        public ax(a aVar, UserMessageParams userMessageParams) {
            this.f42217a = aVar;
            this.f42218b = userMessageParams;
        }

        public final /* synthetic */ Object apply(Object obj) {
            final ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            return this.f42217a.f42174i.sendMessage(chatGroupChannelDataModel, this.f42218b).map(new io.reactivex.rxjava3.d.h<T, R>() {
                public final /* synthetic */ Object apply(Object obj) {
                    return new kotlin.o((Datawrapper) obj, chatGroupChannelDataModel);
                }
            });
        }
    }

    public static final class ay<T> implements io.reactivex.rxjava3.d.g<kotlin.o<? extends Datawrapper<? super UserMessage>, ? extends ChatGroupChannelDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42220a;

        public ay(a aVar) {
            this.f42220a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String str;
            kotlin.o oVar = (kotlin.o) obj;
            Datawrapper datawrapper = (Datawrapper) oVar.getFirst();
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) oVar.getSecond();
            if (datawrapper instanceof Datawrapper.Success) {
                UserMessage userMessage = (UserMessage) ((Datawrapper.Success) datawrapper).getData();
                com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
                if (chatGroupChannelDataModel == null || (str = chatGroupChannelDataModel.getChannelUrl()) == null) {
                    str = "";
                }
                MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.a.a(str), (BaseMessage) userMessage);
                return;
            }
            String unused = this.f42220a.l;
            StringBuilder sb = new StringBuilder("resendFileMessage failure ");
            Throwable th = null;
            if (!(datawrapper instanceof Datawrapper.Failure)) {
                datawrapper = null;
            }
            Datawrapper.Failure failure = (Datawrapper.Failure) datawrapper;
            if (failure != null) {
                th = failure.getFailure();
            }
            sb.append(th);
            com.paytm.utility.q.b(sb.toString());
        }
    }

    public static final class az<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42221a;

        public az(a aVar) {
            this.f42221a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String unused = this.f42221a.l;
            com.paytm.utility.q.b("resendFileMessage failure ".concat(String.valueOf((Throwable) obj)));
        }
    }

    static final class b<T> implements io.reactivex.rxjava3.d.g<CPCSendbirdWrapper.ChannelUpdate> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42222a;

        b(a aVar) {
            this.f42222a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            CPCSendbirdWrapper.ChannelUpdate channelUpdate = (CPCSendbirdWrapper.ChannelUpdate) obj;
            if (channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.MessageReceived) {
                if (kotlin.g.b.k.a((Object) ((CPCSendbirdWrapper.ChannelUpdate.MessageReceived) channelUpdate).getChannel().getChannelUrl(), (Object) this.f42222a.f42169d)) {
                    TopActivityManager instance = TopActivityManager.getInstance();
                    kotlin.g.b.k.a((Object) instance, "TopActivityManager.getInstance()");
                    if (!instance.isBackground()) {
                        this.f42222a.b();
                    }
                }
            } else if (channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.ReadReceiptUpdated) {
                if (kotlin.g.b.k.a((Object) ((CPCSendbirdWrapper.ChannelUpdate.ReadReceiptUpdated) channelUpdate).getChannel().getChannelUrl(), (Object) this.f42222a.f42169d)) {
                    this.f42222a.f42171f.onNext(new a.l());
                }
            } else if (channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.DeliveryReceiptUpdated) {
                if (kotlin.g.b.k.a((Object) ((CPCSendbirdWrapper.ChannelUpdate.DeliveryReceiptUpdated) channelUpdate).getChannel().getChannelUrl(), (Object) this.f42222a.f42169d)) {
                    this.f42222a.f42171f.onNext(new a.l());
                }
            } else if ((channelUpdate instanceof CPCSendbirdWrapper.ChannelUpdate.TypingStatusUpdated) && kotlin.g.b.k.a((Object) ((CPCSendbirdWrapper.ChannelUpdate.TypingStatusUpdated) channelUpdate).getChannel().getChannelUrl(), (Object) this.f42222a.f42169d)) {
                this.f42222a.f42171f.onNext(new a.l());
            }
        }
    }

    static final class d<T> implements io.reactivex.rxjava3.d.g<Datawrapper<? super CPCSendbirdWrapper.ConnectionStatus>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42224a;

        d(a aVar) {
            this.f42224a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Datawrapper datawrapper = (Datawrapper) obj;
            if ((datawrapper instanceof Datawrapper.Success) && ((CPCSendbirdWrapper.ConnectionStatus) ((Datawrapper.Success) datawrapper).getData()).getStatus()) {
                this.f42224a.h();
            }
        }
    }

    static final class h<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42230a;

        h(a aVar) {
            this.f42230a = aVar;
        }

        public final /* bridge */ /* synthetic */ Object apply(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            this.f42230a.f42166a = chatGroupChannelDataModel;
            return chatGroupChannelDataModel;
        }
    }

    static final class m<T> implements io.reactivex.rxjava3.d.g<Datawrapper<? super UserMessage>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42241a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f42242b;

        m(a aVar, ChatGroupChannelDataModel chatGroupChannelDataModel) {
            this.f42241a = aVar;
            this.f42242b = chatGroupChannelDataModel;
        }

        public final /* synthetic */ void accept(Object obj) {
            String str;
            Datawrapper datawrapper = (Datawrapper) obj;
            if (datawrapper instanceof Datawrapper.Success) {
                UserMessage userMessage = (UserMessage) ((Datawrapper.Success) datawrapper).getData();
                com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42242b;
                if (chatGroupChannelDataModel == null || (str = chatGroupChannelDataModel.getChannelUrl()) == null) {
                    str = "";
                }
                MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.a.a(str), (BaseMessage) userMessage);
                return;
            }
            String unused = this.f42241a.l;
            StringBuilder sb = new StringBuilder("resendFileMessage failure ");
            Throwable th = null;
            if (!(datawrapper instanceof Datawrapper.Failure)) {
                datawrapper = null;
            }
            Datawrapper.Failure failure = (Datawrapper.Failure) datawrapper;
            if (failure != null) {
                th = failure.getFailure();
            }
            sb.append(th);
            com.paytm.utility.q.b(sb.toString());
        }
    }

    static final class n<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42243a;

        n(a aVar) {
            this.f42243a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String unused = this.f42243a.l;
            com.paytm.utility.q.b("resendFileMessage failure ".concat(String.valueOf((Throwable) obj)));
        }
    }

    static final class q<T> implements io.reactivex.rxjava3.d.g<GroupChannel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42245a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f42246b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f42247c;

        q(a aVar, List list, String str) {
            this.f42245a = aVar;
            this.f42246b = list;
            this.f42247c = str;
        }

        public final /* synthetic */ void accept(Object obj) {
            GroupChannel groupChannel = (GroupChannel) obj;
            for (BaseMessage baseMessage : this.f42246b) {
                if (baseMessage instanceof UserMessage) {
                    ChatGroupChannelDataModel localChannelByIdBlocking = this.f42245a.f42174i.getLocalChannelByIdBlocking(this.f42247c);
                    if (kotlin.g.b.k.a((Object) "contact", (Object) baseMessage.getCustomType())) {
                        a aVar = this.f42245a;
                        String data = baseMessage.getData();
                        kotlin.g.b.k.a((Object) data, "baseMessage.getData()");
                        aVar.b(data, localChannelByIdBlocking);
                    } else if (kotlin.g.b.k.a((Object) "location", (Object) baseMessage.getCustomType())) {
                        String unused = this.f42245a.l;
                        com.paytm.utility.q.a("A location message was sent");
                    } else {
                        a aVar2 = this.f42245a;
                        String message = ((UserMessage) baseMessage).getMessage();
                        kotlin.g.b.k.a((Object) message, "baseMessage.message");
                        aVar2.a(message, localChannelByIdBlocking);
                    }
                } else if (baseMessage instanceof FileMessage) {
                    this.f42245a.a((FileMessage) baseMessage, groupChannel);
                }
            }
            this.f42245a.f42171f.onNext(new a.e());
        }
    }

    static final class r<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42248a;

        r(a aVar) {
            this.f42248a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Throwable th = (Throwable) obj;
            if (th instanceof SendBirdException) {
                this.f42248a.f42171f.onNext(new a.c(((SendBirdException) th).getCode()));
            }
        }
    }

    static final class s<T> implements io.reactivex.rxjava3.d.g<Datawrapper<? super UserMessage>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42249a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f42250b;

        s(a aVar, ChatGroupChannelDataModel chatGroupChannelDataModel) {
            this.f42249a = aVar;
            this.f42250b = chatGroupChannelDataModel;
        }

        public final /* synthetic */ void accept(Object obj) {
            String str;
            Datawrapper datawrapper = (Datawrapper) obj;
            if (datawrapper instanceof Datawrapper.Success) {
                UserMessage userMessage = (UserMessage) ((Datawrapper.Success) datawrapper).getData();
                com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42250b;
                if (chatGroupChannelDataModel == null || (str = chatGroupChannelDataModel.getChannelUrl()) == null) {
                    str = "";
                }
                MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.a.a(str), (BaseMessage) userMessage);
                return;
            }
            String unused = this.f42249a.l;
            StringBuilder sb = new StringBuilder("resendFileMessage failure ");
            Throwable th = null;
            if (!(datawrapper instanceof Datawrapper.Failure)) {
                datawrapper = null;
            }
            Datawrapper.Failure failure = (Datawrapper.Failure) datawrapper;
            if (failure != null) {
                th = failure.getFailure();
            }
            sb.append(th);
            com.paytm.utility.q.b(sb.toString());
        }
    }

    static final class t<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42251a;

        t(a aVar) {
            this.f42251a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String unused = this.f42251a.l;
            com.paytm.utility.q.b("resendFileMessage failure ".concat(String.valueOf((Throwable) obj)));
        }
    }

    static final class x<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42254a;

        x(a aVar) {
            this.f42254a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List<ChatMessageDataModel> list = (List) obj;
            kotlin.g.b.k.c(list, "chatUiBeans");
            if (!list.isEmpty()) {
                this.f42254a.r = ((ChatMessageDataModel) list.get(list.size() - 1)).time;
                for (ChatMessageDataModel chatMessageDataModel : list) {
                    chatMessageDataModel.showQuickReply = false;
                    chatMessageDataModel.showStore = Boolean.FALSE;
                    if (this.f42254a.t != null) {
                        BaseMessage baseMessage = chatMessageDataModel.baseMessage;
                        kotlin.g.b.k.a((Object) baseMessage, "chatMessageDataModel.baseMessage");
                        if (baseMessage.getSender() != null) {
                            String i2 = this.f42254a.t;
                            BaseMessage baseMessage2 = chatMessageDataModel.baseMessage;
                            kotlin.g.b.k.a((Object) baseMessage2, "chatMessageDataModel.baseMessage");
                            Sender sender = baseMessage2.getSender();
                            kotlin.g.b.k.a((Object) sender, "chatMessageDataModel.baseMessage.sender");
                            chatMessageDataModel.showStore = Boolean.valueOf(!kotlin.m.p.a(i2, sender.getUserId(), true));
                        }
                    }
                    if (!TextUtils.isEmpty(chatMessageDataModel.campaignId) && !chatMessageDataModel.readEngageEventSent) {
                        Application a2 = com.paytm.android.chat.c.a();
                        kotlin.g.b.k.a((Object) a2, "ChatApplication.getApplication()");
                        String str = chatMessageDataModel.campaignId;
                        kotlin.g.b.k.a((Object) str, "chatMessageDataModel.campaignId");
                        ChatAnalyticsHelperKt.fireCampaignMessageViewedEvent(a2, str);
                        MessageDBHelperKt.markReadEngageEventSent(chatMessageDataModel.messageId, true);
                    }
                }
                ChatMessageDataModel chatMessageDataModel2 = (ChatMessageDataModel) kotlin.a.k.e(list);
                if (chatMessageDataModel2 != null && kotlin.m.p.a("TRANSFER", chatMessageDataModel2.customType, true)) {
                    chatMessageDataModel2.showQuickReply = true;
                }
            }
            return list;
        }
    }

    static final class y<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42255a;

        y(a aVar) {
            this.f42255a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            boolean z;
            List list = (List) obj;
            kotlin.g.b.k.c(list, "newList");
            h.b b2 = androidx.recyclerview.widget.h.b(new MessageDiffUtil(this.f42255a.v, list));
            kotlin.g.b.k.a((Object) b2, "DiffUtil.calculateDiff(M…sageList, newList), true)");
            Collection collection = list;
            boolean z2 = true;
            if (!collection.isEmpty()) {
                BaseMessage baseMessage = ((ChatMessageDataModel) list.get(0)).baseMessage;
                kotlin.g.b.k.a((Object) baseMessage, "newList[0].baseMessage");
                Sender sender = baseMessage.getSender();
                if (sender != null && kotlin.m.p.a(SharedPreferencesUtil.getUserId(), sender.getUserId(), true)) {
                    z = true;
                    if ((!collection.isEmpty()) && (!this.f42255a.v.isEmpty())) {
                        z2 = true ^ kotlin.g.b.k.a((Object) (ChatMessageDataModel) this.f42255a.v.get(0), (Object) (ChatMessageDataModel) list.get(0));
                    }
                    return new MessageAdapterEvent(list, b2, z, z2);
                }
            }
            z = false;
            z2 = true ^ kotlin.g.b.k.a((Object) (ChatMessageDataModel) this.f42255a.v.get(0), (Object) (ChatMessageDataModel) list.get(0));
            return new MessageAdapterEvent(list, b2, z, z2);
        }
    }

    static final class z<T> implements io.reactivex.rxjava3.d.g<MessageAdapterEvent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42256a;

        z(a aVar) {
            this.f42256a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            MessageAdapterEvent messageAdapterEvent = (MessageAdapterEvent) obj;
            List<ChatMessageDataModel> component1 = messageAdapterEvent.component1();
            h.b component2 = messageAdapterEvent.component2();
            boolean component3 = messageAdapterEvent.component3();
            boolean component4 = messageAdapterEvent.component4();
            this.f42256a.v = component1;
            this.f42256a.c(true);
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42256a.f42166a;
            if (chatGroupChannelDataModel != null) {
                this.f42256a.f42171f.onNext(new a.i(chatGroupChannelDataModel, this.f42256a.v, component2, component3, component4));
            }
        }
    }

    public a(ChatRepository chatRepository) {
        kotlin.g.b.k.c(chatRepository, "repository");
        this.f42174i = chatRepository;
    }

    public final io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> a() {
        return this.f42171f;
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        this.f42169d = str;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        r0 = r0.getChannelUrl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r4 = this;
            boolean r0 = r4.A
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            r4.A = r0
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = r4.f42166a
            if (r0 != 0) goto L_0x004a
            io.reactivex.rxjava3.b.c r0 = r4.u
            if (r0 == 0) goto L_0x0015
            if (r0 == 0) goto L_0x0015
            r0.dispose()
        L_0x0015:
            com.paytm.android.chat.data.repository.ChatRepository r0 = r4.f42174i
            java.lang.String r1 = r4.f42169d
            if (r1 != 0) goto L_0x001e
            kotlin.g.b.k.a()
        L_0x001e:
            io.reactivex.rxjava3.a.y r0 = r0.fetchChannelForDisplay(r1)
            com.paytm.android.chat.h.a$ah r1 = new com.paytm.android.chat.h.a$ah
            r1.<init>(r4)
            io.reactivex.rxjava3.d.h r1 = (io.reactivex.rxjava3.d.h) r1
            io.reactivex.rxjava3.a.y r0 = r0.a(r1)
            io.reactivex.rxjava3.a.x r1 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.y r0 = r0.b((io.reactivex.rxjava3.a.x) r1)
            com.paytm.android.chat.h.a$ai r1 = new com.paytm.android.chat.h.a$ai
            r1.<init>(r4)
            io.reactivex.rxjava3.d.g r1 = (io.reactivex.rxjava3.d.g) r1
            com.paytm.android.chat.h.a$aj r2 = new com.paytm.android.chat.h.a$aj
            r2.<init>(r4)
            io.reactivex.rxjava3.d.g r2 = (io.reactivex.rxjava3.d.g) r2
            io.reactivex.rxjava3.b.c r0 = r0.a(r1, (io.reactivex.rxjava3.d.g<? super java.lang.Throwable>) r2)
            r4.u = r0
            return
        L_0x004a:
            if (r0 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            java.lang.String r0 = r0.getChannelUrl()
            com.sendbird.android.GroupChannel r0 = com.paytm.android.chat.d.a.b.a(r0)
            if (r0 == 0) goto L_0x00a0
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = r4.f42166a
            r1 = 0
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r0.getChannelUrl()
            if (r0 == 0) goto L_0x0069
            com.sendbird.android.GroupChannel r0 = com.paytm.android.chat.d.a.b.a(r0)
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            if (r0 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            com.paytm.android.chat.h.a$ak r2 = new com.paytm.android.chat.h.a$ak
            r2.<init>(r4)
            com.sendbird.android.GroupChannel$GroupChannelRefreshHandler r2 = (com.sendbird.android.GroupChannel.GroupChannelRefreshHandler) r2
            r0.refresh(r2)
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r0 = r4.f42171f
            com.paytm.android.chat.g.a$b r2 = new com.paytm.android.chat.g.a$b
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r3 = r4.f42166a
            if (r3 == 0) goto L_0x0085
            java.lang.String r1 = r3.getChannelUrl()
        L_0x0085:
            if (r1 != 0) goto L_0x008a
            kotlin.g.b.k.a()
        L_0x008a:
            com.sendbird.android.GroupChannel r1 = com.paytm.android.chat.d.a.b.a(r1)
            if (r1 != 0) goto L_0x0093
            kotlin.g.b.k.a()
        L_0x0093:
            boolean r1 = r1.isPushEnabled()
            r2.<init>(r1)
            r0.onNext(r2)
            r4.i()
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.a.h():void");
    }

    static final class ak implements GroupChannel.GroupChannelRefreshHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42204a;

        ak(a aVar) {
            this.f42204a = aVar;
        }

        public final void onResult(SendBirdException sendBirdException) {
            this.f42204a.A = false;
            if (sendBirdException == null) {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42204a.f42166a;
                if (chatGroupChannelDataModel != null) {
                    this.f42204a.f42171f.onNext(new a.C0697a(chatGroupChannelDataModel));
                }
                this.f42204a.b(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void i() {
        ReceiverDisplayInfo receiverDisplayInfo;
        if (this.f42166a != null && this.B) {
            com.paytm.utility.q.a("chat_log loadOtherMember");
            this.B = false;
            ChatRepository chatRepository = this.f42174i;
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42166a;
            if (chatGroupChannelDataModel == null) {
                kotlin.g.b.k.a();
            }
            ChatUserDataModel otherMember = chatRepository.getOtherMember(chatGroupChannelDataModel);
            if (otherMember != null) {
                ChatGroupChannelDataModel chatGroupChannelDataModel2 = this.f42166a;
                String channelUrl = chatGroupChannelDataModel2 != null ? chatGroupChannelDataModel2.getChannelUrl() : null;
                if (channelUrl == null) {
                    kotlin.g.b.k.a();
                }
                if (com.paytm.android.chat.d.a.b.a(channelUrl) != null) {
                    this.n = otherMember;
                    ChatGroupChannelDataModel chatGroupChannelDataModel3 = this.f42166a;
                    String name = (chatGroupChannelDataModel3 == null || (receiverDisplayInfo = chatGroupChannelDataModel3.getReceiverDisplayInfo()) == null) ? null : receiverDisplayInfo.getName();
                    ChatGroupChannelDataModel chatGroupChannelDataModel4 = this.f42166a;
                    String channelUrl2 = chatGroupChannelDataModel4 != null ? chatGroupChannelDataModel4.getChannelUrl() : null;
                    if (channelUrl2 == null) {
                        kotlin.g.b.k.a();
                    }
                    GroupChannel a2 = com.paytm.android.chat.d.a.b.a(channelUrl2);
                    if (a2 == null) {
                        kotlin.g.b.k.a();
                    }
                    Member channelDisplayMember = ChatVariantUtilKt.getChannelDisplayMember(a2);
                    if (!(channelDisplayMember == null || channelDisplayMember.getUserId() == null)) {
                        io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar = this.f42171f;
                        String userId = channelDisplayMember.getUserId();
                        kotlin.g.b.k.a((Object) userId, "p4bMember.userId");
                        aVar.onNext(new a.j(userId));
                        this.t = channelDisplayMember.getUserId();
                    }
                    this.f42171f.onNext(name != null ? new a.aa(name) : null);
                    String sendbirdUserId = otherMember.getSendbirdUserId();
                    if (sendbirdUserId == null) {
                        kotlin.g.b.k.a();
                    }
                    b(sendbirdUserId).b(new GetUserInfoByIdsResponse((UserInfoByIdsData) null)).a(new ab(this, otherMember), (io.reactivex.rxjava3.d.g<? super Throwable>) new ac(this));
                    FileUtils.initCacheFile(com.paytm.android.chat.c.a(), SharedPreferencesUtil.getUserId(), otherMember.getSendbirdUserId());
                    UserMetaData userMetaData = otherMember.getUserMetaData();
                    RegistrationStatus registrationStatus = RegistrationStatus.COMPLETE;
                    if (userMetaData != null) {
                        registrationStatus = userMetaData.getRegistrationStatus();
                    }
                    ContactManager.getInstance().getUserPhone(registrationStatus, otherMember.getSendbirdUserId(), this.f42169d, new b(new ad(this)), new ae(this));
                    return;
                }
            }
            this.B = true;
        }
    }

    static final /* synthetic */ class ad extends kotlin.g.b.i implements kotlin.g.a.b<String, io.reactivex.rxjava3.a.y<GetUserInfoByIdsResponse>> {
        ad(a aVar) {
            super(1, aVar);
        }

        public final String getName() {
            return "fetchUserInfo";
        }

        public final kotlin.k.d getOwner() {
            return kotlin.g.b.y.b(a.class);
        }

        public final String getSignature() {
            return "fetchUserInfo(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;";
        }

        public final io.reactivex.rxjava3.a.y<GetUserInfoByIdsResponse> invoke(String str) {
            kotlin.g.b.k.c(str, "p1");
            return ((a) this.receiver).b(str);
        }
    }

    static final class ae implements ContactManager.UserPhoneCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42198a;

        ae(a aVar) {
            this.f42198a = aVar;
        }

        public final void back(String str) {
            this.f42198a.f42167b = str;
        }
    }

    public final io.reactivex.rxjava3.a.y<GetUserInfoByIdsResponse> b(String str) {
        io.reactivex.rxjava3.a.y yVar;
        kotlin.g.b.k.c(str, "userId");
        if (this.f42172g == null) {
            yVar = io.reactivex.rxjava3.a.y.a(new j(this, str));
        } else {
            yVar = io.reactivex.rxjava3.a.y.a(new k(this));
        }
        io.reactivex.rxjava3.a.y<GetUserInfoByIdsResponse> a2 = yVar.b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) a2, "if (userInfo == null) {\n…bserveOn(Schedulers.io())");
        return a2;
    }

    static final class j<T> implements io.reactivex.rxjava3.a.ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42235a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f42236b;

        j(a aVar, String str) {
            this.f42235a = aVar;
            this.f42236b = str;
        }

        public final void subscribe(io.reactivex.rxjava3.a.z<GetUserInfoByIdsResponse> zVar) {
            a aVar = this.f42235a;
            com.paytm.a aVar2 = com.paytm.a.f40823c;
            aVar.f42172g = com.paytm.a.a((List<String>) kotlin.a.k.a(this.f42236b));
            zVar.onSuccess(this.f42235a.f42172g);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0147, code lost:
        if ((!kotlin.g.b.k.a((java.lang.Object) r2.getUserId(), (java.lang.Object) com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId())) != false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0197, code lost:
        if ((!kotlin.g.b.k.a((java.lang.Object) r2.getUserId(), (java.lang.Object) com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId())) != false) goto L_0x0199;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.paytm.android.chat.data.models.messages.ChatMessageDataModel c(com.sendbird.android.BaseMessage r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r11.getCustomType()
            java.lang.String r2 = r11.getData()
            boolean r3 = r11 instanceof com.sendbird.android.UserMessage
            r4 = 0
            java.lang.String r5 = "message.sender"
            if (r3 == 0) goto L_0x0239
            java.lang.String r3 = "GENERIC_NOTIF"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            r6 = 1
            if (r3 == 0) goto L_0x0043
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel
            r3.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01df
            r6 = r3
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel) r6
            com.sendbird.android.shadow.com.google.gson.Gson r7 = r10.f42168c
            if (r7 != 0) goto L_0x0036
            kotlin.g.b.k.a()
        L_0x0036:
            java.lang.Class<com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean> r8 = com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean.class
            java.lang.Object r2 = r7.fromJson((java.lang.String) r2, r8)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r2 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean) r2
            r6.setData(r2)
            goto L_0x01df
        L_0x0043:
            java.lang.String r3 = "MINI_APP_BASIC_NOTIFICATION"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0072
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r3 = new com.paytm.android.chat.data.models.messages.MiniAppNotificationBean
            r3.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01df
            r6 = r3
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r6 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationBean) r6
            com.sendbird.android.shadow.com.google.gson.Gson r7 = r10.f42168c
            if (r7 != 0) goto L_0x0065
            kotlin.g.b.k.a()
        L_0x0065:
            java.lang.Class<com.paytm.android.chat.data.models.messages.MiniAppNotificationData> r8 = com.paytm.android.chat.data.models.messages.MiniAppNotificationData.class
            java.lang.Object r2 = r7.fromJson((java.lang.String) r2, r8)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r2 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationData) r2
            r6.setNotifData(r2)
            goto L_0x01df
        L_0x0072:
            java.lang.String r3 = "contact"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x00bb
            com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel
            r3.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01df
            com.paytm.android.chat.h.a$v r6 = new com.paytm.android.chat.h.a$v
            r6.<init>()
            java.lang.reflect.Type r6 = r6.getType()
            com.sendbird.android.shadow.com.google.gson.Gson r7 = r10.f42168c
            if (r7 != 0) goto L_0x009a
            kotlin.g.b.k.a()
        L_0x009a:
            java.lang.Object r2 = r7.fromJson((java.lang.String) r2, (java.lang.reflect.Type) r6)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00b4
            int r6 = r2.size()
            if (r6 <= 0) goto L_0x00b4
            java.lang.Object r6 = r2.get(r4)
            com.paytm.android.chat.bean.SelectContactsBean r6 = (com.paytm.android.chat.bean.SelectContactsBean) r6
            if (r6 == 0) goto L_0x00b4
            boolean r6 = r6.isForward
            r3.isForward = r6
        L_0x00b4:
            r6 = r3
            com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel) r6
            r6.sendContactBeans = r2
            goto L_0x01df
        L_0x00bb:
            java.lang.String r3 = "TRANSFER"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x014b
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel     // Catch:{ Exception -> 0x014a }
            r3.<init>()     // Catch:{ Exception -> 0x014a }
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3     // Catch:{ Exception -> 0x014a }
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x014a }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x014a }
            if (r7 != 0) goto L_0x01df
            r7 = r3
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r7 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r7     // Catch:{ Exception -> 0x014a }
            com.sendbird.android.shadow.com.google.gson.Gson r8 = r10.f42168c     // Catch:{ Exception -> 0x014a }
            if (r8 != 0) goto L_0x00dd
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x014a }
        L_0x00dd:
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r9 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r2 = r8.fromJson((java.lang.String) r2, r9)     // Catch:{ Exception -> 0x014a }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r2 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r2     // Catch:{ Exception -> 0x014a }
            r7.bean = r2     // Catch:{ Exception -> 0x014a }
            r2 = r3
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r2     // Catch:{ Exception -> 0x014a }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r2 = r2.bean     // Catch:{ Exception -> 0x014a }
            if (r2 == 0) goto L_0x01df
            r2 = r11
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2     // Catch:{ Exception -> 0x014a }
            com.sendbird.android.Sender r2 = r2.getSender()     // Catch:{ Exception -> 0x014a }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x014a }
            java.lang.String r2 = r2.getUserId()     // Catch:{ Exception -> 0x014a }
            java.lang.String r7 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x014a }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)     // Catch:{ Exception -> 0x014a }
            r2 = r2 ^ r6
            java.lang.String r7 = "uiBean.bean"
            if (r2 == 0) goto L_0x0119
            r2 = r3
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r2     // Catch:{ Exception -> 0x014a }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r2 = r2.bean     // Catch:{ Exception -> 0x014a }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x014a }
            int r2 = r2.getStatus()     // Catch:{ Exception -> 0x014a }
            if (r2 == 0) goto L_0x0119
            return r0
        L_0x0119:
            r2 = r3
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r2     // Catch:{ Exception -> 0x014a }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r2 = r2.bean     // Catch:{ Exception -> 0x014a }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x014a }
            int r2 = r2.getStatus()     // Catch:{ Exception -> 0x014a }
            if (r2 != r6) goto L_0x01df
            r2 = r11
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2     // Catch:{ Exception -> 0x014a }
            com.sendbird.android.Sender r2 = r2.getSender()     // Catch:{ Exception -> 0x014a }
            if (r2 == 0) goto L_0x01df
            r2 = r11
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2     // Catch:{ Exception -> 0x014a }
            com.sendbird.android.Sender r2 = r2.getSender()     // Catch:{ Exception -> 0x014a }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x014a }
            java.lang.String r2 = r2.getUserId()     // Catch:{ Exception -> 0x014a }
            java.lang.String r7 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x014a }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)     // Catch:{ Exception -> 0x014a }
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x01df
            goto L_0x0199
        L_0x014a:
            return r0
        L_0x014b:
            java.lang.String r3 = "TRANSFER_FAIL"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x019c
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel     // Catch:{ Exception -> 0x019b }
            r3.<init>()     // Catch:{ Exception -> 0x019b }
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3     // Catch:{ Exception -> 0x019b }
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x019b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x019b }
            if (r7 != 0) goto L_0x0177
            r7 = r3
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r7 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r7     // Catch:{ Exception -> 0x019b }
            com.sendbird.android.shadow.com.google.gson.Gson r8 = r10.f42168c     // Catch:{ Exception -> 0x019b }
            if (r8 != 0) goto L_0x016d
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x019b }
        L_0x016d:
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r9 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r2 = r8.fromJson((java.lang.String) r2, r9)     // Catch:{ Exception -> 0x019b }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r2 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r2     // Catch:{ Exception -> 0x019b }
            r7.bean = r2     // Catch:{ Exception -> 0x019b }
        L_0x0177:
            r2 = r11
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2     // Catch:{ Exception -> 0x019b }
            com.sendbird.android.Sender r2 = r2.getSender()     // Catch:{ Exception -> 0x019b }
            if (r2 == 0) goto L_0x01df
            r2 = r11
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2     // Catch:{ Exception -> 0x019b }
            com.sendbird.android.Sender r2 = r2.getSender()     // Catch:{ Exception -> 0x019b }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x019b }
            java.lang.String r2 = r2.getUserId()     // Catch:{ Exception -> 0x019b }
            java.lang.String r7 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x019b }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)     // Catch:{ Exception -> 0x019b }
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x01df
        L_0x0199:
            r4 = 1
            goto L_0x01df
        L_0x019b:
            return r0
        L_0x019c:
            com.sendbird.android.shadow.com.google.gson.Gson r3 = new com.sendbird.android.shadow.com.google.gson.Gson
            r3.<init>()
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.UserDataBean> r6 = com.paytm.android.chat.bean.jsonbean.UserDataBean.class
            java.lang.Object r2 = r3.fromJson((java.lang.String) r2, r6)
            com.paytm.android.chat.bean.jsonbean.UserDataBean r2 = (com.paytm.android.chat.bean.jsonbean.UserDataBean) r2
            com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel
            r3.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            if (r2 == 0) goto L_0x01df
            r6 = r3
            com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel) r6
            java.lang.String r7 = r2.getContent()
            r6.replyContent = r7
            java.lang.String r7 = r2.getUrl()
            r6.replyUrl = r7
            java.lang.String r7 = r2.getTitle()
            r6.replyName = r7
            long r7 = r2.getMessageId()
            r6.replyMessageId = r7
            int r7 = r2.getType()
            r6.replyType = r7
            java.lang.String r7 = r2.getUserId()
            r6.replyUserId = r7
            boolean r2 = r2.isForward()
            r3.isForward = r2
        L_0x01df:
            java.lang.String r2 = "user"
            r3.messageType = r2
            r2 = r11
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2
            com.sendbird.android.Sender r6 = r2.getSender()
            if (r6 == 0) goto L_0x01fb
            com.sendbird.android.Sender r6 = r2.getSender()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            java.lang.String r5 = r6.getUserId()
            r3.sendId = r5
            goto L_0x0201
        L_0x01fb:
            java.lang.String r5 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            r3.sendId = r5
        L_0x0201:
            java.lang.String r5 = r2.getMessage()
            r3.message = r5
            java.lang.String r5 = r2.getRequestId()
            r3.requestId = r5
            com.sendbird.android.UserMessage$RequestState r2 = r2.getRequestState()
            com.sendbird.android.UserMessage$RequestState r5 = com.sendbird.android.UserMessage.RequestState.FAILED
            if (r2 != r5) goto L_0x021b
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            r3.state = r2
            goto L_0x0333
        L_0x021b:
            com.sendbird.android.UserMessage$RequestState r5 = com.sendbird.android.UserMessage.RequestState.SUCCEEDED
            if (r2 != r5) goto L_0x0225
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.SUCCEEDED
            r3.state = r2
            goto L_0x0333
        L_0x0225:
            com.sendbird.android.UserMessage$RequestState r5 = com.sendbird.android.UserMessage.RequestState.PENDING
            if (r2 != r5) goto L_0x022f
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.PENDING
            r3.state = r2
            goto L_0x0333
        L_0x022f:
            com.sendbird.android.UserMessage$RequestState r5 = com.sendbird.android.UserMessage.RequestState.NONE
            if (r2 != r5) goto L_0x0333
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.NONE
            r3.state = r2
            goto L_0x0333
        L_0x0239:
            boolean r3 = r11 instanceof com.sendbird.android.FileMessage
            if (r3 == 0) goto L_0x0320
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0256
            com.sendbird.android.shadow.com.google.gson.Gson r3 = r10.f42168c
            if (r3 != 0) goto L_0x024d
            kotlin.g.b.k.a()
        L_0x024d:
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.FileDataBean> r6 = com.paytm.android.chat.bean.jsonbean.FileDataBean.class
            java.lang.Object r2 = r3.fromJson((java.lang.String) r2, r6)
            com.paytm.android.chat.bean.jsonbean.FileDataBean r2 = (com.paytm.android.chat.bean.jsonbean.FileDataBean) r2
            goto L_0x0257
        L_0x0256:
            r2 = r0
        L_0x0257:
            java.lang.String r3 = "Audio"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0267
            com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel
            r3.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            goto L_0x02b9
        L_0x0267:
            java.lang.String r3 = "Image"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x02a6
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel
            r3.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            if (r2 == 0) goto L_0x0283
            r6 = r3
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel) r6
            java.lang.String r7 = r2.message
            r6.messageData = r7
            java.lang.String r7 = r2.path
            r6.filePath = r7
        L_0x0283:
            r6 = r11
            com.sendbird.android.FileMessage r6 = (com.sendbird.android.FileMessage) r6
            java.util.List r6 = r6.getThumbnails()
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x02b9
            r7 = r3
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r7 = (com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel) r7
            java.lang.Object r6 = r6.get(r4)
            java.lang.String r8 = "thumbnails[0]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            com.sendbird.android.FileMessage$Thumbnail r6 = (com.sendbird.android.FileMessage.Thumbnail) r6
            java.lang.String r6 = r6.getUrl()
            r7.thumbnail = r6
            goto L_0x02b9
        L_0x02a6:
            com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel
            r3.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            r6 = r3
            com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel) r6
            r7 = r11
            com.sendbird.android.FileMessage r7 = (com.sendbird.android.FileMessage) r7
            int r7 = r7.getSize()
            r6.fileSize = r7
        L_0x02b9:
            if (r2 == 0) goto L_0x02bf
            boolean r2 = r2.isForward
            r3.isForward = r2
        L_0x02bf:
            r2 = r11
            com.sendbird.android.FileMessage r2 = (com.sendbird.android.FileMessage) r2
            java.lang.String r6 = r2.getRequestId()
            r3.requestId = r6
            java.lang.String r6 = "file"
            r3.messageType = r6
            java.lang.String r6 = r2.getUrl()
            r3.fileUrl = r6
            java.lang.String r6 = r2.getName()
            r3.fileName = r6
            com.sendbird.android.Sender r6 = r2.getSender()
            if (r6 == 0) goto L_0x02ec
            com.sendbird.android.Sender r6 = r2.getSender()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            java.lang.String r5 = r6.getUserId()
            r3.sendId = r5
            goto L_0x02f2
        L_0x02ec:
            java.lang.String r5 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            r3.sendId = r5
        L_0x02f2:
            com.sendbird.android.FileMessage$RequestState r5 = r2.getRequestState()
            com.sendbird.android.FileMessage$RequestState r6 = com.sendbird.android.FileMessage.RequestState.FAILED
            if (r5 != r6) goto L_0x02ff
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r5 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            r3.state = r5
            goto L_0x0319
        L_0x02ff:
            com.sendbird.android.FileMessage$RequestState r6 = com.sendbird.android.FileMessage.RequestState.SUCCEEDED
            if (r5 != r6) goto L_0x0308
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r5 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.SUCCEEDED
            r3.state = r5
            goto L_0x0319
        L_0x0308:
            com.sendbird.android.FileMessage$RequestState r6 = com.sendbird.android.FileMessage.RequestState.PENDING
            if (r5 != r6) goto L_0x0311
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r5 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.PENDING
            r3.state = r5
            goto L_0x0319
        L_0x0311:
            com.sendbird.android.FileMessage$RequestState r6 = com.sendbird.android.FileMessage.RequestState.NONE
            if (r5 != r6) goto L_0x0319
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r5 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.NONE
            r3.state = r5
        L_0x0319:
            java.lang.String r2 = r2.getType()
            r3.fileType = r2
            goto L_0x0333
        L_0x0320:
            boolean r2 = r11 instanceof com.sendbird.android.AdminMessage
            if (r2 == 0) goto L_0x032e
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean r2 = com.paytm.android.chat.utils.AppUtilKt.getValidAdminMessage(r11)
            r3 = r2
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            if (r3 != 0) goto L_0x0333
            return r0
        L_0x032e:
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = new com.paytm.android.chat.data.models.messages.ChatMessageDataModel
            r3.<init>()
        L_0x0333:
            r3.baseMessage = r11
            r3.customType = r1
            long r1 = r11.getMessageId()
            r3.messageId = r1
            long r1 = r11.getCreatedAt()
            r3.time = r1
            if (r4 == 0) goto L_0x0346
            return r0
        L_0x0346:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.a.c(com.sendbird.android.BaseMessage):com.paytm.android.chat.data.models.messages.ChatMessageDataModel");
    }

    public static final class v extends com.google.gsonhtcfix.c.a<List<? extends SelectContactsBean>> {
        v() {
        }
    }

    public final void c(String str) {
        if (this.f42166a != null) {
            UserMessageParams userMessageParams = new UserMessageParams();
            userMessageParams.setMessage(str).setCustomType(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX).setPushNotificationDeliveryOption(BaseMessageParams.PushNotificationDeliveryOption.DEFAULT);
            this.f42174i.sendMessage(this.f42166a, userMessageParams).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new av(this), new aw(this));
        }
    }

    public final void a(boolean z2) {
        if (this.f42166a != null) {
            String str = this.f42169d;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            if (com.paytm.android.chat.d.a.b.a(str) != null) {
                if (z2) {
                    String str2 = this.f42169d;
                    if (str2 == null) {
                        kotlin.g.b.k.a();
                    }
                    GroupChannel a2 = com.paytm.android.chat.d.a.b.a(str2);
                    if (a2 == null) {
                        kotlin.g.b.k.a();
                    }
                    a2.startTyping();
                    return;
                }
                String str3 = this.f42169d;
                if (str3 == null) {
                    kotlin.g.b.k.a();
                }
                GroupChannel a3 = com.paytm.android.chat.d.a.b.a(str3);
                if (a3 == null) {
                    kotlin.g.b.k.a();
                }
                a3.endTyping();
            }
        }
    }

    public static final class au implements BaseChannel.SendFileMessageWithProgressHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42214a;

        public final void onProgress(int i2, int i3, int i4) {
        }

        public au(a aVar) {
            this.f42214a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
            r0 = (r0 = r0.getChatType()).name();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSent(com.sendbird.android.FileMessage r3, com.sendbird.android.SendBirdException r4) {
            /*
                r2 = this;
                com.paytm.android.chat.h.a r0 = r2.f42214a
                java.lang.String r0 = r0.f42169d
                if (r0 != 0) goto L_0x0009
                kotlin.g.b.k.a()
            L_0x0009:
                com.sendbird.android.GroupChannel r0 = com.paytm.android.chat.d.a.b.a(r0)
                com.sendbird.android.BaseChannel r0 = (com.sendbird.android.BaseChannel) r0
                com.sendbird.android.BaseMessage r3 = (com.sendbird.android.BaseMessage) r3
                com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.insertOrUpdateMessage((com.sendbird.android.BaseChannel) r0, (com.sendbird.android.BaseMessage) r3)
                java.lang.String r3 = "GIF"
                if (r4 != 0) goto L_0x0035
                com.paytm.android.chat.h.a r4 = r2.f42214a
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r4 = r4.f42171f
                com.paytm.android.chat.g.a$g r0 = new com.paytm.android.chat.g.a$g
                com.paytm.android.chat.h.a r1 = r2.f42214a
                com.paytm.android.chat.bean.ReceiverDisplayInfo r1 = r1.e()
                if (r1 != 0) goto L_0x0029
                kotlin.g.b.k.a()
            L_0x0029:
                com.paytm.android.chat.bean.ChatType r1 = r1.getChatType()
                java.lang.String r1 = r1.name()
                r0.<init>(r1, r3)
                goto L_0x0055
            L_0x0035:
                com.paytm.android.chat.h.a r4 = r2.f42214a
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r4 = r4.f42171f
                com.paytm.android.chat.h.a r0 = r2.f42214a
                com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r0.e()
                if (r0 == 0) goto L_0x0054
                com.paytm.android.chat.bean.ChatType r0 = r0.getChatType()
                if (r0 == 0) goto L_0x0054
                java.lang.String r0 = r0.name()
                if (r0 == 0) goto L_0x0054
                com.paytm.android.chat.g.a$f r1 = new com.paytm.android.chat.g.a$f
                r1.<init>(r0, r3)
                r0 = r1
                goto L_0x0055
            L_0x0054:
                r0 = 0
            L_0x0055:
                r4.onNext(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.a.au.onSent(com.sendbird.android.FileMessage, com.sendbird.android.SendBirdException):void");
        }
    }

    public final void a(String str, String str2, File file) {
        kotlin.g.b.k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
        if (this.f42166a != null && !TextUtils.isEmpty(str)) {
            String str3 = this.f42169d;
            if (str3 == null) {
                kotlin.g.b.k.a();
            }
            if (com.paytm.android.chat.d.a.b.a(str3) != null) {
                List arrayList = new ArrayList();
                arrayList.add(new FileMessage.ThumbnailSize(240, 240));
                File file2 = new File(str);
                if (file != null) {
                    str = Uri.fromFile(file).toString();
                    kotlin.g.b.k.a((Object) str, "Uri.fromFile(croppedImage).toString()");
                } else {
                    file = file2;
                }
                if (file.exists()) {
                    if (kotlin.g.b.k.a((Object) "", (Object) str)) {
                        this.f42171f.onNext(new a.u("File must be located in local storage."));
                        return;
                    }
                    BaseChannel.SendFileMessageWithProgressHandler atVar = new at(this);
                    FileDataBean fileDataBean = new FileDataBean();
                    fileDataBean.message = str2;
                    fileDataBean.path = str;
                    FileMessageParams customType = new FileMessageParams().setFile(file).setCustomType("Image");
                    Gson gson = this.f42168c;
                    if (gson == null) {
                        kotlin.g.b.k.a();
                    }
                    FileMessageParams thumbnailSizes = customType.setData(gson.toJson((Object) fileDataBean)).setThumbnailSizes(arrayList);
                    String str4 = this.f42169d;
                    if (str4 == null) {
                        kotlin.g.b.k.a();
                    }
                    GroupChannel a2 = com.paytm.android.chat.d.a.b.a(str4);
                    if (a2 == null) {
                        kotlin.g.b.k.a();
                    }
                    FileMessage sendFileMessage = a2.sendFileMessage(thumbnailSizes, atVar);
                    String str5 = this.f42169d;
                    if (str5 == null) {
                        kotlin.g.b.k.a();
                    }
                    MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.b.a(str5), (BaseMessage) sendFileMessage);
                }
            }
        }
    }

    public static final class at implements BaseChannel.SendFileMessageWithProgressHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42213a;

        public final void onProgress(int i2, int i3, int i4) {
        }

        at(a aVar) {
            this.f42213a = aVar;
        }

        public final void onSent(FileMessage fileMessage, SendBirdException sendBirdException) {
            ChatType chatType;
            String name;
            ChatType chatType2;
            String name2;
            String str = this.f42213a.f42169d;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.b.a(str), (BaseMessage) fileMessage);
            Object obj = null;
            if (sendBirdException == null) {
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar = this.f42213a.f42171f;
                ReceiverDisplayInfo e2 = this.f42213a.e();
                if (!(e2 == null || (chatType2 = e2.getChatType()) == null || (name2 = chatType2.name()) == null)) {
                    obj = new a.g(name2, "Image");
                }
                aVar.onNext(obj);
                return;
            }
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar2 = this.f42213a.f42171f;
            ReceiverDisplayInfo e3 = this.f42213a.e();
            if (!(e3 == null || (chatType = e3.getChatType()) == null || (name = chatType.name()) == null)) {
                obj = new a.f(name, "Image");
            }
            aVar2.onNext(obj);
        }
    }

    public static final class ar implements BaseChannel.SendFileMessageWithProgressHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42211a;

        public final void onProgress(int i2, int i3, int i4) {
        }

        public ar(a aVar) {
            this.f42211a = aVar;
        }

        public final void onSent(FileMessage fileMessage, SendBirdException sendBirdException) {
            ChatType chatType;
            String name;
            ChatType chatType2;
            String name2;
            String str = this.f42211a.f42169d;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.b.a(str), (BaseMessage) fileMessage);
            Object obj = null;
            if (sendBirdException == null) {
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar = this.f42211a.f42171f;
                ReceiverDisplayInfo e2 = this.f42211a.e();
                if (!(e2 == null || (chatType2 = e2.getChatType()) == null || (name2 = chatType2.name()) == null)) {
                    obj = new a.g(name2, "File");
                }
                aVar.onNext(obj);
                return;
            }
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar2 = this.f42211a.f42171f;
            ReceiverDisplayInfo e3 = this.f42211a.e();
            if (!(e3 == null || (chatType = e3.getChatType()) == null || (name = chatType.name()) == null)) {
                obj = new a.f(name, "File");
            }
            aVar2.onNext(obj);
        }
    }

    public static final class as implements BaseChannel.SendFileMessageWithProgressHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42212a;

        public final void onProgress(int i2, int i3, int i4) {
        }

        public as(a aVar) {
            this.f42212a = aVar;
        }

        public final void onSent(FileMessage fileMessage, SendBirdException sendBirdException) {
            ChatType chatType;
            String name;
            ChatType chatType2;
            String name2;
            String str = this.f42212a.f42169d;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.b.a(str), (BaseMessage) fileMessage);
            Object obj = null;
            if (sendBirdException == null) {
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar = this.f42212a.f42171f;
                ReceiverDisplayInfo e2 = this.f42212a.e();
                if (!(e2 == null || (chatType2 = e2.getChatType()) == null || (name2 = chatType2.name()) == null)) {
                    obj = new a.g(name2, "Audio");
                }
                aVar.onNext(obj);
                return;
            }
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar2 = this.f42212a.f42171f;
            ReceiverDisplayInfo e3 = this.f42212a.e();
            if (!(e3 == null || (chatType = e3.getChatType()) == null || (name = chatType.name()) == null)) {
                obj = new a.f(name, "Audio");
            }
            aVar2.onNext(obj);
        }
    }

    public final void a(BaseMessage baseMessage) {
        if (this.f42166a != null) {
            String str = this.f42169d;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            if (com.paytm.android.chat.d.a.b.a(str) != null) {
                String str2 = this.f42169d;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                GroupChannel a2 = com.paytm.android.chat.d.a.b.a(str2);
                if (a2 == null) {
                    kotlin.g.b.k.a();
                }
                a2.deleteMessage(baseMessage, f.f42226a);
            }
        }
    }

    public static void a(String str, String str2) {
        kotlin.g.b.k.c(str, "channelUrl");
        kotlin.g.b.k.c(str2, "message");
        ChatManager b2 = ChatManager.b();
        kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
        b2.a().updateDraftMessageForLocalChannel(str, str2);
    }

    public final void b(boolean z2) {
        int i2;
        long j2;
        String str = this.f42169d;
        if (str == null) {
            kotlin.g.b.k.a();
        }
        if (com.paytm.android.chat.d.a.b.a(str) != null) {
            if (z2) {
                j2 = this.r;
                i2 = 0;
            } else {
                j2 = System.currentTimeMillis();
                i2 = 40;
            }
            MessageListParams messageListParams = new MessageListParams(this.x, i2, BaseChannel.MessageTypeFilter.ALL, (String) null, (List<String>) null, true, true, false, false, false, false, false);
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42166a;
            if (chatGroupChannelDataModel != null) {
                MessageListParams messageListParams2 = messageListParams;
                CPCMessageUtilsKt.fetchMessagesFromProvider(chatGroupChannelDataModel, j2, messageListParams2, new i(this, j2, messageListParams2, z2));
            }
        }
    }

    static final class i implements BaseChannel.GetMessagesHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42231a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f42232b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MessageListParams f42233c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f42234d;

        i(a aVar, long j, MessageListParams messageListParams, boolean z) {
            this.f42231a = aVar;
            this.f42232b = j;
            this.f42233c = messageListParams;
            this.f42234d = z;
        }

        public final void onResult(List<? extends BaseMessage> list, SendBirdException sendBirdException) {
            this.f42231a.s = true;
            this.f42231a.f42171f.onNext(new a.q());
            if (sendBirdException == null) {
                if (!this.f42234d) {
                    this.f42231a.b();
                }
                if (list != null) {
                    String str = this.f42231a.f42169d;
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    GroupChannel a2 = com.paytm.android.chat.d.a.b.a(str);
                    if (a2 != null) {
                        MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) a2, list);
                    }
                }
                this.f42231a.c(!this.f42234d && (list == null || list.size() == 0));
            }
        }
    }

    public final void b() {
        String str = this.f42169d;
        if (str == null) {
            kotlin.g.b.k.a();
        }
        if (com.paytm.android.chat.d.a.b.a(str) != null) {
            String str2 = this.f42169d;
            if (str2 == null) {
                kotlin.g.b.k.a();
            }
            GroupChannel a2 = com.paytm.android.chat.d.a.b.a(str2);
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            a2.markAsRead();
        }
    }

    private void j() {
        c();
        this.j = this.f42174i.listenConnectionManagement(SharedPreferencesUtil.getUserId(), this.y).a(new d(this), (io.reactivex.rxjava3.d.g<? super Throwable>) e.f42225a);
    }

    private void k() {
        d();
        this.k = this.f42174i.addChannelObserver(this.z).a(C0700a.f42177a).a(new b(this), (io.reactivex.rxjava3.d.g<? super Throwable>) c.f42223a);
    }

    public final void c() {
        io.reactivex.rxjava3.b.c cVar = this.j;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public final void d() {
        io.reactivex.rxjava3.b.c cVar = this.k;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public final void b(BaseMessage baseMessage) {
        kotlin.g.b.k.c(baseMessage, "message");
        a(baseMessage);
    }

    public final void a(ArrayList<String> arrayList, List<? extends BaseMessage> list) {
        kotlin.g.b.k.c(arrayList, "channels");
        if (this.f42166a != null) {
            if (list == null) {
                kotlin.g.b.k.a();
            }
            List arrayList2 = new ArrayList(list);
            int i2 = 0;
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i2++;
                this.w.postDelayed(new l(this, it2.next(), arrayList2), ((long) i2) * 251);
            }
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f42239b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f42240c;

        l(a aVar, String str, List list) {
            this.f42238a = aVar;
            this.f42239b = str;
            this.f42240c = list;
        }

        public final void run() {
            a aVar = this.f42238a;
            String str = this.f42239b;
            kotlin.g.b.k.a((Object) str, "channel");
            a.a(aVar, str, this.f42240c);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, ChatGroupChannelDataModel chatGroupChannelDataModel) {
        UserMessageParams userMessageParams = new UserMessageParams();
        userMessageParams.setMessage(str);
        FileDataBean fileDataBean = new FileDataBean();
        fileDataBean.isForward = true;
        Gson gson = this.f42168c;
        if (gson == null) {
            kotlin.g.b.k.a();
        }
        userMessageParams.setData(gson.toJson((Object) fileDataBean));
        this.f42174i.sendMessage(chatGroupChannelDataModel, userMessageParams).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new s(this, chatGroupChannelDataModel), new t(this));
    }

    public static String a(List<? extends SelectContactsBean> list) {
        kotlin.g.b.k.c(list, "selectList");
        if (list.size() == 1) {
            SendContactBean sendContactBean = ((SelectContactsBean) list.get(0)).getSendContactBean();
            kotlin.g.b.k.a((Object) sendContactBean, "selectList[0].sendContactBean");
            return sendContactBean.getContactName();
        } else if (list.size() == 2) {
            kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
            SendContactBean sendContactBean2 = ((SelectContactsBean) list.get(0)).getSendContactBean();
            kotlin.g.b.k.a((Object) sendContactBean2, "selectList[0].sendContactBean");
            String format = String.format("%1$s & %2$s other contact", Arrays.copyOf(new Object[]{sendContactBean2.getContactName(), Integer.valueOf(list.size() - 1)}, 2));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            return format;
        } else {
            kotlin.g.b.aa aaVar2 = kotlin.g.b.aa.f47921a;
            SendContactBean sendContactBean3 = ((SelectContactsBean) list.get(0)).getSendContactBean();
            kotlin.g.b.k.a((Object) sendContactBean3, "selectList[0].sendContactBean");
            String format2 = String.format("%1$s & %2$s other contacts", Arrays.copyOf(new Object[]{sendContactBean3.getContactName(), Integer.valueOf(list.size() - 1)}, 2));
            kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
            return format2;
        }
    }

    public static final class o extends com.google.gsonhtcfix.c.a<List<? extends SelectContactsBean>> {
        o() {
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str, ChatGroupChannelDataModel chatGroupChannelDataModel) {
        Type type = new o().getType();
        Gson gson = this.f42168c;
        if (gson == null) {
            kotlin.g.b.k.a();
        }
        List list = (List) gson.fromJson(str, type);
        UserMessageParams userMessageParams = new UserMessageParams();
        if (list != null && list.size() > 0) {
            ((SelectContactsBean) list.get(0)).isForward = true;
            userMessageParams.setMessage(a((List<? extends SelectContactsBean>) list));
            Gson gson2 = this.f42168c;
            if (gson2 == null) {
                kotlin.g.b.k.a();
            }
            userMessageParams.setData(gson2.toJson((Object) list));
            userMessageParams.setCustomType("contact");
            this.f42174i.sendMessage(chatGroupChannelDataModel, userMessageParams).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new m(this, chatGroupChannelDataModel), new n(this));
        }
    }

    /* access modifiers changed from: private */
    public final void a(FileMessage fileMessage, GroupChannel groupChannel) {
        String data = fileMessage.getData();
        FileMessageParams fileSize = new FileMessageParams().setFileUrl(fileMessage.getUrl()).setCustomType(fileMessage.getCustomType()).setMimeType(fileMessage.getType()).setFileName(fileMessage.getName()).setFileSize(fileMessage.getSize());
        if (!TextUtils.isEmpty(data)) {
            Gson gson = this.f42168c;
            if (gson == null) {
                kotlin.g.b.k.a();
            }
            FileDataBean fileDataBean = (FileDataBean) gson.fromJson(data, FileDataBean.class);
            if (fileDataBean == null) {
                fileDataBean = new FileDataBean();
            }
            fileDataBean.isForward = true;
            Gson gson2 = this.f42168c;
            if (gson2 == null) {
                kotlin.g.b.k.a();
            }
            fileSize.setData(gson2.toJson((Object) fileDataBean));
        } else {
            FileDataBean fileDataBean2 = new FileDataBean();
            fileDataBean2.isForward = true;
            Gson gson3 = this.f42168c;
            if (gson3 == null) {
                kotlin.g.b.k.a();
            }
            fileSize.setData(gson3.toJson((Object) fileDataBean2));
        }
        if (groupChannel == null) {
            kotlin.g.b.k.a();
        }
        MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) groupChannel, (BaseMessage) groupChannel.sendFileMessage(fileSize, (BaseChannel.SendFileMessageHandler) new p(groupChannel)));
    }

    static final class p implements BaseChannel.SendFileMessageHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GroupChannel f42244a;

        p(GroupChannel groupChannel) {
            this.f42244a = groupChannel;
        }

        public final void onSent(FileMessage fileMessage, SendBirdException sendBirdException) {
            MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) this.f42244a, (BaseMessage) fileMessage);
        }
    }

    public final String d(String str) {
        if (this.n == null) {
            return "";
        }
        Context a2 = com.paytm.android.chat.c.a();
        String userId = SharedPreferencesUtil.getUserId();
        ChatUserDataModel chatUserDataModel = this.n;
        if (chatUserDataModel == null) {
            kotlin.g.b.k.a();
        }
        String typePath = FileUtils.getTypePath(a2, userId, chatUserDataModel.getSendbirdUserId(), str);
        kotlin.g.b.k.a((Object) typePath, "FileUtils.getTypePath(Ch…r!!.sendbirdUserId, type)");
        return typePath;
    }

    private String g(String str) {
        if (this.n == null) {
            return "";
        }
        Context a2 = com.paytm.android.chat.c.a();
        String userId = SharedPreferencesUtil.getUserId();
        ChatUserDataModel chatUserDataModel = this.n;
        if (chatUserDataModel == null) {
            kotlin.g.b.k.a();
        }
        return FileUtils.getPath(a2, userId, chatUserDataModel.getSendbirdUserId(), str);
    }

    public final void a(FileMessage fileMessage, boolean z2) {
        boolean z3;
        String str;
        kotlin.g.b.k.c(fileMessage, "message");
        List<String> list = this.o;
        if (list == null) {
            kotlin.g.b.k.a();
        }
        if (list.contains(fileMessage.getUrl())) {
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar = this.f42171f;
            String a2 = com.paytm.android.chat.c.a(R.string.chat_module_downloading, "Downloading...");
            kotlin.g.b.k.a((Object) a2, "ChatApplication.getStrin…oading, \"Downloading...\")");
            aVar.onNext(new a.u(a2));
            return;
        }
        SettingsInfoBean settingsInfoBean = this.m;
        boolean z4 = false;
        if (settingsInfoBean != null) {
            if (settingsInfoBean == null) {
                kotlin.g.b.k.a();
            }
            z3 = settingsInfoBean.settings_media_save2camera_roll;
        } else {
            z3 = false;
        }
        String customType = fileMessage.getCustomType();
        boolean isWifi = NetUtils.getIsWifi(com.paytm.android.chat.c.a());
        if (kotlin.g.b.k.a((Object) "Image", (Object) customType)) {
            SettingsInfoBean settingsInfoBean2 = this.m;
            if (settingsInfoBean2 != null && !z2) {
                if (settingsInfoBean2 == null) {
                    kotlin.g.b.k.a();
                }
                if (settingsInfoBean2.settings_media_photos == 2) {
                    this.f42171f.onNext(new a.r(fileMessage));
                    return;
                }
                SettingsInfoBean settingsInfoBean3 = this.m;
                if (settingsInfoBean3 == null) {
                    kotlin.g.b.k.a();
                }
                if (settingsInfoBean3.settings_media_photos == 0 && !isWifi) {
                    this.f42171f.onNext(new a.r(fileMessage));
                    return;
                }
            }
            if (new File(d(H5ResourceHandlerUtil.IMAGE), fileMessage.getName()).exists() || new File(FileUtils.getAbsCameraPath(), fileMessage.getName()).exists()) {
                return;
            }
            if (z3) {
                z4 = true;
                str = FileUtils.getCameraPath();
            } else {
                str = g(H5ResourceHandlerUtil.IMAGE);
            }
        } else if (kotlin.g.b.k.a((Object) "Audio", (Object) customType)) {
            SettingsInfoBean settingsInfoBean4 = this.m;
            if (settingsInfoBean4 != null && !z2) {
                if (settingsInfoBean4 == null) {
                    kotlin.g.b.k.a();
                }
                if (settingsInfoBean4.settings_media_audio == 2) {
                    this.f42171f.onNext(new a.r(fileMessage));
                    return;
                }
                SettingsInfoBean settingsInfoBean5 = this.m;
                if (settingsInfoBean5 == null) {
                    kotlin.g.b.k.a();
                }
                if (settingsInfoBean5.settings_media_audio == 0 && !isWifi) {
                    this.f42171f.onNext(new a.r(fileMessage));
                    return;
                }
            }
            if (!new File(d(H5ResourceHandlerUtil.AUDIO), fileMessage.getName()).exists()) {
                str = g(H5ResourceHandlerUtil.AUDIO);
            } else {
                return;
            }
        } else {
            SettingsInfoBean settingsInfoBean6 = this.m;
            if (settingsInfoBean6 != null && !z2) {
                if (settingsInfoBean6 == null) {
                    kotlin.g.b.k.a();
                }
                if (settingsInfoBean6.settings_media_documents == 2) {
                    this.f42171f.onNext(new a.r(fileMessage));
                    return;
                }
                SettingsInfoBean settingsInfoBean7 = this.m;
                if (settingsInfoBean7 == null) {
                    kotlin.g.b.k.a();
                }
                if (settingsInfoBean7.settings_media_documents == 0 && !isWifi) {
                    this.f42171f.onNext(new a.r(fileMessage));
                    return;
                }
            }
            if (!new File(d(CommunityPostActivity.TYPE_FILE), fileMessage.getName()).exists()) {
                str = g(CommunityPostActivity.TYPE_FILE);
            } else {
                return;
            }
        }
        this.f42171f.onNext(new a.m());
        List<String> list2 = this.o;
        if (list2 == null) {
            kotlin.g.b.k.a();
        }
        if (list2.contains(fileMessage.getUrl())) {
            com.paytm.android.chat.c.a(R.string.chat_module_downloading, "Downloading...");
            return;
        }
        List<String> list3 = this.o;
        if (list3 != null) {
            String url = fileMessage.getUrl();
            kotlin.g.b.k.a((Object) url, "message.url");
            list3.add(url);
        }
        if (!TextUtils.isEmpty(str)) {
            c.a.a.c a3 = c.a.a.c.a();
            String url2 = fileMessage.getUrl();
            a3.a(url2, str, fileMessage.getName() + ".temp", new g(this, fileMessage, z4));
        }
    }

    public static final class g implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42227a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileMessage f42228b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f42229c;

        g(a aVar, FileMessage fileMessage, boolean z) {
            this.f42227a = aVar;
            this.f42228b = fileMessage;
            this.f42229c = z;
        }

        public final void a(File file) {
            kotlin.g.b.k.c(file, CommunityPostActivity.TYPE_FILE);
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                kotlin.g.b.k.a((Object) absolutePath, "oldPath");
                int length = absolutePath.length() - 5;
                if (absolutePath != null) {
                    String substring = absolutePath.substring(0, length);
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    FileUtils.renameFile(absolutePath, substring);
                    String unused = this.f42227a.l;
                    com.paytm.utility.q.a("down success====2" + file.getAbsolutePath());
                    List h2 = this.f42227a.o;
                    if (h2 != null) {
                        h2.remove(this.f42228b.getUrl());
                    }
                    this.f42227a.f42171f.onNext(new a.n(this.f42228b));
                    if (this.f42229c) {
                        this.f42227a.f42171f.onNext(new a.x(file));
                        return;
                    }
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
            }
        }

        public final void a(int i2) {
            this.f42227a.f42171f.onNext(new a.o(i2, this.f42228b));
        }

        public final void a() {
            List h2 = this.f42227a.o;
            if (h2 != null) {
                h2.remove(this.f42228b.getUrl());
            }
        }
    }

    static final class ac<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42197a;

        ac(a aVar) {
            this.f42197a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String unused = this.f42197a.l;
            com.paytm.utility.q.c("getUserInfoState");
        }
    }

    static final class k<T> implements io.reactivex.rxjava3.d.r<io.reactivex.rxjava3.a.ac<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42237a;

        k(a aVar) {
            this.f42237a = aVar;
        }

        public final /* synthetic */ Object get() {
            return io.reactivex.rxjava3.a.y.a(this.f42237a.f42172g);
        }
    }

    public final void a(FileMessage fileMessage) {
        boolean z2;
        String str;
        ArrayList arrayList = new ArrayList();
        SettingsInfoBean settingsInfoBean = this.m;
        if (settingsInfoBean != null) {
            if (settingsInfoBean == null) {
                kotlin.g.b.k.a();
            }
            z2 = settingsInfoBean.settings_media_save2camera_roll;
        } else {
            z2 = false;
        }
        if (z2) {
            str = FileUtils.getCameraPath();
        } else {
            str = g(H5ResourceHandlerUtil.IMAGE);
        }
        List arrayList2 = new ArrayList();
        arrayList2.add(c((BaseMessage) fileMessage));
        int size = arrayList2.size();
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            ChatMessageDataModel chatMessageDataModel = (ChatMessageDataModel) arrayList2.get(i3);
            if ((chatMessageDataModel instanceof ChatImageMessageDataModel) && kotlin.g.b.k.a((Object) "Image", (Object) chatMessageDataModel.customType)) {
                if (kotlin.g.b.k.a((Object) chatMessageDataModel.fileName, (Object) fileMessage.getName())) {
                    i2 = i3;
                }
                com.zhihu.matisse.a.a aVar = new com.zhihu.matisse.a.a();
                aVar.a(chatMessageDataModel.fileName);
                ChatImageMessageDataModel chatImageMessageDataModel = (ChatImageMessageDataModel) chatMessageDataModel;
                aVar.c(chatImageMessageDataModel.thumbnail);
                aVar.b(chatMessageDataModel.fileUrl);
                aVar.a();
                if (!new File(chatImageMessageDataModel.filePath).exists()) {
                    File file = new File(d(H5ResourceHandlerUtil.IMAGE), chatMessageDataModel.fileName);
                    if (!file.exists()) {
                        File file2 = new File(FileUtils.getAbsCameraPath(), chatMessageDataModel.fileName);
                        if (file2.exists()) {
                            aVar.d(file2.getAbsolutePath());
                        }
                    } else {
                        aVar.d(file.getAbsolutePath());
                    }
                } else {
                    aVar.d(chatImageMessageDataModel.filePath);
                }
                aVar.e(str);
                arrayList.add(aVar);
            }
        }
        arrayList.size();
        this.f42171f.onNext(new a.ac(arrayList, i2));
    }

    public final void b(FileMessage fileMessage) {
        String str;
        kotlin.g.b.k.c(fileMessage, "message");
        String customType = fileMessage.getCustomType();
        File file = null;
        if (kotlin.g.b.k.a((Object) "Image", (Object) customType)) {
            a(fileMessage);
            str = "";
        } else if (kotlin.g.b.k.a((Object) "Audio", (Object) customType)) {
            str = d(H5ResourceHandlerUtil.AUDIO);
        } else {
            str = d(CommunityPostActivity.TYPE_FILE);
            file = new File(str, fileMessage.getName());
            if (file.exists()) {
                List<String> list = this.o;
                if (list != null) {
                    list.remove(fileMessage.getUrl());
                }
                this.f42171f.onNext(new a.ab(file));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (file == null || !file.exists()) {
                a(fileMessage, false);
            }
        }
    }

    public static final class aq implements BaseChannel.SendUserMessageHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42210a;

        public aq(a aVar) {
            this.f42210a = aVar;
        }

        public final void onSent(UserMessage userMessage, SendBirdException sendBirdException) {
            String str = this.f42210a.f42169d;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.b.a(str), (BaseMessage) userMessage);
        }
    }

    public static void a(TxNotifyData txNotifyData) {
        kotlin.g.b.k.c(txNotifyData, "request");
        kotlin.g.b.k.c(txNotifyData, "request");
        io.reactivex.rxjava3.a.y a2 = io.reactivex.rxjava3.a.y.a(new u(txNotifyData)).c().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a());
        kotlin.g.b.k.a((Object) a2, "Single.create { emitter:…dSchedulers.mainThread())");
        a2.a(af.f42199a, (io.reactivex.rxjava3.d.g<? super Throwable>) ag.f42200a);
    }

    static final class u<T> implements io.reactivex.rxjava3.a.ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TxNotifyData f42252a;

        u(TxNotifyData txNotifyData) {
            this.f42252a = txNotifyData;
        }

        public final void subscribe(io.reactivex.rxjava3.a.z<ResponseBase> zVar) {
            kotlin.g.b.k.c(zVar, "emitter");
            com.paytm.a aVar = com.paytm.a.f40823c;
            ResponseBase a2 = com.paytm.a.a(this.f42252a);
            if (a2 != null) {
                if (!zVar.isDisposed()) {
                    zVar.onSuccess(a2);
                }
            } else if (!zVar.isDisposed()) {
                zVar.onError(new Exception("txnotify response is null"));
            }
        }
    }

    public final ReceiverDisplayInfo e() {
        ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42166a;
        if (chatGroupChannelDataModel == null || chatGroupChannelDataModel == null) {
            return null;
        }
        return chatGroupChannelDataModel.getReceiverDisplayInfo();
    }

    public final void f() {
        CharSequence charSequence = this.f42169d;
        if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
            io.reactivex.rxjava3.b.c cVar = this.f42170e;
            if (cVar == null || cVar.isDisposed()) {
                String str = this.f42169d;
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                this.f42170e = MessageDBHelperKt.getMessagesByChannel(str).a(new w(this)).a(new x(this)).a(new y(this)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new z(this), (io.reactivex.rxjava3.d.g<? super Throwable>) new aa(this));
            }
            h();
            j();
            k();
            b();
        }
    }

    static final class w<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42253a;

        w(a aVar) {
            this.f42253a = aVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public List<ChatMessageDataModel> apply(List<? extends ChatMessageDataModel> list) {
            kotlin.g.b.k.c(list, "result");
            if (this.f42253a.f42166a == null) {
                try {
                    a aVar = this.f42253a;
                    ChatRepository chatRepository = this.f42253a.f42174i;
                    String str = this.f42253a.f42169d;
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    aVar.f42166a = chatRepository.fetchChannelForDisplay(str).b();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return list;
        }
    }

    /* access modifiers changed from: private */
    public final void c(boolean z2) {
        if (!this.v.isEmpty() || this.s) {
            if (z2 && this.v.isEmpty() && !this.q) {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42166a;
                if (chatGroupChannelDataModel != null) {
                    this.f42171f.onNext(chatGroupChannelDataModel != null ? new a.s(chatGroupChannelDataModel.isReplyAllowed()) : null);
                } else {
                    this.f42171f.onNext(new a.s(true));
                }
            }
            this.f42171f.onNext(new a.w());
        }
    }

    public final io.reactivex.rxjava3.a.y<ChatGroupChannelDataModel> e(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        io.reactivex.rxjava3.a.y<R> b2 = this.f42174i.fetchChannelForDisplay(str).b(new h(this));
        kotlin.g.b.k.a((Object) b2, "repository.fetchChannelF…        channel\n        }");
        return b2;
    }

    public final io.reactivex.rxjava3.a.y<List<User>> g() {
        return this.f42174i.getBlockedUserList();
    }

    public final ChatUserDataModel a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
        return this.f42174i.getOtherMember(chatGroupChannelDataModel);
    }

    public final io.reactivex.rxjava3.a.y<GroupChannel> f(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        io.reactivex.rxjava3.a.y<GroupChannel> a2 = this.f42174i.getSendbirdGroupChannel(str).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a());
        kotlin.g.b.k.a((Object) a2, "repository.getSendbirdGr…dSchedulers.mainThread())");
        return a2;
    }

    static final class aa<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42191a;

        aa(a aVar) {
            this.f42191a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42191a.c(true);
        }
    }

    public static final /* synthetic */ void a(a aVar, String str, List list) {
        if (kotlin.g.b.k.a((Object) str, (Object) aVar.f42169d)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                BaseMessage baseMessage = (BaseMessage) it2.next();
                String str2 = aVar.f42169d;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                if (com.paytm.android.chat.d.a.b.a(str2) != null) {
                    ChatRepository chatRepository = aVar.f42174i;
                    String str3 = aVar.f42169d;
                    if (str3 == null) {
                        kotlin.g.b.k.a();
                    }
                    ChatGroupChannelDataModel localChannelByIdBlocking = chatRepository.getLocalChannelByIdBlocking(str3);
                    if (baseMessage instanceof UserMessage) {
                        if (kotlin.g.b.k.a((Object) "contact", (Object) baseMessage.getCustomType())) {
                            String data = baseMessage.getData();
                            kotlin.g.b.k.a((Object) data, "baseMessage.getData()");
                            aVar.b(data, localChannelByIdBlocking);
                        } else if (kotlin.g.b.k.a((Object) "location", (Object) baseMessage.getCustomType())) {
                            com.paytm.utility.q.a("A location message was sent");
                        } else {
                            String message = ((UserMessage) baseMessage).getMessage();
                            kotlin.g.b.k.a((Object) message, "baseMessage.message");
                            aVar.a(message, localChannelByIdBlocking);
                        }
                    } else if (baseMessage instanceof FileMessage) {
                        FileMessage fileMessage = (FileMessage) baseMessage;
                        String str4 = aVar.f42169d;
                        if (str4 == null) {
                            kotlin.g.b.k.a();
                        }
                        aVar.a(fileMessage, com.paytm.android.chat.d.a.b.a(str4));
                    }
                }
            }
            aVar.f42171f.onNext(new a.e());
            return;
        }
        aVar.f(str).a(new q(aVar, list, str), (io.reactivex.rxjava3.d.g<? super Throwable>) new r(aVar));
    }
}
