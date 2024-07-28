package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class EmptyModel extends IJRPaytmDataModel implements IJRDataModel {
    public String jsonData;

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        this.jsonData = str;
        return this;
    }
}
