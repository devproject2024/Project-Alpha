package com.paytm.contactsSdk.api.model;

import com.paytm.contactsSdk.api.p002enum.ContactsErrorType;
import kotlin.g.b.k;

public final class ContactsSDKState {
    private final ContactsErrorType contactsSDKError;
    private final boolean contactsSDKReady;

    public static /* synthetic */ ContactsSDKState copy$default(ContactsSDKState contactsSDKState, boolean z, ContactsErrorType contactsErrorType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = contactsSDKState.contactsSDKReady;
        }
        if ((i2 & 2) != 0) {
            contactsErrorType = contactsSDKState.contactsSDKError;
        }
        return contactsSDKState.copy(z, contactsErrorType);
    }

    public final boolean component1() {
        return this.contactsSDKReady;
    }

    public final ContactsErrorType component2() {
        return this.contactsSDKError;
    }

    public final ContactsSDKState copy(boolean z, ContactsErrorType contactsErrorType) {
        k.c(contactsErrorType, "contactsSDKError");
        return new ContactsSDKState(z, contactsErrorType);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactsSDKState)) {
            return false;
        }
        ContactsSDKState contactsSDKState = (ContactsSDKState) obj;
        return this.contactsSDKReady == contactsSDKState.contactsSDKReady && k.a((Object) this.contactsSDKError, (Object) contactsSDKState.contactsSDKError);
    }

    public final int hashCode() {
        boolean z = this.contactsSDKReady;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        ContactsErrorType contactsErrorType = this.contactsSDKError;
        return i2 + (contactsErrorType != null ? contactsErrorType.hashCode() : 0);
    }

    public final String toString() {
        return "ContactsSDKState(contactsSDKReady=" + this.contactsSDKReady + ", contactsSDKError=" + this.contactsSDKError + ")";
    }

    public ContactsSDKState(boolean z, ContactsErrorType contactsErrorType) {
        k.c(contactsErrorType, "contactsSDKError");
        this.contactsSDKReady = z;
        this.contactsSDKError = contactsErrorType;
    }

    public final ContactsErrorType getContactsSDKError() {
        return this.contactsSDKError;
    }

    public final boolean getContactsSDKReady() {
        return this.contactsSDKReady;
    }
}
