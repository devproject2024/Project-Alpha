package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.fastag.model.SavingAccountPassbookEntriesModal;

public class CJRReplacementReason extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRTransaction> allTransaction;
    @b(a = "cancellation_allowed")
    private int cancellationAllowed;
    @b(a = "category_id")
    private int categoryId;
    @b(a = "child")
    private ArrayList<CJRReplacementReason> childList;
    int childPos = -1;
    @b(a = "comments")
    private String comments;
    @b(a = "icon")
    private String icon;
    @b(a = "id")
    private int id;
    @b(a = "is_active")
    private int isActive;
    @b(a = "is_admin_user")
    private int isAdminUser;
    @b(a = "is_call_allowed")
    private int isCallAllowed;
    @b(a = "is_customer_user")
    private int isCustomerUser;
    @b(a = "is_email_allowed")
    private int isEmailAllowed;
    @b(a = "is_fc_owner")
    private int isFcOwner;
    @b(a = "is_merchant_owner")
    private int isMerchantOwner;
    @b(a = "is_merchant_user")
    private int isMerchantUser;
    @b(a = "is_paytm_owner")
    private int isPaytmOwner;
    @b(a = "is_replaced_order")
    private int isReplacedOrder;
    boolean isSelected = false;
    @b(a = "children")
    private ArrayList<CJRReplacementReason> issueReasonsList;
    @b(a = "issue_text")
    private String issueText;
    @b(a = "message")
    private String message;
    @b(a = "meta_data")
    private CSTReasonsMetaData metaData;
    private ArrayList<CJROrderList> orderLists;
    @b(a = "order_state")
    private int orderState;
    @b(a = "out_of_stock")
    private int outOfStock;
    private ReplacementPageType pageType;
    @b(a = "parent_issue_id")
    private int parentIssueId;
    int parentPos = -1;
    private ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> paymentBankTransactions;
    @b(a = "raise_ticket_allowed")
    private int raiseTicketAllowed;
    @b(a = "replacement_allowed")
    private int replacementAllowed;
    @b(a = "return_allowed")
    private int returnAllowed;
    @b(a = "vertical_id")
    private int verticalId;

    public int getParentPos() {
        return this.parentPos;
    }

    public void setParentPos(int i2) {
        this.parentPos = i2;
    }

    public int getChildPos() {
        return this.childPos;
    }

    public void setChildPos(int i2) {
        this.childPos = i2;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public int getParentIssueId() {
        return this.parentIssueId;
    }

    public int getReplacementAllowed() {
        return this.replacementAllowed;
    }

    public int getCancellationAllowed() {
        return this.cancellationAllowed;
    }

    public int getRaiseTicketAllowed() {
        return this.raiseTicketAllowed;
    }

    public int getReturnAllowed() {
        return this.returnAllowed;
    }

    public int getIsActive() {
        return this.isActive;
    }

    public int getIsAdminUser() {
        return this.isAdminUser;
    }

    public int getIsMerchantUser() {
        return this.isMerchantUser;
    }

    public int getIsCustomerUser() {
        return this.isCustomerUser;
    }

    public int getIsPaytmOwner() {
        return this.isPaytmOwner;
    }

    public int getIsFcOwner() {
        return this.isFcOwner;
    }

    public int getIsMerchantOwner() {
        return this.isMerchantOwner;
    }

    public String getMessage() {
        return this.message;
    }

    public String getComments() {
        return this.comments;
    }

    public void setIssueText(String str) {
        this.issueText = str;
    }

    public String getIssueText() {
        return this.issueText;
    }

    public int getOutOfStock() {
        return this.outOfStock;
    }

    public int getIsReplacedOrder() {
        return this.isReplacedOrder;
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getOrderState() {
        return this.orderState;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIsCallAllowed(boolean z) {
        int i2 = 1;
        if (!z) {
            i2 = 0;
        }
        this.isCallAllowed = i2;
    }

    public void setIsEmailAllowed(boolean z) {
        int i2 = 1;
        if (!z) {
            i2 = 0;
        }
        this.isEmailAllowed = i2;
    }

    public boolean getIsCallAllowed() {
        return this.isCallAllowed == 1;
    }

    public boolean getIsEmailAllowed() {
        return this.isEmailAllowed == 1;
    }

    public ArrayList<CJRReplacementReason> getChildList() {
        ArrayList<CJRReplacementReason> arrayList = this.childList;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<CJRReplacementReason> arrayList2 = this.issueReasonsList;
        if (arrayList2 == null) {
            return new ArrayList<>();
        }
        this.childList = arrayList2;
        return arrayList2;
    }

    public ReplacementPageType getPageType() {
        return this.pageType;
    }

    public void setPageType(ReplacementPageType replacementPageType) {
        this.pageType = replacementPageType;
    }

    public CSTReasonsMetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(CSTReasonsMetaData cSTReasonsMetaData) {
        this.metaData = cSTReasonsMetaData;
    }

    public ArrayList<CJROrderList> getOrderLists() {
        return this.orderLists;
    }

    public void setOrderLists(ArrayList<CJROrderList> arrayList) {
        this.orderLists = arrayList;
    }

    public ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> getPaymentBankTransactions() {
        return this.paymentBankTransactions;
    }

    public void setPaymentBankTransactions(ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList) {
        this.paymentBankTransactions = arrayList;
    }

    public ArrayList<CJRTransaction> getAllTransaction() {
        return this.allTransaction;
    }

    public void setAllTransaction(ArrayList<CJRTransaction> arrayList) {
        this.allTransaction = arrayList;
    }

    public CJRReplacementReason clone() throws CloneNotSupportedException {
        return (CJRReplacementReason) super.clone();
    }

    public void setParentIssueId(int i2) {
        this.parentIssueId = i2;
    }

    public void setReplacementAllowed(int i2) {
        this.replacementAllowed = i2;
    }

    public void setCancellationAllowed(int i2) {
        this.cancellationAllowed = i2;
    }

    public void setRaiseTicketAllowed(int i2) {
        this.raiseTicketAllowed = i2;
    }

    public void setReturnAllowed(int i2) {
        this.returnAllowed = i2;
    }

    public void setIsActive(int i2) {
        this.isActive = i2;
    }

    public void setIsAdminUser(int i2) {
        this.isAdminUser = i2;
    }

    public void setIsMerchantUser(int i2) {
        this.isMerchantUser = i2;
    }

    public void setIsCustomerUser(int i2) {
        this.isCustomerUser = i2;
    }

    public void setIsPaytmOwner(int i2) {
        this.isPaytmOwner = i2;
    }

    public void setIsFcOwner(int i2) {
        this.isFcOwner = i2;
    }

    public void setIsMerchantOwner(int i2) {
        this.isMerchantOwner = i2;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public void setOutOfStock(int i2) {
        this.outOfStock = i2;
    }

    public void setIsReplacedOrder(int i2) {
        this.isReplacedOrder = i2;
    }

    public void setVerticalId(int i2) {
        this.verticalId = i2;
    }

    public void setCategoryId(int i2) {
        this.categoryId = i2;
    }

    public void setOrderState(int i2) {
        this.orderState = i2;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIsCallAllowed(int i2) {
        this.isCallAllowed = i2;
    }

    public void setIsEmailAllowed(int i2) {
        this.isEmailAllowed = i2;
    }

    public void setChildList(ArrayList<CJRReplacementReason> arrayList) {
        this.childList = arrayList;
    }

    public ArrayList<CJRReplacementReason> getIssueReasonsList() {
        return this.issueReasonsList;
    }

    public void setIssueReasonsList(ArrayList<CJRReplacementReason> arrayList) {
        this.issueReasonsList = arrayList;
    }

    public String toString() {
        return this.issueText;
    }
}
