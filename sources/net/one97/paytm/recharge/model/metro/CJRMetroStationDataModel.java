package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroStationDataModel implements IJRDataModel {
    @b(a = "key")
    private String key;
    @b(a = "label")
    private String label;

    public String getKey() {
        return this.key;
    }

    public String getLabel() {
        return this.label;
    }
}
