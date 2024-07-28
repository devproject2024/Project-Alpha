package com.alipay.iap.android.webapp.sdk.utils;

import com.alibaba.a.b.c;
import com.alibaba.a.g;
import com.alipay.mobile.b.b.a;

public class JsonUtils {
    public static <T> T parseObject(String str, g<T> gVar) throws a {
        try {
            return com.alibaba.a.a.parseObject(str, gVar, new c[0]);
        } catch (Exception unused) {
            com.alipay.iap.android.common.b.c.j();
            throw new a((Integer) 10, "parse json " + str + " for type " + gVar + " failed");
        }
    }

    public static String toJSONString(Object obj) {
        return com.alibaba.a.a.toJSONString(obj);
    }
}
