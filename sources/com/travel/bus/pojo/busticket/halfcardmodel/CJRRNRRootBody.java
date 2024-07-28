package com.travel.bus.pojo.busticket.halfcardmodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRRNRRootBody extends IJRPaytmDataModel {
    @b(a = "questions")
    private List<CJRRNRQuestions> questions = null;

    public List<CJRRNRQuestions> getQuestions() {
        return this.questions;
    }
}
