package com.paytm.android.chat.data.repository.datastores;

import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.data.db.room.db_entities.ChatChannelUsersJoinEntity;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.GroupChannel;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.y;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser;

public interface ChatChannelDataStore {
    void deleteChannel(String str);

    h<List<ChatGroupChannelDataModel>> getAllChatGroupChannels();

    l<ChatGroupChannelDataModel> getChannelByIdentifier(String str);

    y<Integer> getChannelCount();

    h<List<ChatGroupChannelDataModel>> getChannelsForDisplay();

    List<ChatChannelUsersJoinEntity> getJointChannelEntitiesWithParticipantKey(List<ChatGroupChannelDataModel> list);

    List<ChatChannelUsersJoinEntity> getJointEntitiesWithParticipantKey(List<? extends BaseChannel> list);

    GroupChannel getSendbirdChannel(String str);

    ChatGroupChannelDataModel locateChannelBetweenTwoUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2);

    h<Integer> observeUnreadCountOnChannels();

    ChatGroupChannelDataModel offlineCreateFakeChannelBetweenUsers(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2);

    void offlineUpdateChannelWithOurModel(ChatGroupChannelDataModel chatGroupChannelDataModel);

    void offlineUpdateChannelsWithOurModel(List<ChatGroupChannelDataModel> list);

    y<Integer> totalPinnedChannelCount();

    ChatGroupChannelDataModel updateAndGetChannel(ChatGroupChannelDataModel chatGroupChannelDataModel);

    b updateChannel(ChatGroupChannelDataModel chatGroupChannelDataModel);

    void updateChannel(BaseChannel baseChannel);

    ChatGroupChannelDataModel updateChannelFromCreateChannelApi(ChatPayeeUser chatPayeeUser, ChatPayeeUser chatPayeeUser2, Map<String, ? extends UsersInfoJsonBean> map, BaseChannel baseChannel);

    void updateChannelPinnedState(String str, boolean z);

    void updateChannels(List<? extends BaseChannel> list);

    b updateChatChannels(List<ChatGroupChannelDataModel> list);

    void updateDraftMessageForChannel(String str, String str2);
}
