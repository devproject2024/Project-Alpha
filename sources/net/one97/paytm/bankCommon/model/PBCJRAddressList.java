package net.one97.paytm.bankCommon.model;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBCJRAddressList extends ArrayList<PBCJRAddress> implements IJRDataModel {
    private static final long serialVersionUID = 1;

    public PBCJRAddress get(int i2) {
        return (PBCJRAddress) super.get(i2);
    }
}
