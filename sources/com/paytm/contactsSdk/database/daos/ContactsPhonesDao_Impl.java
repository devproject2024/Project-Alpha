package com.paytm.contactsSdk.database.daos;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.b.e;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.models.ContactPhone;
import java.util.ArrayList;
import java.util.List;

public final class ContactsPhonesDao_Impl implements ContactsPhonesDao {
    private final j __db;
    private final c<ContactPhone> __insertionAdapterOfContactPhone;
    private final q __preparedStmtOfDeleteAllPhone;

    public ContactsPhonesDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfContactPhone = new c<ContactPhone>(jVar) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `contacts_phones` (`id`,`contact_id`,`phone`,`isPrimary`) VALUES (nullif(?, 0),?,?,?)";
            }

            public void bind(f fVar, ContactPhone contactPhone) {
                fVar.a(1, (long) contactPhone.getId());
                fVar.a(2, (long) contactPhone.getContact_id());
                if (contactPhone.getPhone() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, contactPhone.getPhone());
                }
                fVar.a(4, contactPhone.isPrimary() ? 1 : 0);
            }
        };
        this.__preparedStmtOfDeleteAllPhone = new q(jVar) {
            public String createQuery() {
                return "DELETE FROM contacts_phones";
            }
        };
    }

    public final void insertAll(List<ContactPhone> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfContactPhone.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void deleteAllPhone() {
        this.__db.assertNotSuspendingTransaction();
        f acquire = this.__preparedStmtOfDeleteAllPhone.acquire();
        this.__db.beginTransaction();
        try {
            acquire.a();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllPhone.release(acquire);
        }
    }

    public final List<ContactPhone> getAll() {
        m a2 = m.a("SELECT * FROM contacts_phones", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.__db, a2, false);
        try {
            int b2 = b.b(a3, "id");
            int b3 = b.b(a3, ContactColumn.CONTACT_ID);
            int b4 = b.b(a3, ContactColumn.PHONE_NUMBER);
            int b5 = b.b(a3, ContactColumn.IS_PRIMARY);
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(new ContactPhone(a3.getInt(b2), a3.getInt(b3), a3.getString(b4), a3.getInt(b5) != 0));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final Cursor getAllContactWithPhone(int i2, int i3) {
        m a2 = m.a("SELECT contacts.name, contacts_phones.* from contacts_phones Inner Join contacts on contacts_phones.contact_id  == contacts.id Order by contacts.name ASC Limit ?,?", 2);
        a2.a(1, (long) i3);
        a2.a(2, (long) i2);
        this.__db.beginTransaction();
        try {
            Cursor query = this.__db.query(a2);
            this.__db.setTransactionSuccessful();
            return query;
        } finally {
            this.__db.endTransaction();
        }
    }

    public final Cursor getContactsWithPhoneByName(String str) {
        m a2 = m.a("SELECT contacts.name, contacts_phones.* from contacts_phones Inner Join contacts on contacts_phones.contact_id  == contacts.id  WHERE name Like '%'||?||'%' ORDER BY contacts.name ASC", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.__db.beginTransaction();
        try {
            Cursor query = this.__db.query(a2);
            this.__db.setTransactionSuccessful();
            return query;
        } finally {
            this.__db.endTransaction();
        }
    }

    public final Cursor getAllContactWithPhone() {
        m a2 = m.a("SELECT contacts.name, contacts_phones.* from contacts_phones Inner Join contacts on contacts_phones.contact_id  == contacts.id Order by contacts.name ASC", 0);
        this.__db.beginTransaction();
        try {
            Cursor query = this.__db.query(a2);
            this.__db.setTransactionSuccessful();
            return query;
        } finally {
            this.__db.endTransaction();
        }
    }

    public final void deleteDeletedContacts(List<Integer> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder a2 = e.a();
        a2.append("DELETE FROM contacts_phones WHERE contact_id In (");
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
}
