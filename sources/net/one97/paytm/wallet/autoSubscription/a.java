package net.one97.paytm.wallet.autoSubscription;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.k;
import net.one97.paytm.common.entity.CJRPGTokenList;

public final class a {
    public static void a(final Context context, final String str, final h hVar) {
        k.a(context).a();
        new net.one97.paytm.addmoney.utils.a(context).a(new h() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRPGTokenList)) {
                    k.a(context).b();
                    return;
                }
                String a2 = net.one97.paytm.helper.a.b().a((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(a2)) {
                    new net.one97.paytm.addmoney.utils.a(context).a(new h() {
                        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                            k.a(context).b();
                            hVar.a(iJRPaytmDataModel);
                        }

                        public final void b(NetworkCustomError networkCustomError) {
                            k.a(context).b();
                            hVar.b(networkCustomError);
                        }
                    }, a2, "1", PaymentDestinationType.TO_WALLET.getNumVal(), str);
                }
            }

            public final void b(NetworkCustomError networkCustomError) {
                k.a(context).b();
            }
        });
    }
}
