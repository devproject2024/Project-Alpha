package common.insuranceOrderSummary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import net.one97.paytm.insurance.R;

public final class InsurancePostPaymentFragment$downloadPDF$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f13421a;

    InsurancePostPaymentFragment$downloadPDF$1(c cVar) {
        this.f13421a = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f13421a.isAdded()) {
            Toast.makeText(context, this.f13421a.getString(R.string.ins_pdf_download_completed), 1).show();
        }
    }
}
