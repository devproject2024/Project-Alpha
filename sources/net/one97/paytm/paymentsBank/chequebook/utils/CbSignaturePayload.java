package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbSignaturePayload extends IJRPaytmDataModel {
    @b(a = "approvedAt")
    private final Long approvedAt;
    @b(a = "approver")
    private final String approver;
    @b(a = "custId")
    private final String custId;
    @b(a = "imageId")
    private final String imageId;
    @b(a = "status")
    private final String status;
    @b(a = "uploadedAt")
    private final Long uploadedAt;
    @b(a = "url")
    private final String url;

    public static /* synthetic */ CbSignaturePayload copy$default(CbSignaturePayload cbSignaturePayload, String str, String str2, String str3, String str4, String str5, Long l, Long l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbSignaturePayload.custId;
        }
        if ((i2 & 2) != 0) {
            str2 = cbSignaturePayload.status;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = cbSignaturePayload.imageId;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = cbSignaturePayload.url;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = cbSignaturePayload.approver;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            l = cbSignaturePayload.uploadedAt;
        }
        Long l3 = l;
        if ((i2 & 64) != 0) {
            l2 = cbSignaturePayload.approvedAt;
        }
        return cbSignaturePayload.copy(str, str6, str7, str8, str9, l3, l2);
    }

    public final String component1() {
        return this.custId;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.imageId;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.approver;
    }

    public final Long component6() {
        return this.uploadedAt;
    }

    public final Long component7() {
        return this.approvedAt;
    }

    public final CbSignaturePayload copy(String str, String str2, String str3, String str4, String str5, Long l, Long l2) {
        return new CbSignaturePayload(str, str2, str3, str4, str5, l, l2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbSignaturePayload)) {
            return false;
        }
        CbSignaturePayload cbSignaturePayload = (CbSignaturePayload) obj;
        return k.a((Object) this.custId, (Object) cbSignaturePayload.custId) && k.a((Object) this.status, (Object) cbSignaturePayload.status) && k.a((Object) this.imageId, (Object) cbSignaturePayload.imageId) && k.a((Object) this.url, (Object) cbSignaturePayload.url) && k.a((Object) this.approver, (Object) cbSignaturePayload.approver) && k.a((Object) this.uploadedAt, (Object) cbSignaturePayload.uploadedAt) && k.a((Object) this.approvedAt, (Object) cbSignaturePayload.approvedAt);
    }

    public final int hashCode() {
        String str = this.custId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imageId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.approver;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Long l = this.uploadedAt;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.approvedAt;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CbSignaturePayload(custId=" + this.custId + ", status=" + this.status + ", imageId=" + this.imageId + ", url=" + this.url + ", approver=" + this.approver + ", uploadedAt=" + this.uploadedAt + ", approvedAt=" + this.approvedAt + ")";
    }

    public final String getCustId() {
        return this.custId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getApprover() {
        return this.approver;
    }

    public final Long getUploadedAt() {
        return this.uploadedAt;
    }

    public CbSignaturePayload(String str, String str2, String str3, String str4, String str5, Long l, Long l2) {
        this.custId = str;
        this.status = str2;
        this.imageId = str3;
        this.url = str4;
        this.approver = str5;
        this.uploadedAt = l;
        this.approvedAt = l2;
    }

    public final Long getApprovedAt() {
        return this.approvedAt;
    }
}
