package com.paytm.contactsSdk.database;

public final class ContactColumn {
    public static final String CONTACT_ID = "contact_id";
    public static final ContactColumn INSTANCE = new ContactColumn();
    public static final String IS_PRIMARY = "isPrimary";
    public static final String NAME = "name";
    public static final String PHONE_NUMBER = "phone";

    private ContactColumn() {
    }
}
