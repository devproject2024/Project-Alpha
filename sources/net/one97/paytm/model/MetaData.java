package net.one97.paytm.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public class MetaData implements IJRDataModel {
    public String make;
    public String model;
    public String policyExipryDate;
    public String policyStartDate;
    public String ref_id;
    @b(a = "request_id")
    public String request_id;
    public String variant;
    public String vehicleNo;

    public MetaData(String str) {
        this.request_id = str;
    }

    public MetaData() {
    }

    public MetaData(String str, String str2) {
        this.request_id = str2;
    }

    public MetaData createFromObject(g gVar) {
        this.vehicleNo = (String) gVar.get("vehicleNo");
        return this;
    }
}
