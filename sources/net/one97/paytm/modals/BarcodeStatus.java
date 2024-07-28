package net.one97.paytm.modals;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

@Deprecated
public class BarcodeStatus implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    BarcodeData data;
    @b(a = "result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public BarcodeData getData() {
        return this.data;
    }
}
