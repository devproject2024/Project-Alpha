package net.one97.paytm.common.entity.prime.verifyprime;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PrimeStatusResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "isprime")
    private boolean isprime;
    @b(a = "message")
    private String message;
    @b(a = "plan_id")
    private String plan_id;
    @b(a = "plan_name")
    private String plan_name;
    @b(a = "status")
    private String status;

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPlan_name() {
        return this.plan_name;
    }

    public String getPlan_id() {
        return this.plan_id;
    }

    public boolean getIsprime() {
        return this.isprime;
    }
}
