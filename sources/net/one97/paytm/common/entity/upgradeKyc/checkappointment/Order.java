package net.one97.paytm.common.entity.upgradeKyc.checkappointment;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class Order extends IJRPaytmDataModel {
    @a
    @b(a = "amount")
    public Integer amount;
    @a
    @b(a = "date")
    public String date;
    @a
    @b(a = "is_physical")
    public Boolean isPhysical;
    @a
    @b(a = "item_count")
    public Integer itemCount;
    @a
    @b(a = "items")
    public ArrayList<Item> items = null;
    @a
    @b(a = "order_detail_url")
    public String orderDetailUrl;
    @a
    @b(a = "order_id")
    public double orderId;
    @a
    @b(a = "order_list_type")
    public Integer orderListType;
    @a
    @b(a = "order_name")
    public String orderName;
    @a
    @b(a = "order_status")
    public Integer orderStatus;
    @a
    @b(a = "order_type")
    public String orderType;
    @a
    @b(a = "status")
    public String status;
    @a
    @b(a = "status_icon")
    public String statusIcon;
}
