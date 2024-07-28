package net.one97.paytm.paymentsBank.createfd.c;

import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;

public final class c {

    public interface a extends a {
        void a();

        void a(String str);

        void a(b.a.C0305a aVar);

        void a(boolean z);

        b.a.C0305a b(String str);

        void b();

        void b(boolean z);

        String c();

        b.a.C0305a c(String str);

        String d();

        void d(String str);

        String e(String str);

        SlfdMetaApiResponseModel e();

        void f();
    }

    public interface b extends b {

        public static final class a {
        }

        void a(double d2, Integer num);

        void a(Integer num, NetworkCustomError networkCustomError);

        void a(String str, String str2);

        void a(ArrayList<PBTncData> arrayList);

        void a(b.a.C0305a aVar, String str);

        void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel);

        void a(FDProjectionListModel fDProjectionListModel);

        void b();

        void b(String str);

        void b(b.a.C0305a aVar, String str);

        void b(boolean z);

        void c();

        void c(boolean z);

        void d();
    }
}
