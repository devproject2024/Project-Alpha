package com.paytm.contactsSdk.models;

import kotlin.g.b.k;

public final class Contact {
    private final int id;
    private final String name;
    private final int syncType;

    public static /* synthetic */ Contact copy$default(Contact contact, int i2, String str, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = contact.id;
        }
        if ((i4 & 2) != 0) {
            str = contact.name;
        }
        if ((i4 & 4) != 0) {
            i3 = contact.syncType;
        }
        return contact.copy(i2, str, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.syncType;
    }

    public final Contact copy(int i2, String str, int i3) {
        k.c(str, "name");
        return new Contact(i2, str, i3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) obj;
        return this.id == contact.id && k.a((Object) this.name, (Object) contact.name) && this.syncType == contact.syncType;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.id).hashCode() * 31;
        String str = this.name;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.syncType).hashCode();
    }

    public final String toString() {
        return "Contact(id=" + this.id + ", name=" + this.name + ", syncType=" + this.syncType + ")";
    }

    public Contact(int i2, String str, int i3) {
        k.c(str, "name");
        this.id = i2;
        this.name = str;
        this.syncType = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSyncType() {
        return this.syncType;
    }
}
