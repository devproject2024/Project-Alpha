package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRManufacturingDetails implements IJRDataModel {
    @b(a = "manufacturing_address")
    private List<CJRManufacturingAddress> manufacturingAddress;

    public List<CJRManufacturingAddress> getManufacturingAddress() {
        return this.manufacturingAddress;
    }

    public void setManufacturingAddress(List<CJRManufacturingAddress> list) {
        this.manufacturingAddress = list;
    }
}
