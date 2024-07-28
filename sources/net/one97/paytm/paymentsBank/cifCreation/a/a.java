package net.one97.paytm.paymentsBank.cifCreation.a;

import java.util.ArrayList;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFCreationResponse;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFStatusResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;

public interface a {

    /* renamed from: net.one97.paytm.paymentsBank.cifCreation.a.a$a  reason: collision with other inner class name */
    public interface C0295a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(String str);

        void a(boolean z);

        void b(boolean z);

        void c();

        void d();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<C0295a> {
        void a(double d2);

        void a(String str, String str2);

        void a(ArrayList<PBTncData> arrayList);

        void a(CIFCreationResponse cIFCreationResponse);

        void a(CIFStatusResponse cIFStatusResponse);

        void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel);

        void b(boolean z);
    }
}
