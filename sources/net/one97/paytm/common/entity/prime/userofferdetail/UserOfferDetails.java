package net.one97.paytm.common.entity.prime.userofferdetail;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class UserOfferDetails extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<Response> response;
    private int status;

    public ArrayList<Response> getResponse() {
        return this.response;
    }

    public int getStatus() {
        return this.status;
    }
}
