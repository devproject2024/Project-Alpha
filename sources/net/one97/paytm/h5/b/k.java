package net.one97.paytm.h5.b;

import android.content.Context;
import net.one97.paytm.h5.b.c;
import net.one97.paytm.h5.model.H5AppDetailsForUserModel;
import net.one97.paytm.h5paytmsdk.a.c;
import net.one97.paytm.h5paytmsdk.c.l;

public final class k implements l {
    public final void a(String str, Context context, final c cVar) {
        if (net.one97.paytm.verifier.a.c.a()) {
            cVar.a(Boolean.TRUE);
        } else {
            c.a(context, str, (c.a) new c.a() {
                public final void onAppDataFetched(H5AppDetailsForUserModel h5AppDetailsForUserModel) {
                    cVar.a(Boolean.TRUE);
                }

                public final void onError(String str) {
                    cVar.a(Boolean.FALSE);
                }
            });
        }
    }
}
