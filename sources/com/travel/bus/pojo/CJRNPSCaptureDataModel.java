package com.travel.bus.pojo;

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
        public CJRNPSCaptureDataModel f22782a;

        public a() {
            this.f22782a = null;
            this.f22782a = new CJRNPSCaptureDataModel();
        }

        public final a a(String str) {
            String unused = this.f22782a.orderId = str;
            return this;
        }

        public final a a(ArrayList<String> arrayList) {
            ArrayList unused = this.f22782a.itemIds = arrayList;
            return this;
        }
    }
}
