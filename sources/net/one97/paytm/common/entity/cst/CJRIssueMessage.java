package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIssueMessage extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "CBSAccountNumber")
    private String CBSAccountNumber;
    @b(a = "CBSTxnId")
    private String CBSTxnId;
    @b(a = "CBSTxnTime")
    private String CBSTxnTime;
    @b(a = "attachmentId")
    private String attachmentId;
    @b(a = "attachmentType")
    private String attachmentType;
    @b(a = "caseCSATKey")
    private String caseCSATKey;
    @b(a = "caseCSATStatus")
    private String caseCSATStatus;
    @b(a = "comment")
    private String comment;
    @b(a = "commentCreationDate")
    private String commentCreationDate;
    @b(a = "isCustomer")
    private boolean isCustomer;
    private boolean isDownloadingAttachment = false;
    private boolean isEllipsized = true;
    private boolean isFeedbackSubmitted;
    private boolean isInitiated;
    private boolean isNewMessage = false;
    private boolean isPreviousMessage = false;
    private boolean isUploadingAttachment = false;
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
    @b(a = "ticketNumber")
    private String ticketNumber;
    @b(a = "walletTxnId")
    private String walletTxnId;

    public boolean isInitiated() {
        return this.isInitiated;
    }

    public void setInitiated(boolean z) {
        this.isInitiated = z;
    }

    public boolean isFeedbackSubmitted() {
        return this.isFeedbackSubmitted;
    }

    public void setFeedbackSubmitted(boolean z) {
        this.isFeedbackSubmitted = z;
    }

    public String getCaseCSATKey() {
        return this.caseCSATKey;
    }

    public void setCaseCSATKey(String str) {
        this.caseCSATKey = str;
    }

    public String getCaseCSATStatus() {
        return this.caseCSATStatus;
    }

    public void setCaseCSATStatus(String str) {
        this.caseCSATStatus = str;
    }

    public boolean isPreviousMessage() {
        return this.isPreviousMessage;
    }

    public void setPreviousMessage(boolean z) {
        this.isPreviousMessage = z;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getCommentCreationDate() {
        return this.commentCreationDate;
    }

    public void setCommentCreationDate(String str) {
        this.commentCreationDate = str;
    }

    public String getL1IssueCategory() {
        return this.l1IssueCategory;
    }

    public void setL1IssueCategory(String str) {
        this.l1IssueCategory = str;
    }

    public String getL2IssueCategory() {
        return this.l2IssueCategory;
    }

    public void setL2IssueCategory(String str) {
        this.l2IssueCategory = str;
    }

    public String getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(String str) {
        this.attachmentId = str;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public boolean isCustomer() {
        return this.isCustomer;
    }

    public void setCustomer(boolean z) {
        this.isCustomer = z;
    }

    public boolean isNewMessage() {
        return this.isNewMessage;
    }

    public void setNewMessage(boolean z) {
        this.isNewMessage = z;
    }

    public boolean isDownloadingAttachment() {
        return this.isDownloadingAttachment;
    }

    public void setDownloadingAttachment(boolean z) {
        this.isDownloadingAttachment = z;
    }

    public boolean isUploadingAttachment() {
        return this.isUploadingAttachment;
    }

    public void setUploadingAttachment(boolean z) {
        this.isUploadingAttachment = z;
    }

    public boolean isEllipsized() {
        return this.isEllipsized;
    }

    public void setEllipsized(boolean z) {
        this.isEllipsized = z;
    }

    public String getWalletTxnId() {
        return this.walletTxnId;
    }

    public void setWalletTxnId(String str) {
        this.walletTxnId = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
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

    public String getAttachmentType() {
        return this.attachmentType;
    }

    public void setAttachmentType(String str) {
        this.attachmentType = str;
    }

    public String getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(String str) {
        this.ticketNumber = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRIssueMessage cJRIssueMessage = (CJRIssueMessage) fVar.a(str, CJRIssueMessage.class);
        cJRIssueMessage.setNewMessage(true);
        return cJRIssueMessage;
    }
}
