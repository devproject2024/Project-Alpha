package com.paytm.contactsSdk.models;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.k;

public final class ContactProviderData {
    private final LinkedHashMap<Integer, ContactWithPhones> contactsIDAndDataMap;
    private final List<Integer> deletedContactIdList;

    public static /* synthetic */ ContactProviderData copy$default(ContactProviderData contactProviderData, LinkedHashMap<Integer, ContactWithPhones> linkedHashMap, List<Integer> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            linkedHashMap = contactProviderData.contactsIDAndDataMap;
        }
        if ((i2 & 2) != 0) {
            list = contactProviderData.deletedContactIdList;
        }
        return contactProviderData.copy(linkedHashMap, list);
    }

    public final LinkedHashMap<Integer, ContactWithPhones> component1() {
        return this.contactsIDAndDataMap;
    }

    public final List<Integer> component2() {
        return this.deletedContactIdList;
    }

    public final ContactProviderData copy(LinkedHashMap<Integer, ContactWithPhones> linkedHashMap, List<Integer> list) {
        k.c(linkedHashMap, "contactsIDAndDataMap");
        k.c(list, "deletedContactIdList");
        return new ContactProviderData(linkedHashMap, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactProviderData)) {
            return false;
        }
        ContactProviderData contactProviderData = (ContactProviderData) obj;
        return k.a((Object) this.contactsIDAndDataMap, (Object) contactProviderData.contactsIDAndDataMap) && k.a((Object) this.deletedContactIdList, (Object) contactProviderData.deletedContactIdList);
    }

    public final int hashCode() {
        LinkedHashMap<Integer, ContactWithPhones> linkedHashMap = this.contactsIDAndDataMap;
        int i2 = 0;
        int hashCode = (linkedHashMap != null ? linkedHashMap.hashCode() : 0) * 31;
        List<Integer> list = this.deletedContactIdList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ContactProviderData(contactsIDAndDataMap=" + this.contactsIDAndDataMap + ", deletedContactIdList=" + this.deletedContactIdList + ")";
    }

    public ContactProviderData(LinkedHashMap<Integer, ContactWithPhones> linkedHashMap, List<Integer> list) {
        k.c(linkedHashMap, "contactsIDAndDataMap");
        k.c(list, "deletedContactIdList");
        this.contactsIDAndDataMap = linkedHashMap;
        this.deletedContactIdList = list;
    }

    public final LinkedHashMap<Integer, ContactWithPhones> getContactsIDAndDataMap() {
        return this.contactsIDAndDataMap;
    }

    public final List<Integer> getDeletedContactIdList() {
        return this.deletedContactIdList;
    }
}
