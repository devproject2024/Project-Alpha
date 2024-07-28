package com.paytm.android.chat.data.repository.datastores;

import com.imsdk.CPCSendbirdWrapper;
import com.imsdk.Datawrapper;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import com.sendbird.android.UserMessageParams;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.y;
import java.io.File;
import java.util.List;

public interface IPCRemoteDS {
    h<CPCSendbirdWrapper.ChannelUpdate> addChannelObserver(String str);

    b disConnect();

    void disConnectAsync();

    y<List<ChatGroupChannelDataModel>> fetchChannelList();

    y<ChatGroupChannelDataModel> fetchSendBirdChannel(String str);

    y<List<User>> getBlockedUserList();

    ChatUserDataModel getOtherMember(ChatGroupChannelDataModel chatGroupChannelDataModel);

    List<ChatUserDataModel> getOtherMembers(ChatGroupChannelDataModel chatGroupChannelDataModel);

    y<GroupChannel> getSendbirdGroupChannel(String str);

    y<User> getUserInfo(String str);

    y<List<User>> getUsersInfo(List<String> list);

    y<Boolean> isPushEnabled(String str);

    boolean isSenbirdWSConnected();

    h<Datawrapper<CPCSendbirdWrapper.ConnectionStatus>> listenConnectionManagement(String str, String str2);

    y<CPCSendbirdWrapper.ConnectionStatus> login(String str, String str2, String str3, String str4);

    b logout(boolean z, String str);

    void markAsDelivered(String str);

    y<CPCSendbirdWrapper.ConnectionStatus> reConnect();

    void reConnectAsync();

    b registPushToken();

    p<Datawrapper<FileMessage>> resendFileMessage(BaseChannel baseChannel, FileMessage fileMessage, File file);

    p<Datawrapper<UserMessage>> resendUserMessage(BaseChannel baseChannel, UserMessage userMessage);

    p<Datawrapper<UserMessage>> sendMessage(ChatGroupChannelDataModel chatGroupChannelDataModel, UserMessageParams userMessageParams);

    void setAutoBackgroundDetection(boolean z);

    b setChannelPushPreferences(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z);

    b unblockUser(String str);

    b updateCurrentUserProfileImage(File file);
}
