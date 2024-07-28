package com.paytm.contactsSdk.database;

public final class Tables {
    public static final String CONTACTS = "contacts";
    public static final String CONTACTS_DELETED = "contacts_deleted";
    public static final String CONTACTS_PHONES = "contacts_phones";
    public static final String CONTACTS_SYNC = "contacts_sync";
    public static final String DYNAMIC_MAPPING = "dynamic_mapping";
    public static final String ENRICHMENT_DATA = "enrichment_data";
    public static final Tables INSTANCE = new Tables();

    private Tables() {
    }
}
