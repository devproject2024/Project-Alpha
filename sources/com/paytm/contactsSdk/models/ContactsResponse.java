package com.paytm.contactsSdk.models;

import java.util.ArrayList;

public final class ContactsResponse {
    private final ArrayList<ContactWithPhones> contactsList = new ArrayList<>();

    public final ArrayList<ContactWithPhones> getContactsList() {
        return this.contactsList;
    }
}
