package net.one97.paytm.common;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class TPOrderSummaryContactUs extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isAllItemsSelected = false;
    @b(a = "itemID")
    private Long itemID;
    @b(a = "itemStatus")
    private String itemStatus;
    @b(a = "name")
    private String name;
    @b(a = "needShipping")
    private String needShipping;
    @b(a = "orderId")
    private Long orderId;
    @b(a = "price")
    private String price;
    @b(a = "productVerticalLabel")
    private String productVerticalLabel;
    @b(a = "promoCode")
    private String promoCode;
    @b(a = "status")
    private int status;
    @b(a = "thumbnailImageURL")
    private String thumbnailImageURL;
    @b(a = "verticalId")
    private int verticalId;

    public String getName() {
        return this.name;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getItemStatus() {
        return this.itemStatus;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrderId(Long l) {
        this.orderId = l;
    }

    public void setItemStatus(String str) {
        this.itemStatus = str;
    }

    public void setItemID(Long l) {
        this.itemID = l;
    }

    public void setVerticalId(int i2) {
        this.verticalId = i2;
    }

    public void setProductVerticalLabel(String str) {
        this.productVerticalLabel = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setNeedShipping(String str) {
        this.needShipping = str;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public void setThumbnailImageURL(String str) {
        this.thumbnailImageURL = str;
    }

    public Long getItemID() {
        return this.itemID;
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public String getProductVerticalLabel() {
        return this.productVerticalLabel;
    }

    public String getPrice() {
        return this.price;
    }

    public int getStatus() {
        return this.status;
    }

    public String getNeedShipping() {
        return this.needShipping;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public String getThumbnailImageURL() {
        return this.thumbnailImageURL;
    }

    public boolean isAllItemsSelected() {
        return this.isAllItemsSelected;
    }

    public void setAllItemsSelected(boolean z) {
        this.isAllItemsSelected = z;
    }
}
