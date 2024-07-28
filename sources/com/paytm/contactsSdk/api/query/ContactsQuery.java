package com.paytm.contactsSdk.api.query;

import com.paytm.contactsSdk.api.p002enum.ContactsConsentStrategy;
import com.paytm.contactsSdk.api.p002enum.FetchContactType;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ContactsQuery {
    private final ContactsConsentStrategy contactsConsentStrategy;
    private final int offset;
    private final int pageSize;
    private final FetchContactType queryType;
    private final String searchName;
    private final String searchNumber;

    private ContactsQuery(int i2, int i3, FetchContactType fetchContactType, String str, String str2, ContactsConsentStrategy contactsConsentStrategy2) {
        this.offset = i2;
        this.pageSize = i3;
        this.queryType = fetchContactType;
        this.searchName = str;
        this.searchNumber = str2;
        this.contactsConsentStrategy = contactsConsentStrategy2;
    }

    public /* synthetic */ ContactsQuery(int i2, int i3, FetchContactType fetchContactType, String str, String str2, ContactsConsentStrategy contactsConsentStrategy2, g gVar) {
        this(i2, i3, fetchContactType, str, str2, contactsConsentStrategy2);
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final FetchContactType getQueryType() {
        return this.queryType;
    }

    public final String getSearchName() {
        return this.searchName;
    }

    public final String getSearchNumber() {
        return this.searchNumber;
    }

    public final ContactsConsentStrategy getContactsConsentStrategy() {
        return this.contactsConsentStrategy;
    }

    public static final class Builder {
        private ContactsConsentStrategy contactsConsentStrategy = ContactsConsentStrategy.NO_CONSENT_CHECK;
        private int offset;
        private int pageSize = 50;
        private FetchContactType queryType = FetchContactType.ALL;
        private String searchName = "";
        private String searchNumber = "";

        public final Builder offset(int i2) {
            Builder builder = this;
            builder.offset = i2;
            return builder;
        }

        public final Builder queryType(FetchContactType fetchContactType) {
            k.c(fetchContactType, "queryType");
            Builder builder = this;
            builder.queryType = fetchContactType;
            return builder;
        }

        public final Builder searchName(String str) {
            k.c(str, "searchName");
            Builder builder = this;
            builder.searchName = str;
            return builder;
        }

        public final Builder pageSize(int i2) {
            Builder builder = this;
            builder.pageSize = i2;
            return builder;
        }

        public final ContactsQuery build() {
            return new ContactsQuery(this.offset, this.pageSize, this.queryType, this.searchName, this.searchNumber, this.contactsConsentStrategy, (g) null);
        }
    }
}
