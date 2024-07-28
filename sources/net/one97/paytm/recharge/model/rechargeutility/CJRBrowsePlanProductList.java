package net.one97.paytm.recharge.model.rechargeutility;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.HashMap;

public class CJRBrowsePlanProductList implements Serializable {
    @b(a = "amount_plan_desc")
    private String amountPlanDescription;
    @b(a = "catalogProductId")
    private long catalogProductId;
    @b(a = "category_name")
    private String categoryName;
    @b(a = "circle")
    private String circle;
    @b(a = "data")
    private String data;
    @b(a = "description")
    private String description;
    @b(a = "disclaimer")
    private String disclaimer;
    @b(a = "displayName")
    private String displayName;
    private boolean isFromPlanResponse = true;
    @b(a = "marchentId")
    private long marchentId;
    @b(a = "name")
    private String name;
    @b(a = "operator")
    private String operator;
    @b(a = "paytype")
    private String paytype;
    private String planCategoryDisplayName;
    @b(a = "categoryId")
    private long planCategoryId;
    @b(a = "price")
    private Double price;
    @b(a = "productId")
    private long productId;
    @b(a = "producttype")
    private String producttype;
    @b(a = "service")
    private String service;
    @b(a = "sms")
    private String sms;
    @b(a = "subCategoryMap")
    private HashMap<String, String> subCategoryMap;
    @b(a = "talktime")
    private String talktime;
    @b(a = "title")
    private String title;
    @b(a = "validity")
    private String validity;

    public HashMap<String, String> getSubCategoryMap() {
        return this.subCategoryMap;
    }

    public String getAmountPlanDescription() {
        return this.amountPlanDescription;
    }

    public void setAmountPlanDescription(String str) {
        this.amountPlanDescription = str;
    }

    public void setSubCategoryMap(HashMap<String, String> hashMap) {
        this.subCategoryMap = hashMap;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public String getParsedDescription() {
        return (TextUtils.isEmpty(this.description) || this.description.trim().equalsIgnoreCase("NA")) ? "" : this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public String getCircle() {
        return this.circle;
    }

    public void setCircle(String str) {
        this.circle = str;
    }

    public String getTalktime() {
        return this.talktime;
    }

    public String getParsedTalktime() {
        return (TextUtils.isEmpty(this.talktime) || this.talktime.trim().equalsIgnoreCase("0") || this.talktime.trim().equalsIgnoreCase("NA")) ? "" : this.talktime;
    }

    public void setTalktime(String str) {
        this.talktime = str;
    }

    public String getValidity() {
        return this.validity;
    }

    public String getParsedValidity() {
        return (TextUtils.isEmpty(this.validity) || this.validity.trim().equalsIgnoreCase("NA")) ? "" : this.validity;
    }

    public void setValidity(String str) {
        this.validity = str;
    }

    public String getSms() {
        return this.sms;
    }

    public String getParsedSms() {
        return (TextUtils.isEmpty(this.sms) || this.sms.trim().equalsIgnoreCase("NA")) ? "" : this.sms;
    }

    public void setSms(String str) {
        this.sms = str;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public void setDisclaimer(String str) {
        this.disclaimer = str;
    }

    public String getProductType() {
        return this.producttype;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double d2) {
        this.price = d2;
    }

    public String getData() {
        return this.data;
    }

    public String getParsedDataValue() {
        return (TextUtils.isEmpty(this.data) || this.data.trim().equalsIgnoreCase("NA")) ? "" : this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public class ExtnAttrs {
        @b(a = "conv_fee")
        private Integer convFee;

        public ExtnAttrs() {
        }

        public Integer getConvFee() {
            return this.convFee;
        }

        public void setConvFee(Integer num) {
            this.convFee = num;
        }
    }

    public long getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

    public long getMarchentId() {
        return this.marchentId;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public long getCatalogProductId() {
        return this.catalogProductId;
    }

    public String getService() {
        return this.service;
    }

    public String getPaytype() {
        return this.paytype;
    }

    public long getPlanCategoryId() {
        return this.planCategoryId;
    }

    public boolean isFromPlanResponse() {
        return this.isFromPlanResponse;
    }

    public void setFromPlanResponse(boolean z) {
        this.isFromPlanResponse = z;
    }

    public String getPlanCategoryDisplayName() {
        return this.planCategoryDisplayName;
    }

    public void setPlanCategoryDisplayName(String str) {
        this.planCategoryDisplayName = str;
    }
}
