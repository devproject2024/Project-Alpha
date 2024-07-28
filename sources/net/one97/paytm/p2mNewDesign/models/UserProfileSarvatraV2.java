package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class UserProfileSarvatraV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "priority")
    private String priority;
    @b(a = "response")
    private ResponseV2 response;
    @b(a = "status")
    private String status;

    public UserProfileSarvatraV2() {
        this((ResponseV2) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ UserProfileSarvatraV2 copy$default(UserProfileSarvatraV2 userProfileSarvatraV2, ResponseV2 responseV2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            responseV2 = userProfileSarvatraV2.response;
        }
        if ((i2 & 2) != 0) {
            str = userProfileSarvatraV2.priority;
        }
        if ((i2 & 4) != 0) {
            str2 = userProfileSarvatraV2.status;
        }
        return userProfileSarvatraV2.copy(responseV2, str, str2);
    }

    public final ResponseV2 component1() {
        return this.response;
    }

    public final String component2() {
        return this.priority;
    }

    public final String component3() {
        return this.status;
    }

    public final UserProfileSarvatraV2 copy(ResponseV2 responseV2, String str, String str2) {
        return new UserProfileSarvatraV2(responseV2, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserProfileSarvatraV2)) {
            return false;
        }
        UserProfileSarvatraV2 userProfileSarvatraV2 = (UserProfileSarvatraV2) obj;
        return k.a((Object) this.response, (Object) userProfileSarvatraV2.response) && k.a((Object) this.priority, (Object) userProfileSarvatraV2.priority) && k.a((Object) this.status, (Object) userProfileSarvatraV2.status);
    }

    public final int hashCode() {
        ResponseV2 responseV2 = this.response;
        int i2 = 0;
        int hashCode = (responseV2 != null ? responseV2.hashCode() : 0) * 31;
        String str = this.priority;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.status;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UserProfileSarvatraV2(response=" + this.response + ", priority=" + this.priority + ", status=" + this.status + ")";
    }

    public final ResponseV2 getResponse() {
        return this.response;
    }

    public final void setResponse(ResponseV2 responseV2) {
        this.response = responseV2;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final void setPriority(String str) {
        this.priority = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserProfileSarvatraV2(ResponseV2 responseV2, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : responseV2, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public UserProfileSarvatraV2(ResponseV2 responseV2, String str, String str2) {
        this.response = responseV2;
        this.priority = str;
        this.status = str2;
    }
}
