package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.cst.CJRCSTRaiseIssue;
import net.one97.paytm.common.entity.cst.CJRHelpAndSupportItem;

public class CJRCSTMetaData implements IJRDataModel {
    @b(a = "CBSAccountNumber")
    private String CBSAccountNumber;
    @b(a = "CBSTxnId")
    private String CBSTxnId;
    @b(a = "CBSTxnTime")
    private String CBSTxnTime;
    @b(a = "action")
    private String action;
    @b(a = "caseCreationDate")
    private String caseCreationDate;
    @b(a = "categoryId")
    private String[] categoryId;
    private ArrayList<CJRCSTRaiseIssue> ctaList;
    @b(a = "customerId")
    private String customerId;
    @b(a = "headerText")
    private String headerText;
    @b(a = "itemId")
    private String itemId;
    @b(a = "itemName")
    private String itemName;
    @b(a = "jsonObject")
    private CJRHelpAndSupportItem jsonObject = null;
    @b(a = "l1IssueCategory")
    private String l1IssueCategory;
    @b(a = "l2IssueCategory")
    private String l2IssueCategory;
    @b(a = "landingPageUrl")
    private String landingPageUrl;
    @b(a = "loginRequired")
    private Boolean loginRequired;
    @b(a = "navEnginePath")
    private String navEnginePath;
    @b(a = "orderId")
    private String orderId;
    @b(a = "resource")
    private String resource;
    @b(a = "resourceUrl")
    private String resourceUrl;
    @b(a = "selected")
    private Boolean selected = Boolean.FALSE;
    private final Long serialVersionUID = 1L;
    @b(a = "status")
    private String status;
    @b(a = "subHeaderText")
    private String subHeaderText;
    @b(a = "text")
    private String text;
    @b(a = "thumbnail")
    private String thumbnail;
    @b(a = "thumbnails")
    private String thumbnails;
    @b(a = "ticketNumber")
    private String ticketNumber;
    @b(a = "tileCount")
    private Integer tileCount;
    @b(a = "trendingId")
    private String trendingId;
    @b(a = "vId")
    private String vId;
    @b(a = "vIdLoggedOut")
    private String vIdLoggedOut;
    @b(a = "value")
    private String value;
    @b(a = "verticalId")
    private String verticalId;
    @b(a = "verticalLabel")
    private String verticalLabel;
    @b(a = "walletTxnId")
    private String walletTxnId;

    public String getvId() {
        return this.vId;
    }

    public void setvId(String str) {
        this.vId = str;
    }

    public String getvIdLoggedOut() {
        return this.vIdLoggedOut;
    }

    public void setvIdLoggedOut(String str) {
        this.vIdLoggedOut = str;
    }

    public String getNavEnginePath() {
        return this.navEnginePath;
    }

    public void setNavEnginePath(String str) {
        this.navEnginePath = str;
    }

    public String[] getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String[] strArr) {
        this.categoryId = strArr;
    }

    public String getSubHeaderText() {
        return this.subHeaderText;
    }

    public void setSubHeaderText(String str) {
        this.subHeaderText = str;
    }

    public String getHeaderText() {
        return this.headerText;
    }

    public void setHeaderText(String str) {
        this.headerText = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public ArrayList<CJRCSTRaiseIssue> getCtaList() {
        return this.ctaList;
    }

    public void setCtaList(ArrayList<CJRCSTRaiseIssue> arrayList) {
        this.ctaList = arrayList;
    }

    public Boolean getSelected() {
        return this.selected;
    }

    public void setSelected(Boolean bool) {
        this.selected = bool;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public String getCaseCreationDate() {
        return this.caseCreationDate;
    }

    public void setCaseCreationDate(String str) {
        this.caseCreationDate = str;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(String str) {
        this.ticketNumber = str;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getWalletTxnId() {
        return this.walletTxnId;
    }

    public void setWalletTxnId(String str) {
        this.walletTxnId = str;
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

    public String getVerticalLabel() {
        return this.verticalLabel;
    }

    public void setVerticalLabel(String str) {
        this.verticalLabel = str;
    }

    public String getTrendingId() {
        return this.trendingId;
    }

    public void setTrendingId(String str) {
        this.trendingId = str;
    }

    public String getThumbnails() {
        return this.thumbnails;
    }

    public void setThumbnails(String str) {
        this.thumbnails = str;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public String getResource() {
        return this.resource;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public void setResourceUrl(String str) {
        this.resourceUrl = str;
    }

    public Long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public Integer getTileCount() {
        return this.tileCount;
    }

    public void setTileCount(Integer num) {
        this.tileCount = num;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public Boolean getLoginRequired() {
        return this.loginRequired;
    }

    public void setLoginRequired(Boolean bool) {
        this.loginRequired = bool;
    }

    public String getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(String str) {
        this.verticalId = str;
    }

    public String getLandingPageUrl() {
        return this.landingPageUrl;
    }

    public void setLandingPageUrl(String str) {
        this.landingPageUrl = str;
    }

    public CJRHelpAndSupportItem getJsonObject() {
        return this.jsonObject;
    }

    public void setJsonObject(CJRHelpAndSupportItem cJRHelpAndSupportItem) {
        this.jsonObject = cJRHelpAndSupportItem;
    }
}
