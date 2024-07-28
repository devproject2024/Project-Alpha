package net.one97.paytm.paymentsBank.slfd.interestprojection.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class FDPostTransactionModel extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.a
    @com.google.gsonhtcfix.a.b(a = "response_code")
    private int code;
    @com.google.gsonhtcfix.a.a
    @com.google.gsonhtcfix.a.b(a = "message")
    private String message;
    @com.google.gsonhtcfix.a.a
    @com.google.gsonhtcfix.a.b(a = "redemption_response")
    private a redemptionResponse;
    @com.google.gsonhtcfix.a.a
    @com.google.gsonhtcfix.a.b(a = "status")
    private String status;
    @com.google.gsonhtcfix.a.a
    @com.google.gsonhtcfix.a.b(a = "txn_id")
    private String txnId;

    public static class a {
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "amount")

        /* renamed from: a  reason: collision with root package name */
        public double f19208a;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "successAmount")

        /* renamed from: b  reason: collision with root package name */
        public double f19209b;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "netTds")

        /* renamed from: c  reason: collision with root package name */
        public double f19210c;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "projectedInterest")

        /* renamed from: d  reason: collision with root package name */
        public double f19211d;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "transferredAmount")

        /* renamed from: e  reason: collision with root package name */
        public double f19212e;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "status")

        /* renamed from: f  reason: collision with root package name */
        public Integer f19213f;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "message")

        /* renamed from: g  reason: collision with root package name */
        public String f19214g;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "redemption_response_list")

        /* renamed from: h  reason: collision with root package name */
        public List<b> f19215h;
    }

    public class b {
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "fdNumber")

        /* renamed from: a  reason: collision with root package name */
        public String f19216a;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "redemptionAmount")

        /* renamed from: b  reason: collision with root package name */
        public double f19217b;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "interestRate")

        /* renamed from: c  reason: collision with root package name */
        public Double f19218c;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "status")

        /* renamed from: d  reason: collision with root package name */
        public String f19219d;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "redemptionDate")

        /* renamed from: e  reason: collision with root package name */
        public long f19220e;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "netTds")

        /* renamed from: f  reason: collision with root package name */
        public double f19221f;
        @com.google.gsonhtcfix.a.a
        @com.google.gsonhtcfix.a.b(a = "projectedInterest")

        /* renamed from: g  reason: collision with root package name */
        public double f19222g;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public a getRedemptionResponse() {
        return this.redemptionResponse;
    }

    public void setRedemptionResponse(a aVar) {
        this.redemptionResponse = aVar;
    }
}
