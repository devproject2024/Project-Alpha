package net.one97.paytm.insurance.fourWheeler.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import kotlin.g.b.k;

public final class H5toInsuranceCommunicator$downloadPDF$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f14031a;

    H5toInsuranceCommunicator$downloadPDF$1(Activity activity) {
        this.f14031a = activity;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        Toast.makeText(context, "Pdf download complete.", 1).show();
        this.f14031a.finish();
    }
}
