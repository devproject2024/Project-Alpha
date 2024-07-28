package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMoviePassPrevalidateResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    private List<CJRMPCartItems> cart_items;
    private String promocode;

    public final List<CJRMPCartItems> getCart_items() {
        return this.cart_items;
    }

    public final void setCart_items(List<CJRMPCartItems> list) {
        this.cart_items = list;
    }

    public CJRMoviePassPrevalidateResponseModel(List<CJRMPCartItems> list, String str) {
        this.cart_items = list;
        this.promocode = str;
    }

    public final String getPromocode() {
        return this.promocode;
    }

    public final void setPromocode(String str) {
        this.promocode = str;
    }
}
