package net.one97.paytm.impsRefund.c;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.impsdatamodel.CJRAccountBodyResponse;
import net.one97.paytm.common.entity.impsdatamodel.CJRFetchRefundAccount;
import net.one97.paytm.impsRefund.a.b;
import net.one97.paytm.impsRefund.b.a;
import net.one97.paytm.impsRefund.b.b;

public final class c implements b.a, a.C0917a {

    /* renamed from: a  reason: collision with root package name */
    private b.C0916b f50602a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.impsRefund.b.b f50603b;

    public c(b.C0916b bVar, net.one97.paytm.impsRefund.b.b bVar2) {
        this.f50602a = bVar;
        this.f50603b = bVar2;
    }

    public final void a() {
        c();
    }

    public final void b() {
        b.a aVar = net.one97.paytm.impsRefund.b.b.f50588a;
        net.one97.paytm.impsRefund.b.b.f50593g = null;
    }

    public final void c() {
        b.C0916b bVar = this.f50602a;
        if (bVar != null) {
            bVar.a(true);
        }
        net.one97.paytm.impsRefund.b.b bVar2 = this.f50603b;
        if (bVar2 != null) {
            bVar2.a((a.C0917a) this);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        String str3;
        HashMap<String, String> resultInfo;
        HashMap<String, String> resultInfo2;
        HashMap<String, String> resultInfo3;
        b.C0916b bVar = this.f50602a;
        if (bVar != null) {
            bVar.a(false);
        }
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRFetchRefundAccount)) {
            CJRFetchRefundAccount cJRFetchRefundAccount = (CJRFetchRefundAccount) iJRPaytmDataModel;
            CJRAccountBodyResponse body = cJRFetchRefundAccount.getBody();
            if (body == null || (resultInfo3 = body.getResultInfo()) == null || (str = resultInfo3.get("resultStatus")) == null) {
                str = "";
            }
            if (!p.a("S", str, true)) {
                CJRAccountBodyResponse body2 = cJRFetchRefundAccount.getBody();
                if (body2 == null || (resultInfo2 = body2.getResultInfo()) == null || (str2 = resultInfo2.get("resultStatus")) == null) {
                    str2 = "";
                }
                if (!p.a(AppConstants.FEED_SUB_TYPE, str2, true)) {
                    CJRAccountBodyResponse body3 = cJRFetchRefundAccount.getBody();
                    if (body3 == null || (resultInfo = body3.getResultInfo()) == null || (str3 = resultInfo.get("resultMsg")) == null) {
                        str3 = "";
                    }
                    k.a((Object) str3, "dataModel.body?.resultInfo?.get(\"resultMsg\") ?: \"\"");
                    b.C0916b bVar2 = this.f50602a;
                    if (bVar2 != null) {
                        bVar2.a(str3);
                        return;
                    }
                    return;
                }
            }
            b.C0916b bVar3 = this.f50602a;
            if (bVar3 != null) {
                bVar3.a(cJRFetchRefundAccount);
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        b.C0916b bVar = this.f50602a;
        if (bVar != null) {
            bVar.a(false);
        }
        b.C0916b bVar2 = this.f50602a;
        if (bVar2 != null) {
            bVar2.a(networkCustomError);
        }
    }
}
