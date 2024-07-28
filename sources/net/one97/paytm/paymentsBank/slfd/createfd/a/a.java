package net.one97.paytm.paymentsBank.slfd.createfd.a;

import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel;

public interface a {

    /* renamed from: net.one97.paytm.paymentsBank.slfd.createfd.a.a$a  reason: collision with other inner class name */
    public interface C0333a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(String str);

        void a(String str, String str2, boolean z);

        void a(SlfdNomineeModel slfdNomineeModel, int i2);

        void a(boolean z);

        void c();

        void d();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<C0333a> {
        void a();

        void a(String str);

        void a(String str, double d2);

        void a(String str, String str2);

        void a(ArrayList<PBTncData> arrayList);

        void b();

        void b(int i2);

        void b(boolean z);
    }
}
