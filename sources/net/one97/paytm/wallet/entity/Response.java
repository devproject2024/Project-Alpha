package net.one97.paytm.wallet.entity;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.wallet.common.entity.offline_pg.paymethodresponse.VPADetailsOffline;

public class Response implements IJRDataModel {
    private ArrayList<BankAccountDetails.BankAccount> bankAccounts;
    private ArrayList<VPADetailsOffline> vpaDetails;

    public ArrayList<BankAccountDetails.BankAccount> getBankAccounts() {
        return this.bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccountDetails.BankAccount> arrayList) {
        this.bankAccounts = arrayList;
    }

    public ArrayList<VPADetailsOffline> getVpaDetails() {
        return this.vpaDetails;
    }

    public void setVpaDetails(ArrayList<VPADetailsOffline> arrayList) {
        this.vpaDetails = arrayList;
    }

    public String toString() {
        return "ClassPojo [bankAccounts = " + this.bankAccounts + ", vpaDetails = " + this.vpaDetails + "]";
    }
}
