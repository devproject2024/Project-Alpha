package com.paytm.android.chat.data.models.users.payments;

import com.google.gsonhtcfix.a.b;
import com.paytm.android.chat.network.response.ResponseBase;
import kotlin.g.b.g;

public final class GetUserInfoByIdsResponse extends ResponseBase {
    @b(a = "data")
    private UserInfoByIdsData data;
    private int statusCode;

    public GetUserInfoByIdsResponse() {
        this((UserInfoByIdsData) null, 1, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetUserInfoByIdsResponse(UserInfoByIdsData userInfoByIdsData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : userInfoByIdsData);
    }

    public final UserInfoByIdsData getData() {
        return this.data;
    }

    public final void setData(UserInfoByIdsData userInfoByIdsData) {
        this.data = userInfoByIdsData;
    }

    public GetUserInfoByIdsResponse(UserInfoByIdsData userInfoByIdsData) {
        this.data = userInfoByIdsData;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(int i2) {
        this.statusCode = i2;
    }
}
