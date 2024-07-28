package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class ConfirmImageUpload extends IJRPaytmDataModel {
    @b(a = "payload")
    private final Object ConfirmImageUploadPayload;
    @b(a = "status")
    private final String custId;
    @b(a = "responseCode")
    private final int imageId;
    @b(a = "message")
    private final String message;

    public static /* synthetic */ ConfirmImageUpload copy$default(ConfirmImageUpload confirmImageUpload, String str, int i2, String str2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            str = confirmImageUpload.custId;
        }
        if ((i3 & 2) != 0) {
            i2 = confirmImageUpload.imageId;
        }
        if ((i3 & 4) != 0) {
            str2 = confirmImageUpload.message;
        }
        if ((i3 & 8) != 0) {
            obj = confirmImageUpload.ConfirmImageUploadPayload;
        }
        return confirmImageUpload.copy(str, i2, str2, obj);
    }

    public final String component1() {
        return this.custId;
    }

    public final int component2() {
        return this.imageId;
    }

    public final String component3() {
        return this.message;
    }

    public final Object component4() {
        return this.ConfirmImageUploadPayload;
    }

    public final ConfirmImageUpload copy(String str, int i2, String str2, Object obj) {
        k.c(str, "custId");
        k.c(str2, "message");
        k.c(obj, "ConfirmImageUploadPayload");
        return new ConfirmImageUpload(str, i2, str2, obj);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ConfirmImageUpload) {
                ConfirmImageUpload confirmImageUpload = (ConfirmImageUpload) obj;
                if (k.a((Object) this.custId, (Object) confirmImageUpload.custId)) {
                    if (!(this.imageId == confirmImageUpload.imageId) || !k.a((Object) this.message, (Object) confirmImageUpload.message) || !k.a(this.ConfirmImageUploadPayload, confirmImageUpload.ConfirmImageUploadPayload)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.custId;
        int i2 = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.imageId) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.ConfirmImageUploadPayload;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ConfirmImageUpload(custId=" + this.custId + ", imageId=" + this.imageId + ", message=" + this.message + ", ConfirmImageUploadPayload=" + this.ConfirmImageUploadPayload + ")";
    }

    public final String getCustId() {
        return this.custId;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final String getMessage() {
        return this.message;
    }

    public ConfirmImageUpload(String str, int i2, String str2, Object obj) {
        k.c(str, "custId");
        k.c(str2, "message");
        k.c(obj, "ConfirmImageUploadPayload");
        this.custId = str;
        this.imageId = i2;
        this.message = str2;
        this.ConfirmImageUploadPayload = obj;
    }

    public final Object getConfirmImageUploadPayload() {
        return this.ConfirmImageUploadPayload;
    }
}
