package net.one97.paytm.nativesdk.instruments;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.h5container.api.H5Event;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;

public final class InstrumentsSelectionManagerImpl implements p, InstrumentsSelectionManager {
    private final InstrumentsSelectionManagerImpl$broadcastReceiver$1 broadcastReceiver = new InstrumentsSelectionManagerImpl$broadcastReceiver$1(this);
    private InstrumentCallback callback;
    private final Application context;
    private InstrumentSelector instrumentSelector;
    private final List<PaytmBaseView> instruments;

    public InstrumentsSelectionManagerImpl(Application application, List<? extends PaytmBaseView> list) {
        k.c(application, "context");
        k.c(list, "instruments");
        this.context = application;
        this.instruments = list;
        List<PaytmBaseView> list2 = this.instruments;
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        this.instrumentSelector = new InstrumentSelector(list2, instance);
    }

    public final Application getContext() {
        return this.context;
    }

    public final List<PaytmBaseView> getInstruments() {
        return this.instruments;
    }

    public final InstrumentSelector getInstrumentSelector() {
        return this.instrumentSelector;
    }

    public final void setInstrumentSelector(InstrumentSelector instrumentSelector2) {
        k.c(instrumentSelector2, "<set-?>");
        this.instrumentSelector = instrumentSelector2;
    }

    public final InstrumentCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(InstrumentCallback instrumentCallback) {
        this.callback = instrumentCallback;
    }

    @aa(a = k.a.ON_CREATE)
    private final void onCreate() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.SELECT_NEXT_INSTRUMENT);
        intentFilter.addAction(SDKConstants.OPEN_AUTO_INSTRUMENT_PPB_POSTPAID);
        a.a((Context) this.context).a(this.broadcastReceiver, intentFilter);
    }

    @aa(a = k.a.ON_DESTROY)
    private final void onDestroy() {
        this.callback = null;
        a.a((Context) this.context).a((BroadcastReceiver) this.broadcastReceiver);
    }

    public final void resetInstruments(ArrayList<PaytmBaseView> arrayList) {
        kotlin.g.b.k.c(arrayList, "instruments");
        this.instrumentSelector.resetInstruments(arrayList);
    }

    public final void registerCallback(InstrumentCallback instrumentCallback) {
        kotlin.g.b.k.c(instrumentCallback, H5Event.TYPE_CALL_BACK);
        this.callback = instrumentCallback;
    }

    public final int getTotalInstrumentsSelected() {
        return this.instrumentSelector.getNumberOfInstrumentsSelected();
    }
}
