package net.one97.paytm.addmoney.common.paymethodresponse;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public class VPADetailsOffline implements IJRDataModel {
    private BankAccountDetails.BankAccount defaultCredit;
    private BankAccountDetails.BankAccount defaultDebit;
    private String name;
    private String primary;

    public BankAccountDetails.BankAccount getDefaultCredit() {
        return this.defaultCredit;
    }

    public BankAccountDetails.BankAccount getDefaultDebit() {
        return this.defaultDebit;
    }

    public String getPrimary() {
        return this.primary;
    }

    public String getName() {
        return this.name;
    }
}
