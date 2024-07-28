package net.one97.paytm.upi.requestmoney.a;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.MoneyTransferRecentListAdapter;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.d;

public interface e {

    public interface a extends c {
        void a();

        void a(int i2);

        void a(int i2, MoneyTransferRecentListAdapter.BeneficiaryViewHolder beneficiaryViewHolder);

        void a(String str, String str2, boolean z);

        void a(UpiProfileDefaultBank upiProfileDefaultBank, String str, String str2, String str3, String str4, String str5);

        int b();
    }

    public interface b extends d<a> {
        void a();

        void a(String str);

        void a(String str, String str2);

        void a(ArrayList<UpiBaseDataModel> arrayList);

        void a(List<UpiProfileDefaultBank> list);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(boolean z);

        void a(boolean z, String str);

        void a(boolean z, String str, String str2, String str3, String str4, String str5);

        void b();

        void b(List<UpiProfileDefaultBank> list);

        void b(boolean z);
    }
}
