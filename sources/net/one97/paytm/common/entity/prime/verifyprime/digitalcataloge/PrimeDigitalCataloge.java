package net.one97.paytm.common.entity.prime.verifyprime.digitalcataloge;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PrimeDigitalCataloge extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<Products> products;

    public ArrayList<Products> getProducts() {
        return this.products;
    }
}
