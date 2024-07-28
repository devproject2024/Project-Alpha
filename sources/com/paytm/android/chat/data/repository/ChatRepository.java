package com.paytm.android.chat.data.repository;

import com.imsdk.CPCSendbirdWrapper;
import com.imsdk.Datawrapper;
import com.paytm.android.chat.bean.UserInfoBean;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.repository.datastores.ChatLocalUsersDataStore;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import com.sendbird.android.UserMessageParams;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.y;
import java.io.File;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser;

public interface ChatRepository {
    h<CPCSendbirdWrapper.ChannelUpdate> addChannelObserver(String str);

    y<CPCSendbirdWrapper.ConnectionStatus> chatLogin(UserInfoBean userInfoBean);

    y<CPCSendbirdWrapper.ConnectionStatus> chatLogin(String str, String str2, String str3, String str4, String str5, String str6);

    ChatUserDataModel constructChatUserDataModelFromMember(Member member);

    ChatUserEntity constructChatUserEntity(String str, UsersInfoJsonBean usersInfoJsonBean);

    ChatUserDataModel constructChatUserFromChatEntity(ChatUserEntity chatUserEntity);

    void deleteLocalChannel(String str);

    b fetchAndUpdateDeletedMessages(ChatGroupChannelDataModel chatGroupChannelDataModel);

    y<ChatGroupChannelDataModel> fetchChannelForDisplay(String str);

    y<List<ChatGroupChannelDataModel>> fetchChannelList();

    h<List<ChatGroupChannelDataModel>> getAllLocalChannels();

    y<List<User>> getBlockedUserList();

    l<ChatGroupChannelDataModel> getLocalChannelById(String str);

    ChatGroupChannelDataModel getLocalChannelByIdBlocking(String str);

    y<Integer> getLocalChannelCount();

    h<List<ChatGroupChannelDataModel>> getLocalChannelsForDisplay();

    ChatUserDataModel getOtherMember(ChatGroupChannelDataModel chatGroupChannelDataModel);

    List<ChatUserDataModel> getOtherMembers(ChatGroupChannelDataModel chatGroupChannelDataModel);

    GroupChannel getSendbirdChannel(String str);

    y<GroupChannel> getSendbirdGroupChannel(String str);

    ChatUserDataModel getUserByAnyId(String str);

    ChatUserDataModel getUserByIdentifier(String str);

    ChatUserDataModel getUserBySendbirdId(String str);

    y<User> getUserInfo();

    y<User> getUserInfo(String str);

    ChatLocalUsersDataStore getUsersDataStore();

    boolean isSenbirdWSConnected();

    h<Datawrapper<CPCSendbirdWrapper.ConnectionStatus>> listenConnectionManagement(String str);

    h<Datawrapper<CPCSendbirdWrapper.ConnectionStatus>> listenConnectionManagement(String str, String str2);

    ChatGroupChannelDataModel locateChannelBetweenTwoUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2);

    b logout(boolean z);

    void markAsDelivered(String str);

    h<Integer> observeUnreadCountOnLocalChannels();

    ChatGroupChannelDataModel offlineCreateFakeChannelBetweenUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2);

    y<CPCSendbirdWrapper.ConnectionStatus> reConnect();

    void reConnectAsync();

    b registPushToken();

    p<Datawrapper<FileMessage>> resendFileMessage(BaseChannel baseChannel, FileMessage fileMessage, File file);

    p<Datawrapper<UserMessage>> resendUserMessage(BaseChannel baseChannel, UserMessage userMessage);

    p<Datawrapper<UserMessage>> sendMessage(ChatGroupChannelDataModel chatGroupChannelDataModel, UserMessageParams userMessageParams);

    b setChannelPushPreferences(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z);

    y<Integer> totalPinnedLocalChannelCount();

    b unblockUser(String str);

    ChatGroupChannelDataModel updateChannelFromCreateChannelApi(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2, Map<String, ? extends UsersInfoJsonBean> map, BaseChannel baseChannel);

    b updateCurrentUserProfileImage(File file);

    void updateDraftMessageForLocalChannel(String str, String str2);

    b updateLocalChannel(ChatGroupChannelDataModel chatGroupChannelDataModel);

    b updateLocalChannel(List<ChatGroupChannelDataModel> list);

    void updateLocalChannel(BaseChannel baseChannel);

    /* renamed from: updateLocalChannel  reason: collision with other method in class */
    void m512updateLocalChannel(List<? extends BaseChannel> list);

    void updateLocalChannelPinnedState(String str, boolean z);

    void updateUserThroughChatUserModel(List<ChatUserDataModel> list);

    void updateUsersThroughEntity(List<ChatUserEntity> list);
}
