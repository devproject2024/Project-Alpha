package net.one97.paytm.moneytransfer.a;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public interface d {

    public interface a extends c {
        void a();

        void a(String str);

        void b();

        void c();
    }

    public interface b extends net.one97.paytm.upi.d<a> {
        void a();

        void a(Double d2, Double d3, Double d4);

        void a(String str);

        void a(ArrayList<UpiProfileDefaultBank> arrayList, ArrayList<UpiProfileDefaultBank> arrayList2);

        void a(List<UpiProfileDefaultBank> list);

        void a(PPBCurrentAccountModel pPBCurrentAccountModel);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(boolean z);

        void b(String str);

        boolean b();

        void c(String str);

        boolean c();

        void d(String str);

        boolean d();

        boolean e();

        boolean f();

        boolean g();

        boolean h();

        boolean i();

        void j();

        boolean k();

        void l();
    }
}
