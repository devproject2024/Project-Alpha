package com.paytm.contactsSdk.database.daos;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import com.paytm.contactsSdk.models.DynamicMapping;
import java.util.ArrayList;
import java.util.List;

public final class DynamiceMappingDao_Impl implements DynamiceMappingDao {
    private final j __db;
    private final c<DynamicMapping> __insertionAdapterOfDynamicMapping;
    private final c<DynamicMapping> __insertionAdapterOfDynamicMapping_1;
    private final q __preparedStmtOfDeletedAllData;

    public DynamiceMappingDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfDynamicMapping = new c<DynamicMapping>(jVar) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `dynamic_mapping` (`feature`,`columnNumber`,`bitCode`) VALUES (?,?,?)";
            }

            public void bind(f fVar, DynamicMapping dynamicMapping) {
                if (dynamicMapping.getFeature() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, dynamicMapping.getFeature());
                }
                fVar.a(2, (long) dynamicMapping.getColumnNumber());
                fVar.a(3, dynamicMapping.getBitCode());
            }
        };
        this.__insertionAdapterOfDynamicMapping_1 = new c<DynamicMapping>(jVar) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `dynamic_mapping` (`feature`,`columnNumber`,`bitCode`) VALUES (?,?,?)";
            }

            public void bind(f fVar, DynamicMapping dynamicMapping) {
                if (dynamicMapping.getFeature() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, dynamicMapping.getFeature());
                }
                fVar.a(2, (long) dynamicMapping.getColumnNumber());
                fVar.a(3, dynamicMapping.getBitCode());
            }
        };
        this.__preparedStmtOfDeletedAllData = new q(jVar) {
            public String createQuery() {
                return "DELETE FROM dynamic_mapping";
            }
        };
    }

    public final void insertDynamicMapping(DynamicMapping dynamicMapping) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDynamicMapping.insert(dynamicMapping);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void insertDynamicMappingList(List<DynamicMapping> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDynamicMapping_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void deletedAllData() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeletedAllData.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeletedAllData.release(acquire);
        }
    }

    public final List<DynamicMapping> getDynamicMapping() {
        Cursor a2;
        m a3 = m.a("SELECT * FROM dynamic_mapping", 0);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            a2 = androidx.room.b.c.a(this.__db, a3, false);
            int b2 = b.b(a2, "feature");
            int b3 = b.b(a2, "columnNumber");
            int b4 = b.b(a2, "bitCode");
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(new DynamicMapping(a2.getString(b2), a2.getInt(b3), a2.getLong(b4)));
            }
            this.__db.setTransactionSuccessful();
            a2.close();
            a3.a();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }
}
