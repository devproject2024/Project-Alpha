package net.one97.paytm.nativesdk.instruments.giftVoucher;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.PaymentModes;

public final class GiftVoucherViewModelFactory implements al.b {
    private final Application context;
    private final PaymentModes paymentModes;
    private final TransactionProcessor transactionProcessor;

    public GiftVoucherViewModelFactory(PaymentModes paymentModes2, TransactionProcessor transactionProcessor2, Application application) {
        k.c(paymentModes2, "paymentModes");
        k.c(transactionProcessor2, "transactionProcessor");
        k.c(application, "context");
        this.paymentModes = paymentModes2;
        this.transactionProcessor = transactionProcessor2;
        this.context = application;
    }

    public final Application getContext() {
        return this.context;
    }

    public final PaymentModes getPaymentModes() {
        return this.paymentModes;
    }

    public final TransactionProcessor getTransactionProcessor() {
        return this.transactionProcessor;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(GiftVoucherViewModel.class)) {
            return (ai) new GiftVoucherViewModel(this.paymentModes, this.transactionProcessor, this.context);
        }
        throw new RuntimeException("View Model Not Defined");
    }
}
