package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityButtonObjectV2 implements IJRDataModel {
    @b(a = "prefetch")
    private Map<String, CJRUtilityPrefetchV2> prefetchMap;

    public Map<String, CJRUtilityPrefetchV2> getPrefetchMap() {
        return this.prefetchMap;
    }

    public void setPrefetchMap(Map<String, CJRUtilityPrefetchV2> map) {
        this.prefetchMap = map;
    }
}
