package com.paytm.android.chat.data.repository.datastores;

import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.bean.HomeFilter;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.data.db.room.DBManager;
import com.paytm.android.chat.data.db.room.dao.ChatChannelDao;
import com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao;
import com.paytm.android.chat.data.db.room.dao.ChatMessageDao;
import com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity;
import com.paytm.android.chat.data.db.room.db_entities.ChatChannelUsersJoinEntity;
import com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.db.room.db_entities.UserInfoSource;
import com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt;
import com.paytm.android.chat.data.db.room.helper.NotificationDBHelperKt;
import com.paytm.android.chat.data.mappers.CPCDataMapperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.providers.CPCDataProviderKt;
import com.paytm.android.chat.utils.CPCMessagePreviewUtilsKt;
import com.paytm.android.chat.utils.ChatVariantUtilKt;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.g.b.x;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType;

public final class ChatLocalChannelDataStore implements ChatChannelDataStore {
    private final String TAG = "ChatLocalDataStore";
    private final io.reactivex.rxjava3.a.h<List<ChatGroupChannelDataModel>> allChannelFlowable = this.chatChannelDao.getAllChannel().a(a.f41981a).a(new b(this)).a(new c(this)).a(d.f41990a);
    private final ChatChannelDao chatChannelDao;
    private final ChatChannelUsersJoinDao chatChannelUsersJoinDao;
    /* access modifiers changed from: private */
    public ChatLocalUsersDataStore chatLocalUsersDataStore;
    /* access modifiers changed from: private */
    public final ChatMessageDao chatMessageDao;
    /* access modifiers changed from: private */
    public final androidx.room.j database;

    static final class ad implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final ad f41986a = new ad();

        ad() {
        }

