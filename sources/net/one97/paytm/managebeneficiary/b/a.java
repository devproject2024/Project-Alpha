package net.one97.paytm.managebeneficiary.b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.paytm.utility.b;
import kotlin.g.b.k;
import net.one97.paytm.managebeneficiary.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0954a f53271a = new C0954a((byte) 0);

    public static final void a(com.paytm.network.a aVar, Context context) {
        C0954a.a(aVar, context);
    }

    /* renamed from: net.one97.paytm.managebeneficiary.b.a$a  reason: collision with other inner class name */
    public static final class C0954a {
        private C0954a() {
        }

        public /* synthetic */ C0954a(byte b2) {
            this();
        }

        public static void a(com.paytm.network.a aVar, Context context) {
            k.c(context, "context");
            b(aVar, context);
        }

        private static void b(com.paytm.network.a aVar, Context context) {
            k.c(context, "context");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.pb_mb_no_connection));
            builder.setMessage(context.getResources().getString(R.string.pb_mb_no_internet));
            builder.setPositiveButton(context.getResources().getString(R.string.pb_mb_network_retry_yes), new C0955a(context, aVar));
            builder.show();
        }

        /* renamed from: net.one97.paytm.managebeneficiary.b.a$a$a  reason: collision with other inner class name */
        static final class C0955a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f53272a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.paytm.network.a f53273b;

            C0955a(Context context, com.paytm.network.a aVar) {
                this.f53272a = context;
                this.f53273b = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (b.c(this.f53272a)) {
                    com.paytm.network.a aVar = this.f53273b;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                C0954a aVar2 = a.f53271a;
                C0954a.a(this.f53273b, this.f53272a);
            }
        }
    }
}
