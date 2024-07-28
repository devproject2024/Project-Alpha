package com.paytm.android.chat.data.db.room.helper;

import android.app.Application;
import com.paytm.android.chat.data.db.room.DBManager;
import com.paytm.android.chat.data.db.room.dao.ChatMessageDao;
import com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.utils.CPCMessagePreviewUtilsKt;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.ChatMessageState;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Sender;
import com.sendbird.android.UserMessage;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import io.reactivex.rxjava3.a.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final class MessageDBHelperKt {
    private static final String TAG = "MessageDBHelper";

    static final class b<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f41952a = new b();

        b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class e<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f41955a = new e();

        e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class h<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final h f41958a = new h();

        h() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class k<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f41961a = new k();

        k() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class m implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final m f41963a = new m();

        m() {
        }

        public final void run() {
        }
    }

    static final class q<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final q f41968a = new q();

        q() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class t<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final t f41972a = new t();

        t() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class w<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final w f41976a = new w();

        w() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public static final kotlin.x insertOrUpdateMessage(BaseChannel baseChannel, BaseMessage baseMessage) {
        if (baseChannel == null || baseMessage == null) {
            return null;
        }
        insertOrUpdateMessage(baseChannel, (List<? extends BaseMessage>) kotlin.a.k.a(baseMessage));
        return kotlin.x.f47997a;
    }

    public static final ChatMessageEntity getChatMessageEntity(BaseChannel baseChannel, BaseMessage baseMessage) {
        String str;
        String str2;
        kotlin.g.b.k.c(baseChannel, "channel");
        kotlin.g.b.k.c(baseMessage, "message");
        ChatMessageEntity chatMessageEntity = new ChatMessageEntity();
        chatMessageEntity.setMessageId(baseMessage.getMessageId());
        String requestId = baseMessage.getRequestId();
        kotlin.g.b.k.a((Object) requestId, "message.requestId");
        chatMessageEntity.setRequestId(requestId);
        String channelUrl = baseMessage.getChannelUrl();
        kotlin.g.b.k.a((Object) channelUrl, "message.channelUrl");
        chatMessageEntity.setChannelUrl(channelUrl);
        Sender sender = baseMessage.getSender();
        if (sender == null || (str = sender.getUserId()) == null) {
            str = "";
        }
        chatMessageEntity.setSenderId(str);
        Sender sender2 = baseMessage.getSender();
        if (sender2 == null || (str2 = sender2.getNickname()) == null) {
            str2 = "";
        }
        chatMessageEntity.setSenderName(str2);
        chatMessageEntity.setMessageCustomType(baseMessage.getCustomType());
        chatMessageEntity.setCreatedAt(Long.valueOf(baseMessage.getCreatedAt()));
        chatMessageEntity.setUpdatedAt(Long.valueOf(baseMessage.getUpdatedAt()));
        ChatMessageState.Companion companion = ChatMessageState.Companion;
        byte[] bArr = null;
        if (!(baseChannel instanceof GroupChannel)) {
            baseChannel = null;
        }
        chatMessageEntity.setMessageState(companion.getMessageState((GroupChannel) baseChannel, baseMessage).getValue());
        chatMessageEntity.setRawMessage(baseMessage.serialize());
        chatMessageEntity.setMessageContent(baseMessage.getMessage());
        chatMessageEntity.setOperatorMessage(baseMessage.isOperatorMessage());
        chatMessageEntity.setCustomType(baseMessage.getCustomType());
        chatMessageEntity.setData(baseMessage.getData());
        chatMessageEntity.setErrorCode(baseMessage.getErrorCode());
        chatMessageEntity.setSilent(baseMessage.isSilent());
        chatMessageEntity.setMentionType(baseMessage.getMentionType().name());
        Sender sender3 = baseMessage.getSender();
        if (sender3 != null) {
            bArr = sender3.serialize();
        }
        chatMessageEntity.setSender(bArr);
        chatMessageEntity.setParentMessageId(Long.valueOf(baseMessage.getParentMessageId()));
        chatMessageEntity.setParentMessageText(baseMessage.getParentMessageText());
        chatMessageEntity.setMessagePreview(CPCMessagePreviewUtilsKt.getMessagePreview(baseMessage));
        if (baseMessage instanceof UserMessage) {
            chatMessageEntity.setMessageType(StringSet.user);
        }
        if (baseMessage instanceof AdminMessage) {
            chatMessageEntity.setMessageType("admin");
        }
        if (baseMessage instanceof FileMessage) {
            chatMessageEntity.setMessageType(CommunityPostActivity.TYPE_FILE);
            FileMessage fileMessage = (FileMessage) baseMessage;
            chatMessageEntity.setFileName(fileMessage.getName());
            chatMessageEntity.setFileUrl(fileMessage.getUrl());
        }
        return chatMessageEntity;
    }

    public static final List<ChatMessageEntity> getNonAdminMessagesForChannelByUrl(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        return DBManager.INSTANCE.getDb().chatMessageDao().getNonAdminMessagesByChannelUrl(str);
    }

    public static final List<ChatMessageEntity> getPreviewTextNotEmptyMessagesByChannelUrl(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        return DBManager.INSTANCE.getDb().chatMessageDao().getPreviewTextNotEmptyMessagesByChannelUrl(str);
    }

    public static final void insertOrUpdateMessage(BaseChannel baseChannel, List<? extends BaseMessage> list) {
        kotlin.g.b.k.c(baseChannel, "channel");
        kotlin.g.b.k.c(list, "list");
        if (!list.isEmpty()) {
            y.a(new p(list, baseChannel)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(q.f41968a, (io.reactivex.rxjava3.d.g<? super Throwable>) r.f41969a);
        }
    }

    public static final void markReadEngageEventSent(long j2, boolean z) {
        y.a(new s(j2, z)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(t.f41972a, (io.reactivex.rxjava3.d.g<? super Throwable>) u.f41973a);
    }

    public static final io.reactivex.rxjava3.a.h<List<ChatMessageDataModel>> getMessagesByChannel(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        io.reactivex.rxjava3.a.h<R> a2 = DBManager.INSTANCE.getDb().chatMessageDao().getMessageForChannel(str).a(o.f41965a);
        kotlin.g.b.k.a((Object) a2, "DBManager.db.chatMessage…map newList\n            }");
        return a2;
    }

    static final class o<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final o f41965a = new o();

        o() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return a((List) obj);
        }

        private static List<ChatMessageDataModel> a(List<ChatMessageEntity> list) {
            ChatMessageDataModel chatMessageDataModelFromMessageEntity;
            List<ChatMessageDataModel> arrayList = new ArrayList<>();
            kotlin.g.b.k.a((Object) list, "chatMessageEntity");
            Iterator it2 = list.iterator();
            while (true) {
                boolean z = true;
                if (!it2.hasNext()) {
                    break;
                }
                ChatMessageEntity chatMessageEntity = (ChatMessageEntity) it2.next();
                try {
                    if (!(BaseMessage.buildFromSerializedData(chatMessageEntity.getRawMessage()) == null || (chatMessageDataModelFromMessageEntity = MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(chatMessageEntity, false)) == null)) {
                        chatMessageDataModelFromMessageEntity.readEngageEventSent = chatMessageEntity.getReadEngageEventSent();
                        Boolean showAnim = chatMessageEntity.getShowAnim();
                        if (showAnim != null) {
                            z = showAnim.booleanValue();
                        }
                        chatMessageDataModelFromMessageEntity.showAnim = z;
                        arrayList.add(chatMessageDataModelFromMessageEntity);
                    }
                } catch (Exception unused) {
                }
            }
            if (arrayList.size() > 1) {
                kotlin.a.k.a(arrayList, new MessageDBHelperKt$getMessagesByChannel$1$$special$$inlined$sortByDescending$1());
            }
            return arrayList;
        }
    }

    public static final Long getOldestMessageTsForChannel(String str) {
        return DBManager.INSTANCE.getDb().chatMessageDao().getOldestMessageTsForChannel(str);
    }

    public static final void deleteMessage(BaseMessage baseMessage) {
        kotlin.g.b.k.c(baseMessage, "message");
        y.a(new g(baseMessage)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(h.f41958a, (io.reactivex.rxjava3.d.g<? super Throwable>) i.f41959a);
    }

    public static final void deleteMessage(long j2) {
        y.a(new j(j2)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(k.f41961a, (io.reactivex.rxjava3.d.g<? super Throwable>) l.f41962a);
    }

    public static final void deleteMessagesForChannel(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        DBManager.INSTANCE.getDb().chatMessageDao().deleteMessageForChannel(str).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(m.f41963a, n.f41964a);
    }

    public static final void bulkDeleteMessage(List<Long> list) {
        kotlin.g.b.k.c(list, "messageIds");
        y.a(new a(list)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(b.f41952a, (io.reactivex.rxjava3.d.g<? super Throwable>) c.f41953a);
    }

    public static final void deleteAllMessage() {
        y.a(d.f41954a).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(e.f41955a, (io.reactivex.rxjava3.d.g<? super Throwable>) f.f41956a);
    }

    public static final void updateAnimationState(long j2, boolean z) {
        y.a(new v(j2, z)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(w.f41976a, (io.reactivex.rxjava3.d.g<? super Throwable>) x.f41977a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x018a, code lost:
        if ((!kotlin.g.b.k.a((java.lang.Object) r11 != null ? r11.getUserId() : null, (java.lang.Object) com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId())) != false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d1, code lost:
        if ((!kotlin.g.b.k.a((java.lang.Object) r11 != null ? r11.getUserId() : null, (java.lang.Object) com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId())) != false) goto L_0x01d3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.paytm.android.chat.data.models.messages.ChatMessageDataModel getChatMessageDataModelFromMessageEntity(com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r10, boolean r11) throws java.lang.Exception {
        /*
            java.lang.String r0 = "chatMessageEntity"
            kotlin.g.b.k.c(r10, r0)
            byte[] r0 = r10.getRawMessage()
            com.sendbird.android.BaseMessage r0 = com.sendbird.android.BaseMessage.buildFromSerializedData(r0)
            java.lang.String r1 = r10.getCustomType()
            java.lang.String r10 = r10.getData()
            boolean r2 = r0 instanceof com.sendbird.android.UserMessage
            java.lang.String r3 = "message.sender"
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L_0x0275
            java.lang.String r2 = "UPI_REQUEST"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            r6 = 1
            if (r2 == 0) goto L_0x0041
            com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel r11 = new com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel
            r11.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r11
            r2 = r11
            com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel r2 = (com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel) r2
            com.google.gsonhtcfix.f r6 = com.paytm.android.chat.utils.AppUtilKt.getGson()
            java.lang.Class<com.paytm.android.chat.data.models.messages.ChatMessageUPIData> r7 = com.paytm.android.chat.data.models.messages.ChatMessageUPIData.class
            java.lang.Object r6 = r6.a((java.lang.String) r10, r7)
            com.paytm.android.chat.data.models.messages.ChatMessageUPIData r6 = (com.paytm.android.chat.data.models.messages.ChatMessageUPIData) r6
            r2.setData(r6)
            goto L_0x021b
        L_0x0041:
            java.lang.String r2 = "UPI_RESPONSE"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x0064
            com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel r11 = new com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel
            r11.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r11
            r2 = r11
            com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel) r2
            com.google.gsonhtcfix.f r6 = com.paytm.android.chat.utils.AppUtilKt.getGson()
            java.lang.Class<com.paytm.android.chat.data.models.messages.ChatMessageUPIData> r7 = com.paytm.android.chat.data.models.messages.ChatMessageUPIData.class
            java.lang.Object r6 = r6.a((java.lang.String) r10, r7)
            com.paytm.android.chat.data.models.messages.ChatMessageUPIData r6 = (com.paytm.android.chat.data.models.messages.ChatMessageUPIData) r6
            r2.setData(r6)
            goto L_0x021b
        L_0x0064:
            java.lang.String r2 = "GENERIC_NOTIF"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x0090
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r11 = new com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel
            r11.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r11
            r2 = r10
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x021b
            r2 = r11
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel) r2
            com.google.gsonhtcfix.f r6 = com.paytm.android.chat.utils.AppUtilKt.getGson()
            java.lang.Class<com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean> r7 = com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean.class
            java.lang.Object r6 = r6.a((java.lang.String) r10, r7)
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel$GenericDataBean r6 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel.GenericDataBean) r6
            r2.setData(r6)
            goto L_0x021b
        L_0x0090:
            java.lang.String r2 = "MINI_APP_BASIC_NOTIFICATION"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x00bc
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r11 = new com.paytm.android.chat.data.models.messages.MiniAppNotificationBean
            r11.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r11
            r2 = r10
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x021b
            r2 = r11
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r2 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationBean) r2
            com.google.gsonhtcfix.f r6 = com.paytm.android.chat.utils.AppUtilKt.getGson()
            java.lang.Class<com.paytm.android.chat.data.models.messages.MiniAppNotificationData> r7 = com.paytm.android.chat.data.models.messages.MiniAppNotificationData.class
            java.lang.Object r6 = r6.a((java.lang.String) r10, r7)
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r6 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationData) r6
            r2.setNotifData(r6)
            goto L_0x021b
        L_0x00bc:
            java.lang.String r2 = "contact"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x0105
            com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel r11 = new com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel
            r11.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r11
            r2 = r10
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x021b
            com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt$getChatMessageDataModelFromMessageEntity$listType$1 r2 = new com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt$getChatMessageDataModelFromMessageEntity$listType$1
            r2.<init>()
            java.lang.reflect.Type r2 = r2.getType()
            com.google.gsonhtcfix.f r6 = com.paytm.android.chat.utils.AppUtilKt.getGson()
            java.lang.Object r2 = r6.a((java.lang.String) r10, (java.lang.reflect.Type) r2)
            java.lang.String r6 = "gson.fromJson(data, listType)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00fe
            int r6 = r2.size()
            if (r6 <= 0) goto L_0x00fe
            java.lang.Object r6 = r2.get(r4)
            com.paytm.android.chat.bean.SelectContactsBean r6 = (com.paytm.android.chat.bean.SelectContactsBean) r6
            boolean r6 = r6.isForward
            r11.isForward = r6
        L_0x00fe:
            r6 = r11
            com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel) r6
            r6.sendContactBeans = r2
            goto L_0x021b
        L_0x0105:
            java.lang.String r2 = "TRANSFER"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x018e
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r2 = new com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel     // Catch:{ Exception -> 0x018d }
            r2.<init>()     // Catch:{ Exception -> 0x018d }
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r2     // Catch:{ Exception -> 0x018d }
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x018d }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x018d }
            if (r7 != 0) goto L_0x021a
            r7 = r2
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r7 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r7     // Catch:{ Exception -> 0x018d }
            com.google.gsonhtcfix.f r8 = com.paytm.android.chat.utils.AppUtilKt.getGson()     // Catch:{ Exception -> 0x018d }
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r9 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r8 = r8.a((java.lang.String) r10, r9)     // Catch:{ Exception -> 0x018d }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r8 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r8     // Catch:{ Exception -> 0x018d }
            r7.bean = r8     // Catch:{ Exception -> 0x018d }
            r7 = r2
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r7 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r7     // Catch:{ Exception -> 0x018d }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r7 = r7.bean     // Catch:{ Exception -> 0x018d }
            if (r7 == 0) goto L_0x021a
            java.lang.String r7 = "messageDataModel.bean"
            if (r11 != 0) goto L_0x0162
            r8 = r0
            com.sendbird.android.UserMessage r8 = (com.sendbird.android.UserMessage) r8     // Catch:{ Exception -> 0x018d }
            com.sendbird.android.Sender r8 = r8.getSender()     // Catch:{ Exception -> 0x018d }
            if (r8 == 0) goto L_0x0147
            java.lang.String r8 = r8.getUserId()     // Catch:{ Exception -> 0x018d }
            goto L_0x0148
        L_0x0147:
            r8 = r5
        L_0x0148:
            java.lang.String r9 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x018d }
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x018d }
            r8 = r8 ^ r6
            if (r8 == 0) goto L_0x0162
            r8 = r2
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r8 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r8     // Catch:{ Exception -> 0x018d }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r8 = r8.bean     // Catch:{ Exception -> 0x018d }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)     // Catch:{ Exception -> 0x018d }
            int r8 = r8.getStatus()     // Catch:{ Exception -> 0x018d }
            if (r8 == 0) goto L_0x0162
            return r5
        L_0x0162:
            r8 = r2
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r8 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r8     // Catch:{ Exception -> 0x018d }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r8 = r8.bean     // Catch:{ Exception -> 0x018d }
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)     // Catch:{ Exception -> 0x018d }
            int r7 = r8.getStatus()     // Catch:{ Exception -> 0x018d }
            if (r7 != r6) goto L_0x021a
            if (r11 != 0) goto L_0x021a
            r11 = r0
            com.sendbird.android.UserMessage r11 = (com.sendbird.android.UserMessage) r11     // Catch:{ Exception -> 0x018d }
            com.sendbird.android.Sender r11 = r11.getSender()     // Catch:{ Exception -> 0x018d }
            if (r11 == 0) goto L_0x0180
            java.lang.String r11 = r11.getUserId()     // Catch:{ Exception -> 0x018d }
            goto L_0x0181
        L_0x0180:
            r11 = r5
        L_0x0181:
            java.lang.String r7 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x018d }
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r7)     // Catch:{ Exception -> 0x018d }
            r11 = r11 ^ r6
            if (r11 == 0) goto L_0x021a
            goto L_0x01d3
        L_0x018d:
            return r5
        L_0x018e:
            java.lang.String r2 = "TRANSFER_FAIL"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x01d7
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r2 = new com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel     // Catch:{ Exception -> 0x01d6 }
            r2.<init>()     // Catch:{ Exception -> 0x01d6 }
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r2     // Catch:{ Exception -> 0x01d6 }
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x01d6 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d6 }
            if (r7 != 0) goto L_0x01b7
            r7 = r2
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r7 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r7     // Catch:{ Exception -> 0x01d6 }
            com.google.gsonhtcfix.f r8 = com.paytm.android.chat.utils.AppUtilKt.getGson()     // Catch:{ Exception -> 0x01d6 }
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r9 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r8 = r8.a((java.lang.String) r10, r9)     // Catch:{ Exception -> 0x01d6 }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r8 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r8     // Catch:{ Exception -> 0x01d6 }
            r7.bean = r8     // Catch:{ Exception -> 0x01d6 }
        L_0x01b7:
            if (r11 != 0) goto L_0x021a
            r11 = r0
            com.sendbird.android.UserMessage r11 = (com.sendbird.android.UserMessage) r11     // Catch:{ Exception -> 0x01d6 }
            com.sendbird.android.Sender r11 = r11.getSender()     // Catch:{ Exception -> 0x01d6 }
            if (r11 == 0) goto L_0x01c7
            java.lang.String r11 = r11.getUserId()     // Catch:{ Exception -> 0x01d6 }
            goto L_0x01c8
        L_0x01c7:
            r11 = r5
        L_0x01c8:
            java.lang.String r7 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x01d6 }
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r7)     // Catch:{ Exception -> 0x01d6 }
            r11 = r11 ^ r6
            if (r11 == 0) goto L_0x021a
        L_0x01d3:
            r11 = r2
            r4 = 1
            goto L_0x021b
        L_0x01d6:
            return r5
        L_0x01d7:
            com.google.gsonhtcfix.f r11 = new com.google.gsonhtcfix.f
            r11.<init>()
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.UserDataBean> r2 = com.paytm.android.chat.bean.jsonbean.UserDataBean.class
            java.lang.Object r11 = r11.a((java.lang.String) r10, r2)
            com.paytm.android.chat.bean.jsonbean.UserDataBean r11 = (com.paytm.android.chat.bean.jsonbean.UserDataBean) r11
            com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel r2 = new com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel
            r2.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r2
            if (r11 == 0) goto L_0x021a
            r6 = r2
            com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel) r6
            java.lang.String r7 = r11.getContent()
            r6.replyContent = r7
            java.lang.String r7 = r11.getUrl()
            r6.replyUrl = r7
            java.lang.String r7 = r11.getTitle()
            r6.replyName = r7
            long r7 = r11.getMessageId()
            r6.replyMessageId = r7
            int r7 = r11.getType()
            r6.replyType = r7
            java.lang.String r7 = r11.getUserId()
            r6.replyUserId = r7
            boolean r11 = r11.isForward()
            r2.isForward = r11
        L_0x021a:
            r11 = r2
        L_0x021b:
            java.lang.String r2 = "user"
            r11.messageType = r2
            r2 = r0
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2
            com.sendbird.android.Sender r6 = r2.getSender()
            if (r6 == 0) goto L_0x0237
            com.sendbird.android.Sender r6 = r2.getSender()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            java.lang.String r3 = r6.getUserId()
            r11.sendId = r3
            goto L_0x023d
        L_0x0237:
            java.lang.String r3 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            r11.sendId = r3
        L_0x023d:
            java.lang.String r3 = r2.getMessage()
            r11.message = r3
            java.lang.String r3 = r2.getRequestId()
            r11.requestId = r3
            com.sendbird.android.BaseMessage$SendingStatus r2 = r2.getSendingStatus()
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.FAILED
            if (r2 != r3) goto L_0x0257
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            r11.state = r2
            goto L_0x037f
        L_0x0257:
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.SUCCEEDED
            if (r2 != r3) goto L_0x0261
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.SUCCEEDED
            r11.state = r2
            goto L_0x037f
        L_0x0261:
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.PENDING
            if (r2 != r3) goto L_0x026b
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.PENDING
            r11.state = r2
            goto L_0x037f
        L_0x026b:
            com.sendbird.android.BaseMessage$SendingStatus r3 = com.sendbird.android.BaseMessage.SendingStatus.NONE
            if (r2 != r3) goto L_0x037f
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r2 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.NONE
            r11.state = r2
            goto L_0x037f
        L_0x0275:
            boolean r2 = r0 instanceof com.sendbird.android.FileMessage
            if (r2 == 0) goto L_0x035a
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x028f
            com.google.gsonhtcfix.f r11 = com.paytm.android.chat.utils.AppUtilKt.getGson()
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.FileDataBean> r2 = com.paytm.android.chat.bean.jsonbean.FileDataBean.class
            java.lang.Object r11 = r11.a((java.lang.String) r10, r2)
            com.paytm.android.chat.bean.jsonbean.FileDataBean r11 = (com.paytm.android.chat.bean.jsonbean.FileDataBean) r11
            goto L_0x0290
        L_0x028f:
            r11 = r5
        L_0x0290:
            java.lang.String r2 = "Audio"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x02a0
            com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel r2 = new com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel
            r2.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r2
            goto L_0x02f2
        L_0x02a0:
            java.lang.String r2 = "Image"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x02df
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r2 = new com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel
            r2.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r2
            if (r11 == 0) goto L_0x02bc
            r6 = r2
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel) r6
            java.lang.String r7 = r11.message
            r6.messageData = r7
            java.lang.String r7 = r11.path
            r6.filePath = r7
        L_0x02bc:
            r6 = r0
            com.sendbird.android.FileMessage r6 = (com.sendbird.android.FileMessage) r6
            java.util.List r6 = r6.getThumbnails()
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x02f2
            r7 = r2
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r7 = (com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel) r7
            java.lang.Object r6 = r6.get(r4)
            java.lang.String r8 = "thumbnails[0]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            com.sendbird.android.FileMessage$Thumbnail r6 = (com.sendbird.android.FileMessage.Thumbnail) r6
            java.lang.String r6 = r6.getUrl()
            r7.thumbnail = r6
            goto L_0x02f2
        L_0x02df:
            com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel r2 = new com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel
            r2.<init>()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r2 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r2
            r6 = r2
            com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel r6 = (com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel) r6
            r7 = r0
            com.sendbird.android.FileMessage r7 = (com.sendbird.android.FileMessage) r7
            int r7 = r7.getSize()
            r6.fileSize = r7
        L_0x02f2:
            if (r11 == 0) goto L_0x02f8
            boolean r11 = r11.isForward
            r2.isForward = r11
        L_0x02f8:
            r11 = r0
            com.sendbird.android.FileMessage r11 = (com.sendbird.android.FileMessage) r11
            java.lang.String r6 = r11.getRequestId()
            r2.requestId = r6
            java.lang.String r6 = "file"
            r2.messageType = r6
            java.lang.String r6 = r11.getUrl()
            r2.fileUrl = r6
            java.lang.String r6 = r11.getName()
            r2.fileName = r6
            com.sendbird.android.Sender r6 = r11.getSender()
            if (r6 == 0) goto L_0x0325
            com.sendbird.android.Sender r6 = r11.getSender()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            java.lang.String r3 = r6.getUserId()
            r2.sendId = r3
            goto L_0x032b
        L_0x0325:
            java.lang.String r3 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            r2.sendId = r3
        L_0x032b:
            com.sendbird.android.BaseMessage$SendingStatus r3 = r11.getSendingStatus()
            com.sendbird.android.BaseMessage$SendingStatus r6 = com.sendbird.android.BaseMessage.SendingStatus.FAILED
            if (r3 != r6) goto L_0x0338
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r3 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            r2.state = r3
            goto L_0x0352
        L_0x0338:
            com.sendbird.android.BaseMessage$SendingStatus r6 = com.sendbird.android.BaseMessage.SendingStatus.SUCCEEDED
            if (r3 != r6) goto L_0x0341
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r3 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.SUCCEEDED
            r2.state = r3
            goto L_0x0352
        L_0x0341:
            com.sendbird.android.BaseMessage$SendingStatus r6 = com.sendbird.android.BaseMessage.SendingStatus.PENDING
            if (r3 != r6) goto L_0x034a
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r3 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.PENDING
            r2.state = r3
            goto L_0x0352
        L_0x034a:
            com.sendbird.android.BaseMessage$SendingStatus r6 = com.sendbird.android.BaseMessage.SendingStatus.NONE
            if (r3 != r6) goto L_0x0352
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r3 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.NONE
            r2.state = r3
        L_0x0352:
            java.lang.String r11 = r11.getType()
            r2.fileType = r11
            r11 = r2
            goto L_0x037f
        L_0x035a:
            boolean r2 = r0 instanceof com.sendbird.android.AdminMessage
            if (r2 == 0) goto L_0x037a
            java.lang.String r2 = "admin"
            if (r11 == 0) goto L_0x036e
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean r11 = com.paytm.android.chat.utils.AppUtilKt.getAdminMessage(r0)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r11
            if (r11 != 0) goto L_0x036b
            return r5
        L_0x036b:
            r11.messageType = r2
            goto L_0x037f
        L_0x036e:
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean r11 = com.paytm.android.chat.utils.AppUtilKt.getValidAdminMessage(r0)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r11
            if (r11 != 0) goto L_0x0377
            return r5
        L_0x0377:
            r11.messageType = r2
            goto L_0x037f
        L_0x037a:
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r11 = new com.paytm.android.chat.data.models.messages.ChatMessageDataModel
            r11.<init>()
        L_0x037f:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x038d }
            r2.<init>(r10)     // Catch:{ Exception -> 0x038d }
            java.lang.String r10 = "campaignId"
            java.lang.String r10 = r2.optString(r10)     // Catch:{ Exception -> 0x038d }
            r11.campaignId = r10     // Catch:{ Exception -> 0x038d }
            goto L_0x038e
        L_0x038d:
        L_0x038e:
            r11.baseMessage = r0
            r11.customType = r1
            java.lang.String r10 = "message"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            long r1 = r0.getMessageId()
            r11.messageId = r1
            long r1 = r0.getCreatedAt()
            r11.time = r1
            long r1 = r0.getCreatedAt()
            java.lang.Long r10 = java.lang.Long.valueOf(r1)
            r11.createdAt = r10
            long r0 = r0.getUpdatedAt()
            java.lang.Long r10 = java.lang.Long.valueOf(r0)
            r11.updatedAt = r10
            if (r4 == 0) goto L_0x03ba
            return r5
        L_0x03ba:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity, boolean):com.paytm.android.chat.data.models.messages.ChatMessageDataModel");
    }

    static final class p<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f41966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseChannel f41967b;

        p(List list, BaseChannel baseChannel) {
            this.f41966a = list;
            this.f41967b = baseChannel;
        }

        public final /* synthetic */ Object call() {
            String data;
            String a2;
            String a3;
            Iterable<BaseMessage> iterable = this.f41966a;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (BaseMessage chatMessageEntity : iterable) {
                arrayList.add(MessageDBHelperKt.getChatMessageEntity(this.f41967b, chatMessageEntity));
            }
            for (ChatMessageEntity rawMessage : DBManager.INSTANCE.getDb().chatMessageDao().insertOrUpdate((List) arrayList).getInsertedList()) {
                BaseMessage buildFromSerializedData = BaseMessage.buildFromSerializedData(rawMessage.getRawMessage());
                if (!(buildFromSerializedData == null || (data = buildFromSerializedData.getData()) == null || (a2 = com.paytm.android.chat.f.a(data)) == null)) {
                    try {
                        String optString = new JSONObject(a2).optString("campaignId");
                        if (!(optString == null || (a3 = com.paytm.android.chat.f.a(optString)) == null)) {
                            Application a4 = com.paytm.android.chat.c.a();
                            kotlin.g.b.k.a((Object) a4, "ChatApplication.getApplication()");
                            ChatAnalyticsHelperKt.fireCampaignMessageReceivedEvent(a4, a3);
                            kotlin.x xVar = kotlin.x.f47997a;
                        }
                    } catch (Exception unused) {
                        kotlin.x xVar2 = kotlin.x.f47997a;
                    }
                }
            }
            return kotlin.x.f47997a;
        }
    }

    static final class r<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final r f41969a = new r();

        r() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("insertOrUpdateMessage");
        }
    }

    static final class s<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f41970a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f41971b;

        s(long j, boolean z) {
            this.f41970a = j;
            this.f41971b = z;
        }

        public final /* synthetic */ Object call() {
            DBManager.INSTANCE.getDb().chatMessageDao().markReadEngageEventSent(this.f41970a, this.f41971b);
            return kotlin.x.f47997a;
        }
    }

    static final class u<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final u f41973a = new u();

        u() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("markReadEngageEventSent");
        }
    }

    static final class g<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseMessage f41957a;

        g(BaseMessage baseMessage) {
            this.f41957a = baseMessage;
        }

        public final /* synthetic */ Object call() {
            ChatMessageDao chatMessageDao = DBManager.INSTANCE.getDb().chatMessageDao();
            long messageId = this.f41957a.getMessageId();
            String requestId = this.f41957a.getRequestId();
            kotlin.g.b.k.a((Object) requestId, "message.requestId");
            chatMessageDao.deleteMessage(messageId, requestId);
            return kotlin.x.f47997a;
        }
    }

    static final class i<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f41959a = new i();

        i() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("deleteMessage using BaseMessage");
        }
    }

    static final class j<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f41960a;

        j(long j) {
            this.f41960a = j;
        }

        public final /* synthetic */ Object call() {
            DBManager.INSTANCE.getDb().chatMessageDao().deleteMessage(this.f41960a);
            return kotlin.x.f47997a;
        }
    }

    static final class l<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final l f41962a = new l();

        l() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("deleteMessage using messageId");
        }
    }

    static final class n<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final n f41964a = new n();

        n() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("deleteMessagesForChannel");
        }
    }

    static final class a<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f41951a;

        a(List list) {
            this.f41951a = list;
        }

        public final /* synthetic */ Object call() {
            DBManager.INSTANCE.getDb().chatMessageDao().bulkDeleteByMessageId(this.f41951a);
            return kotlin.x.f47997a;
        }
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f41953a = new c();

        c() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("bulkDeleteMessage");
        }
    }

    static final class d<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f41954a = new d();

        d() {
        }

        public final /* synthetic */ Object call() {
            DBManager.INSTANCE.getDb().chatMessageDao().deleteAllMessages();
            return kotlin.x.f47997a;
        }
    }

    static final class f<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f41956a = new f();

        f() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("deleteAllMessage");
        }
    }

    static final class v<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f41974a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f41975b;

        v(long j, boolean z) {
            this.f41974a = j;
            this.f41975b = z;
        }

        public final /* synthetic */ Object call() {
            DBManager.INSTANCE.getDb().chatMessageDao().updateAnimationState(this.f41974a, this.f41975b);
            return kotlin.x.f47997a;
        }
    }

    static final class x<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final x f41977a = new x();

        x() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("updateAnimationState");
        }
    }
}
