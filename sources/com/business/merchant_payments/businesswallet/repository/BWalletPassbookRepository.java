package com.business.merchant_payments.businesswallet.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.model.businesswallet.BWalletOrderDetails;
import com.business.merchant_payments.utility.NetworkService;
import java.util.HashMap;
import kotlin.a.ae;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.t;

public final class BWalletPassbookRepository {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "BWalletPassbookRepository";
    public static BWalletPassbookRepository ownInstance;
    public final Application app;
    public final NetworkService networkService;

    public BWalletPassbookRepository(Application application) {
        this.app = application;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        this.networkService = instance.getNetworkService();
    }

    public /* synthetic */ BWalletPassbookRepository(Application application, g gVar) {
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

        public final BWalletPassbookRepository getInstance() {
            if (BWalletPassbookRepository.ownInstance == null) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                k.b(instance, "PaymentsConfig.getInstance()");
                Application application = instance.getApplication();
                if (application != null) {
                    BWalletPassbookRepository.ownInstance = new BWalletPassbookRepository(application, (g) null);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
                }
            }
            BWalletPassbookRepository access$getOwnInstance$cp = BWalletPassbookRepository.ownInstance;
            k.a((Object) access$getOwnInstance$cp);
            return access$getOwnInstance$cp;
        }
    }

    public final void destroy() {
        ownInstance = null;
    }

    public final LiveData<b<BWalletOrderDetails>> loadOrderDetails(String str) {
        k.d(str, "txnId");
        y yVar = new y();
        this.networkService.loadBWOrderDetails(GTMDataProviderImpl.Companion.getMInstance().businessWalletOrderDetail(), getHeaders(), ae.c(t.a("txnId", str))).enqueue(new BWalletPassbookRepository$loadOrderDetails$1(yVar));
        return yVar;
    }

    public final HashMap<String, Object> getHeaders() {
        HashMap<String, Object> headers = RequestParamUtil.getHeaders(this.app);
        k.b(headers, "headers");
        return headers;
    }
}
