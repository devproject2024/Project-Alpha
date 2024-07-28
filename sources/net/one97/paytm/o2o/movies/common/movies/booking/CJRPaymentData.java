package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPaymentData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "is8DigitBin")
    public Boolean is8DigitBin;
}
