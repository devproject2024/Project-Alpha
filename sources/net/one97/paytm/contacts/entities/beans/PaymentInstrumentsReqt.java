package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PaymentInstrumentsReqt extends IJRPaytmDataModel implements IJRDataModel {
    private int count;
    private ArrayList<DetailReqt> details;
    private Long lastTimestamp;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public Long getLastTimestamp() {
        return this.lastTimestamp;
    }

    public void setLastTimestamp(Long l) {
        this.lastTimestamp = l;
    }

    public ArrayList<DetailReqt> getDetails() {
        return this.details;
    }

    public void setDetails(ArrayList<DetailReqt> arrayList) {
        this.details = arrayList;
    }
}
