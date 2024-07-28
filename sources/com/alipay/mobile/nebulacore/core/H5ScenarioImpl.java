package com.alipay.mobile.nebulacore.core;

import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.h5container.api.H5Scenario;
import com.alipay.mobile.nebulacore.data.H5PrefData;

public class H5ScenarioImpl implements H5Scenario {
    public static final String TAG = "H5Scenario";
    private H5Data data;
    private String name;

    public H5ScenarioImpl(String str) {
        setName(str);
    }

    public H5Data getData() {
        return this.data;
    }

    public void setData(H5Data h5Data) {
        this.data = h5Data;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
        this.data = new H5PrefData(str);
    }
}
