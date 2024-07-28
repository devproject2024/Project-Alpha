package net.one97.paytm.transport.iocl.data;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class User implements IJRDataModel {
    @b(a = "dob")
    private String dob;
    @b(a = "gender")
    private String gender;
    @b(a = "haveTransactionsInIOCL")
    private boolean hasTransaction;
    @b(a = "haveFuelWallet")
    private boolean haveFuelWallet;
    @b(a = "memberNumber")
    private String memberNumber;
    @b(a = "mobile")
    private String mobile;
    @b(a = "displayName")
    private String name;
    @b(a = "pincode")
    private String pincode;
    @b(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String str) {
        this.dob = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String str) {
        this.pincode = str;
    }

    public boolean isHasTransaction() {
        return this.hasTransaction;
    }

    public void setHasTransaction(boolean z) {
        this.hasTransaction = z;
    }

    public boolean isHaveFuelWallet() {
        return this.haveFuelWallet;
    }

    public void setHaveFuelWallet(boolean z) {
        this.haveFuelWallet = z;
    }

    public String getMemberNumber() {
        return this.memberNumber;
    }

    public void setMemberNumber(String str) {
        this.memberNumber = str;
    }
}
