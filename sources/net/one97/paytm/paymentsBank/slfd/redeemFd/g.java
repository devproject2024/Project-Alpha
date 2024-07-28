package net.one97.paytm.paymentsBank.slfd.redeemFd;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.model.slfd.SlfdBalanceResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit;
import net.one97.paytm.paymentsBank.slfd.a.a.a;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.redeemFd.a;
import net.one97.paytm.paymentsBank.slfd.redeemFd.c;
import org.json.JSONArray;

public final class g implements g.a, g.b<IJRPaytmDataModel>, c.a {

    /* renamed from: a  reason: collision with root package name */
    private String f19332a;

    /* renamed from: b  reason: collision with root package name */
    private String f19333b = "isa";

    /* renamed from: c  reason: collision with root package name */
    private String f19334c;

    /* renamed from: d  reason: collision with root package name */
    private String f19335d;

    /* renamed from: e  reason: collision with root package name */
    private final a f19336e;

    /* renamed from: f  reason: collision with root package name */
    private c.b f19337f;

    public final void a() {
    }

    public g(a aVar, c.b bVar) {
        k.c(aVar, "dataRepository");
        this.f19336e = aVar;
        this.f19337f = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof SlfdBalanceResponseModel) {
            c.b bVar = this.f19337f;
            if (bVar != null) {
                bVar.a(false);
            }
            SlfdBalanceResponseModel slfdBalanceResponseModel = (SlfdBalanceResponseModel) iJRPaytmDataModel;
            if (slfdBalanceResponseModel.getResponseCode() == 200) {
                this.f19334c = String.valueOf(slfdBalanceResponseModel.getNetInvestment());
                DecimalFormat decimalFormat = new DecimalFormat("#.####");
                decimalFormat.setRoundingMode(RoundingMode.CEILING);
                this.f19335d = decimalFormat.format(slfdBalanceResponseModel.getNetInvestment() - slfdBalanceResponseModel.getUnclearRedemptionAmount()).toString();
                c.b bVar2 = this.f19337f;
                if (bVar2 != null) {
                    bVar2.a(this.f19335d);
                    return;
                }
                return;
            }
            c.b bVar3 = this.f19337f;
            if (bVar3 != null) {
                String message = slfdBalanceResponseModel.getMessage();
                if (message == null) {
                    message = "";
                }
                bVar3.c(message);
            }
        } else if (iJRPaytmDataModel instanceof SlfdMetaApiResponseModel) {
            c.b bVar4 = this.f19337f;
            if (bVar4 != null) {
                bVar4.a(false);
            }
            c.b bVar5 = this.f19337f;
            if (bVar5 != null) {
                bVar5.a((SlfdMetaApiResponseModel) iJRPaytmDataModel);
            }
        } else if (iJRPaytmDataModel instanceof ValidateAmountLimit) {
            ValidateAmountLimit validateAmountLimit = (ValidateAmountLimit) iJRPaytmDataModel;
            if (validateAmountLimit.getLimitBreached()) {
                c.b bVar6 = this.f19337f;
                if (bVar6 != null) {
                    bVar6.a((a) new a.b(validateAmountLimit.getMessage()));
                    return;
                }
                return;
            }
            c.b bVar7 = this.f19337f;
            if (bVar7 != null) {
                bVar7.n();
            }
        } else if (iJRPaytmDataModel instanceof SlfdCreateRedeemResponse) {
            SlfdCreateRedeemResponse slfdCreateRedeemResponse = (SlfdCreateRedeemResponse) iJRPaytmDataModel;
            if (p.a("success", slfdCreateRedeemResponse.getStatus(), true)) {
                c.b bVar8 = this.f19337f;
                if (bVar8 != null) {
                    String orderId = slfdCreateRedeemResponse.getOrderId();
                    String str = this.f19332a;
                    bVar8.a(orderId, str != null ? Double.valueOf(Double.parseDouble(str)) : null);
                    return;
                }
                return;
            }
            c.b bVar9 = this.f19337f;
            if (bVar9 != null) {
                bVar9.c(slfdCreateRedeemResponse.getMessage());
            }
        }
    }

    public final void b(String str, double d2) {
        c.b bVar;
        k.c(str, "redeemAmount");
        a c2 = c(str, d2);
        if (c2 != null && (bVar = this.f19337f) != null) {
            bVar.b(c2);
        }
    }

    public final void a(String str, double d2) {
        k.c(str, "redeemAmount");
        a c2 = c(str, d2);
        if (c2 == null) {
            c.b bVar = this.f19337f;
            if (bVar != null) {
                bVar.b(str);
                return;
            }
            return;
        }
        c.b bVar2 = this.f19337f;
        if (bVar2 != null) {
            bVar2.a(c2);
        }
    }

    private static a c(String str, double d2) {
        if (TextUtils.isEmpty(net.one97.paytm.bankCommon.mapping.a.ab(str))) {
            return a.C0341a.f19293a;
        }
        String ab = net.one97.paytm.bankCommon.mapping.a.ab(str);
        k.a((Object) ab, "amount");
        double parseDouble = Double.parseDouble(ab);
        if (Double.compare(parseDouble, 0.0d) == 0) {
            return a.e.f19297a;
        }
        if (parseDouble > d2) {
            return a.c.f19295a;
        }
        return null;
    }

    public final void a(String str) {
        k.c(str, "redeemAmount");
        c.b bVar = this.f19337f;
        if (bVar != null) {
            bVar.m();
        }
        this.f19332a = net.one97.paytm.bankCommon.mapping.a.ab(str);
        net.one97.paytm.paymentsBank.slfd.a.a.a aVar = this.f19336e;
        String str2 = this.f19332a;
        if (str2 == null) {
            k.a();
        }
        aVar.a("IBPAN", str2, "20265", (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }

    public final void b(String str) {
        k.c(str, "txnToken");
        if (this.f19332a != null) {
            c.b bVar = this.f19337f;
            if (bVar != null) {
                bVar.o();
            }
            net.one97.paytm.paymentsBank.slfd.a.a.a aVar = this.f19336e;
            String str2 = this.f19332a;
            if (str2 == null) {
                k.a();
            }
            aVar.a((JSONArray) null, str2, str, (g.b<IJRPaytmDataModel>) this, (g.a) this);
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        c.b bVar = this.f19337f;
        if (bVar != null) {
            bVar.a(networkCustomError);
        }
    }

    public final void b() {
        this.f19337f = null;
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final void c() {
        c.b bVar = this.f19337f;
        if (bVar != null) {
            bVar.a(true);
        }
        g.b bVar2 = this;
        g.a aVar = this;
        this.f19336e.b(bVar2, aVar);
        this.f19336e.a(bVar2, aVar);
    }
}
