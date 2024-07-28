package net.one97.paytm.impsRefund.c;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.impsdatamodel.CJRAccountBodyResponse;
import net.one97.paytm.common.entity.impsdatamodel.CJRAddRefundAmount;
import net.one97.paytm.common.entity.impsdatamodel.CJRFetchRefundAccount;
import net.one97.paytm.impsRefund.a.a;
import net.one97.paytm.impsRefund.b.a;
import net.one97.paytm.impsRefund.b.b;

public final class a implements a.C0915a, a.C0917a {

    /* renamed from: a  reason: collision with root package name */
    private a.b f50598a;

    /* renamed from: b  reason: collision with root package name */
    private b f50599b;

    public a(a.b bVar, b bVar2) {
        this.f50598a = bVar;
        this.f50599b = bVar2;
    }

    public final void a() {
        b.a aVar = b.f50588a;
        b.f50593g = null;
    }

    public final void a(String str) {
        k.c(str, "assetId");
        a.b bVar = this.f50598a;
        if (bVar != null) {
            bVar.a(true);
        }
        b bVar2 = this.f50599b;
        if (bVar2 != null) {
            bVar2.a(this, str);
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        a.b bVar = this.f50598a;
        if (bVar != null) {
            bVar.a(true);
        }
        b bVar2 = this.f50599b;
        if (bVar2 != null) {
            bVar2.a(this, str, str2, str3, str4, (String) null);
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
        a.b bVar = this.f50598a;
        if (bVar != null) {
            bVar.a(false);
        }
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJRAddRefundAmount) {
            CJRAddRefundAmount cJRAddRefundAmount = (CJRAddRefundAmount) iJRPaytmDataModel;
            CJRAccountBodyResponse body = cJRAddRefundAmount.getBody();
            if (body == null || (resultInfo4 = body.getResultInfo()) == null || (str3 = resultInfo4.get("resultStatus")) == null) {
                str3 = "";
            }
            if (p.a("S", str3, true)) {
                a.b bVar2 = this.f50598a;
                if (bVar2 != null) {
                    bVar2.a(cJRAddRefundAmount);
                    return;
                }
                return;
            }
            CJRAccountBodyResponse body2 = cJRAddRefundAmount.getBody();
            if (body2 == null || (resultInfo3 = body2.getResultInfo()) == null || (str4 = resultInfo3.get("resultMsg")) == null) {
                str4 = "";
            }
            k.a((Object) str4, "dataModel.body?.resultInfo?.get(\"resultMsg\") ?: \"\"");
            a.b bVar3 = this.f50598a;
            if (bVar3 != null) {
                bVar3.a(str4);
            }
        } else if (iJRPaytmDataModel instanceof CJRFetchRefundAccount) {
            CJRFetchRefundAccount cJRFetchRefundAccount = (CJRFetchRefundAccount) iJRPaytmDataModel;
            CJRAccountBodyResponse body3 = cJRFetchRefundAccount.getBody();
            if (body3 == null || (resultInfo2 = body3.getResultInfo()) == null || (str = resultInfo2.get("resultStatus")) == null) {
                str = "";
            }
            if (p.a("S", str, true)) {
                a.b bVar4 = this.f50598a;
                if (bVar4 != null) {
                    bVar4.a();
                    return;
                }
                return;
            }
            a.b bVar5 = this.f50598a;
            if (bVar5 != null) {
                bVar5.a(false);
            }
            CJRAccountBodyResponse body4 = cJRFetchRefundAccount.getBody();
            if (body4 == null || (resultInfo = body4.getResultInfo()) == null || (str2 = resultInfo.get("resultMsg")) == null) {
                str2 = "";
            }
            k.a((Object) str2, "dataModel.body?.resultInfo?.get(\"resultMsg\") ?: \"\"");
            a.b bVar6 = this.f50598a;
            if (bVar6 != null) {
                bVar6.a(str2);
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        a.b bVar = this.f50598a;
        if (bVar != null) {
            bVar.a(false);
        }
        a.b bVar2 = this.f50598a;
        if (bVar2 != null) {
            bVar2.a(networkCustomError);
        }
    }
}
