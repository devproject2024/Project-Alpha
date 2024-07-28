package net.one97.paytm.moneytransfer.b.a;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.b.a;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public interface a {

    /* renamed from: net.one97.paytm.moneytransfer.b.a.a$a  reason: collision with other inner class name */
    public interface C0960a {
        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(UpiCustomVolleyError upiCustomVolleyError);
    }

    public interface b {
        void onSuccess(CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase);
    }

    public interface c {
    }

    void a(String str);

    void a(String str, String str2);

    void a(String str, String str2, String str3, String str4, String str5, String str6, CLRemoteResultReceiver cLRemoteResultReceiver, String str7, String str8, String str9, String str10, String str11, List<BankAccountDetails.BankAccountCredentials> list, String str12);

    void a(ArrayList<BeneficiaryEntity> arrayList);

    void a(net.one97.paytm.moneytransfer.a.a aVar);

    void a(C0960a aVar, String str);

    void a(C0960a aVar, String str, String str2);

    void a(C0960a aVar, String str, String str2, String str3, String str4);

    void a(C0960a aVar, String str, String str2, boolean z);

    void a(C0960a aVar, b bVar);

    void a(C0960a aVar, b bVar, int i2, int i3);

    void a(C0960a aVar, c cVar);

    void a(C0960a aVar, PaymentManager.PaymentUiModel paymentUiModel);

    void a(b bVar);

    void a(a.C1382a aVar, String str);

    void a(a.C1382a aVar, String str, String str2);

    void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UpiProfileDefaultBank upiProfileDefaultBank, String str12, boolean z, String str13, CommonPayParams commonPayParams, String str14, String str15);

    void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UpiProfileDefaultBank upiProfileDefaultBank, String str11, String str12, CommonPayParams commonPayParams, String str13, String str14);

    void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9, String str10);

    boolean a();

    void b(String str);

    void b(C0960a aVar, String str, String str2);

    void b(C0960a aVar, c cVar);

    boolean b();

    String c();

    void c(C0960a aVar, c cVar);
}
