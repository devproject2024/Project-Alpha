package net.one97.paytm.paymentsBank.download.a.a;

import android.os.Bundle;
import android.view.View;
import net.one97.paytm.paymentsBank.download.a.a;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private DownloadActivity f18303a;

    public b(Object obj) {
        if (obj instanceof DownloadActivity) {
            this.f18303a = (DownloadActivity) obj;
        }
    }

    public final void onClick(View view) {
        net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
        if (net.one97.paytm.payments.c.c.b.e()) {
            Bundle bundle = new Bundle();
            bundle.putString("goToScreen", "savingsAccountStatement");
            net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
            net.one97.paytm.payments.c.c.b.c(this.f18303a, bundle);
        } else if (j.b()) {
            o.a().openStatements(this.f18303a);
        } else {
            o.a().openICAAccountStatementPage(this.f18303a);
        }
    }
}
