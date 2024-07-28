package net.one97.paytm.common.entity.hotels;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayout;

public class CJRCarouselData implements IJRDataModel {
    @b(a = "offers")
    private ArrayList<CJRHomePageLayout> mCarouselOffers;

    public ArrayList<CJRHomePageLayout> getCarouselOffers() {
        return this.mCarouselOffers;
    }

    public void setCarouselOffers(ArrayList<CJRHomePageLayout> arrayList) {
        this.mCarouselOffers = arrayList;
    }
}
