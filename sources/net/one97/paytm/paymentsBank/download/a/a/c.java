package net.one97.paytm.paymentsBank.download.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import net.one97.paytm.payments.c.c.b;
import net.one97.paytm.paymentsBank.download.a.a;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;
import net.one97.paytm.paymentsBank.slfd.tds.view.TDSCertificateActivity;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private DownloadActivity f18304a;

    public c(Object obj) {
        if (obj instanceof DownloadActivity) {
            this.f18304a = (DownloadActivity) obj;
        }
    }

    public final void onClick(View view) {
        b bVar = b.f17264a;
        if (b.a()) {
            Bundle bundle = new Bundle();
            bundle.putString("goToScreen", "fd_interest_certificate");
            b bVar2 = b.f17264a;
            b.a(this.f18304a, bundle, ViewHolderFactory.CLASS_HOME);
            return;
        }
        Intent intent = new Intent(this.f18304a, TDSCertificateActivity.class);
        intent.putExtra("extra_certificate_ui_config", net.one97.paytm.paymentsBank.slfd.tds.a.a.a.INTEREST_CERTIFICATE);
        this.f18304a.startActivity(intent);
    }
}
