package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class ListVpaResponseModel implements UpiBaseDataModel {
    @c(a = "details")
    private Details details;

    public Details getDetails() {
        return this.details;
    }

    public void setDetails(Details details2) {
        this.details = details2;
    }

    public class Details implements UpiBaseDataModel {
        @c(a = "valist")
        private List<Valist> valist = null;

        public Details() {
        }

        public List<Valist> getValist() {
            return this.valist;
        }

        public void setValist(List<Valist> list) {
            this.valist = list;
        }
    }

    public class Valist implements UpiBaseDataModel {
        @c(a = "credit")
        private ProfileCreditDefault credit;
        @c(a = "debit")
        private ProfileDebitDefault debit;
        @c(a = "va")
        private String virtualAddress;

        public Valist() {
        }

        public String getVirtualAddress() {
            return this.virtualAddress;
        }

        public void setVirtualAddress(String str) {
            this.virtualAddress = str;
        }

        public ProfileDebitDefault getDebit() {
            return this.debit;
        }

        public void setDebit(ProfileDebitDefault profileDebitDefault) {
            this.debit = profileDebitDefault;
        }

        public ProfileCreditDefault getCredit() {
            return this.credit;
        }

        public void setCredit(ProfileCreditDefault profileCreditDefault) {
            this.credit = profileCreditDefault;
        }
    }
}
