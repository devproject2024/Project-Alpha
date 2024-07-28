package net.one97.paytm.common.entity.shopping;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAddressList extends ArrayList<CJRAddress> implements IJRDataModel {
    private static final long serialVersionUID = 1;

    public CJRAddress get(int i2) {
        return (CJRAddress) super.get(i2);
    }
}
