package net.one97.paytm.upi.requestmoney.a;

import java.util.ArrayList;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.d;

public interface a {

    /* renamed from: net.one97.paytm.upi.requestmoney.a.a$a  reason: collision with other inner class name */
    public interface C1399a extends c {
        void a(int i2, int i3);

        void a(String str, String str2, boolean z);

        void a(ArrayList<UpiDBTransactionModel> arrayList);
    }

    public interface b extends d<C1399a> {
        void a();

        void a(String str);

        void a(ArrayList<BeneficiaryEntity> arrayList, int i2);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(boolean z);

        void b(boolean z);
    }
}
