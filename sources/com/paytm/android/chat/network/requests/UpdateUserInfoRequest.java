package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.UpdateUserJsonBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.utils.SharedPreferencesUtil;

public class UpdateUserInfoRequest extends BaseRequest {
    public UpdateUserInfoRequest(UpdateUserJsonBean updateUserJsonBean, a<String> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.UPDATE_USER_INFO);
        updateUserJsonBean.setUserId(SharedPreferencesUtil.getUserId());
        this.baseData.c("application/json", new f().a((Object) updateUserJsonBean));
        c.a.a.f.b(url, this.baseData, aVar);
    }
}
