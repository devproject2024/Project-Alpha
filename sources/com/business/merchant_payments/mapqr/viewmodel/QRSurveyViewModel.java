package com.business.merchant_payments.mapqr.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.mapqr.repository.QRSurveyRepo;
import com.google.gson.l;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class QRSurveyViewModel extends c {
    public String code = "";
    public y<Boolean> qrSurveyFlag;
    public LiveData<b<l>> qrSurveyViewModel;
    public String text = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QRSurveyViewModel(Application application) {
        super(application);
        k.d(application, "application");
    }

    public final LiveData<b<l>> getQrSurveyViewModel() {
        LiveData<b<l>> liveData = this.qrSurveyViewModel;
        if (liveData == null) {
            k.a("qrSurveyViewModel");
        }
        return liveData;
    }

    public final void setQrSurveyViewModel(LiveData<b<l>> liveData) {
        k.d(liveData, "<set-?>");
        this.qrSurveyViewModel = liveData;
    }

    public final void initDefaultParams() {
        y<Boolean> yVar = new y<>();
        this.qrSurveyFlag = yVar;
        LiveData<b<l>> b2 = ah.b(yVar, new QRSurveyViewModel$initDefaultParams$1(this));
        k.b(b2, "Transformations.switchMa…)\n            }\n        }");
        this.qrSurveyViewModel = b2;
    }

    /* access modifiers changed from: private */
    public final LiveData<b<l>> sendSurvey() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (i.a(instance.getApplication())) {
            return QRSurveyRepo.Companion.getInstance().saveQRSurveyResponse(this.code, this.text);
        }
        y yVar = new y();
        yVar.setValue(b.a("NO NETWORK"));
        return yVar;
    }

    public final void hitSendSurveyApi(String str, String str2) {
        k.d(str, "code");
        k.d(str2, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        this.code = str;
        this.text = str2;
        y<Boolean> yVar = this.qrSurveyFlag;
        if (yVar == null) {
            k.a("qrSurveyFlag");
        }
        yVar.setValue(Boolean.TRUE);
    }
}
