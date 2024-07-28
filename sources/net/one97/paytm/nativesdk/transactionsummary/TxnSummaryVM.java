package net.one97.paytm.nativesdk.transactionsummary;

import android.app.Application;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse;

public final class TxnSummaryVM extends a {
    private final Application context;
    private y<Boolean> hasErrorOccured = new y<>();
    private y<Boolean> loaderVisibilty = new y<>();
    private final PaymentRepository repository;
    private y<TxnSummaryResponse> responseTxnSummary = new y<>();
    private int retTryCount;

    public final void checkStatusTest() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TxnSummaryVM(Application application, PaymentRepository paymentRepository) {
        super(application);
        k.c(application, "context");
        k.c(paymentRepository, "repository");
        this.context = application;
        this.repository = paymentRepository;
        checkStatus();
    }

    public final y<TxnSummaryResponse> getResponseTxnSummary() {
        return this.responseTxnSummary;
    }

    public final void setResponseTxnSummary(y<TxnSummaryResponse> yVar) {
        this.responseTxnSummary = yVar;
    }

    public final y<Boolean> getLoaderVisibilty() {
        return this.loaderVisibilty;
    }

    public final void setLoaderVisibilty(y<Boolean> yVar) {
        this.loaderVisibilty = yVar;
    }

    public final y<Boolean> getHasErrorOccured() {
        return this.hasErrorOccured;
    }

    public final void setHasErrorOccured(y<Boolean> yVar) {
        this.hasErrorOccured = yVar;
    }

    public final int getRetTryCount() {
        return this.retTryCount;
    }

    public final void setRetTryCount(int i2) {
        this.retTryCount = i2;
    }

    /* access modifiers changed from: private */
    public final void retry() {
        int i2 = this.retTryCount;
        if (i2 < 3) {
            this.retTryCount = i2 + 1;
            checkStatus();
            return;
        }
        this.retTryCount = 0;
        y<Boolean> yVar = this.hasErrorOccured;
        if (yVar != null) {
            yVar.postValue(Boolean.TRUE);
        }
    }

    private final void checkStatus() {
        y<Boolean> yVar = this.loaderVisibilty;
        if (yVar != null) {
            yVar.postValue(Boolean.TRUE);
        }
        this.repository.checkSubsPaymentStatus(new TxnSummaryVM$checkStatus$1(this));
    }
}
