package net.one97.paytm.common.entity.upgradeKyc.checkappointment;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class Item extends IJRPaytmDataModel {
    @a
    @b(a = "custom_text1")
    public String customText1;
    @a
    @b(a = "fulfillment_req")
    public FulfillmentReq fulfillmentReq;
    @a
    @b(a = "id")
    public double id;
    @a
    @b(a = "is_physical")
    public Boolean isPhysical;
    @a
    @b(a = "item_detail_url")
    public String itemDetailUrl;
    @a
    @b(a = "item_status")
    public Integer itemStatus;
    @a
    @b(a = "merchant_id")
    public Integer merchantId;
    @a
    @b(a = "merchant_name")
    public String merchantName;
    @a
    @b(a = "name")
    public String name;
    @a
    @b(a = "price")
    public Integer price;
    @a
    @b(a = "quantity")
    public Integer quantity;
    @a
    @b(a = "stamped_quantity")
    public Integer stampedQuantity;
    @a
    @b(a = "status")
    public String status;
    @a
    @b(a = "status_text")
    public String statusText;
    @a
    @b(a = "status_text2")
    public String statusText2;
    @a
    @b(a = "subtotal")
    public Integer subtotal;
    @a
    @b(a = "total_price")
    public Integer totalPrice;
}
