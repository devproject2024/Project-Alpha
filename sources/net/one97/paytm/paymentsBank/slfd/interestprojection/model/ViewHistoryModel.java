package net.one97.paytm.paymentsBank.slfd.interestprojection.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class ViewHistoryModel extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.a
    @b(a = "fd_list")
    private List<a> fdList = null;
    @com.google.gsonhtcfix.a.a
    @b(a = "fd_net_count")
    private String fdNetCount;
    @com.google.gsonhtcfix.a.a
    @b(a = "message")
    private String message;
    @com.google.gsonhtcfix.a.a
    @b(a = "response_code")
    private String responseCode;
    @com.google.gsonhtcfix.a.a
    @b(a = "status")
    private String status;

    public static class a {
        @com.google.gsonhtcfix.a.a
        @b(a = "amount")

        /* renamed from: a  reason: collision with root package name */
        public double f19223a;
        @com.google.gsonhtcfix.a.a
        @b(a = "txn_date")

        /* renamed from: b  reason: collision with root package name */
        public long f19224b;
        @com.google.gsonhtcfix.a.a
        @b(a = "txn_type")

        /* renamed from: c  reason: collision with root package name */
        public String f19225c;
        @com.google.gsonhtcfix.a.a
        @b(a = "interest_earned")

        /* renamed from: d  reason: collision with root package name */
        public Double f19226d;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getFdNetCount() {
        return this.fdNetCount;
    }

    public void setFdNetCount(String str) {
        this.fdNetCount = str;
    }

    public List<a> getFdList() {
        return this.fdList;
    }

    public void setFdList(List<a> list) {
        this.fdList = list;
    }
}
