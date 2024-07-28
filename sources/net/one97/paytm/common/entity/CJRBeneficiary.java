package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRBeneficiary extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "accountNo")
    private String mAccountNo;
    @b(a = "amount")
    private String mAmount;
    @b(a = "comment")
    private String mComment;
    @b(a = "contactNo")
    private String mContactNo;
    @b(a = "emailId")
    private String mEmailId;
    @b(a = "nickName")
    private String mNickName;
    @b(a = "payeeSsoId")
    private String mPayeeSsoId;

    public String getName() {
        return null;
    }

    public String getPayeeSsoId() {
        return this.mPayeeSsoId;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public String getContactNo() {
        return this.mContactNo;
    }

    public String getEmailId() {
        return this.mEmailId;
    }

    public String getAccountNo() {
        return this.mAccountNo;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public String getComment() {
        return this.mComment;
    }
}
