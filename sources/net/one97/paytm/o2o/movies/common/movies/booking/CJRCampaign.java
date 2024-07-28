package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCampaign extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "campaignType")
    public String campaignType;
}
