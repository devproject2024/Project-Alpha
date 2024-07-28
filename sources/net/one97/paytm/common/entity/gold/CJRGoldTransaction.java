package net.one97.paytm.common.entity.gold;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGoldTransaction implements IJRDataModel {
    @b(a = "display_date_time")
    private String displayDateTime;
    @b(a = "display_status_msg")
    private String displayStatusMsg;
    @b(a = "display_title")
    private String displayTitle;
    @b(a = "display_values")
    private ArrayList<CJRGoldDisplayValue> displayValues = null;
    @b(a = "display_weight")
    private String displayWeight;
    @b(a = "dst_name")
    private String dstName;
    @b(a = "grams")
    private String grams;
    private String helpKey;
    @b(a = "id")
    private int id;
    private String layoutType;
    private String mHeader;
    private boolean needHelp;
    @b(a = "order_id")
    private double orderId;
    @b(a = "price_per_gram")
    private String pricePerGram;
    @b(a = "remaining_balance")
    private String remainingBalance;
    private Object resultValue;
    @b(a = "displayInvoice")
    private boolean showInvoice;
    @b(a = "invoiceUrl")
    private String showInvoiceUrl;
    @b(a = "src_message")
    private String srcMessage;
    @b(a = "status")
    private String status;
    @b(a = "total_amount")
    private String totalAmount;
    @b(a = "transaction_date")
    private String transactionDate;
    @b(a = "txn_id")
    private String txnId;
    @b(a = "txn_type")
    private String txnType;
    @b(a = "unit_type")
    private String unitType;
    @b(a = "updated_at")
    private String updatedAt;
    private int verticalId;
    private String verticalLabel;

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public String getTxnType() {
        return this.txnType;
    }

    public void setTxnType(String str) {
        this.txnType = str;
    }

    public double getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int i2) {
        this.orderId = (double) i2;
    }

    public String getDisplayStatusMsg() {
        return this.displayStatusMsg;
    }

    public void setDisplayStatusMsg(String str) {
        this.displayStatusMsg = str;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public void setDisplayTitle(String str) {
        this.displayTitle = str;
    }

    public String getDisplayWeight() {
        return this.displayWeight;
    }

    public void setDisplayWeight(String str) {
        this.displayWeight = str;
    }

    public String getDisplayDateTime() {
        return this.displayDateTime;
    }

    public void setDisplayDateTime(String str) {
        this.displayDateTime = str;
    }

    public ArrayList<CJRGoldDisplayValue> getDisplayValues() {
        return this.displayValues;
    }

    public void setDisplayValues(ArrayList<CJRGoldDisplayValue> arrayList) {
        this.displayValues = arrayList;
    }

    public String getUnitType() {
        return this.unitType;
    }

    public void setUnitType(String str) {
        this.unitType = str;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String getPricePerGram() {
        return this.pricePerGram;
    }

    public void setPricePerGram(String str) {
        this.pricePerGram = str;
    }

    public String getGrams() {
        return this.grams;
    }

    public void setGrams(String str) {
        this.grams = str;
    }

    public String getRemainingBalance() {
        return this.remainingBalance;
    }

    public void setRemainingBalance(String str) {
        this.remainingBalance = str;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(String str) {
        this.transactionDate = str;
    }

    public String getLayoutType() {
        return this.layoutType;
    }

    public void setLayoutType(String str) {
        this.layoutType = str;
    }

    public boolean isShowInvoice() {
        return this.showInvoice;
    }

    public void setShowInvoice(boolean z) {
        this.showInvoice = z;
    }

    public String getShowInvoiceUrl() {
        return this.showInvoiceUrl;
    }

    public void setShowInvoiceUrl(String str) {
        this.showInvoiceUrl = str;
    }

    public boolean isNeedHelp() {
        return this.needHelp;
    }

    public void setNeedHelp(boolean z) {
        this.needHelp = z;
    }

    public String getHelpKey() {
        return this.helpKey;
    }

    public void setHelpKey(String str) {
        this.helpKey = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public Object getResultValue() {
        return this.resultValue;
    }

    public void setResultValue(Object obj) {
        this.resultValue = obj;
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(int i2) {
        this.verticalId = i2;
    }

    public String getVerticalLabel() {
        return this.verticalLabel;
    }

    public void setVerticalLabel(String str) {
        this.verticalLabel = str;
    }

    public String getmHeader() {
        return this.mHeader;
    }

    public void setmHeader(String str) {
        this.mHeader = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public String getSrcMessage() {
        return this.srcMessage;
    }

    public void setSrcMessage(String str) {
        this.srcMessage = str;
    }

    public String getDstName() {
        return this.dstName;
    }

    public void setDstName(String str) {
        this.dstName = str;
    }
}
