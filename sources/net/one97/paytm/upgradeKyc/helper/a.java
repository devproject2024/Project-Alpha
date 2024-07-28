package net.one97.paytm.upgradeKyc.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1317a f66022a = new C1317a((byte) 0);

    /* renamed from: net.one97.paytm.upgradeKyc.helper.a$a  reason: collision with other inner class name */
    public static final class C1317a {
        private C1317a() {
        }

        public /* synthetic */ C1317a(byte b2) {
            this();
        }

        public static b a() {
            b bVar = new b();
            e.a aVar = e.f66028b;
            b a2 = bVar.a(e.a.b().a()).a(a.c.KYC);
            k.a((Object) a2, "networkCallBuilder");
            return a2;
        }

        public static Map<String, String> a(Context context) {
            k.c(context, "context");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept", "application/json");
            hashMap.put("client_id", com.paytm.utility.b.k());
            hashMap.put("client_secret", com.paytm.utility.b.l());
            hashMap.put("session_token", d.a(context));
            hashMap.put("Authorization", com.paytm.utility.b.m());
            if (d.b(context) != null) {
                String b2 = d.b(context);
                k.a((Object) b2, "CJRNetUtility.getCartID(context)");
                hashMap.put("cart_id", b2);
            }
            return hashMap;
        }

        public static void a(Context context, com.paytm.network.a aVar) {
            k.c(context, "context");
            k.c(aVar, "networkCall");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.no_connection));
            builder.setMessage(context.getResources().getString(R.string.no_internet));
            builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new C1318a(context, aVar));
            builder.show();
        }

        /* renamed from: net.one97.paytm.upgradeKyc.helper.a$a$a  reason: collision with other inner class name */
        static final class C1318a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f66023a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.paytm.network.a f66024b;

            C1318a(Context context, com.paytm.network.a aVar) {
                this.f66023a = context;
                this.f66024b = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c(this.f66023a)) {
                    this.f66024b.a();
                    return;
                }
                C1317a aVar = a.f66022a;
                C1317a.a(this.f66023a, this.f66024b);
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
