package com.paytm.android.chat.h;

import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.jsonbean.BlockUserJsonBean;
import com.paytm.android.chat.bean.jsonbean.DelBlockedUserJsonBean;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.g.b;
import com.paytm.android.chat.network.requests.BlockUserRequest;
import com.paytm.android.chat.network.requests.DelBlockedUserRequest;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.sendbird.android.Member;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.o;

public final class c extends com.paytm.android.chat.base.f<com.paytm.android.chat.g.b> {

    /* renamed from: a  reason: collision with root package name */
    public final io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.b> f42260a = io.reactivex.rxjava3.j.a.a();

    /* renamed from: b  reason: collision with root package name */
    public String f42261b;

    /* renamed from: c  reason: collision with root package name */
    public ChatGroupChannelDataModel f42262c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42263d;

    /* renamed from: e  reason: collision with root package name */
    public final ChatRepository f42264e;

    public static final class a<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f42265a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f42266b;

        public a(c cVar, String str) {
            this.f42265a = cVar;
            this.f42266b = str;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            c cVar = this.f42265a;
            k.a((Object) chatGroupChannelDataModel, "channel");
            return cVar.a(chatGroupChannelDataModel) ? this.f42265a.f42264e.getLocalChannelById(this.f42266b).a() : chatGroupChannelDataModel;
        }
    }

    public static final class b<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f42267a = new b();

        b() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata;
            Object obj2;
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            Iterator it2 = chatGroupChannelDataModel.getMembers().iterator();
            while (true) {
                chatPaymentMetadata = null;
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (!((ChatUserDataModel) obj2).isMe()) {
                    break;
                }
            }
            ChatUserDataModel chatUserDataModel = (ChatUserDataModel) obj2;
            if (chatUserDataModel != null) {
                chatPaymentMetadata = chatUserDataModel.getChatPaymentMetadata();
            }
            return new o(chatGroupChannelDataModel, chatPaymentMetadata);
        }
    }

    /* renamed from: com.paytm.android.chat.h.c$c  reason: collision with other inner class name */
    public static final class C0703c<T> implements io.reactivex.rxjava3.d.g<o<? extends ChatGroupChannelDataModel, ? extends ChatUserEntity.ChatPaymentMetadata>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f42268a;

        public C0703c(c cVar) {
            this.f42268a = cVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            o oVar = (o) obj;
            c.a(this.f42268a, (ChatGroupChannelDataModel) oVar.getFirst());
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.b> aVar = this.f42268a.f42260a;
            Object first = oVar.getFirst();
            k.a(first, "it.first");
            aVar.onNext(new b.g((ChatGroupChannelDataModel) first, (ChatUserEntity.ChatPaymentMetadata) oVar.getSecond()));
        }
    }

    public c(ChatRepository chatRepository) {
        k.c(chatRepository, "repository");
        this.f42264e = chatRepository;
    }

    public final io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.b> a() {
        return this.f42260a;
    }

    public static final class g implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f42274a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f42275b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f42276c;

        public g(boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel, c cVar) {
            this.f42274a = z;
            this.f42275b = chatGroupChannelDataModel;
            this.f42276c = cVar;
        }

        public final void run() {
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42276c.f42262c;
            if (chatGroupChannelDataModel != null) {
                chatGroupChannelDataModel.setPushEnabled(this.f42274a);
            }
            this.f42276c.f42260a.onNext(new b.a(401));
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.b> aVar = this.f42276c.f42260a;
            boolean z = this.f42274a;
            ChatGroupChannelDataModel chatGroupChannelDataModel2 = this.f42275b;
            aVar.onNext(new b.f(z, chatGroupChannelDataModel2, chatGroupChannelDataModel2.getReceiverDisplayInfo().getName()));
        }
    }

    public final void b() {
        ReceiverDisplayInfo receiverDisplayInfo;
        Member receiver;
        ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42262c;
        if (chatGroupChannelDataModel != null && (receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo()) != null && (receiver = receiverDisplayInfo.getReceiver()) != null) {
            if (this.f42263d) {
                DelBlockedUserJsonBean delBlockedUserJsonBean = new DelBlockedUserJsonBean();
                delBlockedUserJsonBean.setBlockUserId(receiver.getUserId());
                delBlockedUserJsonBean.setUserId(SharedPreferencesUtil.getUserId());
                new DelBlockedUserRequest(delBlockedUserJsonBean, new e(receiverDisplayInfo, this));
                return;
            }
            BlockUserJsonBean blockUserJsonBean = new BlockUserJsonBean();
            blockUserJsonBean.setBlockUserId(receiver.getUserId());
            blockUserJsonBean.setUserId(SharedPreferencesUtil.getUserId());
            new BlockUserRequest(blockUserJsonBean, new f(receiverDisplayInfo, this));
        }
    }

    public static final class e extends c.a.a.a<String> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReceiverDisplayInfo f42270c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f42271d;

        e(ReceiverDisplayInfo receiverDisplayInfo, c cVar) {
            this.f42270c = receiverDisplayInfo;
            this.f42271d = cVar;
        }

        public final void a(int i2, String str) {
            this.f42271d.f42260a.onNext(new b.i(this.f42270c.getName()));
            if (i2 == 410 || i2 == 401 || i2 == 403) {
                this.f42271d.f42260a.onNext(new b.h(i2));
            }
        }

        public final /* synthetic */ void a(Object obj) {
            this.f42271d.f42263d = false;
            this.f42271d.f42260a.onNext(new b.j(this.f42270c.getName()));
        }
    }

    public static final class f extends c.a.a.a<String> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReceiverDisplayInfo f42272c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f42273d;

        f(ReceiverDisplayInfo receiverDisplayInfo, c cVar) {
            this.f42272c = receiverDisplayInfo;
            this.f42273d = cVar;
        }

        public final void a(int i2, String str) {
            this.f42273d.f42260a.onNext(new b.C0698b(this.f42272c.getName()));
            if (i2 == 410 || i2 == 401 || i2 == 403) {
                this.f42273d.f42260a.onNext(new b.h(i2));
            }
        }

        public final /* synthetic */ void a(Object obj) {
            this.f42273d.f42263d = true;
            this.f42273d.f42260a.onNext(new b.a(403));
            this.f42273d.f42260a.onNext(new b.c(this.f42272c.getName()));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        r6 = r6.getMetaData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.getMembers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            r4 = r1
            com.paytm.android.chat.data.models.users.ChatUserDataModel r4 = (com.paytm.android.chat.data.models.users.ChatUserDataModel) r4
            boolean r4 = r4.isMe()
            r4 = r4 ^ r2
            if (r4 == 0) goto L_0x000a
            goto L_0x0022
        L_0x0021:
            r1 = r3
        L_0x0022:
            com.paytm.android.chat.data.models.users.ChatUserDataModel r1 = (com.paytm.android.chat.data.models.users.ChatUserDataModel) r1
            if (r1 == 0) goto L_0x0086
            if (r6 == 0) goto L_0x0033
            com.paytm.android.chat.bean.ChannelMetaData r6 = r6.getMetaData()
            if (r6 == 0) goto L_0x0033
            com.paytm.android.chat.bean.ChatType r6 = r6.getChatType()
            goto L_0x0034
        L_0x0033:
            r6 = r3
        L_0x0034:
            if (r6 != 0) goto L_0x0037
            goto L_0x0086
        L_0x0037:
            int[] r0 = com.paytm.android.chat.h.d.f42280a
            int r6 = r6.ordinal()
            r6 = r0[r6]
            if (r6 == r2) goto L_0x0048
            r0 = 2
            if (r6 == r0) goto L_0x0048
            r0 = 3
            if (r6 == r0) goto L_0x0048
            goto L_0x0086
        L_0x0048:
            net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r3 = r1.constructChatPayeeUser()     // Catch:{ Exception -> 0x004d }
            goto L_0x004e
        L_0x004d:
        L_0x004e:
            java.lang.String r6 = r1.getSendbirdUserId()
            if (r3 != 0) goto L_0x0086
            if (r6 == 0) goto L_0x0086
            com.paytm.a r0 = com.paytm.a.f40823c
            java.util.List r0 = kotlin.a.k.a(r6)
            com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse r0 = com.paytm.a.a((java.util.List<java.lang.String>) r0)
            if (r0 == 0) goto L_0x0086
            com.paytm.android.chat.data.models.users.payments.UserInfoByIdsData r0 = r0.getData()
            if (r0 == 0) goto L_0x0086
            java.util.Map r0 = r0.getMap()
            if (r0 == 0) goto L_0x0086
            java.lang.Object r0 = r0.get(r6)
            com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean r0 = (com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean) r0
            if (r0 == 0) goto L_0x0086
            com.paytm.android.chat.data.repository.ChatRepository r1 = r5.f42264e
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity r6 = r1.constructChatUserEntity(r6, r0)
            com.paytm.android.chat.data.repository.ChatRepository r0 = r5.f42264e
            java.util.List r6 = kotlin.a.k.a(r6)
            r0.updateUsersThroughEntity(r6)
            goto L_0x0087
        L_0x0086:
            r2 = 0
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.h.c.a(com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel):boolean");
    }

    public static final /* synthetic */ void a(c cVar, ChatGroupChannelDataModel chatGroupChannelDataModel) {
        ReceiverDisplayInfo receiverDisplayInfo;
        Member receiver;
        cVar.f42262c = chatGroupChannelDataModel;
        if (chatGroupChannelDataModel != null && (receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo()) != null && (receiver = receiverDisplayInfo.getReceiver()) != null) {
            cVar.f42263d = receiver.isBlockedByMe();
        }
    }

    public static final class h<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f42277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f42278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f42279c;

        public h(boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel, c cVar) {
            this.f42277a = z;
            this.f42278b = chatGroupChannelDataModel;
            this.f42279c = cVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.b> aVar = this.f42279c.f42260a;
            boolean z = this.f42277a;
            ChatGroupChannelDataModel chatGroupChannelDataModel = this.f42278b;
            aVar.onNext(new b.e(z, chatGroupChannelDataModel, chatGroupChannelDataModel.getReceiverDisplayInfo().getName()));
        }
    }

    public static final class d<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f42269a;

        public d(c cVar) {
            this.f42269a = cVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42269a.f42260a.onNext(new b.d((byte) 0));
        }
    }
}
