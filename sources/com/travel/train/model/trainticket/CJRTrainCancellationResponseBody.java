package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCancellationResponseBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "templates")
    private List<CJRTrainCancellationTemplate> templates = null;

    public ArrayList<CJRTrainCancellationTemplate> getTemplates() {
        return (ArrayList) this.templates;
    }
}
