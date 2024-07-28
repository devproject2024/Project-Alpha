package com.alipay.mobile.nebula.util.monitor;

import com.alipay.mobile.h5container.api.H5Param;
import java.util.ArrayList;
import java.util.List;

public class H5JSApiMonitorFilter {
    private static List<String> jSApiMonitorList;

    static {
        ArrayList arrayList = new ArrayList();
        jSApiMonitorList = arrayList;
        arrayList.add(H5Param.MONITOR_PERFORMANCE);
        jSApiMonitorList.add("");
    }

    public static boolean shouldFilter(String str) {
        return jSApiMonitorList.contains(str);
    }
}
