package net.one97.paytm.wallet.newdesign.fastscan;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.fastscanner.c.b;
import net.one97.paytm.wallet.communicator.c;

public final class FastScannerCommunicator implements b {
    public final boolean isLogsEnabled() {
        return true;
    }

    public final long getMinDiffToProcessBitmap() {
        long longFromGTM = net.one97.paytm.wallet.communicator.b.a().getLongFromGTM(getContext(), "minDiffProcessBitmap");
        if (longFromGTM < 1000) {
            return 1000;
        }
        return longFromGTM;
    }

    public final Context getContext() {
        c a2 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        Context context = a2.getContext();
        k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
        return context;
    }
}
