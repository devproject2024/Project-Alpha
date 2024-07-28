package net.one97.paytm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import net.one97.paytm.insurance.R;

public final class InsuranceOrderSummary$downloadPDF$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InsuranceOrderSummary f13545a;

    InsuranceOrderSummary$downloadPDF$1(InsuranceOrderSummary insuranceOrderSummary) {
        this.f13545a = insuranceOrderSummary;
    }

    public final void onReceive(Context context, Intent intent) {
        Toast.makeText(context, this.f13545a.getString(R.string.ins_pdf_download_completed), 0).show();
    }
}
