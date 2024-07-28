package net.one97.paytm.wallet.i;

import android.content.Context;
import com.paytm.utility.d;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.communicator.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f70414a = new b();

    private b() {
    }

    public static void a(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "firstSixDigit");
        k.c(str2, "lastFourDigit");
        k.c(str3, "expiryDate");
        net.one97.paytm.wallet.communicator.b.c().createOneClickInfoObject(context, str, str2, str3, com.paytm.utility.b.n(context));
    }

    public static void a(Context context, String str, String str2, String str3, a.b bVar) {
        a.b bVar2 = bVar;
        k.c(context, "context");
        k.c(str, "firstSixDigit");
        k.c(str2, "lastFourDigit");
        String str4 = str3;
        k.c(str4, "expiryDate");
        k.c(bVar2, "listener");
        net.one97.paytm.wallet.communicator.b.c().isEnrolled(context, str, str2, str4, com.paytm.utility.b.n(context), d.a(context), SDKConstants.SSO, (String) null, (String) null, new a(bVar2));
    }

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.b f70415a;

        a(a.b bVar) {
            this.f70415a = bVar;
        }

        public final void a(boolean z, boolean z2, String str) {
            this.f70415a.a(z, z2, str);
        }

        public final void a(String str, String str2) {
            this.f70415a.a(str, str2);
        }
    }

    public static void a(Context context) {
        k.c(context, "context");
        if (net.one97.paytm.wallet.communicator.b.a().isVscpEnabled(context)) {
            net.one97.paytm.wallet.communicator.b.c().checkAllEnrolledCards(context, d.a(context), SDKConstants.SSO, com.paytm.utility.b.n(context), (String) null, (String) null);
        }
    }
}
