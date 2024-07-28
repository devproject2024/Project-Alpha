package net.one97.paytm.nativesdk.paymethods.viewmodel;

import android.app.Application;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener;

public final class AppInvokeViewModel extends InstrumentSheetViewModel {
    public final boolean shouldfollowPriorityOrder() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInvokeViewModel(String str, String str2, OnPayMethodSelectedListener onPayMethodSelectedListener, OnBottomSheetChangeListener onBottomSheetChangeListener, boolean z, String str3, CashierInstrumentListner cashierInstrumentListner, Application application) {
        super(str, str2, onPayMethodSelectedListener, onBottomSheetChangeListener, z, str3, cashierInstrumentListner, application);
        k.c(str, "primaryInfo");
        k.c(str2, "secondaryInfo");
        k.c(onBottomSheetChangeListener, "mBottomSheetChangeListener");
        k.c(str3, "mPaymentMode");
        k.c(cashierInstrumentListner, "cashierInstrumentListner");
        k.c(application, "context");
    }
}
