package com.paytm.android.chat.data.db.room.dao;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.room.rxjava3.b;
import androidx.sqlite.db.f;
import com.paytm.android.chat.data.db.room.db_entities.SendbirdNotificationEntity;
import com.sendbird.android.constant.StringSet;
import io.reactivex.rxjava3.a.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class SendbirdNotificationDao_Impl implements SendbirdNotificationDao {
    /* access modifiers changed from: private */
    public final j __db;
    private final c<SendbirdNotificationEntity> __insertionAdapterOfSendbirdNotificationEntity;
    private final q __preparedStmtOfClearAllEntry;

    public SendbirdNotificationDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfSendbirdNotificationEntity = new c<SendbirdNotificationEntity>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `SendbirdNotification` (`id`,`channel_url`,`payload`) VALUES (?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                SendbirdNotificationEntity sendbirdNotificationEntity = (SendbirdNotificationEntity) obj;
                if (sendbirdNotificationEntity.getId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, sendbirdNotificationEntity.getId());
                }
                if (sendbirdNotificationEntity.getChannelUrl() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, sendbirdNotificationEntity.getChannelUrl());
                }
                if (sendbirdNotificationEntity.getPayload() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, sendbirdNotificationEntity.getPayload());
                }
            }
        };
        this.__preparedStmtOfClearAllEntry = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM SendbirdNotification";
            }
        };
    }

    public final void addEntry(SendbirdNotificationEntity sendbirdNotificationEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSendbirdNotificationEntity.insert(sendbirdNotificationEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void clearAllEntry() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfClearAllEntry.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearAllEntry.release(acquire);
        }
    }

    public final h<Integer> getAllNotificationCountFlowable() {
        final m a2 = m.a("SELECT COUNT(*) FROM SendbirdNotification", 0);
        return b.a(this.__db, new String[]{"SendbirdNotification"}, new Callable<Integer>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Integer call() throws Exception {
                Cursor a2 = androidx.room.b.c.a(SendbirdNotificationDao_Impl.this.__db, a2, false);
                try {
                    Integer num = null;
                    if (a2.moveToFirst()) {
                        if (!a2.isNull(0)) {
                            num = Integer.valueOf(a2.getInt(0));
                        }
                    }
                    return num;
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

    public final List<SendbirdNotificationEntity> getAllNotification() {
        m a2 = m.a("SELECT * FROM SendbirdNotification", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, "id");
            int b3 = androidx.room.b.b.b(a3, StringSet.channel_url);
            int b4 = androidx.room.b.b.b(a3, "payload");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                SendbirdNotificationEntity sendbirdNotificationEntity = new SendbirdNotificationEntity();
                sendbirdNotificationEntity.setId(a3.getString(b2));
                sendbirdNotificationEntity.setChannelUrl(a3.getString(b3));
                sendbirdNotificationEntity.setPayload(a3.getString(b4));
                arrayList.add(sendbirdNotificationEntity);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
