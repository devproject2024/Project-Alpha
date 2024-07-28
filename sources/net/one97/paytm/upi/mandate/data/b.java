package net.one97.paytm.upi.mandate.data;

import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.mandate.data.model.AuthMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.CheckMandateStatusRequestModel;
import net.one97.paytm.upi.mandate.data.model.CreateMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.CreateRecurringMandateRequestModel;
import net.one97.paytm.upi.mandate.data.model.UpdateMandateRequestModel;
import net.one97.paytm.upi.mandate.update.UpdateMandateRequestBody;

public interface b {

    public interface a {
        void a(UpiBaseDataModel upiBaseDataModel);

        void a(UpiCustomVolleyError upiCustomVolleyError);
    }

    void a(int i2, a aVar);

    void a(String str, a aVar);

    void a(AuthMandateRequestModel authMandateRequestModel, a aVar);

    void a(CheckMandateStatusRequestModel checkMandateStatusRequestModel, a aVar);

    void a(CreateMandateRequestModel createMandateRequestModel, a aVar);

    void a(CreateRecurringMandateRequestModel createRecurringMandateRequestModel, a aVar);

    void a(UpdateMandateRequestModel updateMandateRequestModel, a aVar);

    void a(UpdateMandateRequestBody updateMandateRequestBody, a aVar);

    void b(int i2, a aVar);

    void c(int i2, a aVar);
}
