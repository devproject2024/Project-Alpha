package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class UserCheckSubscriptionStatus extends IJRDataModel {
    @b(a = "response")
    private final SubscriptionResponse response;
    @b(a = "status")
    private final String status;
    @b(a = "statusCode")
    private final String statusCode;
    @b(a = "statusMessage")
    private final String statusMessage;

    public UserCheckSubscriptionStatus() {
        this((String) null, (String) null, (String) null, (SubscriptionResponse) null, 15, (g) null);
    }

    public static /* synthetic */ UserCheckSubscriptionStatus copy$default(UserCheckSubscriptionStatus userCheckSubscriptionStatus, String str, String str2, String str3, SubscriptionResponse subscriptionResponse, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userCheckSubscriptionStatus.status;
        }
        if ((i2 & 2) != 0) {
            str2 = userCheckSubscriptionStatus.statusCode;
        }
        if ((i2 & 4) != 0) {
            str3 = userCheckSubscriptionStatus.statusMessage;
        }
        if ((i2 & 8) != 0) {
            subscriptionResponse = userCheckSubscriptionStatus.response;
        }
        return userCheckSubscriptionStatus.copy(str, str2, str3, subscriptionResponse);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusCode;
    }

    public final String component3() {
        return this.statusMessage;
    }

    public final SubscriptionResponse component4() {
        return this.response;
    }

    public final UserCheckSubscriptionStatus copy(String str, String str2, String str3, SubscriptionResponse subscriptionResponse) {
        return new UserCheckSubscriptionStatus(str, str2, str3, subscriptionResponse);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserCheckSubscriptionStatus)) {
            return false;
        }
        UserCheckSubscriptionStatus userCheckSubscriptionStatus = (UserCheckSubscriptionStatus) obj;
        return k.a((Object) this.status, (Object) userCheckSubscriptionStatus.status) && k.a((Object) this.statusCode, (Object) userCheckSubscriptionStatus.statusCode) && k.a((Object) this.statusMessage, (Object) userCheckSubscriptionStatus.statusMessage) && k.a((Object) this.response, (Object) userCheckSubscriptionStatus.response);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.statusMessage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SubscriptionResponse subscriptionResponse = this.response;
        if (subscriptionResponse != null) {
            i2 = subscriptionResponse.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "UserCheckSubscriptionStatus(status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", response=" + this.response + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserCheckSubscriptionStatus(String str, String str2, String str3, SubscriptionResponse subscriptionResponse, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : subscriptionResponse);
    }

    public final SubscriptionResponse getResponse() {
        return this.response;
    }

    public UserCheckSubscriptionStatus(String str, String str2, String str3, SubscriptionResponse subscriptionResponse) {
        this.status = str;
        this.statusCode = str2;
        this.statusMessage = str3;
        this.response = subscriptionResponse;
    }
}
