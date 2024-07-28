package net.one97.paytm.nativesdk.transactionsummary;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;

public final class TxnSummaryVmFactory implements al.b {
    private final Application context;
    private final PaymentRepository repository;

    public TxnSummaryVmFactory(Application application, PaymentRepository paymentRepository) {
        k.c(application, "context");
        k.c(paymentRepository, "repository");
        this.context = application;
        this.repository = paymentRepository;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(TxnSummaryVM.class)) {
            return (ai) new TxnSummaryVM(this.context, this.repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
