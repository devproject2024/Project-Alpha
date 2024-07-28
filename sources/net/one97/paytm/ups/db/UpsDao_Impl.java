package net.one97.paytm.ups.db;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;

public final class UpsDao_Impl implements UpsDao {
    private final j __db;
    private final c<ConsentItem> __insertionAdapterOfConsentItem;
    private final q __preparedStmtOfDeleteTable;

    public UpsDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfConsentItem = new c<ConsentItem>(jVar) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ConsentTable` (`consentKey`,`consentValue`,`syncedWithServer`,`verticalId`,`syncTimestamp`) VALUES (?,?,?,?,?)";
            }

            public void bind(f fVar, ConsentItem consentItem) {
                if (consentItem.getConsentKey() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, consentItem.getConsentKey());
                }
                if (consentItem.getConsentValue() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, consentItem.getConsentValue());
                }
                fVar.a(3, consentItem.getSyncedWithServer() ? 1 : 0);
                if (consentItem.getVerticalId() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, consentItem.getVerticalId());
                }
                fVar.a(5, consentItem.getSyncTimestamp());
            }
        };
        this.__preparedStmtOfDeleteTable = new q(jVar) {
            public String createQuery() {
                return "DELETE FROM ConsentTable";
            }
        };
    }

    public final long insertConsent(ConsentItem consentItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfConsentItem.insertAndReturnId(consentItem);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void deleteTable() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteTable.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteTable.release(acquire);
        }
    }

    public final List<ConsentItem> getAllAvailableConsent() {
        m a2 = m.a("SELECT * FROM ConsentTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = b.b(a3, "consentKey");
            int b3 = b.b(a3, "consentValue");
            int b4 = b.b(a3, "syncedWithServer");
            int b5 = b.b(a3, "verticalId");
            int b6 = b.b(a3, "syncTimestamp");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(new ConsentItem(a3.getString(b2), a3.getString(b3), a3.getInt(b4) != 0, a3.getString(b5), a3.getLong(b6)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final List<ConsentItem> getConsent(String str) {
        String str2 = str;
        m a2 = m.a("SELECT * FROM ConsentTable WHERE consentKey == ?", 1);
        if (str2 == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = b.b(a3, "consentKey");
            int b3 = b.b(a3, "consentValue");
            int b4 = b.b(a3, "syncedWithServer");
            int b5 = b.b(a3, "verticalId");
            int b6 = b.b(a3, "syncTimestamp");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(new ConsentItem(a3.getString(b2), a3.getString(b3), a3.getInt(b4) != 0, a3.getString(b5), a3.getLong(b6)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final List<ConsentItem> getConsentNeededToSyncWithServer(boolean z) {
        m a2 = m.a("SELECT * FROM ConsentTable WHERE syncedWithServer == ?", 1);
        a2.a(1, z ? 1 : 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = b.b(a3, "consentKey");
            int b3 = b.b(a3, "consentValue");
            int b4 = b.b(a3, "syncedWithServer");
            int b5 = b.b(a3, "verticalId");
            int b6 = b.b(a3, "syncTimestamp");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(new ConsentItem(a3.getString(b2), a3.getString(b3), a3.getInt(b4) != 0, a3.getString(b5), a3.getLong(b6)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
