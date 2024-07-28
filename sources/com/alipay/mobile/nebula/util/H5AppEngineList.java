package com.alipay.mobile.nebula.util;

import com.alipay.mobile.h5container.service.H5Service;
import java.util.ArrayList;
import java.util.List;

public class H5AppEngineList {
    public static List<String> appEngineList;

    static {
        ArrayList arrayList = new ArrayList();
        appEngineList = arrayList;
        arrayList.add(H5Service.H5APP_ENGINE_TYPE);
        appEngineList.add("tinyApp");
        appEngineList.add("BNApp");
    }
}
