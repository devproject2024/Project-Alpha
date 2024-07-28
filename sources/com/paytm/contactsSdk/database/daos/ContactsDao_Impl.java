package com.paytm.contactsSdk.database.daos;

import android.database.Cursor;
import androidx.a.d;
import androidx.room.b;
import androidx.room.b.e;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.models.Contact;
import com.paytm.contactsSdk.models.ContactPhone;
import java.util.ArrayList;
import java.util.List;

public final class ContactsDao_Impl extends ContactsDao {
    private final j __db;
    private final c<Contact> __insertionAdapterOfContact;
    private final q __preparedStmtOfDeleteContactsTable;
    private final q __preparedStmtOfUpdateAllContactsSyncType;
    private final b<Contact> __updateAdapterOfContact;

    public ContactsDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfContact = new c<Contact>(jVar) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `contacts` (`id`,`name`,`syncType`) VALUES (?,?,?)";
            }

            public void bind(f fVar, Contact contact) {
                fVar.a(1, (long) contact.getId());
                if (contact.getName() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, contact.getName());
                }
                fVar.a(3, (long) contact.getSyncType());
            }
        };
        this.__updateAdapterOfContact = new b<Contact>(jVar) {
            public String createQuery() {
                return "UPDATE OR ABORT `contacts` SET `id` = ?,`name` = ?,`syncType` = ? WHERE `id` = ?";
            }

            public void bind(f fVar, Contact contact) {
                fVar.a(1, (long) contact.getId());
                if (contact.getName() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, contact.getName());
                }
                fVar.a(3, (long) contact.getSyncType());
                fVar.a(4, (long) contact.getId());
            }
        };
        this.__preparedStmtOfDeleteContactsTable = new q(jVar) {
            public String createQuery() {
                return "Delete From contacts";
            }
        };
        this.__preparedStmtOfUpdateAllContactsSyncType = new q(jVar) {
            public String createQuery() {
                return "Update contacts set syncType = ?";
            }
        };
    }

    public final long[] insertContacts(List<Contact> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfContact.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    public final int updateContacts(List<Contact> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int handleMultiple = this.__updateAdapterOfContact.handleMultiple(list) + 0;
            this.__db.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void deleteContactsTable() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteContactsTable.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteContactsTable.release(acquire);
        }
    }

    public final void updateAllContactsSyncType(int i2) {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfUpdateAllContactsSyncType.acquire();
        acquire.a(1, (long) i2);
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateAllContactsSyncType.release(acquire);
        }
    }

    public final List<Contact> getContacts() {
        m a2 = m.a("SELECT * FROM contacts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, "id");
            int b3 = androidx.room.b.b.b(a3, "name");
            int b4 = androidx.room.b.b.b(a3, "syncType");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(new Contact(a3.getInt(b2), a3.getString(b3), a3.getInt(b4)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final long getContactsCount() {
        m a2 = m.a("SELECT COUNT(*) FROM contacts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            return a3.moveToFirst() ? a3.getLong(0) : 0;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final long getContactsCount(int i2) {
        m a2 = m.a("SELECT COUNT(*) FROM contacts WHERE syncType =?", 1);
        a2.a(1, (long) i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            return a3.moveToFirst() ? a3.getLong(0) : 0;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final List<Integer> getContactIds() {
        Integer num;
        m a2 = m.a("SELECT id FROM contacts", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                if (a3.isNull(0)) {
                    num = null;
                } else {
                    num = Integer.valueOf(a3.getInt(0));
                }
                arrayList.add(num);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[Catch:{ all -> 0x00b3, all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.contactsSdk.models.ContactWithPhones> getContactsWithPhones() {
        /*
            r12 = this;
            java.lang.String r0 = "SELECT * FROM contacts"
            r1 = 0
            androidx.room.m r0 = androidx.room.m.a((java.lang.String) r0, (int) r1)
            androidx.room.j r1 = r12.__db
            r1.assertNotSuspendingTransaction()
            androidx.room.j r1 = r12.__db
            r1.beginTransaction()
            androidx.room.j r1 = r12.__db     // Catch:{ all -> 0x00bb }
            r2 = 1
            android.database.Cursor r1 = androidx.room.b.c.a(r1, r0, r2)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "id"
            int r2 = androidx.room.b.b.b(r1, r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "name"
            int r3 = androidx.room.b.b.b(r1, r3)     // Catch:{ all -> 0x00b3 }
            java.lang.String r4 = "syncType"
            int r4 = androidx.room.b.b.b(r1, r4)     // Catch:{ all -> 0x00b3 }
            androidx.a.d r5 = new androidx.a.d     // Catch:{ all -> 0x00b3 }
            r5.<init>()     // Catch:{ all -> 0x00b3 }
        L_0x0030:
            boolean r6 = r1.moveToNext()     // Catch:{ all -> 0x00b3 }
            r7 = 0
            if (r6 == 0) goto L_0x004c
            long r8 = r1.getLong(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.Object r6 = r5.a(r8, r7)     // Catch:{ all -> 0x00b3 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x00b3 }
            if (r6 != 0) goto L_0x0030
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00b3 }
            r6.<init>()     // Catch:{ all -> 0x00b3 }
            r5.b(r8, r6)     // Catch:{ all -> 0x00b3 }
            goto L_0x0030
        L_0x004c:
            r6 = -1
            r1.moveToPosition(r6)     // Catch:{ all -> 0x00b3 }
            r12.__fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(r5)     // Catch:{ all -> 0x00b3 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00b3 }
            int r8 = r1.getCount()     // Catch:{ all -> 0x00b3 }
            r6.<init>(r8)     // Catch:{ all -> 0x00b3 }
        L_0x005c:
            boolean r8 = r1.moveToNext()     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x00a2
            boolean r8 = r1.isNull(r2)     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x0077
            boolean r8 = r1.isNull(r3)     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x0077
            boolean r8 = r1.isNull(r4)     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r11 = r7
            goto L_0x0088
        L_0x0077:
            int r8 = r1.getInt(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r9 = r1.getString(r3)     // Catch:{ all -> 0x00b3 }
            int r10 = r1.getInt(r4)     // Catch:{ all -> 0x00b3 }
            com.paytm.contactsSdk.models.Contact r11 = new com.paytm.contactsSdk.models.Contact     // Catch:{ all -> 0x00b3 }
            r11.<init>(r8, r9, r10)     // Catch:{ all -> 0x00b3 }
        L_0x0088:
            long r8 = r1.getLong(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.Object r8 = r5.a(r8, r7)     // Catch:{ all -> 0x00b3 }
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x0099
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00b3 }
            r8.<init>()     // Catch:{ all -> 0x00b3 }
        L_0x0099:
            com.paytm.contactsSdk.models.ContactWithPhones r9 = new com.paytm.contactsSdk.models.ContactWithPhones     // Catch:{ all -> 0x00b3 }
            r9.<init>(r11, r8)     // Catch:{ all -> 0x00b3 }
            r6.add(r9)     // Catch:{ all -> 0x00b3 }
            goto L_0x005c
        L_0x00a2:
            androidx.room.j r2 = r12.__db     // Catch:{ all -> 0x00b3 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x00b3 }
            r1.close()     // Catch:{ all -> 0x00bb }
            r0.a()     // Catch:{ all -> 0x00bb }
            androidx.room.j r0 = r12.__db
            r0.endTransaction()
            return r6
        L_0x00b3:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x00bb }
            r0.a()     // Catch:{ all -> 0x00bb }
            throw r2     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            androidx.room.j r1 = r12.__db
            r1.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.database.daos.ContactsDao_Impl.getContactsWithPhones():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[Catch:{ all -> 0x00b3, all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.contactsSdk.models.ContactWithPhones> getContactsWithPhonesASC() {
        /*
            r12 = this;
            java.lang.String r0 = "SELECT * FROM contacts ORDER BY name ASC"
            r1 = 0
            androidx.room.m r0 = androidx.room.m.a((java.lang.String) r0, (int) r1)
            androidx.room.j r1 = r12.__db
            r1.assertNotSuspendingTransaction()
            androidx.room.j r1 = r12.__db
            r1.beginTransaction()
            androidx.room.j r1 = r12.__db     // Catch:{ all -> 0x00bb }
            r2 = 1
            android.database.Cursor r1 = androidx.room.b.c.a(r1, r0, r2)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "id"
            int r2 = androidx.room.b.b.b(r1, r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "name"
            int r3 = androidx.room.b.b.b(r1, r3)     // Catch:{ all -> 0x00b3 }
            java.lang.String r4 = "syncType"
            int r4 = androidx.room.b.b.b(r1, r4)     // Catch:{ all -> 0x00b3 }
            androidx.a.d r5 = new androidx.a.d     // Catch:{ all -> 0x00b3 }
            r5.<init>()     // Catch:{ all -> 0x00b3 }
        L_0x0030:
            boolean r6 = r1.moveToNext()     // Catch:{ all -> 0x00b3 }
            r7 = 0
            if (r6 == 0) goto L_0x004c
            long r8 = r1.getLong(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.Object r6 = r5.a(r8, r7)     // Catch:{ all -> 0x00b3 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x00b3 }
            if (r6 != 0) goto L_0x0030
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00b3 }
            r6.<init>()     // Catch:{ all -> 0x00b3 }
            r5.b(r8, r6)     // Catch:{ all -> 0x00b3 }
            goto L_0x0030
        L_0x004c:
            r6 = -1
            r1.moveToPosition(r6)     // Catch:{ all -> 0x00b3 }
            r12.__fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(r5)     // Catch:{ all -> 0x00b3 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00b3 }
            int r8 = r1.getCount()     // Catch:{ all -> 0x00b3 }
            r6.<init>(r8)     // Catch:{ all -> 0x00b3 }
        L_0x005c:
            boolean r8 = r1.moveToNext()     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x00a2
            boolean r8 = r1.isNull(r2)     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x0077
            boolean r8 = r1.isNull(r3)     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x0077
            boolean r8 = r1.isNull(r4)     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r11 = r7
            goto L_0x0088
        L_0x0077:
            int r8 = r1.getInt(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r9 = r1.getString(r3)     // Catch:{ all -> 0x00b3 }
            int r10 = r1.getInt(r4)     // Catch:{ all -> 0x00b3 }
            com.paytm.contactsSdk.models.Contact r11 = new com.paytm.contactsSdk.models.Contact     // Catch:{ all -> 0x00b3 }
            r11.<init>(r8, r9, r10)     // Catch:{ all -> 0x00b3 }
        L_0x0088:
            long r8 = r1.getLong(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.Object r8 = r5.a(r8, r7)     // Catch:{ all -> 0x00b3 }
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x0099
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00b3 }
            r8.<init>()     // Catch:{ all -> 0x00b3 }
        L_0x0099:
            com.paytm.contactsSdk.models.ContactWithPhones r9 = new com.paytm.contactsSdk.models.ContactWithPhones     // Catch:{ all -> 0x00b3 }
            r9.<init>(r11, r8)     // Catch:{ all -> 0x00b3 }
            r6.add(r9)     // Catch:{ all -> 0x00b3 }
            goto L_0x005c
        L_0x00a2:
            androidx.room.j r2 = r12.__db     // Catch:{ all -> 0x00b3 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x00b3 }
            r1.close()     // Catch:{ all -> 0x00bb }
            r0.a()     // Catch:{ all -> 0x00bb }
            androidx.room.j r0 = r12.__db
            r0.endTransaction()
            return r6
        L_0x00b3:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x00bb }
            r0.a()     // Catch:{ all -> 0x00bb }
            throw r2     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            androidx.room.j r1 = r12.__db
            r1.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.database.daos.ContactsDao_Impl.getContactsWithPhonesASC():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c A[Catch:{ all -> 0x00bb, all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.contactsSdk.models.ContactWithPhones> getContactsbyNameSearch(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 1
            java.lang.String r1 = "SELECT * FROM contacts WHERE name Like '%'||?||'%'"
            androidx.room.m r1 = androidx.room.m.a((java.lang.String) r1, (int) r0)
            if (r12 != 0) goto L_0x000d
            r1.a((int) r0)
            goto L_0x0010
        L_0x000d:
            r1.a((int) r0, (java.lang.String) r12)
        L_0x0010:
            androidx.room.j r12 = r11.__db
            r12.assertNotSuspendingTransaction()
            androidx.room.j r12 = r11.__db
            r12.beginTransaction()
            androidx.room.j r12 = r11.__db     // Catch:{ all -> 0x00c3 }
            android.database.Cursor r12 = androidx.room.b.c.a(r12, r1, r0)     // Catch:{ all -> 0x00c3 }
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r12, r0)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "name"
            int r2 = androidx.room.b.b.b(r12, r2)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "syncType"
            int r3 = androidx.room.b.b.b(r12, r3)     // Catch:{ all -> 0x00bb }
            androidx.a.d r4 = new androidx.a.d     // Catch:{ all -> 0x00bb }
            r4.<init>()     // Catch:{ all -> 0x00bb }
        L_0x0038:
            boolean r5 = r12.moveToNext()     // Catch:{ all -> 0x00bb }
            r6 = 0
            if (r5 == 0) goto L_0x0054
            long r7 = r12.getLong(r0)     // Catch:{ all -> 0x00bb }
            java.lang.Object r5 = r4.a(r7, r6)     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x00bb }
            if (r5 != 0) goto L_0x0038
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            r5.<init>()     // Catch:{ all -> 0x00bb }
            r4.b(r7, r5)     // Catch:{ all -> 0x00bb }
            goto L_0x0038
        L_0x0054:
            r5 = -1
            r12.moveToPosition(r5)     // Catch:{ all -> 0x00bb }
            r11.__fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(r4)     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            int r7 = r12.getCount()     // Catch:{ all -> 0x00bb }
            r5.<init>(r7)     // Catch:{ all -> 0x00bb }
        L_0x0064:
            boolean r7 = r12.moveToNext()     // Catch:{ all -> 0x00bb }
            if (r7 == 0) goto L_0x00aa
            boolean r7 = r12.isNull(r0)     // Catch:{ all -> 0x00bb }
            if (r7 == 0) goto L_0x007f
            boolean r7 = r12.isNull(r2)     // Catch:{ all -> 0x00bb }
            if (r7 == 0) goto L_0x007f
            boolean r7 = r12.isNull(r3)     // Catch:{ all -> 0x00bb }
            if (r7 != 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r10 = r6
            goto L_0x0090
        L_0x007f:
            int r7 = r12.getInt(r0)     // Catch:{ all -> 0x00bb }
            java.lang.String r8 = r12.getString(r2)     // Catch:{ all -> 0x00bb }
            int r9 = r12.getInt(r3)     // Catch:{ all -> 0x00bb }
            com.paytm.contactsSdk.models.Contact r10 = new com.paytm.contactsSdk.models.Contact     // Catch:{ all -> 0x00bb }
            r10.<init>(r7, r8, r9)     // Catch:{ all -> 0x00bb }
        L_0x0090:
            long r7 = r12.getLong(r0)     // Catch:{ all -> 0x00bb }
            java.lang.Object r7 = r4.a(r7, r6)     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00bb }
            if (r7 != 0) goto L_0x00a1
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            r7.<init>()     // Catch:{ all -> 0x00bb }
        L_0x00a1:
            com.paytm.contactsSdk.models.ContactWithPhones r8 = new com.paytm.contactsSdk.models.ContactWithPhones     // Catch:{ all -> 0x00bb }
            r8.<init>(r10, r7)     // Catch:{ all -> 0x00bb }
            r5.add(r8)     // Catch:{ all -> 0x00bb }
            goto L_0x0064
        L_0x00aa:
            androidx.room.j r0 = r11.__db     // Catch:{ all -> 0x00bb }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x00bb }
            r12.close()     // Catch:{ all -> 0x00c3 }
            r1.a()     // Catch:{ all -> 0x00c3 }
            androidx.room.j r12 = r11.__db
            r12.endTransaction()
            return r5
        L_0x00bb:
            r0 = move-exception
            r12.close()     // Catch:{ all -> 0x00c3 }
            r1.a()     // Catch:{ all -> 0x00c3 }
            throw r0     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r12 = move-exception
            androidx.room.j r0 = r11.__db
            r0.endTransaction()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.database.daos.ContactsDao_Impl.getContactsbyNameSearch(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[Catch:{ all -> 0x00bb, all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.contactsSdk.models.ContactWithPhones> getContactsWithPhones(int r11, int r12) {
        /*
            r10 = this;
            r0 = 2
            java.lang.String r1 = "SELECT * FROM contacts Order by name ASC Limit ?,?"
            androidx.room.m r1 = androidx.room.m.a((java.lang.String) r1, (int) r0)
            long r2 = (long) r12
            r12 = 1
            r1.a((int) r12, (long) r2)
            long r2 = (long) r11
            r1.a((int) r0, (long) r2)
            androidx.room.j r11 = r10.__db
            r11.assertNotSuspendingTransaction()
            androidx.room.j r11 = r10.__db
            r11.beginTransaction()
            androidx.room.j r11 = r10.__db     // Catch:{ all -> 0x00c3 }
            android.database.Cursor r11 = androidx.room.b.c.a(r11, r1, r12)     // Catch:{ all -> 0x00c3 }
            java.lang.String r12 = "id"
            int r12 = androidx.room.b.b.b(r11, r12)     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = "name"
            int r0 = androidx.room.b.b.b(r11, r0)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "syncType"
            int r2 = androidx.room.b.b.b(r11, r2)     // Catch:{ all -> 0x00bb }
            androidx.a.d r3 = new androidx.a.d     // Catch:{ all -> 0x00bb }
            r3.<init>()     // Catch:{ all -> 0x00bb }
        L_0x0038:
            boolean r4 = r11.moveToNext()     // Catch:{ all -> 0x00bb }
            r5 = 0
            if (r4 == 0) goto L_0x0054
            long r6 = r11.getLong(r12)     // Catch:{ all -> 0x00bb }
            java.lang.Object r4 = r3.a(r6, r5)     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x00bb }
            if (r4 != 0) goto L_0x0038
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            r4.<init>()     // Catch:{ all -> 0x00bb }
            r3.b(r6, r4)     // Catch:{ all -> 0x00bb }
            goto L_0x0038
        L_0x0054:
            r4 = -1
            r11.moveToPosition(r4)     // Catch:{ all -> 0x00bb }
            r10.__fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(r3)     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            int r6 = r11.getCount()     // Catch:{ all -> 0x00bb }
            r4.<init>(r6)     // Catch:{ all -> 0x00bb }
        L_0x0064:
            boolean r6 = r11.moveToNext()     // Catch:{ all -> 0x00bb }
            if (r6 == 0) goto L_0x00aa
            boolean r6 = r11.isNull(r12)     // Catch:{ all -> 0x00bb }
            if (r6 == 0) goto L_0x007f
            boolean r6 = r11.isNull(r0)     // Catch:{ all -> 0x00bb }
            if (r6 == 0) goto L_0x007f
            boolean r6 = r11.isNull(r2)     // Catch:{ all -> 0x00bb }
            if (r6 != 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r9 = r5
            goto L_0x0090
        L_0x007f:
            int r6 = r11.getInt(r12)     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = r11.getString(r0)     // Catch:{ all -> 0x00bb }
            int r8 = r11.getInt(r2)     // Catch:{ all -> 0x00bb }
            com.paytm.contactsSdk.models.Contact r9 = new com.paytm.contactsSdk.models.Contact     // Catch:{ all -> 0x00bb }
            r9.<init>(r6, r7, r8)     // Catch:{ all -> 0x00bb }
        L_0x0090:
            long r6 = r11.getLong(r12)     // Catch:{ all -> 0x00bb }
            java.lang.Object r6 = r3.a(r6, r5)     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x00bb }
            if (r6 != 0) goto L_0x00a1
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            r6.<init>()     // Catch:{ all -> 0x00bb }
        L_0x00a1:
            com.paytm.contactsSdk.models.ContactWithPhones r7 = new com.paytm.contactsSdk.models.ContactWithPhones     // Catch:{ all -> 0x00bb }
            r7.<init>(r9, r6)     // Catch:{ all -> 0x00bb }
            r4.add(r7)     // Catch:{ all -> 0x00bb }
            goto L_0x0064
        L_0x00aa:
            androidx.room.j r12 = r10.__db     // Catch:{ all -> 0x00bb }
            r12.setTransactionSuccessful()     // Catch:{ all -> 0x00bb }
            r11.close()     // Catch:{ all -> 0x00c3 }
            r1.a()     // Catch:{ all -> 0x00c3 }
            androidx.room.j r11 = r10.__db
            r11.endTransaction()
            return r4
        L_0x00bb:
            r12 = move-exception
            r11.close()     // Catch:{ all -> 0x00c3 }
            r1.a()     // Catch:{ all -> 0x00c3 }
            throw r12     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r11 = move-exception
            androidx.room.j r12 = r10.__db
            r12.endTransaction()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.database.daos.ContactsDao_Impl.getContactsWithPhones(int, int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097 A[Catch:{ all -> 0x00b6, all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.contactsSdk.models.ContactWithPhones> getContacts(int r12) {
        /*
            r11 = this;
            r0 = 1
            java.lang.String r1 = "SELECT * FROM contacts WHERE syncType = ?"
            androidx.room.m r1 = androidx.room.m.a((java.lang.String) r1, (int) r0)
            long r2 = (long) r12
            r1.a((int) r0, (long) r2)
            androidx.room.j r12 = r11.__db
            r12.assertNotSuspendingTransaction()
            androidx.room.j r12 = r11.__db
            r12.beginTransaction()
            androidx.room.j r12 = r11.__db     // Catch:{ all -> 0x00be }
            android.database.Cursor r12 = androidx.room.b.c.a(r12, r1, r0)     // Catch:{ all -> 0x00be }
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r12, r0)     // Catch:{ all -> 0x00b6 }
            java.lang.String r2 = "name"
            int r2 = androidx.room.b.b.b(r12, r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = "syncType"
            int r3 = androidx.room.b.b.b(r12, r3)     // Catch:{ all -> 0x00b6 }
            androidx.a.d r4 = new androidx.a.d     // Catch:{ all -> 0x00b6 }
            r4.<init>()     // Catch:{ all -> 0x00b6 }
        L_0x0033:
            boolean r5 = r12.moveToNext()     // Catch:{ all -> 0x00b6 }
            r6 = 0
            if (r5 == 0) goto L_0x004f
            long r7 = r12.getLong(r0)     // Catch:{ all -> 0x00b6 }
            java.lang.Object r5 = r4.a(r7, r6)     // Catch:{ all -> 0x00b6 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x00b6 }
            if (r5 != 0) goto L_0x0033
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00b6 }
            r5.<init>()     // Catch:{ all -> 0x00b6 }
            r4.b(r7, r5)     // Catch:{ all -> 0x00b6 }
            goto L_0x0033
        L_0x004f:
            r5 = -1
            r12.moveToPosition(r5)     // Catch:{ all -> 0x00b6 }
            r11.__fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(r4)     // Catch:{ all -> 0x00b6 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00b6 }
            int r7 = r12.getCount()     // Catch:{ all -> 0x00b6 }
            r5.<init>(r7)     // Catch:{ all -> 0x00b6 }
        L_0x005f:
            boolean r7 = r12.moveToNext()     // Catch:{ all -> 0x00b6 }
            if (r7 == 0) goto L_0x00a5
            boolean r7 = r12.isNull(r0)     // Catch:{ all -> 0x00b6 }
            if (r7 == 0) goto L_0x007a
            boolean r7 = r12.isNull(r2)     // Catch:{ all -> 0x00b6 }
            if (r7 == 0) goto L_0x007a
            boolean r7 = r12.isNull(r3)     // Catch:{ all -> 0x00b6 }
            if (r7 != 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r10 = r6
            goto L_0x008b
        L_0x007a:
            int r7 = r12.getInt(r0)     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = r12.getString(r2)     // Catch:{ all -> 0x00b6 }
            int r9 = r12.getInt(r3)     // Catch:{ all -> 0x00b6 }
            com.paytm.contactsSdk.models.Contact r10 = new com.paytm.contactsSdk.models.Contact     // Catch:{ all -> 0x00b6 }
            r10.<init>(r7, r8, r9)     // Catch:{ all -> 0x00b6 }
        L_0x008b:
            long r7 = r12.getLong(r0)     // Catch:{ all -> 0x00b6 }
            java.lang.Object r7 = r4.a(r7, r6)     // Catch:{ all -> 0x00b6 }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00b6 }
            if (r7 != 0) goto L_0x009c
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00b6 }
            r7.<init>()     // Catch:{ all -> 0x00b6 }
        L_0x009c:
            com.paytm.contactsSdk.models.ContactWithPhones r8 = new com.paytm.contactsSdk.models.ContactWithPhones     // Catch:{ all -> 0x00b6 }
            r8.<init>(r10, r7)     // Catch:{ all -> 0x00b6 }
            r5.add(r8)     // Catch:{ all -> 0x00b6 }
            goto L_0x005f
        L_0x00a5:
            androidx.room.j r0 = r11.__db     // Catch:{ all -> 0x00b6 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x00b6 }
            r12.close()     // Catch:{ all -> 0x00be }
            r1.a()     // Catch:{ all -> 0x00be }
            androidx.room.j r12 = r11.__db
            r12.endTransaction()
            return r5
        L_0x00b6:
            r0 = move-exception
            r12.close()     // Catch:{ all -> 0x00be }
            r1.a()     // Catch:{ all -> 0x00be }
            throw r0     // Catch:{ all -> 0x00be }
        L_0x00be:
            r12 = move-exception
            androidx.room.j r0 = r11.__db
            r0.endTransaction()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.database.daos.ContactsDao_Impl.getContacts(int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.paytm.contactsSdk.models.ContactWithPhones> getContacts(int r11, int r12) {
        /*
            r10 = this;
            r0 = 2
            java.lang.String r1 = "SELECT * FROM contacts WHERE syncType = ? LIMIT ?"
            androidx.room.m r1 = androidx.room.m.a((java.lang.String) r1, (int) r0)
            long r2 = (long) r11
            r11 = 1
            r1.a((int) r11, (long) r2)
            long r2 = (long) r12
            r1.a((int) r0, (long) r2)
            androidx.room.j r12 = r10.__db
            r12.assertNotSuspendingTransaction()
            androidx.room.j r12 = r10.__db
            android.database.Cursor r11 = androidx.room.b.c.a(r12, r1, r11)
            java.lang.String r12 = "id"
            int r12 = androidx.room.b.b.b(r11, r12)     // Catch:{ all -> 0x00ac }
            java.lang.String r0 = "name"
            int r0 = androidx.room.b.b.b(r11, r0)     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = "syncType"
            int r2 = androidx.room.b.b.b(r11, r2)     // Catch:{ all -> 0x00ac }
            androidx.a.d r3 = new androidx.a.d     // Catch:{ all -> 0x00ac }
            r3.<init>()     // Catch:{ all -> 0x00ac }
        L_0x0033:
            boolean r4 = r11.moveToNext()     // Catch:{ all -> 0x00ac }
            r5 = 0
            if (r4 == 0) goto L_0x004f
            long r6 = r11.getLong(r12)     // Catch:{ all -> 0x00ac }
            java.lang.Object r4 = r3.a(r6, r5)     // Catch:{ all -> 0x00ac }
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x00ac }
            if (r4 != 0) goto L_0x0033
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00ac }
            r4.<init>()     // Catch:{ all -> 0x00ac }
            r3.b(r6, r4)     // Catch:{ all -> 0x00ac }
            goto L_0x0033
        L_0x004f:
            r4 = -1
            r11.moveToPosition(r4)     // Catch:{ all -> 0x00ac }
            r10.__fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(r3)     // Catch:{ all -> 0x00ac }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00ac }
            int r6 = r11.getCount()     // Catch:{ all -> 0x00ac }
            r4.<init>(r6)     // Catch:{ all -> 0x00ac }
        L_0x005f:
            boolean r6 = r11.moveToNext()     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x00a5
            boolean r6 = r11.isNull(r12)     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x007a
            boolean r6 = r11.isNull(r0)     // Catch:{ all -> 0x00ac }
            if (r6 == 0) goto L_0x007a
            boolean r6 = r11.isNull(r2)     // Catch:{ all -> 0x00ac }
            if (r6 != 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r9 = r5
            goto L_0x008b
        L_0x007a:
            int r6 = r11.getInt(r12)     // Catch:{ all -> 0x00ac }
            java.lang.String r7 = r11.getString(r0)     // Catch:{ all -> 0x00ac }
            int r8 = r11.getInt(r2)     // Catch:{ all -> 0x00ac }
            com.paytm.contactsSdk.models.Contact r9 = new com.paytm.contactsSdk.models.Contact     // Catch:{ all -> 0x00ac }
            r9.<init>(r6, r7, r8)     // Catch:{ all -> 0x00ac }
        L_0x008b:
            long r6 = r11.getLong(r12)     // Catch:{ all -> 0x00ac }
            java.lang.Object r6 = r3.a(r6, r5)     // Catch:{ all -> 0x00ac }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x00ac }
            if (r6 != 0) goto L_0x009c
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00ac }
            r6.<init>()     // Catch:{ all -> 0x00ac }
        L_0x009c:
            com.paytm.contactsSdk.models.ContactWithPhones r7 = new com.paytm.contactsSdk.models.ContactWithPhones     // Catch:{ all -> 0x00ac }
            r7.<init>(r9, r6)     // Catch:{ all -> 0x00ac }
            r4.add(r7)     // Catch:{ all -> 0x00ac }
            goto L_0x005f
        L_0x00a5:
            r11.close()
            r1.a()
            return r4
        L_0x00ac:
            r12 = move-exception
            r11.close()
            r1.a()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.database.daos.ContactsDao_Impl.getContacts(int, int):java.util.List");
    }

    public final List<Integer> getContactIds(int i2, int i3) {
        Integer num;
        m a2 = m.a("SELECT id FROM contacts WHERE syncType = ? LIMIT ?", 2);
        a2.a(1, (long) i2);
        a2.a(2, (long) i3);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                if (a3.isNull(0)) {
                    num = null;
                } else {
                    num = Integer.valueOf(a3.getInt(0));
                }
                arrayList.add(num);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final void deleteContacts(List<Integer> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder a2 = e.a();
        a2.append("Delete From contacts WHERE id in (");
        e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.__db.compileStatement(a2.toString());
        int i2 = 1;
        for (Integer next : list) {
            if (next == null) {
                compileStatement.a(i2);
            } else {
                compileStatement.a(i2, (long) next.intValue());
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void updateContactSyncType(List<Integer> list, int i2) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder a2 = e.a();
        a2.append("Update contacts set  syncType = ");
        a2.append("?");
        a2.append(" where id In (");
        e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.__db.compileStatement(a2.toString());
        compileStatement.a(1, (long) i2);
        int i3 = 2;
        for (Integer next : list) {
            if (next == null) {
                compileStatement.a(i3);
            } else {
                compileStatement.a(i3, (long) next.intValue());
            }
            i3++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    private void __fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(d<ArrayList<ContactPhone>> dVar) {
        int i2;
        while (!dVar.c()) {
            if (dVar.b() > 999) {
                d<ArrayList<ContactPhone>> dVar2 = new d<>(999);
                int b2 = dVar.b();
                d<ArrayList<ContactPhone>> dVar3 = dVar2;
                int i3 = 0;
                while (true) {
                    i2 = 0;
                    while (i3 < b2) {
                        dVar3.b(dVar.b(i3), dVar.c(i3));
                        i3++;
                        i2++;
                        if (i2 == 999) {
                            __fetchRelationshipcontactsPhonesAscomPaytmContactsSdkModelsContactPhone(dVar3);
                            dVar3 = new d<>(999);
                        }
                    }
                    break;
                }
                if (i2 > 0) {
                    dVar = dVar3;
                } else {
                    return;
                }
            } else {
                StringBuilder a2 = e.a();
                a2.append("SELECT `id`,`contact_id`,`phone`,`isPrimary` FROM `contacts_phones` WHERE `contact_id` IN (");
                int b3 = dVar.b();
                e.a(a2, b3);
                a2.append(")");
                m a3 = m.a(a2.toString(), b3 + 0);
                int i4 = 1;
                for (int i5 = 0; i5 < dVar.b(); i5++) {
                    a3.a(i4, dVar.b(i5));
                    i4++;
                }
                Cursor a4 = androidx.room.b.c.a(this.__db, a3, false);
                try {
                    int a5 = androidx.room.b.b.a(a4, ContactColumn.CONTACT_ID);
                    if (a5 != -1) {
                        int b4 = androidx.room.b.b.b(a4, "id");
                        int b5 = androidx.room.b.b.b(a4, ContactColumn.CONTACT_ID);
                        int b6 = androidx.room.b.b.b(a4, ContactColumn.PHONE_NUMBER);
                        int b7 = androidx.room.b.b.b(a4, ContactColumn.IS_PRIMARY);
                        while (a4.moveToNext()) {
                            ArrayList a6 = dVar.a(a4.getLong(a5), null);
                            if (a6 != null) {
                                a6.add(new ContactPhone(a4.getInt(b4), a4.getInt(b5), a4.getString(b6), a4.getInt(b7) != 0));
                            }
                        }
                        a4.close();
                        return;
                    }
                    return;
                } finally {
                    a4.close();
                }
            }
        }
    }
}
