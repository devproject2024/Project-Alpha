package com.business.merchant_payments.mapqr.viewmodel;

import androidx.arch.core.c.a;
import androidx.lifecycle.LiveData;
import com.business.common_module.utilities.a.b;
import com.google.gson.l;
import kotlin.g.b.k;

public final class QRSurveyViewModel$initDefaultParams$1<I, O> implements a<Boolean, LiveData<b<l>>> {
    public final /* synthetic */ QRSurveyViewModel this$0;

    public QRSurveyViewModel$initDefaultParams$1(QRSurveyViewModel qRSurveyViewModel) {
        this.this$0 = qRSurveyViewModel;
    }

    public final LiveData<b<l>> apply(Boolean bool) {
        k.b(bool, "flag");
        if (bool.booleanValue()) {
            return this.this$0.sendSurvey();
        }
        return com.business.common_module.utilities.a.a.a();
    }
}
