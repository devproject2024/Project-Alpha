package net.one97.paytm.paymentsBank.slfd.timeline;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.model.slfd.AmountDetailsResponse;
import net.one97.paytm.paymentsBank.model.slfd.FdDetailsResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse;
import net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.timeline.a.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a implements g.a, g.b<IJRPaytmDataModel>, a.C0344a {

    /* renamed from: a  reason: collision with root package name */
    private String f19375a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f19376b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f19377c;

    /* renamed from: d  reason: collision with root package name */
    private a.b f19378d;

    /* renamed from: e  reason: collision with root package name */
    private final b f19379e;

    /* renamed from: f  reason: collision with root package name */
    private final String f19380f;

    public a(a.b bVar, b bVar2, String str) {
        k.c(bVar2, "dataRepository");
        k.c(str, "fdId");
        this.f19378d = bVar;
        this.f19379e = bVar2;
        this.f19380f = str;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof FdDetailsResponse) {
            FdDetailsResponse fdDetailsResponse = (FdDetailsResponse) iJRPaytmDataModel;
            if (fdDetailsResponse.getResponse_code() == 200) {
                a.b bVar = this.f19378d;
                if (bVar != null) {
                    bVar.a(iJRPaytmDataModel);
                    return;
                }
                return;
            }
            a.b bVar2 = this.f19378d;
            if (bVar2 != null) {
                String message = fdDetailsResponse.getMessage();
                if (message == null) {
                    k.a();
                }
                bVar2.a(message);
            }
        } else if (iJRPaytmDataModel instanceof AmountDetailsResponse) {
            this.f19377c = false;
            AmountDetailsResponse amountDetailsResponse = (AmountDetailsResponse) iJRPaytmDataModel;
            if (amountDetailsResponse.getResponse_code() == 200) {
                a.b bVar3 = this.f19378d;
                if (bVar3 != null) {
                    bVar3.b(iJRPaytmDataModel);
                }
                this.f19375a = String.valueOf(amountDetailsResponse.getNet_amount_payout());
                this.f19376b = String.valueOf(amountDetailsResponse.getTrial_closure_amount());
                return;
            }
            a.b bVar4 = this.f19378d;
            if (bVar4 != null) {
                bVar4.a(amountDetailsResponse.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof SlfdCreateRedeemResponse) {
            SlfdCreateRedeemResponse slfdCreateRedeemResponse = (SlfdCreateRedeemResponse) iJRPaytmDataModel;
            if (p.a("success", slfdCreateRedeemResponse.getStatus(), true)) {
                a.b bVar5 = this.f19378d;
                if (bVar5 != null) {
                    bVar5.a(slfdCreateRedeemResponse.getOrderId(), Double.valueOf(Double.parseDouble(this.f19375a)));
                    return;
                }
                return;
            }
            a.b bVar6 = this.f19378d;
            if (bVar6 != null) {
                bVar6.b(slfdCreateRedeemResponse.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof ValidateAmountLimit) {
            ValidateAmountLimit validateAmountLimit = (ValidateAmountLimit) iJRPaytmDataModel;
            if (validateAmountLimit.getLimitBreached()) {
                a.b bVar7 = this.f19378d;
                if (bVar7 != null) {
                    bVar7.c(validateAmountLimit.getMessage());
                    return;
                }
                return;
            }
            a.b bVar8 = this.f19378d;
            if (bVar8 != null) {
                bVar8.ak_();
            }
        }
    }

    public final void c() {
        a.b bVar = this.f19378d;
        if (bVar != null) {
            bVar.b();
        }
        this.f19379e.a("IBPAN", this.f19376b, "20265", (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f19377c = false;
        a.b bVar = this.f19378d;
        if (bVar != null) {
            bVar.a(networkCustomError);
        }
    }

    public final void a(Double d2) {
        if (!this.f19377c) {
            this.f19377c = true;
            this.f19379e.a(this.f19380f, d2, (g.b<IJRPaytmDataModel>) this, (g.a) this);
        }
    }

    public final void a(String str) {
        k.c(str, "txnToken");
        a.b bVar = this.f19378d;
        if (bVar != null) {
            bVar.b();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("fd_id", this.f19380f);
        jSONObject.put("amount", this.f19376b);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        this.f19379e.a(jSONArray, this.f19376b, str, (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }

    public final void b() {
        this.f19378d = null;
    }

    public final void a() {
        a.b bVar = this.f19378d;
        if (bVar != null) {
            bVar.a();
        }
        this.f19379e.b(this.f19380f, this, this);
    }
}
