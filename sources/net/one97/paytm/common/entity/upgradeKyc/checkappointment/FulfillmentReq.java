package net.one97.paytm.common.entity.upgradeKyc.checkappointment;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class FulfillmentReq extends IJRPaytmDataModel {
    @a
    @b(a = "conv_fee")
    public Integer convFee;
    @a
    @b(a = "date_string")
    public String dateString;
    @a
    @b(a = "event_slug")
    public String eventSlug;
    @a
    @b(a = "is_ticket")
    public Boolean isTicket;
    @a
    @b(a = "item_expiry")
    public String itemExpiry;
    @a
    @b(a = "item_name")
    public String itemName;
    @a
    @b(a = "price")
    public Integer price;
    @a
    @b(a = "ticketCount")
    public Integer ticketCount;
}
