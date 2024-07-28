package net.one97.paytm.common.entity.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCancellationProtectFare implements IJRDataModel {
    @b(a = "cp_charges")
    private String cpCharges;
    @b(a = "grand_total_cp")
    private String grandTotalCp;

    public String getCpCharges() {
        return this.cpCharges;
    }

    public void setCpCharges(String str) {
        this.cpCharges = str;
    }

    public String getGrandTotalCp() {
        return this.grandTotalCp;
    }

    public void setGrandTotalCp(String str) {
        this.grandTotalCp = str;
    }
}
