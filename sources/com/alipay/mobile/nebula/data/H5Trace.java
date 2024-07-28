package com.alipay.mobile.nebula.data;

import com.alibaba.a.e;
import com.alipay.mobile.nebula.provider.H5TraceProvider;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5Trace {
    private static boolean sEnabled = false;

    public static void setEnabled(boolean z) {
        sEnabled = z;
    }

    public static boolean isTraceEnable() {
        return sEnabled;
    }

    private static e formatParam(String[] strArr) {
        e eVar = new e();
        if (!(strArr == null || strArr.length == 0)) {
            int i2 = 0;
            while (i2 < strArr.length / 2) {
                String str = strArr[i2];
                i2++;
                eVar.put(str, (Object) strArr[i2]);
            }
        }
        return eVar;
    }

    public static void event(String str, String str2, String... strArr) {
        H5TraceProvider h5TraceProvider;
        if (isTraceEnable() && (h5TraceProvider = (H5TraceProvider) H5Utils.getProvider(H5TraceProvider.class.getName())) != null) {
            h5TraceProvider.event(str, str2, formatParam(strArr));
        }
    }

    public static void sessionBegin(String str, String str2, String... strArr) {
        H5TraceProvider h5TraceProvider;
        if (isTraceEnable() && (h5TraceProvider = (H5TraceProvider) H5Utils.getProvider(H5TraceProvider.class.getName())) != null) {
            h5TraceProvider.sessionBegin(str, str2, formatParam(strArr));
        }
    }

    public static void sessionEnd(String str, String str2, String... strArr) {
        H5TraceProvider h5TraceProvider;
        if (isTraceEnable() && (h5TraceProvider = (H5TraceProvider) H5Utils.getProvider(H5TraceProvider.class.getName())) != null) {
            h5TraceProvider.sessionEnd(str, str2, formatParam(strArr));
        }
    }
}
