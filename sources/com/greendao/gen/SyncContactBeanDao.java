package com.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class SyncContactBeanDao extends AbstractDao<SyncContactBean, Long> {
    public static final String TABLENAME = "SYNC_CONTACT_BEAN";

    public static class Properties {
        public static final Property ChannelUrl = new Property(4, String.class, "channelUrl", false, "CHANNEL_URL");
        public static final Property ContactId = new Property(8, String.class, "contactId", false, "CONTACT_ID");
        public static final Property ContactName = new Property(5, String.class, "contactName", false, "CONTACT_NAME");
        public static final Property ContactPhone = new Property(6, String.class, "contactPhone", false, "CONTACT_PHONE");
        public static final Property ContactPic = new Property(7, String.class, "contactPic", false, "CONTACT_PIC");
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property IsPaytm = new Property(9, Boolean.TYPE, "isPaytm", false, "IS_PAYTM");
        public static final Property LastMessageTimeStamp = new Property(12, Long.TYPE, "lastMessageTimeStamp", false, "LAST_MESSAGE_TIME_STAMP");
        public static final Property PtId = new Property(1, String.class, "ptId", false, "PT_ID");
        public static final Property PtName = new Property(2, String.class, "ptName", false, "PT_NAME");
        public static final Property PtPic = new Property(3, String.class, "ptPic", false, "PT_PIC");
        public static final Property SelfId = new Property(10, String.class, "selfId", false, "SELF_ID");
        public static final Property SendbirdId = new Property(11, String.class, "sendbirdId", false, "SENDBIRD_ID");
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    public SyncContactBeanDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public SyncContactBeanDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"SYNC_CONTACT_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"PT_ID\" TEXT,\"PT_NAME\" TEXT,\"PT_PIC\" TEXT,\"CHANNEL_URL\" TEXT,\"CONTACT_NAME\" TEXT,\"CONTACT_PHONE\" TEXT,\"CONTACT_PIC\" TEXT,\"CONTACT_ID\" TEXT,\"IS_PAYTM\" INTEGER NOT NULL ,\"SELF_ID\" TEXT,\"SENDBIRD_ID\" TEXT,\"LAST_MESSAGE_TIME_STAMP\" INTEGER NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_SYNC_CONTACT_BEAN_CONTACT_PHONE ON \"SYNC_CONTACT_BEAN\" (\"CONTACT_PHONE\" ASC);");
    }

    public static void dropTable(Database database, boolean z) {
        StringBuilder sb = new StringBuilder("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"SYNC_CONTACT_BEAN\"");
        database.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(DatabaseStatement databaseStatement, SyncContactBean syncContactBean) {
        databaseStatement.clearBindings();
        Long id = syncContactBean.getId();
        if (id != null) {
            databaseStatement.bindLong(1, id.longValue());
        }
        String ptId = syncContactBean.getPtId();
        if (ptId != null) {
            databaseStatement.bindString(2, ptId);
        }
        String ptName = syncContactBean.getPtName();
        if (ptName != null) {
            databaseStatement.bindString(3, ptName);
        }
        String ptPic = syncContactBean.getPtPic();
        if (ptPic != null) {
            databaseStatement.bindString(4, ptPic);
        }
        String channelUrl = syncContactBean.getChannelUrl();
        if (channelUrl != null) {
            databaseStatement.bindString(5, channelUrl);
        }
        String contactName = syncContactBean.getContactName();
        if (contactName != null) {
            databaseStatement.bindString(6, contactName);
        }
        String contactPhone = syncContactBean.getContactPhone();
        if (contactPhone != null) {
            databaseStatement.bindString(7, contactPhone);
        }
        String contactPic = syncContactBean.getContactPic();
        if (contactPic != null) {
            databaseStatement.bindString(8, contactPic);
        }
        String contactId = syncContactBean.getContactId();
        if (contactId != null) {
            databaseStatement.bindString(9, contactId);
        }
        databaseStatement.bindLong(10, syncContactBean.getIsPaytm() ? 1 : 0);
        String selfId = syncContactBean.getSelfId();
        if (selfId != null) {
            databaseStatement.bindString(11, selfId);
        }
        String sendbirdId = syncContactBean.getSendbirdId();
        if (sendbirdId != null) {
            databaseStatement.bindString(12, sendbirdId);
        }
        databaseStatement.bindLong(13, syncContactBean.getLastMessageTimeStamp());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(SQLiteStatement sQLiteStatement, SyncContactBean syncContactBean) {
        sQLiteStatement.clearBindings();
        Long id = syncContactBean.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        String ptId = syncContactBean.getPtId();
        if (ptId != null) {
            sQLiteStatement.bindString(2, ptId);
        }
        String ptName = syncContactBean.getPtName();
        if (ptName != null) {
            sQLiteStatement.bindString(3, ptName);
        }
        String ptPic = syncContactBean.getPtPic();
        if (ptPic != null) {
            sQLiteStatement.bindString(4, ptPic);
        }
        String channelUrl = syncContactBean.getChannelUrl();
        if (channelUrl != null) {
            sQLiteStatement.bindString(5, channelUrl);
        }
        String contactName = syncContactBean.getContactName();
        if (contactName != null) {
            sQLiteStatement.bindString(6, contactName);
        }
        String contactPhone = syncContactBean.getContactPhone();
        if (contactPhone != null) {
            sQLiteStatement.bindString(7, contactPhone);
        }
        String contactPic = syncContactBean.getContactPic();
        if (contactPic != null) {
            sQLiteStatement.bindString(8, contactPic);
        }
        String contactId = syncContactBean.getContactId();
        if (contactId != null) {
            sQLiteStatement.bindString(9, contactId);
        }
        sQLiteStatement.bindLong(10, syncContactBean.getIsPaytm() ? 1 : 0);
        String selfId = syncContactBean.getSelfId();
        if (selfId != null) {
            sQLiteStatement.bindString(11, selfId);
        }
        String sendbirdId = syncContactBean.getSendbirdId();
        if (sendbirdId != null) {
            sQLiteStatement.bindString(12, sendbirdId);
        }
        sQLiteStatement.bindLong(13, syncContactBean.getLastMessageTimeStamp());
    }

    public Long readKey(Cursor cursor, int i2) {
        int i3 = i2 + 0;
        if (cursor.isNull(i3)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i3));
    }

    public SyncContactBean readEntity(Cursor cursor, int i2) {
        Cursor cursor2 = cursor;
        int i3 = i2 + 0;
        String str = null;
        Long valueOf = cursor2.isNull(i3) ? null : Long.valueOf(cursor2.getLong(i3));
        int i4 = i2 + 1;
        String string = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        int i5 = i2 + 2;
        String string2 = cursor2.isNull(i5) ? null : cursor2.getString(i5);
        int i6 = i2 + 3;
        String string3 = cursor2.isNull(i6) ? null : cursor2.getString(i6);
        int i7 = i2 + 4;
        String string4 = cursor2.isNull(i7) ? null : cursor2.getString(i7);
        int i8 = i2 + 5;
        String string5 = cursor2.isNull(i8) ? null : cursor2.getString(i8);
        int i9 = i2 + 6;
        String string6 = cursor2.isNull(i9) ? null : cursor2.getString(i9);
        int i10 = i2 + 7;
        String string7 = cursor2.isNull(i10) ? null : cursor2.getString(i10);
        int i11 = i2 + 8;
        String string8 = cursor2.isNull(i11) ? null : cursor2.getString(i11);
        boolean z = cursor2.getShort(i2 + 9) != 0;
        int i12 = i2 + 10;
        String string9 = cursor2.isNull(i12) ? null : cursor2.getString(i12);
        int i13 = i2 + 11;
        if (!cursor2.isNull(i13)) {
            str = cursor2.getString(i13);
        }
        return new SyncContactBean(valueOf, string, string2, string3, string4, string5, string6, string7, string8, z, string9, str, cursor2.getLong(i2 + 12));
    }

    public void readEntity(Cursor cursor, SyncContactBean syncContactBean, int i2) {
        int i3 = i2 + 0;
        String str = null;
        syncContactBean.setId(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i4 = i2 + 1;
        syncContactBean.setPtId(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i2 + 2;
        syncContactBean.setPtName(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i2 + 3;
        syncContactBean.setPtPic(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i2 + 4;
        syncContactBean.setChannelUrl(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i2 + 5;
        syncContactBean.setContactName(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i2 + 6;
        syncContactBean.setContactPhone(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i2 + 7;
        syncContactBean.setContactPic(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i2 + 8;
        syncContactBean.setContactId(cursor.isNull(i11) ? null : cursor.getString(i11));
        syncContactBean.setIsPaytm(cursor.getShort(i2 + 9) != 0);
        int i12 = i2 + 10;
        syncContactBean.setSelfId(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i2 + 11;
        if (!cursor.isNull(i13)) {
            str = cursor.getString(i13);
        }
        syncContactBean.setSendbirdId(str);
        syncContactBean.setLastMessageTimeStamp(cursor.getLong(i2 + 12));
    }

    /* access modifiers changed from: protected */
    public final Long updateKeyAfterInsert(SyncContactBean syncContactBean, long j) {
        syncContactBean.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public Long getKey(SyncContactBean syncContactBean) {
        if (syncContactBean != null) {
            return syncContactBean.getId();
        }
        return null;
    }

    public boolean hasKey(SyncContactBean syncContactBean) {
        return syncContactBean.getId() != null;
    }
}
