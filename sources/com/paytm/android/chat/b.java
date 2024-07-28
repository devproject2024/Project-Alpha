package com.paytm.android.chat;

import android.content.Context;
import androidx.recyclerview.widget.h;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.paytm.android.chat.bean.ChatFriendsHeader;
import com.paytm.android.chat.bean.ChatHomeChip;
import com.paytm.android.chat.bean.FriendBean;
import com.paytm.android.chat.bean.FriendsCache;
import com.paytm.android.chat.bean.HomeFilter;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.SendContactBean;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.h;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.network.response.HomeChips;
import com.paytm.android.chat.network.response.Page;
import com.paytm.android.chat.network.response.ResponseOfFriends;
import com.paytm.android.chat.network.response.ResponseSF;
import com.paytm.android.chat.network.response.View;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.ChatConfigUtil;
import com.paytm.android.chat.utils.ChatHomeDiffUtil;
import com.paytm.android.chat.utils.ChatHomeListEvent;
import com.paytm.android.chat.utils.ChatMessageState;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.constant.StringSet;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final com.google.gson.f f41761a = new com.google.gson.f();

    /* renamed from: b  reason: collision with root package name */
    public final ChatRepository f41762b;

    /* renamed from: c  reason: collision with root package name */
    public final List<ChatGroupChannelDataModel> f41763c;

    /* renamed from: d  reason: collision with root package name */
    final List<SelectContactsBean> f41764d;

    /* renamed from: e  reason: collision with root package name */
    final Map<String, SendContactBean> f41765e;

    /* renamed from: f  reason: collision with root package name */
    public String f41766f;

    /* renamed from: g  reason: collision with root package name */
    public io.reactivex.rxjava3.b.c f41767g;

    /* renamed from: h  reason: collision with root package name */
    public String f41768h;

    /* renamed from: i  reason: collision with root package name */
    public final io.reactivex.rxjava3.j.a<a> f41769i;
    public io.reactivex.rxjava3.b.c j;
    boolean k;
    boolean l;
    h m;
    final C0693b n;
    private final List<HomeChips> o;
    private final Map<String, FriendBean> p;
    private final List<Object> q;
    private int r;
    private final Context s;

    /* renamed from: com.paytm.android.chat.b$b  reason: collision with other inner class name */
    public interface C0693b {
        void a(List<Object> list, h.b bVar, int i2, List<FriendBean> list2, int i3);

        void a(List<Object> list, h.b bVar, String str);
    }

    public static final class g<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f41785a = new g();

        g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public static final class e<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41783a;

        public e(b bVar) {
            this.f41783a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ResponseOfFriends responseOfFriends = (ResponseOfFriends) obj;
            b bVar = this.f41783a;
            ResponseOfFriends.DataOfFriends dataOfFriends = responseOfFriends.data;
            bVar.f41766f = dataOfFriends != null ? dataOfFriends.next : null;
            b bVar2 = this.f41783a;
            kotlin.g.b.k.a((Object) responseOfFriends, Payload.RESPONSE);
            return b.a(bVar2, responseOfFriends);
        }
    }

    public static final class f<T> implements io.reactivex.rxjava3.d.g<Map<String, ? extends FriendBean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41784a;

        public f(b bVar) {
            this.f41784a = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41784a.f41769i.onNext(new a((List) null, (List) null, (Map) obj, 3));
        }
    }

    public static final class h<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41786a;

        public h(b bVar) {
            this.f41786a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            if (this.f41786a.l) {
                kotlin.g.b.k.a((Object) list, "channelList");
                if (!list.isEmpty()) {
                    b bVar = this.f41786a;
                    bVar.l = false;
                    h hVar = bVar.m;
                    kotlin.g.b.k.c(list, "list");
                    y.a(new h.a(hVar, list)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(h.b.f42257a, (io.reactivex.rxjava3.d.g<? super Throwable>) h.c.f42259a);
                }
            }
            return list;
        }
    }

    public static final class i<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41787a;

        public i(b bVar) {
            this.f41787a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List<ChatGroupChannelDataModel> list = (List) obj;
            kotlin.g.b.k.a((Object) list, "channelList");
            for (ChatGroupChannelDataModel chatGroupChannelDataModel : list) {
                GroupChannel sendbirdChannel = this.f41787a.f41762b.getSendbirdChannel(chatGroupChannelDataModel.getChannelUrl());
                if (sendbirdChannel != null) {
                    ChatMessageDataModel lastMessage = chatGroupChannelDataModel.getLastMessage();
                    if (lastMessage != null) {
                        lastMessage.messageState = ChatMessageState.Companion.getMessageState(sendbirdChannel, lastMessage.baseMessage);
                    }
                    chatGroupChannelDataModel.setTyping(sendbirdChannel.isTyping());
                }
            }
            return list;
        }
    }

    public static final class j<T> implements io.reactivex.rxjava3.d.g<List<? extends ChatGroupChannelDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41788a;

        public j(b bVar) {
            this.f41788a = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41788a.f41769i.onNext(new a((List) null, (List) obj, (Map) null, 5));
        }
    }

    public static final class l<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41790a;

        public l(b bVar) {
            this.f41790a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            a aVar = (a) obj;
            b bVar = this.f41790a;
            kotlin.g.b.k.a((Object) aVar, "chatHomeSubList");
            return bVar.a(aVar);
        }
    }

    public static final class m<T> implements io.reactivex.rxjava3.d.g<ChatHomeListEvent> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41791a;

        public m(b bVar) {
            this.f41791a = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            ChatHomeListEvent chatHomeListEvent = (ChatHomeListEvent) obj;
            b bVar = this.f41791a;
            kotlin.g.b.k.a((Object) chatHomeListEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (chatHomeListEvent instanceof ChatHomeListEvent.ChatHomeNormalList) {
                ChatHomeListEvent.ChatHomeNormalList chatHomeNormalList = (ChatHomeListEvent.ChatHomeNormalList) chatHomeListEvent;
                bVar.n.a(chatHomeNormalList.getList(), chatHomeNormalList.getDiffResult(), chatHomeNormalList.getTotalUnreadCount(), chatHomeNormalList.getFriendList(), chatHomeNormalList.getChannelSize());
            } else if (chatHomeListEvent instanceof ChatHomeListEvent.ChatHomeSearchList) {
                ChatHomeListEvent.ChatHomeSearchList chatHomeSearchList = (ChatHomeListEvent.ChatHomeSearchList) chatHomeListEvent;
                bVar.n.a(chatHomeSearchList.getList(), chatHomeSearchList.getDiffResult(), chatHomeSearchList.getQuery());
            }
        }
    }

    static final class o<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41793a;

        o(b bVar) {
            this.f41793a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            com.paytm.android.chat.contact.c cVar = (com.paytm.android.chat.contact.c) obj;
            this.f41793a.f41764d.clear();
            List<SelectContactsBean> list = this.f41793a.f41764d;
            kotlin.g.b.k.a((Object) cVar, "contactListModel");
            ArrayList<SelectContactsBean> a2 = cVar.a();
            kotlin.g.b.k.a((Object) a2, "contactListModel.selectContacts");
            list.addAll(a2);
            Map linkedHashMap = new LinkedHashMap();
            for (SelectContactsBean selectContactsBean : this.f41793a.f41764d) {
                SendContactBean sendContactBean = selectContactsBean.getSendContactBean();
                kotlin.g.b.k.a((Object) sendContactBean, "contact.sendContactBean");
                String contactPhone = sendContactBean.getContactPhone();
                kotlin.g.b.k.a((Object) contactPhone, "contact.sendContactBean.contactPhone");
                String convertToHash = AppUtilKt.convertToHash(AppUtilKt.sanitizeContact(contactPhone));
                CharSequence charSequence = convertToHash;
                if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
                    SendContactBean sendContactBean2 = selectContactsBean.getSendContactBean();
                    kotlin.g.b.k.a((Object) sendContactBean2, "contact.sendContactBean");
                    String contactName = sendContactBean2.getContactName();
                    kotlin.g.b.k.a((Object) contactName, "contact.sendContactBean.contactName");
                    linkedHashMap.put(convertToHash, contactName);
                    Map<String, SendContactBean> map = this.f41793a.f41765e;
                    SendContactBean sendContactBean3 = selectContactsBean.getSendContactBean();
                    kotlin.g.b.k.a((Object) sendContactBean3, "contact.sendContactBean");
                    map.put(convertToHash, sendContactBean3);
                }
            }
            long currentTimeMillis = System.currentTimeMillis() - SharedPreferencesUtil.getLong(SharedPreferencesUtil.Key.last_time_contacts_updated_to_sendbird, 0);
            com.paytm.android.chat.e.b a3 = e.a();
            kotlin.g.b.k.a((Object) a3, "ChatHelper.getIChatListener()");
            if (currentTimeMillis > a3.b()) {
                com.paytm.a aVar = com.paytm.a.f40823c;
                com.paytm.a.a((Map<String, String>) linkedHashMap).b();
                SharedPreferencesUtil.saveLong(SharedPreferencesUtil.Key.last_time_contacts_updated_to_sendbird, System.currentTimeMillis());
                if (ChatConfigUtil.Companion.getInstance().getActiveUIConfig().f41778b) {
                    return this.f41793a.a((String) null).b();
                }
            } else if (ChatConfigUtil.Companion.getInstance().getActiveUIConfig().f41778b) {
                return this.f41793a.a((String) null).b();
            }
            throw new Exception("friends is disabled or error");
        }
    }

    static final class p<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41794a;

        p(b bVar) {
            this.f41794a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ResponseOfFriends responseOfFriends = (ResponseOfFriends) obj;
            b bVar = this.f41794a;
            ResponseOfFriends.DataOfFriends dataOfFriends = responseOfFriends.data;
            bVar.f41766f = dataOfFriends != null ? dataOfFriends.next : null;
            b bVar2 = this.f41794a;
            kotlin.g.b.k.a((Object) responseOfFriends, Payload.RESPONSE);
            return b.a(bVar2, responseOfFriends);
        }
    }

    static final class q<T> implements io.reactivex.rxjava3.d.g<Map<String, ? extends FriendBean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41795a;

        q(b bVar) {
            this.f41795a = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41795a.f41769i.onNext(new a((List) null, (List) null, (Map) obj, 3));
        }
    }

    public static final class t<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41798a;

        public t(b bVar) {
            this.f41798a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ArrayList<View> views;
            View view;
            String str = (String) obj;
            SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.FILTER_CACHE, str);
            Page page = (Page) kotlin.a.k.e(((ResponseSF) this.f41798a.f41761a.a(str, ResponseSF.class)).getPage());
            if (page == null || (views = page.getViews()) == null || (view = (View) kotlin.a.k.e(views)) == null) {
                return null;
            }
            return view.getItems();
        }
    }

    public static final class u<T> implements io.reactivex.rxjava3.d.g<ArrayList<HomeChips>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41799a;

        public u(b bVar) {
            this.f41799a = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41799a.f41769i.onNext(new a((ArrayList) obj, (List) null, (Map) null, 6));
        }
    }

    public b(Context context, C0693b bVar) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(bVar, "listner");
        this.s = context;
        this.n = bVar;
        ChatManager b2 = ChatManager.b();
        kotlin.g.b.k.a((Object) b2, "ChatManager.getInstance()");
        this.f41762b = b2.a();
        this.o = new ArrayList();
        this.f41763c = new ArrayList();
        this.p = new LinkedHashMap();
        this.f41764d = new ArrayList();
        this.q = new ArrayList();
        this.f41765e = new LinkedHashMap();
        this.f41769i = io.reactivex.rxjava3.j.a.a();
        this.k = true;
        this.l = true;
        this.m = new h();
    }

    static final class d<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41782a;

        d(b bVar) {
            this.f41782a = bVar;
        }

        public final void subscribe(z<ResponseSF> zVar) {
            String string = SharedPreferencesUtil.getString(SharedPreferencesUtil.Key.FILTER_CACHE, "");
            CharSequence charSequence = string;
            if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
                zVar.onSuccess(this.f41782a.f41761a.a(string, ResponseSF.class));
            } else {
                zVar.onError(new Exception("homechip cache not available"));
            }
        }
    }

    public final void a() {
        if (this.k) {
            this.k = false;
            com.paytm.android.chat.contact.f.a(this.s).a().b(new o(this)).b(new p(this)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(new q(this), (io.reactivex.rxjava3.d.g<? super Throwable>) new r(this));
        }
    }

    public static final class s<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41797a;

        public s(b bVar) {
            this.f41797a = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void subscribe(io.reactivex.rxjava3.a.z<java.lang.String> r6) {
            /*
                r5 = this;
                r0 = 0
                com.paytm.android.chat.b r1 = r5.f41797a     // Catch:{ Exception -> 0x0044 }
                com.paytm.android.chat.b$d r2 = new com.paytm.android.chat.b$d     // Catch:{ Exception -> 0x0044 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0044 }
                io.reactivex.rxjava3.a.ab r2 = (io.reactivex.rxjava3.a.ab) r2     // Catch:{ Exception -> 0x0044 }
                io.reactivex.rxjava3.a.y r1 = io.reactivex.rxjava3.a.y.a(r2)     // Catch:{ Exception -> 0x0044 }
                io.reactivex.rxjava3.a.x r2 = io.reactivex.rxjava3.i.a.b()     // Catch:{ Exception -> 0x0044 }
                io.reactivex.rxjava3.a.y r1 = r1.b((io.reactivex.rxjava3.a.x) r2)     // Catch:{ Exception -> 0x0044 }
                java.lang.String r2 = "Single.create<ResponseSF…scribeOn(Schedulers.io())"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0044 }
                java.lang.Object r1 = r1.b()     // Catch:{ Exception -> 0x0044 }
                com.paytm.android.chat.network.response.ResponseSF r1 = (com.paytm.android.chat.network.response.ResponseSF) r1     // Catch:{ Exception -> 0x0044 }
                java.util.ArrayList r1 = r1.getPage()     // Catch:{ Exception -> 0x0044 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0044 }
                java.lang.Object r1 = kotlin.a.k.e(r1)     // Catch:{ Exception -> 0x0044 }
                com.paytm.android.chat.network.response.Page r1 = (com.paytm.android.chat.network.response.Page) r1     // Catch:{ Exception -> 0x0044 }
                if (r1 == 0) goto L_0x0044
                java.util.ArrayList r1 = r1.getViews()     // Catch:{ Exception -> 0x0044 }
                if (r1 == 0) goto L_0x0044
                java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0044 }
                java.lang.Object r1 = kotlin.a.k.e(r1)     // Catch:{ Exception -> 0x0044 }
                com.paytm.android.chat.network.response.View r1 = (com.paytm.android.chat.network.response.View) r1     // Catch:{ Exception -> 0x0044 }
                if (r1 == 0) goto L_0x0044
                java.util.ArrayList r1 = r1.getItems()     // Catch:{ Exception -> 0x0044 }
                goto L_0x0045
            L_0x0044:
                r1 = r0
            L_0x0045:
                if (r1 == 0) goto L_0x0056
                com.paytm.android.chat.b r2 = r5.f41797a
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.b$a> r2 = r2.f41769i
                com.paytm.android.chat.b$a r3 = new com.paytm.android.chat.b$a
                java.util.List r1 = (java.util.List) r1
                r4 = 6
                r3.<init>(r1, r0, r0, r4)
                r2.onNext(r3)
            L_0x0056:
                java.lang.String r0 = com.paytm.android.chat.b.b()
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0068
                boolean r1 = kotlin.m.p.a(r1)
                if (r1 == 0) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r1 = 0
                goto L_0x0069
            L_0x0068:
                r1 = 1
            L_0x0069:
                if (r1 != 0) goto L_0x006f
                r6.onSuccess(r0)
                return
            L_0x006f:
                java.lang.Exception r0 = new java.lang.Exception
                java.lang.String r1 = "fetchHomeChipsApi error"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r6.onError(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.b.s.subscribe(io.reactivex.rxjava3.a.z):void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0054 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized com.paytm.android.chat.utils.ChatHomeListEvent c(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r0.<init>()     // Catch:{ all -> 0x00fd }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x00fd }
            java.util.List<com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel> r1 = r10.f41763c     // Catch:{ all -> 0x00fd }
            java.util.List r1 = r10.a((java.util.List<com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel>) r1)     // Catch:{ all -> 0x00fd }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x00fd }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r2.<init>()     // Catch:{ all -> 0x00fd }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x00fd }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00fd }
        L_0x001b:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00fd }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0043
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00fd }
            r6 = r3
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r6 = (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r6     // Catch:{ all -> 0x00fd }
            com.paytm.android.chat.bean.ReceiverDisplayInfo r6 = r6.getReceiverDisplayInfo()     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x003d
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00fd }
            r4 = r11
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x00fd }
            boolean r4 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.CharSequence) r4, (boolean) r5)     // Catch:{ all -> 0x00fd }
        L_0x003d:
            if (r4 == 0) goto L_0x001b
            r2.add(r3)     // Catch:{ all -> 0x00fd }
            goto L_0x001b
        L_0x0043:
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x00fd }
            java.util.List<com.paytm.android.chat.bean.SelectContactsBean> r1 = r10.f41764d     // Catch:{ all -> 0x00fd }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x00fd }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r3.<init>()     // Catch:{ all -> 0x00fd }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x00fd }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00fd }
        L_0x0054:
            boolean r6 = r1.hasNext()     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x00a5
            java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x00fd }
            r7 = r6
            com.paytm.android.chat.bean.SelectContactsBean r7 = (com.paytm.android.chat.bean.SelectContactsBean) r7     // Catch:{ all -> 0x00fd }
            com.paytm.android.chat.bean.SendContactBean r8 = r7.getSendContactBean()     // Catch:{ all -> 0x00fd }
            java.lang.String r9 = "it.sendContactBean"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = r8.getContactName()     // Catch:{ all -> 0x00fd }
            java.lang.String r9 = "it.sendContactBean.contactName"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ all -> 0x00fd }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x00fd }
            r9 = r11
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ all -> 0x00fd }
            boolean r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (boolean) r5)     // Catch:{ all -> 0x00fd }
            if (r8 != 0) goto L_0x009e
            com.paytm.android.chat.bean.SendContactBean r7 = r7.getSendContactBean()     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = "it.sendContactBean"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ all -> 0x00fd }
            java.lang.String r7 = r7.getContactPhone()     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = "it.sendContactBean.contactPhone"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ all -> 0x00fd }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00fd }
            r8 = r11
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x00fd }
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (boolean) r5)     // Catch:{ all -> 0x00fd }
            if (r7 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r7 = 0
            goto L_0x009f
        L_0x009e:
            r7 = 1
        L_0x009f:
            if (r7 == 0) goto L_0x0054
            r3.add(r6)     // Catch:{ all -> 0x00fd }
            goto L_0x0054
        L_0x00a5:
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x00fd }
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x00fd }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00fd }
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x00be
            com.paytm.android.chat.bean.ChatChannelHeader r1 = new com.paytm.android.chat.bean.ChatChannelHeader     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            r0.add(r1)     // Catch:{ all -> 0x00fd }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x00fd }
            r0.addAll(r2)     // Catch:{ all -> 0x00fd }
        L_0x00be:
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x00fd }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00fd }
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x00d5
            com.paytm.android.chat.bean.ChatContactHeader r1 = new com.paytm.android.chat.bean.ChatContactHeader     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            r0.add(r1)     // Catch:{ all -> 0x00fd }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x00fd }
            r0.addAll(r3)     // Catch:{ all -> 0x00fd }
        L_0x00d5:
            com.paytm.android.chat.utils.ChatHomeDiffUtil r1 = new com.paytm.android.chat.utils.ChatHomeDiffUtil     // Catch:{ all -> 0x00fd }
            java.util.List<java.lang.Object> r2 = r10.q     // Catch:{ all -> 0x00fd }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x00fd }
            androidx.recyclerview.widget.h$a r1 = (androidx.recyclerview.widget.h.a) r1     // Catch:{ all -> 0x00fd }
            androidx.recyclerview.widget.h$b r1 = androidx.recyclerview.widget.h.b(r1)     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = "DiffUtil.calculateDiff(C…, searchFinalList), true)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
            java.util.List<java.lang.Object> r2 = r10.q     // Catch:{ all -> 0x00fd }
            r2.clear()     // Catch:{ all -> 0x00fd }
            java.util.List<java.lang.Object> r2 = r10.q     // Catch:{ all -> 0x00fd }
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x00fd }
            r2.addAll(r3)     // Catch:{ all -> 0x00fd }
            com.paytm.android.chat.utils.ChatHomeListEvent$ChatHomeSearchList r2 = new com.paytm.android.chat.utils.ChatHomeListEvent$ChatHomeSearchList     // Catch:{ all -> 0x00fd }
            r2.<init>(r0, r1, r11)     // Catch:{ all -> 0x00fd }
            com.paytm.android.chat.utils.ChatHomeListEvent r2 = (com.paytm.android.chat.utils.ChatHomeListEvent) r2     // Catch:{ all -> 0x00fd }
            monitor-exit(r10)
            return r2
        L_0x00fd:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.b.c(java.lang.String):com.paytm.android.chat.utils.ChatHomeListEvent");
    }

    private final List<ChatGroupChannelDataModel> a(List<ChatGroupChannelDataModel> list) {
        String a2 = e.a().a("chat_home_filter_v2", "");
        CharSequence charSequence = a2;
        HomeFilter homeFilter = !(charSequence == null || kotlin.m.p.a(charSequence)) ? (HomeFilter) this.f41761a.a(a2, HomeFilter.class) : null;
        if (homeFilter == null || list.size() < homeFilter.getCount()) {
            return list;
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) next;
            Iterator<String> it2 = homeFilter.getFilters().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (kotlin.m.p.a(chatGroupChannelDataModel.getCustomType(), it2.next(), true)) {
                    break;
                }
                i2++;
            }
            if (i2 != homeFilter.getFilters().size()) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    static final class c<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41780a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f41781b;

        c(b bVar, String str) {
            this.f41780a = bVar;
            this.f41781b = str;
        }

        public final void subscribe(z<ResponseOfFriends> zVar) {
            ResponseOfFriends b2 = this.f41780a.b(this.f41781b);
            if (b2 != null) {
                zVar.onSuccess(b2);
            } else {
                zVar.onError(new Exception("friends fetch error"));
            }
        }
    }

    public final y<ResponseOfFriends> a(String str) {
        y<ResponseOfFriends> b2 = y.a(new c(this, str)).b(io.reactivex.rxjava3.i.a.b());
        kotlin.g.b.k.a((Object) b2, "Single.create<ResponseOf…scribeOn(Schedulers.io())");
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final ResponseOfFriends b(String str) {
        com.paytm.utility.q.d("Request");
        if (str == null) {
            str = UrlManager.getUrl(UrlProfileList.GET_FRIEND_LIST);
        }
        c.a.a.r.a(str);
        Request build = new Request.Builder().url(str).headers(new Headers.Builder().add(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, SharedPreferencesUtil.getToken()).build()).build();
        c.a.a.j b2 = c.a.a.j.b();
        kotlin.g.b.k.a((Object) b2, "OkHttpFinal.getInstance()");
        try {
            Response execute = FirebasePerfOkHttpClient.execute(b2.c().newCall(build));
            kotlin.g.b.k.a((Object) execute, Payload.RESPONSE);
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                String string = body != null ? body.string() : null;
                com.paytm.utility.q.d("response\n".concat(String.valueOf(string)));
                return (ResponseOfFriends) this.f41761a.a(string, ResponseOfFriends.class);
            }
            com.paytm.utility.q.d("response error");
            return null;
        } catch (Exception unused) {
            com.paytm.utility.q.a();
            return null;
        }
    }

    static String b() {
        com.paytm.utility.q.d("Request");
        Request build = new Request.Builder().url("https://storefront.paytm.com/v2/h/paytm-chat-home?client=androidapp&site_id=1&version=8").post(RequestBody.create((MediaType) null, "")).build();
        c.a.a.j b2 = c.a.a.j.b();
        kotlin.g.b.k.a((Object) b2, "OkHttpFinal.getInstance()");
        try {
            Response execute = FirebasePerfOkHttpClient.execute(b2.c().newCall(build));
            kotlin.g.b.k.a((Object) execute, Payload.RESPONSE);
            if (execute.isSuccessful()) {
                ResponseBody body = execute.body();
                String string = body != null ? body.string() : null;
                com.paytm.utility.q.d("response\n".concat(String.valueOf(string)));
                return string;
            }
            com.paytm.utility.q.d("response error");
            return null;
        } catch (Exception unused) {
            com.paytm.utility.q.a();
            return null;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<HomeChips> f41770a;

        /* renamed from: b  reason: collision with root package name */
        final List<ChatGroupChannelDataModel> f41771b;

        /* renamed from: c  reason: collision with root package name */
        final Map<String, FriendBean> f41772c;

        public a() {
            this((List) null, (List) null, (Map) null, 7);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.g.b.k.a((Object) this.f41770a, (Object) aVar.f41770a) && kotlin.g.b.k.a((Object) this.f41771b, (Object) aVar.f41771b) && kotlin.g.b.k.a((Object) this.f41772c, (Object) aVar.f41772c);
        }

        public final int hashCode() {
            List<HomeChips> list = this.f41770a;
            int i2 = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<ChatGroupChannelDataModel> list2 = this.f41771b;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            Map<String, FriendBean> map = this.f41772c;
            if (map != null) {
                i2 = map.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "ChatHomeSubList(homeChipsList=" + this.f41770a + ", channelList=" + this.f41771b + ", friendListMap=" + this.f41772c + ")";
        }

        private a(List<HomeChips> list, List<ChatGroupChannelDataModel> list2, Map<String, ? extends FriendBean> map) {
            this.f41770a = list;
            this.f41771b = list2;
            this.f41772c = map;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(List list, List list2, Map map, int i2) {
            this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : list2, (i2 & 4) != 0 ? null : map);
        }
    }

    public static final class n<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final n f41792a = new n();

        n() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.a();
        }
    }

    static final class r<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f41796a;

        r(b bVar) {
            this.f41796a = bVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41796a.k = true;
            com.paytm.utility.q.a();
        }
    }

    public static final class v<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final v f41800a = new v();

        v() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.a();
        }
    }

    public static final class k<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f41789a = new k();

        k() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized ChatHomeListEvent a(a aVar) {
        List<T> c2;
        boolean z;
        Object obj;
        String a2;
        List<HomeChips> list = aVar.f41770a;
        if (list != null) {
            this.o.clear();
            this.o.addAll(list);
        }
        List<ChatGroupChannelDataModel> list2 = aVar.f41771b;
        if (list2 != null) {
            this.f41763c.clear();
            this.f41763c.addAll(list2);
        }
        Map<String, FriendBean> map = aVar.f41772c;
        if (map != null) {
            this.p.putAll(map);
        }
        String str = this.f41768h;
        if (str == null || (a2 = f.a(str)) == null) {
            List<ChatGroupChannelDataModel> list3 = this.f41763c;
            Collection arrayList = new ArrayList();
            Iterator it2 = this.o.iterator();
            while (true) {
                HomeChips homeChips = null;
                int i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                HomeChips homeChips2 = (HomeChips) it2.next();
                boolean z2 = false;
                for (ChatGroupChannelDataModel chatGroupChannelDataModel : list3) {
                    if (kotlin.a.k.a(homeChips2.getFilter(), chatGroupChannelDataModel.getCustomType())) {
                        i2++;
                        if (chatGroupChannelDataModel.getUnreadMessageCount() > 0) {
                            z2 = true;
                        }
                    }
                }
                if (i2 != 0 || !kotlin.m.p.a(StringSet.filter, homeChips2.getAction(), true)) {
                    homeChips = new HomeChips(homeChips2.getImage_url(), homeChips2.getName(), homeChips2.getFilter(), homeChips2.getAction(), homeChips2.getUrl(), z2);
                }
                if (homeChips != null) {
                    arrayList.add(homeChips);
                }
            }
            List list4 = (List) arrayList;
            List<ChatGroupChannelDataModel> a3 = a(this.f41763c);
            int i3 = 0;
            for (ChatGroupChannelDataModel unreadMessageCount : a3) {
                i3 += unreadMessageCount.getUnreadMessageCount();
            }
            this.r = i3;
            List arrayList2 = new ArrayList();
            if ((!a3.isEmpty()) && (!list4.isEmpty())) {
                arrayList2.add(new ChatHomeChip(list4));
            }
            if (!a3.isEmpty()) {
                arrayList2.addAll(a3);
            }
            if (a3.isEmpty()) {
                c2 = kotlin.a.k.c(this.p.values());
            } else {
                Map<String, FriendBean> map2 = this.p;
                Map linkedHashMap = new LinkedHashMap();
                for (Map.Entry next : map2.entrySet()) {
                    FriendBean friendBean = (FriendBean) next.getValue();
                    Iterator<ChatGroupChannelDataModel> it3 = this.f41763c.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        }
                        ChatGroupChannelDataModel next2 = it3.next();
                        if (next2.getMemberCount() == 2) {
                            Iterator it4 = next2.getMembers().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it4.next();
                                if (kotlin.m.p.a(((ChatUserDataModel) obj).getSendbirdUserId(), friendBean.getSendbirdId(), false)) {
                                    break;
                                }
                            }
                            if (obj != null) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (!z) {
                        linkedHashMap.put(next.getKey(), next.getValue());
                    }
                }
                c2 = kotlin.a.k.c(linkedHashMap.values());
            }
            List<T> list5 = c2;
            if (!list5.isEmpty()) {
                arrayList2.add(new ChatFriendsHeader());
                arrayList2.addAll(list5);
            }
            h.b b2 = androidx.recyclerview.widget.h.b(new ChatHomeDiffUtil(this.q, arrayList2));
            kotlin.g.b.k.a((Object) b2, "DiffUtil.calculateDiff(C…alList, finalList), true)");
            this.q.clear();
            this.q.addAll(arrayList2);
            return new ChatHomeListEvent.ChatHomeNormalList(arrayList2, b2, this.r, list5, a3.size());
        }
        return c(a2);
    }

    public static final /* synthetic */ Map a(b bVar, ResponseOfFriends responseOfFriends) {
        List<ResponseOfFriends.Friend> list;
        String str;
        b bVar2 = bVar;
        ResponseOfFriends responseOfFriends2 = responseOfFriends;
        FriendsCache friendsCache = (FriendsCache) bVar2.f41761a.a(SharedPreferencesUtil.getString(SharedPreferencesUtil.Key.friends_cache, ""), FriendsCache.class);
        if (friendsCache == null) {
            friendsCache = new FriendsCache(new HashMap());
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map linkedHashMap = new LinkedHashMap();
        ResponseOfFriends.DataOfFriends dataOfFriends = responseOfFriends2.data;
        if (!(dataOfFriends == null || (list = dataOfFriends.friends) == null)) {
            for (ResponseOfFriends.Friend friend : list) {
                kotlin.g.b.k.a((Object) friend, "friend");
                friendsCache.putIfNotExist(friend.getSendbirdId(), Long.valueOf(currentTimeMillis));
                SendContactBean sendContactBean = bVar2.f41765e.get(friend.getPersonalDiscoveryKey());
                if (sendContactBean != null) {
                    CharSequence charSequence = friend.photo;
                    if (charSequence == null || kotlin.m.p.a(charSequence)) {
                        str = sendContactBean.getContactPic();
                    } else {
                        str = friend.photo;
                    }
                    String str2 = str;
                    String sendbirdId = friend.getSendbirdId();
                    kotlin.g.b.k.a((Object) sendbirdId, "friend.sendbirdId");
                    long c2 = currentTimeMillis - e.a().c();
                    Long l2 = friendsCache.getHashMap().get(friend.getSendbirdId());
                    if (l2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) l2, "friendsCache.hashMap[friend.sendbirdId]!!");
                    boolean z = c2 < l2.longValue();
                    String paytmUserId = friend.getPaytmUserId();
                    FriendBean friendBean = r13;
                    FriendBean friendBean2 = new FriendBean(z, paytmUserId, friend.getSendbirdId(), responseOfFriends2.data.preview_text.get(friend.getPreviewTextId()), sendContactBean.getContactName(), str2, sendContactBean.getContactPhone());
                    linkedHashMap.put(sendbirdId, friendBean);
                }
            }
        }
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.friends_cache, bVar2.f41761a.b(friendsCache));
        return linkedHashMap;
    }
}
