package net.one97.paytm.h5paytmsdk.c;

import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;

public final class a implements H5ConfigProvider {
    public final void clearProcessCache() {
    }

    public final boolean isAliDomains(String str) {
        return false;
    }

    public final boolean isAlipayDomains(String str) {
        return false;
    }

    public final boolean isPartnerDomains(String str) {
        return false;
    }

    public final boolean isRpcDomains(String str) {
        return false;
    }

    public final boolean isSeriousAliDomains(String str) {
        return false;
    }

    public final boolean permitLocation(String str) {
        return false;
    }

    public final String getConfig(String str) {
        return com.alipay.plus.android.a.a.a.a().c(str);
    }

    public final e getConfigJSONObject(String str) {
        return com.alipay.plus.android.a.a.a.a().a(str);
    }

    public final b getConfigJSONArray(String str) {
        return com.alipay.plus.android.a.a.a.a().b(str);
    }

    public final String getConfigWithNotifyChange(String str, final H5ConfigProvider.OnConfigChangeListener onConfigChangeListener) {
        com.alipay.plus.android.a.a.a a2 = com.alipay.plus.android.a.a.a.a();
        a2.f15173f.a(str, new Object() {
        });
        return com.alipay.plus.android.a.a.a.a().c(str);
    }

    public final String getConfigWithProcessCache(String str) {
        return com.alipay.plus.android.a.a.a.a().c(str);
    }
}
