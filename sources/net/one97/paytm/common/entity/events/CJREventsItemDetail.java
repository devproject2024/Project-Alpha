package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventsItemDetail implements IJRDataModel {
    @b(a = "count")
    private int count;
    @b(a = "label")
    private String label;
    @b(a = "value")
    private double value;
    @b(a = "valuePerItem")
    private double valuePerItem;

    public String getLabel() {
        return this.label;
    }

    public double getValue() {
        return this.value;
    }

    public double getValuePerItem() {
        return this.valuePerItem;
    }

    public int getCount() {
        return this.count;
    }
}
