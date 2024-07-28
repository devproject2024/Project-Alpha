package net.one97.paytm.nativesdk.paymethods.factory;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener;
import net.one97.paytm.nativesdk.paymethods.viewmodel.AppInvokeViewModel;
import net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel;

public final class InstrumentViewModelFactory implements al.b {
    private final CashierInstrumentListner cashierInstrumentListner;
    private final Application context;
    private boolean isDisableInstrument;
    private final OnBottomSheetChangeListener mBottomSheetChangeListener;
    private String mPaymentMode;
    private OnPayMethodSelectedListener payMethodSelectedListener;
    private final String primaryInfo;
    private final String secondaryInfo;

    public InstrumentViewModelFactory(String str, String str2, OnPayMethodSelectedListener onPayMethodSelectedListener, OnBottomSheetChangeListener onBottomSheetChangeListener, boolean z, String str3, CashierInstrumentListner cashierInstrumentListner2, Application application) {
        k.c(str, "primaryInfo");
        k.c(str2, "secondaryInfo");
        k.c(onBottomSheetChangeListener, "mBottomSheetChangeListener");
        k.c(str3, "mPaymentMode");
        k.c(cashierInstrumentListner2, "cashierInstrumentListner");
        k.c(application, "context");
        this.primaryInfo = str;
        this.secondaryInfo = str2;
        this.payMethodSelectedListener = onPayMethodSelectedListener;
        this.mBottomSheetChangeListener = onBottomSheetChangeListener;
        this.isDisableInstrument = z;
        this.mPaymentMode = str3;
        this.cashierInstrumentListner = cashierInstrumentListner2;
        this.context = application;
    }

    public final OnPayMethodSelectedListener getPayMethodSelectedListener() {
        return this.payMethodSelectedListener;
    }

    public final String getPrimaryInfo() {
        return this.primaryInfo;
    }

    public final String getSecondaryInfo() {
        return this.secondaryInfo;
    }

    public final void setPayMethodSelectedListener(OnPayMethodSelectedListener onPayMethodSelectedListener) {
        this.payMethodSelectedListener = onPayMethodSelectedListener;
    }

    public final Application getContext() {
        return this.context;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(InstrumentSheetViewModel.class)) {
            return (ai) new InstrumentSheetViewModel(this.primaryInfo, this.secondaryInfo, this.payMethodSelectedListener, this.mBottomSheetChangeListener, this.isDisableInstrument, this.mPaymentMode, this.cashierInstrumentListner, this.context);
        }
        if (cls.isAssignableFrom(AppInvokeViewModel.class)) {
            return (ai) new AppInvokeViewModel(this.primaryInfo, this.secondaryInfo, this.payMethodSelectedListener, this.mBottomSheetChangeListener, this.isDisableInstrument, this.mPaymentMode, this.cashierInstrumentListner, this.context);
        }
        throw new RuntimeException("View Model Not Defined");
    }
}
