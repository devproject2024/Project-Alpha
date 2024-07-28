package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.auth.CJRDataModelItem;

public class CJRTransaction extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "extendedTxnInfo")
    private ArrayList<ExtendedTxnInfo> extendedTxnInfo;
    @b(a = "invoiceProcessed")
    private boolean isInvoiceProcessed;
    @b(a = "amountValue")
    private String mAmountValue;
    @b(a = "currencyCode")
    private String mCurrencyCode;
    @b(a = "imageUrl")
    private String mImageUrl;
    @b(a = "isBtnEnabled")
    private boolean mIsBtnEnabled;
    @b(a = "label")
    private String mLabel;
    @b(a = "narration")
    private String mNarration;
    @b(a = "newNarration")
    private String mNewNarration;
    @b(a = "txnamount")
    private String mTxnAmount;
    @b(a = "txndate")
    private String mTxnDate;
    @b(a = "txnDate")
    private String mTxnDatePaymentBank;
    @b(a = "txnDesc1")
    private String mTxnDesc1;
    @b(a = "txnDesc2")
    private String mTxnDesc2;
    @b(a = "txnDesc3")
    private String mTxnDesc3;
    @b(a = "txnDesc4")
    private String mTxnDesc4;
    @b(a = "txnDesc")
    private String mTxnDescMain;
    @b(a = "txnDescription1")
    private String mTxnDescription1;
    @b(a = "txnDescription2")
    private String mTxnDescription2;
    @b(a = "txnDescription3")
    private String mTxnDescription3;
    @b(a = "txnFrom")
    private String mTxnFrom;
    @b(a = "txnFromImageUrl")
    private String mTxnFromImageUrl;
    @b(a = "txnSerialNumber")
    private String mTxnSerialNumber;
    @b(a = "txnStatus")
    private String mTxnStatus;
    @b(a = "txnTo")
    private String mTxnTo;
    @b(a = "txnToImageUrl")
    private String mTxnToImageUrl;
    @b(a = "txntype")
    private String mTxnType;
    @b(a = "txnType")
    private String mTxnTypePaymentBank;
    @b(a = "type")
    private String mType;
    @b(a = "walletOrderId")
    private String mWalletOrderId;
    @b(a = "payeeId")
    private String payeeId;
    @b(a = "payerId")
    private String payerId;
    @b(a = "reportCode")
    private String reportCode;
    @b(a = "textForShare")
    private String textForShare;
    @b(a = "txnCategory")
    private String txnCategory;
    @b(a = "txnId")
    private String txnId;
    @b(a = "txnPostDate")
    private String txnPostDate;

    public String getName() {
        return null;
    }

    public CJRTransaction() {
    }

    public String getmTxnFromImageUrl() {
        return this.mTxnFromImageUrl;
    }

    public void setmTxnFromImageUrl(String str) {
        this.mTxnFromImageUrl = str;
    }

    public String getmTxnToImageUrl() {
        return this.mTxnToImageUrl;
    }

    public void setmTxnToImageUrl(String str) {
        this.mTxnToImageUrl = str;
    }

    public CJRTransaction(String str) {
        this.mTxnDate = str;
    }

    public boolean isInvoiceProcessed() {
        return this.isInvoiceProcessed;
    }

    public String getTxnDate() {
        return this.mTxnDate;
    }

    public String getWalletOrderId() {
        return this.mWalletOrderId;
    }

    public String getNarration() {
        return this.mNarration;
    }

    public String getTxnType() {
        return this.mTxnType;
    }

    public String getCurrencyCode() {
        return this.mCurrencyCode;
    }

    public String getTxnAmount() {
        return this.mTxnAmount;
    }

    public String getTxnStatus() {
        return this.mTxnStatus;
    }

    public String getTxnDesc1() {
        return this.mTxnDesc1;
    }

    public String getTxnDesc2() {
        return this.mTxnDesc2;
    }

    public String getTxnDesc3() {
        return this.mTxnDesc3;
    }

    public boolean isBtnEnabled() {
        return this.mIsBtnEnabled;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getTxnFrom() {
        return this.mTxnFrom;
    }

    public String getTxnTo() {
        return this.mTxnTo;
    }

    public String getType() {
        return this.mType;
    }

    public void setmType(String str) {
        this.mType = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getTxnDesc4() {
        return this.mTxnDesc4;
    }

    public String getNewNarration() {
        return this.mNewNarration;
    }

    public void setNewNarration(String str) {
        this.mNewNarration = str;
    }

    public void setmCurrencyCode(String str) {
        this.mCurrencyCode = str;
    }

    public void setmNarration(String str) {
        this.mNarration = str;
    }

    public ArrayList<ExtendedTxnInfo> getExtendedTxnInfo() {
        return this.extendedTxnInfo;
    }

    public void setExtendedTxnInfo(ArrayList<ExtendedTxnInfo> arrayList) {
        this.extendedTxnInfo = arrayList;
    }

    public void setmTxnDesc1(String str) {
        this.mTxnDesc1 = str;
    }

    public void setmTxnDesc2(String str) {
        this.mTxnDesc2 = str;
    }

    public void setmTxnStatus(String str) {
        this.mTxnStatus = str;
    }

    public void setmTxnTo(String str) {
        this.mTxnTo = str;
    }

    public void setmTxnFrom(String str) {
        this.mTxnFrom = str;
    }

    public void setmWalletOrderId(String str) {
        this.mWalletOrderId = str;
    }

    public String getTxnDescription1() {
        return this.mTxnDescription1;
    }

    public String getTextForShare() {
        return this.textForShare;
    }

    public void setmTxnType(String str) {
        this.mTxnType = str;
    }

    public void setmTxnDate(String str) {
        this.mTxnDate = str;
    }

    public void setTextForShare(String str) {
        this.textForShare = str;
    }

    public String getTxnDescMain() {
        return this.mTxnDescMain;
    }

    public void setTxnDescMain(String str) {
        this.mTxnDescMain = str;
    }

    public String getmAmountValue() {
        return this.mAmountValue;
    }

    public void setmAmountValue(String str) {
        this.mAmountValue = str;
    }

    public String getmTxnDatePaymentBank() {
        return this.mTxnDatePaymentBank;
    }

    public void setmTxnDatePaymentBank(String str) {
        this.mTxnDatePaymentBank = str;
    }

    public String getmTxnTypePaymentBank() {
        return this.mTxnTypePaymentBank;
    }

    public void setmTxnTypePaymentBank(String str) {
        this.mTxnTypePaymentBank = str;
    }

    public String getTxnCategory() {
        return this.txnCategory;
    }

    public void setTxnCategory(String str) {
        this.txnCategory = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getTxnPostDate() {
        return this.txnPostDate;
    }

    public void setTxnPostDate(String str) {
        this.txnPostDate = str;
    }

    public String getmTxnSerialNumber() {
        return this.mTxnSerialNumber;
    }

    public void setmTxnSerialNumber(String str) {
        this.mTxnSerialNumber = str;
    }

    public void setmTxnAmount(String str) {
        this.mTxnAmount = str;
    }

    public String getReportCode() {
        return this.reportCode;
    }

    public void setReportCode(String str) {
        this.reportCode = str;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getmTxnDescription2() {
        return this.mTxnDescription2;
    }

    public void setmTxnDescription2(String str) {
        this.mTxnDescription2 = str;
    }

    public String getmTxnDescription3() {
        return this.mTxnDescription3;
    }

    public void setmTxnDescription3(String str) {
        this.mTxnDescription3 = str;
    }

    public String getPayeeId() {
        return this.payeeId;
    }

    public void setPayeeId(String str) {
        this.payeeId = str;
    }

    public String getPayerId() {
        return this.payerId;
    }

    public void setPayerId(String str) {
        this.payerId = str;
    }

    public String toString() {
        return "CJRTransaction{mTxnDate='" + this.mTxnDate + '\'' + ", mWalletOrderId='" + this.mWalletOrderId + '\'' + ", mNewNarration='" + this.mNewNarration + '\'' + ", mNarration='" + this.mNarration + '\'' + ", mTxnType='" + this.mTxnType + '\'' + ", mCurrencyCode='" + this.mCurrencyCode + '\'' + ", mTxnAmount='" + this.mTxnAmount + '\'' + ", mTxnDatePaymentBank='" + this.mTxnDatePaymentBank + '\'' + ", mAmountValue='" + this.mAmountValue + '\'' + ", mTxnTypePaymentBank='" + this.mTxnTypePaymentBank + '\'' + ", txnCategory='" + this.txnCategory + '\'' + ", txnId='" + this.txnId + '\'' + ", txnPostDate='" + this.txnPostDate + '\'' + ", mTxnStatus='" + this.mTxnStatus + '\'' + ", mTxnSerialNumber='" + this.mTxnSerialNumber + '\'' + ", mTxnDescMain='" + this.mTxnDescMain + '\'' + ", mTxnDesc1='" + this.mTxnDesc1 + '\'' + ", mTxnDesc2='" + this.mTxnDesc2 + '\'' + ", reportCode='" + this.reportCode + '\'' + ", mTxnDesc3='" + this.mTxnDesc3 + '\'' + ", mTxnDesc4='" + this.mTxnDesc4 + '\'' + ", mIsBtnEnabled=" + this.mIsBtnEnabled + ", mButtonList=, mImageUrl='" + this.mImageUrl + '\'' + ", mTxnFrom='" + this.mTxnFrom + '\'' + ", mTxnTo='" + this.mTxnTo + '\'' + ", mType='" + this.mType + '\'' + ", mLabel='" + this.mLabel + '\'' + ", mTxnDescription1='" + this.mTxnDescription1 + '\'' + ", extendedTxnInfo=" + this.extendedTxnInfo + ", textForShare='" + this.textForShare + '\'' + '}';
    }
}
