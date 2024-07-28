package com.paytm.contactsSdk.models;

import com.paytm.contactsSdk.database.ContactColumn;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ContactPhone {
    private final int contact_id;
    private final int id;
    private final boolean isPrimary;
    private final String phone;

    public static /* synthetic */ ContactPhone copy$default(ContactPhone contactPhone, int i2, int i3, String str, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = contactPhone.id;
        }
        if ((i4 & 2) != 0) {
            i3 = contactPhone.contact_id;
        }
        if ((i4 & 4) != 0) {
            str = contactPhone.phone;
        }
        if ((i4 & 8) != 0) {
            z = contactPhone.isPrimary;
        }
        return contactPhone.copy(i2, i3, str, z);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.contact_id;
    }

    public final String component3() {
        return this.phone;
    }

    public final boolean component4() {
        return this.isPrimary;
    }

    public final ContactPhone copy(int i2, int i3, String str, boolean z) {
        k.c(str, ContactColumn.PHONE_NUMBER);
        return new ContactPhone(i2, i3, str, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactPhone)) {
            return false;
        }
        ContactPhone contactPhone = (ContactPhone) obj;
        return this.id == contactPhone.id && this.contact_id == contactPhone.contact_id && k.a((Object) this.phone, (Object) contactPhone.phone) && this.isPrimary == contactPhone.isPrimary;
    }

    public final int hashCode() {
        int hashCode = ((Integer.valueOf(this.id).hashCode() * 31) + Integer.valueOf(this.contact_id).hashCode()) * 31;
        String str = this.phone;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.isPrimary;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    public final String toString() {
        return "ContactPhone(id=" + this.id + ", contact_id=" + this.contact_id + ", phone=" + this.phone + ", isPrimary=" + this.isPrimary + ")";
    }

    public ContactPhone(int i2, int i3, String str, boolean z) {
        k.c(str, ContactColumn.PHONE_NUMBER);
        this.id = i2;
        this.contact_id = i3;
        this.phone = str;
        this.isPrimary = z;
    }

    public final int getId() {
        return this.id;
    }

    public final int getContact_id() {
        return this.contact_id;
    }

    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContactPhone(int i2, int i3, String str, boolean z, int i4, g gVar) {
        this((i4 & 1) != 0 ? 0 : i2, i3, str, (i4 & 8) != 0 ? false : z);
    }

    public final boolean isPrimary() {
        return this.isPrimary;
    }

    public final String getContactPhoneData() {
        return "contact_id :" + this.contact_id + " phone :" + this.phone + " isPrimary :" + this.isPrimary;
    }
}
