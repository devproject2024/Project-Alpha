package net.one97.paytm.contacts.entities.db_entities;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class NonExistedContacts implements IJRDataModel {
    private String contactId;
    private long id;
    private Integer type;

    public static /* synthetic */ NonExistedContacts copy$default(NonExistedContacts nonExistedContacts, long j, String str, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = nonExistedContacts.id;
        }
        if ((i2 & 2) != 0) {
            str = nonExistedContacts.contactId;
        }
        if ((i2 & 4) != 0) {
            num = nonExistedContacts.type;
        }
        return nonExistedContacts.copy(j, str, num);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.contactId;
    }

    public final Integer component3() {
        return this.type;
    }

    public final NonExistedContacts copy(long j, String str, Integer num) {
        k.c(str, "contactId");
        return new NonExistedContacts(j, str, num);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NonExistedContacts) {
                NonExistedContacts nonExistedContacts = (NonExistedContacts) obj;
                if (!(this.id == nonExistedContacts.id) || !k.a((Object) this.contactId, (Object) nonExistedContacts.contactId) || !k.a((Object) this.type, (Object) nonExistedContacts.type)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.id;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.contactId;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.type;
        if (num != null) {
            i3 = num.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "NonExistedContacts(id=" + this.id + ", contactId=" + this.contactId + ", type=" + this.type + ")";
    }

    public NonExistedContacts(long j, String str, Integer num) {
        k.c(str, "contactId");
        this.id = j;
        this.contactId = str;
        this.type = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NonExistedContacts(long j, String str, Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : j, str, num);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getContactId() {
        return this.contactId;
    }

    public final void setContactId(String str) {
        k.c(str, "<set-?>");
        this.contactId = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }
}
