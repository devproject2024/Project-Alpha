package com.paytm.android.chat.data.repository;

import com.imsdk.CPCSendbirdWrapper;
import com.imsdk.Datawrapper;
import com.paytm.android.chat.bean.UserInfoBean;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt;
import com.paytm.android.chat.data.mappers.CPCDataMapperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.repository.datastores.ChatChannelDataStore;
import com.paytm.android.chat.data.repository.datastores.ChatLocalUsersDataStore;
import com.paytm.android.chat.data.repository.datastores.IPCRemoteDS;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.q;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import com.sendbird.android.UserMessageParams;
import com.sendbird.android.constant.StringSet;
import io.reactivex.rxjava3.a.c;
import io.reactivex.rxjava3.a.e;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.h;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser;

public final class RPCChatRepository implements ChatRepository {
    private final ChatChannelDataStore localChannelDataStore;
    private ChatLocalUsersDataStore localUsersDataStore;
    private final IPCRemoteDS remoteDS;
    private final SharedPreferencesUtil sharedPrefUtil;

    public RPCChatRepository(IPCRemoteDS iPCRemoteDS) {
        this(iPCRemoteDS, (ChatLocalUsersDataStore) null, (ChatChannelDataStore) null, (SharedPreferencesUtil) null, 14, (g) null);
    }

    public RPCChatRepository(IPCRemoteDS iPCRemoteDS, ChatLocalUsersDataStore chatLocalUsersDataStore) {
        this(iPCRemoteDS, chatLocalUsersDataStore, (ChatChannelDataStore) null, (SharedPreferencesUtil) null, 12, (g) null);
    }

    public RPCChatRepository(IPCRemoteDS iPCRemoteDS, ChatLocalUsersDataStore chatLocalUsersDataStore, ChatChannelDataStore chatChannelDataStore) {
        this(iPCRemoteDS, chatLocalUsersDataStore, chatChannelDataStore, (SharedPreferencesUtil) null, 8, (g) null);
    }

    static final class b<T, R> implements h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RPCChatRepository f41980a;

