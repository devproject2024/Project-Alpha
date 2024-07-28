package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTSendFeedBackModel implements IJRDataModel {
    @c(a = "client")
    private String client;
    @c(a = "comment")
    private String comment;
    @c(a = "customerId")
    private String custId;
    @c(a = "issueId")
    private String issueId;
    @c(a = "itemId")
    private String itemId;
    @c(a = "l1IssueId")
    private String l1IssueId;
    @c(a = "l2IssueId")
    private String l2IssueId;
    @c(a = "likeFlag")
    private Boolean likeFlag;
    @c(a = "orderId")
    private String orderId;
    @c(a = "parentIssueId")
    private String parentIssueId;
    @c(a = "source")
    private String source;

    public String getCustId() {
        return this.custId;
    }

    public void setCustId(String str) {
        this.custId = str;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String str) {
        this.client = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public void setIssueId(String str) {
        this.issueId = str;
    }

    public String getL1IssueId() {
        return this.l1IssueId;
    }

    public void setL1IssueId(String str) {
        this.l1IssueId = str;
    }

    public String getL2IssueId() {
        return this.l2IssueId;
    }

    public void setL2IssueId(String str) {
        this.l2IssueId = str;
    }

    public String getParentIssueId() {
        return this.parentIssueId;
    }

    public void setParentIssueId(String str) {
        this.parentIssueId = str;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public Boolean getLikeFlag() {
        return this.likeFlag;
    }

    public void setLikeFlag(Boolean bool) {
        this.likeFlag = bool;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
