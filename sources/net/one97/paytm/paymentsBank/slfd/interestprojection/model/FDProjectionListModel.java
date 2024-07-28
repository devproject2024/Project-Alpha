package net.one97.paytm.paymentsBank.slfd.interestprojection.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDTransactionHistoryModel;

public class FDProjectionListModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "amount")
    private Double amount;
    @b(a = "fd_category")
    ArrayList<String> fdCategory;
    @b(a = "fd_id")
    private String fdId;
    @a
    @b(a = "fd_interest_projection_list")
    private List<FdInterestProjectionDtoList> fdInterestProjectionDtoList = null;
    @b(a = "interest_earned")
    private Double interestEarned;
    @b(a = "message")
    private String message;
    @b(a = "net_invested_amount")
    private Double netInvestedAmount;
    @b(a = "nominee_details")
    private FDTransactionHistoryModel.a nomineeDetails;
    @b(a = "response_code")
    private long response_code;
    @b(a = "status")
    private String status;
    @b(a = "txn_id")
    private String txn_id;

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double d2) {
        this.amount = d2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Double getInterestEarned() {
        return this.interestEarned;
    }

    public void setInterestEarned(Double d2) {
        this.interestEarned = d2;
    }

    public ArrayList<String> getFdCategory() {
        return this.fdCategory;
    }

    public void setFdCategory(ArrayList<String> arrayList) {
        this.fdCategory = arrayList;
    }

    public String getFdId() {
        return this.fdId;
    }

    public void setFdId(String str) {
        this.fdId = str;
    }

    public Double getNetInvestedAmount() {
        return this.netInvestedAmount;
    }

    public void setNetInvestedAmount(Double d2) {
        this.netInvestedAmount = d2;
    }

    public FDTransactionHistoryModel.a getNomineeDetails() {
        return this.nomineeDetails;
    }

    public void setNomineeDetails(FDTransactionHistoryModel.a aVar) {
        this.nomineeDetails = aVar;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String str) {
        this.txn_id = str;
    }

    public long getResponse_code() {
        return this.response_code;
    }

    public void setResponse_code(long j) {
        this.response_code = j;
    }

    public List<FdInterestProjectionDtoList> getFdInterestProjectionDtoList() {
        return this.fdInterestProjectionDtoList;
    }

    public void setFdInterestProjectionDtoList(List<FdInterestProjectionDtoList> list) {
        this.fdInterestProjectionDtoList = list;
    }

    public static class FdInterestProjectionDtoList extends IJRPaytmDataModel {
        @a
        @b(a = "date")
        private String date;
        @a
        @b(a = "days")
        private Integer days;
        @a
        @b(a = "displayName")
        private String displayName;
        @a
        @b(a = "interestEarned")
        private double interestEarned;
        @a
        @b(a = "interestRate")
        private String interestRate;
        @a
        @b(a = "label")
        private String label;
        @a
        @b(a = "projectedInterest")
        private double projectedInterest = 0.0d;

        public String getDate() {
            return this.date;
        }

        public void setDate(String str) {
            this.date = str;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public Integer getDays() {
            return this.days;
        }

        public void setDays(Integer num) {
            this.days = num;
        }

        public String getInterestRate() {
            return this.interestRate;
        }

        public void setInterestRate(String str) {
            this.interestRate = str;
        }

        public double getInterestEarned() {
            return this.interestEarned;
        }

        public void setInterestEarned(double d2) {
            this.interestEarned = d2;
        }

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public double getProjectedInterest() {
            return this.projectedInterest;
        }

        public void setProjectedInterest(double d2) {
            this.projectedInterest = d2;
        }
    }
}
