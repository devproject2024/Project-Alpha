package com.travel.flight.pojo.flightticket;

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
        public CJRNPSCaptureDataModel f25438a;

        public a() {
            this.f25438a = null;
            this.f25438a = new CJRNPSCaptureDataModel();
        }

        public final a a(String str) {
            String unused = this.f25438a.orderId = str;
            return this;
        }

        public final a a(ArrayList<String> arrayList) {
            ArrayList unused = this.f25438a.itemIds = arrayList;
            return this;
        }
    }
}
