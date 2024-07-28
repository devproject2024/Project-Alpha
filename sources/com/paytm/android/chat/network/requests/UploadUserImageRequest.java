package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.UploadImageJsonBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.q;

public class UploadUserImageRequest extends BaseRequest {
    public UploadUserImageRequest(UploadImageJsonBean uploadImageJsonBean, a<String> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.UPLOAD_USER_IMAGE);
        if (SharedPreferencesUtil.getUserId() != null && !SharedPreferencesUtil.getUserId().isEmpty()) {
            uploadImageJsonBean.setUserId(Long.valueOf(SharedPreferencesUtil.getUserId()));
        }
        this.baseData.c("application/json", new f().a((Object) uploadImageJsonBean));
        q.d(new f().a((Object) uploadImageJsonBean));
        c.a.a.f.b(url, this.baseData, aVar);
    }
}
