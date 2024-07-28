package com.alipay.mobile.nebula.provider;

import com.alibaba.a.e;

public interface H5TraceProvider {
    void event(String str, String str2, e eVar);

    void sessionBegin(String str, String str2, e eVar);

    void sessionEnd(String str, String str2, e eVar);
}
