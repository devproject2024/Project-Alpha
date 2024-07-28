package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CashWithdrawPostTransactionRedemptionStatus extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "payload")
    private Payload payload;
    @a
    @b(a = "requestId")
    private String requestId;
    @a
    @b(a = "responseCode")
    private Integer responseCode;
    /* access modifiers changed from: private */
    @a
    @b(a = "responseMessage")
    public String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public class Payload extends IJRPaytmDataModel {
        @b(a = "orderDate")
        private String orderDate;
        @b(a = "orderId")
        private String orderId;
        @b(a = "qrCodeId")
        private String qrCodeId;
        @b(a = "status")
        private String status;

        public Payload() {
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String getResponseMessage() {
            return CashWithdrawPostTransactionRedemptionStatus.this.responseMessage;
        }

        public String getQrCodeId() {
            return this.qrCodeId;
        }

        public void setQrCodeId(String str) {
            this.qrCodeId = str;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public String getOrderDate() {
            return this.orderDate;
        }

        public void setOrderDate(String str) {
            this.orderDate = str;
        }
    }
}
