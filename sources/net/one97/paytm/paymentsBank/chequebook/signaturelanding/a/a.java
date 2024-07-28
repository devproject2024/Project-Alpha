package net.one97.paytm.paymentsBank.chequebook.signaturelanding.a;

import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.utils.f;

public final class a {

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$a  reason: collision with other inner class name */
    public interface C0285a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(String str);

        void a(String str, String str2);

        void a(String str, boolean z, String str2);

        void a(boolean z);

        void b(String str);

        void b(String str, String str2);

        void b(boolean z);

        void c();

        void c(String str);

        void c(boolean z);

        void d();

        String e();

        Boolean f();

        f.a.C0293a g();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<C0285a> {
        void a(NetworkCustomError networkCustomError);

        void a(Boolean bool);

        void a(String str);

        void a(String str, String str2);

        void a(ArrayList<PBTncData> arrayList);

        void a(CBDocumentTypeResponse cBDocumentTypeResponse);

        void a(CBGetSignatureResponse cBGetSignatureResponse);

        void a(DocumentCreateResponse documentCreateResponse);

        void a(GetDocumentCreateResponse getDocumentCreateResponse);

        void b();

        void b(String str);

        void b(String str, String str2);

        void b(ArrayList<PBTncData> arrayList);

        void c();

        void c(String str);

        void d();

        void e();
    }
}
