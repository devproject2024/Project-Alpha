package com.paytm.contactsSdk.database.daos;

import com.paytm.contactsSdk.api.p002enum.LocalContactSyncType;
import com.paytm.contactsSdk.manager.DatabaseManager;
import com.paytm.contactsSdk.models.Contact;
import com.paytm.contactsSdk.models.ContactPhone;
import com.paytm.contactsSdk.models.ContactWithPhones;
import com.paytm.contactsSdk.utils.ContactUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.z;
import kotlin.g.b.k;

public abstract class ContactsDao {
    public abstract void deleteContacts(List<Integer> list);

    public abstract void deleteContactsTable();

    public abstract List<Integer> getContactIds();

    public abstract List<Integer> getContactIds(int i2, int i3);

    public abstract List<Contact> getContacts();

    public abstract List<ContactWithPhones> getContacts(int i2);

    public abstract List<ContactWithPhones> getContacts(int i2, int i3);

    public abstract long getContactsCount();

    public abstract long getContactsCount(int i2);

    public abstract List<ContactWithPhones> getContactsWithPhones();

    public abstract List<ContactWithPhones> getContactsWithPhones(int i2, int i3);

    public abstract List<ContactWithPhones> getContactsWithPhonesASC();

    public abstract List<ContactWithPhones> getContactsbyNameSearch(String str);

    public abstract long[] insertContacts(List<Contact> list);

    public abstract void updateAllContactsSyncType(int i2);

    public abstract void updateContactSyncType(List<Integer> list, int i2);

    public abstract int updateContacts(List<Contact> list);

    public final void insertContactsWithPhone(List<ContactWithPhones> list) {
        k.c(list, "contactsListWithPhones");
        insertContacts(ContactUtil.INSTANCE.getContactsFromContactPhoneWithSync$contacts_sdk_release(list, LocalContactSyncType.SYNC_ADD_UPDATE));
        ArrayList arrayList = new ArrayList();
        for (z zVar : kotlin.a.k.g(list)) {
            for (ContactPhone add : ((ContactWithPhones) zVar.f47894b).getPhones()) {
                arrayList.add(add);
            }
        }
        if (!arrayList.isEmpty()) {
            DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().insertAll(arrayList);
        }
    }
}
