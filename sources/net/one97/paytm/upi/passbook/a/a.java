package net.one97.paytm.upi.passbook.a;

import android.widget.ImageView;
import java.util.ArrayList;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.d;
import net.one97.paytm.upi.passbook.view.c;

public interface a {

    /* renamed from: net.one97.paytm.upi.passbook.a.a$a  reason: collision with other inner class name */
    public interface C1377a extends c {
        int a();

        String a(int i2);

        void a(int i2, ImageView imageView);

        void a(int i2, c.a aVar);

        void a(int i2, boolean z);

        void a(String str);

        void b();

        void b(int i2);

        void c();

        void c(int i2);

        void d();

        void d(int i2);

        void e(int i2);

        void f(int i2);

        void g();

        void g(int i2);

        UpiPendingRequestModel h(int i2);

        void h();

        UpiPendingRequestModel i(int i2);

        void i();

        void j();

        void k();
    }

    public interface b extends d<C1377a> {
        void a();

        void a(int i2);

        void a(int i2, int i3);

        void a(int i2, int i3, ArrayList<UpiPendingRequestModel> arrayList);

        void a(int i2, String str);

        void a(int i2, String str, ImageView imageView);

        void a(int i2, String str, String str2);

        void a(int i2, String str, String str2, String str3);

        void a(int i2, UpiPendingRequestModel upiPendingRequestModel);

        void a(String str);

        void a(UpiPendingRequestModel upiPendingRequestModel);

        void a(UpiTransactionModelV2 upiTransactionModelV2);

        void a(boolean z);

        void a(boolean z, UpiPendingRequestModel upiPendingRequestModel);

        void a(boolean z, boolean z2);

        void a(boolean z, boolean z2, UpiPendingRequestModel upiPendingRequestModel);

        void b();

        void b(int i2);

        void b(String str);

        void b(boolean z);

        void c(int i2);

        void c(boolean z);

        boolean c();

        void d(boolean z);

        boolean d();

        void e();
    }
}
