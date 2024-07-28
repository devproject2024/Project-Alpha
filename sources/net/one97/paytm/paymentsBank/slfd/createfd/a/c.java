package net.one97.paytm.paymentsBank.slfd.createfd.a;

import android.content.Context;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.ViewLifoFdResponse;

public interface c {

    public interface a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(Context context);

        void a(boolean z);

        void c();

        void d();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<a> {
        void a(double d2);

        void a(String str);

        void a(String str, String str2);

        void a(String str, SlfdMetaApiResponseModel slfdMetaApiResponseModel);

        void a(FGHStatusModel fGHStatusModel, boolean z);

        void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel);

        void a(ViewLifoFdResponse viewLifoFdResponse);

        void b(boolean z);
    }
}
