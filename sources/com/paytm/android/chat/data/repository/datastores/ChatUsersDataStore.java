package com.paytm.android.chat.data.repository.datastores;

import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.sendbird.android.Member;
import java.util.List;

public interface ChatUsersDataStore {
    ChatUserDataModel constructChatUserDataModelFromMember(Member member);

    ChatUserDataModel constructChatUserFromUserEntity(ChatUserEntity chatUserEntity);

    void deleteUsers(Member member);

    void deleteUsers(List<? extends Member> list);

    List<ChatUserDataModel> getChatUsersFromMembers(List<? extends Member> list);

    ChatUserDataModel getUserByAnyId(String str);

    ChatUserDataModel getUserByIdentifier(String str);

    ChatUserDataModel getUserBySendbirdId(String str);

    void updateUserThroughChatUserModel(List<ChatUserDataModel> list);

    void updateUsers(Member member);

    void updateUsers(List<? extends Member> list);

    void updateUsersDataModel(List<ChatUserDataModel> list);

    void updateUsersThroughEntity(List<ChatUserEntity> list);

    void updateUsersWithOurModels(List<ChatUserDataModel> list);
}
