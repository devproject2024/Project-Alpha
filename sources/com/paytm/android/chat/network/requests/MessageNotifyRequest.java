package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.MessageNotifyBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.utility.q;

public class MessageNotifyRequest extends BaseRequest {
    public MessageNotifyRequest(MessageNotifyBean messageNotifyBean, final a<String> aVar) {
        String url = UrlManager.getUrl(UrlProfileList.MSG_NOTIFY);
        q.d("url:".concat(String.valueOf(url)));
        String a2 = new f().a((Object) messageNotifyBean);
        this.baseData.c("application/json", a2);
        q.d("body:".concat(String.valueOf(a2)));
        c.a.a.f.b(url, this.baseData, new a<String>() {
            public final /* synthetic */ void a(Object obj) {
                q.a("onSuccess:".concat(String.valueOf((String) obj)));
            }

            public final void a(int i2, String str) {
                q.b("onFailure[" + i2 + "]" + str);
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i2, str);
                }
            }
        });
    }
}
