package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2;

public class CJRUtilityButtonObjectV4 implements IJRDataModel {
    @b(a = "prefetch")
    private List<CJRUtilityPrefetchV2> prefetch;
    private Map<String, CJRUtilityPrefetchV2> prefetchMap;

    public Map<String, CJRUtilityPrefetchV2> getPrefetchMap() {
        List<CJRUtilityPrefetchV2> list = this.prefetch;
        if (list != null && !list.isEmpty() && this.prefetchMap == null) {
            this.prefetchMap = new HashMap(this.prefetch.size());
            for (int i2 = 0; i2 < this.prefetch.size(); i2++) {
                this.prefetchMap.put(String.valueOf(i2), this.prefetch.get(i2));
            }
        }
        return this.prefetchMap;
    }

    public void setPrefetchMap(Map<String, CJRUtilityPrefetchV2> map) {
        this.prefetchMap = map;
    }
}
