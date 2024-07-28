package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.BlockUserJsonBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.utility.q;

public class BlockUserRequest extends BaseRequest {
    public BlockUserRequest(BlockUserJsonBean blockUserJsonBean, a<String> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.ADD_BLOCK_USER);
        q.d("url:".concat(String.valueOf(url)));
        this.baseData.c("application/json", new f().a((Object) blockUserJsonBean));
        c.a.a.f.b(url, this.baseData, aVar);
    }
}
