package net.one97.paytm.postpayment.models;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class P2MPostPaymentDataModel extends IJRPaytmDataModel {
    private String additionalInfo;
    private String amount;
    private IJRDataModel bundle;
    private String comment;
    private String emiMessage;
    private boolean isAmountAlreadyPresent;
    private boolean isBackPressOfflinePG;
    private boolean isCardTxn;
    private boolean isEmi;
    private boolean isFromAppEvoke;
    private boolean isFromMobileNumber;
    private boolean isFromRecent;
    private boolean isLinkBasedPayment;
    private boolean isNetBankingTxn;
    private boolean isOfflinePG;
    private boolean isPPBTxn;
    private boolean isPcf;
    private boolean isPostPaid;
    private boolean isSingleApi;
    private boolean isStaticQrCode;
    private boolean isUpi;
    private boolean isWalletTxn;
    private String lastUsedPayMode;
    private String merchantLogo;
    private String mid;
    private String name;
    private String orderId;
    private String pageLoadTime;
    private String pageLoadType;
    private String paymentMode;
    private String paymentType;
    private double pcfAmount;
    private String phoneNumber;
    private boolean qrScanTime;
    private String scanResult;
    private String suggestedInstrument;
    private String tagline;
    private String uid;
    private String usedInstrument;
    private String via;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f59707a;

        /* renamed from: b  reason: collision with root package name */
        public String f59708b;

        /* renamed from: c  reason: collision with root package name */
        public String f59709c;

        /* renamed from: d  reason: collision with root package name */
        public String f59710d;

        /* renamed from: e  reason: collision with root package name */
        public String f59711e;

        /* renamed from: f  reason: collision with root package name */
        public String f59712f;

        /* renamed from: g  reason: collision with root package name */
        public String f59713g;

        /* renamed from: h  reason: collision with root package name */
        public String f59714h;

        /* renamed from: i  reason: collision with root package name */
        IJRDataModel f59715i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
    }

    public P2MPostPaymentDataModel(a aVar) {
        this.name = aVar.f59708b;
        this.phoneNumber = aVar.f59707a;
        this.amount = aVar.f59709c;
        this.comment = aVar.f59710d;
        this.tagline = aVar.f59711e;
        this.merchantLogo = aVar.f59714h;
        this.orderId = aVar.f59712f;
        this.mid = aVar.f59713g;
        this.bundle = aVar.f59715i;
        this.isPostPaid = aVar.j;
        this.isCardTxn = aVar.m;
        this.isNetBankingTxn = aVar.n;
        this.isPPBTxn = aVar.k;
        this.isUpi = aVar.l;
        this.isFromAppEvoke = aVar.o;
    }

    public boolean isFromAppEvoke() {
        return this.isFromAppEvoke;
    }

    public void setFromAppEvoke(boolean z) {
        this.isFromAppEvoke = z;
    }

    public String getVia() {
        return this.via;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getComment() {
        return this.comment;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public String getTagline() {
        return this.tagline;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getMid() {
        return this.mid;
    }

    public boolean isOfflinePG() {
        return this.isOfflinePG;
    }

    public String getMerchantLogo() {
        return this.merchantLogo;
    }

    public boolean isBackPressOfflinePG() {
        return this.isBackPressOfflinePG;
    }

    public boolean isPostPaid() {
        return this.isPostPaid;
    }

    public boolean isPPBTxn() {
        return this.isPPBTxn;
    }

    public boolean isUpi() {
        return this.isUpi;
    }

    public boolean isCardTxn() {
        return this.isCardTxn;
    }

    public boolean isNetBankingTxn() {
        return this.isNetBankingTxn;
    }

    public boolean isWalletTxn() {
        return this.isWalletTxn;
    }

    public IJRDataModel getBundle() {
        return this.bundle;
    }

    public boolean isFromMobileNumber() {
        return this.isFromMobileNumber;
    }

    public boolean isQrScanTime() {
        return this.qrScanTime;
    }

    public String getSuggestedInstrument() {
        return this.suggestedInstrument;
    }

    public boolean isFromRecent() {
        return this.isFromRecent;
    }

    public boolean isSingleApi() {
        return this.isSingleApi;
    }

    public boolean isLinkBasedPayment() {
        return this.isLinkBasedPayment;
    }

    public String getPageLoadType() {
        return this.pageLoadType;
    }

    public String getPageLoadTime() {
        return this.pageLoadTime;
    }

    public boolean isAmountAlreadyPresent() {
        return this.isAmountAlreadyPresent;
    }

    public String getScanResult() {
        return this.scanResult;
    }

    public boolean isStaticQrCode() {
        return this.isStaticQrCode;
    }

    public String getUsedInstrument() {
        return this.usedInstrument;
    }

    public String getLastUsedPayMode() {
        return this.lastUsedPayMode;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isPcf() {
        return this.isPcf;
    }

    public double getPcfAmount() {
        return this.pcfAmount;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public boolean isEmi() {
        return this.isEmi;
    }

    public String getEmiMessage() {
        return this.emiMessage;
    }
}
