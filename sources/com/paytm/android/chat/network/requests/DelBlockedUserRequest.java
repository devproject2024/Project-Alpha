package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.DelBlockedUserJsonBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.utility.q;

public class DelBlockedUserRequest extends BaseRequest {
    public DelBlockedUserRequest(DelBlockedUserJsonBean delBlockedUserJsonBean, a<String> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.DEL_BLOCK_USER);
        q.d("url:".concat(String.valueOf(url)));
        this.baseData.c("application/json", new f().a((Object) delBlockedUserJsonBean));
        c.a.a.f.b(url, this.baseData, aVar);
    }
}
