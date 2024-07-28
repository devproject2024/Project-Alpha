package net.one97.paytm.nativesdk.instruments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ExtensionsKt;

public final class InstrumentsSelectionManagerImpl$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ InstrumentsSelectionManagerImpl this$0;

    InstrumentsSelectionManagerImpl$broadcastReceiver$1(InstrumentsSelectionManagerImpl instrumentsSelectionManagerImpl) {
        this.this$0 = instrumentsSelectionManagerImpl;
    }

    public final void onReceive(Context context, Intent intent) {
        PaytmBaseView paytmBaseView;
        if (ExtensionsKt.isNotNullNotBlank(intent != null ? intent.getAction() : null)) {
            if (intent == null) {
                k.a();
            }
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != 1250288496) {
                    if (hashCode != 1674735974 || !action.equals(SDKConstants.OPEN_AUTO_INSTRUMENT_PPB_POSTPAID)) {
                        return;
                    }
                } else if (!action.equals(SDKConstants.SELECT_NEXT_INSTRUMENT)) {
                    return;
                }
                String stringExtra = intent.getStringExtra(SDKConstants.SELECTED_INSTRUMENT);
                if (ExtensionsKt.isNotNullNotBlank(stringExtra)) {
                    InstrumentSelector instrumentSelector = this.this$0.getInstrumentSelector();
                    k.a((Object) stringExtra, "instrumentName");
                    paytmBaseView = instrumentSelector.selectNextInstrument(stringExtra);
                } else {
                    paytmBaseView = this.this$0.getInstrumentSelector().selectNextInstrument();
                }
                InstrumentCallback callback = this.this$0.getCallback();
                if (callback != null) {
                    callback.instrumentSelected(paytmBaseView);
                }
            }
        }
    }
}
