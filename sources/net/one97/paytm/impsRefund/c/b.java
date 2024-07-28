package net.one97.paytm.impsRefund.c;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.impsdatamodel.CJRAccountBodyResponse;
import net.one97.paytm.common.entity.impsdatamodel.CJRAddRefundAmount;
import net.one97.paytm.common.entity.impsdatamodel.CJRFetchRefundAccount;
import net.one97.paytm.impsRefund.a.c;
import net.one97.paytm.impsRefund.b.a;

public final class b implements c.a, a.C0917a {

    /* renamed from: a  reason: collision with root package name */
    private c.b f50600a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.impsRefund.b.b f50601b;

    public b(c.b bVar, net.one97.paytm.impsRefund.b.b bVar2) {
        this.f50600a = bVar;
        this.f50601b = bVar2;
    }

    public final void a(String str) {
        k.c(str, "assetId");
        c.b bVar = this.f50600a;
        if (bVar != null) {
            bVar.a(true);
        }
        net.one97.paytm.impsRefund.b.b bVar2 = this.f50601b;
        if (bVar2 != null) {
            bVar2.a(this, str);
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        c.b bVar = this.f50600a;
        if (bVar != null) {
            bVar.a(true);
        }
        net.one97.paytm.impsRefund.b.b bVar2 = this.f50601b;
        if (bVar2 != null) {
            bVar2.a(this, str, str2, (String) null, str3, str4);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        HashMap<String, String> resultInfo;
        HashMap<String, String> resultInfo2;
        String str3;
        String str4;
        HashMap<String, String> resultInfo3;
        HashMap<String, String> resultInfo4;
        c.b bVar = this.f50600a;
        if (bVar != null) {
            bVar.a(false);
        }
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRFetchRefundAccount)) {
            CJRFetchRefundAccount cJRFetchRefundAccount = (CJRFetchRefundAccount) iJRPaytmDataModel;
            CJRAccountBodyResponse body = cJRFetchRefundAccount.getBody();
            if (body == null || (resultInfo4 = body.getResultInfo()) == null || (str3 = resultInfo4.get("resultStatus")) == null) {
                str3 = "";
            }
            if (p.a("S", str3, true)) {
                c.b bVar2 = this.f50600a;
                if (bVar2 != null) {
                    bVar2.a();
                    return;
                }
                return;
            }
            CJRAccountBodyResponse body2 = cJRFetchRefundAccount.getBody();
            if (body2 == null || (resultInfo3 = body2.getResultInfo()) == null || (str4 = resultInfo3.get("resultMsg")) == null) {
                str4 = "";
            }
            k.a((Object) str4, "dataModel.body?.resultInfo?.get(\"resultMsg\") ?: \"\"");
            c.b bVar3 = this.f50600a;
            if (bVar3 != null) {
                bVar3.a(str4);
            }
        } else if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRAddRefundAmount)) {
            CJRAddRefundAmount cJRAddRefundAmount = (CJRAddRefundAmount) iJRPaytmDataModel;
            CJRAccountBodyResponse body3 = cJRAddRefundAmount.getBody();
            if (body3 == null || (resultInfo2 = body3.getResultInfo()) == null || (str = resultInfo2.get("resultStatus")) == null) {
                str = "";
            }
            if (p.a("S", str, true)) {
                c.b bVar4 = this.f50600a;
                if (bVar4 != null) {
                    bVar4.a(cJRAddRefundAmount);
                    return;
                }
                return;
            }
            CJRAccountBodyResponse body4 = cJRAddRefundAmount.getBody();
            if (body4 == null || (resultInfo = body4.getResultInfo()) == null || (str2 = resultInfo.get("resultMsg")) == null) {
                str2 = "";
            }
            k.a((Object) str2, "dataModel.body?.resultInfo?.get(\"resultMsg\") ?: \"\"");
            c.b bVar5 = this.f50600a;
            if (bVar5 != null) {
                bVar5.a(str2);
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        c.b bVar = this.f50600a;
        if (bVar != null) {
            bVar.a(false);
        }
        c.b bVar2 = this.f50600a;
        if (bVar2 != null) {
            bVar2.a(networkCustomError);
        }
    }
}
