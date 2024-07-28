package net.one97.paytm.paymentsBank.slfd.createfd.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.form15g.model.FGHResponseModel;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdBalanceResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.ViewLifoFdResponse;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.createfd.a.c;
import net.one97.paytm.paymentsBank.utils.j;

public final class c implements g.a, g.b<IJRPaytmDataModel>, c.a {

    /* renamed from: a  reason: collision with root package name */
    private SlfdMetaApiResponseModel f19056a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19057b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19058c;

    /* renamed from: d  reason: collision with root package name */
    private String f19059d;

    /* renamed from: e  reason: collision with root package name */
    private String f19060e;

    /* renamed from: f  reason: collision with root package name */
    private double f19061f;

    /* renamed from: g  reason: collision with root package name */
    private FGHStatusModel f19062g;

    /* renamed from: h  reason: collision with root package name */
    private final b f19063h;

    /* renamed from: i  reason: collision with root package name */
    private final c.b f19064i;

    public c(b bVar, c.b bVar2) {
        k.c(bVar, "slfdRepository");
        k.c(bVar2, "slfdLandingPageView");
        this.f19063h = bVar;
        this.f19064i = bVar2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        this.f19064i.a(false);
        if (iJRPaytmDataModel instanceof SlfdBalanceResponseModel) {
            SlfdBalanceResponseModel slfdBalanceResponseModel = (SlfdBalanceResponseModel) iJRPaytmDataModel;
            if (slfdBalanceResponseModel.getResponseCode() == 200) {
                this.f19059d = String.valueOf(slfdBalanceResponseModel.getNetInvestment());
                DecimalFormat decimalFormat = new DecimalFormat("#.####");
                decimalFormat.setRoundingMode(RoundingMode.CEILING);
                this.f19060e = decimalFormat.format(slfdBalanceResponseModel.getNetInvestment() - slfdBalanceResponseModel.getUnclearRedemptionAmount()).toString();
                this.f19064i.a(String.valueOf(slfdBalanceResponseModel.getNetInvestment() + slfdBalanceResponseModel.getUnclearBookingAmount()));
                this.f19064i.a(slfdBalanceResponseModel.getTotalInterestEarned());
                this.f19061f = slfdBalanceResponseModel.getNetInvestment() + slfdBalanceResponseModel.getUnclearBookingAmount();
                return;
            }
            c.b bVar = this.f19064i;
            String status = slfdBalanceResponseModel.getStatus();
            if (status == null) {
                status = "";
            }
            String message = slfdBalanceResponseModel.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.a(status, message);
        } else if (iJRPaytmDataModel instanceof SlfdMetaApiResponseModel) {
            this.f19056a = (SlfdMetaApiResponseModel) iJRPaytmDataModel;
            if (this.f19057b) {
                SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.f19056a;
                if (slfdMetaApiResponseModel != null) {
                    this.f19064i.a(slfdMetaApiResponseModel);
                    return;
                }
                this.f19057b = true;
                e();
            } else if (this.f19058c) {
                c();
            }
        } else if (iJRPaytmDataModel instanceof ViewLifoFdResponse) {
            ViewLifoFdResponse viewLifoFdResponse = (ViewLifoFdResponse) iJRPaytmDataModel;
            if (viewLifoFdResponse != null) {
                this.f19064i.a(viewLifoFdResponse);
            }
        } else if (iJRPaytmDataModel instanceof FGHStatusModel) {
            FGHStatusModel fGHStatusModel = (FGHStatusModel) iJRPaytmDataModel;
            this.f19062g = fGHStatusModel;
            if (TextUtils.isEmpty(fGHStatusModel.getStatus()) || !p.a(fGHStatusModel.getStatus(), "FAILURE", true)) {
                String a2 = j.a();
                b bVar2 = this.f19063h;
                c.b bVar3 = this.f19064i;
                if (bVar3 != null) {
                    k.a((Object) a2, "accType");
                    bVar2.a((Context) (Activity) bVar3, (g.b<IJRPaytmDataModel>) this, (g.a) this, a2);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
            com.paytm.utility.b.p();
            c.b bVar4 = this.f19064i;
            if (bVar4 != null) {
                String string = ((Activity) bVar4).getString(R.string.error);
                k.a((Object) string, "(slfdLandingPageView as …getString(R.string.error)");
                FGHResponseModel response = fGHStatusModel.getResponse();
                k.a((Object) response, "response.getResponse()");
                String errorMessage = response.getErrorMessage();
                k.a((Object) errorMessage, "response.getResponse().errorMessage");
                bVar4.a(string, errorMessage);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        } else if (iJRPaytmDataModel instanceof CustProductStatus) {
            c cVar = this;
            com.paytm.utility.b.p();
            String panRec = ((CustProductStatus) iJRPaytmDataModel).getPanRec();
            if (panRec == null) {
                k.a();
            }
            if (!p.a(panRec, "Y", true)) {
                cVar.f19064i.a(cVar.f19062g, false);
            } else {
                cVar.f19064i.a(cVar.f19062g, true);
            }
        }
    }

    public final void a() {
        a(true);
        e();
    }

    public final void b() {
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final void c() {
        SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.f19056a;
        if (slfdMetaApiResponseModel != null) {
            this.f19064i.a(this.f19060e, slfdMetaApiResponseModel);
            return;
        }
        this.f19058c = true;
        e();
    }

    public final void a(boolean z) {
        this.f19064i.a(z);
        this.f19063h.b(this, this);
    }

    public final void a(Context context) {
        k.c(context, "context");
        com.paytm.utility.b.k(context, context.getString(R.string.pb_please_wait));
        this.f19063h.g(this, this);
    }

    private final void e() {
        this.f19064i.a(true);
        this.f19063h.a(this, this);
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        String str2;
        this.f19064i.a(false);
        com.paytm.utility.b.p();
        c.b bVar = this.f19064i;
        if (networkCustomError == null || (str = networkCustomError.getAlertTitle()) == null) {
            str = "Error";
        }
        if (networkCustomError == null || (str2 = networkCustomError.getAlertMessage()) == null) {
            str2 = "Some error occurred while fetching details";
        }
        bVar.a(str, str2);
    }

    public final void d() {
        if (this.f19061f != 0.0d) {
            this.f19064i.b(true);
            this.f19063h.a(String.valueOf(this.f19061f), (g.b<IJRPaytmDataModel>) this, (g.a) this);
        }
    }
}
