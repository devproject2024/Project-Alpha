package com.business.merchant_payments.mapqr.viewmodel;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import androidx.arch.core.c.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.events.d;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.mapqr.model.MapQRRequest;
import com.business.merchant_payments.mapqr.model.MapQRResponse;
import com.business.merchant_payments.mapqr.model.VerifyQRResponse;
import com.business.merchant_payments.mapqr.repository.MapQRRepository;
import java.net.URLDecoder;
import java.util.HashMap;

public class MapQRViewModel extends c {
    public static final String MAP_QR = "map_qr";
    public static final String TAG = "MapQRViewModel";
    public static final String VERIFY_QR = "verify_qr";
    public y<Boolean> hitMapQRApiFlag = new y<>();
    public y<Boolean> hitVerifyQRApiFlag = new y<>();
    public LiveData<b<MapQRResponse>> mapQRResponseLiveDataWrapper = ah.b(this.hitMapQRApiFlag, new a() {
        public final Object apply(Object obj) {
            return MapQRViewModel.this.lambda$new$0$MapQRViewModel((Boolean) obj);
        }
    });
    public String mappedBy;
    public String qRCode;
    public LiveData<b<VerifyQRResponse>> verifyQRResponseLiveDataWrapper = ah.b(this.hitVerifyQRApiFlag, new a() {
        public final Object apply(Object obj) {
            return MapQRViewModel.this.lambda$new$1$MapQRViewModel((Boolean) obj);
        }
    });

    public void initDefaultParams() {
    }

    public MapQRViewModel(Application application) {
        super(application);
    }

    public /* synthetic */ LiveData lambda$new$0$MapQRViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return callMapQRApi();
        }
        return new com.business.common_module.utilities.a.a();
    }

    public /* synthetic */ LiveData lambda$new$1$MapQRViewModel(Boolean bool) {
        return bool.booleanValue() ? callVerifyQRApi(this.qRCode) : new com.business.common_module.utilities.a.a();
    }

    private LiveData<b<MapQRResponse>> callMapQRApi() {
        if (!i.a(PaymentsConfig.getInstance().getApplication())) {
            return new com.business.common_module.utilities.a.a();
        }
        org.greenrobot.eventbus.c.a().c(new d(true));
        return MapQRRepository.getInstance().getMapQRResponse(GTMDataProviderImpl.Companion.getMInstance().getMapQRUrl(), getMapQRHeaders(), getMapQRRequest());
    }

    private LiveData<b<VerifyQRResponse>> callVerifyQRApi(String str) {
        if (!i.a(PaymentsConfig.getInstance().getApplication())) {
            return new com.business.common_module.utilities.a.a();
        }
        org.greenrobot.eventbus.c.a().c(new d(true));
        return MapQRRepository.getInstance().getVerifyQRResponse(GTMDataProviderImpl.Companion.getMInstance().getVerifyQRUrl() + str, getMapQRHeaders());
    }

    private HashMap<String, Object> getMapQRHeaders() {
        return RequestParamUtil.getHeaders(getContext());
    }

    private MapQRRequest getMapQRRequest() {
        return new MapQRRequest(this.qRCode, this.mappedBy);
    }

    public void callMapQRApi(String str, String str2) {
        this.qRCode = getQRCodeValue(str);
        this.mappedBy = str2;
        this.hitMapQRApiFlag.setValue(Boolean.TRUE);
    }

    public void triggerVerifyQRApi(String str) {
        this.qRCode = getQRCodeValue(str);
        this.hitVerifyQRApiFlag.setValue(Boolean.TRUE);
    }

    public String getQRCodeValue(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(AppConstants.MapQrConstants.UPI)) {
            return str;
        }
        try {
            str = URLDecoder.decode(Uri.parse(str).getQueryParameter("pa"), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
            if (!str.contains("@paytm")) {
                return str;
            }
            if (str.startsWith("paytmqr")) {
                return str.replace("paytmqr", "").replace("@paytm", "");
            }
            if (str.startsWith("pqr")) {
                return str.replace("pqr", "").replace("@paytm", "");
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
