package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPromoMetaData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "campData")
    public HashMap<String, CJRCampaign> campData;
    @b(a = "paymentData")
    public CJRPaymentData paymentData;
}
