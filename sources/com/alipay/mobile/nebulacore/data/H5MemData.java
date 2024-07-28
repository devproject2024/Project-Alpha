package com.alipay.mobile.nebulacore.data;

import com.alipay.mobile.h5container.api.H5Data;
import java.util.HashMap;
import java.util.Map;

public class H5MemData implements H5Data {
    private Map<String, String> map = new HashMap();

    public void set(String str, String str2) {
        this.map.put(str, str2);
    }

    public String get(String str) {
        return this.map.get(str);
    }

    public String remove(String str) {
        return this.map.remove(str);
    }

    public boolean has(String str) {
        return this.map.containsKey(str);
    }
}
