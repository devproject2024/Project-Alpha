package net.one97.paytm.acceptPayment.viewModel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;

public final class ForceUpdateProvider implements p {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f52167a;

    /* renamed from: b  reason: collision with root package name */
    private final k f52168b;

    public ForceUpdateProvider(k kVar) {
        kotlin.g.b.k.d(kVar, "lifecycle");
        this.f52168b = kVar;
        kVar.a(this);
    }

    public static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f52169a = new a();

        a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
            kotlin.g.b.k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
            com.paytm.utility.b.ai(b2.a());
        }
    }

    public static final class b implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f52170a;

        public b(Activity activity) {
            this.f52170a = activity;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            kotlin.g.b.k.d(dialogInterface, "dialogInterface");
            if (i2 != 4) {
                return true;
            }
            this.f52170a.finish();
            return true;
        }
    }

    @aa(a = k.a.ON_DESTROY)
    public final void clear() {
        AlertDialog alertDialog = this.f52167a;
        if (alertDialog != null && alertDialog.isShowing()) {
            AlertDialog alertDialog2 = this.f52167a;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            AlertDialog alertDialog3 = this.f52167a;
            if (alertDialog3 != null) {
                alertDialog3.cancel();
            }
            this.f52167a = null;
        }
        this.f52168b.b(this);
    }
}
