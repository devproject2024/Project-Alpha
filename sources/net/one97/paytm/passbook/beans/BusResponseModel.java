package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class BusResponseModel extends IJRDataModel {
    private static final long serialVersionUID = 2;
    @b(a = "imageUrl")
    private String imageUrl;
    @b(a = "invoiceDetails")
    private BusInvoiceDetailsModel invoiceDetails;
    @b(a = "merchantName")
    private String merchantName;
    @b(a = "merchantOrderId")
    private String merchantOrderId;
    @b(a = "txnamount")
    private String txnamount;
    @b(a = "txndate")
    private String txndate;
    @b(a = "uniqueReferenceLabel")
    private String uniqueReferenceLabel;
    @b(a = "uniqueReferenceValue")
    private String uniqueReferenceValue;
    @b(a = "walletSysTransactionId")
    private String walletSysTransactionId;

    public String getWalletSysTransactionId() {
        return this.walletSysTransactionId;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getMerchantOrderId() {
        return this.merchantOrderId;
    }

    public String getTxndate() {
        return this.txndate;
    }

    public String getTxnamount() {
        return this.txnamount;
    }

    public String getUniqueReferenceLabel() {
        return this.uniqueReferenceLabel;
    }

    public String getUniqueReferenceValue() {
        return this.uniqueReferenceValue;
    }

    public BusInvoiceDetailsModel getInvoiceDetails() {
        return this.invoiceDetails;
    }
}
