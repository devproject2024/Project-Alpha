package com.alipay.mobile.nebula.appcenter.apphandler;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H5AppCreditInfo {
    private Map<String, List<String>> creditMap = new HashMap();
    private Map<Integer, List<String>> strategyMap = new HashMap();

    public Map<Integer, List<String>> getStrategyMap() {
        return this.strategyMap;
    }

    public Map<String, List<String>> getCreditMap() {
        return this.creditMap;
    }

    public void addCreditAppInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!this.creditMap.containsKey(str) || this.creditMap.get(str) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                this.creditMap.put(str, arrayList);
                return;
            }
            this.creditMap.get(str).add(str2);
        }
    }

    public void addStrategyInfo(int i2, List<String> list) {
        if (list != null && list.size() != 0) {
            if (!this.strategyMap.containsKey(Integer.valueOf(i2)) || this.strategyMap.get(Integer.valueOf(i2)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                this.strategyMap.put(Integer.valueOf(i2), arrayList);
                return;
            }
            this.strategyMap.get(Integer.valueOf(i2)).addAll(list);
        }
    }

    public String toString() {
        return "H5AppCreditInfo{strategyMap=" + this.strategyMap + ", creditMap=" + this.creditMap + '}';
    }
}