        b(RPCChatRepository rPCChatRepository) {
            this.f41980a = rPCChatRepository;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            RPCChatRepository rPCChatRepository = this.f41980a;
            k.a((Object) chatGroupChannelDataModel, "channel");
            rPCChatRepository.updateLocalChannel(chatGroupChannelDataModel);
            return chatGroupChannelDataModel;
        }
    }

    public RPCChatRepository(IPCRemoteDS iPCRemoteDS, ChatLocalUsersDataStore chatLocalUsersDataStore, ChatChannelDataStore chatChannelDataStore, SharedPreferencesUtil sharedPreferencesUtil) {
        k.c(iPCRemoteDS, "remoteDS");
        k.c(chatLocalUsersDataStore, "localUsersDataStore");
        k.c(chatChannelDataStore, "localChannelDataStore");
        k.c(sharedPreferencesUtil, "sharedPrefUtil");
        this.remoteDS = iPCRemoteDS;
        this.localUsersDataStore = chatLocalUsersDataStore;
        this.localChannelDataStore = chatChannelDataStore;
        this.sharedPrefUtil = sharedPreferencesUtil;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RPCChatRepository(com.paytm.android.chat.data.repository.datastores.IPCRemoteDS r8, com.paytm.android.chat.data.repository.datastores.ChatLocalUsersDataStore r9, com.paytm.android.chat.data.repository.datastores.ChatChannelDataStore r10, com.paytm.android.chat.utils.SharedPreferencesUtil r11, int r12, kotlin.g.b.g r13) {
        /*
            r7 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L_0x001d
            com.paytm.android.chat.data.repository.datastores.ChatLocalUsersDataStore r9 = new com.paytm.android.chat.data.repository.datastores.ChatLocalUsersDataStore
            com.paytm.android.chat.data.db.room.DBManager r13 = com.paytm.android.chat.data.db.room.DBManager.INSTANCE
            com.paytm.android.chat.data.db.room.ChatDB r13 = r13.getDb()
            com.paytm.android.chat.data.db.room.dao.ChatUserDao r13 = r13.chatUserDao()
            com.paytm.android.chat.data.db.room.DBManager r0 = com.paytm.android.chat.data.db.room.DBManager.INSTANCE
            com.paytm.android.chat.data.db.room.ChatDB r0 = r0.getDb()
            com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao r0 = r0.chatChannelUserDao()
            r9.<init>(r13, r0)
        L_0x001d:
            r13 = r12 & 4
            if (r13 == 0) goto L_0x0051
            com.paytm.android.chat.data.repository.datastores.ChatLocalChannelDataStore r10 = new com.paytm.android.chat.data.repository.datastores.ChatLocalChannelDataStore
            com.paytm.android.chat.data.db.room.DBManager r13 = com.paytm.android.chat.data.db.room.DBManager.INSTANCE
            com.paytm.android.chat.data.db.room.ChatDB r13 = r13.getDb()
            com.paytm.android.chat.data.db.room.dao.ChatMessageDao r3 = r13.chatMessageDao()
            com.paytm.android.chat.data.db.room.DBManager r13 = com.paytm.android.chat.data.db.room.DBManager.INSTANCE
            com.paytm.android.chat.data.db.room.ChatDB r13 = r13.getDb()
            com.paytm.android.chat.data.db.room.dao.ChatChannelDao r4 = r13.chatChannelDao()
            com.paytm.android.chat.data.db.room.DBManager r13 = com.paytm.android.chat.data.db.room.DBManager.INSTANCE
            com.paytm.android.chat.data.db.room.ChatDB r13 = r13.getDb()
            com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao r5 = r13.chatChannelUserDao()
            com.paytm.android.chat.data.db.room.DBManager r13 = com.paytm.android.chat.data.db.room.DBManager.INSTANCE
            com.paytm.android.chat.data.db.room.ChatDB r13 = r13.getDb()
            r6 = r13
            androidx.room.j r6 = (androidx.room.j) r6
            r1 = r10
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            com.paytm.android.chat.data.repository.datastores.ChatChannelDataStore r10 = (com.paytm.android.chat.data.repository.datastores.ChatChannelDataStore) r10
        L_0x0051:
            r12 = r12 & 8
            if (r12 == 0) goto L_0x0057
            com.paytm.android.chat.utils.SharedPreferencesUtil r11 = com.paytm.android.chat.utils.SharedPreferencesUtil.INSTANCE
        L_0x0057:
            r7.<init>(r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.repository.RPCChatRepository.<init>(com.paytm.android.chat.data.repository.datastores.IPCRemoteDS, com.paytm.android.chat.data.repository.datastores.ChatLocalUsersDataStore, com.paytm.android.chat.data.repository.datastores.ChatChannelDataStore, com.paytm.android.chat.utils.SharedPreferencesUtil, int, kotlin.g.b.g):void");
    }

    public final ChatLocalUsersDataStore getUsersDataStore() {
        return this.localUsersDataStore;
    }

    public final GroupChannel getSendbirdChannel(String str) {
        return this.localChannelDataStore.getSendbirdChannel(str);
    }

    public final io.reactivex.rxjava3.a.h<List<ChatGroupChannelDataModel>> getAllLocalChannels() {
        return this.localChannelDataStore.getAllChatGroupChannels();
    }

    public final y<Integer> getLocalChannelCount() {
        return this.localChannelDataStore.getChannelCount();
    }

    public final l<ChatGroupChannelDataModel> getLocalChannelById(String str) {
        k.c(str, "channelUrl");
        return this.localChannelDataStore.getChannelByIdentifier(str);
    }

    public final ChatGroupChannelDataModel getLocalChannelByIdBlocking(String str) {
        k.c(str, "channelUrl");
        try {
            return getLocalChannelById(str).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a();
        } catch (Throwable unused) {
            q.c("getLocalChannelByIdBlocking");
            return null;
        }
    }

    public final io.reactivex.rxjava3.a.h<List<ChatGroupChannelDataModel>> getLocalChannelsForDisplay() {
        return this.localChannelDataStore.getChannelsForDisplay();
    }

    public final void updateLocalChannel(BaseChannel baseChannel) {
        k.c(baseChannel, "channel");
        this.localChannelDataStore.updateChannel(baseChannel);
    }

    public final io.reactivex.rxjava3.a.b updateLocalChannel(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "channel");
        return this.localChannelDataStore.updateChannel(chatGroupChannelDataModel);
    }

    public final io.reactivex.rxjava3.a.b updateLocalChannel(List<ChatGroupChannelDataModel> list) {
        k.c(list, "channels");
        return this.localChannelDataStore.updateChatChannels(list);
    }

    /* renamed from: updateLocalChannel  reason: collision with other method in class */
    public final void m513updateLocalChannel(List<? extends BaseChannel> list) {
        k.c(list, "channels");
        this.localChannelDataStore.updateChannels(list);
    }

    public final ChatGroupChannelDataModel updateChannelFromCreateChannelApi(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2, Map<String, ? extends UsersInfoJsonBean> map, BaseChannel baseChannel) {
        k.c(chatPayeeUser, "sender");
        k.c(chatPayeeUser2, "receiver");
        k.c(map, "userMap");
        k.c(baseChannel, "channel");
        return this.localChannelDataStore.updateChannelFromCreateChannelApi(chatPayeeUser, chatPayeeUser2, map, baseChannel);
    }

    public final void deleteLocalChannel(String str) {
        k.c(str, "identifier");
        this.localChannelDataStore.deleteChannel(str);
    }

    public final void updateDraftMessageForLocalChannel(String str, String str2) {
        k.c(str, "identifier");
        this.localChannelDataStore.updateDraftMessageForChannel(str, str2);
    }

    public final void updateLocalChannelPinnedState(String str, boolean z) {
        k.c(str, "identifier");
        this.localChannelDataStore.updateChannelPinnedState(str, z);
    }

    public final y<Integer> totalPinnedLocalChannelCount() {
        return this.localChannelDataStore.totalPinnedChannelCount();
    }

    public final io.reactivex.rxjava3.a.h<Integer> observeUnreadCountOnLocalChannels() {
        return this.localChannelDataStore.observeUnreadCountOnChannels();
    }

    public final ChatUserEntity constructChatUserEntity(String str, UsersInfoJsonBean usersInfoJsonBean) {
        k.c(str, "sendbirdId");
        k.c(usersInfoJsonBean, "userInfo");
        return CPCDataMapperKt.mapUserInfoBeanToUserEntity(str, usersInfoJsonBean);
    }

    public final ChatGroupChannelDataModel locateChannelBetweenTwoUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2) {
        k.c(chatPayeeUser, "sender");
        k.c(chatPayeeUser2, "receiver");
        return this.localChannelDataStore.locateChannelBetweenTwoUsers(chatPayeeUser, chatPayeeUser2);
    }

    public final ChatUserDataModel getUserBySendbirdId(String str) {
        k.c(str, "sendbirdId");
        return this.localUsersDataStore.getUserBySendbirdId(str);
    }

    public final ChatUserDataModel getUserByIdentifier(String str) {
        k.c(str, "identifier");
        return this.localUsersDataStore.getUserByIdentifier(str);
    }

    public final ChatUserDataModel getUserByAnyId(String str) {
        k.c(str, "uniqueId");
        return this.localUsersDataStore.getUserByAnyId(str);
    }

    public final void updateUserThroughChatUserModel(List<ChatUserDataModel> list) {
        k.c(list, "list");
        this.localUsersDataStore.updateUserThroughChatUserModel(list);
    }

    public final ChatUserDataModel constructChatUserDataModelFromMember(Member member) {
        k.c(member, StringSet.member);
        return this.localUsersDataStore.constructChatUserDataModelFromMember(member);
    }

    public final ChatUserDataModel constructChatUserFromChatEntity(ChatUserEntity chatUserEntity) {
        k.c(chatUserEntity, "chatUserEntity");
        return this.localUsersDataStore.constructChatUserFromUserEntity(chatUserEntity);
    }

    public final void updateUsersThroughEntity(List<ChatUserEntity> list) {
        k.c(list, "list");
        this.localUsersDataStore.updateUsersThroughEntity(list);
    }

    public final ChatGroupChannelDataModel offlineCreateFakeChannelBetweenUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2) {
        k.c(chatPayeeUser, "sender");
        k.c(chatPayeeUser2, "receiver");
        return this.localChannelDataStore.offlineCreateFakeChannelBetweenUsers(chatPayeeUser, chatPayeeUser2);
    }

    public final p<Datawrapper<UserMessage>> sendMessage(ChatGroupChannelDataModel chatGroupChannelDataModel, UserMessageParams userMessageParams) {
        return this.remoteDS.sendMessage(chatGroupChannelDataModel, userMessageParams);
    }

    public final List<ChatUserDataModel> getOtherMembers(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "mChannel");
        return this.remoteDS.getOtherMembers(chatGroupChannelDataModel);
    }

    public final ChatUserDataModel getOtherMember(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "mChannel");
        return this.remoteDS.getOtherMember(chatGroupChannelDataModel);
    }

    public final y<ChatGroupChannelDataModel> fetchChannelForDisplay(String str) {
        k.c(str, "channelUrl");
        y<ChatGroupChannelDataModel> b2 = getLocalChannelById(str).a(this.remoteDS.fetchSendBirdChannel(str).b(new b(this))).b(io.reactivex.rxjava3.i.a.b());
        k.a((Object) b2, "getLocalChannelById(chan…scribeOn(Schedulers.io())");
        return b2;
    }

    static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f41978a;

        a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
            this.f41978a = chatGroupChannelDataModel;
        }

        public final void a(final c cVar) {
            Long oldestMessageTsForChannel = MessageDBHelperKt.getOldestMessageTsForChannel(this.f41978a.getChannelUrl());
            if (oldestMessageTsForChannel != null) {
                com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
                GroupChannel a2 = com.paytm.android.chat.d.a.a.a(this.f41978a.getChannelUrl());
                if (a2 != null) {
                    a2.getMessageChangeLogsByTimestamp(oldestMessageTsForChannel.longValue(), new BaseChannel.GetMessageChangeLogsHandler() {
                        public final void onResult(List<BaseMessage> list, List<Long> list2, boolean z, String str, SendBirdException sendBirdException) {
                            if (sendBirdException != null) {
                                c cVar = cVar;
                                k.a((Object) cVar, "emitter");
                                if (!cVar.isDisposed()) {
                                    cVar.onError(sendBirdException);
                                    return;
                                }
                            }
                            if (list2 != null && list2.size() > 0) {
                                MessageDBHelperKt.bulkDeleteMessage(list2);
                                c cVar2 = cVar;
                                k.a((Object) cVar2, "emitter");
                                if (!cVar2.isDisposed()) {
                                    cVar.onComplete();
                                }
                            }
                        }
                    });
                }
            }
            k.a((Object) cVar, "emitter");
            if (!cVar.isDisposed()) {
                cVar.onComplete();
            }
        }
    }

    public final io.reactivex.rxjava3.a.b fetchAndUpdateDeletedMessages(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "channel");
        io.reactivex.rxjava3.a.b a2 = io.reactivex.rxjava3.a.b.a((e) new a(chatGroupChannelDataModel));
        k.a((Object) a2, "Completable.create { emi…er.onComplete()\n        }");
        return a2;
    }

    public final io.reactivex.rxjava3.a.h<Datawrapper<CPCSendbirdWrapper.ConnectionStatus>> listenConnectionManagement(String str, String str2) {
        k.c(str, "userId");
        k.c(str2, "handlerId");
        return this.remoteDS.listenConnectionManagement(str, str2);
    }

    public final io.reactivex.rxjava3.a.h<Datawrapper<CPCSendbirdWrapper.ConnectionStatus>> listenConnectionManagement(String str) {
        k.c(str, "handlerId");
        return this.remoteDS.listenConnectionManagement(SharedPreferencesUtil.getUserId(), str);
    }

    public final io.reactivex.rxjava3.a.h<CPCSendbirdWrapper.ChannelUpdate> addChannelObserver(String str) {
        k.c(str, "handlerId");
        return this.remoteDS.addChannelObserver(str);
    }

    public final p<Datawrapper<UserMessage>> resendUserMessage(BaseChannel baseChannel, UserMessage userMessage) {
        k.c(baseChannel, "channel");
        return this.remoteDS.resendUserMessage(baseChannel, userMessage);
    }

    public final p<Datawrapper<FileMessage>> resendFileMessage(BaseChannel baseChannel, FileMessage fileMessage, File file) {
        k.c(baseChannel, "channel");
        return this.remoteDS.resendFileMessage(baseChannel, fileMessage, file);
    }

    public final io.reactivex.rxjava3.a.b logout(boolean z) {
        return this.remoteDS.logout(z, SharedPreferencesUtil.getSBToken());
    }

    public final y<CPCSendbirdWrapper.ConnectionStatus> chatLogin(UserInfoBean userInfoBean) {
        k.c(userInfoBean, "bean");
        String userId = userInfoBean.getUserId();
        k.a((Object) userId, "bean.userId");
        return chatLogin(userId, userInfoBean.getNickname(), userInfoBean.getPhoneNumber(), userInfoBean.getProfileUrl(), userInfoBean.getToken(), userInfoBean.getAccessToken());
    }

    public final y<CPCSendbirdWrapper.ConnectionStatus> chatLogin(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "userId");
        this.remoteDS.setAutoBackgroundDetection(true);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_NAME, str2);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_MOBILE_NUMBER, str3);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_IMG, str4);
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_TOKEN, str5);
        q.b("PFChatLogin: ".concat(String.valueOf(str6)));
        return this.remoteDS.login(str, str2, str4, str6);
    }

    public final io.reactivex.rxjava3.a.b registPushToken() {
        return this.remoteDS.registPushToken();
    }

    public final io.reactivex.rxjava3.a.b updateCurrentUserProfileImage(File file) {
        return this.remoteDS.updateCurrentUserProfileImage(file);
    }

    public final y<User> getUserInfo(String str) {
        k.c(str, "userId");
        return this.remoteDS.getUserInfo(str);
    }

    public final y<User> getUserInfo() {
        return getUserInfo(SharedPreferencesUtil.getUserId());
    }

    public final y<List<User>> getBlockedUserList() {
        return this.remoteDS.getBlockedUserList();
    }

    public final void reConnectAsync() {
        this.remoteDS.reConnectAsync();
    }

    public final y<CPCSendbirdWrapper.ConnectionStatus> reConnect() {
        return this.remoteDS.reConnect();
    }

    public final io.reactivex.rxjava3.a.b unblockUser(String str) {
        k.c(str, "userId");
        return this.remoteDS.unblockUser(str);
    }

    public final boolean isSenbirdWSConnected() {
        return this.remoteDS.isSenbirdWSConnected();
    }

    public final y<List<ChatGroupChannelDataModel>> fetchChannelList() {
        return this.remoteDS.fetchChannelList();
    }

    public final io.reactivex.rxjava3.a.b setChannelPushPreferences(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z) {
        k.c(chatGroupChannelDataModel, "channel");
        return this.remoteDS.setChannelPushPreferences(chatGroupChannelDataModel, z);
    }

    public final void markAsDelivered(String str) {
        k.c(str, "channelUrl");
        this.remoteDS.markAsDelivered(str);
    }

    public final y<GroupChannel> getSendbirdGroupChannel(String str) {
        k.c(str, "channelUrl");
        return this.remoteDS.getSendbirdGroupChannel(str);
    }
}
