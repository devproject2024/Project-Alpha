package net.one97.paytm.hotel4.service.model.ordersummary;

import com.google.gsonhtcfix.a.a;
import com.paytm.network.model.IJRPaytmDataModel;

public class PriceData extends IJRPaytmDataModel {
    @a
    public int finalCGST;
    @a
    public int finalIGST;
    @a
    public int finalPrice;
    @a
    public int finalSGST;
    @a
    public int finalTax;
    @a
    public int finalUTGST;
    @a
    public int originalPrice;
    @a
    public int totalPriceWithTax;
    @a
    public int totalTax;
}
