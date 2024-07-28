package net.one97.paytm.paymentsBank.chequebook.signaturelanding.a;

import android.content.Context;
import android.net.Uri;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;

public final class b {

    public interface a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(Context context, C0286b bVar, String str);

        void a(String str);

        void a(String str, Uri uri, String str2);

        void a(String str, String str2);

        void b(String str);

        String c();

        void c(String str);

        void d();
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$b  reason: collision with other inner class name */
    public interface C0286b extends net.one97.paytm.paymentsBank.slfd.b<a> {
        void a(String str, String str2);

        void a(CBGetSignatureResponse cBGetSignatureResponse);

        void b();

        void b(String str, String str2);

        void b(boolean z);

        void c();

        void c(String str, String str2);

        void d();

        void d(String str, String str2);

        void e();
    }
}
