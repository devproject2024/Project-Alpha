package net.one97.paytm.common.entity.prime.verifyprime.primepromocode;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PrimePromoCode extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<Codes> codes;

    public ArrayList<Codes> getCodes() {
        return this.codes;
    }
}
