package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;

public class CJRSetSeatItems extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "3dglasses")
    private ArrayList<a> _3dglasses;
    private ArrayList<CJRFoodBeverageItemV2> fnbAndVouchers;
    @b(a = "food")
    private ArrayList<CJRFoodBeverageItemV2> food;
    @b(a = "food_vouchers")
    private ArrayList<CJRFoodBeverageItemV2> foodVouchers;
    @b(a = "items")
    private ArrayList<CJRFoodBeverageItemV2> items;

    public ArrayList<CJRFoodBeverageItemV2> getFnbAndVouchers() {
        ArrayList<CJRFoodBeverageItemV2> arrayList = this.fnbAndVouchers;
        if (arrayList != null) {
            return arrayList;
        }
        this.fnbAndVouchers = new ArrayList<>();
        ArrayList<CJRFoodBeverageItemV2> arrayList2 = this.items;
        if (arrayList2 != null && arrayList2.size() > 0) {
            this.fnbAndVouchers.addAll(this.items);
        }
        ArrayList<CJRFoodBeverageItemV2> arrayList3 = this.foodVouchers;
        if (arrayList3 != null && arrayList3.size() > 0) {
            this.fnbAndVouchers.addAll(this.foodVouchers);
        }
        ArrayList<CJRFoodBeverageItemV2> arrayList4 = this.food;
        if (arrayList4 != null && arrayList4.size() > 0) {
            this.fnbAndVouchers.addAll(this.food);
        }
        return this.fnbAndVouchers;
    }

    public ArrayList<a> get_3dglasses() {
        return this._3dglasses;
    }
}
