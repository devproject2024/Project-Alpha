package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUserWalletBalance extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "totalBalance")
    private double totalBalance;

    public double getTotalBalance() {
        return this.totalBalance;
    }
}
