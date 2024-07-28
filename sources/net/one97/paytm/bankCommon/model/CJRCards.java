package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCards implements IJRDataModel {
    @b(a = "generic_actions")
    private ArrayList<CJRAction> actions;
    @b(a = "courier_card")
    private CJRSellerCourierCard courierCard;
    private CJRGeneric generic;
    @b(a = "status_flow")
    private ArrayList<CJRStatusFlow> mStatusFlow = new ArrayList<>();
    @b(a = "return_card")
    private CJRSellerCourierCard returnCard;
    @b(a = "seller_card")
    private CJRSellerCourierCard sellerCard;

    public CJRGeneric getGeneric() {
        if (this.generic == null) {
            this.generic = new CJRGeneric(this.actions);
        }
        return this.generic;
    }

    public ArrayList<CJRAction> getActions() {
        return this.actions;
    }

    public void setActions(ArrayList<CJRAction> arrayList) {
        this.actions = arrayList;
    }

    public CJRSellerCourierCard getSellerCard() {
        return this.sellerCard;
    }

    public CJRSellerCourierCard getCourierCard() {
        return this.courierCard;
    }

    public CJRSellerCourierCard getReturnCard() {
        return this.returnCard;
    }

    public ArrayList<CJRStatusFlow> getStatusFlow() {
        return this.mStatusFlow;
    }
}