        public final void run() {
        }
    }

    static final class h implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final h f41994a = new h();

        h() {
        }

        public final void run() {
        }
    }

    static final class u<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final u f42008a = new u();

        u() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class w implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final w f42010a = new w();

        w() {
        }

        public final void run() {
        }
    }

    static final class z<T> implements io.reactivex.rxjava3.d.g<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        public static final z f42014a = new z();

        z() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class a<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f41981a = new a();

        a() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            List<ChatChannelEntity> list = (List) obj;
            kotlin.g.b.k.a((Object) list, "channelEntityList");
            for (ChatChannelEntity rawChannel : list) {
                BaseChannel buildFromSerializedData = BaseChannel.buildFromSerializedData(rawChannel.getRawChannel());
                if (!(buildFromSerializedData instanceof GroupChannel)) {
                    buildFromSerializedData = null;
                }
                GroupChannel groupChannel = (GroupChannel) buildFromSerializedData;
                if (groupChannel != null) {
                    com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
                    String url = groupChannel.getUrl();
                    kotlin.g.b.k.a((Object) url, "it.url");
                    com.paytm.android.chat.d.a.a.a(url, groupChannel);
                }
            }
            return list;
        }
    }

    static final class b<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41988a;

        b(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41988a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List<ChatChannelEntity> list = (List) obj;
            List arrayList = new ArrayList();
            kotlin.g.b.k.a((Object) list, "channelEntityList");
            for (ChatChannelEntity mapChannelEntityToChatChannel : list) {
                ChatGroupChannelDataModel mapChannelEntityToChatChannel2 = CPCDataMapperKt.mapChannelEntityToChatChannel(mapChannelEntityToChatChannel, this.f41988a.chatLocalUsersDataStore);
                if (mapChannelEntityToChatChannel2 != null) {
                    arrayList.add(mapChannelEntityToChatChannel2);
                }
            }
            return arrayList;
        }
    }

    static final class c<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41989a;

        c(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41989a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            ChatLocalChannelDataStore chatLocalChannelDataStore = this.f41989a;
            kotlin.g.b.k.a((Object) list, "it");
            return chatLocalChannelDataStore.fixLastMessagePreviews(list);
        }
    }

    static final class d<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f41990a = new d();

        d() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            kotlin.g.b.k.a((Object) list, "it");
            return ChatVariantUtilKt.getFilteredListForVariant(list);
        }
    }

    static final class j<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f41996a;

        j(ChatGroupChannelDataModel chatGroupChannelDataModel) {
            this.f41996a = chatGroupChannelDataModel;
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            kotlin.g.b.k.c(list, "msgEntList");
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ChatMessageEntity chatMessageEntity = (ChatMessageEntity) it2.next();
                if (chatMessageEntity.getRawMessage() != null) {
                    BaseMessage buildFromSerializedData = BaseMessage.buildFromSerializedData(chatMessageEntity.getRawMessage());
                    if (!(buildFromSerializedData instanceof AdminMessage)) {
                        kotlin.g.b.k.a((Object) buildFromSerializedData, "baseMessage");
                        MPCMessagePreview messagePreview = CPCMessagePreviewUtilsKt.getMessagePreview(buildFromSerializedData);
                        if (messagePreview == null) {
                            continue;
                        } else {
                            CharSequence previewText = messagePreview.getPreviewText();
                            if (!(previewText == null || previewText.length() == 0)) {
                                ChatMessageDataModel chatMessageDataModelFromMessageEntity = MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(chatMessageEntity, false);
                                this.f41996a.setLastMessage(chatMessageDataModelFromMessageEntity);
                                String str = null;
                                this.f41996a.setLastmessageId(chatMessageDataModelFromMessageEntity != null ? Long.valueOf(chatMessageDataModelFromMessageEntity.messageId) : null);
                                ChatGroupChannelDataModel chatGroupChannelDataModel = this.f41996a;
                                if (chatMessageDataModelFromMessageEntity != null) {
                                    str = chatMessageDataModelFromMessageEntity.messageType;
                                }
                                chatGroupChannelDataModel.setLastMessageType(str);
                                this.f41996a.setLastMessagePreview(CPCMessagePreviewUtilsKt.getMessagePreview(buildFromSerializedData));
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            return kotlin.x.f47997a;
        }
    }

    static final class k<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f41997a = new k();

        k() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            ChatChannelEntity chatChannelEntity = (ChatChannelEntity) obj;
            BaseChannel buildFromSerializedData = BaseChannel.buildFromSerializedData(chatChannelEntity.getRawChannel());
            if (!(buildFromSerializedData instanceof GroupChannel)) {
                buildFromSerializedData = null;
            }
            GroupChannel groupChannel = (GroupChannel) buildFromSerializedData;
            if (groupChannel == null) {
                return null;
            }
            ChatGroupChannelDataModel mapBaseChannelToChatChannel = CPCDataMapperKt.mapBaseChannelToChatChannel(groupChannel);
            mapBaseChannelToChatChannel.setDraftMessage(chatChannelEntity.getDraftMessage());
            mapBaseChannelToChatChannel.setUnreadMessageCount(chatChannelEntity.getUnreadMessageCount());
            com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
            String url = groupChannel.getUrl();
            kotlin.g.b.k.a((Object) url, "channel.url");
            com.paytm.android.chat.d.a.a.a(url, groupChannel);
            return mapBaseChannelToChatChannel;
        }
    }

    static final class m<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f41999a = new m();

        m() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            List list = (List) obj;
            kotlin.g.b.k.a((Object) list, "list");
            kotlin.a.k.a(list, AnonymousClass1.f42000a);
            return list;
        }
    }

    static final class p<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.c f42001a;

        p(x.c cVar) {
            this.f42001a = cVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            x.c cVar = this.f42001a;
            kotlin.g.b.k.a((Object) num, "it");
            cVar.element = num.intValue();
        }
    }

    static final class q<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.c f42002a;

        q(x.c cVar) {
            this.f42002a = cVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            x.c cVar = this.f42002a;
            kotlin.g.b.k.a((Object) num, "it");
            cVar.element = num.intValue();
        }
    }

    static final class s<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final s f42005a = new s();

        s() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            return Integer.valueOf(a((List) obj));
        }

        private static int a(List<ChatGroupChannelDataModel> list) {
            HomeFilter homeFilter;
            try {
                homeFilter = (HomeFilter) new com.google.gson.f().a(com.paytm.android.chat.e.a().a("chat_home_filter_v2", ""), HomeFilter.class);
            } catch (Exception unused) {
                homeFilter = null;
            }
            int i2 = 0;
            if (homeFilter == null || list.size() < homeFilter.getCount()) {
                kotlin.g.b.k.a((Object) list, "it");
                for (ChatGroupChannelDataModel unreadMessageCount : list) {
                    i2 += unreadMessageCount.getUnreadMessageCount();
                }
                return i2;
            }
            kotlin.g.b.k.a((Object) list, "it");
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (kotlin.a.k.a(homeFilter.getFilters(), ((ChatGroupChannelDataModel) next).getCustomType())) {
                    arrayList.add(next);
                }
            }
            for (ChatGroupChannelDataModel unreadMessageCount2 : (List) arrayList) {
                i2 += unreadMessageCount2.getUnreadMessageCount();
            }
            return i2;
        }
    }

    public ChatLocalChannelDataStore(ChatLocalUsersDataStore chatLocalUsersDataStore2, ChatMessageDao chatMessageDao2, ChatChannelDao chatChannelDao2, ChatChannelUsersJoinDao chatChannelUsersJoinDao2, androidx.room.j jVar) {
        kotlin.g.b.k.c(chatLocalUsersDataStore2, "chatLocalUsersDataStore");
        kotlin.g.b.k.c(chatMessageDao2, "chatMessageDao");
        kotlin.g.b.k.c(chatChannelDao2, "chatChannelDao");
        kotlin.g.b.k.c(chatChannelUsersJoinDao2, "chatChannelUsersJoinDao");
        kotlin.g.b.k.c(jVar, "database");
        this.chatLocalUsersDataStore = chatLocalUsersDataStore2;
        this.chatMessageDao = chatMessageDao2;
        this.chatChannelDao = chatChannelDao2;
        this.chatChannelUsersJoinDao = chatChannelUsersJoinDao2;
        this.database = jVar;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final io.reactivex.rxjava3.a.h<List<ChatGroupChannelDataModel>> getAllChannelFlowable() {
        return this.allChannelFlowable;
    }

    public final void updateChannels(List<? extends BaseChannel> list) {
        kotlin.g.b.k.c(list, "channels");
        if (!list.isEmpty()) {
            io.reactivex.rxjava3.a.y.a(new y(this, list)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(z.f42014a, (io.reactivex.rxjava3.d.g<? super Throwable>) new aa(this));
        }
    }

    public final io.reactivex.rxjava3.a.b updateChatChannels(List<ChatGroupChannelDataModel> list) {
        kotlin.g.b.k.c(list, "channels");
        if (!list.isEmpty()) {
            io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((Callable<?>) new ab(this, list)).a((io.reactivex.rxjava3.d.g<? super Throwable>) new ac(this));
            kotlin.g.b.k.a((Object) a2, "Completable.fromCallable…, \"updateChannels\", it) }");
            return a2;
        }
        io.reactivex.rxjava3.a.b a3 = io.reactivex.rxjava3.a.b.a((Throwable) new UnsupportedOperationException("Empty channels"));
        kotlin.g.b.k.a((Object) a3, "Completable.error(Unsupp…eption(\"Empty channels\"))");
        return a3;
    }

    public final void updateChannel(BaseChannel baseChannel) {
        kotlin.g.b.k.c(baseChannel, "channel");
        updateChannels(kotlin.a.k.a(baseChannel));
    }

    public final io.reactivex.rxjava3.a.b updateChannel(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
        return updateChatChannels(kotlin.a.k.a(chatGroupChannelDataModel));
    }

    public final io.reactivex.rxjava3.a.h<List<ChatGroupChannelDataModel>> getChannelsForDisplay() {
        io.reactivex.rxjava3.a.h<R> a2 = getAllChatGroupChannels().a(new l(this)).a(m.f41999a);
        kotlin.g.b.k.a((Object) a2, "getAllChatGroupChannels(…ap list\n                }");
        return a2;
    }

    static final class l<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41998a;

        l(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41998a = chatLocalChannelDataStore;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public List<ChatGroupChannelDataModel> apply(List<ChatGroupChannelDataModel> list) {
            Long l;
            kotlin.g.b.k.a((Object) list, "list");
            Iterable<ChatGroupChannelDataModel> iterable = list;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (ChatGroupChannelDataModel chatGroupChannelDataModel : iterable) {
                try {
                    ChatMessageEntity latestNotSucceededMessage = this.f41998a.chatMessageDao.getLatestNotSucceededMessage(chatGroupChannelDataModel.getChannelUrl());
                    if ((latestNotSucceededMessage != null ? latestNotSucceededMessage.getRawMessage() : null) != null) {
                        ChatMessageDataModel lastMessage = chatGroupChannelDataModel.getLastMessage();
                        long j = 0;
                        long longValue = (lastMessage == null || (l = lastMessage.createdAt) == null) ? 0 : l.longValue();
                        Long createdAt = latestNotSucceededMessage.getCreatedAt();
                        if (createdAt != null) {
                            j = createdAt.longValue();
                        }
                        if (longValue <= j) {
                            chatGroupChannelDataModel.setLastMessage(MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(latestNotSucceededMessage, true));
                        }
                    }
                } catch (Exception unused) {
                }
                arrayList.add(chatGroupChannelDataModel);
            }
            return kotlin.a.k.c((List) arrayList);
        }
    }

    public final io.reactivex.rxjava3.a.l<ChatGroupChannelDataModel> getChannelByIdentifier(String str) {
        kotlin.g.b.k.c(str, "channelUrl");
        io.reactivex.rxjava3.a.l<R> c2 = this.chatChannelDao.getChannel(str).c(k.f41997a);
        kotlin.g.b.k.a((Object) c2, "chatChannelDao.getChanne…      }\n                }");
        return c2;
    }

    public final io.reactivex.rxjava3.a.y<Integer> getChannelCount() {
        return this.chatChannelDao.getChannelCount();
    }

    public final GroupChannel getSendbirdChannel(String str) {
        com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
        return com.paytm.android.chat.d.a.a.a(str);
    }

    public final io.reactivex.rxjava3.a.h<List<ChatGroupChannelDataModel>> getAllChatGroupChannels() {
        io.reactivex.rxjava3.a.h<List<ChatGroupChannelDataModel>> hVar = this.allChannelFlowable;
        kotlin.g.b.k.a((Object) hVar, "allChannelFlowable");
        return hVar;
    }

    /* access modifiers changed from: private */
    public final List<ChatGroupChannelDataModel> fixLastMessagePreviews(List<ChatGroupChannelDataModel> list) {
        BaseMessage baseMessage;
        List arrayList = new ArrayList();
        for (ChatGroupChannelDataModel chatGroupChannelDataModel : list) {
            if (chatGroupChannelDataModel.getLastMessage() != null) {
                ChatMessageDataModel lastMessage = chatGroupChannelDataModel.getLastMessage();
                if ((lastMessage != null ? lastMessage.baseMessage : null) == null) {
                    arrayList.add(chatGroupChannelDataModel);
                }
                ChatMessageDataModel lastMessage2 = chatGroupChannelDataModel.getLastMessage();
                if (!(lastMessage2 == null || (baseMessage = lastMessage2.baseMessage) == null)) {
                    if (baseMessage instanceof AdminMessage) {
                        arrayList.add(chatGroupChannelDataModel);
                    }
                    MPCMessagePreview messagePreview = CPCMessagePreviewUtilsKt.getMessagePreview(baseMessage);
                    if (messagePreview == null) {
                        arrayList.add(chatGroupChannelDataModel);
                    } else {
                        CharSequence previewText = messagePreview.getPreviewText();
                        if (previewText == null || previewText.length() == 0) {
                            arrayList.add(chatGroupChannelDataModel);
                        }
                    }
                }
            } else {
                arrayList.add(chatGroupChannelDataModel);
            }
            if (areAllMessagesAdmin(chatGroupChannelDataModel.getChannelUrl())) {
                arrayList.remove(chatGroupChannelDataModel);
            }
            if (areAllMessagesWithBadPreviews(chatGroupChannelDataModel.getChannelUrl())) {
                arrayList.remove(chatGroupChannelDataModel);
            }
        }
        Iterable<ChatGroupChannelDataModel> iterable = arrayList;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (ChatGroupChannelDataModel chatGroupChannelDataModel2 : iterable) {
            arrayList2.add((kotlin.x) DBManager.INSTANCE.getDb().chatMessageDao().getMessageForChannel(chatGroupChannelDataModel2.getChannelUrl()).a(new j(chatGroupChannelDataModel2)).b());
        }
        return list;
    }

    private final boolean areAllMessagesAdmin(String str) {
        return MessageDBHelperKt.getNonAdminMessagesForChannelByUrl(str).isEmpty();
    }

    private final boolean areAllMessagesWithBadPreviews(String str) {
        return MessageDBHelperKt.getPreviewTextNotEmptyMessagesByChannelUrl(str).isEmpty();
    }

    /* access modifiers changed from: private */
    public final void updateChannelsAndUsersInDatabase(List<? extends BaseChannel> list) {
        ChatLocalUsersDataStore chatLocalUsersDataStore2 = this.chatLocalUsersDataStore;
        Iterable<BaseChannel> iterable = list;
        Collection arrayList = new ArrayList();
        for (BaseChannel baseChannel : iterable) {
            if (baseChannel != null) {
                kotlin.a.k.a(arrayList, ((GroupChannel) baseChannel).getMembers());
            } else {
                throw new kotlin.u("null cannot be cast to non-null type com.sendbird.android.GroupChannel");
            }
        }
        chatLocalUsersDataStore2.updateUsers((List<? extends Member>) (List) arrayList);
        this.chatChannelUsersJoinDao.upsert(getJointEntitiesWithParticipantKey(list));
        Collection arrayList2 = new ArrayList();
        for (BaseChannel baseChannel2 : iterable) {
            ChatChannelEntity chatChannelEntity = null;
            if (!(baseChannel2 instanceof GroupChannel)) {
                baseChannel2 = null;
            }
            GroupChannel groupChannel = (GroupChannel) baseChannel2;
            if (groupChannel != null) {
                com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
                String url = groupChannel.getUrl();
                kotlin.g.b.k.a((Object) url, "it.url");
                com.paytm.android.chat.d.a.a.a(url, groupChannel);
                chatChannelEntity = CPCDataMapperKt.mapBaseChannelToChannelEntity(groupChannel);
            }
            if (chatChannelEntity != null) {
                arrayList2.add(chatChannelEntity);
            }
        }
        this.chatChannelDao.upsertDeprecated((List) arrayList2);
    }

    /* access modifiers changed from: private */
    public final void updatechatChannelsAndUsersInDatabase(List<ChatGroupChannelDataModel> list) {
        ChatLocalUsersDataStore chatLocalUsersDataStore2 = this.chatLocalUsersDataStore;
        Iterable<ChatGroupChannelDataModel> iterable = list;
        Collection arrayList = new ArrayList();
        for (ChatGroupChannelDataModel members : iterable) {
            kotlin.a.k.a(arrayList, members.getMembers());
        }
        chatLocalUsersDataStore2.updateUsersDataModel((List) arrayList);
        this.chatChannelUsersJoinDao.upsert(getJointChannelEntitiesWithParticipantKey(list));
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (ChatGroupChannelDataModel mapChatChannelToChannelEntity : iterable) {
            arrayList2.add(CPCDataMapperKt.mapChatChannelToChannelEntity(mapChatChannelToChannelEntity));
        }
        this.chatChannelDao.upsertDeprecated((List) arrayList2);
    }

    public final List<ChatChannelUsersJoinEntity> getJointEntitiesWithParticipantKey(List<? extends BaseChannel> list) {
        kotlin.g.b.k.c(list, "channels");
        ArrayList arrayList = new ArrayList();
        Iterable<BaseChannel> iterable = list;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (BaseChannel baseChannel : iterable) {
            if (baseChannel != null) {
                GroupChannel groupChannel = (GroupChannel) baseChannel;
                List<Member> members = groupChannel.getMembers();
                kotlin.g.b.k.a((Object) members, "ch.members");
                String a2 = kotlin.a.k.a((Iterable) members, (CharSequence) "+", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) o.INSTANCE, 30);
                ChatChannelUsersJoinEntity chatChannelUsersJoinEntity = new ChatChannelUsersJoinEntity();
                String url = groupChannel.getUrl();
                kotlin.g.b.k.a((Object) url, "ch.url");
                chatChannelUsersJoinEntity.setChannelUrl(url);
                chatChannelUsersJoinEntity.setUniqueId(a2);
                arrayList2.add(Boolean.valueOf(arrayList.add(chatChannelUsersJoinEntity)));
            } else {
                throw new kotlin.u("null cannot be cast to non-null type com.sendbird.android.GroupChannel");
            }
        }
        return arrayList;
    }

    static final class o extends kotlin.g.b.l implements kotlin.g.a.b<Member, String> {
        public static final o INSTANCE = new o();

        o() {
            super(1);
        }

        public final String invoke(Member member) {
            kotlin.g.b.k.a((Object) member, "it");
            String userId = member.getUserId();
            kotlin.g.b.k.a((Object) userId, "it.userId");
            return userId;
        }
    }

    public final List<ChatChannelUsersJoinEntity> getJointChannelEntitiesWithParticipantKey(List<ChatGroupChannelDataModel> list) {
        kotlin.g.b.k.c(list, "channels");
        ArrayList arrayList = new ArrayList();
        Iterable<ChatGroupChannelDataModel> iterable = list;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (ChatGroupChannelDataModel chatGroupChannelDataModel : iterable) {
            String a2 = kotlin.a.k.a((Iterable) chatGroupChannelDataModel.getMembers(), (CharSequence) "+", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) n.INSTANCE, 30);
            ChatChannelUsersJoinEntity chatChannelUsersJoinEntity = new ChatChannelUsersJoinEntity();
            chatChannelUsersJoinEntity.setChannelUrl(chatGroupChannelDataModel.getChannelUrl());
            chatChannelUsersJoinEntity.setUniqueId(a2);
            arrayList2.add(Boolean.valueOf(arrayList.add(chatChannelUsersJoinEntity)));
        }
        return arrayList;
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.b<ChatUserDataModel, CharSequence> {
        public static final n INSTANCE = new n();

        n() {
            super(1);
        }

        public final CharSequence invoke(ChatUserDataModel chatUserDataModel) {
            kotlin.g.b.k.c(chatUserDataModel, "it");
            String sendbirdUserId = chatUserDataModel.getSendbirdUserId();
            return sendbirdUserId != null ? sendbirdUserId : "";
        }
    }

    public final ChatGroupChannelDataModel updateAndGetChannel(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        ChatGroupChannelDataModel chatGroupChannelDataModel2 = chatGroupChannelDataModel;
        kotlin.g.b.k.c(chatGroupChannelDataModel2, "channel");
        com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
        GroupChannel a2 = com.paytm.android.chat.d.a.a.a(chatGroupChannelDataModel.getChannelUrl());
        if (a2 == null) {
            return chatGroupChannelDataModel2;
        }
        BaseMessage lastMessage = a2.getLastMessage();
        ChatMessageDataModel chatMessageDataModelFromMessageEntity = lastMessage != null ? MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(MessageDBHelperKt.getChatMessageEntity(a2, lastMessage), true) : null;
        ChatLocalUsersDataStore chatLocalUsersDataStore2 = this.chatLocalUsersDataStore;
        List<Member> members = a2.getMembers();
        kotlin.g.b.k.a((Object) members, "sendbirdChannel.members");
        return ChatGroupChannelDataModel.copy$default(chatGroupChannelDataModel, false, (String) null, (ReceiverDisplayInfo) null, false, chatMessageDataModelFromMessageEntity, (MPCMessagePreview) null, (String) null, chatLocalUsersDataStore2.getChatUsersFromMembers(members), (Long) null, (String) null, 0, 0, 0, 0, (String) null, (String) null, false, (String) null, (Long) null, (String) null, false, false, false, false, false, (ChannelMetaData) null, 0, false, false, false, (String) null, 2147483503, (Object) null);
    }

    public final void deleteChannel(String str) {
        kotlin.g.b.k.c(str, "identifier");
        io.reactivex.rxjava3.a.b.a(this.chatChannelDao.deleteChannel(str), this.chatMessageDao.deleteMessageForChannel(str)).b((io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.b.c>) new e(this)).a((io.reactivex.rxjava3.d.a) new f(this)).b((io.reactivex.rxjava3.d.a) new g(this)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(h.f41994a, new i(this));
    }

    static final class f implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41992a;

        f(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41992a = chatLocalChannelDataStore;
        }

        public final void run() {
            this.f41992a.database.setTransactionSuccessful();
        }
    }

    static final class g implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41993a;

        g(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41993a = chatLocalChannelDataStore;
        }

        public final void run() {
            this.f41993a.database.endTransaction();
        }
    }

    public final void updateDraftMessageForChannel(String str, String str2) {
        kotlin.g.b.k.c(str, "identifier");
        this.chatChannelDao.updateDraftMessage(str, str2 != null ? com.paytm.android.chat.f.a(str2) : null).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(ad.f41986a, new ae(this));
    }

    public final void updateChannelPinnedState(String str, boolean z2) {
        kotlin.g.b.k.c(str, "identifier");
        this.chatChannelDao.updatePinnedState(str, z2).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(w.f42010a, new x(this));
    }

    public final io.reactivex.rxjava3.a.y<Integer> totalPinnedChannelCount() {
        return this.chatChannelDao.getPinnedChannelCount();
    }

    public final io.reactivex.rxjava3.a.h<Integer> observeUnreadCountOnChannels() {
        io.reactivex.rxjava3.a.h<R> a2 = getAllChatGroupChannels().a(s.f42005a);
        io.reactivex.rxjava3.a.h<Integer> allNotificationCountFlowable = NotificationDBHelperKt.getAllNotificationCountFlowable();
        x.c cVar = new x.c();
        cVar.element = 0;
        x.c cVar2 = new x.c();
        cVar2.element = 0;
        io.reactivex.rxjava3.a.h<Integer> a3 = io.reactivex.rxjava3.a.h.a(a2.a((io.reactivex.rxjava3.d.g<? super R>) new p(cVar)), (io.reactivex.rxjava3.a.h<R>) allNotificationCountFlowable.a((io.reactivex.rxjava3.d.g<? super Integer>) new q(cVar2))).c().a(new r(cVar, cVar2));
        kotlin.g.b.k.a((Object) a3, "Flowable.merge(\n        …      }\n                }");
        return a3;
    }

    public final ChatGroupChannelDataModel locateChannelBetweenTwoUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2) {
        String channelUrl;
        kotlin.g.b.k.c(chatPayeeUser, "sender");
        kotlin.g.b.k.c(chatPayeeUser2, "receiver");
        ChatChannelUsersJoinDao chatChannelUsersJoinDao2 = this.chatChannelUsersJoinDao;
        ChatChannelUsersJoinEntity channelForUniqueId = chatChannelUsersJoinDao2.getChannelForUniqueId(chatPayeeUser.getIdentifier() + '+' + chatPayeeUser2.getIdentifier());
        if (channelForUniqueId == null || (channelUrl = channelForUniqueId.getChannelUrl()) == null) {
            return null;
        }
        return getChannelByIdentifier(channelUrl).b().a();
    }

    public final ChatGroupChannelDataModel updateChannelFromCreateChannelApi(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2, Map<String, ? extends UsersInfoJsonBean> map, BaseChannel baseChannel) {
        kotlin.g.b.k.c(chatPayeeUser, "sender");
        kotlin.g.b.k.c(chatPayeeUser2, "receiver");
        kotlin.g.b.k.c(map, "userMap");
        kotlin.g.b.k.c(baseChannel, "channel");
        ChatGroupChannelDataModel mapBaseChannelToChatChannel = CPCDataMapperKt.mapBaseChannelToChatChannel(baseChannel);
        pairUserPaymentDataAndUpdateDataStores(baseChannel, kotlin.a.k.b((T[]) new ChatPayeeUser[]{chatPayeeUser, chatPayeeUser2}), map, mapBaseChannelToChatChannel);
        return mapBaseChannelToChatChannel;
    }

    public final void pairUserPaymentDataAndUpdateDataStores(BaseChannel baseChannel, List<? extends ChatPayeeUser> list, Map<String, ? extends UsersInfoJsonBean> map, ChatGroupChannelDataModel chatGroupChannelDataModel) {
        kotlin.g.b.k.c(baseChannel, "baseChannel");
        kotlin.g.b.k.c(list, "listOfPayeeUser");
        kotlin.g.b.k.c(map, "userMap");
        kotlin.g.b.k.c(chatGroupChannelDataModel, "chatGroupChannelDataModel");
        List<ChatUserDataModel> arrayList = new ArrayList<>();
        if (baseChannel instanceof GroupChannel) {
            List<Member> members = ((GroupChannel) baseChannel).getMembers();
            kotlin.g.b.k.a((Object) members, "baseChannel.members");
            for (Member member : members) {
                kotlin.g.b.k.a((Object) member, "it");
                ChatUserDataModel mapUserEntityToChatUser = CPCDataMapperKt.mapUserEntityToChatUser(CPCDataMapperKt.mapMemberToUserEntity(member));
                UsersInfoJsonBean usersInfoJsonBean = (UsersInfoJsonBean) map.get(member.getUserId());
                if (usersInfoJsonBean != null) {
                    mapUserEntityToChatUser.bindUserInfoApiData(usersInfoJsonBean);
                }
                arrayList.add(mapUserEntityToChatUser);
            }
        }
        for (ChatPayeeUser chatPayeeUser : list) {
            for (ChatUserDataModel chatUserDataModel : arrayList) {
                if (kotlin.g.b.k.a((Object) chatPayeeUser.getIdentifier(), (Object) chatUserDataModel.getIdentifier())) {
                    chatUserDataModel.bindChatPayeeUser(chatPayeeUser);
                }
            }
        }
        this.chatLocalUsersDataStore.updateUsersWithOurModels(arrayList);
        this.chatChannelUsersJoinDao.upsert(getJointEntitiesWithParticipantKey(kotlin.a.k.a(baseChannel)));
        chatGroupChannelDataModel.setMembers(arrayList);
    }

    public final ChatGroupChannelDataModel offlineCreateFakeChannelBetweenUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2) {
        ChatPayeeUser chatPayeeUser3 = chatPayeeUser;
        ChatPayeeUser chatPayeeUser4 = chatPayeeUser2;
        kotlin.g.b.k.c(chatPayeeUser3, "sender");
        kotlin.g.b.k.c(chatPayeeUser4, "receiver");
        List arrayList = new ArrayList();
        ChatUserDataModel chatUserDataModel = r3;
        ChatUserDataModel chatUserDataModel2 = new ChatUserDataModel((String) null, (String) null, (ChatUserType) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, false, false, false, (byte[]) null, (String) null, (String) null, (String) null, (UserInfoSource) null, (UserMetaData) null, (UserExtendedMetaData) null, (Long) null, 0, 0, (ChatUserEntity.ChatPaymentMetadata) null, (com.paytm.android.chat.contact.a) null, (String) null, 33554431, (kotlin.g.b.g) null);
        ChatUserDataModel chatUserDataModel3 = chatUserDataModel;
        chatUserDataModel3.bindChatPayeeUser(chatPayeeUser3);
        arrayList.add(chatUserDataModel3);
        ChatUserDataModel chatUserDataModel4 = new ChatUserDataModel((String) null, (String) null, (ChatUserType) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, false, false, false, (byte[]) null, (String) null, (String) null, (String) null, (UserInfoSource) null, (UserMetaData) null, (UserExtendedMetaData) null, (Long) null, 0, 0, (ChatUserEntity.ChatPaymentMetadata) null, (com.paytm.android.chat.contact.a) null, (String) null, 33554431, (kotlin.g.b.g) null);
        chatUserDataModel4.bindChatPayeeUser(chatPayeeUser4);
        arrayList.add(chatUserDataModel4);
        ChatGroupChannelDataModel provideOfflineFakeChannel = CPCDataProviderKt.provideOfflineFakeChannel(arrayList);
        CPCDataMapperKt.mapChannelToEntityOffline(provideOfflineFakeChannel);
        return provideOfflineFakeChannel;
    }

    /* access modifiers changed from: private */
    public final void offlineUpdateChannelsAndUsersInDatabase(List<ChatGroupChannelDataModel> list) {
        ChatLocalUsersDataStore chatLocalUsersDataStore2 = this.chatLocalUsersDataStore;
        Iterable<ChatGroupChannelDataModel> iterable = list;
        Collection arrayList = new ArrayList();
        for (ChatGroupChannelDataModel members : iterable) {
            kotlin.a.k.a(arrayList, members.getMembers());
        }
        chatLocalUsersDataStore2.updateUsersWithOurModels((List) arrayList);
        this.chatChannelUsersJoinDao.upsert(offlineGetJointEntitiesWithParticipantKey(list));
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (ChatGroupChannelDataModel mapChannelToEntityOffline : iterable) {
            arrayList2.add(CPCDataMapperKt.mapChannelToEntityOffline(mapChannelToEntityOffline));
        }
        this.chatChannelDao.upsertDeprecated((List) arrayList2);
    }

    public final List<ChatChannelUsersJoinEntity> offlineGetJointEntitiesWithParticipantKey(List<ChatGroupChannelDataModel> list) {
        kotlin.g.b.k.c(list, "channels");
        ArrayList arrayList = new ArrayList();
        Iterable<ChatGroupChannelDataModel> iterable = list;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (ChatGroupChannelDataModel chatGroupChannelDataModel : iterable) {
            String str = "";
            for (ChatUserDataModel chatUserDataModel : chatGroupChannelDataModel.getMembers()) {
                if (str.length() == 0) {
                    String identifier = chatUserDataModel.getIdentifier();
                    if (identifier != null) {
                        str = identifier;
                    }
                } else {
                    String identifier2 = chatUserDataModel.getIdentifier();
                    if (identifier2 != null) {
                        str = str + '+' + identifier2;
                    }
                }
            }
            ChatChannelUsersJoinEntity chatChannelUsersJoinEntity = new ChatChannelUsersJoinEntity();
            chatChannelUsersJoinEntity.setChannelUrl(chatGroupChannelDataModel.getChannelUrl());
            chatChannelUsersJoinEntity.setUniqueId(str);
            arrayList2.add(Boolean.valueOf(arrayList.add(chatChannelUsersJoinEntity)));
        }
        return arrayList;
    }

    public final void offlineUpdateChannelWithOurModel(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        kotlin.g.b.k.c(chatGroupChannelDataModel, "channel");
        offlineUpdateChannelsWithOurModel(kotlin.a.k.a(chatGroupChannelDataModel));
    }

    public final void offlineUpdateChannelsWithOurModel(List<ChatGroupChannelDataModel> list) {
        kotlin.g.b.k.c(list, "channels");
        if (!list.isEmpty()) {
            io.reactivex.rxjava3.a.y.a(new t(this, list)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(u.f42008a, (io.reactivex.rxjava3.d.g<? super Throwable>) new v(this));
        }
    }

    static final class y<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f42012a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f42013b;

        y(ChatLocalChannelDataStore chatLocalChannelDataStore, List list) {
            this.f42012a = chatLocalChannelDataStore;
            this.f42013b = list;
        }

        public final /* synthetic */ Object call() {
            ChatLocalChannelDataStore chatLocalChannelDataStore = this.f42012a;
            List list = this.f42013b;
            if (list != null) {
                chatLocalChannelDataStore.updateChannelsAndUsersInDatabase(list);
                return kotlin.x.f47997a;
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.List<com.sendbird.android.BaseChannel>");
        }
    }

    static final class aa<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41982a;

        aa(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41982a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41982a.getTAG();
            com.paytm.utility.q.c("updateChannels");
        }
    }

    static final class ab<V> implements Callable<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41983a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f41984b;

        ab(ChatLocalChannelDataStore chatLocalChannelDataStore, List list) {
            this.f41983a = chatLocalChannelDataStore;
            this.f41984b = list;
        }

        public final /* synthetic */ Object call() {
            this.f41983a.updatechatChannelsAndUsersInDatabase(this.f41984b);
            return kotlin.x.f47997a;
        }
    }

    static final class ac<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41985a;

        ac(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41985a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41985a.getTAG();
            com.paytm.utility.q.c("updateChannels");
        }
    }

    static final class e<T> implements io.reactivex.rxjava3.d.g<io.reactivex.rxjava3.b.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41991a;

        e(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41991a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41991a.database.beginTransaction();
        }
    }

    static final class i<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41995a;

        i(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41995a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41995a.getTAG();
            com.paytm.utility.q.c("delete channel");
        }
    }

    static final class ae<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f41987a;

        ae(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f41987a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41987a.getTAG();
            com.paytm.utility.q.c("updateDraftMessage");
        }
    }

    static final class x<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f42011a;

        x(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f42011a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42011a.getTAG();
            com.paytm.utility.q.c("updatePinnedState");
        }
    }

    static final class r<T1, T2, R> implements io.reactivex.rxjava3.d.c<Integer, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.c f42003a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.c f42004b;

        r(x.c cVar, x.c cVar2) {
            this.f42003a = cVar;
            this.f42004b = cVar2;
        }

        public final /* synthetic */ Object a(Object obj, Object obj2) {
            if (this.f42003a.element == this.f42004b.element) {
                return Integer.valueOf(this.f42003a.element);
            }
            return Integer.valueOf(Math.max(this.f42003a.element, this.f42004b.element));
        }
    }

    static final class t<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f42006a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f42007b;

        t(ChatLocalChannelDataStore chatLocalChannelDataStore, List list) {
            this.f42006a = chatLocalChannelDataStore;
            this.f42007b = list;
        }

        public final /* synthetic */ Object call() {
            this.f42006a.offlineUpdateChannelsAndUsersInDatabase(this.f42007b);
            return kotlin.x.f47997a;
        }
    }

    static final class v<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalChannelDataStore f42009a;

        v(ChatLocalChannelDataStore chatLocalChannelDataStore) {
            this.f42009a = chatLocalChannelDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42009a.getTAG();
            com.paytm.utility.q.c("updateChannels");
        }
    }
}
