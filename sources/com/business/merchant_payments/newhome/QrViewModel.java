package com.business.merchant_payments.newhome;

import android.app.Application;
import android.text.TextUtils;
import androidx.arch.core.c.a;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.events.e;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.event.ErrorHandlingEvent;
import com.business.merchant_payments.model.qrsummarymodel.QRSummary;
import com.business.merchant_payments.utility.MPConstants;
import retrofit2.Response;

public class QrViewModel extends c {
    public boolean isErrorResponse;
    public ObservableBoolean isP4BClient;
    public ObservableBoolean isQRDataLoading = new ObservableBoolean();
    public LiveData<b<QRSummary>> mObservableQrSummary;
    public final y<Boolean> qrSummaryFlag;

    public QrViewModel(Application application) {
        super(application);
        ObservableBoolean observableBoolean = new ObservableBoolean();
        this.isP4BClient = observableBoolean;
        this.isErrorResponse = true;
        observableBoolean.set(MPConstants.isP4BClient());
        this.qrSummaryFlag = new y<>();
        this.isP4BClient.set(MPConstants.isP4BClient());
        this.mObservableQrSummary = ah.b(this.qrSummaryFlag, new a() {
            public final Object apply(Object obj) {
                return QrViewModel.this.lambda$new$0$QrViewModel((Boolean) obj);
            }
        });
        bindData();
    }

    public /* synthetic */ LiveData lambda$new$0$QrViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return fetchQRCodeApiCall();
        }
        return new com.business.common_module.utilities.a.a();
    }

    public void initDefaultParams() {
        this.mObservableQrSummary = new y();
    }

    private LiveData<b<QRSummary>> fetchQRCodeApiCall() {
        handleQRProgressBar(true);
        return QRViewRepository.getInstance().fetchQRCodeApiCallNew();
    }

    public void handleQRProgressBar(boolean z) {
        this.isQRDataLoading.set(z);
    }

    private void bindData() {
        updateManageQrTabSetting();
    }

    public void updateManageQrTabSetting() {
        if (PaymentsConfig.getInstance().getMerchantDataProvider().d()) {
            setQrSummaryFlag(true);
        }
    }

    public void handleErrorCondition(Response<?> response) {
        if (response.code() == 400) {
            String parseError = ErrorUtil.parseError(response);
            if (TextUtils.isEmpty(parseError) || !parseError.equalsIgnoreCase(AppConstants.INVALID_TOKEN)) {
                org.greenrobot.eventbus.c.a().c(new ErrorHandlingEvent(PaymentsConfig.getInstance().getAppContext().getResources().getString(R.string.mp_error), parseError));
                PaymentsConfig.getInstance().getErrorHandlerListener().a(PaymentsConfig.getInstance().getAppContext(), response);
            } else if (this.isErrorResponse) {
                this.isErrorResponse = false;
                org.greenrobot.eventbus.c.a().c(new e(AppConstants.HOME_HELP_SCREEN));
                ErrorUtil.handleInvalidToken(response);
            }
        }
    }

    private void setQrSummaryFlag(boolean z) {
        this.qrSummaryFlag.setValue(Boolean.valueOf(z));
    }

    public LiveData<b<QRSummary>> getmObservableQrSummary() {
        return this.mObservableQrSummary;
    }

    public boolean isEDCFlavour() {
        return AppUtility.isEdcFlavour().booleanValue();
    }
}
