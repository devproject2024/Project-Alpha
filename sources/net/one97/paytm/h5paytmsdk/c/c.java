package net.one97.paytm.h5paytmsdk.c;

import android.text.TextUtils;
import com.alibaba.a.a;
import com.alibaba.a.g;
import com.alipay.iap.android.webapp.sdk.provider.BaseJSApiPermissionProvider;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.List;
import java.util.Map;

public final class c extends BaseJSApiPermissionProvider {
    public final boolean hasThisPermission(String str, String str2) {
        return false;
    }

    public final boolean hasDomainPermission(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.startsWith("file://")) {
            return super.hasDomainPermission(str, str2);
        }
        return true;
    }

    public final Map<String, List<String>> getJSApiPermissionConfig() {
        try {
            return (Map) a.parseObject(H5Environment.getConfig("jsapiPermission"), new g<Map<String, List<String>>>() {
            }, new com.alibaba.a.b.c[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.alipay.iap.android.common.b.c.j();
            return null;
        }
    }
}
