package com.business.merchant_payments.mapqr.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.mapqr.model.Answers;
import com.business.merchant_payments.mapqr.model.SaveResponseBody;
import com.business.merchant_payments.utility.NetworkService;
import com.google.gson.l;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class QRSurveyRepo {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "QRSurveyRepo";
    public static QRSurveyRepo ownInstance;
    public final Application app;
    public final NetworkService networkService;

    public QRSurveyRepo(Application application) {
        this.app = application;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        this.networkService = instance.getNetworkService();
    }

    public /* synthetic */ QRSurveyRepo(Application application, g gVar) {
        this(application);
    }

    public final Application getApp() {
        return this.app;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final QRSurveyRepo getInstance() {
            if (QRSurveyRepo.ownInstance == null) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                Application application = instance.getApplication();
                if (application != null) {
                    QRSurveyRepo.ownInstance = new QRSurveyRepo(application, (g) null);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
                }
            }
            QRSurveyRepo access$getOwnInstance$cp = QRSurveyRepo.ownInstance;
            k.a((Object) access$getOwnInstance$cp);
            return access$getOwnInstance$cp;
        }
    }

    public final LiveData<b<l>> saveQRSurveyResponse(String str, String str2) {
        k.d(str, "code");
        k.d(str2, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        y yVar = new y();
        String qRSaveSurveyAPI = GTMDataProviderImpl.Companion.getMInstance().getQRSaveSurveyAPI();
        HashMap<String, Object> headers = RequestParamUtil.getHeaders(this.app);
        SaveResponseBody saveResponseBody = new SaveResponseBody((List) null, 1, (g) null);
        Answers answers = saveResponseBody.getQuestions().get(0).getAnswers().get(0);
        answers.setCode(str);
        answers.setText(str2);
        this.networkService.saveQRSurveyResponse(qRSaveSurveyAPI, saveResponseBody, headers).enqueue(new QRSurveyRepo$saveQRSurveyResponse$2(yVar));
        return yVar;
    }
}
