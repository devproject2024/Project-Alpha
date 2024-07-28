package net.one97.paytm.paymentsBank.download.a.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import net.one97.paytm.payments.c.c.b;
import net.one97.paytm.paymentsBank.download.a.a;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;
import net.one97.paytm.paymentsBank.slfd.tds.view.TDSCertificateActivity;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private DownloadActivity f18305a;

    public d(Object obj) {
        if (obj instanceof DownloadActivity) {
            this.f18305a = (DownloadActivity) obj;
        }
    }

    public final void onClick(View view) {
        b bVar = b.f17264a;
        if (b.a()) {
            Bundle bundle = new Bundle();
            bundle.putString("goToScreen", "fd_tds_certificate");
            b bVar2 = b.f17264a;
            b.a(this.f18305a, bundle, ViewHolderFactory.CLASS_HOME);
            return;
        }
        Intent intent = new Intent(this.f18305a, TDSCertificateActivity.class);
        intent.putExtra("extra_certificate_ui_config", net.one97.paytm.paymentsBank.slfd.tds.a.a.a.TDS_CERTIFICATE);
        this.f18305a.startActivity(intent);
    }
}
