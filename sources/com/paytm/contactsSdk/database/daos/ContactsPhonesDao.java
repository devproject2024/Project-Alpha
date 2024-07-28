package com.paytm.contactsSdk.database.daos;

import android.database.Cursor;
import com.paytm.contactsSdk.models.ContactPhone;
import java.util.List;

public interface ContactsPhonesDao {
    void deleteAllPhone();

    void deleteDeletedContacts(List<Integer> list);

    List<ContactPhone> getAll();

    Cursor getAllContactWithPhone();

    Cursor getAllContactWithPhone(int i2, int i3);

    Cursor getContactsWithPhoneByName(String str);

    void insertAll(List<ContactPhone> list);
}
