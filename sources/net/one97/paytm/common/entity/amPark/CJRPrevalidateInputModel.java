package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPrevalidateInputModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cart_items")
    private ArrayList<CJRPrevalidateCartItemModel> cart_items = new ArrayList<>();
    @b(a = "error")
    private String error;
    @b(a = "promocode")
    private String promocode;
    @b(a = "promofailuretext")
    private String promofailuretext;
    @b(a = "promostatus")
    private String promostatus;
    @b(a = "promotext")
    private String promotext;

    public ArrayList<CJRPrevalidateCartItemModel> getCart_items() {
        return this.cart_items;
    }

    public void setCart_items(ArrayList<CJRPrevalidateCartItemModel> arrayList) {
        this.cart_items = arrayList;
    }

    public void setCart_items(CJRPrevalidateCartItemModel cJRPrevalidateCartItemModel) {
        this.cart_items.add(cJRPrevalidateCartItemModel);
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String str) {
        this.promocode = str;
    }

    public String getPromotext() {
        return this.promotext;
    }

    public void setPromotext(String str) {
        this.promotext = str;
    }

    public String getPromostatus() {
        return this.promostatus;
    }

    public void setPromostatus(String str) {
        this.promostatus = str;
    }

    public String getPromofailuretext() {
        return this.promofailuretext;
    }

    public void setPromofailuretext(String str) {
        this.promofailuretext = str;
    }
}
