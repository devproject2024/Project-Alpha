package net.one97.paytm.paymentsBank.createfd.prefrence.b;

import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse;

public final class b {

    public interface a {
        Long a();

        void a(String str);

        void a(String str, String str2);

        void a(FDStatusResponse fDStatusResponse);

        void a(boolean z);

        Long b();

        void b(String str, String str2);

        void b(boolean z);

        Double c();

        Integer d();

        void e();

        String f();
    }

    /* renamed from: net.one97.paytm.paymentsBank.createfd.prefrence.b.b$b  reason: collision with other inner class name */
    public interface C0303b {
        void a(Integer num, NetworkCustomError networkCustomError);

        void a(String str, String str2);

        void a(ArrayList<PBTncData> arrayList);

        void a(boolean z);

        void b(String str);

        void b(boolean z);

        void c();

        boolean d();
    }
}
