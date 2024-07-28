package com.travel.train.model;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNPSCaptureDataModel implements IJRDataModel {
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
        public CJRNPSCaptureDataModel f27691a;

        public a() {
            this.f27691a = null;
            this.f27691a = new CJRNPSCaptureDataModel();
        }
    }
}
