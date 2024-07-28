package net.one97.paytm.upi.requestmoney;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.k;
import androidx.lifecycle.q;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.PendingCollectMandateRequests;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.requestmoney.view.UpiRequestMoneyPagerActivity;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f69103c;

    /* renamed from: a  reason: collision with root package name */
    String f69104a = "UpiRequestMoneyPendingHelper";

    /* renamed from: b  reason: collision with root package name */
    ArrayList<UpiPendingRequestModel> f69105b;

    private a() {
    }

    public static a a() {
        a aVar = f69103c;
        return aVar == null ? new a() : aVar;
    }

    public final void a(final Context context, String str, final q qVar) {
        g.b().a((a.C1379a) new a.C1379a() {
            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void a(UpiBaseDataModel upiBaseDataModel) {
                q qVar;
                if (upiBaseDataModel instanceof PendingCollectMandateRequests) {
                    PendingCollectMandateRequests pendingCollectMandateRequests = (PendingCollectMandateRequests) upiBaseDataModel;
                    a.this.f69105b = new ArrayList<>();
                    if (pendingCollectMandateRequests.getmPendingRequests() != null) {
                        ArrayList<UpiPendingRequestModel> arrayList = pendingCollectMandateRequests.getmPendingRequests();
                        int i2 = 0;
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (arrayList.get(i3).getDirection().equalsIgnoreCase("RECEIVED") && a.a(arrayList.get(i3))) {
                                a.this.f69105b.add(arrayList.get(i3));
                                i2++;
                            }
                            if (i2 == 5) {
                                break;
                            }
                        }
                        if (a.this.f69105b.size() > 0 && (qVar = qVar) != null && qVar.getLifecycle().a().isAtLeast(k.b.STARTED)) {
                            Intent intent = new Intent(context, UpiRequestMoneyPagerActivity.class);
                            intent.putExtra("pendingRequestModelArrayList", a.this.f69105b);
                            context.startActivity(intent);
                        }
                    }
                }
            }
        }, str, this.f69104a, context.getClass().getSimpleName());
    }

    static /* synthetic */ boolean a(UpiPendingRequestModel upiPendingRequestModel) {
        if (!UpiGTMLoader.getInstance().isCollectPopUpAllowed()) {
            return (upiPendingRequestModel.getMandateDetails() == null || upiPendingRequestModel.getMandateDetails().getUmn() == null) ? false : true;
        }
        return true;
    }
}
