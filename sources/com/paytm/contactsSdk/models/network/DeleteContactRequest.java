package com.paytm.contactsSdk.models.network;

import com.paytm.contactsSdk.constant.ContactsConstant;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class DeleteContactRequest {
    private final List<Integer> contactId;
    private final String contactType;
    private final String deviceId;

    public static /* synthetic */ DeleteContactRequest copy$default(DeleteContactRequest deleteContactRequest, String str, String str2, List<Integer> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deleteContactRequest.deviceId;
        }
        if ((i2 & 2) != 0) {
            str2 = deleteContactRequest.contactType;
        }
        if ((i2 & 4) != 0) {
            list = deleteContactRequest.contactId;
        }
        return deleteContactRequest.copy(str, str2, list);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.contactType;
    }

    public final List<Integer> component3() {
        return this.contactId;
    }

    public final DeleteContactRequest copy(String str, String str2, List<Integer> list) {
        k.c(str, "deviceId");
        k.c(str2, "contactType");
        k.c(list, "contactId");
        return new DeleteContactRequest(str, str2, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteContactRequest)) {
            return false;
        }
        DeleteContactRequest deleteContactRequest = (DeleteContactRequest) obj;
        return k.a((Object) this.deviceId, (Object) deleteContactRequest.deviceId) && k.a((Object) this.contactType, (Object) deleteContactRequest.contactType) && k.a((Object) this.contactId, (Object) deleteContactRequest.contactId);
    }

    public final int hashCode() {
        String str = this.deviceId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contactType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Integer> list = this.contactId;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "DeleteContactRequest(deviceId=" + this.deviceId + ", contactType=" + this.contactType + ", contactId=" + this.contactId + ")";
    }

    public DeleteContactRequest(String str, String str2, List<Integer> list) {
        k.c(str, "deviceId");
        k.c(str2, "contactType");
        k.c(list, "contactId");
        this.deviceId = str;
        this.contactType = str2;
        this.contactId = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeleteContactRequest(String str, String str2, List list, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? ContactsConstant.CONTACT_TYPE_VALUE : str2, list);
    }

    public final List<Integer> getContactId() {
        return this.contactId;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
