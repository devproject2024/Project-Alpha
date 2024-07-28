package net.one97.paytm.recharge.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.recharge.common.utils.ba;

public class CJRPersonalInsurance extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "id")
    public long id;
    @b(a = "meta_data")
    public MetaDataInsurance metaDataInsurance;
    @b(a = "name")
    public String name;
    @b(a = "product_list")
    public ArrayList<ProductItem> productList;

    public static class MetaDataInsurance implements IJRDataModel {
        @b(a = "amount")
        public String amount;
        public String consumerNumber;
        @b(a = "linkedUtility")
        public String linkedUtility;
        public String operator;
        public String productId;
        @b(a = "recharge_number")
        public String rechargeNumber;
        public String request_id;
        public String service;

        public String getProductId() {
            return this.productId;
        }

        public String getConsumerNumber() {
            return this.consumerNumber;
        }

        public String getService() {
            return this.service;
        }

        public String getOperator() {
            return this.operator;
        }

        public String getRequest_id() {
            return this.request_id;
        }

        public String getRechargeNumber() {
            return this.rechargeNumber;
        }

        public void setRechargeNumber(String str) {
            this.rechargeNumber = str;
        }

        public String getAmount() {
            return this.amount;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public String getLinkedUtility() {
            return this.linkedUtility;
        }

        public void setLinkedUtility(String str) {
            this.linkedUtility = str;
        }
    }

    class ProductItem implements IJRDataModel {
        @b(a = "attributes")
        public ProductItemAttributes attributes;
        @b(a = "id")
        public long id;
        @b(a = "input_fields")
        public ArrayList<ProductItemInputFields> inputFields;
        @b(a = "long_rich_desc")
        public ArrayList<ProductItemLongRichDesc> longRichDescs;

        private ProductItem() {
        }

        public long getId() {
            return this.id;
        }

        public ProductItemAttributes getAttributes() {
            return this.attributes;
        }

        public ArrayList<ProductItemInputFields> getInputFields() {
            return this.inputFields;
        }

        public ArrayList<ProductItemLongRichDesc> getLongRichDescs() {
            return this.longRichDescs;
        }
    }

    class ProductItemAttributes implements IJRDataModel {
        @b(a = "price")
        public String price;

        private ProductItemAttributes() {
        }

        public String getPrice() {
            return this.price;
        }
    }

    class ProductItemInputFields implements IJRDataModel {
        @b(a = "config_key")
        public String configKey;
        @b(a = "pre_selected")
        public boolean preSelected;
        @b(a = "read_only")
        public String readOnly;
        @b(a = "regex")
        public String regex;
        @b(a = "subtext")
        public String subTitle;
        @b(a = "title")
        public String title;
        @b(a = "type")
        public String type;

        private ProductItemInputFields() {
        }

        public String getTitle() {
            return this.title;
        }

        public String getConfigKey() {
            return this.configKey;
        }

        public String getRegex() {
            return this.regex;
        }

        public String getType() {
            return this.type;
        }

        public String getReadOnly() {
            return this.readOnly;
        }

        public boolean getPreSelected() {
            return this.preSelected;
        }

        public String getSubTitle() {
            return this.subTitle;
        }
    }

    class ProductItemLongRichDesc implements IJRDataModel {
        @b(a = "description")
        public String description;
        @b(a = "heading")
        public String heading;
        @b(a = "title")
        public String title;

        private ProductItemLongRichDesc() {
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getHeading() {
            return this.heading;
        }

        public void setHeading(String str) {
            this.heading = str;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String str) {
            this.description = str;
        }
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<ProductItem> getProductList() {
        return this.productList;
    }

    public String getTermsAndConditions() {
        if (getProductList() == null || getProductList().size() == 0 || getProductList().get(0).getLongRichDescs() == null || getProductList().get(0).getLongRichDescs().size() == 0 || TextUtils.isEmpty(getProductList().get(0).getLongRichDescs().get(0).getDescription())) {
            return null;
        }
        return getProductList().get(0).getLongRichDescs().get(0).getDescription();
    }

    public String getSubTitleForPersonalInsurance() {
        if (getProductList() == null || getProductList().size() == 0 || getProductList().get(0).getInputFields() == null || getProductList().get(0).getInputFields().size() == 0 || TextUtils.isEmpty(getProductList().get(0).getInputFields().get(0).getSubTitle())) {
            return null;
        }
        return getProductList().get(0).getInputFields().get(0).getSubTitle();
    }

    public String getTitleForPersonalInsurance() {
        if (getProductList() == null || getProductList().size() == 0 || getProductList().get(0).getInputFields() == null || getProductList().get(0).getInputFields().size() == 0 || TextUtils.isEmpty(getProductList().get(0).getInputFields().get(0).getTitle())) {
            return null;
        }
        return getProductList().get(0).getInputFields().get(0).getTitle();
    }

    public String getPriceForPersonalInsurance() {
        if (getProductList() == null || getProductList().size() == 0 || getProductList().get(0).getInputFields() == null || getProductList().get(0).getInputFields().size() == 0) {
            return null;
        }
        return ba.j(getProductList().get(0).getAttributes().getPrice());
    }

    public String getProductID() {
        if (getProductList() == null || getProductList().size() == 0) {
            return null;
        }
        return String.valueOf(getProductList().get(0).getId());
    }

    public boolean getPreSelected() {
        if (getProductList() == null || getProductList().size() == 0 || getProductList().get(0).getInputFields() == null || getProductList().get(0).getInputFields().size() == 0) {
            return false;
        }
        return getProductList().get(0).getInputFields().get(0).getPreSelected();
    }

    public MetaDataInsurance getMetaDataInsurance() {
        return this.metaDataInsurance;
    }

    public void setMetaDataInsurance(MetaDataInsurance metaDataInsurance2) {
        this.metaDataInsurance = metaDataInsurance2;
    }
}
