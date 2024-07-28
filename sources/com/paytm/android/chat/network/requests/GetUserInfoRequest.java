package com.paytm.android.chat.network.requests;

import c.a.a.a;
import c.a.a.f;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.network.response.ResponseOfUserInfo;

public class GetUserInfoRequest extends BaseRequest {
    public GetUserInfoRequest(String str, a<ResponseOfUserInfo> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.GET_USER_INFO);
        this.baseData.a("userId", str);
        f.b(url, this.baseData, aVar);
    }
}
