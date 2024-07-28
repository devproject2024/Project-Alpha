package net.one97.paytm.upi.common.models;

import kotlin.g.b.k;

public final class UPIDeregister {
    private String error;
    private String response;
    private String status;

    public static /* synthetic */ UPIDeregister copy$default(UPIDeregister uPIDeregister, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uPIDeregister.status;
        }
        if ((i2 & 2) != 0) {
            str2 = uPIDeregister.error;
        }
        if ((i2 & 4) != 0) {
            str3 = uPIDeregister.response;
        }
        return uPIDeregister.copy(str, str2, str3);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.error;
    }

    public final String component3() {
        return this.response;
    }

    public final UPIDeregister copy(String str, String str2, String str3) {
        k.c(str, "status");
        return new UPIDeregister(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UPIDeregister)) {
            return false;
        }
        UPIDeregister uPIDeregister = (UPIDeregister) obj;
        return k.a((Object) this.status, (Object) uPIDeregister.status) && k.a((Object) this.error, (Object) uPIDeregister.error) && k.a((Object) this.response, (Object) uPIDeregister.response);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.error;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.response;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UPIDeregister(status=" + this.status + ", error=" + this.error + ", response=" + this.response + ")";
    }

    public UPIDeregister(String str, String str2, String str3) {
        k.c(str, "status");
        this.status = str;
        this.error = str2;
        this.response = str3;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        k.c(str, "<set-?>");
        this.status = str;
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final String getResponse() {
        return this.response;
    }

    public final void setResponse(String str) {
        this.response = str;
    }
}
