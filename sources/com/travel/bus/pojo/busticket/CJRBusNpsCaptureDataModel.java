package com.travel.bus.pojo.busticket;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRBusNpsCaptureDataModel extends IJRPaytmDataModel {
    /* access modifiers changed from: private */
    public ArrayList<String> itemIds;
    /* access modifiers changed from: private */
    public String orderId;
    /* access modifiers changed from: private */
    public int response;

    public String getOrderId() {
        return this.orderId;
    }

    public int getResponse() {
        return this.response;
    }

    public ArrayList<String> getItemIds() {
        return this.itemIds;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRBusNpsCaptureDataModel f22783a;

        public a() {
            this.f22783a = null;
            this.f22783a = new CJRBusNpsCaptureDataModel();
        }
    }
}
