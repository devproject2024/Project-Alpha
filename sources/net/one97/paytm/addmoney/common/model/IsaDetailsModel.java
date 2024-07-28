package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class IsaDetailsModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountNumber")
    private String mAccountNumber;
    @b(a = "branchId")
    private String mBranchId;
    @b(a = "cifNumber")
    private String mCifNumber;
    @b(a = "createDate")
    private long mCreateDate;
    @b(a = "createdBy")
    private String mCreatedBy;
    @b(a = "custId")
    private String mCustId;
    @b(a = "errorMessage")
    private String mErrorMessage;
    @b(a = "firstName")
    private String mFirstName;
    @b(a = "ifscCode")
    private String mIfscCode;
    @b(a = "lastName")
    private String mLastName;
    @b(a = "nomineeList")
    private ArrayList<NomineeModel> mNomineeList;
    @b(a = "processId")
    private String mProcessId;
    @b(a = "solId")
    private String mSolId;
    @b(a = "status")
    private String mStatus;
    @b(a = "updateDate")
    private long mUpdateDate;
    @b(a = "updatedBy")
    private String mUpdatedBy;
    @b(a = "userId")
    private String mUserId;

    public String getAccountNumber() {
        return this.mAccountNumber;
    }

    public String getCustId() {
        return this.mCustId;
    }

    public String getCifNumber() {
        return this.mCifNumber;
    }

    public String getIfscCode() {
        return this.mIfscCode;
    }

    public String getProcessId() {
        return this.mProcessId;
    }

    public String getSolId() {
        return this.mSolId;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public ArrayList<NomineeModel> getNomineeList() {
        return this.mNomineeList;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public long getCreateDate() {
        return this.mCreateDate;
    }

    public String getCreatedBy() {
        return this.mCreatedBy;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public String getLastName() {
        return this.mLastName;
    }

    public long getUpdateDate() {
        return this.mUpdateDate;
    }

    public String getUpdatedBy() {
        return this.mUpdatedBy;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getAccountName() {
        return getFirstName() + " " + getLastName();
    }

    public void setAccountNumber(String str) {
        this.mAccountNumber = str;
    }

    public void setIfscCode(String str) {
        this.mIfscCode = str;
    }
}
