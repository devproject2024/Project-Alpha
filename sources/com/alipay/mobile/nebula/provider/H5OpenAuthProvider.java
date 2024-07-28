package com.alipay.mobile.nebula.provider;

import android.app.Activity;
import com.alibaba.a.e;
import java.util.List;
import java.util.Map;

public interface H5OpenAuthProvider {

    public interface OnGetAuthListener {
        void onResult(e eVar);
    }

    void getAuthCode(Activity activity, String str, String str2, List<String> list, String str3, Map<String, Object> map, boolean z, OnGetAuthListener onGetAuthListener);
}
