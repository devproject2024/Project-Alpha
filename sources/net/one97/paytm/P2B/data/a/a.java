package net.one97.paytm.p2b.data.a;

import android.content.Context;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;

public interface a {

    /* renamed from: net.one97.paytm.p2b.data.a.a$a  reason: collision with other inner class name */
    public interface C0169a {
        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(NetworkCustomError networkCustomError);
    }

    void a(Context context, b bVar, String str);

    void a(String str);

    void a(String str, Context context, b bVar, String str2);

    void a(String str, String str2, String str3, String str4, boolean z, C0169a aVar, String str5);

    void a(String str, String str2, C0169a aVar, String str3);

    void a(BeneficiaryEntity beneficiaryEntity, boolean z, C0169a aVar, String str);

    void a(C0169a aVar, String str);

    void a(C0169a aVar, String str, String str2, double d2, String str3);

    void a(C0169a aVar, String str, String str2, String str3, boolean z, String str4);
}
