package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public class CJRHelpAndSupportItem implements IJRDataModel {
    @b(a = "cancellation_allowed")
    int cancellationAllowed;
    @b(a = "category_id")
    int categoryId;
    @b(a = "comments")
    String comments = null;
    @b(a = "icon")
    String icon = null;
    @b(a = "id")
    int id;
    @b(a = "is_active")
    int isActive;
    @b(a = "is_admin_user")
    int isAdminUser;
    @b(a = "is_bank")
    String isBank = null;
    @b(a = "is_call_allowed")
    int isCallAllowed;
    @b(a = "is_customer_user")
    int isCustomerUser;
    @b(a = "is_email_allowed")
    int isEmailAllowed;
    @b(a = "is_fc_owner")
    int isFcOwner;
    @b(a = "is_merchant_owner")
    int isMerchantOwner;
    @b(a = "is_merchant_user")
    int isMerchantUser;
    @b(a = "is_paytm_owner")
    int isPaytmOwner;
    @b(a = "is_replaced_order")
    int isReplacedOrder;
    @b(a = "is_version")
    int isVersion;
    @b(a = "issue_text")
    String issueText = null;
    @b(a = "level")
    int level;
    @b(a = "message")
    String message = null;
    @b(a = "meta_data")
    CJRHelpAndSupportMetaItem metaData;
    @b(a = "order_flag")
    String orderFlag = null;
    @b(a = "order_state")
    int orderState;
    @b(a = "out_of_stock")
    int outOfStock;
    @b(a = "parent_issue_id")
    int parentIssueId;
    @b(a = "priority")
    String priority = null;
    @b(a = "raise_ticket_allowed")
    int raise_ticketAllowed;
    @b(a = "replacement_allowed")
    int replacementAllowed;
    @b(a = "return_allowed")
    int returnAllowed;
    private final Long serialVersionUID = 1L;
    @b(a = "vertical_id")
    int verticalId;

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public int getParentIssueId() {
        return this.parentIssueId;
    }

    public void setParentIssueId(int i2) {
        this.parentIssueId = i2;
    }

    public int getReplacementAllowed() {
        return this.replacementAllowed;
    }

    public void setReplacementAllowed(int i2) {
        this.replacementAllowed = i2;
    }

    public int getCancellationAllowed() {
        return this.cancellationAllowed;
    }

    public void setCancellationAllowed(int i2) {
        this.cancellationAllowed = i2;
    }

    public int getRaise_ticketAllowed() {
        return this.raise_ticketAllowed;
    }

    public void setRaise_ticketAllowed(int i2) {
        this.raise_ticketAllowed = i2;
    }

    public int getReturnAllowed() {
        return this.returnAllowed;
    }

    public void setReturnAllowed(int i2) {
        this.returnAllowed = i2;
    }

    public int getIsActive() {
        return this.isActive;
    }

    public void setIsActive(int i2) {
        this.isActive = i2;
    }

    public int getIsAdminUser() {
        return this.isAdminUser;
    }

    public void setIsAdminUser(int i2) {
        this.isAdminUser = i2;
    }

    public int getIsMerchantUser() {
        return this.isMerchantUser;
    }

    public void setIsMerchantUser(int i2) {
        this.isMerchantUser = i2;
    }

    public int getIsCustomerUser() {
        return this.isCustomerUser;
    }

    public void setIsCustomerUser(int i2) {
        this.isCustomerUser = i2;
    }

    public int getIsPaytmOwner() {
        return this.isPaytmOwner;
    }

    public void setIsPaytmOwner(int i2) {
        this.isPaytmOwner = i2;
    }

    public int getIsFcOwner() {
        return this.isFcOwner;
    }

    public void setIsFcOwner(int i2) {
        this.isFcOwner = i2;
    }

    public int getIsMerchantOwner() {
        return this.isMerchantOwner;
    }

    public void setIsMerchantOwner(int i2) {
        this.isMerchantOwner = i2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public String getIssueText() {
        return this.issueText;
    }

    public void setIssueText(String str) {
        this.issueText = str;
    }

    public int getOutOfStock() {
        return this.outOfStock;
    }

    public void setOutOfStock(int i2) {
        this.outOfStock = i2;
    }

    public int getIsReplacedOrder() {
        return this.isReplacedOrder;
    }

    public void setIsReplacedOrder(int i2) {
        this.isReplacedOrder = i2;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i2) {
        this.level = i2;
    }

    public String getOrderFlag() {
        return this.orderFlag;
    }

    public void setOrderFlag(String str) {
        this.orderFlag = str;
    }

    public int getIsCallAllowed() {
        return this.isCallAllowed;
    }

    public void setIsCallAllowed(int i2) {
        this.isCallAllowed = i2;
    }

    public int getIsEmailAllowed() {
        return this.isEmailAllowed;
    }

    public void setIsEmailAllowed(int i2) {
        this.isEmailAllowed = i2;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public String getIsBank() {
        return this.isBank;
    }

    public void setIsBank(String str) {
        this.isBank = str;
    }

    public int getIsVersion() {
        return this.isVersion;
    }

    public void setIsVersion(int i2) {
        this.isVersion = i2;
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(int i2) {
        this.verticalId = i2;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i2) {
        this.categoryId = i2;
    }

    public int getOrderState() {
        return this.orderState;
    }

    public void setOrderState(int i2) {
        this.orderState = i2;
    }

    public CJRHelpAndSupportMetaItem getMetaData() {
        return this.metaData;
    }

    public void setMetaData(CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem) {
        this.metaData = cJRHelpAndSupportMetaItem;
    }

    public boolean isBankItem() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getBankHomepage() == null) ? false : true;
    }

    public boolean isWalletItem() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getWalletHomepage() == null) ? false : true;
    }

    public boolean isFastTagItem() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getFasttagHomePage() == null) ? false : true;
    }

    public boolean isGvItem() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getGvHomePage() == null) ? false : true;
    }

    public boolean isRecentOrdersItem() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getRecentOrdersHomepage() == null) ? false : true;
    }

    public boolean isRecentOrdersMallItem() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getRecentOrdersHomepageMall() == null) ? false : true;
    }

    public boolean isLevel1Item() {
        return !isUpiItem() && !isBankItem() && !isWalletItem() && !isRecentOrdersItem() && !isRecentOrdersMallItem() && !isWebviewHomepage() && !isArchivedIssue();
    }

    public boolean isWebviewHomepage() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getWebviewHomepage() == null) ? false : true;
    }

    public boolean isArchivedIssue() {
        CJRHelpAndSupportMetaItem cJRHelpAndSupportMetaItem = this.metaData;
        return (cJRHelpAndSupportMetaItem == null || cJRHelpAndSupportMetaItem.getArchivedIssues() == null) ? false : true;
    }

    public boolean isUpiItem() {
        return this.id == 1000517;
    }

    public ItemType getItemType() {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.getCode() == this.id) {
                return itemType;
            }
        }
        return null;
    }

    public enum ItemType {
        RECHARGE(1000501),
        SHOPPING(1000502),
        ADD_MONEY_TO_WALLET(1000503),
        WALLET(1000504),
        BANK(1000505),
        TRAVEL(1000506),
        TICKETS(1000507),
        GOLD(1000508),
        FINANCIAL_SERVICES(1000509),
        LOGIN_SIGN_UP(1000510),
        UPGRADE_YOUR_WALLET(1000511),
        SAVING_BANK_ACCOUNT(1000512),
        PRIVACY_AND_SECURITY(1000513),
        FOR_MERCHANTS(1000514),
        FAQ(1000515),
        ARCHIVED_ITEMS(1000516),
        UPI(UpiConstants.CST_UPI_ID);
        
        private int code;

        private ItemType(int i2) {
            this.code = i2;
        }

        public final int getCode() {
            return this.code;
        }
    }
}
