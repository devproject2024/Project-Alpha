package net.one97.paytm.addmoney.common.model;

import com.paytm.network.model.IJRPaytmDataModel;

public class AccountNameModel extends IJRPaytmDataModel {
    private String name;

    public AccountNameModel(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
