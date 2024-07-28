package com.paytm.contactsSdk.database.daos;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.q;
import androidx.sqlite.db.e;
import androidx.sqlite.db.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.models.EnrichedContactModel;
import com.paytm.contactsSdk.models.EnrichmentData;
import java.util.ArrayList;
import java.util.List;

public final class EnrichmentDao_Impl implements EnrichmentDao {
    private final j __db;
    private final c<EnrichmentData> __insertionAdapterOfEnrichmentData;
    private final q __preparedStmtOfDeletedAllData;

    public EnrichmentDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfEnrichmentData = new c<EnrichmentData>(jVar) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `enrichment_data` (`phoneNumber`,`enrichmentBitCodeCol_0`,`enrichmentBitCodeCol_1`,`enrichmentBitCodeCol_2`,`enrichmentBitCodeCol_3`,`featureJson`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(f fVar, EnrichmentData enrichmentData) {
                if (enrichmentData.getPhoneNumber() == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, enrichmentData.getPhoneNumber());
                }
                fVar.a(2, enrichmentData.getEnrichmentBitCodeCol_0());
                fVar.a(3, enrichmentData.getEnrichmentBitCodeCol_1());
                fVar.a(4, enrichmentData.getEnrichmentBitCodeCol_2());
                fVar.a(5, enrichmentData.getEnrichmentBitCodeCol_3());
                if (enrichmentData.getFeatureJson() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, enrichmentData.getFeatureJson());
                }
            }
        };
        this.__preparedStmtOfDeletedAllData = new q(jVar) {
            public String createQuery() {
                return "DELETE FROM enrichment_data";
            }
        };
    }

    public final void insertEnrichmentData(List<EnrichmentData> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEnrichmentData.insert(list);
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

    public final List<EnrichmentData> getEnrichmentData(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor a2 = androidx.room.b.c.a(this.__db, eVar, false);
        try {
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comPaytmContactsSdkModelsEnrichmentData(a2));
            }
            return arrayList;
        } finally {
            a2.close();
        }
    }

    public final List<EnrichedContactModel> getEnrichedContacts(e eVar) {
        String str;
        String str2;
        this.__db.assertNotSuspendingTransaction();
        Cursor a2 = androidx.room.b.c.a(this.__db, eVar, false);
        try {
            int a3 = b.a(a2, "name");
            int a4 = b.a(a2, ContactColumn.PHONE_NUMBER);
            int a5 = b.a(a2, "featureJson");
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                String str3 = null;
                if (a3 == -1) {
                    str = null;
                } else {
                    str = a2.getString(a3);
                }
                if (a4 == -1) {
                    str2 = null;
                } else {
                    str2 = a2.getString(a4);
                }
                if (a5 != -1) {
                    str3 = a2.getString(a5);
                }
                arrayList.add(new EnrichedContactModel(str, str2, str3));
            }
            return arrayList;
        } finally {
            a2.close();
        }
    }

    public final List<EnrichedContactModel> getEnrichedContactsPaginated(e eVar) {
        String str;
        String str2;
        this.__db.assertNotSuspendingTransaction();
        Cursor a2 = androidx.room.b.c.a(this.__db, eVar, false);
        try {
            int a3 = b.a(a2, "name");
            int a4 = b.a(a2, ContactColumn.PHONE_NUMBER);
            int a5 = b.a(a2, "featureJson");
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                String str3 = null;
                if (a3 == -1) {
                    str = null;
                } else {
                    str = a2.getString(a3);
                }
                if (a4 == -1) {
                    str2 = null;
                } else {
                    str2 = a2.getString(a4);
                }
                if (a5 != -1) {
                    str3 = a2.getString(a5);
                }
                arrayList.add(new EnrichedContactModel(str, str2, str3));
            }
            return arrayList;
        } finally {
            a2.close();
        }
    }

    private EnrichmentData __entityCursorConverter_comPaytmContactsSdkModelsEnrichmentData(Cursor cursor) {
        String str;
        long j;
        long j2;
        long j3;
        long j4;
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("phoneNumber");
        int columnIndex2 = cursor2.getColumnIndex("enrichmentBitCodeCol_0");
        int columnIndex3 = cursor2.getColumnIndex("enrichmentBitCodeCol_1");
        int columnIndex4 = cursor2.getColumnIndex("enrichmentBitCodeCol_2");
        int columnIndex5 = cursor2.getColumnIndex("enrichmentBitCodeCol_3");
        int columnIndex6 = cursor2.getColumnIndex("featureJson");
        String str2 = null;
        if (columnIndex == -1) {
            str = null;
        } else {
            str = cursor2.getString(columnIndex);
        }
        if (columnIndex2 == -1) {
            j = 0;
        } else {
            j = cursor2.getLong(columnIndex2);
        }
        if (columnIndex3 == -1) {
            j2 = 0;
        } else {
            j2 = cursor2.getLong(columnIndex3);
        }
        if (columnIndex4 == -1) {
            j3 = 0;
        } else {
            j3 = cursor2.getLong(columnIndex4);
        }
        if (columnIndex5 == -1) {
            j4 = 0;
        } else {
            j4 = cursor2.getLong(columnIndex5);
        }
        if (columnIndex6 != -1) {
            str2 = cursor2.getString(columnIndex6);
        }
        return new EnrichmentData(str, j, j2, j3, j4, str2);
    }
}
