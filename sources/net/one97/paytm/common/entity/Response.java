package net.one97.paytm.common.entity;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;

public final class Response {
    private final String contactType;
    private final List<ContactsResponse> contacts;
    private final long timeStamp;
    private final int totalCount;

    public static /* synthetic */ Response copy$default(Response response, String str, List<ContactsResponse> list, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = response.contactType;
        }
        if ((i3 & 2) != 0) {
            list = response.contacts;
        }
        List<ContactsResponse> list2 = list;
        if ((i3 & 4) != 0) {
            j = response.timeStamp;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            i2 = response.totalCount;
        }
        return response.copy(str, list2, j2, i2);
    }

    public final String component1() {
        return this.contactType;
    }

    public final List<ContactsResponse> component2() {
        return this.contacts;
    }

    public final long component3() {
        return this.timeStamp;
    }

    public final int component4() {
        return this.totalCount;
    }

    public final Response copy(String str, List<? extends ContactsResponse> list, long j, int i2) {
        return new Response(str, list, j, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return k.a((Object) this.contactType, (Object) response.contactType) && k.a((Object) this.contacts, (Object) response.contacts) && this.timeStamp == response.timeStamp && this.totalCount == response.totalCount;
    }

    public final int hashCode() {
        String str = this.contactType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ContactsResponse> list = this.contacts;
        if (list != null) {
            i2 = list.hashCode();
        }
        long j = this.timeStamp;
        return ((((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.totalCount;
    }

    public final String toString() {
        return "Response(contactType=" + this.contactType + ", contacts=" + this.contacts + ", timeStamp=" + this.timeStamp + ", totalCount=" + this.totalCount + ")";
    }

    public Response(String str, List<? extends ContactsResponse> list, long j, int i2) {
        this.contactType = str;
        this.contacts = list;
        this.timeStamp = j;
        this.totalCount = i2;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final List<ContactsResponse> getContacts() {
        return this.contacts;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }
}
