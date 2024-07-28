package net.one97.paytm.common.entity.upgradeKyc.checkappointment;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class MyOrderApiResponse extends IJRPaytmDataModel {
    @a
    @b(a = "orders")
    public ArrayList<Order> orders = null;
}
