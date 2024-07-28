package com.paytm.contactsSdk.models.requests;

import com.paytm.contactsSdk.database.Tables;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class PostContactRequest {
    private final String contactType;
    private final ArrayList<ContactDetail> contacts;
    private final String deviceId;

    public static /* synthetic */ PostContactRequest copy$default(PostContactRequest postContactRequest, String str, String str2, ArrayList<ContactDetail> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = postContactRequest.deviceId;
        }
        if ((i2 & 2) != 0) {
            str2 = postContactRequest.contactType;
        }
        if ((i2 & 4) != 0) {
            arrayList = postContactRequest.contacts;
        }
        return postContactRequest.copy(str, str2, arrayList);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.contactType;
    }

    public final ArrayList<ContactDetail> component3() {
        return this.contacts;
    }

    public final PostContactRequest copy(String str, String str2, ArrayList<ContactDetail> arrayList) {
        k.c(str, "deviceId");
        k.c(str2, "contactType");
        k.c(arrayList, Tables.CONTACTS);
        return new PostContactRequest(str, str2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostContactRequest)) {
            return false;
        }
        PostContactRequest postContactRequest = (PostContactRequest) obj;
        return k.a((Object) this.deviceId, (Object) postContactRequest.deviceId) && k.a((Object) this.contactType, (Object) postContactRequest.contactType) && k.a((Object) this.contacts, (Object) postContactRequest.contacts);
    }

    public final int hashCode() {
        String str = this.deviceId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contactType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<ContactDetail> arrayList = this.contacts;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "PostContactRequest(deviceId=" + this.deviceId + ", contactType=" + this.contactType + ", contacts=" + this.contacts + ")";
    }

    public PostContactRequest(String str, String str2, ArrayList<ContactDetail> arrayList) {
        k.c(str, "deviceId");
        k.c(str2, "contactType");
        k.c(arrayList, Tables.CONTACTS);
        this.deviceId = str;
        this.contactType = str2;
        this.contacts = arrayList;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final ArrayList<ContactDetail> getContacts() {
        return this.contacts;
    }
}
