package net.one97.paytm.common.entity.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryContactUs extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "id")
    private long id;
    private boolean isAllItemsSelected = false;
    @b(a = "item_price")
    private String itemPrice;
    @b(a = "item_status")
    private int itemStatus;
    @b(a = "name")
    private String name;
    @b(a = "need_shipping")
    private boolean needShipping;
    private String orderId;
    @b(a = "status")
    private String status;
    @b(a = "status_text")
    private String statusText;
    @b(a = "subtotal")
    private double subtotal;
    @b(a = "thumbnail")
    private String thumbnail;
    @b(a = "vertical_id")
    private int verticalId;
    @b(a = "vertical_label")
    private String verticalLabel;

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public void setStatusText(String str) {
        this.statusText = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(double d2) {
        this.subtotal = d2;
    }

    public int getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(int i2) {
        this.verticalId = i2;
    }

    public String getVerticalLabel() {
        return this.verticalLabel;
    }

    public void setVerticalLabel(String str) {
        this.verticalLabel = str;
    }

    public int getItemStatus() {
        return this.itemStatus;
    }

    public void setItemStatus(int i2) {
        this.itemStatus = i2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public boolean getNeedShipping() {
        return this.needShipping;
    }

    public void setNeedShipping(boolean z) {
        this.needShipping = z;
    }

    public String getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(String str) {
        this.itemPrice = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public boolean isAllItemsSelected() {
        return this.isAllItemsSelected;
    }

    public void setAllItemsSelected(boolean z) {
        this.isAllItemsSelected = z;
    }
}
