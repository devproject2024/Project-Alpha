package net.one97.paytm.wallet.newdesign.nearby.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1440a f71113a = new C1440a((byte) 0);

    /* renamed from: net.one97.paytm.wallet.newdesign.nearby.helper.a$a  reason: collision with other inner class name */
    public static final class C1440a {
        private C1440a() {
        }

        public /* synthetic */ C1440a(byte b2) {
            this();
        }

        public static b a() {
            b bVar = new b();
            d.a aVar = d.f71130b;
            b a2 = bVar.a(d.a.b().b()).a(a.c.KYC);
            k.a((Object) a2, "networkCallBuilder");
            return a2;
        }

        public static void a(Context context, com.paytm.network.a aVar) {
            k.c(context, "context");
            k.c(aVar, "networkCall");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.no_connection));
            builder.setMessage(context.getResources().getString(R.string.no_internet));
            builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new C1441a(context, aVar));
            builder.show();
        }

        /* renamed from: net.one97.paytm.wallet.newdesign.nearby.helper.a$a$a  reason: collision with other inner class name */
        static final class C1441a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f71114a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.paytm.network.a f71115b;

            C1441a(Context context, com.paytm.network.a aVar) {
                this.f71114a = context;
                this.f71115b = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c(this.f71114a)) {
                    this.f71115b.a();
                    return;
                }
                C1440a aVar = a.f71113a;
                C1440a.a(this.f71114a, this.f71115b);
            }
        }

        public static void a(Context context, NetworkCustomError networkCustomError) {
            k.c(context, "mContext");
            k.c(networkCustomError, "error");
            String message = networkCustomError.getMessage();
            if (message != null && p.a(message, "417", true)) {
                com.paytm.utility.b.b(context, networkCustomError.getAlertMessage(), networkCustomError.getMessage());
            } else if (networkCustomError.getMessage() != null && p.a(networkCustomError.getMessage(), "parsing_error", false)) {
                com.paytm.utility.b.d(context, networkCustomError.getUrl(), "");
            } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                com.paytm.utility.b.b(context, context.getString(R.string.network_error_heading), context.getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            } else {
                com.paytm.utility.b.b(context, networkCustomError.getAlertMessage(), networkCustomError.getAlertMessage());
            }
        }
    }
}
