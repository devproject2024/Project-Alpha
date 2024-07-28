package com.paytm.android.chat;

import android.content.Context;
import com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean;
import java.util.HashMap;

public interface d {

    public interface a {
        void a(PFPaymentStatusBean pFPaymentStatusBean);
    }

    String a();

    void a(Context context);

    void a(Context context, String str);

    void a(Context context, String str, String str2, a aVar);

    void a(Context context, String str, String str2, String str3);

    void a(HashMap<String, Object> hashMap);

    String b();

    String c();
}
