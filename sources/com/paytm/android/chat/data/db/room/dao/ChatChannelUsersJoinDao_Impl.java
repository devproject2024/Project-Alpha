package com.paytm.android.chat.data.db.room.dao;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.room.rxjava3.b;
import androidx.sqlite.db.f;
import com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao;
import com.paytm.android.chat.data.db.room.db_entities.ChatChannelUsersJoinEntity;
import io.reactivex.rxjava3.a.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class ChatChannelUsersJoinDao_Impl implements ChatChannelUsersJoinDao {
    /* access modifiers changed from: private */
    public final j __db;
    private final c<ChatChannelUsersJoinEntity> __insertionAdapterOfChatChannelUsersJoinEntity;
    private final q __preparedStmtOfDeleteAllChannelUsers;
    private final q __preparedStmtOfDeleteChannelUser;

    public ChatChannelUsersJoinDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfChatChannelUsersJoinEntity = new c<ChatChannelUsersJoinEntity>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `ChatChannelUsersJoinEntity` (`entryId`,`channelUrl`,`uniqueId`) VALUES (nullif(?, 0),?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                ChatChannelUsersJoinEntity chatChannelUsersJoinEntity = (ChatChannelUsersJoinEntity) obj;
                fVar.a(1, chatChannelUsersJoinEntity.getEntryId());
                if (chatChannelUsersJoinEntity.getChannelUrl() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, chatChannelUsersJoinEntity.getChannelUrl());
                }
                if (chatChannelUsersJoinEntity.getUniqueId() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, chatChannelUsersJoinEntity.getUniqueId());
                }
            }
        };
        this.__preparedStmtOfDeleteChannelUser = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatChannelUsersJoinEntity WHERE channelUrl = ?";
            }
        };
        this.__preparedStmtOfDeleteAllChannelUsers = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ChatChannelUsersJoinEntity";
            }
        };
    }

    public final void insert(ChatChannelUsersJoinEntity chatChannelUsersJoinEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfChatChannelUsersJoinEntity.insert(chatChannelUsersJoinEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void upsert(List<ChatChannelUsersJoinEntity> list) {
        this.__db.beginTransaction();
        try {
            ChatChannelUsersJoinDao.DefaultImpls.upsert(this, list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void deleteChannelUser(String str) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteChannelUser.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteChannelUser.release(acquire);
        }
    }

    public final void deleteAllChannelUsers() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteAllChannelUsers.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllChannelUsers.release(acquire);
        }
    }

    public final h<List<ChatChannelUsersJoinEntity>> getAllChannelUsers() {
        final m a2 = m.a("SELECT * FROM ChatChannelUsersJoinEntity", 0);
        return b.a(this.__db, new String[]{"ChatChannelUsersJoinEntity"}, new Callable<List<ChatChannelUsersJoinEntity>>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public List<ChatChannelUsersJoinEntity> call() throws Exception {
                Cursor a2 = androidx.room.b.c.a(ChatChannelUsersJoinDao_Impl.this.__db, a2, false);
                try {
                    int b2 = androidx.room.b.b.b(a2, "entryId");
                    int b3 = androidx.room.b.b.b(a2, "channelUrl");
                    int b4 = androidx.room.b.b.b(a2, "uniqueId");
                    ArrayList arrayList = new ArrayList(a2.getCount());
                    while (a2.moveToNext()) {
                        ChatChannelUsersJoinEntity chatChannelUsersJoinEntity = new ChatChannelUsersJoinEntity();
                        chatChannelUsersJoinEntity.setEntryId(a2.getLong(b2));
                        chatChannelUsersJoinEntity.setChannelUrl(a2.getString(b3));
                        chatChannelUsersJoinEntity.setUniqueId(a2.getString(b4));
                        arrayList.add(chatChannelUsersJoinEntity);
                    }
                    return arrayList;
                } finally {
                    a2.close();
                }
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    public final ChatChannelUsersJoinEntity getChannelForUniqueId(String str) {
        ChatChannelUsersJoinEntity chatChannelUsersJoinEntity;
        m a2 = m.a("SELECT * FROM ChatChannelUsersJoinEntity WHERE uniqueId = ?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, "entryId");
            int b3 = androidx.room.b.b.b(a3, "channelUrl");
            int b4 = androidx.room.b.b.b(a3, "uniqueId");
            if (a3.moveToFirst()) {
                chatChannelUsersJoinEntity = new ChatChannelUsersJoinEntity();
                chatChannelUsersJoinEntity.setEntryId(a3.getLong(b2));
                chatChannelUsersJoinEntity.setChannelUrl(a3.getString(b3));
                chatChannelUsersJoinEntity.setUniqueId(a3.getString(b4));
            } else {
                chatChannelUsersJoinEntity = null;
            }
            return chatChannelUsersJoinEntity;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
