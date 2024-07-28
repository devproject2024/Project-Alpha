package net.one97.paytm.upi.common.models;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class UserPreference extends IJRPaytmDataModel {
    private final String requestId;
    private final NetworkResponse response;
    private final StatusInfo statusInfo;

    public UserPreference() {
        this((String) null, (NetworkResponse) null, (StatusInfo) null, 7, (g) null);
    }

    public static /* synthetic */ UserPreference copy$default(UserPreference userPreference, String str, NetworkResponse networkResponse, StatusInfo statusInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userPreference.requestId;
        }
        if ((i2 & 2) != 0) {
            networkResponse = userPreference.response;
        }
        if ((i2 & 4) != 0) {
            statusInfo2 = userPreference.statusInfo;
        }
        return userPreference.copy(str, networkResponse, statusInfo2);
    }

    public final String component1() {
        return this.requestId;
    }

    public final NetworkResponse component2() {
        return this.response;
    }

    public final StatusInfo component3() {
        return this.statusInfo;
    }

    public final UserPreference copy(String str, NetworkResponse networkResponse, StatusInfo statusInfo2) {
        return new UserPreference(str, networkResponse, statusInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserPreference)) {
            return false;
        }
        UserPreference userPreference = (UserPreference) obj;
        return k.a((Object) this.requestId, (Object) userPreference.requestId) && k.a((Object) this.response, (Object) userPreference.response) && k.a((Object) this.statusInfo, (Object) userPreference.statusInfo);
    }

    public final int hashCode() {
        String str = this.requestId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        NetworkResponse networkResponse = this.response;
        int hashCode2 = (hashCode + (networkResponse != null ? networkResponse.hashCode() : 0)) * 31;
        StatusInfo statusInfo2 = this.statusInfo;
        if (statusInfo2 != null) {
            i2 = statusInfo2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UserPreference(requestId=" + this.requestId + ", response=" + this.response + ", statusInfo=" + this.statusInfo + ")";
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final NetworkResponse getResponse() {
        return this.response;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserPreference(String str, NetworkResponse networkResponse, StatusInfo statusInfo2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : networkResponse, (i2 & 4) != 0 ? null : statusInfo2);
    }

    public final StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public UserPreference(String str, NetworkResponse networkResponse, StatusInfo statusInfo2) {
        this.requestId = str;
        this.response = networkResponse;
        this.statusInfo = statusInfo2;
    }
}
