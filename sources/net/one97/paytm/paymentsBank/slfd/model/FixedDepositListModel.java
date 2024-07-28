package net.one97.paytm.paymentsBank.slfd.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class FixedDepositListModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountId")
    private String mAccountId;
    @b(a = "currentPage")
    private String mCurrentPage;
    @b(a = "customerId")
    private String mCustomerId;
    @b(a = "message")
    private String mMessage;
    @b(a = "response_code")
    private int mResponseCode;
    @b(a = "slfds")
    private ArrayList<FixedDepositModel> mSlfds;
    @b(a = "status")
    private String mStatus;
    @b(a = "totalFDs")
    private int mTotalFDs;
    @b(a = "totalPages")
    private int mTotalPages;

    public String getCustomerId() {
        return this.mCustomerId;
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public String getCurrentPage() {
        return this.mCurrentPage;
    }

    public int getTotalPages() {
        return this.mTotalPages;
    }

    public int getTotalFDs() {
        return this.mTotalFDs;
    }

    public ArrayList<FixedDepositModel> getSlfds() {
        return this.mSlfds;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
