package com.paytm.android.chat.data.db.room.dao;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import com.paytm.android.chat.data.db.room.db_entities.UserExtendedMetaDataEntity;
import java.util.ArrayList;
import java.util.List;

public final class UserExtendedMetadataDao_Impl implements UserExtendedMetadataDao {
    private final j __db;
    private final c<UserExtendedMetaDataEntity> __insertionAdapterOfUserExtendedMetaDataEntity;

    public UserExtendedMetadataDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfUserExtendedMetaDataEntity = new c<UserExtendedMetaDataEntity>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `UserExtendedMetaData` (`sendbirdUserId`,`metaDataString`,`updatedAt`) VALUES (?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                UserExtendedMetaDataEntity userExtendedMetaDataEntity = (UserExtendedMetaDataEntity) obj;
                if (userExtendedMetaDataEntity.getSendbirdUserId() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, userExtendedMetaDataEntity.getSendbirdUserId());
                }
                if (userExtendedMetaDataEntity.getMetaDataString() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, userExtendedMetaDataEntity.getMetaDataString());
                }
                if (userExtendedMetaDataEntity.getUpdatedAt() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, userExtendedMetaDataEntity.getUpdatedAt().longValue());
                }
            }
        };
    }

    public final void insertOrReplace(UserExtendedMetaDataEntity userExtendedMetaDataEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfUserExtendedMetaDataEntity.insert(userExtendedMetaDataEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final List<UserExtendedMetaDataEntity> getAllRecord() {
        Long l;
        m a2 = m.a("SELECT * FROM UserExtendedMetaData", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = b.b(a3, "sendbirdUserId");
            int b3 = b.b(a3, "metaDataString");
            int b4 = b.b(a3, "updatedAt");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                UserExtendedMetaDataEntity userExtendedMetaDataEntity = new UserExtendedMetaDataEntity();
                userExtendedMetaDataEntity.setSendbirdUserId(a3.getString(b2));
                userExtendedMetaDataEntity.setMetaDataString(a3.getString(b3));
                if (a3.isNull(b4)) {
                    l = null;
                } else {
                    l = Long.valueOf(a3.getLong(b4));
                }
                userExtendedMetaDataEntity.setUpdatedAt(l);
                arrayList.add(userExtendedMetaDataEntity);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final UserExtendedMetaDataEntity getBySendbirdUserId(String str) {
        UserExtendedMetaDataEntity userExtendedMetaDataEntity;
        m a2 = m.a("SELECT * FROM UserExtendedMetaData WHERE sendbirdUserId == ?", 1);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = b.b(a3, "sendbirdUserId");
            int b3 = b.b(a3, "metaDataString");
            int b4 = b.b(a3, "updatedAt");
            Long l = null;
            if (a3.moveToFirst()) {
                userExtendedMetaDataEntity = new UserExtendedMetaDataEntity();
                userExtendedMetaDataEntity.setSendbirdUserId(a3.getString(b2));
                userExtendedMetaDataEntity.setMetaDataString(a3.getString(b3));
                if (!a3.isNull(b4)) {
                    l = Long.valueOf(a3.getLong(b4));
                }
                userExtendedMetaDataEntity.setUpdatedAt(l);
            } else {
                userExtendedMetaDataEntity = null;
            }
            return userExtendedMetaDataEntity;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
