package com.travel.sale.data.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CampaignReferResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private final String body;
    @b(a = "code")
    private final int code;
    @b(a = "message")
    private final String message;
}
