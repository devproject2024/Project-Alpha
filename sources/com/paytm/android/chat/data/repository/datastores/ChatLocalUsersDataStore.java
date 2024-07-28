package com.paytm.android.chat.data.repository.datastores;

import com.paytm.android.chat.data.db.room.DBManager;
import com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao;
import com.paytm.android.chat.data.db.room.dao.ChatUserDao;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.mappers.CPCDataMapperKt;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.utility.q;
import com.sendbird.android.Member;
import com.sendbird.android.constant.StringSet;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.x;

public final class ChatLocalUsersDataStore implements ChatUsersDataStore {
    /* access modifiers changed from: private */
    public final String TAG = "ChatLocalUsersDataStore";
    private final h<List<ChatUserEntity>> allUsersDBFlowable = this.chatUserDao.getAllChatUsers();
    private final ChatChannelUsersJoinDao chatChannelUsersJoinDao;
    private final ChatUserDao chatUserDao;

    static final class b<T> implements g<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f42017a = new b();

        b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public ChatLocalUsersDataStore(ChatUserDao chatUserDao2, ChatChannelUsersJoinDao chatChannelUsersJoinDao2) {
        k.c(chatUserDao2, "chatUserDao");
        k.c(chatChannelUsersJoinDao2, "chatChannelUsersJoinDao");
        this.chatUserDao = chatUserDao2;
        this.chatChannelUsersJoinDao = chatChannelUsersJoinDao2;
    }

    public final void updateUsers(Member member) {
        k.c(member, StringSet.member);
        updateUsers((List<? extends Member>) kotlin.a.k.a(member));
    }

    public final void updateUsersThroughEntity(List<ChatUserEntity> list) {
        k.c(list, "list");
        if (!list.isEmpty()) {
            this.chatUserDao.upsert(list);
        }
    }

    public final void updateUserThroughChatUserModel(List<ChatUserDataModel> list) {
        k.c(list, "list");
        if (!list.isEmpty()) {
            ChatUserDao chatUserDao2 = this.chatUserDao;
            Iterable<ChatUserDataModel> iterable = list;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (ChatUserDataModel mapChatUserToUserEntity : iterable) {
                arrayList.add(CPCDataMapperKt.mapChatUserToUserEntity(mapChatUserToUserEntity));
            }
            chatUserDao2.upsert((List) arrayList);
        }
    }

    public final void updateUsers(List<? extends Member> list) {
        k.c(list, "list");
        if (!list.isEmpty()) {
            ChatUserDao chatUserDao2 = this.chatUserDao;
            Iterable<Member> iterable = list;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (Member mapMemberToUserEntity : iterable) {
                arrayList.add(CPCDataMapperKt.mapMemberToUserEntity(mapMemberToUserEntity));
            }
            chatUserDao2.upsert((List) arrayList);
        }
    }

    public final void updateUsersDataModel(List<ChatUserDataModel> list) {
        k.c(list, "list");
        if (!list.isEmpty()) {
            ChatUserDao chatUserDao2 = this.chatUserDao;
            Iterable<ChatUserDataModel> iterable = list;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (ChatUserDataModel mapChatUserToUserEntity : iterable) {
                arrayList.add(CPCDataMapperKt.mapChatUserToUserEntity(mapChatUserToUserEntity));
            }
            chatUserDao2.upsert((List) arrayList);
        }
    }

    public final void updateUsersWithOurModels(List<ChatUserDataModel> list) {
        k.c(list, "list");
        if (!list.isEmpty()) {
            ChatUserDao chatUserDao2 = this.chatUserDao;
            Iterable<ChatUserDataModel> iterable = list;
            Collection arrayList = new ArrayList(kotlin.a.k.a(iterable));
            for (ChatUserDataModel mapChatUserToUserEntity : iterable) {
                arrayList.add(CPCDataMapperKt.mapChatUserToUserEntity(mapChatUserToUserEntity));
            }
            chatUserDao2.upsert((List) arrayList);
        }
    }

    public final void deleteUsers(Member member) {
        k.c(member, StringSet.member);
        deleteUsers((List<? extends Member>) kotlin.a.k.a(member));
    }

    public final void deleteUsers(List<? extends Member> list) {
        k.c(list, "list");
        y.a(new a(list)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(b.f42017a, (g<? super Throwable>) new c(this));
    }

    public final List<ChatUserDataModel> getChatUsersFromMembers(List<? extends Member> list) {
        k.c(list, "list");
        Collection arrayList = new ArrayList();
        for (Member userId : list) {
            String userId2 = userId.getUserId();
            k.a((Object) userId2, "member.userId");
            ChatUserDataModel userByAnyId = getUserByAnyId(userId2);
            if (userByAnyId != null) {
                arrayList.add(userByAnyId);
            }
        }
        return (List) arrayList;
    }

    public final ChatUserDataModel constructChatUserDataModelFromMember(Member member) {
        k.c(member, StringSet.member);
        return constructChatUserFromUserEntity(constructChatUserEntityFromMember(member));
    }

    private final ChatUserEntity constructChatUserEntityFromMember(Member member) {
        return CPCDataMapperKt.mapMemberToUserEntity(member);
    }

    public final ChatUserDataModel constructChatUserFromUserEntity(ChatUserEntity chatUserEntity) {
        k.c(chatUserEntity, "chatUserEntity");
        return CPCDataMapperKt.mapUserEntityToChatUser(chatUserEntity);
    }

    public final ChatUserDataModel getUserBySendbirdId(String str) {
        k.c(str, "sendbirdId");
        ChatUserEntity chatUserBySendbirdId = this.chatUserDao.getChatUserBySendbirdId(str);
        if (chatUserBySendbirdId != null) {
            return constructChatUserFromUserEntity(chatUserBySendbirdId);
        }
        return null;
    }

    public final ChatUserDataModel getUserByIdentifier(String str) {
        k.c(str, "identifier");
        ChatUserEntity chatUserByIdentifier = this.chatUserDao.getChatUserByIdentifier(str);
        if (chatUserByIdentifier != null) {
            return constructChatUserFromUserEntity(chatUserByIdentifier);
        }
        return null;
    }

    public final ChatUserDataModel getUserByAnyId(String str) {
        k.c(str, "uniqueId");
        ChatUserDataModel userBySendbirdId = getUserBySendbirdId(str);
        return userBySendbirdId == null ? getUserByIdentifier(str) : userBySendbirdId;
    }

    static final class a<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f42015a;

        a(List list) {
            this.f42015a = list;
        }

        public final /* synthetic */ Object call() {
            if (!this.f42015a.isEmpty()) {
                y.a(new Callable<T>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f42016a;

                    {
                        this.f42016a = r1;
                    }

                    public final /* synthetic */ Object call() {
                        for (Member userId : this.f42016a.f42015a) {
                            ChatUserDao chatUserDao = DBManager.INSTANCE.getDb().chatUserDao();
                            String userId2 = userId.getUserId();
                            k.a((Object) userId2, "member.userId");
                            chatUserDao.deleteChatUser(userId2);
                        }
                        return x.f47997a;
                    }
                });
            }
            return x.f47997a;
        }
    }

    static final class c<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatLocalUsersDataStore f42018a;

        c(ChatLocalUsersDataStore chatLocalUsersDataStore) {
            this.f42018a = chatLocalUsersDataStore;
        }

        public final /* synthetic */ void accept(Object obj) {
            String unused = this.f42018a.TAG;
            q.c("deletemembers");
        }
    }
}
