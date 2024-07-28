package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryMeta extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "hash_value")
    private String hashValue;
    @b(a = "payment_status")
    private Map<Integer, String> paymentStatusMap;
    @b(a = "position_details")
    private ArrayList<String> positionDetails = null;
    @b(a = "refresh_interval")
    private String refreshInterval;

    public String getHashValue() {
        return this.hashValue;
    }

    public String getRefreshInterval() {
        return this.refreshInterval;
    }

    public ArrayList<String> getPositionDetails() {
        return this.positionDetails;
    }

    public Map<Integer, String> getPaymentStatusMap() {
        return this.paymentStatusMap;
    }
}
