package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRViewAllIssuesDO implements IJRDataModel {
    @b(a = "CBSAccountNumber")
    private String CBSAccountNumber;
    @b(a = "CBSTxnId")
    private String CBSTxnId;
    @b(a = "CBSTxnTime")
    private String CBSTxnTime;
    @b(a = "caseCreationDate")
    private String caseCreationDate;
    @b(a = "customerId")
    private String customerId;
    @b(a = "itemId")
    private String itemId;
    @b(a = "itemName")
    private String itemName;
    @b(a = "l1IssueCategory")
    private String l1IssueCategory;
    @b(a = "l2IssueCategory")
    private String l2IssueCategory;
    @b(a = "orderId")
    private String orderId;
    @b(a = "status")
    private String status;
    @b(a = "ticketNumber")
    private String ticketNumber;
    @b(a = "verticalLabel")
    private String verticalLabel;
    @b(a = "walletTxnId")
    private String walletTxnId;

    public String getVerticalLabel() {
        return this.verticalLabel;
    }

    public void setVerticalLabel(String str) {
        this.verticalLabel = str;
    }

    public String getWalletTxnId() {
        return this.walletTxnId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getCaseCreationDate() {
        return this.caseCreationDate;
    }

    public String getL1IssueCategory() {
        return this.l1IssueCategory;
    }

    public String getL2IssueCategory() {
        return this.l2IssueCategory;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTicketNumber() {
        return this.ticketNumber;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getCBSTxnId() {
        return this.CBSTxnId;
    }

    public void setCBSTxnId(String str) {
        this.CBSTxnId = str;
    }

    public String getCBSAccountNumber() {
        return this.CBSAccountNumber;
    }

    public void setCBSAccountNumber(String str) {
        this.CBSAccountNumber = str;
    }

    public String getCBSTxnTime() {
        return this.CBSTxnTime;
    }

    public void setCBSTxnTime(String str) {
        this.CBSTxnTime = str;
    }
}
