package net.one97.paytm.paymentsBank.slfd.redeemFd;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.paymentsBank.model.slfd.BankFfResponse;
import net.one97.paytm.paymentsBank.model.slfd.LifoRedeemFd;
import net.one97.paytm.paymentsBank.model.slfd.Payload;
import net.one97.paytm.paymentsBank.model.slfd.RedemptionResponseListItem;
import net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse;
import net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit;
import net.one97.paytm.paymentsBank.model.slfd.ViewLifoFdResponse;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.redeemFd.a;
import net.one97.paytm.paymentsBank.slfd.redeemFd.d;
import org.json.JSONArray;

public final class f implements g.a, g.b<IJRPaytmDataModel>, d.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<RedemptionResponseListItem> f19324a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private String f19325b = "IBPAN";

    /* renamed from: c  reason: collision with root package name */
    private String f19326c = "isa";

    /* renamed from: d  reason: collision with root package name */
    private final String f19327d = "20265";

    /* renamed from: e  reason: collision with root package name */
    private final String f19328e;

    /* renamed from: f  reason: collision with root package name */
    private d.b f19329f;

    /* renamed from: g  reason: collision with root package name */
    private final b f19330g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19331h;

    public f(d.b bVar, b bVar2, String str) {
        k.c(bVar2, "dataRepository");
        k.c(str, "amount");
        this.f19329f = bVar;
        this.f19330g = bVar2;
        this.f19331h = str;
        String ab = a.ab(this.f19331h);
        k.a((Object) ab, "CJRAppUtility.getCleanString(amount)");
        this.f19328e = ab;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        List<LifoRedeemFd> lifoFdList;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof ViewLifoFdResponse) {
            ViewLifoFdResponse viewLifoFdResponse = (ViewLifoFdResponse) iJRPaytmDataModel;
            if (viewLifoFdResponse.getResponseCode() == 200) {
                this.f19324a.clear();
                if (!(viewLifoFdResponse.getLifoFdList() == null || (lifoFdList = viewLifoFdResponse.getLifoFdList()) == null)) {
                    for (LifoRedeemFd lifoRedeemFd : lifoFdList) {
                        this.f19324a.add(new RedemptionResponseListItem(lifoRedeemFd.getFdId(), lifoRedeemFd.getRedemptionStatus(), "", "", lifoRedeemFd.getInterestRate(), lifoRedeemFd.getNetAmountPayout(), lifoRedeemFd.getRedemptionStatus(), lifoRedeemFd.getRedemptionAmount()));
                    }
                }
                if (this.f19324a.size() > 0) {
                    d.b bVar = this.f19329f;
                    if (bVar != null) {
                        bVar.a(this.f19324a);
                        return;
                    }
                    return;
                }
                d.b bVar2 = this.f19329f;
                if (bVar2 != null) {
                    bVar2.c();
                    return;
                }
                return;
            }
            d.b bVar3 = this.f19329f;
            if (bVar3 != null) {
                bVar3.a(viewLifoFdResponse.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof ValidateAmountLimit) {
            ValidateAmountLimit validateAmountLimit = (ValidateAmountLimit) iJRPaytmDataModel;
            if (validateAmountLimit.getResponseCode() != 200) {
                d.b bVar4 = this.f19329f;
                if (bVar4 != null) {
                    bVar4.a((a) a.d.f19296a);
                }
            } else if (validateAmountLimit.getLimitBreached()) {
                d.b bVar5 = this.f19329f;
                if (bVar5 != null) {
                    bVar5.a((a) new a.b(validateAmountLimit.getMessage()));
                }
            } else {
                d.b bVar6 = this.f19329f;
                if (bVar6 != null) {
                    bVar6.e();
                }
            }
        } else if (iJRPaytmDataModel instanceof BankFfResponse) {
            BankFfResponse bankFfResponse = (BankFfResponse) iJRPaytmDataModel;
            if (bankFfResponse.getResponseCode() == 200) {
                Payload payload = bankFfResponse.getPayload();
                if (payload == null) {
                    k.a();
                }
                if ("SUCCESS".equals(payload.getStatus())) {
                    Payload payload2 = bankFfResponse.getPayload();
                    d.b bVar7 = this.f19329f;
                    if (bVar7 != null) {
                        bVar7.a(payload2.getOrder_id(), Double.valueOf(Double.parseDouble(this.f19328e)));
                        return;
                    }
                    return;
                }
                d.b bVar8 = this.f19329f;
                if (bVar8 != null) {
                    bVar8.b(bankFfResponse.getResponseMessage());
                    return;
                }
                return;
            }
            d.b bVar9 = this.f19329f;
            if (bVar9 != null) {
                bVar9.b(bankFfResponse.getResponseMessage());
            }
        } else if (iJRPaytmDataModel instanceof SlfdCreateRedeemResponse) {
            SlfdCreateRedeemResponse slfdCreateRedeemResponse = (SlfdCreateRedeemResponse) iJRPaytmDataModel;
            if ("success".equals(slfdCreateRedeemResponse.getStatus())) {
                d.b bVar10 = this.f19329f;
                if (bVar10 != null) {
                    bVar10.a(slfdCreateRedeemResponse.getOrderId(), Double.valueOf(Double.parseDouble(this.f19328e)));
                    return;
                }
                return;
            }
            d.b bVar11 = this.f19329f;
            if (bVar11 != null) {
                bVar11.b(slfdCreateRedeemResponse.getMessage());
            }
        }
    }

    public final void c() {
        d.b bVar = this.f19329f;
        if (bVar != null) {
            bVar.d();
        }
        this.f19330g.a(this.f19325b, this.f19328e, this.f19327d, (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }

    public final void a(String str) {
        k.c(str, "txnToken");
        d.b bVar = this.f19329f;
        if (bVar != null) {
            bVar.f();
        }
        this.f19330g.a((JSONArray) null, this.f19328e, str, (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        d.b bVar = this.f19329f;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void b() {
        this.f19329f = null;
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final void a() {
        d.b bVar = this.f19329f;
        if (bVar != null) {
            bVar.a();
        }
        this.f19330g.a(this.f19328e, (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }
}
