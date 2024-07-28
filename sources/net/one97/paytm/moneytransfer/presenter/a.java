package net.one97.paytm.moneytransfer.presenter;

import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.moneytransfer.a.b;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.requestmoney.b.a.a;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    String f54044a;

    /* renamed from: b  reason: collision with root package name */
    b.a f54045b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.upi.requestmoney.b.a.b f54046c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.b.a.b f54047d;

    public a(b.a aVar, net.one97.paytm.upi.requestmoney.b.a.b bVar, net.one97.paytm.moneytransfer.b.a.b bVar2) {
        k.c(aVar, "mView");
        k.c(bVar, "mRequestMoneyRepository");
        k.c(bVar2, "mMoneyTransferRepository");
        this.f54045b = aVar;
        this.f54046c = bVar;
        this.f54047d = bVar2;
    }

    public static final /* synthetic */ String a(a aVar) {
        String str = aVar.f54044a;
        if (str == null) {
            k.a("mPayerName");
        }
        return str;
    }

    public static final class b implements a.C1402a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54049a;

        b(a aVar) {
            this.f54049a = aVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            this.f54049a.f54045b.a(false);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !p.a("0", baseUpiResponse.getResponse(), true)) {
                    b.a aVar = this.f54049a.f54045b;
                    String response = baseUpiResponse.getResponse();
                    k.a((Object) response, "response.response");
                    aVar.a(false, response);
                    return;
                }
                Object mobileAppData = baseUpiResponse.getMobileAppData();
                if (mobileAppData != null) {
                    String str = (String) mobileAppData;
                    if (str != null) {
                        String lowerCase = str.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (p.a((CharSequence) lowerCase, (CharSequence) "success", false)) {
                            a aVar2 = this.f54049a;
                            int a2 = p.a((CharSequence) str, "=", 0, false, 6) + 1;
                            if (str != null) {
                                String substring = str.substring(a2);
                                k.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
                                aVar2.f54044a = substring;
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        if (!TextUtils.isEmpty(a.a(this.f54049a))) {
                            this.f54049a.f54045b.b(a.a(this.f54049a));
                            this.f54049a.f54045b.a(true, "");
                            return;
                        }
                        this.f54049a.f54045b.a(false, "");
                        return;
                    }
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            if (this.f54049a.f54045b != null) {
                this.f54049a.f54045b.a(false);
                this.f54049a.f54045b.a(upiCustomVolleyError);
            }
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "vpa");
        k.c(str2, "name");
        this.f54045b.a(true);
        this.f54046c.a(new b(this), "", str, str2, "");
    }

    /* renamed from: net.one97.paytm.moneytransfer.presenter.a$a  reason: collision with other inner class name */
    public static final class C0969a implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54048a;

        C0969a(a aVar) {
            this.f54048a = aVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f54048a.f54045b.a(false);
            if (iJRPaytmDataModel instanceof CJRAddBeneficiary) {
                CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
                if (p.a(cJRAddBeneficiary.getStatusCode(), WebLogin.RESPONSE_CODE_SUCCESS, true)) {
                    b.a aVar = this.f54048a.f54045b;
                    CJRAddBeneficiary.BeneficiaryData data = cJRAddBeneficiary.getData();
                    k.a((Object) data, "response.data");
                    aVar.c(data.getBeneficiaryId());
                } else if (cJRAddBeneficiary.getError() != null) {
                    CJRAddBeneficiary.CJRAddBeneficiairyError error = cJRAddBeneficiary.getError();
                    k.a((Object) error, "response.error");
                    if (error.getErrorMsg() != null) {
                        b.a aVar2 = this.f54048a.f54045b;
                        CJRAddBeneficiary.CJRAddBeneficiairyError error2 = cJRAddBeneficiary.getError();
                        k.a((Object) error2, "response.error");
                        String errorMsg = error2.getErrorMsg();
                        k.a((Object) errorMsg, "response.error.errorMsg");
                        aVar2.a(errorMsg);
                        return;
                    }
                    this.f54048a.f54045b.a("");
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            this.f54048a.f54045b.a(false);
            this.f54048a.f54045b.a(upiCustomVolleyError);
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        this.f54045b.a(true);
        this.f54047d.a(new C0969a(this), str, str2, str3, str4);
    }
}
