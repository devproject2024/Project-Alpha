package net.one97.paytm.upi.profile.b;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UPIProfileMultipartResponse;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.common.upi.UserVpaInfo;
import net.one97.paytm.upi.util.UpiConstants;

public interface a {

    /* renamed from: net.one97.paytm.upi.profile.b.a$a  reason: collision with other inner class name */
    public interface C1382a {
        void onError(UpiCustomVolleyError upiCustomVolleyError);

        void onSuccess(UpiBaseDataModel upiBaseDataModel);
    }

    public interface b {
        void a();

        void a(List<UserVpaInfo> list);
    }

    public interface c {
        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(UpiCustomVolleyError upiCustomVolleyError);
    }

    public interface d {
        void a(NetworkCustomError networkCustomError);

        void a(UPIProfileMultipartResponse uPIProfileMultipartResponse);
    }

    void a(String str);

    void a(UserUpiDetails userUpiDetails, C1382a aVar, String str, String str2);

    void a(C1382a aVar, String str, String str2);

    void a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type, UserUpiDetails userUpiDetails, C1382a aVar, String str, String str2);
}
