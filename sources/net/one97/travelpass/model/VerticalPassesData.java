package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class VerticalPassesData extends IJRPaytmDataModel {
    @b(a = "title")
    private String title;
    @b(a = "data")
    private List<PassData> verticalPassesData;
    @b(a = "type")
    private String verticalType;

    public String getVerticalType() {
        return this.verticalType;
    }

    public List<PassData> getVerticalPassesData() {
        return this.verticalPassesData;
    }

    public String getTitle() {
        return this.title;
    }
}
