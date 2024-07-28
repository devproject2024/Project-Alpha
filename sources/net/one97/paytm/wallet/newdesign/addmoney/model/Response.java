package net.one97.paytm.wallet.newdesign.addmoney.model;

import java.util.ArrayList;
import net.one97.paytm.addmoney.common.paymethodresponse.VPADetailsOffline;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

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
