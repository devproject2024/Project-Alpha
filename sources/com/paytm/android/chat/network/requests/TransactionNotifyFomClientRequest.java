package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.android.chat.e;
import com.paytm.android.chat.network.response.TransactionNotifyResponse;
import com.paytm.android.chat.utils.ChatGTMConstants;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class TransactionNotifyFomClientRequest extends BaseRequest {
    public TransactionNotifyFomClientRequest(TxNotifyData txNotifyData, a<TransactionNotifyResponse> aVar) {
        String a2 = e.a().a(ChatGTMConstants.CHAT_NOTIFY_PAYMENT_STATUS, SDKConstants.KEY_STAGING_API.equalsIgnoreCase(e.a().a()) ? "https://digitalproxy-staging.paytm.com/pcchat/api/user/txNotify" : "https://digitalproxy.paytm.com/pcchat/api/user/txNotify");
        this.baseData.c("application/json", new f().a((Object) txNotifyData));
        c.a.a.f.b(a2, this.baseData, aVar);
    }
}
