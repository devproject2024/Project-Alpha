package net.one97.paytm.orders.datamodel;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNPSCaptureDataModel extends IJRPaytmDataModel implements IJRDataModel {
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
}
