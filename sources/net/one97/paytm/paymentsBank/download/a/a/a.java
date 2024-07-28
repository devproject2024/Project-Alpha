package net.one97.paytm.paymentsBank.download.a.a;

import android.view.View;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;

public final class a extends net.one97.paytm.paymentsBank.download.a.a {

    /* renamed from: a  reason: collision with root package name */
    private DownloadActivity f18302a;

    public a(Object obj) {
        if (obj instanceof DownloadActivity) {
            this.f18302a = (DownloadActivity) obj;
        }
    }

    public final void onClick(View view) {
        this.f18302a.onBackPressed();
    }
}
