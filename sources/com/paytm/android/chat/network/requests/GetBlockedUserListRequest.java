package com.paytm.android.chat.network.requests;

import c.a.a.a;
import c.a.a.f;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.network.response.ResponseOfBlockedUserList;

public class GetBlockedUserListRequest extends BaseRequest {
    public GetBlockedUserListRequest(Long l, a<ResponseOfBlockedUserList> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.GET_BLOCK_USERLIST);
        this.baseData.a("userId", String.valueOf(l.longValue()));
        f.a(url, this.baseData, aVar);
    }
}
