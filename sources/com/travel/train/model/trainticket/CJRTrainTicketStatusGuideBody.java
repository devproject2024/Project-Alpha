package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTicketStatusGuideBody extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "templates")
    private ArrayList<CJRTrainTicketStatusGuideTemplate> templates;

    public ArrayList<CJRTrainTicketStatusGuideTemplate> getTemplates() {
        return this.templates;
    }
}
