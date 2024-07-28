package net.one97.travelpass.ordersummary.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.TPOrderSummaryContactUs;

public class OrderSummaryBodyItem extends IJRPaytmDataModel {
    @b(a = "contactUsData")
    private List<TPOrderSummaryContactUs> TPOrderSummaryCSTData;
    @b(a = "body")
    private String body;
    @b(a = "categoryDeeplink")
    private String categoryDeeplink;
    @b(a = "contactusText")
    private String contactusText;
    @b(a = "fields")
    private List<OrderSummaryFiled> fields = null;
    @b(a = "footerText")
    private String footerText;
    @b(a = "heading")
    private String heading;
    @b(a = "label")
    private String label;
    @b(a = "logo")
    private String logo;
    @b(a = "mypassDeeplink")
    private String mypassDeeplink;
    @b(a = "mypassesIcon")
    private String mypassesIcon;
    @b(a = "mypassesText")
    private String mypassesText;
    @b(a = "retry")
    private Boolean retry;
    @b(a = "status")
    private String status;
    @b(a = "statusIcon")
    private String statusIcon;
    @b(a = "statusImage")
    private String statusImage;
    @b(a = "statusMessage")
    private String statusMessage;
    @b(a = "subCatLine")
    private String subCatLine;
    @b(a = "subCategory")
    private String subCategory;
    @b(a = "subCategoryIcon")
    private String subCategoryIcon;
    @b(a = "tncContent")
    private List<String> termsConditions;
    @b(a = "topHeading")
    private String topHeading;
    @b(a = "travelPassImageUrl")
    private String travelPassImageUrl;
    @b(a = "type")
    private String type;

    public void setMypassDeeplink(String str) {
        this.mypassDeeplink = str;
    }

    public String getCategoryDeeplink() {
        return this.categoryDeeplink;
    }

    public void setCategoryDeeplink(String str) {
        this.categoryDeeplink = str;
    }

    public List<String> getTermsConditions() {
        return this.termsConditions;
    }

    public void setTermsConditions(List<String> list) {
        this.termsConditions = list;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public Boolean getRetry() {
        return this.retry;
    }

    public void setRetry(Boolean bool) {
        this.retry = bool;
    }

    public String getStatusIcon() {
        return this.statusIcon;
    }

    public void setStatusIcon(String str) {
        this.statusIcon = str;
    }

    public String getSubCategoryIcon() {
        return this.subCategoryIcon;
    }

    public void setSubCategoryIcon(String str) {
        this.subCategoryIcon = str;
    }

    public String getMypassesText() {
        return this.mypassesText;
    }

    public void setMypassesText(String str) {
        this.mypassesText = str;
    }

    public String getSubCatLine() {
        return this.subCatLine;
    }

    public void setSubCatLine(String str) {
        this.subCatLine = str;
    }

    public String getMypassesIcon() {
        return this.mypassesIcon;
    }

    public void setMypassesIcon(String str) {
        this.mypassesIcon = str;
    }

    public String getTravelPassImageUrl() {
        return this.travelPassImageUrl;
    }

    public void setTravelpassImageUrl(String str) {
        this.travelPassImageUrl = str;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public List<OrderSummaryFiled> getFields() {
        return this.fields;
    }

    public void setFields(List<OrderSummaryFiled> list) {
        this.fields = list;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public String getFooterText() {
        return this.footerText;
    }

    public void setFooterText(String str) {
        this.footerText = str;
    }

    public String getContactusText() {
        return this.contactusText;
    }

    public void setContactusText(String str) {
        this.contactusText = str;
    }

    public String getStatusImage() {
        return this.statusImage;
    }

    public String getTopHeading() {
        return this.topHeading;
    }

    public List<TPOrderSummaryContactUs> getTPOrderSummaryCSTData() {
        return this.TPOrderSummaryCSTData;
    }

    public void setStatusImage(String str) {
        this.statusImage = str;
    }

    public void setTravelPassImageUrl(String str) {
        this.travelPassImageUrl = str;
    }

    public void setTopHeading(String str) {
        this.topHeading = str;
    }

    public void setTPOrderSummaryCSTData(List<TPOrderSummaryContactUs> list) {
        this.TPOrderSummaryCSTData = list;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public void setSubCategory(String str) {
        this.subCategory = str;
    }

    public String getMypassDeeplink() {
        return this.mypassDeeplink;
    }

    public class TncContent extends IJRPaytmDataModel {
        @b(a = "id")
        private String _id;
        @b(a = "tncContent")
        private List<String> tncContent = null;
        @b(a = "tnc_id")
        private int tnc_id;

        public TncContent() {
        }

        public String get_id() {
            return this._id;
        }

        public int getTnc_id() {
            return this.tnc_id;
        }

        public List<String> getTncContent() {
            return this.tncContent;
        }
    }
}
