package com.paytm.contactsSdk.api.callback;

import android.database.Cursor;
import com.paytm.contactsSdk.api.p002enum.ContactsErrorType;

public interface ContactsQueryCallback {
    void onContactsAvailable(Cursor cursor, ContactsErrorType contactsErrorType);
}
