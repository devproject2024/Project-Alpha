package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCpBreakUp extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cp_charges")
    private String cpCharges;
    @b(a = "grand_total_cp")
    private String grandTotalCp;

    public String getCpCharges() {
        return this.cpCharges;
    }

    public String getGrandTotalCp() {
        return this.grandTotalCp;
    }
}
