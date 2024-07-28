package com.paytm.android.chat.data.repository.datastores;

import com.google.firebase.iid.FirebaseInstanceId;
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
import kotlin.g.b.k;

public final class DPCRemoteDS implements IPCRemoteDS {
    private final IPCFirebaseInstanceIdWrapper firebaseInstanceId;
    private final CPCSendbirdWrapper sendbirdWrapper;

    public DPCRemoteDS(CPCSendbirdWrapper cPCSendbirdWrapper, IPCFirebaseInstanceIdWrapper iPCFirebaseInstanceIdWrapper) {
        k.c(cPCSendbirdWrapper, "sendbirdWrapper");
        k.c(iPCFirebaseInstanceIdWrapper, "firebaseInstanceId");
        this.sendbirdWrapper = cPCSendbirdWrapper;
        this.firebaseInstanceId = iPCFirebaseInstanceIdWrapper;
    }

    public final y<CPCSendbirdWrapper.ConnectionStatus> login(String str, String str2, String str3, String str4) {
        k.c(str, "userId");
        return this.sendbirdWrapper.login(str, str2, str3, str4);
    }

    public final b registPushToken() {
        String str;
        try {
            str = FirebaseInstanceId.a().g();
        } catch (Exception unused) {
            str = null;
        }
        return this.sendbirdWrapper.registPushTokenToSendbird(str);
    }

    public final b logout(boolean z, String str) {
        k.c(str, "sendBirdToken");
        return this.sendbirdWrapper.logout(z, str);
    }

    public final void disConnectAsync() {
        this.sendbirdWrapper.disConnectAsync();
    }

    public final b disConnect() {
        return this.sendbirdWrapper.disConnect();
    }

    public final void reConnectAsync() {
        this.sendbirdWrapper.reConnectAsync();
    }

    public final y<CPCSendbirdWrapper.ConnectionStatus> reConnect() {
        return this.sendbirdWrapper.reConnect();
    }

    public final boolean isSenbirdWSConnected() {
        return this.sendbirdWrapper.isSenbirdWSConnected();
    }

    public final void setAutoBackgroundDetection(boolean z) {
        this.sendbirdWrapper.setAutoBackgroundDetection(z);
    }

    public final y<Boolean> isPushEnabled(String str) {
        k.c(str, "channelUrl");
        return this.sendbirdWrapper.isPushEnabled(str);
    }

    public final y<ChatGroupChannelDataModel> fetchSendBirdChannel(String str) {
        k.c(str, "channelUrl");
        return this.sendbirdWrapper.fetchSendBirdChannel(str);
    }

    public final y<List<ChatGroupChannelDataModel>> fetchChannelList() {
        return this.sendbirdWrapper.fetchChannelList();
    }

    public final b setChannelPushPreferences(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z) {
        k.c(chatGroupChannelDataModel, "channel");
        return this.sendbirdWrapper.setChannelPushPreferences(chatGroupChannelDataModel, z);
    }

    public final h<CPCSendbirdWrapper.ChannelUpdate> addChannelObserver(String str) {
        return this.sendbirdWrapper.addChannelObserver(str);
    }

    public final b updateCurrentUserProfileImage(File file) {
        return this.sendbirdWrapper.updateCurrentUserProfileImage(file);
    }

    public final y<List<User>> getUsersInfo(List<String> list) {
        k.c(list, "userIds");
        return this.sendbirdWrapper.getUsersInfo(list);
    }

    public final y<User> getUserInfo(String str) {
        k.c(str, "userId");
        return this.sendbirdWrapper.getUserInfo(str);
    }

    public final y<List<User>> getBlockedUserList() {
        return this.sendbirdWrapper.getBlockedUserList();
    }

    public final b unblockUser(String str) {
        k.c(str, "userId");
        return this.sendbirdWrapper.unblockUser(str);
    }

    public final List<ChatUserDataModel> getOtherMembers(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "mChannel");
        return this.sendbirdWrapper.getOtherMembers(chatGroupChannelDataModel);
    }

    public final ChatUserDataModel getOtherMember(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "mChannel");
        return this.sendbirdWrapper.getOtherMember(chatGroupChannelDataModel);
    }

    public final p<Datawrapper<UserMessage>> sendMessage(ChatGroupChannelDataModel chatGroupChannelDataModel, UserMessageParams userMessageParams) {
        return this.sendbirdWrapper.sendMessage(chatGroupChannelDataModel, userMessageParams);
    }

    public final p<Datawrapper<UserMessage>> resendUserMessage(BaseChannel baseChannel, UserMessage userMessage) {
        k.c(baseChannel, "channel");
        return this.sendbirdWrapper.resendUserMessage(baseChannel, userMessage);
    }

    public final p<Datawrapper<FileMessage>> resendFileMessage(BaseChannel baseChannel, FileMessage fileMessage, File file) {
        k.c(baseChannel, "channel");
        return this.sendbirdWrapper.resendFileMessage(baseChannel, fileMessage, file);
    }

    public final void markAsDelivered(String str) {
        this.sendbirdWrapper.markAsDelivered(str);
    }

    public final h<Datawrapper<CPCSendbirdWrapper.ConnectionStatus>> listenConnectionManagement(String str, String str2) {
        k.c(str, "userId");
        k.c(str2, "handlerId");
        return this.sendbirdWrapper.listenConnectionManagement(str, str2);
    }

    public final y<GroupChannel> getSendbirdGroupChannel(String str) {
        k.c(str, "channelUrl");
        return this.sendbirdWrapper.getSendbirdGroupChannel(str);
    }
}
