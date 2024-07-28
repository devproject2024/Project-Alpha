package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class Response extends IJRPaytmDataModel implements IJRDataModel {
    ArrayList<ContactsResponse> contacts;
    private long timeStamp;
    private int totalCount;
    private boolean usePhoneBookPaymentInstruments;

    public boolean getUsePaymentInstruments() {
        return this.usePhoneBookPaymentInstruments;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public long getLastTimestamp() {
        return this.timeStamp;
    }

    public void setUsePaymentInstruments(boolean z) {
        this.usePhoneBookPaymentInstruments = z;
    }

    public void setTotalCount(int i2) {
        this.totalCount = i2;
    }

    public void setLastTimestamp(long j) {
        this.timeStamp = j;
    }

    public ArrayList<ContactsResponse> getContacts() {
        return this.contacts;
    }
}
