package net.one97.paytm.recharge.legacy.catalog.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.LinkedHashMap;
import net.one97.paytm.common.entity.IJRDataModel;

@Deprecated
public class CalendarResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    private LinkedHashMap<String, PriceCalendarModule> data;
    private String date_format;
    private boolean status;

    public LinkedHashMap<String, PriceCalendarModule> getData() {
        return this.data;
    }

    public void setData(LinkedHashMap<String, PriceCalendarModule> linkedHashMap) {
        this.data = linkedHashMap;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public String getDate_format() {
        return this.date_format;
    }

    public void setDate_format(String str) {
        this.date_format = str;
    }
}
