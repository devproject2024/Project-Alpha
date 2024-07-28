package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroStationModel implements IJRDataModel {
    @b(a = "station_id")
    private String id;
    @b(a = "display_name")
    private String name;

    public CJRMetroStationModel(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
