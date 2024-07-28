package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRActiveMetroTicketQRItemModel extends IJRPaytmDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "expiry")
    private String expiry;
    @b(a = "expiryTime")
    private String expiryTime;
    private boolean isPenaltyTicket;
    @b(a = "issuedOn")
    private String issuedOn;
    @b(a = "operatorRefId")
    private String operatorRefId;
    @b(a = "order_id")
    private String orderId;
    @b(a = "previousQRCodeId")
    private String previousQRCodeId;
    @b(a = "productId")
    private long productId;
    @b(a = "qrCode")
    private String qrCode;
    @b(a = "qrCodeId")
    private String qrCodeId;
    @b(a = "status")
    private String status;
    @b(a = "ticketNumber")
    private int ticketNumber;

    public String getIssuedOn() {
        return this.issuedOn;
    }

    public long getProductId() {
        return this.productId;
    }

    public int getTicketNumber() {
        return this.ticketNumber;
    }

    public String getQrCodeId() {
        return this.qrCodeId;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public String getExpiryTime() {
        return this.expiryTime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getOperatorRefId() {
        return this.operatorRefId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public boolean isPenaltyTicket() {
        return this.isPenaltyTicket;
    }

    public void setPenaltyTicket(boolean z) {
        this.isPenaltyTicket = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRActiveMetroTicketQRItemModel)) {
            return false;
        }
        return this.qrCodeId.equalsIgnoreCase(((CJRActiveMetroTicketQRItemModel) obj).qrCodeId);
    }

    public String getExpiry() {
        return this.expiry;
    }

    public String getPreviousQrCodeId() {
        return this.previousQRCodeId;
    }

    public String getAmount() {
        return this.amount;
    }
}
